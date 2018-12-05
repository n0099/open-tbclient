package com.baidu.b.a.f.d;

import android.util.Log;
import com.baidu.b.a.a;
import java.io.File;
/* loaded from: classes2.dex */
public class g {
    private static g aad;
    private k aae = new k();

    public static g rR() {
        synchronized (g.class) {
            if (aad == null) {
                aad = new g();
            }
        }
        return aad;
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
                        bVar2.onDownloadError(new com.baidu.b.a.b.b.a(aVar.packageName, 2204, "download : path not available", a.C0056a.C0057a.YU));
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
        if (this.aae.b(fVar, bVar)) {
            com.baidu.b.a.c.a.a rL = fVar.rL();
            rL.KC = 2212;
            rL.errMsg = "duplicated download task";
            rL.Zm = a.C0056a.C0057a.Zc;
            fVar.rM().onDownloading(new com.baidu.b.a.b.b.a(fVar.getPackageName(), rL.KC, rL.errMsg, rL.Zm));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void e(f fVar) {
        fVar.aH(false);
        this.aae.h(fVar);
    }

    public synchronized void f(f fVar) {
        boolean k = this.aae.k(fVar);
        this.aae.j(fVar);
        fVar.bH(12);
        com.baidu.b.a.b.b.a aVar = new com.baidu.b.a.b.b.a(fVar.getPackageName(), 2211, "download : customer cancel download", a.C0056a.C0057a.Zb);
        if (!k) {
            fVar.rM().onFileCancel(aVar);
        }
    }

    public synchronized void a(com.baidu.b.a.f.d.a.a aVar) {
        this.aae.c(aVar);
    }

    public synchronized void b(com.baidu.b.a.f.d.a.a aVar) {
        this.aae.d(aVar);
    }
}
