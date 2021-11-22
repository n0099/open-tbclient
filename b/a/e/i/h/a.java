package b.a.e.i.h;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import b.a.e.i.j.g.d;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
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
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f2268b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Integer> f2269a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1196887512, "Lb/a/e/i/h/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1196887512, "Lb/a/e/i/h/a;");
        }
    }

    public a() {
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
        this.f2269a = new HashMap<>();
    }

    public static synchronized a b() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f2268b == null) {
                    synchronized (a.class) {
                        if (f2268b == null) {
                            f2268b = new a();
                        }
                    }
                }
                aVar = f2268b;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public final void a(b.a.e.f.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : this.f2269a.entrySet()) {
            aVar.b(entry.getKey() + "_count", String.valueOf(entry.getValue()));
        }
        this.f2269a.clear();
    }

    public final b.a.e.f.n.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BdStatisticsManager.getInstance().getStatsItem("dbg") : (b.a.e.f.n.a) invokeV.objValue;
    }

    public void d(String str, String str2, PluginSetting pluginSetting, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, pluginSetting, str3) == null) {
            if (pluginSetting == null) {
                pluginSetting = d.k().h(str2);
            }
            int i2 = pluginSetting != null ? pluginSetting.install_fail_count : 0;
            j(str, null, str2, "failContent_" + i2 + "-callFrom_" + str3);
        }
    }

    public void e(String str, String str2, PluginSetting pluginSetting, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, pluginSetting, str3) == null) {
            if (pluginSetting == null) {
                pluginSetting = d.k().h(str2);
            }
            int i2 = pluginSetting != null ? pluginSetting.install_fail_count : 0;
            j(str, str3, str2, "failContent_" + i2);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0).getBoolean("is_plugin_lastload_fail", false) : invokeV.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            j(str, null, null, null);
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            j(str, null, null, "count_" + i2);
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            j(str, null, str2, null);
        }
    }

    public final void j(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            b.a.e.f.n.a c2 = c();
            if (str != null) {
                c2.b("workflow", str);
            }
            if (str2 != null) {
                c2.b("reason", str2);
            }
            if (str3 != null) {
                c2.b("pname", str3);
            }
            if (str4 != null) {
                c2.b("comment", str4);
            }
            c2.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings l = d.k().l();
            if (l != null) {
                c2.b("pver", l.getContainerVersion());
            }
            c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c2.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c2);
        }
    }

    public void k(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, str, j) == null) {
            l(str, j, 0);
        }
    }

    public void l(String str, long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            m(str, j, i2, null);
        }
    }

    public void m(String str, long j, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i2), str2}) == null) {
            b.a.e.f.n.a c2 = c();
            c2.b("workflow", str + "_cost");
            c2.c("cost", Long.valueOf(j));
            if (i2 != 0) {
                c2.c("count", Integer.valueOf(i2));
            }
            if (str2 != null) {
                c2.b("pname", str2);
            }
            c2.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings l = d.k().l();
            if (l != null) {
                c2.b("pver", l.getContainerVersion());
            }
            c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdStatisticsManager.getInstance().debug("pluginproxy", c2);
        }
    }

    public void n(String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
            m(str, j, 0, str2);
        }
    }

    public void o(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048589, this, str, str2, str3, str4) == null) {
            b.a.e.f.n.a c2 = c();
            if (str != null) {
                c2.b("workflow", str + "_debug");
            }
            if (str2 != null) {
                c2.b("reason", str2);
            }
            if (str3 != null) {
                c2.b("pname", str3);
            }
            if (str4 != null) {
                c2.b("comment", str4);
            }
            c2.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings l = d.k().l();
            if (l != null) {
                c2.b("pver", l.getContainerVersion());
            }
            c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c2.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c2);
        }
    }

    public void p(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, str3, str4) == null) {
            j(str, str3, str2, str4);
        }
    }

    public void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, str2, str3) == null) {
            r(str, str2, str3, null);
        }
    }

    public void r(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, str2, str3, str4) == null) {
            b.a.e.f.n.a c2 = c();
            if (str != null) {
                c2.b("workflow", str + "_failure");
            }
            if (str2 != null) {
                c2.b("reason", str2);
            }
            if (str3 != null) {
                c2.b("pname", str3);
            }
            a(c2);
            if (str4 != null) {
                c2.b("comment", str4);
            }
            c2.c("pid", Integer.valueOf(Process.myPid()));
            PluginSettings l = d.k().l();
            if (l != null) {
                c2.b("pver", l.getContainerVersion());
            }
            c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
            BdLog.e(c2.toString());
            BdStatisticsManager.getInstance().debug("pluginproxy", c2);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || str == null) {
            return;
        }
        Integer num = this.f2269a.get(str);
        if (num == null) {
            num = 0;
        }
        this.f2269a.put(str, Integer.valueOf(num.intValue() + 1));
    }

    public void t(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) || str == null || str2 == null) {
            return;
        }
        s(str);
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            EditorHelper.putBoolean(BdBaseApplication.getInst().getSharedPreferences(PluginDownloadActivityConfig.PLUGIN_CONFIG, 0), "is_plugin_lastload_fail", z);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f2269a.size() == 0) {
            return;
        }
        b.a.e.f.n.a c2 = c();
        a(c2);
        c2.b("appver", BdStatisticsManager.getInstance().getAppVersion());
        BdStatisticsManager.getInstance().debug("pluginproxy", c2);
    }
}
