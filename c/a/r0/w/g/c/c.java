package c.a.r0.w.g.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.l.e.n;
import c.a.q0.s.f0.f;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.w.g.d.c A;
    public c.a.r0.w.g.a.d B;
    public c.a.r0.x0.x1.b C;
    public NavigationBar D;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f26165a;

    /* renamed from: b  reason: collision with root package name */
    public int f26166b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.w.g.c.d f26167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26168d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f26169e;

    /* renamed from: f  reason: collision with root package name */
    public View f26170f;

    /* renamed from: g  reason: collision with root package name */
    public View f26171g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26172h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26173i;

    /* renamed from: j  reason: collision with root package name */
    public BdTypeMultiColumnListView f26174j;
    public PopupWindow k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public String p;
    public boolean q;
    public c.a.q0.s.f0.g r;
    public PbListView s;
    public NoNetworkView t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26175e;

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
            this.f26175e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.f26175e.f26165a.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26176e;

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
            this.f26176e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26176e.r();
            }
        }
    }

    /* renamed from: c.a.r0.w.g.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnTouchListenerC1217c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26177e;

        public View$OnTouchListenerC1217c(c cVar) {
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
            this.f26177e = cVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                this.f26177e.C.b(view, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26178e;

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
            this.f26178e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26178e.s(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26179e;

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
            this.f26179e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26179e.s(2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26180e;

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
            this.f26180e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26180e.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f26181e;

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
            this.f26181e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c12573").param("fid", this.f26181e.p));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(this.f26181e.f26165a.getPageActivity())));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BdMultiColumnListView.OnScrollToBottomListener f26182e;

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
            this.f26182e = onScrollToBottomListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onScrollToBottomListener = this.f26182e) == null) {
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
        this.f26166b = -1;
        this.q = false;
        this.f26165a = tbPageContext;
        this.f26168d = z;
        this.f26169e = bdUniqueId;
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
            this.f26174j.setNextPage(this.s);
        }
        this.s.A(this.f26165a.getResources().getString(R.string.load_more));
        this.s.f();
    }

    public void B() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f26174j.setNextPage(this.s);
        }
        this.s.M();
        this.s.O();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.A == null) {
                c.a.r0.w.g.d.c cVar = new c.a.r0.w.g.d.c(this.f26165a.getPageActivity());
                this.A = cVar;
                cVar.a();
                this.A.e(new g(this));
            }
            if (this.A.b().getParent() == null) {
                this.f26174j.setNextPage(this.A);
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
            this.f26173i.getLocationOnScreen(iArr);
            int height = ((View) this.f26173i.getParent()).getHeight() - this.f26173i.getHeight();
            if (iArr[1] - this.k.getHeight() <= 50) {
                c.a.e.e.m.g.d(this.k, this.f26165a.getPageActivity());
                return;
            }
            c.a.e.e.m.g.m(this.k, this.f26170f, 0, (iArr[0] - (this.f26173i.getWidth() / 2)) - this.f26165a.getResources().getDimensionPixelSize(R.dimen.ds24), iArr[1] + this.f26173i.getHeight() + height);
            this.k.update();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f26174j.completePullRefresh();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f26174j != null && j.z()) {
            this.f26174j.startPullRefresh();
        }
    }

    public BdTypeMultiColumnListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f26174j : (BdTypeMultiColumnListView) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (NavigationBar) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f26170f : (View) invokeV.objValue;
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
                View inflate = LayoutInflater.from(this.f26165a.getPageActivity()).inflate(R.layout.ala_frs_game_live_recommand_header, (ViewGroup) null);
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
                View inflate = LayoutInflater.from(this.f26165a.getPageActivity()).inflate(R.layout.ala_frs_game_live_sort_panel, (ViewGroup) null);
                this.l = inflate;
                this.m = (TextView) inflate.findViewById(R.id.frs_game_live_hot);
                this.n = (TextView) this.l.findViewById(R.id.frs_game_live_new);
                this.o = this.l.findViewById(R.id.frs_game_live_sort_sepline);
                this.m.setOnClickListener(new d(this));
                this.n.setOnClickListener(new e(this));
            }
            if (this.k == null) {
                PopupWindow popupWindow = new PopupWindow(this.f26165a.getPageActivity());
                this.k = popupWindow;
                popupWindow.setContentView(this.l);
                this.k.setWidth(-2);
                this.k.setHeight(-2);
                this.k.setAnimationStyle(16973826);
                this.k.setBackgroundDrawable(this.f26165a.getResources().getDrawable(R.drawable.popup_window_transparent));
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
            View inflate = LayoutInflater.from(this.f26165a.getPageActivity()).inflate(R.layout.ala_game_frs_main_view_layout, (ViewGroup) null);
            this.f26170f = inflate;
            if (this.q) {
                NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.view_navigation_bar);
                this.D = navigationBar;
                navigationBar.setVisibility(0);
                this.D.onChangeSkinType(this.f26165a, TbadkCoreApplication.getInst().getSkinType());
                this.D.showBottomLine(true);
                this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            this.f26171g = this.f26170f.findViewById(R.id.frs_game_live_topinfo);
            this.f26172h = (TextView) this.f26170f.findViewById(R.id.frs_game_live_num);
            this.f26173i = (TextView) this.f26170f.findViewById(R.id.frs_game_live_sort);
            BdTypeMultiColumnListView bdTypeMultiColumnListView = (BdTypeMultiColumnListView) this.f26170f.findViewById(R.id.listView);
            this.f26174j = bdTypeMultiColumnListView;
            bdTypeMultiColumnListView.setColumnDiv((int) this.f26165a.getResources().getDimension(R.dimen.ds16));
            this.t = (NoNetworkView) this.f26170f.findViewById(R.id.vNoNetwork);
            c.a.q0.s.f0.g gVar = new c.a.q0.s.f0.g(this.f26165a);
            this.r = gVar;
            gVar.V(this.f26169e);
            this.f26174j.setPullRefresh(this.r);
            PbListView pbListView = new PbListView(this.f26165a.getPageActivity());
            this.s = pbListView;
            pbListView.a();
            this.B = new c.a.r0.w.g.a.d(this.f26165a, this.f26174j);
            this.f26173i.setOnClickListener(new b(this));
            if (this.f26168d) {
                this.C = new c.a.r0.x0.x1.b(this.f26165a.getPageActivity(), this.f26169e, this.f26168d);
                this.f26174j.setOnTouchListener(new View$OnTouchListenerC1217c(this));
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
            if (this.f26166b != i2) {
                this.f26166b = i2;
            }
            NavigationBar navigationBar = this.D;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f26165a, i2);
            }
            NavigationBar navigationBar2 = this.D;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.f26165a, i2);
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            SkinManager.setViewTextColor(this.f26172h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f26173i, R.color.CAM_X0109);
            this.f26174j.setContentBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.f26173i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
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
            c.a.e.e.m.g.d(this.k, this.f26165a.getPageActivity());
            c.a.r0.w.g.c.d dVar = this.f26167c;
            if (dVar != null) {
                dVar.a(i2);
            }
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || this.f26172h == null) {
            return;
        }
        this.f26172h.setText(this.f26165a.getResources().getString(R.string.frs_game_live_num, StringHelper.numberUniformFormatExtra(i2)));
        if (i2 <= 1) {
            this.f26173i.setVisibility(8);
        } else {
            this.f26173i.setVisibility(0);
        }
    }

    public void u(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 == 1) {
                TextView textView2 = this.f26173i;
                if (textView2 != null) {
                    textView2.setText(this.f26165a.getString(R.string.frs_game_live_sort_hot));
                }
            } else if (i2 != 2 || (textView = this.f26173i) == null) {
            } else {
                textView.setText(this.f26165a.getString(R.string.frs_game_live_sort_new));
            }
        }
    }

    public void v(c.a.r0.w.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, eVar) == null) {
            this.B.b(eVar);
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
                this.f26171g.setVisibility(8);
                View view = this.u;
                if (view != null) {
                    this.f26174j.removeHeaderView(view);
                    this.f26174j.addHeaderView(this.u);
                }
                this.B.c(list);
                this.f26174j.setNextPage(null);
                return;
            }
            View view2 = this.u;
            if (view2 != null) {
                this.f26174j.removeHeaderView(view2);
            }
            if (list.size() == 0) {
                this.f26171g.setVisibility(8);
                this.B.c(list);
                this.f26174j.setNextPage(null);
                return;
            }
            this.f26171g.setVisibility(0);
            this.B.c(list);
            if (z) {
                A();
            } else {
                C();
            }
        }
    }

    public void x(c.a.r0.w.g.c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            this.f26167c = dVar;
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
            this.f26174j.setOnSrollToBottomListener(onScrollToBottomListener);
            this.s.z(new h(this, onScrollToBottomListener));
        }
    }
}
