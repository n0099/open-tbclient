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
    private b<Boolean> cxg;
    private String cxh;
    private String cxi;
    private c<h> cxj = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ae.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String P(h hVar) {
            return e.d.afR().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void N(h hVar) {
            super.N(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ae.d.a.print("plugin download start: bundleId = " + hVar.dqi);
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
            a.this.cxg.K(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(h hVar) {
            super.L(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ae.d.a.print("download finish, plugin is null");
                a.this.cxg.K(false);
            } else if (!ac.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ae.d.a.print("download finish, check zip sign failure");
                a.this.cxg.K(false);
            } else {
                File bj = e.bj(hVar.dqi, String.valueOf(com.baidu.swan.apps.swancore.b.pq(hVar.versionName)));
                d.ensureDirectoryExist(bj);
                if (bj == null || !bj.exists()) {
                    com.baidu.swan.apps.ae.d.a.print("download finish, create file failure, name = " + hVar.dqi + " ; version = " + hVar.versionCode);
                    a.this.cxg.K(false);
                    return;
                }
                boolean unzipFile = d.unzipFile(hVar.filePath, bj.getAbsolutePath());
                hVar.createTime = hVar.aHq();
                hVar.updateTime = hVar.aHq();
                com.baidu.swan.pms.database.a.aHb().c(hVar);
                d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ae.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.cxg.K(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.cxg = bVar;
        this.cxh = str;
        this.cxi = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaV() {
        super.aaV();
        com.baidu.swan.apps.ae.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h cM;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (cM = com.baidu.swan.pms.database.a.aHb().cM(this.cxh, this.cxi)) != null) {
                cM.updateTime = cM.aHq();
                com.baidu.swan.pms.database.a.aHb().g(cM);
            }
            com.baidu.swan.apps.ae.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ae.d.a.print("fetch plugin error");
        }
        this.cxg.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aaR() {
        super.aaR();
        com.baidu.swan.apps.ae.d.a.print("no package");
        this.cxg.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> amX() {
        return this.cxj;
    }
}
