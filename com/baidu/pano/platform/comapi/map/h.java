package com.baidu.pano.platform.comapi.map;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class h extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9054a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f9055b;

    public h(e eVar, int i) {
        this.f9055b = eVar;
        this.f9054a = i;
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
        float c2 = this.f9055b.c();
        int i = this.f9054a;
        if (1 == i) {
            if (c2 > 40.0f) {
                aVar5 = this.f9055b.f9044a;
                c2 = aVar5.a();
            } else {
                this.f9055b.k();
                return;
            }
        } else if (2 == i) {
            if (c2 > 20.0f) {
                aVar4 = this.f9055b.f9044a;
                c2 = aVar4.a();
            } else {
                this.f9055b.k();
                return;
            }
        } else if (3 == i) {
            if (c2 < 60.0f) {
                aVar3 = this.f9055b.f9044a;
                c2 = aVar3.a();
            } else {
                this.f9055b.k();
                return;
            }
        } else if (4 == i) {
            if (c2 > 20.0f) {
                aVar2 = this.f9055b.f9044a;
                c2 = aVar2.a();
            } else {
                this.f9055b.k();
                return;
            }
        } else if (5 == i) {
            if (c2 > 40.0f) {
                aVar = this.f9055b.f9044a;
                c2 = aVar.a();
            } else {
                this.f9055b.k();
                return;
            }
        }
        handler = this.f9055b.o;
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 1002;
        obtainMessage.arg1 = (int) c2;
        handler2 = this.f9055b.o;
        handler2.sendMessage(obtainMessage);
    }
}
