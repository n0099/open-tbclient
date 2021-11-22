package b.f.a0.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class i implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31685a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31686b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f31687c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ f f31688d;

    public i(f fVar, TTNativeExpressAd tTNativeExpressAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, tTNativeExpressAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31688d = fVar;
        this.f31687c = tTNativeExpressAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            LogPrinter.d();
            adReporter = this.f31688d.mReporter;
            adReporter.recordOnClicked(this.f31686b);
            this.f31686b = true;
            this.f31688d.onAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            LogPrinter.d();
            adReporter = this.f31688d.mReporter;
            adReporter.recordShowSucceed(this.f31685a);
            this.f31685a = true;
            this.f31688d.onAdShow(this.f31687c);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            LogPrinter.e("onRenderFail message: " + str + ", code = " + i2, new Object[0]);
            adReporter = this.f31688d.mReporter;
            adReporter.recordRenderFailed(i2);
            this.f31688d.isAdLoading = false;
            this.f31688d.onAdError(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.d();
            adReporter = this.f31688d.mReporter;
            adReporter.recordRenderSucceed();
            this.f31688d.onAdLoaded((f) this.f31687c);
        }
    }
}
