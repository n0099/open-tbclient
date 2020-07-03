package com.baidu.swan.b.a.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.t;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject cXm;
    private String cXs;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void A(@NonNull Bundle bundle) {
        this.cXs = bundle.getString("operation", "");
        this.cXm = t.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = t.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.b.a.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.b.a.a.axV().bH(c.this.cXm);
                String str = c.this.cXs;
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
                        c.this.bI(parseString);
                        return;
                    case 1:
                        c.this.bJ(parseString);
                        return;
                    case 2:
                        c.this.ayh();
                        return;
                    case 3:
                        c.this.bK(parseString);
                        return;
                    case 4:
                        c.this.bM(parseString);
                        return;
                    case 5:
                        c.this.bL(parseString);
                        return;
                    default:
                        c.this.b(new com.baidu.swan.b.a.e.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, null, null, new com.baidu.swan.b.a.f.a(this.cXm));
        com.baidu.swan.b.a.a.axV().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.a.axV().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayh() {
        com.baidu.swan.b.a.a.axV().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, null, null, new com.baidu.swan.b.a.f.a(this.cXm));
        com.baidu.swan.b.a.a.axV().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, null, null, new com.baidu.swan.b.a.f.a(this.cXm));
        com.baidu.swan.b.a.a.axV().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, null, null, new com.baidu.swan.b.a.f.a(this.cXm));
        com.baidu.swan.b.a.a.axV().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.b.a.e.b bVar) {
        this.cxY.clear();
        if (bVar != null) {
            this.cxY.putString("functionType", bVar.ayj());
            this.cxY.putString("resultData", bVar.getResult());
            this.cxY.putInt("resultStatus", bVar.getStatus());
            if (bVar.ayi()) {
                if (!TextUtils.equals(this.cXs, "startDownload")) {
                    com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, "success", null, new com.baidu.swan.b.a.f.a(this.cXm));
                }
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cXs, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cXm));
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
