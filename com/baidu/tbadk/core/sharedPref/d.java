package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b UH;
    private final /* synthetic */ Uri UI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.UH = bVar;
        this.UI = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.UH.d(this.UI);
    }
}
