package com.baidu.live.tbadk.coreextra.data;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PhotoUrlData implements Serializable {
    private static final long serialVersionUID = -6994746964706195260L;
    private String bigurl;
    private String height;
    private String pic;
    private String picId;
    private String smallurl;
    private String toServerPhotoInfo;
    private String width;

    public String getPic() {
        return this.pic;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public String getWidth() {
        return this.width;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public String getPicId() {
        return this.picId;
    }

    public void setPicId(String str) {
        this.picId = str;
    }

    public String getSmallurl() {
        return this.smallurl;
    }

    public void setSmallurl(String str) {
        this.smallurl = str;
    }

    public String getBigurl() {
        return this.bigurl;
    }

    public void setBigurl(String str) {
        this.bigurl = str;
    }

    public String getToServerPhotoInfo() {
        return this.toServerPhotoInfo;
    }

    public void setToServerPhotoInfo(String str) {
        this.toServerPhotoInfo = str;
        parsePicInfo(str);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("smallUrl", this.smallurl);
            jSONObject.put("bigurl", this.bigurl);
            jSONObject.put("picId", this.picId);
            jSONObject.put("toServerPhotoInfo", this.toServerPhotoInfo);
            return jSONObject;
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        this.smallurl = jSONObject.optString("smallurl", "");
        this.bigurl = jSONObject.optString("bigurl", "");
        this.picId = jSONObject.optString("picId", "");
        this.toServerPhotoInfo = jSONObject.optString("toServerPhotoInfo", "");
        parsePicInfo(this.toServerPhotoInfo);
    }

    private void parsePicInfo(String str) {
        if (!StringUtils.isNull(str)) {
            str.replaceAll("#\\(|\\)", "");
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 4) {
                this.pic = split[0];
                this.picId = split[1];
                this.width = split[2];
                this.height = split[3];
            }
        }
    }

    public static String serializableJson(PhotoUrlData photoUrlData) {
        if (photoUrlData == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("smallurl", photoUrlData.smallurl);
            jSONObject.put("bigurl", photoUrlData.bigurl);
            jSONObject.put("picId", photoUrlData.picId);
            jSONObject.put("toServerPhotoInfo", photoUrlData.toServerPhotoInfo);
            jSONObject.put("pic", photoUrlData.pic);
            jSONObject.put("width", photoUrlData.width);
            jSONObject.put("height", photoUrlData.height);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static PhotoUrlData fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.smallurl = jSONObject.optString("smallurl");
            photoUrlData.bigurl = jSONObject.optString("bigurl");
            photoUrlData.picId = jSONObject.optString("picId");
            photoUrlData.toServerPhotoInfo = jSONObject.optString("toServerPhotoInfo");
            photoUrlData.pic = jSONObject.optString("pic");
            photoUrlData.width = jSONObject.optString("width");
            photoUrlData.height = jSONObject.optString("height");
            return photoUrlData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
