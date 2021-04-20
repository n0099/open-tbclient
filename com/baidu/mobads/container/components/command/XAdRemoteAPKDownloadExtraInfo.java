package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdRemoteAPKDownloadExtraInfo implements Serializable {
    public static final String ADID = "adid";
    public static final String APO_PAGE = "apopage";
    public static final String APPNAME = "appname";
    public static final String APPSID = "appsid";
    public static final String APP_STORE_LINK = "asl";
    public static final String AUTO_OPEN = "autoOpen";
    public static final String BUYER = "buyer";
    public static final String CLICK_TOUCH_TIME = "cts";
    public static final String CONTENT_LENGTH = "contentLength";
    public static final String DL = "dl";
    public static final String DL_COUNTS = "dlCnt";
    public static final String DL_TUNNEL = "dlTunnel";
    public static final String EXTRAS = "extras";
    public static final String FILENAME = "filename";
    public static final String FIRST_CLICK_TIME = "ts";
    public static final String FIRST_PROCESS_ID = "clickProcId";
    public static final String FOLDER = "folder";
    public static final String KEY_SPLIT = "#$#";
    public static final String MOBILE_NET_CONFIRMED = "mnCfm";
    public static final String PK = "pk";
    public static final String PLACE_ID = "placeId";
    public static final String POP_NOTIFY = "popNotify";
    public static final String PROD = "prod";
    public static final String QK = "qk";
    public static final String TAG = "XAdRemoteAPKDownloadExtraInfo";
    public static final String TARGET_URL = "turl";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final long serialVersionUID = -8265147931424177431L;
    public long appSize;
    public String appsec;
    public boolean autoOpen;
    public long clickTime;
    public long clickTouchTime;
    public long firstClickTime;
    public long firstProcessId;
    public boolean isTooLarge;
    public String mAdid;
    public String mAppName;
    public String mAppsid;
    public String mBuyer;
    public String mProd;
    public String mTitle;
    public String mUrl;
    public int notifID;
    public String outputFileName;
    public String outputFolder;
    public String packageName;
    public String placeId;
    public String queryKey;
    public String targetUrl;
    public long contentLength = -1;
    public int progress = 0;
    public IDownloader.DownloadStatus status = IDownloader.DownloadStatus.NONE;
    public Object notifBuilder = null;
    public boolean popNotify = true;
    public HashMap<String, String> mExtras = new HashMap<>();
    public int dlCnt = 0;
    public boolean mobileConfirmed = false;
    public boolean mAPOOpen = false;
    public String mPage = null;
    public String apoPage = null;
    public String asl = null;
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();

    public XAdRemoteAPKDownloadExtraInfo(String str, String str2) {
        this.packageName = str;
        this.mTitle = str2;
    }

    public static String getCurrentProcName() {
        return ProcessUtils.getInstance().getCurrentProcessName(XAdRemoteCommonUtils.getApplicationContext());
    }

    public static XAdRemoteAPKDownloadExtraInfo getStoredDownloadInfo(Context context, String str) {
        XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0);
            String string = sharedPreferences.getString(str + KEY_SPLIT + getCurrentProcName(), null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                String string2 = jSONObject.getString("title");
                String optString = jSONObject.optString("url", jSONObject.optString(TARGET_URL));
                XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = new XAdRemoteAPKDownloadExtraInfo(str, string2);
                try {
                    xAdRemoteAPKDownloadExtraInfo2.mAppName = jSONObject.optString("appname");
                    String optString2 = jSONObject.optString(QK);
                    String optString3 = jSONObject.optString(BUYER);
                    String optString4 = jSONObject.optString(ADID);
                    HashMap<String, String> json2HashMap = ConvertUtils.json2HashMap(jSONObject.optJSONObject("extras"));
                    xAdRemoteAPKDownloadExtraInfo2.setSingleAdsRelated(optString2, optString4, optString, jSONObject.optBoolean(AUTO_OPEN), optString3);
                    xAdRemoteAPKDownloadExtraInfo2.popNotify = jSONObject.optBoolean(POP_NOTIFY);
                    xAdRemoteAPKDownloadExtraInfo2.mExtras = json2HashMap;
                    xAdRemoteAPKDownloadExtraInfo2.setLocalRelated(jSONObject.getString("filename"), jSONObject.getString(FOLDER));
                    xAdRemoteAPKDownloadExtraInfo2.targetUrl = jSONObject.optString(TARGET_URL);
                    xAdRemoteAPKDownloadExtraInfo2.setPlaceRelated(jSONObject.optString(PLACE_ID), jSONObject.optString("prod"), jSONObject.optString("appsid"));
                    int i = jSONObject.getInt("dl");
                    IDownloader.DownloadStatus[] values = IDownloader.DownloadStatus.values();
                    IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.NONE;
                    for (int i2 = 0; i2 < values.length; i2++) {
                        if (values[i2].getCode() == i) {
                            downloadStatus = values[i2];
                        }
                    }
                    xAdRemoteAPKDownloadExtraInfo2.status = downloadStatus;
                    xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed = jSONObject.optBoolean(MOBILE_NET_CONFIRMED);
                    xAdRemoteAPKDownloadExtraInfo2.dlCnt = jSONObject.getInt(DL_COUNTS);
                    xAdRemoteAPKDownloadExtraInfo2.clickTouchTime = jSONObject.optLong(CLICK_TOUCH_TIME);
                    xAdRemoteAPKDownloadExtraInfo2.firstClickTime = jSONObject.optLong("ts");
                    xAdRemoteAPKDownloadExtraInfo2.firstProcessId = jSONObject.optInt(FIRST_PROCESS_ID);
                    xAdRemoteAPKDownloadExtraInfo2.apoPage = jSONObject.optString(APO_PAGE);
                    xAdRemoteAPKDownloadExtraInfo2.asl = jSONObject.optString(APP_STORE_LINK);
                    return xAdRemoteAPKDownloadExtraInfo2;
                } catch (Exception e2) {
                    e = e2;
                    xAdRemoteAPKDownloadExtraInfo = xAdRemoteAPKDownloadExtraInfo2;
                    RemoteXAdLogger.getInstance().d(e);
                    return xAdRemoteAPKDownloadExtraInfo;
                }
            }
            return null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static List<String> getUndownloadedPackagesBefore(Context context, long j) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, ?> entry : context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                try {
                    String currentProcName = getCurrentProcName();
                    String key = entry.getKey();
                    if (key.contains(KEY_SPLIT + currentProcName)) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong(CLICK_TOUCH_TIME) >= j && ((i = jSONObject.getInt("dl")) == 0 || i == 1 || i == 4)) {
                            arrayList.add(key.substring(0, key.indexOf(KEY_SPLIT)));
                        }
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d("XAdDownloaderManager", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            RemoteXAdLogger.getInstance().d(e3);
        }
        return arrayList;
    }

    public void addExtra(String str, String str2) {
        if (this.mExtras == null) {
            this.mExtras = new HashMap<>();
        }
        this.mExtras.put(str, str2);
    }

    public void copyExtraFrom(HashMap<String, String> hashMap) {
        if (this.mExtras == null) {
            this.mExtras = new HashMap<>();
        }
        if (hashMap != null) {
            this.mExtras.putAll(hashMap);
        }
    }

    public String getAdid() {
        return this.mAdid;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public long getAppSize() {
        return this.appSize;
    }

    public String getAppsec() {
        return this.appsec;
    }

    public String getAppsid() {
        return this.mAppsid;
    }

    public String getBuyer() {
        return this.mBuyer;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProd() {
        return this.mProd;
    }

    public String getQueryKey() {
        return this.queryKey;
    }

    public void hibernateStatus(Context context) {
        if (TextUtils.isEmpty(this.packageName)) {
            return;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0).edit();
            edit.putString(this.packageName + KEY_SPLIT + getCurrentProcName(), toJsonObject().toString());
            edit.apply();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(TAG, e2);
        }
    }

    public boolean isTooLarge() {
        return this.isTooLarge;
    }

    public void setAppSize(long j) {
        this.appSize = j;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public void setLocalRelated(String str, String str2) {
        this.outputFileName = str;
        this.outputFolder = str2;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPlaceRelated(String str, String str2, String str3) {
        this.placeId = str;
        this.mProd = str2;
        this.mAppsid = str3;
    }

    public void setSingleAdsRelated(String str, String str2, String str3, boolean z, String str4) {
        this.queryKey = str;
        this.mBuyer = str4;
        this.mAdid = str2;
        this.mUrl = str3;
        this.autoOpen = z;
    }

    public void setTooLarge(boolean z) {
        this.isTooLarge = z;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dl", this.status.getCode());
            jSONObject.put("filename", this.outputFileName);
            jSONObject.put(FOLDER, this.outputFolder);
            jSONObject.put("title", this.mTitle);
            jSONObject.put(CONTENT_LENGTH, this.contentLength);
            jSONObject.put("pk", this.packageName);
            jSONObject.put(QK, this.queryKey);
            jSONObject.put(BUYER, this.mBuyer);
            jSONObject.put(AUTO_OPEN, this.autoOpen);
            jSONObject.put(POP_NOTIFY, this.popNotify);
            jSONObject.put(ADID, this.mAdid);
            jSONObject.put(PLACE_ID, this.placeId);
            jSONObject.put("prod", this.mProd);
            jSONObject.put("appsid", this.mAppsid);
            if (!this.mAppName.isEmpty()) {
                jSONObject.put("appname", this.mAppName);
            }
            jSONObject.put("extras", ConvertUtils.hashMap2Json(this.mExtras));
            jSONObject.put(DL_TUNNEL, 4);
            if (this.targetUrl != null && this.targetUrl.length() > 0) {
                jSONObject.put(TARGET_URL, this.targetUrl);
            } else {
                jSONObject.put("url", this.mUrl);
            }
            jSONObject.put(MOBILE_NET_CONFIRMED, this.mobileConfirmed);
            jSONObject.put(DL_COUNTS, this.dlCnt);
            jSONObject.put(CLICK_TOUCH_TIME, this.clickTouchTime);
            if (this.dlCnt == 1) {
                this.firstClickTime = System.currentTimeMillis();
                this.firstProcessId = Process.myPid();
            }
            jSONObject.put("ts", this.firstClickTime);
            jSONObject.put(FIRST_PROCESS_ID, this.firstProcessId);
            jSONObject.put(APO_PAGE, this.apoPage);
            jSONObject.put(APP_STORE_LINK, this.asl);
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
        return jSONObject;
    }
}
