package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bc {
    private String aJq;
    private String aJr;
    private String aJs;
    private String aJt;
    private String aJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(String str) {
        parserJson(str);
    }

    public boolean CW() {
        return true;
    }

    public boolean CX() {
        return "1".equals(this.aJs);
    }

    public boolean CY() {
        return "1".equals(this.aJu);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aJq = jSONObject.optString("is_prettify");
                this.aJr = jSONObject.optString("is_stickers");
                this.aJs = jSONObject.optString("is_privilegewin");
                this.aJt = jSONObject.optString("unused_text");
                this.aJu = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(be beVar) {
        return false;
    }

    public static boolean b(be beVar) {
        return Build.VERSION.SDK_INT > 19 && beVar != null && beVar.aJy != null && "1".equals(beVar.aJy.aJq);
    }

    public static boolean c(be beVar) {
        return !b(beVar);
    }
}
