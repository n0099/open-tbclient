package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Cm;
    private final /* synthetic */ Uri Cn;
    private final /* synthetic */ ContentValues Co;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Cm = bVar;
        this.Cn = uri;
        this.Co = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cm.b(this.Cn, this.Co);
    }
}
