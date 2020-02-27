package com.baidu.live.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class an {
    private String acI;
    private String acJ;
    private String acK;
    private String acL;
    private String acM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(String str) {
        parserJson(str);
    }

    public boolean qI() {
        return "1".equals(this.acJ);
    }

    public boolean qJ() {
        return "1".equals(this.acK);
    }

    public boolean qK() {
        return "1".equals(this.acM);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.acI = jSONObject.optString("is_prettify");
                this.acJ = jSONObject.optString("is_stickers");
                this.acK = jSONObject.optString("is_privilegewin");
                this.acL = jSONObject.optString("unused_text");
                this.acM = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(ap apVar) {
        return TbadkCoreApplication.getInst().isTieba() || !(apVar == null || apVar.acQ == null || !"0".equals(apVar.acQ.acI));
    }

    public static boolean b(ap apVar) {
        return (TbadkCoreApplication.getInst().isTieba() || apVar == null || apVar.acQ == null || !"1".equals(apVar.acQ.acI)) ? false : true;
    }

    public static boolean c(ap apVar) {
        return (apVar == null || apVar.acQ == null || !"3".equals(apVar.acQ.acI)) ? false : true;
    }
}
