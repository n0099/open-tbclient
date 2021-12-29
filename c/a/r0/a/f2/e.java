package c.a.r0.a.f2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import c.a.r0.a.f2.f.a0;
import c.a.r0.a.f2.f.b0;
import c.a.r0.a.f2.f.c0;
import c.a.r0.a.f2.f.f;
import c.a.r0.a.f2.f.o;
import c.a.r0.a.f2.f.p;
import c.a.r0.a.f2.f.q;
import c.a.r0.a.f2.f.s;
import c.a.r0.a.f2.f.t;
import c.a.r0.a.f2.f.w;
import c.a.r0.a.f2.f.x;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.b.h;
import c.a.r0.a.h2.b.k;
import c.a.r0.a.o2.e.g;
import c.a.r0.a.o2.e.j;
import c.a.r0.a.o2.e.l;
import c.a.r0.a.o2.e.m;
import c.a.r0.a.o2.e.n;
import c.a.r0.a.p1.i;
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
    public final Map<String, z> a;

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
        this.a = new HashMap();
        a();
    }

    public void a() {
        List<z> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new t(this));
            b(new i(this));
            b(new c0(this));
            b(new f(this));
            b(new c.a.r0.a.p1.b(this));
            b(new o(this));
            b(new l(this));
            b(new m(this));
            b(new c.a.r0.a.o2.e.f(this));
            b(new g(this));
            b(new n(this));
            b(new c.a.r0.a.o2.e.o(this));
            b(new c.a.r0.a.o2.e.i(this));
            b(new j(this));
            b(new c.a.r0.a.o2.e.a(this));
            b(new c.a.r0.a.o2.e.b(this));
            b(new h(this));
            b(new c.a.r0.a.h2.b.g(this));
            b(new c.a.r0.a.h2.b.e(this));
            b(new c.a.r0.a.h2.b.c(this));
            b(new c.a.r0.a.h2.b.b(this));
            b(new c.a.r0.a.h2.b.a(this));
            b(new c.a.r0.a.h2.b.d(this));
            b(new k(this));
            b(new c.a.r0.a.f2.f.i(this));
            b(new x(this));
            b(new c.a.r0.a.i0.a.a(this));
            b(new b0(this));
            b(new q(this));
            b(new p(this));
            b(new c.a.r0.a.r2.e.b.a(this));
            b(new c.a.r0.a.r2.e.b.b(this));
            b(new c.a.r0.a.r2.a.b.a(this));
            b(new c.a.r0.a.r2.a.b.b(this));
            b(new c.a.r0.a.j1.f.c.a(this));
            b(new s(this));
            b(new c.a.r0.a.j1.g.d.a(this));
            b(new c.a.r0.a.p1.n(this));
            b(new c.a.r0.a.f2.f.j(this));
            b(new c.a.r0.a.f2.f.i0.e(this));
            b(new c.a.r0.a.f2.f.i0.b(this));
            b(new c.a.r0.a.x.a(this));
            b(new w(this));
            b(new SwanAppDownloadAction(this));
            b(new a0(this));
            b(new c.a.r0.a.f2.f.i0.c(this));
            b(new c.a.r0.a.f2.f.h0.b.b(this));
            b(new c.a.r0.a.f2.f.h0.b.a(this));
            b(new c.a.r0.a.r2.h.b.a(this));
            b(new c.a.r0.a.r2.h.b.b(this));
            b(new c.a.r0.a.r2.c.b.c(this));
            b(new c.a.r0.a.r2.c.b.a(this));
            b(new c.a.r0.a.r2.b.a(this));
            b(new c.a.r0.a.r2.j.a(this));
            b(new c.a.r0.a.r2.b.b(this));
            b(new c.a.r0.a.r2.b.c(this));
            b(new c.a.r0.a.r2.i.a(this));
            b(new c.a.r0.a.s.a.i.b(this));
            b(new c.a.r0.a.h2.b.i(this));
            b(new c.a.r0.a.y0.h.d(this));
            b(new c.a.r0.a.s.a.j.a.a(this));
            b(new c.a.r0.a.z1.f.c(this));
            b(new c.a.r0.a.z1.f.a(this));
            b(new c.a.r0.a.z1.f.d(this));
            b(new c.a.r0.a.z1.f.b(this));
            c.a.r0.a.p.b.a.b d2 = c.a.r0.a.c1.b.d();
            if (d2 == null || (c2 = d2.c(this)) == null || c2.isEmpty()) {
                return;
            }
            for (z zVar : c2) {
                b(zVar);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void b(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar) == null) {
            this.a.put(zVar.a, zVar);
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
                        z zVar = this.a.get(str);
                        if (zVar != null) {
                            if (unitedSchemeEntity.isOnlyVerify()) {
                                return true;
                            }
                            return zVar.h(context, unitedSchemeEntity, callbackHandler, "/swanAPI" + uri.getPath());
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
