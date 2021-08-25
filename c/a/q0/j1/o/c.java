package c.a.q0.j1.o;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.c.e.c.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static c f20966d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f20967a;

    /* renamed from: b  reason: collision with root package name */
    public List<Long> f20968b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f20969c;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20970a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20970a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                this.f20970a.b();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(26586518, "Lc/a/q0/j1/o/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(26586518, "Lc/a/q0/j1/o/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20967a = 0L;
        this.f20968b = new ArrayList();
        this.f20969c = new a(this, 2005016);
        MessageManager.getInstance().registerListener(this.f20969c);
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f20966d == null) {
                synchronized (c.class) {
                    if (f20966d == null) {
                        f20966d = new c();
                    }
                }
            }
            return f20966d;
        }
        return (c) invokeV.objValue;
    }

    public synchronized void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (this) {
                if (this.f20967a != 0 && this.f20967a != j2) {
                    this.f20968b.clear();
                    i.c("PushIdsCacheManager", null, 0, "addPushId", -1, "not equal original gid:" + j2 + "-" + this.f20967a);
                }
                this.f20967a = j2;
                for (Long l : this.f20968b) {
                    if (l != null && l.longValue() == j3) {
                        return;
                    }
                }
                this.f20968b.add(Long.valueOf(j3));
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.f20967a = 0L;
                this.f20968b.clear();
            }
        }
    }

    public synchronized boolean c(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            synchronized (this) {
                for (Long l : this.f20968b) {
                    if (l != null && l.longValue() == j2) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeJ.booleanValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20967a : invokeV.longValue;
    }

    public Long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? c.a.q0.j1.k.b.o().r().get(this.f20967a) : (Long) invokeV.objValue;
    }

    public synchronized List<Long> g() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (Long l : this.f20968b) {
                    if (l != null) {
                        arrayList.add(Long.valueOf(c.a.q0.j1.w.b.c(l.longValue())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized String h() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                str = "";
                for (Long l : this.f20968b) {
                    if (l != null && l.longValue() != 0) {
                        str = (str + l.longValue()) + ",";
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public synchronized boolean i() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                if (this.f20967a > 0) {
                    z = this.f20968b.size() > 0;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2) == null) {
            synchronized (this) {
                b();
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    this.f20967a = c.a.e.e.m.b.f(str, 0L);
                    try {
                        String[] split = str2.split(",");
                        if (split != null && split.length > 0) {
                            for (int i2 = 0; i2 < split.length; i2++) {
                                if (!TextUtils.isEmpty(split[i2])) {
                                    this.f20968b.add(Long.valueOf(Long.parseLong(split[i2])));
                                }
                            }
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                } catch (Exception e3) {
                    BdLog.e(e3);
                }
            }
        }
    }

    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                this.f20968b.clear();
            }
        }
    }
}
