package com.baidu.ar.npc;

import android.util.Log;
import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4296a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f4297b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f4298c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f4299d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f4300e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f4301f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f4302g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f4303h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f4304i;
    public final /* synthetic */ float j;
    public final /* synthetic */ float k;
    public final /* synthetic */ long l;
    public final /* synthetic */ ArBridge m;

    public o(ArBridge arBridge, int i2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, long j) {
        this.m = arBridge;
        this.f4296a = i2;
        this.f4297b = i3;
        this.f4298c = f2;
        this.f4299d = f3;
        this.f4300e = f4;
        this.f4301f = f5;
        this.f4302g = i4;
        this.f4303h = f6;
        this.f4304i = f7;
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
        int i2 = this.f4296a;
        int i3 = this.f4297b;
        float f2 = this.f4298c;
        float f3 = this.f4299d;
        float f4 = this.f4300e;
        float f5 = this.f4301f;
        int i4 = this.f4302g;
        float f6 = this.f4303h;
        float f7 = this.f4304i;
        float f8 = this.j;
        float f9 = this.k;
        long j = this.l;
        eVar2 = arBridge.j;
        arBridge.onTouchEventNative(i2, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, j, eVar2.ordinal());
    }
}
