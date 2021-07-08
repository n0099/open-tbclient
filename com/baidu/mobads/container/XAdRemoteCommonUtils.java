package com.baidu.mobads.container;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.command.OAdRemoteApkDownloaderObserver;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAPKCommand;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.components.controller.XAdInstallController;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.downloader.OAdRemoteDownloadManager;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.download.activate.XSharedPreferences;
import com.baidu.mobads.container.h5.XAdservAdContainer;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAdRemoteCommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_TIMEOUT = 0;
    public static final String EMPTY_STRING = "empty";
    public static final String LP_MURL_KEY = "lpMurlStyle";
    public static final String LP_STYLE_FLAG_KEY = "lpShoubaiStyle";
    public static final int NO_MIDPAGE = 0;
    public static final String PERMISSION_APP_LIST = "permission_app_list";
    public static final String PERMISSION_LOCATION = "permission_location";
    public static final String PERMISSION_PHONE_STATE = "permission_read_phone_state";
    public static final String PERMISSION_STORAGE = "permission_storage";
    public static final int SECOND_CONFIRM_MIDPAGE = 1;
    public static final int VIDEO_PLAY_MIDPAGE = 2;
    public static RemoteXAdLogger mAdLogger = null;
    public static XSharedPreferences mSharedPreferences = null;
    public static final XAdRemoteCommonUtils sAdRemoteCommonUtils;
    public static boolean shouldPopToast = true;
    public static long timeout;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(12258807, "Lcom/baidu/mobads/container/XAdRemoteCommonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(12258807, "Lcom/baidu/mobads/container/XAdRemoteCommonUtils;");
                return;
            }
        }
        mAdLogger = RemoteXAdLogger.getInstance();
        sAdRemoteCommonUtils = new XAdRemoteCommonUtils();
    }

    public XAdRemoteCommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean dealWithCompleted(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, xAdRemoteAPKDownloadExtraInfo, xAdRemoteDownloadAdInfo)) == null) {
            boolean isInstalled = AdDownloadApkUtils.isInstalled(context, xAdRemoteAPKDownloadExtraInfo.packageName);
            RemoteCommonUtils remoteCommonUtils = RemoteCommonUtils.getInstance();
            if (isInstalled) {
                remoteCommonUtils.sendDownloadApkLog(context, 529, RemoteCommonUtils.MSG_DOWNLOADED_OPEN_APP, xAdRemoteDownloadAdInfo);
                stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_OPEN);
                OpenAppUtils.openApp(context, xAdRemoteAPKDownloadExtraInfo.packageName);
                return true;
            }
            String str = xAdRemoteAPKDownloadExtraInfo.outputFolder + xAdRemoteAPKDownloadExtraInfo.outputFileName;
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
            remoteCommonUtils.sendDownloadApkLog(context, 529, RemoteCommonUtils.MSG_DOWNLOADED_INSTALL_APP, xAdRemoteDownloadAdInfo);
            stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_INSTALL);
            AppUtils.ApkInfo localApkFileInfo = AppUtils.getLocalApkFileInfo(context, str);
            if (localApkFileInfo != null && !TextUtils.isEmpty(localApkFileInfo.packageName) && !localApkFileInfo.packageName.equals(xAdRemoteAPKDownloadExtraInfo.packageName)) {
                xAdRemoteAPKDownloadExtraInfo.hibernateStatus(context);
                String str2 = localApkFileInfo.packageName;
                xAdRemoteAPKDownloadExtraInfo.packageName = str2;
                if (AdDownloadApkUtils.isInstalled(context, str2)) {
                    remoteCommonUtils.sendDownloadApkLog(context, 529, "alreadyinstalled_call_openapp1", xAdRemoteDownloadAdInfo);
                    stateEvent(xAdRemoteAPKDownloadExtraInfo, AdStateCode.EVENT_DL_OPEN);
                    OpenAppUtils.openApp(context, xAdRemoteAPKDownloadExtraInfo.packageName);
                    SendLogUtil.fireAdMetrics(xAdRemoteDownloadAdInfo.getClickThroughUrl());
                    return true;
                }
            }
            XAdInstallController.getInstance().registerInstallReceiver(context, xAdRemoteAPKDownloadExtraInfo);
            AdDownloadApkUtils.installApkWithLog(context, file, xAdRemoteAPKDownloadExtraInfo);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static void downloadApp(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, iXAdInstanceInfo, str2, str3, Boolean.valueOf(z)}) == null) {
            String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
            String queryKey = iXAdInstanceInfo.getQueryKey();
            String appPackageName = iXAdInstanceInfo.getAppPackageName();
            XAdRemoteDownloadAdInfo createFromInstanceInfo = XAdRemoteDownloadAdInfo.createFromInstanceInfo(iXAdInstanceInfo);
            createFromInstanceInfo.mIsPopNotif = z;
            createFromInstanceInfo.mDlType = str3;
            createFromInstanceInfo.mProd = str2;
            createFromInstanceInfo.mAppsid = str;
            createFromInstanceInfo.addExtraParam("creative_id", RemoteCommonUtils.getInstance().getStringFromJson(iXAdInstanceInfo.getOriginJsonObject(), "creative_id"));
            createFromInstanceInfo.addExtraParam("uniqueId", iXAdInstanceInfo.getUniqueId());
            if ("lp_normal".equals(str3)) {
                appPackageName = EncryptUtils.getMD5(clickThroughUrl);
                createFromInstanceInfo.mAppPackageName = appPackageName;
            }
            XAdRemoteAPKDownloadExtraInfo storedDownloadInfo = XAdRemoteAPKDownloadExtraInfo.getStoredDownloadInfo(context, appPackageName);
            if (storedDownloadInfo != null) {
                updateAdInfoInDownloadExtraInfo(storedDownloadInfo, createFromInstanceInfo);
                if (storedDownloadInfo.status == IDownloader.DownloadStatus.COMPLETED && dealWithCompleted(context, storedDownloadInfo, createFromInstanceInfo)) {
                    stateEvent(storedDownloadInfo, AdStateCode.EVENT_DL_COMPLETE);
                    stateEvent(storedDownloadInfo, AdStateCode.EVENT_AD_STATE_END);
                    return;
                }
                SendLogUtil.fireAdMetrics(createFromInstanceInfo.getClickThroughUrl());
            }
            boolean z2 = false;
            try {
                z2 = iXAdInstanceInfo.isNoticeDlNonWifiSecJump();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(queryKey)) {
                String strInsteadQk = getStrInsteadQk(context, clickThroughUrl);
                if (TextUtils.isEmpty(strInsteadQk)) {
                    strInsteadQk = "empty_url";
                }
                iXAdInstanceInfo.setQueryKey(strInsteadQk);
            }
            if (!CommonUtils.isWifi(context) && z && z2) {
                CommonUtils.showDownloadConfirmDialog(context, new CommonUtils.DialogOperation(context, createFromInstanceInfo) { // from class: com.baidu.mobads.container.XAdRemoteCommonUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Context val$context;
                    public final /* synthetic */ XAdRemoteDownloadAdInfo val$downloadAdInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, createFromInstanceInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$context = context;
                        this.val$downloadAdInfo = createFromInstanceInfo;
                    }

                    @Override // com.baidu.mobads.container.util.CommonUtils.DialogOperation
                    public void onClickButton(boolean z3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z3) == null) {
                            if (z3) {
                                XAdRemoteCommonUtils.startDownload(this.val$context, 0, this.val$downloadAdInfo);
                            } else {
                                XAdRemoteCommonUtils.startDownload(this.val$context, 1, this.val$downloadAdInfo);
                            }
                        }
                    }
                });
            } else {
                startDownload(context, 2, createFromInstanceInfo);
            }
            RemoteCommonUtils.getInstance().sendDownloadApkLog(context, SDKLogTypeConstants.TYPE_LP_DOWNLOAD, "startDownload", createFromInstanceInfo);
        }
    }

    public static void downloadAppSilence(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, iXAdInstanceInfo) == null) {
            downloadApp(context, str, iXAdInstanceInfo, null, "silence", false);
        }
    }

    public static String getAdServVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? XAdservAdContainer.ADSERV_VERSION_CODE : (String) invokeV.objValue;
    }

    public static IDownloader getAdsApkDownloader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            Context appContext = AppConfigImp.getInstance().getAppContext();
            if (appContext == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return OAdRemoteDownloadManager.getInstance(appContext).getAdsApkDownloader(str);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
                return null;
            }
        }
        return (IDownloader) invokeL.objValue;
    }

    public static Context getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? AppConfigImp.getInstance().getAppContext() : (Context) invokeV.objValue;
    }

    public static Field getDeclaredField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static IDownloader.DownloadStatus getDownloadStatus(String str) {
        int i2;
        String string;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                Context applicationContext = getApplicationContext();
                String currentProcessName = ProcessUtils.getInstance().getCurrentProcessName(applicationContext);
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0);
                string = sharedPreferences.getString(str + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + currentProcessName, null);
            } catch (Exception unused) {
            }
            if (string != null) {
                int i3 = new JSONObject(string).getInt("dl");
                IDownloader.DownloadStatus[] values = IDownloader.DownloadStatus.values();
                IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.NONE;
                for (i2 = 0; i2 < values.length; i2++) {
                    if (values[i2].getCode() == i3) {
                        downloadStatus = values[i2];
                    }
                }
                return downloadStatus;
            }
            if (getAdsApkDownloader(str) != null) {
                return getAdsApkDownloader(str).getState();
            }
            return IDownloader.DownloadStatus.NONE;
        }
        return (IDownloader.DownloadStatus) invokeL.objValue;
    }

    public static XAdRemoteCommonUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? sAdRemoteCommonUtils : (XAdRemoteCommonUtils) invokeV.objValue;
    }

    public static HashMap<String, Object> getLpFlag(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, xAdContainerContext, iXAdInstanceInfo)) == null) {
            try {
                JSONObject originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
                int optInt = originJsonObject.optInt("midpage_type");
                String optString = originJsonObject.optString("murl");
                int optInt2 = originJsonObject.optInt("act");
                if ("feed".equals(xAdContainerContext.getAdProd())) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (!TextUtils.isEmpty(optString) && optInt != 0) {
                        if (Double.valueOf(getProxyVer()).doubleValue() >= 8.5d) {
                            if (!CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setWebUrl", String.class)) {
                                if (optInt2 == 2) {
                                    iXAdInstanceInfo.setActionType(1);
                                }
                                if (optInt == 1) {
                                    hashMap.put("lpShoubaiStyle", "video_and_web");
                                    App2Activity.MURL_SECOND_CONFIRM.set(true);
                                    hashMap.put(LP_MURL_KEY, App2Activity.MURL_SECOND_CONFIRM_NEW);
                                } else if (optInt == 2) {
                                    hashMap.put("lpShoubaiStyle", "video_and_web");
                                    App2Activity.MURL_WEB.set(true);
                                    hashMap.put(LP_MURL_KEY, App2Activity.MURL_WEB_NEW);
                                    iXAdInstanceInfo.setClickThroughUrl(optString);
                                }
                            } else if (optInt == 1) {
                                App2Activity.MURL_SECOND_CONFIRM.set(true);
                                hashMap.put(LP_MURL_KEY, App2Activity.MURL_SECOND_CONFIRM_NEW);
                                hashMap.put("lpShoubaiStyle", "video_and_web");
                            } else if (optInt == 2) {
                                App2Activity.MURL_WEB.set(true);
                                hashMap.put(LP_MURL_KEY, App2Activity.MURL_WEB_NEW);
                                hashMap.put("lpShoubaiStyle", "video_and_web");
                                if (optInt2 == 1) {
                                    iXAdInstanceInfo.setWebUrl(optString);
                                }
                            }
                        }
                    } else if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "getAction", new Class[0])) {
                        String action = iXAdInstanceInfo.getAction();
                        if (!TextUtils.isEmpty(action) && action.equals("video")) {
                            hashMap.put("lpShoubaiStyle", "video_and_web");
                        }
                    }
                    return hashMap;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (HashMap) invokeLL.objValue;
    }

    public static String getProxyVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? AppConfigImp.getInstance().getProxyVersion() : (String) invokeV.objValue;
    }

    public static String getStrInsteadQk(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            sb.append("_");
            sb.append(context != null ? DeviceUtils.getInstance().getCUID(context) : "");
            return EncryptUtils.getMD5(sb.toString());
        }
        return (String) invokeLL.objValue;
    }

    public static void makeRequest(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65550, null, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new OAdURLConnection(i2, str).asynLoad();
    }

    public static void setMobileConfirmed(String str) {
        OAdRemoteApkDownloaderObserver globalDownloadObserver;
        XAdRemoteAPKDownloadExtraInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || (globalDownloadObserver = OAdRemoteApkDownloaderObserver.getGlobalDownloadObserver(str)) == null || (downloadInfo = globalDownloadObserver.getDownloadInfo()) == null) {
            return;
        }
        downloadInfo.mobileConfirmed = true;
    }

    public static void startDownload(Context context, int i2, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65553, null, context, i2, xAdRemoteDownloadAdInfo) == null) {
            xAdRemoteDownloadAdInfo.mActionOnlyWifi = 1 == i2;
            xAdRemoteDownloadAdInfo.mDownType = i2;
            xAdRemoteDownloadAdInfo.addExtraParam("pkgmd5", EncryptUtils.getMD5(xAdRemoteDownloadAdInfo.getOriginClickUrl()));
            new XAdRemoteDownloadAPKCommand(context.getApplicationContext(), xAdRemoteDownloadAdInfo).execute();
            RemoteCommonUtils.getInstance().sendDownloadApkLog(context, 1046, "downloadConfirm", xAdRemoteDownloadAdInfo);
        }
    }

    public static void stateEvent(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, AdStateCode adStateCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, xAdRemoteAPKDownloadExtraInfo, adStateCode) == null) || xAdRemoteAPKDownloadExtraInfo == null) {
            return;
        }
        try {
            if (xAdRemoteAPKDownloadExtraInfo.mExtras != null && adStateCode != null) {
                String str = xAdRemoteAPKDownloadExtraInfo.mExtras.get("uniqueId");
                if (AdStateCode.EVENT_AD_STATE_END.getCode() == adStateCode.getCode()) {
                    StateMachine.finish(str);
                } else {
                    StateMachine.event(str, adStateCode);
                }
            }
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public static void updateAdInfoInDownloadExtraInfo(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo, XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, xAdRemoteAPKDownloadExtraInfo, xAdRemoteDownloadAdInfo) == null) || xAdRemoteAPKDownloadExtraInfo == null || xAdRemoteDownloadAdInfo == null) {
            return;
        }
        xAdRemoteAPKDownloadExtraInfo.popNotify = xAdRemoteDownloadAdInfo.isPopNotif();
        xAdRemoteAPKDownloadExtraInfo.mobileConfirmed = !xAdRemoteDownloadAdInfo.isActionOnlyWifi();
        xAdRemoteAPKDownloadExtraInfo.autoOpen = xAdRemoteDownloadAdInfo.isAutoOpen();
        xAdRemoteAPKDownloadExtraInfo.mAPOOpen = false;
        if (xAdRemoteDownloadAdInfo.getAPOOpen() && !TextUtils.isEmpty(xAdRemoteDownloadAdInfo.getPage())) {
            xAdRemoteAPKDownloadExtraInfo.mAPOOpen = true;
            xAdRemoteAPKDownloadExtraInfo.mPage = xAdRemoteDownloadAdInfo.getPage();
        }
        xAdRemoteAPKDownloadExtraInfo.copyExtraFrom(xAdRemoteDownloadAdInfo.getExtras());
        xAdRemoteAPKDownloadExtraInfo.addExtra("dl_type", xAdRemoteDownloadAdInfo.mDlType);
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_qk", xAdRemoteDownloadAdInfo.getQueryKey());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_adid", xAdRemoteDownloadAdInfo.getAdId());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_buyer", xAdRemoteDownloadAdInfo.mBuyer);
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_apid", xAdRemoteDownloadAdInfo.getApId());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_prod", xAdRemoteDownloadAdInfo.getProd());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_appsid", xAdRemoteDownloadAdInfo.getAppsid());
        xAdRemoteAPKDownloadExtraInfo.addExtra("cur_url", xAdRemoteDownloadAdInfo.getClickThroughUrl());
        try {
            xAdRemoteAPKDownloadExtraInfo.addExtra("act", String.valueOf(xAdRemoteDownloadAdInfo.getActType()));
        } catch (Exception unused) {
        }
    }

    public void silenceDownload(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, xAdContainerContext, iXAdInstanceInfo) == null) {
            Context appContext = xAdContainerContext.getAppContext();
            if (iXAdInstanceInfo.getActionType() == 2 && NetworkInfoUtils.getNetworkType(getApplicationContext()).equals("wifi")) {
                IDownloader.DownloadStatus downloadStatus = getDownloadStatus(iXAdInstanceInfo.getAppPackageName());
                if (AdDownloadApkUtils.isInstalled(appContext, iXAdInstanceInfo.getAppPackageName()) || downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                    return;
                }
                iXAdInstanceInfo.setAutoOpen(false);
                iXAdInstanceInfo.setPopNotif(false);
                downloadAppSilence(appContext, xAdContainerContext.getAppsid(), iXAdInstanceInfo);
            }
        }
    }

    public static void makeRequest(List<String> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, list, i2) == null) {
            try {
                for (String str : list) {
                    makeRequest(str, i2);
                }
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
        }
    }
}
