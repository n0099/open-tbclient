package b.a.p0.a.u.e.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import b.a.p0.a.f2.f.o0.g;
import b.a.p0.a.u.c.d;
import b.a.p0.q.i.h;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0413a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8521a;

        public C0413a(a aVar) {
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
            this.f8521a = aVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(b.a.p0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    this.f8521a.D(eVar, optString, str);
                    return new b.a.p0.a.u.h.b(0);
                }
                b.a.p0.a.e0.d.c("PreLoadSubPackageApi", "subPackage root is null");
                return new b.a.p0.a.u.h.b(202);
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8522a;

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
            this.f8522a = aVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(b.a.p0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("roots");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    this.f8522a.B(eVar, str, optJSONArray);
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
        public final /* synthetic */ b.a.p0.a.d2.e f8523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8524f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f8525g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8526h;

        /* renamed from: b.a.p0.a.u.e.b.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0414a implements g.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f8527a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f8528b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f8529c;

            public C0414a(c cVar, CountDownLatch countDownLatch, List list, String str) {
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
                this.f8527a = countDownLatch;
                this.f8528b = list;
                this.f8529c = str;
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    this.f8527a.countDown();
                    this.f8528b.add(this.f8529c);
                }
            }

            @Override // b.a.p0.a.f2.f.o0.g.e
            public void b(int i2, b.a.p0.a.u2.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                    this.f8527a.countDown();
                    b.a.p0.a.e0.d.o("PreLoadSubPackageApi", "downloadSubPackage fail, code=" + i2);
                }
            }
        }

        public c(a aVar, b.a.p0.a.d2.e eVar, String str, JSONArray jSONArray) {
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
            this.f8526h = aVar;
            this.f8523e = eVar;
            this.f8524f = str;
            this.f8525g = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String j0 = this.f8523e.j0();
                if (!TextUtils.isDigitsOnly(j0)) {
                    a aVar = this.f8526h;
                    String str = this.f8524f;
                    aVar.d(str, new b.a.p0.a.u.h.b(202, "current version error:" + j0));
                    return;
                }
                List<h> k = b.a.p0.q.g.a.i().k(this.f8523e.f4474f, Integer.parseInt(j0));
                ArraySet<String> arraySet = new ArraySet();
                List synchronizedList = Collections.synchronizedList(new ArrayList());
                for (int i2 = 0; i2 < this.f8525g.length(); i2++) {
                    String optString = this.f8525g.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (a.E(optString, k) && this.f8523e.t0(optString)) {
                            synchronizedList.add(optString);
                        } else {
                            arraySet.add(optString);
                        }
                    }
                }
                if (!arraySet.isEmpty()) {
                    CountDownLatch countDownLatch = new CountDownLatch(arraySet.size());
                    for (String str2 : arraySet) {
                        String Q = this.f8523e.Q(str2);
                        if (TextUtils.isEmpty(Q)) {
                            countDownLatch.countDown();
                        } else {
                            b.a.p0.a.d2.e eVar = this.f8523e;
                            g.l(eVar.f4474f, eVar.j0(), "1", str2, Q, null, new C0414a(this, countDownLatch, synchronizedList, str2));
                        }
                    }
                    try {
                        countDownLatch.await(1L, TimeUnit.MINUTES);
                    } catch (InterruptedException e2) {
                        b.a.p0.a.e0.d.d("PreLoadSubPackageApi", "loadSubPackages", e2);
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < this.f8525g.length(); i3++) {
                    try {
                        jSONObject.put(this.f8525g.optString(i3), synchronizedList.contains(this.f8525g.optString(i3)) ? 0 : 1001);
                    } catch (Exception unused) {
                    }
                }
                this.f8526h.d(this.f8524f, new b.a.p0.a.u.h.b(0, jSONObject));
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f8530e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8531f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8532g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8533h;

        public d(a aVar, b.a.p0.a.d2.e eVar, String str, String str2) {
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
            this.f8533h = aVar;
            this.f8530e = eVar;
            this.f8531f = str;
            this.f8532g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8530e.u0(this.f8531f) && this.f8530e.t0(this.f8531f)) {
                    b.a.p0.a.e0.d.i("PreLoadSubPackageApi", "subPackage have existed");
                    this.f8533h.d(this.f8532g, new b.a.p0.a.u.h.b(1001, "subPackage have existed"));
                    return;
                }
                String Q = this.f8530e.Q(this.f8531f);
                if (!TextUtils.isEmpty(Q)) {
                    this.f8533h.C(this.f8530e, this.f8531f, Q, this.f8532g);
                    return;
                }
                b.a.p0.a.e0.d.i("PreLoadSubPackageApi", "subPackage cannot find aps key");
                this.f8533h.d(this.f8532g, new b.a.p0.a.u.h.b(202));
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements g.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8534a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8535b;

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
            this.f8535b = aVar;
            this.f8534a = str;
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.i("PreLoadSubPackageApi", "preload subPackage success");
                this.f8535b.d(this.f8534a, new b.a.p0.a.u.h.b(0, "preload subPackage success"));
            }
        }

        @Override // b.a.p0.a.f2.f.o0.g.e
        public void b(int i2, b.a.p0.a.u2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar) == null) {
                b.a.p0.a.e0.d.c("PreLoadSubPackageApi", "preload subPackage failed");
                this.f8535b.d(this.f8534a, new b.a.p0.a.u.h.b(202, "No SubPackage"));
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

    public final void B(b.a.p0.a.d2.e eVar, @Nullable String str, @NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, jSONArray) == null) {
            ExecutorUtilsExt.postOnElastic(new c(this, eVar, str, jSONArray), "PreLoadSubPackageApi", 2);
        }
    }

    public final void C(b.a.p0.a.d2.e eVar, String str, String str2, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, str, str2, str3) == null) {
            g.l(eVar.f4474f, eVar.j0(), "1", str, str2, null, new e(this, str3));
        }
    }

    public final void D(b.a.p0.a.d2.e eVar, String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            ExecutorUtilsExt.postOnElastic(new d(this, eVar, str, str2), "doLoadSubPackageAsync", 2);
        }
    }

    public b.a.p0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#loadSubPackage", false);
            return l(str, true, new C0413a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#loadSubPackages", false);
            return l(str, true, new b(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Basic" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "PreLoadSubPackageApi" : (String) invokeV.objValue;
    }
}
