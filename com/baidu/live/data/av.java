package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class av {
    private String aAA;
    private String aAB;
    private String aAC;
    private String aAy;
    private String aAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(String str) {
        parserJson(str);
    }

    public boolean ws() {
        return true;
    }

    public boolean wt() {
        return "1".equals(this.aAA);
    }

    public boolean wu() {
        return "1".equals(this.aAC);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aAy = jSONObject.optString("is_prettify");
                this.aAz = jSONObject.optString("is_stickers");
                this.aAA = jSONObject.optString("is_privilegewin");
                this.aAB = jSONObject.optString("unused_text");
                this.aAC = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(ax axVar) {
        return false;
    }

    public static boolean b(ax axVar) {
        return Build.VERSION.SDK_INT > 19 && axVar != null && axVar.aAG != null && "1".equals(axVar.aAG.aAy);
    }

    public static boolean c(ax axVar) {
        return !b(axVar);
    }
}
