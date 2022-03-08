package c.a.j.h.b.b$b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f3708b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f3709c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f3710d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f3711e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f3712f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3713g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f3714h;

    /* renamed from: i  reason: collision with root package name */
    public long f3715i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f3716j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m() {
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

    public m(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3) {
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
        this.f3709c = num;
        this.f3710d = num2;
        this.f3711e = num3;
        this.f3712f = num4;
        this.f3713g = bArr;
        this.f3714h = bArr2;
        this.f3715i = j2;
        this.f3716j = bArr3;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a = i2;
        }
    }

    public final void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.f3715i = j2;
        }
    }

    public final void d(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
            this.f3709c = num;
        }
    }

    public final void e(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            this.f3713g = bArr;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof m) {
                    m mVar = (m) obj;
                    if (Intrinsics.areEqual(this.f3709c, mVar.f3709c) && Intrinsics.areEqual(this.f3710d, mVar.f3710d) && Intrinsics.areEqual(this.f3711e, mVar.f3711e) && Intrinsics.areEqual(this.f3712f, mVar.f3712f) && Intrinsics.areEqual(this.f3713g, mVar.f3713g) && Intrinsics.areEqual(this.f3714h, mVar.f3714h)) {
                        if (!(this.f3715i == mVar.f3715i) || !Intrinsics.areEqual(this.f3716j, mVar.f3716j)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("Recovery: add recoveryCount: " + this.f3708b);
            this.f3708b = this.f3708b + 1;
        }
    }

    public final void g(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.f3710d = num;
        }
    }

    public final void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            this.f3714h = bArr;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.f3709c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.f3710d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.f3711e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f3712f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.f3713g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.f3714h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j2 = this.f3715i;
            int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            byte[] bArr3 = this.f3716j;
            return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public final void i(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, num) == null) {
            this.f3711e = num;
        }
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.f3716j = bArr;
        }
    }

    public final synchronized boolean k() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                z = false;
                if (this.f3713g != null && this.f3714h != null && this.f3715i > currentTimeMillis && this.a == 1) {
                    z = true;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("isSessionEnable " + this.f3713g + WebvttCueParser.CHAR_SPACE + this.f3714h + WebvttCueParser.CHAR_SPACE + this.f3715i + WebvttCueParser.CHAR_SPACE + this.a);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            this.f3712f = num;
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f3708b < 3 : invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("Downgrade: reset downgrade count " + this.f3708b);
            this.f3708b = 0;
        }
    }

    public final Integer o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f3709c : (Integer) invokeV.objValue;
    }

    public final Integer p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f3710d : (Integer) invokeV.objValue;
    }

    public final byte[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f3713g : (byte[]) invokeV.objValue;
    }

    public final byte[] r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f3714h : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "SessionParams(dhGroupId=" + this.f3709c + ", dhSecretKey=" + this.f3710d + ", dhPublicKey=" + this.f3711e + ", dhServerPublicKey=" + this.f3712f + ", aesSecretKey=" + Arrays.toString(this.f3713g) + ", sessionTicket=" + Arrays.toString(this.f3714h) + ", expireTime=" + this.f3715i + ", entryType=" + Arrays.toString(this.f3716j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ m(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j2, (i2 & 128) == 0 ? bArr3 : null);
    }
}
