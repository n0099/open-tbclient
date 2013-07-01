package com.baidu.android.pushservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.common.logging.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f315a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PushSDK pushSDK) {
        this.f315a = pushSDK;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean tryConnect;
        Context context2;
        String str;
        if (b.a()) {
            str = PushSDK.TAG;
            Log.d(str, "ACTION_SCREEN_ON");
        }
        tryConnect = this.f315a.tryConnect();
        if (tryConnect) {
            return;
        }
        Intent intent2 = new Intent("com.baidu.pushservice.action.STOP");
        context2 = PushSDK.mContext;
        b.a(context2, intent2);
    }
}
