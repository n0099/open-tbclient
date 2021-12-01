package c.a.d.i.j.e;

import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile d f2829c;
    public transient /* synthetic */ FieldHolder $fh;
    public PluginNetConfigInfos a;

    /* renamed from: b  reason: collision with root package name */
    public b f2830b;

    /* loaded from: classes.dex */
    public class a implements c.a.d.i.j.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar, c.a.d.i.j.e.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public d() {
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
        this.a = new PluginNetConfigInfos();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f2829c == null) {
                synchronized (d.class) {
                    if (f2829c == null) {
                        f2829c = new d();
                    }
                }
            }
            return f2829c;
        }
        return (d) invokeV.objValue;
    }

    public PluginNetConfigInfos b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (PluginNetConfigInfos) invokeV.objValue;
    }

    public void c(PluginSettings pluginSettings, boolean z, c.a.d.i.j.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{pluginSettings, Boolean.valueOf(z), aVar}) == null) {
            c d2 = d(pluginSettings);
            b bVar = this.f2830b;
            if (bVar != null) {
                bVar.a(z, d2, new a(this, aVar));
            }
        }
    }

    public c d(PluginSettings pluginSettings) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pluginSettings)) == null) {
            c cVar = new c();
            ArrayList arrayList = new ArrayList();
            if (pluginSettings.getPlugins() != null) {
                for (Map.Entry<String, PluginSetting> entry : pluginSettings.getPlugins().entrySet()) {
                    PluginSetting value = entry.getValue();
                    if (value != null) {
                        arrayList.add(new BasicNameValuePair(value.packageName, String.valueOf(value.versionCode)));
                    }
                }
            }
            cVar.a(arrayList);
            return cVar;
        }
        return (c) invokeL.objValue;
    }
}
