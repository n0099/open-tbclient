package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dJI;
    private String dJO;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dJO = bundle.getString("operation", "");
        this.dJI = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aPp().cf(d.this.dJI);
                String str = d.this.dJO;
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
                        d.this.aPF();
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
                        d.this.aPG();
                        return;
                    case 7:
                        d.this.aPH();
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
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        com.baidu.swan.gamecenter.appmanager.a.aPp().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aPp().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPF() {
        com.baidu.swan.gamecenter.appmanager.a.aPp().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ci(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        com.baidu.swan.gamecenter.appmanager.a.aPp().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        com.baidu.swan.gamecenter.appmanager.a.aPp().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
        com.baidu.swan.gamecenter.appmanager.a.aPp().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPG() {
        com.baidu.swan.gamecenter.appmanager.a.aPp().aPr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPH() {
        com.baidu.swan.gamecenter.appmanager.a.aPp().aPs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.dfo.clear();
        if (bVar != null) {
            this.dfo.putString("functionType", bVar.aPR());
            this.dfo.putString("resultData", bVar.getResult());
            this.dfo.putInt("resultStatus", bVar.getStatus());
            if (bVar.aPQ()) {
                if (!TextUtils.equals(this.dJO, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dJO, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dJI));
            }
        }
        finish();
    }

    /* loaded from: classes6.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
