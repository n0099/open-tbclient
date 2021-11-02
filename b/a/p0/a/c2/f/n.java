package b.a.p0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
public class n extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4348g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f4349h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4350i;
        public final /* synthetic */ String j;
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
            this.f4346e = callbackHandler;
            this.f4347f = str;
            this.f4348g = str2;
            this.f4349h = context;
            this.f4350i = jSONObject;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar != null && !fVar.f4907d) {
                    if (this.k.m(fVar, this.f4348g)) {
                        this.k.l(this.f4349h, this.f4350i, this.f4346e, this.f4347f, this.j);
                        return;
                    } else {
                        this.f4346e.handleSchemeDispatchCallback(this.f4347f, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                boolean z = a0.f4160b;
                b.a.p0.a.e2.c.d.n(10005, this.f4346e, this.f4347f);
                b.a.p0.a.j2.k.p(10005, fVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements q0.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4351a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f4352b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4353c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f4354d;

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
            this.f4351a = callbackHandler;
            this.f4352b = str;
            this.f4353c = str2;
            this.f4354d = str3;
        }

        @Override // b.a.p0.a.v2.q0.g
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f4351a.handleSchemeDispatchCallback(this.f4352b, UnitedSchemeUtility.wrapCallbackParams(z ? 0 : 1001, z ? "打开APP成功" : "打开APP失败，本地没有安装").toString());
                c.a("open", this.f4353c, "confirm", this.f4354d);
            }
        }

        @Override // b.a.p0.a.v2.q0.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f4351a.handleSchemeDispatchCallback(this.f4352b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.f4353c, QueryResponse.Options.CANCEL, this.f4354d);
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
                b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                String str8 = "";
                if (P != null) {
                    str8 = b.a.p0.a.j2.k.m(P.l());
                    str6 = P.getAppId();
                    str7 = P.N();
                    str5 = P.K().S();
                } else {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                }
                String a2 = b.a.p0.a.c1.a.m().a();
                eVar.f6383a = str8;
                eVar.f6384b = str;
                eVar.f6387e = str2;
                eVar.f6388f = str6;
                eVar.f6385c = str5;
                eVar.a("appName", str7);
                eVar.a("hostName", a2);
                eVar.a("hostVersion", q0.D());
                eVar.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                eVar.a("scheme", str4);
                b.a.p0.a.j2.b.i("2572", "90", eVar.f());
                if (a0.f4160b) {
                    String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", eVar.f());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                return false;
            }
            String optString = a2.optString("cb");
            if (a0.f4160b) {
                String str = "params is " + a2.toString();
            }
            String optString2 = a2.optString("open", "");
            String optString3 = a2.optString("invokeFrom", "");
            c.a("invoke", optString3, null, optString2);
            eVar.S().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
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
                b.a.p0.a.c1.a.K().a(optString, jSONObject.optJSONObject("extraParams"));
                if (a0.f4160b) {
                    String str3 = "openUrl:" + optString;
                }
                z = o(context, optString, callbackHandler, str, str2);
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (a0.f4160b) {
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

    public final boolean m(b.a.p0.a.e2.c.f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, fVar, str)) == null) {
            if (fVar != null && !TextUtils.isEmpty(str)) {
                String S = b.a.p0.a.a2.d.g().r().K().S();
                if (TextUtils.isEmpty(S)) {
                    S = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                }
                JSONObject jSONObject = fVar.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (a0.f4160b) {
                        String str2 = "source: " + S + " openUrl:" + str + " 配置数据:" + jSONObject;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    int length = optJSONArray == null ? 0 : optJSONArray.length();
                    if (length > 0) {
                        boolean z = false;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (S.equals(optJSONArray.optString(i2))) {
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
            return q0.W(context, str, new b(this, callbackHandler, str2, str3, str));
        }
        return invokeLLLLL.booleanValue;
    }
}
