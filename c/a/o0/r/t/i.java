package c.a.o0.r.t;

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
public class i implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131235007;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f11058b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f11059c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f11060d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f11061e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f11062f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f11063g;

    /* renamed from: h  reason: collision with root package name */
    public int f11064h;
    public int i;
    public float j;
    public int k;
    public Runnable l;
    public c.a.o0.a.d0.a m;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(935454578, "Lc/a/o0/r/t/i;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(935454578, "Lc/a/o0/r/t/i;");
        }
    }

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 3000;
        if (context == null) {
            return;
        }
        this.a = context;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d060b, (ViewGroup) null);
        this.f11058b = viewGroup;
        this.f11059c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09208f);
        TextView textView = (TextView) this.f11058b.findViewById(R.id.obfuscated_res_0x7f092089);
        this.f11060d = textView;
        textView.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) this.f11058b.findViewById(R.id.obfuscated_res_0x7f092088);
        this.f11061e = tbImageView;
        tbImageView.setDefaultBgResource(obfuscated);
        this.f11061e.setDrawCorner(true);
        this.f11061e.setConrers(15);
        this.f11061e.setRadius(c.a.d.f.p.n.f(context, R.dimen.tbds20));
        this.i = c.a.d.f.p.n.f(context, R.dimen.tbds176);
        this.f11064h = c.a.d.f.p.n.f(context, R.dimen.tbds29);
        SkinManager.setBackgroundResource(this.f11058b, R.drawable.obfuscated_res_0x7f080cf1);
        this.f11062f = (WindowManager) this.a.getSystemService("window");
        g();
        this.l = new a(this);
    }

    public static i h(Context context, c.a.o0.a.d0.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, aVar)) == null) {
            i iVar = new i(context);
            iVar.a(aVar);
            return iVar;
        }
        return (i) invokeLL.objValue;
    }

    public final i a(c.a.o0.a.d0.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (this.a == null) {
                return this;
            }
            if (aVar == null) {
                c();
                return this;
            }
            this.m = aVar;
            if (c.a.d.f.p.m.isEmpty(aVar.f9632e)) {
                this.f11059c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1343));
            } else {
                this.f11059c.setText(aVar.f9632e);
            }
            if (c.a.d.f.p.m.isEmpty(aVar.f9633f)) {
                this.f11060d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02ba));
            } else {
                this.f11060d.setText(aVar.f9633f);
            }
            if (c.a.d.f.p.m.isEmpty(aVar.p)) {
                SkinManager.setViewTextColor(this.f11059c, R.color.CAM_X0302, 1);
            } else {
                this.f11059c.setTextColor(c.a.p0.b2.o.k.b.b(aVar.p));
            }
            if (c.a.d.f.p.m.isEmpty(aVar.q)) {
                SkinManager.setViewTextColor(this.f11060d, R.color.CAM_X0101, 1);
            } else {
                this.f11060d.setTextColor(c.a.p0.b2.o.k.b.b(aVar.q));
            }
            if (!c.a.d.f.p.m.isEmpty(aVar.o)) {
                this.f11060d.setBackgroundDrawable(b(aVar.o));
            }
            if (!c.a.d.f.p.m.isEmpty(aVar.j)) {
                this.f11061e.J(aVar.j, 10, false);
            }
            int i = aVar.i;
            if (i > 3) {
                this.k = i * 1000;
            }
            this.j = (float) aVar.n;
            i();
            return this;
        }
        return (i) invokeL.objValue;
    }

    public final StateListDrawable b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable = this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c0);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(c.a.d.f.p.n.f(this.a, R.dimen.tbds10));
            gradientDrawable.setColor(c.a.p0.b2.o.k.b.b(str));
            stateListDrawable.addState(new int[]{16842919}, drawable);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return (StateListDrawable) invokeL.objValue;
    }

    public final i c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.f11059c.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1343));
            this.f11060d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02ba));
            SkinManager.setViewTextColor(this.f11059c, R.color.CAM_X0302, 1);
            SkinManager.setViewTextColor(this.f11060d, R.color.CAM_X0101, 1);
            i();
            return this;
        }
        return (i) invokeV.objValue;
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
            if (this.a != null) {
                if (this.f11058b.getWindowToken() != null) {
                    this.f11062f.removeView(this.f11058b);
                }
                c.a.d.f.m.e.a().removeCallbacks(this.l);
            }
            this.a = null;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.f11063g = layoutParams;
            layoutParams.width = c.a.d.f.p.n.k(this.a) - (this.f11064h * 2);
            this.f11063g.height = c.a.d.f.p.n.f(this.a, R.dimen.tbds196);
            WindowManager.LayoutParams layoutParams2 = this.f11063g;
            layoutParams2.type = 1000;
            layoutParams2.format = -3;
            layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f1003c2;
            layoutParams2.flags = 262152;
            layoutParams2.gravity = 81;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WindowManager.LayoutParams layoutParams = this.f11063g;
            layoutParams.y = this.i;
            layoutParams.alpha = this.j;
        }
    }

    public i j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a != null) {
                this.f11062f.addView(this.f11058b, this.f11063g);
                c.a.d.f.m.e.a().removeCallbacks(this.l);
                c.a.d.f.m.e.a().postDelayed(this.l, this.k);
                if (this.m != null) {
                    TiebaStatic.log(new StatisticItem("c13317").param("obj_source", this.m.a).param("obj_type", this.m.f9629b));
                }
            }
            return this;
        }
        return (i) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.o0.a.d0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (aVar = this.m) == null) {
            return;
        }
        int i = aVar.f9631d;
        if (i == c.a.o0.a.d0.a.D) {
            if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), this.m.l) && !c.a.d.f.p.m.isEmpty(this.m.k)) {
                d(this.m.k);
            }
        } else if (i == c.a.o0.a.d0.a.E && !c.a.d.f.p.m.isEmpty(aVar.k)) {
            d(this.m.k);
        }
        TiebaStatic.log(new StatisticItem("c13318").param("obj_source", this.m.a).param("obj_type", this.m.f9629b));
    }
}
