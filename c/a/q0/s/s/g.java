package c.a.q0.s.s;

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
/* loaded from: classes5.dex */
public class g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13168e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f13169f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13170g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13171h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f13172i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f13173j;

    /* renamed from: k  reason: collision with root package name */
    public WindowManager.LayoutParams f13174k;
    public int l;
    public int m;
    public float n;
    public int o;
    public Runnable p;
    public c.a.q0.a.d0.a q;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f13175e;

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
            this.f13175e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13175e.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644112246, "Lc/a/q0/s/s/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644112246, "Lc/a/q0/s/s/g;");
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
        this.f13168e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f13169f = viewGroup;
        this.f13170g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f13169f.findViewById(R.id.toast_btn);
        this.f13171h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f13169f.findViewById(R.id.toast_bg);
        this.f13172i = tbImageView;
        tbImageView.setDefaultBgResource(r);
        this.f13172i.setDrawCorner(true);
        this.f13172i.setConrers(15);
        this.f13172i.setRadius(c.a.d.f.p.l.f(context, R.dimen.tbds20));
        this.m = c.a.d.f.p.l.f(context, R.dimen.tbds176);
        this.l = c.a.d.f.p.l.f(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f13169f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.f13173j = (WindowManager) this.f13168e.getSystemService("window");
        g();
        this.p = new a(this);
    }

    public static g h(Context context, c.a.q0.a.d0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            g gVar = new g(context);
            gVar.a(aVar);
            return gVar;
        }
        return (g) invokeLL.objValue;
    }

    public final g a(c.a.q0.a.d0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f13168e == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.q = aVar;
            if (c.a.d.f.p.k.isEmpty(aVar.f11608e)) {
                this.f13170g.setText(this.f13168e.getResources().getString(R.string.task_already_finish));
            } else {
                this.f13170g.setText(aVar.f11608e);
            }
            if (c.a.d.f.p.k.isEmpty(aVar.f11609f)) {
                this.f13171h.setText(this.f13168e.getResources().getString(R.string.back));
            } else {
                this.f13171h.setText(aVar.f11609f);
            }
            if (c.a.d.f.p.k.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f13170g, R.color.CAM_X0302, 1);
            } else {
                this.f13170g.setTextColor(c.a.r0.w1.o.k.b.b(aVar.p));
            }
            if (c.a.d.f.p.k.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f13171h, R.color.CAM_X0101, 1);
            } else {
                this.f13171h.setTextColor(c.a.r0.w1.o.k.b.b(aVar.q));
            }
            if (!c.a.d.f.p.k.isEmpty(aVar.o)) {
                this.f13171h.setBackgroundDrawable(b(aVar.o));
            }
            if (!c.a.d.f.p.k.isEmpty(aVar.f11613j)) {
                this.f13172i.startLoad(aVar.f11613j, 10, false);
            }
            int i2 = aVar.f11612i;
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
            Drawable drawable = this.f13168e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(c.a.d.f.p.l.f(this.f13168e, R.dimen.tbds10));
            gradientDrawable.setColor(c.a.r0.w1.o.k.b.b(str));
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
            this.f13170g.setText(this.f13168e.getResources().getString(R.string.task_already_finish));
            this.f13171h.setText(this.f13168e.getResources().getString(R.string.back));
            SkinManager.setViewTextColor(this.f13170g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f13171h, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (g) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || c.a.d.f.p.k.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
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
            if (this.f13168e != null) {
                if (this.f13169f.getWindowToken() != null) {
                    this.f13173j.removeView(this.f13169f);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.p);
            }
            this.f13168e = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f13174k = layoutParams;
            layoutParams.width = c.a.d.f.p.l.k(this.f13168e) - (this.l * 2);
            this.f13174k.height = c.a.d.f.p.l.f(this.f13168e, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.f13174k;
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
            WindowManager.LayoutParams layoutParams = this.f13174k;
            layoutParams.y = this.m;
            layoutParams.alpha = this.n;
        }
    }

    public g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f13168e != null) {
                this.f13173j.addView(this.f13169f, this.f13174k);
                c.a.d.f.m.e.a().removeCallbacks(this.p);
                c.a.d.f.m.e.a().postDelayed(this.p, this.o);
                if (this.q != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.a).param("obj_type", this.q.f11605b));
                }
            }
            return this;
        }
        return (g) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.q0.a.d0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.q) == null) {
            return;
        }
        int i2 = aVar.f11607d;
        if (i2 == c.a.q0.a.d0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !c.a.d.f.p.k.isEmpty(this.q.f11614k)) {
                d(this.q.f11614k);
            }
        } else if (i2 == c.a.q0.a.d0.a.E && !c.a.d.f.p.k.isEmpty(aVar.f11614k)) {
            d(this.q.f11614k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.a).param("obj_type", this.q.f11605b));
    }
}
