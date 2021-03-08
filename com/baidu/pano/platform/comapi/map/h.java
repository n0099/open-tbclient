package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2736a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, int i) {
        this.b = eVar;
        this.f2736a = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        com.baidu.pano.platform.c.a aVar;
        com.baidu.pano.platform.c.a aVar2;
        com.baidu.pano.platform.c.a aVar3;
        com.baidu.pano.platform.c.a aVar4;
        Handler handler;
        Handler handler2;
        com.baidu.pano.platform.c.a aVar5;
        float c = this.b.c();
        if (1 == this.f2736a) {
            if (c > 40.0f) {
                aVar5 = this.b.f2733a;
                c = aVar5.a();
            } else {
                this.b.k();
                return;
            }
        } else if (2 == this.f2736a) {
            if (c > 20.0f) {
                aVar4 = this.b.f2733a;
                c = aVar4.a();
            } else {
                this.b.k();
                return;
            }
        } else if (3 == this.f2736a) {
            if (c < 60.0f) {
                aVar3 = this.b.f2733a;
                c = aVar3.a();
            } else {
                this.b.k();
                return;
            }
        } else if (4 == this.f2736a) {
            if (c > 20.0f) {
                aVar2 = this.b.f2733a;
                c = aVar2.a();
            } else {
                this.b.k();
                return;
            }
        } else if (5 == this.f2736a) {
            if (c > 40.0f) {
                aVar = this.b.f2733a;
                c = aVar.a();
            } else {
                this.b.k();
                return;
            }
        }
        handler = this.b.o;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 1002;
        obtainMessage.arg1 = (int) c;
        handler2 = this.b.o;
        handler2.sendMessage(obtainMessage);
    }
}
