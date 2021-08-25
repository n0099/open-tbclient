package c.a.p0.s.s;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14471e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f14472f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14473g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14474h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f14475i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f14476j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public Runnable p;
    public c.a.p0.a.d0.a q;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f14477e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14477e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14477e.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-843400587, "Lc/a/p0/s/s/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-843400587, "Lc/a/p0/s/s/g;");
                return;
            }
        }
        r = R.drawable.shape_new_complete_toast_bg;
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 1.0f;
        this.o = 3000;
        if (context == null) {
            return;
        }
        this.f14471e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f14472f = viewGroup;
        this.f14473g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f14472f.findViewById(R.id.toast_btn);
        this.f14474h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f14472f.findViewById(R.id.toast_bg);
        this.f14475i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.f14475i.setDrawCorner(true);
        this.f14475i.setConrers(15);
        this.f14475i.setRadius(c.a.e.e.p.l.g(context, R.dimen.tbds20));
        this.m = c.a.e.e.p.l.g(context, R.dimen.tbds176);
        this.l = c.a.e.e.p.l.g(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f14472f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.f14476j = (WindowManager) this.f14471e.getSystemService("window");
        g();
        this.p = new a(this);
    }

    public static g h(Context context, c.a.p0.a.d0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            g gVar = new g(context);
            gVar.a(aVar);
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final g a(c.a.p0.a.d0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f14471e == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.q = aVar;
            if (c.a.e.e.p.k.isEmpty(aVar.f12549e)) {
                this.f14473g.setText(this.f14471e.getResources().getString(R.string.task_already_finish));
            } else {
                this.f14473g.setText(aVar.f12549e);
            }
            if (c.a.e.e.p.k.isEmpty(aVar.f12550f)) {
                this.f14474h.setText(this.f14471e.getResources().getString(R.string.back));
            } else {
                this.f14474h.setText(aVar.f12550f);
            }
            if (c.a.e.e.p.k.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f14473g, R.color.CAM_X0302, 1);
            } else {
                this.f14473g.setTextColor(c.a.q0.o1.o.k.b.b(aVar.p));
            }
            if (c.a.e.e.p.k.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f14474h, R.color.CAM_X0101, 1);
            } else {
                this.f14474h.setTextColor(c.a.q0.o1.o.k.b.b(aVar.q));
            }
            if (!c.a.e.e.p.k.isEmpty(aVar.o)) {
                this.f14474h.setBackgroundDrawable(b(aVar.o));
            }
            if (!c.a.e.e.p.k.isEmpty(aVar.f12554j)) {
                this.f14475i.startLoad(aVar.f12554j, 10, false);
            }
            int i2 = aVar.f12553i;
            if (i2 > 3) {
                this.o = i2 * 1000;
            }
            this.n = (float) aVar.n;
            i();
            return this;
        }
        return (g) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f14471e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(c.a.e.e.p.l.g(this.f14471e, R.dimen.tbds10));
            gradientDrawable.setColor(c.a.q0.o1.o.k.b.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f14473g.setText(this.f14471e.getResources().getString(R.string.task_already_finish));
            this.f14474h.setText(this.f14471e.getResources().getString(R.string.back));
            SkinManager.setViewTextColor(this.f14473g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f14474h, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (g) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || c.a.e.e.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(e2, new String[]{str});
    }

    public final TbPageContext e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f14471e != null) {
                if (this.f14472f.getWindowToken() != null) {
                    this.f14476j.removeView(this.f14472f);
                }
                c.a.e.e.m.e.a().removeCallbacks(this.p);
            }
            this.f14471e = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.k = layoutParams;
            layoutParams.width = c.a.e.e.p.l.k(this.f14471e) - (this.l * 2);
            this.k.height = c.a.e.e.p.l.g(this.f14471e, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.k;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.new_complete_task_toast;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.k;
            layoutParams.y = this.m;
            layoutParams.alpha = this.n;
        }
    }

    public g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f14471e != null) {
                this.f14476j.addView(this.f14472f, this.k);
                c.a.e.e.m.e.a().removeCallbacks(this.p);
                c.a.e.e.m.e.a().postDelayed(this.p, this.o);
                if (this.q != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.f12545a).param("obj_type", this.q.f12546b));
                }
            }
            return this;
        }
        return (g) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.a.d0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.q) == null) {
            return;
        }
        int i2 = aVar.f12548d;
        if (i2 == c.a.p0.a.d0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !c.a.e.e.p.k.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i2 == c.a.p0.a.d0.a.E && !c.a.e.e.p.k.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.f12545a).param("obj_type", this.q.f12546b));
    }
}
