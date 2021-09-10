package c.a.p0.a.u.e.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import c.a.p0.a.c2.f.p0.g;
import c.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
public class a extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0385a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8756a;

        public C0385a(a aVar) {
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
            this.f8756a = aVar;
        }

        @Override // c.a.p0.a.u.c.d.b
        public c.a.p0.a.u.h.b a(c.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                if (!TextUtils.isEmpty(optString)) {
                    this.f8756a.x(eVar, optString, str);
                    return new c.a.p0.a.u.h.b(0);
                }
                c.a.p0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
                return new c.a.p0.a.u.h.b(202);
            }
            return (c.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8757a;

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
                    return;
                }
            }
            this.f8757a = aVar;
        }

        @Override // c.a.p0.a.u.c.d.b
        public c.a.p0.a.u.h.b a(c.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.f8757a.v(eVar, str, optJSONArray);
                    return new c.a.p0.a.u.h.b(0);
                }
                return new c.a.p0.a.u.h.b(202);
            }
            return (c.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8759f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8760g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8761h;

        /* renamed from: c.a.p0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0386a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f8762a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f8763b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f8764c;

            public C0386a(c cVar, CountDownLatch countDownLatch, List list, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, countDownLatch, list, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8762a = countDownLatch;
                this.f8763b = list;
                this.f8764c = str;
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f8762a.countDown();
                    this.f8763b.add(this.f8764c);
                }
            }

            @Override // c.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f8762a.countDown();
                    c.a.p0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
                }
            }
        }

        public c(a aVar, c.a.p0.a.a2.e eVar, String str, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8761h = aVar;
            this.f8758e = eVar;
            this.f8759f = str;
            this.f8760g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String Z = this.f8758e.Z();
                if (!TextUtils.isDigitsOnly(Z)) {
                    a aVar = this.f8761h;
                    String str = this.f8759f;
                    aVar.d(str, new c.a.p0.a.u.h.b(202, "current version error:" + Z));
                    return;
                }
                List<c.a.p0.n.h.g> j2 = c.a.p0.n.g.a.h().j(this.f8758e.f4558f, Integer.parseInt(Z));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.f8760g.length(); i2++) {
                    String optString = this.f8760g.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.y(optString, j2) && this.f8758e.k0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String G = this.f8758e.G(str2);
                        if (TextUtils.isEmpty(G)) {
                            countDownLatch.countDown();
                        } else {
                            c.a.p0.a.a2.e eVar = this.f8758e;
                            g.k(eVar.f4558f, eVar.Z(), "1", str2, G, null, new C0386a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        c.a.p0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.f8760g.length(); i3++) {
                    try {
                        jSONObject.put(this.f8760g.optString(i3), synchronizedList.contains(this.f8760g.optString(i3)) ? 0 : 1001);
                    } catch (Exception e3) {
                        if (c.a.p0.a.u.c.d.f8727c) {
                            e3.printStackTrace();
                        }
                    }
                }
                this.f8761h.d(this.f8759f, new c.a.p0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.a2.e f8765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8766f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8767g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8768h;

        public d(a aVar, c.a.p0.a.a2.e eVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8768h = aVar;
            this.f8765e = eVar;
            this.f8766f = str;
            this.f8767g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8765e.l0(this.f8766f) && this.f8765e.k0(this.f8766f)) {
                    c.a.p0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                    this.f8768h.d(this.f8767g, new c.a.p0.a.u.h.b(1001, "subPackage have existed"));
                    return;
                }
                String G = this.f8765e.G(this.f8766f);
                if (!TextUtils.isEmpty(G)) {
                    this.f8768h.w(this.f8765e, this.f8766f, G, this.f8767g);
                    return;
                }
                c.a.p0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
                this.f8768h.d(this.f8767g, new c.a.p0.a.u.h.b(202));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8769a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8770b;

        public e(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8770b = aVar;
            this.f8769a = str;
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
                this.f8770b.d(this.f8769a, new c.a.p0.a.u.h.b(0, "preload subPackage success"));
            }
        }

        @Override // c.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                c.a.p0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
                this.f8770b.d(this.f8769a, new c.a.p0.a.u.h.b(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean y(@Nullable String str, @Nullable List<c.a.p0.n.h.g> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (c.a.p0.n.h.g gVar : list) {
                    if (gVar != null && TextUtils.equals(gVar.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public c.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? j(str, true, new b(this)) : (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void v(c.a.p0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "Api-LoadSubPackage", 2);
        }
    }

    public final void w(c.a.p0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2, str3) == null) {
            g.k(eVar.f4558f, eVar.Z(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void x(c.a.p0.a.a2.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public c.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8727c;
            return j(str, true, new C0385a(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
