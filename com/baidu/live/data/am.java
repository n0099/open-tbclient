package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class am {
    private String aaK;
    private String aaL;
    private String aaM;
    private String aaN;
    private String aaO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(String str) {
        parserJson(str);
    }

    public boolean pX() {
        return "1".equals(this.aaL);
    }

    public boolean pY() {
        return "1".equals(this.aaM);
    }

    public boolean pZ() {
        return "1".equals(this.aaO);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aaK = jSONObject.optString("is_prettify");
                this.aaL = jSONObject.optString("is_stickers");
                this.aaM = jSONObject.optString("is_privilegewin");
                this.aaN = jSONObject.optString("unused_text");
                this.aaO = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(ao aoVar) {
        return TbadkCoreApplication.getInst().isTieba() || !(aoVar == null || aoVar.aaS == null || !"0".equals(aoVar.aaS.aaK));
    }

    public static boolean b(ao aoVar) {
        return (TbadkCoreApplication.getInst().isTieba() || aoVar == null || aoVar.aaS == null || !"1".equals(aoVar.aaS.aaK)) ? false : true;
    }

    public static boolean c(ao aoVar) {
        return (aoVar == null || aoVar.aaS == null || !"3".equals(aoVar.aaS.aaK)) ? false : true;
    }
}
