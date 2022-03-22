package c.d.a0.a;

import android.view.View;
import c.d.a0.a.u;
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
/* loaded from: classes3.dex */
public class v implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22994b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f22995c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f22996d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f22997e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ u.b f22998f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ u f22999g;

    public v(u uVar, ExpressAdListenerWrapper expressAdListenerWrapper, String str, TTNativeExpressAd tTNativeExpressAd, u.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, expressAdListenerWrapper, str, tTNativeExpressAd, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22999g = uVar;
        this.f22995c = expressAdListenerWrapper;
        this.f22996d = str;
        this.f22997e = tTNativeExpressAd;
        this.f22998f = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) {
            LogPrinter.d();
            this.f22999g.onAdClicked(this.f22994b, new String[0]);
            this.f22994b = true;
            FunAdInteractionListener funAdInteractionListener = this.f22995c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f22996d;
                pid = this.f22999g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22999g.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i) == null) {
            LogPrinter.d();
            this.f22999g.onAdShow(this.f22997e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f22995c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f22996d;
                pid = this.f22999g.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22999g.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i) == null) {
            LogPrinter.d();
            u.b bVar = this.f22998f;
            if (bVar.f22992c) {
                return;
            }
            int i2 = bVar.a + 1;
            bVar.a = i2;
            if (i2 == bVar.f22991b) {
                bVar.f22993d.onAdError(i, str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.d();
            this.f22997e.setCanInterruptVideoPlay(true);
            this.f22999g.j.put(this.f22997e, this.f22995c);
            u.b bVar = this.f22998f;
            TTNativeExpressAd tTNativeExpressAd = this.f22997e;
            if (bVar.f22992c) {
                bVar.f22993d.cacheOrDestroyAd(tTNativeExpressAd);
                return;
            }
            bVar.f22993d.onAdLoaded((u) tTNativeExpressAd);
            bVar.f22992c = true;
        }
    }
}
