package com.baidu.android.systemmonitor.b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f682a = fVar;
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
            this.f682a.o();
        } else if (action.equals("android.intent.action.TIME_SET") || action.equals("android.intent.action.TIMEZONE_CHANGED")) {
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            j = this.f682a.f;
            j2 = this.f682a.d;
            j3 = this.f682a.e;
            long j4 = j + ((currentTimeMillis - j2) - (elapsedRealtime - j3));
            this.f682a.f = j4;
            context2 = this.f682a.b;
            com.baidu.android.systemmonitor.d.b.a(context2.getApplicationContext(), j4);
            this.f682a.d = currentTimeMillis;
            this.f682a.e = elapsedRealtime;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            handler2 = this.f682a.t;
            runnable2 = this.f682a.l;
            handler2.postDelayed(runnable2, 500L);
        } else if (!action.equals("android.intent.action.SCREEN_ON")) {
            if (action.equals("android.intent.action.USER_PRESENT")) {
                this.f682a.g = SystemClock.elapsedRealtime();
                boolean unused = f.i = false;
            }
        } else {
            this.f682a.g = SystemClock.elapsedRealtime();
            context3 = this.f682a.b;
            boolean unused2 = f.i = ((KeyguardManager) context3.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
            i = f.n;
            if (i == 2) {
                handler = this.f682a.t;
                runnable = this.f682a.m;
                handler.post(runnable);
            }
        }
    }
}
