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
    private b<Boolean> dpU;
    private String dpV;
    private String dpW;
    private c<h> dpX = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String U(h hVar) {
            return d.C0449d.aws().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void S(h hVar) {
            super.S(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.erV);
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
            a.this.dpU.N(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(h hVar) {
            super.Q(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.dpU.N(false);
            } else if (!ae.f(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.dpU.N(false);
            } else {
                File bO = d.bO(hVar.erV, String.valueOf(com.baidu.swan.apps.swancore.b.td(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(bO);
                if (bO == null || !bO.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.erV + " ; version = " + hVar.versionCode);
                    a.this.dpU.N(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, bO.getAbsolutePath());
                hVar.createTime = hVar.bcu();
                hVar.updateTime = hVar.bcu();
                com.baidu.swan.pms.database.a.bci().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.dpU.N(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.dpU = bVar;
        this.dpV = str;
        this.dpW = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqj() {
        super.aqj();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h dv;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (dv = com.baidu.swan.pms.database.a.bci().dv(this.dpV, this.dpW)) != null) {
                dv.updateTime = dv.bcu();
                com.baidu.swan.pms.database.a.bci().g(dv);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.dpU.N(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void ani() {
        super.ani();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.dpU.N(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aEr() {
        return this.dpX;
    }
}
