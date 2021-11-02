package com.baidu.mobads.container.dex;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SkyDex {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String METHOD_NAME_SETAPPSID = "setAppSid";
    public static final String PATH_FeedAd = "com.baidu.mobad.feeds.BaiduNative";
    public static final String PATH_FeedBuilder = "com.baidu.mobad.feeds.RequestParameters$Builder";
    public static final String PATH_FeedListener = "com.baidu.mobad.feeds.BaiduNative$BaiduNativeNetworkListener";
    public static final String PATH_FeedRequestParams = "com.baidu.mobad.feeds.RequestParameters";
    public static final String getMaterialType = "getAdMaterialType";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public SkyDex(Context context) {
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
        this.mContext = context.getApplicationContext();
    }

    public static void setId(Context context, String str, String str2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) {
            Class.forName(str).getMethod(METHOD_NAME_SETAPPSID, Context.class, String.class).invoke(null, context, str2);
        }
    }
}
