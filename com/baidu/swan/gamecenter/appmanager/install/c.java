package com.baidu.swan.gamecenter.appmanager.install;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download ede;
    private JSONObject edf;
    private C0514c edg = new C0514c();
    private com.baidu.swan.gamecenter.appmanager.b.b edh;

    public c(Download download, JSONObject jSONObject) {
        this.ede = download;
        this.edf = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.edh = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.ede, this.edf, this.edg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.edh != null) {
            this.edh.a(bVar);
        }
        if (bVar != null && !bVar.aTD()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ede.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.edf));
        }
        if (this.edg != null) {
            com.baidu.swan.gamecenter.appmanager.a.aTc().e(this.ede.getKeyByUser(), this.edg);
            this.edg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private JSONObject ecJ;
        private com.baidu.swan.gamecenter.appmanager.b.a edc;
        private Download ede;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.ede = download;
            this.ecJ = jSONObject;
            this.edc = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aTc().co(this.ecJ);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ede.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ecJ));
            com.baidu.swan.gamecenter.appmanager.a.aTc().a(this.ede.getUrl(), this.edc);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0514c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0514c() {
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

    /* loaded from: classes14.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aTc().vJ(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aTc().aTg();
        }
    }
}
