package com.baidu.swan.games.c.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.d.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.f.f;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<h> czJ = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.c.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String P(h hVar) {
            return a.c.ahd().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void N(h hVar) {
            super.N(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void O(h hVar) {
            super.O(hVar);
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
            a.this.dgL.dE(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(h hVar) {
            super.L(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.dgL.dE(false);
                return;
            }
            File ZI = a.this.dgM.ZI();
            if (ZI.exists()) {
                d.deleteFile(ZI);
            } else {
                d.ensureDirectoryExist(ZI);
            }
            boolean unzipFile = d.unzipFile(hVar.filePath, ZI.getAbsolutePath());
            if (unzipFile) {
                a.this.dgM.jD(hVar.versionName);
            }
            d.deleteFile(hVar.filePath);
            a.this.dgL.dE(unzipFile);
        }
    };
    @NonNull
    private com.baidu.swan.games.c.b dgL;
    @NonNull
    private com.baidu.swan.games.c.b.a dgM;

    public a(@NonNull com.baidu.swan.games.c.b.a aVar, @NonNull com.baidu.swan.games.c.b bVar) {
        this.dgL = bVar;
        this.dgM = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void abX() {
        super.abX();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.dgL.dE(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Zs() {
        super.Zs();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.dgL.dE(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aoG() {
        return this.czJ;
    }
}
