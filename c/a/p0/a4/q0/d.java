package c.a.p0.a4.q0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f12336b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f12337c;

    public d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12337c = new HashMap<>();
        this.a = 0;
        this.f12336b = i;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    if (this.f12337c.size() >= this.f12336b) {
                        c();
                    }
                    this.a++;
                    this.f12337c.put(valueOf, Integer.valueOf(this.a));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return this.f12337c.containsKey(Long.valueOf(Long.parseLong(str)));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Long l = null;
                int i = 134217727;
                for (Map.Entry<Long, Integer> entry : this.f12337c.entrySet()) {
                    if (entry.getValue().intValue() < i) {
                        int intValue = entry.getValue().intValue();
                        i = intValue;
                        l = entry.getKey();
                    }
                }
                if (l != null) {
                    this.f12337c.remove(l);
                } else {
                    this.f12337c.clear();
                }
            }
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    return this.f12337c.get(valueOf) != null;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
