package com.baidu.location.b;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class i extends Thread {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.a(new File(com.baidu.location.e.l.k() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
