package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Yo;
    private final /* synthetic */ Uri Yp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Yo = bVar;
        this.Yp = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yo.d(this.Yp);
    }
}
