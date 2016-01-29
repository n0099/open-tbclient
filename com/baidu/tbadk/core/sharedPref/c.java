package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b aae;
    private final /* synthetic */ Uri aaf;
    private final /* synthetic */ ContentValues aag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.aae = bVar;
        this.aaf = uri;
        this.aag = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aae.b(this.aaf, this.aag);
    }
}
