package c.a.l0.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f3521b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public c(Context context) {
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

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f3521b == null) {
                synchronized (c.class) {
                    if (f3521b == null) {
                        f3521b = new c(context);
                    }
                }
            }
            return f3521b;
        }
        return (c) invokeL.objValue;
    }

    public String b(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String d2 = new c.a.l0.g.c(this.a, null).d(jSONObject, j);
                        if (!TextUtils.isEmpty(d2)) {
                            return d2;
                        }
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public final void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("1");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    a.f(this.a).C("k_retry_code_cm", optJSONArray.toString());
                } else {
                    a.f(this.a).C("k_retry_code_cm", "");
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("2");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    a.f(this.a).C("k_retry_code_cu", optJSONArray2.toString());
                } else {
                    a.f(this.a).C("k_retry_code_cu", "");
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("3");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    a.f(this.a).C("k_retry_code_ct", optJSONArray3.toString());
                    return;
                } else {
                    a.f(this.a).C("k_retry_code_ct", "");
                    return;
                }
            }
            a.f(this.a).C("k_retry_code_cm", "");
            a.f(this.a).C("k_retry_code_cu", "");
            a.f(this.a).C("k_retry_code_ct", "");
        }
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                try {
                    if (f()) {
                        return true;
                    }
                    c.a.l0.g.c cVar = new c.a.l0.g.c(this.a, null);
                    String b2 = cVar.b();
                    if (TextUtils.isEmpty(b2)) {
                        for (int i = 0; i < 3; i++) {
                            b2 = cVar.b();
                            if (!TextUtils.isEmpty(b2)) {
                                break;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(b2)) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    int optInt = jSONObject.optInt("0", -1);
                    if (optInt == 2) {
                        a.f(this.a).S(false);
                    } else {
                        a.f(this.a).S(true);
                    }
                    if (optInt == 1 || optInt == 3) {
                        return true;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("1");
                    if (optJSONObject == null) {
                        return false;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("yd_config");
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("app_id");
                        String optString2 = optJSONObject2.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            c.a.l0.d.d.k("cm", optString, optString2);
                        }
                        int optInt2 = optJSONObject2.optInt("status", -1);
                        if (optInt2 == 1) {
                            a.f(this.a).l(true);
                        } else if (optInt2 == 2) {
                            a.f(this.a).l(false);
                        }
                        a.f(this.a).Y(optJSONObject2.toString());
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
                    if (optJSONObject3 != null) {
                        String optString3 = optJSONObject3.optString("app_id");
                        String optString4 = optJSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            c.a.l0.d.d.k(Config.EXCEPTION_CRASH_TYPE, optString3, optString4);
                        }
                        int optInt3 = optJSONObject3.optInt("status", -1);
                        if (optInt3 == 1) {
                            a.f(this.a).w(true);
                        } else if (optInt3 == 2) {
                            a.f(this.a).w(false);
                        }
                        a.f(this.a).s(optJSONObject3.toString());
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
                    if (optJSONObject4 != null) {
                        String optString5 = optJSONObject4.optString("app_id");
                        String optString6 = optJSONObject4.optString(GameGuideConfigInfo.KEY_APP_KEY);
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            c.a.l0.d.d.k("cu", optString5, optString6);
                        }
                        int optInt4 = optJSONObject4.optInt("status", -1);
                        if (optInt4 == 1) {
                            a.f(this.a).D(true);
                        } else if (optInt4 == 2) {
                            a.f(this.a).D(false);
                        }
                        a.f(this.a).M(optJSONObject4.toString());
                    }
                    JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
                    if (optJSONObject5 != null) {
                        String optString7 = optJSONObject5.optString(GameGuideConfigInfo.KEY_APP_KEY, "");
                        String optString8 = optJSONObject5.optString("secret_key", "");
                        if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            c.a.l0.a.f3508b = optString7;
                            c.a.l0.a.f3509c = optString8;
                            a.f(this.a).H(optString7, optString8);
                        }
                    }
                    a.f(this.a).Q(optJSONObject.optString("encrypt_key", ""));
                    JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
                    if (optJSONObject6 != null) {
                        a.f(this.a).I("1".equals(optJSONObject6.optString("1", "1")));
                        a.f(this.a).y(optJSONObject6.optInt("2"));
                        a.f(this.a).N("1".equals(optJSONObject6.optString("3", "0")));
                        c(optJSONObject6.optJSONObject("4"));
                    }
                    a.f(this.a).j(jSONObject.optLong("3", 300L) * 1000);
                    a.f(this.a).P(System.currentTimeMillis());
                    return true;
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public String e(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, jSONObject, j)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String i = new c.a.l0.g.c(this.a, null).i(jSONObject, j);
                        if (!TextUtils.isEmpty(i)) {
                            return i;
                        }
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (System.currentTimeMillis() - a.f(this.a).i0() > a.f(this.a).E()) {
                    return false;
                }
                String o0 = a.f(this.a).o0();
                String O = a.f(this.a).O();
                String f0 = a.f(this.a).f0();
                if (TextUtils.isEmpty(o0) && TextUtils.isEmpty(O) && TextUtils.isEmpty(f0)) {
                    return false;
                }
                if (!TextUtils.isEmpty(o0)) {
                    JSONObject jSONObject = new JSONObject(o0);
                    String string = jSONObject.getString("app_id");
                    String string2 = jSONObject.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        c.a.l0.d.d.k("cm", string, string2);
                    }
                }
                if (!TextUtils.isEmpty(O)) {
                    JSONObject jSONObject2 = new JSONObject(O);
                    String string3 = jSONObject2.getString("app_id");
                    String string4 = jSONObject2.getString(GameGuideConfigInfo.KEY_APP_KEY);
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        c.a.l0.d.d.k(Config.EXCEPTION_CRASH_TYPE, string3, string4);
                    }
                }
                if (TextUtils.isEmpty(f0)) {
                    return true;
                }
                JSONObject jSONObject3 = new JSONObject(f0);
                String optString = jSONObject3.optString("app_id");
                String optString2 = jSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return true;
                }
                c.a.l0.d.d.k("cu", optString, optString2);
                return true;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
