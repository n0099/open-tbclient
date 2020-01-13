package com.baidu.searchbox.ugc.model;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.b.b.b;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.model.PublishModels;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.MediaUtils;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.tbadk.TbConfig;
import com.google.gson.a.c;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest4util.EncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class HttpRequestPublishModule {
    public static final boolean DEBUG = false;
    private static final int HTTP_NO_ERROR = 0;
    private static final String RESPONSE_PARAMS_KEY = "params";
    private static final String RESPONSE_RNMSG_KEY = "rnmsg";
    private static final String RESPONSE_STATUS_KEY = "status";
    private static final String SIGN_SECRET = "BAIDU_SHOUBAI_DYNAMIC_TOPIC";
    private static final String TAG = HttpRequestPublishModule.class.getSimpleName();
    public static VideoUploadModel videoInfo;

    /* loaded from: classes12.dex */
    public static class Forward {
        @c("account_type")
        public String accountType;
        @c("attachment")
        public AttachmentInfo attachmentInfo;
        @c(TableDefine.PaSubscribeColumns.COLUMN_AVATAR)
        public String avatar;
        @c("channel")
        public String channel;
        @c("id")
        public String id;
        @c("nid")
        public String nid;
        @c("pic_count")
        public String picCount;
        @c("ref_type")
        public String refType;
        @c("thumbpic")
        public String thumbpic;
        @c("tid")
        public String tid;
        @c("title")
        public String title;
        @c("url")
        public String url;
        @c("video_duration")
        public String videoDuration;
    }

    /* loaded from: classes12.dex */
    public static class Target implements NoProGuard {
        @c("topics")
        public List<TopicItem> mTopicList = new ArrayList();
        @c("at")
        public List<AtUserInfoItem> mUserInfoList = new ArrayList();
        @c("link")
        public List<LinkInfoItem> mLinkInfoList = new ArrayList();
    }

    /* loaded from: classes12.dex */
    public static class VideoUploadModel {
        public String authorUK;
        public String bgSound;
        public String bgSoundRec;
        public String controls;
        public String coverUrl;
        public String duration;
        public String height;
        public String mediaId;
        public String musicName;
        public String size;
        public int soundSrc;
        public String source_url;
        public String videoFirstFrame;
        public String videoProductionType;
        public String width;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public void requestPublish(String str, Map<String, String> map, final PublishRequestListener publishRequestListener) {
        if (publishRequestListener != null) {
            try {
                ?? cookieManager = ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(b.nk().processUrl(UgcServerApiUtils.getHostAddress() + UgcServerApiUtils.PUBLISHER_ADDRESS_PATH))).addParams(map).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false));
                String publisherUserAgent = UgcServerApiUtils.getPublisherUserAgent();
                if (!TextUtils.isEmpty(publisherUserAgent)) {
                    cookieManager.addHeader("User-Agent", publisherUserAgent);
                }
                String referer = UgcServerApiUtils.getReferer();
                if (!TextUtils.isEmpty(referer)) {
                    cookieManager.addHeader("Referer", referer);
                }
                cookieManager.build().executeAsyncOnUIBack(new StringResponseCallback() { // from class: com.baidu.searchbox.ugc.model.HttpRequestPublishModule.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onSuccess(String str2, int i) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            String optString = jSONObject.optString("errno");
                            String optString2 = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
                            if (TextUtils.equals(optString, "0")) {
                                if (publishRequestListener != null) {
                                    publishRequestListener.onSuccess(str2);
                                }
                            } else if (publishRequestListener != null) {
                                publishRequestListener.onFailed(optString2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (publishRequestListener != null) {
                                publishRequestListener.onFailed("出错啦，请稍后重试");
                            }
                        }
                    }

                    @Override // com.baidu.searchbox.http.callback.ResponseCallback
                    public void onFail(Exception exc) {
                        if (publishRequestListener != null) {
                            publishRequestListener.onFailed("出错啦，请稍后重试");
                        }
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    public void requestPublish(JSONObject jSONObject, String str, String str2, String str3, List<PublishModels.ImageData> list, VideoUploadModel videoUploadModel, String str4, int i, int i2, String str5, String str6, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, final PublishModels.PublishCallback publishCallback) {
        new HashMap();
        Map<String, String> generateRequestPublishParams = generateRequestPublishParams(jSONObject, str2, str3, list, videoUploadModel, str4, i, i2, str5, str6, jSONObject2, jSONObject3, jSONObject4, jSONObject5, jSONObject6);
        if (generateRequestPublishParams.size() <= 0) {
            if (publishCallback != null) {
                publishCallback.onFailed(null);
                return;
            }
            return;
        }
        try {
            requestPublish(str, generateRequestPublishParams, new PublishRequestListener() { // from class: com.baidu.searchbox.ugc.model.HttpRequestPublishModule.2
                @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
                public void onSuccess(String str7) {
                    String str8 = null;
                    try {
                        JSONObject jSONObject7 = new JSONObject(str7);
                        String optString = jSONObject7.optString("errno");
                        str8 = jSONObject7.optString(BaseJsonData.TAG_ERRMSG);
                        PublishModels.PublishResultInfo parsePublishResponse = HttpRequestPublishModule.parsePublishResponse(jSONObject7);
                        if (!TextUtils.equals(optString, "0") && parsePublishResponse != null) {
                            if (publishCallback != null) {
                                publishCallback.onFailed(str8);
                            }
                        } else if (parsePublishResponse != null && publishCallback != null) {
                            publishCallback.onSuccess(parsePublishResponse);
                            return;
                        }
                    } catch (Exception e) {
                    }
                    if (publishCallback != null) {
                        publishCallback.onFailed(str8);
                    }
                }

                @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
                public void onFailed(String str7) {
                    if (publishCallback != null) {
                        publishCallback.onFailed(str7);
                    }
                }
            });
        } catch (Exception e) {
            if (publishCallback != null) {
                publishCallback.onFailed(null);
            }
        }
    }

    public static PublishModels.PublishResultInfo parsePublishResponse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return null;
        }
        PublishModels.PublishResultInfo publishResultInfo = new PublishModels.PublishResultInfo();
        PublishModels.PublishData publishData = new PublishModels.PublishData();
        publishData.errmsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
        PublishModels.PublishSubData publishSubData = new PublishModels.PublishSubData();
        publishSubData.metaId = optJSONObject.optString("meta_id");
        publishSubData.isTransfer = optJSONObject.optString("is_transfer");
        publishSubData.mediaType = optJSONObject.optString("media_type");
        publishSubData.vid = optJSONObject.optString(LogConfig.LOG_VID);
        publishSubData.coverImg = optJSONObject.optString("cover_img");
        publishSubData.videoUrl = optJSONObject.optString("video_url");
        publishData.subData = publishSubData;
        publishResultInfo.data = publishData;
        publishResultInfo.requestId = generateCallbackResult(optJSONObject);
        return publishResultInfo;
    }

    public static String generateCallbackResult(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", 0);
            jSONObject2.put("params", jSONObject);
            jSONObject2.put("rnmsg", "ugcpublish");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject2.toString();
    }

    public static Map<String, String> generateRequestPublishParams(JSONObject jSONObject, String str, String str2, List<PublishModels.ImageData> list, VideoUploadModel videoUploadModel, String str3, int i, int i2, String str4, String str5, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6) {
        String str6;
        try {
            jSONObject.put("title", str);
            jSONObject.put("content", str2);
            jSONObject.put("source_from", str3);
            jSONObject.put("sourceid", i + "");
            jSONObject.put("source_type", i2 + "");
            jSONObject.put("topic", jSONObject2);
            jSONObject.put("ext_info", jSONObject3);
            jSONObject.put("publishType", str4);
            JSONArray jSONArray = new JSONArray();
            if (list != null && list.size() > 0) {
                for (PublishModels.ImageData imageData : list) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("url", imageData.url);
                    jSONObject7.put("width", imageData.width + "");
                    jSONObject7.put("height", imageData.height + "");
                    jSONObject7.put(TiebaInitialize.LogFields.SIZE, imageData.size + "");
                    jSONArray.put(jSONObject7);
                }
            }
            jSONObject.put(TbConfig.IMAGE_CACHE_DIR_NAME, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject8 = new JSONObject();
            if (videoUploadModel != null && !TextUtils.isEmpty(videoUploadModel.mediaId)) {
                jSONObject8.put("mediaId", videoUploadModel.mediaId);
                jSONObject8.put("cover_img", videoUploadModel.coverUrl);
                jSONObject8.put(TiebaInitialize.LogFields.SIZE, videoUploadModel.size);
                jSONObject8.put("duration", videoUploadModel.duration);
                jSONObject8.put("height_in_pixel", videoUploadModel.height);
                jSONObject8.put("width_in_pixel", videoUploadModel.width);
                jSONObject8.put("source_key", str5);
                jSONObject8.put("author_uk", videoUploadModel.authorUK);
                jSONObject8.put("music_name", videoUploadModel.musicName);
                jSONObject8.put("sound_src", videoUploadModel.soundSrc);
                jSONObject8.put("bg_sound", videoUploadModel.bgSound);
                jSONObject8.put("bg_sound_rec", videoUploadModel.bgSoundRec);
                jSONObject8.put("production_type", videoUploadModel.videoProductionType);
                jSONObject8.put("video_first_frame", videoUploadModel.videoFirstFrame);
                jSONArray2.put(jSONObject8);
            }
            jSONObject.put("videos", jSONArray2);
            jSONObject.put("uk", UgcLoginUtils.getUK());
            jSONObject.put("question_reply", jSONObject4);
            jSONObject.put(UgcConstant.QUESTION_ASK, jSONObject6);
            if (jSONObject5 != null) {
                jSONObject.put("swan", jSONObject5);
            }
            JSONObject jSONObject9 = new JSONObject();
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put("location", "");
            jSONObject10.put("apinfo", "");
            jSONObject9.put("info", jSONObject10);
            jSONObject9.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis());
            jSONObject9.put("data", jSONObject);
            if (Build.VERSION.SDK_INT < 8) {
                str6 = null;
            } else {
                str6 = new String(Base64.encode(jSONObject9.toString().getBytes(), 0));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("sign", getSign(str6, SIGN_SECRET));
            hashMap.put("base64", str6);
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> generateRequestPublishParams(JSONObject jSONObject, int i, String str, String str2, List<PublishModels.ImageData> list, VideoUploadModel videoUploadModel, String str3, int i2, int i3, String str4, String str5, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, JSONObject jSONObject7) {
        try {
            jSONObject.put(UgcConstant.SERVER_TOPICS_RULE, i + "");
            jSONObject.put("location", jSONObject3);
            new HashMap();
            return generateRequestPublishParams(jSONObject, str, str2, list, videoUploadModel, str3, i2, i3, str4, str5, jSONObject2, jSONObject4, jSONObject5, jSONObject6, jSONObject7);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequiresApi(api = 10)
    public static VideoUploadModel getVideoInfo(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        VideoUploadModel videoUploadModel = new VideoUploadModel();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            mediaMetadataRetriever = FileUtils.getMediaMetadataRetriever(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
        String valueOf = String.valueOf(MediaUtils.getMediaSize(str));
        videoUploadModel.duration = String.valueOf(Integer.parseInt(extractMetadata) / 1000);
        videoUploadModel.size = valueOf;
        videoUploadModel.height = extractMetadata2;
        videoUploadModel.width = extractMetadata3;
        return videoUploadModel;
    }

    public static VideoUploadModel getVideoUploadInfo() {
        return videoInfo;
    }

    public static String getSign(String str, String str2) {
        return EncryptUtils.encrypt("MD5", (str + str2).getBytes(), false);
    }
}
