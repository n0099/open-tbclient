package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes15.dex */
public class NAReceiver extends BaseBroadcastReceiver {
    private NAReceiverCallback mNAReceiverCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NAReceiver(NAReceiverCallback nAReceiverCallback, String str, String str2, String str3) {
        this.mNAReceiverCallback = nAReceiverCallback;
        this.mHost = str;
        this.mPage = str2;
        this.mAction = str3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mNAReceiverCallback == null) {
            if (Contract.DEBUG) {
                Log.d(Contract.TAG, "NAReceiver onReceive ## mNAReceiverCallback is null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("data");
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "NAReceiver onReceive ## " + stringExtra);
        }
        this.mNAReceiverCallback.onReceive(action, stringExtra);
    }

    @Override // com.baidu.searchbox.datachannel.BaseBroadcastReceiver
    public void release() {
        this.mNAReceiverCallback = null;
    }
}
