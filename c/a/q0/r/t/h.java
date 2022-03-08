package c.a.q0.r.t;

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
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: r */
    public static final int shape_new_complete_toast_bg = 2131235213;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f13485e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f13486f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13487g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13488h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f13489i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f13490j;
    public WindowManager.LayoutParams k;
    public int l;
    public int m;
    public float n;
    public int o;
    public Runnable p;
    public c.a.q0.a.c0.a q;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f13491e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13491e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13491e.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1615512917, "Lc/a/q0/r/t/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1615512917, "Lc/a/q0/r/t/h;");
        }
    }

    public h(Context context) {
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
        this.f13485e = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.new_task_completed_toast_layout, (ViewGroup) null);
        this.f13486f = viewGroup;
        this.f13487g = (TextView) viewGroup.findViewById(R.id.toast_message_content);
        TextView textView = (TextView) this.f13486f.findViewById(R.id.toast_btn);
        this.f13488h = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f13486f.findViewById(R.id.toast_bg);
        this.f13489i = tbImageView;
        tbImageView.setDefaultBgResource(shape_new_complete_toast_bg);
        this.f13489i.setDrawCorner(true);
        this.f13489i.setConrers(15);
        this.f13489i.setRadius(c.a.d.f.p.n.f(context, R.dimen.tbds20));
        this.m = c.a.d.f.p.n.f(context, R.dimen.tbds176);
        this.l = c.a.d.f.p.n.f(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f13486f, R.drawable.layerlist_new_complete_task_toast_shadow);
        this.f13490j = (WindowManager) this.f13485e.getSystemService("window");
        g();
        this.p = new a(this);
    }

    public static h h(Context context, c.a.q0.a.c0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            h hVar = new h(context);
            hVar.a(aVar);
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final h a(c.a.q0.a.c0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.f13485e == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.q = aVar;
            if (c.a.d.f.p.m.isEmpty(aVar.f11811e)) {
                this.f13487g.setText(this.f13485e.getResources().getString(R.string.task_already_finish));
            } else {
                this.f13487g.setText(aVar.f11811e);
            }
            if (c.a.d.f.p.m.isEmpty(aVar.f11812f)) {
                this.f13488h.setText(this.f13485e.getResources().getString(R.string.back));
            } else {
                this.f13488h.setText(aVar.f11812f);
            }
            if (c.a.d.f.p.m.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f13487g, R.color.CAM_X0302, 1);
            } else {
                this.f13487g.setTextColor(c.a.r0.z1.o.k.b.b(aVar.p));
            }
            if (c.a.d.f.p.m.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f13488h, R.color.CAM_X0101, 1);
            } else {
                this.f13488h.setTextColor(c.a.r0.z1.o.k.b.b(aVar.q));
            }
            if (!c.a.d.f.p.m.isEmpty(aVar.o)) {
                this.f13488h.setBackgroundDrawable(b(aVar.o));
            }
            if (!c.a.d.f.p.m.isEmpty(aVar.f11816j)) {
                this.f13489i.startLoad(aVar.f11816j, 10, false);
            }
            int i2 = aVar.f11815i;
            if (i2 > 3) {
                this.o = i2 * 1000;
            }
            this.n = (float) aVar.n;
            i();
            return this;
        }
        return (h) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.f13485e.getResources().getDrawable(R.drawable.shape_new_complete_toast_btn_bg_pressed);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(c.a.d.f.p.n.f(this.f13485e, R.dimen.tbds10));
            gradientDrawable.setColor(c.a.r0.z1.o.k.b.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f13487g.setText(this.f13485e.getResources().getString(R.string.task_already_finish));
            this.f13488h.setText(this.f13485e.getResources().getString(R.string.back));
            SkinManager.setViewTextColor(this.f13487g, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f13488h, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (h) invokeV.objValue;
    }

    public final void d(String str) {
        TbPageContext<?> e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || c.a.d.f.p.m.isEmpty(str) || (e2 = e(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
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
            if (this.f13485e != null) {
                if (this.f13486f.getWindowToken() != null) {
                    this.f13490j.removeView(this.f13486f);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.p);
            }
            this.f13485e = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.k = layoutParams;
            layoutParams.width = c.a.d.f.p.n.k(this.f13485e) - (this.l * 2);
            this.k.height = c.a.d.f.p.n.f(this.f13485e, R.dimen.tbds196);
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

    public h j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f13485e != null) {
                this.f13490j.addView(this.f13486f, this.k);
                c.a.d.f.m.e.a().removeCallbacks(this.p);
                c.a.d.f.m.e.a().postDelayed(this.p, this.o);
                if (this.q != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.q.a).param("obj_type", this.q.f11808b));
                }
            }
            return this;
        }
        return (h) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.q0.a.c0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.q) == null) {
            return;
        }
        int i2 = aVar.f11810d;
        if (i2 == c.a.q0.a.c0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.q.l) && !c.a.d.f.p.m.isEmpty(this.q.k)) {
                d(this.q.k);
            }
        } else if (i2 == c.a.q0.a.c0.a.E && !c.a.d.f.p.m.isEmpty(aVar.k)) {
            d(this.q.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.q.a).param("obj_type", this.q.f11808b));
    }
}
