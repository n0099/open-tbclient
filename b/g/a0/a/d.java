package b.g.a0.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
/* loaded from: classes6.dex */
public class d extends q<TTSplashAd> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements TTAdNative.SplashAdListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f30801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f30802b;

        public a(d dVar, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30802b = dVar;
            this.f30801a = funAdSlot;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
        @MainThread
        public void onError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                LogPrinter.e("CSJSplashAd onError code: " + i2 + ", message: " + str, new Object[0]);
                this.f30802b.mReporter.recordLoadFailed(Integer.valueOf(i2));
                this.f30802b.onError(i2, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onSplashAdLoad(TTSplashAd tTSplashAd) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tTSplashAd) == null) {
                LogPrinter.d();
                this.f30802b.mReporter.recordLoadSucceed();
                this.f30802b.onAdLoaded((d) tTSplashAd);
                this.f30802b.mAdRipper.report(tTSplashAd, this.f30801a.getSid());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener
        @MainThread
        public void onTimeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.e();
                this.f30802b.mReporter.recordLoadFailed("TimeOut");
                this.f30802b.onError(0, "Load Timeout");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TTSplashAd.AdInteractionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final TTSplashAd f30803a;

        /* renamed from: b  reason: collision with root package name */
        public final String f30804b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f30805c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30806d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f30807e;

        public b(d dVar, TTSplashAd tTSplashAd, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, tTSplashAd, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30807e = dVar;
            this.f30803a = tTSplashAd;
            this.f30804b = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdClicked(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                LogPrinter.d();
                this.f30807e.mReporter.recordOnClicked(this.f30806d);
                this.f30806d = true;
                this.f30807e.onAdClicked();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdShow(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                LogPrinter.d();
                this.f30807e.mReporter.recordShowSucceed(this.f30805c);
                this.f30805c = true;
                this.f30807e.onAdShow(this.f30803a);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                this.f30807e.mReporter.recordSplashSkip();
                this.f30807e.onAdClose();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
        public void onAdTimeOver() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f30807e.mReporter.recordSplashTimeOver();
                this.f30807e.onAdClose();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Ssp.Pid pid) {
        super(pid, false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AdSlot a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new AdSlot.Builder().setCodeId(this.mPid.pid).setSupportDeepLink(true).setImageAcceptedSize(1080, 1920).build() : (AdSlot) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
        }
    }

    public final boolean e(ViewGroup viewGroup, TTSplashAd tTSplashAd, TTSplashAd.AdInteractionListener adInteractionListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, tTSplashAd, adInteractionListener)) == null) {
            View splashView = tTSplashAd.getSplashView();
            if (splashView.getParent() != null) {
                ((ViewGroup) splashView.getParent()).removeView(splashView);
            }
            viewGroup.removeAllViews();
            viewGroup.addView(splashView);
            this.mReporter.recordShowStart();
            tTSplashAd.setSplashInteractionListener(adInteractionListener);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // b.g.a0.a.q, com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            super.loadInternal(context, funAdSlot);
            AdSlot a2 = a();
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            this.f30863h.loadSplashAd(a2, new a(this, funAdSlot), 5000);
            onLoadStart();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
            e(viewGroup, tTSplashAd, new b(this, tTSplashAd, str));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, activity, viewGroup, str, obj)) == null) {
            TTSplashAd tTSplashAd = (TTSplashAd) obj;
            o oVar = new o(tTSplashAd);
            e(viewGroup, tTSplashAd, new g(this, tTSplashAd, str, oVar));
            return oVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
