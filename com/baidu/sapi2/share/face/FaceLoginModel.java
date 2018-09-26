package com.baidu.sapi2.share.face;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FaceLoginModel {
    public static final String KEY_DISPLAY_NAME = "eman_yalpsid";
    public static final String KEY_ENCRYPT_LIVING_UID = "diu_ne";
    public static final String KEY_FACE_LOGIN_CHECK_RESUTL = "face_check_result";
    public static final String KEY_FACE_LOGIN_CHECK_TIME = "face_check_time";
    public static final String KEY_LAST_LOGIN_TIME = "last_time";
    public String cuid;
    public String displayName;
    public String faceCheckStr;
    public long faceLoginCheckTime;
    public long lastLoginTime;
    public String livingUid;

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_ENCRYPT_LIVING_UID, this.livingUid);
            jSONObject.put(KEY_FACE_LOGIN_CHECK_RESUTL, this.faceCheckStr);
            jSONObject.put(KEY_FACE_LOGIN_CHECK_TIME, this.faceLoginCheckTime);
            jSONObject.put(KEY_DISPLAY_NAME, this.displayName);
            jSONObject.put("cuid", this.cuid);
            jSONObject.put(KEY_LAST_LOGIN_TIME, this.lastLoginTime);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public static FaceLoginModel fromJSON(JSONObject jSONObject) {
        FaceLoginModel faceLoginModel = new FaceLoginModel();
        faceLoginModel.livingUid = jSONObject.optString(KEY_ENCRYPT_LIVING_UID);
        faceLoginModel.faceCheckStr = jSONObject.optString(KEY_FACE_LOGIN_CHECK_RESUTL);
        faceLoginModel.faceLoginCheckTime = jSONObject.optLong(KEY_FACE_LOGIN_CHECK_TIME);
        faceLoginModel.cuid = jSONObject.optString("cuid");
        faceLoginModel.displayName = jSONObject.optString(KEY_DISPLAY_NAME);
        faceLoginModel.lastLoginTime = jSONObject.optLong(KEY_LAST_LOGIN_TIME);
        return faceLoginModel;
    }

    public int getFaceCheckErrno() {
        try {
            return new JSONObject(this.faceCheckStr).optInt("errno");
        } catch (JSONException e) {
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }
    }
}
