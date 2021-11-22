package b.a.q0.s.s;

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
import b.a.q0.c1.m0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Activity f14329e;

    /* renamed from: f  reason: collision with root package name */
    public View f14330f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f14331g;

    /* renamed from: h  reason: collision with root package name */
    public View f14332h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14333i;
    public WindowManager j;
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f14334e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14334e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14334e.e();
            }
        }
    }

    public e(Activity activity) {
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
        this.f14329e = activity;
        this.r = b.a.e.f.p.l.g(activity, R.dimen.tbds114);
        this.p = b.a.e.f.p.l.g(activity, R.dimen.tbds84);
        this.q = b.a.e.f.p.l.g(activity, R.dimen.tbds44);
        this.m = b.a.e.f.p.l.g(activity, R.dimen.tbds222);
        this.l = b.a.e.f.p.l.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.f14331g = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.f14332h = inflate.findViewById(R.id.background);
        this.f14333i = (TextView) inflate.findViewById(R.id.toast_tv);
        this.f14330f = inflate;
        this.f14332h.setBackgroundDrawable(b());
        this.f14333i.setMaxLines(1);
        this.f14333i.setGravity(17);
        this.f14333i.setTextSize(0, b.a.e.f.p.l.g(activity, R.dimen.tbfontsize40));
        this.f14333i.setTextColor(this.f14329e.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f14333i;
        int i4 = this.q;
        textView.setPadding(i4, 0, i4, 0);
        this.j = (WindowManager) this.f14329e.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.k = layoutParams;
        layoutParams.width = b.a.e.f.p.l.k(this.f14329e) - (this.l * 2);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.height = this.r;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.ToastAnimation;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.k.alpha = this.n;
    }

    public static e f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            e eVar = new e(activity);
            eVar.a(str);
            return eVar;
        }
        return (e) invokeLL.objValue;
    }

    public final e a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f14329e != null && !TextUtils.isEmpty(str)) {
                String e2 = m0.e(str, 34);
                int t = b.a.e.f.p.l.t(this.f14333i.getPaint(), e2);
                ViewGroup.LayoutParams layoutParams = this.f14331g.getLayoutParams();
                layoutParams.width = t + (this.q * 2);
                this.f14331g.setLayoutParams(layoutParams);
                this.f14333i.setText(e2);
            }
            return this;
        }
        return (e) invokeL.objValue;
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
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{b.a.r0.q1.o.k.b.b("#FF722B"), b.a.r0.q1.o.k.b.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.p);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.m + UtilHelper.getNavigationBarHeight(this.f14329e) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.u);
            if (this.f14330f.getWindowToken() != null) {
                this.j.removeView(this.f14330f);
            }
        }
    }

    public e g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 > 0) {
                this.o = i2 * 1000;
            }
            return this;
        }
        return (e) invokeI.objValue;
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
            this.f14331g.setTag(obj);
            this.f14331g.setOnClickListener(this);
        }
    }

    public e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.u);
            View view = this.f14330f;
            if (view != null && view.getWindowToken() != null) {
                this.j.removeView(this.f14330f);
            }
            this.j.addView(this.f14330f, this.k);
            b.a.e.f.m.e.a().postDelayed(this.u, this.o);
            return this;
        }
        return (e) invokeV.objValue;
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
