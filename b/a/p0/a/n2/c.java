package b.a.p0.a.n2;

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
        public final /* synthetic */ JSONObject f7268e;

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
            this.f7268e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.n2.b.k("777", this.f7268e);
                b.a.p0.a.e0.d.k("SwanAppBusinessUbc", this.f7268e.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c f7269a;

        /* renamed from: b  reason: collision with root package name */
        public String f7270b;

        /* renamed from: c  reason: collision with root package name */
        public String f7271c;

        /* renamed from: d  reason: collision with root package name */
        public String f7272d;

        /* renamed from: e  reason: collision with root package name */
        public String f7273e;

        /* renamed from: f  reason: collision with root package name */
        public String f7274f;

        /* renamed from: g  reason: collision with root package name */
        public String f7275g;

        /* renamed from: h  reason: collision with root package name */
        public String f7276h;

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
            this.f7269a = new c(null);
            this.f7271c = String.valueOf(i2);
            this.f7270b = "swan";
        }

        public b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f7275g = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f7276h = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f7274f = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f7272d = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f7273e = str;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f7269a.b(this);
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
            if (!TextUtils.isEmpty(bVar.f7270b)) {
                jSONObject.put("from", bVar.f7270b);
            }
            if (!TextUtils.isEmpty(bVar.f7271c)) {
                jSONObject.put("type", bVar.f7271c);
            }
            if (!TextUtils.isEmpty(bVar.f7273e)) {
                jSONObject.put("value", bVar.f7273e);
            }
            if (!TextUtils.isEmpty(bVar.f7272d)) {
                jSONObject.put("source", bVar.f7272d);
            }
            if (!TextUtils.isEmpty(bVar.f7274f)) {
                jSONObject.put("page", bVar.f7274f);
            }
            boolean isEmpty = TextUtils.isEmpty(bVar.f7275g);
            boolean isEmpty2 = TextUtils.isEmpty(bVar.f7276h);
            if (!isEmpty || !isEmpty2) {
                JSONObject jSONObject2 = new JSONObject();
                if (!isEmpty) {
                    jSONObject2.put("appid", bVar.f7275g);
                }
                if (!isEmpty2) {
                    jSONObject2.put("info", bVar.f7276h);
                }
                jSONObject.put("ext", jSONObject2);
            }
            b.a.p0.a.z2.q.k(new a(this, jSONObject), "SwanAppBusinessUbcRunnable");
        } catch (JSONException e2) {
            if (b.a.p0.a.k.f6863a) {
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
