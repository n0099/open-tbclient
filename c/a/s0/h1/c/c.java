package c.a.s0.h1.c;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.d;
import c.a.d.a.f;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.r0.g0.h;
import c.a.r0.s.i0.f;
import c.a.r0.s.i0.g;
import c.a.s0.h1.c.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends d<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public AdapterView.OnItemClickListener C;
    public View.OnClickListener D;
    public MyGiftListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18023b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f18024c;

    /* renamed from: d  reason: collision with root package name */
    public h f18025d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f18026e;

    /* renamed from: f  reason: collision with root package name */
    public View f18027f;

    /* renamed from: g  reason: collision with root package name */
    public View f18028g;

    /* renamed from: h  reason: collision with root package name */
    public View f18029h;

    /* renamed from: i  reason: collision with root package name */
    public View f18030i;

    /* renamed from: j  reason: collision with root package name */
    public View f18031j;

    /* renamed from: k  reason: collision with root package name */
    public g f18032k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public c.a.s0.h1.c.b v;
    public boolean w;
    public String x;
    public LinearLayout y;
    public View z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18033e;

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
            this.f18033e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18033e.m();
                this.f18033e.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18034e;

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
            this.f18034e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            a.C1086a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f18034e.v.getItem(i2)) == null || item.a <= 0 || StringUtils.isNull(item.f17992b)) {
                return;
            }
            if (this.f18034e.w) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f18034e.a.getPageContext().getPageActivity(), item.a, item.f17992b, item.f18001k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!k.z()) {
                this.f18034e.a.showToast(R.string.neterror);
            } else {
                this.f18034e.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.f17992b)));
            }
        }
    }

    /* renamed from: c.a.s0.h1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1088c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18035e;

        public View$OnClickListenerC1088c(c cVar) {
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
            this.f18035e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view != this.f18035e.o) {
                if (view != this.f18035e.s || StringUtils.isNull(this.f18035e.x)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f18035e.a.getPageContext(), new String[]{this.f18035e.x});
            } else if (m.C()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f18035e.a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(this.f18035e.a.getPageContext().getPageActivity(), this.f18035e.a.getResources().getString(R.string.neterror));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, pVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18032k = null;
        this.C = new b(this);
        this.D = new View$OnClickListenerC1088c(this);
        this.a = myGiftListActivity;
        this.w = z;
        this.l = pVar;
        o();
        n();
        if (!this.w && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f18024c.addNetworkChangeListener(bVar);
        }
    }

    public final SpannableString j(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i2);
            int f2 = m.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
            if (i3 == 2) {
                drawable.setBounds(0, 3, f2, m.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
            } else {
                drawable.setBounds(0, 0, f2, f2);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            c.a.r0.f1.d dVar = new c.a.r0.f1.d(drawable);
            dVar.c(m.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(m.f(this.a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18026e.completePullRefreshPostDelayed(0L);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18031j : (View) invokeV.objValue;
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f18025d) == null) {
            return;
        }
        hVar.dettachView(this.f18027f);
        this.f18025d = null;
        this.f18026e.setVisibility(0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y = (LinearLayout) this.a.findViewById(R.id.gift_relation_ll);
            this.A = (TextView) this.a.findViewById(R.id.gift_relation_text);
            this.y.setOnClickListener(this.a.getSendGiftClickListener());
            this.z = this.a.findViewById(R.id.gift_send_gift_top_line);
            this.B = (ImageView) this.a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.a.findViewById(R.id.root);
            this.f18027f = findViewById;
            this.f18026e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f18027f.findViewById(R.id.navigation_bar);
            this.f18023b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.w) {
                    this.f18023b.setCenterTextTitle(this.a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f18023b.setTitleText(format);
                }
            }
            this.f18023b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18024c = (NoNetworkView) this.f18027f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f18029h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f18028g = inflate2;
            inflate2.setVisibility(8);
            this.u = (LinearLayout) this.f18028g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f18028g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f18028g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f18028g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f18028g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f18028g.findViewById(R.id.textview_blue_number);
            this.r = (TextView) this.f18028g.findViewById(R.id.tv_blue_name);
            this.t = (TextView) this.f18028g.findViewById(R.id.textview_gift_name);
            TextView textView = (TextView) this.f18028g.findViewById(R.id.view_get_blue);
            this.s = textView;
            textView.setOnClickListener(this.D);
            this.o.setOnClickListener(this.D);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f18030i = inflate3;
            this.f18031j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.w) {
                this.f18026e.addHeaderView(this.f18028g);
            } else {
                if (this.a.userType == 1) {
                    this.f18029h.setVisibility(0);
                    this.f18026e.addHeaderView(this.f18029h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f18030i.setPadding(0, 0, 0, m.f(this.a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f18026e.addFooterView(this.f18030i);
            c.a.s0.h1.c.b bVar = new c.a.s0.h1.c.b(this.a, this.w);
            this.v = bVar;
            this.f18026e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.a.getPageContext());
            this.f18032k = gVar;
            this.f18026e.setPullRefresh(gVar);
            this.f18026e.setOnSrollToBottomListener(this.l);
            this.f18026e.setOnItemClickListener(this.C);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f18027f);
            this.a.getLayoutMode().j(this.f18028g);
            this.a.getLayoutMode().j(this.f18029h);
            this.a.getLayoutMode().j(this.f18030i);
            this.f18023b.onChangeSkinType(getPageContext(), i2);
            this.f18024c.onChangeSkinType(this.a.getPageContext(), i2);
            this.f18032k.C(i2);
            c.a.s0.h1.c.b bVar = this.v;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0302);
            SkinManager.setImageResource(this.B, R.drawable.icon_gift_list);
            c.a.r0.s.v.c.d(this.p).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.r).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.q).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.t).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.m).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.s).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.o).v(R.color.CAM_X0101);
            c.a.r0.s.v.c.d(this.n).v(R.color.CAM_X0101);
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f18028g);
            d2.e(R.string.A_X02);
            d2.f(R.color.CAM_X0310);
        }
    }

    public final void p(c.a.s0.h1.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && this.w) {
                this.f18028g.setVisibility(0);
                String str = aVar.d().f18004b;
                String str2 = aVar.d().a;
                this.x = aVar.f17990g.f13381b;
                this.m.setText(j(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f17991h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f17991h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.q.setText(j(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f17989f), 2));
                this.s.setText(aVar.f17990g.a);
                this.n.setText(j(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f17991h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f17991h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f18028g.setVisibility(8);
        }
    }

    public final void q(c.a.s0.h1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f18002b == 1) {
                        this.f18030i.setVisibility(0);
                    } else {
                        this.f18030i.setVisibility(8);
                    }
                }
                this.v.e(aVar.a(), aVar.f17991h);
                return;
            }
            this.f18030i.setVisibility(8);
            this.y.setVisibility(8);
            this.v.e(null, -1);
        }
    }

    public void r(c.a.s0.h1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (!this.w && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
            }
            if (aVar != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.e();
            }
            m();
            p(aVar);
            q(aVar);
        }
    }

    public void s(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.f18032k.a(gVar);
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.f18025d == null) {
                this.f18025d = new h(this.mContext.getContext(), new a(this));
            }
            this.f18025d.k(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f18025d.attachView(this.f18027f, z);
            this.f18025d.p();
            this.y.setVisibility(8);
            this.f18026e.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f18026e.setVisibility(0);
            this.f18026e.startPullRefresh();
        }
    }
}
