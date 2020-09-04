package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dnA;
    private JSONObject dnB;
    private C0487c dnC = new C0487c();
    private com.baidu.swan.gamecenter.appmanager.b.b dnD;

    public c(Download download, JSONObject jSONObject) {
        this.dnA = download;
        this.dnB = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dnD = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dnA, this.dnB, this.dnC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dnD != null) {
            this.dnD.a(bVar);
        }
        if (bVar != null && !bVar.aKC()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dnA.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dnB));
        }
        if (this.dnC != null) {
            com.baidu.swan.gamecenter.appmanager.a.aKb().e(this.dnA.getKeyByUser(), this.dnC);
            this.dnC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private Download dnA;
        private JSONObject dne;
        private com.baidu.swan.gamecenter.appmanager.b.a dny;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dnA = download;
            this.dne = jSONObject;
            this.dny = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aKb().bS(this.dne);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dnA.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
            com.baidu.swan.gamecenter.appmanager.a.aKb().a(this.dnA.getUrl(), this.dny);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0487c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0487c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aKb().uh(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aKb().aKf();
        }
    }
}
