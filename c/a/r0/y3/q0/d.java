package c.a.r0.y3.q0;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f25144b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f25145c;

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25145c = new HashMap<>();
        this.a = 0;
        this.f25144b = i2;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    if (this.f25145c.size() >= this.f25144b) {
                        c();
                    }
                    this.a++;
                    this.f25145c.put(valueOf, Integer.valueOf(this.a));
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
                return this.f25145c.containsKey(Long.valueOf(Long.parseLong(str)));
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
                int i2 = 134217727;
                for (Map.Entry<Long, Integer> entry : this.f25145c.entrySet()) {
                    if (entry.getValue().intValue() < i2) {
                        int intValue = entry.getValue().intValue();
                        i2 = intValue;
                        l = entry.getKey();
                    }
                }
                if (l != null) {
                    this.f25145c.remove(l);
                } else {
                    this.f25145c.clear();
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
                    return this.f25145c.get(valueOf) != null;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
