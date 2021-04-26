package com.baidu.minivideo.plugin.capture.bean;

import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HttpRequestPublishModule {
    public static final int HTTP_NO_ERROR = 0;

    /* loaded from: classes2.dex */
    public static class ImageData {
        public int height;
        public String url;
        public int width;
    }

    /* loaded from: classes2.dex */
    public static class PopInfoDaLiBao implements Jsonable {
        public boolean enabled = false;
        public int points;
        public String text;
        public int time;

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public boolean parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.enabled = jSONObject.optBoolean(SapiOptions.KEY_CACHE_ENABLED);
                this.text = jSONObject.optString("text");
                this.time = jSONObject.optInt("time");
                this.points = jSONObject.optInt("points");
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return true;
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            JSONObject jSONObject;
            Exception e2;
            try {
                jSONObject = new JSONObject();
            } catch (Exception e3) {
                jSONObject = null;
                e2 = e3;
            }
            try {
                jSONObject.put(SapiOptions.KEY_CACHE_ENABLED, this.enabled);
                jSONObject.put("text", this.text);
                jSONObject.put("time", this.time);
                jSONObject.put("points", this.points);
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class ShareData implements Jsonable {
        public String content;
        public String icon;
        public String link;
        public String shareText;
        public String title;

        public ShareData() {
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
                this.icon = jSONObject.optString("icon");
                this.shareText = jSONObject.optString("shareText");
                return true;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return true;
            }
        }

        @Override // com.baidu.minivideo.plugin.capture.bean.Jsonable
        public JSONObject toJson() {
            JSONObject jSONObject;
            Exception e2;
            try {
                jSONObject = new JSONObject();
            } catch (Exception e3) {
                jSONObject = null;
                e2 = e3;
            }
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
                jSONObject.put("link", this.link);
                jSONObject.put("icon", this.icon);
                jSONObject.put("shareText", this.shareText);
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                return jSONObject;
            }
            return jSONObject;
        }
    }

    /* loaded from: classes2.dex */
    public static class VideoUploadModel {
        public String coverUrl;
        public String duration;
        public String height;
        public String mediaId;
        public String size;
        public String width;
    }
}
