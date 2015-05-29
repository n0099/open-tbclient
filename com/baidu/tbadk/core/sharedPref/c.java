package com.baidu.tbadk.core.sharedPref;

import android.content.ContentValues;
import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b Tr;
    private final /* synthetic */ Uri Ts;
    private final /* synthetic */ ContentValues Tt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri, ContentValues contentValues) {
        this.Tr = bVar;
        this.Ts = uri;
        this.Tt = contentValues;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Tr.b(this.Ts, this.Tt);
    }
}
