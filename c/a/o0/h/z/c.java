package c.a.o0.h.z;

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
public class c extends c.a.o0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.a.l0.c f11616b;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.z.g.c f11617a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.y.b.a f11618b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11619c;

        /* renamed from: c.a.o0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0605a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11620e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f11621f;

            public RunnableC0605a(a aVar, JSONObject jSONObject) {
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
                this.f11621f = aVar;
                this.f11620e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.h.m0.c.a(this.f11621f.f11618b, true, this.f11620e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f11622e;

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
                this.f11622e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f11622e;
                    c.a.o0.h.m0.c.a(aVar.f11618b, false, aVar.f11617a);
                }
            }
        }

        public a(c cVar, c.a.o0.h.z.g.c cVar2, c.a.o0.a.y.b.a aVar) {
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
            this.f11619c = cVar;
            this.f11617a = cVar2;
            this.f11618b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                this.f11619c.f11616b.post(new RunnableC0605a(this, jSONObject));
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
                if (c.a.o0.h.z.a.f11608a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.o0.h.z.a.f11608a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.o0.h.z.g.c cVar = this.f11617a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.o0.h.m0.c.c("getUserInfo", "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.o0.h.z.a.f11608a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11617a.errMsg)) {
                    c.a.o0.h.z.g.c cVar = this.f11617a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f11619c.f11616b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback<c.a.o0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.z.g.c f11623a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.y.b.a f11624b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11625c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.h.z.g.c f11626e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11627f;

            public a(b bVar, c.a.o0.h.z.g.c cVar) {
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
                this.f11627f = bVar;
                this.f11626e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.h.m0.c.a(this.f11627f.f11624b, true, this.f11626e);
                }
            }
        }

        /* renamed from: c.a.o0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0606b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f11628e;

            public RunnableC0606b(b bVar) {
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
                this.f11628e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f11628e;
                    c.a.o0.h.m0.c.a(bVar.f11624b, false, bVar.f11623a);
                }
            }
        }

        public b(c cVar, c.a.o0.h.z.g.c cVar2, c.a.o0.a.y.b.a aVar) {
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
            this.f11625c = cVar;
            this.f11623a = cVar2;
            this.f11624b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.o0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                this.f11625c.f11616b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.o0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.o0.h.z.a.f11608a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.o0.h.z.a.f11608a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.o0.h.z.g.c cVar = this.f11623a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.o0.h.z.g.c cVar2 = this.f11623a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.o0.h.m0.c.c("removeUserCloudStorage", "ok");
                return this.f11623a;
            }
            return (c.a.o0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.o0.h.z.a.f11608a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11623a.errMsg)) {
                    c.a.o0.h.z.g.c cVar = this.f11623a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f11625c.f11616b.post(new RunnableC0606b(this));
            }
        }
    }

    /* renamed from: c.a.o0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0607c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.z.g.c f11629a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.y.b.a f11630b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11631c;

        /* renamed from: c.a.o0.h.z.c$c$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11632e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0607c f11633f;

            public a(C0607c c0607c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0607c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11633f = c0607c;
                this.f11632e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.h.m0.c.a(this.f11633f.f11630b, true, this.f11632e);
                }
            }
        }

        /* renamed from: c.a.o0.h.z.c$c$b */
        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0607c f11634e;

            public b(C0607c c0607c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0607c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11634e = c0607c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0607c c0607c = this.f11634e;
                    c.a.o0.h.m0.c.a(c0607c.f11630b, false, c0607c.f11629a);
                }
            }
        }

        public C0607c(c cVar, c.a.o0.h.z.g.c cVar2, c.a.o0.a.y.b.a aVar) {
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
            this.f11631c = cVar;
            this.f11629a = cVar2;
            this.f11630b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                this.f11631c.f11616b.post(new a(this, jSONObject));
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
                if (c.a.o0.h.z.a.f11608a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.o0.h.z.a.f11608a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.o0.h.z.g.c cVar = this.f11629a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.o0.h.m0.c.c("getUserCloudStorage", "ok"));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                if (TextUtils.isEmpty(this.f11629a.errMsg)) {
                    c.a.o0.h.z.g.c cVar = this.f11629a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f11631c.f11616b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends ResponseCallback<c.a.o0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.z.g.c f11635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.y.b.a f11636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f11637c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.h.z.g.c f11638e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f11639f;

            public a(d dVar, c.a.o0.h.z.g.c cVar) {
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
                this.f11639f = dVar;
                this.f11638e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.h.m0.c.a(this.f11639f.f11636b, true, this.f11638e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f11640e;

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
                this.f11640e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f11640e;
                    c.a.o0.h.m0.c.a(dVar.f11636b, false, dVar.f11635a);
                }
            }
        }

        public d(c cVar, c.a.o0.h.z.g.c cVar2, c.a.o0.a.y.b.a aVar) {
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
            this.f11637c = cVar;
            this.f11635a = cVar2;
            this.f11636b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.o0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                this.f11637c.f11616b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.o0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.o0.h.z.a.f11608a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.o0.h.z.a.f11608a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.o0.h.z.g.c cVar = this.f11635a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.o0.h.z.g.c cVar2 = this.f11635a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "ok");
                return this.f11635a;
            }
            return (c.a.o0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                if (TextUtils.isEmpty(this.f11635a.errMsg)) {
                    c.a.o0.h.z.g.c cVar = this.f11635a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f11637c.f11616b.post(new b(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.h.z.g.c f11641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.y.b.a f11643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f11644d;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f11645e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f11646f;

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
                this.f11646f = eVar;
                this.f11645e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.o0.h.m0.c.a(this.f11646f.f11643c, true, this.f11645e);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f11647e;

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
                this.f11647e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f11647e;
                    c.a.o0.h.m0.c.a(eVar.f11643c, false, eVar.f11641a);
                }
            }
        }

        public e(c cVar, c.a.o0.h.z.g.c cVar2, String str, c.a.o0.a.y.b.a aVar) {
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
            this.f11644d = cVar;
            this.f11641a = cVar2;
            this.f11642b = str;
            this.f11643c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.o0.h.z.a.f11608a;
                this.f11644d.f11616b.post(new a(this, jSONObject));
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
                if (c.a.o0.h.z.a.f11608a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.o0.h.z.a.f11608a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.o0.h.z.g.c cVar = this.f11641a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f11642b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.o0.h.m0.c.c(this.f11642b, "ok"));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.o0.h.z.a.f11608a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f11641a.errMsg)) {
                    c.a.o0.h.z.g.c cVar = this.f11641a;
                    cVar.errNo = "100";
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f11642b, exc.getMessage());
                }
                this.f11644d.f11616b.post(new b(this));
            }
        }
    }

    public c(@NonNull c.a.o0.a.l0.c cVar) {
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
        this.f11616b = cVar;
    }

    public final c.a.o0.h.z.g.b[] c(c.a.o0.a.y.b.a aVar, JsObject[] jsObjectArr, c.a.o0.h.z.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                c.a.o0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                c.a.o0.h.m0.c.a(aVar, false, cVar);
                return null;
            } else {
                c.a.o0.h.z.g.b[] bVarArr = new c.a.o0.h.z.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObjectArr[i2]);
                    if (G != null && G.l() == 2 && !TextUtils.isEmpty(G.C("key")) && !TextUtils.isEmpty(G.C("value"))) {
                        bVarArr[i2] = new c.a.o0.h.z.g.b();
                        bVarArr[i2].key = G.C("key");
                        bVarArr[i2].value = G.C("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail some keys in list meet length exceed");
                            c.a.o0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            c.a.o0.h.m0.c.a(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail invalid KVData item");
                        c.a.o0.h.m0.c.a(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (c.a.o0.h.z.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            c.a.o0.h.z.g.c cVar = new c.a.o0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.o0.h.m0.c.c("getFriendCloudStorage", "fail must login before calling");
                c.a.o0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = G.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", G));
                return;
            } catch (JSTypeMismatchException e2) {
                if (c.a.o0.h.z.a.f11608a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.o0.h.m0.c.c("getFriendCloudStorage", "fail invalid keyList");
                c.a.o0.h.m0.c.a(G, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(c.a.o0.h.z.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", c.a.o0.a.a2.e.V());
                JSONArray jSONArray = new JSONArray();
                for (c.a.o0.h.z.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (c.a.o0.h.z.a.f11608a) {
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
                o = c.a.o0.h.t.a.b().o();
            } else if (i2 == 2) {
                o = c.a.o0.h.t.a.b().k();
            } else if (i2 == 3) {
                o = c.a.o0.h.t.a.b().p();
            } else if (i2 != 4) {
                o = i2 != 5 ? "" : c.a.o0.h.t.a.b().i();
            } else {
                o = c.a.o0.h.t.a.b().m();
            }
            if (TextUtils.isEmpty(o)) {
                boolean z = c.a.o0.h.z.a.f11608a;
            }
            return o;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.o0.a.a2.e i2 = c.a.o0.a.a2.e.i();
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
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.o0.h.z.g.c cVar = new c.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("getUserCloudStorage", "fail must login before calling");
            c.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(3, h2, new C0607c(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (c.a.o0.h.z.a.f11608a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("getUserCloudStorage", "fail invalid keyList");
            c.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
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
            if (c.a.o0.h.z.a.f11608a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", c.a.o0.a.a2.e.V());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (c.a.o0.h.z.a.f11608a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new c.a.o0.h.z.g.c(), G));
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
                jSONObject.put("ma_id", c.a.o0.a.a2.e.V());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (c.a.o0.h.z.a.f11608a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.o0.h.z.g.c cVar = new c.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("removeUserCloudStorage", "fail must login before calling");
            c.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = G.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, G));
        } catch (JSTypeMismatchException e2) {
            if (c.a.o0.h.z.a.f11608a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("removeUserCloudStorage", "fail invalid keyList");
            c.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        c.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (G = c.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        c.a.o0.h.z.g.c cVar = new c.a.o0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail must login before calling");
            c.a.o0.h.m0.c.a(G, false, cVar);
            i(G.A("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = G.e("KVDataList");
            h(jsObject);
            c.a.o0.h.z.g.b[] c2 = c(G, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, G));
        } catch (JSTypeMismatchException e3) {
            if (c.a.o0.h.z.a.f11608a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.o0.h.m0.c.c("setUserCloudStorage", "fail KVDataList must be an Array");
            c.a.o0.h.m0.c.a(G, false, cVar);
            h(jsObject);
        }
    }
}
