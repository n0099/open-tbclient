package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dBG;
    private JSONObject dBH;
    private C0499c dBI = new C0499c();
    private com.baidu.swan.gamecenter.appmanager.b.b dBJ;

    public c(Download download, JSONObject jSONObject) {
        this.dBG = download;
        this.dBH = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dBJ = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dBG, this.dBH, this.dBI));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dBJ != null) {
            this.dBJ.a(bVar);
        }
        if (bVar != null && !bVar.aNW()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dBG.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dBH));
        }
        if (this.dBI != null) {
            com.baidu.swan.gamecenter.appmanager.a.aNv().e(this.dBG.getKeyByUser(), this.dBI);
            this.dBI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        private com.baidu.swan.gamecenter.appmanager.b.a dBE;
        private Download dBG;
        private JSONObject dBl;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dBG = download;
            this.dBl = jSONObject;
            this.dBE = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aNv().cc(this.dBl);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dBG.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
            com.baidu.swan.gamecenter.appmanager.a.aNv().a(this.dBG.getUrl(), this.dBE);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0499c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0499c() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            if (c.DEBUG) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.mPackageName);
            }
            c.this.b(bVar);
            com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new a(this.mFilePath));
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.a
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.a
        public void setFilePath(String str) {
            this.mFilePath = str;
        }
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aNv().vm(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aNv().aNz();
        }
    }
}
