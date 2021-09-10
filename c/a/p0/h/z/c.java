package c.a.p0.h.z;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends c.a.p0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.l0.c f11644b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11646b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11647c;

        /* renamed from: c.a.p0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0607a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11648e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f11649f;

            public RunnableC0607a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11649f = aVar;
                this.f11648e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11649f.f11646b, true, this.f11648e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11650e;

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
                this.f11650e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f11650e;
                    c.a.p0.h.m0.c.a(aVar.f11646b, false, aVar.f11645a);
                }
            }
        }

        public a(c cVar, c.a.p0.h.z.g.c cVar2, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11647c = cVar;
            this.f11645a = cVar2;
            this.f11646b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11647c.f11644b.post(new RunnableC0607a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
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
                    c.a.p0.h.z.g.c cVar = this.f11645a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.p0.h.m0.c.c("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.p0.h.z.a.f11636a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11645a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11645a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f11647c.f11644b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<c.a.p0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11651a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11652b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11653c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.h.z.g.c f11654e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11655f;

            public a(b bVar, c.a.p0.h.z.g.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11655f = bVar;
                this.f11654e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11655f.f11652b, true, this.f11654e);
                }
            }
        }

        /* renamed from: c.a.p0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0608b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f11656e;

            public RunnableC0608b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11656e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f11656e;
                    c.a.p0.h.m0.c.a(bVar.f11652b, false, bVar.f11651a);
                }
            }
        }

        public b(c cVar, c.a.p0.h.z.g.c cVar2, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11653c = cVar;
            this.f11651a = cVar2;
            this.f11652b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.p0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11653c.f11644b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.p0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
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
                    c.a.p0.h.z.g.c cVar = this.f11651a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.p0.h.z.g.c cVar2 = this.f11651a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.p0.h.m0.c.c("removeUserCloudStorage", "ok");
                return this.f11651a;
            }
            return (c.a.p0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.p0.h.z.a.f11636a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11651a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11651a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f11653c.f11644b.post(new RunnableC0608b(this));
            }
        }
    }

    /* renamed from: c.a.p0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0609c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11659c;

        /* renamed from: c.a.p0.h.z.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11660e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0609c f11661f;

            public a(C0609c c0609c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0609c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11661f = c0609c;
                this.f11660e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11661f.f11658b, true, this.f11660e);
                }
            }
        }

        /* renamed from: c.a.p0.h.z.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0609c f11662e;

            public b(C0609c c0609c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0609c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11662e = c0609c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0609c c0609c = this.f11662e;
                    c.a.p0.h.m0.c.a(c0609c.f11658b, false, c0609c.f11657a);
                }
            }
        }

        public C0609c(c cVar, c.a.p0.h.z.g.c cVar2, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11659c = cVar;
            this.f11657a = cVar2;
            this.f11658b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11659c.f11644b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
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
                    c.a.p0.h.z.g.c cVar = this.f11657a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.p0.h.m0.c.c("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                if (TextUtils.isEmpty(this.f11657a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11657a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f11659c.f11644b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<c.a.p0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11663a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11664b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11665c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.h.z.g.c f11666e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f11667f;

            public a(d dVar, c.a.p0.h.z.g.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11667f = dVar;
                this.f11666e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11667f.f11664b, true, this.f11666e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f11668e;

            public b(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11668e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f11668e;
                    c.a.p0.h.m0.c.a(dVar.f11664b, false, dVar.f11663a);
                }
            }
        }

        public d(c cVar, c.a.p0.h.z.g.c cVar2, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11665c = cVar;
            this.f11663a = cVar2;
            this.f11664b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.p0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11665c.f11644b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.p0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
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
                    c.a.p0.h.z.g.c cVar = this.f11663a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.p0.h.z.g.c cVar2 = this.f11663a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "ok");
                return this.f11663a;
            }
            return (c.a.p0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                if (TextUtils.isEmpty(this.f11663a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11663a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f11665c.f11644b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h.z.g.c f11669a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11670b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.y.b.a f11671c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f11672d;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11673e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f11674f;

            public a(e eVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11674f = eVar;
                this.f11673e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.h.m0.c.a(this.f11674f.f11671c, true, this.f11673e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f11675e;

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
                this.f11675e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f11675e;
                    c.a.p0.h.m0.c.a(eVar.f11671c, false, eVar.f11669a);
                }
            }
        }

        public e(c cVar, c.a.p0.h.z.g.c cVar2, String str, c.a.p0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, cVar2, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11672d = cVar;
            this.f11669a = cVar2;
            this.f11670b = str;
            this.f11671c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.p0.h.z.a.f11636a;
                this.f11672d.f11644b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
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
                    c.a.p0.h.z.g.c cVar = this.f11669a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f11670b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.p0.h.m0.c.c(this.f11670b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.p0.h.z.a.f11636a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11669a.errMsg)) {
                    c.a.p0.h.z.g.c cVar = this.f11669a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f11670b, exc.getMessage());
                }
                this.f11672d.f11644b.post(new b(this));
            }
        }
    }

    public c(@NonNull c.a.p0.a.l0.c cVar) {
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
        this.f11644b = cVar;
    }

    public final c.a.p0.h.z.g.b[] c(c.a.p0.a.y.b.a aVar, JsObject[] jsObjectArr, c.a.p0.h.z.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                c.a.p0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                c.a.p0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else {
                c.a.p0.h.z.g.b[] bVarArr = new c.a.p0.h.z.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    c.a.p0.a.y.b.a G = c.a.p0.a.y.b.a.G(jsObjectArr[i2]);
                    if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                        bVarArr[i2] = new c.a.p0.h.z.g.b();
                        bVarArr[i2].key = G.C("key");
                        bVarArr[i2].value = G.C("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                            c.a.p0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            c.a.p0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                        c.a.p0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (c.a.p0.h.z.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            c.a.p0.h.z.g.c cVar = new c.a.p0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.p0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                c.a.p0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (c.a.p0.h.z.a.f11636a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.p0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                c.a.p0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(c.a.p0.h.z.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", c.a.p0.a.a2.e.V());
                JSONArray jSONArray = new JSONArray();
                for (c.a.p0.h.z.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (c.a.p0.h.z.a.f11636a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String f(int i2) {
        InterceptResult invokeI;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 1) {
                o = c.a.p0.h.t.a.b().o();
            } else if (i2 == 2) {
                o = c.a.p0.h.t.a.b().k();
            } else if (i2 == 3) {
                o = c.a.p0.h.t.a.b().p();
            } else if (i2 != 4) {
                o = i2 != 5 ? "" : c.a.p0.h.t.a.b().i();
            } else {
                o = c.a.p0.h.t.a.b().m();
            }
            if (TextUtils.isEmpty(o)) {
                boolean z = c.a.p0.h.z.a.f11636a;
            }
            return o;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            if (i2 == null) {
                return false;
            }
            return i2.j().e(AppRuntime.getAppContext());
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d(jsObject, 5);
        }
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.p0.h.z.g.c cVar = new c.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            c.a.p0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C0609c(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (c.a.p0.h.z.a.f11636a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            c.a.p0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h2 = G.h("swanIdList");
            if (h2 != null && h2.length > 0) {
                for (String str : h2) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (c.a.p0.h.z.a.f11636a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", c.a.p0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (c.a.p0.h.z.a.f11636a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new c.a.p0.h.z.g.c(), G));
    }

    public final void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public final void i(JsObject[] jsObjectArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObjectArr) == null) || jsObjectArr == null) {
            return;
        }
        for (JsObject jsObject : jsObjectArr) {
            h(jsObject);
        }
    }

    public final <T> void j(int i2, @NonNull String[] strArr, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, responseCallback) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (strArr.length > 0) {
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            try {
                jSONObject.put("ma_id", c.a.p0.a.a2.e.V());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (c.a.p0.h.z.a.f11636a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.p0.h.z.g.c cVar = new c.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            c.a.p0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (c.a.p0.h.z.a.f11636a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            c.a.p0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        c.a.p0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (G = c.a.p0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.p0.h.z.g.c cVar = new c.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            c.a.p0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            c.a.p0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (c.a.p0.h.z.a.f11636a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.p0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            c.a.p0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
