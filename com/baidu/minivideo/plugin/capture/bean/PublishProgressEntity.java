package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PublishProgressEntity implements Jsonable {
    public int mProgress;
    public String mVideoCover;
    public String mVideoPath;
    public int showWhere = 2;
    public int type;

    /* loaded from: classes3.dex */
    public interface ShowWhere {
        public static final int SHOW_FOLLOW = 2;
        public static final int SHOW_HOME_INDEX = 1;
    }

    /* loaded from: classes3.dex */
    public interface Type {
        public static final int PUBLISH_FAIL = 2;
        public static final int PUBLISH_PROGRESS = 4;
        public static final int PUBLISH_START = 1;
        public static final int PUBLISH_SUCCESS = 3;
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
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
        } catch (JSONException e) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj instanceof PublishProgressEntity) {
            PublishProgressEntity publishProgressEntity = (PublishProgressEntity) obj;
            if (this.mProgress == publishProgressEntity.mProgress && this.type == publishProgressEntity.type && this.showWhere == publishProgressEntity.showWhere) {
                if (this.mVideoCover != null) {
                    if (!this.mVideoCover.equals(publishProgressEntity.mVideoCover)) {
                        return false;
                    }
                } else if (publishProgressEntity.mVideoCover != null) {
                    return false;
                }
                if (this.mVideoPath != null) {
                    z = this.mVideoPath.equals(publishProgressEntity.mVideoPath);
                } else if (publishProgressEntity.mVideoPath != null) {
                    z = false;
                }
                return z;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.mVideoCover != null ? this.mVideoCover.hashCode() : 0) * 31) + (this.mVideoPath != null ? this.mVideoPath.hashCode() : 0)) * 31) + this.mProgress) * 31) + this.type) * 31) + this.showWhere;
    }
}
