package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bt {
    private String aRc;
    private String aRd;
    private String aRe;
    private String aRf;
    private String aRg;
    private boolean mArReportOriginalValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(String str) {
        parserJson(str);
    }

    public boolean CC() {
        return true;
    }

    public boolean CD() {
        return "1".equals(this.aRe);
    }

    public boolean CE() {
        return "1".equals(this.aRg);
    }

    public boolean isArReportOriginalValue() {
        return this.mArReportOriginalValue;
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aRc = jSONObject.optString("is_prettify");
                this.aRd = jSONObject.optString("is_stickers");
                this.aRe = jSONObject.optString("is_privilegewin");
                this.aRf = jSONObject.optString("unused_text");
                this.aRg = jSONObject.optString("is_wishlist", "1");
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
        return Build.VERSION.SDK_INT > 19 && bvVar != null && bvVar.aRk != null && "1".equals(bvVar.aRk.aRc);
    }

    public static boolean c(bv bvVar) {
        return !b(bvVar);
    }
}
