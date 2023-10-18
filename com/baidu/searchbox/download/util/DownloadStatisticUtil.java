package com.baidu.searchbox.download.util;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.xw;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class DownloadStatisticUtil {
    public static final String EXT_KEY_PARTNER_NAME = "partner_name";

    public static String getSource(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 6 ? i != 8 ? i != 11 ? "other" : DownloadStatisticConstants.OFFLINE_PAGE : "zip" : "novel" : "file" : "app" : "picture" : "music" : "video";
    }

    public static void dialogClickBaiduDownload() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", DownloadStatisticConstants.UBC_VALUE_SAFETY_OPEN, "615");
    }

    public static void dialogClickCancel() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", "cancel", "615");
    }

    public static void dialogClickDownload() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", "download", "615");
    }

    public static void dialogClickFilePath() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", DownloadStatisticConstants.UBC_VALUE_MODIFY_PATH, "615");
    }

    public static void dialogClickYun() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", DownloadStatisticConstants.UBC_VALUE_YUN, "615");
    }

    public static void doLowTrafficDownloadClick() {
        ubc("tool", "click", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", DownloadStatisticConstants.UBC_VALUE_SAVE_TRAFFIC, "615");
    }

    public static void downloadDialogShow() {
        ubc("tool", "show", DownloadStatisticConstants.UBC_VALUE_OPENBOX, "", "", "615");
    }

    public static void duplicateDialogCancel() {
        ubc("tool", "click", "repeat", "", "close", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void duplicateDialogConfirm() {
        ubc("tool", "click", "repeat", "", "download", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void duplicateDialogShow() {
        ubc("tool", "show", "repeat", "", "", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void downloadNotificationClick(int i) {
        ubc("tool", "click", DownloadStatisticConstants.UBC_PAGE_NOTICE_BAR, getSource(i), "", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void downloadNotificationShow(int i) {
        ubc("tool", "show", DownloadStatisticConstants.UBC_PAGE_NOTICE_BAR, getSource(i), "downloading", DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static String getExtraPartnerSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(EXT_KEY_PARTNER_NAME);
            if (optJSONObject == null) {
                return "";
            }
            return optJSONObject.optString("source");
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static String getExtraSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("source");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void downloadNotificationClick(int i, String str) {
        ubc("tool", "click", DownloadStatisticConstants.UBC_PAGE_NOTICE_BAR, getSource(i), str, DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void downloadNotificationShow(int i, String str) {
        ubc("tool", "show", DownloadStatisticConstants.UBC_PAGE_NOTICE_BAR, getSource(i), str, DownloadStatisticConstants.DOWNLOAD_WINDOWN_UBC_ID);
    }

    public static void downloadTaskDoneToast(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("partner", str2);
            jSONObject.put(EXT_KEY_PARTNER_NAME, getExtraSource(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubc("tool", "show", "toast", "", DownloadStatisticConstants.UBC_VALUE_DOWNLOADED, "615", jSONObject.toString());
    }

    public static void downloadTaskStartToast(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("partner", str2);
            jSONObject.put(EXT_KEY_PARTNER_NAME, getExtraSource(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubc("tool", "show", "toast", "", DownloadStatisticConstants.UBC_VALUE_TASK, "615", jSONObject.toString());
    }

    public static void toastClickDone(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("partner", str2);
            jSONObject.put(EXT_KEY_PARTNER_NAME, getExtraSource(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubc("tool", "click", "toast", "", DownloadStatisticConstants.UBC_VALUE_DOWNLOADED, "615", jSONObject.toString());
    }

    public static void toastClickTask(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("partner", str2);
            jSONObject.put(EXT_KEY_PARTNER_NAME, getExtraSource(str3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ubc("tool", "click", "toast", "", DownloadStatisticConstants.UBC_VALUE_TASK, "615", jSONObject.toString());
    }

    public static void ubc(String str, String str2, String str3, String str4, String str5, String str6) {
        ubc(str, str2, str3, str4, str5, str6, "");
    }

    public static void ubc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (TextUtils.isEmpty(str6)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("from", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("type", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("page", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("source", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("value", str5);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONObject.put("ext", str7);
            }
            UBC.onEvent(str6, jSONObject.toString());
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
        xw.z(str6, jSONObject.toString());
    }
}
