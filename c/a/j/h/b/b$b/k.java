package c.a.j.h.b.b$b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final a f3555i;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f3556b;

    /* renamed from: c  reason: collision with root package name */
    public byte f3557c;

    /* renamed from: d  reason: collision with root package name */
    public byte f3558d;

    /* renamed from: e  reason: collision with root package name */
    public short f3559e;

    /* renamed from: f  reason: collision with root package name */
    public int f3560f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3561g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f3562h;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                k kVar = new k(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
                kVar.d(new byte[2]);
                byte[] e2 = kVar.e();
                if (e2 != null) {
                    e2[0] = 0;
                }
                byte[] e3 = kVar.e();
                if (e3 != null) {
                    e3[1] = 2;
                }
                kVar.g(new byte[2]);
                byte[] h2 = kVar.h();
                if (h2 != null) {
                    h2[0] = -27;
                }
                byte[] h3 = kVar.h();
                if (h3 != null) {
                    h3[1] = -89;
                }
                return kVar;
            }
            return (k) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(738460222, "Lc/a/j/h/b/b$b/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(738460222, "Lc/a/j/h/b/b$b/k;");
                return;
            }
        }
        f3555i = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, null, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((byte[]) objArr[0], (byte[]) objArr[1], ((Byte) objArr[2]).byteValue(), ((Byte) objArr[3]).byteValue(), ((Short) objArr[4]).shortValue(), ((Integer) objArr[5]).intValue(), (byte[]) objArr[6], (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public k(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, byte[] bArr3, byte[] bArr4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, bArr2, Byte.valueOf(b2), Byte.valueOf(b3), Short.valueOf(s), Integer.valueOf(i2), bArr3, bArr4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.f3556b = bArr2;
        this.f3557c = b2;
        this.f3558d = b3;
        this.f3559e = s;
        this.f3560f = i2;
        this.f3561g = bArr3;
        this.f3562h = bArr4;
    }

    public final void a(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048576, this, b2) == null) {
            this.f3557c = b2;
        }
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f3560f = i2;
        }
    }

    public final void c(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Short.valueOf(s)}) == null) {
            this.f3559e = s;
        }
    }

    public final void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            this.a = bArr;
        }
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (byte[]) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    if (Intrinsics.areEqual(this.a, kVar.a) && Intrinsics.areEqual(this.f3556b, kVar.f3556b)) {
                        if (this.f3557c == kVar.f3557c) {
                            if (this.f3558d == kVar.f3558d) {
                                if (this.f3559e == kVar.f3559e) {
                                    if (!(this.f3560f == kVar.f3560f) || !Intrinsics.areEqual(this.f3561g, kVar.f3561g) || !Intrinsics.areEqual(this.f3562h, kVar.f3562h)) {
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048582, this, b2) == null) {
            this.f3558d = b2;
        }
    }

    public final void g(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            this.f3556b = bArr;
        }
    }

    public final byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f3556b : (byte[]) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            byte[] bArr = this.a;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            byte[] bArr2 = this.f3556b;
            int hashCode2 = (((((((((hashCode + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31) + this.f3557c) * 31) + this.f3558d) * 31) + this.f3559e) * 31) + this.f3560f) * 31;
            byte[] bArr3 = this.f3561g;
            int hashCode3 = (hashCode2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
            byte[] bArr4 = this.f3562h;
            return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
        }
        return invokeV.intValue;
    }

    public final byte i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f3557c : invokeV.byteValue;
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.f3561g = bArr;
        }
    }

    public final byte k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f3558d : invokeV.byteValue;
    }

    public final void l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            this.f3562h = bArr;
        }
    }

    public final short m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f3559e : invokeV.shortValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f3560f : invokeV.intValue;
    }

    public final byte[] o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3561g : (byte[]) invokeV.objValue;
    }

    public final byte[] p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f3562h : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "RecordParams(protocolVersion=" + Arrays.toString(this.a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.f3557c) + ", schemeExtType=" + ((int) this.f3558d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.f3559e) + ", contentLen=" + this.f3560f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.f3561g) + ')';
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ k(byte[] bArr, byte[] bArr2, byte b2, byte b3, short s, int i2, byte[] bArr3, byte[] bArr4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new byte[2] : bArr, (i3 & 2) != 0 ? new byte[2] : bArr2, (i3 & 4) != 0 ? (byte) 0 : b2, (i3 & 8) != 0 ? (byte) 0 : b3, (i3 & 16) != 0 ? (short) 0 : s, (i3 & 32) == 0 ? i2 : 0, (i3 & 64) != 0 ? null : bArr3, (i3 & 128) == 0 ? bArr4 : null);
    }
}
