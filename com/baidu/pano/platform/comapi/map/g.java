package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class g extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f9387a;

    public g(e eVar) {
        this.f9387a = eVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        Handler handler;
        Handler handler2;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        f2 = this.f9387a.f9385i;
        float f17 = f2 * 0.1f;
        f3 = this.f9387a.j;
        float f18 = f3 * 0.1f;
        f4 = this.f9387a.f9385i;
        if (!Float.isInfinite(Math.abs(f4))) {
            f5 = this.f9387a.f9385i;
            if (!Float.isNaN(f5)) {
                f6 = this.f9387a.j;
                if (!Float.isInfinite(Math.abs(f6))) {
                    f7 = this.f9387a.j;
                    if (!Float.isNaN(f7)) {
                        f8 = this.f9387a.f9385i;
                        float f19 = 0.0f;
                        if (Math.abs(f8) > 40.0f) {
                            e eVar = this.f9387a;
                            f15 = eVar.f9385i;
                            eVar.f9385i = f15 - f17;
                            f16 = this.f9387a.f9385i;
                            f9 = 0.03f * f16;
                        } else {
                            f9 = 0.0f;
                        }
                        f10 = this.f9387a.j;
                        if (Math.abs(f10) > 40.0f) {
                            e eVar2 = this.f9387a;
                            f13 = eVar2.j;
                            eVar2.j = f13 - f18;
                            f14 = this.f9387a.j;
                            f19 = 0.018f * f14;
                        }
                        f11 = this.f9387a.f9385i;
                        if (Math.abs(f11) < 40.0f) {
                            f12 = this.f9387a.j;
                            if (Math.abs(f12) < 40.0f) {
                                this.f9387a.j();
                                return;
                            }
                        }
                        handler = this.f9387a.o;
                        Message obtainMessage = handler.obtainMessage();
                        obtainMessage.what = 1001;
                        obtainMessage.arg1 = (int) f9;
                        obtainMessage.arg2 = (int) f19;
                        handler2 = this.f9387a.o;
                        handler2.sendMessage(obtainMessage);
                        return;
                    }
                }
            }
        }
        this.f9387a.j();
    }
}
