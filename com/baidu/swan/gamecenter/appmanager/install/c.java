package com.baidu.swan.gamecenter.appmanager.install;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dZw;
    private JSONObject dZx;
    private C0511c dZy = new C0511c();
    private com.baidu.swan.gamecenter.appmanager.b.b dZz;

    public c(Download download, JSONObject jSONObject) {
        this.dZw = download;
        this.dZx = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dZz = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dZw, this.dZx, this.dZy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dZz != null) {
            this.dZz.a(bVar);
        }
        if (bVar != null && !bVar.aTo()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dZw.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dZx));
        }
        if (this.dZy != null) {
            com.baidu.swan.gamecenter.appmanager.a.aSN().e(this.dZw.getKeyByUser(), this.dZy);
            this.dZy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private JSONObject dZb;
        private com.baidu.swan.gamecenter.appmanager.b.a dZu;
        private Download dZw;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dZw = download;
            this.dZb = jSONObject;
            this.dZu = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aSN().cp(this.dZb);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dZw.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
            com.baidu.swan.gamecenter.appmanager.a.aSN().a(this.dZw.getUrl(), this.dZu);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0511c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0511c() {
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

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aSN().vj(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aSN().aSR();
        }
    }
}
