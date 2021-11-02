package com.baidu.mobads.container.components.countly;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class XAdRemoteSDKCountly {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COUNTLY_BASE_URL_POST = "https://mobads-logs.baidu.com/brwhis.log";
    public static final String COUNTLY_TYPE_4_CRASH = "404";
    public static boolean HAS_SEND_ERROR_FOR_FEED_RESPONSE_HTML = false;
    public static final String TEMP_FOR_FEED_RESPONSE_HTML = "temp_for_feed_response_html";
    public static volatile String TEMP_REQUEST_AD_STRING;
    public static volatile String TEMP_RESPONSE_AD_STRING;
    public static XAdRemoteSDKCountly theInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final RemoteXAdLogger mAdLogger;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1576760763, "Lcom/baidu/mobads/container/components/countly/XAdRemoteSDKCountly;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1576760763, "Lcom/baidu/mobads/container/components/countly/XAdRemoteSDKCountly;");
                return;
            }
        }
        theInstance = new XAdRemoteSDKCountly();
        TEMP_REQUEST_AD_STRING = "";
        TEMP_RESPONSE_AD_STRING = "";
        HAS_SEND_ERROR_FOR_FEED_RESPONSE_HTML = false;
    }

    public XAdRemoteSDKCountly() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
    }

    private XAdRemoteAPKDownloadExtraInfo cloneApkDownloadExtraInfo(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, xAdRemoteAPKDownloadExtraInfo)) == null) {
            XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo2 = new XAdRemoteAPKDownloadExtraInfo(xAdRemoteAPKDownloadExtraInfo.packageName, xAdRemoteAPKDownloadExtraInfo.mTitle);
            xAdRemoteAPKDownloadExtraInfo2.setSingleAdsRelated(xAdRemoteAPKDownloadExtraInfo.getQueryKey(), xAdRemoteAPKDownloadExtraInfo.getAdid(), xAdRemoteAPKDownloadExtraInfo.mUrl, xAdRemoteAPKDownloadExtraInfo.autoOpen, xAdRemoteAPKDownloadExtraInfo.getBuyer());
            xAdRemoteAPKDownloadExtraInfo2.popNotify = xAdRemoteAPKDownloadExtraInfo.popNotify;
            xAdRemoteAPKDownloadExtraInfo2.setLocalRelated(xAdRemoteAPKDownloadExtraInfo.outputFileName, xAdRemoteAPKDownloadExtraInfo.outputFolder);
            xAdRemoteAPKDownloadExtraInfo2.setPlaceRelated(xAdRemoteAPKDownloadExtraInfo.placeId, xAdRemoteAPKDownloadExtraInfo.mProd, xAdRemoteAPKDownloadExtraInfo.mAppsid);
            xAdRemoteAPKDownloadExtraInfo2.notifID = xAdRemoteAPKDownloadExtraInfo.notifID;
            xAdRemoteAPKDownloadExtraInfo2.mobileConfirmed = xAdRemoteAPKDownloadExtraInfo.mobileConfirmed;
            xAdRemoteAPKDownloadExtraInfo2.setClickTime(xAdRemoteAPKDownloadExtraInfo.getClickTime());
            xAdRemoteAPKDownloadExtraInfo2.setAppSize(xAdRemoteAPKDownloadExtraInfo.getAppSize());
            xAdRemoteAPKDownloadExtraInfo2.setTooLarge(xAdRemoteAPKDownloadExtraInfo.isTooLarge());
            xAdRemoteAPKDownloadExtraInfo2.asl = xAdRemoteAPKDownloadExtraInfo.asl;
            xAdRemoteAPKDownloadExtraInfo2.apoPage = xAdRemoteAPKDownloadExtraInfo.apoPage;
            xAdRemoteAPKDownloadExtraInfo2.mAPOOpen = xAdRemoteAPKDownloadExtraInfo.mAPOOpen;
            xAdRemoteAPKDownloadExtraInfo2.copyExtraFrom(xAdRemoteAPKDownloadExtraInfo.mExtras);
            return xAdRemoteAPKDownloadExtraInfo2;
        }
        return (XAdRemoteAPKDownloadExtraInfo) invokeL.objValue;
    }

    public static XAdRemoteSDKCountly getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? theInstance : (XAdRemoteSDKCountly) invokeV.objValue;
    }

    private void onAPKAction(Context context, int i2, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i2, xAdRemoteAPKDownloadExtraInfo) == null) || xAdRemoteAPKDownloadExtraInfo == null) {
            return;
        }
        XAdRemoteDownloadMonitorTrackingInfo xAdRemoteDownloadMonitorTrackingInfo = new XAdRemoteDownloadMonitorTrackingInfo(context, cloneApkDownloadExtraInfo(xAdRemoteAPKDownloadExtraInfo));
        xAdRemoteDownloadMonitorTrackingInfo.adid = xAdRemoteAPKDownloadExtraInfo.getAdid();
        SendLogUtil.Builder.create(context).appendType(i2).append("net", CommonUtils.getNetworkType(context)).append(xAdRemoteDownloadMonitorTrackingInfo.toHashMap()).sendWithVd();
    }

    private void onTracking(String str, String str2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, str, str2, hashMap) == null) {
        }
    }

    public void onAPKDownloadComplete(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, xAdRemoteAPKDownloadExtraInfo) == null) {
            onAPKAction(context, 9, xAdRemoteAPKDownloadExtraInfo);
        }
    }

    public void onAPKDownloadError(XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xAdRemoteAPKDownloadExtraInfo) == null) {
        }
    }

    public void onAPKInstallComplete(Context context, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, xAdRemoteAPKDownloadExtraInfo) == null) {
            onAPKAction(context, 11, xAdRemoteAPKDownloadExtraInfo);
        }
    }

    public void onCrash(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ad", str3);
                hashMap.put("stacktrace", str2);
                onTracking(str, COUNTLY_TYPE_4_CRASH, hashMap);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().e(e2);
            }
        }
    }
}
