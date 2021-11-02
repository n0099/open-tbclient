package b.a.r0.k2.u.f.g1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.k2.h;
import b.a.r0.k2.i;
import b.a.r0.k2.j;
import b.a.r0.k2.m;
import b.a.r0.k2.u.f.d0;
import b.a.r0.k2.u.f.e0;
import b.a.r0.l3.s0.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public b.a.r0.k2.r.f B;
    public String C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public Runnable F;
    public View.OnClickListener G;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f19282a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19283b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19284c;

    /* renamed from: d  reason: collision with root package name */
    public View f19285d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19286e;

    /* renamed from: f  reason: collision with root package name */
    public final View f19287f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f19288g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f19289h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f19290i;
    public BarImageView j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public d0 n;
    public float o;
    public PbFragment p;
    public Runnable q;
    public ImageView r;
    public boolean s;
    public PopupWindow t;
    public int u;
    public int v;
    public int w;
    public int x;
    public View y;
    public TBSpecificationBtn z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19291e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19291e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19291e.p.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19292a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f19292a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f20875b) {
                this.f19292a.A = true;
                c cVar = this.f19292a;
                cVar.J(cVar.A);
            }
        }
    }

    /* renamed from: b.a.r0.k2.u.f.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0968c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19293a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0968c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f19293a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f19293a.y != null) {
                    if (!booleanValue || this.f19293a.A) {
                        this.f19293a.y.setVisibility(4);
                    } else {
                        this.f19293a.y.setVisibility(0);
                        TbPageTag l = b.a.q0.n0.c.l(this.f19293a.p.getContext());
                        if (this.f19293a.B != null && l != null) {
                            b.a.r0.k2.u.f.f1.c.a("c14277", this.f19293a.C, this.f19293a.B.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.f19293a;
                    cVar.J(cVar.A);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19294e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19294e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19294e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!b.a.e.e.m.g.a(this.f19294e.m, this.f19294e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19295e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19295e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19295e.j();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19296e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19296e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19296e.q();
            }
        }
    }

    public c(PbFragment pbFragment, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19283b = false;
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.A = false;
        this.D = new b(this, 2001437);
        this.E = new C0968c(this, 2921599);
        this.F = new f(this);
        this.G = new g(this);
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), b.a.r0.k2.g.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds14);
        l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds_6);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(i.view_navigation_bar);
        this.f19282a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f19282a.hideBottomLine();
        this.f19287f = this.f19282a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.mCommonOnClickListener);
        this.f19284c = this.f19282a.setCenterTextTitle("");
        this.f19288g = (ImageView) this.f19282a.getCenterImgBox();
        this.f19289h = (LinearLayout) this.f19282a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.ds20);
        this.f19289h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f19288g;
        int i4 = h.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f19288g.setVisibility(8);
        this.f19284c.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.f19288g.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.r = (ImageView) this.f19287f.findViewById(i.widget_navi_back_button);
        if (this.f19290i == null) {
            s();
        }
        pbFragment.registerListener(this.D);
        pbFragment.registerListener(this.E);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.s = z;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.f19287f.setVisibility(0);
            } else {
                this.f19287f.setVisibility(8);
            }
            z(z);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !b.a.q0.s.e0.b.j().g("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(i.arrow_up);
                TextView textView = (TextView) inflate.findViewById(i.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.p.getContext(), b.a.r0.k2.g.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.p.getContext(), b.a.r0.k2.g.ds128);
                }
                textView.setText(b.a.r0.k2.l.share_tip);
                textView.setOnClickListener(this.G);
                this.t = new PopupWindow(inflate, -2, -2);
            }
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.r.setVisibility(0);
            z(z);
            if (TbadkCoreApplication.isLogin()) {
                View view = this.f19285d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f19285d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void E(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, e0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new d0(pbFragment, pbFragment.mCommonOnClickListener);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), m.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        b.a.e.e.m.g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(m.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.r());
        window.setDimAmount(this.o);
        this.n.O(e0Var == null ? false : e0Var.f19226a);
        this.n.v(e0Var == null ? false : e0Var.n);
        this.n.x(e0Var == null ? false : e0Var.f19230e);
        this.n.D(e0Var == null ? false : e0Var.f19234i);
        this.n.y(e0Var == null ? false : e0Var.f19231f);
        this.n.Q(e0Var != null ? e0Var.f19228c : true);
        this.n.M(e0Var == null ? false : e0Var.k);
        this.n.z(e0Var == null ? false : e0Var.l, e0Var.t);
        if (e0Var == null) {
            this.n.J(false, false);
            this.n.I(false, false);
        } else {
            this.n.J(e0Var.f19232g, e0Var.s);
            this.n.I(e0Var.f19233h, e0Var.r);
        }
        boolean z = e0Var == null ? false : e0Var.q;
        boolean z2 = e0Var == null ? false : e0Var.o;
        boolean z3 = e0Var == null ? false : e0Var.f19229d;
        boolean z4 = e0Var == null ? false : e0Var.f19227b;
        boolean z5 = e0Var == null ? false : e0Var.p;
        boolean z6 = e0Var == null ? false : e0Var.j;
        boolean z7 = e0Var == null ? false : e0Var.m;
        this.n.A(z3, z2);
        this.n.P(z4, z);
        this.n.K(z6, z5);
        this.n.S(z7);
        if (e0Var != null) {
            d0 d0Var = this.n;
            boolean z8 = e0Var.u;
            d0Var.w = z8;
            if (z8) {
                d0Var.f().setText(b.a.r0.k2.l.report_text);
                this.n.y(false);
            }
        }
        this.n.w(e0Var == null ? false : e0Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.getPbModel() != null && this.p.getPbModel().P0() != null && this.p.getPbModel().P0().Q() != null && this.p.getPbModel().P0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(b.a.r0.k2.l.have_called_fans_short);
        }
        L();
        this.n.T(e0Var != null ? e0Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f19283b) {
                this.f19284c.setText(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                z(true);
                b.a.q0.s.k.c().h(str);
                return;
            }
            z(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f19283b = z;
            if (this.f19285d == null && this.f19286e == null) {
                View addCustomView = this.f19282a.addCustomView(controlAlign, j.nb_item_floor_more, this.p.mCommonOnClickListener);
                this.f19285d = addCustomView;
                this.f19286e = (ImageView) addCustomView.findViewById(i.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f19285d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19286e, h.icon_pure_topbar_more44_svg, b.a.r0.k2.f.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f19285d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f19285d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.f19285d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void J(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (tBSpecificationBtn = this.z) == null) {
            return;
        }
        if (z) {
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.followed));
            ((b.a.q0.s.g0.n.b) this.z.getStyleConfig()).s(b.a.r0.k2.f.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.attention));
    }

    public void K(b.a.r0.k2.r.f fVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{fVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.f19290i == null) {
            return;
        }
        this.B = fVar;
        this.C = str2;
        if (StringUtils.isNull(str)) {
            this.j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, b.a.r0.k2.l.forum, b.a.r0.k2.g.tbds0, 1, this.x, false);
            b.a.q0.s.k.c().h(str);
            this.j.startLoad(str3, 10, false);
        }
        View view = this.y;
        if (view != null && this.B != null) {
            view.setTag(i.forum_name, str);
            this.y.setTag(i.forum_id, str2);
            this.y.setTag(i.thread_id, this.B.Q());
            this.A = z;
        }
        y();
    }

    public final void L() {
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (d0Var = this.n) == null) {
            return;
        }
        d0Var.u();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.a.e.e.m.g.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            b.a.e.e.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!b.a.e.e.m.g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.y : (View) invokeV.objValue;
    }

    public d0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : (d0) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f19288g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19282a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.F != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.F);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r.setVisibility(0);
            z(false);
            View view = this.f19285d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f19282a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, j.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f19290i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(i.pb_nav_title_forum_image);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds1));
            this.j.setStrokeColorResId(b.a.r0.k2.f.CAM_X0401);
            this.j.setOnClickListener(this.p.mCommonOnClickListener);
            TextView textView = (TextView) this.f19290i.findViewById(i.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(this.p.mCommonOnClickListener);
            if (this.f19290i.getLayoutParams() != null && (this.f19290i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19290i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.f19290i.setLayoutParams(marginLayoutParams);
            }
            if (this.f19290i.getVisibility() == 8) {
                this.f19290i.setVisibility(0);
            }
            if (this.f19290i.getAlpha() != 1.0f) {
                this.f19290i.setAlpha(1.0f);
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AlertDialog alertDialog = this.m;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            NavigationBar navigationBar = this.f19282a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f19282a.getBarBgView(), b.a.r0.k2.f.CAM_X0208);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, h.icon_pure_topbar_return40, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f19286e, h.icon_pure_topbar_more40, b.a.r0.k2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f19284c, b.a.r0.k2.f.CAM_X0105, b.a.r0.k2.f.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, b.a.r0.k2.f.CAM_X0105);
            y();
            L();
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f19282a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f19282a.getBackground().mutate().setAlpha(0);
            this.f19282a.getTopCoverBgView().setBackgroundResource(h.bg_pb_header_gradient_top);
            this.f19282a.getTopCoverBgView().setVisibility(0);
            this.f19282a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(b.a.r0.k2.f.black_alpha85));
            this.f19284c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(b.a.r0.k2.f.CAM_X0111));
            WebPManager.setPureDrawable(this.f19286e, h.icon_pure_topbar_more40, b.a.r0.k2.f.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, h.icon_pure_topbar_return40, b.a.r0.k2.f.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void w(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            d0 d0Var = this.n;
            if (d0Var != null) {
                d0Var.t();
            }
            this.m = null;
            this.n = null;
            b.a.e.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.f19290i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f19290i);
            d2.n(b.a.r0.k2.l.J_X07);
            d2.f(b.a.r0.k2.f.CAM_X0209);
            return;
        }
        this.f19290i.setBackgroundResource(0);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (!this.f19283b && z && !"".equals(this.f19284c.getText().toString())) {
                this.f19284c.setVisibility(0);
            } else {
                this.f19284c.setVisibility(8);
            }
        }
    }
}
