package com.baidu.searchbox.ng.ai.apps.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    protected static final boolean DEBUG = false;
    private String mCallback;
    private WeakReference<CallbackHandler> mCallbackHandlerWeakRef;

    public NetworkBroadcastReceiver(CallbackHandler callbackHandler, String str) {
        this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
        this.mCallback = str;
    }

    public void updateCallback(CallbackHandler callbackHandler, String str) {
        this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
        this.mCallback = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE" == intent.getAction() && !TextUtils.isEmpty(this.mCallback)) {
            AiAppNetworkUtils.notifyNetworkStatus(context, this.mCallbackHandlerWeakRef.get(), this.mCallback);
        }
    }
}
