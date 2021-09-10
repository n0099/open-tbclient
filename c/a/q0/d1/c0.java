package c.a.q0.d1;

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
public class c0<KEY> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayMap<KEY, Long> f12904a;

    /* renamed from: b  reason: collision with root package name */
    public long f12905b;

    public c0(int i2, @NonNull TimeUnit timeUnit) {
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
        this.f12904a = new ArrayMap<>();
        this.f12905b = timeUnit.toMillis(i2);
    }

    public static <T> c0<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new c0<>(1000, TimeUnit.MILLISECONDS) : (c0) invokeV.objValue;
    }

    public synchronized boolean a(@NonNull KEY key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, key)) == null) {
            synchronized (this) {
                Long l = this.f12904a.get(key);
                long uptimeMillis = SystemClock.uptimeMillis();
                if (l == null) {
                    this.f12904a.put(key, Long.valueOf(uptimeMillis));
                    return true;
                } else if (uptimeMillis - l.longValue() > this.f12905b) {
                    this.f12904a.put(key, Long.valueOf(uptimeMillis));
                    return true;
                } else {
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }
}
