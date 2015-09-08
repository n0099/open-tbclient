package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Yv;
    private final /* synthetic */ Uri Yw;
    private final /* synthetic */ ContentValues Yx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Yv = bVar;
        this.Yw = uri;
        this.Yx = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yv.b(this.Yw, this.Yx);
    }
}
