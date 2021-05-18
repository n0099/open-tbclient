package com.baidu.swan.apps.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.a.i0.a.k;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public static final boolean DEBUG = k.f43025a;
    public String mCallback;
    public WeakReference<CallbackHandler> mCallbackHandlerWeakRef;

    public NetworkBroadcastReceiver(CallbackHandler callbackHandler, String str) {
        this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
        this.mCallback = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || "android.net.conn.CONNECTIVITY_CHANGE" != intent.getAction() || TextUtils.isEmpty(this.mCallback) || isInitialStickyBroadcast()) {
            return;
        }
        if (DEBUG) {
            Log.d("NetworkBroadcast", "——> onReceive: ");
        }
        SwanAppNetworkUtils.k(context, this.mCallbackHandlerWeakRef.get(), this.mCallback);
    }

    public void updateCallback(CallbackHandler callbackHandler, String str) {
        this.mCallbackHandlerWeakRef = new WeakReference<>(callbackHandler);
        this.mCallback = str;
    }
}
