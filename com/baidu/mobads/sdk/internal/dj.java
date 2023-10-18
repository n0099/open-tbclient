package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dj extends dr {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullScreenVideoAd.FullScreenVideoAdListener a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(Context context, String str, boolean z) {
        super(context, str, z, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.dr
    public void a(ScreenVideoAdListener screenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, screenVideoAdListener) == null) {
            super.a(screenVideoAdListener);
            if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
                this.a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.dr, com.baidu.mobads.sdk.internal.bf
    public void g(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (fullScreenVideoAdListener = this.a) != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }
}
