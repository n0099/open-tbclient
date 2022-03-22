package c.d.a0.a;

import android.view.View;
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
public class d0 implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f22940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f22941c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f22942d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f22943e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ c0 f22944f;

    public d0(c0 c0Var, ExpressAdListenerWrapper expressAdListenerWrapper, String str, TTNativeExpressAd tTNativeExpressAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c0Var, expressAdListenerWrapper, str, tTNativeExpressAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22944f = c0Var;
        this.f22941c = expressAdListenerWrapper;
        this.f22942d = str;
        this.f22943e = tTNativeExpressAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i) == null) {
            LogPrinter.e("CSJNativeExpressAd onAdClicked type: " + i, new Object[0]);
            this.f22944f.onAdClicked(this.f22940b, new String[0]);
            this.f22940b = true;
            FunAdInteractionListener funAdInteractionListener = this.f22941c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f22942d;
                pid = this.f22944f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22944f.mPid;
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
            LogPrinter.e("CSJNativeExpressAd onAdShow type: " + i, new Object[0]);
            this.f22944f.onAdShow(this.f22943e, this.a, new String[0]);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f22941c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f22942d;
                pid = this.f22944f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f22944f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i, new Object[0]);
            this.f22944f.onError(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
            this.f22944f.j.put(this.f22943e, this.f22941c);
            this.f22944f.onAdLoaded((c0) this.f22943e);
        }
    }
}
