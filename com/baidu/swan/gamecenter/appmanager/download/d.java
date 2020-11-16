package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dNS;
    private String dNY;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dNY = bundle.getString("operation", "");
        this.dNS = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aRh().cf(d.this.dNS);
                String str = d.this.dNY;
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
                        d.this.cg(parseString);
                        return;
                    case 1:
                        d.this.ch(parseString);
                        return;
                    case 2:
                        d.this.aRx();
                        return;
                    case 3:
                        d.this.ci(parseString);
                        return;
                    case 4:
                        d.this.ck(parseString);
                        return;
                    case 5:
                        d.this.cj(parseString);
                        return;
                    case 6:
                        d.this.aRy();
                        return;
                    case 7:
                        d.this.aRz();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
        com.baidu.swan.gamecenter.appmanager.a.aRh().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aRh().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRx() {
        com.baidu.swan.gamecenter.appmanager.a.aRh().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
        com.baidu.swan.gamecenter.appmanager.a.aRh().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
        com.baidu.swan.gamecenter.appmanager.a.aRh().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
        com.baidu.swan.gamecenter.appmanager.a.aRh().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRy() {
        com.baidu.swan.gamecenter.appmanager.a.aRh().aRj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRz() {
        com.baidu.swan.gamecenter.appmanager.a.aRh().aRk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.djC.clear();
        if (bVar != null) {
            this.djC.putString("functionType", bVar.aRJ());
            this.djC.putString("resultData", bVar.getResult());
            this.djC.putInt("resultStatus", bVar.getStatus());
            if (bVar.aRI()) {
                if (!TextUtils.equals(this.dNY, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dNY, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dNS));
            }
        }
        finish();
    }

    /* loaded from: classes16.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
