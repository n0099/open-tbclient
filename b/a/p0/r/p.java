package b.a.p0.r;

import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final p f11528a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-578726830, "Lb/a/p0/r/p$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-578726830, "Lb/a/p0/r/p$b;");
                    return;
                }
            }
            f11528a = new p(null);
        }
    }

    public /* synthetic */ p(a aVar) {
        this();
    }

    public static p b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f11528a : (p) invokeV.objValue;
    }

    public Flow a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i2)) == null) {
            if (b.a.h0.b.a.a.g()) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return n.f().a(str, str2, i2);
            }
            return d(str, r.b(str2), i2);
        }
        return (Flow) invokeLLI.objValue;
    }

    public final IRemoteUBCService c() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e.f() : (IRemoteUBCService) invokeV.objValue;
    }

    public final Flow d(String str, String str2, int i2) {
        Flow flow;
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2)) == null) {
            try {
                flow = c().ubcBeginFlow(str, str2, i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                flow = null;
            }
            return flow == null ? new Flow() : flow;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void e(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, str, str2, i2) == null) {
            if (b.a.h0.b.a.a.g()) {
                if (e.g() == null && TextUtils.isEmpty(str)) {
                    return;
                }
                n.f().j(str, str2, i2);
                return;
            }
            try {
                c().ubcOnEvent(str, r.b(str2), i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f(String str, Map<String, String> map, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, str, map, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
            }
            e(str, jSONObject.toString(), i2);
        }
    }

    public void g(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, str, jSONObject, i2) == null) {
            if (b.a.h0.b.a.a.g()) {
                if (e.g() == null && TextUtils.isEmpty(str)) {
                    return;
                }
                n.f().k(str, jSONObject, i2);
                return;
            }
            try {
                c().ubcOnEvent(str, r.c(jSONObject), i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n.f().q();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            n.f().l();
        }
    }

    public final void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            e(str, "", 0);
        }
    }

    public p() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
