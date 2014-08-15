package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b a;
    private final /* synthetic */ Uri b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.a = bVar;
        this.b = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c(this.b);
    }
}
