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
/* loaded from: classes10.dex */
public class a extends j {
    private b<Boolean> bDW;
    private String bDX;
    private String bDY;
    private c<h> bDZ = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ag.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String I(h hVar) {
            return e.d.RA().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void G(h hVar) {
            super.G(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ag.d.a.print("plugin download start: bundleId = " + hVar.cwZ);
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
            a.this.bDW.D(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void E(h hVar) {
            super.E(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ag.d.a.print("download finish, plugin is null");
                a.this.bDW.D(false);
            } else if (!ab.d(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ag.d.a.print("download finish, check zip sign failure");
                a.this.bDW.D(false);
            } else {
                File ay = e.ay(hVar.cwZ, String.valueOf(com.baidu.swan.apps.swancore.b.ma(hVar.versionName)));
                com.baidu.swan.d.c.ensureDirectoryExist(ay);
                if (ay == null || !ay.exists()) {
                    com.baidu.swan.apps.ag.d.a.print("download finish, create file failure, name = " + hVar.cwZ + " ; version = " + hVar.versionCode);
                    a.this.bDW.D(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, ay.getAbsolutePath());
                hVar.createTime = hVar.art();
                hVar.updateTime = hVar.art();
                com.baidu.swan.pms.database.a.arf().c(hVar);
                com.baidu.swan.d.c.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ag.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.bDW.D(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.bDW = bVar;
        this.bDX = str;
        this.bDY = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void MW() {
        super.MW();
        com.baidu.swan.apps.ag.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        h bU;
        super.a(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (bU = com.baidu.swan.pms.database.a.arf().bU(this.bDX, this.bDY)) != null) {
                bU.updateTime = bU.art();
                com.baidu.swan.pms.database.a.arf().g(bU);
            }
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ag.d.a.print("fetch plugin error");
        }
        this.bDW.D(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void MS() {
        super.MS();
        com.baidu.swan.apps.ag.d.a.print("no package");
        this.bDW.D(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.f.e eVar) {
        super.a(eVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> XN() {
        return this.bDZ;
    }
}
