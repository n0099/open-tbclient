package b.a.r0.u2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f25552a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25553b;

    /* renamed from: c  reason: collision with root package name */
    public int f25554c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25555d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.a.r0.t2.b> f25556e;

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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
                b.a.r0.a2.d.a(b.a.r0.a2.f.f15513b);
                b.a.r0.a2.d.a(b.a.r0.a2.f.f15514c);
                b.a.r0.a2.d.a(b.a.r0.a2.f.f15515d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<l, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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
        /* renamed from: b */
        public Void doInBackground(l... lVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, lVarArr)) == null) {
                if (lVarArr == null || lVarArr.length != 1 || lVarArr[0] == null) {
                    return null;
                }
                l lVar = lVarArr[0];
                synchronized ("debug") {
                    File file = new File(b.a.r0.a2.f.f15516e + b.a.r0.a2.f.f15512a + lVar.f25558b + b.a.r0.a2.f.f15512a + "debug");
                    StringBuilder sb = new StringBuilder();
                    sb.append(lVar.f25557a.a().toString());
                    sb.append(StringUtils.LF);
                    b.a.r0.a2.d.g(file, sb.toString(), true);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<e, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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
        /* renamed from: b */
        public Void doInBackground(e... eVarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVarArr)) == null) {
                if (eVarArr == null || eVarArr.length != 1 || eVarArr[0] == null) {
                    return null;
                }
                e eVar = eVarArr[0];
                synchronized ("kpi") {
                    b.a.r0.a2.d.g(new File(b.a.r0.a2.f.f15516e + b.a.r0.a2.f.f15512a + eVar.f25527d + b.a.r0.a2.f.f15512a + "kpi"), k.e(eVar.f25524a, eVar.f25525b, eVar.f25526c).toString(), false);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1668636376, "Lb/a/r0/u2/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1668636376, "Lb/a/r0/u2/k;");
                return;
            }
        }
        if (b.a.e.f.p.f.c()) {
            new a().execute(new Void[0]);
        }
    }

    public k(String str) {
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
        this.f25553b = true;
        this.f25554c = 0;
        this.f25555d = false;
        this.f25552a = str;
        this.f25556e = new ArrayList();
    }

    public static final JSONObject e(boolean z, int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            int i3 = 1;
            try {
                jSONObject.put("postSuccess", (z2 && z) ? 1 : 0);
                jSONObject.put("errorTimes", i2);
                if (!z2) {
                    i3 = 0;
                }
                jSONObject.put("posted", i3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public void a(b.a.r0.t2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f25556e.add(bVar);
            c();
            m(bVar);
            l();
        }
    }

    public JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                if (!ListUtils.isEmpty(this.f25556e)) {
                    int size = this.f25556e.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put(this.f25556e.get(i2).a());
                    }
                }
                jSONObject.put("running", jSONArray);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && b.a.e.f.p.f.c()) {
            File file = new File(b.a.r0.a2.f.f15516e + b.a.r0.a2.f.f15512a + this.f25552a + b.a.r0.a2.f.f15512a);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e(this.f25553b, this.f25554c, this.f25555d) : (JSONObject) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25554c++;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25554c > 0 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25555d : invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f25553b = false;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f25553b = true;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f25555d = true;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && b.a.e.f.p.f.c()) {
            new c(this).execute(new e(this.f25553b, this.f25554c, this.f25555d, this.f25552a));
        }
    }

    public final void m(b.a.r0.t2.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) && b.a.e.f.p.f.c() && bVar != null) {
            new b(this).execute(new l(bVar, this.f25552a));
        }
    }
}
