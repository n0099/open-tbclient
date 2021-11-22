package b.a.p0.a.u.e.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.c2.b.c.a;
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
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new b.a.p0.a.u.h.b(1001, "context not support");
            }
            b.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new b.a.p0.a.u.h.b(1001, "none fragmentManger");
            }
            b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
            if (!(m instanceof a.InterfaceC0136a)) {
                return new b.a.p0.a.u.h.b(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new b.a.p0.a.u.h.b(1001, "fragment has detached");
            }
            b.a.p0.a.c2.b.d.a.c(m);
            b.a.p0.a.e0.d.i("LoadingViewApi", "hide loading success");
            return b.a.p0.a.u.h.b.f();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                b.a.p0.a.e0.d.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                b.a.p0.a.e0.d.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new b.a.p0.a.u.h.b(1001, "context not support");
                }
                b.a.p0.a.h0.g.g swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new b.a.p0.a.u.h.b(1001, "none fragment");
                }
                b.a.p0.a.h0.g.d m = swanAppFragmentManager.m();
                if (!(m instanceof a.InterfaceC0136a)) {
                    return new b.a.p0.a.u.h.b(1001, "fragment not support");
                }
                b.a.p0.a.c2.b.c.a floatLayer = ((a.InterfaceC0136a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new b.a.p0.a.u.h.b(1001, "can't get floatLayer");
                }
                b.a.p0.a.c2.b.d.a.f(floatLayer, context, optString, optBoolean);
                b.a.p0.a.e0.d.i("LoadingViewApi", "show loading success");
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
