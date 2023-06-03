package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.datachannel.DataChannelWebSchemeDispatcher;
import java.util.List;
@Deprecated
/* loaded from: classes3.dex */
public class Registry extends BaseRegistry {
    @Nullable
    public static boolean isReceiverExist(WebReceiver webReceiver) {
        synchronized (ReceiverManager.getInstance()) {
            List<BaseBroadcastReceiver> receivers = ReceiverManager.getInstance().getReceivers();
            if (receivers != null && receivers.size() > 0) {
                if (webReceiver == null) {
                    return true;
                }
                for (BaseBroadcastReceiver baseBroadcastReceiver : receivers) {
                    if (baseBroadcastReceiver instanceof WebReceiver) {
                        WebReceiver webReceiver2 = (WebReceiver) baseBroadcastReceiver;
                        if (TextUtils.equals(webReceiver2.mAction, webReceiver.mAction) && TextUtils.equals(webReceiver2.mHost, webReceiver.mHost) && TextUtils.equals(webReceiver2.mPage, webReceiver.mPage) && TextUtils.equals(webReceiver2.getJsCallback(), webReceiver.getJsCallback()) && webReceiver2.getWebViewCallBackListener() == webReceiver.getWebViewCallBackListener()) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static void realAddWebReceiver(WebReceiver webReceiver) {
        Context appContext = AppRuntime.getAppContext();
        ReceiverManager.getInstance().addReceiver(webReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(webReceiver.mAction);
        LocalBroadcastManager.getInstance(appContext).registerReceiver(webReceiver, intentFilter);
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerWebReceiver ## " + webReceiver.toString());
        }
    }

    public static boolean registerWebReceiver(String str, String str2, @NonNull String str3, @NonNull DataChannelWebSchemeDispatcher.OnWebViewCallBackListener onWebViewCallBackListener, @NonNull String str4, boolean z) {
        if (onWebViewCallBackListener != null && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(str)) {
                str = Contract.DEFAULT_HOST;
            }
            String str5 = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = Contract.DEFAULT_PAGE;
            }
            WebReceiver webReceiver = new WebReceiver(onWebViewCallBackListener, str4, str5, str2, str3);
            if (z) {
                realAddWebReceiver(webReceiver);
                return true;
            } else if (!isReceiverExist(webReceiver)) {
                realAddWebReceiver(webReceiver);
                return true;
            } else {
                return true;
            }
        } else if (Contract.DEBUG) {
            Log.d(Contract.TAG, "Registry registerWebReceiver invalid param");
            return false;
        } else {
            return false;
        }
    }
}
