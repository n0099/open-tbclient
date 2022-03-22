package c.a.u0.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes3.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21386b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21387c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21388d;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public long f21389b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f21390c;

        /* renamed from: d  reason: collision with root package name */
        public int f21391d;

        /* renamed from: e  reason: collision with root package name */
        public int f21392e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f21393f;

        /* renamed from: g  reason: collision with root package name */
        public int f21394g;

        /* renamed from: h  reason: collision with root package name */
        public int f21395h;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f21390c), Integer.valueOf(this.f21394g), Boolean.valueOf(this.f21393f), Integer.valueOf(this.a), Long.valueOf(this.f21389b), Integer.valueOf(this.f21395h), Integer.valueOf(this.f21391d), Integer.valueOf(this.f21392e)) : (String) invokeV.objValue;
        }
    }

    public b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.f21386b = i2;
        this.f21387c = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.f21388d = i4;
    }

    public int a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (aVar.f21390c != null) {
                return aVar.f21391d - aVar.f21392e;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            for (byte b2 : bArr) {
                if (61 == b2 || k(b2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract void c(byte[] bArr, int i, int i2, a aVar);

    public byte[] d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? e(d.b(str)) : (byte[]) invokeL.objValue;
    }

    public byte[] e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = new a();
            c(bArr, 0, bArr.length, aVar);
            c(bArr, 0, -1, aVar);
            int i = aVar.f21391d;
            byte[] bArr2 = new byte[i];
            l(bArr2, 0, i, aVar);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public abstract void f(byte[] bArr, int i, int i2, a aVar);

    public byte[] g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            a aVar = new a();
            f(bArr, 0, bArr.length, aVar);
            f(bArr, 0, -1, aVar);
            int i = aVar.f21391d - aVar.f21392e;
            byte[] bArr2 = new byte[i];
            l(bArr2, 0, i, aVar);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] h(int i, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, aVar)) == null) {
            byte[] bArr = aVar.f21390c;
            return (bArr == null || bArr.length < aVar.f21391d + i) ? m(aVar) : bArr;
        }
        return (byte[]) invokeIL.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 8192;
        }
        return invokeV.intValue;
    }

    public long j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bArr)) == null) {
            int length = bArr.length;
            int i = this.a;
            long j = (((length + i) - 1) / i) * this.f21386b;
            int i2 = this.f21387c;
            return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.f21388d) : j;
        }
        return invokeL.longValue;
    }

    public abstract boolean k(byte b2);

    public int l(byte[] bArr, int i, int i2, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), aVar})) == null) {
            if (aVar.f21390c == null) {
                return aVar.f21393f ? -1 : 0;
            }
            int min = Math.min(a(aVar), i2);
            System.arraycopy(aVar.f21390c, aVar.f21392e, bArr, i, min);
            int i3 = aVar.f21392e + min;
            aVar.f21392e = i3;
            if (i3 >= aVar.f21391d) {
                aVar.f21390c = null;
            }
            return min;
        }
        return invokeCommon.intValue;
    }

    public final byte[] m(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, aVar)) == null) {
            byte[] bArr = aVar.f21390c;
            if (bArr == null) {
                aVar.f21390c = new byte[i()];
                aVar.f21391d = 0;
                aVar.f21392e = 0;
            } else {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                aVar.f21390c = bArr2;
            }
            return aVar.f21390c;
        }
        return (byte[]) invokeL.objValue;
    }
}
