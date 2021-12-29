package c.a.s0.s.s;

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
import c.a.s0.e1.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
    public Activity f13907e;

    /* renamed from: f  reason: collision with root package name */
    public View f13908f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f13909g;

    /* renamed from: h  reason: collision with root package name */
    public View f13910h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f13911i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f13912j;

    /* renamed from: k  reason: collision with root package name */
    public WindowManager.LayoutParams f13913k;
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
        public final /* synthetic */ f f13914e;

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
            this.f13914e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13914e.e();
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
        this.f13907e = activity;
        this.r = c.a.d.f.p.n.f(activity, R.dimen.tbds114);
        this.p = c.a.d.f.p.n.f(activity, R.dimen.tbds84);
        this.q = c.a.d.f.p.n.f(activity, R.dimen.tbds44);
        this.m = c.a.d.f.p.n.f(activity, R.dimen.tbds222);
        this.l = c.a.d.f.p.n.f(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f13909g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f13910h = inflate.findViewById(R.id.background);
        this.f13911i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f13908f = inflate;
        this.f13910h.setBackgroundDrawable(b());
        this.f13911i.setMaxLines(1);
        this.f13911i.setGravity(17);
        this.f13911i.setTextSize(0, c.a.d.f.p.n.f(activity, R.dimen.tbfontsize40));
        this.f13911i.setTextColor(this.f13907e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f13911i;
        int i4 = this.q;
        textView.setPadding(i4, 0, i4, 0);
        this.f13912j = (WindowManager) this.f13907e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f13913k = layoutParams;
        layoutParams.width = c.a.d.f.p.n.k(this.f13907e) - (this.l * 2);
        WindowManager.LayoutParams layoutParams2 = this.f13913k;
        layoutParams2.height = this.r;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.ToastAnimation;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.f13913k.alpha = this.n;
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
            if (this.f13907e != null && !TextUtils.isEmpty(str)) {
                String e2 = o0.e(str, 34);
                int t = c.a.d.f.p.n.t(this.f13911i.getPaint(), e2);
                ViewGroup.LayoutParams layoutParams = this.f13909g.getLayoutParams();
                layoutParams.width = t + (this.q * 2);
                this.f13909g.setLayoutParams(layoutParams);
                this.f13911i.setText(e2);
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
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{c.a.t0.x1.o.k.b.b("#FF722B"), c.a.t0.x1.o.k.b.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.p);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m + UtilHelper.getNavigationBarHeight(this.f13907e) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            if (this.f13908f.getWindowToken() != null) {
                this.f13912j.removeView(this.f13908f);
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
            this.f13909g.setTag(obj);
            this.f13909g.setOnClickListener(this);
        }
    }

    public f j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.u);
            View view = this.f13908f;
            if (view != null && view.getWindowToken() != null) {
                this.f13912j.removeView(this.f13908f);
            }
            this.f13912j.addView(this.f13908f, this.f13913k);
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
