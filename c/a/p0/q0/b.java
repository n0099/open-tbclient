package c.a.p0.q0;

import c.a.d.f.p.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Set;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.q0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1282b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f17082d;
        public transient /* synthetic */ FieldHolder $fh;
        public Process a;

        /* renamed from: b  reason: collision with root package name */
        public String f17083b;

        /* renamed from: c  reason: collision with root package name */
        public long f17084c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2111631458, "Lc/a/p0/q0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2111631458, "Lc/a/p0/q0/b$b;");
                    return;
                }
            }
            f17082d = BdUniqueId.gen();
        }

        public /* synthetic */ C1282b(String str, a aVar) {
            this(str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Process exec = runtime.exec(c() + this.f17083b);
                            this.a = exec;
                            r1 = exec.waitFor() == 0;
                            this.f17084c = System.currentTimeMillis() - currentTimeMillis;
                        } catch (InterruptedException e2) {
                            BdLog.detailException(e2);
                            d.c().a("test_speed", e2.getMessage());
                        }
                    } catch (IOException e3) {
                        BdLog.detailException(e3);
                        d.c().a("test_speed", e3.getMessage());
                    } catch (Throwable th) {
                        BdLog.detailException(th);
                        d.c().a("test_speed", th.getMessage());
                    }
                    this.a.destroy();
                    return Boolean.valueOf(r1);
                } catch (Throwable th2) {
                    this.a.destroy();
                    throw th2;
                }
            }
            return (Boolean) invokeL.objValue;
        }

        public final String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int I = l.I();
                return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                Process process = this.a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                c.a.p0.q0.i.d.m().n(this.f17083b, (int) this.f17084c, false);
            }
        }

        public C1282b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f17082d));
            this.f17083b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bool) == null) {
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                c.a.p0.q0.i.d.m().n(this.f17083b, (int) this.f17084c, booleanValue);
                c.a.d.f.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_testspeed");
                statsItem.c("issuc", Boolean.valueOf(booleanValue));
                statsItem.b("ip", this.f17083b);
                statsItem.c("speed", Integer.valueOf((int) this.f17084c));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1691655520, "Lc/a/p0/q0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1691655520, "Lc/a/p0/q0/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = new b();
                    }
                }
            }
            return a;
        }
        return (b) invokeV.objValue;
    }

    public void b(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, set) == null) {
            for (String str : set) {
                new C1282b(str, null).execute(new String[0]);
            }
        }
    }
}
