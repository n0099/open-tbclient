package c.a.q0.i3.m0.d;

import android.os.Build;
import android.webkit.WebView;
import c.a.e.e.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f20408a;

    public f() {
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
        this.f20408a = new ArrayList<>();
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f20408a.add(aVar);
        }
    }

    public final void b(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2) == null) || webView == null || k.isEmpty(str) || k.isEmpty(str2)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            webView.evaluateJavascript("javascript:" + str + "&&" + str + "('" + str2 + "')", null);
            return;
        }
        webView.loadUrl("javascript:" + str + "&&" + str + "('" + str2 + "')");
    }

    public c c(e eVar, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, eVar, cVar)) == null) {
            if (cVar == null) {
                cVar = new c();
            }
            if (ActionJsonData.TAG_NOTIFICATION.equals(eVar.c()) && "addObserver".equals(eVar.a())) {
                Iterator<a> it = this.f20408a.iterator();
                while (it.hasNext()) {
                    cVar = it.next().addObserver(eVar.d(), cVar, true);
                    if (cVar.i()) {
                        return cVar;
                    }
                }
                if (!cVar.i()) {
                    cVar.u(202);
                    cVar.r(TbadkCoreApplication.getInst().getString(R.string.can_find_notification_name));
                }
            } else {
                String c2 = eVar.c();
                if (!k.isEmpty(c2) && DescriptionTableInfo.getModuleSet() != null && !DescriptionTableInfo.getModuleSet().contains(c2)) {
                    cVar.u(201);
                    return cVar;
                }
                Iterator<a> it2 = this.f20408a.iterator();
                while (it2.hasNext()) {
                    cVar = it2.next().dispatch(eVar, cVar);
                    if (cVar.h()) {
                        return cVar;
                    }
                }
                if (!cVar.h()) {
                    cVar.u(202);
                }
            }
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public void d(WebView webView, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, webView, cVar) == null) || webView == null || cVar == null || !cVar.j()) {
            return;
        }
        b(webView, cVar.c(), cVar.d());
    }

    public void e(WebView webView, List<c> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, list) == null) || webView == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (c cVar : list) {
            if (cVar != null && cVar.j()) {
                b(webView, cVar.c(), cVar.d());
            }
        }
    }

    public List<c> f(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, hashMap)) == null) {
            List<c> list = null;
            if (k.isEmpty(str)) {
                return null;
            }
            Iterator<a> it = this.f20408a.iterator();
            while (it.hasNext()) {
                list = it.next().processNotification(str, hashMap);
                if (!ListUtils.isEmpty(list)) {
                    break;
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }
}
