package c.a.o0.h.g;

import c.a.o0.a.a2.e;
import c.a.o0.h.m0.c;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.o0.h.d.b bVar, JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, bVar, jsObject) == null) {
            b bVar2 = new b();
            c.a.o0.a.y.b.a G = c.a.o0.a.y.b.a.G(jsObject);
            if (G == null) {
                G = new c.a.o0.a.y.b.a();
            }
            boolean z = false;
            if (bVar == null) {
                bVar2.errMsg = "openCustomerServiceConversation:fail";
                c.a(G, false, bVar2);
                return;
            }
            if (c.a.o0.h.q.c.b.c()) {
                e i2 = e.i();
                if (i2 != null) {
                    String str = "{\"appKey\":\"" + i2.D() + "\"}";
                    if (SchemeRouter.invoke(c.a.o0.a.c1.a.b(), "baiduboxapp://v35/message/deliverMnpAppKey?params=" + URLEncoder.encode(str))) {
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
            c.a(G, z, bVar2);
        }
    }
}
