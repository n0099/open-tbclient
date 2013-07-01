package com.baidu.android.nebula.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDLocationManager f289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDLocationManager bDLocationManager) {
        this.f289a = bDLocationManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        BDLocationManager.a();
    }
}
