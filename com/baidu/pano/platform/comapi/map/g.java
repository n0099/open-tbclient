package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class g extends TimerTask {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Handler handler;
        Handler handler2;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16 = 0.0f;
        f = this.a.i;
        float f17 = f * 0.1f;
        f2 = this.a.j;
        float f18 = f2 * 0.1f;
        float f19 = 0.005f * 6.0f;
        float f20 = 6.0f * 0.003f;
        f3 = this.a.i;
        if (!Float.isInfinite(Math.abs(f3))) {
            f4 = this.a.i;
            if (!Float.isNaN(f4)) {
                f5 = this.a.j;
                if (!Float.isInfinite(Math.abs(f5))) {
                    f6 = this.a.j;
                    if (!Float.isNaN(f6)) {
                        f7 = this.a.i;
                        if (Math.abs(f7) > 40.0f) {
                            e eVar = this.a;
                            f14 = this.a.i;
                            eVar.i = f14 - f17;
                            f15 = this.a.i;
                            f8 = f15 * f19;
                        } else {
                            f8 = 0.0f;
                        }
                        f9 = this.a.j;
                        if (Math.abs(f9) > 40.0f) {
                            e eVar2 = this.a;
                            f12 = this.a.j;
                            eVar2.j = f12 - f18;
                            f13 = this.a.j;
                            f16 = f13 * f20;
                        }
                        f10 = this.a.i;
                        if (Math.abs(f10) < 40.0f) {
                            f11 = this.a.j;
                            if (Math.abs(f11) < 40.0f) {
                                this.a.j();
                                return;
                            }
                        }
                        handler = this.a.o;
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 1001;
                        obtainMessage.arg1 = (int) f8;
                        obtainMessage.arg2 = (int) f16;
                        handler2 = this.a.o;
                        handler2.sendMessage(obtainMessage);
                        return;
                    }
                }
            }
        }
        this.a.j();
    }
}
