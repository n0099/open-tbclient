package c.a.o0.c.a.i;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f10318a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f10319b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f10320c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f10321d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f10322e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f10323f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f10324g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f10325h;

    /* renamed from: i  reason: collision with root package name */
    public long f10326i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f10327j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Integer) objArr[0], (Integer) objArr[1], (Integer) objArr[2], (Integer) objArr[3], (byte[]) objArr[4], (byte[]) objArr[5], ((Long) objArr[6]).longValue(), (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, num2, num3, num4, bArr, bArr2, Long.valueOf(j2), bArr3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10320c = num;
        this.f10321d = num2;
        this.f10322e = num3;
        this.f10323f = num4;
        this.f10324g = bArr;
        this.f10325h = bArr2;
        this.f10326i = j2;
        this.f10327j = bArr3;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (k.f7049a) {
                String str = "Recovery: add recoveryCount: " + this.f10319b;
            }
            this.f10319b++;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10319b < 3 : invokeV.booleanValue;
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10324g : (byte[]) invokeV.objValue;
    }

    public final Integer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10320c : (Integer) invokeV.objValue;
    }

    public final Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10322e : (Integer) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    return Intrinsics.areEqual(this.f10320c, gVar.f10320c) && Intrinsics.areEqual(this.f10321d, gVar.f10321d) && Intrinsics.areEqual(this.f10322e, gVar.f10322e) && Intrinsics.areEqual(this.f10323f, gVar.f10323f) && Intrinsics.areEqual(this.f10324g, gVar.f10324g) && Intrinsics.areEqual(this.f10325h, gVar.f10325h) && this.f10326i == gVar.f10326i && Intrinsics.areEqual(this.f10327j, gVar.f10327j);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final Integer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f10321d : (Integer) invokeV.objValue;
    }

    public final Integer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f10323f : (Integer) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f10318a : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.f10320c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.f10321d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.f10322e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f10323f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.f10324g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.f10325h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j2 = this.f10326i;
            int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            byte[] bArr3 = this.f10327j;
            return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public final byte[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f10325h : (byte[]) invokeV.objValue;
    }

    public final synchronized boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                z = false;
                if (this.f10324g != null && this.f10325h != null && this.f10326i > currentTimeMillis && this.f10318a == 1) {
                    z = true;
                }
                if (c.a.o0.c.a.a.f10283a) {
                    String str = "isSessionEnable " + this.f10324g + ' ' + this.f10325h + ' ' + this.f10326i + ' ' + this.f10318a;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (k.f7049a) {
                String str = "Downgrade: reset downgrade count " + this.f10319b;
            }
            this.f10319b = 0;
        }
    }

    public final void l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            this.f10324g = bArr;
        }
    }

    public final void m(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.f10320c = num;
        }
    }

    public final void n(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            this.f10322e = num;
        }
    }

    public final void o(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.f10321d = num;
        }
    }

    public final void p(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            this.f10323f = num;
        }
    }

    public final void q(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bArr) == null) {
            this.f10327j = bArr;
        }
    }

    public final void r(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j2) == null) {
            this.f10326i = j2;
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.f10318a = i2;
        }
    }

    public final void t(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bArr) == null) {
            this.f10325h = bArr;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "SessionParams(dhGroupId=" + this.f10320c + ", dhSecretKey=" + this.f10321d + ", dhPublicKey=" + this.f10322e + ", dhServerPublicKey=" + this.f10323f + ", aesSecretKey=" + Arrays.toString(this.f10324g) + ", sessionTicket=" + Arrays.toString(this.f10325h) + ", expireTime=" + this.f10326i + ", entryType=" + Arrays.toString(this.f10327j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ g(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j2, (i2 & 128) == 0 ? bArr3 : null);
    }
}
