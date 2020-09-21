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
/* loaded from: classes3.dex */
public class a extends j {
    private b<Boolean> cJT;
    private String cJU;
    private String cJV;
    private c<h> cJW = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String R(h hVar) {
            return d.C0421d.apo().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void P(h hVar) {
            super.P(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.dHr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void Q(h hVar) {
            super.Q(hVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (aVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download error: " + aVar.toString());
            }
            a.this.cJT.L(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void N(h hVar) {
            super.N(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.cJT.L(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.cJT.L(false);
            } else {
                File by = d.by(hVar.dHr, String.valueOf(com.baidu.swan.apps.swancore.b.sw(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(by);
                if (by == null || !by.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.dHr + " ; version = " + hVar.versionCode);
                    a.this.cJT.L(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, by.getAbsolutePath());
                hVar.createTime = hVar.aUr();
                hVar.updateTime = hVar.aUr();
                com.baidu.swan.pms.database.a.aUf().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.cJT.L(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.cJT = bVar;
        this.cJU = str;
        this.cJV = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ajg() {
        super.ajg();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h df;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (df = com.baidu.swan.pms.database.a.aUf().df(this.cJU, this.cJV)) != null) {
                df.updateTime = df.aUr();
                com.baidu.swan.pms.database.a.aUf().g(df);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.cJT.L(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void agl() {
        super.agl();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.cJT.L(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> axm() {
        return this.cJW;
    }
}
