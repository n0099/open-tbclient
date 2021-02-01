package com.baidu.swan.gamecenter.appmanager.install;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download ebD;
    private JSONObject ebE;
    private C0508c ebF = new C0508c();
    private com.baidu.swan.gamecenter.appmanager.b.b ebG;

    public c(Download download, JSONObject jSONObject) {
        this.ebD = download;
        this.ebE = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.ebG = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.ebD, this.ebE, this.ebF));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.ebG != null) {
            this.ebG.a(bVar);
        }
        if (bVar != null && !bVar.aTA()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ebD.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.ebE));
        }
        if (this.ebF != null) {
            com.baidu.swan.gamecenter.appmanager.a.aSZ().e(this.ebD.getKeyByUser(), this.ebF);
            this.ebF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class b implements Runnable {
        private com.baidu.swan.gamecenter.appmanager.b.a ebB;
        private Download ebD;
        private JSONObject ebi;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.ebD = download;
            this.ebi = jSONObject;
            this.ebB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aSZ().cm(this.ebi);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ebD.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
            com.baidu.swan.gamecenter.appmanager.a.aSZ().a(this.ebD.getUrl(), this.ebB);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C0508c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0508c() {
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

    /* loaded from: classes15.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aSZ().vC(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aSZ().aTd();
        }
    }
}
