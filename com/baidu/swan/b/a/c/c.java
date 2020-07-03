package com.baidu.swan.b.a.c;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.down.manage.Download;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Download cXE;
    private JSONObject cXF;
    private C0412c cXG = new C0412c();
    private com.baidu.swan.b.a.d.b cXH;

    public c(Download download, JSONObject jSONObject) {
        this.cXE = download;
        this.cXF = jSONObject;
    }

    public void b(com.baidu.swan.b.a.d.b bVar) {
        this.cXH = bVar;
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new b(this.cXE, this.cXF, this.cXG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.b.a.e.b bVar) {
        if (this.cXH != null) {
            this.cXH.a(bVar);
        }
        if (bVar != null && !bVar.ayi()) {
            com.baidu.swan.b.a.f.c.a(this.cXE.getKeyByUser(), "installApp", "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cXF));
        }
        if (this.cXG != null) {
            com.baidu.swan.b.a.a.axV().e(this.cXE.getKeyByUser(), this.cXG);
            this.cXG = null;
        }
    }

    /* loaded from: classes11.dex */
    private static class b implements Runnable {
        private com.baidu.swan.b.a.d.a cXC;
        private Download cXE;
        private JSONObject cXm;

        private b(@NonNull Download download, JSONObject jSONObject, @NonNull com.baidu.swan.b.a.d.a aVar) {
            this.cXE = download;
            this.cXm = jSONObject;
            this.cXC = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.swan.b.a.a.axV().bH(this.cXm);
            com.baidu.swan.b.a.f.c.a(this.cXE.getKeyByUser(), "installApp", null, null, new com.baidu.swan.b.a.f.a(this.cXm));
            com.baidu.swan.b.a.a.axV().a(this.cXE.getUrl(), this.cXC);
        }
    }

    /* renamed from: com.baidu.swan.b.a.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0412c implements com.baidu.swan.b.a.d.a {
        private String mFilePath;
        private String mPackageName;

        public C0412c() {
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
            com.baidu.swan.b.a.a.axV().qS(this.mFilePath);
            com.baidu.swan.b.a.a.axV().axX();
        }
    }
}
