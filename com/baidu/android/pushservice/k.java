package com.baidu.android.pushservice;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PushSDK pushSDK) {
        this.f608a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f608a.handleOnStart(new Intent());
    }
}
