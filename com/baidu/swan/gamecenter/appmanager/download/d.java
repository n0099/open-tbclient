package com.baidu.swan.gamecenter.appmanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.v;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject edN;
    private String edT;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.edT = bundle.getString("operation", "");
        this.edN = v.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = v.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.gamecenter.appmanager.a.b.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.gamecenter.appmanager.download.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.gamecenter.appmanager.a.aWG().cp(d.this.edN);
                String str = d.this.edT;
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
                        d.this.aWW();
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
                        d.this.aWX();
                        return;
                    case 7:
                        d.this.aWY();
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
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
        com.baidu.swan.gamecenter.appmanager.a.aWG().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.a.aWG().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWW() {
        com.baidu.swan.gamecenter.appmanager.a.aWG().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
        com.baidu.swan.gamecenter.appmanager.a.aWG().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
        com.baidu.swan.gamecenter.appmanager.a.aWG().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(@NonNull JSONObject jSONObject) {
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, null, null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
        com.baidu.swan.gamecenter.appmanager.a.aWG().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWX() {
        com.baidu.swan.gamecenter.appmanager.a.aWG().aWI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWY() {
        com.baidu.swan.gamecenter.appmanager.a.aWG().aWJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.gamecenter.appmanager.c.b bVar) {
        this.dvA.clear();
        if (bVar != null) {
            this.dvA.putString("functionType", bVar.aXi());
            this.dvA.putString("resultData", bVar.getResult());
            this.dvA.putInt("resultStatus", bVar.getStatus());
            if (bVar.aXh()) {
                if (!TextUtils.equals(this.edT, "startDownload")) {
                    com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
                }
            } else {
                com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.edT, com.baidu.pass.biometrics.face.liveness.c.a.p, String.valueOf(bVar.getStatus()), new com.baidu.swan.gamecenter.appmanager.d.a(this.edN));
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
