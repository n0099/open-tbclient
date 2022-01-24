package c.a.r0.j.a0;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
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
public class c extends c.a.r0.j.a0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.l0.c f10926b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f10927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10928c;

        /* renamed from: c.a.r0.j.a0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0737a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10929e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10930f;

            public RunnableC0737a(a aVar, JSONObject jSONObject) {
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
                this.f10930f = aVar;
                this.f10929e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j.n0.c.call(this.f10930f.f10927b, true, this.f10929e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10931e;

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
                this.f10931e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f10931e;
                    c.a.r0.j.n0.c.call(aVar.f10927b, false, aVar.a);
                }
            }
        }

        public a(c cVar, c.a.r0.j.a0.g.c cVar2, c.a.r0.a.y.b.a aVar) {
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
            this.f10928c = cVar;
            this.a = cVar2;
            this.f10927b = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (c.a.r0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", exc.getMessage());
                }
                this.f10928c.f10926b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                this.f10928c.f10926b.post(new RunnableC0737a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.r0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.r0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserInfo", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, c.a.r0.j.n0.c.b("getUserInfo", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ResponseCallback<c.a.r0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f10932b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10933c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.j.a0.g.c f10934e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f10935f;

            public a(b bVar, c.a.r0.j.a0.g.c cVar) {
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
                this.f10935f = bVar;
                this.f10934e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j.n0.c.call(this.f10935f.f10932b, true, this.f10934e);
                }
            }
        }

        /* renamed from: c.a.r0.j.a0.c$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0738b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f10936e;

            public RunnableC0738b(b bVar) {
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
                this.f10936e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f10936e;
                    c.a.r0.j.n0.c.call(bVar.f10932b, false, bVar.a);
                }
            }
        }

        public b(c cVar, c.a.r0.j.a0.g.c cVar2, c.a.r0.a.y.b.a aVar) {
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
            this.f10933c = cVar;
            this.a = cVar2;
            this.f10932b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.r0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                this.f10933c.f10926b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.r0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.r0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.r0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.r0.j.a0.g.c cVar2 = this.a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.r0.j.n0.c.b("removeUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.a;
            }
            return (c.a.r0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (c.a.r0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "removeUserCloudStorage", exc.getMessage());
                }
                this.f10933c.f10926b.post(new RunnableC0738b(this));
            }
        }
    }

    /* renamed from: c.a.r0.j.a0.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0739c extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f10937b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10938c;

        /* renamed from: c.a.r0.j.a0.c$c$a */
        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10939e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0739c f10940f;

            public a(C0739c c0739c, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0739c, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10940f = c0739c;
                this.f10939e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j.n0.c.call(this.f10940f.f10937b, true, this.f10939e);
                }
            }
        }

        /* renamed from: c.a.r0.j.a0.c$c$b */
        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C0739c f10941e;

            public b(C0739c c0739c) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0739c};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10941e = c0739c;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    C0739c c0739c = this.f10941e;
                    c.a.r0.j.n0.c.call(c0739c.f10937b, false, c0739c.a);
                }
            }
        }

        public C0739c(c cVar, c.a.r0.j.a0.g.c cVar2, c.a.r0.a.y.b.a aVar) {
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
            this.f10938c = cVar;
            this.a = cVar2;
            this.f10937b = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", exc.getMessage());
                }
                this.f10938c.f10926b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                this.f10938c.f10926b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.r0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.r0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "getUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, c.a.r0.j.n0.c.b("getUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("KVDataList", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d extends ResponseCallback<c.a.r0.j.a0.g.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f10942b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10943c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.j.a0.g.c f10944e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f10945f;

            public a(d dVar, c.a.r0.j.a0.g.c cVar) {
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
                this.f10945f = dVar;
                this.f10944e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j.n0.c.call(this.f10945f.f10942b, true, this.f10944e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f10946e;

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
                this.f10946e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f10946e;
                    c.a.r0.j.n0.c.call(dVar.f10942b, false, dVar.a);
                }
            }
        }

        public d(c cVar, c.a.r0.j.a0.g.c cVar2, c.a.r0.a.y.b.a aVar) {
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
            this.f10943c = cVar;
            this.a = cVar2;
            this.f10942b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(c.a.r0.j.a0.g.c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                this.f10943c.f10926b.post(new a(this, cVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public c.a.r0.j.a0.g.c parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.r0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.r0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", jSONObject.optString("errmsg"));
                    return null;
                }
                c.a.r0.j.a0.g.c cVar2 = this.a;
                cVar2.errNo = "0";
                cVar2.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return this.a;
            }
            return (c.a.r0.j.a0.g.c) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "setUserCloudStorage", exc.getMessage());
                }
                this.f10943c.f10926b.post(new b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.j.a0.g.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f10947b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.y.b.a f10948c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f10949d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ JSONObject f10950e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f10951f;

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
                this.f10951f = eVar;
                this.f10950e = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.j.n0.c.call(this.f10951f.f10948c, true, this.f10950e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f10952e;

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
                this.f10952e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e eVar = this.f10952e;
                    c.a.r0.j.n0.c.call(eVar.f10948c, false, eVar.a);
                }
            }
        }

        public e(c cVar, c.a.r0.j.a0.g.c cVar2, String str, c.a.r0.a.y.b.a aVar) {
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
            this.f10949d = cVar;
            this.a = cVar2;
            this.f10947b = str;
            this.f10948c = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (c.a.r0.j.a0.a.a) {
                    exc.printStackTrace();
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10947b, exc.getMessage());
                }
                this.f10949d.f10926b.post(new b(this));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i2) == null) {
                boolean z = c.a.r0.j.a0.a.a;
                this.f10949d.f10926b.post(new a(this, jSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i2)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (c.a.r0.j.a0.a.a) {
                    String str = "parse response: " + string;
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (c.a.r0.j.a0.a.a) {
                        String str2 = "errno = " + optString;
                    }
                    c.a.r0.j.a0.g.c cVar = this.a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", this.f10947b, jSONObject.optString("errmsg"));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errNo", "0");
                jSONObject2.put(StatConstants.KEY_EXT_ERR_MSG, c.a.r0.j.n0.c.b(this.f10947b, NewBindCardEntry.BING_CARD_SUCCESS_MSG));
                jSONObject2.put("data", jSONObject.optJSONArray("data"));
                return jSONObject2;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    public c(@NonNull c.a.r0.a.l0.c cVar) {
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
        this.f10926b = cVar;
    }

    public final c.a.r0.j.a0.g.b[] c(c.a.r0.a.y.b.a aVar, JsObject[] jsObjectArr, c.a.r0.j.a0.g.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, aVar, jsObjectArr, cVar)) == null) {
            int length = jsObjectArr.length;
            if (length < 1) {
                cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail KVDataList.length must greater than 0");
                c.a.r0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else if (length > 128) {
                cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail user has stored too much keys. delete some keys and try again");
                c.a.r0.j.n0.c.call(aVar, false, cVar);
                return null;
            } else {
                c.a.r0.j.a0.g.b[] bVarArr = new c.a.r0.j.a0.g.b[length];
                for (int i2 = 0; i2 < length; i2++) {
                    c.a.r0.a.y.b.a F = c.a.r0.a.y.b.a.F(jsObjectArr[i2]);
                    if (F != null && F.k() == 2 && !TextUtils.isEmpty(F.B("key")) && !TextUtils.isEmpty(F.B("value"))) {
                        bVarArr[i2] = new c.a.r0.j.a0.g.b();
                        bVarArr[i2].key = F.B("key");
                        bVarArr[i2].value = F.B("value");
                        if (!bVarArr[i2].a()) {
                            cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail some keys in list meet length exceed");
                            c.a.r0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        } else if (!bVarArr[i2].b()) {
                            cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail some key-value in list meet length exceed");
                            c.a.r0.j.n0.c.call(aVar, false, cVar);
                            return null;
                        }
                    } else {
                        cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail invalid KVData item");
                        c.a.r0.j.n0.c.call(aVar, false, cVar);
                        return null;
                    }
                }
                return bVarArr;
            }
        }
        return (c.a.r0.j.a0.g.b[]) invokeLLL.objValue;
    }

    public final void d(JsObject jsObject, int i2) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject, i2) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        if (i2 == 5) {
            c.a.r0.j.a0.g.c cVar = new c.a.r0.j.a0.g.c();
            if (!g()) {
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.r0.j.n0.c.b("getFriendCloudStorage", "fail must login before calling");
                c.a.r0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
            try {
                String[] h2 = F.h("keyList");
                h(jsObject);
                j(i2, h2, new e(this, cVar, "getFriendCloudStorage", F));
                return;
            } catch (JSTypeMismatchException e2) {
                if (c.a.r0.j.a0.a.a) {
                    e2.printStackTrace();
                }
                cVar.errNo = FontParser.sFontWeightDefault;
                cVar.errMsg = c.a.r0.j.n0.c.b("getFriendCloudStorage", "fail invalid keyList");
                c.a.r0.j.n0.c.call(F, false, cVar);
                h(jsObject);
                return;
            }
        }
        h(jsObject);
    }

    public final JSONObject e(c.a.r0.j.a0.g.b[] bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVarArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", c.a.r0.a.d2.e.f0());
                JSONArray jSONArray = new JSONArray();
                for (c.a.r0.j.a0.g.b bVar : bVarArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("key", bVar.key);
                    jSONObject2.put("value", bVar.value);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                if (c.a.r0.j.a0.a.a) {
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
                r = c.a.r0.j.u.a.b().r();
            } else if (i2 == 2) {
                r = c.a.r0.j.u.a.b().m();
            } else if (i2 == 3) {
                r = c.a.r0.j.u.a.b().s();
            } else if (i2 != 4) {
                r = i2 != 5 ? "" : c.a.r0.j.u.a.b().k();
            } else {
                r = c.a.r0.j.u.a.b().o();
            }
            if (TextUtils.isEmpty(r)) {
                boolean z = c.a.r0.j.a0.a.a;
            }
            return r;
        }
        return (String) invokeI.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
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
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.r0.j.a0.g.c cVar = new c.a.r0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("getUserCloudStorage", "fail must login before calling");
            c.a.r0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(3, h2, new C0739c(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (c.a.r0.j.a0.a.a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("getUserCloudStorage", "fail invalid keyList");
            c.a.r0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
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
            if (c.a.r0.j.a0.a.a) {
                e2.printStackTrace();
            }
        }
        h(jsObject);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ma_id", c.a.r0.a.d2.e.f0());
            jSONObject.put("swanid_list", jSONArray);
        } catch (JSONException e3) {
            if (c.a.r0.j.a0.a.a) {
                e3.printStackTrace();
            }
        }
        a(f(1), jSONObject.toString(), new a(this, new c.a.r0.j.a0.g.c(), F));
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
                jSONObject.put("ma_id", c.a.r0.a.d2.e.f0());
                jSONObject.put("key_list", jSONArray);
            } catch (JSONException e2) {
                if (c.a.r0.j.a0.a.a) {
                    e2.printStackTrace();
                }
            }
            a(f(i2), jSONObject.toString(), responseCallback);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.r0.j.a0.g.c cVar = new c.a.r0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("removeUserCloudStorage", "fail must login before calling");
            c.a.r0.j.n0.c.call(F, false, cVar);
            h(jsObject);
            return;
        }
        try {
            String[] h2 = F.h("keyList");
            h(jsObject);
            j(2, h2, new b(this, cVar, F));
        } catch (JSTypeMismatchException e2) {
            if (c.a.r0.j.a0.a.a) {
                e2.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("removeUserCloudStorage", "fail invalid keyList");
            c.a.r0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        c.a.r0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) || (F = c.a.r0.a.y.b.a.F(jsObject)) == null) {
            return;
        }
        c.a.r0.j.a0.g.c cVar = new c.a.r0.j.a0.g.c();
        if (!g()) {
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail must login before calling");
            c.a.r0.j.n0.c.call(F, false, cVar);
            i(F.z("KVDataList"));
            h(jsObject);
            return;
        }
        try {
            JsObject[] e2 = F.e("KVDataList");
            h(jsObject);
            c.a.r0.j.a0.g.b[] c2 = c(F, e2, cVar);
            i(e2);
            if (c2 == null) {
                return;
            }
            a(f(4), e(c2).toString(), new d(this, cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (c.a.r0.j.a0.a.a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = c.a.r0.j.n0.c.b("setUserCloudStorage", "fail KVDataList must be an Array");
            c.a.r0.j.n0.c.call(F, false, cVar);
            h(jsObject);
        }
    }
}
