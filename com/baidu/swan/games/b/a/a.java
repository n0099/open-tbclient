package com.baidu.swan.games.b.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.as.ab;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.games.k.a;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<h> bIr = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.b.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String K(h hVar) {
            return a.c.TT().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void I(h hVar) {
            super.I(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void J(h hVar) {
            super.J(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(h hVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) hVar, aVar);
            if (a.DEBUG) {
                Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.cmB.cn(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void G(h hVar) {
            super.G(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ab.d(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.cmB.cn(false);
                return;
            }
            File Ns = a.this.cmC.Ns();
            if (Ns.exists()) {
                com.baidu.swan.d.c.deleteFile(Ns);
            } else {
                com.baidu.swan.d.c.ensureDirectoryExist(Ns);
            }
            boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, Ns.getAbsolutePath());
            if (unzipFile) {
                a.this.cmC.gR(hVar.versionName);
            }
            com.baidu.swan.d.c.deleteFile(hVar.filePath);
            a.this.cmB.cn(unzipFile);
        }
    };
    @NonNull
    private com.baidu.swan.games.b.b cmB;
    @NonNull
    private com.baidu.swan.games.b.b.a cmC;

    public a(@NonNull com.baidu.swan.games.b.b.a aVar, @NonNull com.baidu.swan.games.b.b bVar) {
        this.cmB = bVar;
        this.cmC = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pp() {
        super.Pp();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.cmB.cn(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Pl() {
        super.Pl();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.cmB.cn(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aag() {
        return this.bIr;
    }
}
