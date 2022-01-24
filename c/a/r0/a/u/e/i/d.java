package c.a.r0.a.u.e.i;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements NetRequest.RequestInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF, IF] complete} */
    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RequestInterceptor
    public boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, netRequestResult, netRequestParam)) == null) {
            if (netRequestParam == null) {
                return false;
            }
            String url = netRequestParam.getUrl();
            if (TextUtils.isEmpty(url)) {
                if (netRequestResult != null) {
                    netRequestResult.setStatusCodeAndMsg(1001, "illegal url");
                }
                return true;
            }
            JsObject jsObject = netRequestParam.getJsObject();
            if (jsObject != null) {
                try {
                    int propertyIndex = jsObject.getPropertyIndex("__plugin__");
                    r2 = propertyIndex > 0 ? jsObject.toString(propertyIndex) : null;
                    int c2 = c.a.r0.a.e2.a.b.c("request", url, r2);
                    if (c2 != 0) {
                        c.a.r0.a.u.h.b Y = i.Y(c2);
                        netRequestResult.setStatusCodeAndMsg(Y.f9465b, Y.f9466c);
                        return true;
                    }
                } finally {
                    if (e.e() && jsObject != null) {
                        jsObject.release();
                    }
                }
            }
            if (e.e() && jsObject != null) {
                jsObject.release();
            }
            if (!TextUtils.isEmpty(r2)) {
                netRequestParam.addHeader("X-SWAN-HOSTSIGN", c.a.r0.a.w1.h.a.b(c.a.r0.a.w1.h.b.h(r2)));
            }
            netRequestParam.addHeader("Referer", j.d());
            netRequestParam.addHeader("User-Agent", c.a.r0.p.b.b().a());
            return false;
        }
        return invokeLL.booleanValue;
    }
}
