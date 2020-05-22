package com.baidu.swan.b.a.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.t;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject cSC;
    private String cSI;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        this.cSI = bundle.getString("operation", "");
        this.cSC = t.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = t.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.b.a.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.b.a.a.awP().bA(c.this.cSC);
                String str = c.this.cSI;
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
                        c.this.bB(parseString);
                        return;
                    case 1:
                        c.this.bC(parseString);
                        return;
                    case 2:
                        c.this.axb();
                        return;
                    case 3:
                        c.this.bD(parseString);
                        return;
                    case 4:
                        c.this.bF(parseString);
                        return;
                    case 5:
                        c.this.bE(parseString);
                        return;
                    default:
                        c.this.b(new com.baidu.swan.b.a.e.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, null, null, new com.baidu.swan.b.a.f.a(this.cSC));
        com.baidu.swan.b.a.a.awP().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.a.awP().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axb() {
        com.baidu.swan.b.a.a.awP().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, null, null, new com.baidu.swan.b.a.f.a(this.cSC));
        com.baidu.swan.b.a.a.awP().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, null, null, new com.baidu.swan.b.a.f.a(this.cSC));
        com.baidu.swan.b.a.a.awP().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, null, null, new com.baidu.swan.b.a.f.a(this.cSC));
        com.baidu.swan.b.a.a.awP().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.b.a.e.b bVar) {
        this.ctk.clear();
        if (bVar != null) {
            this.ctk.putString("functionType", bVar.axd());
            this.ctk.putString("resultData", bVar.getResult());
            this.ctk.putInt("resultStatus", bVar.getStatus());
            if (bVar.axc()) {
                if (!TextUtils.equals(this.cSI, "startDownload")) {
                    com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, "success", null, new com.baidu.swan.b.a.f.a(this.cSC));
                }
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cSI, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cSC));
            }
        }
        finish();
    }

    /* loaded from: classes11.dex */
    public class a implements com.baidu.swan.b.a.d.b {
        public a() {
        }

        @Override // com.baidu.swan.b.a.d.b
        public void a(com.baidu.swan.b.a.e.b bVar) {
            c.this.b(bVar);
        }
    }
}
