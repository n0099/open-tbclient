package com.baidu.platform.comapi.walknavi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class j extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f10152a;

    public j(b bVar) {
        this.f10152a = bVar;
    }

    private void a(Context context) {
        Context context2;
        Context context3;
        context2 = this.f10152a.y;
        int a2 = com.baidu.platform.comapi.wnplatform.o.h.a(context2);
        if (a2 != 0) {
            com.baidu.platform.comapi.walknavi.b.a.f9902a = a2;
            context3 = this.f10152a.y;
            com.baidu.platform.comapi.wnplatform.o.h.a(context3, 0);
        }
    }

    private void b(Context context) {
        Handler handler;
        handler = this.f10152a.z;
        handler.postDelayed(new k(this), 2000L);
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
}
