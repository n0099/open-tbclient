package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b SG;
    private final /* synthetic */ Uri SH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.SG = bVar;
        this.SH = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.SG.d(this.SH);
    }
}
