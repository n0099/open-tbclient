package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Gy;
    private final /* synthetic */ Uri Gz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Gy = bVar;
        this.Gz = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Gy.d(this.Gz);
    }
}
