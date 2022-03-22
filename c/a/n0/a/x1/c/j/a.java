package c.a.n0.a.x1.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends h<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String m;
    public final Activity n;
    public final boolean o;
    public final String p;

    /* renamed from: c.a.n0.a.x1.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0590a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7671b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f7672c;

        public /* synthetic */ b(boolean z, String str, JSONObject jSONObject, C0590a c0590a) {
            this(z, str, jSONObject);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.f7671b), this.a) : (String) invokeV.objValue;
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str == null ? "" : str;
            this.f7671b = z;
            this.f7672c = jSONObject;
        }
    }

    public a(Activity activity, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = activity;
        this.m = str;
        this.o = z;
        this.p = str2;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.I();
            c.a.n0.a.f1.r.c.a.f();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.x1.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: P */
    public b m(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            JSONObject c2 = c.a.n0.a.x1.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    c.a.n0.a.x1.c.d.m(c2);
                    c.a.n0.a.x1.c.d.t("Accredit", c2.toString());
                }
                if (c.a.n0.a.x1.c.c.f7628f) {
                    throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
                }
            }
            JSONObject jSONObject3 = c2.getJSONObject("data");
            String str = "";
            if (jSONObject3 != null) {
                str = jSONObject3.optString("code", "");
                jSONObject2 = jSONObject3.optJSONObject("opendata");
            } else {
                jSONObject2 = null;
            }
            return new b(this.o, str, jSONObject2, null);
        }
        return (b) invokeL.objValue;
    }

    @Override // c.a.n0.a.x1.c.c
    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", M().N());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GameGuideConfigInfo.KEY_APP_KEY, M().N());
                jSONObject2.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                jSONObject2.put("host_key_hash", c.a.n0.a.x1.c.d.g());
                String l = c.a.n0.a.s0.a.o().l();
                if (!TextUtils.isEmpty(l)) {
                    jSONObject2.put("host_api_key", l);
                }
                jSONObject.put("open", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("permit", Boolean.toString(this.o));
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(this.m, jSONObject3);
                jSONObject.put("accredits", jSONObject4);
                if (!TextUtils.isEmpty(this.p)) {
                    jSONObject.put("provider_appkey", this.p);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            v("data", jSONObject.toString());
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public HttpRequest w(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hVar)) == null) ? c.a.n0.a.s0.a.o().o(this.n, hVar.B()) : (HttpRequest) invokeL.objValue;
    }

    @Override // c.a.n0.a.x1.c.j.h
    public SwanInterfaceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? SwanInterfaceType.ACCREDIT_DATA : (SwanInterfaceType) invokeV.objValue;
    }
}
