package c.a.o0.a.u.e.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import c.a.o0.a.n2.a.a;
import c.a.o0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.u.e.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0414a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9050a;

        /* renamed from: c.a.o0.a.u.e.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0415a implements a.InterfaceC0318a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f9051a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f9052b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C0414a f9053c;

            public C0415a(C0414a c0414a, String str, l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0414a, str, lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9053c = c0414a;
                this.f9051a = str;
                this.f9052b = lVar;
            }

            @Override // c.a.o0.a.n2.a.a.InterfaceC0318a
            public void a(double[] dArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                    if (dArr != null && dArr.length == 3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("x", dArr[0]);
                            jSONObject.put("y", dArr[1]);
                            jSONObject.put("z", dArr[2]);
                            this.f9052b.d(this.f9053c.f9050a, jSONObject);
                            return;
                        } catch (JSONException e2) {
                            c.a.o0.a.e0.d.b("Api-Accelerometer", "handle compass,json error，" + e2.toString());
                            this.f9052b.f(this.f9053c.f9050a, "Json error");
                            return;
                        }
                    }
                    c.a.o0.a.e0.d.b("Api-Accelerometer", "illegal accelerometers");
                    this.f9053c.f9050a.d(this.f9051a, new c.a.o0.a.u.h.b(1001));
                }
            }
        }

        public C0414a(a aVar) {
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
            this.f9050a = aVar;
        }

        @Override // c.a.o0.a.u.c.d.b
        public c.a.o0.a.u.h.b a(c.a.o0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                c.a.o0.a.e0.d.g("Api-Accelerometer", " init ");
                l lVar = new l("accelerometerChange", jSONObject, str);
                c.a.o0.a.n2.a.a a2 = c.a.o0.a.n2.a.a.a();
                a2.b(this.f9050a.i(), b.a(jSONObject.optString("interval")));
                a2.e(new C0415a(this, str, lVar));
                a2.f();
                lVar.b(this.f9050a);
                return new c.a.o0.a.u.h.b(0);
            }
            return (c.a.o0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static ArrayMap<String, Integer> f9054a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(140111382, "Lc/a/o0/a/u/e/o/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(140111382, "Lc/a/o0/a/u/e/o/a$b;");
                    return;
                }
            }
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            f9054a = arrayMap;
            arrayMap.put(IMTrackDatabase.UiEnum.TABLE_NAME, 60);
            f9054a.put("game", 20);
            f9054a.put("normal", 200);
        }

        public static int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                Integer num = f9054a.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 200;
            }
            return invokeL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.o0.a.u.c.d.f8699c;
            return j(str, true, new C0414a(this));
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = c.a.o0.a.u.c.d.f8699c;
            c.a.o0.a.e0.d.g("Api-Accelerometer", "stop listen accelerometer");
            c.a.o0.a.n2.a.a.a().g();
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeV.objValue;
    }
}
