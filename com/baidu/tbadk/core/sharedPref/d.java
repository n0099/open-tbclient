package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b aae;
    private final /* synthetic */ Uri aaf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.aae = bVar;
        this.aaf = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aae.d(this.aaf);
    }
}
