package b.g.a0.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes6.dex */
public class h implements AdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30919a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30920b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f30921c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f30922d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f30923e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f30924f;

    public h(e eVar, ExpressAdListenerWrapper expressAdListenerWrapper, String str, NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, expressAdListenerWrapper, str, nativeExpressADData2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30924f = eVar;
        this.f30921c = expressAdListenerWrapper;
        this.f30922d = str;
        this.f30923e = nativeExpressADData2;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            adReporter = this.f30924f.mReporter;
            adReporter.recordOnClosed();
            this.f30924f.onAdClose();
            FunAdInteractionListener funAdInteractionListener = this.f30921c.funListener;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(this.f30922d);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            adReporter = this.f30924f.mReporter;
            adReporter.recordOnClicked(this.f30920b);
            this.f30920b = true;
            this.f30924f.onAdClicked();
            FunAdInteractionListener funAdInteractionListener = this.f30921c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f30922d;
                pid = this.f30924f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30924f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.e();
            adReporter = this.f30924f.mReporter;
            adReporter.recordShowSucceed(this.f30919a);
            this.f30919a = true;
            this.f30924f.onAdShow(this.f30923e);
            FunAdInteractionListener funAdInteractionListener = this.f30921c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f30922d;
                pid = this.f30924f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30924f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            adReporter = this.f30924f.mReporter;
            adReporter.recordRenderFailed();
            this.f30924f.onError(0, "RenderFail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
            adReporter = this.f30924f.mReporter;
            adReporter.recordRenderSucceed();
            this.f30924f.f30916h.put(this.f30923e, this.f30921c);
            this.f30924f.onAdLoaded((e) this.f30923e);
        }
    }
}
