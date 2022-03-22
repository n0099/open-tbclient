package c.a.d.j;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteService;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static volatile e f2474d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Class<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public int f2475b;

    /* renamed from: c  reason: collision with root package name */
    public int f2476c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1528893972, "Lc/a/d/j/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1528893972, "Lc/a/d/j/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f2475b = 0;
        this.f2476c = 0;
        this.a = new HashMap<>();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f2474d == null) {
                synchronized (e.class) {
                    if (f2474d == null) {
                        f2474d = new e();
                    }
                }
            }
            return f2474d;
        }
        return (e) invokeV.objValue;
    }

    public Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            Class<?> cls2 = this.a.get(cls.getName());
            if (cls2 == null) {
                if (PluginBaseRemoteService.class.isAssignableFrom(cls)) {
                    int i = this.f2476c;
                    if (i == 10) {
                        BdLog.e("can not find service,Has started 10 Remoteservice");
                        return null;
                    }
                    this.f2476c = i + 1;
                    str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f2476c;
                } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                    int i2 = this.f2475b;
                    if (i2 == 20) {
                        BdLog.e("can not find service,Has started 20 service");
                        return null;
                    }
                    this.f2475b = i2 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f2475b;
                } else {
                    str = PluginBaseThirdService.class.isAssignableFrom(cls) ? "com.baidu.adp.plugin.proxy.service.ThirdServiceProxy" : "";
                }
                try {
                    cls2 = Class.forName(str);
                    this.a.put(cls.getName(), cls2);
                    return cls2;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls2;
                }
            }
            return cls2;
        }
        return (Class) invokeL.objValue;
    }
}
