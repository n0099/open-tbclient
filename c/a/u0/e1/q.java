package c.a.u0.e1;

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
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.g.d;
import c.a.t0.s.r.d2;
import c.a.t0.s.r.o2;
import c.a.t0.s.t.c;
import c.a.u0.k.f;
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
import com.baidu.tieba.frs.shrinkhead.LogicField;
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
/* loaded from: classes8.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar A;
    @NonNull
    public final c.a.u0.e1.v2.c.c B;
    public View C;
    public View D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public CommonTipView I;
    public c.a.u0.e1.c3.d J;
    public c.a.u0.e1.z1.e.c K;
    public c.a.u0.e1.c3.m L;
    public GifView M;
    public TbImageView N;
    public HashSet<String> O;
    public c.a.u0.b3.k P;
    public int Q;
    public int R;
    public View S;
    public View T;
    public ObservedChangeLinearLayout U;
    public boolean V;
    public c.a.u0.e1.z1.e.a W;
    public boolean X;
    public c.a.u0.n4.e Y;
    public AppBarLayout Z;
    public FrsFragment a;
    public AppBarLayoutStickyBehavior a0;

    /* renamed from: b  reason: collision with root package name */
    public NoPressedRelativeLayout f16888b;
    public FrsHeaderViewContainer b0;

    /* renamed from: c  reason: collision with root package name */
    public CoordinatorLayout f16889c;
    public CollapsingToolbarLayout c0;

    /* renamed from: d  reason: collision with root package name */
    public View f16890d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public View f16891e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f16892f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f16893g;
    public int g0;

    /* renamed from: h  reason: collision with root package name */
    public MessageRedDotView f16894h;
    public c.a.u0.e1.c3.h h0;

    /* renamed from: i  reason: collision with root package name */
    public c.a.u0.k0.f f16895i;
    public FrsMultiDelBottomMenuView i0;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f16896j;
    public FrsMoveAreaBottomMenuView j0;
    public ImageView k;
    public NavigationBarCoverTip k0;
    public TextView l;
    public TextView l0;
    public ViewStub m;
    public TextView m0;
    public FrameLayout n;
    public int n0;
    public TbImageView o;
    public int o0;
    public TbImageView p;
    public boolean p0;
    public ExposeTagViewCoordinatorLayout q;
    public c.a.d.o.e.l q0;
    public FrsTabViewPager r;
    public CustomMessageListener r0;
    public PbListView s;
    public AppBarLayout.OnOffsetChangedListener s0;
    public BdTypeRecyclerView t;
    public Runnable t0;
    public c.a.u0.e1.z1.d.e0 u;
    public boolean u0;
    public c.a.u0.e1.c3.k v;
    public c.a.t0.s.t.c w;
    public View.OnClickListener x;
    public NoNetworkView.b y;
    public NoNetworkView z;

    /* loaded from: classes8.dex */
    public class a implements c.InterfaceC0904c {
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

        @Override // c.a.t0.s.t.c.InterfaceC0904c
        public void a(c.a.t0.s.t.c cVar, int i2, View view) {
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

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16897e;

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
            this.f16897e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16897e.m == null) {
                return;
            }
            this.f16897e.n.setVisibility(0);
            this.f16897e.p.setVisibility(0);
            this.f16897e.o.setVisibility(8);
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                c.a.t0.s.j0.b.k().x("frs_video_activity_guide", 1L);
            }
        }

        @Override // c.a.d.f.g.d.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.d.f.g.c f16898e;

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
            this.f16898e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.d.f.g.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f16898e) == null) {
                return;
            }
            cVar.e();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16899e;

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
            this.f16899e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16899e.W().notifyDataSetChanged();
                if (this.f16899e.p0) {
                    return;
                }
                this.f16899e.P.n(this.f16899e.Q, this.f16899e.R, this.f16899e.H, true);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    if (this.a.q0 == null) {
                        this.a.q0 = new c.a.d.o.e.l(new c.a.d.o.e.j());
                    }
                    this.a.q0.q(this.a.t, 2);
                } else if (this.a.q0 != null) {
                    this.a.q0.w();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.M(appBarLayout, i2);
                if (this.a.v != null && this.a.q.hasTargetView()) {
                    this.a.v.q(i2 == 0 && !this.a.q.canDrag());
                }
                if (this.a.f0 != i2 && Math.abs(i2) >= 0 && this.a.T() != -1) {
                    if (Math.abs(i2) >= this.a.T()) {
                        if (this.a.d0) {
                            this.a.d0 = false;
                            q qVar = this.a;
                            qVar.N0(qVar.d0);
                        }
                    } else if (!this.a.d0) {
                        this.a.d0 = true;
                        q qVar2 = this.a;
                        qVar2.N0(qVar2.d0);
                    }
                    int Z = this.a.Z() + this.a.h0() + this.a.j0();
                    int totalScrollRange = appBarLayout.getTotalScrollRange() - Math.abs(i2);
                    int totalScrollRange2 = (appBarLayout.getTotalScrollRange() - Z) + this.a.B.i();
                    int i3 = totalScrollRange + this.a.B.i();
                    if (totalScrollRange2 <= 0) {
                        return;
                    }
                    float abs = Math.abs(i2 * 1.0f) / totalScrollRange2;
                    if (Float.compare(abs, 1.0f) > 0) {
                        abs = 1.0f;
                    }
                    if (Float.compare(abs, 0.05f) <= 0 && this.a.f0 - i2 < 0) {
                        abs = 0.0f;
                    }
                    if (Float.compare(abs, 1.0f) == 0) {
                        this.a.V1(Math.abs(Z - i3));
                        if (this.a.T != null) {
                            this.a.T.setVisibility(0);
                        }
                    } else if (this.a.T != null) {
                        if (this.a.q0() != UtilHelper.getStatusBarHeight()) {
                            this.a.V1(0);
                        }
                        this.a.T.setVisibility(8);
                    }
                    if (this.a.A != null) {
                        if (this.a.V) {
                            this.a.A.getBarBgView().setAlpha(abs);
                            this.a.Y1(false);
                            this.a.B.c(abs);
                        } else if (this.a.m0 != null) {
                            this.a.m0.setAlpha(abs);
                        }
                    }
                    this.a.f0 = i2;
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921397, Integer.valueOf(i2));
                    CustomMessage customMessage = new CustomMessage(2921397);
                    if (this.a.a != null && this.a.a.getTabController() != null && this.a.a.getTabController().A() != null && (this.a.a.getTabController().A().f44014b instanceof BaseFragment)) {
                        customMessage.setTag(((BaseFragment) this.a.a.getTabController().A().f44014b).getUniqueId());
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

    /* loaded from: classes8.dex */
    public class i implements c.a.t0.f1.j.e {
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

        @Override // c.a.t0.f1.j.e
        public void a(View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || i3 == i5 || i5 <= 0) {
                return;
            }
            this.a.c0.setMinimumHeight(i3);
        }
    }

    /* loaded from: classes8.dex */
    public class j extends DefaultItemAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f16900b;

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
            this.f16900b = qVar;
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
                    this.f16900b.t.getAdapter().notifyDataSetChanged();
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                if (this.a.P != null) {
                    this.a.P.k(view);
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

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16901e;

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
            this.f16901e = qVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16901e.a.hideKeyBroad();
                if (this.f16901e.a == null || this.f16901e.Z == null) {
                    return;
                }
                this.f16901e.a.scrollCurrentTabToTop();
                this.f16901e.Z.setExpanded(true);
                if (this.f16901e.P != null) {
                    this.f16901e.P.n(this.f16901e.Q, this.f16901e.R, false, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.v.q(this.a.f0 == 0 && !this.a.q.canDrag());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f16902e;

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
            this.f16902e = qVar;
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
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f16902e.v != null && this.f16902e.q.hasTargetView()) {
                this.f16902e.v.q(false);
                this.f16902e.q.clearTargetView();
            }
        }
    }

    public q(FrsFragment frsFragment, View.OnClickListener onClickListener, c.a.u0.e1.z1.e.a aVar, boolean z, c.a.u0.e1.c3.h hVar) {
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
        this.f16888b = null;
        this.f16889c = null;
        this.f16890d = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.B = c.a.u0.e1.v2.c.b.a();
        this.E = true;
        this.F = true;
        this.G = 0;
        this.H = false;
        this.Q = 0;
        this.R = 0;
        this.S = null;
        this.T = null;
        this.V = false;
        this.X = true;
        this.d0 = true;
        this.e0 = -1;
        this.f0 = -1;
        this.n0 = 0;
        this.o0 = 0;
        this.p0 = false;
        this.r0 = new g(this, 2156674);
        this.s0 = new h(this);
        this.t0 = new b(this);
        this.a = frsFragment;
        this.x = onClickListener;
        MessageManager.getInstance().registerListener(this.r0);
        D0(aVar, z);
        this.O = new HashSet<>();
        this.G = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
        this.g0 = TbadkCoreApplication.getInst().getSkinType();
        this.h0 = hVar;
    }

    @NonNull
    public static String b0(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            String fixedBarText = UtilHelper.getFixedBarText(str, 7, true, false);
            if (fixedBarText.length() < 12) {
                return fixedBarText + "吧";
            }
            return UtilHelper.getFixedBarText(str, 6, true, false) + "吧";
        }
        return (String) invokeL.objValue;
    }

    public void A0() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.l();
    }

    public void A1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.G = i2;
        }
    }

    public void B0() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.m();
    }

    public void B1(c.a.d.o.e.v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vVar) == null) {
            this.u.e(vVar);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.M == null) {
            View rootView = this.a.getRootView();
            this.M = (GifView) rootView.findViewById(f1.gif_real_time);
            TbImageView tbImageView = (TbImageView) rootView.findViewById(f1.tbimg_real_time);
            this.N = tbImageView;
            tbImageView.setPageId(this.a.getUniqueId());
            this.M.setLayerType(1, null);
            this.N.setLayerType(1, null);
        }
    }

    public void C1(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.y = bVar;
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public final void D0(c.a.u0.e1.z1.e.a aVar, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, aVar, z) == null) {
            this.W = aVar;
            View rootView = this.a.getRootView();
            if (this.f16888b == null) {
                this.f16888b = (NoPressedRelativeLayout) rootView.findViewById(f1.frs);
            }
            if (this.f16890d == null) {
                this.f16890d = rootView.findViewById(f1.frs_content_container);
            }
            if (this.f16889c == null) {
                this.f16889c = (CoordinatorLayout) rootView.findViewById(f1.frs_nested_scroll_layout);
            }
            if (this.D == null) {
                this.D = rootView.findViewById(f1.frs_list_content);
            }
            if (this.c0 == null) {
                this.c0 = (CollapsingToolbarLayout) rootView.findViewById(f1.frs_collapse_layout);
            }
            if (this.b0 == null) {
                this.b0 = (FrsHeaderViewContainer) rootView.findViewById(f1.header_view_container);
            }
            if (this.v == null) {
                this.v = new c.a.u0.e1.c3.k(this.a);
            }
            if (this.U == null) {
                ObservedChangeLinearLayout observedChangeLinearLayout = (ObservedChangeLinearLayout) rootView.findViewById(f1.navigation_bar_wrapperLayout);
                this.U = observedChangeLinearLayout;
                observedChangeLinearLayout.setOnSizeChangeListener(new i(this));
            }
            this.B.j(this.a, rootView, this.x);
            if (this.A == null) {
                this.A = this.B.f();
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.a.isFromMainTab()) {
                this.A.setVisibility(8);
            }
            if (this.C == null) {
                this.C = rootView.findViewById(f1.frs_navi_line);
                c.a.u0.e1.z1.e.b c2 = aVar.c();
                if (c2 != null) {
                    c2.b(this.C);
                }
            }
            if (this.f16891e == null) {
                this.f16891e = (View) this.B.a(LogicField.BACK_BTN);
                this.f16892f = (ImageView) this.B.a(LogicField.BACK_IV);
            }
            if (this.k == null) {
                this.k = (ImageView) this.B.a(LogicField.SEARCH_BTN);
            }
            if (this.f16895i == null) {
                this.f16895i = (c.a.u0.k0.f) this.B.a(LogicField.MESSAGE_ICON_CONTROLLER);
                this.f16893g = (ImageView) this.B.a(LogicField.MESSAGE_BTN);
                this.f16894h = (MessageRedDotView) this.B.a(LogicField.MESSAGE_RED_DOT);
            }
            if (this.f16896j == null) {
                this.f16896j = (ImageView) this.B.a(LogicField.SHARE_BTN);
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
                c.a.d.o.e.l lVar = new c.a.d.o.e.l(new c.a.d.o.e.j());
                this.q0 = lVar;
                lVar.q(this.t, 2);
            }
            this.t.setScrollable(this.a);
            this.t.setFadingEdgeLength(0);
            this.t.setOverScrollMode(2);
            this.f16888b.setBottomOrderView(this.t);
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
            c.a.u0.e1.c3.k kVar = this.v;
            if (kVar != null) {
                kVar.r(1, false);
            }
            if (!z) {
                if (this.z == null) {
                    this.z = new NoNetworkView(this.a.getActivity());
                    this.z.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    this.U.addView(this.z);
                }
                if (c.a.d.f.p.l.A()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                }
                this.z.onChangeSkinType(this.a.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            }
            C0();
            if (this.J == null) {
                c.a.u0.e1.c3.d a2 = aVar.a(this.a, this.f16888b);
                this.J = a2;
                a2.x(this.a.getWriteIcon());
            }
            if (this.K == null) {
                this.K = aVar.d(this.a, this.f16888b);
                l1(true);
            }
            if (this.S == null) {
                this.S = rootView.findViewById(f1.statebar_view);
            }
            if (this.T == null) {
                this.T = rootView.findViewById(f1.statebar_view_holder);
            }
            if (this.P == null) {
                this.P = new c.a.u0.b3.k(this.a.getPageContext(), this.t);
            }
            if (c.a.t0.b.d.l()) {
                this.P.p(2);
            } else {
                this.P.p(1);
            }
            this.P.u(this.a.getUniqueId());
            NavigationBarCoverTip navigationBarCoverTip = (NavigationBarCoverTip) rootView.findViewById(f1.navigation_cover_tip);
            this.k0 = navigationBarCoverTip;
            if (this.L == null) {
                this.L = new c.a.u0.e1.c3.m(this.a, navigationBarCoverTip);
            }
            if (this.Z == null) {
                AppBarLayout appBarLayout = (AppBarLayout) rootView.findViewById(f1.frs_app_bar_layout);
                this.Z = appBarLayout;
                appBarLayout.addOnOffsetChangedListener(this.s0);
                this.d0 = true;
                this.e0 = -1;
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) this.Z.getLayoutParams();
                if (layoutParams.getBehavior() instanceof AppBarLayoutStickyBehavior) {
                    this.a0 = (AppBarLayoutStickyBehavior) layoutParams.getBehavior();
                }
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = (FrsMultiDelBottomMenuView) rootView.findViewById(f1.frs_multi_delete_menu_view);
            this.i0 = frsMultiDelBottomMenuView;
            frsMultiDelBottomMenuView.setPageContext(this.a.getPageContext());
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = (FrsMoveAreaBottomMenuView) rootView.findViewById(f1.frs_move_area_menu_view);
            this.j0 = frsMoveAreaBottomMenuView;
            frsMoveAreaBottomMenuView.setPageContext(this.a.getPageContext());
            if (this.m0 == null) {
                this.m0 = (TextView) this.B.a(LogicField.FOLD_TITLE);
            }
            ExposeTagViewCoordinatorLayout exposeTagViewCoordinatorLayout = (ExposeTagViewCoordinatorLayout) rootView.findViewById(f1.frs_nested_scroll_layout);
            this.q = exposeTagViewCoordinatorLayout;
            exposeTagViewCoordinatorLayout.setListener(new n(this));
            FrsTabViewPager frsTabViewPager = (FrsTabViewPager) rootView.findViewById(f1.frs_viewpager);
            this.r = frsTabViewPager;
            frsTabViewPager.addOnPageChangeListener(new o(this));
        }
    }

    public void D1(boolean z) {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.s(z);
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m != null && this.p.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void E1(ArrayList<c.a.d.o.e.n> arrayList, FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, arrayList, frsViewData) == null) || frsViewData == null) {
            return;
        }
        ArrayList<c.a.d.o.e.n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
        if (ListUtils.isEmpty(switchThreadDataToThreadCardInfo) || !frsViewData.mHasThreadExceptTop) {
            s sVar = new s();
            ArrayList<c.a.d.o.e.n> arrayList2 = new ArrayList<>();
            arrayList2.add(sVar);
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.getModelController() != null && this.a.getModelController().V() == 0) {
                sVar.d(this.a.getModelController().R());
            }
            switchThreadDataToThreadCardInfo = arrayList2;
        }
        if (ListUtils.getCount(switchThreadDataToThreadCardInfo) > 0) {
            for (int i3 = 0; i3 < switchThreadDataToThreadCardInfo.size(); i3++) {
                c.a.d.o.e.n nVar = switchThreadDataToThreadCardInfo.get(i3);
                if (nVar instanceof d2) {
                    ((d2) nVar).w.z4(i3);
                }
            }
        }
        this.u.h(switchThreadDataToThreadCardInfo, frsViewData);
        c.a.u0.b3.k kVar = this.P;
        if (kVar != null && (i2 = this.Q) != 0) {
            kVar.n(i2, this.R, this.H, true);
        }
        FrsFragment frsFragment2 = this.a;
        if (frsFragment2 != null) {
            frsFragment2.setLiveCardStatData();
        }
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
        if (frsMultiDelBottomMenuView != null) {
            frsMultiDelBottomMenuView.setFrsViewData(frsViewData);
        }
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s.b().getParent() != null && this.F : invokeV.booleanValue;
    }

    public void F1(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && (textView = this.m0) != null && TextUtils.isEmpty(textView.getText())) {
            if (TextUtils.isEmpty(str)) {
                this.m0.setText("");
                return;
            }
            this.m0.setText(b0(str));
            c.a.t0.s.l.c().h(str);
        }
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            return frsMoveAreaBottomMenuView != null && frsMoveAreaBottomMenuView.isChooseViewShow();
        }
        return invokeV.booleanValue;
    }

    public void G1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || this.U == null) {
            return;
        }
        o1();
        if (this.V) {
            this.A.getBarBgView().setAlpha(0.0f);
            this.A.hideBottomLine();
        } else {
            View view = this.S;
            if (view != null) {
                view.setAlpha(1.0f);
            }
            View view2 = this.T;
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            TextView textView = this.m0;
            if (textView != null) {
                textView.setAlpha(0.0f);
            }
            this.A.getBarBgView().setAlpha(1.0f);
            this.A.showBottomLine();
        }
        O0(this.g0);
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.u0.e1.c3.k kVar = this.v;
            if (kVar != null) {
                return kVar.h() instanceof FrsNewAreaFragment;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void H1() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.t();
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            c.a.u0.e1.c3.d dVar = this.J;
            if (dVar == null) {
                return false;
            }
            return dVar.p();
        }
        return invokeV.booleanValue;
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.F = true;
            this.t.setNextPage(this.s);
            this.s.C(this.x);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.f();
            this.s.D(this.a.getResources().getString(i1.list_click_load_more));
        }
    }

    public void J(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onScrollListener) == null) {
            this.t.addOnScrollListener(onScrollListener);
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c.a.u0.e1.z1.d.e0 e0Var = this.u;
            if (e0Var instanceof c.a.u0.e1.z1.d.q) {
                ((c.a.u0.e1.z1.d.q) e0Var).s();
            }
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.m == null) {
            return;
        }
        this.n.setVisibility(0);
        this.p.setVisibility(8);
        this.o.setVisibility(0);
        TbadkCoreApplication.getInst().handler.postDelayed(this.t0, 5000L);
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || this.a == null) {
            return;
        }
        L(i2);
    }

    public void K0() {
        c.a.u0.e1.z1.d.e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (e0Var = this.u) == null) {
            return;
        }
        e0Var.notifyDataSetChanged();
    }

    public void K1(o2 o2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, o2Var) == null) {
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
            TbadkCoreApplication.getInst().handler.postDelayed(this.t0, 5000L);
        }
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), i2);
                if (this.A.getBackground() != null && this.A.getBackground().mutate() != null) {
                    this.A.getBackground().mutate().setAlpha(0);
                }
                SkinManager.setBackgroundColor(this.A.getBarBgView(), c1.CAM_X0207);
                SkinManager.setBackgroundColor(this.A.getBottomLine(), c1.CAM_X0204);
                SkinManager.setBackgroundColor(this.C, c1.CAM_X0204, i2);
                c.a.u0.k0.f fVar = this.f16895i;
                if (fVar != null) {
                    fVar.d(i2);
                }
                if (this.k != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                if (this.f16896j != null) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16896j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
            }
            SkinManager.setBackgroundColor(this.S, c1.CAM_X0207);
            SkinManager.setBackgroundColor(this.T, c1.CAM_X0207);
            Y1(true);
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.p0 = z;
            if (this.P == null) {
                return;
            }
            FrsFragment frsFragment = this.a;
            boolean z2 = (frsFragment == null || frsFragment.getTabController() == null || this.a.getTabController().A() == null) ? true : this.a.getTabController().A().f44014b instanceof FrsAllThreadFragment;
            if (!z && z2) {
                this.P.r(true);
                this.P.n(this.Q, this.R, this.H, true);
                return;
            }
            this.P.r(false);
            this.P.y();
        }
    }

    public void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.t.setVisibility(0);
        }
    }

    public final void M(AppBarLayout appBarLayout, int i2) {
        FrsFragment frsFragment;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048603, this, appBarLayout, i2) == null) || (frsFragment = this.a) == null || appBarLayout == null || frsFragment.getTabController() == null || this.a.getPageContext() == null) {
            return;
        }
        int Z = Z() + h0() + j0();
        int totalScrollRange = (appBarLayout.getTotalScrollRange() - Math.abs(i2)) + this.B.i();
        FrsTabViewController tabController = this.a.getTabController();
        ViewGroup.LayoutParams layoutParams = this.f16890d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        }
        FrsFragment frsFragment2 = this.a;
        boolean z = frsFragment2 != null && frsFragment2.needAdjustHeaderBottom();
        if (totalScrollRange <= 0) {
            if (this.o0 != 2) {
                tabController.f(2);
            }
            this.o0 = 2;
            marginLayoutParams.topMargin = 0;
        } else if (totalScrollRange > 0 && totalScrollRange < Z) {
            if (this.o0 != 1) {
                tabController.f(1);
            }
            this.o0 = 1;
            marginLayoutParams.topMargin = 0;
        } else {
            if (this.o0 != 0) {
                tabController.f(0);
            }
            this.o0 = 0;
            if (z) {
                marginLayoutParams.topMargin = c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds_30);
            } else {
                marginLayoutParams.topMargin = 0;
            }
        }
        if (z) {
            this.f16890d.setLayoutParams(marginLayoutParams);
        }
    }

    public void M0(int i2, int i3) {
        c.a.u0.b3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048604, this, i2, i3) == null) || (kVar = this.P) == null) {
            return;
        }
        kVar.m(i2, i3, this.H, 1);
        if (c.a.t0.b.d.l()) {
            this.P.p(2);
        } else {
            this.P.p(1);
        }
        this.P.q(false);
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.F = true;
            this.t.setNextPage(this.s);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.C(null);
            this.s.R();
        }
    }

    public void N(String str) {
        c.a.u0.e1.c3.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || (mVar = this.L) == null) {
            return;
        }
        mVar.a(str);
    }

    public final void N0(boolean z) {
        FrsFragment frsFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || !z || (frsFragment = this.a) == null || frsFragment.getHeaderVC() == null) {
            return;
        }
        this.a.getHeaderVC().P();
    }

    public final void N1(int i2) {
        c.a.u0.k0.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || (fVar = this.f16895i) == null) {
            return;
        }
        fVar.g(i2);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.v.f();
        }
    }

    public void O0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.g0 = i2;
            this.B.onChangeSkinType(i2);
            c.a.u0.h.f.b bVar = new c.a.u0.h.f.b(this.a, 4);
            bVar.D(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar));
            c.a.u0.h.f.a aVar = new c.a.u0.h.f.a(this.a.getPageContext(), 4);
            aVar.l(i2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
            TbImageView tbImageView = this.N;
            if (tbImageView != null) {
                tbImageView.invalidate();
            }
            c.a.u0.e1.z1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.c();
                this.u.notifyDataSetChanged();
            }
            c.a.t0.x0.a.a(this.a.getPageContext(), this.f16888b);
            NoNetworkView noNetworkView = this.z;
            if (noNetworkView != null) {
                noNetworkView.onChangeSkinType(this.a.getPageContext(), i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(c1.CAM_X0109));
                this.s.d(i2);
            }
            TextView textView = this.m0;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColor(c1.CAM_X0105));
            }
            K(i2);
            c.a.u0.e1.z1.e.c cVar = this.K;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
            }
            c.a.u0.e1.c3.d dVar = this.J;
            if (dVar != null) {
                dVar.u(i2);
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.onChangeSkinType();
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.onChangeSkinType();
            }
            SkinManager.setBackgroundColor(this.f16890d, c1.CAM_X0202);
        }
    }

    public void O1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, str, i2) == null) {
            if (this.l0 == null) {
                TextView textView = new TextView(this.a.getActivity());
                this.l0 = textView;
                textView.setGravity(19);
                this.l0.setPadding(c.a.d.f.p.n.f(this.a.getActivity(), d1.ds34), 0, c.a.d.f.p.n.f(this.a.getActivity(), d1.ds34), 0);
                this.l0.setLayoutParams(new ViewGroup.LayoutParams(-1, c.a.d.f.p.n.f(this.a.getActivity(), d1.tbds112)));
                this.l0.setTextSize(0, c.a.d.f.p.n.f(this.a.getActivity(), d1.fontsize30));
                this.l0.setMaxLines(2);
                this.l0.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                this.l0.setTextColor(ContextCompat.getColor(this.a.getActivity(), c1.CAM_X0101));
            }
            this.k0.setBackgroundColor(i2);
            this.l0.setText(str);
            this.k0.showTip(this.a.getActivity(), this.l0, 5000);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.f16896j;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r0);
            c.a.u0.b3.k kVar = this.P;
            if (kVar != null) {
                kVar.h();
            }
            c.a.u0.e1.c3.m mVar = this.L;
            if (mVar != null) {
                mVar.c();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView = this.i0;
            if (frsMultiDelBottomMenuView != null) {
                frsMultiDelBottomMenuView.setPageContext(null);
            }
            FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView = this.j0;
            if (frsMoveAreaBottomMenuView != null) {
                frsMoveAreaBottomMenuView.setPageContext(null);
            }
            this.u.n();
            this.t.setOnSrollToBottomListener(null);
            this.t.setScrollable(null);
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.t0);
            CommonTipView commonTipView = this.I;
            if (commonTipView != null) {
                commonTipView.onDestroy();
            }
            this.O.clear();
            c.a.u0.e1.c3.d dVar = this.J;
            if (dVar != null) {
                dVar.r();
            }
            c.a.u0.n4.e eVar = this.Y;
            if (eVar != null) {
                eVar.e();
            }
            NavigationBarCoverTip navigationBarCoverTip = this.k0;
            if (navigationBarCoverTip != null) {
                navigationBarCoverTip.onDestroy();
            }
            FrsMultiDelBottomMenuView frsMultiDelBottomMenuView2 = this.i0;
            if (frsMultiDelBottomMenuView2 != null) {
                frsMultiDelBottomMenuView2.onDestroy();
            }
            c.a.u0.e1.c3.k kVar2 = this.v;
            if (kVar2 != null) {
                kVar2.n();
            }
        }
    }

    public void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.F = false;
            this.t.setNextPage(this.s);
            int i2 = this.G;
            if (i2 > 0) {
                this.s.M(i2);
            }
            this.s.C(null);
            this.s.f();
            this.s.D(this.a.getResources().getString(i1.list_has_no_more));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.w == null && this.a.getPageContext() != null) {
            String[] strArr = {this.a.getPageContext().getPageActivity().getString(i1.take_photo), this.a.getPageContext().getPageActivity().getString(i1.album)};
            c.a.t0.s.t.c cVar = new c.a.t0.s.t.c(this.a.getPageContext().getPageActivity());
            this.w = cVar;
            cVar.l(this.a.getPageContext().getPageActivity().getString(i1.operation));
            this.w.j(strArr, new a(this));
            this.w.c(this.a.getPageContext());
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        AppBarLayoutStickyBehavior appBarLayoutStickyBehavior;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.Z != null && (appBarLayoutStickyBehavior = this.a0) != null && appBarLayoutStickyBehavior.isSticky()) {
                BdTypeRecyclerView bdTypeRecyclerView = this.t;
                if (bdTypeRecyclerView != null) {
                    bdTypeRecyclerView.setSelection(0);
                }
                this.a0.expandedAppBarLayout(this.Z);
                return true;
            }
            c.a.u0.e1.c3.d dVar = this.J;
            return dVar != null && dVar.v();
        }
        return invokeV.booleanValue;
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            Q();
            c.a.t0.s.t.c cVar = this.w;
            if (cVar != null) {
                cVar.m();
            }
        }
    }

    public void R() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.dismissLoadingView();
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            c.a.u0.e1.c3.d dVar = this.J;
            if (dVar != null) {
                dVar.s();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void R1(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, postWriteCallBackData) == null) && postWriteCallBackData != null && postWriteCallBackData.mFrom == 2) {
            if (postWriteCallBackData.getIconStampData() != null) {
                c.a.t0.t.h.b.c(this.a.getTbPageContext(), postWriteCallBackData, 1);
                return;
            }
            if (this.Y == null) {
                this.Y = new c.a.u0.n4.e(this.a.getActivity(), this.f16888b);
            }
            this.Y.g(postWriteCallBackData);
        }
    }

    public void S() {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.dismissPopupWindow();
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
        }
    }

    public void S1() {
        int headerViewsCount;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || c.a.t0.s.j0.b.k().m("frs_video_activity_guide", 0L) != 0 || this.u0 || this.a.getActivity() == null || this.a.getPageContext() == null) {
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
            this.u0 = true;
        }
    }

    public final int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            AppBarLayout appBarLayout = this.Z;
            if (appBarLayout == null) {
                return this.e0;
            }
            int i2 = this.e0;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = appBarLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.Z.getChildAt(childCount);
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
            int max = Math.max(0, this.Z.getTotalScrollRange() - Math.abs(i3));
            this.e0 = max;
            return max;
        }
        return invokeV.intValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            K(TbadkCoreApplication.getInst().getSkinType());
            c.a.u0.e1.c3.d dVar = this.J;
            if (dVar != null) {
                dVar.t();
            }
        }
    }

    public void T1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || this.J == null) {
            return;
        }
        if (c.a.t0.y.d.h().k()) {
            this.J.A(false);
        } else {
            this.J.A(z);
        }
    }

    public View U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.f16891e : (View) invokeV.objValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || W() == null) {
            return;
        }
        List<c.a.d.o.e.n> g2 = W().g();
        if (ListUtils.isEmpty(g2)) {
            return;
        }
        for (c.a.d.o.e.n nVar : g2) {
            if (nVar instanceof d2) {
                d2 d2Var = (d2) nVar;
                if (d2Var.x != 0 && d2Var.w != null && this.a.getModelController() != null && this.a.getModelController().d0() != null) {
                    int[] i0 = d2Var.w.i0();
                    d2Var.x = i0[0];
                    d2Var.y = i0[1];
                }
            }
        }
        c.a.d.f.m.e.a().postDelayed(new f(this), 500L);
    }

    public void U1() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.u();
    }

    public View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.D : (View) invokeV.objValue;
    }

    public void V0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048631, this, i2) == null) && TbadkCoreApplication.getCurrentAccount() == null) {
            if ((i2 == 3 || i2 == 6) && c.a.t0.s.j0.b.k().h("frs_login_tip", true)) {
                if (this.I == null) {
                    this.I = new CommonTipView(this.a.getActivity());
                }
                this.I.setText(i1.frs_login_tip);
                this.I.show((FrameLayout) V(), TbadkCoreApplication.getInst().getSkinType());
                c.a.t0.s.j0.b.k().u("frs_login_tip", false);
            }
        }
    }

    public final void V1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            View p0 = p0();
            View r0 = r0();
            if (!UtilHelper.canUseStyleImmersiveSticky() || p0 == null || r0 == null || p0.getLayoutParams() == null || r0.getLayoutParams() == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = p0.getLayoutParams();
            int statusBarHeight = UtilHelper.getStatusBarHeight() - i2;
            layoutParams.height = statusBarHeight;
            if (statusBarHeight < 0) {
                layoutParams.height = 0;
            }
            p0.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = r0.getLayoutParams();
            layoutParams2.height = i2;
            if (i2 > UtilHelper.getStatusBarHeight()) {
                layoutParams2.height = UtilHelper.getStatusBarHeight();
            }
            r0.setLayoutParams(layoutParams2);
        }
    }

    public c.a.u0.e1.z1.d.e0 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.u : (c.a.u0.e1.z1.d.e0) invokeV.objValue;
    }

    public void W0() {
        c.a.u0.e1.z1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.X && (cVar = this.K) != null) {
                cVar.b(false, false);
            }
            N1(8);
            ImageView imageView = this.k;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.f16896j;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            T1(false);
            this.t.setVisibility(8);
            this.b0.setVisibility(8);
        }
    }

    public void W1() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.v();
    }

    public c.a.u0.e1.c3.k X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.v : (c.a.u0.e1.c3.k) invokeV.objValue;
    }

    public void X0() {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.u();
    }

    public final void X1() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (navigationBar = this.A) == null) {
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
        TextView textView = this.m0;
        if (textView != null) {
            textView.setAlpha(alpha);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            ImageView imageView = this.f16892f;
            if (imageView != null) {
                imageView.setAlpha(f2);
            }
            ImageView imageView2 = this.f16893g;
            if (imageView2 != null) {
                imageView2.setAlpha(f2);
            }
            FrsFragment frsFragment = this.a;
            if (frsFragment != null && frsFragment.getTabController() != null && this.n0 == 1) {
                this.a.getTabController().e0(f2);
            }
            MessageRedDotView messageRedDotView = this.f16894h;
            if (messageRedDotView != null) {
                messageRedDotView.setAlpha(f2);
            }
            ImageView imageView3 = this.k;
            if (imageView3 != null) {
                imageView3.setAlpha(f2);
            }
            ImageView imageView4 = this.f16896j;
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
        View view = this.S;
        if (view != null) {
            view.setAlpha(alpha);
        }
        View view2 = this.T;
        if (view2 != null) {
            view2.setAlpha(alpha);
        }
        View view3 = this.C;
        if (view3 != null) {
            view3.setAlpha(alpha);
        }
    }

    public c.a.u0.e1.c3.d Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.J : (c.a.u0.e1.c3.d) invokeV.objValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            D0(this.W, this.a.isFromMainTab());
            c.a.u0.e1.z1.d.e0 e0Var = this.u;
            if (e0Var != null) {
                e0Var.f();
            }
        }
    }

    public final void Y1(boolean z) {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048641, this, z) == null) || (navigationBar = this.A) == null || navigationBar.getBarBgView() == null || !this.V) {
            return;
        }
        if (this.A.getBarBgView().getAlpha() < 0.5f) {
            if (z || this.n0 != 0) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16892f, e1.ic_icon_pure_topbar_return40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ImageView imageView = this.f16893g;
                if (imageView != null) {
                    imageView.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0101), null));
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16896j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.n0 = 0;
            }
        } else if (z || this.n0 != 1) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16892f, e1.ic_icon_pure_topbar_return40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.k, e1.ic_icon_pure_topbar_search40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            ImageView imageView2 = this.f16893g;
            if (imageView2 != null) {
                imageView2.setImageDrawable(WebPManager.getPureDrawable(e1.icon_pure_topbar_information40, SkinManager.getColor(c1.CAM_X0106), null));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f16896j, e1.ic_icon_pure_topbar_share40_svg, c1.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.n0 = 1;
        }
        X1();
    }

    public final int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                return UtilHelper.getStatusBarHeight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void Z0(c.a.t0.s.r.g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, g0Var) == null) {
            c.a.u0.h.f.a aVar = new c.a.u0.h.f.a(this.a.getPageContext(), 1);
            aVar.j(this.t);
            HashMap hashMap = new HashMap();
            hashMap.put("forum_name", this.a.getForumName());
            hashMap.put("forum_id", this.a.getForumId());
            aVar.k(hashMap);
            aVar.i(g0Var);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016516, aVar));
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            c.a.u0.e1.c3.k kVar = this.v;
            if (kVar == null) {
                return false;
            }
            return kVar.j();
        }
        return invokeV.booleanValue;
    }

    public void a1(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            c.a.u0.k0.f fVar = this.f16895i;
            if (fVar != null) {
                fVar.e(z, i2);
            }
            this.B.d(i2, z);
        }
    }

    public void b1() {
        NoNetworkView noNetworkView;
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (noNetworkView = this.z) == null || (bVar = this.y) == null) {
            return;
        }
        noNetworkView.removeNetworkChangeListener(bVar);
    }

    public BdTypeRecyclerView c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.t : (BdTypeRecyclerView) invokeV.objValue;
    }

    public void c1() {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.removeChooseView();
    }

    public View d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            PbListView pbListView = this.s;
            if (pbListView == null) {
                return null;
            }
            return pbListView.b();
        }
        return (View) invokeV.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (this.E) {
                return false;
            }
            this.s.D(this.a.getResources().getString(i1.load_more_must_after_delete));
            this.s.f();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            c.a.u0.k0.f fVar = this.f16895i;
            if (fVar != null) {
                return fVar.c();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void e1() {
        c.a.u0.e1.z1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (this.X && (cVar = this.K) != null) {
                cVar.b(true, false);
            }
            N1(0);
            P();
            T1(this.a.canShowWriteButton());
            this.t.setVisibility(0);
            this.b0.setVisibility(0);
        }
    }

    @NonNull
    public c.a.u0.e1.v2.c.c f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.B : (c.a.u0.e1.v2.c.c) invokeV.objValue;
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.u.notifyDataSetChanged();
        }
    }

    public NavigationBar g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.A : (NavigationBar) invokeV.objValue;
    }

    public void g1(int i2) {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048656, this, i2) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.o(i2);
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            FrsFragment frsFragment = this.a;
            if (frsFragment == null) {
                return null;
            }
            return frsFragment.getTbPageContext().getPageActivity();
        }
        return (Context) invokeV.objValue;
    }

    public final int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            NavigationBar navigationBar = this.A;
            if (navigationBar == null) {
                return 0;
            }
            return navigationBar.getHeight();
        }
        return invokeV.intValue;
    }

    public void h1(boolean z) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048659, this, z) == null) || (appBarLayout = this.Z) == null) {
            return;
        }
        appBarLayout.setExpanded(z);
    }

    public ObservedChangeLinearLayout i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.U : (ObservedChangeLinearLayout) invokeV.objValue;
    }

    public void i1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048661, this, i2, i3) == null) {
            this.Q = i2;
            this.R = i3;
        }
    }

    public final int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            if (this.z == null || c.a.d.f.p.l.z()) {
                return 0;
            }
            return this.z.getHeight();
        }
        return invokeV.intValue;
    }

    public void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.u.a(str);
        }
    }

    public c.a.u0.b3.k k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.P : (c.a.u0.b3.k) invokeV.objValue;
    }

    public void k1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048665, this, i2) == null) || (view = this.f16890d) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public TextView l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public void l1(boolean z) {
        c.a.u0.e1.z1.e.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048667, this, z) == null) || (cVar = this.K) == null) {
            return;
        }
        cVar.a(z);
    }

    public c.a.u0.e1.z1.e.c m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.K : (c.a.u0.e1.z1.e.c) invokeV.objValue;
    }

    public void m1(boolean z, boolean z2) {
        c.a.u0.e1.z1.e.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && this.X && (cVar = this.K) != null) {
            cVar.b(z, z2);
        }
    }

    public RelativeLayout n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.f16888b : (RelativeLayout) invokeV.objValue;
    }

    public void n1(s0 s0Var) {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, s0Var) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.p(s0Var);
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? Z() + j0() : invokeV.intValue;
    }

    public final void o1() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.V = y0();
            FrsHeaderViewContainer frsHeaderViewContainer = this.b0;
            if (frsHeaderViewContainer == null || (layoutParams = frsHeaderViewContainer.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            if (this.V) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), d1.ds88) + Z(), 0, 0);
            }
            this.b0.requestLayout();
        }
    }

    public View p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.S : (View) invokeV.objValue;
    }

    public void p1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048675, this, z) == null) {
            this.u.b(z);
        }
    }

    public final int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            View view = this.S;
            if (view == null) {
                return 0;
            }
            return view.getHeight();
        }
        return invokeV.intValue;
    }

    public void q1(boolean z) {
        c.a.u0.e1.z1.e.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z) == null) {
            this.X = z;
            if (z || (cVar = this.K) == null) {
                return;
            }
            cVar.b(false, false);
        }
    }

    public View r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.T : (View) invokeV.objValue;
    }

    public void r1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z) == null) {
            this.H = z;
        }
    }

    public ImageView s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.k : (ImageView) invokeV.objValue;
    }

    public void s1(int i2, boolean z) {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.r(i2, z);
    }

    public ImageView t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.f16896j : (ImageView) invokeV.objValue;
    }

    public void t1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z) == null) {
            this.E = z;
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

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void u1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048685, this, i2) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setVisibility(i2);
    }

    public void v0() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || this.m == null || (frameLayout = this.n) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void v1(int i2) {
        FrsMoveAreaBottomMenuView frsMoveAreaBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048687, this, i2) == null) || (frsMoveAreaBottomMenuView = this.j0) == null) {
            return;
        }
        frsMoveAreaBottomMenuView.setMoveNumber(i2);
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            this.F = false;
            this.t.setNextPage(null);
        }
    }

    public void w1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048689, this, i2) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setSelectNumber(i2);
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048690, this, z) == null) || this.K == null) {
            return;
        }
        if (z) {
            m1(false, true);
        } else {
            m1(false, false);
        }
    }

    public void x1(boolean z) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048691, this, z) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setIsBlockMode(z);
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            c.a.u0.e1.c3.h hVar = this.h0;
            return hVar != null && hVar.z();
        }
        return invokeV.booleanValue;
    }

    public void y1(int i2) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048693, this, i2) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setVisibility(i2);
    }

    public void z0(c.a.t0.s.r.d dVar) {
        c.a.u0.e1.c3.k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, dVar) == null) || (kVar = this.v) == null) {
            return;
        }
        kVar.d(dVar);
    }

    public void z1(f.c cVar) {
        FrsMultiDelBottomMenuView frsMultiDelBottomMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048695, this, cVar) == null) || (frsMultiDelBottomMenuView = this.i0) == null) {
            return;
        }
        frsMultiDelBottomMenuView.setDeleteCallback(cVar);
    }
}
