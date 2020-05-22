package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download cSU;
    private JSONObject cSV;
    private C0406c cSW = new C0406c();
    private com.baidu.swan.b.a.d.b cSX;

    public c(Download download, JSONObject jSONObject) {
        this.cSU = download;
        this.cSV = jSONObject;
    }

    public void b(com.baidu.swan.b.a.d.b bVar) {
        this.cSX = bVar;
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new b(this.cSU, this.cSV, this.cSW));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.b.a.e.b bVar) {
        if (this.cSX != null) {
            this.cSX.a(bVar);
        }
        if (bVar != null && !bVar.axc()) {
            com.baidu.swan.b.a.f.c.a(this.cSU.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cSV));
        }
        if (this.cSW != null) {
            com.baidu.swan.b.a.a.awP().e(this.cSU.getKeyByUser(), this.cSW);
            this.cSW = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private JSONObject cSC;
        private com.baidu.swan.b.a.d.a cSS;
        private Download cSU;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cSU = download;
            this.cSC = jSONObject;
            this.cSS = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.awP().bA(this.cSC);
            com.baidu.swan.b.a.f.c.a(this.cSU.getKeyByUser(), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cSC));
            com.baidu.swan.b.a.a.awP().a(this.cSU.getUrl(), this.cSS);
        }
    }

    /* renamed from: com.baidu.swan.b.a.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0406c implements com.baidu.swan.b.a.d.a {
        private String mFilePath;
        private String mPackageName;

        public C0406c() {
        }

        @Override // com.baidu.swan.b.a.d.b
        public void a(com.baidu.swan.b.a.e.b bVar) {
            if (c.DEBUG) {
                Log.d("InstallAppLocal", "onResult mPackageName:" + this.mPackageName);
            }
            c.this.b(bVar);
            com.baidu.swan.b.a.a.a.sExecutorService.execute(new a(this.mFilePath));
        }

        @Override // com.baidu.swan.b.a.d.a
        public void setPackageName(String str) {
            this.mPackageName = str;
        }

        @Override // com.baidu.swan.b.a.d.a
        public void setFilePath(String str) {
            this.mFilePath = str;
        }
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private String mFilePath;

        private a(String str) {
            this.mFilePath = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.awP().qK(this.mFilePath);
            com.baidu.swan.b.a.a.awP().awR();
        }
    }
}
