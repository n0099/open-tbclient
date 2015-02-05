package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b GE;
    private final /* synthetic */ Uri GF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.GE = bVar;
        this.GF = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.GE.d(this.GF);
    }
}
