package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.sdk.internal.RemoteDexLoader;
import com.baidu.mobads.sdk.internal.XAdURIUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class BDAdConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public String mAppName;
    public String mAppsid;
    public String mChannelId;
    public JSONObject mConfigObj;
    public boolean mHttps;
    public boolean mLpMultiProcess;
    public int mVideoCacheCapacityMb;

    /* renamed from: com.baidu.mobads.sdk.api.BDAdConfig$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAppName;
        public String mAppsid;
        public String mChannelId;
        public boolean mHttps;
        public boolean mLpSupportMultiProcess;
        public int mVideoCacheCapacityMb;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public BDAdConfig build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new BDAdConfig(context, this, null) : (BDAdConfig) invokeL.objValue;
        }

        public Builder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.mAppName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAppsid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mAppsid = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setChannelId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mChannelId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setHttps(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.mHttps = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setLpMultiProcess(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                this.mLpSupportMultiProcess = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setVideoCacheCapacityMb(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
                this.mVideoCacheCapacityMb = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public /* synthetic */ BDAdConfig(Context context, Builder builder, AnonymousClass1 anonymousClass1) {
        this(context, builder);
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
                jSONObject2.put(AppConfigImp.KEY_VIDEOCACHE, "" + this.mVideoCacheCapacityMb);
                this.mConfigObj.put("appsid", this.mAppsid);
                this.mConfigObj.put(AppConfigImp.KEY_CHANNELID, this.mChannelId);
                JSONObject jSONObject3 = this.mConfigObj;
                jSONObject3.put(AppConfigImp.KEY_LP_MULTIPROCESS, "" + this.mLpMultiProcess);
                XAdURIUtils.getInstance().setLpMultiProcess(this.mLpMultiProcess);
                XAdURIUtils.getInstance().setHttps(this.mHttps);
                RemoteDexLoader.getInstance().initRemoteDex(this.mAppContext);
                RemoteDexLoader.getInstance().getContainerFactory().initConfig(this.mConfigObj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BDAdConfig(Context context, Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHttps = builder.mHttps;
        this.mAppContext = context;
        this.mVideoCacheCapacityMb = builder.mVideoCacheCapacityMb;
        this.mAppName = builder.mAppName;
        this.mAppsid = builder.mAppsid;
        this.mChannelId = builder.mChannelId;
        this.mLpMultiProcess = builder.mLpSupportMultiProcess;
    }
}
