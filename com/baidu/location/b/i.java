package com.baidu.location.b;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f2623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f2623a = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f2623a.a(new File(com.baidu.location.e.l.k() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
