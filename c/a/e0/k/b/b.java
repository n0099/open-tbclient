package c.a.e0.k.b;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e0.h;
import c.a.e0.k.a.e;
import c.a.e0.k.a.f;
import c.a.e0.n.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f3124b = "payChannel";

    /* renamed from: c  reason: collision with root package name */
    public static String f3125c = "payType";

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f3126d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f3127a;

    /* loaded from: classes.dex */
    public class a extends c.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.e0.k.a.a f3128a;

        public a(b bVar, c.a.e0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3128a = aVar;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                c.a.e0.k.h.a.f("7");
                this.f3128a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errCode", -1);
                    int optInt2 = jSONObject.optInt("errno", -1);
                    if (optInt == 0 && optInt2 == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            c.a.e0.k.h.a.d("7", optInt2 + "", jSONObject.optString("msg"));
                            c.a.e0.k.a.a aVar = this.f3128a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("msg = ");
                            sb.append(jSONObject.optString("msg"));
                            aVar.b(new com.baidu.poly.a.i.b(sb.toString()), "data is empty");
                        } else {
                            this.f3128a.a(optJSONObject);
                        }
                    } else {
                        c.a.e0.k.h.a.d("7", optInt2 + "", jSONObject.optString("errmsg"));
                        c.a.e0.k.a.a aVar2 = this.f3128a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("errmsg = ");
                        sb2.append(jSONObject.optString("errmsg"));
                        com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("errno is ");
                        sb3.append(optInt2);
                        aVar2.b(bVar, sb3.toString());
                    }
                } catch (JSONException e2) {
                    c.a.e0.k.h.a.d("7", null, null);
                    this.f3128a.b(e2, "error");
                }
            }
        }
    }

    /* renamed from: c.a.e0.k.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0054b extends c.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.e0.k.a.a f3129a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3130b;

        public C0054b(b bVar, c.a.e0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3130b = bVar;
            this.f3129a = aVar;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                c.a.e0.k.h.a.f("8");
                this.f3129a.b(th, g.a().getResources().getString(h.common_error_tips));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f3129a.a(this.f3130b.i(jSONObject.optJSONObject("data")));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(optInt);
                        sb.append("");
                        c.a.e0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                        c.a.e0.k.a.a aVar = this.f3129a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("msg = ");
                        sb2.append(jSONObject.optString("msg"));
                        aVar.b(new com.baidu.poly.a.i.b(sb2.toString()), jSONObject.optString("msg"));
                    }
                } catch (Throwable th) {
                    c.a.e0.k.h.a.d("8", null, null);
                    this.f3129a.b(th, g.a().getResources().getString(h.common_error_tips));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.e0.k.a.a f3131a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3132b;

        public c(b bVar, c.a.e0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3132b = bVar;
            this.f3131a = aVar;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                c.a.e0.k.h.a.f("8");
                this.f3131a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f3131a.a(this.f3132b.i(jSONObject.optJSONObject("data")));
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(optInt);
                        sb.append("");
                        c.a.e0.k.h.a.d("8", sb.toString(), jSONObject.optString("msg"));
                        c.a.e0.k.a.a aVar = this.f3131a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("msg = ");
                        sb2.append(jSONObject.optString("msg"));
                        com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("errno is ");
                        sb3.append(optInt);
                        aVar.b(bVar, sb3.toString());
                    }
                } catch (Throwable th) {
                    c.a.e0.k.h.a.d("8", null, null);
                    this.f3131a.b(th, "error");
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends c.a.e0.k.a.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.e0.k.a.a f3133a;

        public d(b bVar, c.a.e0.k.a.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3133a = aVar;
        }

        @Override // c.a.e0.k.a.a
        public void b(Throwable th, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th, str) == null) {
                this.f3133a.b(th, str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("errno", -1);
                    if (optInt == 0) {
                        this.f3133a.a(jSONObject.optJSONObject("data"));
                        return;
                    }
                    c.a.e0.k.a.a aVar = this.f3133a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("msg = ");
                    sb.append(jSONObject.optString("msg"));
                    com.baidu.poly.a.i.b bVar = new com.baidu.poly.a.i.b(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("errno is ");
                    sb2.append(optInt);
                    aVar.b(bVar, sb2.toString());
                } catch (Throwable th) {
                    this.f3133a.b(th, "error");
                }
            }
        }
    }

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
        this.f3127a = eVar;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3126d == null) {
                synchronized (b.class) {
                    if (f3126d == null) {
                        f3126d = new b(new f());
                    }
                }
            }
            return f3126d;
        }
        return (b) invokeV.objValue;
    }

    public c.a.e0.k.a.b a(Bundle bundle, c.a.e0.k.a.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, cVar)) == null) {
            c.a.e0.k.a.b bVar = new c.a.e0.k.a.b();
            f(bVar, bundle);
            bVar.e(f3125c, "android");
            e(bundle, bVar, cVar);
            return bVar;
        }
        return (c.a.e0.k.a.b) invokeLL.objValue;
    }

    public void c(Bundle bundle, c.a.e0.k.a.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, aVar) == null) {
            c.a.e0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            c.a.e0.k.a.b bVar = new c.a.e0.k.a.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.e(str, bundle.get(str).toString());
                }
            }
            e(bundle, bVar, k);
            this.f3127a.a(c.a.e0.k.b.d.d(), k, bVar, new a(this, aVar));
        }
    }

    public void d(Bundle bundle, c.a.e0.k.a.a<Map<String, String>> aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, aVar, str) == null) {
            c.a.e0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            c.a.e0.k.a.b bVar = new c.a.e0.k.a.b();
            for (String str2 : keySet) {
                if (bundle.get(str2) instanceof String) {
                    bVar.e(str2, bundle.get(str2).toString());
                }
            }
            bVar.e(f3124b, str);
            e(bundle, bVar, k);
            this.f3127a.a(c.a.e0.k.b.d.f(), k, bVar, new C0054b(this, aVar));
        }
    }

    public final void e(Bundle bundle, c.a.e0.k.a.b bVar, c.a.e0.k.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, bVar, cVar) == null) {
            String string = bundle.getString("bduss");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String b2 = cVar.b("Cookie");
            String str = "BDUSS=" + string;
            if (b2 == null) {
                cVar.e("Cookie", str);
                return;
            }
            cVar.e("Cookie", b2 + "; " + str);
        }
    }

    public final void f(c.a.e0.k.a.b bVar, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, bVar, bundle) == null) || bundle == null || bVar == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            bVar.e(str, bundle.getString(str));
        }
        Iterator<Map.Entry<String, String>> it = bVar.c().entrySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty(it.next().getValue())) {
                it.remove();
            }
        }
    }

    public void g(Bundle bundle, c.a.e0.k.a.a<JSONObject> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bundle, aVar) == null) {
            c.a.e0.k.a.c k = k();
            Set<String> keySet = bundle.keySet();
            c.a.e0.k.a.b bVar = new c.a.e0.k.a.b();
            for (String str : keySet) {
                if (bundle.get(str) instanceof String) {
                    bVar.e(str, bundle.get(str).toString());
                }
            }
            this.f3127a.a(c.a.e0.k.b.d.h(), k, bVar, new d(this, aVar));
        }
    }

    public void h(Bundle bundle, c.a.e0.k.a.a<Map<String, String>> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, bundle, aVar) == null) {
            c.a.e0.k.a.c k = k();
            c.a.e0.k.a.b a2 = a(bundle, k);
            this.f3127a.a(c.a.e0.k.b.d.g(), k, a2, new c(this, aVar));
        }
    }

    public final Map<String, String> i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            Map<String, String> a2 = c.a.e0.n.e.a();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        a2.put(next, jSONObject.optString(next));
                    }
                }
            }
            return a2;
        }
        return (Map) invokeL.objValue;
    }

    public final c.a.e0.k.a.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new c.a.e0.k.a.c() : (c.a.e0.k.a.c) invokeV.objValue;
    }
}
