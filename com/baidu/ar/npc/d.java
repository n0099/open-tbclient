package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1527a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f1528b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.e = arBridge;
        this.f1527a = str;
        this.f1528b = hashMap;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.nativeDestroyCase();
        this.e.setGLJniEnv();
        this.e.nativeCreateCase(this.f1527a, this.e.getCaseId(), this.f1528b, this.c, this.d);
    }
}
