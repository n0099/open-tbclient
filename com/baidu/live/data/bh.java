package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bh {
    private String aNL;
    private String aNM;
    private String aNN;
    private String aNO;
    private String aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(String str) {
        parserJson(str);
    }

    public boolean Ej() {
        return true;
    }

    public boolean Ek() {
        return "1".equals(this.aNN);
    }

    public boolean El() {
        return "1".equals(this.aNP);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aNL = jSONObject.optString("is_prettify");
                this.aNM = jSONObject.optString("is_stickers");
                this.aNN = jSONObject.optString("is_privilegewin");
                this.aNO = jSONObject.optString("unused_text");
                this.aNP = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bj bjVar) {
        return false;
    }

    public static boolean b(bj bjVar) {
        return Build.VERSION.SDK_INT > 19 && bjVar != null && bjVar.aNT != null && "1".equals(bjVar.aNT.aNL);
    }

    public static boolean c(bj bjVar) {
        return !b(bjVar);
    }
}
