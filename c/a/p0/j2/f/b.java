package c.a.p0.j2.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.j2.f.f;
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
import com.baidu.tbadk.util.PageDialogHelper$PayForm;
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
/* loaded from: classes2.dex */
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
    public View f15715b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f15716c;

    /* renamed from: d  reason: collision with root package name */
    public HListView f15717d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f15718e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15719f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15720g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f15721h;
    public LinearLayout i;
    public TextView j;
    public NoNetworkView k;
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

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.d
        public void a(AdapterView<?> adapterView, View view, int i, long j) {
            f.d item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.m.getItem(i)) == null) {
                return;
            }
            item.m = true;
            this.a.m.g(item);
            this.a.u(item.n);
            this.a.x(item.j);
        }
    }

    /* renamed from: c.a.p0.j2.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1181b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public View$OnClickListenerC1181b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int i = 0;
                if (view == this.a.j) {
                    this.a.l();
                    int i2 = 2;
                    if (this.a.x != 1) {
                        int unused = this.a.x;
                        i2 = 1;
                    }
                    f.d b2 = this.a.m.b();
                    if (b2 != null && b2.n != 1) {
                        long j = b2.l;
                        if (j == 1) {
                            i = 1;
                        } else if (j == 3) {
                            i = 3;
                        } else if (j == 6) {
                            i = 6;
                        } else if (j == 12) {
                            i = 12;
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c13200").param("obj_type", i2).param("obj_locate", i));
                } else if (view != this.a.f15718e) {
                    if (view == this.a.f15720g) {
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{b.F});
                    }
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{b.G});
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(251461024, "Lc/a/p0/j2/f/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(251461024, "Lc/a/p0/j2/f/b;");
        }
    }

    public b(TbPageContext tbPageContext, View view, int i, String str, String str2, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, Integer.valueOf(i), str, str2, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = 2;
        this.C = Boolean.FALSE;
        this.D = new a(this);
        this.E = new View$OnClickListenerC1181b(this);
        this.f15715b = view;
        this.a = tbPageContext;
        this.x = i;
        this.C = Boolean.valueOf(z);
        this.z = str;
        this.A = str2;
        this.B = i2;
        o();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f.d b2 = this.m.b();
            if (b2 == null) {
                n.M(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f1365);
            } else if (b2.n == 1 && b2.o) {
                n.M(this.a.getPageActivity(), R.string.obfuscated_res_0x7f0f13df);
            } else {
                t(b2.i, b2.j / 100, b2.l, b2.n);
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
        f.b bVar = fVar.f15736b;
        this.q = bVar;
        f.g gVar = fVar.a;
        this.p = gVar;
        if (bVar == null || gVar == null || (eVar = gVar.f15755c) == null) {
            return;
        }
        this.y = eVar.a;
        f.a aVar = bVar.f15741b;
        this.s = aVar;
        if (aVar != null) {
            this.t = aVar.f15738c;
        }
        f.c cVar = this.q.a;
        this.r = cVar;
        if (cVar != null) {
            this.u = cVar.f15743c;
        }
    }

    public final ArrayList<d> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList<d> arrayList = new ArrayList<>();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = this.x;
            Integer valueOf = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080621);
            Integer valueOf2 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061f);
            Integer valueOf3 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080620);
            Integer valueOf4 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061b);
            Integer valueOf5 = Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061d);
            if (i == 1) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aae), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aac), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aaa), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aaf), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aad), valueOf);
            } else if (i == 2) {
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aae), valueOf5);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aac), valueOf4);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aa6), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080618));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aa5), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080617));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aa9), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061a));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aab), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080619));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aaa), valueOf3);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aaf), valueOf2);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aa7), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061e));
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aad), valueOf);
                linkedHashMap.put(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0aa8), Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08061c));
            }
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                d dVar = new d();
                dVar.f15733b = (String) entry.getKey();
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
            this.f15716c = (RelativeLayout) this.f15715b.findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.f15717d = (HListView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f0918eb);
            this.i = (LinearLayout) this.f15715b.findViewById(R.id.obfuscated_res_0x7f091a41);
            this.f15718e = (ImageView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f091a42);
            this.f15719f = (TextView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f091913);
            this.f15720g = (TextView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f09190c);
            this.f15721h = (GridView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f091902);
            this.k = (NoNetworkView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f0923d1);
            this.j = (TextView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f0913dd);
            this.l = (TextView) this.f15715b.findViewById(R.id.obfuscated_res_0x7f0921d2);
            this.f15717d.setBackgroundResource(R.drawable.obfuscated_res_0x7f081200);
            this.f15717d.setOnItemClickListener(this.D);
            this.f15717d.setSelector(this.a.getPageActivity().getResources().getDrawable(R.drawable.obfuscated_res_0x7f081200));
            this.f15721h.setVerticalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds58));
            this.f15721h.setHorizontalSpacing(this.a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds108));
            this.j.setOnClickListener(this.E);
            this.f15718e.setOnClickListener(this.E);
            this.f15720g.setOnClickListener(this.E);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.k.c(this.a, i);
            SkinManager.setBackgroundColor(this.f15716c, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f15719f, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f15720g, (int) R.color.CAM_X0107);
            this.f15720g.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_tbvip_arrow_right), (Drawable) null);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setBackgroundResource(this.j, R.drawable.member_price_btn_bg);
            SkinManager.setImageResource(this.f15718e, R.drawable.icon_tbvip_attention);
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
        for (int i = 0; i < list2.size(); i++) {
            f.d dVar = list2.get(i);
            if (dVar != null && dVar.j >= 0 && dVar.n == 1) {
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
                this.f15716c.setVisibility(8);
            } else if (this.q != null && (gVar = this.p) != null) {
                if (gVar.f15755c == null) {
                    this.f15716c.setVisibility(8);
                } else if (this.s == null && this.r == null) {
                    this.f15716c.setVisibility(8);
                } else if (this.x == 2 && ((aVar = this.s) == null || ListUtils.isEmpty(aVar.a))) {
                    this.f15716c.setVisibility(8);
                } else {
                    this.f15716c.setVisibility(0);
                    v();
                    w();
                    y();
                }
            } else {
                this.f15716c.setVisibility(8);
            }
        }
    }

    public void s(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            if (fVar == null) {
                this.f15716c.setVisibility(8);
                return;
            }
            this.o = fVar;
            m();
            r();
        }
    }

    public final void t(long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            PayConfig payConfig = new PayConfig(1, "0", String.valueOf(j), String.valueOf(j2), String.valueOf(j3), true, this.C.booleanValue(), PageDialogHelper$PayForm.NOT_SET, this.z, this.A);
            payConfig.setTitle(this.v);
            payConfig.setOrderName(this.w + this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0aa4, new Object[]{String.valueOf(j3)}));
            payConfig.setAutoPay(i);
            if (this.B == 23) {
                payConfig.paymentPosKey = PayConfig.PAYMENT_POS_KEY_MANGA;
            }
            c.a.o0.q0.e.c().a(payConfig, this.a.getPageActivity());
        }
    }

    public final void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 1) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
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
                    x(dVar.j);
                }
            }
            if (this.m == null) {
                c cVar2 = new c(this.a);
                this.m = cVar2;
                cVar2.d(list);
                this.f15717d.setAdapter((ListAdapter) this.m);
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
            this.f15721h.setAdapter((ListAdapter) this.n);
        }
    }

    public final void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.j.setText(this.a.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f1363, "" + (j / 100)));
        }
    }

    public final void y() {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = this.x;
            if (2 == i) {
                if (this.y == 2) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f042f, new Object[]{this.t});
                } else {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.t});
                }
                this.w = this.t;
            } else if (1 == i) {
                long j = this.y;
                if (j == 1) {
                    string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f042f, new Object[]{this.u});
                } else {
                    string = j == 0 ? this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.u}) : null;
                }
                this.w = this.u;
            } else {
                string = this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0502, new Object[]{this.u});
                this.w = this.u;
            }
            this.v = string;
        }
    }
}
