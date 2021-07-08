package com.baidu.mobads.container.landingpage;

import android.content.Context;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class XAdRemoteAbstractTrackingInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COUNTLY_AD_TYPE = "adt";
    public transient /* synthetic */ FieldHolder $fh;
    public String adid;
    public String appsec;
    public String appsid;
    public String cuid;
    public Context mApplicationContext;
    public String os;
    public String packageNameOfPubliser;
    public String prod;
    public String qk;
    public String sn;
    public long ts;
    public String v;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public XAdRemoteAbstractTrackingInfo(XAdRemoteCommandExtraInfo xAdRemoteCommandExtraInfo) {
        this(xAdRemoteCommandExtraInfo.getAdInstanceInfo().getAdId(), xAdRemoteCommandExtraInfo.getAdInstanceInfo().getQueryKey(), xAdRemoteCommandExtraInfo.mProdType, xAdRemoteCommandExtraInfo.appsid, xAdRemoteCommandExtraInfo.appsec);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdRemoteCommandExtraInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String encodeURIComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public String mapToString(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                StringBuilder sb2 = new StringBuilder();
                for (String str : hashMap.keySet()) {
                    String str2 = hashMap.get(str);
                    if (str != null && str2 != null) {
                        String encodeURIComponent = encodeURIComponent(str);
                        String encodeURIComponent2 = encodeURIComponent(str2);
                        sb.append(encodeURIComponent + "=" + encodeURIComponent2 + "&");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(encodeURIComponent2);
                        sb3.append(",");
                        sb2.append(sb3.toString());
                    }
                }
                sb2.append(XAdSDKRemoteConfig.SED);
                String md5 = EncryptUtils.getMD5(sb2.toString());
                sb.append("vd=" + md5 + "&");
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public abstract HashMap<String, String> toAdditionalHashMap();

    public HashMap<String, String> toFixedHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(XAdRemoteAPKDownloadExtraInfo.ADID, this.adid);
            hashMap.put("appsec", this.appsec);
            hashMap.put("appsid", this.appsid);
            hashMap.put("pack", this.packageNameOfPubliser);
            hashMap.put(XAdRemoteAPKDownloadExtraInfo.QK, this.qk);
            hashMap.put(IAdRequestParam.SN, this.sn);
            hashMap.put("ts", "" + this.ts);
            hashMap.put("v", this.v);
            hashMap.put(IAdRequestParam.OS, this.os);
            hashMap.put("prod", this.prod);
            hashMap.put("cuid", this.cuid);
            hashMap.put("p_ver", XAdRemoteCommonUtils.getProxyVer());
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public HashMap<String, String> toHashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap<String, String> fixedHashMap = toFixedHashMap();
            HashMap<String, String> additionalHashMap = toAdditionalHashMap();
            if (additionalHashMap != null) {
                fixedHashMap.putAll(additionalHashMap);
            }
            return fixedHashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? mapToString(toHashMap()) : (String) invokeV.objValue;
    }

    @Deprecated
    public XAdRemoteAbstractTrackingInfo(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.adid = "-1";
        this.qk = "";
        this.packageNameOfPubliser = "";
        this.appsec = "";
        this.appsid = "";
        this.v = "";
        this.sn = "";
        this.prod = "";
        this.cuid = "";
        this.mApplicationContext = XAdRemoteCommonUtils.getApplicationContext();
        this.ts = System.currentTimeMillis();
        this.adid = str;
        this.qk = str2;
        this.appsec = str5;
        Context context = this.mApplicationContext;
        if (context != null) {
            this.packageNameOfPubliser = context.getPackageName();
        }
        this.appsid = str4;
        this.sn = DeviceUtils.getInstance().getEncodedSN(this.mApplicationContext);
        this.os = "android";
        this.v = "android_" + XAdSDKRemoteVersion.getVersion() + "_4.1.30";
        this.prod = str3;
        this.cuid = Base64.encode(DeviceUtils.getInstance().getCUID(this.mApplicationContext));
    }
}
