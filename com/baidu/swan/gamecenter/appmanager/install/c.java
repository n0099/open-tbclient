package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download ddn;
    private JSONObject ddo;
    private C0439c ddp = new C0439c();
    private com.baidu.swan.gamecenter.appmanager.b.b ddq;

    public c(Download download, JSONObject jSONObject) {
        this.ddn = download;
        this.ddo = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.ddq = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.ddn, this.ddo, this.ddp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.ddq != null) {
            this.ddq.a(bVar);
        }
        if (bVar != null && !bVar.aBN()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ddn.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.ddo));
        }
        if (this.ddp != null) {
            com.baidu.swan.gamecenter.appmanager.a.aBl().e(this.ddn.getKeyByUser(), this.ddp);
            this.ddp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class b implements Runnable {
        private JSONObject dcR;
        private com.baidu.swan.gamecenter.appmanager.b.a ddl;
        private Download ddn;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.ddn = download;
            this.dcR = jSONObject;
            this.ddl = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aBl().bM(this.dcR);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.ddn.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
            com.baidu.swan.gamecenter.appmanager.a.aBl().a(this.ddn.getUrl(), this.ddl);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C0439c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0439c() {
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

    /* loaded from: classes20.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aBl().rO(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aBl().aBp();
        }
    }
}
