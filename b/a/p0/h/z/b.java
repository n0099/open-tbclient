package b.a.p0.h.z;

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
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends b.a.p0.h.z.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.l0.c f10835b;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback<b.a.p0.h.z.g.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.h.z.g.c f10836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.y.b.a f10837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f10838c;

        /* renamed from: b.a.p0.h.z.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0600a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.h.z.g.a f10839e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f10840f;

            public RunnableC0600a(a aVar, b.a.p0.h.z.g.a aVar2) {
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
                this.f10840f = aVar;
                this.f10839e = aVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.h.m0.c.call(this.f10840f.f10837b, true, this.f10839e);
                }
            }
        }

        /* renamed from: b.a.p0.h.z.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0601b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f10841e;

            public RunnableC0601b(a aVar) {
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
                this.f10841e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f10841e;
                    b.a.p0.h.m0.c.call(aVar.f10837b, false, aVar.f10836a);
                }
            }
        }

        public a(b bVar, b.a.p0.h.z.g.c cVar, b.a.p0.a.y.b.a aVar) {
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
            this.f10838c = bVar;
            this.f10836a = cVar;
            this.f10837b = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(b.a.p0.h.z.g.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, aVar, i2) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                this.f10838c.f10835b.post(new RunnableC0600a(this, aVar));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public b.a.p0.h.z.g.a parseResponse(Response response, int i2) throws Exception {
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
                    b.a.p0.h.z.g.c cVar = this.f10836a;
                    cVar.errNo = optString;
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                b.a.p0.h.z.g.a aVar = new b.a.p0.h.z.g.a();
                aVar.result = !TextUtils.equals(optString2, "0");
                aVar.errNo = "0";
                aVar.errMsg = b.a.p0.h.m0.c.b("checkIsUserAdvisedToRest", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                return aVar;
            }
            return (b.a.p0.h.z.g.a) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                boolean z = b.a.p0.h.z.a.f10834a;
                if (TextUtils.isEmpty(this.f10836a.errMsg)) {
                    b.a.p0.h.z.g.c cVar = this.f10836a;
                    cVar.errNo = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
                    cVar.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.f10838c.f10835b.post(new RunnableC0601b(this));
            }
        }
    }

    public b(@NonNull b.a.p0.a.l0.c cVar) {
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
        this.f10835b = cVar;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        b.a.p0.a.y.b.a F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) || (F = b.a.p0.a.y.b.a.F(jsObject)) == null || this.f10835b == null) {
            return;
        }
        b.a.p0.h.z.g.c cVar = new b.a.p0.h.z.g.c();
        try {
            int d2 = F.d("todayPlayedTime");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", b.a.p0.a.a2.e.U());
                jSONObject.put("todayPlayedTime", String.valueOf(d2));
            } catch (JSONException e2) {
                if (b.a.p0.h.z.a.f10834a) {
                    e2.printStackTrace();
                }
            }
            a(b.a.p0.h.t.a.b().e(), jSONObject.toString(), new a(this, cVar, F));
        } catch (JSTypeMismatchException e3) {
            if (b.a.p0.h.z.a.f10834a) {
                e3.printStackTrace();
            }
            cVar.errNo = FontParser.sFontWeightDefault;
            cVar.errMsg = b.a.p0.h.m0.c.a("checkIsUserAdvisedToRest", e3);
            b.a.p0.h.m0.c.call(F, false, cVar);
        }
    }
}
