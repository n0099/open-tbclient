package b.a.r0.v.b.i;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.k;
import b.a.p0.a.p.d.i;
import b.a.q0.a.g;
import b.a.q0.j0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
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
/* loaded from: classes5.dex */
public final class a implements i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f25651a;

    /* renamed from: b  reason: collision with root package name */
    public static String f25652b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.r0.v.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1249a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f25653a;

        public C1249a(Context context) {
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
            this.f25653a = context;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(b.a.q0.a.g.A) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f25653a, null, (String) hashMap.get(b.a.q0.a.g.A), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(881186864, "Lb/a/r0/v/b/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(881186864, "Lb/a/r0/v/b/i/a;");
                return;
            }
        }
        f25651a = k.f6863a;
        f25652b = NewUrlSchemaHelper.SCHEME;
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
            if (TextUtils.equals(str3, AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA)) {
                str5 = "";
            } else {
                str5 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str5 + str4;
            }
            String str7 = f25652b;
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
            if (f25651a) {
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
                if (b.a.q0.a.g.c(parse)) {
                    b.a.q0.a.g.b().j(str, parse, new C1249a(context));
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

    @Override // b.a.p0.a.p.d.i
    public b.a.p0.a.u2.a a(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            if (context == null) {
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.f("Context exception");
                return aVar;
            } else if (TextUtils.isEmpty(str5)) {
                return c(str5);
            } else {
                if (TextUtils.isEmpty(str3)) {
                    str3 = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
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
                    b.a.p0.a.u2.a aVar2 = new b.a.p0.a.u2.a();
                    aVar2.f("invoke failed");
                    return aVar2;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    jSONObject.put("launchMode", "standard");
                    String b2 = b(str, str2, str3, str4, jSONObject);
                    boolean d2 = d(context, b2);
                    if (f25651a) {
                        String str6 = "result = " + d2 + org.apache.commons.lang3.StringUtils.LF + "拼接后的uri is: " + b2;
                    }
                    if (d2) {
                        return null;
                    }
                    b.a.p0.a.u2.a aVar3 = new b.a.p0.a.u2.a();
                    aVar3.f("invoke failed");
                    return aVar3;
                } catch (JSONException e3) {
                    if (f25651a) {
                        Log.getStackTraceString(e3);
                    }
                    return c(str5);
                }
            }
        }
        return (b.a.p0.a.u2.a) invokeCommon.objValue;
    }

    public final b.a.p0.a.u2.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(5L);
            aVar.i(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
            sb.append(TextUtils.isEmpty(str) ? " empty" : "");
            sb.append(" parameter:");
            sb.append(str);
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            sb.append(" appId:");
            sb.append(b.a.p0.a.d2.d.J().getAppId());
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            sb.append(" curPage:");
            sb.append(b.a.p0.a.g1.f.U().T());
            sb.append(org.apache.commons.lang3.StringUtils.LF);
            aVar.f(sb.toString());
            return aVar;
        }
        return (b.a.p0.a.u2.a) invokeL.objValue;
    }

    public final void e(String str) {
        b.a.p0.a.d2.e L;
        b.a.p0.a.y1.c.e.a z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (L = b.a.p0.a.d2.e.L()) == null || (z = L.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.V(bundle, c.class);
    }
}
