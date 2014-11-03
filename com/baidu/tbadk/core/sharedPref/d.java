package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Cn;
    private final /* synthetic */ Uri Co;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Cn = bVar;
        this.Co = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cn.c(this.Co);
    }
}
