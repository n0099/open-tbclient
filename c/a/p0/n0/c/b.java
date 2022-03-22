package c.a.p0.n0.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f16422b;

    /* renamed from: c  reason: collision with root package name */
    public int f16423c;

    /* renamed from: d  reason: collision with root package name */
    public int f16424d;

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
        this.a = new Canvas();
        this.f16422b = c.a.p0.n0.g.b.b();
    }

    public final void a(int i, int i2, int i3, boolean z, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
            boolean z2 = !z ? i > this.f16423c || i2 > this.f16424d : !(i == this.f16423c && i2 == this.f16424d);
            if (!Intrinsics.areEqual(this.f16422b, c.a.p0.n0.g.b.b()) && !this.f16422b.isRecycled() && z2) {
                this.f16422b.eraseColor(0);
                this.a.setBitmap(this.f16422b);
                return;
            }
            this.f16423c = Math.max(1, i);
            this.f16424d = Math.max(1, i2);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.f16423c, this.f16424d, i4 == 32 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ARGB_4444);
                if (i3 > 0) {
                    createBitmap.setDensity(i3);
                }
                d().setBitmap(createBitmap);
                d().setDensity(i3);
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig…y = density\n            }");
                this.f16422b = createBitmap;
            } catch (Exception unused) {
                this.f16422b = c.a.p0.n0.g.b.b();
                this.a.setBitmap(null);
                this.f16423c = 0;
                this.f16424d = 0;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16422b.isRecycled()) {
            return;
        }
        this.f16422b.eraseColor(0);
    }

    public final Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16422b : (Bitmap) invokeV.objValue;
    }

    public final Canvas d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (Canvas) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16424d : invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16423c : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Intrinsics.areEqual(this.f16422b, c.a.p0.n0.g.b.b())) {
            return;
        }
        this.a.setBitmap(null);
        this.f16422b = c.a.p0.n0.g.b.b();
        this.f16423c = 0;
        this.f16424d = 0;
    }
}
