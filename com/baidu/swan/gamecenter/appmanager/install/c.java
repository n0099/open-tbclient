package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dpC;
    private JSONObject dpD;
    private C0482c dpE = new C0482c();
    private com.baidu.swan.gamecenter.appmanager.b.b dpF;

    public c(Download download, JSONObject jSONObject) {
        this.dpC = download;
        this.dpD = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dpF = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dpC, this.dpD, this.dpE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dpF != null) {
            this.dpF.a(bVar);
        }
        if (bVar != null && !bVar.aLn()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dpC.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dpD));
        }
        if (this.dpE != null) {
            com.baidu.swan.gamecenter.appmanager.a.aKM().e(this.dpC.getKeyByUser(), this.dpE);
            this.dpE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class b implements Runnable {
        private com.baidu.swan.gamecenter.appmanager.b.a dpA;
        private Download dpC;
        private JSONObject dph;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dpC = download;
            this.dph = jSONObject;
            this.dpA = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aKM().bV(this.dph);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dpC.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
            com.baidu.swan.gamecenter.appmanager.a.aKM().a(this.dpC.getUrl(), this.dpA);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C0482c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0482c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aKM().uA(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aKM().aKQ();
        }
    }
}
