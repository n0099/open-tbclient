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
/* loaded from: classes25.dex */
public class a extends j {
    private b<Boolean> dpK;
    private String dpL;
    private String dpM;
    private c<h> dpN = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.apps.ac.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String U(h hVar) {
            return d.C0474d.ayU().getAbsolutePath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void S(h hVar) {
            super.S(hVar);
            if (hVar != null) {
                com.baidu.swan.apps.ac.d.a.print("plugin download start: bundleId = " + hVar.emZ);
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
            a.this.dpK.O(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(h hVar) {
            super.Q(hVar);
            if (hVar == null) {
                com.baidu.swan.apps.ac.d.a.print("download finish, plugin is null");
                a.this.dpK.O(false);
            } else if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                com.baidu.swan.apps.ac.d.a.print("download finish, check zip sign failure");
                a.this.dpK.O(false);
            } else {
                File bQ = d.bQ(hVar.emZ, String.valueOf(com.baidu.swan.apps.swancore.b.ur(hVar.versionName)));
                com.baidu.swan.c.d.ensureDirectoryExist(bQ);
                if (bQ == null || !bQ.exists()) {
                    com.baidu.swan.apps.ac.d.a.print("download finish, create file failure, name = " + hVar.emZ + " ; version = " + hVar.versionCode);
                    a.this.dpK.O(false);
                    return;
                }
                boolean unzipFile = com.baidu.swan.c.d.unzipFile(hVar.filePath, bQ.getAbsolutePath());
                hVar.createTime = hVar.bdR();
                hVar.updateTime = hVar.bdR();
                com.baidu.swan.pms.database.a.bdF().c(hVar);
                com.baidu.swan.c.d.deleteFile(hVar.filePath);
                com.baidu.swan.apps.ac.d.a.print("download finish, unZipSuccess = " + unzipFile);
                a.this.dpK.O(Boolean.valueOf(unzipFile));
            }
        }
    };

    public a(String str, String str2, b<Boolean> bVar) {
        this.dpK = bVar;
        this.dpL = str;
        this.dpM = str2;
    }

    @Override // com.baidu.swan.pms.a.g
    public void asM() {
        super.asM();
        com.baidu.swan.apps.ac.d.a.print("fetch plugin success");
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        h dx;
        super.b(aVar);
        if (aVar != null) {
            if (aVar.errorNo == 1010 && (dx = com.baidu.swan.pms.database.a.bdF().dx(this.dpL, this.dpM)) != null) {
                dx.updateTime = dx.bdR();
                com.baidu.swan.pms.database.a.bdF().g(dx);
            }
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error: " + aVar.toString());
        } else {
            com.baidu.swan.apps.ac.d.a.print("fetch plugin error");
        }
        this.dpK.O(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void apQ() {
        super.apQ();
        com.baidu.swan.apps.ac.d.a.print("no package");
        this.dpK.O(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aGR() {
        return this.dpN;
    }
}
