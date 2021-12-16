package c.i.b.a.a0.o;

import c.i.b.a.i0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l a;

    /* renamed from: b  reason: collision with root package name */
    public int f29442b;

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
        this.a = new l(8);
    }

    public final long a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            int i2 = 0;
            fVar.c(this.a.a, 0, 1);
            int i3 = this.a.a[0] & 255;
            if (i3 == 0) {
                return Long.MIN_VALUE;
            }
            int i4 = 128;
            int i5 = 0;
            while ((i3 & i4) == 0) {
                i4 >>= 1;
                i5++;
            }
            int i6 = i3 & (~i4);
            fVar.c(this.a.a, 1, i5);
            while (i2 < i5) {
                i2++;
                i6 = (this.a.a[i2] & 255) + (i6 << 8);
            }
            this.f29442b += i5 + 1;
            return i6;
        }
        return invokeL.longValue;
    }

    public boolean b(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        long a;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        long length = fVar.getLength();
        long j2 = 1024;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j2 = length;
        }
        int i4 = (int) j2;
        fVar.c(this.a.a, 0, 4);
        long z = this.a.z();
        this.f29442b = 4;
        while (z != 440786851) {
            int i5 = this.f29442b + 1;
            this.f29442b = i5;
            if (i5 == i4) {
                return false;
            }
            fVar.c(this.a.a, 0, 1);
            z = ((z << 8) & (-256)) | (this.a.a[0] & 255);
        }
        long a2 = a(fVar);
        long j3 = this.f29442b;
        if (a2 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j3 + a2 >= length) {
            return false;
        }
        while (true) {
            int i6 = this.f29442b;
            long j4 = j3 + a2;
            if (i6 >= j4) {
                return ((long) i6) == j4;
            } else if (a(fVar) != Long.MIN_VALUE && (a(fVar)) >= 0 && a <= 2147483647L) {
                if (i2 != 0) {
                    fVar.g((int) a);
                    this.f29442b = (int) (this.f29442b + a);
                }
            }
        }
    }
}
