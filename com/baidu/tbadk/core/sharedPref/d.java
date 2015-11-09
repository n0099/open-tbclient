package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Ys;
    private final /* synthetic */ Uri Yt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Ys = bVar;
        this.Yt = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ys.d(this.Yt);
    }
}
