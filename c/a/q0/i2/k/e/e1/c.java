package c.a.q0.i2.k.e.e1;

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
import c.a.e.e.p.l;
import c.a.q0.i2.k.e.c0;
import c.a.q0.i2.k.e.d0;
import c.a.q0.i3.r0.k;
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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn A;
    public boolean B;
    public c.a.q0.i2.h.e C;
    public String D;
    public CustomMessageListener E;
    public CustomMessageListener F;
    public Runnable G;
    public View.OnClickListener H;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f19396a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19397b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19398c;

    /* renamed from: d  reason: collision with root package name */
    public View f19399d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19400e;

    /* renamed from: f  reason: collision with root package name */
    public final View f19401f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f19402g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f19403h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f19404i;

    /* renamed from: j  reason: collision with root package name */
    public BarImageView f19405j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public c0 n;
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
    public int y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19406e;

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
            this.f19406e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19406e.p.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19407a;

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
            this.f19407a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f20550b) {
                this.f19407a.B = true;
                c cVar = this.f19407a;
                cVar.K(cVar.B);
            }
        }
    }

    /* renamed from: c.a.q0.i2.k.e.e1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0924c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19408a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0924c(c cVar, int i2) {
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
            this.f19408a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f19408a.z != null) {
                    if (!booleanValue || this.f19408a.B) {
                        this.f19408a.z.setVisibility(4);
                    } else {
                        this.f19408a.z.setVisibility(0);
                        TbPageTag l = c.a.p0.l0.c.l(this.f19408a.p.getContext());
                        if (this.f19408a.C != null && l != null) {
                            c.a.q0.i2.k.e.d1.c.a("c14277", this.f19408a.D, this.f19408a.C.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.f19408a;
                    cVar.K(cVar.B);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19409e;

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
            this.f19409e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19409e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.e.e.m.g.a(this.f19409e.m, this.f19409e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19410e;

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
            this.f19410e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19410e.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19411e;

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
            this.f19411e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19411e.q();
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
        this.f19397b = false;
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.B = false;
        this.E = new b(this, 2001437);
        this.F = new C0924c(this, 2921599);
        this.G = new f(this);
        this.H = new g(this);
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        this.y = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f19396a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f19396a.hideBottomLine();
        this.f19401f = this.f19396a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.mCommonOnClickListener);
        this.f19398c = this.f19396a.setCenterTextTitle("");
        this.f19402g = (ImageView) this.f19396a.getCenterImgBox();
        this.f19403h = (LinearLayout) this.f19396a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f19403h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f19402g;
        int i4 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f19402g.setVisibility(8);
        this.f19398c.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.f19402g.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.r = (ImageView) this.f19401f.findViewById(R.id.widget_navi_back_button);
        if (this.f19404i == null) {
            if (!c.a.p0.b.d.Q() && !c.a.p0.b.d.S()) {
                s();
            } else {
                t();
            }
        }
        pbFragment.registerListener(this.E);
        pbFragment.registerListener(this.F);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!this.f19397b && z && !"".equals(this.f19398c.getText().toString())) {
                this.f19398c.setVisibility(0);
            } else {
                this.f19398c.setVisibility(8);
            }
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f19401f.setVisibility(0);
            } else {
                this.f19401f.setVisibility(8);
            }
            A(z);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !c.a.p0.s.d0.b.j().g("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.arrow_up);
                TextView textView = (TextView) inflate.findViewById(R.id.tips);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds28);
                } else {
                    layoutParams.rightMargin = l.g(this.p.getContext(), R.dimen.ds128);
                }
                textView.setText(R.string.share_tip);
                textView.setOnClickListener(this.H);
                this.t = new PopupWindow(inflate, -2, -2);
            }
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.r.setVisibility(0);
            A(z);
            if (TbadkCoreApplication.isLogin()) {
                View view = this.f19399d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f19399d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void F(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, d0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new c0(pbFragment, pbFragment.mCommonOnClickListener);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.DialogTheme).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        c.a.e.e.m.g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.r());
        window.setDimAmount(this.o);
        this.n.O(d0Var == null ? false : d0Var.f19343a);
        this.n.v(d0Var == null ? false : d0Var.n);
        this.n.x(d0Var == null ? false : d0Var.f19347e);
        this.n.D(d0Var == null ? false : d0Var.f19351i);
        this.n.y(d0Var == null ? false : d0Var.f19348f);
        this.n.Q(d0Var != null ? d0Var.f19345c : true);
        this.n.N(d0Var == null ? false : d0Var.k);
        this.n.z(d0Var == null ? false : d0Var.l, d0Var.t);
        if (d0Var == null) {
            this.n.K(false, false);
            this.n.J(false, false);
        } else {
            this.n.K(d0Var.f19349g, d0Var.s);
            this.n.J(d0Var.f19350h, d0Var.r);
        }
        boolean z = d0Var == null ? false : d0Var.q;
        boolean z2 = d0Var == null ? false : d0Var.o;
        boolean z3 = d0Var == null ? false : d0Var.f19346d;
        boolean z4 = d0Var == null ? false : d0Var.f19344b;
        boolean z5 = d0Var == null ? false : d0Var.p;
        boolean z6 = d0Var == null ? false : d0Var.f19352j;
        boolean z7 = d0Var == null ? false : d0Var.m;
        this.n.A(z3, z2);
        this.n.P(z4, z);
        this.n.L(z6, z5);
        this.n.S(z7);
        if (d0Var != null) {
            c0 c0Var = this.n;
            boolean z8 = d0Var.u;
            c0Var.w = z8;
            if (z8) {
                c0Var.f().setText(R.string.report_text);
                this.n.y(false);
            }
        }
        this.n.w(d0Var == null ? false : d0Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.getPbModel() != null && this.p.getPbModel().O0() != null && this.p.getPbModel().O0().Q() != null && this.p.getPbModel().O0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        M();
        this.n.T(d0Var != null ? d0Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f19397b) {
                this.f19398c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                A(true);
                c.a.p0.s.k.c().h(str);
                return;
            }
            A(false);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f19397b = z;
            if (this.f19399d == null && this.f19400e == null) {
                if (c.a.p0.b.d.S() || c.a.p0.b.d.Q()) {
                    View addCustomView = this.f19396a.addCustomView(controlAlign, R.layout.navigation_right_attention_btn, this.p.mCommonOnClickListener);
                    this.z = addCustomView;
                    addCustomView.setVisibility(4);
                    TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.z.findViewById(R.id.navigation_attention);
                    this.A = tBSpecificationBtn;
                    tBSpecificationBtn.setTextSize(R.dimen.T_X08);
                }
                View addCustomView2 = this.f19396a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.mCommonOnClickListener);
                this.f19399d = addCustomView2;
                this.f19400e = (ImageView) addCustomView2.findViewById(R.id.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f19399d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19400e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f19399d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void I(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (view = this.f19399d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void J() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (view = this.f19399d) == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void K(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (tBSpecificationBtn = this.A) == null) {
            return;
        }
        if (z) {
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.followed));
            ((c.a.p0.s.f0.n.b) this.A.getStyleConfig()).r(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.attention));
    }

    public void L(c.a.q0.i2.h.e eVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{eVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.f19404i == null) {
            return;
        }
        this.C = eVar;
        this.D = str2;
        if (StringUtils.isNull(str)) {
            this.f19405j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.f19405j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.forum, R.dimen.tbds0, 1, this.x, false);
            c.a.p0.s.k.c().h(str);
            this.f19405j.startLoad(str3, 10, false);
        }
        View view = this.z;
        if (view != null && this.C != null) {
            view.setTag(R.id.forum_name, str);
            this.z.setTag(R.id.forum_id, str2);
            this.z.setTag(R.id.thread_id, this.C.Q());
            this.B = z;
        }
        z();
    }

    public final void M() {
        c0 c0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (c0Var = this.n) == null) {
            return;
        }
        c0Var.u();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c.a.e.e.m.g.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            c.a.e.e.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.e.e.m.g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.z : (View) invokeV.objValue;
    }

    public c0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.n : (c0) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f19402g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f19396a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.G != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.G);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.r.setVisibility(0);
            A(false);
            View view = this.f19399d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f19396a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f19404i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.f19405j = barImageView;
            barImageView.setShowOval(true);
            this.f19405j.setShowOuterBorder(false);
            this.f19405j.setShowInnerBorder(true);
            this.f19405j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f19405j.setStrokeColorResId(R.color.CAM_X0401);
            this.f19405j.setOnClickListener(this.p.mCommonOnClickListener);
            TextView textView = (TextView) this.f19404i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(this.p.mCommonOnClickListener);
            if (this.f19404i.getLayoutParams() != null && (this.f19404i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19404i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.f19404i.setLayoutParams(marginLayoutParams);
            }
            if (this.f19404i.getVisibility() == 8) {
                this.f19404i.setVisibility(0);
            }
            if (this.f19404i.getAlpha() != 1.0f) {
                this.f19404i.setAlpha(1.0f);
            }
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f19396a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f19404i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.f19405j = barImageView;
            ViewGroup.LayoutParams layoutParams = barImageView.getLayoutParams();
            layoutParams.width = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
            layoutParams.height = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
            this.f19405j.setLayoutParams(layoutParams);
            this.f19405j.setShowOval(true);
            this.f19405j.setShowOuterBorder(false);
            this.f19405j.setShowInnerBorder(true);
            this.f19405j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f19405j.setStrokeColorResId(R.color.CAM_X0401);
            this.f19405j.setOnClickListener(this.p.mCommonOnClickListener);
            TextView textView = (TextView) this.f19404i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            c.a.p0.s.u.c.d(textView).y(R.dimen.T_X05);
            this.k.setOnClickListener(this.p.mCommonOnClickListener);
            if (this.f19404i.getLayoutParams() != null && (this.f19404i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f19404i.getLayoutParams();
                marginLayoutParams.leftMargin = this.y;
                this.f19404i.setLayoutParams(marginLayoutParams);
            }
            if (this.f19404i.getVisibility() == 8) {
                this.f19404i.setVisibility(0);
            }
            if (this.f19404i.getAlpha() != 1.0f) {
                this.f19404i.setAlpha(1.0f);
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AlertDialog alertDialog = this.m;
            return alertDialog != null && alertDialog.isShowing();
        }
        return invokeV.booleanValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            NavigationBar navigationBar = this.f19396a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f19396a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.f19405j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f19400e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f19398c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            z();
            M();
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.f19396a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f19396a.getBackground().mutate().setAlpha(0);
            this.f19396a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.f19396a.getTopCoverBgView().setVisibility(0);
            this.f19396a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f19398c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f19400e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void x(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view) == null) {
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            c0 c0Var = this.n;
            if (c0Var != null) {
                c0Var.t();
            }
            this.m = null;
            this.n = null;
            c.a.e.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.f19404i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            if (!c.a.p0.b.d.Q() && !c.a.p0.b.d.S()) {
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.f19404i);
                d2.n(R.string.J_X07);
                d2.f(R.color.CAM_X0209);
                return;
            }
            this.f19404i.setBackgroundResource(0);
            return;
        }
        this.f19404i.setBackgroundResource(0);
    }
}
