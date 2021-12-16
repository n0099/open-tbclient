package c.a.s0.s2.u.f.h1;

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
import c.a.d.f.p.m;
import c.a.s0.s2.h;
import c.a.s0.s2.i;
import c.a.s0.s2.j;
import c.a.s0.s2.l;
import c.a.s0.s2.u.f.e0;
import c.a.s0.s2.u.f.f0;
import c.a.s0.v3.s0.k;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.s0.s2.r.f B;
    public String C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public Runnable F;
    public View.OnClickListener G;
    public final NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23057b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23058c;

    /* renamed from: d  reason: collision with root package name */
    public View f23059d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f23060e;

    /* renamed from: f  reason: collision with root package name */
    public final View f23061f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f23062g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f23063h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f23064i;

    /* renamed from: j  reason: collision with root package name */
    public BarImageView f23065j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f23066k;
    public String l;
    public AlertDialog m;
    public e0 n;
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

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23067e;

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
            this.f23067e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23067e.p.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f25131b) {
                this.a.A = true;
                c cVar = this.a;
                cVar.J(cVar.A);
            }
        }
    }

    /* renamed from: c.a.s0.s2.u.f.h1.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1368c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1368c(c cVar, int i2) {
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
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.y != null) {
                    if (!booleanValue || this.a.A) {
                        this.a.y.setVisibility(4);
                    } else {
                        this.a.y.setVisibility(0);
                        TbPageTag l = c.a.r0.o0.c.l(this.a.p.getContext());
                        if (this.a.B != null && l != null) {
                            c.a.s0.s2.u.f.g1.c.a("c14277", this.a.C, this.a.B.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.a;
                    cVar.J(cVar.A);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23068e;

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
            this.f23068e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f23068e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.d.f.m.g.a(this.f23068e.m, this.f23068e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23069e;

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
            this.f23069e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23069e.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23070e;

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
            this.f23070e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23070e.q();
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
        this.f23057b = false;
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
        this.E = new C1368c(this, 2921599);
        this.F = new f(this);
        this.G = new g(this);
        this.p = pbFragment;
        this.u = m.f(pbFragment.getContext(), c.a.s0.s2.g.ds88);
        this.v = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.ds14);
        m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds_6);
        int k2 = m.k(TbadkCoreApplication.getInst());
        int f2 = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds40);
        int f3 = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.ds102) + ((int) (k2 * 0.07d));
        this.w = f3;
        if (f3 - f2 > 0) {
            this.w = f3 - f2;
        }
        this.x = (k2 - (this.w * 2)) - m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(i.view_navigation_bar);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.f23061f = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.mCommonOnClickListener);
        this.f23058c = this.a.setCenterTextTitle("");
        this.f23062g = (ImageView) this.a.getCenterImgBox();
        this.f23063h = (LinearLayout) this.a.getCenterImgBoxLayout();
        int f4 = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.ds20);
        this.f23063h.setPadding(f4, 0, f4, 0);
        ImageView imageView = this.f23062g;
        int i4 = h.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f23062g.setVisibility(8);
        this.f23058c.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.f23062g.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.r = (ImageView) this.f23061f.findViewById(i.widget_navi_back_button);
        if (this.f23064i == null) {
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
                this.f23061f.setVisibility(0);
            } else {
                this.f23061f.setVisibility(8);
            }
            z(z);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !c.a.r0.s.g0.b.j().g("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(j.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(i.arrow_up);
                TextView textView = (TextView) inflate.findViewById(i.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = m.f(this.p.getContext(), c.a.s0.s2.g.ds28);
                } else {
                    layoutParams.rightMargin = m.f(this.p.getContext(), c.a.s0.s2.g.ds128);
                }
                textView.setText(l.share_tip);
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
                View view = this.f23059d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f23059d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void E(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, f0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new e0(pbFragment, pbFragment.mCommonOnClickListener);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), c.a.s0.s2.m.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        c.a.d.f.m.g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(c.a.s0.s2.m.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.r());
        window.setDimAmount(this.o);
        this.n.K(f0Var == null ? false : f0Var.a);
        this.n.v(f0Var == null ? false : f0Var.n);
        this.n.x(f0Var == null ? false : f0Var.f22992e);
        this.n.C(f0Var == null ? false : f0Var.f22996i);
        this.n.y(f0Var == null ? false : f0Var.f22993f);
        this.n.M(f0Var != null ? f0Var.f22990c : true);
        this.n.G(f0Var == null ? false : f0Var.f22998k);
        this.n.z(f0Var == null ? false : f0Var.l, f0Var.t);
        if (f0Var == null) {
            this.n.E(false, false);
            this.n.D(false, false);
        } else {
            this.n.E(f0Var.f22994g, f0Var.s);
            this.n.D(f0Var.f22995h, f0Var.r);
        }
        boolean z = f0Var == null ? false : f0Var.q;
        boolean z2 = f0Var == null ? false : f0Var.o;
        boolean z3 = f0Var == null ? false : f0Var.f22991d;
        boolean z4 = f0Var == null ? false : f0Var.f22989b;
        boolean z5 = f0Var == null ? false : f0Var.p;
        boolean z6 = f0Var == null ? false : f0Var.f22997j;
        boolean z7 = f0Var == null ? false : f0Var.m;
        this.n.A(z3, z2);
        this.n.L(z4, z);
        this.n.F(z6, z5);
        this.n.Q(z7);
        if (f0Var != null) {
            e0 e0Var = this.n;
            boolean z8 = f0Var.u;
            e0Var.w = z8;
            if (z8) {
                e0Var.f().setText(l.report_text);
                this.n.y(false);
            }
        }
        this.n.w(f0Var == null ? false : f0Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.getPbModel() != null && this.p.getPbModel().R0() != null && this.p.getPbModel().R0().Q() != null && this.p.getPbModel().R0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(l.have_called_fans_short);
        }
        L();
        this.n.S(f0Var != null ? f0Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f23057b) {
                this.f23058c.setText(TbadkCoreApplication.getInst().getResources().getString(l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                z(true);
                c.a.r0.s.l.c().h(str);
                return;
            }
            z(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f23057b = z;
            if (this.f23059d == null && this.f23060e == null) {
                View addCustomView = this.a.addCustomView(controlAlign, j.nb_item_floor_more, this.p.mCommonOnClickListener);
                this.f23059d = addCustomView;
                this.f23060e = (ImageView) addCustomView.findViewById(i.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f23059d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23060e, h.icon_pure_topbar_more44_svg, c.a.s0.s2.f.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f23059d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f23059d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.f23059d) == null) {
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
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(l.followed));
            ((c.a.r0.s.i0.n.b) this.z.getStyleConfig()).s(c.a.s0.s2.f.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(l.attention));
    }

    public void K(c.a.s0.s2.r.f fVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{fVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.f23064i == null) {
            return;
        }
        this.B = fVar;
        this.C = str2;
        if (StringUtils.isNull(str)) {
            this.f23065j.setVisibility(8);
            this.f23066k.setText("贴吧动态");
            this.l = null;
        } else {
            this.f23065j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.f23066k, str, l.forum, c.a.s0.s2.g.tbds0, 1, this.x, false);
            c.a.r0.s.l.c().h(str);
            this.f23065j.startLoad(str3, 10, false);
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
        e0 e0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (e0Var = this.n) == null) {
            return;
        }
        e0Var.u();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.d.f.m.g.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            c.a.d.f.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.d.f.m.g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.y : (View) invokeV.objValue;
    }

    public e0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : (e0) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f23062g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.F != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.F);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r.setVisibility(0);
            z(false);
            View view = this.f23059d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, j.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f23064i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(i.pb_nav_title_forum_image);
            this.f23065j = barImageView;
            barImageView.setShowOval(true);
            this.f23065j.setShowOuterBorder(false);
            this.f23065j.setShowInnerBorder(true);
            this.f23065j.setStrokeWith(m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds1));
            this.f23065j.setStrokeColorResId(c.a.s0.s2.f.CAM_X0401);
            this.f23065j.setOnClickListener(this.p.mCommonOnClickListener);
            TextView textView = (TextView) this.f23064i.findViewById(i.pb_nav_title_forum_name);
            this.f23066k = textView;
            textView.setOnClickListener(this.p.mCommonOnClickListener);
            if (this.f23064i.getLayoutParams() != null && (this.f23064i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f23064i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.f23064i.setLayoutParams(marginLayoutParams);
            }
            if (this.f23064i.getVisibility() == 8) {
                this.f23064i.setVisibility(0);
            }
            if (this.f23064i.getAlpha() != 1.0f) {
                this.f23064i.setAlpha(1.0f);
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
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), c.a.s0.s2.f.CAM_X0208);
            }
            BarImageView barImageView = this.f23065j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, h.icon_pure_topbar_return40, c.a.s0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f23060e, h.icon_pure_topbar_more40, c.a.s0.s2.f.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f23058c, c.a.s0.s2.f.CAM_X0105, c.a.s0.s2.f.s_navbar_title_color);
            SkinManager.setViewTextColor(this.f23066k, c.a.s0.s2.f.CAM_X0105);
            y();
            L();
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.a.onChangeSkinType(this.p.getPageContext(), i2);
            this.a.getBackground().mutate().setAlpha(0);
            this.a.getTopCoverBgView().setBackgroundResource(h.bg_pb_header_gradient_top);
            this.a.getTopCoverBgView().setVisibility(0);
            this.a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(c.a.s0.s2.f.black_alpha85));
            this.f23058c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(c.a.s0.s2.f.CAM_X0111));
            WebPManager.setPureDrawable(this.f23060e, h.icon_pure_topbar_more40, c.a.s0.s2.f.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, h.icon_pure_topbar_return40, c.a.s0.s2.f.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
            e0 e0Var = this.n;
            if (e0Var != null) {
                e0Var.t();
            }
            this.m = null;
            this.n = null;
            c.a.d.f.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.f23064i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f23064i);
            d2.n(l.J_X07);
            d2.f(c.a.s0.s2.f.CAM_X0209);
            return;
        }
        this.f23064i.setBackgroundResource(0);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (!this.f23057b && z && !"".equals(this.f23058c.getText().toString())) {
                this.f23058c.setVisibility(0);
            } else {
                this.f23058c.setVisibility(8);
            }
        }
    }
}
