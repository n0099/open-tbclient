package com.baidu.android.moplus;

import android.content.Intent;
/* loaded from: classes.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MoPlusService moPlusService) {
        this.f512a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f512a.a(new Intent());
    }
}
