package com.baidu.swan.apps.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
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
        if (context != null && intent != null && "android.net.conn.CONNECTIVITY_CHANGE" == intent.getAction() && !TextUtils.isEmpty(this.mCallback) && !isInitialStickyBroadcast()) {
            if (DEBUG) {
                Log.d("NetworkBroadcast", "——> onReceive: ");
            }
            SwanAppNetworkUtils.a(context, this.mCallbackHandlerWeakRef.get(), this.mCallback);
        }
    }
}
