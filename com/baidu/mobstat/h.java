package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.location.LocationClientOption;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Context context) {
        this.b = gVar;
        this.a = context;
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
        SharedPreferences a = this.b.a(this.a);
        this.b.g = a.getBoolean("exceptionanalysisflag", false);
        z = this.b.g;
        if (z) {
            e.a().b(this.a);
        }
        timer = this.b.e;
        if (timer != null) {
            timer2 = this.b.e;
            timer2.cancel();
            this.b.e = null;
        }
        this.b.c = SendStrategyEnum.values()[a.getInt("sendLogtype", 0)];
        this.b.d = a.getInt("timeinterval", 1);
        this.b.b = a.getBoolean("onlywifi", false);
        sendStrategyEnum = this.b.c;
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.b.e(this.a);
        } else {
            sendStrategyEnum2 = this.b.c;
            if (sendStrategyEnum2.equals(SendStrategyEnum.ONCE_A_DAY)) {
                this.b.e(this.a);
            }
        }
        handler = g.h;
        i iVar = new i(this);
        i = this.b.f;
        handler.postDelayed(iVar, i * LocationClientOption.MIN_SCAN_SPAN);
    }
}
