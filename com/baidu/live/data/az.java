package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class az {
    private String aCJ;
    private String aCK;
    private String aCL;
    private String aCM;
    private String aCN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(String str) {
        parserJson(str);
    }

    public boolean wQ() {
        return true;
    }

    public boolean wR() {
        return "1".equals(this.aCL);
    }

    public boolean wS() {
        return "1".equals(this.aCN);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aCJ = jSONObject.optString("is_prettify");
                this.aCK = jSONObject.optString("is_stickers");
                this.aCL = jSONObject.optString("is_privilegewin");
                this.aCM = jSONObject.optString("unused_text");
                this.aCN = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bb bbVar) {
        return false;
    }

    public static boolean b(bb bbVar) {
        return Build.VERSION.SDK_INT > 19 && bbVar != null && bbVar.aCR != null && "1".equals(bbVar.aCR.aCJ);
    }

    public static boolean c(bb bbVar) {
        return !b(bbVar);
    }
}
