package b.a.p0.a.q1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.p0.a.h0.g.k;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.v2.o0;
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
public class c extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends b.a.p0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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
                            e.a().onPayResult(Integer.valueOf(t.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), URLDecoder.decode(t.get("result"), "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            e.a().onPayResult(Integer.valueOf(t.get(EnterDxmPayServiceAction.SERVICE_STATUS_CODE)).intValue(), null);
                        }
                    } else {
                        e.a().onPayResult(6, null);
                    }
                    k.F2();
                    return true;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }
    }

    public c() {
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

    @Override // b.a.p0.a.h0.g.k
    public b.a.p0.a.h0.j.d G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (b.a.p0.a.h0.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.g.k
    public b.a.p0.a.p.e.e k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? g.M().W().g(getContext()) : (b.a.p0.a.p.e.e) invokeV.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [b.a.p0.a.p.e.c] */
    @Override // b.a.p0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View w0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(b.a.p0.a.g.aiapps_webview_fragment, viewGroup, false);
            inflate.findViewById(b.a.p0.a.f.ai_apps_title_bar_root).setVisibility(8);
            b.a.p0.a.p.e.e k = k();
            this.C0 = k;
            k.X(G2());
            this.D0 = this.C0.s();
            this.C0.loadUrl(this.E0);
            this.C0.j((FrameLayout) inflate.findViewById(b.a.p0.a.f.aiapps_webView_container), this.D0.covertToView());
            if (J1()) {
                inflate = M1(inflate);
            }
            return u1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
