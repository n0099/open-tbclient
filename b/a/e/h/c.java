package b.a.e.h;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseRemoteSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseSingleTaskActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdFragmentActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseThirdSingleTaskActivity;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import com.baidu.adp.plugin.proxy.activity.FragmentActivityProxy;
import com.baidu.adp.plugin.proxy.activity.RemoteActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdActivityProxy;
import com.baidu.adp.plugin.proxy.activity.ThirdFragmentActivityProxy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile c f2221g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f2222a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f2223b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Class<?>, Class<?>> f2224c;

    /* renamed from: d  reason: collision with root package name */
    public int f2225d;

    /* renamed from: e  reason: collision with root package name */
    public int f2226e;

    /* renamed from: f  reason: collision with root package name */
    public int f2227f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1303810960, "Lb/a/e/h/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1303810960, "Lb/a/e/h/c;");
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
        this.f2222a = null;
        this.f2223b = null;
        this.f2224c = null;
        this.f2225d = 0;
        this.f2226e = 0;
        this.f2227f = 0;
        this.f2222a = new HashMap();
        this.f2223b = new HashMap();
        this.f2224c = new HashMap();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f2221g == null) {
                synchronized (c.class) {
                    if (f2221g == null) {
                        f2221g = new c();
                    }
                }
            }
            return f2221g;
        }
        return (c) invokeV.objValue;
    }

    public Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            if (cls == null) {
                return null;
            }
            if (PluginBaseSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls2 = this.f2222a.get(cls);
                if (cls2 != null) {
                    return cls2;
                }
                int i2 = this.f2226e;
                if (i2 == 20) {
                    BdLog.e("can not find singletaskactivity,Has started 20 singletaskactivity");
                    return null;
                }
                this.f2226e = i2 + 1;
                try {
                    cls2 = Class.forName("com.baidu.adp.plugin.proxy.activity.SingleTaskActivityProxy" + this.f2226e);
                    this.f2222a.put(cls, cls2);
                    return cls2;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return cls2;
                }
            } else if (PluginBaseRemoteSingleTaskActivity.class.isAssignableFrom(cls)) {
                Class<?> cls3 = this.f2223b.get(cls);
                if (cls3 != null) {
                    return cls3;
                }
                int i3 = this.f2227f;
                if (i3 == 10) {
                    BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                    return null;
                }
                this.f2227f = i3 + 1;
                try {
                    cls3 = Class.forName("com.baidu.adp.plugin.proxy.activity.RemoteSingleTaskActivityProxy" + this.f2227f);
                    this.f2223b.put(cls, cls3);
                    return cls3;
                } catch (Exception e3) {
                    BdLog.e(e3);
                    return cls3;
                }
            } else if (PluginBaseRemoteActivity.class.isAssignableFrom(cls)) {
                return RemoteActivityProxy.class;
            } else {
                if (PluginBaseThirdSingleTaskActivity.class.isAssignableFrom(cls)) {
                    Class<?> cls4 = this.f2224c.get(cls);
                    if (cls4 != null) {
                        return cls4;
                    }
                    int i4 = this.f2225d;
                    if (i4 == 10) {
                        BdLog.e("can not find singletaskactivity,Has started 10 remote singletaskactivity");
                        return null;
                    }
                    this.f2225d = i4 + 1;
                    try {
                        cls4 = Class.forName("com.baidu.adp.plugin.proxy.activity.ThirdSingleTaskActivityProxy" + this.f2225d);
                        this.f2224c.put(cls, cls4);
                        return cls4;
                    } catch (Exception e4) {
                        BdLog.e(e4);
                        return cls4;
                    }
                } else if (PluginBaseThirdActivity.class.isAssignableFrom(cls)) {
                    return ThirdActivityProxy.class;
                } else {
                    if (PluginBaseThirdFragmentActivity.class.isAssignableFrom(cls)) {
                        return ThirdFragmentActivityProxy.class;
                    }
                    if (PluginBaseFragmentActivity.class.isAssignableFrom(cls)) {
                        return FragmentActivityProxy.class;
                    }
                    if (PluginBaseActivity.class.isAssignableFrom(cls)) {
                        return ActivityProxy.class;
                    }
                    return null;
                }
            }
        }
        return (Class) invokeL.objValue;
    }
}
