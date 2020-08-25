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
/* loaded from: classes8.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<h> cHS = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.c.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String Q(h hVar) {
            return a.c.aoD().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void O(h hVar) {
            super.O(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void P(h hVar) {
            super.P(hVar);
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
            a.this.dqU.dO(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void M(h hVar) {
            super.M(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ae.e(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.dqU.dO(false);
                return;
            }
            File afR = a.this.dqV.afR();
            if (afR.exists()) {
                d.deleteFile(afR);
            } else {
                d.ensureDirectoryExist(afR);
            }
            boolean unzipFile = d.unzipFile(hVar.filePath, afR.getAbsolutePath());
            if (unzipFile) {
                a.this.dqV.lc(hVar.versionName);
            }
            d.deleteFile(hVar.filePath);
            a.this.dqU.dO(unzipFile);
        }
    };
    @NonNull
    private com.baidu.swan.games.c.b dqU;
    @NonNull
    private com.baidu.swan.games.c.b.a dqV;

    public a(@NonNull com.baidu.swan.games.c.b.a aVar, @NonNull com.baidu.swan.games.c.b bVar) {
        this.dqU = bVar;
        this.dqV = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        super.aiw();
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
        this.dqU.dO(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void afB() {
        super.afB();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.dqU.dO(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(f fVar) {
        super.a(fVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> awD() {
        return this.cHS;
    }
}
