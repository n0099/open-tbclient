package com.baidu.ala.recorder.video;

import android.util.Log;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.e;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class LogReport {
    private static final String TAG = "DuAr_Report";
    public static AlaRecorderLog mRecorderLog;

    public static void init(AlaRecorderLog alaRecorderLog) {
        if (isDebug()) {
            Log.d(TAG, OneKeyLoginSdkCall.l + alaRecorderLog);
        }
        mRecorderLog = alaRecorderLog;
        b.a(new e() { // from class: com.baidu.ala.recorder.video.LogReport.1
            @Override // com.baidu.minivideo.arface.e
            public void report(String str, JSONObject jSONObject) {
                LogReport.logArFaceReport(str, jSONObject);
            }
        });
    }

    public static void logCameraStart(AlaRecorderLog.CameraInfo cameraInfo) {
        if (mRecorderLog != null) {
            mRecorderLog.logCameraStart(cameraInfo);
        }
    }

    public static void logCameraError(int i, String str) {
        if (mRecorderLog != null) {
            mRecorderLog.logCameraError(i, str);
        }
    }

    public static void logEvent(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        if (isDebug()) {
            Log.d(TAG, "id:" + str + ", type:" + str2 + ", page:" + str3 + ", value:" + str4 + ", ext:" + jSONObject.toString());
        }
        if (mRecorderLog != null) {
            mRecorderLog.logEvent(str, str2, str3, str4, jSONObject);
        }
    }

    public static void logArFaceReport(String str, JSONObject jSONObject) {
        try {
            jSONObject.put(AlaRecorderLog.KEY_CONTENT_EXT_RES_ID, mRecorderLog.getResId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (AlaRecorderLog.NAME_BEAUTY_PERFORMANCE.equals(str)) {
            logEvent(AlaRecorderLog.BEAUTY_PERFORMANCE_LOG_ID, "0", "author_liveroom", str, jSONObject);
        } else {
            logEvent(AlaRecorderLog.BEAUTY_INFO_LOG_ID, "0", "author_liveroom", str, jSONObject);
        }
    }

    private static boolean isDebug() {
        return b.isDebug();
    }
}
