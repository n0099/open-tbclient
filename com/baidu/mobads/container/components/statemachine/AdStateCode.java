package com.baidu.mobads.container.components.statemachine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class AdStateCode {
    public static final /* synthetic */ AdStateCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AdStateCode EVENT_AD_STATE_END;
    public static final AdStateCode EVENT_AD_TIMEOUT;
    public static final AdStateCode EVENT_APO_FB;
    public static final AdStateCode EVENT_APO_OPEN;
    public static final AdStateCode EVENT_CLICK;
    public static final AdStateCode EVENT_CLICK_APO;
    public static final AdStateCode EVENT_CLICK_DL;
    public static final AdStateCode EVENT_CLICK_LP;
    public static final AdStateCode EVENT_CLICK_LP_DL;
    public static final AdStateCode EVENT_CLICK_PULL_SHOUBAI;
    public static final AdStateCode EVENT_DL_CANCELLED;
    public static final AdStateCode EVENT_DL_COMPLETE;
    public static final AdStateCode EVENT_DL_DOWNLOADING;
    public static final AdStateCode EVENT_DL_ERROR;
    public static final AdStateCode EVENT_DL_INIT;
    public static final AdStateCode EVENT_DL_INSTALL;
    public static final AdStateCode EVENT_DL_OPEN;
    public static final AdStateCode EVENT_DL_PAUSE;
    public static final AdStateCode EVENT_DL_RESUME;
    public static final AdStateCode EVENT_DL_START;
    public static final AdStateCode EVENT_DL_WAIT_WIFI;
    public static final AdStateCode EVENT_IMPRESSION;
    public static final AdStateCode EVENT_IMPRESSION_FAILED;
    public static final AdStateCode EVENT_IMPRESSION_SUCCESS;
    public static final AdStateCode EVENT_LP_CLOSE;
    public static final AdStateCode EVENT_LP_CREATE;
    public static final AdStateCode EVENT_LP_PAGE_FINISH;
    public static final AdStateCode EVENT_LP_PAGE_LOADED;
    public static final AdStateCode EVENT_LP_PAGE_START;
    public static final AdStateCode EVENT_REMOVE_AD_VIEW;
    public static final AdStateCode EVENT_REQUEST;
    public static final AdStateCode EVENT_RESPONSE_ERROR;
    public static final AdStateCode EVENT_RESPONSE_NO_AD;
    public static final AdStateCode EVENT_RESPONSE_OK;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1771218849, "Lcom/baidu/mobads/container/components/statemachine/AdStateCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1771218849, "Lcom/baidu/mobads/container/components/statemachine/AdStateCode;");
                return;
            }
        }
        EVENT_REQUEST = new AdStateCode("EVENT_REQUEST", 0, 101, "request");
        EVENT_RESPONSE_OK = new AdStateCode("EVENT_RESPONSE_OK", 1, 102, "responseOk");
        EVENT_RESPONSE_NO_AD = new AdStateCode("EVENT_RESPONSE_NO_AD", 2, 103, "responseNoAd");
        EVENT_RESPONSE_ERROR = new AdStateCode("EVENT_RESPONSE_ERROR", 3, 104, "responseError");
        EVENT_IMPRESSION = new AdStateCode("EVENT_IMPRESSION", 4, 201, "impression");
        EVENT_IMPRESSION_SUCCESS = new AdStateCode("EVENT_IMPRESSION_SUCCESS", 5, 202, "impressionSuccess");
        EVENT_IMPRESSION_FAILED = new AdStateCode("EVENT_IMPRESSION_FAILED", 6, 203, "impressionFailed");
        EVENT_CLICK = new AdStateCode("EVENT_CLICK", 7, 301, "adClick");
        EVENT_CLICK_DL = new AdStateCode("EVENT_CLICK_DL", 8, 302, "clickDl");
        EVENT_CLICK_LP = new AdStateCode("EVENT_CLICK_LP", 9, 303, "clickLp");
        EVENT_CLICK_LP_DL = new AdStateCode("EVENT_CLICK_LP_DL", 10, 304, "clickLpDl");
        EVENT_CLICK_APO = new AdStateCode("EVENT_CLICK_APO", 11, 305, "clickApo");
        EVENT_CLICK_PULL_SHOUBAI = new AdStateCode("EVENT_CLICK_PULL_SHOUBAI", 12, ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, "clickShoubai");
        EVENT_APO_OPEN = new AdStateCode("EVENT_APO_OPEN", 13, 501, "apoOpen");
        EVENT_APO_FB = new AdStateCode("EVENT_APO_FB", 14, 502, "apoFallback");
        EVENT_LP_CREATE = new AdStateCode("EVENT_LP_CREATE", 15, 601, "lpCreate");
        EVENT_LP_PAGE_START = new AdStateCode("EVENT_LP_PAGE_START", 16, 602, "lpPageStart");
        EVENT_LP_PAGE_LOADED = new AdStateCode("EVENT_LP_PAGE_LOADED", 17, 603, "lpPageLoaded");
        EVENT_LP_PAGE_FINISH = new AdStateCode("EVENT_LP_PAGE_FINISH", 18, 604, "lpPageFinish");
        EVENT_LP_CLOSE = new AdStateCode("EVENT_LP_CLOSE", 19, 605, "lpClose");
        EVENT_DL_INIT = new AdStateCode("EVENT_DL_INIT", 20, 801, "init");
        EVENT_DL_START = new AdStateCode("EVENT_DL_START", 21, 802, "start");
        EVENT_DL_DOWNLOADING = new AdStateCode("EVENT_DL_DOWNLOADING", 22, SDKLogTypeConstants.TYPE_DOWNLOAD_DIALOG_LOG, "downloading");
        EVENT_DL_RESUME = new AdStateCode("EVENT_DL_RESUME", 23, 806, "resume");
        EVENT_DL_CANCELLED = new AdStateCode("EVENT_DL_CANCELLED", 24, 807, "cancelled");
        EVENT_DL_WAIT_WIFI = new AdStateCode("EVENT_DL_WAIT_WIFI", 25, 808, "waitWifi");
        EVENT_DL_COMPLETE = new AdStateCode("EVENT_DL_COMPLETE", 26, 809, "completed");
        EVENT_DL_ERROR = new AdStateCode("EVENT_DL_ERROR", 27, 804, "error");
        EVENT_DL_PAUSE = new AdStateCode("EVENT_DL_PAUSE", 28, 805, "pause");
        EVENT_DL_INSTALL = new AdStateCode("EVENT_DL_INSTALL", 29, 831, "alreadyDownloadedInstall");
        EVENT_DL_OPEN = new AdStateCode("EVENT_DL_OPEN", 30, 832, "alreadyDownloadedOpen");
        EVENT_AD_TIMEOUT = new AdStateCode("EVENT_AD_TIMEOUT", 31, 400, "adTimeout");
        EVENT_REMOVE_AD_VIEW = new AdStateCode("EVENT_REMOVE_AD_VIEW", 32, 700, "removeAdView");
        AdStateCode adStateCode = new AdStateCode("EVENT_AD_STATE_END", 33, 0, ConstantHelper.LOG_FINISH);
        EVENT_AD_STATE_END = adStateCode;
        $VALUES = new AdStateCode[]{EVENT_REQUEST, EVENT_RESPONSE_OK, EVENT_RESPONSE_NO_AD, EVENT_RESPONSE_ERROR, EVENT_IMPRESSION, EVENT_IMPRESSION_SUCCESS, EVENT_IMPRESSION_FAILED, EVENT_CLICK, EVENT_CLICK_DL, EVENT_CLICK_LP, EVENT_CLICK_LP_DL, EVENT_CLICK_APO, EVENT_CLICK_PULL_SHOUBAI, EVENT_APO_OPEN, EVENT_APO_FB, EVENT_LP_CREATE, EVENT_LP_PAGE_START, EVENT_LP_PAGE_LOADED, EVENT_LP_PAGE_FINISH, EVENT_LP_CLOSE, EVENT_DL_INIT, EVENT_DL_START, EVENT_DL_DOWNLOADING, EVENT_DL_RESUME, EVENT_DL_CANCELLED, EVENT_DL_WAIT_WIFI, EVENT_DL_COMPLETE, EVENT_DL_ERROR, EVENT_DL_PAUSE, EVENT_DL_INSTALL, EVENT_DL_OPEN, EVENT_AD_TIMEOUT, EVENT_REMOVE_AD_VIEW, adStateCode};
    }

    public AdStateCode(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
        this.msg = str2;
    }

    public static AdStateCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdStateCode) Enum.valueOf(AdStateCode.class, str) : (AdStateCode) invokeL.objValue;
    }

    public static AdStateCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdStateCode[]) $VALUES.clone() : (AdStateCode[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
    }
}
