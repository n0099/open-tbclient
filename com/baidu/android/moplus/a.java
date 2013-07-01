package com.baidu.android.moplus;

import android.content.Intent;
/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoPlusService f249a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MoPlusService moPlusService) {
        this.f249a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f249a.a(new Intent());
    }
}
