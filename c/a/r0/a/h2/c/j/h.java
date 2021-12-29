package c.a.r0.a.h2.c.j;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class h<ResultDataT> extends c.a.r0.a.h2.c.c<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f7334g;

    /* renamed from: h  reason: collision with root package name */
    public String f7335h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f7336i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f7337j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f7338k;
    public String l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f7339e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7339e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = c.a.r0.a.h2.c.c.f7262f;
                this.f7339e.D();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f7340b;

        public b(h hVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7340b = hVar;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.f7340b.E()) {
                    this.f7340b.N(this.a);
                } else {
                    this.f7340b.H(this.a, exc);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f7340b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpRequest a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f7341b;

        public c(h hVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7341b = hVar;
            this.a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                c.a.r0.a.e0.d.i("OAuthRequest", "retryRequest fail: ");
                this.f7341b.H(this.a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                c.a.r0.a.e0.d.i("OAuthRequest", "retryRequest success: ");
                this.f7341b.J(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7342e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f7343f;

        public d(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7343f = hVar;
            this.f7342e = str;
        }

        @Override // c.a.r0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f7343f.p();
                    this.f7343f.call();
                    return;
                }
                this.f7343f.C(null, this.f7342e);
            }
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7334g = new HashMap();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public Map<String, String> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7334g : (Map) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void C(Response response, String str) {
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, response, str) == null) {
            this.f7335h = str;
            try {
                JSONObject jSONObject = new JSONObject(this.f7335h);
                this.f7336i = jSONObject;
                optInt = jSONObject.optInt("errno");
            } catch (OAuthException e2) {
                G(e2.mErrorCode, str, response);
                d(e2);
            } catch (Exception e3) {
                c.a.r0.a.h2.c.d.k(e3.toString(), Boolean.TRUE);
                L(str, e3);
                G(2103, str, response);
                d(new OAuthException(10005));
                n.r(10005, null);
            }
            if ((this.f7337j && optInt == 402) || (this.f7338k && optInt == 401)) {
                this.f7337j = false;
                this.f7338k = false;
                if (SwanAppAllianceLoginHelper.f39956d.f()) {
                    SwanAppAllianceLoginHelper.f39956d.b();
                }
                O(str);
            } else if (F(optInt)) {
                if (SwanAppAllianceLoginHelper.f39956d.f()) {
                    SwanAppAllianceLoginHelper.f39956d.b();
                    O(str);
                } else if (c.a.r0.a.h2.c.c.f7262f) {
                    throw new RuntimeException("is not AllianceLogin, error number");
                }
            } else {
                if (response != null && optInt != 0) {
                    G(optInt, str, response);
                }
                r(m(this.f7336i));
                I();
                c();
            }
        }
    }

    public final void D() {
        HttpRequest w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (w = w(this)) == null) {
            return;
        }
        w.executeAsync(new b(this, w));
        c.a.r0.a.n2.t.a.a(z());
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 == 600101 || i2 == 600102 || i2 == 600103 || i2 == 402 || i2 == 401 : invokeI.booleanValue;
    }

    public final void G(int i2, String str, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i2, str, response) == null) {
            c.a.r0.a.n2.t.a.c(z(), i2, str, response);
        }
    }

    public void H(HttpRequest httpRequest, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, httpRequest, exc) == null) {
            c.a.r0.a.h2.c.d.k(exc.toString(), Boolean.FALSE);
            c.a.r0.a.n2.t.a.b(z(), 2101, httpRequest.getOkRequest() == null ? null : httpRequest.getOkRequest().url().toString(), null, exc.getMessage());
            d(new OAuthException(10002));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void J(Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, response) == null) {
            if (!response.isSuccessful()) {
                c.a.r0.a.h2.c.d.k("bad response", Boolean.TRUE);
                G(2104, null, null);
                d(new OAuthException(10002));
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                c.a.r0.a.h2.c.d.k("empty response body", Boolean.TRUE);
                G(2103, null, null);
                d(new OAuthException(10001));
                return;
            }
            try {
                C(response, body.string());
            } catch (IOException e2) {
                if (c.a.r0.a.h2.c.c.f7262f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public final void L(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, exc) == null) {
            if (this.f7336i == null) {
                c.a.r0.a.h2.c.d.t("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
                return;
            }
            c.a.r0.a.h2.c.d.t("OAuthRequest", "ex: " + exc.toString());
        }
    }

    @NonNull
    @SuppressLint({"BDThrowableCheck"})
    public c.a.r0.a.d2.e M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
            if (L == null) {
                if (!c.a.r0.a.h2.c.c.f7262f) {
                    return c.a.r0.a.d2.d.J().r();
                }
                throw new IllegalStateException("null SwanApp");
            }
            return L;
        }
        return (c.a.r0.a.d2.e) invokeV.objValue;
    }

    public void N(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, httpRequest) == null) {
            c.a.r0.a.e0.d.i("OAuthRequest", "retryRequest: " + httpRequest.toString());
            K();
            httpRequest.executeAsync(new c(this, httpRequest));
        }
    }

    public final void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            M().M().f(c.a.r0.a.g1.f.U().getActivity(), null, new d(this, str));
        }
    }

    @Override // c.a.r0.a.h2.c.c
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "OAuthRequest-onExec", 2);
        }
    }

    @Override // c.a.r0.a.h2.c.c
    public c.a.r0.a.h2.c.c<ResultDataT> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = "loginApi";
            } else {
                this.l = str;
            }
            super.q(str);
            return this;
        }
        return (c.a.r0.a.h2.c.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            i<ResultDataT> iVar = this.a;
            return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), e(), Integer.valueOf(this.a.b()), this.f7335h, this.f7336i, iVar.a, iVar.a());
        }
        return (String) invokeV.objValue;
    }

    public h<ResultDataT> v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            this.f7334g.put(str, str2);
            return this;
        }
        return (h) invokeLL.objValue;
    }

    public abstract HttpRequest w(h hVar);

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f7338k = true;
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f7337j = true;
        }
    }

    public abstract SwanInterfaceType z();
}
