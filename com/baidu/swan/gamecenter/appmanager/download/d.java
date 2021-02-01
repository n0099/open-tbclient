package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.v;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject ebi;
    private String ebo;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.ebo = bundle.getString("operation", "");
        this.ebi = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aSZ().cm(d.this.ebi);
                String str = d.this.ebo;
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
                        d.this.cn(parseString);
                        return;
                    case 1:
                        d.this.co(parseString);
                        return;
                    case 2:
                        d.this.aTp();
                        return;
                    case 3:
                        d.this.cp(parseString);
                        return;
                    case 4:
                        d.this.cr(parseString);
                        return;
                    case 5:
                        d.this.cq(parseString);
                        return;
                    case 6:
                        d.this.aTq();
                        return;
                    case 7:
                        d.this.aTr();
                        return;
                    default:
                        d.this.b(new com.baidu.swan.gamecenter.appmanager.c.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
        com.baidu.swan.gamecenter.appmanager.a.aSZ().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aSZ().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        com.baidu.swan.gamecenter.appmanager.a.aSZ().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
        com.baidu.swan.gamecenter.appmanager.a.aSZ().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
        com.baidu.swan.gamecenter.appmanager.a.aSZ().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
        com.baidu.swan.gamecenter.appmanager.a.aSZ().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTq() {
        com.baidu.swan.gamecenter.appmanager.a.aSZ().aTb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTr() {
        com.baidu.swan.gamecenter.appmanager.a.aSZ().aTc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.dsX.clear();
        if (bVar != null) {
            this.dsX.putString("functionType", bVar.aTB());
            this.dsX.putString("resultData", bVar.getResult());
            this.dsX.putInt("resultStatus", bVar.getStatus());
            if (bVar.aTA()) {
                if (!TextUtils.equals(this.ebo, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.ebo, com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.ebi));
            }
        }
        finish();
    }

    /* loaded from: classes15.dex */
    public class a implements com.baidu.swan.gamecenter.appmanager.b.b {
        public a() {
        }

        @Override // com.baidu.swan.gamecenter.appmanager.b.b
        public void a(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
            d.this.b(bVar);
        }
    }
}
