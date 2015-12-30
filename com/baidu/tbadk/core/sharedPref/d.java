package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b ZH;
    private final /* synthetic */ Uri ZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.ZH = bVar;
        this.ZI = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ZH.d(this.ZI);
    }
}
