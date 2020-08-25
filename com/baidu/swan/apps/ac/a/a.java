package com.baidu.swan.apps.ac.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.swan.apps.ap.ae;
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
    private b<Boolean> cHP;
    private String cHQ;
    private String cHR;
    private c<h> cHS = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String Q(h hVar) {
            return d.C0426d.aoD().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void O(h hVar) {
            super.O(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.dFj);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void P(h hVar) {
            super.P(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.cHP.K(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void M(h hVar) {
            super.M(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.cHP.K(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.cHP.K(false);
            } else {
                File by = d.by(hVar.dFj, String.valueOf(com.baidu.swan.apps.swancore.b.sb(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(by);
                if (by == null || !by.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.dFj + " ; version = " + hVar.versionCode);
                    a.this.cHP.K(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, by.getAbsolutePath());
                hVar.createTime = hVar.aTF();
                hVar.updateTime = hVar.aTF();
                com.baidu.swan.pms.database.a.aTt().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.cHP.K(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.cHP = bVar;
        this.cHQ = str;
        this.cHR = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        super.aiw();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h df;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (df = com.baidu.swan.pms.database.a.aTt().df(this.cHQ, this.cHR)) != null) {
                df.updateTime = df.aTF();
                com.baidu.swan.pms.database.a.aTt().g(df);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.cHP.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.cHP.K(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> awD() {
        return this.cHS;
    }
}
