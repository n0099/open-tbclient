package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bt {
    private String aPC;
    private String aPD;
    private String aPE;
    private String aPF;
    private String aPG;
    private boolean mArReportOriginalValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(String str) {
        parserJson(str);
    }

    public boolean Cz() {
        return true;
    }

    public boolean CA() {
        return "1".equals(this.aPE);
    }

    public boolean CB() {
        return "1".equals(this.aPG);
    }

    public boolean isArReportOriginalValue() {
        return this.mArReportOriginalValue;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aPC = jSONObject.optString("is_prettify");
                this.aPD = jSONObject.optString("is_stickers");
                this.aPE = jSONObject.optString("is_privilegewin");
                this.aPF = jSONObject.optString("unused_text");
                this.aPG = jSONObject.optString("is_wishlist", "1");
                this.mArReportOriginalValue = TextUtils.equals(jSONObject.optString("ar_perf_switch", "0"), "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bv bvVar) {
        return false;
    }

    public static boolean b(bv bvVar) {
        return Build.VERSION.SDK_INT > 19 && bvVar != null && bvVar.aPK != null && "1".equals(bvVar.aPK.aPC);
    }

    public static boolean c(bv bvVar) {
        return !b(bvVar);
    }
}
