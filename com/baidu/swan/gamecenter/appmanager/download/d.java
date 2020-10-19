package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.ap.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dBl;
    private String dBr;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dBr = bundle.getString("operation", "");
        this.dBl = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aNv().cc(d.this.dBl);
                String str = d.this.dBr;
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
                        d.this.cd(parseString);
                        return;
                    case 1:
                        d.this.ce(parseString);
                        return;
                    case 2:
                        d.this.aNL();
                        return;
                    case 3:
                        d.this.cf(parseString);
                        return;
                    case 4:
                        d.this.ch(parseString);
                        return;
                    case 5:
                        d.this.cg(parseString);
                        return;
                    case 6:
                        d.this.aNM();
                        return;
                    case 7:
                        d.this.aNN();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
        com.baidu.swan.gamecenter.appmanager.a.aNv().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aNv().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNL() {
        com.baidu.swan.gamecenter.appmanager.a.aNv().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cf(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
        com.baidu.swan.gamecenter.appmanager.a.aNv().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
        com.baidu.swan.gamecenter.appmanager.a.aNv().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
        com.baidu.swan.gamecenter.appmanager.a.aNv().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNM() {
        com.baidu.swan.gamecenter.appmanager.a.aNv().aNx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNN() {
        com.baidu.swan.gamecenter.appmanager.a.aNv().aNy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.cWN.clear();
        if (bVar != null) {
            this.cWN.putString("functionType", bVar.aNX());
            this.cWN.putString("resultData", bVar.getResult());
            this.cWN.putInt("resultStatus", bVar.getStatus());
            if (bVar.aNW()) {
                if (!TextUtils.equals(this.dBr, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dBr, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dBl));
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
