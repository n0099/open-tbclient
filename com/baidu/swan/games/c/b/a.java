package com.baidu.swan.games.c.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.an.w;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.pms.g;
import com.baidu.swan.games.i.a;
import com.baidu.swan.pms.a.c;
import com.baidu.swan.pms.e.e;
import com.baidu.swan.pms.model.i;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends g {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.c.b bfj;
    private com.baidu.swan.pms.a.a<i> bft = new c<i>() { // from class: com.baidu.swan.games.c.b.a.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String gj() {
            return a.d.Du().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: a */
        public void F(i iVar) {
            super.F(iVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownloadCallback", "onDownloadStart: " + iVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: b */
        public void G(i iVar) {
            super.G(iVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownloadCallback", "onDownloading: 其它地方正在下载此包");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((AnonymousClass1) iVar, aVar);
            if (a.DEBUG) {
                Log.e("ConsoleJsDownloadCallback", "onDownloadError: " + aVar.toString());
            }
            a.this.bfj.cK(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void E(i iVar) {
            super.E(iVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownloadCallback", "onDownloadFinish: " + iVar.toString());
            }
            if (!w.b(new File(iVar.filePath), iVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownloadCallback", "onDownloadFinish: 校验签名失败");
                }
                a.this.bfj.cK(false);
                return;
            }
            File Qx = com.baidu.swan.games.c.a.b.Qv().Qx();
            if (Qx.exists()) {
                com.baidu.swan.c.a.deleteFile(Qx);
            }
            boolean bs = com.baidu.swan.c.a.bs(iVar.filePath, Qx.getAbsolutePath());
            if (bs) {
                com.baidu.swan.games.c.a.b.Qv().iU(iVar.versionName);
            }
            com.baidu.swan.c.a.deleteFile(iVar.filePath);
            a.this.bfj.cK(bs);
        }
    };

    public a(com.baidu.swan.games.c.b bVar) {
        this.bfj = bVar;
    }

    @Override // com.baidu.swan.pms.a.f
    public void AF() {
        super.AF();
        if (DEBUG) {
            Log.i("ConsoleJsDownloadCallback", "onFetchSuccess");
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(com.baidu.swan.pms.model.a aVar) {
        super.a(aVar);
        if (DEBUG) {
            Log.e("ConsoleJsDownloadCallback", "onFetchError: " + aVar.toString());
        }
        this.bfj.cK(false);
    }

    @Override // com.baidu.swan.pms.a.f
    public void AB() {
        super.AB();
        if (DEBUG) {
            Log.i("ConsoleJsDownloadCallback", "onNoPackage");
        }
        this.bfj.cK(false);
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownloadCallback", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<i> QG() {
        return this.bft;
    }
}
