package b.a.p0.n.i.i.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.n.i.l.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(b.a.p0.n.f.c<T> cVar, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, cVar, t, str, str2)) == null) {
            if (t == null || cVar == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                j(t, PackageTable.MD5, cVar);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                j(t, "downloadUrl", cVar);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, b.a.p0.n.f.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, cVar)) == null) {
            if (cVar == null || t == null) {
                return false;
            }
            if (t instanceof b.a.p0.n.h.e) {
                b.a.p0.n.h.e eVar = (b.a.p0.n.h.e) t;
                return a(cVar, t, eVar.l, eVar.n);
            } else if (t instanceof a.C0618a) {
                b.a.p0.n.h.f fVar = ((a.C0618a) t).f11148d;
                return a(cVar, t, fVar.l, fVar.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static f<b.a.p0.n.h.b> c(b.a.p0.n.h.b bVar, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bVar, gVar)) == null) {
            if (gVar != null && b(bVar, gVar.q())) {
                return new f<>(new e(bVar), bVar, new c(gVar.q()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static f<b.a.p0.n.h.d> d(b.a.p0.n.h.d dVar, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dVar, gVar)) == null) {
            if (gVar != null && b(dVar, gVar.r())) {
                return new f<>(new e(dVar), dVar, new c(gVar.r()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static List<f<a.C0618a>> e(List<a.C0618a> list, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, gVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gVar != null && list != null && list.size() > 0) {
                for (a.C0618a c0618a : list) {
                    b.a.p0.n.h.f fVar = c0618a.f11148d;
                    if (fVar != null && b(c0618a, gVar.u())) {
                        arrayList.add(new f(new e(fVar), c0618a, new c(gVar.u())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<b.a.p0.n.h.f> f(b.a.p0.n.h.f fVar, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, fVar, gVar)) == null) {
            if (gVar != null && b(fVar, gVar.t())) {
                return new f<>(new e(fVar), fVar, new c(gVar.t()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static List<f<b.a.p0.n.h.g>> g(List<b.a.p0.n.h.g> list, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, gVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gVar != null && list != null && list.size() > 0) {
                for (b.a.p0.n.h.g gVar2 : list) {
                    if (b(gVar2, gVar.z())) {
                        arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.z())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<b.a.p0.n.h.h> h(b.a.p0.n.h.h hVar, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, hVar, gVar)) == null) {
            if (gVar != null && b(hVar, gVar.w())) {
                return new f<>(new e(hVar), hVar, new c(gVar.w()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static f<b.a.p0.n.h.i> i(b.a.p0.n.h.i iVar, b.a.p0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, iVar, gVar)) == null) {
            if (gVar != null && b(iVar, gVar.y())) {
                return new f<>(new e(iVar), iVar, new c(gVar.y()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static <T> void j(T t, String str, b.a.p0.n.f.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, t, str, cVar) == null) {
            cVar.e(t, new b.a.p0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
        }
    }
}
