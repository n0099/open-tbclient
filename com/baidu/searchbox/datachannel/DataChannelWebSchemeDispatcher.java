package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes3.dex */
public class DataChannelWebSchemeDispatcher extends UnitedSchemeBaseDispatcher {
    public static HashMap<String, Class<? extends UnitedSchemeAbsDispatcher>> sSubDispatchers = new HashMap<>();
    public String mHost;
    public OnWebViewCallBackListener onWebViewCallBackListener;

    /* loaded from: classes3.dex */
    public interface OnWebViewCallBackListener {
        void evaluateJavascript(String str);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    public DataChannelWebSchemeDispatcher(OnWebViewCallBackListener onWebViewCallBackListener, String str) {
        this.onWebViewCallBackListener = onWebViewCallBackListener;
        this.mHost = TextUtils.isEmpty(str) ? Contract.DEFAULT_HOST : str;
    }

    public boolean sendBroadcast(String str, String str2) {
        return Sender.sendBroadcast(AppRuntime.getAppContext(), str, str2);
    }

    public boolean unregisterReceiver(String str, String str2) {
        return BaseRegistry.unregisterReceiver(this.mHost, str, str2);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return sSubDispatchers.get(str);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        boolean z;
        boolean registerReceiver;
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (Contract.DEBUG) {
                Log.w(Contract.TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Web dispatcher invoke : " + path);
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(unitedSchemeEntity.getSource(), unitedSchemeEntity.getUri());
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        char c = 65535;
        int hashCode = path.hashCode();
        if (hashCode != -690213213) {
            if (hashCode != 836015164) {
                if (hashCode == 879301177 && path.equals(Contract.SCHEME_ACTION_SEND_BROADCAST)) {
                    c = 2;
                }
            } else if (path.equals("unregister")) {
                c = 1;
            }
        } else if (path.equals("register")) {
            c = 0;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (!unitedSchemeEntity.isOnlyVerify()) {
                        UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
                    }
                    if (Contract.DEBUG) {
                        Log.w(Contract.TAG, "Uri action is unknown");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    return false;
                }
                registerReceiver = sendBroadcast(params.get("action"), params.get("data"));
            } else {
                registerReceiver = unregisterReceiver(params.get("page"), params.get("action"));
            }
        } else {
            String str = params.get("page");
            String str2 = params.get(Contract.SCHEME_KEY_JSCALLBACK);
            String str3 = params.get("action");
            String str4 = params.get(Contract.SCHEME_KEY_ALLOWDUPLICATE);
            if (!TextUtils.isEmpty(str4) && TextUtils.equals(Boolean.FALSE.toString(), str4.toLowerCase(Locale.getDefault()))) {
                z = false;
            } else {
                z = true;
            }
            registerReceiver = registerReceiver(str, str3, str2, z);
        }
        if (registerReceiver) {
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        }
        return true;
    }

    public boolean registerReceiver(String str, String str2, String str3, boolean z) {
        return Registry.registerWebReceiver(this.mHost, str, str2, this.onWebViewCallBackListener, str3, z);
    }
}
