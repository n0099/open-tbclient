package b.a.p0.j.a0;

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
public class c extends b.a.p0.j.a0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.l0.c f10867b;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.a0.g.c f10868a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10870c;

        /* renamed from: b.a.p0.j.a0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0579a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10871e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10872f;

            public RunnableC0579a(a aVar, JSONObject jSONObject) {
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
                this.f10872f = aVar;
                this.f10871e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.j.n0.c.call(this.f10872f.f10869b, true, this.f10871e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10873e;

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
                this.f10873e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f10873e;
                    b.a.p0.j.n0.c.call(aVar.f10869b, false, aVar.f10868a);
                }
            }
        }

        public a(c cVar, b.a.p0.j.a0.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10870c = cVar;
            this.f10868a = cVar2;
            this.f10869b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                this.f10870c.f10867b.post(new RunnableC0579a(this, jSONObject));
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
                if (b.a.p0.j.a0.a.f10859a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.j.a0.a.f10859a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.j.a0.g.c cVar = this.f10868a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.j.n0.c.b("getUserInfo", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.j.a0.a.f10859a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10868a.errMsg)) {
                    b.a.p0.j.a0.g.c cVar = this.f10868a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f10870c.f10867b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ResponseCallback<b.a.p0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.a0.g.c f10874a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10875b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10876c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.j.a0.g.c f10877e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10878f;

            public a(b bVar, b.a.p0.j.a0.g.c cVar) {
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
                this.f10878f = bVar;
                this.f10877e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.j.n0.c.call(this.f10878f.f10875b, true, this.f10877e);
                }
            }
        }

        /* renamed from: b.a.p0.j.a0.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0580b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10879e;

            public RunnableC0580b(b bVar) {
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
                this.f10879e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10879e;
                    b.a.p0.j.n0.c.call(bVar.f10875b, false, bVar.f10874a);
                }
            }
        }

        public b(c cVar, b.a.p0.j.a0.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10876c = cVar;
            this.f10874a = cVar2;
            this.f10875b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                this.f10876c.f10867b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (b.a.p0.j.a0.a.f10859a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.j.a0.a.f10859a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.j.a0.g.c cVar = this.f10874a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                b.a.p0.j.a0.g.c cVar2 = this.f10874a;
                cVar2.errNo = "0";
                cVar2.errMsg = b.a.p0.j.n0.c.b("removeUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.f10874a;
            }
            return (b.a.p0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.j.a0.a.f10859a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10874a.errMsg)) {
                    b.a.p0.j.a0.g.c cVar = this.f10874a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f10876c.f10867b.post(new RunnableC0580b(this));
            }
        }
    }

    /* renamed from: b.a.p0.j.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0581c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.a0.g.c f10880a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10881b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10882c;

        /* renamed from: b.a.p0.j.a0.c$c$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10883e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0581c f10884f;

            public a(C0581c c0581c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0581c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10884f = c0581c;
                this.f10883e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.j.n0.c.call(this.f10884f.f10881b, true, this.f10883e);
                }
            }
        }

        /* renamed from: b.a.p0.j.a0.c$c$b */
        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0581c f10885e;

            public b(C0581c c0581c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0581c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10885e = c0581c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0581c c0581c = this.f10885e;
                    b.a.p0.j.n0.c.call(c0581c.f10881b, false, c0581c.f10880a);
                }
            }
        }

        public C0581c(c cVar, b.a.p0.j.a0.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10882c = cVar;
            this.f10880a = cVar2;
            this.f10881b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                this.f10882c.f10867b.post(new a(this, jSONObject));
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
                if (b.a.p0.j.a0.a.f10859a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.j.a0.a.f10859a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.j.a0.g.c cVar = this.f10880a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.j.n0.c.b("getUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                if (TextUtils.isEmpty(this.f10880a.errMsg)) {
                    b.a.p0.j.a0.g.c cVar = this.f10880a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f10882c.f10867b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends ResponseCallback<b.a.p0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.a0.g.c f10886a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10887b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10888c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.j.a0.g.c f10889e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f10890f;

            public a(d dVar, b.a.p0.j.a0.g.c cVar) {
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
                this.f10890f = dVar;
                this.f10889e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.j.n0.c.call(this.f10890f.f10887b, true, this.f10889e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f10891e;

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
                this.f10891e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10891e;
                    b.a.p0.j.n0.c.call(dVar.f10887b, false, dVar.f10886a);
                }
            }
        }

        public d(c cVar, b.a.p0.j.a0.g.c cVar2, b.a.p0.a.y.b.a aVar) {
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
            this.f10888c = cVar;
            this.f10886a = cVar2;
            this.f10887b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                this.f10888c.f10867b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (b.a.p0.j.a0.a.f10859a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.j.a0.a.f10859a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.j.a0.g.c cVar = this.f10886a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                b.a.p0.j.a0.g.c cVar2 = this.f10886a;
                cVar2.errNo = "0";
                cVar2.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.f10886a;
            }
            return (b.a.p0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                if (TextUtils.isEmpty(this.f10886a.errMsg)) {
                    b.a.p0.j.a0.g.c cVar = this.f10886a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f10888c.f10867b.post(new b(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.a0.g.c f10892a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10893b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10894c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f10895d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10896e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f10897f;

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
                this.f10897f = eVar;
                this.f10896e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.j.n0.c.call(this.f10897f.f10894c, true, this.f10896e);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f10898e;

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
                this.f10898e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f10898e;
                    b.a.p0.j.n0.c.call(eVar.f10894c, false, eVar.f10892a);
                }
            }
        }

        public e(c cVar, b.a.p0.j.a0.g.c cVar2, String str, b.a.p0.a.y.b.a aVar) {
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
            this.f10895d = cVar;
            this.f10892a = cVar2;
            this.f10893b = str;
            this.f10894c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, jSONObject, i2) == null) {
                boolean z = b.a.p0.j.a0.a.f10859a;
                this.f10895d.f10867b.post(new a(this, jSONObject));
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
                if (b.a.p0.j.a0.a.f10859a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (b.a.p0.j.a0.a.f10859a) {
                        String str2 = "errno = " + optString;
                    }
                    b.a.p0.j.a0.g.c cVar = this.f10892a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10893b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put("errMsg", b.a.p0.j.n0.c.b(this.f10893b, NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (b.a.p0.j.a0.a.f10859a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.f10892a.errMsg)) {
                    b.a.p0.j.a0.g.c cVar = this.f10892a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10893b, exc.getMessage());
                }
                this.f10895d.f10867b.post(new b(this));
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
        this.f10867b = cVar;
    }

    public final b.a.p0.j.a0.g.b[] c(b.a.p0.a.y.b.a aVar, JsObject[] jsObjectArr, b.a.p0.j.a0.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                b.a.p0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                b.a.p0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else {
                b.a.p0.j.a0.g.b[] bVarArr = new b.a.p0.j.a0.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObjectArr[i2]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        bVarArr[i2] = new b.a.p0.j.a0.g.b();
                        bVarArr[i2].key = F.B("key");
                        bVarArr[i2].value = F.B("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            b.a.p0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            b.a.p0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail invalid KVData item");
                        b.a.p0.j.n0.c.call(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (b.a.p0.j.a0.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            b.a.p0.j.a0.g.c cVar = new b.a.p0.j.a0.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = b.a.p0.j.n0.c.b("getFriendCloudStorage", "fail must login before calling");
                b.a.p0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (b.a.p0.j.a0.a.f10859a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = b.a.p0.j.n0.c.b("getFriendCloudStorage", "fail invalid keyList");
                b.a.p0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(b.a.p0.j.a0.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", b.a.p0.a.d2.e.f0());
                JSONArray jSONArray = new JSONArray();
                for (b.a.p0.j.a0.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (b.a.p0.j.a0.a.f10859a) {
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
                r = b.a.p0.j.u.a.b().r();
            } else if (i2 == 2) {
                r = b.a.p0.j.u.a.b().m();
            } else if (i2 == 3) {
                r = b.a.p0.j.u.a.b().s();
            } else if (i2 != 4) {
                r = i2 != 5 ? "" : b.a.p0.j.u.a.b().k();
            } else {
                r = b.a.p0.j.u.a.b().o();
            }
            if (TextUtils.isEmpty(r)) {
                boolean z = b.a.p0.j.a0.a.f10859a;
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.p0.a.d2.e L = b.a.p0.a.d2.e.L();
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
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        b.a.p0.j.a0.g.c cVar = new b.a.p0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("getUserCloudStorage", "fail must login before calling");
            b.a.p0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(3, h2, new C0581c(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (b.a.p0.j.a0.a.f10859a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("getUserCloudStorage", "fail invalid keyList");
            b.a.p0.j.n0.c.call(F, false, cVar);
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
            if (b.a.p0.j.a0.a.f10859a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", b.a.p0.a.d2.e.f0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (b.a.p0.j.a0.a.f10859a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new b.a.p0.j.a0.g.c(), F));
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
                jSONObject.put("ma_id", b.a.p0.a.d2.e.f0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (b.a.p0.j.a0.a.f10859a) {
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
        b.a.p0.j.a0.g.c cVar = new b.a.p0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("removeUserCloudStorage", "fail must login before calling");
            b.a.p0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (b.a.p0.j.a0.a.f10859a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("removeUserCloudStorage", "fail invalid keyList");
            b.a.p0.j.n0.c.call(F, false, cVar);
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
        b.a.p0.j.a0.g.c cVar = new b.a.p0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail must login before calling");
            b.a.p0.j.n0.c.call(F, false, cVar);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            b.a.p0.j.a0.g.b[] c2 = c(F, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (b.a.p0.j.a0.a.f10859a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.j.n0.c.b("setUserCloudStorage", "fail KVDataList must be an Array");
            b.a.p0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }
}
