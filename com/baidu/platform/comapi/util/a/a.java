package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.vi.VIContext;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public int d;
    public int e;
    public int f;
    public double g;

    public a() {
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
        this.a = -1;
        this.b = -1;
        this.c = -1.0f;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1.0d;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == -1) {
                a(VIContext.getContext());
            }
            return this.a;
        }
        return invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b == -1) {
                a(VIContext.getContext());
            }
            return this.b;
        }
        return invokeV.intValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == -1.0f) {
                a(VIContext.getContext());
            }
            return this.c;
        }
        return invokeV.floatValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == -1) {
                a(VIContext.getContext());
            }
            return this.f;
        }
        return invokeV.intValue;
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.a = displayMetrics.widthPixels;
            this.b = displayMetrics.heightPixels;
            this.c = displayMetrics.density;
            this.d = (int) displayMetrics.xdpi;
            this.e = (int) displayMetrics.ydpi;
            if (Build.VERSION.SDK_INT > 3) {
                int i = displayMetrics.densityDpi;
                this.f = i;
                if (i < 240) {
                    this.f = i;
                }
            } else {
                this.f = 160;
            }
            if (this.f == 0) {
                this.f = 160;
            }
            this.g = this.f / 240.0d;
        }
    }
}
