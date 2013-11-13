package com.baidu.android.pushservice;

import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PushSDK pushSDK) {
        this.f715a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f715a.handleOnStart(new Intent());
    }
}
