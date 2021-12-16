package c.a.d.i.j.f;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.ReqData;
import plugin.writeSettings.WriteSettingsReqIdl;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final BdUniqueId f2795e;

    /* renamed from: f  reason: collision with root package name */
    public static final BdAsyncTaskParallel f2796f;

    /* renamed from: g  reason: collision with root package name */
    public static b f2797g;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public PluginSettings f2798b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2799c;

    /* renamed from: d  reason: collision with root package name */
    public e f2800d;

    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PluginSettings a;

        /* renamed from: b  reason: collision with root package name */
        public d f2801b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f2802c;

        public a(b bVar, PluginSettings pluginSettings, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pluginSettings, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2802c = bVar;
            this.a = pluginSettings;
            this.f2801b = dVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel();
                d dVar = this.f2801b;
                if (dVar != null) {
                    dVar.a();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                PluginSettings pluginSettings = this.a;
                if (pluginSettings != null && pluginSettings.getPlugins() != null) {
                    ReqData.Builder builder = new ReqData.Builder();
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, PluginSetting> entry : this.a.getPlugins().entrySet()) {
                        PluginSetting value = entry.getValue();
                        if (value != null) {
                            Plugin_setting.Builder builder2 = new Plugin_setting.Builder();
                            builder2.apk_path = value.apkPath;
                            builder2.cmd_range = value.getCmdRange();
                            builder2.display_name = value.displayName;
                            if (value.enable) {
                                builder2.enable = 0;
                            } else {
                                builder2.enable = 1;
                            }
                            if (value.forbidden) {
                                builder2.forbidden = 1;
                            } else {
                                builder2.forbidden = 0;
                            }
                            builder2.install_status = Integer.valueOf(value.installStatus);
                            builder2.md5 = value.md5;
                            builder2.package_name = value.packageName;
                            builder2.requireLoad = value.requireLoad;
                            builder2.size = Integer.valueOf(value.size);
                            builder2.temp_md5 = value.tempMd5;
                            builder2.temp_version_code = Integer.valueOf(value.tempVersionCode);
                            builder2.url = value.url;
                            builder2.version = value.version;
                            builder2.version_code = Integer.valueOf(value.versionCode);
                            builder2.is_inject_classloader = Integer.valueOf(value.isInjectClassloader() ? 1 : 0);
                            builder2.abandon_apk_path = value.getAbandon_apk_path();
                            builder2.install_fail_count = Integer.valueOf(value.install_fail_count);
                            builder2.priority = Integer.valueOf(value.priority);
                            builder2.has_res = Integer.valueOf(value.hasRes ? 1 : 0);
                            builder2.is_third = Integer.valueOf(value.isThird ? 1 : 0);
                            builder2.is_Patch = Integer.valueOf(value.isPatch ? 1 : 0);
                            builder2.load_priority = Integer.valueOf(value.load_priority);
                            builder2.replaceMethodClasses = value.replaceMethodClasses;
                            builder2.ext = value.ext;
                            builder2.rollback = Integer.valueOf(value.rollback);
                            arrayList.add(builder2.build(false));
                        }
                    }
                    builder.plugin_settings_list = arrayList;
                    builder.container_version = this.a.getContainerVersion();
                    builder.forbidden_feature = this.a.getForbiddenFeatures();
                    WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
                    try {
                        builder3.data = builder.build(false);
                        return Boolean.valueOf(this.f2802c.f(this.f2802c.c(), builder3.build(false).toByteArray()));
                    } catch (Throwable th) {
                        c.a.d.i.h.a.b().g("plugin_settings_write_error");
                        c.a.d.i.h.a.b().m("plugin_setting", "settings_write_error", null, th.getMessage());
                        return Boolean.FALSE;
                    }
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                super.onPostExecute((a) bool);
                if (this.f2801b != null) {
                    if (bool != null && bool.booleanValue()) {
                        this.f2801b.b();
                    } else {
                        this.f2801b.a();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1093982594, "Lc/a/d/i/j/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1093982594, "Lc/a/d/i/j/f/b;");
                return;
            }
        }
        f2795e = BdUniqueId.gen();
        f2796f = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, f2795e);
    }

    public b() {
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
        this.f2798b = new PluginSettings();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f2797g == null) {
                synchronized (b.class) {
                    if (f2797g == null) {
                        f2797g = new b();
                    }
                }
            }
            return f2797g;
        }
        return (b) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Util.i() == null) {
                return null;
            }
            return Util.i().getAbsoluteFile() + File.separator + "plugin_settings";
        }
        return (String) invokeV.objValue;
    }

    public PluginSettings d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2798b : (PluginSettings) invokeV.objValue;
    }

    public void e(PluginSettings pluginSettings, d dVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pluginSettings, dVar) == null) || pluginSettings == null) {
            return;
        }
        this.f2798b = pluginSettings;
        if (this.f2799c && (eVar = this.f2800d) != null) {
            eVar.a(pluginSettings);
            this.f2800d = null;
            this.f2799c = false;
        }
        a aVar = this.a;
        if (aVar != null) {
            aVar.cancel();
            this.a = null;
        }
        if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
            pluginSettings.setContainerSetting("");
        }
        a aVar2 = new a(this, pluginSettings, dVar);
        this.a = aVar2;
        aVar2.setParallel(f2796f);
        this.a.execute(new String[0]);
    }

    public final boolean f(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, str, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (bArr == null) {
                    c.a.d.f.m.a.d(null);
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                if (bArr != null) {
                    try {
                        fileOutputStream2.write(bArr);
                    } catch (Exception e2) {
                        fileOutputStream = fileOutputStream2;
                        e = e2;
                        BdLog.e(e.getMessage());
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        fileOutputStream = fileOutputStream2;
                        th = th;
                        c.a.d.f.m.a.d(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                c.a.d.f.m.a.d(fileOutputStream2);
                return true;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
