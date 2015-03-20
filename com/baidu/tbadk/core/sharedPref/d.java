package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b SE;
    private final /* synthetic */ Uri SF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.SE = bVar;
        this.SF = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.SE.d(this.SF);
    }
}
