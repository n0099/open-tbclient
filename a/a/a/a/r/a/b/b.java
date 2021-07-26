package a.a.a.a.r.a.b;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
/* loaded from: classes.dex */
public class b implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1097a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1098b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f1099c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f1100d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1101e;

    public b(a aVar, TTNativeExpressAd tTNativeExpressAd, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, tTNativeExpressAd, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1101e = aVar;
        this.f1099c = tTNativeExpressAd;
        this.f1100d = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1101e.f1015h.a(this.f1098b);
            this.f1098b = true;
            this.f1101e.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            a.a.a.a.v.d.a();
            this.f1101e.f1015h.b(this.f1097a);
            this.f1097a = true;
            a aVar = this.f1101e;
            TTNativeExpressAd tTNativeExpressAd = this.f1099c;
            aVar.a((a) tTNativeExpressAd, aVar.o.remove(tTNativeExpressAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            a.a.a.a.v.d.b("onRenderFail message: " + str + ", code = " + i2, new Object[0]);
            this.f1101e.f1015h.a(i2);
            this.f1101e.m = false;
            this.f1101e.a(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            a.a.a.a.v.d.a();
            this.f1101e.f1015h.e();
            this.f1101e.o.put(this.f1099c, this.f1100d);
            a aVar = this.f1101e;
            aVar.a((a) this.f1099c);
            aVar.h();
        }
    }
}
