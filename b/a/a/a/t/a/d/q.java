package b.a.a.a.t.a.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.a.a.r;
import b.a.a.a.t.a.d.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f1292a;

    /* renamed from: b  reason: collision with root package name */
    public int f1293b;

    /* renamed from: c  reason: collision with root package name */
    public int f1294c;

    /* renamed from: d  reason: collision with root package name */
    public int f1295d;

    /* renamed from: e  reason: collision with root package name */
    public int f1296e;

    /* renamed from: f  reason: collision with root package name */
    public int f1297f;

    /* renamed from: g  reason: collision with root package name */
    public SplashAD f1298g;

    /* renamed from: h  reason: collision with root package name */
    public View f1299h;

    /* renamed from: i  reason: collision with root package name */
    public int f1300i;

    /* renamed from: j  reason: collision with root package name */
    public int f1301j;
    public int[] k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* loaded from: classes.dex */
    public interface a {
    }

    public q() {
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
        GDTADManager.getInstance().getAppContext();
        this.f1292a = 694;
        this.f1293b = 209;
        this.f1294c = 370;
        this.f1295d = 34;
        this.f1296e = 1;
        this.f1297f = 300;
    }

    public final void a(View view, ViewGroup viewGroup, float f2, float f3, int[] iArr, ViewGroup viewGroup2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, viewGroup, Float.valueOf(f2), Float.valueOf(f3), iArr, viewGroup2, aVar}) == null) {
            b.a.a.a.x.d.b("zoomOut onAnimationEnd", new Object[0]);
            r.g(view);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setX(0.0f);
            view.setY(0.0f);
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            float f4 = (f2 - iArr2[0]) + iArr[0];
            float f5 = (f3 - iArr2[1]) + iArr[1];
            b.a.a.a.x.d.b("zoomOut distX:" + f4 + " distY:" + f5, new Object[0]);
            b.a.a.a.x.d.b("zoomOut containerScreenX:" + iArr2[0] + " containerScreenY:" + iArr2[1], new Object[0]);
            viewGroup2.addView(view, -1, -1);
            viewGroup.addView(viewGroup2, new FrameLayout.LayoutParams(this.f1293b, this.f1294c));
            viewGroup2.setTranslationX(f4);
            viewGroup2.setTranslationY(f5);
            if (aVar != null) {
                ((m.b.a) aVar).f1275a.f1271b.zoomOutAnimationFinish();
            }
        }
    }
}
