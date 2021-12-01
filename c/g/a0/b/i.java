package c.g.a0.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.qq.e.ads.nativ.express2.AdEventListener;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
/* loaded from: classes7.dex */
public class i implements AdEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f28703c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28704d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ NativeExpressADData2 f28705e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ f f28706f;

    public i(f fVar, ExpressAdListenerWrapper expressAdListenerWrapper, String str, NativeExpressADData2 nativeExpressADData2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, expressAdListenerWrapper, str, nativeExpressADData2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28706f = fVar;
        this.f28703c = expressAdListenerWrapper;
        this.f28704d = str;
        this.f28705e = nativeExpressADData2;
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onAdClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogPrinter.d();
            this.f28706f.onAdClose();
            FunAdInteractionListener funAdInteractionListener = this.f28703c.funListener;
            if (funAdInteractionListener != null) {
                funAdInteractionListener.onAdClose(this.f28704d);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onClick() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            this.f28706f.onAdClicked(this.f28702b);
            this.f28702b = true;
            FunAdInteractionListener funAdInteractionListener = this.f28703c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f28704d;
                pid = this.f28706f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28706f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onExposed() {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogPrinter.e();
            this.f28706f.onAdShow(this.f28705e, this.a);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f28703c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f28704d;
                pid = this.f28706f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28706f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LogPrinter.d();
            this.f28706f.onError(0, "RenderFail");
        }
    }

    @Override // com.qq.e.ads.nativ.express2.AdEventListener
    public void onRenderSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LogPrinter.d();
            this.f28706f.f28700h.put(this.f28705e, this.f28703c);
            this.f28706f.onAdLoaded((f) this.f28705e);
        }
    }
}
