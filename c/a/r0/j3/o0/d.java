package c.a.r0.j3.o0;

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

    /* renamed from: a  reason: collision with root package name */
    public volatile int f20999a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f21000b;

    /* renamed from: c  reason: collision with root package name */
    public volatile HashMap<Long, Integer> f21001c;

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
        this.f21001c = new HashMap<>();
        this.f20999a = 0;
        this.f21000b = i2;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                synchronized (this) {
                    if (this.f21001c.size() >= this.f21000b) {
                        c();
                    }
                    this.f20999a++;
                    this.f21001c.put(valueOf, Integer.valueOf(this.f20999a));
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
                return this.f21001c.containsKey(Long.valueOf(Long.parseLong(str)));
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
                for (Map.Entry<Long, Integer> entry : this.f21001c.entrySet()) {
                    if (entry.getValue().intValue() < i2) {
                        int intValue = entry.getValue().intValue();
                        i2 = intValue;
                        l = entry.getKey();
                    }
                }
                if (l != null) {
                    this.f21001c.remove(l);
                } else {
                    this.f21001c.clear();
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
                    return this.f21001c.get(valueOf) != null;
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
