package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Cm;
    private final /* synthetic */ Uri Cn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Cm = bVar;
        this.Cn = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cm.c(this.Cn);
    }
}
