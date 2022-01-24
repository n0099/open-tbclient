package c.a.t0.i1.c;

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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.s0.s.k0.f;
import c.a.s0.s.k0.g;
import c.a.t0.i1.c.a;
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
    public MyGiftListActivity a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18381b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f18382c;

    /* renamed from: d  reason: collision with root package name */
    public h f18383d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f18384e;

    /* renamed from: f  reason: collision with root package name */
    public View f18385f;

    /* renamed from: g  reason: collision with root package name */
    public View f18386g;

    /* renamed from: h  reason: collision with root package name */
    public View f18387h;

    /* renamed from: i  reason: collision with root package name */
    public View f18388i;

    /* renamed from: j  reason: collision with root package name */
    public View f18389j;
    public g k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public c.a.t0.i1.c.b s;
    public boolean t;
    public LinearLayout u;
    public View v;
    public TextView w;
    public ImageView x;
    public AdapterView.OnItemClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18390e;

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
            this.f18390e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18390e.k();
                this.f18390e.s();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18391e;

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
            this.f18391e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            a.C1143a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f18391e.s.getItem(i2)) == null || item.a <= 0 || StringUtils.isNull(item.f18355b)) {
                return;
            }
            if (this.f18391e.t) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f18391e.a.getPageContext().getPageActivity(), item.a, item.f18355b, item.f18362i, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!l.z()) {
                this.f18391e.a.showToast(R.string.neterror);
            } else {
                this.f18391e.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.f18355b)));
            }
        }
    }

    /* renamed from: c.a.t0.i1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1145c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18392e;

        public View$OnClickListenerC1145c(c cVar) {
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
            this.f18392e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && view != null && view == this.f18392e.o) {
                if (n.C()) {
                    CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f18392e.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.showToast(this.f18392e.a.getPageContext().getPageActivity(), this.f18392e.a.getResources().getString(R.string.neterror));
                }
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
        this.y = new b(this);
        this.z = new View$OnClickListenerC1145c(this);
        this.a = myGiftListActivity;
        this.t = z;
        this.l = pVar;
        m();
        l();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f18382c.addNetworkChangeListener(bVar);
        }
    }

    public final SpannableString h(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i2);
            int f2 = n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
            if (i3 == 2) {
                drawable.setBounds(0, 3, f2, n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
            } else {
                drawable.setBounds(0, 0, f2, f2);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            c.a.s0.f1.d dVar = new c.a.s0.f1.d(drawable);
            dVar.c(n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(n.f(this.a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f18384e.completePullRefreshPostDelayed(0L);
        }
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18389j : (View) invokeV.objValue;
    }

    public void k() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f18383d) == null) {
            return;
        }
        hVar.dettachView(this.f18385f);
        this.f18383d = null;
        this.f18384e.setVisibility(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = (LinearLayout) this.a.findViewById(R.id.gift_relation_ll);
            this.w = (TextView) this.a.findViewById(R.id.gift_relation_text);
            this.u.setOnClickListener(this.a.getSendGiftClickListener());
            this.v = this.a.findViewById(R.id.gift_send_gift_top_line);
            this.x = (ImageView) this.a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.a.findViewById(R.id.root);
            this.f18385f = findViewById;
            this.f18384e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f18385f.findViewById(R.id.navigation_bar);
            this.f18381b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.t) {
                    this.f18381b.setCenterTextTitle(this.a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f18381b.setTitleText(format);
                }
            }
            this.f18381b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f18382c = (NoNetworkView) this.f18385f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f18387h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f18386g = inflate2;
            inflate2.setVisibility(8);
            this.r = (LinearLayout) this.f18386g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f18386g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f18386g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f18386g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f18386g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f18386g.findViewById(R.id.textview_gift_name);
            this.o.setOnClickListener(this.z);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f18388i = inflate3;
            this.f18389j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.t) {
                this.f18384e.addHeaderView(this.f18386g);
            } else {
                if (this.a.userType == 1) {
                    this.f18387h.setVisibility(0);
                    this.f18384e.addHeaderView(this.f18387h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f18388i.setPadding(0, 0, 0, n.f(this.a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f18384e.addFooterView(this.f18388i);
            c.a.t0.i1.c.b bVar = new c.a.t0.i1.c.b(this.a, this.t);
            this.s = bVar;
            this.f18384e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.a.getPageContext());
            this.k = gVar;
            this.f18384e.setPullRefresh(gVar);
            this.f18384e.setOnSrollToBottomListener(this.l);
            this.f18384e.setOnItemClickListener(this.y);
        }
    }

    public final void n(c.a.t0.i1.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            if (aVar != null && this.t) {
                this.f18386g.setVisibility(0);
                String str = aVar.d().f18365b;
                String str2 = aVar.d().a;
                String str3 = aVar.f18353g.f13629b;
                this.m.setText(h(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f18354h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f18354h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.n.setText(h(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f18354h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f18354h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f18386g.setVisibility(8);
        }
    }

    public final void o(c.a.t0.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f18363b == 1) {
                        this.f18388i.setVisibility(0);
                    } else {
                        this.f18388i.setVisibility(8);
                    }
                }
                this.s.e(aVar.a(), aVar.f18354h);
                return;
            }
            this.f18388i.setVisibility(8);
            this.u.setVisibility(8);
            this.s.e(null, -1);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.a.getLayoutMode().k(i2 == 1);
            this.a.getLayoutMode().j(this.f18385f);
            this.a.getLayoutMode().j(this.f18386g);
            this.a.getLayoutMode().j(this.f18387h);
            this.a.getLayoutMode().j(this.f18388i);
            this.f18381b.onChangeSkinType(getPageContext(), i2);
            this.f18382c.onChangeSkinType(this.a.getPageContext(), i2);
            this.k.C(i2);
            c.a.t0.i1.c.b bVar = this.s;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.w, R.color.CAM_X0302);
            SkinManager.setImageResource(this.x, R.drawable.icon_gift_list);
            c.a.s0.s.u.c.d(this.p).v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.q).v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.m).v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.o).v(R.color.CAM_X0101);
            c.a.s0.s.u.c.d(this.n).v(R.color.CAM_X0101);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f18386g);
            d2.e(R.string.A_X02);
            d2.f(R.color.CAM_X0310);
        }
    }

    public void p(c.a.t0.i1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (aVar != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.e();
            }
            k();
            n(aVar);
            o(aVar);
        }
    }

    public void q(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.k.a(gVar);
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.f18383d == null) {
                this.f18383d = new h(this.mContext.getContext(), new a(this));
            }
            this.f18383d.k(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f18383d.attachView(this.f18385f, z);
            this.f18383d.p();
            this.u.setVisibility(8);
            this.f18384e.setVisibility(8);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f18384e.setVisibility(0);
            this.f18384e.startPullRefresh();
        }
    }
}
