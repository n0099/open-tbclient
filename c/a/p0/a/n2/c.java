package c.a.p0.a.n2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7008e;

        public a(c cVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7008e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.n2.b.k("777", this.f7008e);
                c.a.p0.a.e0.d.k("SwanAppBusinessUbc", this.f7008e.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public String f7009b;

        /* renamed from: c  reason: collision with root package name */
        public String f7010c;

        /* renamed from: d  reason: collision with root package name */
        public String f7011d;

        /* renamed from: e  reason: collision with root package name */
        public String f7012e;

        /* renamed from: f  reason: collision with root package name */
        public String f7013f;

        /* renamed from: g  reason: collision with root package name */
        public String f7014g;

        /* renamed from: h  reason: collision with root package name */
        public String f7015h;

        public b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new c(null);
            this.f7010c = String.valueOf(i2);
            this.f7009b = "swan";
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f7014g = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f7015h = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f7013f = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f7011d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f7012e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.b(this);
            }
        }
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public final void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(bVar.f7009b)) {
                jSONObject.put("from", bVar.f7009b);
            }
            if (!TextUtils.isEmpty(bVar.f7010c)) {
                jSONObject.put("type", bVar.f7010c);
            }
            if (!TextUtils.isEmpty(bVar.f7012e)) {
                jSONObject.put("value", bVar.f7012e);
            }
            if (!TextUtils.isEmpty(bVar.f7011d)) {
                jSONObject.put("source", bVar.f7011d);
            }
            if (!TextUtils.isEmpty(bVar.f7013f)) {
                jSONObject.put("page", bVar.f7013f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f7014g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f7015h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f7014g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f7015h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            c.a.p0.a.z2.q.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (c.a.p0.a.k.a) {
                e2.printStackTrace();
            }
        }
    }

    public c() {
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
}
