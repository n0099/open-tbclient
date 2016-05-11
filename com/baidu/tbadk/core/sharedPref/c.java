package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b UH;
    private final /* synthetic */ Uri UI;
    private final /* synthetic */ ContentValues UJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.UH = bVar;
        this.UI = uri;
        this.UJ = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.UH.b(this.UI, this.UJ);
    }
}
