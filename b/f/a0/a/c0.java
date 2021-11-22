package b.f.a0.a;

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
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class c0 implements TTNativeExpressAd.ExpressAdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31653a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExpressAdListenerWrapper f31655c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f31656d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeExpressAd f31657e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ b0 f31658f;

    public c0(b0 b0Var, ExpressAdListenerWrapper expressAdListenerWrapper, String str, TTNativeExpressAd tTNativeExpressAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b0Var, expressAdListenerWrapper, str, tTNativeExpressAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31658f = b0Var;
        this.f31655c = expressAdListenerWrapper;
        this.f31656d = str;
        this.f31657e = tTNativeExpressAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
            LogPrinter.e("CSJNativeExpressAd onAdClicked type: " + i2, new Object[0]);
            adReporter = this.f31658f.mReporter;
            adReporter.recordOnClicked(this.f31654b);
            this.f31654b = true;
            this.f31658f.onAdClicked();
            FunAdInteractionListener funAdInteractionListener = this.f31655c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f31656d;
                pid = this.f31658f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f31658f.mPid;
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
            LogPrinter.e("CSJNativeExpressAd onAdShow type: " + i2, new Object[0]);
            adReporter = this.f31658f.mReporter;
            adReporter.recordShowSucceed(this.f31653a);
            this.f31653a = true;
            this.f31658f.onAdShow(this.f31657e);
            FunAdInteractionListener funAdInteractionListener = this.f31655c.funListener;
            if (funAdInteractionListener != null) {
                String str = this.f31656d;
                pid = this.f31658f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f31658f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderFail message: " + str + ", code:" + i2, new Object[0]);
            adReporter = this.f31658f.mReporter;
            adReporter.recordRenderFailed(i2);
            this.f31658f.onError(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        AdReporter adReporter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            LogPrinter.e("CSJNativeExpressAd onRenderSuccess width: " + f2 + ", height:" + f3, new Object[0]);
            adReporter = this.f31658f.mReporter;
            adReporter.recordRenderSucceed();
            this.f31658f.f31650i.put(this.f31657e, this.f31655c);
            this.f31658f.onAdLoaded((b0) this.f31657e);
        }
    }
}
