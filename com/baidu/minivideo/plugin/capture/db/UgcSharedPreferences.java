package com.baidu.minivideo.plugin.capture.db;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.minivideo.plugin.capture.download.utils.LogUtils;
import com.baidu.minivideo.plugin.capture.utils.PreferenceUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UgcSharedPreferences {
    public static final String AUDIO_ROINTS_LIST = "audio_points_list";
    public static final String CAPTURE_CONFIG = "capture_config";
    public static final String ENCODE_HARD_SUPPORT_MAX_H = "encode_max_h";
    public static final String ENCODE_HARD_SUPPORT_MAX_W = "encode_max_w";
    public static final String FRONT_OR_BACK_CAMERA = "front_or_back_camera";
    public static final String KEY_BEAUTIFUL_LEVEL = "key_beautiful_level";
    public static final String KEY_CONFIG_DISPLAY_TIMES = "winDisplayTimes";
    public static final String KEY_FILTER = "key_filter";
    public static final String KEY_SAVE_VIDEO_LOACL = "save_video_local";
    public static final String KEY_THIN_FACE_LEVEL = "key_thin_face_level";
    public static final String LAST_CAPTURE_CONFIG_TIME = "last_capture_update_config";
    public static final String MUSIC_INFO = "music_info";
    public static final String SYNC_VIDEO_PUBLISH_CONFIG = "sync_video_publish_config";
    public static final String TAG = "UgcSharedPreferencesTAG";
    public static final String PREF = "bdminivideo_capture_sdk";
    public static SharedPreferences sPref = Application.get().getSharedPreferences(PREF, 0);

    public static int getBeautifulLevel() {
        return sPref.getInt(KEY_BEAUTIFUL_LEVEL, 65);
    }

    public static String getCaptureConfig() {
        return sPref.getString(CAPTURE_CONFIG, "");
    }

    public static Point getEncodeSupportMaxSize() {
        if (sPref.contains(ENCODE_HARD_SUPPORT_MAX_W)) {
            return new Point(sPref.getInt(ENCODE_HARD_SUPPORT_MAX_W, 0), sPref.getInt(ENCODE_HARD_SUPPORT_MAX_H, 0));
        }
        return null;
    }

    public static String getFilter() {
        return sPref.getString(KEY_FILTER, null);
    }

    public static long getLastCaptureConfigTime() {
        return sPref.getLong(LAST_CAPTURE_CONFIG_TIME, 0L);
    }

    public static int getSaveVideoLocalStatus() {
        return sPref.getInt(KEY_SAVE_VIDEO_LOACL, -1);
    }

    public static int getShootDisplayLimit() {
        return sPref.getInt(KEY_CONFIG_DISPLAY_TIMES, 0);
    }

    public static int getSyncIconCloseTimes(String str) {
        return sPref.getInt(str, 0);
    }

    public static String getSyncVideoPublishConfig() {
        return sPref.getString(SYNC_VIDEO_PUBLISH_CONFIG, "");
    }

    public static int getThinFaceLevel() {
        return sPref.getInt(KEY_THIN_FACE_LEVEL, 65);
    }

    public static boolean isFrontCamera() {
        return sPref.getBoolean(FRONT_OR_BACK_CAMERA, true);
    }

    public static void setBeautifulLevel(int i) {
        sPref.edit().putInt(KEY_BEAUTIFUL_LEVEL, i).apply();
    }

    public static void setCameraFront(boolean z) {
        sPref.edit().putBoolean(FRONT_OR_BACK_CAMERA, z).apply();
    }

    public static void setCaptureConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(CAPTURE_CONFIG, str).apply();
    }

    public static void setCreatorCenterConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("creatorCenter");
            if (optJSONObject != null) {
                LogUtils.d("mini_ugc_creator_center(app) --> " + optJSONObject.toString());
                PreferenceUtils.putString("mini_ugc_creator_center", optJSONObject.toString());
            } else {
                PreferenceUtils.putString("mini_ugc_creator_center", "");
            }
        } catch (Exception unused) {
            PreferenceUtils.putString("mini_ugc_creator_center", "");
        }
    }

    public static void setEncodeSupportMaxSize(Point point) {
        SharedPreferences.Editor edit = sPref.edit();
        if (point != null) {
            edit.putInt(ENCODE_HARD_SUPPORT_MAX_W, point.x);
            edit.putInt(ENCODE_HARD_SUPPORT_MAX_H, point.y).apply();
            return;
        }
        edit.remove(ENCODE_HARD_SUPPORT_MAX_W);
        edit.remove(ENCODE_HARD_SUPPORT_MAX_H).apply();
    }

    public static void setFilter(String str) {
        sPref.edit().putString(KEY_FILTER, str).apply();
    }

    public static void setLastCaptureConfigTime(long j) {
        sPref.edit().putLong(LAST_CAPTURE_CONFIG_TIME, j).apply();
    }

    public static void setSaveVideoLocalStatus(int i) {
        sPref.edit().putInt(KEY_SAVE_VIDEO_LOACL, i).apply();
    }

    public static void setShootDisplayLimit(int i) {
        sPref.edit().putInt(KEY_CONFIG_DISPLAY_TIMES, i).apply();
    }

    public static void setSyncIconCloseTimes(String str, int i) {
        sPref.edit().putInt(str, i).apply();
    }

    public static void setSyncVideoPublishConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sPref.edit().putString(SYNC_VIDEO_PUBLISH_CONFIG, str).apply();
    }

    public static void setThinFaceLevel(int i) {
        sPref.edit().putInt(KEY_THIN_FACE_LEVEL, i).apply();
    }
}
