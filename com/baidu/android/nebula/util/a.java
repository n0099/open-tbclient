package com.baidu.android.nebula.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BDLocationManager f680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDLocationManager bDLocationManager) {
        this.f680a = bDLocationManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        BDLocationManager.a();
    }
}
