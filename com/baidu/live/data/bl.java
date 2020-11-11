package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl {
    private String aPn;
    private String aPo;
    private String aPp;
    private String aPq;
    private String aPr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(String str) {
        parserJson(str);
    }

    public boolean EP() {
        return true;
    }

    public boolean EQ() {
        return "1".equals(this.aPp);
    }

    public boolean ER() {
        return "1".equals(this.aPr);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPn = jSONObject.optString("is_prettify");
                this.aPo = jSONObject.optString("is_stickers");
                this.aPp = jSONObject.optString("is_privilegewin");
                this.aPq = jSONObject.optString("unused_text");
                this.aPr = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bn bnVar) {
        return false;
    }

    public static boolean b(bn bnVar) {
        return Build.VERSION.SDK_INT > 19 && bnVar != null && bnVar.aPv != null && "1".equals(bnVar.aPv.aPn);
    }

    public static boolean c(bn bnVar) {
        return !b(bnVar);
    }
}
