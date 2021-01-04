package com.baidu.swan.apps.api.module.d;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.t;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lg(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Image", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            c.e("Api-Image", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("Api-Image", "empty cb");
            return new com.baidu.swan.apps.api.c.b(202, "empty cb");
        }
        return f(optString, jSONObject.optString("src"), jSONObject.optInt("quality", 80));
    }

    private com.baidu.swan.apps.api.c.b f(final String str, String str2, int i) {
        final e aMk = e.aMk();
        if (aMk == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        final int i2 = (i < 0 || i > 100) ? 80 : i;
        if (TextUtils.isEmpty(str2)) {
            c.e("Api-Image", "src is null");
            return new com.baidu.swan.apps.api.c.b(202, "src is null");
        }
        PathType tW = com.baidu.swan.apps.storage.b.tW(str2);
        String str3 = null;
        if (tW == PathType.BD_FILE) {
            str3 = com.baidu.swan.apps.storage.b.cE(str2, aMk.id);
        } else if (tW == PathType.RELATIVE) {
            str3 = com.baidu.swan.apps.storage.b.a(str2, aMk, aMk.getVersion());
        }
        if (TextUtils.isEmpty(str3)) {
            c.e("Api-Image", "file path error");
            return new com.baidu.swan.apps.api.c.b(2001, "file path error");
        }
        final File file = new File(str3);
        if (!file.exists()) {
            c.e("Api-Image", "file does not exist");
            return new com.baidu.swan.apps.api.c.b(2001, "file does not exist");
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.api.module.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                File uO = t.uO(file.getName());
                if (!t.a(file, uO, i2)) {
                    c.e("Api-Image", "compress image failed");
                    a.this.a(str, new com.baidu.swan.apps.api.c.b(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.cH(uO.getAbsolutePath(), aMk.id));
                } catch (JSONException e) {
                    c.e("Api-Image", e.toString());
                }
                a.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject));
            }
        }, "compressImage");
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
