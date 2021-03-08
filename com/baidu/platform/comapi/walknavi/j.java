package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f3022a = bVar;
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
        context2 = this.f3022a.y;
        int a2 = com.baidu.platform.comapi.wnplatform.o.h.a(context2);
        if (a2 != 0) {
            com.baidu.platform.comapi.walknavi.b.a.f2902a = a2;
            context3 = this.f3022a.y;
            com.baidu.platform.comapi.wnplatform.o.h.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.f3022a.z;
        handler.postDelayed(new k(this), 2000L);
    }
}
