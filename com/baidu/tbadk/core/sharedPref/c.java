package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b ZH;
    private final /* synthetic */ Uri ZI;
    private final /* synthetic */ ContentValues ZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.ZH = bVar;
        this.ZI = uri;
        this.ZJ = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ZH.b(this.ZI, this.ZJ);
    }
}
