package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dph;
    private String dpn;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dpn = bundle.getString("operation", "");
        this.dph = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aKM().bV(d.this.dph);
                String str = d.this.dpn;
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
                        d.this.bW(parseString);
                        return;
                    case 1:
                        d.this.bX(parseString);
                        return;
                    case 2:
                        d.this.aLc();
                        return;
                    case 3:
                        d.this.bY(parseString);
                        return;
                    case 4:
                        d.this.ca(parseString);
                        return;
                    case 5:
                        d.this.bZ(parseString);
                        return;
                    case 6:
                        d.this.aLd();
                        return;
                    case 7:
                        d.this.aLe();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
        com.baidu.swan.gamecenter.appmanager.a.aKM().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aKM().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLc() {
        com.baidu.swan.gamecenter.appmanager.a.aKM().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
        com.baidu.swan.gamecenter.appmanager.a.aKM().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
        com.baidu.swan.gamecenter.appmanager.a.aKM().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
        com.baidu.swan.gamecenter.appmanager.a.aKM().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        com.baidu.swan.gamecenter.appmanager.a.aKM().aKO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        com.baidu.swan.gamecenter.appmanager.a.aKM().aKP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.cKK.clear();
        if (bVar != null) {
            this.cKK.putString("functionType", bVar.aLo());
            this.cKK.putString("resultData", bVar.getResult());
            this.cKK.putInt("resultStatus", bVar.getStatus());
            if (bVar.aLn()) {
                if (!TextUtils.equals(this.dpn, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dpn, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dph));
            }
        }
        finish();
    }

    /* loaded from: classes14.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
