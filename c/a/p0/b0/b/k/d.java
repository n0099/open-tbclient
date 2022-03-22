package c.a.p0.b0.b.k;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.w;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import c.a.o0.j0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends z {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f12450d = "com.baidu.tieba://";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f12451c;

    /* loaded from: classes2.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f12452b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12453c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f12454d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12455e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12456f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12457g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f12458h;

        public a(d dVar, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12458h = dVar;
            this.a = callbackHandler;
            this.f12452b = context;
            this.f12453c = str;
            this.f12454d = str2;
            this.f12455e = str3;
            this.f12456f = str4;
            this.f12457g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.x1.c.d.h(iVar)) {
                    c.a.n0.a.x1.c.d.q(iVar, this.a, this.f12458h.f12451c);
                } else if (!this.f12458h.l(this.f12452b, this.f12453c, this.f12454d, this.f12455e, this.f12456f, this.f12457g)) {
                    c.a.n0.a.u.d.c("PageTransitionAction", "page transition fail");
                    this.a.handleSchemeDispatchCallback(this.f12458h.f12451c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    c.a.n0.a.u.d.i("PageTransitionAction", "page transition success");
                    this.a.handleSchemeDispatchCallback(this.f12458h.f12451c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements BdUniDispatchSchemeController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_URL) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a, null, (String) hashMap.get(BdUniDispatchSchemeController.PARAM_URL), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-889268224, "Lc/a/p0/b0/b/k/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-889268224, "Lc/a/p0/b0/b/k/d;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4, str5)) == null) {
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject = new JSONObject(str5);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (TextUtils.isEmpty(next)) {
                        return null;
                    }
                    String obj = jSONObject.opt(next).toString();
                    sb.append(next + "=" + Uri.encode(obj) + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    str4 = "/" + str4;
                }
                if (TextUtils.equals(str3, "NA")) {
                    str6 = "";
                } else {
                    str6 = "/" + str3;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = str6 + str4;
                }
                String str8 = f12450d;
                if (TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        str8 = str8 + str;
                    }
                } else {
                    String substring = str2.substring(1, str2.length());
                    if (TextUtils.isEmpty(str)) {
                        str7 = str8 + substring;
                    } else {
                        str7 = str8 + str + "/" + substring;
                    }
                    str8 = str7;
                }
                StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
                String str9 = str8 + "?" + ((Object) sb2);
                if (z.f6924b) {
                    Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
                }
                return str9;
            } catch (JSONException e2) {
                if (z.f6924b) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLLLL.objValue;
    }

    public static boolean n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
                Uri parse = Uri.parse(str);
                if (BdUniDispatchSchemeController.isUniScheme(parse)) {
                    BdUniDispatchSchemeController.getInstance().parseWebViewScheme(str, parse, new b(context));
                } else {
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context);
                    tbWebViewActivityConfig.setUri(parse);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
                return true;
            }
            if (!TextUtils.isEmpty(str) && str.contains("com.baidu.tieba")) {
                Uri parse2 = Uri.parse(str);
                if ("miniapp".equals(parse2.getAuthority()) && "/goods".equals(parse2.getPath())) {
                    h.i(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                    return true;
                }
            }
            return UtilHelper.dealOneScheme(context, str);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                return false;
            }
            JSONObject d2 = w.d(param);
            String optString = d2.optString("cb");
            this.f12451c = optString;
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString2 = d2.optString("authority");
            String optString3 = d2.optString("path");
            String optString4 = d2.optString("module", "NA");
            String optString5 = d2.optString("action");
            JSONObject optJSONObject = d2.optJSONObject("scheme");
            try {
                optJSONObject.put("launchMode", "standard");
            } catch (JSONException e2) {
                if (z.f6924b) {
                    e2.printStackTrace();
                }
            }
            eVar.d0().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
            c.a.n0.a.u.d.i("PageTransitionAction", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean l(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str5) && context != null) {
                String str6 = null;
                if (str3.hashCode() == -330473854) {
                    str3.equals("anything");
                }
                if ("icashwebview".equals(str4)) {
                    if (!StringUtils.isNull(str5)) {
                        try {
                            String optString = new JSONObject(str5).optString("url");
                            if (!StringUtils.isNull(optString)) {
                                o(optString);
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    str6 = m(str, str2, str3, str4, str5);
                    z = n(context, str6);
                }
                if (z.f6924b) {
                    Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void o(String str) {
        c.a.n0.a.t1.e L;
        c.a.n0.a.o1.c.e.a z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (L = c.a.n0.a.t1.e.L()) == null || (z = L.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.V(bundle, c.class);
    }
}
