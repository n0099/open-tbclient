package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PublishProgressEntity implements Jsonable {
    public int mProgress;
    public String mVideoCover;
    public String mVideoPath;
    public int showWhere = 2;
    public int type;

    /* loaded from: classes2.dex */
    public interface ShowWhere {
        public static final int SHOW_FOLLOW = 2;
        public static final int SHOW_HOME_INDEX = 1;
    }

    /* loaded from: classes2.dex */
    public interface Type {
        public static final int PUBLISH_FAIL = 2;
        public static final int PUBLISH_PROGRESS = 4;
        public static final int PUBLISH_START = 1;
        public static final int PUBLISH_SUCCESS = 3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PublishProgressEntity) {
            PublishProgressEntity publishProgressEntity = (PublishProgressEntity) obj;
            if (this.mProgress == publishProgressEntity.mProgress && this.type == publishProgressEntity.type && this.showWhere == publishProgressEntity.showWhere) {
                String str = this.mVideoCover;
                if (str == null ? publishProgressEntity.mVideoCover == null : str.equals(publishProgressEntity.mVideoCover)) {
                    String str2 = this.mVideoPath;
                    String str3 = publishProgressEntity.mVideoPath;
                    return str2 != null ? str2.equals(str3) : str3 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mVideoCover;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mVideoPath;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mProgress) * 31) + this.type) * 31) + this.showWhere;
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mVideoCover = jSONObject.optString("mVideoCover");
            this.mVideoPath = jSONObject.optString("mVideoPath");
            this.mProgress = jSONObject.optInt("mProgress");
            this.type = jSONObject.optInt("type");
            this.showWhere = jSONObject.optInt("showWhere");
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mVideoCover", this.mVideoCover);
            jSONObject.put("mVideoPath", this.mVideoPath);
            jSONObject.put("mProgress", this.mProgress);
            jSONObject.put("type", this.type);
            jSONObject.put("showWhere", this.showWhere);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
