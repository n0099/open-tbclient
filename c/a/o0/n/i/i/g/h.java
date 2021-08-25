package c.a.o0.n.i.i.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.n.i.l.a;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(c.a.o0.n.f.c<T> cVar, T t, String str, String str2) {
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
                j(t, BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, cVar);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, c.a.o0.n.f.c<T> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, cVar)) == null) {
            if (cVar == null || t == null) {
                return false;
            }
            if (t instanceof c.a.o0.n.h.e) {
                c.a.o0.n.h.e eVar = (c.a.o0.n.h.e) t;
                return a(cVar, t, eVar.l, eVar.n);
            } else if (t instanceof a.C0621a) {
                c.a.o0.n.h.f fVar = ((a.C0621a) t).f11931d;
                return a(cVar, t, fVar.l, fVar.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static f<c.a.o0.n.h.b> c(c.a.o0.n.h.b bVar, c.a.o0.n.f.g gVar) {
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

    public static f<c.a.o0.n.h.d> d(c.a.o0.n.h.d dVar, c.a.o0.n.f.g gVar) {
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

    public static List<f<a.C0621a>> e(List<a.C0621a> list, c.a.o0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, gVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gVar != null && list != null && list.size() > 0) {
                for (a.C0621a c0621a : list) {
                    c.a.o0.n.h.f fVar = c0621a.f11931d;
                    if (fVar != null && b(c0621a, gVar.u())) {
                        arrayList.add(new f(new e(fVar), c0621a, new c(gVar.u())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<c.a.o0.n.h.f> f(c.a.o0.n.h.f fVar, c.a.o0.n.f.g gVar) {
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

    public static List<f<c.a.o0.n.h.g>> g(List<c.a.o0.n.h.g> list, c.a.o0.n.f.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, gVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (gVar != null && list != null && list.size() > 0) {
                for (c.a.o0.n.h.g gVar2 : list) {
                    if (b(gVar2, gVar.z())) {
                        arrayList.add(new f(new e(gVar2), gVar2, new c(gVar.z())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<c.a.o0.n.h.h> h(c.a.o0.n.h.h hVar, c.a.o0.n.f.g gVar) {
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

    public static f<c.a.o0.n.h.i> i(c.a.o0.n.h.i iVar, c.a.o0.n.f.g gVar) {
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

    public static <T> void j(T t, String str, c.a.o0.n.f.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, t, str, cVar) == null) {
            cVar.e(t, new c.a.o0.n.h.a(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, String.format(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MISS_PARAM, str)));
        }
    }
}
