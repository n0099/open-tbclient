package c.a.r0.j2.k.e.g1;

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
import c.a.r0.j2.k.e.d0;
import c.a.r0.j2.k.e.e0;
import c.a.r0.j3.r0.k;
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
    public c.a.r0.j2.h.e B;
    public String C;
    public CustomMessageListener D;
    public CustomMessageListener E;
    public Runnable F;
    public View.OnClickListener G;

    /* renamed from: a  reason: collision with root package name */
    public final NavigationBar f20096a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20097b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f20098c;

    /* renamed from: d  reason: collision with root package name */
    public View f20099d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f20100e;

    /* renamed from: f  reason: collision with root package name */
    public final View f20101f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f20102g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f20103h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f20104i;

    /* renamed from: j  reason: collision with root package name */
    public BarImageView f20105j;
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20106e;

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
            this.f20106e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20106e.p.hideKeyBroad();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20107a;

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
            this.f20107a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f21118b) {
                this.f20107a.A = true;
                c cVar = this.f20107a;
                cVar.J(cVar.A);
            }
        }
    }

    /* renamed from: c.a.r0.j2.k.e.g1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0962c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20108a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0962c(c cVar, int i2) {
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
            this.f20108a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.f20108a.y != null) {
                    if (!booleanValue || this.f20108a.A) {
                        this.f20108a.y.setVisibility(4);
                    } else {
                        this.f20108a.y.setVisibility(0);
                        TbPageTag l = c.a.q0.n0.c.l(this.f20108a.p.getContext());
                        if (this.f20108a.B != null && l != null) {
                            c.a.r0.j2.k.e.f1.c.a("c14277", this.f20108a.C, this.f20108a.B.Q(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    }
                    c cVar = this.f20108a;
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
        public final /* synthetic */ c f20109e;

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
            this.f20109e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f20109e.m == null) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.e.e.m.g.a(this.f20109e.m, this.f20109e.p.getPageContext().getPageActivity()))));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20110e;

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
            this.f20110e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20110e.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20111e;

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
            this.f20111e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20111e.q();
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
        this.f20097b = false;
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
        this.E = new C0962c(this, 2921599);
        this.F = new f(this);
        this.G = new g(this);
        this.p = pbFragment;
        this.u = l.g(pbFragment.getContext(), R.dimen.ds88);
        this.v = l.g(TbadkCoreApplication.getInst(), R.dimen.ds14);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int k = l.k(TbadkCoreApplication.getInst());
        int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds102) + ((int) (k * 0.07d));
        this.w = g3;
        if (g3 - g2 > 0) {
            this.w = g3 - g2;
        }
        this.x = (k - (this.w * 2)) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view.findViewById(R.id.view_navigation_bar);
        this.f20096a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.f20096a.hideBottomLine();
        this.f20101f = this.f20096a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.mCommonOnClickListener);
        this.f20098c = this.f20096a.setCenterTextTitle("");
        this.f20102g = (ImageView) this.f20096a.getCenterImgBox();
        this.f20103h = (LinearLayout) this.f20096a.getCenterImgBoxLayout();
        int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
        this.f20103h.setPadding(g4, 0, g4, 0);
        ImageView imageView = this.f20102g;
        int i4 = R.drawable.icon_pb_play_small;
        SkinManager.setNavbarIconSrc(imageView, i4, i4);
        this.f20102g.setVisibility(8);
        this.f20098c.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.f20102g.setOnClickListener(pbFragment.mCommonOnClickListener);
        this.r = (ImageView) this.f20101f.findViewById(R.id.widget_navi_back_button);
        if (this.f20104i == null) {
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
                this.f20101f.setVisibility(0);
            } else {
                this.f20101f.setVisibility(8);
            }
            z(z);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if ((!this.s || TbadkCoreApplication.isLogin()) && !c.a.q0.s.d0.b.j().g("show_share", false)) {
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
                View view = this.f20099d;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.f20099d;
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
        this.n.O(e0Var == null ? false : e0Var.f20036a);
        this.n.v(e0Var == null ? false : e0Var.n);
        this.n.x(e0Var == null ? false : e0Var.f20040e);
        this.n.D(e0Var == null ? false : e0Var.f20044i);
        this.n.y(e0Var == null ? false : e0Var.f20041f);
        this.n.Q(e0Var != null ? e0Var.f20038c : true);
        this.n.N(e0Var == null ? false : e0Var.k);
        this.n.z(e0Var == null ? false : e0Var.l, e0Var.t);
        if (e0Var == null) {
            this.n.K(false, false);
            this.n.J(false, false);
        } else {
            this.n.K(e0Var.f20042g, e0Var.s);
            this.n.J(e0Var.f20043h, e0Var.r);
        }
        boolean z = e0Var == null ? false : e0Var.q;
        boolean z2 = e0Var == null ? false : e0Var.o;
        boolean z3 = e0Var == null ? false : e0Var.f20039d;
        boolean z4 = e0Var == null ? false : e0Var.f20037b;
        boolean z5 = e0Var == null ? false : e0Var.p;
        boolean z6 = e0Var == null ? false : e0Var.f20045j;
        boolean z7 = e0Var == null ? false : e0Var.m;
        this.n.A(z3, z2);
        this.n.P(z4, z);
        this.n.L(z6, z5);
        this.n.S(z7);
        if (e0Var != null) {
            d0 d0Var = this.n;
            boolean z8 = e0Var.u;
            d0Var.w = z8;
            if (z8) {
                d0Var.f().setText(R.string.report_text);
                this.n.y(false);
            }
        }
        this.n.w(e0Var == null ? false : e0Var.v);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.getPbModel() != null && this.p.getPbModel().O0() != null && this.p.getPbModel().O0().Q() != null && this.p.getPbModel().O0().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.d().setText(R.string.have_called_fans_short);
        }
        L();
        this.n.T(e0Var != null ? e0Var.w : false);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.f20097b) {
                this.f20098c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                z(true);
                c.a.q0.s.k.c().h(str);
                return;
            }
            z(false);
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.f20097b = z;
            if (this.f20099d == null && this.f20100e == null) {
                View addCustomView = this.f20096a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.p.mCommonOnClickListener);
                this.f20099d = addCustomView;
                this.f20100e = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                int i2 = this.u;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
                layoutParams.rightMargin = this.v;
                this.f20099d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20100e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                this.f20099d.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            }
        }
    }

    public void H(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.f20099d) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public void I() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (view = this.f20099d) == null) {
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
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.followed));
            ((c.a.q0.s.f0.n.b) this.z.getStyleConfig()).r(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.attention));
    }

    public void K(c.a.r0.j2.h.e eVar, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{eVar, str, str2, str3, Boolean.valueOf(z)}) == null) || this.p == null || this.f20104i == null) {
            return;
        }
        this.B = eVar;
        this.C = str2;
        if (StringUtils.isNull(str)) {
            this.f20105j.setVisibility(8);
            this.k.setText("贴吧动态");
            this.l = null;
        } else {
            this.f20105j.setVisibility(0);
            this.l = str;
            ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.forum, R.dimen.tbds0, 1, this.x, false);
            c.a.q0.s.k.c().h(str);
            this.f20105j.startLoad(str3, 10, false);
        }
        View view = this.y;
        if (view != null && this.B != null) {
            view.setTag(R.id.forum_name, str);
            this.y.setTag(R.id.forum_id, str2);
            this.y.setTag(R.id.thread_id, this.B.Q());
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
            c.a.e.e.m.g.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            c.a.e.e.m.e.a().postDelayed(this.q, 100L);
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (alertDialog = this.m) == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!c.a.e.e.m.g.a(alertDialog, this.p.getPageContext().getPageActivity()))));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f20102g : (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f20096a : (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.F != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.F);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.r.setVisibility(0);
            z(false);
            View view = this.f20099d;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.f20096a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.nav_fourm_title_layout, (View.OnClickListener) null);
            this.f20104i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.pb_nav_title_forum_image);
            this.f20105j = barImageView;
            barImageView.setShowOval(true);
            this.f20105j.setShowOuterBorder(false);
            this.f20105j.setShowInnerBorder(true);
            this.f20105j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.f20105j.setStrokeColorResId(R.color.CAM_X0401);
            this.f20105j.setOnClickListener(this.p.mCommonOnClickListener);
            TextView textView = (TextView) this.f20104i.findViewById(R.id.pb_nav_title_forum_name);
            this.k = textView;
            textView.setOnClickListener(this.p.mCommonOnClickListener);
            if (this.f20104i.getLayoutParams() != null && (this.f20104i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.w > 0 && this.x > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f20104i.getLayoutParams();
                int i2 = this.w;
                marginLayoutParams.leftMargin = i2;
                marginLayoutParams.rightMargin = i2;
                this.f20104i.setLayoutParams(marginLayoutParams);
            }
            if (this.f20104i.getVisibility() == 8) {
                this.f20104i.setVisibility(0);
            }
            if (this.f20104i.getAlpha() != 1.0f) {
                this.f20104i.setAlpha(1.0f);
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
            NavigationBar navigationBar = this.f20096a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i2);
                SkinManager.setBackgroundColor(this.f20096a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.f20105j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.f20100e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.f20098c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            y();
            L();
        }
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f20096a.onChangeSkinType(this.p.getPageContext(), i2);
            this.f20096a.getBackground().mutate().setAlpha(0);
            this.f20096a.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
            this.f20096a.getTopCoverBgView().setVisibility(0);
            this.f20096a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.f20098c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.f20100e, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
            c.a.e.e.m.e.a().removeCallbacks(this.q);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.f20104i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f20104i);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.f20104i.setBackgroundResource(0);
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (!this.f20097b && z && !"".equals(this.f20098c.getText().toString())) {
                this.f20098c.setVisibility(0);
            } else {
                this.f20098c.setVisibility(8);
            }
        }
    }
}
