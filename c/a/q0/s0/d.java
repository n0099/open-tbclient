package c.a.q0.s0;

import android.text.TextUtils;
import c.a.e.e.d.l;
import c.a.e.e.p.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class d implements c.a.e.h.j.f.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final String f14601c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.e.h.j.f.a f14602a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14603b;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public File f14604a;

        public a(d dVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14604a = null;
            this.f14604a = file;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, voidArr)) == null) {
                File file = this.f14604a;
                if (file == null || !file.exists()) {
                    return null;
                }
                Util.a(this.f14604a);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Void, PluginNetConfigInfos, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14605a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.e.h.j.f.c f14606b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f14608d;

        public b(d dVar, c.a.e.h.j.f.c cVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14608d = dVar;
            this.f14607c = false;
            this.f14606b = cVar;
            this.f14607c = z;
        }

        public final String b(l<String> lVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lVar, str)) == null) ? lVar.get(str) : (String) invokeLL.objValue;
        }

        public final String c(l<String> lVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar, str)) == null) {
                boolean checkNewUser = TbadkCoreApplication.getInst().checkNewUser();
                if (TbadkCoreApplication.getInst().checkInterrupt() && checkNewUser) {
                    return null;
                }
                NetWork netWork = new NetWork(d.f14601c);
                this.f14605a = netWork;
                netWork.addPostData("plugin_upload_config", str);
                return this.f14605a.postNetData();
            }
            return (String) invokeLL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                this.f14608d.f14603b = false;
                this.f14605a.cancelNetConnect();
                this.f14605a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(PluginNetConfigInfos... pluginNetConfigInfosArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, pluginNetConfigInfosArr) == null) {
                super.onProgressUpdate(pluginNetConfigInfosArr);
                this.f14608d.f14603b = false;
                boolean z = pluginNetConfigInfosArr[0] != null;
                String str = null;
                NetWork netWork = this.f14605a;
                if (netWork != null && !netWork.isNetSuccess()) {
                    str = this.f14605a.getNetException();
                    if (this.f14605a.getServerErrorCode() != 0) {
                        str = str + "-" + this.f14605a.getErrorString();
                    }
                }
                this.f14608d.f14602a.a(z, this.f14606b, pluginNetConfigInfosArr[0], str);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001224));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            String str;
            boolean z;
            String str2;
            PluginNetConfigInfos pluginNetConfigInfos;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voidArr)) == null) {
                c.a.e.h.j.f.c cVar = this.f14606b;
                if (cVar == null) {
                    publishProgress(null);
                    return null;
                }
                if (cVar.a() == null || this.f14606b.a().size() <= 0) {
                    str = "";
                } else {
                    StringBuilder sb = new StringBuilder(50);
                    int size = this.f14606b.a().size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (i2 != 0) {
                            sb.append(",");
                        }
                        BasicNameValuePair basicNameValuePair = this.f14606b.a().get(i2);
                        if (basicNameValuePair != null && !TextUtils.isEmpty(basicNameValuePair.getName()) && !TextUtils.isEmpty(basicNameValuePair.getValue())) {
                            sb.append(basicNameValuePair.getName());
                            sb.append(":");
                            sb.append(basicNameValuePair.getValue());
                        }
                    }
                    str = sb.toString();
                }
                BdCacheService j2 = BdCacheService.j("baidu_plugin.db");
                l<String> c2 = j2.c("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                String str3 = c2.get("time");
                if (!this.f14607c && str3 != null) {
                    long g2 = c.a.e.e.m.b.g(str3, -1L);
                    if (g2 != -1 && System.currentTimeMillis() - g2 < 86400000) {
                        z = false;
                        PluginSettings l = c.a.e.h.j.g.d.k().l();
                        String str4 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + (l == null ? l.getContainerVersion() : null) + "_" + str;
                        if (!z) {
                            str2 = c(c2, str);
                            pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                        } else {
                            String b2 = b(c2, str4);
                            PluginNetConfigInfos parse = PluginNetConfigInfos.parse(b2);
                            if (parse == null) {
                                str2 = c(c2, str);
                                pluginNetConfigInfos = PluginNetConfigInfos.parse(str2);
                                z = true;
                            } else {
                                str2 = b2;
                                pluginNetConfigInfos = parse;
                            }
                        }
                        publishProgress(pluginNetConfigInfos);
                        if (z) {
                            j2.k(c2);
                            l<String> c3 = j2.c("plugin.serverconfig", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 2);
                            c3.e("time", String.valueOf(System.currentTimeMillis()), 172800000L);
                            c3.e(str4, str2, 172800000L);
                        }
                        return null;
                    }
                }
                z = true;
                PluginSettings l2 = c.a.e.h.j.g.d.k().l();
                if (l2 == null) {
                }
                String str42 = TbConfig.getVersion() + "." + TbConfig.BUILD_NUMBER + "_" + (l2 == null ? l2.getContainerVersion() : null) + "_" + str;
                if (!z) {
                }
                publishProgress(pluginNetConfigInfos);
                if (z) {
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(53001919, "Lc/a/q0/s0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(53001919, "Lc/a/q0/s0/d;");
                return;
            }
        }
        f14601c = TbConfig.SERVER_ADDRESS + TbConfig.PLUGIN_NET_CONFIGS_MIS;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.e.h.j.f.b
    public void a(boolean z, c.a.e.h.j.f.c cVar, c.a.e.h.j.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), cVar, aVar}) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                if (aVar != null) {
                    aVar.a(false, cVar, null, null);
                    return;
                }
                return;
            }
            this.f14602a = aVar;
            if (!this.f14603b) {
                this.f14603b = true;
                new b(this, cVar, z).execute(new Void[0]);
            }
            try {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                File filesDir = inst.getFilesDir();
                if (filesDir == null) {
                    filesDir = new File("/data/data/" + inst.getPackageName() + "/files/");
                    try {
                        if (!filesDir.exists()) {
                            f.q(filesDir);
                        }
                    } catch (IOException unused) {
                    }
                }
                File file = new File(filesDir, "pluginsEX");
                if (file.exists()) {
                    new a(this, file).execute(new Void[0]);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
