package b.a.a.a.t.a.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class p implements TTNativeExpressAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1199a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1202d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f1203e;

    public p(o oVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oVar, tTNativeExpressAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1203e = oVar;
        this.f1201c = tTNativeExpressAd;
        this.f1202d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1203e.f1057h.f(this.f1200b);
            this.f1200b = true;
            this.f1203e.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.a.a.x.d.a();
            this.f1203e.f1057h.m();
            this.f1203e.s();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
            b.a.a.a.x.d.a();
            this.f1203e.f1057h.k(this.f1199a);
            this.f1199a = true;
            o oVar = this.f1203e;
            TTNativeExpressAd tTNativeExpressAd = this.f1201c;
            oVar.i(tTNativeExpressAd, oVar.p.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, view, str, i2) == null) {
            b.a.a.a.x.d.f("onRenderFail message: " + str + ", code: " + i2, new Object[0]);
            this.f1203e.f1057h.b(i2);
            this.f1203e.n(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            b.a.a.a.x.d.a();
            this.f1203e.f1057h.n();
            this.f1203e.p.put(this.f1201c, this.f1202d);
            o oVar = this.f1203e;
            oVar.h(this.f1201c);
            oVar.u();
        }
    }
}
