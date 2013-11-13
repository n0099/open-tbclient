package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PushSDK pushSDK) {
        this.f716a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f716a.sendRequestTokenIntent();
    }
}
