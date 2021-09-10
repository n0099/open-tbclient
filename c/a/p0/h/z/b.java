package c.a.p0.h.z;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c.a.p0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.l0.c f11637b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<c.a.p0.h.z.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f11640c;

        /* renamed from: c.a.p0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0605a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.h.z.g.a f11641e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f11642f;

            public RunnableC0605a(a aVar, c.a.p0.h.z.g.a aVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, aVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11642f = aVar;
                this.f11641e = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11642f.f11639b, true, this.f11641e);
                }
            }
        }

        /* renamed from: c.a.p0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0606b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11643e;

            public RunnableC0606b(a aVar) {
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
                this.f11643e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f11643e;
                    c.a.p0.h.m0.c.a(aVar.f11639b, false, aVar.f11638a);
                }
            }
        }

        public a(b bVar, c.a.p0.h.z.g.c cVar, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11640c = bVar;
            this.f11638a = cVar;
            this.f11639b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.p0.h.z.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11640c.f11637b.post(new RunnableC0605a(this, aVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.p0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.p0.h.z.a.f11636a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.p0.h.z.a.f11636a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.p0.h.z.g.c cVar = this.f11638a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                c.a.p0.h.z.g.a aVar = new c.a.p0.h.z.g.a();
                aVar.result = !TextUtils.equals(optString2, "0");
                aVar.errNo = "0";
                aVar.errMsg = c.a.p0.h.m0.c.c("checkIsUserAdvisedToRest", "ok");
                return aVar;
            }
            return (c.a.p0.h.z.g.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                if (TextUtils.isEmpty(this.f11638a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11638a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.f11640c.f11637b.post(new RunnableC0606b(this));
            }
        }
    }

    public b(@NonNull c.a.p0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11637b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null || this.f11637b == null) {
            return;
        }
        c.a.p0.h.z.g.c cVar = new c.a.p0.h.z.g.c();
        try {
            int d2 = G.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", c.a.p0.a.a2.e.V());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (c.a.p0.h.z.a.f11636a) {
                    e2.printStackTrace();
                }
            }
            a(c.a.p0.h.t.a.b().e(), jSONObject.toString(), new a(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (c.a.p0.h.z.a.f11636a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.b("checkIsUserAdvisedToRest", e3);
            c.a.p0.h.m0.c.a(G, false, cVar);
        }
    }
}
