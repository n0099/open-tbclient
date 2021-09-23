package c.a.r0.w0.o2;

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
/* loaded from: classes4.dex */
public class e implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f27421e;

    /* renamed from: f  reason: collision with root package name */
    public NoPressedRelativeLayout f27422f;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f27423g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f27424h;

    /* renamed from: i  reason: collision with root package name */
    public final Animation f27425i;

    /* renamed from: j  reason: collision with root package name */
    public final Animation f27426j;
    public final Runnable k;
    public int l;
    public int m;
    public int n;

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27427e;

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
            this.f27427e = eVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 111) {
                    this.f27427e.j();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f27428a;

        public b(e eVar) {
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
            this.f27428a = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f27428a.f27424h.getParent() == null) {
                return;
            }
            ((ViewGroup) this.f27428a.f27424h.getParent()).removeView(this.f27428a.f27424h);
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

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27429e;

        public c(e eVar) {
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
            this.f27429e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27429e.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27430e;

        public d(e eVar) {
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
            this.f27430e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f27430e.e();
                if (this.f27430e.f27423g == null || this.f27430e.f27423g.getIsRefresh() || this.f27430e.f27423g.getFrsView() == null) {
                    return;
                }
                this.f27430e.f27423g.getFrsView().R1();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.f27422f = noPressedRelativeLayout;
        this.f27423g = frsFragment;
        this.f27421e = new Handler(new a(this));
        this.f27425i = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_in);
        Animation loadAnimation = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f27426j = loadAnimation;
        loadAnimation.setAnimationListener(new b(this));
        this.k = new c(this);
        f();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f27424h.getParent() == null) {
            return;
        }
        this.l = -1;
        this.n = -1;
        this.f27421e.removeCallbacks(this.k);
        this.f27424h.clearAnimation();
        this.f27424h.startAnimation(this.f27426j);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.f27424h = textView;
            textView.setOnClickListener(new d(this));
            this.f27424h.setGravity(17);
            this.f27424h.setText(R.string.frs_game_refresh_tip_text);
            int dimensionPixelSize = this.f27423g.getResources().getDimensionPixelSize(R.dimen.ds20);
            int dimensionPixelSize2 = this.f27423g.getResources().getDimensionPixelSize(R.dimen.ds40);
            this.f27424h.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            this.f27424h.setTextSize(0, this.f27423g.getResources().getDimensionPixelSize(R.dimen.fontsize28));
            SkinManager.setBackgroundResource(this.f27424h, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.f27424h, R.color.CAM_X0302);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.topMargin = this.f27423g.getNavigationBar().getBottom() + c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds8);
            this.f27424h.setLayoutParams(layoutParams);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27421e.removeCallbacksAndMessages(null);
        }
    }

    public void h(RecyclerView recyclerView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, recyclerView, i2, i3) == null) {
            this.l = i2;
            this.m = i3;
            if (this.n < 0) {
                this.n = i2;
            }
        }
    }

    public void i(RecyclerView recyclerView, int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, recyclerView, i2) == null) && i2 == 0) {
            int i5 = this.l;
            if (i5 > 0 && (i3 = this.m) > 0 && (i4 = this.n) >= 0 && i5 + i3 + 1 < i4) {
                this.f27421e.sendEmptyMessage(111);
            }
            this.n = this.l;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f27424h.getParent() == null) {
            this.f27422f.addView(this.f27424h);
            this.f27424h.clearAnimation();
            this.f27424h.startAnimation(this.f27425i);
            this.f27421e.removeCallbacks(this.k);
            this.f27421e.postDelayed(this.k, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(this.f27424h, R.drawable.bg_home_float);
            SkinManager.setViewTextColor(this.f27424h, R.color.CAM_X0302);
        }
    }
}
