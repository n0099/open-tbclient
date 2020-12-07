package com.baidu.swan.gamecenter.appmanager.install;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download dVl;
    private JSONObject dVm;
    private C0535c dVn = new C0535c();
    private com.baidu.swan.gamecenter.appmanager.b.b dVo;

    public c(Download download, JSONObject jSONObject) {
        this.dVl = download;
        this.dVm = jSONObject;
    }

    public void b(com.baidu.swan.gamecenter.appmanager.b.b bVar) {
        this.dVo = bVar;
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new b(this.dVl, this.dVm, this.dVn));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        if (this.dVo != null) {
            this.dVo.a(bVar);
        }
        if (bVar != null && !bVar.aUN()) {
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dVl.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dVm));
        }
        if (this.dVn != null) {
            com.baidu.swan.gamecenter.appmanager.a.aUm().e(this.dVl.getKeyByUser(), this.dVn);
            this.dVn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class b implements Runnable {
        private JSONObject dUQ;
        private com.baidu.swan.gamecenter.appmanager.b.a dVj;
        private Download dVl;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.gamecenter.appmanager.b.a aVar) {
            this.dVl = download;
            this.dUQ = jSONObject;
            this.dVj = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.gamecenter.appmanager.a.aUm().ch(this.dUQ);
            com.baidu.swan.gamecenter.appmanager.d.c.a(this.dVl.getKeyByUser(), "installApp", null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dUQ));
            com.baidu.swan.gamecenter.appmanager.a.aUm().a(this.dVl.getUrl(), this.dVj);
        }
    }

    /* renamed from: com.baidu.swan.gamecenter.appmanager.install.c$c  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C0535c implements com.baidu.swan.gamecenter.appmanager.b.a {
        private String mFilePath;
        private String mPackageName;

        public C0535c() {
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
            com.baidu.swan.gamecenter.appmanager.a.aUm().wv(this.mFilePath);
            com.baidu.swan.gamecenter.appmanager.a.aUm().aUq();
        }
    }
}
