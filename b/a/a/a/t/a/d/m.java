package b.a.a.a.t.a.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.a.a.r;
import b.a.a.a.t.a.d.q;
import b.a.a.a.u.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m extends b.a.a.a.c<SplashAD> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<SplashAD, String> o;
    public boolean p;
    public WeakReference<b> q;

    /* loaded from: classes.dex */
    public class a implements SplashADZoomOutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f1265a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1266b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SplashAD[] f1267c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FunAdSlot f1268d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ m f1269e;

        public a(m mVar, SplashAD[] splashADArr, FunAdSlot funAdSlot) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, splashADArr, funAdSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1269e = mVar;
            this.f1267c = splashADArr;
            this.f1268d = funAdSlot;
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.a.a.x.d.b("isSupportZoomOut", new Object[0]);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.a.a.x.d.a();
                this.f1269e.f1057h.f(this.f1266b);
                this.f1266b = true;
                this.f1269e.r();
                b bVar = this.f1269e.q.get();
                if (bVar != null) {
                    String sid = this.f1268d.getSid();
                    FunSplashAdInteractionListener funSplashAdInteractionListener = bVar.f1274e;
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
                b.a.a.a.x.d.a();
                m mVar = this.f1269e;
                if (!mVar.p) {
                    mVar.f1057h.m();
                    this.f1269e.s();
                    return;
                }
                b bVar = mVar.q.get();
                if (bVar != null) {
                    bVar.a();
                }
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b.a.a.a.x.d.a();
                this.f1269e.f1057h.k(this.f1265a);
                this.f1265a = true;
                SplashAD splashAD = this.f1267c[0];
                m mVar = this.f1269e;
                mVar.i(splashAD, mVar.o.remove(splashAD));
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
                b.a.a.a.x.d.a();
                this.f1269e.f1057h.h();
                SplashAD splashAD = this.f1267c[0];
                this.f1269e.o.put(splashAD, this.f1268d.getSid());
                m mVar = this.f1269e;
                mVar.h(splashAD);
                mVar.u();
                this.f1269e.m.c(splashAD, this.f1268d.getSid());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                b.a.a.a.x.d.a();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
                b.a.a.a.x.d.a();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, adError) == null) {
                int errorCode = adError.getErrorCode();
                b.a.a.a.x.d.f("onNoAD code: " + errorCode + ", message: " + adError.getErrorMsg(), new Object[0]);
                if (errorCode == 4005) {
                    this.f1269e.f1057h.j(Integer.valueOf(errorCode));
                    this.f1269e.g(errorCode, adError.getErrorMsg());
                    return;
                }
                this.f1269e.f1057h.e(Integer.valueOf(errorCode));
                this.f1269e.n(errorCode, adError.getErrorMsg());
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f1269e.p = true;
                b bVar = this.f1269e.q.get();
                if (bVar != null) {
                    bVar.f1272c = true;
                }
                b.a.a.a.x.d.b("onZoomOut", new Object[0]);
                this.f1269e.f1057h.m();
                this.f1269e.s();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                b.a.a.a.x.d.b("onZoomOutPlayFinish", new Object[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements FunSplashAd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public q f1270a;

        /* renamed from: b  reason: collision with root package name */
        public SplashAD f1271b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1272c;

        /* renamed from: d  reason: collision with root package name */
        public ViewGroup f1273d;

        /* renamed from: e  reason: collision with root package name */
        public FunSplashAdInteractionListener f1274e;

        /* loaded from: classes.dex */
        public class a implements q.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f1275a;

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
                this.f1275a = bVar;
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
            this.f1270a = new q();
            this.f1271b = splashAD;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q qVar = this.f1270a;
                if (qVar != null) {
                    qVar.f1298g = null;
                    qVar.f1299h = null;
                }
                r.g(this.f1273d);
                this.f1273d = null;
                this.f1270a = null;
                this.f1271b = null;
                this.f1274e = null;
            }
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public void removeMiniWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                b.a.a.a.x.d.a();
                a();
            }
        }

        @Override // com.fun.ad.sdk.FunSplashAd
        public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
            InterceptResult invokeCommon;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
                if (activity != null) {
                    if (!this.f1272c) {
                        b.a.a.a.x.d.b("isZoomOutPulled == false, will not show mini window", new Object[0]);
                        return false;
                    } else if (this.f1270a == null) {
                        return false;
                    } else {
                        this.f1274e = funSplashAdInteractionListener;
                        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                        q qVar = this.f1270a;
                        a aVar = new a(this);
                        a.a.a.a.s.a.d.p pVar = null;
                        if (qVar != null) {
                            b.a.a.a.x.d.b("zoomOut startZoomOut activity", new Object[0]);
                            if (viewGroup == null) {
                                b.a.a.a.x.d.b("zoomOut animationContainer or zoomOutContainer is null", new Object[0]);
                            } else if (qVar.f1298g != null && qVar.f1299h != null) {
                                int[] iArr = new int[2];
                                viewGroup.getLocationOnScreen(iArr);
                                int[] iArr2 = qVar.k;
                                int i3 = iArr2[0] - iArr[0];
                                int i4 = iArr2[1] - iArr[1];
                                r.g(qVar.f1299h);
                                viewGroup.addView(qVar.f1299h, new FrameLayout.LayoutParams(qVar.f1300i, qVar.f1301j));
                                qVar.f1299h.setX(i3);
                                qVar.f1299h.setY(i4);
                                View view = qVar.f1299h;
                                qVar.f1298g = null;
                                qVar.f1299h = null;
                                if (view != null) {
                                    Context context = viewGroup.getContext();
                                    int[] iArr3 = new int[2];
                                    view.getLocationOnScreen(iArr3);
                                    int width = view.getWidth();
                                    int height = view.getHeight();
                                    qVar.o = viewGroup.getWidth();
                                    qVar.n = viewGroup.getHeight();
                                    if (qVar.o == 0) {
                                        qVar.o = qVar.l;
                                    }
                                    if (qVar.n == 0) {
                                        qVar.n = qVar.m;
                                    }
                                    float f2 = qVar.f1293b / width;
                                    float f3 = qVar.f1294c / height;
                                    float f4 = qVar.f1296e == 0 ? qVar.f1295d : (qVar.o - qVar.f1295d) - i2;
                                    float f5 = qVar.n - qVar.f1292a;
                                    b.a.a.a.x.d.b("zoomOut animationContainerWidth:" + qVar.o + " animationContainerHeight:" + qVar.n, new Object[0]);
                                    b.a.a.a.x.d.b("zoomOut splashScreenX:" + iArr3[0] + " splashScreenY:" + iArr3[1], new Object[0]);
                                    b.a.a.a.x.d.b("zoomOut splashWidth:" + width + " splashHeight:" + height, new Object[0]);
                                    b.a.a.a.x.d.b("zoomOut width:" + qVar.f1293b + " height:" + qVar.f1294c, new Object[0]);
                                    b.a.a.a.x.d.b("zoomOut animationDistX:" + f4 + " animationDistY:" + f5, new Object[0]);
                                    r.g(view);
                                    viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
                                    a.a.a.a.s.a.d.p pVar2 = new a.a.a.a.s.a.d.p(context, qVar.f1295d);
                                    view.setPivotX(0.0f);
                                    view.setPivotY(0.0f);
                                    if (z) {
                                        view.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(qVar.f1297f).setListener(new p(qVar, aVar, view, viewGroup, f4, f5, iArr3, pVar2));
                                    } else {
                                        qVar.a(view, viewGroup, f4, f5, iArr3, pVar2, aVar);
                                    }
                                    pVar = pVar2;
                                }
                            } else {
                                b.a.a.a.x.d.b("zoomOut splashAD or splashView is null", new Object[0]);
                            }
                            this.f1273d = pVar;
                            return true;
                        }
                        throw null;
                    }
                }
                throw new IllegalArgumentException();
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h.a aVar) {
        super(aVar, true, false, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((h.a) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new HashMap<>();
        this.q = new WeakReference<>(null);
    }

    @Override // b.a.a.a.c
    public b.a.a.a.w.a e(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? new b.a.a.a.w.j(aVar) : (b.a.a.a.w.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public boolean k(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, str, splashAD)) == null) {
            SplashAD splashAD2 = splashAD;
            this.f1057h.p();
            this.o.put(splashAD2, str);
            splashAD2.showAd(viewGroup);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.app.Activity, android.view.ViewGroup, java.lang.String, java.lang.Object] */
    @Override // b.a.a.a.c
    public FunSplashAd m(Activity activity, ViewGroup viewGroup, String str, SplashAD splashAD) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, str, splashAD)) == null) {
            SplashAD splashAD2 = splashAD;
            this.f1057h.p();
            this.o.put(splashAD2, str);
            splashAD2.showAd(viewGroup);
            b bVar = new b(splashAD2);
            this.q = new WeakReference<>(bVar);
            View decorView = activity.getWindow().getDecorView();
            q qVar = bVar.f1270a;
            if (qVar != null) {
                qVar.f1298g = bVar.f1271b;
                qVar.f1299h = viewGroup;
                viewGroup.getLocationOnScreen(qVar.k);
                qVar.f1300i = viewGroup.getWidth();
                qVar.f1301j = viewGroup.getHeight();
                qVar.l = decorView.getWidth();
                qVar.m = decorView.getHeight();
            }
            return bVar;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    @Override // b.a.a.a.c
    public void o(Context context, FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, funAdSlot) == null) {
            this.p = false;
            a aVar = new a(this, r0, funAdSlot);
            this.f1057h.d(funAdSlot, this.f1058i);
            SplashAD splashAD = new SplashAD(context.getApplicationContext(), this.f1058i.f1448c, aVar, 0);
            SplashAD[] splashADArr = {splashAD};
            splashAD.fetchAdOnly();
            t();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.a.a.a.c
    public void p(SplashAD splashAD) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, splashAD) == null) {
            this.o.remove(splashAD);
        }
    }
}
