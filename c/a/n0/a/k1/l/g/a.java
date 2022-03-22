package c.a.n0.a.k1.l.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.c;
import c.a.n0.a.p2.q;
import c.a.n0.a.q0.d;
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
public class a implements c.a.n0.a.v0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final Set<String> f5369e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, SwanAppConfigData> f5370c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f5371d;

    /* renamed from: c.a.n0.a.k1.l.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0364a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public RunnableC0364a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.a.b();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (c.a.n0.a.v0.f.a.a) {
                    Log.d("SwanPerformance", "async batch parse app.json cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public /* synthetic */ b(a aVar, RunnableC0364a runnableC0364a) {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-695667014, "Lc/a/n0/a/k1/l/g/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-695667014, "Lc/a/n0/a/k1/l/g/a$c;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1721392359, "Lc/a/n0/a/k1/l/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1721392359, "Lc/a/n0/a/k1/l/g/a;");
                return;
            }
        }
        f5369e = new HashSet();
    }

    public /* synthetic */ a(RunnableC0364a runnableC0364a) {
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
            for (String str : f5369e) {
                c(new File(g2, str));
            }
        }
    }

    public final void c(File file) {
        File d2;
        SwanAppConfigData a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) || file == null || !file.exists() || !file.isDirectory() || (d2 = d(file)) == null || (a = c.a.n0.a.v0.c.a.a(d2)) == null) {
            return;
        }
        this.f5370c.put(d2.getAbsolutePath(), a);
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
                if (c.a.n0.a.v0.f.a.a) {
                    Log.d("SwanPerformance", file.getAbsolutePath() + " is an empty folder");
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.f5370c;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                this.f5370c.clear();
            }
            this.f5371d = false;
            if (c.a.n0.a.v0.f.a.a) {
                Log.d("SwanPerformance", "release app.json batch cache");
            }
        }
    }

    public void g(String str) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f5370c) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, SwanAppConfigData>> it = this.f5370c.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SwanAppConfigData> next = it.next();
            if (next != null) {
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    this.f5370c.remove(key);
                    break;
                }
            }
        }
        if (c.a.n0.a.v0.f.a.a) {
            Log.d("SwanPerformance", "release app.json appId = " + str);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f5369e.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
            f5369e.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
            f5369e.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
            f5369e.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
            f5369e.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
        }
    }

    @AnyThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f5371d) {
                if (c.a.n0.a.v0.f.a.a) {
                    Log.d("SwanPerformance", "has batch parse app.json, size = " + this.f5370c.size());
                    return;
                }
                return;
            }
            this.f5371d = true;
            try {
                q.k(new RunnableC0364a(this), "startAsyncBatchParseAppJson");
            } catch (Throwable th) {
                if (c.a.n0.a.v0.f.a.a) {
                    Log.e("SwanPerformance", "batch parse app.json exception");
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
            SwanAppConfigData swanAppConfigData = this.f5370c.get(absolutePath);
            if (c.a.n0.a.v0.f.a.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("try obtain config data success = ");
                sb.append(swanAppConfigData != null);
                Log.d("SwanPerformance", sb.toString());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5370c = new ConcurrentHashMap<>();
        this.f5371d = false;
        h();
    }
}
