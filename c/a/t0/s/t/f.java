package c.a.t0.s.t;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.p0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f14052e;

    /* renamed from: f  reason: collision with root package name */
    public View f14053f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f14054g;

    /* renamed from: h  reason: collision with root package name */
    public View f14055h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14056i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f14057j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Drawable s;
    public View.OnClickListener t;
    public final Runnable u;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14058e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14058e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14058e.e();
            }
        }
    }

    public f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 1.0f;
        this.o = 5000;
        this.u = new a(this);
        if (activity == null) {
            return;
        }
        this.f14052e = activity;
        this.r = c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbds114);
        this.p = c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbds84);
        this.q = c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbds44);
        this.m = c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbds222);
        this.l = c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(c.a.u0.a4.h.text_toast_layout, (ViewGroup) null);
        this.f14054g = (ViewGroup) inflate.findViewById(c.a.u0.a4.g.layout_container);
        this.f14055h = inflate.findViewById(c.a.u0.a4.g.background);
        this.f14056i = (TextView) inflate.findViewById(c.a.u0.a4.g.toast_tv);
        this.f14053f = inflate;
        this.f14055h.setBackgroundDrawable(b());
        this.f14056i.setMaxLines(1);
        this.f14056i.setGravity(17);
        this.f14056i.setTextSize(0, c.a.d.f.p.n.f(activity, c.a.u0.a4.e.tbfontsize40));
        this.f14056i.setTextColor(this.f14052e.getResources().getColor(c.a.u0.a4.d.CAM_X0101));
        TextView textView = this.f14056i;
        int i4 = this.q;
        textView.setPadding(i4, 0, i4, 0);
        this.f14057j = (WindowManager) this.f14052e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = c.a.d.f.p.n.k(this.f14052e) - (this.l * 2);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.height = this.r;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = c.a.u0.a4.k.ToastAnimation;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.k.alpha = this.n;
    }

    public static f f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            f fVar = new f(activity);
            fVar.a(str);
            return fVar;
        }
        return (f) invokeLL.objValue;
    }

    public final f a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f14052e != null && !TextUtils.isEmpty(str)) {
                String e2 = p0.e(str, 34);
                int t = c.a.d.f.p.n.t(this.f14056i.getPaint(), e2);
                ViewGroup.LayoutParams layoutParams = this.f14054g.getLayoutParams();
                layoutParams.width = t + (this.q * 2);
                this.f14054g.setLayoutParams(layoutParams);
                this.f14056i.setText(e2);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.s == null) {
                this.s = c();
            }
            return this.s;
        }
        return (Drawable) invokeV.objValue;
    }

    public final GradientDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{c.a.u0.z1.o.k.b.b("#FF722B"), c.a.u0.z1.o.k.b.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.p);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m + UtilHelper.getNavigationBarHeight(this.f14052e) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            if (this.f14053f.getWindowToken() != null) {
                this.f14057j.removeView(this.f14053f);
            }
        }
    }

    public f g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 > 0) {
                this.o = i2 * 1000;
            }
            return this;
        }
        return (f) invokeI.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.t = onClickListener;
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.f14054g.setTag(obj);
            this.f14054g.setOnClickListener(this);
        }
    }

    public f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            View view = this.f14053f;
            if (view != null && view.getWindowToken() != null) {
                this.f14057j.removeView(this.f14053f);
            }
            this.f14057j.addView(this.f14053f, this.k);
            c.a.d.f.m.e.a().postDelayed(this.u, this.o);
            return this;
        }
        return (f) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            View.OnClickListener onClickListener = this.t;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            e();
        }
    }
}
