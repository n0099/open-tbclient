package b.a.p0.c.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.q.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.LightappConstants;
import okhttp3.Callback;
import org.json.JSONObject;
@Service
/* loaded from: classes.dex */
public class c implements b.a.p0.a.p.d.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10126a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1008600358, "Lb/a/p0/c/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1008600358, "Lb/a/p0/c/a/c;");
                return;
            }
        }
        f10126a = k.f6863a;
    }

    public c() {
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

    @Override // b.a.p0.a.p.d.d
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            d.b().c(bArr);
        }
    }

    @Override // b.a.p0.a.p.d.d
    public <T> void e(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, responseCallback) == null) {
            new b.a.p0.c.a.k.b().q(str, str2, responseCallback);
        }
    }

    @Override // b.a.p0.a.p.d.d
    public void f(String str, String str2, a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, cVar) == null) {
            new b.a.p0.c.a.k.a().k(str, str2, cVar);
        }
    }

    @Override // b.a.p0.a.p.d.d
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? d.b().e(str) : invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.d.d
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? d.b().d() : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.d.d
    public boolean i(@NonNull b.a.p0.a.d2.e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2, Callback callback, b.a.p0.a.z2.g1.c<String> cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{eVar, jSONObject, str, str2, callback, cVar})) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject == null || !optJSONObject.optBoolean("enableBdtls", false)) {
                return false;
            }
            String optString = optJSONObject.optString(LightappConstants.ACCESS_WALLET_SERVICE_PARAM_SERVICE);
            if (TextUtils.isEmpty(optString)) {
                boolean z = f10126a;
                if (cVar != null) {
                    cVar.onCallback("serviceId is invalid");
                    return true;
                }
                return true;
            }
            n.D(str, eVar.X().G(), null, str2);
            new b.a.p0.c.a.k.d(eVar, jSONObject, str2, callback).o(optString);
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
