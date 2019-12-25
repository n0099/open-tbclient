package com.baidu.swan.apps.ag.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.core.f.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class a extends j {
    private b<Boolean> bDl;
    private String bDm;
    private String bDn;
    private c<h> bDo = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ag.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String I(h hVar) {
            return e.d.Re().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void G(h hVar) {
            super.G(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download start: bundleId = " + hVar.cwO);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void H(h hVar) {
            super.H(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.bDl.D(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void E(h hVar) {
            super.E(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ag.d.a.print("download finish, plugin is null");
                a.this.bDl.D(false);
            } else if (!ab.d(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ag.d.a.print("download finish, check zip sign failure");
                a.this.bDl.D(false);
            } else {
                File ax = e.ax(hVar.cwO, String.valueOf(com.baidu.swan.apps.swancore.b.lX(hVar.versionName)));
                com.baidu.swan.d.c.ensureDirectoryExist(ax);
                if (ax == null || !ax.exists()) {
                    com.baidu.swan.apps.ag.d.a.print("download finish, create file failure, name = " + hVar.cwO + " ; version = " + hVar.versionCode);
                    a.this.bDl.D(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, ax.getAbsolutePath());
                hVar.createTime = hVar.ara();
                hVar.updateTime = hVar.ara();
                com.baidu.swan.pms.database.a.aqM().c(hVar);
                com.baidu.swan.d.c.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ag.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.bDl.D(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.bDl = bVar;
        this.bDm = str;
        this.bDn = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void MA() {
        super.MA();
        com.baidu.swan.apps.ag.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        h bT;
        super.a(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (bT = com.baidu.swan.pms.database.a.aqM().bT(this.bDm, this.bDn)) != null) {
                bT.updateTime = bT.ara();
                com.baidu.swan.pms.database.a.aqM().g(bT);
            }
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error");
        }
        this.bDl.D(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        com.baidu.swan.apps.ag.d.a.print("no package");
        this.bDl.D(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> Xq() {
        return this.bDo;
    }
}
