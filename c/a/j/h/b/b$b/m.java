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
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f4071b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f4072c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f4073d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f4074e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f4075f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f4076g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f4077h;

    /* renamed from: i  reason: collision with root package name */
    public long f4078i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f4079j;

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
        this.f4072c = num;
        this.f4073d = num2;
        this.f4074e = num3;
        this.f4075f = num4;
        this.f4076g = bArr;
        this.f4077h = bArr2;
        this.f4078i = j2;
        this.f4079j = bArr3;
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
            this.f4078i = j2;
        }
    }

    public final void d(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, num) == null) {
            this.f4072c = num;
        }
    }

    public final void e(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            this.f4076g = bArr;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof m) {
                    m mVar = (m) obj;
                    if (Intrinsics.areEqual(this.f4072c, mVar.f4072c) && Intrinsics.areEqual(this.f4073d, mVar.f4073d) && Intrinsics.areEqual(this.f4074e, mVar.f4074e) && Intrinsics.areEqual(this.f4075f, mVar.f4075f) && Intrinsics.areEqual(this.f4076g, mVar.f4076g) && Intrinsics.areEqual(this.f4077h, mVar.f4077h)) {
                        if (!(this.f4078i == mVar.f4078i) || !Intrinsics.areEqual(this.f4079j, mVar.f4079j)) {
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
            debugTrace.a("Recovery: add recoveryCount: " + this.f4071b);
            this.f4071b = this.f4071b + 1;
        }
    }

    public final void g(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.f4073d = num;
        }
    }

    public final void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr) == null) {
            this.f4077h = bArr;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.f4072c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.f4073d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.f4074e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f4075f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.f4076g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.f4077h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j2 = this.f4078i;
            int i2 = (((hashCode5 + hashCode6) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            byte[] bArr3 = this.f4079j;
            return i2 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public final void i(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, num) == null) {
            this.f4074e = num;
        }
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.f4079j = bArr;
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
                if (this.f4076g != null && this.f4077h != null && this.f4078i > currentTimeMillis && this.a == 1) {
                    z = true;
                }
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("isSessionEnable " + this.f4076g + ' ' + this.f4077h + ' ' + this.f4078i + ' ' + this.a);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, num) == null) {
            this.f4075f = num;
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f4071b < 3 : invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("Downgrade: reset downgrade count " + this.f4071b);
            this.f4071b = 0;
        }
    }

    public final Integer o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f4072c : (Integer) invokeV.objValue;
    }

    public final Integer p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f4073d : (Integer) invokeV.objValue;
    }

    public final byte[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f4076g : (byte[]) invokeV.objValue;
    }

    public final byte[] r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f4077h : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "SessionParams(dhGroupId=" + this.f4072c + ", dhSecretKey=" + this.f4073d + ", dhPublicKey=" + this.f4074e + ", dhServerPublicKey=" + this.f4075f + ", aesSecretKey=" + Arrays.toString(this.f4076g) + ", sessionTicket=" + Arrays.toString(this.f4077h) + ", expireTime=" + this.f4078i + ", entryType=" + Arrays.toString(this.f4079j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ m(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j2, byte[] bArr3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : num4, (i2 & 16) != 0 ? null : bArr, (i2 & 32) != 0 ? null : bArr2, (i2 & 64) != 0 ? 0L : j2, (i2 & 128) == 0 ? bArr3 : null);
    }
}
