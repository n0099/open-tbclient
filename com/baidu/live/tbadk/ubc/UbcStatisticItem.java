package com.baidu.live.tbadk.ubc;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UbcStatisticItem {
    private String mContentPage;
    private String mContentType;
    private String mContentValue;
    private JSONObject mExtJson;
    private String mId;
    private String mLoc;
    private String mSubPage;

    public UbcStatisticItem(String str) {
        this.mId = str;
    }

    public UbcStatisticItem(String str, String str2, String str3, String str4) {
        this.mId = str;
        setType(str2);
        setPage(str3);
        setValue(str4);
    }

    public UbcStatisticItem setType(String str) {
        this.mContentType = str;
        return this;
    }

    public UbcStatisticItem setPage(String str) {
        this.mContentPage = str;
        return this;
    }

    public UbcStatisticItem setValue(String str) {
        this.mContentValue = str;
        return this;
    }

    public UbcStatisticItem setContentExt(String str, String str2, JSONObject jSONObject) {
        this.mExtJson = jSONObject;
        this.mLoc = str;
        this.mSubPage = str2;
        if (this.mExtJson == null) {
            this.mExtJson = new JSONObject();
        }
        return this;
    }

    public UbcStatisticItem setContentExt(JSONObject jSONObject) {
        this.mExtJson = jSONObject;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getContentPage() {
        return this.mContentPage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getContentValue() {
        return this.mContentValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getContentType() {
        return this.mContentType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLoc() {
        return this.mLoc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getSubPage() {
        return this.mSubPage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject getContentExt() {
        return this.mExtJson;
    }
}
