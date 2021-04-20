package com.baidu.location.a;

import java.io.File;
/* loaded from: classes2.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f6528a;

    public f(d dVar) {
        this.f6528a = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f6528a.a(new File(com.baidu.location.d.j.i() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
