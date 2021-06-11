package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.util.SendLogUtil;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoteCommonUtils {
    public static final String APPSID = "BaiduMobAd_APP_ID";
    public static final String DUMMY_ADSERV_VERSION = "4.1.30";
    public static final String MSG_DOWNLOADED_INSTALL_APP = "alreadydownloaded_call_installapp";
    public static final String MSG_DOWNLOADED_OPEN_APP = "alreadyinstalled_call_openapp";
    public static RemoteCommonUtils mInstance;
    public String appId;

    public static RemoteCommonUtils getInstance() {
        if (mInstance == null) {
            mInstance = new RemoteCommonUtils();
        }
        return mInstance;
    }

    public static boolean isLocalFileExist(JSONObject jSONObject) {
        try {
            File file = new File(jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.FOLDER) + jSONObject.optString("filename"));
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public String genCompleteErrorMessage(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    public String getBuyerFromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.BUYER, "");
            return TextUtils.isEmpty(optString) ? jSONObject.optString("buyer_id", "") : optString;
        }
        return "";
    }

    public String getStringFromJson(JSONObject jSONObject, String str) {
        return (jSONObject == null || TextUtils.isEmpty(str)) ? "" : jSONObject.optString(str, "");
    }

    public void printErrorMessageLog(int i2, String str, String str2) {
        RemoteXAdLogger.getInstance().e(getInstance().genCompleteErrorMessage(String.valueOf(i2), str, str2));
    }

    public void sendDownloadApkLog(Context context, int i2, String str, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        String str2;
        try {
            SendLogUtil.Builder create = SendLogUtil.Builder.create(context);
            create.appendType(i2);
            create.appendApId("");
            create.append("msg", str);
            if (xAdRemoteAPKDownloadExtraInfo != null) {
                create.append("prod", xAdRemoteAPKDownloadExtraInfo.getProd());
                create.appendAppSid(xAdRemoteAPKDownloadExtraInfo.getAppsid());
                create.append(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN, xAdRemoteAPKDownloadExtraInfo.autoOpen);
                create.append(XAdRemoteAPKDownloadExtraInfo.ADID, xAdRemoteAPKDownloadExtraInfo.getAdid());
                create.append("pk", xAdRemoteAPKDownloadExtraInfo.getPackageName());
                create.append(XAdRemoteAPKDownloadExtraInfo.QK, xAdRemoteAPKDownloadExtraInfo.getQueryKey());
                create.append(XAdRemoteAPKDownloadExtraInfo.DL_COUNTS, xAdRemoteAPKDownloadExtraInfo.dlCnt);
                create.append(XAdRemoteAPKDownloadExtraInfo.BUYER, xAdRemoteAPKDownloadExtraInfo.getBuyer());
                if (xAdRemoteAPKDownloadExtraInfo.mExtras != null) {
                    create.append(xAdRemoteAPKDownloadExtraInfo.mExtras);
                }
                str2 = xAdRemoteAPKDownloadExtraInfo.mUrl;
                if (!TextUtils.isEmpty(str2)) {
                    int indexOf = str2.indexOf("?");
                    if (indexOf <= 0) {
                        indexOf = str2.length();
                    }
                    str2 = str2.substring(0, indexOf);
                }
            } else {
                str2 = "";
            }
            create.append("net", CommonUtils.getNetworkType(context));
            create.append(IAdRequestParam.BDR, Build.VERSION.SDK_INT);
            create.append("mac", "");
            create.append("url", str2);
            create.sendWithVd();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public void sendLog4DlFailed(Context context, long j) {
        if (context == null) {
            return;
        }
        try {
            Map<String, ?> all = context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0).getAll();
            SendLogUtil.Builder create = SendLogUtil.Builder.create(context);
            create.appendType(408);
            create.append("msg", "dl_info");
            for (String str : all.keySet()) {
                if (str.contains(XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT)) {
                    JSONObject jSONObject = new JSONObject(String.valueOf(all.get(str)));
                    long optLong = jSONObject.optLong(XAdRemoteAPKDownloadExtraInfo.CLICK_TOUCH_TIME);
                    int optInt = jSONObject.optInt("dl");
                    Map<String, ?> map = all;
                    if (optInt >= 4 && optInt <= 6 && optLong < j) {
                        create.append("dlname", AdURIUtils.encodeURIComponent(str));
                        create.append(XAdRemoteAPKDownloadExtraInfo.QK, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK));
                        create.append(XAdRemoteAPKDownloadExtraInfo.ADID, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.ADID));
                        create.append("dl", optInt);
                        create.append(XAdRemoteAPKDownloadExtraInfo.BUYER, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.BUYER));
                        create.append("filename", jSONObject.optString("filename"));
                        create.append(XAdRemoteAPKDownloadExtraInfo.DL_COUNTS, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.DL_COUNTS));
                        create.append(XAdRemoteAPKDownloadExtraInfo.MOBILE_NET_CONFIRMED, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.MOBILE_NET_CONFIRMED));
                        create.append(XAdRemoteAPKDownloadExtraInfo.CLICK_TOUCH_TIME, jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.CLICK_TOUCH_TIME));
                        if (jSONObject.getJSONObject("extras") != null) {
                            create.append("dl_type", jSONObject.optString("dl_type"));
                        }
                    }
                    all = map;
                }
            }
            create.append(IAdRequestParam.BDR, Build.VERSION.SDK_INT);
            create.send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public void sendDownloadApkLog(Context context, int i2, String str, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
        String str2;
        try {
            SendLogUtil.Builder create = SendLogUtil.Builder.create(context);
            create.appendType(i2);
            create.appendApId("");
            create.append("msg", str);
            if (xAdRemoteDownloadAdInfo != null) {
                create.appendAppSid(xAdRemoteDownloadAdInfo.getAppsid());
                create.append("prod", xAdRemoteDownloadAdInfo.getProd());
                create.append(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN, xAdRemoteDownloadAdInfo.isAutoOpen());
                create.append(XAdRemoteAPKDownloadExtraInfo.ADID, xAdRemoteDownloadAdInfo.getAdId());
                create.append("pk", xAdRemoteDownloadAdInfo.getAppPackageName());
                create.append(XAdRemoteAPKDownloadExtraInfo.QK, xAdRemoteDownloadAdInfo.getQueryKey());
                create.append("act", xAdRemoteDownloadAdInfo.getActType());
                create.append(XAdRemoteAPKDownloadExtraInfo.BUYER, xAdRemoteDownloadAdInfo.mBuyer);
                create.append("dl_type", xAdRemoteDownloadAdInfo.mDlType);
                create.append("downType", xAdRemoteDownloadAdInfo.mDownType);
                if (xAdRemoteDownloadAdInfo.getExtras() != null) {
                    create.append(xAdRemoteDownloadAdInfo.getExtras());
                }
                str2 = xAdRemoteDownloadAdInfo.getClickThroughUrl();
                if (!TextUtils.isEmpty(str2)) {
                    int indexOf = str2.indexOf("?");
                    if (indexOf <= 0) {
                        indexOf = str2.length();
                    }
                    str2 = str2.substring(0, indexOf);
                }
            } else {
                str2 = "";
            }
            create.append("net", CommonUtils.getNetworkType(context));
            create.append(IAdRequestParam.BDR, Build.VERSION.SDK_INT);
            create.append("mac", "");
            create.append("url", str2);
            create.sendWithVd();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }
}
