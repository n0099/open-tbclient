package com.baidu.swan.b.a.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject cIs;
    private String cIx;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.cIx = bundle.getString("operation", "");
        this.cIs = s.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = s.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.b.a.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.b.a.a.ati().bB(c.this.cIs);
                String str = c.this.cIx;
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
                        c.this.bC(parseString);
                        return;
                    case 1:
                        c.this.bD(parseString);
                        return;
                    case 2:
                        c.this.atu();
                        return;
                    case 3:
                        c.this.bE(parseString);
                        return;
                    case 4:
                        c.this.bG(parseString);
                        return;
                    case 5:
                        c.this.bF(parseString);
                        return;
                    default:
                        c.this.a(new com.baidu.swan.b.a.e.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, null, null, new com.baidu.swan.b.a.f.a(this.cIs));
        com.baidu.swan.b.a.a.ati().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.a.ati().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atu() {
        com.baidu.swan.b.a.a.ati().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, null, null, new com.baidu.swan.b.a.f.a(this.cIs));
        com.baidu.swan.b.a.a.ati().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, null, null, new com.baidu.swan.b.a.f.a(this.cIs));
        com.baidu.swan.b.a.a.ati().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, null, null, new com.baidu.swan.b.a.f.a(this.cIs));
        com.baidu.swan.b.a.a.ati().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.b.a.e.b bVar) {
        this.chU.clear();
        if (bVar != null) {
            this.chU.putString("functionType", bVar.atw());
            this.chU.putString("resultData", bVar.getResult());
            this.chU.putInt("resultStatus", bVar.getStatus());
            if (bVar.atv()) {
                if (!TextUtils.equals(this.cIx, "startDownload")) {
                    com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, "success", null, new com.baidu.swan.b.a.f.a(this.cIs));
                }
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cIx, "fail", String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cIs));
            }
        }
        finish();
    }

    /* loaded from: classes11.dex */
    public class a implements com.baidu.swan.b.a.d.b {
        public a() {
        }

        @Override // com.baidu.swan.b.a.d.b
        public void b(com.baidu.swan.b.a.e.b bVar) {
            c.this.a(bVar);
        }
    }
}
