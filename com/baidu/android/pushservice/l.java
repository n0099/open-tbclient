package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PushSDK pushSDK) {
        this.f586a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f586a.sendRequestTokenIntent();
    }
}
