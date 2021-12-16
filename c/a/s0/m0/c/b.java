package c.a.s0.m0.c;

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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f19267b;

    /* renamed from: c  reason: collision with root package name */
    public int f19268c;

    /* renamed from: d  reason: collision with root package name */
    public int f19269d;

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
        this.a = new Canvas();
        this.f19267b = c.a.s0.m0.g.b.b();
    }

    public final void a(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            boolean z2 = !z ? i2 > this.f19268c || i3 > this.f19269d : !(i2 == this.f19268c && i3 == this.f19269d);
            if (!Intrinsics.areEqual(this.f19267b, c.a.s0.m0.g.b.b()) && !this.f19267b.isRecycled() && z2) {
                this.f19267b.eraseColor(0);
                this.a.setBitmap(this.f19267b);
                return;
            }
            this.f19268c = Math.max(1, i2);
            this.f19269d = Math.max(1, i3);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.f19268c, this.f19269d, i5 == 32 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ARGB_4444);
                if (i4 > 0) {
                    createBitmap.setDensity(i4);
                }
                d().setBitmap(createBitmap);
                d().setDensity(i4);
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig…y = density\n            }");
                this.f19267b = createBitmap;
            } catch (Exception unused) {
                this.f19267b = c.a.s0.m0.g.b.b();
                this.a.setBitmap(null);
                this.f19268c = 0;
                this.f19269d = 0;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19267b.isRecycled()) {
            return;
        }
        this.f19267b.eraseColor(0);
    }

    public final Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19267b : (Bitmap) invokeV.objValue;
    }

    public final Canvas d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (Canvas) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19269d : invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19268c : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Intrinsics.areEqual(this.f19267b, c.a.s0.m0.g.b.b())) {
            return;
        }
        this.a.setBitmap(null);
        this.f19267b = c.a.s0.m0.g.b.b();
        this.f19268c = 0;
        this.f19269d = 0;
    }
}
