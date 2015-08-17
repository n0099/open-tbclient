package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Ym;
    private final /* synthetic */ Uri Yn;
    private final /* synthetic */ ContentValues Yo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Ym = bVar;
        this.Yn = uri;
        this.Yo = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ym.b(this.Yn, this.Yo);
    }
}
