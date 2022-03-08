package c.a.p0.j.g;

import c.a.p0.a.t1.e;
import c.a.p0.j.n0.c;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.p0.j.d.b bVar, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, jsObject) == null) {
            b bVar2 = new b();
            c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
            if (F == null) {
                F = new c.a.p0.a.o.b.a();
            }
            boolean z = false;
            if (bVar == null) {
                bVar2.errMsg = "openCustomerServiceConversation:fail";
                c.call(F, false, bVar2);
                return;
            }
            if (c.a.p0.j.q.c.b.c()) {
                e L = e.L();
                if (L != null) {
                    String str = "{\"appKey\":\"" + L.N() + "\"}";
                    if (SchemeRouter.invoke(c.a.p0.a.s0.a.c(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
                        bVar2.errMsg = "openCustomerServiceConversation:ok";
                        z = true;
                    } else {
                        bVar2.errMsg = "openCustomerServiceConversation:fail";
                    }
                } else {
                    bVar2.errMsg = "openCustomerServiceConversation:fail";
                }
            } else {
                bVar2.errMsg = "openCustomerServiceConversation:fail require user interaction";
            }
            c.call(F, z, bVar2);
        }
    }
}
