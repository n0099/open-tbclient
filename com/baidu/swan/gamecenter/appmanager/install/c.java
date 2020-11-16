package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dOn;
    private JSONObject dOo;
    private C0523c dOp = new C0523c();
    private com.baidu.swan.gamecenter.appmanager.b.b dOq;

    public c(Download download, JSONObject jSONObject) {
        this.dOn = download;
        this.dOo = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dOq = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dOn, this.dOo, this.dOp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dOq != null) {
            this.dOq.a(bVar);
        }
        if (bVar != null && !bVar.aRI()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dOn.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dOo));
        }
        if (this.dOp != null) {
            com.baidu.swan.gamecenter.appmanager.a.aRh().e(this.dOn.getKeyByUser(), this.dOp);
            this.dOp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class b implements Runnable {
        private JSONObject dNS;
        private com.baidu.swan.gamecenter.appmanager.b.a dOl;
        private Download dOn;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dOn = download;
            this.dNS = jSONObject;
            this.dOl = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aRh().cf(this.dNS);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dOn.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
            com.baidu.swan.gamecenter.appmanager.a.aRh().a(this.dOn.getUrl(), this.dOl);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0523c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0523c() {
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

    /* loaded from: classes16.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aRh().vO(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aRh().aRl();
        }
    }
}
