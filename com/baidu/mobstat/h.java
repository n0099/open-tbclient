package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f962a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Context context) {
        this.b = gVar;
        this.f962a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        Timer timer;
        SendStrategyEnum sendStrategyEnum;
        SendStrategyEnum sendStrategyEnum2;
        Handler handler;
        int i;
        Timer timer2;
        SharedPreferences a2 = this.b.a(this.f962a);
        this.b.g = a2.getBoolean("exceptionanalysisflag", false);
        z = this.b.g;
        if (z) {
            e.a().b(this.f962a);
        }
        timer = this.b.e;
        if (timer != null) {
            timer2 = this.b.e;
            timer2.cancel();
            this.b.e = null;
        }
        this.b.c = SendStrategyEnum.values()[a2.getInt("sendLogtype", 0)];
        this.b.d = a2.getInt("timeinterval", 1);
        this.b.b = a2.getBoolean("onlywifi", false);
        sendStrategyEnum = this.b.c;
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.b.e(this.f962a);
        } else {
            sendStrategyEnum2 = this.b.c;
            if (sendStrategyEnum2.equals(SendStrategyEnum.ONCE_A_DAY)) {
                this.b.e(this.f962a);
            }
        }
        handler = g.h;
        i iVar = new i(this);
        i = this.b.f;
        handler.postDelayed(iVar, i * LocationClientOption.MIN_SCAN_SPAN);
    }
}
