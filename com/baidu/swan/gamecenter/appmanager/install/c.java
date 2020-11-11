package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dPV;
    private JSONObject dPW;
    private C0525c dPX = new C0525c();
    private com.baidu.swan.gamecenter.appmanager.b.b dPY;

    public c(Download download, JSONObject jSONObject) {
        this.dPV = download;
        this.dPW = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dPY = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dPV, this.dPW, this.dPX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dPY != null) {
            this.dPY.a(bVar);
        }
        if (bVar != null && !bVar.aSq()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dPV.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dPW));
        }
        if (this.dPX != null) {
            com.baidu.swan.gamecenter.appmanager.a.aRP().e(this.dPV.getKeyByUser(), this.dPX);
            this.dPX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        private JSONObject dPA;
        private com.baidu.swan.gamecenter.appmanager.b.a dPT;
        private Download dPV;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dPV = download;
            this.dPA = jSONObject;
            this.dPT = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aRP().cl(this.dPA);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dPV.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dPA));
            com.baidu.swan.gamecenter.appmanager.a.aRP().a(this.dPV.getUrl(), this.dPT);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0525c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0525c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aRP().vT(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aRP().aRT();
        }
    }
}
