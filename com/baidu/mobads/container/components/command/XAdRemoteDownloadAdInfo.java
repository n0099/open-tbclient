package com.baidu.mobads.container.components.command;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class XAdRemoteDownloadAdInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appOpenStrs;
    public boolean isTooLarge;
    public boolean mAPOOpen;
    public int mAct;
    public boolean mActionOnlyWifi;
    public String mAdId;
    public String mApId;
    public String mAppName;
    public String mAppPackageName;
    public long mAppSize;
    public String mAppsid;
    public String mAsl;
    public boolean mAutoOpen;
    public String mBuyer;
    public String mClickThroughUrl;
    public String mDlType;
    public int mDownType;
    public HashMap<String, String> mExtras;
    public boolean mIsPopNotif;
    public String mOriginalUrl;
    public String mPage;
    public String mProd;
    public String mQueryKey;
    public String mTitle;
    public JSONObject originJsonObject;

    public XAdRemoteDownloadAdInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDownType = 1;
        this.mAutoOpen = true;
        this.mIsPopNotif = true;
        this.mActionOnlyWifi = true;
        this.mAPOOpen = false;
        this.mExtras = new HashMap<>();
    }

    public static XAdRemoteDownloadAdInfo createAdInfoFromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = new XAdRemoteDownloadAdInfo();
            xAdRemoteDownloadAdInfo.mApId = "";
            xAdRemoteDownloadAdInfo.mProd = "";
            if (jSONObject != null) {
                xAdRemoteDownloadAdInfo.mClickThroughUrl = jSONObject.optString("curl", "");
                xAdRemoteDownloadAdInfo.mOriginalUrl = jSONObject.optString("ori_curl", "");
                xAdRemoteDownloadAdInfo.mAdId = jSONObject.optString("id", "-1");
                xAdRemoteDownloadAdInfo.mAct = jSONObject.optInt("act");
                xAdRemoteDownloadAdInfo.mTitle = jSONObject.optString("tit", "");
                xAdRemoteDownloadAdInfo.mAppPackageName = jSONObject.optString("pk", "");
                xAdRemoteDownloadAdInfo.mAppName = jSONObject.optString("appname", "");
                xAdRemoteDownloadAdInfo.mQueryKey = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK, "");
                xAdRemoteDownloadAdInfo.mActionOnlyWifi = true;
                xAdRemoteDownloadAdInfo.mAppSize = jSONObject.optLong("sz", 0L);
                xAdRemoteDownloadAdInfo.isTooLarge = false;
                xAdRemoteDownloadAdInfo.originJsonObject = jSONObject;
                xAdRemoteDownloadAdInfo.mAsl = jSONObject.optString("app_store_link", "");
                xAdRemoteDownloadAdInfo.appOpenStrs = jSONObject.optString("apo", "");
                try {
                    xAdRemoteDownloadAdInfo.mPage = new JSONObject(xAdRemoteDownloadAdInfo.appOpenStrs).optString("page", "");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return xAdRemoteDownloadAdInfo;
        }
        return (XAdRemoteDownloadAdInfo) invokeL.objValue;
    }

    public static XAdRemoteDownloadAdInfo createFromInstanceInfo(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iXAdInstanceInfo)) == null) {
            XAdRemoteDownloadAdInfo xAdRemoteDownloadAdInfo = new XAdRemoteDownloadAdInfo();
            xAdRemoteDownloadAdInfo.mApId = "";
            xAdRemoteDownloadAdInfo.mProd = "";
            if (iXAdInstanceInfo != null) {
                xAdRemoteDownloadAdInfo.mClickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
                xAdRemoteDownloadAdInfo.mOriginalUrl = iXAdInstanceInfo.getOriginClickUrl();
                xAdRemoteDownloadAdInfo.mAdId = iXAdInstanceInfo.getAdId();
                xAdRemoteDownloadAdInfo.mAct = iXAdInstanceInfo.getActionType();
                xAdRemoteDownloadAdInfo.mBuyer = iXAdInstanceInfo.getBuyer();
                xAdRemoteDownloadAdInfo.mTitle = iXAdInstanceInfo.getTitle();
                xAdRemoteDownloadAdInfo.mAppPackageName = iXAdInstanceInfo.getAppPackageName();
                xAdRemoteDownloadAdInfo.mAppName = iXAdInstanceInfo.getAppName();
                xAdRemoteDownloadAdInfo.mQueryKey = iXAdInstanceInfo.getQueryKey();
                xAdRemoteDownloadAdInfo.mAutoOpen = iXAdInstanceInfo.isAutoOpen();
                xAdRemoteDownloadAdInfo.mIsPopNotif = iXAdInstanceInfo.isPopNotif();
                xAdRemoteDownloadAdInfo.mActionOnlyWifi = iXAdInstanceInfo.isActionOnlyWifi();
                xAdRemoteDownloadAdInfo.mAppSize = iXAdInstanceInfo.getAppSize();
                xAdRemoteDownloadAdInfo.isTooLarge = iXAdInstanceInfo.isTooLarge();
                xAdRemoteDownloadAdInfo.mAPOOpen = iXAdInstanceInfo.getAPOOpen();
                xAdRemoteDownloadAdInfo.mPage = iXAdInstanceInfo.getPage();
                xAdRemoteDownloadAdInfo.mAsl = iXAdInstanceInfo.getAppStoreLink();
                xAdRemoteDownloadAdInfo.originJsonObject = iXAdInstanceInfo.getOriginJsonObject();
                xAdRemoteDownloadAdInfo.appOpenStrs = iXAdInstanceInfo.getAppOpenStrs();
            }
            return xAdRemoteDownloadAdInfo;
        }
        return (XAdRemoteDownloadAdInfo) invokeL.objValue;
    }

    public void addExtraParam(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.mExtras.put(str, str2);
        }
    }

    public boolean getAPOOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAPOOpen : invokeV.booleanValue;
    }

    public int getActType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAct : invokeV.intValue;
    }

    public String getAdId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAdId : (String) invokeV.objValue;
    }

    public String getApId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mApId : (String) invokeV.objValue;
    }

    public String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mAppName : (String) invokeV.objValue;
    }

    public String getAppOpenStrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.appOpenStrs : (String) invokeV.objValue;
    }

    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mAppPackageName : (String) invokeV.objValue;
    }

    public long getAppSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAppSize : invokeV.longValue;
    }

    public String getAppStoreLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAsl : (String) invokeV.objValue;
    }

    public String getAppsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mAppsid : (String) invokeV.objValue;
    }

    public String getClickThroughUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mClickThroughUrl : (String) invokeV.objValue;
    }

    public HashMap<String, String> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mExtras : (HashMap) invokeV.objValue;
    }

    public String getOriginClickUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mOriginalUrl : (String) invokeV.objValue;
    }

    public JSONObject getOriginJsonObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.originJsonObject : (JSONObject) invokeV.objValue;
    }

    public String getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mPage : (String) invokeV.objValue;
    }

    public String getProd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mProd : (String) invokeV.objValue;
    }

    public String getQueryKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mQueryKey : (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mTitle : (String) invokeV.objValue;
    }

    public boolean isActionOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mActionOnlyWifi : invokeV.booleanValue;
    }

    public boolean isAutoOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mAutoOpen : invokeV.booleanValue;
    }

    public boolean isPopNotif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsPopNotif : invokeV.booleanValue;
    }

    public boolean isTooLarge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.isTooLarge : invokeV.booleanValue;
    }
}
