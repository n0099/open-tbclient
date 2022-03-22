package c.a.p0.n0.f.d.d;

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
/* loaded from: classes2.dex */
public final class b extends c.a.p0.n0.f.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.a<a> f16477b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f16478c;

    /* renamed from: d  reason: collision with root package name */
    public float f16479d;

    /* renamed from: e  reason: collision with root package name */
    public final PointF f16480e;

    /* renamed from: f  reason: collision with root package name */
    public float f16481f;

    public b() {
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
        this.f16477b = new c.b.b.q.a<>(0);
        this.f16478c = new PointF();
        this.f16480e = new PointF(1.0f, 1.0f);
        this.f16481f = 1.0f;
    }

    public final void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            g();
            a.b<a> it = this.f16477b.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "actions.iterator()");
            while (it.hasNext()) {
                it.next().a(j);
            }
        }
    }

    public final void d(a action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, action) == null) {
            Intrinsics.checkNotNullParameter(action, "action");
            action.c(this);
            action.b();
            this.f16477b.a(action);
        }
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16481f : invokeV.floatValue;
    }

    public final PointF f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16478c : (PointF) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a().f().u();
            this.f16478c.set(0.0f, 0.0f);
            this.f16479d = 0.0f;
            this.f16480e.set(1.0f, 1.0f);
            this.f16481f = 1.0f;
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
            PointF pointF = this.f16480e;
            matrix.setScale(pointF.x, pointF.y);
            matrix.postRotate(this.f16479d);
            PointF pointF2 = this.f16478c;
            matrix.postTranslate(pointF2.x, pointF2.y);
        }
    }

    @Override // c.a.p0.n0.f.c.a, c.b.b.q.z.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.reset();
            g();
            this.f16477b.clear();
        }
    }
}
