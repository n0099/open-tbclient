package com.baidu.searchbox.datachannel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
/* loaded from: classes13.dex */
public class APSReceiver extends BaseBroadcastReceiver {
    private APSReceiverCallback mAPSReceiverCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public APSReceiver(APSReceiverCallback aPSReceiverCallback, String str, String str2, String str3) {
        this.mAPSReceiverCallback = aPSReceiverCallback;
        this.mHost = str;
        this.mPage = str2;
        this.mAction = str3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("data");
        if (Contract.DEBUG) {
            Log.d(Contract.TAG, "APSReceiver onReceive ## " + stringExtra);
        }
        this.mAPSReceiverCallback.onReceive(action, stringExtra);
    }

    @Override // com.baidu.searchbox.datachannel.BaseBroadcastReceiver
    public void release() {
        this.mAPSReceiverCallback = null;
    }
}
