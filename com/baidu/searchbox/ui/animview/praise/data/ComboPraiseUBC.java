package com.baidu.searchbox.ui.animview.praise.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ComboPraiseUBC {
    public static final String UBC_DEFAULT_ICON_TYPE = "0";
    public static final String UBC_DEFAULT_PRAISE_ANIM_TYPE = "0";
    public static final String UBC_JSON_KEY_EXT = "ext";
    public static final String UBC_JSON_KEY_NID = "nid";
    public static final String UBC_JSON_KEY_SOURCE = "source";
    public static final String UBC_JSON_KEY_STRATEGY_INFO = "strategy_info";
    public String mAnimationName;
    public int mComboTimes;
    public String mCommentId;
    public String mIconType = "0";
    public String mNid;
    public String mPage;
    public String mSource;
    public String mStrategyInfo;
    public String mType;
    public String mValue;

    public ComboPraiseUBC() {
    }

    public String getAnimationName() {
        return this.mAnimationName;
    }

    public int getComboTimes() {
        return this.mComboTimes;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public String getIconType() {
        return this.mIconType;
    }

    public String getNid() {
        return this.mNid;
    }

    public String getPage() {
        return this.mPage;
    }

    public String getStrategyInfo() {
        return this.mStrategyInfo;
    }

    public String getType() {
        return this.mType;
    }

    public String getUBCSource() {
        return this.mSource;
    }

    public String getValue() {
        return this.mValue;
    }

    public ComboPraiseUBC(String str, String str2) {
        this.mSource = str;
        this.mNid = str2;
    }

    public ComboPraiseUBC(String str, String str2, String str3) {
        this.mSource = str;
        this.mNid = str2;
        this.mStrategyInfo = str3;
    }

    public ComboPraiseUBC(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.mType = str;
        this.mValue = str2;
        this.mPage = str3;
        this.mSource = str4;
        this.mCommentId = str5;
        this.mComboTimes = i;
        this.mAnimationName = str6;
    }

    public static ComboPraiseUBC parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ComboPraiseUBC comboPraiseUBC = new ComboPraiseUBC();
        comboPraiseUBC.mSource = jSONObject.optString("source", "");
        comboPraiseUBC.mNid = jSONObject.optString("nid", "");
        comboPraiseUBC.mStrategyInfo = jSONObject.optString("strategy_info", "");
        return comboPraiseUBC;
    }

    public void setAnimationName(String str) {
        this.mAnimationName = str;
    }

    public void setComboTimes(int i) {
        this.mComboTimes = i;
    }

    public void setCommentId(String str) {
        this.mCommentId = str;
    }

    public void setIconType(String str) {
        this.mIconType = str;
    }

    public void setNid(String str) {
        this.mNid = str;
    }

    public void setPage(String str) {
        this.mPage = str;
    }

    public void setStrategyInfo(String str) {
        this.mStrategyInfo = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setUBCSource(String str) {
        this.mSource = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }
}
