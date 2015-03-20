package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b SE;
    private final /* synthetic */ Uri SF;
    private final /* synthetic */ ContentValues SG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.SE = bVar;
        this.SF = uri;
        this.SG = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.SE.b(this.SF, this.SG);
    }
}
