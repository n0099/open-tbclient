package c.a.n0.a.k.e.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import c.a.n0.a.k.c.d;
import c.a.n0.a.v1.f.o0.g;
import c.a.n0.q.h.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.k.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.k.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0327a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0327a(a aVar) {
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

        @Override // c.a.n0.a.k.c.d.a
        public c.a.n0.a.k.h.b a(c.a.n0.a.t1.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.D(eVar, optString, str);
                    return new c.a.n0.a.k.h.b(0);
                }
                c.a.n0.a.u.d.c("PreLoadSubPackageApi", "subPackage root is null");
                return new c.a.n0.a.k.h.b(202);
            }
            return (c.a.n0.a.k.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.k.c.d.a
        public c.a.n0.a.k.h.b a(c.a.n0.a.t1.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.a.B(eVar, str, optJSONArray);
                    return new c.a.n0.a.k.h.b(0);
                }
                return new c.a.n0.a.k.h.b(202);
            }
            return (c.a.n0.a.k.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4982b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JSONArray f4983c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4984d;

        /* renamed from: c.a.n0.a.k.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0328a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountDownLatch a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f4985b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f4986c;

            public C0328a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = countDownLatch;
                this.f4985b = list;
                this.f4986c = str;
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.a.countDown();
                    this.f4985b.add(this.f4986c);
                }
            }

            @Override // c.a.n0.a.v1.f.o0.g.e
            public void c(int i, c.a.n0.a.k2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                    this.a.countDown();
                    c.a.n0.a.u.d.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i);
                }
            }
        }

        public c(a aVar, c.a.n0.a.t1.e eVar, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4984d = aVar;
            this.a = eVar;
            this.f4982b = str;
            this.f4983c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String j0 = this.a.j0();
                if (!TextUtils.isDigitsOnly(j0)) {
                    a aVar = this.f4984d;
                    String str = this.f4982b;
                    aVar.d(str, new c.a.n0.a.k.h.b(202, "current version error:" + j0));
                    return;
                }
                List<h> k = c.a.n0.q.f.a.i().k(this.a.f6344b, Integer.parseInt(j0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i = 0; i < this.f4983c.length(); i++) {
                    String optString = this.f4983c.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.E(optString, k) && this.a.t0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String Q = this.a.Q(str2);
                        if (TextUtils.isEmpty(Q)) {
                            countDownLatch.countDown();
                        } else {
                            c.a.n0.a.t1.e eVar = this.a;
                            g.l(eVar.f6344b, eVar.j0(), "1", str2, Q, null, new C0328a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        c.a.n0.a.u.d.d("PreLoadSubPackageApi", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < this.f4983c.length(); i2++) {
                    try {
                        jSONObject.put(this.f4983c.optString(i2), synchronizedList.contains(this.f4983c.optString(i2)) ? 0 : 1001);
                    } catch (Exception unused) {
                    }
                }
                this.f4984d.d(this.f4982b, new c.a.n0.a.k.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4988c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f4989d;

        public d(a aVar, c.a.n0.a.t1.e eVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4989d = aVar;
            this.a = eVar;
            this.f4987b = str;
            this.f4988c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.u0(this.f4987b) && this.a.t0(this.f4987b)) {
                    c.a.n0.a.u.d.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.f4989d.d(this.f4988c, new c.a.n0.a.k.h.b(1001, "subPackage have existed"));
                    return;
                }
                String Q = this.a.Q(this.f4987b);
                if (!TextUtils.isEmpty(Q)) {
                    this.f4989d.C(this.a, this.f4987b, Q, this.f4988c);
                    return;
                }
                c.a.n0.a.u.d.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                this.f4989d.d(this.f4988c, new c.a.n0.a.k.h.b(202));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4990b;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4990b = aVar;
            this.a = str;
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.u.d.i("PreLoadSubPackageApi", "preload subPackage success");
                this.f4990b.d(this.a, new c.a.n0.a.k.h.b(0, "preload subPackage success"));
            }
        }

        @Override // c.a.n0.a.v1.f.o0.g.e
        public void c(int i, c.a.n0.a.k2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, aVar) == null) {
                c.a.n0.a.u.d.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.f4990b.d(this.a, new c.a.n0.a.k.h.b(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean E(@Nullable String str, @Nullable List<h> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (h hVar : list) {
                    if (hVar != null && TextUtils.equals(hVar.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void B(c.a.n0.a.t1.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void C(c.a.n0.a.t1.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2, str3) == null) {
            g.l(eVar.f6344b, eVar.j0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void D(c.a.n0.a.t1.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public c.a.n0.a.k.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#loadSubPackage", false);
            return l(str, true, new C0327a(this));
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#loadSubPackages", false);
            return l(str, true, new b(this));
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }
}
