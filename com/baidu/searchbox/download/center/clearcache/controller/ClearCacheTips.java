package com.baidu.searchbox.download.center.clearcache.controller;

import android.text.TextUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.download.center.clearcache.ClearCacheDataChangeEvent;
import com.baidu.searchbox.download.center.clearcache.ClearCacheRuntime;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ClearCacheTips {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CLEAR_CACHE_TIPS_KEY = "clear_cache_tips_key";
    public transient /* synthetic */ FieldHolder $fh;

    public ClearCacheTips() {
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

    public static String buildTips(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : str : (String) invokeL.objValue;
    }

    public static void notifyTips(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j2) == null) {
            ClearCacheUtils.markDoneClearJob();
            DefaultSharedPrefsWrapper.getInstance().putString(CLEAR_CACHE_TIPS_KEY, buildTips(ClearCacheUtils.formatSize(j2)));
            ClearCacheRuntime.getClearCacheContext().notifyPersonalClearCacheTipsChange();
            BdEventBus.Companion.getDefault().post(new ClearCacheDataChangeEvent());
        }
    }
}
