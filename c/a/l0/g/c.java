package c.a.l0.g;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import c.a.l0.d.i;
import c.a.l0.m.e;
import c.a.l0.m.g;
import c.a.l0.m.j;
import c.a.l0.m.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d f3634c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3626b = context;
        this.f3634c = d.a(context);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f3626b.getPackageName());
                jSONObject.put("6", c.a.l0.m.c.k(this.f3626b));
                jSONObject.put("7", j.a(this.f3626b));
                return c("q/1/qc", c.a.l0.m.c.c(this.f3626b, jSONObject, ""));
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                byte[] f2 = c.a.l0.m.c.f();
                String b2 = this.f3634c.b(str, URLEncoder.encode(Base64.encodeToString(e.h(f2, g.b(c.a.l0.m.d.a(this.f3626b)).getBytes()), 0)));
                if (TextUtils.isEmpty(b2)) {
                    return "";
                }
                String a = a(b2, this.f3634c.e(f2, jSONObject.toString()));
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                JSONObject jSONObject2 = new JSONObject(a);
                jSONObject2.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                String optString = jSONObject2.optString("skey");
                return new String(e.e(Base64.decode(jSONObject2.optString("data").getBytes(), 0), e.g(Base64.decode(optString.getBytes(), 0), g.b(c.a.l0.m.d.a(this.f3626b)).getBytes())));
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String d(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, j)) == null) {
            try {
                JSONObject f2 = f(true, false);
                f2.put("40", c.a.l0.h.a.c(this.f3626b, true, false, "login"));
                f2.put("41", c.a.l0.h.a.b(this.f3626b, "login"));
                f2.put("24", "");
                f2.put("73", i.c().f());
                if (i.c().i()) {
                    f2.put("50", k.a(this.f3626b));
                    f2.put("60", c.a.l0.h.a.h(this.f3626b, "login"));
                    Pair<Integer, String[]> d2 = k.d(this.f3626b);
                    if (d2 != null) {
                        f2.put(UVEventType.PAY_WALLET_BANNER_SHOW, d2.first);
                        String[] strArr = (String[]) d2.second;
                        if (strArr.length == 4) {
                            f2.put("14", strArr[0]);
                            f2.put("18", strArr[1]);
                            f2.put("15", strArr[2]);
                            f2.put("19", strArr[3]);
                        }
                    }
                }
                return c("q/1/qmini", c.a.l0.m.c.c(this.f3626b, e(f2, jSONObject), "1077102"));
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }

    public final JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, jSONObject2)) == null) {
            if (jSONObject == null && jSONObject2 == null) {
                return null;
            }
            if (jSONObject == null) {
                return jSONObject2;
            }
            if (jSONObject2 == null) {
                return jSONObject;
            }
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject f(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                g(jSONObject, "21", "");
                g(jSONObject, "22", "");
                g(jSONObject, "23", "");
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void g(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, jSONObject, str, str2) == null) || jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put(str, "");
            } else {
                jSONObject.put(str, str2);
            }
        } catch (Throwable th) {
            c.a.l0.m.c.d(th);
        }
    }

    public boolean h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            try {
                JSONObject f2 = f(false, true);
                f2.put("24", "");
                f2.put("40", c.a.l0.h.a.c(this.f3626b, false, true, "prelogin"));
                f2.put("41", c.a.l0.h.a.b(this.f3626b, "prelogin"));
                f2.put("27", c.a.l0.h.a.e(this.f3626b, "prelogin"));
                f2.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, c.a.l0.h.a.g(this.f3626b, "prelogin"));
                f2.put("60", c.a.l0.h.a.h(this.f3626b, "prelogin"));
                f2.put(BaseUtils.METHOD_SENDMESSAGE, String.valueOf(Build.VERSION.SDK_INT));
                f2.put("50", k.a(this.f3626b));
                Pair<Integer, String[]> d2 = k.d(this.f3626b);
                if (d2 != null) {
                    f2.put(UVEventType.PAY_WALLET_BANNER_SHOW, d2.first);
                    String[] strArr = (String[]) d2.second;
                    if (strArr.length == 4) {
                        f2.put("14", strArr[0]);
                        f2.put("18", strArr[1]);
                        f2.put("15", strArr[2]);
                        f2.put("19", strArr[3]);
                    }
                }
                JSONObject jSONObject2 = new JSONObject(c("q/1/qpre", c.a.l0.m.c.c(this.f3626b, e(f2, jSONObject), "1077104")));
                if (jSONObject2.optInt("0", 0) == 0) {
                    i.c().e(this.f3626b, jSONObject2);
                    return true;
                }
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String i(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, jSONObject, j)) == null) {
            try {
                return c("q/1/qv", c.a.l0.m.c.c(this.f3626b, e(f(true, false), jSONObject), ""));
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }
}
