package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.command.XAdRemoteDownloadAdInfo;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class RemoteCommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPSID = "BaiduMobAd_APP_ID";
    public static final String DUMMY_ADSERV_VERSION = "4.1.30";
    public static final String MSG_DOWNLOADED_INSTALL_APP = "alreadydownloaded_call_installapp";
    public static final String MSG_DOWNLOADED_OPEN_APP = "alreadyinstalled_call_openapp";
    public static RemoteCommonUtils mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1298462473, "Lcom/baidu/mobads/container/util/RemoteCommonUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1298462473, "Lcom/baidu/mobads/container/util/RemoteCommonUtils;");
        }
    }

    public RemoteCommonUtils() {
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

    public static RemoteCommonUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                mInstance = new RemoteCommonUtils();
            }
            return mInstance;
        }
        return (RemoteCommonUtils) invokeV.objValue;
    }

    public static boolean isLocalFileExist(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
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
        return invokeL.booleanValue;
    }

    public String genCompleteErrorMessage(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
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
        return (String) invokeLLL.objValue;
    }

    public String getBuyerFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject != null) {
                String optString = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.BUYER, "");
                return TextUtils.isEmpty(optString) ? jSONObject.optString("buyer_id", "") : optString;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public String getStringFromJson(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) ? (jSONObject == null || TextUtils.isEmpty(str)) ? "" : jSONObject.optString(str, "") : (String) invokeLL.objValue;
    }

    public void printErrorMessageLog(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            RemoteXAdLogger.getInstance().e(getInstance().genCompleteErrorMessage(String.valueOf(i2), str, str2));
        }
    }

    public void sendDownloadApkLog(Context context, int i2, String str, XAdRemoteAPKDownloadExtraInfo xAdRemoteAPKDownloadExtraInfo) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, context, i2, str, xAdRemoteAPKDownloadExtraInfo) == null) {
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
    }

    public void sendLog4DlFailed(Context context, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048582, this, context, j2) == null) || context == null) {
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
                    if (optInt >= 4 && optInt <= 6 && optLong < j2) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048581, this, context, i2, str, xAdRemoteDownloadAdInfo) == null) {
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
}
