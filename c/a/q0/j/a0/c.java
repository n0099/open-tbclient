package c.a.q0.j.a0;

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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends c.a.q0.j.a0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.a.l0.c f10295b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.y.b.a f10296b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10297c;

        /* renamed from: c.a.q0.j.a0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0669a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10298e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10299f;

            public RunnableC0669a(a aVar, JSONObject jSONObject) {
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
                this.f10299f = aVar;
                this.f10298e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.j.n0.c.call(this.f10299f.f10296b, true, this.f10298e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10300e;

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
                this.f10300e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f10300e;
                    c.a.q0.j.n0.c.call(aVar.f10296b, false, aVar.a);
                }
            }
        }

        public a(c cVar, c.a.q0.j.a0.g.c cVar2, c.a.q0.a.y.b.a aVar) {
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
            this.f10297c = cVar;
            this.a = cVar2;
            this.f10296b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                this.f10297c.f10295b.post(new RunnableC0669a(this, jSONObject));
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
                if (c.a.q0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.q0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.q0.j.n0.c.b("getUserInfo", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.q0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f10297c.f10295b.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback<c.a.q0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.y.b.a f10301b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10302c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.j.a0.g.c f10303e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10304f;

            public a(b bVar, c.a.q0.j.a0.g.c cVar) {
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
                this.f10304f = bVar;
                this.f10303e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.j.n0.c.call(this.f10304f.f10301b, true, this.f10303e);
                }
            }
        }

        /* renamed from: c.a.q0.j.a0.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0670b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10305e;

            public RunnableC0670b(b bVar) {
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
                this.f10305e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10305e;
                    c.a.q0.j.n0.c.call(bVar.f10301b, false, bVar.a);
                }
            }
        }

        public b(c cVar, c.a.q0.j.a0.g.c cVar2, c.a.q0.a.y.b.a aVar) {
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
            this.f10302c = cVar;
            this.a = cVar2;
            this.f10301b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.q0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                this.f10302c.f10295b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.q0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.q0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.q0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.q0.j.a0.g.c cVar2 = this.a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.q0.j.n0.c.b("removeUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.a;
            }
            return (c.a.q0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.q0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f10302c.f10295b.post(new RunnableC0670b(this));
            }
        }
    }

    /* renamed from: c.a.q0.j.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0671c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.y.b.a f10306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10307c;

        /* renamed from: c.a.q0.j.a0.c$c$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10308e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0671c f10309f;

            public a(C0671c c0671c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0671c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10309f = c0671c;
                this.f10308e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.j.n0.c.call(this.f10309f.f10306b, true, this.f10308e);
                }
            }
        }

        /* renamed from: c.a.q0.j.a0.c$c$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0671c f10310e;

            public b(C0671c c0671c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0671c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10310e = c0671c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0671c c0671c = this.f10310e;
                    c.a.q0.j.n0.c.call(c0671c.f10306b, false, c0671c.a);
                }
            }
        }

        public C0671c(c cVar, c.a.q0.j.a0.g.c cVar2, c.a.q0.a.y.b.a aVar) {
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
            this.f10307c = cVar;
            this.a = cVar2;
            this.f10306b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                this.f10307c.f10295b.post(new a(this, jSONObject));
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
                if (c.a.q0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.q0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.q0.j.n0.c.b("getUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f10307c.f10295b.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ResponseCallback<c.a.q0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.y.b.a f10311b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10312c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.j.a0.g.c f10313e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f10314f;

            public a(d dVar, c.a.q0.j.a0.g.c cVar) {
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
                this.f10314f = dVar;
                this.f10313e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.j.n0.c.call(this.f10314f.f10311b, true, this.f10313e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f10315e;

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
                this.f10315e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10315e;
                    c.a.q0.j.n0.c.call(dVar.f10311b, false, dVar.a);
                }
            }
        }

        public d(c cVar, c.a.q0.j.a0.g.c cVar2, c.a.q0.a.y.b.a aVar) {
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
            this.f10312c = cVar;
            this.a = cVar2;
            this.f10311b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.q0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                this.f10312c.f10295b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.q0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.q0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.q0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.q0.j.a0.g.c cVar2 = this.a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.a;
            }
            return (c.a.q0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f10312c.f10295b.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.q0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10316b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.y.b.a f10317c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f10318d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10319e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f10320f;

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
                this.f10320f = eVar;
                this.f10319e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.q0.j.n0.c.call(this.f10320f.f10317c, true, this.f10319e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f10321e;

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
                this.f10321e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f10321e;
                    c.a.q0.j.n0.c.call(eVar.f10317c, false, eVar.a);
                }
            }
        }

        public e(c cVar, c.a.q0.j.a0.g.c cVar2, String str, c.a.q0.a.y.b.a aVar) {
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
            this.f10318d = cVar;
            this.a = cVar2;
            this.f10316b = str;
            this.f10317c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = c.a.q0.j.a0.a.a;
                this.f10318d.f10295b.post(new a(this, jSONObject));
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
                if (c.a.q0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.q0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10316b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", c.a.q0.j.n0.c.b(this.f10316b, NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.q0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.q0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10316b, exc.getMessage());
                }
                this.f10318d.f10295b.post(new b(this));
            }
        }
    }

    public c(@NonNull c.a.q0.a.l0.c cVar) {
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
        this.f10295b = cVar;
    }

    public final c.a.q0.j.a0.g.b[] c(c.a.q0.a.y.b.a aVar, JsObject[] jsObjectArr, c.a.q0.j.a0.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                c.a.q0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                c.a.q0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else {
                c.a.q0.j.a0.g.b[] bVarArr = new c.a.q0.j.a0.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    c.a.q0.a.y.b.a F = c.a.q0.a.y.b.a.F(jsObjectArr[i2]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        bVarArr[i2] = new c.a.q0.j.a0.g.b();
                        bVarArr[i2].key = F.B("key");
                        bVarArr[i2].value = F.B("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            c.a.q0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            c.a.q0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail invalid KVData item");
                        c.a.q0.j.n0.c.call(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (c.a.q0.j.a0.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        c.a.q0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (F = c.a.q0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            c.a.q0.j.a0.g.c cVar = new c.a.q0.j.a0.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.q0.j.n0.c.b("getFriendCloudStorage", "fail must login before calling");
                c.a.q0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (c.a.q0.j.a0.a.a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.q0.j.n0.c.b("getFriendCloudStorage", "fail invalid keyList");
                c.a.q0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(c.a.q0.j.a0.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", c.a.q0.a.d2.e.f0());
                JSONArray jSONArray = new JSONArray();
                for (c.a.q0.j.a0.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (c.a.q0.j.a0.a.a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String f(int i2) {
        InterceptResult invokeI;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 1) {
                r = c.a.q0.j.u.a.b().r();
            } else if (i2 == 2) {
                r = c.a.q0.j.u.a.b().m();
            } else if (i2 == 3) {
                r = c.a.q0.j.u.a.b().s();
            } else if (i2 != 4) {
                r = i2 != 5 ? "" : c.a.q0.j.u.a.b().k();
            } else {
                r = c.a.q0.j.u.a.b().o();
            }
            if (TextUtils.isEmpty(r)) {
                boolean z = c.a.q0.j.a0.a.a;
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.q0.a.d2.e L = c.a.q0.a.d2.e.L();
            if (L == null) {
                return false;
            }
            return L.M().e(AppRuntime.getAppContext());
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
        c.a.q0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = c.a.q0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.q0.j.a0.g.c cVar = new c.a.q0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("getUserCloudStorage", "fail must login before calling");
            c.a.q0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(3, h2, new C0671c(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (c.a.q0.j.a0.a.a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("getUserCloudStorage", "fail invalid keyList");
            c.a.q0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        c.a.q0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (F = c.a.q0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            String[] h2 = F.h("swanIdList");
            if (h2 != null && h2.length > 0) {
                for (String str : h2) {
                    jSONArray.put(str);
                }
            }
        } catch (JSTypeMismatchException e2) {
            if (c.a.q0.j.a0.a.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", c.a.q0.a.d2.e.f0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (c.a.q0.j.a0.a.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new c.a.q0.j.a0.g.c(), F));
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
                jSONObject.put("ma_id", c.a.q0.a.d2.e.f0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (c.a.q0.j.a0.a.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        c.a.q0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (F = c.a.q0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.q0.j.a0.g.c cVar = new c.a.q0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("removeUserCloudStorage", "fail must login before calling");
            c.a.q0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (c.a.q0.j.a0.a.a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("removeUserCloudStorage", "fail invalid keyList");
            c.a.q0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        c.a.q0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (F = c.a.q0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.q0.j.a0.g.c cVar = new c.a.q0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail must login before calling");
            c.a.q0.j.n0.c.call(F, false, cVar);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            c.a.q0.j.a0.g.b[] c2 = c(F, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (c.a.q0.j.a0.a.a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.q0.j.n0.c.b("setUserCloudStorage", "fail KVDataList must be an Array");
            c.a.q0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }
}
