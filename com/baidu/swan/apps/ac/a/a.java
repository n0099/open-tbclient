package com.baidu.swan.apps.ac.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ae;
import com.baidu.swan.apps.core.f.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.utils.f;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class a extends j {
    private b<Boolean> dtI;
    private String dtJ;
    private String dtK;
    private c<h> dtL = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String W(h hVar) {
            return d.C0452d.awT().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void U(h hVar) {
            super.U(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.evD);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void V(h hVar) {
            super.V(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.dtI.P(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void S(h hVar) {
            super.S(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.dtI.P(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.dtI.P(false);
            } else {
                File bI = d.bI(hVar.evD, String.valueOf(com.baidu.swan.apps.swancore.b.tD(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(bI);
                if (bI == null || !bI.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.evD + " ; version = " + hVar.versionCode);
                    a.this.dtI.P(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, bI.getAbsolutePath());
                hVar.createTime = hVar.bcJ();
                hVar.updateTime = hVar.bcJ();
                com.baidu.swan.pms.database.a.bcx().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.dtI.P(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.dtI = bVar;
        this.dtJ = str;
        this.dtK = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqK() {
        super.aqK();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h dp;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (dp = com.baidu.swan.pms.database.a.bcx().dp(this.dtJ, this.dtK)) != null) {
                dp.updateTime = dp.bcJ();
                com.baidu.swan.pms.database.a.bcx().g(dp);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.dtI.P(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void anJ() {
        super.anJ();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.dtI.P(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aEP() {
        return this.dtL;
    }
}
