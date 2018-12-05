package com.baidu.searchbox.ng.ai.apps.pay;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.AiAppsPageParam;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsWxPayLaunchMsg {
    private static final boolean DEBUG = false;
    public static final int NOT_INSTALLED_WECHAT_CODE = 1002;
    public static final String NOT_INSTALLED_WECHAT_MSG = "had not installed WeChat";
    public static final String PARAMS_KEY = "params";
    private static final String TAG = AiAppsWxPayLaunchMsg.class.getSimpleName();
    public static volatile AiAppsWxPayLaunchMsg sInstance;
    public static String wx_appType;
    public static String wx_appid;

    private AiAppsWxPayLaunchMsg() {
    }

    public static AiAppsWxPayLaunchMsg getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsWxPayLaunchMsg.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsWxPayLaunchMsg();
                }
            }
        }
        return sInstance;
    }

    public boolean openWebView(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        String parseUrlParams = parseUrlParams(unitedSchemeEntity, "params");
        if (TextUtils.isEmpty(parseUrlParams)) {
            AiAppsLog.i(TAG, "wxPay: url is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else if (!AiAppsRuntime.getPaymentRuntime().isWxAppInstalledAndSupported(context)) {
            UniversalToast.makeText(context, context.getText(R.string.aiapps_wx_not_install_toast_msg)).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1002, NOT_INSTALLED_WECHAT_MSG);
            return false;
        } else {
            openWxPay(AiAppsPageParam.createObject(parseUrlParams, parseUrlParams), aiAppsFragmentManager);
            AiAppsLog.i(TAG, "open wxPay page success");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("finalUrl", parseUrlParams);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
    }

    public boolean closeWebView() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            AiAppsLog.e(TAG, "fragmentManager is null");
            return false;
        }
        aiAppsFragmentManager.createTransaction().setCustomAnimations(AiAppsFragmentManager.ANIM_HOLD, AiAppsFragmentManager.ANIM_EXIT).popFragment().commit();
        return true;
    }

    private void openWxPay(AiAppsPageParam aiAppsPageParam, AiAppsFragmentManager aiAppsFragmentManager) {
        AiAppsLog.i(TAG, "openWxPay: page url=" + aiAppsPageParam.mBaseUrl);
        aiAppsFragmentManager.createTransaction().setCustomAnimations(AiAppsFragmentManager.ANIM_ENTER, AiAppsFragmentManager.ANIM_HOLD).pushFragment(AiAppsFragmentManager.WXPAY, aiAppsPageParam).commitNow();
    }

    private static String parseUrlParams(UnitedSchemeEntity unitedSchemeEntity, String str) {
        String str2 = unitedSchemeEntity.getParams().get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new JSONObject(str2).optString(ImageCoverViewModel.KEY_SRC);
        } catch (JSONException e) {
            return null;
        }
    }
}
