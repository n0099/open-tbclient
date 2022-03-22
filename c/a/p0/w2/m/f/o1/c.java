package c.a.p0.w2.m.f.o1;

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
import c.a.d.f.p.n;
import c.a.o0.r.l;
import c.a.p0.w2.m.f.l0;
import c.a.p0.w2.m.f.m0;
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
    public boolean A;
    public c.a.p0.w2.i.f B;
    public String C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public Runnable F;
    public View.OnClickListener G;
    public final NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20280b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20281c;

    /* renamed from: d  reason: collision with root package name */
    public View f20282d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20283e;

    /* renamed from: f  reason: collision with root package name */
    public final View f20284f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f20285g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f20286h;
    public LinearLayout i;
    public BarImageView j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public l0 n;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.p.d5();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.a4.t0.f) && ((c.a.p0.a4.t0.f) customResponsedMessage.getData()).f12402b) {
                this.a.A = true;
                c cVar = this.a;
                cVar.J(cVar.A);
            }
        }
    }

    /* renamed from: c.a.p0.w2.m.f.o1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1517c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1517c(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                        TbPageTag l = c.a.o0.o0.c.l(this.a.p.getContext());
                        if (this.a.B != null && l != null) {
                            c.a.p0.w2.m.f.n1.c.a("c14277", this.a.C, this.a.B.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.a;
                    cVar.J(cVar.A);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public final /* synthetic */ c a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.d.f.m.g.a(this.a.m, this.a.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.q();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20280b = false;
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
        this.E = new C1517c(this, 2921599);
        this.F = new f(this);
        this.G = new g(this);
        this.p = pbFragment;
        this.u = n.f(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f0702ff);
        this.v = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        n.f(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int k = n.k(TbadkCoreApplication.getInst());
        int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07022a) + ((int) (k * 0.07d));
        this.w = f3;
        if (f3 - f2 > 0) {
            this.w = f3 - f2;
        }
        this.x = (k - (this.w * 2)) - n.f(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.obfuscated_res_0x7f0923cf);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.f20284f = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.d2);
        this.f20281c = this.a.setCenterTextTitle("");
        this.f20285g = (ImageView) this.a.getCenterImgBox();
        this.f20286h = (LinearLayout) this.a.getCenterImgBoxLayout();
        int f4 = n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.f20286h.setPadding(f4, 0, f4, 0);
        SkinManager.setNavbarIconSrc(this.f20285g, R.drawable.obfuscated_res_0x7f08088e, R.drawable.obfuscated_res_0x7f08088e);
        this.f20285g.setVisibility(8);
        this.f20281c.setOnClickListener(pbFragment.d2);
        this.f20285g.setOnClickListener(pbFragment.d2);
        this.r = (ImageView) this.f20284f.findViewById(R.id.obfuscated_res_0x7f09246f);
        if (this.i == null) {
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
                this.f20284f.setVisibility(0);
            } else {
                this.f20284f.setVisibility(8);
            }
            z(z);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !c.a.o0.r.j0.b.k().h("show_share", false)) {
                View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.obfuscated_res_0x7f0d083f, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0902a9);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092026);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.gravity = 5;
                if (!TbadkCoreApplication.isLogin()) {
                    layoutParams.rightMargin = n.f(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
                } else {
                    layoutParams.rightMargin = n.f(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
                }
                textView.setText(R.string.obfuscated_res_0x7f0f113c);
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
                View view = this.f20282d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f20282d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void E(m0 m0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, m0Var) == null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new l0(pbFragment, pbFragment.d2);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.obfuscated_res_0x7f100104).create();
        this.m = create;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        c.a.d.f.m.g.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = n.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ed);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.t());
        window.setDimAmount(this.o);
        this.n.L(m0Var == null ? false : m0Var.a);
        this.n.y(m0Var == null ? false : m0Var.n);
        this.n.A(m0Var == null ? false : m0Var.f20237e);
        this.n.F(m0Var == null ? false : m0Var.i);
        this.n.B(m0Var == null ? false : m0Var.f20238f);
        this.n.N(m0Var != null ? m0Var.f20235c : true);
        this.n.K(m0Var == null ? false : m0Var.k);
        this.n.C(m0Var == null ? false : m0Var.l, m0Var.t);
        if (m0Var == null) {
            this.n.H(false, false);
            this.n.G(false, false);
        } else {
            this.n.H(m0Var.f20239g, m0Var.s);
            this.n.G(m0Var.f20240h, m0Var.r);
        }
        boolean z = m0Var == null ? false : m0Var.q;
        boolean z2 = m0Var == null ? false : m0Var.o;
        boolean z3 = m0Var == null ? false : m0Var.f20236d;
        boolean z4 = m0Var == null ? false : m0Var.f20234b;
        boolean z5 = m0Var == null ? false : m0Var.p;
        boolean z6 = m0Var == null ? false : m0Var.j;
        boolean z7 = m0Var == null ? false : m0Var.m;
        this.n.D(z3, z2);
        this.n.M(z4, z);
        this.n.I(z6, z5);
        this.n.P(z7);
        if (m0Var != null) {
            l0 l0Var = this.n;
            boolean z8 = m0Var.u;
            l0Var.w = z8;
            if (z8) {
                l0Var.h().setText(R.string.obfuscated_res_0x7f0f0fa2);
                this.n.B(false);
            }
        }
        this.n.z(m0Var == null ? false : m0Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.w() != null && this.p.w().S0() != null && this.p.w().S0().Q() != null && this.p.w().S0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.obfuscated_res_0x7f0f0812);
        }
        L();
        this.n.Q(m0Var != null ? m0Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f20280b) {
                this.f20281c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03c0, UtilHelper.getFixedBarText(str, 7, false)));
                z(true);
                l.c().h(str);
                return;
            }
            z(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f20280b = z;
            if (this.f20282d == null && this.f20283e == null) {
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.obfuscated_res_0x7f0d05e6, this.p.d2);
                this.f20282d = addCustomView;
                this.f20283e = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09150f);
                int i = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
                layoutParams.rightMargin = this.v;
                this.f20282d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20283e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f20282d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f20282d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.f20282d) == null) {
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
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0627));
            ((c.a.o0.r.l0.n.b) this.z.getStyleConfig()).t(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f029b));
    }

    public void K(c.a.p0.w2.i.f fVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{fVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.i == null) {
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
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.obfuscated_res_0x7f0f063c, R.dimen.tbds0, 1, this.x, false);
            l.c().h(str);
            this.j.J(str3, 10, false);
        }
        View view = this.y;
        if (view != null && this.B != null) {
            view.setTag(R.id.obfuscated_res_0x7f090a67, str);
            this.y.setTag(R.id.obfuscated_res_0x7f090a4b, str2);
            this.y.setTag(R.id.obfuscated_res_0x7f091fa8, this.B.Q());
            this.A = z;
        }
        y();
    }

    public final void L() {
        l0 l0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (l0Var = this.n) == null) {
            return;
        }
        l0Var.x();
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

    public l0 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.n : (l0) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f20285g : (View) invokeV.objValue;
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
            View view = this.f20282d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d05e2, (View.OnClickListener) null);
            this.i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091701);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.d2);
            TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091702);
            this.k = textView;
            textView.setOnClickListener(this.p.d2);
            if (this.i.getLayoutParams() != null && (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                int i = this.w;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
                this.i.setLayoutParams(marginLayoutParams);
            }
            if (this.i.getVisibility() == 8) {
                this.i.setVisibility(0);
            }
            if (this.i.getAlpha() != 1.0f) {
                this.i.setAlpha(1.0f);
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

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f20283e, R.drawable.obfuscated_res_0x7f0809b9, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f20281c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            y();
            L();
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.a.onChangeSkinType(this.p.getPageContext(), i);
            this.a.getBackground().mutate().setAlpha(0);
            this.a.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c8);
            this.a.getTopCoverBgView().setVisibility(0);
            this.a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f20281c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f20283e, R.drawable.obfuscated_res_0x7f0809b9, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
            l0 l0Var = this.n;
            if (l0Var != null) {
                l0Var.w();
            }
            this.m = null;
            this.n = null;
            c.a.d.f.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.i.setBackgroundResource(0);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (!this.f20280b && z && !"".equals(this.f20281c.getText().toString())) {
                this.f20281c.setVisibility(0);
            } else {
                this.f20281c.setVisibility(8);
            }
        }
    }
}
