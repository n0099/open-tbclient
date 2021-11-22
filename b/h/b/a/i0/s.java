package b.h.b.a.i0;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f33516a;

    /* renamed from: b  reason: collision with root package name */
    public long f33517b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f33518c;

    public s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33518c = -9223372036854775807L;
        h(j);
    }

    public static long f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? (j * 1000000) / SapiWebView.DEFAULT_TIMEOUT_MILLIS : invokeJ.longValue;
    }

    public static long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? (j * SapiWebView.DEFAULT_TIMEOUT_MILLIS) / 1000000 : invokeJ.longValue;
    }

    public long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            if (this.f33518c != -9223372036854775807L) {
                this.f33518c = j;
            } else {
                long j2 = this.f33516a;
                if (j2 != Long.MAX_VALUE) {
                    this.f33517b = j2 - j;
                }
                synchronized (this) {
                    this.f33518c = j;
                    notifyAll();
                }
            }
            return j + this.f33517b;
        }
        return invokeJ.longValue;
    }

    public long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            if (this.f33518c != -9223372036854775807L) {
                long i2 = i(this.f33518c);
                long j2 = (4294967296L + i2) / AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                long j3 = ((j2 - 1) * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT) + j;
                j += j2 * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                if (Math.abs(j3 - i2) < Math.abs(j - i2)) {
                    j = j3;
                }
            }
            return a(f(j));
        }
        return invokeJ.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33516a : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f33518c != -9223372036854775807L) {
                return this.f33518c;
            }
            long j = this.f33516a;
            if (j != Long.MAX_VALUE) {
                return j;
            }
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33516a == Long.MAX_VALUE) {
                return 0L;
            }
            if (this.f33518c == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f33517b;
        }
        return invokeV.longValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f33518c = -9223372036854775807L;
        }
    }

    public synchronized void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            synchronized (this) {
                a.f(this.f33518c == -9223372036854775807L);
                this.f33516a = j;
            }
        }
    }

    public synchronized void j() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                while (this.f33518c == -9223372036854775807L) {
                    wait();
                }
            }
        }
    }
}
