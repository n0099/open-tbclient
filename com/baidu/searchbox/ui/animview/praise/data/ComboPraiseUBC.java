package com.baidu.searchbox.ui.animview.praise.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ComboPraiseUBC {
    public static final String UBC_JSON_KEY_NID = "nid";
    public static final String UBC_JSON_KEY_SOURCE = "source";
    private String mNid;
    private String mUBCSource;

    public String getUBCSource() {
        return this.mUBCSource;
    }

    public void setUBCSource(String str) {
        this.mUBCSource = str;
    }

    public String getNid() {
        return this.mNid;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public ComboPraiseUBC() {
    }

    public ComboPraiseUBC(String str, String str2) {
        this.mUBCSource = str;
        this.mNid = str2;
    }

    public static ComboPraiseUBC parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ComboPraiseUBC comboPraiseUBC = new ComboPraiseUBC();
        comboPraiseUBC.mUBCSource = jSONObject.optString("source", "");
        comboPraiseUBC.mNid = jSONObject.optString("nid", "");
        return comboPraiseUBC;
    }
}
