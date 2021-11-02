package b.a.p0.h.z;

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
/* loaded from: classes4.dex */
public class c extends b.a.p0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.l0.c f10842b;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10843a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10844b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10845c;

        /* renamed from: b.a.p0.h.z.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0602a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10846e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10847f;

            public RunnableC0602a(a aVar, JSONObject jSONObject) {
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
                this.f10847f = aVar;
                this.f10846e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10847f.f10844b, true, this.f10846e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10848e;

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
                this.f10848e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f10848e;
                    b.a.p0.h.m0.c.call(aVar.f10844b, false, aVar.f10843a);
                }
            }
        }

        public a(c cVar, b.a.p0.h.z.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10845c = cVar;
            this.f10843a = cVar2;
            this.f10844b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10845c.f10842b.post(new RunnableC0602a(this, jSONObject));
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
                if (b.a.p0.h.z.a.f10834a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.h.z.a.f10834a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.h.z.g.c cVar = this.f10843a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.h.m0.c.b("getUserInfo", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.h.z.a.f10834a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10843a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10843a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f10845c.f10842b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback<b.a.p0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10849a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10850b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10851c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.h.z.g.c f10852e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10853f;

            public a(b bVar, b.a.p0.h.z.g.c cVar) {
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
                this.f10853f = bVar;
                this.f10852e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10853f.f10850b, true, this.f10852e);
                }
            }
        }

        /* renamed from: b.a.p0.h.z.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0603b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10854e;

            public RunnableC0603b(b bVar) {
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
                this.f10854e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10854e;
                    b.a.p0.h.m0.c.call(bVar.f10850b, false, bVar.f10849a);
                }
            }
        }

        public b(c cVar, b.a.p0.h.z.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10851c = cVar;
            this.f10849a = cVar2;
            this.f10850b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10851c.f10842b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (b.a.p0.h.z.a.f10834a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.h.z.a.f10834a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.h.z.g.c cVar = this.f10849a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                b.a.p0.h.z.g.c cVar2 = this.f10849a;
                cVar2.errNo = "0";
                cVar2.errMsg = b.a.p0.h.m0.c.b("removeUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.f10849a;
            }
            return (b.a.p0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.h.z.a.f10834a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10849a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10849a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f10851c.f10842b.post(new RunnableC0603b(this));
            }
        }
    }

    /* renamed from: b.a.p0.h.z.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0604c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10855a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10856b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10857c;

        /* renamed from: b.a.p0.h.z.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10858e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0604c f10859f;

            public a(C0604c c0604c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0604c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10859f = c0604c;
                this.f10858e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10859f.f10856b, true, this.f10858e);
                }
            }
        }

        /* renamed from: b.a.p0.h.z.c$c$b */
        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0604c f10860e;

            public b(C0604c c0604c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0604c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10860e = c0604c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0604c c0604c = this.f10860e;
                    b.a.p0.h.m0.c.call(c0604c.f10856b, false, c0604c.f10855a);
                }
            }
        }

        public C0604c(c cVar, b.a.p0.h.z.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10857c = cVar;
            this.f10855a = cVar2;
            this.f10856b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10857c.f10842b.post(new a(this, jSONObject));
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
                if (b.a.p0.h.z.a.f10834a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.h.z.a.f10834a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.h.z.g.c cVar = this.f10855a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.h.m0.c.b("getUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                if (TextUtils.isEmpty(this.f10855a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10855a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f10857c.f10842b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ResponseCallback<b.a.p0.h.z.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10861a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10862b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10863c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.h.z.g.c f10864e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f10865f;

            public a(d dVar, b.a.p0.h.z.g.c cVar) {
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
                this.f10865f = dVar;
                this.f10864e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10865f.f10862b, true, this.f10864e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f10866e;

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
                this.f10866e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10866e;
                    b.a.p0.h.m0.c.call(dVar.f10862b, false, dVar.f10861a);
                }
            }
        }

        public d(c cVar, b.a.p0.h.z.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10863c = cVar;
            this.f10861a = cVar2;
            this.f10862b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.h.z.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10863c.f10842b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.h.z.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (b.a.p0.h.z.a.f10834a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.h.z.a.f10834a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.h.z.g.c cVar = this.f10861a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                b.a.p0.h.z.g.c cVar2 = this.f10861a;
                cVar2.errNo = "0";
                cVar2.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.f10861a;
            }
            return (b.a.p0.h.z.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                if (TextUtils.isEmpty(this.f10861a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10861a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f10863c.f10842b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10867a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f10870d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10871e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f10872f;

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
                this.f10872f = eVar;
                this.f10871e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10872f.f10869c, true, this.f10871e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f10873e;

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
                this.f10873e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f10873e;
                    b.a.p0.h.m0.c.call(eVar.f10869c, false, eVar.f10867a);
                }
            }
        }

        public e(c cVar, b.a.p0.h.z.g.c cVar2, String str, b.a.p0.a.y.b.a aVar) {
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
            this.f10870d = cVar;
            this.f10867a = cVar2;
            this.f10868b = str;
            this.f10869c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10870d.f10842b.post(new a(this, jSONObject));
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
                if (b.a.p0.h.z.a.f10834a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.h.z.a.f10834a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.h.z.g.c cVar = this.f10867a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10868b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.h.m0.c.b(this.f10868b, NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.h.z.a.f10834a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10867a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10867a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10868b, exc.getMessage());
                }
                this.f10870d.f10842b.post(new b(this));
            }
        }
    }

    public c(@NonNull b.a.p0.a.l0.c cVar) {
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
        this.f10842b = cVar;
    }

    public final b.a.p0.h.z.g.b[] c(b.a.p0.a.y.b.a aVar, JsObject[] jsObjectArr, b.a.p0.h.z.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                b.a.p0.h.m0.c.call(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                b.a.p0.h.m0.c.call(aVar, false, cVar);
                return null;
            } else {
                b.a.p0.h.z.g.b[] bVarArr = new b.a.p0.h.z.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObjectArr[i2]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        bVarArr[i2] = new b.a.p0.h.z.g.b();
                        bVarArr[i2].key = F.B("key");
                        bVarArr[i2].value = F.B("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            b.a.p0.h.m0.c.call(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            b.a.p0.h.m0.c.call(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail invalid KVData item");
                        b.a.p0.h.m0.c.call(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (b.a.p0.h.z.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            b.a.p0.h.z.g.c cVar = new b.a.p0.h.z.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = b.a.p0.h.m0.c.b("getFriendCloudStorage", "fail must login before calling");
                b.a.p0.h.m0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (b.a.p0.h.z.a.f10834a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = b.a.p0.h.m0.c.b("getFriendCloudStorage", "fail invalid keyList");
                b.a.p0.h.m0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(b.a.p0.h.z.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", b.a.p0.a.a2.e.U());
                JSONArray jSONArray = new JSONArray();
                for (b.a.p0.h.z.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (b.a.p0.h.z.a.f10834a) {
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
                o = b.a.p0.h.t.a.b().o();
            } else if (i2 == 2) {
                o = b.a.p0.h.t.a.b().k();
            } else if (i2 == 3) {
                o = b.a.p0.h.t.a.b().p();
            } else if (i2 != 4) {
                o = i2 != 5 ? "" : b.a.p0.h.t.a.b().i();
            } else {
                o = b.a.p0.h.t.a.b().m();
            }
            if (TextUtils.isEmpty(o)) {
                boolean z = b.a.p0.h.z.a.f10834a;
            }
            return o;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
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
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        b.a.p0.h.z.g.c cVar = new b.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("getUserCloudStorage", "fail must login before calling");
            b.a.p0.h.m0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(3, h2, new C0604c(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (b.a.p0.h.z.a.f10834a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("getUserCloudStorage", "fail invalid keyList");
            b.a.p0.h.m0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
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
            if (b.a.p0.h.z.a.f10834a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", b.a.p0.a.a2.e.U());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (b.a.p0.h.z.a.f10834a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new b.a.p0.h.z.g.c(), F));
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
                jSONObject.put("ma_id", b.a.p0.a.a2.e.U());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (b.a.p0.h.z.a.f10834a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        b.a.p0.h.z.g.c cVar = new b.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("removeUserCloudStorage", "fail must login before calling");
            b.a.p0.h.m0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (b.a.p0.h.z.a.f10834a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("removeUserCloudStorage", "fail invalid keyList");
            b.a.p0.h.m0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        b.a.p0.h.z.g.c cVar = new b.a.p0.h.z.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail must login before calling");
            b.a.p0.h.m0.c.call(F, false, cVar);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            b.a.p0.h.z.g.b[] c2 = c(F, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (b.a.p0.h.z.a.f10834a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.b("setUserCloudStorage", "fail KVDataList must be an Array");
            b.a.p0.h.m0.c.call(F, false, cVar);
            h(jsObject);
        }
    }
}
