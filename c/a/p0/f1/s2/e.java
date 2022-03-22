package c.a.p0.f1.s2;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.a.l.q;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class e implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f14584b;

    /* renamed from: c  reason: collision with root package name */
    public FrsFragment f14585c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14586d;

    /* renamed from: e  reason: collision with root package name */
    public final Animation f14587e;

    /* renamed from: f  reason: collision with root package name */
    public final Animation f14588f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f14589g;

    /* renamed from: h  reason: collision with root package name */
    public int f14590h;
    public int i;
    public int j;

    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 111) {
                    this.a.j();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.f14586d.getParent() == null) {
                return;
            }
            ((ViewGroup) this.a.f14586d.getParent()).removeView(this.a.f14586d);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.e();
                if (this.a.f14585c == null || this.a.f14585c.D2() || this.a.f14585c.x0() == null) {
                    return;
                }
                this.a.f14585c.x0().T1();
            }
        }
    }

    public e(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, noPressedRelativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14590h = -1;
        this.i = -1;
        this.j = -1;
        this.f14584b = noPressedRelativeLayout;
        this.f14585c = frsFragment;
        this.a = new Handler(new a(this));
        this.f14587e = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.obfuscated_res_0x7f010063);
        Animation loadAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.obfuscated_res_0x7f010064);
        this.f14588f = loadAnimation;
        loadAnimation.setAnimationListener(new b(this));
        this.f14589g = new c(this);
        f();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14586d.getParent() == null) {
            return;
        }
        this.f14590h = -1;
        this.j = -1;
        this.a.removeCallbacks(this.f14589g);
        this.f14586d.clearAnimation();
        this.f14586d.startAnimation(this.f14588f);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.f14586d = textView;
            textView.setOnClickListener(new d(this));
            this.f14586d.setGravity(17);
            this.f14586d.setText(R.string.obfuscated_res_0x7f0f06d9);
            int dimensionPixelSize = this.f14585c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            int dimensionPixelSize2 = this.f14585c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070225);
            this.f14586d.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.f14586d.setTextSize(0, this.f14585c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5));
            SkinManager.setBackgroundResource(this.f14586d, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.f14586d, (int) R.color.CAM_X0302);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = this.f14585c.d0().getBottom() + c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702fb);
            this.f14586d.setLayoutParams(layoutParams);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.removeCallbacksAndMessages(null);
        }
    }

    public void h(RecyclerView recyclerView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, recyclerView, i, i2) == null) {
            this.f14590h = i;
            this.i = i2;
            if (this.j < 0) {
                this.j = i;
            }
        }
    }

    public void i(RecyclerView recyclerView, int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, recyclerView, i) == null) && i == 0) {
            int i4 = this.f14590h;
            if (i4 > 0 && (i2 = this.i) > 0 && (i3 = this.j) >= 0 && i4 + i2 + 1 < i3) {
                this.a.sendEmptyMessage(111);
            }
            this.j = this.f14590h;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f14586d.getParent() == null) {
            this.f14584b.addView(this.f14586d);
            this.f14586d.clearAnimation();
            this.f14586d.startAnimation(this.f14587e);
            this.a.removeCallbacks(this.f14589g);
            this.a.postDelayed(this.f14589g, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(this.f14586d, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.f14586d, (int) R.color.CAM_X0302);
        }
    }
}
