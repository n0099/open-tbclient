package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ba {
    private String aEe;
    private String aEf;
    private String aEg;
    private String aEh;
    private String aEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(String str) {
        parserJson(str);
    }

    public boolean xt() {
        return true;
    }

    public boolean xu() {
        return "1".equals(this.aEg);
    }

    public boolean xv() {
        return "1".equals(this.aEi);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aEe = jSONObject.optString("is_prettify");
                this.aEf = jSONObject.optString("is_stickers");
                this.aEg = jSONObject.optString("is_privilegewin");
                this.aEh = jSONObject.optString("unused_text");
                this.aEi = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bc bcVar) {
        return false;
    }

    public static boolean b(bc bcVar) {
        return Build.VERSION.SDK_INT > 19 && bcVar != null && bcVar.aEm != null && "1".equals(bcVar.aEm.aEe);
    }

    public static boolean c(bc bcVar) {
        return !b(bcVar);
    }
}
