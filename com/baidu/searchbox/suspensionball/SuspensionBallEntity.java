package com.baidu.searchbox.suspensionball;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SuspensionBallEntity extends BaseEntity {
    private static final String KEY_CLICKTIMES = "clicktimes";
    private static final String KEY_CREATETIME = "createtime";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_KEY = "key";
    public static final String KEY_SCHEME = "scheme";
    public static final String KEY_UBC_PAGE = "page";
    public String extra;
    public String image;
    public String page;
    public String scheme;
    long createTime = System.currentTimeMillis();
    int clickTimes = 0;
    SuspensionBallView mView = null;

    public SuspensionBallEntity() {
    }

    public SuspensionBallEntity(String str, String str2) {
        this.key = str;
        this.scheme = str2;
    }

    public SuspensionBallEntity(String str, String str2, String str3) {
        this.key = str;
        this.page = str2;
        this.scheme = str3;
    }

    public void update(SuspensionBallEntity suspensionBallEntity) {
        if (suspensionBallEntity != null) {
            this.key = suspensionBallEntity.key;
            this.image = suspensionBallEntity.image;
            this.scheme = suspensionBallEntity.scheme;
            this.page = suspensionBallEntity.page;
            this.extra = suspensionBallEntity.extra;
            this.createTime = suspensionBallEntity.createTime;
            this.clickTimes = suspensionBallEntity.clickTimes;
        }
    }

    public void updateModelWithJson(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(jSONObject.optString("image"))) {
                    this.image = jSONObject.getString("image");
                }
                if (!TextUtils.isEmpty(jSONObject.optString(KEY_SCHEME))) {
                    this.scheme = SuspensionSchemeUtil.schemeAddSuspensionKey(jSONObject.getString(KEY_SCHEME), str);
                }
                if (!TextUtils.isEmpty(jSONObject.optString("page"))) {
                    this.page = jSONObject.getString("page");
                }
                if (!TextUtils.isEmpty(jSONObject.optString("extra"))) {
                    this.extra = jSONObject.getString("extra");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLegal() {
        return (TextUtils.isEmpty(this.key) || TextUtils.isEmpty(this.scheme)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.key);
            jSONObject.put("image", this.image);
            jSONObject.put(KEY_SCHEME, this.scheme);
            jSONObject.put("page", this.page);
            jSONObject.put("extra", this.extra);
            jSONObject.put(KEY_CREATETIME, this.createTime);
            jSONObject.put(KEY_CLICKTIMES, this.clickTimes);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SuspensionBallEntity fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SuspensionBallEntity suspensionBallEntity = new SuspensionBallEntity();
        suspensionBallEntity.key = jSONObject.optString("key", "");
        suspensionBallEntity.image = jSONObject.optString("image", "");
        suspensionBallEntity.scheme = jSONObject.optString(KEY_SCHEME, "");
        suspensionBallEntity.page = jSONObject.optString("page", "");
        suspensionBallEntity.extra = jSONObject.optString("extra", "");
        suspensionBallEntity.createTime = jSONObject.optLong(KEY_CREATETIME, System.currentTimeMillis());
        suspensionBallEntity.clickTimes = jSONObject.optInt(KEY_CLICKTIMES, 0);
        return suspensionBallEntity;
    }
}
