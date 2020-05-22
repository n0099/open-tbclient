package com.baidu.swan.apps.ae.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.core.f.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.e.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private b<Boolean> css;
    private String cst;
    private String csu;
    private c<h> csv = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ae.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String P(h hVar) {
            return e.d.aeL().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void N(h hVar) {
            super.N(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ae.d.a.print("plugin download start: bundleId = " + hVar.dlx);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void O(h hVar) {
            super.O(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ae.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.css.K(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(h hVar) {
            super.L(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ae.d.a.print("download finish, plugin is null");
                a.this.css.K(false);
            } else if (!ac.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ae.d.a.print("download finish, check zip sign failure");
                a.this.css.K(false);
            } else {
                File bh = e.bh(hVar.dlx, String.valueOf(com.baidu.swan.apps.swancore.b.pi(hVar.versionName)));
                d.ensureDirectoryExist(bh);
                if (bh == null || !bh.exists()) {
                    com.baidu.swan.apps.ae.d.a.print("download finish, create file failure, name = " + hVar.dlx + " ; version = " + hVar.versionCode);
                    a.this.css.K(false);
                    return;
                }
                boolean unzipFile = d.unzipFile(hVar.filePath, bh.getAbsolutePath());
                hVar.createTime = hVar.aGk();
                hVar.updateTime = hVar.aGk();
                com.baidu.swan.pms.database.a.aFV().c(hVar);
                d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ae.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.css.K(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.css = bVar;
        this.cst = str;
        this.csu = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
        com.baidu.swan.apps.ae.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h cK;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (cK = com.baidu.swan.pms.database.a.aFV().cK(this.cst, this.csu)) != null) {
                cK.updateTime = cK.aGk();
                com.baidu.swan.pms.database.a.aFV().g(cK);
            }
            com.baidu.swan.apps.ae.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ae.d.a.print("fetch plugin error");
        }
        this.css.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        com.baidu.swan.apps.ae.d.a.print("no package");
        this.css.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> alR() {
        return this.csv;
    }
}
