package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Ym;
    private final /* synthetic */ Uri Yn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Ym = bVar;
        this.Yn = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ym.d(this.Yn);
    }
}
