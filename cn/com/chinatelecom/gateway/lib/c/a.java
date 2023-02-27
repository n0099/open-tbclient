package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "a";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1293515452, "Lcn/com/chinatelecom/gateway/lib/c/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1293515452, "Lcn/com/chinatelecom/gateway/lib/c/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Context context, String str, String str2, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, network)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if ((optInt == 0 || optInt == 30002) && !TextUtils.isEmpty(optString)) {
                    String c = cn.com.chinatelecom.gateway.lib.a.a.c(optString, str2);
                    if (!TextUtils.isEmpty(c)) {
                        try {
                            jSONObject.put("data", new JSONObject(c));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject.put("data", c);
                        }
                        if (optInt == 30002) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = ((JSONObject) jSONObject.opt("data")).optJSONArray("urls");
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    arrayList.add(optJSONArray.getString(i));
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return null;
                            }
                            return a(context, arrayList, str2, network);
                        }
                        return jSONObject.toString();
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                CtAuth.warn(a, "decryptResult error", th);
                return null;
            }
        }
        return (String) invokeLLLL.objValue;
    }

    public static String a(Context context, List list, String str, Network network) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, list, str, network)) != null) {
            return (String) invokeLLLL.objValue;
        }
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                return null;
            }
            try {
                String str2 = (String) list.get(i);
                if (!TextUtils.isEmpty((CharSequence) list.get(i)) && context != null && Build.VERSION.SDK_INT < 21) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        ((Boolean) Class.forName("android.net.ConnectivityManager").getMethod("requestRouteToHost", Integer.TYPE, Integer.TYPE).invoke(connectivityManager, 5, Integer.valueOf(j.a(j.b(str2))))).booleanValue();
                    }
                }
                String a2 = a(h.a((String) list.get(i), network), str);
                try {
                    JSONObject jSONObject = TextUtils.isEmpty(a2) ? null : new JSONObject(a2);
                    if (jSONObject != null && jSONObject.getInt("result") == 0) {
                        return a2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            i++;
        }
    }

    public static /* synthetic */ String a(a aVar, Context context, String str, String str2, String str3, Network network, String str4, String str5) {
        String b = b();
        String a2 = n.a(context, str, str2, str3, b);
        String str6 = a;
        CtAuth.info(str6, "request params : " + a2);
        String a3 = h.a(context, "https://id6.me/auth/preauth.do", a2, network, str4, str5);
        String str7 = a;
        CtAuth.info(str7, "request result : " + a3);
        String a4 = a(context, a3, b, network);
        if (TextUtils.isEmpty(a4)) {
            return "{\"result\":80001,\"msg\":\"请求异常\"}";
        }
        cn.com.chinatelecom.gateway.lib.b.d.a(str5, a4, a2);
        return a4;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result");
                String optString = jSONObject.optString("data");
                if (optInt == 0 && !TextUtils.isEmpty(optString)) {
                    String c = cn.com.chinatelecom.gateway.lib.a.a.c(optString, str2);
                    if (!TextUtils.isEmpty(c)) {
                        try {
                            jSONObject.put("data", new JSONObject(c));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject.put("data", c);
                        }
                    }
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                CtAuth.warn(a, "decryptResult error", th);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    private void a(Context context, String str, r rVar, int i, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, str, rVar, Integer.valueOf(i), preCodeListener}) == null) {
            q.a();
            e eVar = new e(this, q.b(rVar), i, rVar, str, context, preCodeListener);
            q.a();
            q.a(eVar);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                String uuid = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(uuid)) {
                    return "";
                }
                String replace = uuid.replace("-", "");
                return replace.length() >= 16 ? replace.substring(0, 16) : replace;
            } catch (Throwable th) {
                CtAuth.warn(a, "generateAesKey error", th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public final void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048576, this, context, str, str2, str3, preCodeListener) == null) {
            int i = CtAuth.mTotalTimeout;
            int i2 = i <= 0 ? 10000 : i;
            String a2 = g.a();
            String a3 = g.a(context);
            cn.com.chinatelecom.gateway.lib.b.d.a(a2).a(str).b(a3).d("preauth").c(cn.com.chinatelecom.gateway.lib.b.a.g(context)).i(context.getPackageName());
            a(context, a2, new b(this, context, str, str2, str3, a3, a2, preCodeListener), i2, preCodeListener);
        }
    }

    public final void b(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3, preCodeListener) == null) {
            int i = CtAuth.mTotalTimeout;
            int i2 = i <= 0 ? 10000 : i;
            String a2 = g.a();
            String a3 = g.a(context);
            cn.com.chinatelecom.gateway.lib.b.d.a(a2).a(str).b(a3).d("preauth").c(cn.com.chinatelecom.gateway.lib.b.a.g(context)).i(context.getPackageName());
            if (Build.VERSION.SDK_INT < 21) {
                a(context, a2, new d(this, context, str, str2, str3, a3, a2, preCodeListener), i2, preCodeListener);
                return;
            }
            j jVar = new j();
            jVar.a(context, new c(this, a2, context, str, str2, str3, a3, preCodeListener));
            k kVar = new k(jVar, i2);
            q.a();
            q.a(kVar);
        }
    }
}
