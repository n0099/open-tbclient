package com.baidu.sapi2.views;

import android.content.BroadcastReceiver;
import com.baidu.sapi2.callback.RequestSMSCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j extends RequestSMSCallback {
    final /* synthetic */ SmsLoginView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SmsLoginView smsLoginView) {
        this.a = smsLoginView;
    }

    @Override // com.baidu.sapi2.callback.RequestSMSCallback
    public void receiverResult(BroadcastReceiver broadcastReceiver) {
        this.a.r = broadcastReceiver;
    }
}
