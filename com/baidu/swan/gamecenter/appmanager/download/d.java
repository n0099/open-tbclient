package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dne;
    private String dnk;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dnk = bundle.getString("operation", "");
        this.dne = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aKb().bS(d.this.dne);
                String str = d.this.dnk;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1261560102:
                        if (str.equals("queryStatus")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -625158317:
                        if (str.equals("deleteDownload")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -606050596:
                        if (str.equals("resumeAllDownload")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -534830837:
                        if (str.equals("queryAllStatus")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -451216226:
                        if (str.equals("pauseDownload")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -417021581:
                        if (str.equals("pauseAllDownload")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 184711125:
                        if (str.equals("resumeDownload")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1554935562:
                        if (str.equals("startDownload")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        d.this.bT(parseString);
                        return;
                    case 1:
                        d.this.bU(parseString);
                        return;
                    case 2:
                        d.this.aKr();
                        return;
                    case 3:
                        d.this.bV(parseString);
                        return;
                    case 4:
                        d.this.bX(parseString);
                        return;
                    case 5:
                        d.this.bW(parseString);
                        return;
                    case 6:
                        d.this.aKs();
                        return;
                    case 7:
                        d.this.aKt();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
        com.baidu.swan.gamecenter.appmanager.a.aKb().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aKb().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKr() {
        com.baidu.swan.gamecenter.appmanager.a.aKb().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
        com.baidu.swan.gamecenter.appmanager.a.aKb().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
        com.baidu.swan.gamecenter.appmanager.a.aKb().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
        com.baidu.swan.gamecenter.appmanager.a.aKb().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKs() {
        com.baidu.swan.gamecenter.appmanager.a.aKb().aKd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKt() {
        com.baidu.swan.gamecenter.appmanager.a.aKb().aKe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.cIK.clear();
        if (bVar != null) {
            this.cIK.putString("functionType", bVar.aKD());
            this.cIK.putString("resultData", bVar.getResult());
            this.cIK.putInt("resultStatus", bVar.getStatus());
            if (bVar.aKC()) {
                if (!TextUtils.equals(this.dnk, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dnk, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dne));
            }
        }
        finish();
    }

    /* loaded from: classes3.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
