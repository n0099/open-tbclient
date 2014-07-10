package com.baidu.android.systemmonitor.freqstatistic;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends BroadcastReceiver {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(c cVar) {
        this.a = cVar;
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
            this.a.o();
        } else if (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.TIMEZONE_CHANGED")) {
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j = this.a.f;
            j2 = this.a.d;
            j3 = this.a.e;
            long j4 = j + ((currentTimeMillis - j2) - (elapsedRealtime - j3));
            this.a.f = j4;
            context2 = this.a.b;
            com.baidu.android.systemmonitor.c.b.a(context2.getApplicationContext(), j4);
            this.a.d = currentTimeMillis;
            this.a.e = elapsedRealtime;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            handler2 = this.a.t;
            runnable2 = this.a.l;
            handler2.postDelayed(runnable2, 500L);
        } else if (!action.equals("android.intent.action.SCREEN_ON")) {
            if (action.equals("android.intent.action.USER_PRESENT")) {
                this.a.g = SystemClock.elapsedRealtime();
                boolean unused = c.i = false;
            }
        } else {
            this.a.g = SystemClock.elapsedRealtime();
            context3 = this.a.b;
            boolean unused2 = c.i = ((KeyguardManager) context3.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            i = c.n;
            if (i == 2) {
                handler = this.a.t;
                runnable = this.a.m;
                handler.post(runnable);
            }
        }
    }
}
