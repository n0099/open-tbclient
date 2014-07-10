package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import java.util.Timer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Context context) {
        this.b = kVar;
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
        this.b.g = BasicStoreTools.getInstance().getExceptionTurn(this.a);
        z = this.b.g;
        if (z) {
            i.a().b(this.a);
        }
        timer = this.b.e;
        if (timer != null) {
            timer2 = this.b.e;
            timer2.cancel();
            this.b.e = null;
        }
        this.b.c = SendStrategyEnum.values()[BasicStoreTools.getInstance().getSendStrategy(this.a)];
        this.b.d = BasicStoreTools.getInstance().getSendStrategyTime(this.a);
        this.b.b = BasicStoreTools.getInstance().getOnlyWifiChannel(this.a);
        sendStrategyEnum = this.b.c;
        if (sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.b.d(this.a);
        } else {
            sendStrategyEnum2 = this.b.c;
            if (sendStrategyEnum2.equals(SendStrategyEnum.ONCE_A_DAY)) {
                this.b.d(this.a);
            }
        }
        handler = k.i;
        m mVar = new m(this);
        i = this.b.f;
        handler.postDelayed(mVar, i * 1000);
    }
}
