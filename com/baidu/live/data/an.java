package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an {
    private String acS;
    private String acT;
    private String acU;
    private String acV;
    private String acW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(String str) {
        parserJson(str);
    }

    public boolean qN() {
        return "1".equals(this.acT);
    }

    public boolean qO() {
        return "1".equals(this.acU);
    }

    public boolean qP() {
        return "1".equals(this.acW);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.acS = jSONObject.optString("is_prettify");
                this.acT = jSONObject.optString("is_stickers");
                this.acU = jSONObject.optString("is_privilegewin");
                this.acV = jSONObject.optString("unused_text");
                this.acW = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(ap apVar) {
        return TbadkCoreApplication.getInst().isTieba() || !(apVar == null || apVar.ada == null || !"0".equals(apVar.ada.acS));
    }

    public static boolean b(ap apVar) {
        return (TbadkCoreApplication.getInst().isTieba() || apVar == null || apVar.ada == null || !"1".equals(apVar.ada.acS)) ? false : true;
    }

    public static boolean c(ap apVar) {
        return (apVar == null || apVar.ada == null || !"3".equals(apVar.ada.acS)) ? false : true;
    }
}
