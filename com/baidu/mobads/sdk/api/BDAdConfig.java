package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BDAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public String mAppName;
    public String mAppsid;
    public BDAdInitListener mBDAdInitListener;
    public String mChannelId;
    public boolean mCloseShake;
    public JSONObject mConfigObj;
    public boolean mDebug;
    public JSONObject mDialogParams;
    public JSONObject mExtraParams;
    public boolean mHttps;
    public boolean mLpMultiProcess;
    public boolean mMtjSwitch;
    public boolean mSplashLog;
    public boolean mUseActivityDialog;
    public int mVideoCacheCapacityMb;
    public String mWXAPPid;

    /* loaded from: classes3.dex */
    public interface BDAdInitListener {
        void fail();

        void success();
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAppName;
        public String mAppsid;
        public BDAdInitListener mBDAdInitListener;
        public String mChannelId;
        public boolean mCloseShake;
        public boolean mDebug;
        public JSONObject mDialogParams;
        public JSONObject mExtraParams;
        public boolean mHttps;
        public boolean mLpSupportMultiProcess;
        public boolean mMtjSwitch;
        public boolean mSplashLog;
        public boolean mUseActivityDialog;
        public int mVideoCacheCapacityMb;
        public String mWXAPPid;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHttps = true;
            this.mUseActivityDialog = true;
            this.mMtjSwitch = true;
            this.mCloseShake = false;
            this.mDebug = false;
            this.mSplashLog = false;
        }

        public BDAdConfig build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return new BDAdConfig(context, this);
            }
            return (BDAdConfig) invokeL.objValue;
        }

        public Builder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mAppName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppsid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mAppsid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBDAdInitListener(BDAdInitListener bDAdInitListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bDAdInitListener)) == null) {
                this.mBDAdInitListener = bDAdInitListener;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mChannelId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setCloseShake(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.mCloseShake = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDebug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.mDebug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDialogParams(BDDialogParams bDDialogParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bDDialogParams)) == null) {
                this.mDialogParams = bDDialogParams.toJson();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setHttps(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.mHttps = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLpMultiProcess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.mLpSupportMultiProcess = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setMtjSwitch(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
                this.mMtjSwitch = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSplashLog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
                this.mSplashLog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoCacheCapacityMb(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
                this.mVideoCacheCapacityMb = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setWXAppid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                this.mWXAPPid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @Deprecated
        public Builder useActivityDialog(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bool)) == null) {
                this.mUseActivityDialog = bool.booleanValue();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder putExtraParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (this.mExtraParams == null) {
                    this.mExtraParams = new JSONObject();
                }
                try {
                    this.mExtraParams.put(str, str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    public BDAdConfig(Context context, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUseActivityDialog = true;
        this.mDebug = false;
        this.mSplashLog = false;
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
        this.mUseActivityDialog = builder.mUseActivityDialog;
        this.mDialogParams = builder.mDialogParams;
        this.mMtjSwitch = builder.mMtjSwitch;
        this.mCloseShake = builder.mCloseShake;
        this.mDebug = builder.mDebug;
        this.mWXAPPid = builder.mWXAPPid;
        this.mBDAdInitListener = builder.mBDAdInitListener;
        this.mSplashLog = builder.mSplashLog;
        this.mExtraParams = builder.mExtraParams;
    }

    public static void clearMemoryCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            try {
                z.a().c().onTaskDistribute(az.c, null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            this.mConfigObj = jSONObject;
            try {
                jSONObject.put("https", "" + this.mHttps);
                this.mConfigObj.put("appName", this.mAppName);
                JSONObject jSONObject2 = this.mConfigObj;
                jSONObject2.put("videoCacheSize", "" + this.mVideoCacheCapacityMb);
                this.mConfigObj.put("appsid", this.mAppsid);
                this.mConfigObj.put("channelId", this.mChannelId);
                JSONObject jSONObject3 = this.mConfigObj;
                jSONObject3.put("lpMultiProcess", "" + this.mLpMultiProcess);
                JSONObject jSONObject4 = this.mConfigObj;
                jSONObject4.put("useActivityDialog", "" + this.mUseActivityDialog);
                this.mConfigObj.put("dialog_params", this.mDialogParams);
                this.mConfigObj.put("mtj_switch", this.mMtjSwitch);
                this.mConfigObj.put("sp_shake", this.mCloseShake);
                this.mConfigObj.put("sdk_debug", this.mDebug);
                this.mConfigObj.put("splashLog", this.mSplashLog);
                this.mConfigObj.put("extras", this.mExtraParams);
                if (!TextUtils.isEmpty(this.mWXAPPid)) {
                    this.mConfigObj.put("wxAppid", this.mWXAPPid);
                }
                co.a().a(this.mLpMultiProcess);
                co.a().b(this.mHttps);
                av.a(this.mDebug);
            } catch (Exception e) {
                e.printStackTrace();
            }
            z.a().a(this.mAppContext, new z.a(this) { // from class: com.baidu.mobads.sdk.api.BDAdConfig.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDAdConfig this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.sdk.internal.z.a
                public void onFailure() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mBDAdInitListener != null) {
                        this.this$0.mBDAdInitListener.fail();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.z.a
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        IXAdContainerFactory c = z.a().c();
                        if (c != null) {
                            c.initConfig(this.this$0.mConfigObj);
                            c.onTaskDistribute(az.a, MobadsPermissionSettings.getPermissionInfo());
                        }
                        if (this.this$0.mBDAdInitListener != null) {
                            this.this$0.mBDAdInitListener.success();
                        }
                    }
                }
            });
        }
    }
}
