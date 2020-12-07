package com.baidu.live.data;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bm {
    private String aQC;
    private String aQD;
    private String aQE;
    private String aQF;
    private String aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(String str) {
        parserJson(str);
    }

    public boolean FR() {
        return true;
    }

    public boolean FS() {
        return "1".equals(this.aQE);
    }

    public boolean FT() {
        return "1".equals(this.aQG);
    }

    private void parserJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.aQC = jSONObject.optString("is_prettify");
                this.aQD = jSONObject.optString("is_stickers");
                this.aQE = jSONObject.optString("is_privilegewin");
                this.aQF = jSONObject.optString("unused_text");
                this.aQG = jSONObject.optString("is_wishlist", "1");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean a(bo boVar) {
        return false;
    }

    public static boolean b(bo boVar) {
        return Build.VERSION.SDK_INT > 19 && boVar != null && boVar.aQK != null && "1".equals(boVar.aQK.aQC);
    }

    public static boolean c(bo boVar) {
        return !b(boVar);
    }
}
