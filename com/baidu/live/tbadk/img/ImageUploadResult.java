package com.baidu.live.tbadk.img;

import com.baidu.live.adp.lib.util.BdLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class ImageUploadResult implements Serializable {
    public long picId;
    public static int INTER_ERROR_FILE_ERROR = -1;
    public static int INTER_ERROR_SEND_ERROR = -2;
    public static int INTER_ERROR_SEND_CALCELLED = -3;
    public static int CHUNK_ERROR = 2230203;
    public int error_code = 0;
    public String error_msg = null;
    public String resourceId = null;
    public int chunkNo = 0;
    public picInfo picInfo = null;

    public UploadedImageInfo getUploadedPicInfo() {
        if (this.picInfo == null || this.error_code != 0) {
            return null;
        }
        UploadedImageInfo uploadedImageInfo = new UploadedImageInfo();
        uploadedImageInfo.setPic_id(String.valueOf(this.picId));
        if (this.picInfo != null && this.picInfo.originPic != null) {
            uploadedImageInfo.setHeight(this.picInfo.originPic.height);
            uploadedImageInfo.setWidth(this.picInfo.originPic.width);
            return uploadedImageInfo;
        }
        return uploadedImageInfo;
    }

    public static ImageUploadResult parser(String str) {
        JSONObject jSONObject;
        ImageUploadResult imageUploadResult = new ImageUploadResult();
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            imageUploadResult.error_code = jSONObject.optInt("error_code");
            imageUploadResult.error_msg = jSONObject.optString("error_msg");
            imageUploadResult.resourceId = jSONObject.optString("resourceId");
            imageUploadResult.chunkNo = jSONObject.optInt("chunkNo");
            imageUploadResult.picId = jSONObject.optInt("picId");
            JSONObject optJSONObject = jSONObject.optJSONObject("picInfo");
            if (optJSONObject != null) {
                imageUploadResult.picInfo = new picInfo();
                imageUploadResult.picInfo.parseJson(optJSONObject);
            }
        }
        return imageUploadResult;
    }

    /* loaded from: classes11.dex */
    public static class picInfo implements Serializable {
        public PicDetailedInfo bigPic;
        public PicDetailedInfo originPic;
        public PicDetailedInfo smallPic;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.bigPic != null) {
                    jSONObject.put("bigPic", this.bigPic.toJson());
                }
                if (this.smallPic != null) {
                    jSONObject.put("smallPic", this.smallPic.toJson());
                }
                if (this.originPic != null) {
                    jSONObject.put("originPic", this.originPic.toJson());
                }
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
            return jSONObject;
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.bigPic = new PicDetailedInfo();
                this.bigPic.parseJson(jSONObject.optJSONObject("bigPic"));
                this.smallPic = new PicDetailedInfo();
                this.smallPic.parseJson(jSONObject.optJSONObject("smallPic"));
                this.originPic = new PicDetailedInfo();
                this.originPic.parseJson(jSONObject.optJSONObject("originPic"));
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class PicDetailedInfo implements Serializable {
        public int height;
        public String picUrl;
        public int type;
        public int width;

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", this.width);
                jSONObject.put("height", this.height);
                jSONObject.put("picUrl", this.picUrl);
            } catch (JSONException e) {
                BdLog.e(e.getMessage());
            }
            return jSONObject;
        }

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.width = jSONObject.optInt("width");
                this.height = jSONObject.optInt("height");
                this.picUrl = jSONObject.optString("picUrl");
            }
        }
    }
}
