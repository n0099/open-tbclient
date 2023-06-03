package com.baidu.searchbox.download.business.util;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadUtils {
    public static final String DOWNLOAD_END_TOAST = "download_end_toast";
    public static final String DOWNLOAD_END_TOAST_HIDE = "1";
    public static final String TAG = "DownloadUtils";

    public static ContentValues buildDownloadEndToastHide(ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DOWNLOAD_END_TOAST, "1");
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
        contentValues.put("extra_info", jSONObject.toString());
        return contentValues;
    }

    public static long getFileSize(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return file.length();
            }
            return 0L;
        }
        return 0L;
    }

    public static void safeRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context != null && broadcastReceiver != null && intentFilter != null) {
            try {
                context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "registerDownloadReceiver failed. " + e.getMessage());
                }
            }
        }
    }

    public static void safeUnRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        if (context != null && broadcastReceiver != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    Log.e(TAG, "registerDownloadReceiver failed. " + e);
                }
            }
        }
    }
}
