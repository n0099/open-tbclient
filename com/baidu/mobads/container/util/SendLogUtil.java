package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class SendLogUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static String END_REQUEST_TIME = "";
    public static String START_REQUEST_TIME = "";
    public static int SUBTYPE_READ_SP = 2;
    public static int SUBTYPE_READ_SP_REPLACE = 3;
    public static int SUBTYPE_SAVE_TO_SP = 1;
    public static int TYPE_SEND_COOKIE = 425;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public static HashMap<String, String> mCommon;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, String> mArgs;
        public Context mContext;
        public int mType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(862045684, "Lcom/baidu/mobads/container/util/SendLogUtil$Builder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(862045684, "Lcom/baidu/mobads/container/util/SendLogUtil$Builder;");
                    return;
                }
            }
            mCommon = new HashMap<>();
        }

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mArgs = new HashMap<>();
            this.mContext = context;
            initCommonArgs();
            mCommon.put("appsid", DeviceUtils.getInstance().getAppId(this.mContext));
            mCommon.put(IAdRequestParam.NCUID, Base64.encode(PluginLoader.getCuidFromGalaxy(this.mContext)));
            mCommon.put("zd", PluginLoader.getZid(this.mContext));
        }

        public static Builder create(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
        }

        private StringBuffer fill(HashMap<String, String> hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, hashMap)) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                if (hashMap != null && !hashMap.isEmpty()) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        try {
                            String encode = URLEncoder.encode(entry.getValue().trim(), "utf-8");
                            stringBuffer.append(entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(encode);
                            stringBuffer.append("&");
                        } catch (Exception unused) {
                        }
                    }
                }
                return stringBuffer;
            }
            return (StringBuffer) invokeL.objValue;
        }

        private void initCommonArgs() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && mCommon.isEmpty()) {
                mCommon.put("cuid", Base64.encode(DeviceUtils.getInstance().getCUID(this.mContext)));
                mCommon.put(IAdRequestParam.SN, DeviceUtils.getInstance().getEncodedSN(this.mContext));
                mCommon.put("os", "android");
                mCommon.put(IAdRequestParam.OSV, Build.VERSION.RELEASE);
                mCommon.put("model", Build.MODEL);
                mCommon.put("brand", DeviceUtils.getInstance().getPhoneOSBrand());
                mCommon.put(IAdRequestParam.BDR, DeviceUtils.getInstance().getPhoneOSBuildVersionSdk());
                mCommon.put("v", "android_9.042");
                mCommon.put("p_ver", XAdRemoteCommonUtils.getProxyVer());
                mCommon.put("a_ver", XAdRemoteCommonUtils.getAdServVersion());
                mCommon.put("pack", AppUtils.getAppPackage(this.mContext));
            }
        }

        private void sendUnderSecurity(StringBuffer stringBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, stringBuffer) == null) {
                try {
                    XAdRemoteCommonUtils.makeRequest(AdURIUtils.addParameters("https://mobads-logs.baidu.com/dz.zb?" + stringBuffer.toString(), null), 2);
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().d(th.getMessage());
                }
            }
        }

        public Builder append(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                this.mArgs.put(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder appendAdInfo(IXAdInstanceInfo iXAdInstanceInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iXAdInstanceInfo)) == null) {
                this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.QK, iXAdInstanceInfo.getQueryKey());
                this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.ADID, iXAdInstanceInfo.getAdId());
                this.mArgs.put("act", String.valueOf(iXAdInstanceInfo.getActionType()));
                try {
                    this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.BUYER, iXAdInstanceInfo.getOriginJsonObject().optString(XAdRemoteAPKDownloadExtraInfo.BUYER));
                } catch (Exception unused) {
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appendApId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                mCommon.put("apid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appendAppSid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                mCommon.put("appsid", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appendProdType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                mCommon.put("prod", str);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder appendType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                this.mType = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public StringBuffer getAllParameters() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("type=");
                stringBuffer.append(this.mType);
                stringBuffer.append(Typography.amp);
                stringBuffer.append(fill(mCommon));
                stringBuffer.append(fill(this.mArgs));
                stringBuffer.append("ts=");
                stringBuffer.append(String.valueOf(System.currentTimeMillis()));
                return stringBuffer;
            }
            return (StringBuffer) invokeV.objValue;
        }

        public void send() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                sendUnderSecurity(getAllParameters());
            }
        }

        public void sendWithVd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("type=");
                stringBuffer.append(this.mType);
                stringBuffer.append(Typography.amp);
                try {
                    TreeMap treeMap = new TreeMap();
                    StringBuilder sb = new StringBuilder();
                    treeMap.putAll(mCommon);
                    treeMap.putAll(this.mArgs);
                    treeMap.put("ts", String.valueOf(System.currentTimeMillis()));
                    RemoteCommonUtils.getInstance();
                    for (String str : treeMap.keySet()) {
                        String str2 = (String) treeMap.get(str);
                        if (str != null && str2 != null) {
                            if (!str.equals("targetscheme")) {
                                str = AdURIUtils.encodeURIComponent(str);
                                str2 = AdURIUtils.encodeURIComponent(str2);
                            }
                            stringBuffer.append(str);
                            stringBuffer.append("=");
                            stringBuffer.append(str2);
                            stringBuffer.append("&");
                            sb.append(str2);
                            sb.append(",");
                        }
                    }
                    sb.append(XAdSDKRemoteConfig.SED);
                    stringBuffer.append("vd=");
                    stringBuffer.append(EncryptUtils.getMD5(sb.toString()));
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().d(th.getMessage());
                }
                sendUnderSecurity(stringBuffer);
            }
        }

        public Builder append(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
                this.mArgs.put(str, z ? "true" : "false");
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }

        public Builder append(String str, int i2) {
            String str2;
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
                try {
                    str2 = String.valueOf(i2);
                } catch (Exception unused) {
                    str2 = "-1";
                }
                this.mArgs.put(str, str2);
                return this;
            }
            return (Builder) invokeLI.objValue;
        }

        public Builder append(HashMap<String, String> hashMap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hashMap)) == null) {
                if (hashMap != null) {
                    this.mArgs.putAll(hashMap);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-920489493, "Lcom/baidu/mobads/container/util/SendLogUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-920489493, "Lcom/baidu/mobads/container/util/SendLogUtil;");
        }
    }

    public SendLogUtil() {
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

    public static String addParameters(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (hashMap != null && !hashMap.isEmpty()) {
                sb.append("?");
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    try {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append("&");
                    } catch (Exception unused) {
                    }
                }
                String sb2 = sb.toString();
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, hashMap) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        new OAdURLConnection(1, addParameters(str, hashMap)).asynLoad();
    }

    public static void sendCookieLog(Context context, int i2, int i3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), str, str2}) == null) {
            try {
                Builder.create(context).appendType(i2).append("subtype", i3).append("spbaiduid", str).append("cookiebaiduid", str2).append("logversion", "1").send();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
    }

    public static void sendExpLpLog(Context context, int i2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, context, i2, hashMap) == null) {
            try {
                Builder.create(context).appendType(i2).append(hashMap).send();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
    }

    public static void sendLog(Context context, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65543, null, context, i2, str, str2) == null) {
            try {
                Builder.create(context).appendType(i2).append("reason", str).append("url", str2).append("m_start_request", START_REQUEST_TIME).append("m_end_request", END_REQUEST_TIME).send();
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2.getMessage());
            }
        }
    }

    public static void fireAdMetrics(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            fireAdMetrics(str, null);
        }
    }
}
