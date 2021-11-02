package b.a.p0.a.u.e.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import b.a.p0.a.c2.f.p0.g;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0380a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8027a;

        public C0380a(a aVar) {
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
            this.f8027a = aVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    this.f8027a.w(eVar, optString, str);
                    return new b.a.p0.a.u.h.b(0);
                }
                b.a.p0.a.e0.d.b("Api-LoadSubPackage", "subPackage root is null");
                return new b.a.p0.a.u.h.b(202);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8028a;

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
            this.f8028a = aVar;
        }

        @Override // b.a.p0.a.u.c.d.b
        public b.a.p0.a.u.h.b a(b.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.f8028a.u(eVar, str, optJSONArray);
                    return new b.a.p0.a.u.h.b(0);
                }
                return new b.a.p0.a.u.h.b(202);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8031g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8032h;

        /* renamed from: b.a.p0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0381a implements g.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f8033a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f8034b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f8035c;

            public C0381a(c cVar, CountDownLatch countDownLatch, List list, String str) {
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
                this.f8033a = countDownLatch;
                this.f8034b = list;
                this.f8035c = str;
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f8033a.countDown();
                    this.f8034b.add(this.f8035c);
                }
            }

            @Override // b.a.p0.a.c2.f.p0.g.d
            public void b(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f8033a.countDown();
                    b.a.p0.a.e0.d.l("Api-LoadSubPackage", "downloadSubPackage fail, code=" + i2);
                }
            }
        }

        public c(a aVar, b.a.p0.a.a2.e eVar, String str, JSONArray jSONArray) {
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
            this.f8032h = aVar;
            this.f8029e = eVar;
            this.f8030f = str;
            this.f8031g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String Y = this.f8029e.Y();
                if (!TextUtils.isDigitsOnly(Y)) {
                    a aVar = this.f8032h;
                    String str = this.f8030f;
                    aVar.d(str, new b.a.p0.a.u.h.b(202, "current version error:" + Y));
                    return;
                }
                List<b.a.p0.n.h.g> j = b.a.p0.n.g.a.h().j(this.f8029e.f3961f, Integer.parseInt(Y));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.f8031g.length(); i2++) {
                    String optString = this.f8031g.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.x(optString, j) && this.f8029e.j0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String F = this.f8029e.F(str2);
                        if (TextUtils.isEmpty(F)) {
                            countDownLatch.countDown();
                        } else {
                            b.a.p0.a.a2.e eVar = this.f8029e;
                            g.k(eVar.f3961f, eVar.Y(), "1", str2, F, null, new C0381a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        b.a.p0.a.e0.d.c("Api-LoadSubPackage", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.f8031g.length(); i3++) {
                    try {
                        jSONObject.put(this.f8031g.optString(i3), synchronizedList.contains(this.f8031g.optString(i3)) ? 0 : 1001);
                    } catch (Exception e3) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e3.printStackTrace();
                        }
                    }
                }
                this.f8032h.d(this.f8030f, new b.a.p0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8037f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8038g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8039h;

        public d(a aVar, b.a.p0.a.a2.e eVar, String str, String str2) {
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
            this.f8039h = aVar;
            this.f8036e = eVar;
            this.f8037f = str;
            this.f8038g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8036e.k0(this.f8037f) && this.f8036e.j0(this.f8037f)) {
                    b.a.p0.a.e0.d.g("Api-LoadSubPackage", "subPackage have existed");
                    this.f8039h.d(this.f8038g, new b.a.p0.a.u.h.b(1001, "subPackage have existed"));
                    return;
                }
                String F = this.f8036e.F(this.f8037f);
                if (!TextUtils.isEmpty(F)) {
                    this.f8039h.v(this.f8036e, this.f8037f, F, this.f8038g);
                    return;
                }
                b.a.p0.a.e0.d.g("Api-LoadSubPackage", "subPackage cannot find aps key");
                this.f8039h.d(this.f8038g, new b.a.p0.a.u.h.b(202));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements g.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8040a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8041b;

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
            this.f8041b = aVar;
            this.f8040a = str;
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.g("Api-LoadSubPackage", "preload subPackage success");
                this.f8041b.d(this.f8040a, new b.a.p0.a.u.h.b(0, "preload subPackage success"));
            }
        }

        @Override // b.a.p0.a.c2.f.p0.g.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                b.a.p0.a.e0.d.b("Api-LoadSubPackage", "preload subPackage failed");
                this.f8041b.d(this.f8040a, new b.a.p0.a.u.h.b(202, "No SubPackage"));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean x(@Nullable String str, @Nullable List<b.a.p0.n.h.g> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, list)) == null) {
            if (str != null && list != null && !list.isEmpty()) {
                for (b.a.p0.n.h.g gVar : list) {
                    if (gVar != null && TextUtils.equals(gVar.p, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void u(b.a.p0.a.a2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "Api-LoadSubPackage", 2);
        }
    }

    public final void v(b.a.p0.a.a2.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2, str3) == null) {
            g.k(eVar.f3961f, eVar.Y(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void w(b.a.p0.a.a2.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return i(str, true, new C0380a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? i(str, true, new b(this)) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
