package c.a.n0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
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

    /* renamed from: c.a.n0.a.e2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0164a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f5311a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5312b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f5313c;

        public /* synthetic */ b(boolean z, String str, JSONObject jSONObject, C0164a c0164a) {
            this(z, str, jSONObject);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("Result(%b):%s", Boolean.valueOf(this.f5312b), this.f5311a) : (String) invokeV.objValue;
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5311a = str == null ? "" : str;
            this.f5312b = z;
            this.f5313c = jSONObject;
        }
    }

    public a(Activity activity, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, Boolean.valueOf(z), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = activity;
        this.m = str;
        this.o = z;
    }

    @Override // c.a.n0.a.e2.c.j.h
    public SwanInterfaceType A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SwanInterfaceType.ACCREDIT_DATA : (SwanInterfaceType) invokeV.objValue;
    }

    @Override // c.a.n0.a.e2.c.j.h
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.J();
            c.a.n0.a.n1.q.c.a.f();
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public b Q(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONObject c2 = c.a.n0.a.e2.c.d.c(jSONObject);
            int optInt = c2.optInt("errno", 10001);
            if (optInt != 0) {
                if (11001 == optInt) {
                    c.a.n0.a.e2.c.d.l(c2);
                    c.a.n0.a.e2.c.d.s("Accredit", c2.toString());
                }
                if (c.a.n0.a.e2.c.c.f5244f) {
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

    @Override // c.a.n0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hVar)) == null) ? c.a.n0.a.c1.a.n().o(this.n, hVar.C()) : (HttpRequest) invokeL.objValue;
    }
}
