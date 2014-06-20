package com.baidu.android.moplus;

import android.content.Intent;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ MoPlusService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MoPlusService moPlusService) {
        this.a = moPlusService;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(new Intent());
    }
}
