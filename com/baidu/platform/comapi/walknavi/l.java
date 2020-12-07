package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class l extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.f3083a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("state");
        if (TelephonyManager.EXTRA_STATE_RINGING.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(stringExtra)) {
            a(context);
        } else if (TelephonyManager.EXTRA_STATE_IDLE.equals(stringExtra)) {
            b(context);
        }
    }

    private void a(Context context) {
        Context context2;
        Context context3;
        context2 = this.f3083a.z;
        int a2 = com.baidu.platform.comapi.wnplatform.p.i.a(context2);
        if (a2 != 0) {
            com.baidu.platform.comapi.walknavi.b.a.f2958a = a2;
            context3 = this.f3083a.z;
            com.baidu.platform.comapi.wnplatform.p.i.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.f3083a.A;
        handler.postDelayed(new m(this), 2000L);
    }
}
