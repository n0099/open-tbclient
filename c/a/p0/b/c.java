package c.a.p0.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.e.i;
import c.a.p0.k.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f4556b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4557c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes.dex */
    public class a extends c.a.p0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f4558f;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4558f = cVar;
        }

        @Override // c.a.p0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    String b2 = new c.a.p0.f.d(this.f4558f.a, null).b();
                    if (TextUtils.isEmpty(b2)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(b2);
                    if (jSONObject.optInt("0") == 0) {
                        c.f4557c = jSONObject.optInt("1") == 2;
                    }
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    public c(Context context) {
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

    public static c b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f4556b == null) {
                synchronized (c.class) {
                    if (f4556b == null) {
                        f4556b = new c(context);
                    }
                }
            }
            return f4556b;
        }
        return (c) invokeL.objValue;
    }

    public String c(JSONObject jSONObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, jSONObject, j2)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String d2 = new c.a.p0.f.d(this.a, null).d(jSONObject, j2);
                        if (!TextUtils.isEmpty(d2)) {
                            return d2;
                        }
                    }
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e.c().b(new a(this));
        }
    }

    public String e(JSONObject jSONObject, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, j2)) == null) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.length() != 0) {
                        String j3 = new c.a.p0.f.d(this.a, null).j(jSONObject, j2);
                        if (!TextUtils.isEmpty(j3)) {
                            return j3;
                        }
                    }
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
            return "";
        }
        return (String) invokeLJ.objValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                try {
                    if (g()) {
                        return true;
                    }
                    c.a.p0.f.d dVar = new c.a.p0.f.d(this.a, null);
                    String i2 = dVar.i();
                    if (TextUtils.isEmpty(i2)) {
                        for (int i3 = 0; i3 < 3; i3++) {
                            i2 = dVar.i();
                            if (!TextUtils.isEmpty(i2)) {
                                break;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(i2)) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(i2);
                    int optInt = jSONObject.optInt("0", -1);
                    if (optInt == 2) {
                        c.a.p0.b.a.h(this.a).N(false);
                    } else {
                        c.a.p0.b.a.h(this.a).N(true);
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
                        String optString2 = optJSONObject2.optString("app_key");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            i.j("cm", optString, optString2);
                        }
                        int optInt2 = optJSONObject2.optInt("status", -1);
                        if (optInt2 == 1) {
                            c.a.p0.b.a.h(this.a).n(true);
                        } else if (optInt2 == 2) {
                            c.a.p0.b.a.h(this.a).n(false);
                        }
                        c.a.p0.b.a.h(this.a).Y(optJSONObject2.toString());
                    }
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("dx_config");
                    if (optJSONObject3 != null) {
                        String optString3 = optJSONObject3.optString("app_id");
                        String optString4 = optJSONObject3.optString("app_key");
                        if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                            i.j("ct", optString3, optString4);
                        }
                        int optInt3 = optJSONObject3.optInt("status", -1);
                        if (optInt3 == 1) {
                            c.a.p0.b.a.h(this.a).x(true);
                        } else if (optInt3 == 2) {
                            c.a.p0.b.a.h(this.a).x(false);
                        }
                        c.a.p0.b.a.h(this.a).B(optJSONObject3.toString());
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("lt_config");
                    if (optJSONObject4 != null) {
                        String optString5 = optJSONObject4.optString("app_id");
                        String optString6 = optJSONObject4.optString("app_key");
                        if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            i.j(k.f33808b, optString5, optString6);
                        }
                        int optInt4 = optJSONObject4.optInt("status", -1);
                        if (optInt4 == 1) {
                            c.a.p0.b.a.h(this.a).D(true);
                        } else if (optInt4 == 2) {
                            c.a.p0.b.a.h(this.a).D(false);
                        }
                        c.a.p0.b.a.h(this.a).Q(optJSONObject4.toString());
                    }
                    JSONObject optJSONObject5 = optJSONObject.optJSONObject("auto_config");
                    if (optJSONObject5 != null) {
                        String optString7 = optJSONObject5.optString("app_key", "");
                        String optString8 = optJSONObject5.optString("secret_key", "");
                        if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            c.a.p0.a.f4539b = optString7;
                            c.a.p0.a.f4540c = optString8;
                            c.a.p0.b.a.h(this.a).C(optString7, optString8);
                        }
                    }
                    c.a.p0.b.a.h(this.a).U(optJSONObject.optString("encrypt_key", ""));
                    JSONObject optJSONObject6 = jSONObject.optJSONObject("a_setting");
                    if (optJSONObject6 != null) {
                        if ("1".equals(optJSONObject6.optString("1", "1"))) {
                            c.a.p0.b.a.h(this.a).I(true);
                        } else {
                            c.a.p0.b.a.h(this.a).I(false);
                        }
                        c.a.p0.b.a.h(this.a).z(optJSONObject6.optInt("2"));
                    }
                    c.a.p0.b.a.h(this.a).l(jSONObject.optLong("3", 300L) * 1000);
                    c.a.p0.b.a.h(this.a).P(System.currentTimeMillis());
                    return true;
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (System.currentTimeMillis() - c.a.p0.b.a.h(this.a).i0() > c.a.p0.b.a.h(this.a).E()) {
                    return false;
                }
                String o0 = c.a.p0.b.a.h(this.a).o0();
                String S = c.a.p0.b.a.h(this.a).S();
                String f0 = c.a.p0.b.a.h(this.a).f0();
                if (TextUtils.isEmpty(o0) && TextUtils.isEmpty(S) && TextUtils.isEmpty(f0)) {
                    return false;
                }
                if (!TextUtils.isEmpty(o0)) {
                    JSONObject jSONObject = new JSONObject(o0);
                    String string = jSONObject.getString("app_id");
                    String string2 = jSONObject.getString("app_key");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        i.j("cm", string, string2);
                    }
                }
                if (!TextUtils.isEmpty(S)) {
                    JSONObject jSONObject2 = new JSONObject(S);
                    String string3 = jSONObject2.getString("app_id");
                    String string4 = jSONObject2.getString("app_key");
                    if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                        i.j("ct", string3, string4);
                    }
                }
                if (TextUtils.isEmpty(f0)) {
                    return true;
                }
                JSONObject jSONObject3 = new JSONObject(f0);
                String optString = jSONObject3.optString("app_id");
                String optString2 = jSONObject3.optString("app_key");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return true;
                }
                i.j(k.f33808b, optString, optString2);
                return true;
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
