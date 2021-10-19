package c.a.r0.k2.p;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f20948a;

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f20949b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20950c;

    /* renamed from: d  reason: collision with root package name */
    public int f20951d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20952e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f20953f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f20954g;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20955e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20955e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20955e.m(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20956e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20956e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20956e.f20949b != null) {
                    this.f20956e.f20949b.cancel();
                }
                this.f20956e.f20952e = false;
                this.f20956e.f20951d = 3;
                WebPManager.setPureDrawable(this.f20956e.f20948a, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (float) ((Math.sin((f2 * 18.84955592153876d) - 1.5707963267948966d) * 0.075d) + 1.075d) : invokeF.floatValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f20957e;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20957e = iVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f20957e.f20948a == null) {
                return;
            }
            this.f20957e.f20948a.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f20957e.f20948a.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public i(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20950c = false;
        this.f20951d = 3;
        this.f20952e = false;
        this.f20953f = new a(this);
        this.f20954g = new b(this);
        this.f20948a = imageView;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f20949b = valueAnimator;
        valueAnimator.setDuration(PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        this.f20949b.setFloatValues(0.0f, 1.0f);
        this.f20949b.setInterpolator(new c(this));
        this.f20949b.addUpdateListener(new d(this));
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().c()) {
            c.a.e.e.m.e.a().removeCallbacks(this.f20953f);
            long a2 = TbSingleton.getInstance().getSharePanelConfData().a() * 1000;
            if (a2 <= 0) {
                a2 = 3000;
            }
            c.a.e.e.m.e.a().postDelayed(this.f20953f, a2);
        }
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20951d : invokeV.intValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20950c : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20952e : invokeV.booleanValue;
    }

    public void i() {
        int b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f20950c && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().c() && (b2 = c.a.q0.t.g.f.b()) > 0) {
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f20948a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f20953f);
            c.a.e.e.m.e.a().removeCallbacks(this.f20954g);
            ValueAnimator valueAnimator = this.f20949b;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.f20949b.removeAllUpdateListeners();
                this.f20949b.cancel();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20950c = z;
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f20952e = z;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f20950c = true;
            this.f20951d = i2;
            int b2 = c.a.q0.t.g.f.b();
            if (b2 > 0) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.f20948a, b2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ValueAnimator valueAnimator = this.f20949b;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
                this.f20952e = true;
                if (c.a.q0.b.d.S() || c.a.q0.b.d.T()) {
                    c.a.e.e.m.e.a().postDelayed(this.f20954g, 10000L);
                }
            }
        }
    }
}
