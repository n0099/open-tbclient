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
    private com.baidu.swan.games.c.b bzm;
    private com.baidu.swan.pms.a.a<i> bzw = new c<i>() { // from class: com.baidu.swan.games.c.b.a.1
        @Override // com.baidu.swan.pms.a.d
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return a.this.a(bundle, set);
        }

        @Override // com.baidu.swan.pms.a.a
        public String getDownloadPath() {
            return a.d.Jb().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: a */
        public void D(i iVar) {
            super.D(iVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownloadCallback", "onDownloadStart: " + iVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: b */
        public void E(i iVar) {
            super.E(iVar);
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
            a.this.bzm.de(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c, com.baidu.swan.pms.a.a
        /* renamed from: c */
        public void C(i iVar) {
            super.C(iVar);
            if (a.DEBUG) {
                Log.i("ConsoleJsDownloadCallback", "onDownloadFinish: " + iVar.toString());
            }
            if (!w.b(new File(iVar.filePath), iVar.sign)) {
                if (a.DEBUG) {
                    Log.e("ConsoleJsDownloadCallback", "onDownloadFinish: 校验签名失败");
                }
                a.this.bzm.de(false);
                return;
            }
            File Wl = com.baidu.swan.games.c.a.b.Wj().Wl();
            if (Wl.exists()) {
                com.baidu.swan.c.a.deleteFile(Wl);
            }
            boolean bz = com.baidu.swan.c.a.bz(iVar.filePath, Wl.getAbsolutePath());
            if (bz) {
                com.baidu.swan.games.c.a.b.Wj().jG(iVar.versionName);
            }
            com.baidu.swan.c.a.deleteFile(iVar.filePath);
            a.this.bzm.de(bz);
        }
    };

    public a(com.baidu.swan.games.c.b bVar) {
        this.bzm = bVar;
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gm() {
        super.Gm();
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
        this.bzm.de(false);
    }

    @Override // com.baidu.swan.pms.a.f
    public void Gi() {
        super.Gi();
        if (DEBUG) {
            Log.i("ConsoleJsDownloadCallback", "onNoPackage");
        }
        this.bzm.de(false);
    }

    @Override // com.baidu.swan.pms.a.f
    public void a(e eVar) {
        super.a(eVar);
        if (DEBUG) {
            Log.i("ConsoleJsDownloadCallback", "onPrepareDownload");
        }
    }

    @Override // com.baidu.swan.pms.a.f
    public com.baidu.swan.pms.a.a<i> Wu() {
        return this.bzw;
    }
}
