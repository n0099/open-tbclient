package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Yo;
    private final /* synthetic */ Uri Yp;
    private final /* synthetic */ ContentValues Yq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Yo = bVar;
        this.Yp = uri;
        this.Yq = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yo.b(this.Yp, this.Yq);
    }
}
