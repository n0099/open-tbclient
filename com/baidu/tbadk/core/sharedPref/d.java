package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b UY;
    private final /* synthetic */ Uri UZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.UY = bVar;
        this.UZ = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.UY.d(this.UZ);
    }
}
