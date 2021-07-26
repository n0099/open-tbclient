package a.a.a.a.r.a.b;

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
    public boolean f1143a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1145c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1146d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f1147e;

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
        this.f1147e = oVar;
        this.f1145c = tTNativeExpressAd;
        this.f1146d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1147e.f1015h.a(this.f1144b);
            this.f1144b = true;
            this.f1147e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.v.d.a();
            this.f1147e.f1015h.d();
            this.f1147e.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1147e.f1015h.b(this.f1143a);
            this.f1143a = true;
            o oVar = this.f1147e;
            TTNativeExpressAd tTNativeExpressAd = this.f1145c;
            oVar.a((o) tTNativeExpressAd, oVar.o.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, view, str, i2) == null) {
            a.a.a.a.v.d.b("onRenderFail message: " + str + ", code: " + i2, new Object[0]);
            this.f1147e.f1015h.a(i2);
            this.f1147e.b(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a.a.a.a.v.d.a();
            this.f1147e.f1015h.e();
            this.f1147e.o.put(this.f1145c, this.f1146d);
            o oVar = this.f1147e;
            oVar.a((o) this.f1145c);
            oVar.h();
        }
    }
}
