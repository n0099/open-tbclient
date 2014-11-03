package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Cn;
    private final /* synthetic */ Uri Co;
    private final /* synthetic */ ContentValues Cp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Cn = bVar;
        this.Co = uri;
        this.Cp = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cn.b(this.Co, this.Cp);
    }
}
