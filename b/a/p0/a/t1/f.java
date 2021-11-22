package b.a.p0.a.t1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.p0.a.h0.g.l;
import b.a.p0.a.z2.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.p0.a.h0.j.a, b.a.p0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null && str.startsWith("https://etrade.baidu.com/cashier/create-qrcode/close")) {
                    Map<String, String> t = o0.t(o0.o(str));
                    if (t != null && t.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE) != null) {
                        try {
                            h.a().onPayResult(Integer.valueOf(t.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            h.a().onPayResult(Integer.valueOf(t.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), null);
                        }
                    } else {
                        h.a().onPayResult(6, null);
                    }
                    l.V2();
                    return true;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }
    }

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
            }
        }
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.h0.j.d W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.l
    public b.a.p0.a.p.e.e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.a.p0.a.h0.u.g.U().f0().i(getContext()) : (b.a.p0.a.p.e.e) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [b.a.p0.a.p.e.c] */
    @Override // b.a.p0.a.h0.g.l, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            inflate.findViewById(b.a.p0.a.f.ai_apps_title_bar_root).setVisibility(8);
            b.a.p0.a.p.e.e l = l();
            this.I0 = l;
            l.a0(W2());
            this.J0 = this.I0.t();
            this.I0.loadUrl(this.K0);
            this.I0.k((FrameLayout) inflate.findViewById(b.a.p0.a.f.aiapps_webView_container), this.J0.covertToView());
            if (Q1()) {
                inflate = T1(inflate);
            }
            return A1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
