package c.a.t0.m0.i;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.view.InputDeviceCompat;
import c.b.b.q.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class b implements z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.m0.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.m0.c.a f19539b;

    /* renamed from: c  reason: collision with root package name */
    public PointF f19540c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f19541d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f19542e;

    /* renamed from: f  reason: collision with root package name */
    public float f19543f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19544g;

    public b(c.a.t0.m0.e.a item, c.a.t0.m0.c.a drawingCache, PointF position, RectF rect, Matrix transform) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {item, drawingCache, position, rect, transform};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(drawingCache, "drawingCache");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.a = item;
        this.f19539b = drawingCache;
        this.f19540c = position;
        this.f19541d = rect;
        this.f19542e = transform;
        this.f19543f = 1.0f;
    }

    public final float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19543f : invokeV.floatValue;
    }

    public final c.a.t0.m0.c.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19539b : (c.a.t0.m0.c.a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19544g : invokeV.booleanValue;
    }

    public final c.a.t0.m0.e.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (c.a.t0.m0.e.a) invokeV.objValue;
    }

    public final PointF e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19540c : (PointF) invokeV.objValue;
    }

    public final RectF f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19541d : (RectF) invokeV.objValue;
    }

    public final Matrix g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19542e : (Matrix) invokeV.objValue;
    }

    public final void h(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f19543f = f2;
        }
    }

    public final void i(c.a.t0.m0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.f19539b = aVar;
        }
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f19544g = z;
        }
    }

    public final void k(c.a.t0.m0.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.a = aVar;
        }
    }

    @Override // c.b.b.q.z.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }
}
