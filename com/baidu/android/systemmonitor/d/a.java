package com.baidu.android.systemmonitor.d;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.f395a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long j;
        long j2;
        long j3;
        Context context2;
        Context context3;
        int i;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        String action = intent.getAction();
        if (action.equals("com.baidu.freqstatistic.summaryresults")) {
            this.f395a.o();
        } else if (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.TIMEZONE_CHANGED")) {
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j = this.f395a.f;
            j2 = this.f395a.d;
            j3 = this.f395a.e;
            long j4 = j + ((currentTimeMillis - j2) - (elapsedRealtime - j3));
            this.f395a.f = j4;
            context2 = this.f395a.b;
            com.baidu.android.systemmonitor.a.b.a(context2.getApplicationContext(), j4);
            this.f395a.d = currentTimeMillis;
            this.f395a.e = elapsedRealtime;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            handler2 = this.f395a.t;
            runnable2 = this.f395a.l;
            handler2.postDelayed(runnable2, 500L);
        } else if (!action.equals("android.intent.action.SCREEN_ON")) {
            if (action.equals("android.intent.action.USER_PRESENT")) {
                this.f395a.g = SystemClock.elapsedRealtime();
                boolean unused = c.i = false;
            }
        } else {
            this.f395a.g = SystemClock.elapsedRealtime();
            context3 = this.f395a.b;
            boolean unused2 = c.i = ((KeyguardManager) context3.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            i = c.n;
            if (i == 2) {
                handler = this.f395a.t;
                runnable = this.f395a.m;
                handler.post(runnable);
            }
        }
    }
}
