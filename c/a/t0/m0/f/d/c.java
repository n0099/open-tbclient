package c.a.t0.m0.f.d;

import android.graphics.PointF;
import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class c extends c.a.t0.m0.f.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19242b;

    /* renamed from: c  reason: collision with root package name */
    public PointF f19243c;

    /* renamed from: d  reason: collision with root package name */
    public RectF f19244d;

    public c() {
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
        this.f19243c = new PointF();
        this.f19244d = new RectF();
    }

    public final PointF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19243c : (PointF) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19242b : invokeV.booleanValue;
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f19242b = z;
        }
    }

    @Override // c.a.t0.m0.f.c.a, c.b.b.q.z.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.reset();
            this.f19242b = false;
            this.f19243c = new PointF();
            this.f19244d = new RectF();
        }
    }

    public final c update(boolean z, int i2, PointF position, RectF rect, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), position, rect, Integer.valueOf(i3)})) == null) {
            Intrinsics.checkNotNullParameter(position, "position");
            Intrinsics.checkNotNullParameter(rect, "rect");
            this.f19242b = z;
            if (!Intrinsics.areEqual(this.f19243c, position)) {
                this.f19243c.set(position);
            }
            if (!Intrinsics.areEqual(this.f19244d, rect)) {
                this.f19244d.set(rect);
            }
            return this;
        }
        return (c) invokeCommon.objValue;
    }
}
