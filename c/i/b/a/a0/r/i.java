package c.i.b.a.a0.r;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29692b;

    /* renamed from: c  reason: collision with root package name */
    public int f29693c;

    /* renamed from: d  reason: collision with root package name */
    public int f29694d;

    public i(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f29692b = bArr.length;
    }

    public final void a() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i3 = this.f29693c;
            c.i.b.a.i0.a.f(i3 >= 0 && (i3 < (i2 = this.f29692b) || (i3 == i2 && this.f29694d == 0)));
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f29693c * 8) + this.f29694d : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            boolean z = (((this.a[this.f29693c] & 255) >> this.f29694d) & 1) == 1;
            e(1);
            return z;
        }
        return invokeV.booleanValue;
    }

    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int i3 = this.f29693c;
            int min = Math.min(i2, 8 - this.f29694d);
            int i4 = i3 + 1;
            int i5 = ((this.a[i3] & 255) >> this.f29694d) & (255 >> (8 - min));
            while (min < i2) {
                i5 |= (this.a[i4] & 255) << min;
                min += 8;
                i4++;
            }
            int i6 = i5 & ((-1) >>> (32 - i2));
            e(i2);
            return i6;
        }
        return invokeI.intValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            int i3 = i2 / 8;
            int i4 = this.f29693c + i3;
            this.f29693c = i4;
            int i5 = this.f29694d + (i2 - (i3 * 8));
            this.f29694d = i5;
            if (i5 > 7) {
                this.f29693c = i4 + 1;
                this.f29694d = i5 - 8;
            }
            a();
        }
    }
}
