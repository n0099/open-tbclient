package c.a.t0.z.b.j;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.z2.w;
import c.a.s0.a.g;
import c.a.s0.k0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
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
/* loaded from: classes9.dex */
public class d extends z {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f26729d = "com.baidu.tieba://";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f26730c;

    /* loaded from: classes9.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f26731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f26732f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f26733g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f26734h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f26735i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f26736j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ String f26737k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f26731e = callbackHandler;
            this.f26732f = context;
            this.f26733g = str;
            this.f26734h = str2;
            this.f26735i = str3;
            this.f26736j = str4;
            this.f26737k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.r0.a.h2.c.d.h(iVar)) {
                    c.a.r0.a.h2.c.d.q(iVar, this.f26731e, this.l.f26730c);
                } else if (!this.l.l(this.f26732f, this.f26733g, this.f26734h, this.f26735i, this.f26736j, this.f26737k)) {
                    c.a.r0.a.e0.d.c("PageTransitionAction", "page transition fail");
                    this.f26731e.handleSchemeDispatchCallback(this.l.f26730c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    c.a.r0.a.e0.d.i("PageTransitionAction", "page transition success");
                    this.f26731e.handleSchemeDispatchCallback(this.l.f26730c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements g.b {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // c.a.s0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(c.a.s0.a.g.B) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a, null, (String) hashMap.get(c.a.s0.a.g.B), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1471139883, "Lc/a/t0/z/b/j/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1471139883, "Lc/a/t0/z/b/j/d;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c.a.r0.a.f2.e eVar) {
        super(eVar, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                String str8 = f26729d;
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
                if (z.f6340b) {
                    String str10 = "encodeParams: " + ((Object) sb2);
                }
                return str9;
            } catch (JSONException e2) {
                if (z.f6340b) {
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
                if (c.a.s0.a.g.c(parse)) {
                    c.a.s0.a.g.b().j(str, parse, new b(context));
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
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
            this.f26730c = optString;
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
                if (z.f6340b) {
                    e2.printStackTrace();
                }
            }
            eVar.d0().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
            c.a.r0.a.e0.d.i("PageTransitionAction", "callback success");
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
                if (z.f6340b) {
                    String str7 = "result = " + z + org.apache.commons.lang3.StringUtils.LF + "拼接后的uri is: " + str6;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void o(String str) {
        c.a.r0.a.d2.e L;
        c.a.r0.a.y1.c.e.a z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (L = c.a.r0.a.d2.e.L()) == null || (z = L.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.V(bundle, c.class);
    }
}
