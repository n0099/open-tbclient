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
    private b<Boolean> cgX;
    private String cgY;
    private String cgZ;
    private c<h> cha = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ag.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String L(h hVar) {
            return e.d.abI().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void J(h hVar) {
            super.J(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download start: bundleId = " + hVar.dai);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void K(h hVar) {
            super.K(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.cgX.G(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void H(h hVar) {
            super.H(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ag.d.a.print("download finish, plugin is null");
                a.this.cgX.G(false);
            } else if (!ab.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ag.d.a.print("download finish, check zip sign failure");
                a.this.cgX.G(false);
            } else {
                File aQ = e.aQ(hVar.dai, String.valueOf(com.baidu.swan.apps.swancore.b.nB(hVar.versionName)));
                com.baidu.swan.d.c.ensureDirectoryExist(aQ);
                if (aQ == null || !aQ.exists()) {
                    com.baidu.swan.apps.ag.d.a.print("download finish, create file failure, name = " + hVar.dai + " ; version = " + hVar.versionCode);
                    a.this.cgX.G(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, aQ.getAbsolutePath());
                hVar.createTime = hVar.aBW();
                hVar.updateTime = hVar.aBW();
                com.baidu.swan.pms.database.a.aBI().c(hVar);
                com.baidu.swan.d.c.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ag.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.cgX.G(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.cgX = bVar;
        this.cgY = str;
        this.cgZ = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xe() {
        super.Xe();
        com.baidu.swan.apps.ag.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        h cn;
        super.a(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (cn = com.baidu.swan.pms.database.a.aBI().cn(this.cgY, this.cgZ)) != null) {
                cn.updateTime = cn.aBW();
                com.baidu.swan.pms.database.a.aBI().g(cn);
            }
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error");
        }
        this.cgX.G(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xa() {
        super.Xa();
        com.baidu.swan.apps.ag.d.a.print("no package");
        this.cgX.G(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> ail() {
        return this.cha;
    }
}
