package c.a.r0.a.u1.l.g;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.a1.d;
import c.a.r0.a.n2.c;
import c.a.r0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a implements c.a.r0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f9560e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, SwanAppConfigData> f9561c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9562d;

    /* renamed from: c.a.r0.a.u1.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0608a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f9563e;

        public RunnableC0608a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9563e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f9563e.b();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (c.a.r0.a.f1.f.a.a) {
                    String str = "async batch parse app.json cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms";
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                if (file == null) {
                    return 1;
                }
                if (file2 == null) {
                    return -1;
                }
                return (int) ((b(file) - b(file2)) * (-1));
            }
            return invokeLL.intValue;
        }

        public final long b(@NonNull File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.lastModified() : invokeL.longValue;
        }

        public /* synthetic */ b(a aVar, RunnableC0608a runnableC0608a) {
            this(aVar);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767519168, "Lc/a/r0/a/u1/l/g/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(767519168, "Lc/a/r0/a/u1/l/g/a$c;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-343335009, "Lc/a/r0/a/u1/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-343335009, "Lc/a/r0/a/u1/l/g/a;");
                return;
            }
        }
        f9560e = new HashSet();
    }

    public /* synthetic */ a(RunnableC0608a runnableC0608a) {
        this();
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a : (a) invokeV.objValue;
    }

    public final void b() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File g2 = d.g();
            if (!g2.exists() || (listFiles = g2.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            for (String str : f9560e) {
                c(new File(g2, str));
            }
        }
    }

    public final void c(File file) {
        File d2;
        SwanAppConfigData a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) || file == null || !file.exists() || !file.isDirectory() || (d2 = d(file)) == null || (a = c.a.r0.a.f1.c.a.a(d2)) == null) {
            return;
        }
        this.f9561c.put(d2.getAbsolutePath(), a);
    }

    public final File d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            if (file != null && !file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    if (listFiles.length > 1) {
                        Arrays.sort(listFiles, new b(this, null));
                    }
                    return listFiles[0];
                }
                c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_START_PLAY);
                bVar.h(file.getAbsolutePath());
                bVar.k("async parse swanApp");
                bVar.m();
                if (c.a.r0.a.f1.f.a.a) {
                    String str = file.getAbsolutePath() + " is an empty folder";
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.f9561c;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                this.f9561c.clear();
            }
            this.f9562d = false;
            boolean z = c.a.r0.a.f1.f.a.a;
        }
    }

    public void g(String str) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f9561c) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, SwanAppConfigData>> it = this.f9561c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SwanAppConfigData> next = it.next();
            if (next != null) {
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    this.f9561c.remove(key);
                    break;
                }
            }
        }
        if (c.a.r0.a.f1.f.a.a) {
            String str2 = "release app.json appId = " + str;
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f9560e.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
            f9560e.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
            f9560e.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
            f9560e.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
            f9560e.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
        }
    }

    @AnyThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f9562d) {
                if (c.a.r0.a.f1.f.a.a) {
                    String str = "has batch parse app.json, size = " + this.f9561c.size();
                    return;
                }
                return;
            }
            this.f9562d = true;
            try {
                q.k(new RunnableC0608a(this), "startAsyncBatchParseAppJson");
            } catch (Throwable th) {
                if (c.a.r0.a.f1.f.a.a) {
                    th.printStackTrace();
                }
            }
        }
    }

    public SwanAppConfigData j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String absolutePath = file.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = this.f9561c.get(absolutePath);
            if (c.a.r0.a.f1.f.a.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("try obtain config data success = ");
                sb.append(swanAppConfigData != null);
                sb.toString();
            }
            return swanAppConfigData;
        }
        return (SwanAppConfigData) invokeL.objValue;
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
        this.f9561c = new ConcurrentHashMap<>();
        this.f9562d = false;
        h();
    }
}
