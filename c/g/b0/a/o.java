package c.g.b0.a;

import android.animation.Animator;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.FunSplashAdInteractionListener;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
/* loaded from: classes3.dex */
public class o implements FunSplashAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTSplashAd a;

    /* renamed from: b  reason: collision with root package name */
    public final View f28273b;

    /* renamed from: c  reason: collision with root package name */
    public final Pair<Integer, Integer> f28274c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28275d;

    /* renamed from: e  reason: collision with root package name */
    public final int f28276e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28277f;

    /* renamed from: g  reason: collision with root package name */
    public int f28278g;

    /* renamed from: h  reason: collision with root package name */
    public int f28279h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f28280i;

    /* renamed from: j  reason: collision with root package name */
    public FunSplashAdInteractionListener f28281j;

    /* loaded from: classes3.dex */
    public class a implements ISplashClickEyeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o a;

        public a(o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public boolean isSupportSplashClickEye(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.a.f28277f = z;
                LogPrinter.d("isSupportSplashClickEye:" + z, new Object[0]);
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public void onSplashClickEyeAnimationFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                LogPrinter.d();
                ViewUtils.removeFromParent(this.a.f28280i);
                this.a.f28280i = null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public void onSplashClickEyeAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.d();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f28282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f28283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f28284g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int[] f28285h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f28286i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f28287j;
        public final /* synthetic */ o k;

        public b(o oVar, ViewGroup viewGroup, float f2, float f3, int[] iArr, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oVar, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = oVar;
            this.f28282e = viewGroup;
            this.f28283f = f2;
            this.f28284g = f3;
            this.f28285h = iArr;
            this.f28286i = i2;
            this.f28287j = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.k.a(this.f28282e, this.f28283f, this.f28284g, this.f28285h, this.f28286i, this.f28287j);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    public o(TTSplashAd tTSplashAd) {
        Integer valueOf;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTSplashAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f28275d = PxUtils.dp2px(16.0f);
        this.f28276e = PxUtils.dp2px(100.0f);
        this.f28280i = new FrameLayout(FunAdSdk.getAppContext());
        tTSplashAd.setSplashClickEyeListener(new a(this));
        this.a = tTSplashAd;
        this.f28273b = tTSplashAd.getSplashView();
        int[] splashClickEyeSizeToDp = tTSplashAd.getSplashClickEyeSizeToDp();
        if (splashClickEyeSizeToDp == null || splashClickEyeSizeToDp.length != 2) {
            DisplayMetrics displayMetrics = FunAdSdk.getAppContext().getResources().getDisplayMetrics();
            int round2 = Math.round(Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels) * 0.3f);
            valueOf = Integer.valueOf(round2);
            round = Math.round((round2 * 16) / 9.0f);
        } else {
            valueOf = Integer.valueOf(PxUtils.dp2px(splashClickEyeSizeToDp[0]));
            round = PxUtils.dp2px(splashClickEyeSizeToDp[1]);
        }
        this.f28274c = Pair.create(valueOf, Integer.valueOf(round));
    }

    public final void a(ViewGroup viewGroup, float f2, float f3, int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            ViewUtils.removeFromParent(this.f28273b);
            this.f28273b.setScaleX(1.0f);
            this.f28273b.setScaleY(1.0f);
            this.f28273b.setX(0.0f);
            this.f28273b.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f4 = (f3 - iArr2[1]) + iArr[1];
            this.f28280i.addView(this.f28273b, -1, -1);
            viewGroup.addView(this.f28280i, new FrameLayout.LayoutParams(i2, i3));
            this.f28280i.setTranslationX((f2 - iArr2[0]) + iArr[0]);
            this.f28280i.setTranslationY(f4);
            this.a.splashClickEyeAnimationFinish();
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public void removeMiniWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            FrameLayout frameLayout = this.f28280i;
            if (frameLayout != null) {
                ViewUtils.removeFromParent(frameLayout);
                this.f28280i = null;
            }
            this.f28281j = null;
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
            if (activity != null) {
                if (!this.f28277f) {
                    LogPrinter.d("showMiniWindow failed without support", new Object[0]);
                    return false;
                } else if (this.f28280i == null) {
                    LogPrinter.d("showMiniWindow failed:Can't showMiniWindow again", new Object[0]);
                    return false;
                } else {
                    this.f28281j = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(16908290);
                    int[] iArr = new int[2];
                    this.f28273b.getLocationOnScreen(iArr);
                    int width = this.f28273b.getWidth();
                    int height = this.f28273b.getHeight();
                    int i2 = this.f28278g;
                    int i3 = this.f28279h;
                    if (i2 == 0 || i3 == 0) {
                        LogPrinter.d("showMiniWindow failed without invalid origin view width and height", new Object[0]);
                        return false;
                    }
                    int intValue = ((Integer) this.f28274c.first).intValue();
                    int intValue2 = ((Integer) this.f28274c.second).intValue();
                    float f2 = intValue / width;
                    float f3 = intValue2 / height;
                    float f4 = (i2 - this.f28275d) - intValue;
                    float f5 = (i3 - this.f28276e) - intValue2;
                    ViewUtils.removeFromParent(this.f28273b);
                    viewGroup.addView(this.f28273b, new FrameLayout.LayoutParams(width, height));
                    this.f28273b.setPivotX(0.0f);
                    this.f28273b.setPivotY(0.0f);
                    if (z) {
                        this.f28273b.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(300L).setListener(new b(this, viewGroup2, f4, f5, iArr, intValue, intValue2));
                        return true;
                    }
                    a(viewGroup2, f4, f5, iArr, intValue, intValue2);
                    return true;
                }
            }
            throw new IllegalArgumentException();
        }
        return invokeCommon.booleanValue;
    }
}
