package a.a.a.a.u.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class n implements TTNativeExpressAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1146a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1147b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1148c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1149d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1150e;

    public n(m mVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mVar, tTNativeExpressAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1150e = mVar;
        this.f1148c = tTNativeExpressAd;
        this.f1149d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1150e.f1017h.a(this.f1147b);
            this.f1147b = true;
            this.f1150e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a.a.a.y.d.a();
            this.f1150e.f1017h.d();
            this.f1150e.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) {
            a.a.a.a.y.d.a();
            this.f1150e.f1017h.b(this.f1146a);
            this.f1146a = true;
            m mVar = this.f1150e;
            TTNativeExpressAd tTNativeExpressAd = this.f1148c;
            mVar.a((m) tTNativeExpressAd, mVar.o.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, view, str, i2) == null) {
            a.a.a.a.y.d.b("onRenderFail message: " + str + ", code: " + i2, new Object[0]);
            this.f1150e.f1017h.a(i2);
            this.f1150e.b(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a.a.a.a.y.d.a();
            this.f1150e.f1017h.e();
            this.f1150e.o.put(this.f1148c, this.f1149d);
            m mVar = this.f1150e;
            mVar.a((m) this.f1148c);
            mVar.h();
        }
    }
}
