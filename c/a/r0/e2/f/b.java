package c.a.r0.e2.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.e2.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String F = "https://tieba.baidu.com/tb/vip_eula_mobile.html";
    public static String G = "https://tieba.baidu.com/tb/viprenew_eula_mobile.html";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public int B;
    public Boolean C;
    public AdapterView.d D;
    public View.OnClickListener E;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f16935b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f16936c;

    /* renamed from: d  reason: collision with root package name */
    public HListView f16937d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f16938e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16939f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16940g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f16941h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f16942i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f16943j;

    /* renamed from: k  reason: collision with root package name */
    public NoNetworkView f16944k;
    public TextView l;
    public c m;
    public e n;
    public f o;
    public f.g p;
    public f.b q;
    public f.c r;
    public f.a s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public long y;
    public String z;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i2, long j2) {
            f.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (item = this.a.m.getItem(i2)) == null) {
                return;
            }
            item.m = true;
            this.a.m.g(item);
            this.a.u(item.n);
            this.a.x(item.f16980j);
        }
    }

    /* renamed from: c.a.r0.e2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1014b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16945e;

        public View$OnClickListenerC1014b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16945e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i2 = 0;
                if (view == this.f16945e.f16943j) {
                    this.f16945e.l();
                    int i3 = 2;
                    if (this.f16945e.x != 1) {
                        int unused = this.f16945e.x;
                        i3 = 1;
                    }
                    f.d b2 = this.f16945e.m.b();
                    if (b2 != null && b2.n != 1) {
                        long j2 = b2.l;
                        if (j2 == 1) {
                            i2 = 1;
                        } else if (j2 == 3) {
                            i2 = 3;
                        } else if (j2 == 6) {
                            i2 = 6;
                        } else if (j2 == 12) {
                            i2 = 12;
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i3).param("obj_locate", i2));
                } else if (view != this.f16945e.f16938e) {
                    if (view == this.f16945e.f16940g) {
                        UrlManager.getInstance().dealOneLink(this.f16945e.a, new String[]{b.F});
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(this.f16945e.a, new String[]{b.G});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-284117095, "Lc/a/r0/e2/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-284117095, "Lc/a/r0/e2/f/b;");
        }
    }

    public b(TbPageContext tbPageContext, View view, int i2, String str, String str2, boolean z, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i2), str, str2, Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = 2;
        this.C = Boolean.FALSE;
        this.D = new a(this);
        this.E = new View$OnClickListenerC1014b(this);
        this.f16935b = view;
        this.a = tbPageContext;
        this.x = i2;
        this.C = Boolean.valueOf(z);
        this.z = str;
        this.A = str2;
        this.B = i3;
        o();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.d b2 = this.m.b();
            if (b2 == null) {
                l.L(this.a.getPageActivity(), R.string.tb_member_select_money_tip);
            } else if (b2.n == 1 && b2.o) {
                l.L(this.a.getPageActivity(), R.string.tips_auto_pay_succ);
            } else {
                t(b2.f16979i, b2.f16980j / 100, b2.l, b2.n);
                if (this.B == 26) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.MEMBER_PAY_PAGE_SHOW_PAY_CLICK).param("obj_source", 1));
                }
            }
        }
    }

    public final void m() {
        f fVar;
        f.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.o) == null) {
            return;
        }
        f.b bVar = fVar.f16962b;
        this.q = bVar;
        f.g gVar = fVar.a;
        this.p = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f16984c) == null) {
            return;
        }
        this.y = eVar.a;
        f.a aVar = bVar.f16967b;
        this.s = aVar;
        if (aVar != null) {
            this.t = aVar.f16964c;
        }
        f.c cVar = this.q.a;
        this.r = cVar;
        if (cVar != null) {
            this.u = cVar.f16969c;
        }
    }

    public final ArrayList<d> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<d> arrayList = new ArrayList<>();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = this.x;
            if (i2 == 1) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
            } else if (i2 == 2) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_update_name), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_nickname24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_special_identity), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_member24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_forbid_adv), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_advertising24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_experience_acc), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_accelerate24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_one_key_sign), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_checkin24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_special_bg), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_bg24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_patch_card), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_remedy24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_write_pop), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_qipao24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_forbid_speak), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_notalk24_svg));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_tail), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_tail24_1x));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.member_privilege_more_link), Integer.valueOf(R.drawable.ic_icon_pure_tbvip_morelink26_svg));
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                d dVar = new d();
                dVar.f16958b = (String) entry.getKey();
                dVar.a = ((Integer) entry.getValue()).intValue();
                arrayList.add(dVar);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16936c = (RelativeLayout) this.f16935b.findViewById(R.id.root);
            this.f16937d = (HListView) this.f16935b.findViewById(R.id.price_listview);
            this.f16942i = (LinearLayout) this.f16935b.findViewById(R.id.renew_layout);
            this.f16938e = (ImageView) this.f16935b.findViewById(R.id.renew_tip_img);
            this.f16939f = (TextView) this.f16935b.findViewById(R.id.privilege_title);
            this.f16940g = (TextView) this.f16935b.findViewById(R.id.privilege_rule);
            this.f16941h = (GridView) this.f16935b.findViewById(R.id.privilege_container);
            this.f16944k = (NoNetworkView) this.f16935b.findViewById(R.id.view_no_network);
            this.f16943j = (TextView) this.f16935b.findViewById(R.id.member_pay_button);
            this.l = (TextView) this.f16935b.findViewById(R.id.tv_member_auto_pay_cancel_tip);
            this.f16937d.setBackgroundResource(R.drawable.transparent_bg);
            this.f16937d.setOnItemClickListener(this.D);
            this.f16937d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.transparent_bg));
            this.f16941h.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.f16941h.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
            this.f16943j.setOnClickListener(this.E);
            this.f16938e.setOnClickListener(this.E);
            this.f16940g.setOnClickListener(this.E);
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f16944k.onChangeSkinType(this.a, i2);
            SkinManager.setBackgroundColor(this.f16936c, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f16939f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f16940g, R.color.CAM_X0107);
            this.f16940g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
            SkinManager.setViewTextColor(this.f16943j, R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.f16943j, R.drawable.member_price_btn_bg);
            SkinManager.setImageResource(this.f16938e, R.drawable.icon_tbvip_attention);
        }
    }

    public void q(boolean z) {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.o == null) {
            return;
        }
        List<f.d> list2 = null;
        if (2 != this.x ? !((cVar = this.r) == null || (list = cVar.a) == null) : !((aVar = this.s) == null || (list = aVar.a) == null)) {
            list2 = list;
        }
        if (ListUtils.isEmpty(list2)) {
            return;
        }
        for (int i2 = 0; i2 < list2.size(); i2++) {
            f.d dVar = list2.get(i2);
            if (dVar != null && dVar.f16980j >= 0 && dVar.n == 1) {
                dVar.o = z;
                return;
            }
        }
    }

    public final void r() {
        f.g gVar;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.o == null) {
                this.f16936c.setVisibility(8);
            } else if (this.q != null && (gVar = this.p) != null) {
                if (gVar.f16984c == null) {
                    this.f16936c.setVisibility(8);
                } else if (this.s == null && this.r == null) {
                    this.f16936c.setVisibility(8);
                } else if (this.x == 2 && ((aVar = this.s) == null || ListUtils.isEmpty(aVar.a))) {
                    this.f16936c.setVisibility(8);
                } else {
                    this.f16936c.setVisibility(0);
                    v();
                    w();
                    y();
                }
            } else {
                this.f16936c.setVisibility(8);
            }
        }
    }

    public void s(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            if (fVar == null) {
                this.f16936c.setVisibility(8);
                return;
            }
            this.o = fVar;
            m();
            r();
        }
    }

    public final void t(long j2, long j3, long j4, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j2), String.valueOf(j3), String.valueOf(j4), true, this.C.booleanValue(), PageDialogHelper.PayForm.NOT_SET, this.z, this.A);
            payConfig.setTitle(this.v);
            payConfig.setOrderName(this.w + this.a.getPageActivity().getString(R.string.member_month, new Object[]{String.valueOf(j4)}));
            payConfig.setAutoPay(i2);
            if (this.B == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            }
            c.a.q0.q0.d.c().a(payConfig, this.a.getPageActivity());
        }
    }

    public final void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                this.f16942i.setVisibility(0);
            } else {
                this.f16942i.setVisibility(8);
            }
        }
    }

    public final void v() {
        f.c cVar;
        List<f.d> list;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (2 != this.x ? (cVar = this.r) == null || (list = cVar.a) == null : (aVar = this.s) == null || (list = aVar.a) == null) {
                list = null;
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            for (f.d dVar : list) {
                if (dVar.m) {
                    u(dVar.n);
                    x(dVar.f16980j);
                }
            }
            if (this.m == null) {
                c cVar2 = new c(this.a);
                this.m = cVar2;
                cVar2.d(list);
                this.f16937d.setAdapter((ListAdapter) this.m);
            }
            this.m.d(list);
            this.m.notifyDataSetChanged();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.n == null) {
            ArrayList<d> n = n();
            e eVar = new e(this.a.getPageActivity());
            this.n = eVar;
            eVar.c(n);
            this.f16941h.setAdapter((ListAdapter) this.n);
        }
    }

    public final void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f16943j.setText(this.a.getPageActivity().getResources().getString(R.string.tb_member_need_pay_money, "" + (j2 / 100)));
        }
    }

    public final void y() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i2 = this.x;
            if (2 == i2) {
                if (this.y == 2) {
                    string = this.a.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.t});
                } else {
                    string = this.a.getPageActivity().getString(R.string.dredge, new Object[]{this.t});
                }
                this.w = this.t;
            } else if (1 == i2) {
                long j2 = this.y;
                if (j2 == 1) {
                    string = this.a.getPageActivity().getString(R.string.continue_dredge, new Object[]{this.u});
                } else {
                    string = j2 == 0 ? this.a.getPageActivity().getString(R.string.dredge, new Object[]{this.u}) : null;
                }
                this.w = this.u;
            } else {
                string = this.a.getPageActivity().getString(R.string.dredge, new Object[]{this.u});
                this.w = this.u;
            }
            this.v = string;
        }
    }
}
