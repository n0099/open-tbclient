package c.a.r0.l0.c;

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
    public Bitmap f18795b;

    /* renamed from: c  reason: collision with root package name */
    public int f18796c;

    /* renamed from: d  reason: collision with root package name */
    public int f18797d;

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
        this.f18795b = c.a.r0.l0.g.b.b();
    }

    public final void a(int i2, int i3, int i4, boolean z, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)}) == null) {
            boolean z2 = !z ? i2 > this.f18796c || i3 > this.f18797d : !(i2 == this.f18796c && i3 == this.f18797d);
            if (!Intrinsics.areEqual(this.f18795b, c.a.r0.l0.g.b.b()) && !this.f18795b.isRecycled() && z2) {
                this.f18795b.eraseColor(0);
                this.a.setBitmap(this.f18795b);
                return;
            }
            this.f18796c = Math.max(1, i2);
            this.f18797d = Math.max(1, i3);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.f18796c, this.f18797d, i5 == 32 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ARGB_4444);
                if (i4 > 0) {
                    createBitmap.setDensity(i4);
                }
                d().setBitmap(createBitmap);
                d().setDensity(i4);
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, heig…y = density\n            }");
                this.f18795b = createBitmap;
            } catch (Exception unused) {
                this.f18795b = c.a.r0.l0.g.b.b();
                this.a.setBitmap(null);
                this.f18796c = 0;
                this.f18797d = 0;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18795b.isRecycled()) {
            return;
        }
        this.f18795b.eraseColor(0);
    }

    public final Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18795b : (Bitmap) invokeV.objValue;
    }

    public final Canvas d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (Canvas) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18797d : invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f18796c : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Intrinsics.areEqual(this.f18795b, c.a.r0.l0.g.b.b())) {
            return;
        }
        this.a.setBitmap(null);
        this.f18795b = c.a.r0.l0.g.b.b();
        this.f18796c = 0;
        this.f18797d = 0;
    }
}
