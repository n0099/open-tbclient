package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aq {
    private String avk;
    private String avl;
    private String avm;
    private String avn;
    private String avo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(String str) {
        parserJson(str);
    }

    public boolean ve() {
        return true;
    }

    public boolean vf() {
        return "1".equals(this.avm);
    }

    public boolean vg() {
        return "1".equals(this.avo);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.avk = jSONObject.optString("is_prettify");
                this.avl = jSONObject.optString("is_stickers");
                this.avm = jSONObject.optString("is_privilegewin");
                this.avn = jSONObject.optString("unused_text");
                this.avo = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(as asVar) {
        return false;
    }

    public static boolean b(as asVar) {
        return Build.VERSION.SDK_INT > 19 && asVar != null && asVar.avs != null && "1".equals(asVar.avs.avk);
    }

    public static boolean c(as asVar) {
        return !b(asVar);
    }
}
