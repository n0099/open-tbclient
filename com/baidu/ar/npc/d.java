package com.baidu.ar.npc;

import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1526a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HashMap f1527b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ ArBridge e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ArBridge arBridge, String str, HashMap hashMap, int i, int i2) {
        this.e = arBridge;
        this.f1526a = str;
        this.f1527b = hashMap;
        this.c = i;
        this.d = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.nativeDestroyCase();
        this.e.setGLJniEnv();
        this.e.nativeCreateCase(this.f1526a, this.e.getCaseId(), this.f1527b, this.c, this.d);
    }
}
