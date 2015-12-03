package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Ze;
    private final /* synthetic */ Uri Zf;
    private final /* synthetic */ ContentValues Zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Ze = bVar;
        this.Zf = uri;
        this.Zg = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ze.b(this.Zf, this.Zg);
    }
}
