package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.v;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject dZb;
    private String dZh;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.dZh = bundle.getString("operation", "");
        this.dZb = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aSN().cp(d.this.dZb);
                String str = d.this.dZh;
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
                        d.this.cq(parseString);
                        return;
                    case 1:
                        d.this.cr(parseString);
                        return;
                    case 2:
                        d.this.aTd();
                        return;
                    case 3:
                        d.this.cs(parseString);
                        return;
                    case 4:
                        d.this.cu(parseString);
                        return;
                    case 5:
                        d.this.ct(parseString);
                        return;
                    case 6:
                        d.this.aTe();
                        return;
                    case 7:
                        d.this.aTf();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
        com.baidu.swan.gamecenter.appmanager.a.aSN().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aSN().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTd() {
        com.baidu.swan.gamecenter.appmanager.a.aSN().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
        com.baidu.swan.gamecenter.appmanager.a.aSN().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
        com.baidu.swan.gamecenter.appmanager.a.aSN().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
        com.baidu.swan.gamecenter.appmanager.a.aSN().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTe() {
        com.baidu.swan.gamecenter.appmanager.a.aSN().aSP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTf() {
        com.baidu.swan.gamecenter.appmanager.a.aSN().aSQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.dqL.clear();
        if (bVar != null) {
            this.dqL.putString("functionType", bVar.aTp());
            this.dqL.putString("resultData", bVar.getResult());
            this.dqL.putInt("resultStatus", bVar.getStatus());
            if (bVar.aTo()) {
                if (!TextUtils.equals(this.dZh, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.dZh, com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.dZb));
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
