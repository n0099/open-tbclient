package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bl {
    private String aNC;
    private String aND;
    private String aNE;
    private String aNF;
    private String aNG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(String str) {
        parserJson(str);
    }

    public boolean Eg() {
        return true;
    }

    public boolean Eh() {
        return "1".equals(this.aNE);
    }

    public boolean Ei() {
        return "1".equals(this.aNG);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aNC = jSONObject.optString("is_prettify");
                this.aND = jSONObject.optString("is_stickers");
                this.aNE = jSONObject.optString("is_privilegewin");
                this.aNF = jSONObject.optString("unused_text");
                this.aNG = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bn bnVar) {
        return false;
    }

    public static boolean b(bn bnVar) {
        return Build.VERSION.SDK_INT > 19 && bnVar != null && bnVar.aNK != null && "1".equals(bnVar.aNK.aNC);
    }

    public static boolean c(bn bnVar) {
        return !b(bnVar);
    }
}
