package com.baidu.ar.npc;

import android.util.Log;
import com.baidu.ar.npc.ArBridge;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4191a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4193c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4194d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f4195e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f4196f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4197g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4198h;
    public final /* synthetic */ float i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ long l;
    public final /* synthetic */ ArBridge m;

    public o(ArBridge arBridge, int i, int i2, float f2, float f3, float f4, float f5, int i3, float f6, float f7, float f8, float f9, long j) {
        this.m = arBridge;
        this.f4191a = i;
        this.f4192b = i2;
        this.f4193c = f2;
        this.f4194d = f3;
        this.f4195e = f4;
        this.f4196f = f5;
        this.f4197g = i3;
        this.f4198h = f6;
        this.i = f7;
        this.j = f8;
        this.k = f9;
        this.l = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArBridge.e eVar;
        ArBridge.e eVar2;
        StringBuilder sb = new StringBuilder();
        sb.append("onTouchEvent the orientation is ");
        eVar = this.m.j;
        sb.append(eVar.name());
        Log.d("orientation", sb.toString());
        ArBridge arBridge = this.m;
        int i = this.f4191a;
        int i2 = this.f4192b;
        float f2 = this.f4193c;
        float f3 = this.f4194d;
        float f4 = this.f4195e;
        float f5 = this.f4196f;
        int i3 = this.f4197g;
        float f6 = this.f4198h;
        float f7 = this.i;
        float f8 = this.j;
        float f9 = this.k;
        long j = this.l;
        eVar2 = arBridge.j;
        arBridge.onTouchEventNative(i, i2, f2, f3, f4, f5, i3, f6, f7, f8, f9, j, eVar2.ordinal());
    }
}
