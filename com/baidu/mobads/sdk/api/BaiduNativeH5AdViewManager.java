package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BaiduNativeH5AdViewManager {
    public static /* synthetic */ Interceptable $ic;
    public static BaiduNativeH5AdViewManager theInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public BaiduNativeH5AdViewManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized BaiduNativeH5AdViewManager getInstance() {
        InterceptResult invokeV;
        BaiduNativeH5AdViewManager baiduNativeH5AdViewManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (BaiduNativeH5AdViewManager.class) {
                if (theInstance == null) {
                    theInstance = new BaiduNativeH5AdViewManager();
                }
                baiduNativeH5AdViewManager = theInstance;
            }
            return baiduNativeH5AdViewManager;
        }
        return (BaiduNativeH5AdViewManager) invokeV.objValue;
    }

    public BaiduNativeH5AdView getBaiduNativeH5AdView(Context context, BaiduNativeAdPlacement baiduNativeAdPlacement, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, context, baiduNativeAdPlacement, i)) == null) {
            BaiduNativeH5AdView adView = baiduNativeAdPlacement.getAdView();
            if (baiduNativeAdPlacement.getAdView() == null) {
                BaiduNativeH5AdView baiduNativeH5AdView = new BaiduNativeH5AdView(context, i);
                baiduNativeH5AdView.setAdPlacement(baiduNativeAdPlacement);
                baiduNativeAdPlacement.setAdView(baiduNativeH5AdView);
                return baiduNativeH5AdView;
            }
            return adView;
        }
        return (BaiduNativeH5AdView) invokeLLI.objValue;
    }
}
