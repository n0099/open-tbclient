package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Yu;
    private final /* synthetic */ Uri Yv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Yu = bVar;
        this.Yv = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yu.e(this.Yv);
    }
}
