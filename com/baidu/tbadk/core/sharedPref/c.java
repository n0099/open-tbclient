package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Yu;
    private final /* synthetic */ Uri Yv;
    private final /* synthetic */ ContentValues Yw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Yu = bVar;
        this.Yv = uri;
        this.Yw = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yu.b(this.Yv, this.Yw);
    }
}
