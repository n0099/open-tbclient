package com.baidu.android.moplus;

import android.content.Intent;
/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MoPlusService moPlusService) {
        this.f513a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f513a.a(new Intent());
    }
}
