package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b VH;
    private final /* synthetic */ Uri VI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.VH = bVar;
        this.VI = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.VH.e(this.VI);
    }
}
