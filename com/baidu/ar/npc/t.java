package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1550a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1551b;
    final /* synthetic */ HashMap c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ ArBridge f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ArBridge arBridge, String str, int i, HashMap hashMap, int i2, int i3) {
        this.f = arBridge;
        this.f1550a = str;
        this.f1551b = i;
        this.c = hashMap;
        this.d = i2;
        this.e = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.nativeCreateCase(this.f1550a, this.f1551b, this.c, this.d, this.e);
    }
}
