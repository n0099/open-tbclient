package c.g.a0.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.g.a0.b.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.fun.ad.sdk.internal.api.ReporterPidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class w extends ReporterPidLoader<SplashAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28726h;

    /* renamed from: i  reason: collision with root package name */
    public WeakReference<b> f28727i;

    /* loaded from: classes7.dex */
    public class a implements SplashADZoomOutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28728b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f28729c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f28730d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f28731e;

        public a(w wVar, SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, splashADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28731e = wVar;
            this.f28729c = splashADArr;
            this.f28730d = funAdSlot;
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
                this.f28731e.onAdClicked(this.f28728b);
                this.f28728b = true;
                b bVar = this.f28731e.f28727i.get();
                if (bVar != null) {
                    String sid = this.f28730d.getSid();
                    FunSplashAdInteractionListener funSplashAdInteractionListener = bVar.f28735e;
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
                w wVar = this.f28731e;
                if (!wVar.f28726h) {
                    wVar.onAdClose();
                    return;
                }
                b bVar = wVar.f28727i.get();
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
                this.f28731e.onAdShow(this.f28729c[0], this.a);
                this.a = true;
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                LogPrinter.d();
                this.f28731e.onAdLoaded((w) this.f28729c[0]);
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
        public void onADTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
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
                    this.f28731e.onAdError(errorCode, adError.getErrorMsg());
                } else {
                    this.f28731e.onError(errorCode, adError.getErrorMsg());
                }
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f28731e.f28726h = true;
                b bVar = this.f28731e.f28727i.get();
                if (bVar != null) {
                    bVar.f28733c = true;
                }
                LogPrinter.d("onZoomOut", new Object[0]);
                this.f28731e.onAdClose();
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

    /* loaded from: classes7.dex */
    public static class b implements FunSplashAd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a0 a;

        /* renamed from: b  reason: collision with root package name */
        public SplashAD f28732b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28733c;

        /* renamed from: d  reason: collision with root package name */
        public ViewGroup f28734d;

        /* renamed from: e  reason: collision with root package name */
        public FunSplashAdInteractionListener f28735e;

        /* loaded from: classes7.dex */
        public class a implements a0.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

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
                this.a = bVar;
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
            this.a = new a0();
            this.f28732b = splashAD;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a0 a0Var = this.a;
                if (a0Var != null) {
                    a0Var.f28691g = null;
                    a0Var.f28692h = null;
                }
                ViewUtils.removeFromParent(this.f28734d);
                this.f28734d = null;
                this.a = null;
                this.f28732b = null;
                this.f28735e = null;
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
                    if (!this.f28733c) {
                        LogPrinter.d("isZoomOutPulled == false, will not show mini window", new Object[0]);
                        return false;
                    }
                    a0 a0Var = this.a;
                    if (a0Var == null) {
                        return false;
                    }
                    this.f28735e = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
                    a aVar = new a(this);
                    a0Var.getClass();
                    LogPrinter.d("zoomOut startZoomOut activity", new Object[0]);
                    com.fun.module.gdt.s sVar = null;
                    if (viewGroup == null || viewGroup2 == null) {
                        LogPrinter.d("zoomOut animationContainer or zoomOutContainer is null", new Object[0]);
                    } else if (a0Var.f28691g != null && a0Var.f28692h != null) {
                        int[] iArr = new int[2];
                        viewGroup.getLocationOnScreen(iArr);
                        int[] iArr2 = a0Var.f28695k;
                        int i2 = iArr2[0] - iArr[0];
                        int i3 = iArr2[1] - iArr[1];
                        ViewUtils.removeFromParent(a0Var.f28692h);
                        viewGroup.addView(a0Var.f28692h, new FrameLayout.LayoutParams(a0Var.f28693i, a0Var.f28694j));
                        a0Var.f28692h.setX(i2);
                        a0Var.f28692h.setY(i3);
                        View view = a0Var.f28692h;
                        a0Var.f28691g = null;
                        a0Var.f28692h = null;
                        if (view != null) {
                            Context context = viewGroup2.getContext();
                            int[] iArr3 = new int[2];
                            view.getLocationOnScreen(iArr3);
                            int width = view.getWidth();
                            int height = view.getHeight();
                            int width2 = viewGroup.getWidth();
                            int height2 = viewGroup.getHeight();
                            if (width2 == 0) {
                                width2 = a0Var.l;
                            }
                            if (height2 == 0) {
                                height2 = a0Var.m;
                            }
                            int i4 = a0Var.a;
                            float f2 = i4 / width;
                            int i5 = a0Var.f28686b;
                            float f3 = i5 / height;
                            float f4 = a0Var.f28689e == 0 ? a0Var.f28687c : (width2 - a0Var.f28687c) - i4;
                            float f5 = (height2 - a0Var.f28688d) - i5;
                            LogPrinter.d("zoomOut animationContainerWidth:" + width2 + " animationContainerHeight:" + height2, new Object[0]);
                            StringBuilder sb = new StringBuilder();
                            sb.append("zoomOut splashScreenX:");
                            sb.append(iArr3[0]);
                            sb.append(" splashScreenY:");
                            sb.append(iArr3[1]);
                            LogPrinter.d(sb.toString(), new Object[0]);
                            LogPrinter.d("zoomOut splashWidth:" + width + " splashHeight:" + height, new Object[0]);
                            LogPrinter.d("zoomOut width:" + a0Var.a + " height:" + a0Var.f28686b, new Object[0]);
                            LogPrinter.d("zoomOut animationDistX:" + f4 + " animationDistY:" + f5, new Object[0]);
                            ViewUtils.removeFromParent(view);
                            viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
                            com.fun.module.gdt.s sVar2 = new com.fun.module.gdt.s(context, a0Var.f28687c);
                            view.setPivotX(0.0f);
                            view.setPivotY(0.0f);
                            if (z) {
                                view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(a0Var.f28690f).setListener(new z(a0Var, aVar, view, viewGroup2, f4, f5, iArr3, sVar2));
                            } else {
                                a0Var.a(view, viewGroup2, f4, f5, iArr3, sVar2, aVar);
                            }
                            bVar = this;
                            sVar = sVar2;
                            bVar.f28734d = sVar;
                            return true;
                        }
                    } else {
                        LogPrinter.d("zoomOut splashAD or splashView is null", new Object[0]);
                    }
                    bVar = this;
                    bVar.f28734d = sVar;
                    return true;
                }
                throw new IllegalArgumentException();
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Ssp.Pid pid) {
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
        this.f28727i = new WeakReference<>(null);
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) ? new h(pid) : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void destroyInternal(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            SplashAD splashAD = (SplashAD) obj;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public void loadInternal(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, funAdSlot) == null) {
            this.f28726h = false;
            a aVar = new a(this, r0, funAdSlot);
            onLoadStart(funAdSlot);
            SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.mPid.pid, aVar, 0);
            SplashAD[] splashADArr = {splashAD};
            splashAD.fetchAdOnly();
        }
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, activity, viewGroup, str, obj)) == null) {
            onShowStart();
            ((SplashAD) obj).showAd(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.BasePidLoader
    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, activity, viewGroup, str, obj)) == null) {
            SplashAD splashAD = (SplashAD) obj;
            onShowStart();
            splashAD.showAd(viewGroup);
            b bVar = new b(splashAD);
            this.f28727i = new WeakReference<>(bVar);
            View decorView = activity.getWindow().getDecorView();
            a0 a0Var = bVar.a;
            if (a0Var != null) {
                a0Var.f28691g = bVar.f28732b;
                a0Var.f28692h = viewGroup;
                viewGroup.getLocationOnScreen(a0Var.f28695k);
                a0Var.f28693i = viewGroup.getWidth();
                a0Var.f28694j = viewGroup.getHeight();
                a0Var.l = decorView.getWidth();
                a0Var.m = decorView.getHeight();
            }
            return bVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
