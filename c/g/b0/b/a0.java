package c.g.b0.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.g.b0.b.w;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.PxUtils;
import com.fun.ad.sdk.internal.api.utils.ViewUtils;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes9.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f28269b;

    /* renamed from: c  reason: collision with root package name */
    public int f28270c;

    /* renamed from: d  reason: collision with root package name */
    public int f28271d;

    /* renamed from: e  reason: collision with root package name */
    public int f28272e;

    /* renamed from: f  reason: collision with root package name */
    public int f28273f;

    /* renamed from: g  reason: collision with root package name */
    public SplashAD f28274g;

    /* renamed from: h  reason: collision with root package name */
    public View f28275h;

    /* renamed from: i  reason: collision with root package name */
    public int f28276i;

    /* renamed from: j  reason: collision with root package name */
    public int f28277j;
    public int[] k;
    public int l;
    public int m;

    /* loaded from: classes9.dex */
    public interface a {
    }

    public a0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new int[2];
        Context appContext = GDTADManager.getInstance().getAppContext();
        int round = Math.round(Math.min(PxUtils.getDeviceHeightInPixel(appContext), PxUtils.getDeviceWidthInPixel(appContext)) * 0.3f);
        this.a = round;
        this.f28269b = Math.round((round * 16) / 9);
        this.f28270c = PxUtils.dpToPx(appContext, 6);
        this.f28271d = PxUtils.dpToPx(appContext, 100);
        this.f28272e = 1;
        this.f28273f = 300;
    }

    public final void a(View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2, aVar}) == null) {
            LogPrinter.d("zoomOut onAnimationEnd", new Object[0]);
            ViewUtils.removeFromParent(view);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setX(0.0f);
            view.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f4 = (f2 - iArr2[0]) + iArr[0];
            float f5 = (f3 - iArr2[1]) + iArr[1];
            LogPrinter.d("zoomOut distX:" + f4 + " distY:" + f5, new Object[0]);
            LogPrinter.d("zoomOut containerScreenX:" + iArr2[0] + " containerScreenY:" + iArr2[1], new Object[0]);
            viewGroup2.addView(view, -1, -1);
            viewGroup.addView(viewGroup2, new FrameLayout.LayoutParams(this.a, this.f28269b));
            viewGroup2.setTranslationX(f4);
            viewGroup2.setTranslationY(f5);
            if (aVar != null) {
                ((w.b.a) aVar).a.f28314b.zoomOutAnimationFinish();
            }
        }
    }
}
