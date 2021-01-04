package com.baidu.swan.gamecenter.appmanager.install;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download eei;
    private JSONObject eej;
    private C0528c eek = new C0528c();
    private com.baidu.swan.gamecenter.appmanager.b.b eel;

    public c(Download download, JSONObject jSONObject) {
        this.eei = download;
        this.eej = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.eel = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.eei, this.eej, this.eek));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.eel != null) {
            this.eel.a(bVar);
        }
        if (bVar != null && !bVar.aXh()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.eei.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.eej));
        }
        if (this.eek != null) {
            com.baidu.swan.gamecenter.appmanager.a.aWG().e(this.eei.getKeyByUser(), this.eek);
            this.eek = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private JSONObject edN;
        private com.baidu.swan.gamecenter.appmanager.b.a eeg;
        private Download eei;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.eei = download;
            this.edN = jSONObject;
            this.eeg = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aWG().cp(this.edN);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.eei.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
            com.baidu.swan.gamecenter.appmanager.a.aWG().a(this.eei.getUrl(), this.eeg);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0528c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0528c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aWG().wu(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aWG().aWK();
        }
    }
}
