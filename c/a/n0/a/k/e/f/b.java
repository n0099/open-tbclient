package c.a.n0.a.k.e.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.s1.b.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new c.a.n0.a.k.h.b(1001, "context not support");
            }
            c.a.n0.a.x.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new c.a.n0.a.k.h.b(1001, "none fragmentManger");
            }
            c.a.n0.a.x.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0451a)) {
                return new c.a.n0.a.k.h.b(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new c.a.n0.a.k.h.b(1001, "fragment has detached");
            }
            c.a.n0.a.s1.b.d.a.c(m);
            c.a.n0.a.u.d.i("LoadingViewApi", "hide loading success");
            return c.a.n0.a.k.h.b.f();
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                c.a.n0.a.u.d.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new c.a.n0.a.k.h.b(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                c.a.n0.a.u.d.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.n0.a.k.h.b(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new c.a.n0.a.k.h.b(1001, "context not support");
                }
                c.a.n0.a.x.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new c.a.n0.a.k.h.b(1001, "none fragment");
                }
                c.a.n0.a.x.g.d m = swanAppFragmentManager.m();
                if (!(m instanceof a.InterfaceC0451a)) {
                    return new c.a.n0.a.k.h.b(1001, "fragment not support");
                }
                c.a.n0.a.s1.b.c.a floatLayer = ((a.InterfaceC0451a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new c.a.n0.a.k.h.b(1001, "can't get floatLayer");
                }
                c.a.n0.a.s1.b.d.a.f(floatLayer, context, optString, optBoolean);
                c.a.n0.a.u.d.i("LoadingViewApi", "show loading success");
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
