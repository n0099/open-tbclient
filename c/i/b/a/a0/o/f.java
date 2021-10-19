package c.i.b.a.a0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f32553d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f32554a;

    /* renamed from: b  reason: collision with root package name */
    public int f32555b;

    /* renamed from: c  reason: collision with root package name */
    public int f32556c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445180900, "Lc/i/b/a/a0/o/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445180900, "Lc/i/b/a/a0/o/f;");
                return;
            }
        }
        f32553d = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32554a = new byte[8];
    }

    public static long a(byte[] bArr, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            long j2 = bArr[0] & 255;
            if (z) {
                j2 &= ~f32553d[i2 - 1];
            }
            for (int i3 = 1; i3 < i2; i3++) {
                j2 = (j2 << 8) | (bArr[i3] & 255);
            }
            return j2;
        }
        return invokeCommon.longValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65539, null, i2)) != null) {
            return invokeI.intValue;
        }
        int i3 = 0;
        while (true) {
            long[] jArr = f32553d;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & i2) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32556c : invokeV.intValue;
    }

    public long d(c.i.b.a.a0.f fVar, boolean z, boolean z2, int i2) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            if (this.f32555b == 0) {
                if (!fVar.a(this.f32554a, 0, 1, z)) {
                    return -1L;
                }
                int c2 = c(this.f32554a[0] & 255);
                this.f32556c = c2;
                if (c2 != -1) {
                    this.f32555b = 1;
                } else {
                    throw new IllegalStateException("No valid varint length mask found");
                }
            }
            int i3 = this.f32556c;
            if (i3 > i2) {
                this.f32555b = 0;
                return -2L;
            }
            if (i3 != 1) {
                fVar.readFully(this.f32554a, 1, i3 - 1);
            }
            this.f32555b = 0;
            return a(this.f32554a, this.f32556c, z2);
        }
        return invokeCommon.longValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f32555b = 0;
            this.f32556c = 0;
        }
    }
}
