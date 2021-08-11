package b.a.a.a.t.a.c;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class s implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1206a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1207b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1208c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1209d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f1210e;

    public s(r rVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rVar, tTNativeExpressAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1210e = rVar;
        this.f1208c = tTNativeExpressAd;
        this.f1209d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            b.a.a.a.x.d.f("CSJNativeExpressAd onAdClicked type: " + i2, new Object[0]);
            this.f1210e.f1057h.f(this.f1207b);
            this.f1207b = true;
            this.f1210e.r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            b.a.a.a.x.d.f("CSJNativeExpressAd onAdShow type: " + i2, new Object[0]);
            this.f1210e.f1057h.k(this.f1206a);
            this.f1206a = true;
            r rVar = this.f1210e;
            TTNativeExpressAd tTNativeExpressAd = this.f1208c;
            rVar.i(tTNativeExpressAd, rVar.p.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            b.a.a.a.x.d.f("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i2, new Object[0]);
            this.f1210e.f1057h.b(i2);
            this.f1210e.n(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            b.a.a.a.x.d.f("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
            this.f1210e.f1057h.n();
            this.f1210e.p.put(this.f1208c, this.f1209d);
            r rVar = this.f1210e;
            rVar.h(this.f1208c);
            rVar.u();
        }
    }
}
