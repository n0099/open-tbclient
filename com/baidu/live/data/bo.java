package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bo {
    private String aME;
    private String aMF;
    private String aMG;
    private String aMH;
    private String aMI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(String str) {
        parserJson(str);
    }

    public boolean Bm() {
        return true;
    }

    public boolean Bn() {
        return "1".equals(this.aMG);
    }

    public boolean Bo() {
        return "1".equals(this.aMI);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aME = jSONObject.optString("is_prettify");
                this.aMF = jSONObject.optString("is_stickers");
                this.aMG = jSONObject.optString("is_privilegewin");
                this.aMH = jSONObject.optString("unused_text");
                this.aMI = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bq bqVar) {
        return false;
    }

    public static boolean b(bq bqVar) {
        return Build.VERSION.SDK_INT > 19 && bqVar != null && bqVar.aMM != null && "1".equals(bqVar.aMM.aME);
    }

    public static boolean c(bq bqVar) {
        return !b(bqVar);
    }
}
