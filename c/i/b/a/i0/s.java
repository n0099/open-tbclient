package c.i.b.a.i0;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f33726a;

    /* renamed from: b  reason: collision with root package name */
    public long f33727b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f33728c;

    public s(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33728c = -9223372036854775807L;
        h(j2);
    }

    public static long f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j2)) == null) ? (j2 * 1000000) / SapiWebView.DEFAULT_TIMEOUT_MILLIS : invokeJ.longValue;
    }

    public static long i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j2)) == null) ? (j2 * SapiWebView.DEFAULT_TIMEOUT_MILLIS) / 1000000 : invokeJ.longValue;
    }

    public long a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            if (this.f33728c != -9223372036854775807L) {
                this.f33728c = j2;
            } else {
                long j3 = this.f33726a;
                if (j3 != Long.MAX_VALUE) {
                    this.f33727b = j3 - j2;
                }
                synchronized (this) {
                    this.f33728c = j2;
                    notifyAll();
                }
            }
            return j2 + this.f33727b;
        }
        return invokeJ.longValue;
    }

    public long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            if (this.f33728c != -9223372036854775807L) {
                long i2 = i(this.f33728c);
                long j3 = (4294967296L + i2) / AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                long j4 = ((j3 - 1) * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT) + j2;
                j2 += j3 * AnimatedStateListDrawableCompat.AnimatedStateListState.REVERSIBLE_FLAG_BIT;
                if (Math.abs(j4 - i2) < Math.abs(j2 - i2)) {
                    j2 = j4;
                }
            }
            return a(f(j2));
        }
        return invokeJ.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33726a : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f33728c != -9223372036854775807L) {
                return this.f33728c;
            }
            long j2 = this.f33726a;
            if (j2 != Long.MAX_VALUE) {
                return j2;
            }
            return -9223372036854775807L;
        }
        return invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f33726a == Long.MAX_VALUE) {
                return 0L;
            }
            if (this.f33728c == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f33727b;
        }
        return invokeV.longValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f33728c = -9223372036854775807L;
        }
    }

    public synchronized void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            synchronized (this) {
                a.f(this.f33728c == -9223372036854775807L);
                this.f33726a = j2;
            }
        }
    }

    public synchronized void j() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                while (this.f33728c == -9223372036854775807L) {
                    wait();
                }
            }
        }
    }
}
