package com.baidu.searchbox.ugc.utils;

import com.baidu.searchbox.config.AppConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class UgcRDUBCUtils {
    public static final String ALBUM_IMAGE = "image";
    public static final String ALBUM_VIDEO = "video";
    public static final String IMAGE_UPLOAD = "image_upload";
    public static final String PAGE_HOST = "host";
    public static final String PAGE_PLUGIN = "plugin";
    public static final String RESULT_CANCEL = "cancel";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_SUCCESS = "success";
    public static final String UBC_UGC_RD_ID = "1097";
    private static final boolean sDebug = AppConfig.isDebug();

    public static void uploadImageStatistics(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", IMAGE_UPLOAD);
            jSONObject.put("page", str);
            jSONObject.put("source", str2);
            jSONObject.put("value", str3);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void videoClipEntranceStatistics(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "video_clip_entrance");
            jSONObject.put("page", "VideoClipActivity");
            jSONObject.putOpt("source", str);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void videoClipPlayErrorStatistics(int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "clip_mediaplayer_error");
            jSONObject.put("page", "VideoClipActivity");
            jSONObject.put("source", i);
            jSONObject.put("value", i2);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcSchemaEntranceStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_schema_entrance");
            jSONObject.putOpt("source", str);
            jSONObject.putOpt("from", str2);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcMenuClickStatistics(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_menu_click");
            jSONObject.putOpt("source", str);
            jSONObject.putOpt("from", str2);
            jSONObject.putOpt("value", str3);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcPublishCallbackStatistics(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_publish_callback");
            jSONObject.putOpt("source", str);
            jSONObject.putOpt("from", str2);
            jSONObject.putOpt("value", str3);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcNAVideoShareEntranceStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_nashare_entrance");
            jSONObject.putOpt("source", str);
            jSONObject.putOpt("from", str2);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcNAShareNextStatistics(String str, String str2, String str3) {
        UgcUbcDataKeeper.setNaShareSourceFrom(str);
        UgcUbcDataKeeper.setNaSharePublishType(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_nashare_next");
            jSONObject.putOpt("source", str);
            jSONObject.putOpt("from", str2);
            jSONObject.putOpt("value", str3);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcNAShareCallbackStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "ugc_nashare_callback");
            jSONObject.putOpt("source", UgcUbcDataKeeper.getNaShareSourceFrom());
            jSONObject.putOpt("from", UgcUbcDataKeeper.getNaSharePublishType());
            jSONObject.putOpt("value", str);
            jSONObject.putOpt("page", str2);
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcVideoCompressStatistics(int i, boolean z, long j, long j2, long j3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", "video_upload_compress");
            jSONObject.putOpt("page", UgcUbcDataKeeper.getVideoUploadVideoMime());
            jSONObject.putOpt("source", UgcUbcDataKeeper.getVideoUploadAudioMime());
            jSONObject.putOpt("value", Integer.valueOf(i));
            jSONObject.putOpt("from", Integer.valueOf(z ? 1 : 0));
            jSONObject2.putOpt("timing", Long.valueOf(j));
            jSONObject2.putOpt("sourceSize", Long.valueOf(j2));
            jSONObject2.putOpt("compressedSize", Long.valueOf(j3));
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    private static void ugcAlbumPerfStatistics(int i, String str, long j, int i2, int i3, int i4, CharSequence charSequence) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", "ugc_album_perf");
            jSONObject.putOpt("source", Integer.valueOf(i));
            jSONObject.putOpt("from", str);
            jSONObject2.putOpt("timing", Long.valueOf(j));
            jSONObject2.putOpt("totalNumber", Integer.valueOf(i2));
            jSONObject2.putOpt("firstIndex", Integer.valueOf(i3));
            jSONObject2.putOpt("lastIndex", Integer.valueOf(i4));
            jSONObject2.putOpt("bucketName", charSequence);
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e) {
            if (sDebug) {
                e.printStackTrace();
            }
        }
        UgcUBCUtils.ugcOnEvent(UBC_UGC_RD_ID, jSONObject.toString());
    }

    public static void ugcAlbumVideoPerfStatistics(int i, String str, long j, int i2, int i3) {
        ugcAlbumPerfStatistics(i, str, j, i2, i3, i3, "default");
    }

    public static void ugcAlbumPhotoPerfStatistics(int i, String str, long j, int i2, CharSequence charSequence) {
        ugcAlbumPerfStatistics(i, str, j, i2, SelectUtil.getPhotoFirstIndex(), SelectUtil.getPhotoLastIndex(), charSequence);
    }

    public static void votePublishCallbackStatistics() {
        ugcPublishCallbackStatistics(UgcUbcDataKeeper.getVoteSourceFrom(), "12", "success");
    }
}
