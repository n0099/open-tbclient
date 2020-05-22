package com.baidu.live.tbadk.ubc;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcDebugItem {
    public JSONObject otherExt;
    public String page;
    public String statCode;
    public String statId;
    public String value;

    public UbcDebugItem(String str, String str2) {
        this.page = str;
        this.value = str2;
    }

    public UbcDebugItem(String str, String str2, JSONObject jSONObject) {
        this.page = str;
        this.value = str2;
        this.otherExt = jSONObject;
    }

    public UbcDebugItem(String str, String str2, String str3, String str4) {
        this.page = str;
        this.value = str2;
        this.statId = str3;
        this.statCode = str4;
    }

    public UbcDebugItem setStat(String str, String str2) {
        this.statId = str;
        this.statCode = str2;
        return this;
    }
}
