package b.g.a0.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class n implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f30840a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30841b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FunAdInteractionListener f30842c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f30843d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f30844e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f30845f;

    public n(k kVar, FunAdInteractionListener funAdInteractionListener, String str, TTNativeAd tTNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, funAdInteractionListener, str, tTNativeAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30845f = kVar;
        this.f30842c = funAdInteractionListener;
        this.f30843d = str;
        this.f30844e = tTNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30845f.mReporter;
            adReporter.recordOnClicked(this.f30841b);
            this.f30841b = true;
            this.f30845f.onAdClicked();
            FunAdInteractionListener funAdInteractionListener = this.f30842c;
            if (funAdInteractionListener != null) {
                String str = this.f30843d;
                pid = this.f30845f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30845f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30845f.mReporter;
            adReporter.recordOnClicked(this.f30841b);
            this.f30841b = true;
            this.f30845f.onAdClicked();
            FunAdInteractionListener funAdInteractionListener = this.f30842c;
            if (funAdInteractionListener != null) {
                String str = this.f30843d;
                pid = this.f30845f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30845f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        AdReporter adReporter;
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            adReporter = this.f30845f.mReporter;
            adReporter.recordShowSucceed(this.f30840a);
            this.f30840a = true;
            this.f30845f.onAdShow(this.f30844e);
            FunAdInteractionListener funAdInteractionListener = this.f30842c;
            if (funAdInteractionListener != null) {
                String str = this.f30843d;
                pid = this.f30845f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f30845f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }
}
