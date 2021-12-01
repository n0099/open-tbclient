package c.a.r0.m0.f.d.d;

import android.graphics.Matrix;
import android.graphics.PointF;
import c.b.b.q.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class b extends c.a.r0.m0.f.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<a> f19902b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f19903c;

    /* renamed from: d  reason: collision with root package name */
    public float f19904d;

    /* renamed from: e  reason: collision with root package name */
    public final PointF f19905e;

    /* renamed from: f  reason: collision with root package name */
    public float f19906f;

    public b() {
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
        this.f19902b = new c.b.b.q.a<>(0);
        this.f19903c = new PointF();
        this.f19905e = new PointF(1.0f, 1.0f);
        this.f19906f = 1.0f;
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            g();
            a.b<a> it = this.f19902b.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "actions.iterator()");
            while (it.hasNext()) {
                it.next().a(j2);
            }
        }
    }

    public final void d(a action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            action.c(this);
            action.b();
            this.f19902b.a(action);
        }
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19906f : invokeV.floatValue;
    }

    public final PointF f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19903c : (PointF) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a().f().u();
            this.f19903c.set(0.0f, 0.0f);
            this.f19904d = 0.0f;
            this.f19905e.set(1.0f, 1.0f);
            this.f19906f = 1.0f;
        }
    }

    public final void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    public final void i(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, matrix) == null) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            PointF pointF = this.f19905e;
            matrix.setScale(pointF.x, pointF.y);
            matrix.postRotate(this.f19904d);
            PointF pointF2 = this.f19903c;
            matrix.postTranslate(pointF2.x, pointF2.y);
        }
    }

    @Override // c.a.r0.m0.f.c.a, c.b.b.q.z.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.reset();
            g();
            this.f19902b.clear();
        }
    }
}
