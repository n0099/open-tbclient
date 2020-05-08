package com.baidu.swan.apps.api.module.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.q;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gx(String str) {
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-Image", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            com.baidu.swan.apps.console.c.e("Api-Image", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("Api-Image", "empty cb");
            return new com.baidu.swan.apps.api.b.b(202, "empty cb");
        }
        return b(optString, jSONObject.optString(UserAccountActionItem.KEY_SRC), jSONObject.optInt("quality", 80));
    }

    private com.baidu.swan.apps.api.b.b b(final String str, String str2, int i) {
        final e akM = e.akM();
        if (akM == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "swan app is null");
        }
        final int i2 = (i < 0 || i > 100) ? 80 : i;
        if (TextUtils.isEmpty(str2)) {
            com.baidu.swan.apps.console.c.e("Api-Image", "src is null");
            return new com.baidu.swan.apps.api.b.b(202, "src is null");
        }
        PathType nm = com.baidu.swan.apps.storage.b.nm(str2);
        String str3 = null;
        if (nm == PathType.BD_FILE) {
            str3 = com.baidu.swan.apps.storage.b.by(str2, akM.id);
        } else if (nm == PathType.RELATIVE) {
            str3 = com.baidu.swan.apps.storage.b.a(str2, akM, akM.getVersion());
        }
        if (TextUtils.isEmpty(str3)) {
            com.baidu.swan.apps.console.c.e("Api-Image", "file path error");
            return new com.baidu.swan.apps.api.b.b(2001, "file path error");
        }
        final File file = new File(str3);
        if (!file.exists()) {
            com.baidu.swan.apps.console.c.e("Api-Image", "file does not exist");
            return new com.baidu.swan.apps.api.b.b(2001, "file does not exist");
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.api.module.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                File nX = q.nX(file.getName());
                if (!q.a(file, nX, i2)) {
                    com.baidu.swan.apps.console.c.e("Api-Image", "compress image failed");
                    a.this.a(str, new com.baidu.swan.apps.api.b.b(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.bA(nX.getAbsolutePath(), akM.id) + "." + com.baidu.swan.d.c.su(nX.getAbsolutePath()));
                } catch (JSONException e) {
                    com.baidu.swan.apps.console.c.e("Api-Image", e.toString());
                }
                a.this.a(str, new com.baidu.swan.apps.api.b.b(0, jSONObject));
            }
        }, "compressImage");
        return new com.baidu.swan.apps.api.b.b(0);
    }
}
