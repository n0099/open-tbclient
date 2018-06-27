package com.baidu.sapi2.share.face;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FaceLoginModel {
    public static final String DISPLAY_NAME = "eman_yalpsid";
    public static final String ENCRYPT_LIVING_UID = "diu_ne";
    public static final String FACE_LOGIN_CHECK_RESUTL = "face_check_result";
    public static final String FACE_LOGIN_CHECK_TIME = "face_check_time";
    public String cuid;
    public String displayName;
    public String faceCheckStr;
    public long faceLoginCheckTime;
    public String livingUid;

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ENCRYPT_LIVING_UID, this.livingUid);
            jSONObject.put(FACE_LOGIN_CHECK_RESUTL, this.faceCheckStr);
            jSONObject.put(FACE_LOGIN_CHECK_TIME, this.faceLoginCheckTime);
            jSONObject.put(DISPLAY_NAME, this.displayName);
            jSONObject.put("cuid", this.cuid);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    public static FaceLoginModel fromJSON(JSONObject jSONObject) {
        FaceLoginModel faceLoginModel = new FaceLoginModel();
        faceLoginModel.livingUid = jSONObject.optString(ENCRYPT_LIVING_UID);
        faceLoginModel.faceCheckStr = jSONObject.optString(FACE_LOGIN_CHECK_RESUTL);
        faceLoginModel.faceLoginCheckTime = jSONObject.optLong(FACE_LOGIN_CHECK_TIME);
        faceLoginModel.cuid = jSONObject.optString("cuid");
        faceLoginModel.displayName = jSONObject.optString(DISPLAY_NAME);
        return faceLoginModel;
    }

    public int getFaceCheckErrno() {
        try {
            return new JSONObject(this.faceCheckStr).optInt("errno");
        } catch (JSONException e) {
            return -1;
        }
    }
}
