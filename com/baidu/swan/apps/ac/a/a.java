package com.baidu.swan.apps.ac.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.b;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.utils.f;
import java.io.File;
import java.util.Set;
/* loaded from: classes10.dex */
public class a extends j {
    private c<h> deA = new b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String U(h hVar) {
            return d.C0452d.atU().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void S(h hVar) {
            super.S(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.ebO);
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
            a.this.dex.O(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(h hVar) {
            super.Q(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.dex.O(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.dex.O(false);
            } else {
                File bK = d.bK(hVar.ebO, String.valueOf(com.baidu.swan.apps.swancore.b.tB(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(bK);
                if (bK == null || !bK.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.ebO + " ; version = " + hVar.versionCode);
                    a.this.dex.O(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, bK.getAbsolutePath());
                hVar.createTime = hVar.aYT();
                hVar.updateTime = hVar.aYT();
                com.baidu.swan.pms.database.a.aYH().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.dex.O(Boolean.valueOf(unzipFile));
            }
        }
    };
    private com.baidu.swan.apps.core.f.b<Boolean> dex;
    private String dey;
    private String dez;

    public a(String str, String str2, com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        this.dex = bVar;
        this.dey = str;
        this.dez = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h dr;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (dr = com.baidu.swan.pms.database.a.aYH().dr(this.dey, this.dez)) != null) {
                dr.updateTime = dr.aYT();
                com.baidu.swan.pms.database.a.aYH().g(dr);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.dex.O(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void akQ() {
        super.akQ();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.dex.O(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aBR() {
        return this.deA;
    }
}
