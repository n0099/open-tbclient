package c.a.e.h.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.f;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f2838c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f2839a;

    /* renamed from: b  reason: collision with root package name */
    public a f2840b;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f2841a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f2842b;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2842b = cVar;
            this.f2841a = str;
        }

        public final void b(String str) {
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                File m = Util.m();
                String k = Util.k(str);
                if (m == null || !m.exists() || (listFiles = m.listFiles()) == null) {
                    return;
                }
                int length = listFiles.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (listFiles[i2] != null && listFiles[i2].isFile() && listFiles[i2].getName().startsWith(k)) {
                        try {
                            f.p(listFiles[i2]);
                            c.a.e.h.h.a.b().o("plugin_del_temp", "deltmp_suc", str, listFiles[i2].getName());
                        } catch (Throwable th) {
                            c.a.e.h.h.a b2 = c.a.e.h.h.a.b();
                            b2.r("plugin_del_temp", "deltmp_fail", str, listFiles[i2].getName() + "-" + th.getMessage());
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                String str = this.f2841a;
                if (str != null) {
                    b(str);
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                this.f2842b.f2840b = null;
                if (this.f2842b.f2839a.size() > 0) {
                    Iterator it = this.f2842b.f2839a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str = (String) it.next();
                        if (str != null && str.equals(this.f2841a)) {
                            this.f2842b.f2839a.remove(str);
                            break;
                        }
                    }
                }
                this.f2842b.f();
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2839a = new ArrayList<>();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f2838c == null) {
                synchronized (c.class) {
                    if (f2838c == null) {
                        f2838c = new c();
                    }
                }
            }
            return f2838c;
        }
        return (c) invokeV.objValue;
    }

    public void d(PluginSetting pluginSetting) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pluginSetting) == null) || pluginSetting == null || TextUtils.isEmpty(pluginSetting.packageName)) {
            return;
        }
        boolean z = false;
        Iterator<String> it = this.f2839a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (next != null && next.equals(pluginSetting.packageName)) {
                z = true;
                break;
            }
        }
        if (!z) {
            this.f2839a.add(pluginSetting.packageName);
        }
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f2839a.size() > 0 && this.f2840b == null) {
            a aVar = new a(this, this.f2839a.get(0));
            this.f2840b = aVar;
            aVar.execute(new String[0]);
        }
    }
}
