package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b GH;
    private final /* synthetic */ Uri GI;
    private final /* synthetic */ ContentValues GJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.GH = bVar;
        this.GI = uri;
        this.GJ = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.GH.b(this.GI, this.GJ);
    }
}
