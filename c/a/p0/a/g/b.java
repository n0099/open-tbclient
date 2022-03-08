package c.a.p0.a.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.f1.i;
import c.a.p0.a.p2.o0;
import c.a.p0.a.p2.q;
import c.a.p0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f5346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5348g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5349h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f5350i;

        public a(b bVar, c.a.p0.a.t1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, unitedSchemeEntity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5350i = bVar;
            this.f5346e = eVar;
            this.f5347f = unitedSchemeEntity;
            this.f5348g = callbackHandler;
            this.f5349h = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5350i.C(this.f5346e, this.f5347f, this.f5348g, this.f5349h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.v1.e eVar) {
        super(eVar, "/swanAPI/adRequest");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.a.p0.a.v1.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.f1.i
    public boolean A(@NonNull c.a.p0.a.t1.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, eVar, unitedSchemeEntity, callbackHandler, str)) == null) {
            q.j(new a(this, eVar, unitedSchemeEntity, callbackHandler, str), "execRequest");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void C(@NonNull c.a.p0.a.t1.e eVar, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            String optString = a2.optString("cb");
            try {
                String optString2 = a2.optString("url");
                D(a2, optString2, o0.q(optString2));
                unitedSchemeEntity.putParams("params", a2.toString());
                if (super.A(eVar, unitedSchemeEntity, callbackHandler, str)) {
                    return;
                }
                c.a.p0.a.u.d.c("AdRequest", "request fail");
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } catch (JSONException unused) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void D(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, z) == null) || jSONObject == null || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null || (optJSONObject = jSONObject.optJSONObject("extParams")) == null) {
            return;
        }
        if (z) {
            str2 = o();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            j(optJSONObject2, str2);
            jSONObject.put("header", optJSONObject2);
        } else {
            str2 = "";
        }
        if (z.f8176b) {
            String str3 = "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2;
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                l = c.a.p0.a.s0.a.h0().i(c.a.p0.a.s0.a.c());
            } else {
                l = (TextUtils.equals(optString, "baiduid") && z) ? o0.l(str2, "BAIDUID") : "";
            }
            if (TextUtils.isEmpty(l)) {
                l = "";
            }
            c.a.p0.a.u.d.i("AdRequest", "key=" + next + ", value=" + l);
            newBuilder.addQueryParameter(next, l);
        }
        jSONObject.put("url", newBuilder.build().toString());
    }
}
