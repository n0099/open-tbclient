package c.a.n0.a.c2;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c.a.n0.a.c2.f.a0;
import c.a.n0.a.c2.f.b0;
import c.a.n0.a.c2.f.c0;
import c.a.n0.a.c2.f.d0;
import c.a.n0.a.c2.f.f;
import c.a.n0.a.c2.f.o;
import c.a.n0.a.c2.f.p;
import c.a.n0.a.c2.f.q;
import c.a.n0.a.c2.f.t;
import c.a.n0.a.c2.f.u;
import c.a.n0.a.c2.f.x;
import c.a.n0.a.c2.f.y;
import c.a.n0.a.e2.b.h;
import c.a.n0.a.k2.e.g;
import c.a.n0.a.k2.e.j;
import c.a.n0.a.k2.e.l;
import c.a.n0.a.k2.e.m;
import c.a.n0.a.k2.e.n;
import c.a.n0.a.n1.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a0> f4491a;

    public e() {
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
        this.f4491a = new HashMap();
        a();
    }

    public void a() {
        List<a0> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f4491a.clear();
            b(new u(this));
            b(new i(this));
            b(new d0(this));
            b(new f(this));
            b(new c.a.n0.a.n1.b(this));
            b(new o(this));
            b(new l(this));
            b(new m(this));
            b(new c.a.n0.a.k2.e.f(this));
            b(new g(this));
            b(new n(this));
            b(new c.a.n0.a.k2.e.o(this));
            b(new c.a.n0.a.k2.e.i(this));
            b(new j(this));
            b(new c.a.n0.a.k2.e.a(this));
            b(new c.a.n0.a.k2.e.b(this));
            b(new c.a.n0.a.e2.b.g(this));
            b(new c.a.n0.a.e2.b.f(this));
            b(new c.a.n0.a.e2.b.e(this));
            b(new c.a.n0.a.e2.b.c(this));
            b(new c.a.n0.a.e2.b.b(this));
            b(new c.a.n0.a.e2.b.a(this));
            b(new c.a.n0.a.e2.b.d(this));
            b(new c.a.n0.a.e2.b.i(this));
            b(new c.a.n0.a.c2.f.i(this));
            b(new y(this));
            b(new c.a.n0.a.i0.a.a(this));
            b(new c0(this));
            b(new q(this));
            b(new p(this));
            b(new c.a.n0.a.n2.f.b.a(this));
            b(new c.a.n0.a.n2.f.b.b(this));
            b(new c.a.n0.a.n2.a.b.a(this));
            b(new c.a.n0.a.n2.a.b.b(this));
            b(new c.a.n0.a.i1.f.c.a(this));
            b(new t(this));
            b(new c.a.n0.a.i1.g.d.a(this));
            b(new c.a.n0.a.n1.n(this));
            b(new c.a.n0.a.c2.f.j(this));
            b(new c.a.n0.a.c2.f.j0.e(this));
            b(new c.a.n0.a.c2.f.j0.b(this));
            b(new c.a.n0.a.x.a(this));
            b(new x(this));
            b(new SwanAppDownloadAction(this));
            b(new b0(this));
            b(new c.a.n0.a.c2.f.j0.c(this));
            b(new c.a.n0.a.c2.f.i0.b.b(this));
            b(new c.a.n0.a.c2.f.i0.b.a(this));
            b(new c.a.n0.a.n2.i.b.a(this));
            b(new c.a.n0.a.n2.i.b.b(this));
            b(new c.a.n0.a.n2.c.b.c(this));
            b(new c.a.n0.a.n2.c.b.a(this));
            b(new c.a.n0.a.n2.b.a(this));
            b(new c.a.n0.a.n2.k.a(this));
            b(new c.a.n0.a.n2.b.b(this));
            b(new c.a.n0.a.n2.b.c(this));
            b(new c.a.n0.a.n2.j.a(this));
            b(new c.a.n0.a.s.a.j.b(this));
            b(new h(this));
            b(new c.a.n0.a.y0.h.d(this));
            b(new c.a.n0.a.s.a.k.a.a(this));
            b(new c.a.n0.a.w1.f.c(this));
            b(new c.a.n0.a.w1.f.a(this));
            b(new c.a.n0.a.w1.f.d(this));
            b(new c.a.n0.a.w1.f.b(this));
            c.a.n0.a.p.b.a.b d2 = c.a.n0.a.c1.b.d();
            if (d2 == null || (c2 = d2.c(this)) == null || c2.isEmpty()) {
                return;
            }
            for (a0 a0Var : c2) {
                b(a0Var);
            }
        }
    }

    public void b(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a0Var) == null) {
            this.f4491a.put(a0Var.f4494a, a0Var);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "swanAPI" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return null;
        }
        return (Class) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (uri == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty url");
                return false;
            } else if (uri.getPathSegments() != null && !uri.getPathSegments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("swanAPI");
                arrayList.addAll(uri.getPathSegments());
                String str = "/swanAPI" + uri.getPath();
                if (!TextUtils.isEmpty(str) && str.startsWith("/")) {
                    for (int size = arrayList.size(); size > 0; size--) {
                        String str2 = "/" + ((String) arrayList.get(size - 1));
                        if (str.isEmpty() || str.length() < str2.length()) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str + " @ " + str2);
                            return false;
                        }
                        a0 a0Var = this.f4491a.get(str);
                        if (a0Var != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return a0Var.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
                        }
                        str = str.substring(0, str.length() - str2.length());
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "not support such action ：" + uri.getPath());
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302, "err path ：" + str);
                return false;
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty Segment");
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
