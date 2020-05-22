package com.baidu.swan.apps.api.module.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.r;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.PathType;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hk(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-Image", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            c.e("Api-Image", "parse fail");
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.e("Api-Image", "empty cb");
            return new com.baidu.swan.apps.api.c.b(202, "empty cb");
        }
        return b(optString, jSONObject.optString(UserAccountActionItem.KEY_SRC), jSONObject.optInt("quality", 80));
    }

    private com.baidu.swan.apps.api.c.b b(final String str, String str2, int i) {
        final e aoF = e.aoF();
        if (aoF == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        final int i2 = (i < 0 || i > 100) ? 80 : i;
        if (TextUtils.isEmpty(str2)) {
            c.e("Api-Image", "src is null");
            return new com.baidu.swan.apps.api.c.b(202, "src is null");
        }
        PathType oQ = com.baidu.swan.apps.storage.b.oQ(str2);
        String str3 = null;
        if (oQ == PathType.BD_FILE) {
            str3 = com.baidu.swan.apps.storage.b.bT(str2, aoF.id);
        } else if (oQ == PathType.RELATIVE) {
            str3 = com.baidu.swan.apps.storage.b.a(str2, aoF, aoF.getVersion());
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
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.api.module.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                File pG = r.pG(file.getName());
                if (!r.a(file, pG, i2)) {
                    c.e("Api-Image", "compress image failed");
                    a.this.a(str, new com.baidu.swan.apps.api.c.b(1001, "compress image failed"));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempFilePath", com.baidu.swan.apps.storage.b.bW(pG.getAbsolutePath(), aoF.id));
                } catch (JSONException e) {
                    c.e("Api-Image", e.toString());
                }
                a.this.a(str, new com.baidu.swan.apps.api.c.b(0, jSONObject));
            }
        }, "compressImage");
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
