package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aq {
    private String avq;
    private String avr;
    private String avs;
    private String avt;
    private String avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(String str) {
        parserJson(str);
    }

    public boolean vd() {
        return true;
    }

    public boolean ve() {
        return "1".equals(this.avs);
    }

    public boolean vf() {
        return "1".equals(this.avu);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.avq = jSONObject.optString("is_prettify");
                this.avr = jSONObject.optString("is_stickers");
                this.avs = jSONObject.optString("is_privilegewin");
                this.avt = jSONObject.optString("unused_text");
                this.avu = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(as asVar) {
        return false;
    }

    public static boolean b(as asVar) {
        return Build.VERSION.SDK_INT > 19 && asVar != null && asVar.avy != null && "1".equals(asVar.avy.avq);
    }

    public static boolean c(as asVar) {
        return !b(asVar);
    }
}
