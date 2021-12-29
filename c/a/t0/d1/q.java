package c.a.t0.d1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.g.d;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.o2;
import c.a.s0.s.s.c;
import c.a.t0.k.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.design.behavior.AppBarLayoutStickyBehavior;
import com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
import com.baidu.tieba.frs.FrsAllThreadFragment;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.FrsTabViewPager;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.frs.view.FrsMoveAreaBottomMenuView;
import com.baidu.tieba.frs.view.FrsMultiDelBottomMenuView;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    public View B;
    public View C;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public CommonTipView H;
    public c.a.t0.d1.z2.d I;
    public c.a.t0.d1.y1.e.c J;
    public c.a.t0.d1.z2.m K;
    public GifView L;
    public TbImageView M;
    public HashSet<String> N;
    public c.a.t0.z2.k O;
    public int P;
    public int Q;
    public View R;
    public View S;
    public ObservedChangeLinearLayout T;
    public boolean U;
    public c.a.t0.d1.y1.e.a V;
    public boolean W;
    public c.a.t0.k4.e X;
    public AppBarLayout Y;
    public AppBarLayoutStickyBehavior Z;
    public FrsFragment a;
    public FrsHeaderViewContainer a0;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f16664b;
    public CollapsingToolbarLayout b0;

    /* renamed from: c  reason: collision with root package name */
    public CoordinatorLayout f16665c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public View f16666d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public View f16667e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16668f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16669g;
    public c.a.t0.d1.z2.h g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageRedDotView f16670h;
    public FrsMultiDelBottomMenuView h0;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.k0.f f16671i;
    public FrsMoveAreaBottomMenuView i0;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f16672j;
    public NavigationBarCoverTip j0;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f16673k;
    public TextView k0;
    public TextView l;
    public TextView l0;
    public ViewStub m;
    public int m0;
    public FrameLayout n;
    public int n0;
    public TbImageView o;
    public boolean o0;
    public TbImageView p;
    public c.a.d.n.e.l p0;
    public ExposeTagViewCoordinatorLayout q;
    public CustomMessageListener q0;
    public FrsTabViewPager r;
    public AppBarLayout.OnOffsetChangedListener r0;
    public PbListView s;
    public Runnable s0;
    public BdTypeRecyclerView t;
    public boolean t0;
    public c.a.t0.d1.y1.d.e0 u;
    public c.a.t0.d1.z2.k v;
    public c.a.s0.s.s.c w;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes7.dex */
    public class a implements c.InterfaceC0871c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public a(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // c.a.s0.s.s.c.InterfaceC0871c
        public void a(c.a.s0.s.s.c cVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i2, view) == null) {
                cVar.e();
                if (i2 == 0) {
                    this.a.a.takePhoto();
                } else if (i2 != 1 || this.a.a.getPageContext() == null) {
                } else {
                    SelectImageHelper.getAlbumImage(this.a.a.getPageContext().getPageActivity());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16674e;

        public b(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16674e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16674e.m == null) {
                return;
            }
            this.f16674e.n.setVisibility(0);
            this.f16674e.p.setVisibility(0);
            this.f16674e.o.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.a.d.f.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public c(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // c.a.d.f.g.b
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(g1.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(f1.tips)).setText(i1.frs_video_activity_guide_tip);
                this.a.a.getPageContext().getLayoutMode().j(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // c.a.d.f.g.b
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.d.f.p.n.f(this.a.a.getActivity(), d1.ds10) : invokeV.intValue;
        }

        @Override // c.a.d.f.g.b
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? -c.a.d.f.p.n.f(this.a.a.getActivity(), d1.ds6) : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.s.g0.b.j().w("frs_video_activity_guide", 1L);
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d.f.g.c f16675e;

        public e(q qVar, c.a.d.f.g.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16675e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.d.f.g.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f16675e) == null) {
                return;
            }
            cVar.e();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16676e;

        public f(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16676e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16676e.V().notifyDataSetChanged();
                if (this.f16676e.o0) {
                    return;
                }
                this.f16676e.O.n(this.f16676e.P, this.f16676e.Q, this.f16676e.G, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q qVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, Integer.valueOf(i2)};
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
            this.a = qVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.p0 == null) {
                        this.a.p0 = new c.a.d.n.e.l(new c.a.d.n.e.j());
                    }
                    this.a.p0.q(this.a.t, 2);
                } else if (this.a.p0 != null) {
                    this.a.p0.w();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public h(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) {
                this.a.L(appBarLayout, i2);
                if (this.a.v != null && this.a.q.hasTargetView()) {
                    this.a.v.q(i2 == 0 && !this.a.q.canDrag());
                }
                if (this.a.e0 != i2 && Math.abs(i2) >= 0 && this.a.S() != -1) {
                    if (Math.abs(i2) >= this.a.S()) {
                        if (this.a.c0) {
                            this.a.c0 = false;
                            q qVar = this.a;
                            qVar.J0(qVar.c0);
                        }
                    } else if (!this.a.c0) {
                        this.a.c0 = true;
                        q qVar2 = this.a;
                        qVar2.J0(qVar2.c0);
                    }
                    int Y = this.a.Y() + this.a.e0() + this.a.g0();
                    int totalScrollRange = appBarLayout.getTotalScrollRange() - Y;
                    int totalScrollRange2 = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                    if (totalScrollRange <= 0) {
                        return;
                    }
                    float abs = Math.abs(i2 * 1.0f) / totalScrollRange;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && this.a.e0 - i2 < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.a.R1(Math.abs(Y - totalScrollRange2));
                        if (this.a.S != null) {
                            this.a.S.setVisibility(0);
                        }
                    } else if (this.a.S != null) {
                        if (this.a.m0() != UtilHelper.getStatusBarHeight()) {
                            this.a.R1(0);
                        }
                        this.a.S.setVisibility(8);
                    }
                    if (this.a.A != null) {
                        if (this.a.U) {
                            this.a.A.getBarBgView().setAlpha(abs);
                            this.a.U1(false);
                        } else if (this.a.l0 != null) {
                            this.a.l0.setAlpha(abs);
                        }
                    }
                    this.a.e0 = i2;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i2));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.a.a != null && this.a.a.getTabController() != null && this.a.a.getTabController().A() != null && (this.a.a.getTabController().A().f45397b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.a.a.getTabController().A().f45397b).getUniqueId());
                        customResponsedMessage.setOrginalMessage(customMessage);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
                if (this.a.v == null || this.a.v.i() <= 0 || Math.abs(i2) < this.a.v.i()) {
                    return;
                }
                this.a.v.v();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements c.a.s0.g1.j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public i(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // c.a.s0.g1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5 || i5 <= 0) {
                return;
            }
            this.a.b0.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f16677b;

        public j(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16677b = qVar;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveFinished(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                super.onRemoveFinished(viewHolder);
                int i2 = this.a - 1;
                this.a = i2;
                if (i2 == 0) {
                    this.f16677b.t.getAdapter().notifyDataSetChanged();
                }
            }
        }

        @Override // androidx.recyclerview.widget.SimpleItemAnimator
        public void onRemoveStarting(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) {
                this.a++;
                super.onRemoveStarting(viewHolder);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(q qVar, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public l(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
                if (this.a.O != null) {
                    this.a.O.k(view);
                }
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view.findViewById(f1.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.reset();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view.findViewById(f1.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.reset();
                }
                if (view instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view).reset();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16678e;

        public m(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16678e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16678e.a.hideKeyBroad();
                if (this.f16678e.a == null || this.f16678e.Y == null) {
                    return;
                }
                this.f16678e.a.scrollCurrentTabToTop();
                this.f16678e.Y.setExpanded(true);
                if (this.f16678e.O != null) {
                    this.f16678e.O.n(this.f16678e.P, this.f16678e.Q, false, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q a;

        public n(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qVar;
        }

        @Override // com.baidu.adp.widget.design.behavior.ExposeTagViewCoordinatorLayout.NestedScrollAcceptedListener
        public void onNestedScrollAccepted(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.v != null && this.a.q.hasTargetView()) {
                this.a.v.q(this.a.e0 == 0 && !this.a.q.canDrag());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16679e;

        public o(q qVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16679e = qVar;
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
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f16679e.v != null && this.f16679e.q.hasTargetView()) {
                this.f16679e.v.q(false);
                this.f16679e.q.clearTargetView();
            }
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, c.a.t0.d1.y1.e.a aVar, boolean z, c.a.t0.d1.z2.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onClickListener, aVar, Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f16664b = null;
        this.f16665c = null;
        this.f16666d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.D = true;
        this.E = true;
        this.F = 0;
        this.G = false;
        this.P = 0;
        this.Q = 0;
        this.R = null;
        this.S = null;
        this.U = false;
        this.W = true;
        this.c0 = true;
        this.d0 = -1;
        this.e0 = -1;
        this.m0 = 0;
        this.n0 = 0;
        this.o0 = false;
        this.q0 = new g(this, 2156674);
        this.r0 = new h(this);
        this.s0 = new b(this);
        this.a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.q0);
        z0(aVar, z);
        this.N = new HashSet<>();
        this.F = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.f0 = TbadkCoreApplication.getInst().getSkinType();
        this.g0 = hVar;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void A1(ArrayList<c.a.d.n.e.n> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<c.a.d.n.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            s sVar = new s();
            ArrayList<c.a.d.n.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(sVar);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.getModelController() != null && this.a.getModelController().V() == 0) {
                sVar.d(this.a.getModelController().R());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                c.a.d.n.e.n nVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nVar instanceof c2) {
                    ((c2) nVar).w.y4(i3);
                }
            }
        }
        this.u.h(switchThreadDataToThreadCardInfo, frsViewData);
        c.a.t0.z2.k kVar = this.O;
        if (kVar != null && (i2 = this.P) != 0) {
            kVar.n(i2, this.Q, this.G, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.setLiveCardStatData();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.h0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s.b().getParent() != null && this.E : invokeV.booleanValue;
    }

    public void B1(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && TextUtils.isEmpty(this.l0.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.l0.setText("");
                return;
            }
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                str2 = fixedBarText + "吧";
            } else {
                str2 = UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
            }
            this.l0.setText(str2);
            c.a.s0.s.k.c().h(str);
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.isChooseViewShow();
        }
        return invokeV.booleanValue;
    }

    public void C1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || this.T == null) {
            return;
        }
        k1();
        if (this.U) {
            this.A.getBarBgView().setAlpha(0.0f);
            this.A.hideBottomLine();
        } else {
            View view = this.R;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.S;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            TextView textView = this.l0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.A.getBarBgView().setAlpha(1.0f);
            this.A.showBottomLine();
        }
        K0(this.f0);
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.t0.d1.z2.k kVar = this.v;
            if (kVar != null) {
                return kVar.h() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D1() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.t();
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            c.a.t0.d1.z2.d dVar = this.I;
            if (dVar == null) {
                return false;
            }
            return dVar.p();
        }
        return invokeV.booleanValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.E = true;
            this.t.setNextPage(this.s);
            this.s.C(this.x);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.f();
            this.s.D(this.a.getResources().getString(i1.list_click_load_more));
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            c.a.t0.d1.y1.d.e0 e0Var = this.u;
            if (e0Var instanceof c.a.t0.d1.y1.d.q) {
                ((c.a.t0.d1.y1.d.q) e0Var).s();
            }
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.s0, 5000L);
    }

    public void G0() {
        c.a.t0.d1.y1.d.e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (e0Var = this.u) == null) {
            return;
        }
        e0Var.notifyDataSetChanged();
    }

    public void G1(o2 o2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, o2Var) == null) {
            if (this.m == null) {
                View rootView = this.a.getRootView();
                ViewStub viewStub = (ViewStub) rootView.findViewById(f1.yule_game_egg_view_stub);
                this.m = viewStub;
                viewStub.setVisibility(0);
                this.n = (FrameLayout) rootView.findViewById(f1.game_activity_egg_layout);
                this.o = (TbImageView) rootView.findViewById(f1.game_activity_egg);
                this.p = (TbImageView) rootView.findViewById(f1.game_activity_egg_s);
                this.o.setPageId(this.a.getUniqueId());
                this.p.setPageId(this.a.getUniqueId());
                this.o.setDefaultBgResource(c1.common_color_10022);
                this.o.setDefaultResource(0);
                this.p.setDefaultBgResource(c1.common_color_10022);
                this.p.setDefaultResource(0);
                this.n.setOnClickListener(this.x);
            }
            this.n.setVisibility(0);
            String a2 = o2Var.a();
            String b2 = o2Var.b();
            this.o.startLoad(a2, 10, false);
            this.p.startLoad(b2, 10, false);
            TbadkCoreApplication.getInst().handler.postDelayed(this.s0, 5000L);
        }
    }

    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.o0 = z;
            if (this.O == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            boolean z2 = (frsFragment == null || frsFragment.getTabController() == null || this.a.getTabController().A() == null) ? true : this.a.getTabController().A().f45397b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.O.r(true);
                this.O.n(this.P, this.Q, this.G, true);
                return;
            }
            this.O.r(false);
            this.O.y();
        }
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public void I(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public void I0(int i2, int i3) {
        c.a.t0.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) || (kVar = this.O) == null) {
            return;
        }
        kVar.m(i2, i3, this.G, 1);
        if (c.a.s0.b.d.o()) {
            this.O.p(2);
        } else {
            this.O.p(1);
        }
        this.O.q(false);
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.E = true;
            this.t.setNextPage(this.s);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.C(null);
            this.s.R();
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.a == null) {
            return;
        }
        K(i2);
    }

    public final void J0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || !z || (frsFragment = this.a) == null || frsFragment.getHeaderVC() == null) {
            return;
        }
        this.a.getHeaderVC().O();
    }

    public final void J1(int i2) {
        c.a.t0.k0.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (fVar = this.f16671i) == null) {
            return;
        }
        fVar.g(i2);
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.A.getBarBgView(), c1.CAM_X0207);
                SkinManager.setBackgroundColor(this.A.getBottomLine(), c1.CAM_X0204);
                SkinManager.setBackgroundColor(this.B, c1.CAM_X0204, i2);
                c.a.t0.k0.f fVar = this.f16671i;
                if (fVar != null) {
                    fVar.d(i2);
                }
                if (this.f16673k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16673k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.f16672j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16672j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.R, c1.CAM_X0207);
            SkinManager.setBackgroundColor(this.S, c1.CAM_X0207);
            U1(true);
        }
    }

    public void K0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f0 = i2;
            c.a.t0.h.f.b bVar = new c.a.t0.h.f.b(this.a, 4);
            bVar.D(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
            c.a.t0.h.f.a aVar = new c.a.t0.h.f.a(this.a.getPageContext(), 4);
            aVar.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
            TbImageView tbImageView = this.M;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            c.a.t0.d1.y1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.c();
                this.u.notifyDataSetChanged();
            }
            c.a.s0.x0.a.a(this.a.getPageContext(), this.f16664b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0109));
                this.s.d(i2);
            }
            TextView textView = this.l0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(c1.CAM_X0105));
            }
            J(i2);
            c.a.t0.d1.y1.e.c cVar = this.J;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
            c.a.t0.d1.z2.d dVar = this.I;
            if (dVar != null) {
                dVar.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.h0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.onChangeSkinType();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.f16666d, c1.CAM_X0202);
        }
    }

    public void K1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, str, i2) == null) {
            if (this.k0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.k0 = textView;
                textView.setGravity(19);
                this.k0.setPadding(c.a.d.f.p.n.f(this.a.getActivity(), d1.ds34), 0, c.a.d.f.p.n.f(this.a.getActivity(), d1.ds34), 0);
                this.k0.setLayoutParams(new ViewGroup.LayoutParams(-1, c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds112)));
                this.k0.setTextSize(0, c.a.d.f.p.n.f(this.a.getActivity(), d1.fontsize30));
                this.k0.setMaxLines(2);
                this.k0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.k0.setTextColor(ContextCompat.getColor(this.a.getActivity(), c1.CAM_X0101));
            }
            this.j0.setBackgroundColor(i2);
            this.k0.setText(str);
            this.j0.showTip(this.a.getActivity(), this.k0, 5000);
        }
    }

    public final void L(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048601, this, appBarLayout, i2) == null) || (frsFragment = this.a) == null || appBarLayout == null || frsFragment.getTabController() == null || this.a.getPageContext() == null) {
            return;
        }
        int Y = Y() + e0() + g0();
        int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i2);
        FrsTabViewController tabController = this.a.getTabController();
        ViewGroup.LayoutParams layoutParams = this.f16666d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.a;
        boolean z = frsFragment2 != null && frsFragment2.needAdjustHeaderBottom();
        if (totalScrollRange <= 0) {
            if (this.n0 != 2) {
                tabController.f(2);
            }
            this.n0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange <= Y) {
            if (this.n0 != 1) {
                tabController.f(1);
            }
            this.n0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.n0 != 0) {
                tabController.f(0);
            }
            this.n0 = 0;
            if (z) {
                marginLayoutParams.topMargin = c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.f16666d.setLayoutParams(marginLayoutParams);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q0);
            c.a.t0.z2.k kVar = this.O;
            if (kVar != null) {
                kVar.h();
            }
            c.a.t0.d1.z2.m mVar = this.K;
            if (mVar != null) {
                mVar.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.h0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.i0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.n();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.s0);
            CommonTipView commonTipView = this.H;
            if (commonTipView != null) {
                commonTipView.onDestroy();
            }
            this.N.clear();
            c.a.t0.d1.z2.d dVar = this.I;
            if (dVar != null) {
                dVar.r();
            }
            c.a.t0.k4.e eVar = this.X;
            if (eVar != null) {
                eVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.j0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.onDestroy();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.h0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.onDestroy();
            }
            c.a.t0.d1.z2.k kVar2 = this.v;
            if (kVar2 != null) {
                kVar2.n();
            }
        }
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.E = false;
            this.t.setNextPage(this.s);
            int i2 = this.F;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.C(null);
            this.s.f();
            this.s.D(this.a.getResources().getString(i1.list_has_no_more));
        }
    }

    public void M(String str) {
        c.a.t0.d1.z2.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (mVar = this.K) == null) {
            return;
        }
        mVar.a(str);
    }

    public boolean M0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.Y != null && (appBarLayoutStickyBehavior = this.Z) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.Z.expandedAppBarLayout(this.Y);
                return true;
            }
            c.a.t0.d1.z2.d dVar = this.I;
            return dVar != null && dVar.v();
        }
        return invokeV.booleanValue;
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            P();
            c.a.s0.s.s.c cVar = this.w;
            if (cVar != null) {
                cVar.m();
            }
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.v.f();
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.t0.d1.z2.d dVar = this.I;
            if (dVar != null) {
                dVar.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void N1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                c.a.s0.t.h.b.c(this.a.getTbPageContext(), postWriteCallBackData, 1);
                return;
            }
            if (this.X == null) {
                this.X = new c.a.t0.k4.e(this.a.getActivity(), this.f16664b);
            }
            this.X.g(postWriteCallBackData);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f16673k.setVisibility(0);
            this.f16672j.setVisibility(0);
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
        }
    }

    public void O1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048612, this) == null) || c.a.s0.s.g0.b.j().l("frs_video_activity_guide", 0L) != 0 || this.t0 || this.a.getActivity() == null || this.a.getPageContext() == null) {
            return;
        }
        View view = null;
        BdTypeRecyclerView bdTypeRecyclerView = this.t;
        if (bdTypeRecyclerView != null && (headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount()) < this.t.getChildCount()) {
            view = this.t.getChildAt(headerViewsCount);
        }
        if (view != null) {
            c.a.d.f.g.d dVar = new c.a.d.f.g.d();
            dVar.j(view);
            dVar.c(0);
            dVar.i(true);
            dVar.h(false);
            dVar.d(true);
            dVar.a(new c(this));
            dVar.g(new d(this));
            c.a.d.f.g.c b2 = dVar.b();
            b2.o(false);
            b2.q(this.a.getActivity());
            c.a.d.f.m.e.a().postDelayed(new e(this, b2), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            this.t0 = true;
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.w == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(i1.take_photo), this.a.getPageContext().getPageActivity().getString(i1.album)};
            c.a.s0.s.s.c cVar = new c.a.s0.s.s.c(this.a.getPageContext().getPageActivity());
            this.w = cVar;
            cVar.l(this.a.getPageContext().getPageActivity().getString(i1.operation));
            this.w.j(strArr, new a(this));
            this.w.c(this.a.getPageContext());
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            J(TbadkCoreApplication.getInst().getSkinType());
            c.a.t0.d1.z2.d dVar = this.I;
            if (dVar != null) {
                dVar.t();
            }
        }
    }

    public void P1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || this.I == null) {
            return;
        }
        if (c.a.s0.y.d.h().k()) {
            this.I.A(false);
        } else {
            this.I.A(z);
        }
    }

    public void Q() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.dismissLoadingView();
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || V() == null) {
            return;
        }
        List<c.a.d.n.e.n> g2 = V().g();
        if (ListUtils.isEmpty(g2)) {
            return;
        }
        for (c.a.d.n.e.n nVar : g2) {
            if (nVar instanceof c2) {
                c2 c2Var = (c2) nVar;
                if (c2Var.x != 0 && c2Var.w != null && this.a.getModelController() != null && this.a.getModelController().d0() != null) {
                    int[] h0 = c2Var.w.h0();
                    c2Var.x = h0[0];
                    c2Var.y = h0[1];
                }
            }
        }
        c.a.d.f.m.e.a().postDelayed(new f(this), 500L);
    }

    public void Q1() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.u();
    }

    public void R() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.dismissPopupWindow();
    }

    public void R0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && c.a.s0.s.g0.b.j().g("frs_login_tip", true)) {
                if (this.H == null) {
                    this.H = new CommonTipView(this.a.getActivity());
                }
                this.H.setText(i1.frs_login_tip);
                this.H.show((FrameLayout) U(), TbadkCoreApplication.getInst().getSkinType());
                c.a.s0.s.g0.b.j().t("frs_login_tip", false);
            }
        }
    }

    public final void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            View l0 = l0();
            View n0 = n0();
            if (!UtilHelper.canUseStyleImmersiveSticky() || l0 == null || n0 == null || l0.getLayoutParams() == null || n0.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = l0.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            l0.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = n0.getLayoutParams();
            layoutParams2.height = i2;
            if (i2 > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            n0.setLayoutParams(layoutParams2);
        }
    }

    public final int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            AppBarLayout appBarLayout = this.Y;
            if (appBarLayout == null) {
                return this.d0;
            }
            int i2 = this.d0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.Y.getChildAt(childCount);
                if (childAt != null) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                    if ((scrollFlags & 5) == 5) {
                        if ((scrollFlags & 8) != 0) {
                            i3 += ViewCompat.getMinimumHeight(childAt);
                        }
                    } else if (i3 > 0) {
                        break;
                    }
                }
            }
            int max = Math.max(0, this.Y.getTotalScrollRange() - Math.abs(i3));
            this.d0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void S0() {
        c.a.t0.d1.y1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.W && (cVar = this.J) != null) {
                cVar.b(false, false);
            }
            J1(8);
            this.f16673k.setVisibility(8);
            this.f16672j.setVisibility(8);
            P1(false);
            this.t.setVisibility(8);
            this.a0.setVisibility(8);
        }
    }

    public void S1() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.v();
    }

    public View T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.f16667e : (View) invokeV.objValue;
    }

    public void T0() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.u();
    }

    public final void T1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (navigationBar = this.A) == null) {
            return;
        }
        float alpha = navigationBar.getBarBgView() != null ? this.A.getBarBgView().getAlpha() : 0.0f;
        float f2 = alpha < 0.5f ? 1.0f - (alpha * 2.0f) : (alpha * 2.0f) - 1.0f;
        if (Float.compare(f2, 0.0f) < 0) {
            f2 = 0.0f;
        }
        if (Float.compare(f2, 1.0f) > 0) {
            f2 = 1.0f;
        }
        TextView textView = this.l0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f16668f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.f16669g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.getTabController() != null && this.m0 == 1) {
                this.a.getTabController().e0(f2);
            }
            MessageRedDotView messageRedDotView = this.f16670h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f2);
            }
            ImageView imageView3 = this.f16673k;
            if (imageView3 != null) {
                imageView3.setAlpha(f2);
            }
            ImageView imageView4 = this.f16672j;
            if (imageView4 != null) {
                imageView4.setAlpha(f2);
            }
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            float f3 = 1.0f - (2.0f * alpha);
            textView2.setAlpha(f3);
            this.l.setClickable(f3 > 0.0f);
        }
        View view = this.R;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.S;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.B;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public View U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.C : (View) invokeV.objValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            z0(this.V, this.a.isFromMainTab());
            c.a.t0.d1.y1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.f();
            }
        }
    }

    public final void U1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048630, this, z) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || !this.U) {
            return;
        }
        if (this.A.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.m0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16668f, e1.ic_icon_pure_topbar_return40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16673k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f16669g.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0101), null));
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16672j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.m0 = 0;
            }
        } else if (z || this.m0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16668f, e1.ic_icon_pure_topbar_return40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16673k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.f16669g.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0106), null));
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16672j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.m0 = 1;
        }
        T1();
    }

    public c.a.t0.d1.y1.d.e0 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.u : (c.a.t0.d1.y1.d.e0) invokeV.objValue;
    }

    public void V0(c.a.s0.s.q.g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, g0Var) == null) {
            c.a.t0.h.f.a aVar = new c.a.t0.h.f.a(this.a.getPageContext(), 1);
            aVar.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.getForumName());
            hashMap.put("forum_id", this.a.getForumId());
            aVar.k(hashMap);
            aVar.i(g0Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        }
    }

    public c.a.t0.d1.z2.k W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.v : (c.a.t0.d1.z2.k) invokeV.objValue;
    }

    public void W0(int i2, boolean z) {
        c.a.t0.k0.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (fVar = this.f16671i) == null) {
            return;
        }
        fVar.e(z, i2);
    }

    public c.a.t0.d1.z2.d X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.I : (c.a.t0.d1.z2.d) invokeV.objValue;
    }

    public void X0() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (noNetworkView = this.z) == null || (bVar = this.y) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public final int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void Y0() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.removeChooseView();
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            c.a.t0.d1.z2.k kVar = this.v;
            if (kVar == null) {
                return false;
            }
            return kVar.j();
        }
        return invokeV.booleanValue;
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (this.D) {
                return false;
            }
            this.s.D(this.a.getResources().getString(i1.load_more_must_after_delete));
            this.s.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public BdTypeRecyclerView a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.t : (BdTypeRecyclerView) invokeV.objValue;
    }

    public void a1() {
        c.a.t0.d1.y1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            if (this.W && (cVar = this.J) != null) {
                cVar.b(true, false);
            }
            J1(0);
            O();
            P1(this.a.canShowWriteButton());
            this.t.setVisibility(0);
            this.a0.setVisibility(0);
        }
    }

    public View b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            c.a.t0.k0.f fVar = this.f16671i;
            if (fVar != null) {
                return fVar.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void c1(int i2) {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048646, this, i2) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.o(i2);
    }

    public NavigationBar d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.A : (NavigationBar) invokeV.objValue;
    }

    public void d1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048648, this, z) == null) || (appBarLayout = this.Y) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public final int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void e1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i2, i3) == null) {
            this.P = i2;
            this.Q = i3;
        }
    }

    public ObservedChangeLinearLayout f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.T : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void f1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, str) == null) {
            this.u.a(str);
        }
    }

    public final int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.z == null || c.a.d.f.p.l.z()) {
                return 0;
            }
            return this.z.getHeight();
        }
        return invokeV.intValue;
    }

    public void g1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048654, this, i2) == null) || (view = this.f16666d) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.getTbPageContext().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    public c.a.t0.z2.k h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.O : (c.a.t0.z2.k) invokeV.objValue;
    }

    public void h1(boolean z) {
        c.a.t0.d1.y1.e.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048657, this, z) == null) || (cVar = this.J) == null) {
            return;
        }
        cVar.a(z);
    }

    public TextView i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void i1(boolean z, boolean z2) {
        c.a.t0.d1.y1.e.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.W && (cVar = this.J) != null) {
            cVar.b(z, z2);
        }
    }

    public c.a.t0.d1.y1.e.c j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.J : (c.a.t0.d1.y1.e.c) invokeV.objValue;
    }

    public void j1(s0 s0Var) {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048661, this, s0Var) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.p(s0Var);
    }

    public RelativeLayout k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.f16664b : (RelativeLayout) invokeV.objValue;
    }

    public final void k1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            this.U = u0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.a0;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.U) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.ds88) + Y(), 0, 0);
            }
            this.a0.requestLayout();
        }
    }

    public View l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.R : (View) invokeV.objValue;
    }

    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.u.b(z);
        }
    }

    public final int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            View view = this.R;
            if (view == null) {
                return 0;
            }
            return view.getHeight();
        }
        return invokeV.intValue;
    }

    public void m1(boolean z) {
        c.a.t0.d1.y1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048667, this, z) == null) {
            this.W = z;
            if (z || (cVar = this.J) == null) {
                return;
            }
            cVar.b(false, false);
        }
    }

    public View n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void n1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.G = z;
        }
    }

    public ImageView o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.f16673k : (ImageView) invokeV.objValue;
    }

    public void o1(int i2, boolean z) {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.r(i2, z);
    }

    public ImageView p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.f16672j : (ImageView) invokeV.objValue;
    }

    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.D = z;
            if (z) {
                this.s.D(this.a.getResources().getString(i1.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.s.b()) {
                    this.s.R();
                    this.a.loadMore();
                    return;
                }
                this.s.f();
                return;
            }
            this.s.D(this.a.getResources().getString(i1.load_more_must_after_delete));
            this.s.f();
        }
    }

    public int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void q1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048675, this, i2) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public void r0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void r1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048677, this, i2) == null) || (frsMoveAreaBottomMenuView = this.i0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048678, this) == null) {
            this.E = false;
            this.t.setNextPage(null);
        }
    }

    public void s1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048679, this, i2) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048680, this, z) == null) || this.J == null) {
            return;
        }
        if (z) {
            i1(false, true);
        } else {
            i1(false, false);
        }
    }

    public void t1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048681, this, z) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setIsBlockMode(z);
    }

    public final boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            c.a.t0.d1.z2.h hVar = this.g0;
            return hVar != null && hVar.y();
        }
        return invokeV.booleanValue;
    }

    public void u1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048683, this, i2) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }

    public void v0(c.a.s0.s.q.d dVar) {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048684, this, dVar) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.d(dVar);
    }

    public void v1(f.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048685, this, cVar) == null) || (frsMultiDelBottomMenuView = this.h0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }

    public void w0() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.l();
    }

    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.F = i2;
        }
    }

    public void x0() {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.m();
    }

    public void x1(c.a.d.n.e.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, wVar) == null) {
            this.u.e(wVar);
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048690, this) == null) && this.L == null) {
            View rootView = this.a.getRootView();
            this.L = (GifView) rootView.findViewById(f1.gif_real_time);
            TbImageView tbImageView = (TbImageView) rootView.findViewById(f1.tbimg_real_time);
            this.M = tbImageView;
            tbImageView.setPageId(this.a.getUniqueId());
            this.L.setLayerType(1, null);
            this.M.setLayerType(1, null);
        }
    }

    public void y1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public final void z0(c.a.t0.d1.y1.e.a aVar, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048692, this, aVar, z) == null) {
            this.V = aVar;
            View rootView = this.a.getRootView();
            if (this.f16664b == null) {
                this.f16664b = (NoPressedRelativeLayout) rootView.findViewById(f1.frs);
            }
            if (this.f16666d == null) {
                this.f16666d = rootView.findViewById(f1.frs_content_container);
            }
            if (this.f16665c == null) {
                this.f16665c = (CoordinatorLayout) rootView.findViewById(f1.frs_nested_scroll_layout);
            }
            if (this.C == null) {
                this.C = rootView.findViewById(f1.frs_list_content);
            }
            if (this.b0 == null) {
                this.b0 = (CollapsingToolbarLayout) rootView.findViewById(f1.frs_collapse_layout);
            }
            if (this.a0 == null) {
                this.a0 = (FrsHeaderViewContainer) rootView.findViewById(f1.header_view_container);
            }
            if (this.v == null) {
                this.v = new c.a.t0.d1.z2.k(this.a);
            }
            if (this.T == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) rootView.findViewById(f1.navigation_bar_wrapperLayout);
                this.T = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            if (this.A == null) {
                NavigationBar navigationBar = (NavigationBar) rootView.findViewById(f1.view_navigation_bar);
                this.A = navigationBar;
                navigationBar.getBarBgView().setAlpha(1.0f);
                this.A.setContentPaddingTop(c.a.d.f.p.n.f(getContext(), d1.tbds24));
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.isFromMainTab()) {
                this.A.setVisibility(8);
            }
            if (this.B == null) {
                this.B = rootView.findViewById(f1.frs_navi_line);
                c.a.t0.d1.y1.e.b c2 = aVar.c();
                if (c2 != null) {
                    c2.b(this.B);
                }
            }
            if (this.f16667e == null) {
                View addSystemImageButton = this.A.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.f16667e = addSystemImageButton;
                addSystemImageButton.setOnClickListener(this.x);
                this.f16668f = (ImageView) this.f16667e.findViewById(f1.widget_navi_back_button);
            }
            if (this.f16673k == null) {
                this.f16673k = (ImageView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_topbar_search_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16673k, e1.ic_icon_pure_topbar_search40_svg, c1.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f16673k.setOnClickListener(this.x);
            }
            if (this.f16671i == null) {
                c.a.t0.k0.f fVar = new c.a.t0.k0.f(this.a.getPageContext().getPageActivity());
                this.f16671i = fVar;
                this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, fVar.c(), (View.OnClickListener) null);
                this.f16669g = this.f16671i.b();
                MessageRedDotView a2 = this.f16671i.a();
                this.f16670h = a2;
                a2.setShadowEnabled(false);
                this.f16671i.c().setOnClickListener(this.x);
                this.f16671i.f(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, true);
            }
            if (this.f16672j == null) {
                this.f16672j = (ImageView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, g1.frs_topbar_share_layout, (View.OnClickListener) null);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16672j, e1.ic_icon_pure_topbar_share40_svg, c1.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f16672j.setOnClickListener(this.x);
            }
            if (this.l == null) {
                TextView textView = (TextView) this.A.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, g1.frs_private_status, (View.OnClickListener) null);
                this.l = textView;
                textView.setVisibility(8);
                Drawable drawable = SkinManager.getDrawable(e1.icon_arrow12_white);
                int f2 = c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds31);
                drawable.setBounds(0, 0, f2, f2);
                this.l.setCompoundDrawables(null, null, drawable, null);
                SkinManager.setBackgroundResourceSelector(this.l, e1.bg_frs_private_status_n, e1.bg_frs_private_status_s);
                SkinManager.setViewTextColor(this.l, c1.CAM_X0101);
            }
            if (z2) {
                this.A.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                SkinManager.setBackgroundColor(this.A.getBottomLine(), c1.CAM_X0204);
            }
            if (this.t == null) {
                this.t = (BdTypeRecyclerView) rootView.findViewById(f1.frs_lv_thread);
            }
            j jVar = new j(this);
            jVar.setSupportsChangeAnimations(false);
            this.t.setItemAnimator(jVar);
            BdTypeRecyclerView bdTypeRecyclerView = this.t;
            bdTypeRecyclerView.setLayoutManager(new k(this, bdTypeRecyclerView.getContext()));
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                c.a.d.n.e.l lVar = new c.a.d.n.e.l(new c.a.d.n.e.j());
                this.p0 = lVar;
                lVar.q(this.t, 2);
            }
            this.t.setScrollable(this.a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.f16664b.setBottomOrderView(this.t);
            this.t.setOnTouchListener(this.a.mOnTouchListener);
            this.t.setRecyclerListener(new l(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(d1.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.t;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.t.getPaddingBottom());
            if (this.s == null) {
                PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
                this.s = pbListView;
                pbListView.b();
            }
            this.s.p(c1.transparent);
            this.s.t(c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds182));
            this.s.y();
            this.s.H(d1.tbfontsize33);
            this.s.F(SkinManager.getColor(c1.CAM_X0109));
            this.s.B(c1.CAM_X0110);
            this.t.setOnSrollToBottomListener(this.a);
            this.A.setOnClickListener(new m(this));
            boolean isShowBigImage = TbImageHelper.getInstance().isShowBigImage();
            if (this.u == null) {
                this.u = aVar.b(this.a, this.t, isShowBigImage);
            }
            c.a.t0.d1.z2.k kVar = this.v;
            if (kVar != null) {
                kVar.r(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.T.addView(this.z);
                }
                if (c.a.d.f.p.l.A()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            y0();
            if (this.I == null) {
                c.a.t0.d1.z2.d a3 = aVar.a(this.a, this.f16664b);
                this.I = a3;
                a3.x(this.a.getWriteIcon());
            }
            if (this.J == null) {
                this.J = aVar.d(this.a, this.f16664b);
                h1(true);
            }
            if (this.R == null) {
                this.R = rootView.findViewById(f1.statebar_view);
            }
            if (this.S == null) {
                this.S = rootView.findViewById(f1.statebar_view_holder);
            }
            if (this.O == null) {
                this.O = new c.a.t0.z2.k(this.a.getPageContext(), this.t);
            }
            if (c.a.s0.b.d.o()) {
                this.O.p(2);
            } else {
                this.O.p(1);
            }
            this.O.u(this.a.getUniqueId());
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) rootView.findViewById(f1.navigation_cover_tip);
            this.j0 = navigationBarCoverTip;
            if (this.K == null) {
                this.K = new c.a.t0.d1.z2.m(this.a, navigationBarCoverTip);
            }
            if (this.Y == null) {
                AppBarLayout appBarLayout = (AppBarLayout) rootView.findViewById(f1.frs_app_bar_layout);
                this.Y = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.r0);
                this.c0 = true;
                this.d0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Y.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.Z = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) rootView.findViewById(f1.frs_multi_delete_menu_view);
            this.h0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) rootView.findViewById(f1.frs_move_area_menu_view);
            this.i0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.l0 == null) {
                this.l0 = this.A.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, "", null, false);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                int dimension = (int) this.a.getResources().getDimension(d1.ds20);
                layoutParams2.setMargins(0, dimension, dimension, dimension);
                this.l0.setLayoutParams(layoutParams2);
                this.l0.setPadding(0, 0, this.a.getResources().getDimensionPixelSize(d1.ds20), 0);
                this.l0.setTextColor(SkinManager.getColor(c1.CAM_X0105));
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) rootView.findViewById(f1.frs_nested_scroll_layout);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) rootView.findViewById(f1.frs_viewpager);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void z1(boolean z) {
        c.a.t0.d1.z2.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048693, this, z) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.s(z);
    }
}
