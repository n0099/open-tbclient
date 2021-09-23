package c.a.r0.o2.j;

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
import c.a.r0.z2.b;
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
    public c.a.r0.o2.g.b J;
    public c.a.r0.o2.j.k K;
    public ValueAnimator L;
    public long M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public Runnable R;
    public c.a.r0.o2.d.a S;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f23359a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f23360b;

    /* renamed from: c  reason: collision with root package name */
    public PluginErrorTipView f23361c;

    /* renamed from: d  reason: collision with root package name */
    public View f23362d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.y1.a f23363e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f23364f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f23365g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f23366h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f23367i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.o2.e.a f23368j;
    public boolean k;
    public BdUniqueId l;
    public c.a.r0.o2.d.f m;
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
        public final /* synthetic */ p f23369a;

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
            this.f23369a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && this.f23369a.O == ((Integer) customResponsedMessage.getData()).intValue() && this.f23369a.N) {
                c.a.e.e.m.e.a().removeCallbacks(this.f23369a.R);
                this.f23369a.V();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f23370e;

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
            this.f23370e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23370e.N) {
                this.f23370e.V();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements c.a.r0.o2.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23371a;

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
            this.f23371a = pVar;
        }

        @Override // c.a.r0.o2.d.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f23371a.Q = z;
                if (this.f23371a.J == null || this.f23371a.J.B() == null) {
                    return;
                }
                this.f23371a.J.B().setOpen(z);
            }
        }

        @Override // c.a.r0.o2.d.a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f23371a.G.height = -2;
                this.f23371a.F.setLayoutParams(this.f23371a.G);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.q0.s.f0.q.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23372a;

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
            this.f23372a = pVar;
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
                c.a.e.e.m.e.a().postDelayed(this.f23372a.R, p.T);
                this.f23372a.N = true;
                p pVar = this.f23372a;
                pVar.O = pVar.y.b();
                this.f23372a.M();
                this.f23372a.y.forceRefresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23373a;

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
            this.f23373a = pVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                    UtilHelper.changeStatusBarIconAndTextColor(i2 == 0, this.f23373a.f23359a.getPageActivity());
                } else {
                    UtilHelper.changeStatusBarIconAndTextColor(true, this.f23373a.f23359a.getPageActivity());
                }
                this.f23373a.r.setEnableSlideLoading(i2 == 0);
                int abs = Math.abs(i2);
                this.f23373a.K.i(abs == 0);
                float f2 = abs;
                this.f23373a.K.m(f2 > this.f23373a.p / 2.0f);
                float abs2 = ((double) this.f23373a.p) == 0.0d ? 0.0f : Math.abs(f2 / this.f23373a.p);
                this.f23373a.K.h(abs2);
                if (abs2 >= 1.0f) {
                    this.f23373a.o = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f23373a.E.setCornerRadii(this.f23373a.o);
                    this.f23373a.u.setBackgroundDrawable(this.f23373a.E);
                    this.f23373a.Y();
                } else {
                    this.f23373a.o = new float[]{p.U, p.U, p.U, p.U, 0.0f, 0.0f, 0.0f, 0.0f};
                    this.f23373a.E.setCornerRadii(this.f23373a.o);
                    this.f23373a.u.setBackgroundDrawable(this.f23373a.E);
                    this.f23373a.O();
                }
                int i3 = this.f23373a.D - this.f23373a.C;
                if (this.f23373a.D <= 0 || Math.abs(i2) < i3) {
                    return;
                }
                this.f23373a.r.endLoading();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f23374e;

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
            this.f23374e = pVar;
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
                this.f23374e.y.e(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23375a;

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
            this.f23375a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.f23375a.K == null) {
                return;
            }
            this.f23375a.K.n();
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23376a;

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
            this.f23376a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23376a.H.reset();
                this.f23376a.H = null;
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
        public final /* synthetic */ p f23377a;

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
            this.f23377a = pVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23377a.w.setVisibility(8);
                this.f23377a.I.reset();
                this.f23377a.I = null;
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
        public final /* synthetic */ p f23378e;

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
            this.f23378e = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f23378e.C == 0) {
                p pVar2 = this.f23378e;
                pVar2.C = pVar2.F.getMeasuredHeight();
                this.f23378e.p = pVar.F.getMeasuredHeight() - this.f23378e.K.e().getMeasuredHeight();
                if (this.f23378e.s != null) {
                    p pVar3 = this.f23378e;
                    pVar3.P = pVar3.q + this.f23378e.K.e().getMeasuredHeight() + this.f23378e.F.getMeasuredHeight() + this.f23378e.v.getMeasuredHeight();
                    boolean z = (this.f23378e.k || this.f23378e.f23368j.j() == null || this.f23378e.f23368j.j().getNewGodData() == null || !this.f23378e.f23368j.j().getNewGodData().isNewGod()) ? false : true;
                    this.f23378e.G.height = this.f23378e.P;
                    this.f23378e.F.setLayoutParams(this.f23378e.G);
                    this.f23378e.P += z ? c.a.r0.o2.g.a.b0 : 0;
                    this.f23378e.G.height = -2;
                    this.f23378e.F.setLayoutParams(this.f23378e.G);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23379a;

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
            this.f23379a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof c.a.r0.z2.b)) {
                SparseArray<b.a> sparseArray = ((c.a.r0.z2.b) customResponsedMessage.getData()).f29771a;
                if (sparseArray.size() <= 0) {
                    return;
                }
                b.a aVar = sparseArray.get(2);
                if (this.f23379a.J != null && aVar != null) {
                    this.f23379a.J.I(aVar.f29772a);
                }
                b.a aVar2 = sparseArray.get(4);
                b.a aVar3 = sparseArray.get(3);
                b.a aVar4 = sparseArray.get(1);
                b.a aVar5 = sparseArray.get(7);
                b.a aVar6 = sparseArray.get(8);
                if (this.f23379a.f23368j != null) {
                    if (this.f23379a.f23368j.w != null && this.f23379a.f23368j.w.f23252b != null && aVar2 != null) {
                        this.f23379a.f23368j.w.f23252b.putBoolean("person_center_item_red_tip_show", aVar2.f29772a);
                    }
                    if (aVar3 != null && this.f23379a.f23368j.v != null && this.f23379a.f23368j.v.f23252b != null) {
                        this.f23379a.f23368j.v.f23252b.putBoolean("person_center_item_red_tip_show", aVar3.f29772a);
                    }
                    if (aVar4 != null && this.f23379a.f23368j.u != null && this.f23379a.f23368j.u.f23252b != null) {
                        this.f23379a.f23368j.u.f23252b.putBoolean("person_center_item_red_tip_show", aVar4.f29772a);
                    }
                    if (aVar5 != null && this.f23379a.f23368j.x != null && this.f23379a.f23368j.x.f23252b != null) {
                        this.f23379a.f23368j.x.f23252b.putBoolean("person_center_item_red_tip_show", aVar5.f29772a);
                    }
                    if (aVar6 == null || this.f23379a.f23368j.y == null || this.f23379a.f23368j.y.f23252b == null) {
                        return;
                    }
                    this.f23379a.f23368j.y.f23252b.putBoolean("person_center_item_red_tip_show", aVar6.f29772a);
                    this.f23379a.f23368j.y.f23252b.putString("person_center_item_txt", String.valueOf(aVar6.f29773b));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f23380a;

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
            this.f23380a = pVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserPendantData) || (userPendantData = (UserPendantData) customResponsedMessage.getData()) == null) {
                return;
            }
            this.f23380a.J.K(userPendantData.getImgUrl());
        }
    }

    /* loaded from: classes3.dex */
    public class m extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<String> f23381a;

        /* renamed from: b  reason: collision with root package name */
        public List<PersonCenterTabBaseFragment> f23382b;

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
            this.f23381a = arrayList;
            arrayList.add(pVar.f23359a.getResources().getString(R.string.person_center_tab_main));
            this.f23381a.add(pVar.f23359a.getResources().getString(R.string.person_center_tab_thread));
            this.f23381a.add(pVar.f23359a.getResources().getString(R.string.person_center_tab_dynamic));
            ArrayList arrayList2 = new ArrayList();
            this.f23382b = arrayList2;
            arrayList2.add(PersonCenterMainTabFragment.newInstance(pVar.M, pVar.k));
            this.f23382b.add(PersonCenterThreadTabFragment.newInstance(pVar.M, pVar.k));
            this.f23382b.add(PersonCenterDynamicTabFragment.newInstance(pVar.M, pVar.k));
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ListUtils.isEmpty(this.f23382b)) {
                    return -1;
                }
                for (int i2 = 0; i2 < this.f23382b.size(); i2++) {
                    PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23382b.get(i2);
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
                if (i2 < this.f23382b.size()) {
                    return this.f23382b.get(i2);
                }
                return null;
            }
            return (PersonCenterTabBaseFragment) invokeI.objValue;
        }

        public final String d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f23381a.get(i2) : (String) invokeI.objValue;
        }

        public void e(int i2) {
            PersonCenterTabBaseFragment personCenterTabBaseFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                for (int i3 = 0; i3 < this.f23381a.size() && (personCenterTabBaseFragment = this.f23382b.get(i3)) != null; i3++) {
                    if (i3 == i2) {
                        personCenterTabBaseFragment.setPrimary(true);
                    } else {
                        personCenterTabBaseFragment.setPrimary(false);
                    }
                }
            }
        }

        public void f(c.a.r0.o2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || ListUtils.isEmpty(this.f23382b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23382b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23382b.get(i2);
                if (personCenterTabBaseFragment instanceof PersonCenterMainTabFragment) {
                    ((PersonCenterMainTabFragment) personCenterTabBaseFragment).setData(aVar);
                }
            }
        }

        public void forceRefresh() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.isEmpty(this.f23382b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23382b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23382b.get(i2);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.forceRefresh(false);
                }
            }
        }

        public void g(c.a.r0.o2.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.i() == null || ListUtils.isEmpty(this.f23382b)) {
                return;
            }
            for (int i2 = 0; i2 < this.f23382b.size(); i2++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23382b.get(i2);
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
                List<PersonCenterTabBaseFragment> list = this.f23382b;
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
            if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (list = this.f23382b) == null || list.size() <= 0) {
                return;
            }
            int size = this.f23382b.size();
            for (int i3 = 0; i3 < size; i3++) {
                PersonCenterTabBaseFragment personCenterTabBaseFragment = this.f23382b.get(i3);
                if (personCenterTabBaseFragment != null) {
                    personCenterTabBaseFragment.onChangeSkinType(i2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1104721, "Lc/a/r0/o2/j/p;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1104721, "Lc/a/r0/o2/j/p;");
                return;
            }
        }
        U = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds30);
    }

    public p(BaseFragment baseFragment, c.a.r0.o2.d.g gVar, BdUniqueId bdUniqueId, boolean z, long j2) {
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
        this.f23359a = baseFragment.getPageContext();
        this.l = bdUniqueId;
        this.k = z;
        this.M = j2;
        this.m = gVar.l();
        R(gVar.f23146i);
    }

    public c.a.r0.o2.g.b L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.J : (c.a.r0.o2.g.b) invokeV.objValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (c.a.e.e.p.j.z()) {
                this.f23363e.f();
                this.f23363e.g();
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
            this.f23367i = gVar;
            gVar.setTag(this.l);
            tbPageContext.registerListener(this.f23367i);
        }
    }

    public final void Q(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            k kVar = new k(this, 2001435);
            this.f23364f = kVar;
            kVar.setTag(this.l);
            tbPageContext.registerListener(this.f23364f);
            l lVar = new l(this, 2016485);
            this.f23365g = lVar;
            lVar.setTag(this.l);
            tbPageContext.registerListener(this.f23365g);
            a aVar = new a(this, 2921435);
            this.f23366h = aVar;
            aVar.setTag(this.l);
            tbPageContext.registerListener(this.f23366h);
        }
    }

    public final void R(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            this.f23362d = view;
            this.q = UtilHelper.getStatusBarHeight();
            this.r = (LottieSlideLoadingLayout) this.f23362d.findViewById(R.id.person_center_content_view);
            TbImageView tbImageView = (TbImageView) this.f23362d.findViewById(R.id.person_center_header_bg);
            this.s = new PersonHeaderBackgroundController(this.f23359a, tbImageView, this.f23362d.findViewById(R.id.person_center_background_cover), this.k);
            this.r.addSyncHeightView(tbImageView);
            TbPageContext tbPageContext = this.f23359a;
            View view2 = this.f23362d;
            this.K = new c.a.r0.o2.j.k(tbPageContext, view2, view2.findViewById(R.id.person_center_status_bar_space), this.k);
            FrameLayout frameLayout = (FrameLayout) this.f23362d.findViewById(R.id.person_center_header_container);
            this.F = frameLayout;
            this.G = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            this.r.addSyncHeightView(this.F);
            this.r.addLoadingListener(new d(this));
            AppBarLayout appBarLayout = (AppBarLayout) this.f23362d.findViewById(R.id.person_center_app_bar_layout);
            this.t = appBarLayout;
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new e(this));
            this.u = (FrameLayout) this.f23362d.findViewById(R.id.person_center_tab_layout_container);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = (NewPagerSlidingTabBaseStrip) this.f23362d.findViewById(R.id.person_center_tab_layout);
            this.v = newPagerSlidingTabBaseStrip;
            newPagerSlidingTabBaseStrip.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            this.v.setRectPaintColor(R.color.CAM_X0302);
            this.v.init(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds46), c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds46), c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds10), c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds46), true);
            this.v.setIndicatorOffset(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds64));
            this.v.setIndicatorOvershot(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorRadius(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds8));
            this.v.setIndicatorMarginBottom(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds0));
            this.v.setExpandedTabLayoutParams(new LinearLayout.LayoutParams(c.a.e.e.p.l.g(this.f23359a.getPageActivity(), R.dimen.tbds166), -1));
            this.v.setOnPageChangeListener(new f(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.E = gradientDrawable;
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0201));
            this.E.setCornerRadii(this.o);
            this.u.setBackgroundDrawable(this.E);
            View findViewById = this.f23362d.findViewById(R.id.person_center_pager_shadow);
            this.w = findViewById;
            SkinManager.setBackgroundResource(findViewById, R.drawable.personalize_tab_shadow);
            this.x = (CustomViewPager) this.f23362d.findViewById(R.id.person_center_view_pager);
            m mVar = new m(this, this.n.getActivity().getSupportFragmentManager());
            this.y = mVar;
            this.x.setAdapter(mVar);
            this.x.setOffscreenPageLimit(this.y.f23382b.size());
            this.y.notifyDataSetChanged();
            this.v.setViewPager(this.x);
            this.x.setCurrentItem(1);
            c.a.r0.o2.g.b bVar = new c.a.r0.o2.g.b(this.f23359a, this.k);
            this.J = bVar;
            bVar.H(this.S);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            this.F.addView(this.J.C(), layoutParams);
            if (this.K.f()) {
                Q(this.f23359a);
            }
            P(this.f23359a);
            this.f23360b = (NoNetworkView) this.f23362d.findViewById(R.id.person_center_no_network_view);
            this.f23361c = (PluginErrorTipView) this.f23362d.findViewById(R.id.person_center_plugin_error_tip_view);
            this.z = (LinearLayout) this.f23362d.findViewById(R.id.person_center_anti_container);
            this.A = (FrameLayout) this.f23362d.findViewById(R.id.person_center_anti_content);
            this.B = (RelativeLayout) this.f23362d.findViewById(R.id.person_center_noanti_rootview);
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
            c.a.r0.o2.j.k kVar = this.K;
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
            c.a.r0.o2.g.b bVar = this.J;
            if (bVar != null) {
                bVar.F(i2);
            }
            m mVar = this.y;
            if (mVar != null) {
                mVar.onChangeSkinType(i2);
            }
            NoNetworkView noNetworkView = this.f23360b;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.f23359a, i2);
            }
            PluginErrorTipView pluginErrorTipView = this.f23361c;
            if (pluginErrorTipView != null) {
                pluginErrorTipView.onChangeSkinType(this.f23359a, i2);
            }
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.f23362d, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.w, R.drawable.personalize_tab_shadow);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.o2.g.b bVar = this.J;
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

    public void W(c.a.r0.y1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.f23363e = aVar;
        }
    }

    public void X(c.a.r0.b4.e eVar) {
        c.a.r0.o2.j.k kVar;
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

    public void Z(c.a.r0.o2.e.a aVar, boolean z, PersonStatus personStatus) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{aVar, Boolean.valueOf(z), personStatus}) == null) || aVar == null) {
            return;
        }
        this.f23368j = aVar;
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        c.a.r0.o2.j.k kVar = this.K;
        if (kVar != null) {
            kVar.l(aVar, personStatus);
        }
        c.a.r0.o2.g.b bVar = this.J;
        if (bVar != null) {
            bVar.p(aVar);
        }
        PersonHeaderBackgroundController personHeaderBackgroundController = this.s;
        if (personHeaderBackgroundController != null) {
            personHeaderBackgroundController.e(this.f23368j.j());
        }
        this.F.post(new j(this));
        this.y.g(aVar);
        this.y.f(aVar);
        if (ListUtils.isEmpty(aVar.f())) {
            this.m.m();
            c.a.e.e.p.l.M(this.f23359a.getContext(), this.f23359a.getString(R.string.data_load_error));
            return;
        }
        c.a.r0.z2.a.v().K(this.k);
        int size = aVar.f().size();
        for (int i2 = 0; i2 < size; i2++) {
            c.a.e.l.e.n nVar = aVar.f().get(i2);
            if (nVar != null && (nVar instanceof c.a.r0.o2.e.i)) {
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
