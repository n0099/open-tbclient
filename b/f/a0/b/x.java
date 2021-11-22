package b.f.a0.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.f.a0.b.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class x extends BasePidLoader<SplashAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31817h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<b> f31818i;

    /* loaded from: classes6.dex */
    public class a implements SplashADZoomOutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f31819a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31820b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f31821c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f31822d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f31823e;

        public a(x xVar, SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, splashADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31823e = xVar;
            this.f31821c = splashADArr;
            this.f31822d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.d("isSupportZoomOut", new Object[0]);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                this.f31823e.mReporter.recordOnClicked(this.f31820b);
                this.f31820b = true;
                this.f31823e.onAdClicked();
                b bVar = this.f31823e.f31818i.get();
                if (bVar != null) {
                    String sid = this.f31822d.getSid();
                    FunSplashAdInteractionListener funSplashAdInteractionListener = bVar.f31828e;
                    if (funSplashAdInteractionListener != null) {
                        funSplashAdInteractionListener.onAdClicked(sid);
                    }
                }
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
                x xVar = this.f31823e;
                if (!xVar.f31817h) {
                    xVar.mReporter.recordOnClosed();
                    this.f31823e.onAdClose();
                    return;
                }
                b bVar = xVar.f31818i.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.d();
                this.f31823e.mReporter.recordShowSucceed(this.f31819a);
                this.f31819a = true;
                this.f31823e.onAdShow(this.f31821c[0]);
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                LogPrinter.d();
                this.f31823e.mReporter.recordLoadSucceed();
                SplashAD splashAD = this.f31821c[0];
                this.f31823e.onAdLoaded((x) splashAD);
                this.f31823e.mAdRipper.report(splashAD, this.f31822d.getSid());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                LogPrinter.d();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                int errorCode = adError.getErrorCode();
                LogPrinter.e("onNoAD code: " + errorCode + ", message: " + adError.getErrorMsg(), new Object[0]);
                if (errorCode == 4005) {
                    this.f31823e.mReporter.recordShowFailed(Integer.valueOf(errorCode));
                    this.f31823e.onAdError(errorCode, adError.getErrorMsg());
                    return;
                }
                this.f31823e.mReporter.recordLoadFailed(Integer.valueOf(errorCode));
                this.f31823e.onError(errorCode, adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f31823e.f31817h = true;
                b bVar = this.f31823e.f31818i.get();
                if (bVar != null) {
                    bVar.f31826c = true;
                }
                LogPrinter.d("onZoomOut", new Object[0]);
                this.f31823e.mReporter.recordOnClosed();
                this.f31823e.onAdClose();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                LogPrinter.d("onZoomOutPlayFinish", new Object[0]);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements FunSplashAd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b0 f31824a;

        /* renamed from: b  reason: collision with root package name */
        public SplashAD f31825b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31826c;

        /* renamed from: d  reason: collision with root package name */
        public ViewGroup f31827d;

        /* renamed from: e  reason: collision with root package name */
        public FunSplashAdInteractionListener f31828e;

        /* loaded from: classes6.dex */
        public class a implements b0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f31829a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31829a = bVar;
            }
        }

        public b(SplashAD splashAD) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {splashAD};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31824a = new b0();
            this.f31825b = splashAD;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b0 b0Var = this.f31824a;
                if (b0Var != null) {
                    b0Var.f31767g = null;
                    b0Var.f31768h = null;
                }
                ViewUtils.removeFromParent(this.f31827d);
                this.f31827d = null;
                this.f31824a = null;
                this.f31825b = null;
                this.f31828e = null;
            }
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public void removeMiniWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                a();
            }
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
            InterceptResult invokeCommon;
            b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
                if (activity != null) {
                    if (!this.f31826c) {
                        LogPrinter.d("isZoomOutPulled == false, will not show mini window", new Object[0]);
                        return false;
                    }
                    b0 b0Var = this.f31824a;
                    if (b0Var == null) {
                        return false;
                    }
                    this.f31828e = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
                    a aVar = new a(this);
                    b0Var.getClass();
                    LogPrinter.d("zoomOut startZoomOut activity", new Object[0]);
                    com.fun.module.gdt.t tVar = null;
                    if (viewGroup == null || viewGroup2 == null) {
                        LogPrinter.d("zoomOut animationContainer or zoomOutContainer is null", new Object[0]);
                    } else if (b0Var.f31767g != null && b0Var.f31768h != null) {
                        int[] iArr = new int[2];
                        viewGroup.getLocationOnScreen(iArr);
                        int[] iArr2 = b0Var.k;
                        int i2 = iArr2[0] - iArr[0];
                        int i3 = iArr2[1] - iArr[1];
                        ViewUtils.removeFromParent(b0Var.f31768h);
                        viewGroup.addView(b0Var.f31768h, new FrameLayout.LayoutParams(b0Var.f31769i, b0Var.j));
                        b0Var.f31768h.setX(i2);
                        b0Var.f31768h.setY(i3);
                        View view = b0Var.f31768h;
                        b0Var.f31767g = null;
                        b0Var.f31768h = null;
                        if (view != null) {
                            Context context = viewGroup2.getContext();
                            int[] iArr3 = new int[2];
                            view.getLocationOnScreen(iArr3);
                            int width = view.getWidth();
                            int height = view.getHeight();
                            int width2 = viewGroup.getWidth();
                            int height2 = viewGroup.getHeight();
                            if (width2 == 0) {
                                width2 = b0Var.l;
                            }
                            if (height2 == 0) {
                                height2 = b0Var.m;
                            }
                            int i4 = b0Var.f31761a;
                            float f2 = i4 / width;
                            int i5 = b0Var.f31762b;
                            float f3 = i5 / height;
                            float f4 = b0Var.f31765e == 0 ? b0Var.f31763c : (width2 - b0Var.f31763c) - i4;
                            float f5 = (height2 - b0Var.f31764d) - i5;
                            LogPrinter.d("zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2, new Object[0]);
                            StringBuilder sb = new StringBuilder();
                            sb.append("zoomOut splashScreenX:");
                            sb.append(iArr3[0]);
                            sb.append(" splashScreenY:");
                            sb.append(iArr3[1]);
                            LogPrinter.d(sb.toString(), new Object[0]);
                            LogPrinter.d("zoomOut splashWidth:" + width + " splashHeight:" + height, new Object[0]);
                            LogPrinter.d("zoomOut width:" + b0Var.f31761a + " height:" + b0Var.f31762b, new Object[0]);
                            LogPrinter.d("zoomOut animationDistX:" + f4 + " animationDistY:" + f5, new Object[0]);
                            ViewUtils.removeFromParent(view);
                            viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
                            com.fun.module.gdt.t tVar2 = new com.fun.module.gdt.t(context, b0Var.f31763c);
                            view.setPivotX(0.0f);
                            view.setPivotY(0.0f);
                            if (z) {
                                view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(b0Var.f31766f).setListener(new a0(b0Var, aVar, view, viewGroup2, f4, f5, iArr3, tVar2));
                            } else {
                                b0Var.a(view, viewGroup2, f4, f5, iArr3, tVar2, aVar);
                            }
                            bVar = this;
                            tVar = tVar2;
                            bVar.f31827d = tVar;
                            return true;
                        }
                    } else {
                        LogPrinter.d("zoomOut splashAD or splashView is null", new Object[0]);
                    }
                    bVar = this;
                    bVar.f31827d = tVar;
                    return true;
                }
                throw new IllegalArgumentException();
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Ssp.Pid pid) {
        super(pid, true, false, true);
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
                super((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31818i = new WeakReference<>(null);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new i(pid) : (AdRipper) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(SplashAD splashAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, splashAD) == null) {
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.f31817h = false;
            a aVar = new a(this, r0, funAdSlot);
            this.mReporter.recordLoadStart(funAdSlot, this.mPid);
            SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.mPid.pid, aVar, 0);
            SplashAD[] splashADArr = {splashAD};
            splashAD.fetchAdOnly();
            onLoadStart();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, splashAD)) == null) {
            this.mReporter.recordShowStart();
            splashAD.showAd(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, splashAD)) == null) {
            SplashAD splashAD2 = splashAD;
            this.mReporter.recordShowStart();
            splashAD2.showAd(viewGroup);
            b bVar = new b(splashAD2);
            this.f31818i = new WeakReference<>(bVar);
            View decorView = activity.getWindow().getDecorView();
            b0 b0Var = bVar.f31824a;
            if (b0Var != null) {
                b0Var.f31767g = bVar.f31825b;
                b0Var.f31768h = viewGroup;
                viewGroup.getLocationOnScreen(b0Var.k);
                b0Var.f31769i = viewGroup.getWidth();
                b0Var.j = viewGroup.getHeight();
                b0Var.l = decorView.getWidth();
                b0Var.m = decorView.getHeight();
            }
            return bVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
