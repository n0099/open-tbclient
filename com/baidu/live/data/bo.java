package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bo {
    private String aRr;
    private String aRs;
    private String aRt;
    private String aRu;
    private String aRv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(String str) {
        parserJson(str);
    }

    public boolean Fh() {
        return true;
    }

    public boolean Fi() {
        return "1".equals(this.aRt);
    }

    public boolean Fj() {
        return "1".equals(this.aRv);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aRr = jSONObject.optString("is_prettify");
                this.aRs = jSONObject.optString("is_stickers");
                this.aRt = jSONObject.optString("is_privilegewin");
                this.aRu = jSONObject.optString("unused_text");
                this.aRv = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bq bqVar) {
        return false;
    }

    public static boolean b(bq bqVar) {
        return Build.VERSION.SDK_INT > 19 && bqVar != null && bqVar.aRz != null && "1".equals(bqVar.aRz.aRr);
    }

    public static boolean c(bq bqVar) {
        return !b(bqVar);
    }
}
