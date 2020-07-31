package com.baidu.ar.npc;

import android.util.Log;
import com.baidu.ar.npc.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class o implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ float c;
    final /* synthetic */ float d;
    final /* synthetic */ float e;
    final /* synthetic */ float f;
    final /* synthetic */ int g;
    final /* synthetic */ float h;
    final /* synthetic */ float i;
    final /* synthetic */ float j;
    final /* synthetic */ float k;
    final /* synthetic */ long l;
    final /* synthetic */ ArBridge m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ArBridge arBridge, int i, int i2, float f, float f2, float f3, float f4, int i3, float f5, float f6, float f7, float f8, long j) {
        this.m = arBridge;
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
        this.g = i3;
        this.h = f5;
        this.i = f6;
        this.j = f7;
        this.k = f8;
        this.l = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArBridge.e eVar;
        ArBridge.e eVar2;
        StringBuilder append = new StringBuilder().append("onTouchEvent the orientation is ");
        eVar = this.m.j;
        Log.d("orientation", append.append(eVar.name()).toString());
        ArBridge arBridge = this.m;
        int i = this.a;
        int i2 = this.b;
        float f = this.c;
        float f2 = this.d;
        float f3 = this.e;
        float f4 = this.f;
        int i3 = this.g;
        float f5 = this.h;
        float f6 = this.i;
        float f7 = this.j;
        float f8 = this.k;
        long j = this.l;
        eVar2 = this.m.j;
        arBridge.onTouchEventNative(i, i2, f, f2, f3, f4, i3, f5, f6, f7, f8, j, eVar2.ordinal());
    }
}
