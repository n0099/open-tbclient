package com.baidu.swan.apps.ad.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.core.f.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.f.f;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    private b<Boolean> czG;
    private String czH;
    private String czI;
    private c<h> czJ = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ad.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String P(h hVar) {
            return d.C0380d.ahd().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void N(h hVar) {
            super.N(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ad.d.a.print("plugin download start: bundleId = " + hVar.dvZ);
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
                com.baidu.swan.apps.ad.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.czG.J(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(h hVar) {
            super.L(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ad.d.a.print("download finish, plugin is null");
                a.this.czG.J(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ad.d.a.print("download finish, check zip sign failure");
                a.this.czG.J(false);
            } else {
                File bn = d.bn(hVar.dvZ, String.valueOf(com.baidu.swan.apps.swancore.b.qb(hVar.versionName)));
                com.baidu.swan.d.d.ensureDirectoryExist(bn);
                if (bn == null || !bn.exists()) {
                    com.baidu.swan.apps.ad.d.a.print("download finish, create file failure, name = " + hVar.dvZ + " ; version = " + hVar.versionCode);
                    a.this.czG.J(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.d.d.unzipFile(hVar.filePath, bn.getAbsolutePath());
                hVar.createTime = hVar.aLh();
                hVar.updateTime = hVar.aLh();
                com.baidu.swan.pms.database.a.aKS().c(hVar);
                com.baidu.swan.d.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ad.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.czG.J(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.czG = bVar;
        this.czH = str;
        this.czI = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
        com.baidu.swan.apps.ad.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h cP;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (cP = com.baidu.swan.pms.database.a.aKS().cP(this.czH, this.czI)) != null) {
                cP.updateTime = cP.aLh();
                com.baidu.swan.pms.database.a.aKS().g(cP);
            }
            com.baidu.swan.apps.ad.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ad.d.a.print("fetch plugin error");
        }
        this.czG.J(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        com.baidu.swan.apps.ad.d.a.print("no package");
        this.czG.J(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aoG() {
        return this.czJ;
    }
}
