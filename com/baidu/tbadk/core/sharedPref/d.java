package com.baidu.tbadk.core.sharedPref;

import android.net.Uri;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ b Tr;
    private final /* synthetic */ Uri Ts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, Uri uri) {
        this.Tr = bVar;
        this.Ts = uri;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Tr.d(this.Ts);
    }
}
