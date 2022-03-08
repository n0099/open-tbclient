package c.g.b0.a;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes3.dex */
public class n implements TTNativeAd.AdInteractionListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FunAdInteractionListener f28269c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f28270d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TTNativeAd f28271e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f28272f;

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
        this.f28272f = kVar;
        this.f28269c = funAdInteractionListener;
        this.f28270d = str;
        this.f28271e = tTNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            this.f28272f.onAdClicked(this.f28268b);
            this.f28268b = true;
            FunAdInteractionListener funAdInteractionListener = this.f28269c;
            if (funAdInteractionListener != null) {
                String str = this.f28270d;
                pid = this.f28272f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28272f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, tTNativeAd) == null) {
            LogPrinter.d();
            this.f28272f.onAdClicked(this.f28268b);
            this.f28268b = true;
            FunAdInteractionListener funAdInteractionListener = this.f28269c;
            if (funAdInteractionListener != null) {
                String str = this.f28270d;
                pid = this.f28272f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28272f.mPid;
                funAdInteractionListener.onAdClicked(str, str2, pid2.pid);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        Ssp.Pid pid;
        Ssp.Pid pid2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tTNativeAd) == null) {
            LogPrinter.d();
            this.f28272f.onAdShow(this.f28271e, this.a);
            this.a = true;
            FunAdInteractionListener funAdInteractionListener = this.f28269c;
            if (funAdInteractionListener != null) {
                String str = this.f28270d;
                pid = this.f28272f.mPid;
                String str2 = pid.ssp.type;
                pid2 = this.f28272f.mPid;
                funAdInteractionListener.onAdShow(str, str2, pid2.pid);
            }
        }
    }
}
