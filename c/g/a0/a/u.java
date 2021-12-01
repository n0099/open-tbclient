package c.g.a0.a;

import android.view.View;
import c.g.a0.a.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.ExpressAdListenerWrapper;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes7.dex */
public class u implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f28672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28673d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f28674e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ t.b f28675f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ t f28676g;

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
        this.f28676g = tVar;
        this.f28672c = expressAdListenerWrapper;
        this.f28673d = str;
        this.f28674e = tTNativeExpressAd;
        this.f28675f = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            LogPrinter.d();
            this.f28676g.onAdClicked(this.f28671b);
            this.f28671b = true;
            FunAdInteractionListener funAdInteractionListener = this.f28672c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f28673d;
                pid = this.f28676g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28676g.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
            LogPrinter.d();
            this.f28676g.onAdShow(this.f28674e, this.a);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f28672c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f28673d;
                pid = this.f28676g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28676g.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            LogPrinter.d();
            t.b bVar = this.f28675f;
            if (bVar.f28669c) {
                return;
            }
            int i3 = bVar.a + 1;
            bVar.a = i3;
            if (i3 == bVar.f28668b) {
                bVar.f28670d.onAdError(i2, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.d();
            this.f28674e.setCanInterruptVideoPlay(true);
            this.f28676g.f28666i.put(this.f28674e, this.f28672c);
            t.b bVar = this.f28675f;
            TTNativeExpressAd tTNativeExpressAd = this.f28674e;
            if (bVar.f28669c) {
                bVar.f28670d.cacheOrDestroyAd(tTNativeExpressAd);
                return;
            }
            bVar.f28670d.onAdLoaded((t) tTNativeExpressAd);
            bVar.f28669c = true;
        }
    }
}
