package c.a.p0.h0;

import c.a.e.e.p.j;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f18100a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.h0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0874b extends BdAsyncTask<String, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final BdUniqueId f18101d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Process f18102a;

        /* renamed from: b  reason: collision with root package name */
        public String f18103b;

        /* renamed from: c  reason: collision with root package name */
        public long f18104c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1580934375, "Lc/a/p0/h0/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1580934375, "Lc/a/p0/h0/b$b;");
                    return;
                }
            }
            f18101d = BdUniqueId.gen();
        }

        public /* synthetic */ C0874b(String str, a aVar) {
            this(str);
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int I = j.I();
                return I != 1 ? I != 2 ? "ping -c 3 -w 5000 " : "ping -c 3 -w 10000 " : "ping -c 3 -w 3000 ";
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                Process process = this.f18102a;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                c.a.p0.h0.i.d.m().n(this.f18103b, (int) this.f18104c, false);
            }
        }

        public C0874b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f18102a = null;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, f18101d));
            this.f18103b = str;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    try {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            Process exec = runtime.exec(b() + this.f18103b);
                            this.f18102a = exec;
                            r1 = exec.waitFor() == 0;
                            this.f18104c = System.currentTimeMillis() - currentTimeMillis;
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
                    this.f18102a.destroy();
                    return Boolean.valueOf(r1);
                } catch (Throwable th2) {
                    this.f18102a.destroy();
                    throw th2;
                }
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bool) == null) {
                boolean booleanValue = bool != null ? bool.booleanValue() : true;
                c.a.p0.h0.i.d.m().n(this.f18103b, (int) this.f18104c, booleanValue);
                c.a.e.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_testspeed");
                statsItem.c("issuc", Boolean.valueOf(booleanValue));
                statsItem.b("ip", this.f18103b);
                statsItem.c("speed", Integer.valueOf((int) this.f18104c));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1699967209, "Lc/a/p0/h0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1699967209, "Lc/a/p0/h0/b;");
        }
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
            }
        }
    }

    public static final b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f18100a == null) {
                synchronized (b.class) {
                    if (f18100a == null) {
                        f18100a = new b();
                    }
                }
            }
            return f18100a;
        }
        return (b) invokeV.objValue;
    }

    public void b(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, set) == null) {
            for (String str : set) {
                new C0874b(str, null).execute(new String[0]);
            }
        }
    }
}
