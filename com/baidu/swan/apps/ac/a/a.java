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
/* loaded from: classes9.dex */
public class a extends j {
    private b<Boolean> duJ;
    private String duK;
    private String duL;
    private c<h> duM = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String U(h hVar) {
            return d.C0466d.aAl().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void S(h hVar) {
            super.S(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.ewI);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void T(h hVar) {
            super.T(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.duJ.N(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(h hVar) {
            super.Q(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.duJ.N(false);
            } else if (!ae.f(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.duJ.N(false);
            } else {
                File bP = d.bP(hVar.ewI, String.valueOf(com.baidu.swan.apps.swancore.b.uo(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(bP);
                if (bP == null || !bP.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.ewI + " ; version = " + hVar.versionCode);
                    a.this.duJ.N(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, bP.getAbsolutePath());
                hVar.createTime = hVar.bgn();
                hVar.updateTime = hVar.bgn();
                com.baidu.swan.pms.database.a.bgb().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.duJ.N(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.duJ = bVar;
        this.duK = str;
        this.duL = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aud() {
        super.aud();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h dw;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (dw = com.baidu.swan.pms.database.a.bgb().dw(this.duK, this.duL)) != null) {
                dw.updateTime = dw.bgn();
                com.baidu.swan.pms.database.a.bgb().g(dw);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.duJ.N(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void arc() {
        super.arc();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.duJ.N(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aIk() {
        return this.duM;
    }
}
