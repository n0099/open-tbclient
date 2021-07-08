package com.baidu.mobads.container.adrequest;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteExp;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.mobads.container.util.oaid.UniqueIdUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BasicAdRequestInfo implements IAdRequestParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> mAdditionalParameters;
    public Context mCxt;
    public String mPrefixOfV;

    public BasicAdRequestInfo(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPrefixOfV = "android";
        this.mCxt = context;
    }

    private String getAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? AppUtils.supportDl(this.mCxt) ? "NA,LP,DL,APO" : "NA,LP,APO" : (String) invokeV.objValue;
    }

    private String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public HashMap<String, String> additionalParameters2HashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, String> hashMap2 = this.mAdditionalParameters;
            if (hashMap2 != null && hashMap2.size() > 0) {
                for (String str : this.mAdditionalParameters.keySet()) {
                    String str2 = this.mAdditionalParameters.get(str);
                    if (str2 instanceof String) {
                        hashMap.put(str, str2);
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public HashMap<String, String> fixedParameters2HashMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = "1";
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put(IAdRequestParam.MSA, "1");
                hashMap.put("appid", DeviceUtils.getInstance().getAppId(this.mCxt));
                hashMap.put("act", getAct());
                hashMap.put(IAdRequestParam.SES, "" + System.currentTimeMillis());
                hashMap.put(IAdRequestParam.COST_NAME, DeviceUtils.getInstance().getAppId(this.mCxt) + "_cpr");
                hashMap.put("pk", AppUtils.getAppPackage(this.mCxt));
                hashMap.put(IAdRequestParam.CELL_ID, DeviceUtils.getInstance().getCell(this.mCxt));
                hashMap.put("g", DeviceUtils.getInstance().getGPS(this.mCxt));
                hashMap.put(IAdRequestParam.WIFI, DeviceUtils.getInstance().getWIFI(this.mCxt));
                hashMap.put(IAdRequestParam.APINFO, DeviceUtils.getInstance().getBaiduMapsInfo(this.mCxt));
                hashMap.put("mac", "");
                hashMap.put(IAdRequestParam.CSS_ID, "");
                hashMap.put("im", DeviceUtils.getInstance().getSubscriberId(this.mCxt));
                hashMap.put("imei", DeviceUtils.getInstance().getIMEI(this.mCxt));
                hashMap.put(IAdRequestParam.SNFROM, DeviceUtils.getInstance().getSnFrom(this.mCxt));
                hashMap.put(IAdRequestParam.SN, DeviceUtils.getInstance().getSn(this.mCxt));
                hashMap.put(IAdRequestParam.ANDROID_ID, DeviceUtils.getInstance().getAndroidId(this.mCxt));
                hashMap.put("cuid", DeviceUtils.getInstance().getCUID(this.mCxt));
                hashMap.put(IAdRequestParam.NCUID, PluginLoader.getNCuidFrom27jar(this.mCxt));
                hashMap.put("oaid", UniqueIdUtils.getMiidOAID(this.mCxt));
                if (XAdSDKRemoteExp.SecDexExp.isAddZdTd(this.mCxt)) {
                    hashMap.put("td", PluginLoader.getTdid(this.mCxt));
                }
                hashMap.put("iadex", APKStateManager.getInstance().getIADEXValue(this.mCxt));
                hashMap.put("sw", "" + ScreenUtils.getScreenWidth(this.mCxt));
                hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + ScreenUtils.getScreenHeight(this.mCxt));
                hashMap.put(IAdRequestParam.DENSITY, "" + ScreenUtils.getScreenDensity(this.mCxt));
                hashMap.put(IAdRequestParam.BDR, "" + Build.VERSION.SDK_INT);
                hashMap.put(IAdRequestParam.OS, "android");
                hashMap.put(IAdRequestParam.PHONE_TYPE, Build.MODEL);
                hashMap.put(IAdRequestParam.OSV, Build.VERSION.RELEASE);
                hashMap.put(IAdRequestParam.BRAND, DeviceUtils.getInstance().getPhoneOSBrand());
                if (!DeviceUtils.getInstance().isTablet(this.mCxt)) {
                    str = "0";
                }
                hashMap.put("tab", str);
                hashMap.put(IAdRequestParam.SDC, SdcardUtils.getAppSDC(this.mCxt) + "," + SdcardUtils.getMem(this.mCxt));
                hashMap.put(IAdRequestParam.SDK_VALID, "sdk_9.042");
                hashMap.put("v", this.mPrefixOfV + "_" + XAdSDKRemoteVersion.getVersion() + "_" + XAdRemoteCommonUtils.getAdServVersion());
                hashMap.put("p_ver", AppConfigImp.getInstance().getProxyVersion());
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkInfoUtils.getNetworkCatagory(this.mCxt));
                hashMap.put("net", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append("wifi".equals(NetworkInfoUtils.getNetworkType(this.mCxt)) ? 1 : 0);
                hashMap.put(IAdRequestParam.SWI, sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(AppConfigImp.getInstance().isSupportHttps() ? 2 : 1);
                hashMap.put(IAdRequestParam.RPT, sb3.toString());
                hashMap.put(IAdRequestParam.APV, "" + getVersionName(this.mCxt));
                hashMap.put(IAdRequestParam.NETWORK_OPERATOR, NetworkInfoUtils.getNetworkOperator(this.mCxt));
                hashMap.put(IAdRequestParam.CHID, AppConfigImp.getInstance().getChannelId());
                hashMap.put(IAdRequestParam.IMEI2, DeviceUtils.getInstance().getIMEI2(this.mCxt));
                return hashMap;
            } catch (Throwable th) {
                th.printStackTrace();
                return hashMap;
            }
        }
        return (HashMap) invokeV.objValue;
    }

    public String toFullURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, String> fixedParameters2HashMap = fixedParameters2HashMap();
            fixedParameters2HashMap.putAll(additionalParameters2HashMap());
            return AdURIUtils.getRequestAdUrl(IHostConfig.AD_REQUEST_BFP_HOST, fixedParameters2HashMap);
        }
        return (String) invokeV.objValue;
    }
}
