package c.a.r0.a.f2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6194e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6195f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f6197h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f6198i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6199j;
        public final /* synthetic */ n k;

        public a(n nVar, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = nVar;
            this.f6194e = callbackHandler;
            this.f6195f = str;
            this.f6196g = str2;
            this.f6197h = context;
            this.f6198i = jSONObject;
            this.f6199j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar != null && !fVar.f7267d) {
                    if (this.k.m(fVar, this.f6196g)) {
                        this.k.l(this.f6197h, this.f6198i, this.f6194e, this.f6195f, this.f6199j);
                        return;
                    } else {
                        this.f6194e.handleSchemeDispatchCallback(this.f6195f, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                boolean z = z.f6343b;
                c.a.r0.a.h2.c.d.o(10005, this.f6194e, this.f6195f);
                c.a.r0.a.n2.n.r(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements q0.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6200b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6201c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6202d;

        public b(n nVar, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, callbackHandler, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f6200b = str;
            this.f6201c = str2;
            this.f6202d = str3;
        }

        @Override // c.a.r0.a.z2.q0.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.handleSchemeDispatchCallback(this.f6200b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                c.a("open", this.f6201c, "confirm", this.f6202d);
            }
        }

        @Override // c.a.r0.a.z2.q0.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.handleSchemeDispatchCallback(this.f6200b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.f6201c, QueryResponse.Options.CANCEL, this.f6202d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                String str8 = "";
                if (a0 != null) {
                    str8 = c.a.r0.a.n2.n.n(a0.l());
                    str6 = a0.getAppId();
                    str7 = a0.Y();
                    str5 = a0.V().T();
                } else {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                }
                String a = c.a.r0.a.c1.a.n().a();
                eVar.a = str8;
                eVar.f8119b = str;
                eVar.f8122e = str2;
                eVar.f8123f = str6;
                eVar.f8120c = str5;
                eVar.a("appName", str7);
                eVar.a("hostName", a);
                eVar.a("hostVersion", q0.D());
                eVar.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                eVar.a("scheme", str4);
                c.a.r0.a.n2.b.i("2572", "90", eVar.f());
                if (z.f6343b) {
                    String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", eVar.f());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/openApp");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (!c.a.r0.a.c1.a.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else {
                JSONObject a2 = z.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                    return false;
                }
                String optString = a2.optString("cb");
                if (z.f6343b) {
                    String str = "params is " + a2.toString();
                }
                String optString2 = a2.optString("open", "");
                String optString3 = a2.optString("invokeFrom", "");
                c.a("invoke", optString3, null, optString2);
                if (optString2.startsWith(BaseWebViewActivity.SHOUBAI_SCHEME)) {
                    if (!c.a.r0.a.c1.a.a().c()) {
                        c.a.r0.a.c2.b.f.e.f(context, c.a.r0.a.h.swan_app_allow_baiduapp_open).G();
                        return false;
                    }
                    l(context, a2, callbackHandler, optString, optString3);
                } else {
                    eVar.d0().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, callbackHandler, str, str2) == null) {
            String optString = jSONObject.optString("open");
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                optString = Uri.decode(optString);
                c.a.r0.a.c1.a.P().a(optString, jSONObject.optJSONObject("extraParams"));
                if (z.f6343b) {
                    String str3 = "openUrl:" + optString;
                }
                z = o(context, optString, callbackHandler, str, str2);
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (z.f6343b) {
                String str4 = "open app result=" + z + "\nisNeedDownload=" + optBoolean;
            }
            if (!optBoolean) {
                if (z) {
                    return;
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
            } else if (z) {
            } else {
                boolean e2 = q0.e(context, jSONObject.optString("download"));
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(e2 ? 0 : 1001, e2 ? "下载APP成功" : "下载APP失败").toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(c.a.r0.a.h2.c.f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            if (fVar != null && !TextUtils.isEmpty(str)) {
                String T = c.a.r0.a.d2.d.J().r().V().T();
                if (TextUtils.isEmpty(T)) {
                    T = "NA";
                }
                JSONObject jSONObject = fVar.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (z.f6343b) {
                        String str2 = "source: " + T + " openUrl:" + str + " 配置数据:" + jSONObject;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    if (length > 0) {
                        boolean z = false;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (T.equals(optJSONArray.optString(i2))) {
                                z = true;
                            }
                        }
                        return z && n(str, optJSONArray2);
                    }
                    return n(str, optJSONArray2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jSONArray)) == null) {
            int length = jSONArray == null ? 0 : jSONArray.length();
            if (length > 0 && !TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < length; i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        String decode = Uri.decode(optString);
                        int indexOf = decode.indexOf(":");
                        if (indexOf > 0) {
                            decode = decode.substring(0, indexOf);
                        }
                        if (str.startsWith(decode)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(Context context, String str, CallbackHandler callbackHandler, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, str, callbackHandler, str2, str3)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            return q0.Z(context, str, new b(this, callbackHandler, str2, str3, str));
        }
        return invokeLLLLL.booleanValue;
    }
}
