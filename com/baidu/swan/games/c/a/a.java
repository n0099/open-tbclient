package com.baidu.swan.games.c.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.c.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.model.h;
import com.baidu.swan.pms.utils.f;
import java.io.File;
import java.util.Set;
/* loaded from: classes10.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    @NonNull
    private com.baidu.swan.games.c.b dTs;
    @NonNull
    private com.baidu.swan.games.c.b.a dTt;
    private c<h> dkv = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.c.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String U(h hVar) {
            return a.c.awu().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void S(h hVar) {
            super.S(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void T(h hVar) {
            super.T(hVar);
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
            a.this.dTs.eF(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void Q(h hVar) {
            super.Q(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.dTs.eF(false);
                return;
            }
            File anG = a.this.dTt.anG();
            if (anG.exists()) {
                d.deleteFile(anG);
            } else {
                d.ensureDirectoryExist(anG);
            }
            boolean unzipFile = d.unzipFile(hVar.filePath, anG.getAbsolutePath());
            if (unzipFile) {
                a.this.dTt.mQ(hVar.versionName);
            }
            d.deleteFile(hVar.filePath);
            a.this.dTs.eF(unzipFile);
        }
    };

    public a(@NonNull com.baidu.swan.games.c.b.a aVar, @NonNull com.baidu.swan.games.c.b bVar) {
        this.dTs = bVar;
        this.dTt = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqm() {
        super.aqm();
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
        this.dTs.eF(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.dTs.eF(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aEr() {
        return this.dkv;
    }
}
