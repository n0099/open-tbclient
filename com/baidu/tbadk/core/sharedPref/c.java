package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b VH;
    private final /* synthetic */ Uri VI;
    private final /* synthetic */ ContentValues VJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.VH = bVar;
        this.VI = uri;
        this.VJ = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.VH.b(this.VI, this.VJ);
    }
}
