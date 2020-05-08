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
    @NonNull
    private com.baidu.swan.games.b.b cLD;
    @NonNull
    private com.baidu.swan.games.b.b.a cLE;
    private c<h> chg = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.b.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String M(h hVar) {
            return a.c.abH().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void K(h hVar) {
            super.K(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void L(h hVar) {
            super.L(hVar);
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
            a.this.cLD.dj(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void I(h hVar) {
            super.I(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ab.e(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.cLD.dj(false);
                return;
            }
            File Ve = a.this.cLE.Ve();
            if (Ve.exists()) {
                com.baidu.swan.d.c.deleteFile(Ve);
            } else {
                com.baidu.swan.d.c.ensureDirectoryExist(Ve);
            }
            boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, Ve.getAbsolutePath());
            if (unzipFile) {
                a.this.cLE.mo26if(hVar.versionName);
            }
            com.baidu.swan.d.c.deleteFile(hVar.filePath);
            a.this.cLD.dj(unzipFile);
        }
    };

    public a(@NonNull com.baidu.swan.games.b.b.a aVar, @NonNull com.baidu.swan.games.b.b bVar) {
        this.cLD = bVar;
        this.cLE = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void Xd() {
        super.Xd();
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
        this.cLD.dj(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void WZ() {
        super.WZ();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.cLD.dj(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> aik() {
        return this.chg;
    }
}
