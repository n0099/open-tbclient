package com.baidu.location.a;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f1912a = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f1912a.a(new File(com.baidu.location.d.j.i() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
