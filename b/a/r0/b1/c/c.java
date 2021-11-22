package b.a.r0.b1.c;

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
import b.a.e.a.d;
import b.a.e.a.f;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import b.a.r0.b1.c.a;
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
/* loaded from: classes4.dex */
public class c extends d<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public AdapterView.OnItemClickListener C;
    public View.OnClickListener D;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f16457a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f16458b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f16459c;

    /* renamed from: d  reason: collision with root package name */
    public h f16460d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f16461e;

    /* renamed from: f  reason: collision with root package name */
    public View f16462f;

    /* renamed from: g  reason: collision with root package name */
    public View f16463g;

    /* renamed from: h  reason: collision with root package name */
    public View f16464h;

    /* renamed from: i  reason: collision with root package name */
    public View f16465i;
    public View j;
    public g k;
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
    public b.a.r0.b1.c.b v;
    public boolean w;
    public String x;
    public LinearLayout y;
    public View z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16466e;

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
            this.f16466e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16466e.m();
                this.f16466e.u();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16467e;

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
            this.f16467e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            a.C0818a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f16467e.v.getItem(i2)) == null || item.f16428a <= 0 || StringUtils.isNull(item.f16429b)) {
                return;
            }
            if (this.f16467e.w) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f16467e.f16457a.getPageContext().getPageActivity(), item.f16428a, item.f16429b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                this.f16467e.f16457a.showToast(R.string.neterror);
            } else {
                this.f16467e.f16457a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f16428a), item.f16429b)));
            }
        }
    }

    /* renamed from: b.a.r0.b1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0820c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16468e;

        public View$OnClickListenerC0820c(c cVar) {
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
            this.f16468e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view != this.f16468e.o) {
                if (view != this.f16468e.s || StringUtils.isNull(this.f16468e.x)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f16468e.f16457a.getPageContext(), new String[]{this.f16468e.x});
            } else if (l.D()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f16468e.f16457a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(this.f16468e.f16457a.getPageContext().getPageActivity(), this.f16468e.f16457a.getResources().getString(R.string.neterror));
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
        this.k = null;
        this.C = new b(this);
        this.D = new View$OnClickListenerC0820c(this);
        this.f16457a = myGiftListActivity;
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
            this.f16459c.addNetworkChangeListener(bVar);
        }
    }

    public final SpannableString j(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i2);
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
            if (i3 == 2) {
                drawable.setBounds(0, 3, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
            } else {
                drawable.setBounds(0, 0, g2, g2);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            b.a.q0.e1.d dVar = new b.a.q0.e1.d(drawable);
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f16457a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.f16457a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.f16457a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16461e.completePullRefreshPostDelayed(0L);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f16460d) == null) {
            return;
        }
        hVar.dettachView(this.f16462f);
        this.f16460d = null;
        this.f16461e.setVisibility(0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y = (LinearLayout) this.f16457a.findViewById(R.id.gift_relation_ll);
            this.A = (TextView) this.f16457a.findViewById(R.id.gift_relation_text);
            this.y.setOnClickListener(this.f16457a.getSendGiftClickListener());
            this.z = this.f16457a.findViewById(R.id.gift_send_gift_top_line);
            this.B = (ImageView) this.f16457a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16457a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.f16457a.findViewById(R.id.root);
            this.f16462f = findViewById;
            this.f16461e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f16462f.findViewById(R.id.navigation_bar);
            this.f16458b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.f16457a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.f16457a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.w) {
                    this.f16458b.setCenterTextTitle(this.f16457a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f16458b.setTitleText(format);
                }
            }
            this.f16458b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f16459c = (NoNetworkView) this.f16462f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.f16457a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f16464h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.f16457a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f16463g = inflate2;
            inflate2.setVisibility(8);
            this.u = (LinearLayout) this.f16463g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f16463g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f16463g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f16463g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f16463g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f16463g.findViewById(R.id.textview_blue_number);
            this.r = (TextView) this.f16463g.findViewById(R.id.tv_blue_name);
            this.t = (TextView) this.f16463g.findViewById(R.id.textview_gift_name);
            TextView textView = (TextView) this.f16463g.findViewById(R.id.view_get_blue);
            this.s = textView;
            textView.setOnClickListener(this.D);
            this.o.setOnClickListener(this.D);
            View inflate3 = LayoutInflater.from(this.f16457a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f16465i = inflate3;
            this.j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.w) {
                this.f16461e.addHeaderView(this.f16463g);
            } else {
                if (this.f16457a.userType == 1) {
                    this.f16464h.setVisibility(0);
                    this.f16461e.addHeaderView(this.f16464h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f16465i.setPadding(0, 0, 0, l.g(this.f16457a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f16461e.addFooterView(this.f16465i);
            b.a.r0.b1.c.b bVar = new b.a.r0.b1.c.b(this.f16457a, this.w);
            this.v = bVar;
            this.f16461e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.f16457a.getPageContext());
            this.k = gVar;
            this.f16461e.setPullRefresh(gVar);
            this.f16461e.setOnSrollToBottomListener(this.l);
            this.f16461e.setOnItemClickListener(this.C);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f16457a.getLayoutMode().k(i2 == 1);
            this.f16457a.getLayoutMode().j(this.f16462f);
            this.f16457a.getLayoutMode().j(this.f16463g);
            this.f16457a.getLayoutMode().j(this.f16464h);
            this.f16457a.getLayoutMode().j(this.f16465i);
            this.f16458b.onChangeSkinType(getPageContext(), i2);
            this.f16459c.onChangeSkinType(this.f16457a.getPageContext(), i2);
            this.k.C(i2);
            b.a.r0.b1.c.b bVar = this.v;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0302);
            SkinManager.setImageResource(this.B, R.drawable.icon_gift_list);
            b.a.q0.s.u.c.d(this.p).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.r).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.q).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.t).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.m).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.s).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.o).v(R.color.CAM_X0101);
            b.a.q0.s.u.c.d(this.n).v(R.color.CAM_X0101);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f16463g);
            d2.e(R.string.A_X02);
            d2.f(R.color.CAM_X0310);
        }
    }

    public final void p(b.a.r0.b1.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && this.w) {
                this.f16463g.setVisibility(0);
                String str = aVar.d().f16441b;
                String str2 = aVar.d().f16440a;
                this.x = aVar.f16426g.f14161b;
                this.m.setText(j(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f16427h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f16427h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.q.setText(j(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f16425f), 2));
                this.s.setText(aVar.f16426g.f14160a);
                this.n.setText(j(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f16427h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f16427h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f16463g.setVisibility(8);
        }
    }

    public final void q(b.a.r0.b1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f16438b == 1) {
                        this.f16465i.setVisibility(0);
                    } else {
                        this.f16465i.setVisibility(8);
                    }
                }
                this.v.e(aVar.a(), aVar.f16427h);
                return;
            }
            this.f16465i.setVisibility(8);
            this.y.setVisibility(8);
            this.v.e(null, -1);
        }
    }

    public void r(b.a.r0.b1.c.a aVar) {
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
            this.k.a(gVar);
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.f16460d == null) {
                this.f16460d = new h(this.mContext.getContext(), new a(this));
            }
            this.f16460d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f16460d.attachView(this.f16462f, z);
            this.f16460d.o();
            this.y.setVisibility(8);
            this.f16461e.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f16461e.setVisibility(0);
            this.f16461e.startPullRefresh();
        }
    }
}
