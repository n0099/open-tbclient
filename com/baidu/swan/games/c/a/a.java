package com.baidu.swan.games.c.a;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.e.d;
import com.baidu.swan.games.l.a;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.f.e;
import com.baidu.swan.pms.model.h;
import java.io.File;
import java.util.Set;
/* loaded from: classes11.dex */
public class a extends j {
    private static final boolean DEBUG = b.DEBUG;
    @NonNull
    private com.baidu.swan.games.c.b cWq;
    @NonNull
    private com.baidu.swan.games.c.b.a cWr;
    private c<h> csv = new com.baidu.swan.pms.a.b<h>() { // from class: com.baidu.swan.games.c.a.a.1
        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: a */
        public String P(h hVar) {
            return a.c.aeL().getPath();
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
            a.this.cWq.dw(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: d */
        public void L(h hVar) {
            super.L(hVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!ac.e(new File(hVar.filePath), hVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.cWq.dw(false);
                return;
            }
            File XK = a.this.cWr.XK();
            if (XK.exists()) {
                d.deleteFile(XK);
            } else {
                d.ensureDirectoryExist(XK);
            }
            boolean unzipFile = d.unzipFile(hVar.filePath, XK.getAbsolutePath());
            if (unzipFile) {
                a.this.cWr.jg(hVar.versionName);
            }
            d.deleteFile(hVar.filePath);
            a.this.cWq.dw(unzipFile);
        }
    };

    public a(@NonNull com.baidu.swan.games.c.b.a aVar, @NonNull com.baidu.swan.games.c.b bVar) {
        this.cWq = bVar;
        this.cWr = aVar;
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZP() {
        super.ZP();
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
        this.cWq.dw(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void ZL() {
        super.ZL();
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.cWq.dw(false);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public c<h> alR() {
        return this.csv;
    }
}
