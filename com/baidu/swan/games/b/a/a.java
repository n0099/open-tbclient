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
/* loaded from: classes9.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    private c<h> bDo = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.b.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String I(h hVar) {
            return a.c.Re().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: b */
        public void G(h hVar) {
            super.G(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: c */
        public void H(h hVar) {
            super.H(hVar);
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
            a.this.chW.ca(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void E(h hVar) {
            super.E(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ab.d(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.chW.ca(false);
                return;
            }
            File KC = a.this.chX.KC();
            if (KC.exists()) {
                com.baidu.swan.d.c.deleteFile(KC);
            } else {
                com.baidu.swan.d.c.ensureDirectoryExist(KC);
            }
            boolean unzipFile = com.baidu.swan.d.c.unzipFile(hVar.filePath, KC.getAbsolutePath());
            if (unzipFile) {
                a.this.chX.gA(hVar.versionName);
            }
            com.baidu.swan.d.c.deleteFile(hVar.filePath);
            a.this.chW.ca(unzipFile);
        }
    };
    @NonNull
    private com.baidu.swan.games.b.b chW;
    @NonNull
    private com.baidu.swan.games.b.b.a chX;

    public a(@NonNull com.baidu.swan.games.b.b.a aVar, @NonNull com.baidu.swan.games.b.b bVar) {
        this.chW = bVar;
        this.chX = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void MA() {
        super.MA();
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
        this.chW.ca(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void Mw() {
        super.Mw();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.chW.ca(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> Xq() {
        return this.bDo;
    }
}
