package c.a.r0.b1.c;

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
import c.a.e.a.d;
import c.a.e.a.f;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.g0.h;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.r0.b1.c.a;
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
/* loaded from: classes3.dex */
public class c extends d<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public ImageView B;
    public AdapterView.OnItemClickListener C;
    public View.OnClickListener D;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f15948a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f15949b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f15950c;

    /* renamed from: d  reason: collision with root package name */
    public h f15951d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f15952e;

    /* renamed from: f  reason: collision with root package name */
    public View f15953f;

    /* renamed from: g  reason: collision with root package name */
    public View f15954g;

    /* renamed from: h  reason: collision with root package name */
    public View f15955h;

    /* renamed from: i  reason: collision with root package name */
    public View f15956i;

    /* renamed from: j  reason: collision with root package name */
    public View f15957j;
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
    public c.a.r0.b1.c.b v;
    public boolean w;
    public String x;
    public LinearLayout y;
    public View z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15958e;

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
            this.f15958e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f15958e.m();
                this.f15958e.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15959e;

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
            this.f15959e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            a.C0759a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.f15959e.v.getItem(i2)) == null || item.f15916a <= 0 || StringUtils.isNull(item.f15917b)) {
                return;
            }
            if (this.f15959e.w) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f15959e.f15948a.getPageContext().getPageActivity(), item.f15916a, item.f15917b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                this.f15959e.f15948a.showToast(R.string.neterror);
            } else {
                this.f15959e.f15948a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f15916a), item.f15917b)));
            }
        }
    }

    /* renamed from: c.a.r0.b1.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0761c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15960e;

        public View$OnClickListenerC0761c(c cVar) {
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
            this.f15960e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view != this.f15960e.o) {
                if (view != this.f15960e.s || StringUtils.isNull(this.f15960e.x)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f15960e.f15948a.getPageContext(), new String[]{this.f15960e.x});
            } else if (l.D()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f15960e.f15948a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(this.f15960e.f15948a.getPageContext().getPageActivity(), this.f15960e.f15948a.getResources().getString(R.string.neterror));
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
        this.D = new View$OnClickListenerC0761c(this);
        this.f15948a = myGiftListActivity;
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
            this.f15950c.addNetworkChangeListener(bVar);
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
            c.a.q0.f1.d dVar = new c.a.q0.f1.d(drawable);
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f15948a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.f15948a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.f15948a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f15952e.completePullRefreshPostDelayed(0L);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15957j : (View) invokeV.objValue;
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f15951d) == null) {
            return;
        }
        hVar.dettachView(this.f15953f);
        this.f15951d = null;
        this.f15952e.setVisibility(0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y = (LinearLayout) this.f15948a.findViewById(R.id.gift_relation_ll);
            this.A = (TextView) this.f15948a.findViewById(R.id.gift_relation_text);
            this.y.setOnClickListener(this.f15948a.getSendGiftClickListener());
            this.z = this.f15948a.findViewById(R.id.gift_send_gift_top_line);
            this.B = (ImageView) this.f15948a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15948a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.f15948a.findViewById(R.id.root);
            this.f15953f = findViewById;
            this.f15952e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f15953f.findViewById(R.id.navigation_bar);
            this.f15949b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.f15948a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.f15948a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.w) {
                    this.f15949b.setCenterTextTitle(this.f15948a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f15949b.setTitleText(format);
                }
            }
            this.f15949b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f15950c = (NoNetworkView) this.f15953f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.f15948a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f15955h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.f15948a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f15954g = inflate2;
            inflate2.setVisibility(8);
            this.u = (LinearLayout) this.f15954g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f15954g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f15954g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f15954g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f15954g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f15954g.findViewById(R.id.textview_blue_number);
            this.r = (TextView) this.f15954g.findViewById(R.id.tv_blue_name);
            this.t = (TextView) this.f15954g.findViewById(R.id.textview_gift_name);
            TextView textView = (TextView) this.f15954g.findViewById(R.id.view_get_blue);
            this.s = textView;
            textView.setOnClickListener(this.D);
            this.o.setOnClickListener(this.D);
            View inflate3 = LayoutInflater.from(this.f15948a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f15956i = inflate3;
            this.f15957j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.w) {
                this.f15952e.addHeaderView(this.f15954g);
            } else {
                if (this.f15948a.userType == 1) {
                    this.f15955h.setVisibility(0);
                    this.f15952e.addHeaderView(this.f15955h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f15956i.setPadding(0, 0, 0, l.g(this.f15948a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f15952e.addFooterView(this.f15956i);
            c.a.r0.b1.c.b bVar = new c.a.r0.b1.c.b(this.f15948a, this.w);
            this.v = bVar;
            this.f15952e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.f15948a.getPageContext());
            this.k = gVar;
            this.f15952e.setPullRefresh(gVar);
            this.f15952e.setOnSrollToBottomListener(this.l);
            this.f15952e.setOnItemClickListener(this.C);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f15948a.getLayoutMode().k(i2 == 1);
            this.f15948a.getLayoutMode().j(this.f15953f);
            this.f15948a.getLayoutMode().j(this.f15954g);
            this.f15948a.getLayoutMode().j(this.f15955h);
            this.f15948a.getLayoutMode().j(this.f15956i);
            this.f15949b.onChangeSkinType(getPageContext(), i2);
            this.f15950c.onChangeSkinType(this.f15948a.getPageContext(), i2);
            this.k.D(i2);
            c.a.r0.b1.c.b bVar = this.v;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0302);
            SkinManager.setImageResource(this.B, R.drawable.icon_gift_list);
            c.a.q0.s.u.c.d(this.p).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.r).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.q).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.t).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.m).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.s).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.o).v(R.color.CAM_X0101);
            c.a.q0.s.u.c.d(this.n).v(R.color.CAM_X0101);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f15954g);
            d2.e(R.string.A_X02);
            d2.f(R.color.CAM_X0310);
        }
    }

    public final void p(c.a.r0.b1.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && this.w) {
                this.f15954g.setVisibility(0);
                String str = aVar.d().f15930b;
                String str2 = aVar.d().f15929a;
                this.x = aVar.f15914g.f14268b;
                this.m.setText(j(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f15915h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f15915h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.q.setText(j(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f15913f), 2));
                this.s.setText(aVar.f15914g.f14267a);
                this.n.setText(j(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f15915h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f15915h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f15954g.setVisibility(8);
        }
    }

    public final void q(c.a.r0.b1.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f15927b == 1) {
                        this.f15956i.setVisibility(0);
                    } else {
                        this.f15956i.setVisibility(8);
                    }
                }
                this.v.e(aVar.a(), aVar.f15915h);
                return;
            }
            this.f15956i.setVisibility(8);
            this.y.setVisibility(8);
            this.v.e(null, -1);
        }
    }

    public void r(c.a.r0.b1.c.a aVar) {
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
            if (this.f15951d == null) {
                this.f15951d = new h(this.mContext.getContext(), new a(this));
            }
            this.f15951d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f15951d.attachView(this.f15953f, z);
            this.f15951d.o();
            this.y.setVisibility(8);
            this.f15952e.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f15952e.setVisibility(0);
            this.f15952e.startPullRefresh();
        }
    }
}
