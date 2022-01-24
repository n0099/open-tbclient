package c.a.d.i;

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
    public static volatile e f3250d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Class<?>> a;

    /* renamed from: b  reason: collision with root package name */
    public int f3251b;

    /* renamed from: c  reason: collision with root package name */
    public int f3252c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1528923763, "Lc/a/d/i/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1528923763, "Lc/a/d/i/e;");
        }
    }

    public e() {
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
        this.a = null;
        this.f3251b = 0;
        this.f3252c = 0;
        this.a = new HashMap<>();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3250d == null) {
                synchronized (e.class) {
                    if (f3250d == null) {
                        f3250d = new e();
                    }
                }
            }
            return f3250d;
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
                    int i2 = this.f3252c;
                    if (i2 == 10) {
                        BdLog.e("can not find service,Has started 10 Remoteservice");
                        return null;
                    }
                    this.f3252c = i2 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.RemoteServiceProxy" + this.f3252c;
                } else if (PluginBaseService.class.isAssignableFrom(cls)) {
                    int i3 = this.f3251b;
                    if (i3 == 20) {
                        BdLog.e("can not find service,Has started 20 service");
                        return null;
                    }
                    this.f3251b = i3 + 1;
                    str = "com.baidu.adp.plugin.proxy.service.ServiceProxy" + this.f3251b;
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
