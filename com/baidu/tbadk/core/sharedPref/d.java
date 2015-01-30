package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b GH;
    private final /* synthetic */ Uri GI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.GH = bVar;
        this.GI = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.GH.d(this.GI);
    }
}
