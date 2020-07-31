package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.v;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dcR;
    private String dcX;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        this.dcX = bundle.getString("operation", "");
        this.dcR = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aBl().bM(d.this.dcR);
                String str = d.this.dcX;
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
                        d.this.bN(parseString);
                        return;
                    case 1:
                        d.this.bO(parseString);
                        return;
                    case 2:
                        d.this.aBC();
                        return;
                    case 3:
                        d.this.bP(parseString);
                        return;
                    case 4:
                        d.this.bR(parseString);
                        return;
                    case 5:
                        d.this.bQ(parseString);
                        return;
                    case 6:
                        d.this.aBD();
                        return;
                    case 7:
                        d.this.aBE();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
        com.baidu.swan.gamecenter.appmanager.a.aBl().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aBl().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBC() {
        com.baidu.swan.gamecenter.appmanager.a.aBl().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
        com.baidu.swan.gamecenter.appmanager.a.aBl().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
        com.baidu.swan.gamecenter.appmanager.a.aBl().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
        com.baidu.swan.gamecenter.appmanager.a.aBl().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBD() {
        com.baidu.swan.gamecenter.appmanager.a.aBl().aBn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBE() {
        com.baidu.swan.gamecenter.appmanager.a.aBl().aBo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.cAx.clear();
        if (bVar != null) {
            this.cAx.putString("functionType", bVar.aBO());
            this.cAx.putString("resultData", bVar.getResult());
            this.cAx.putInt("resultStatus", bVar.getStatus());
            if (bVar.aBN()) {
                if (!TextUtils.equals(this.dcX, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dcX, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dcR));
            }
        }
        finish();
    }

    /* loaded from: classes20.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
