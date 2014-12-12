package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    private final /* synthetic */ ContentValues GA;
    final /* synthetic */ b Gy;
    private final /* synthetic */ Uri Gz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Gy = bVar;
        this.Gz = uri;
        this.GA = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Gy.b(this.Gz, this.GA);
    }
}
