package c.a.t0.z.b.j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.r0.a.k;
import c.a.r0.a.p.d.i;
import c.a.s0.a.g;
import c.a.s0.k0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
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
@Singleton
@Service
/* loaded from: classes9.dex */
public final class a implements i {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f26728b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.t0.z.b.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1554a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public C1554a(Context context) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471139790, "Lc/a/t0/z/b/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471139790, "Lc/a/t0/z/b/j/a;");
                return;
            }
        }
        a = k.a;
        f26728b = NewUrlSchemaHelper.SCHEME;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        String str5;
        String str6;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.isEmpty(next) || (opt = jSONObject.opt(next)) == null) {
                    return null;
                }
                String obj = opt.toString();
                sb.append(next + "=" + Uri.encode(obj) + "&");
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            if (TextUtils.equals(str3, "NA")) {
                str5 = "";
            } else {
                str5 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str5 + str4;
            }
            String str7 = f26728b;
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    str7 = str7 + str;
                }
            } else {
                String substring = str2.substring(1, str2.length());
                if (TextUtils.isEmpty(str)) {
                    str6 = str7 + substring;
                } else {
                    str6 = str7 + str + "/" + substring;
                }
                str7 = str6;
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
            String str8 = str7 + "?" + ((Object) sb2);
            if (a) {
                String str9 = "encodeParams: " + ((Object) sb2);
            }
            return str8;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return false;
            }
            if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
                Uri parse = Uri.parse(str);
                if (c.a.s0.a.g.c(parse)) {
                    c.a.s0.a.g.b().j(str, parse, new C1554a(context));
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

    @Override // c.a.r0.a.p.d.i
    public c.a.r0.a.u2.a a(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            if (context == null) {
                c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
                aVar.f("Context exception");
                return aVar;
            } else if (TextUtils.isEmpty(str5)) {
                return c(str5);
            } else {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "NA";
                }
                if ("icashwebview".equals(str4) && !StringUtils.isNull(str5)) {
                    try {
                        String optString = new JSONObject(str5).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            e(optString);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    c.a.r0.a.u2.a aVar2 = new c.a.r0.a.u2.a();
                    aVar2.f("invoke failed");
                    return aVar2;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    jSONObject.put("launchMode", "standard");
                    String b2 = b(str, str2, str3, str4, jSONObject);
                    boolean d2 = d(context, b2);
                    if (a) {
                        String str6 = "result = " + d2 + org.apache.commons.lang3.StringUtils.LF + "拼接后的uri is: " + b2;
                    }
                    if (d2) {
                        return null;
                    }
                    c.a.r0.a.u2.a aVar3 = new c.a.r0.a.u2.a();
                    aVar3.f("invoke failed");
                    return aVar3;
                } catch (JSONException e3) {
                    if (a) {
                        Log.getStackTraceString(e3);
                    }
                    return c(str5);
                }
            }
        }
        return (c.a.r0.a.u2.a) invokeCommon.objValue;
    }

    public final c.a.r0.a.u2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(5L);
            aVar.i(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
            sb.append(TextUtils.isEmpty(str) ? " empty" : "");
            sb.append(" parameter:");
            sb.append(str);
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            sb.append(" appId:");
            sb.append(c.a.r0.a.d2.d.J().getAppId());
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            sb.append(" curPage:");
            sb.append(c.a.r0.a.g1.f.U().T());
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            aVar.f(sb.toString());
            return aVar;
        }
        return (c.a.r0.a.u2.a) invokeL.objValue;
    }

    public final void e(String str) {
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
