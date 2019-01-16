package com.baidu.b.a.f.d;

import android.util.Log;
import com.baidu.b.a.a;
import java.io.File;
/* loaded from: classes2.dex */
public class g {
    private static g aam;
    private k aan = new k();

    public static g rV() {
        synchronized (g.class) {
            if (aam == null) {
                aam = new g();
            }
        }
        return aam;
    }

    private g() {
    }

    public synchronized j a(com.baidu.b.a.c.a.a aVar, com.baidu.b.a.b.c.b bVar) {
        j jVar = null;
        synchronized (this) {
            if (aVar == null) {
                if (com.baidu.b.a.h.b.isDebug()) {
                    Log.e("ThunderManager", "DynamicFile cannot be null !!!");
                }
            } else {
                b bVar2 = new b(bVar, aVar);
                if (d.a(bVar, aVar)) {
                    try {
                        File file = new File(bVar2.getDownloadPath());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } catch (Exception e) {
                        if (com.baidu.b.a.h.b.isDebug()) {
                            e.printStackTrace();
                        }
                        bVar2.onDownloadError(new com.baidu.b.a.b.b.a(aVar.packageName, 2204, "download : path not available", a.C0056a.C0057a.Zd));
                    }
                }
                f fVar = new f(aVar, bVar2);
                if (a(fVar, bVar2)) {
                    jVar = new j(fVar, true);
                } else {
                    jVar = new j(fVar);
                }
            }
        }
        return jVar;
    }

    public synchronized boolean a(f fVar, b bVar) {
        boolean z;
        if (this.aan.b(fVar, bVar)) {
            com.baidu.b.a.c.a.a rP = fVar.rP();
            rP.KI = 2212;
            rP.errMsg = "duplicated download task";
            rP.Zv = a.C0056a.C0057a.Zl;
            fVar.rQ().onDownloading(new com.baidu.b.a.b.b.a(fVar.getPackageName(), rP.KI, rP.errMsg, rP.Zv));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void e(f fVar) {
        fVar.aH(false);
        this.aan.h(fVar);
    }

    public synchronized void f(f fVar) {
        boolean k = this.aan.k(fVar);
        this.aan.j(fVar);
        fVar.bH(12);
        com.baidu.b.a.b.b.a aVar = new com.baidu.b.a.b.b.a(fVar.getPackageName(), 2211, "download : customer cancel download", a.C0056a.C0057a.Zk);
        if (!k) {
            fVar.rQ().onFileCancel(aVar);
        }
    }

    public synchronized void a(com.baidu.b.a.f.d.a.a aVar) {
        this.aan.c(aVar);
    }

    public synchronized void b(com.baidu.b.a.f.d.a.a aVar) {
        this.aan.d(aVar);
    }
}
