package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.da;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CPUNovelAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public da mCpuNovelProd;

    /* loaded from: classes3.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, cPUWebAdRequestParam, cpuNovelListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        da daVar = new da(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = daVar;
        daVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        da daVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (daVar = this.mCpuNovelProd) != null) {
            daVar.y();
        }
    }

    public View getNovelView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCpuNovelProd.w();
        }
        return (View) invokeV.objValue;
    }
}
