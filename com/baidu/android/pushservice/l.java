package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f609a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PushSDK pushSDK) {
        this.f609a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f609a.sendRequestTokenIntent();
    }
}
