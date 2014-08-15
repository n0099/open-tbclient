package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b a;
    private final /* synthetic */ Uri b;
    private final /* synthetic */ ContentValues c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.a = bVar;
        this.b = uri;
        this.c = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b, this.c);
    }
}
