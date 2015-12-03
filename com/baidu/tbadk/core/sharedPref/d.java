package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Ze;
    private final /* synthetic */ Uri Zf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Ze = bVar;
        this.Zf = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ze.d(this.Zf);
    }
}
