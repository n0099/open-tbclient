package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dKd;
    private JSONObject dKe;
    private C0513c dKf = new C0513c();
    private com.baidu.swan.gamecenter.appmanager.b.b dKg;

    public c(Download download, JSONObject jSONObject) {
        this.dKd = download;
        this.dKe = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dKg = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dKd, this.dKe, this.dKf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dKg != null) {
            this.dKg.a(bVar);
        }
        if (bVar != null && !bVar.aPQ()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dKd.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dKe));
        }
        if (this.dKf != null) {
            com.baidu.swan.gamecenter.appmanager.a.aPp().e(this.dKd.getKeyByUser(), this.dKf);
            this.dKf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        private JSONObject dJI;
        private com.baidu.swan.gamecenter.appmanager.b.a dKb;
        private Download dKd;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dKd = download;
            this.dJI = jSONObject;
            this.dKb = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aPp().cf(this.dJI);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dKd.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
            com.baidu.swan.gamecenter.appmanager.a.aPp().a(this.dKd.getUrl(), this.dKb);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0513c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0513c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aPp().vF(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aPp().aPt();
        }
    }
}
