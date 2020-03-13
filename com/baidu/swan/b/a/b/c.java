package com.baidu.swan.b.a.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.swan.apps.as.s;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.apps.process.a.a.a {
    private JSONObject cjg;
    private String cjl;
    private String mPackageName;

    @Override // com.baidu.swan.apps.process.a.a.a
    public void y(@NonNull Bundle bundle) {
        this.cjl = bundle.getString("operation", "");
        this.cjg = s.parseString(bundle.getString("ubc_params", ""));
        final JSONObject parseString = s.parseString(bundle.getString("data", ""));
        this.mPackageName = parseString.optString("packageName");
        com.baidu.swan.b.a.a.a.sExecutorService.execute(new Runnable() { // from class: com.baidu.swan.b.a.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.b.a.a.akS().bq(c.this.cjg);
                String str = c.this.cjl;
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
                        c.this.br(parseString);
                        return;
                    case 1:
                        c.this.bs(parseString);
                        return;
                    case 2:
                        c.this.ale();
                        return;
                    case 3:
                        c.this.bt(parseString);
                        return;
                    case 4:
                        c.this.bv(parseString);
                        return;
                    case 5:
                        c.this.bu(parseString);
                        return;
                    default:
                        c.this.a(new com.baidu.swan.b.a.e.a(31009, "invalid operation"));
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, null, null, new com.baidu.swan.b.a.f.a(this.cjg));
        com.baidu.swan.b.a.a.akS().a(jSONObject.optString("url"), jSONObject.optString("packageName"), jSONObject.optString("apkId"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.a.akS().a(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ale() {
        com.baidu.swan.b.a.a.akS().a(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, null, null, new com.baidu.swan.b.a.f.a(this.cjg));
        com.baidu.swan.b.a.a.akS().c(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, null, null, new com.baidu.swan.b.a.f.a(this.cjg));
        com.baidu.swan.b.a.a.akS().d(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(@NonNull JSONObject jSONObject) {
        com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, null, null, new com.baidu.swan.b.a.f.a(this.cjg));
        com.baidu.swan.b.a.a.akS().b(jSONObject.optString("url"), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.b.a.e.b bVar) {
        this.bIU.clear();
        if (bVar != null) {
            this.bIU.putString("functionType", bVar.getFunctionType());
            this.bIU.putString("resultData", bVar.getResult());
            this.bIU.putInt("resultStatus", bVar.getStatus());
            if (bVar.alf()) {
                if (!TextUtils.equals(this.cjl, "startDownload")) {
                    com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, "success", null, new com.baidu.swan.b.a.f.a(this.cjg));
                }
            } else {
                com.baidu.swan.b.a.f.c.a(this.mPackageName, this.cjl, LivenessStat.TYPE_FACE_MATCH_FAIL, String.valueOf(bVar.getStatus()), new com.baidu.swan.b.a.f.a(this.cjg));
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
