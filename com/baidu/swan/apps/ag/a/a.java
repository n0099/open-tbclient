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
/* loaded from: classes11.dex */
public class a extends j {
    private b<Boolean> bId;
    private String bIe;
    private String bIf;
    private c<h> bIg = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ag.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String K(h hVar) {
            return e.d.TQ().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void I(h hVar) {
            super.I(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download start: bundleId = " + hVar.cAZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void J(h hVar) {
            super.J(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.bId.F(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(h hVar) {
            super.G(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ag.d.a.print("download finish, plugin is null");
                a.this.bId.F(false);
            } else if (!ab.d(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ag.d.a.print("download finish, check zip sign failure");
                a.this.bId.F(false);
            } else {
                File aI = e.aI(hVar.cAZ, String.valueOf(com.baidu.swan.apps.swancore.b.mp(hVar.versionName)));
                com.baidu.swan.d.c.ensureDirectoryExist(aI);
                if (aI == null || !aI.exists()) {
                    com.baidu.swan.apps.ag.d.a.print("download finish, create file failure, name = " + hVar.cAZ + " ; version = " + hVar.versionCode);
                    a.this.bId.F(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, aI.getAbsolutePath());
                hVar.createTime = hVar.atJ();
                hVar.updateTime = hVar.atJ();
                com.baidu.swan.pms.database.a.atv().c(hVar);
                com.baidu.swan.d.c.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ag.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.bId.F(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.bId = bVar;
        this.bIe = str;
        this.bIf = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pm() {
        super.Pm();
        com.baidu.swan.apps.ag.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        h cd;
        super.a(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (cd = com.baidu.swan.pms.database.a.atv().cd(this.bIe, this.bIf)) != null) {
                cd.updateTime = cd.atJ();
                com.baidu.swan.pms.database.a.atv().g(cd);
            }
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error");
        }
        this.bId.F(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pi() {
        super.Pi();
        com.baidu.swan.apps.ag.d.a.print("no package");
        this.bId.F(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aad() {
        return this.bIg;
    }
}
