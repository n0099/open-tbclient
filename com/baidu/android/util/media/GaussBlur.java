package com.baidu.android.util.media;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes6.dex */
public final class GaussBlur {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int RADIUS = 10;
    public transient /* synthetic */ FieldHolder $fh;

    public GaussBlur() {
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

    public static Bitmap fastBlur(Bitmap bitmap, boolean z, float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Boolean.valueOf(z), Float.valueOf(f2), Integer.valueOf(i2)})) == null) ? com.baidu.android.util.bitmap.GaussBlur.fastBlur(bitmap, z, f2, i2) : (Bitmap) invokeCommon.objValue;
    }
}
