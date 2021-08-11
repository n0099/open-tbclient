package c.a.p0.v.e.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.k.e.n;
import c.a.o0.s.f0.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.v.e.d.c A;
    public c.a.p0.v.e.a.d B;
    public c.a.p0.v0.w1.b C;
    public NavigationBar D;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25156a;

    /* renamed from: b  reason: collision with root package name */
    public int f25157b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.v.e.c.d f25158c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25159d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f25160e;

    /* renamed from: f  reason: collision with root package name */
    public View f25161f;

    /* renamed from: g  reason: collision with root package name */
    public View f25162g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f25163h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f25164i;

    /* renamed from: j  reason: collision with root package name */
    public BdTypeMultiColumnListView f25165j;
    public PopupWindow k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public String p;
    public boolean q;
    public c.a.o0.s.f0.g r;
    public PbListView s;
    public NoNetworkView t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25166e;

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
            this.f25166e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f25166e.f25156a.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25167e;

        public b(c cVar) {
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
            this.f25167e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25167e.r();
            }
        }
    }

    /* renamed from: c.a.p0.v.e.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnTouchListenerC1175c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25168e;

        public View$OnTouchListenerC1175c(c cVar) {
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
            this.f25168e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f25168e.C.b(view, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25169e;

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
                    return;
                }
            }
            this.f25169e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25169e.s(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25170e;

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
            this.f25170e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25170e.s(2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25171e;

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
            this.f25171e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25171e.l();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25172e;

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
            this.f25172e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12573").param("fid", this.f25172e.p));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(this.f25172e.f25156a.getPageActivity())));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMultiColumnListView.OnScrollToBottomListener f25173e;

        public h(c cVar, BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, onScrollToBottomListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25173e = onScrollToBottomListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onScrollToBottomListener = this.f25173e) == null) {
                return;
            }
            onScrollToBottomListener.onScrollToBottom();
        }
    }

    public c(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), bdUniqueId, str, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25157b = -1;
        this.q = false;
        this.f25156a = tbPageContext;
        this.f25159d = z;
        this.f25160e = bdUniqueId;
        this.p = str;
        this.q = z2;
    }

    public void A() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25165j.setNextPage(this.s);
        }
        this.s.A(this.f25156a.getResources().getString(R.string.load_more));
        this.s.f();
    }

    public void B() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f25165j.setNextPage(this.s);
        }
        this.s.M();
        this.s.O();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.A == null) {
                c.a.p0.v.e.d.c cVar = new c.a.p0.v.e.d.c(this.f25156a.getPageActivity());
                this.A = cVar;
                cVar.a();
                this.A.e(new g(this));
            }
            if (this.A.b().getParent() == null) {
                this.f25165j.setNextPage(this.A);
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            SkinManager.setBackgroundResource(this.l, R.drawable.bg_ala_frs_game_live_sort_panel);
            SkinManager.setBackgroundResource(this.m, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
            int[] iArr = new int[2];
            this.f25164i.getLocationOnScreen(iArr);
            int height = ((View) this.f25164i.getParent()).getHeight() - this.f25164i.getHeight();
            if (iArr[1] - this.k.getHeight() <= 50) {
                c.a.e.e.m.g.d(this.k, this.f25156a.getPageActivity());
                return;
            }
            c.a.e.e.m.g.m(this.k, this.f25161f, 0, (iArr[0] - (this.f25164i.getWidth() / 2)) - this.f25156a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f25164i.getHeight() + height);
            this.k.update();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f25165j.completePullRefresh();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f25165j != null && j.z()) {
            this.f25165j.startPullRefresh();
        }
    }

    public BdTypeMultiColumnListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25165j : (BdTypeMultiColumnListView) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (NavigationBar) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f25161f : (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.u == null) {
                View inflate = LayoutInflater.from(this.f25156a.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
                this.u = inflate;
                this.v = (TextView) inflate.findViewById(R.id.frs_game_live_recommand1);
                this.w = (TextView) this.u.findViewById(R.id.frs_game_live_recommand2);
                this.x = (TextView) this.u.findViewById(R.id.frs_game_live_recommand3);
                this.y = this.u.findViewById(R.id.frs_game_live_recommand_line1);
                this.z = this.u.findViewById(R.id.frs_game_live_recommand_line2);
            }
            p();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.l == null) {
                View inflate = LayoutInflater.from(this.f25156a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
                this.l = inflate;
                this.m = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
                this.n = (TextView) this.l.findViewById(R.id.frs_game_live_new);
                this.o = this.l.findViewById(R.id.frs_game_live_sort_sepline);
                this.m.setOnClickListener(new d(this));
                this.n.setOnClickListener(new e(this));
            }
            if (this.k == null) {
                PopupWindow popupWindow = new PopupWindow(this.f25156a.getPageActivity());
                this.k = popupWindow;
                popupWindow.setContentView(this.l);
                this.k.setWidth(-2);
                this.k.setHeight(-2);
                this.k.setAnimationStyle(16973826);
                this.k.setBackgroundDrawable(this.f25156a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.k.setOutsideTouchable(true);
                this.k.setFocusable(true);
                this.k.setTouchable(true);
                this.k.setOnDismissListener(new f(this));
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.f25156a.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
            this.f25161f = inflate;
            if (this.q) {
                NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.view_navigation_bar);
                this.D = navigationBar;
                navigationBar.setVisibility(0);
                this.D.onChangeSkinType(this.f25156a, TbadkCoreApplication.getInst().getSkinType());
                this.D.showBottomLine(true);
                this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            this.f25162g = this.f25161f.findViewById(R.id.frs_game_live_topinfo);
            this.f25163h = (TextView) this.f25161f.findViewById(R.id.frs_game_live_num);
            this.f25164i = (TextView) this.f25161f.findViewById(R.id.frs_game_live_sort);
            BdTypeMultiColumnListView bdTypeMultiColumnListView = (BdTypeMultiColumnListView) this.f25161f.findViewById(R.id.listView);
            this.f25165j = bdTypeMultiColumnListView;
            bdTypeMultiColumnListView.setColumnDiv((int) this.f25156a.getResources().getDimension(R.dimen.ds16));
            this.t = (NoNetworkView) this.f25161f.findViewById(R.id.vNoNetwork);
            c.a.o0.s.f0.g gVar = new c.a.o0.s.f0.g(this.f25156a);
            this.r = gVar;
            gVar.V(this.f25160e);
            this.f25165j.setPullRefresh(this.r);
            PbListView pbListView = new PbListView(this.f25156a.getPageActivity());
            this.s = pbListView;
            pbListView.a();
            this.B = new c.a.p0.v.e.a.d(this.f25156a, this.f25165j);
            this.f25164i.setOnClickListener(new b(this));
            if (this.f25159d) {
                this.C = new c.a.p0.v0.w1.b(this.f25156a.getPageActivity(), this.f25160e, this.f25159d);
                this.f25165j.setOnTouchListener(new View$OnTouchListenerC1175c(this));
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setViewTextColor(this.v, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.x, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (this.f25157b != i2) {
                this.f25157b = i2;
            }
            NavigationBar navigationBar = this.D;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f25156a, i2);
            }
            NavigationBar navigationBar2 = this.D;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.f25156a, i2);
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            SkinManager.setViewTextColor(this.f25163h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f25164i, R.color.CAM_X0109);
            this.f25165j.setContentBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f25164i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            D();
        }
    }

    public final void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            u(i2);
            c.a.e.e.m.g.d(this.k, this.f25156a.getPageActivity());
            c.a.p0.v.e.c.d dVar = this.f25158c;
            if (dVar != null) {
                dVar.a(i2);
            }
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.f25163h == null) {
            return;
        }
        this.f25163h.setText(this.f25156a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i2)));
        if (i2 <= 1) {
            this.f25164i.setVisibility(8);
        } else {
            this.f25164i.setVisibility(0);
        }
    }

    public void u(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 == 1) {
                TextView textView2 = this.f25164i;
                if (textView2 != null) {
                    textView2.setText(this.f25156a.getString(R.string.frs_game_live_sort_hot));
                }
            } else if (i2 != 2 || (textView = this.f25164i) == null) {
            } else {
                textView.setText(this.f25156a.getString(R.string.frs_game_live_sort_new));
            }
        }
    }

    public void v(c.a.p0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, cVar) == null) {
            this.B.b(cVar);
        }
    }

    public void w(List<n> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            if (z2) {
                m();
                this.f25162g.setVisibility(8);
                View view = this.u;
                if (view != null) {
                    this.f25165j.removeHeaderView(view);
                    this.f25165j.addHeaderView(this.u);
                }
                this.B.c(list);
                this.f25165j.setNextPage(null);
                return;
            }
            View view2 = this.u;
            if (view2 != null) {
                this.f25165j.removeHeaderView(view2);
            }
            if (list.size() == 0) {
                this.f25162g.setVisibility(8);
                this.B.c(list);
                this.f25165j.setNextPage(null);
                return;
            }
            this.f25162g.setVisibility(0);
            this.B.c(list);
            if (z) {
                A();
            } else {
                C();
            }
        }
    }

    public void x(c.a.p0.v.e.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            this.f25158c = dVar;
        }
    }

    public void y(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.r.a(gVar);
        }
    }

    public void z(BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onScrollToBottomListener) == null) {
            this.f25165j.setOnSrollToBottomListener(onScrollToBottomListener);
            this.s.z(new h(this, onScrollToBottomListener));
        }
    }
}
