package com.baidu.searchbox.picture.model;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PictureInfo {
    public int count;
    public int index;
    public String mDescription;
    public int mOriginSize;
    public String mOriginUrl;
    private String mReferrer;
    private String mSource;
    public String mTitle;
    public String mUrl;
    public String nid;
    public int pos;
    public int posInData;

    public PictureInfo() {
        this.mSource = "";
    }

    public PictureInfo(String str, String str2, String str3) {
        this(str, null, str2, str3);
    }

    public PictureInfo(String str, String str2, int i) {
        this(str, null, "", "", str2, i);
    }

    public PictureInfo(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, "", -1);
    }

    public PictureInfo(String str, String str2, String str3, String str4, String str5, int i) {
        this.mSource = "";
        this.mUrl = str;
        this.mReferrer = str2;
        this.mTitle = str3;
        this.mDescription = str4;
        this.mOriginUrl = str5;
        this.mOriginSize = i;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getReferrer() {
        return this.mReferrer;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public int getOriginSize() {
        return this.mOriginSize;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public static PictureInfo jsonToObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PictureInfo pictureInfo = new PictureInfo();
        pictureInfo.mUrl = jSONObject.optString("mUrl");
        pictureInfo.mDescription = jSONObject.optString("mDescription");
        pictureInfo.mReferrer = jSONObject.optString("mReferrer");
        pictureInfo.mTitle = jSONObject.optString("mTitle");
        pictureInfo.mOriginUrl = jSONObject.optString("origin_url");
        pictureInfo.mOriginSize = jSONObject.optInt("origin_size");
        pictureInfo.nid = jSONObject.optString("nid");
        pictureInfo.mSource = jSONObject.optString("source");
        return pictureInfo;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mUrl", this.mUrl);
            jSONObject.put("mDescription", this.mDescription);
            jSONObject.put("mReferrer", this.mReferrer);
            jSONObject.put("mTitle", this.mTitle);
            jSONObject.put("origin_url", this.mOriginUrl);
            jSONObject.put("origin_size", this.mOriginSize);
            jSONObject.put("nid", this.nid);
            jSONObject.put("source", this.mSource);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean isPicInfoEquals(PictureInfo pictureInfo, PictureInfo pictureInfo2) {
        if (pictureInfo == null || pictureInfo2 == null) {
            return false;
        }
        return TextUtils.equals(pictureInfo.mUrl, pictureInfo2.mUrl);
    }
}
