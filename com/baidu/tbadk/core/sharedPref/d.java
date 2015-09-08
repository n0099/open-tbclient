package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Yv;
    private final /* synthetic */ Uri Yw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Yv = bVar;
        this.Yw = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Yv.d(this.Yw);
    }
}
