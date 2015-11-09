package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Ys;
    private final /* synthetic */ Uri Yt;
    private final /* synthetic */ ContentValues Yu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Ys = bVar;
        this.Yt = uri;
        this.Yu = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ys.b(this.Yt, this.Yu);
    }
}
