package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b UY;
    private final /* synthetic */ Uri UZ;
    private final /* synthetic */ ContentValues Va;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.UY = bVar;
        this.UZ = uri;
        this.Va = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.UY.b(this.UZ, this.Va);
    }
}
