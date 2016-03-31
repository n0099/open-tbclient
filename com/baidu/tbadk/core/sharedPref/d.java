package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Zq;
    private final /* synthetic */ Uri Zr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Zq = bVar;
        this.Zr = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Zq.d(this.Zr);
    }
}
