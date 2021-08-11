package c.a.o0.b1;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class b0<KEY> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap<KEY, Long> f12549a;

    /* renamed from: b  reason: collision with root package name */
    public long f12550b;

    public b0(int i2, @NonNull TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12549a = new ArrayMap<>();
        this.f12550b = timeUnit.toMillis(i2);
    }

    public static <T> b0<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new b0<>(1000, TimeUnit.MILLISECONDS) : (b0) invokeV.objValue;
    }

    public synchronized boolean a(@NonNull KEY key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
            synchronized (this) {
                Long l = this.f12549a.get(key);
                long uptimeMillis = SystemClock.uptimeMillis();
                if (l == null) {
                    this.f12549a.put(key, Long.valueOf(uptimeMillis));
                    return true;
                } else if (uptimeMillis - l.longValue() > this.f12550b) {
                    this.f12549a.put(key, Long.valueOf(uptimeMillis));
                    return true;
                } else {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
