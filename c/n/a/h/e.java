package c.n.a.h;

import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public float f34387a;

    /* renamed from: b  reason: collision with root package name */
    public float f34388b;

    /* renamed from: c  reason: collision with root package name */
    public float f34389c;

    /* renamed from: d  reason: collision with root package name */
    public float f34390d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34391e;

    public e() {
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
        this.f34389c = 1.0f;
        this.f34390d = 1.0f;
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34391e : invokeV.booleanValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34389c : invokeV.floatValue;
    }

    public final float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34390d : invokeV.floatValue;
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34387a : invokeV.floatValue;
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34388b : invokeV.floatValue;
    }

    public final void f(float f2, float f3, float f4, float f5, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), scaleType}) == null) || f2 == 0.0f || f3 == 0.0f || f4 == 0.0f || f5 == 0.0f) {
            return;
        }
        g();
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f3 - f5) / 2.0f;
        float f8 = f4 / f5;
        float f9 = f2 / f3;
        float f10 = f3 / f5;
        float f11 = f2 / f4;
        switch (d.$EnumSwitchMapping$0[scaleType.ordinal()]) {
            case 1:
                this.f34387a = f6;
                this.f34388b = f7;
                return;
            case 2:
                if (f8 > f9) {
                    this.f34391e = false;
                    this.f34389c = f10;
                    this.f34390d = f10;
                    this.f34387a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
                this.f34391e = true;
                this.f34389c = f11;
                this.f34390d = f11;
                this.f34388b = (f3 - (f5 * f11)) / 2.0f;
                return;
            case 3:
                if (f4 < f2 && f5 < f3) {
                    this.f34387a = f6;
                    this.f34388b = f7;
                    return;
                } else if (f8 > f9) {
                    this.f34391e = true;
                    this.f34389c = f11;
                    this.f34390d = f11;
                    this.f34388b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                } else {
                    this.f34391e = false;
                    this.f34389c = f10;
                    this.f34390d = f10;
                    this.f34387a = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
            case 4:
                if (f8 > f9) {
                    this.f34391e = true;
                    this.f34389c = f11;
                    this.f34390d = f11;
                    this.f34388b = (f3 - (f5 * f11)) / 2.0f;
                    return;
                }
                this.f34391e = false;
                this.f34389c = f10;
                this.f34390d = f10;
                this.f34387a = (f2 - (f4 * f10)) / 2.0f;
                return;
            case 5:
                if (f8 > f9) {
                    this.f34391e = true;
                    this.f34389c = f11;
                    this.f34390d = f11;
                    return;
                }
                this.f34391e = false;
                this.f34389c = f10;
                this.f34390d = f10;
                return;
            case 6:
                if (f8 > f9) {
                    this.f34391e = true;
                    this.f34389c = f11;
                    this.f34390d = f11;
                    this.f34388b = f3 - (f5 * f11);
                    return;
                }
                this.f34391e = false;
                this.f34389c = f10;
                this.f34390d = f10;
                this.f34387a = f2 - (f4 * f10);
                return;
            case 7:
                Math.max(f11, f10);
                this.f34391e = f11 > f10;
                this.f34389c = f11;
                this.f34390d = f10;
                return;
            default:
                this.f34391e = true;
                this.f34389c = f11;
                this.f34390d = f11;
                return;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f34387a = 0.0f;
            this.f34388b = 0.0f;
            this.f34389c = 1.0f;
            this.f34390d = 1.0f;
            this.f34391e = false;
        }
    }
}
