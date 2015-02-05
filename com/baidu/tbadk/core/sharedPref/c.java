package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b GE;
    private final /* synthetic */ Uri GF;
    private final /* synthetic */ ContentValues GG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.GE = bVar;
        this.GF = uri;
        this.GG = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.GE.b(this.GF, this.GG);
    }
}
