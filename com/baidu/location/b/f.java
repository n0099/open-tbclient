package com.baidu.location.b;

import java.io.File;
/* loaded from: classes2.dex */
public class f extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f6581a;

    public f(d dVar) {
        this.f6581a = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f6581a.a(new File(com.baidu.location.e.k.k() + "/baidu/tempdata", "intime.dat"), "https://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
