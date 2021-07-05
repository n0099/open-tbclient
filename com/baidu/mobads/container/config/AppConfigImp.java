package com.baidu.mobads.container.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.cache.LruDiskCache;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AppConfigImp {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_APPSID = "appsid";
    public static final String KEY_CHANNELID = "channelId";
    public static final String KEY_HTTPS = "https";
    public static final String KEY_LP_MULTIPROCESS = "lpMultiProcess";
    public static final String KEY_P_VERSION = "p_ver";
    public static final String KEY_VIDEOCACHE = "videoCacheSize";
    public static volatile AppConfigImp sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject mAppConObj;
    public Context mAppCxt;
    public String mAppsid;
    public String mChannelId;
    public ICommonModuleObj mCommonObj;
    public boolean mLpSupportMultiProcess;
    public String mProxyVersion;
    public boolean mSupportHttps;
    public int mVideoCacheSize;

    public AppConfigImp() {
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
        this.mSupportHttps = true;
    }

    public static AppConfigImp getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (AppConfigImp.class) {
                    if (sInstance == null) {
                        sInstance = new AppConfigImp();
                    }
                }
            }
            return sInstance;
        }
        return (AppConfigImp) invokeV.objValue;
    }

    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAppCxt : (Context) invokeV.objValue;
    }

    public String getAppsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAppsid : (String) invokeV.objValue;
    }

    public String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mChannelId : (String) invokeV.objValue;
    }

    public ICommonModuleObj getModuleObj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCommonObj : (ICommonModuleObj) invokeV.objValue;
    }

    public String getProxyVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mProxyVersion : (String) invokeV.objValue;
    }

    public void initSDK(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONObject) == null) {
            this.mAppConObj = jSONObject;
            String str = (String) ConvertUtils.optObjectFromJson(jSONObject, "p_ver");
            if (!TextUtils.isEmpty(str)) {
                this.mProxyVersion = str;
            }
            String str2 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, "https");
            if (!TextUtils.isEmpty(str2)) {
                this.mSupportHttps = Boolean.parseBoolean(str2);
            }
            String str3 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_VIDEOCACHE);
            if (!TextUtils.isEmpty(str3)) {
                int parseInt = Integer.parseInt(str3);
                this.mVideoCacheSize = parseInt;
                if (parseInt < 15 || parseInt > 100) {
                    this.mVideoCacheSize = 50;
                }
                LruDiskCache.open(SdcardUtils.getStoragePath(this.mAppCxt) + MaterialLoader.IMAGE_CACHE_PATH, this.mVideoCacheSize * 1000 * 1000);
            }
            String str4 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, "appsid");
            if (!TextUtils.isEmpty(str4)) {
                this.mAppsid = str4;
                DeviceUtils.getInstance().setAppId(this.mAppsid);
            }
            String str5 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_CHANNELID);
            if (!TextUtils.isEmpty(str5)) {
                this.mChannelId = str5;
            }
            String str6 = (String) ConvertUtils.optObjectFromJson(this.mAppConObj, KEY_LP_MULTIPROCESS);
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            this.mLpSupportMultiProcess = Boolean.parseBoolean(str6);
        }
    }

    public boolean isLpMultiProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mLpSupportMultiProcess : invokeV.booleanValue;
    }

    public boolean isSupportHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSupportHttps : invokeV.booleanValue;
    }

    public void setAppContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.mAppCxt = context.getApplicationContext();
        }
    }

    public void setAppsid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mAppsid = str;
        }
    }

    public void setModuleObj(ICommonModuleObj iCommonModuleObj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iCommonModuleObj) == null) {
            this.mCommonObj = iCommonModuleObj;
        }
    }
}
