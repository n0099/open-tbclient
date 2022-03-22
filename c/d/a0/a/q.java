package c.d.a0.a;

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
public class q implements FunSplashAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TTSplashAd a;

    /* renamed from: b  reason: collision with root package name */
    public final View f22974b;

    /* renamed from: c  reason: collision with root package name */
    public final Pair<Integer, Integer> f22975c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22976d;

    /* renamed from: e  reason: collision with root package name */
    public final int f22977e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22978f;

    /* renamed from: g  reason: collision with root package name */
    public int f22979g;

    /* renamed from: h  reason: collision with root package name */
    public int f22980h;
    public FrameLayout i;
    public FunSplashAdInteractionListener j;

    /* loaded from: classes3.dex */
    public class a implements ISplashClickEyeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ISplashClickEyeListener
        public boolean isSupportSplashClickEye(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                this.a.f22978f = z;
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
                ViewUtils.removeFromParent(this.a.i);
                this.a.i = null;
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
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ float f22981b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f22982c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int[] f22983d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22984e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f22985f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q f22986g;

        public b(q qVar, ViewGroup viewGroup, float f2, float f3, int[] iArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22986g = qVar;
            this.a = viewGroup;
            this.f22981b = f2;
            this.f22982c = f3;
            this.f22983d = iArr;
            this.f22984e = i;
            this.f22985f = i2;
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
                this.f22986g.a(this.a, this.f22981b, this.f22982c, this.f22983d, this.f22984e, this.f22985f);
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

    public q(TTSplashAd tTSplashAd) {
        Integer valueOf;
        int round;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tTSplashAd};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22976d = PxUtils.dp2px(16.0f);
        this.f22977e = PxUtils.dp2px(100.0f);
        this.i = new FrameLayout(FunAdSdk.getAppContext());
        tTSplashAd.setSplashClickEyeListener(new a(this));
        this.a = tTSplashAd;
        this.f22974b = tTSplashAd.getSplashView();
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
        this.f22975c = Pair.create(valueOf, Integer.valueOf(round));
    }

    public final void a(ViewGroup viewGroup, float f2, float f3, int[] iArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            ViewUtils.removeFromParent(this.f22974b);
            this.f22974b.setScaleX(1.0f);
            this.f22974b.setScaleY(1.0f);
            this.f22974b.setX(0.0f);
            this.f22974b.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f4 = (f3 - iArr2[1]) + iArr[1];
            this.i.addView(this.f22974b, -1, -1);
            viewGroup.addView(this.i, new FrameLayout.LayoutParams(i, i2));
            this.i.setTranslationX((f2 - iArr2[0]) + iArr[0]);
            this.i.setTranslationY(f4);
            this.a.splashClickEyeAnimationFinish();
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public void removeMiniWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LogPrinter.d();
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                ViewUtils.removeFromParent(frameLayout);
                this.i = null;
            }
            this.j = null;
        }
    }

    @Override // com.fun.ad.sdk.FunSplashAd
    public boolean showMiniWindow(Activity activity, boolean z, FunSplashAdInteractionListener funSplashAdInteractionListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Boolean.valueOf(z), funSplashAdInteractionListener})) == null) {
            if (activity != null) {
                if (!this.f22978f) {
                    LogPrinter.d("showMiniWindow failed without support", new Object[0]);
                    return false;
                } else if (this.i == null) {
                    LogPrinter.d("showMiniWindow failed:Can't showMiniWindow again", new Object[0]);
                    return false;
                } else {
                    this.j = funSplashAdInteractionListener;
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(16908290);
                    int[] iArr = new int[2];
                    this.f22974b.getLocationOnScreen(iArr);
                    int width = this.f22974b.getWidth();
                    int height = this.f22974b.getHeight();
                    int i = this.f22979g;
                    int i2 = this.f22980h;
                    if (i == 0 || i2 == 0) {
                        LogPrinter.d("showMiniWindow failed without invalid origin view width and height", new Object[0]);
                        return false;
                    }
                    int intValue = ((Integer) this.f22975c.first).intValue();
                    int intValue2 = ((Integer) this.f22975c.second).intValue();
                    float f2 = intValue / width;
                    float f3 = intValue2 / height;
                    float f4 = (i - this.f22976d) - intValue;
                    float f5 = (i2 - this.f22977e) - intValue2;
                    ViewUtils.removeFromParent(this.f22974b);
                    viewGroup.addView(this.f22974b, new FrameLayout.LayoutParams(width, height));
                    this.f22974b.setPivotX(0.0f);
                    this.f22974b.setPivotY(0.0f);
                    if (z) {
                        this.f22974b.animate().scaleX(f2).scaleY(f3).x(f4).y(f5).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(300L).setListener(new b(this, viewGroup2, f4, f5, iArr, intValue, intValue2));
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
