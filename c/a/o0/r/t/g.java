package c.a.o0.r.t;

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
import c.a.o0.c1.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* renamed from: b  reason: collision with root package name */
    public View f11044b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f11045c;

    /* renamed from: d  reason: collision with root package name */
    public View f11046d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f11047e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f11048f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f11049g;

    /* renamed from: h  reason: collision with root package name */
    public int f11050h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public Drawable o;
    public View.OnClickListener p;
    public final Runnable q;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public g(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 5000;
        this.q = new a(this);
        if (activity == null) {
            return;
        }
        this.a = activity;
        this.n = c.a.d.f.p.n.f(activity, R.dimen.tbds114);
        this.l = c.a.d.f.p.n.f(activity, R.dimen.tbds84);
        this.m = c.a.d.f.p.n.f(activity, R.dimen.tbds44);
        this.i = c.a.d.f.p.n.f(activity, R.dimen.tbds222);
        this.f11050h = c.a.d.f.p.n.f(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.obfuscated_res_0x7f0d0825, (ViewGroup) null);
        this.f11045c = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0911d1);
        this.f11046d = inflate.findViewById(R.id.obfuscated_res_0x7f0902f4);
        this.f11047e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092093);
        this.f11044b = inflate;
        this.f11046d.setBackgroundDrawable(b());
        this.f11047e.setMaxLines(1);
        this.f11047e.setGravity(17);
        this.f11047e.setTextSize(0, c.a.d.f.p.n.f(activity, R.dimen.tbfontsize40));
        this.f11047e.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.f11047e;
        int i3 = this.m;
        textView.setPadding(i3, 0, i3, 0);
        this.f11048f = (WindowManager) this.a.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f11049g = layoutParams;
        layoutParams.width = c.a.d.f.p.n.k(this.a) - (this.f11050h * 2);
        WindowManager.LayoutParams layoutParams2 = this.f11049g;
        layoutParams2.height = this.n;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f10029e;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.f11049g.alpha = this.j;
    }

    public static g f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            g gVar = new g(activity);
            gVar.a(str);
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final g a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String e2 = o0.e(str, 34);
                int t = c.a.d.f.p.n.t(this.f11047e.getPaint(), e2);
                ViewGroup.LayoutParams layoutParams = this.f11045c.getLayoutParams();
                layoutParams.width = t + (this.m * 2);
                this.f11045c.setLayoutParams(layoutParams);
                this.f11047e.setText(e2);
            }
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.o == null) {
                this.o = c();
            }
            return this.o;
        }
        return (Drawable) invokeV.objValue;
    }

    public final GradientDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{c.a.p0.b2.o.k.b.b("#FF722B"), c.a.p0.b2.o.k.b.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.l);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i + UtilHelper.getNavigationBarHeight(this.a) : invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.q);
            if (this.f11044b.getWindowToken() != null) {
                this.f11048f.removeView(this.f11044b);
            }
        }
    }

    public g g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                this.k = i * 1000;
            }
            return this;
        }
        return (g) invokeI.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.f11045c.setTag(obj);
            this.f11045c.setOnClickListener(this);
        }
    }

    public g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.q);
            View view = this.f11044b;
            if (view != null && view.getWindowToken() != null) {
                this.f11048f.removeView(this.f11044b);
            }
            this.f11048f.addView(this.f11044b, this.f11049g);
            c.a.d.f.m.e.a().postDelayed(this.q, this.k);
            return this;
        }
        return (g) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            View.OnClickListener onClickListener = this.p;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            e();
        }
    }
}
