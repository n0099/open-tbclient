package com.baidu.searchbox.toolbar;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WendaToolBarItem extends BaseToolBarItem {
    public JSONObject extObj;
    public String mJumpScheme;
    public int mStatus;

    public WendaToolBarItem(int i) {
        super(i);
    }

    public void setExtObj(JSONObject jSONObject) {
        this.extObj = jSONObject;
    }

    public void setJumpScheme(String str) {
        this.mJumpScheme = str;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public WendaToolBarItem(int i, String str, int i2, JSONObject jSONObject) {
        super(i);
        this.mJumpScheme = str;
        this.mStatus = i2;
        this.extObj = jSONObject;
    }

    public JSONObject getExtObj() {
        return this.extObj;
    }

    public String getJumpScheme() {
        return this.mJumpScheme;
    }

    public int getStatus() {
        return this.mStatus;
    }
}
