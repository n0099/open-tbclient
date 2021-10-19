package c.a.r0.p2.j;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.r0.a3.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.slideLoadingLayout.LottieSlideLoadingLayout;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
import com.baidu.tieba.personPolymeric.header.PersonHeaderBackgroundController;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterDynamicTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterMainTabFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterTabBaseFragment;
import com.baidu.tieba.personPolymeric.tab.fragments.PersonCenterThreadTabFragment;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static /* synthetic */ Interceptable $ic = null;
    public static int T = 5000;
    public static final float U;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public RelativeLayout B;
    public int C;
    public int D;
    public GradientDrawable E;
    public FrameLayout F;
    public FrameLayout.LayoutParams G;
    public AlphaAnimation H;
    public AlphaAnimation I;
    public c.a.r0.p2.g.b J;
    public c.a.r0.p2.j.k K;
    public ValueAnimator L;
    public long M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public Runnable R;
    public c.a.r0.p2.d.a S;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23543a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f23544b;

    /* renamed from: c  reason: collision with root package name */
    public PluginErrorTipView f23545c;

    /* renamed from: d  reason: collision with root package name */
    public View f23546d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.z1.a f23547e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f23548f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f23549g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f23550h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f23551i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.p2.e.a f23552j;
    public boolean k;
    public BdUniqueId l;
    public c.a.r0.p2.d.f m;
    public BaseFragment n;
    public float[] o;
    public float p;
    public int q;
    public LottieSlideLoadingLayout r;
    public PersonHeaderBackgroundController s;
    public AppBarLayout t;
    public FrameLayout u;
    public NewPagerSlidingTabBaseStrip v;
    public View w;
    public CustomViewPager x;
    public m y;
    public LinearLayout z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23553a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23553a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f23553a.O == ((Integer) customResponsedMessage.getData()).intValue() && this.f23553a.N) {
                c.a.e.e.m.e.a().removeCallbacks(this.f23553a.R);
                this.f23553a.V();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f23554e;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23554e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23554e.N) {
                this.f23554e.V();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.r0.p2.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23555a;

        public c(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23555a = pVar;
        }

        @Override // c.a.r0.p2.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f23555a.Q = z;
                if (this.f23555a.J == null || this.f23555a.J.B() == null) {
                    return;
                }
                this.f23555a.J.B().setOpen(z);
            }
        }

        @Override // c.a.r0.p2.d.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f23555a.G.height = -2;
                this.f23555a.F.setLayoutParams(this.f23555a.G);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.q0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23556a;

        public d(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23556a = pVar;
        }

        @Override // c.a.q0.s.f0.q.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.s.f0.q.b
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                c.a.e.e.m.e.a().postDelayed(this.f23556a.R, p.T);
                this.f23556a.N = true;
                p pVar = this.f23556a;
                pVar.O = pVar.y.b();
                this.f23556a.M();
                this.f23556a.y.forceRefresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23557a;

        public e(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23557a = pVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i2 == 0, this.f23557a.f23543a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.f23557a.f23543a.getPageActivity());
                }
                this.f23557a.r.setEnableSlideLoading(i2 == 0);
                int abs = Math.abs(i2);
                this.f23557a.K.i(abs == 0);
                float f2 = abs;
                this.f23557a.K.m(f2 > this.f23557a.p / 2.0f);
                float abs2 = ((double) this.f23557a.p) == 0.0d ? 0.0f : Math.abs(f2 / this.f23557a.p);
                this.f23557a.K.h(abs2);
                if (abs2 >= 1.0f) {
                    this.f23557a.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f23557a.E.setCornerRadii(this.f23557a.o);
                    this.f23557a.u.setBackgroundDrawable(this.f23557a.E);
                    this.f23557a.Y();
                } else {
                    this.f23557a.o = new float[]{p.U, p.U, p.U, p.U, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f23557a.E.setCornerRadii(this.f23557a.o);
                    this.f23557a.u.setBackgroundDrawable(this.f23557a.E);
                    this.f23557a.O();
                }
                int i3 = this.f23557a.D - this.f23557a.C;
                if (this.f23557a.D <= 0 || Math.abs(i2) < i3) {
                    return;
                }
                this.f23557a.r.endLoading();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f23558e;

        public f(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23558e = pVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f23558e.y.e(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23559a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23559a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f23559a.K == null) {
                return;
            }
            this.f23559a.K.n();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23560a;

        public h(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23560a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23560a.H.reset();
                this.f23560a.H = null;
            }
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

    /* loaded from: classes3.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23561a;

        public i(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23561a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23561a.w.setVisibility(8);
                this.f23561a.I.reset();
                this.f23561a.I = null;
            }
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

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f23562e;

        public j(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23562e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23562e.C == 0) {
                p pVar2 = this.f23562e;
                pVar2.C = pVar2.F.getMeasuredHeight();
                this.f23562e.p = pVar.F.getMeasuredHeight() - this.f23562e.K.e().getMeasuredHeight();
                if (this.f23562e.s != null) {
                    p pVar3 = this.f23562e;
                    pVar3.P = pVar3.q + this.f23562e.K.e().getMeasuredHeight() + this.f23562e.F.getMeasuredHeight() + this.f23562e.v.getMeasuredHeight();
                    boolean z = (this.f23562e.k || this.f23562e.f23552j.j() == null || this.f23562e.f23552j.j().getNewGodData() == null || !this.f23562e.f23552j.j().getNewGodData().isNewGod()) ? false : true;
                    this.f23562e.G.height = this.f23562e.P;
                    this.f23562e.F.setLayoutParams(this.f23562e.G);
                    this.f23562e.P += z ? c.a.r0.p2.g.a.b0 : 0;
                    this.f23562e.G.height = -2;
                    this.f23562e.F.setLayoutParams(this.f23562e.G);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23563a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23563a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.r0.a3.b)) {
                SparseArray<b.a> sparseArray = ((c.a.r0.a3.b) customResponsedMessage.getData()).f15644a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                b.a aVar = sparseArray.get(2);
                if (this.f23563a.J != null && aVar != null) {
                    this.f23563a.J.I(aVar.f15645a);
                }
                b.a aVar2 = sparseArray.get(4);
                b.a aVar3 = sparseArray.get(3);
                b.a aVar4 = sparseArray.get(1);
                b.a aVar5 = sparseArray.get(7);
                b.a aVar6 = sparseArray.get(8);
                if (this.f23563a.f23552j != null) {
                    if (this.f23563a.f23552j.w != null && this.f23563a.f23552j.w.f23436b != null && aVar2 != null) {
                        this.f23563a.f23552j.w.f23436b.putBoolean("person_center_item_red_tip_show", aVar2.f15645a);
                    }
                    if (aVar3 != null && this.f23563a.f23552j.v != null && this.f23563a.f23552j.v.f23436b != null) {
                        this.f23563a.f23552j.v.f23436b.putBoolean("person_center_item_red_tip_show", aVar3.f15645a);
                    }
                    if (aVar4 != null && this.f23563a.f23552j.u != null && this.f23563a.f23552j.u.f23436b != null) {
                        this.f23563a.f23552j.u.f23436b.putBoolean("person_center_item_red_tip_show", aVar4.f15645a);
                    }
                    if (aVar5 != null && this.f23563a.f23552j.x != null && this.f23563a.f23552j.x.f23436b != null) {
                        this.f23563a.f23552j.x.f23436b.putBoolean("person_center_item_red_tip_show", aVar5.f15645a);
                    }
                    if (aVar6 == null || this.f23563a.f23552j.y == null || this.f23563a.f23552j.y.f23436b == null) {
                        return;
                    }
                    this.f23563a.f23552j.y.f23436b.putBoolean("person_center_item_red_tip_show", aVar6.f15645a);
                    this.f23563a.f23552j.y.f23436b.putString("person_center_item_txt", String.valueOf(aVar6.f15646b));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23564a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(p pVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23564a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f23564a.J.K(userPendantData.getImgUrl());
        }
    }

    /* loaded from: classes3.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f23565a;

        /* renamed from: b  reason: collision with root package name */
        public List<PersonCenterTabBaseFragment> f23566b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(p pVar, FragmentManager fragmentManager) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, fragmentManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f23565a = arrayList;
            arrayList.add(pVar.f23543a.getResources().getString(R.string.person_center_tab_main));
            this.f23565a.add(pVar.f23543a.getResources().getString(R.string.person_center_tab_thread));
            this.f23565a.add(pVar.f23543a.getResources().getString(R.string.person_center_tab_dynamic));
            ArrayList arrayList2 = new ArrayList();
            this.f23566b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.newInstance(pVar.M, pVar.k));
            this.f23566b.add(PersonCenterThreadTabFragment.newInstance(pVar.M, pVar.k));
            this.f23566b.add(PersonCenterDynamicTabFragment.newInstance(pVar.M, pVar.k));
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.f23566b)) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.f23566b.size(); i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23566b.get(i2);
                    if (personCenterTabBaseFragment != null && personCenterTabBaseFragment.isPrimary()) {
                        return personCenterTabBaseFragment.getTabType();
                    }
                }
                return -1;
            }
            return invokeV.intValue;
        }

        public PersonCenterTabBaseFragment c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < this.f23566b.size()) {
                    return this.f23566b.get(i2);
                }
                return null;
            }
            return (PersonCenterTabBaseFragment) invokeI.objValue;
        }

        public final String d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f23565a.get(i2) : (String) invokeI.objValue;
        }

        public void e(int i2) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                for (int i3 = 0; i3 < this.f23565a.size() && (personCenterTabBaseFragment = this.f23566b.get(i3)) != null; i3++) {
                    if (i3 == i2) {
                        personCenterTabBaseFragment.setPrimary(true);
                    } else {
                        personCenterTabBaseFragment.setPrimary(false);
                    }
                }
            }
        }

        public void f(c.a.r0.p2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || ListUtils.isEmpty(this.f23566b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23566b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23566b.get(i2);
                if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                    ((PersonCenterMainTabFragment) personCenterTabBaseFragment).setData(aVar);
                }
            }
        }

        public void forceRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.isEmpty(this.f23566b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23566b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23566b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.forceRefresh(false);
                }
            }
        }

        public void g(c.a.r0.p2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.i() == null || ListUtils.isEmpty(this.f23566b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23566b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23566b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.setAuthor(aVar.C);
                    personCenterTabBaseFragment.setUser(aVar.i());
                }
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                List<PersonCenterTabBaseFragment> list = this.f23566b;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? c(i2) : (Fragment) invokeI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? d(i2) : (CharSequence) invokeI.objValue;
        }

        public void onChangeSkinType(int i2) {
            List<PersonCenterTabBaseFragment> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (list = this.f23566b) == null || list.size() <= 0) {
                return;
            }
            int size = this.f23566b.size();
            for (int i3 = 0; i3 < size; i3++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23566b.get(i3);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(888608402, "Lc/a/r0/p2/j/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(888608402, "Lc/a/r0/p2/j/p;");
                return;
            }
        }
        U = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public p(BaseFragment baseFragment, c.a.r0.p2.d.g gVar, BdUniqueId bdUniqueId, boolean z, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, gVar, bdUniqueId, Boolean.valueOf(z), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float f2 = U;
        this.o = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
        this.p = 674.0f;
        this.N = false;
        this.O = -1;
        this.R = new b(this);
        this.S = new c(this);
        this.n = baseFragment;
        this.f23543a = baseFragment.getPageContext();
        this.l = bdUniqueId;
        this.k = z;
        this.M = j2;
        this.m = gVar.l();
        R(gVar.f23330i);
    }

    public c.a.r0.p2.g.b L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (c.a.r0.p2.g.b) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.e.e.p.j.z()) {
                this.f23547e.f();
                this.f23547e.g();
                this.m.l();
                return;
            }
            this.m.p();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.p();
        }
    }

    public void O() {
        AlphaAnimation alphaAnimation;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && S() && (alphaAnimation = this.I) == null && alphaAnimation == null) {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation2;
            alphaAnimation2.setFillAfter(true);
            this.I.setDuration(300L);
            this.I.setAnimationListener(new i(this));
            this.w.startAnimation(this.I);
        }
    }

    public final void P(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            g gVar = new g(this, 2005016);
            this.f23551i = gVar;
            gVar.setTag(this.l);
            tbPageContext.registerListener(this.f23551i);
        }
    }

    public final void Q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            k kVar = new k(this, 2001435);
            this.f23548f = kVar;
            kVar.setTag(this.l);
            tbPageContext.registerListener(this.f23548f);
            l lVar = new l(this, 2016485);
            this.f23549g = lVar;
            lVar.setTag(this.l);
            tbPageContext.registerListener(this.f23549g);
            a aVar = new a(this, 2921435);
            this.f23550h = aVar;
            aVar.setTag(this.l);
            tbPageContext.registerListener(this.f23550h);
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f23546d = view;
            this.q = UtilHelper.getStatusBarHeight();
            this.r = (LottieSlideLoadingLayout) this.f23546d.findViewById(R.id.person_center_content_view);
            TbImageView tbImageView = (TbImageView) this.f23546d.findViewById(R.id.person_center_header_bg);
            this.s = new PersonHeaderBackgroundController(this.f23543a, tbImageView, this.f23546d.findViewById(R.id.person_center_background_cover), this.k);
            this.r.addSyncHeightView(tbImageView);
            TbPageContext tbPageContext = this.f23543a;
            View view2 = this.f23546d;
            this.K = new c.a.r0.p2.j.k(tbPageContext, view2, view2.findViewById(R.id.person_center_status_bar_space), this.k);
            FrameLayout frameLayout = (FrameLayout) this.f23546d.findViewById(R.id.person_center_header_container);
            this.F = frameLayout;
            this.G = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.r.addSyncHeightView(this.F);
            this.r.addLoadingListener(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.f23546d.findViewById(R.id.person_center_app_bar_layout);
            this.t = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.u = (FrameLayout) this.f23546d.findViewById(R.id.person_center_tab_layout_container);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f23546d.findViewById(R.id.person_center_tab_layout);
            this.v = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.v.setRectPaintColor(R.color.CAM_X0302);
            this.v.init(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds46), c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds46), c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds10), c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds46), true);
            this.v.setIndicatorOffset(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds64));
            this.v.setIndicatorOvershot(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorRadius(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorMarginBottom(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds0));
            this.v.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(c.a.e.e.p.l.g(this.f23543a.getPageActivity(), R.dimen.tbds166), -1));
            this.v.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.E = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.E.setCornerRadii(this.o);
            this.u.setBackgroundDrawable(this.E);
            View findViewById = this.f23546d.findViewById(R.id.person_center_pager_shadow);
            this.w = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.x = (CustomViewPager) this.f23546d.findViewById(R.id.person_center_view_pager);
            m mVar = new m(this, this.n.getActivity().getSupportFragmentManager());
            this.y = mVar;
            this.x.setAdapter(mVar);
            this.x.setOffscreenPageLimit(this.y.f23566b.size());
            this.y.notifyDataSetChanged();
            this.v.setViewPager(this.x);
            this.x.setCurrentItem(1);
            c.a.r0.p2.g.b bVar = new c.a.r0.p2.g.b(this.f23543a, this.k);
            this.J = bVar;
            bVar.H(this.S);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.F.addView(this.J.C(), layoutParams);
            if (this.K.f()) {
                Q(this.f23543a);
            }
            P(this.f23543a);
            this.f23544b = (NoNetworkView) this.f23546d.findViewById(R.id.person_center_no_network_view);
            this.f23545c = (PluginErrorTipView) this.f23546d.findViewById(R.id.person_center_plugin_error_tip_view);
            this.z = (LinearLayout) this.f23546d.findViewById(R.id.person_center_anti_container);
            this.A = (FrameLayout) this.f23546d.findViewById(R.id.person_center_anti_content);
            this.B = (RelativeLayout) this.f23546d.findViewById(R.id.person_center_noanti_rootview);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.w.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            c.a.r0.p2.j.k kVar = this.K;
            if (kVar != null) {
                kVar.g(i2);
            }
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.v;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
                this.v.setRectPaintColor(R.color.CAM_X0302);
                this.v.onChangeSkinType();
            }
            GradientDrawable gradientDrawable = this.E;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            c.a.r0.p2.g.b bVar = this.J;
            if (bVar != null) {
                bVar.F(i2);
            }
            m mVar = this.y;
            if (mVar != null) {
                mVar.onChangeSkinType(i2);
            }
            NoNetworkView noNetworkView = this.f23544b;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f23543a, i2);
            }
            PluginErrorTipView pluginErrorTipView = this.f23545c;
            if (pluginErrorTipView != null) {
                pluginErrorTipView.onChangeSkinType(this.f23543a, i2);
            }
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f23546d, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.w, R.drawable.personalize_tab_shadow);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.p2.g.b bVar = this.J;
            if (bVar != null) {
                bVar.G();
            }
            ValueAnimator valueAnimator = this.L;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.L.removeAllListeners();
                this.L.removeAllUpdateListeners();
                this.L = null;
            }
            c.a.e.e.m.e.a().removeCallbacks(this.R);
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.O = -1;
            this.N = false;
            LottieSlideLoadingLayout lottieSlideLoadingLayout = this.r;
            if (lottieSlideLoadingLayout != null) {
                lottieSlideLoadingLayout.endLoading();
            }
        }
    }

    public void W(c.a.r0.z1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f23547e = aVar;
        }
    }

    public void X(c.a.r0.c4.e eVar) {
        c.a.r0.p2.j.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) || (kVar = this.K) == null) {
            return;
        }
        kVar.j(eVar);
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && !S() && this.H == null) {
            this.w.setVisibility(0);
            if (this.H == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                this.H = alphaAnimation;
                alphaAnimation.setFillAfter(true);
                this.H.setDuration(300L);
                this.H.setAnimationListener(new h(this));
                this.w.startAnimation(this.H);
            }
        }
    }

    public void Z(c.a.r0.p2.e.a aVar, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{aVar, Boolean.valueOf(z), personStatus}) == null) || aVar == null) {
            return;
        }
        this.f23552j = aVar;
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        c.a.r0.p2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.l(aVar, personStatus);
        }
        c.a.r0.p2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.p(aVar);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.s;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.f23552j.j());
        }
        this.F.post(new j(this));
        this.y.g(aVar);
        this.y.f(aVar);
        if (ListUtils.isEmpty(aVar.f())) {
            this.m.m();
            c.a.e.e.p.l.M(this.f23543a.getContext(), this.f23543a.getString(R.string.data_load_error));
            return;
        }
        c.a.r0.a3.a.v().K(this.k);
        int size = aVar.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            c.a.e.l.e.n nVar = aVar.f().get(i2);
            if (nVar != null && (nVar instanceof c.a.r0.p2.e.i)) {
                this.m.m();
                return;
            }
        }
        if (z) {
            return;
        }
        this.m.z(true, aVar.f());
    }
}
