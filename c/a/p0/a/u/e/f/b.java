package c.a.p0.a.u.e.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.c2.b.c.a;
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
    public b(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new c.a.p0.a.u.h.b(1001, "context not support");
            }
            c.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new c.a.p0.a.u.h.b(1001, "none fragmentManger");
            }
            c.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0192a)) {
                return new c.a.p0.a.u.h.b(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new c.a.p0.a.u.h.b(1001, "fragment has detached");
            }
            c.a.p0.a.c2.b.d.a.c(m);
            c.a.p0.a.e0.d.i("LoadingViewApi", "hide loading success");
            return c.a.p0.a.u.h.b.f();
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                c.a.p0.a.e0.d.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new c.a.p0.a.u.h.b(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                c.a.p0.a.e0.d.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new c.a.p0.a.u.h.b(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new c.a.p0.a.u.h.b(1001, "context not support");
                }
                c.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new c.a.p0.a.u.h.b(1001, "none fragment");
                }
                c.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
                if (!(m instanceof a.InterfaceC0192a)) {
                    return new c.a.p0.a.u.h.b(1001, "fragment not support");
                }
                c.a.p0.a.c2.b.c.a floatLayer = ((a.InterfaceC0192a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new c.a.p0.a.u.h.b(1001, "can't get floatLayer");
                }
                c.a.p0.a.c2.b.d.a.f(floatLayer, context, optString, optBoolean);
                c.a.p0.a.e0.d.i("LoadingViewApi", "show loading success");
                return c.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
