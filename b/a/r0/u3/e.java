package b.a.r0.u3;

import b.a.e.e.p.f;
import b.a.q0.t.e.g;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24112a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f24113b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f24114c;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.r0.a2.d.a(b.a.r0.a2.c.f14674b);
                b.a.r0.a2.d.a(b.a.r0.a2.c.f14675c);
                b.a.r0.a2.d.a(b.a.r0.a2.c.f14676d);
                b.a.r0.a2.d.a(b.a.r0.a2.c.f14678f);
                b.a.r0.a2.d.a(b.a.r0.a2.c.f14679g);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24115a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24115a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                List j = e.j(b.a.r0.a2.c.f14677e);
                if (j == null) {
                    return null;
                }
                int size = j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f24115a.n((b.a.r0.u3.d) j.get(i2));
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24116a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24116a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length == 2 && !StringUtils.isNull(strArr[0]) && !StringUtils.isNull(strArr[1])) {
                    this.f24116a.f(strArr[0], strArr[1]);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<b.a.r0.u3.d, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f24117a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24117a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(b.a.r0.u3.d... dVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVarArr)) == null) {
                if (dVarArr != null && dVarArr.length == 1 && dVarArr[0] != null) {
                    this.f24117a.g(dVarArr[0]);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* renamed from: b.a.r0.u3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1173e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f24118a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1565187420, "Lb/a/r0/u3/e$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1565187420, "Lb/a/r0/u3/e$e;");
                    return;
                }
            }
            f24118a = new e(null);
        }
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? C1173e.f24118a : (e) invokeV.objValue;
    }

    public static List<b.a.r0.u3.d> j(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                int length = listFiles.length;
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(new b.a.r0.u3.d(m(b.a.r0.a2.d.e(listFiles[i2])), listFiles[i2].getAbsolutePath()));
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static List<String> m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String[] split = str.split(org.apache.commons.lang3.StringUtils.LF);
            int length = split.length;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                if (!StringUtils.isNull(split[i2])) {
                    arrayList.add(split[i2]);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }

    public final synchronized boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            synchronized (this) {
                if (this.f24114c.contains(str)) {
                    return false;
                }
                File file = new File(str);
                return b.a.r0.a2.d.f(file, str2 + org.apache.commons.lang3.StringUtils.LF);
            }
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void g(b.a.r0.u3.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            synchronized (this) {
                try {
                    byte[] a2 = b.a.r0.u3.c.a(dVar.f24110a);
                    if (b.a.r0.u3.c.c(a2, TbConfig.SERVER_ADDRESS + TbConfig.URL_VIDEO_MONITOR_REPORT) && !StringUtils.isNull(dVar.f24111b)) {
                        FileHelper.deleteFile(new File(dVar.f24111b));
                        this.f24114c.add(dVar.f24111b);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (StringUtils.isNull(this.f24112a)) {
                if (!f.c()) {
                    return null;
                }
                this.f24112a = String.valueOf(System.currentTimeMillis());
            }
            return b.a.r0.a2.c.f14677e + this.f24112a;
        }
        return (String) invokeV.objValue;
    }

    public synchronized void k(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, jSONObject, z) == null) {
            synchronized (this) {
                if (jSONObject == null) {
                    return;
                }
                this.f24113b.add(jSONObject.toString());
                String i2 = i();
                if (f.c()) {
                    l(jSONObject, i2);
                }
                if (this.f24113b.size() >= g.a() || z) {
                    n(new b.a.r0.u3.d(this.f24113b, i2));
                    this.f24113b.clear();
                    this.f24112a = null;
                }
            }
        }
    }

    public final void l(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, jSONObject, str) == null) && !StringUtils.isNull(str) && f.c()) {
            new c(this).execute(str, jSONObject.toString());
        }
    }

    public final void n(b.a.r0.u3.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        new d(this).execute(dVar);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && f.c()) {
            new b(this).execute(new Void[0]);
        }
    }

    public e() {
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
        this.f24113b = new ArrayList();
        this.f24114c = new ArrayList();
        if (f.c()) {
            e();
        }
    }
}
