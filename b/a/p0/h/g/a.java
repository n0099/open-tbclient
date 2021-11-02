package b.a.p0.h.g;

import b.a.p0.a.a2.e;
import b.a.p0.h.m0.c;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b.a.p0.h.d.b bVar, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, jsObject) == null) {
            b bVar2 = new b();
            b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
            if (F == null) {
                F = new b.a.p0.a.y.b.a();
            }
            boolean z = false;
            if (bVar == null) {
                bVar2.errMsg = "openCustomerServiceConversation:fail";
                c.call(F, false, bVar2);
                return;
            }
            if (b.a.p0.h.q.c.b.c()) {
                e i2 = e.i();
                if (i2 != null) {
                    String str = "{\"appKey\":\"" + i2.k() + "\"}";
                    if (SchemeRouter.invoke(b.a.p0.a.c1.a.b(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
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
