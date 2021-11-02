package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class XAdRemoteAPKDownloadExtraInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public String apoPage;
    public long appSize;
    public String appsec;
    public String asl;
    public boolean autoOpen;
    public long clickTime;
    public long clickTouchTime;
    public long contentLength;
    public int dlCnt;
    public long firstClickTime;
    public long firstProcessId;
    public boolean isTooLarge;
    public boolean mAPOOpen;
    public final RemoteXAdLogger mAdLogger;
    public String mAdid;
    public String mAppName;
    public String mAppsid;
    public String mBuyer;
    public HashMap<String, String> mExtras;
    public String mPage;
    public String mProd;
    public String mTitle;
    public String mUrl;
    public boolean mobileConfirmed;
    public Object notifBuilder;
    public int notifID;
    public String outputFileName;
    public String outputFolder;
    public String packageName;
    public String placeId;
    public boolean popNotify;
    public int progress;
    public String queryKey;
    public IDownloader.DownloadStatus status;
    public String targetUrl;

    public XAdRemoteAPKDownloadExtraInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contentLength = -1L;
        this.progress = 0;
        this.status = IDownloader.DownloadStatus.NONE;
        this.notifBuilder = null;
        this.popNotify = true;
        this.mExtras = new HashMap<>();
        this.dlCnt = 0;
        this.mobileConfirmed = false;
        this.mAPOOpen = false;
        this.mPage = null;
        this.apoPage = null;
        this.asl = null;
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.packageName = str;
        this.mTitle = str2;
    }

    public static String getCurrentProcName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ProcessUtils.getInstance().getCurrentProcessName(XAdRemoteCommonUtils.getApplicationContext()) : (String) invokeV.objValue;
    }

    public static XAdRemoteAPKDownloadExtraInfo getStoredDownloadInfo(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, context, str)) != null) {
            return (XAdRemoteAPKDownloadExtraInfo) invokeLL.objValue;
        }
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
                    int i2 = jSONObject.getInt("dl");
                    IDownloader.DownloadStatus[] values = IDownloader.DownloadStatus.values();
                    IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.NONE;
                    for (int i3 = 0; i3 < values.length; i3++) {
                        if (values[i3].getCode() == i2) {
                            downloadStatus = values[i3];
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
        InterceptResult invokeLJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, context, j)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                for (Map.Entry<String, ?> entry : context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                    try {
                        String currentProcName = getCurrentProcName();
                        String key = entry.getKey();
                        if (key.contains(KEY_SPLIT + currentProcName)) {
                            JSONObject jSONObject = new JSONObject((String) entry.getValue());
                            if (jSONObject.getLong(CLICK_TOUCH_TIME) >= j && ((i2 = jSONObject.getInt("dl")) == 0 || i2 == 1 || i2 == 4)) {
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
        return (List) invokeLJ.objValue;
    }

    public void addExtra(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.mExtras == null) {
                this.mExtras = new HashMap<>();
            }
            this.mExtras.put(str, str2);
        }
    }

    public void copyExtraFrom(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            if (this.mExtras == null) {
                this.mExtras = new HashMap<>();
            }
            if (hashMap != null) {
                this.mExtras.putAll(hashMap);
            }
        }
    }

    public String getAdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAdid : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.appSize : invokeV.longValue;
    }

    public String getAppsec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.appsec : (String) invokeV.objValue;
    }

    public String getAppsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mAppsid : (String) invokeV.objValue;
    }

    public String getBuyer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBuyer : (String) invokeV.objValue;
    }

    public long getClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.clickTime : invokeV.longValue;
    }

    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public String getProd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mProd : (String) invokeV.objValue;
    }

    public String getQueryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.queryKey : (String) invokeV.objValue;
    }

    public void hibernateStatus(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, context) == null) || TextUtils.isEmpty(this.packageName)) {
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.isTooLarge : invokeV.booleanValue;
    }

    public void setAppSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.appSize = j;
        }
    }

    public void setClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.clickTime = j;
        }
    }

    public void setLocalRelated(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            this.outputFileName = str;
            this.outputFolder = str2;
        }
    }

    public void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.packageName = str;
        }
    }

    public void setPlaceRelated(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, str2, str3) == null) {
            this.placeId = str;
            this.mProd = str2;
            this.mAppsid = str3;
        }
    }

    public void setSingleAdsRelated(String str, String str2, String str3, boolean z, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{str, str2, str3, Boolean.valueOf(z), str4}) == null) {
            this.queryKey = str;
            this.mBuyer = str4;
            this.mAdid = str2;
            this.mUrl = str3;
            this.autoOpen = z;
        }
    }

    public void setTooLarge(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.isTooLarge = z;
        }
    }

    public JSONObject toJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }
}
