package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bh {
    private String aKG;
    private String aKH;
    private String aKI;
    private String aKJ;
    private String aKK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(String str) {
        parserJson(str);
    }

    public boolean Dm() {
        return true;
    }

    public boolean Dn() {
        return "1".equals(this.aKI);
    }

    public boolean Do() {
        return "1".equals(this.aKK);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aKG = jSONObject.optString("is_prettify");
                this.aKH = jSONObject.optString("is_stickers");
                this.aKI = jSONObject.optString("is_privilegewin");
                this.aKJ = jSONObject.optString("unused_text");
                this.aKK = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bj bjVar) {
        return false;
    }

    public static boolean b(bj bjVar) {
        return Build.VERSION.SDK_INT > 19 && bjVar != null && bjVar.aKO != null && "1".equals(bjVar.aKO.aKG);
    }

    public static boolean c(bj bjVar) {
        return !b(bjVar);
    }
}
