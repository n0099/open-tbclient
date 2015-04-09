package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b SG;
    private final /* synthetic */ Uri SH;
    private final /* synthetic */ ContentValues SI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.SG = bVar;
        this.SH = uri;
        this.SI = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.SG.b(this.SH, this.SI);
    }
}
