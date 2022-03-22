package c.a.n0.q.i.i.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.q.i.l.b;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(c.a.n0.q.e.e<T> eVar, T t, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, eVar, t, str, str2)) == null) {
            if (t == null || eVar == null) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                k(t, PackageTable.MD5, eVar);
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                k(t, TTDownloadField.TT_DOWNLOAD_URL, eVar);
                return false;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static <T> boolean b(T t, c.a.n0.q.e.e<T> eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, eVar)) == null) {
            if (eVar == null || t == null) {
                return false;
            }
            if (t instanceof c.a.n0.q.h.f) {
                c.a.n0.q.h.f fVar = (c.a.n0.q.h.f) t;
                return a(eVar, t, fVar.l, fVar.n);
            } else if (t instanceof b.a) {
                c.a.n0.q.h.g gVar = ((b.a) t).f9197d;
                return a(eVar, t, gVar.l, gVar.n);
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static f<c.a.n0.q.h.c> c(c.a.n0.q.h.c cVar, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cVar, iVar)) == null) {
            if (iVar != null && b(cVar, iVar.s())) {
                return new f<>(new e(cVar), cVar, new c(iVar.s()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static f<c.a.n0.q.h.e> d(c.a.n0.q.h.e eVar, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, eVar, iVar)) == null) {
            if (iVar != null && b(eVar, iVar.t())) {
                return new f<>(new e(eVar), eVar, new c(iVar.t()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static List<f<c.a.n0.q.h.i>> e(List<c.a.n0.q.h.i> list, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, iVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (iVar != null && list != null && list.size() > 0) {
                for (c.a.n0.q.h.i iVar2 : list) {
                    if (b(iVar2, iVar.r())) {
                        arrayList.add(new f(new e(iVar2), iVar2, new c(iVar.r())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<f<b.a>> f(List<b.a> list, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, list, iVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (iVar != null && list != null && list.size() > 0) {
                for (b.a aVar : list) {
                    c.a.n0.q.h.g gVar = aVar.f9197d;
                    if (gVar != null && b(aVar, iVar.w())) {
                        arrayList.add(new f(new e(gVar), aVar, new c(iVar.w())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<c.a.n0.q.h.g> g(c.a.n0.q.h.g gVar, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, gVar, iVar)) == null) {
            if (iVar != null && b(gVar, iVar.v())) {
                return new f<>(new e(gVar), gVar, new c(iVar.v()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static List<f<c.a.n0.q.h.h>> h(List<c.a.n0.q.h.h> list, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, iVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (iVar != null && list != null && list.size() > 0) {
                for (c.a.n0.q.h.h hVar : list) {
                    if (b(hVar, iVar.B())) {
                        arrayList.add(new f(new e(hVar), hVar, new c(iVar.B())));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static f<c.a.n0.q.h.i> i(c.a.n0.q.h.i iVar, c.a.n0.q.e.i iVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, iVar, iVar2)) == null) {
            if (iVar2 != null && b(iVar, iVar2.y())) {
                return new f<>(new e(iVar), iVar, new c(iVar2.y()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static f<c.a.n0.q.h.j> j(c.a.n0.q.h.j jVar, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jVar, iVar)) == null) {
            if (iVar != null && b(jVar, iVar.A())) {
                return new f<>(new e(jVar), jVar, new c(iVar.A()));
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public static <T> void k(T t, String str, c.a.n0.q.e.e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, t, str, eVar) == null) {
            eVar.e(t, new c.a.n0.q.h.b(ErrorConstant.Code.DOWNLOAD_ERROR_NETWROK_CHANGE, "download : param error:" + str));
        }
    }
}
