package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Zq;
    private final /* synthetic */ Uri Zr;
    private final /* synthetic */ ContentValues Zs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Zq = bVar;
        this.Zr = uri;
        this.Zs = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Zq.b(this.Zr, this.Zs);
    }
}
