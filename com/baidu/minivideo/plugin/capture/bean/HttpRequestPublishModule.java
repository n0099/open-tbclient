package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HttpRequestPublishModule {
    private static final int HTTP_NO_ERROR = 0;

    /* loaded from: classes3.dex */
    public static class ImageData {
        public int height;
        public String url;
        public int width;
    }

    /* loaded from: classes3.dex */
    public static class VideoUploadModel {
        public String coverUrl;
        public String duration;
        public String height;
        public String mediaId;
        public String size;
        public String width;
    }

    /* loaded from: classes3.dex */
    public class PublishResultInfo {
        public String msg;
        public PopInfoDaLiBao popInfoDaLiBao;
        public ShareData share;
        public int status;
        public PublishData video;

        public PublishResultInfo() {
        }

        public boolean isResultCorrect() {
            return (this.status != 0 || this.video == null || this.share == null || this.popInfoDaLiBao == null) ? false : true;
        }
    }

    /* loaded from: classes3.dex */
    public static class PopInfoDaLiBao implements Jsonable {
        public boolean enabled = false;
        public int points;
        public String text;
        public int time;

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("enabled", this.enabled);
                    jSONObject.put("text", this.text);
                    jSONObject.put("time", this.time);
                    jSONObject.put("points", this.points);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    return jSONObject;
                }
            } catch (Exception e2) {
                e = e2;
                jSONObject = null;
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
                this.enabled = jSONObject.optBoolean("enabled");
                this.text = jSONObject.optString("text");
                this.time = jSONObject.optInt("time");
                this.points = jSONObject.optInt("points");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class PublishData {
        public String coverImg;
        public String duration;
        public String heightInPixel;
        public String isTransfer;
        public String mediaType;
        public String metaId;
        public String userType;
        public String vid;
        public String videoUrl;
        public String widthInPixel;

        public PublishData() {
        }
    }

    /* loaded from: classes3.dex */
    public class ShareData implements Jsonable {
        public String content;
        public String icon;
        public String link;
        public String shareText;
        public String title;

        public ShareData() {
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                e = e;
                jSONObject = null;
            }
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
                jSONObject.put("link", this.link);
                jSONObject.put(AlaStaticKeys.ALA_STATIC_VALUE_ICON, this.icon);
                jSONObject.put("shareText", this.shareText);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return jSONObject;
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
                this.title = jSONObject.optString("title");
                this.content = jSONObject.optString("content");
                this.link = jSONObject.optString("link");
                this.icon = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                this.shareText = jSONObject.optString("shareText");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
