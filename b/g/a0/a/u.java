package b.g.a0.a;

import android.view.View;
import b.g.a0.a.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class u implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30877a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30878b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f30879c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f30880d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f30881e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ t.b f30882f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t f30883g;

    public u(t tVar, ExpressAdListenerWrapper expressAdListenerWrapper, String str, TTNativeExpressAd tTNativeExpressAd, t.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, expressAdListenerWrapper, str, tTNativeExpressAd, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30883g = tVar;
        this.f30879c = expressAdListenerWrapper;
        this.f30880d = str;
        this.f30881e = tTNativeExpressAd;
        this.f30882f = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            LogPrinter.d();
            adReporter = this.f30883g.mReporter;
            adReporter.recordOnClicked(this.f30878b);
            this.f30878b = true;
            this.f30883g.onAdClicked();
            FunAdInteractionListener funAdInteractionListener = this.f30879c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f30880d;
                pid = this.f30883g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30883g.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            LogPrinter.d();
            adReporter = this.f30883g.mReporter;
            adReporter.recordShowSucceed(this.f30877a);
            this.f30877a = true;
            this.f30883g.onAdShow(this.f30881e);
            FunAdInteractionListener funAdInteractionListener = this.f30879c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f30880d;
                pid = this.f30883g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30883g.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            LogPrinter.d();
            adReporter = this.f30883g.mReporter;
            adReporter.recordRenderFailed(i2);
            t.b bVar = this.f30882f;
            if (bVar.f30875c) {
                return;
            }
            int i3 = bVar.f30873a + 1;
            bVar.f30873a = i3;
            if (i3 == bVar.f30874b) {
                bVar.f30876d.onAdError(i2, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.d();
            this.f30881e.setCanInterruptVideoPlay(true);
            adReporter = this.f30883g.mReporter;
            adReporter.recordRenderSucceed();
            this.f30883g.f30870i.put(this.f30881e, this.f30879c);
            t.b bVar = this.f30882f;
            TTNativeExpressAd tTNativeExpressAd = this.f30881e;
            if (bVar.f30875c) {
                bVar.f30876d.cacheOrDestroyAd(tTNativeExpressAd);
                return;
            }
            bVar.f30876d.onAdLoaded((t) tTNativeExpressAd);
            bVar.f30875c = true;
        }
    }
}
