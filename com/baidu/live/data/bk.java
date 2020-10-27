package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bk {
    private String aOq;
    private String aOr;
    private String aOs;
    private String aOt;
    private String aOu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(String str) {
        parserJson(str);
    }

    public boolean Es() {
        return true;
    }

    public boolean Et() {
        return "1".equals(this.aOs);
    }

    public boolean Eu() {
        return "1".equals(this.aOu);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aOq = jSONObject.optString("is_prettify");
                this.aOr = jSONObject.optString("is_stickers");
                this.aOs = jSONObject.optString("is_privilegewin");
                this.aOt = jSONObject.optString("unused_text");
                this.aOu = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bm bmVar) {
        return false;
    }

    public static boolean b(bm bmVar) {
        return Build.VERSION.SDK_INT > 19 && bmVar != null && bmVar.aOy != null && "1".equals(bmVar.aOy.aOq);
    }

    public static boolean c(bm bmVar) {
        return !b(bmVar);
    }
}
