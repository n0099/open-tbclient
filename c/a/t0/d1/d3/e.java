package c.a.t0.d1.d3;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.d.n.e.w;
import c.a.s0.s.q.e2;
import c.a.s0.s.s.a;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.n4.h;
import c.a.t0.w3.k;
import c.a.t0.w3.l0.a;
import c.a.t0.w3.p;
import c.a.t0.w3.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends BaseAdapter implements c.a.t0.d1.w2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f15999e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16000f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f16001g;

    /* renamed from: h  reason: collision with root package name */
    public String f16002h;

    /* renamed from: i  reason: collision with root package name */
    public String f16003i;

    /* renamed from: j  reason: collision with root package name */
    public UserData f16004j;
    public w k;
    public int l;
    public String m;
    public HashSet<String> n;
    public boolean o;
    public c.a.t0.d1.w2.b p;
    public final View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16005e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16005e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1027e c1027e;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f16005e.f16000f == null || ViewHelper.checkUpIsLogin(this.f16005e.f16000f)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof C1027e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof C1027e) && (textView = (c1027e = (C1027e) view.getTag()).f16013c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) c1027e.f16013c.getTag();
                        }
                        if (kVar != null && kVar.k() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i2 = kVar.i();
                            if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                c.a.d.f.p.n.M(this.f16005e.f16000f, i1.book_plugin_not_install_tip);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.f16005e.f16001g, new String[]{i2});
                            a.b b2 = c.a.t0.w3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.d(), this.f16005e.f16002h, this.f16005e.f16003i, null);
                            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.e();
                        } else if (kVar == null || kVar.k() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.f16005e.f16002h).eventStat();
                            if (this.f16005e.f16001g == null || TextUtils.isEmpty(this.f16005e.f16002h)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f16005e.f16001g.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.f16005e.f16002h, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16006e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16006e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1027e c1027e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.f16006e.k == null || !(view.getTag() instanceof C1027e) || (c1027e = (C1027e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.f16006e.f15999e, c1027e.a);
                if (nVar instanceof e2) {
                    e2 e2Var = (e2) nVar;
                    this.f16006e.k.b(view, e2Var, BdUniqueId.gen(), null, this.f16006e.o ? c1027e.a + 1 : c1027e.a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", e2Var.U()).param("tid", e2Var.v1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1027e.a + 1));
                } else if (nVar instanceof q) {
                    this.f16006e.k.b(view, (q) nVar, BdUniqueId.gen(), null, c1027e.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f16007e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16008f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16009g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f16010h;

        public c(e eVar, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16010h = eVar;
            this.f16007e = fVar;
            this.f16008f = str;
            this.f16009g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16007e.f16013c.getLayout().getEllipsisCount(this.f16007e.f16013c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f16010h.x(this.f16008f, this.f16009g);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f16011e;

        public d(e eVar, c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16011e = aVar;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16011e.dismiss();
            }
        }
    }

    /* renamed from: c.a.t0.d1.d3.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1027e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f16012b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16013c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16014d;

        public C1027e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends C1027e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16015e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends C1027e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16016e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f16017f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16002h = "";
        this.f16003i = "";
        this.l = SkinManager.getColor(c1.CAM_X0302);
        this.m = "";
        this.n = new HashSet<>();
        this.p = new c.a.t0.d1.w2.b();
        this.q = new a(this);
        this.r = new b(this);
        this.f16000f = context;
        this.f16001g = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f15999e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f15999e, i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 1) {
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    gVar = new g(this);
                    view = LayoutInflater.from(this.f16000f).inflate(g1.frs_header_top_item_single, (ViewGroup) null, false);
                    gVar.f16012b = view;
                    gVar.f16016e = (TbImageView) view.findViewById(f1.frs_header_top_item_image);
                    gVar.f16013c = (TextView) view.findViewById(f1.frs_header_top_item_title);
                    gVar.f16014d = (TextView) view.findViewById(f1.top_item_type);
                    gVar.f16017f = (TextView) view.findViewById(f1.top_item_rank);
                    view.setTag(gVar);
                }
                m(gVar, (n) ListUtils.getItem(this.f15999e, i2));
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f16000f).inflate(g1.frs_header_top_item_double, (ViewGroup) null, false);
                    fVar.f16012b = view;
                    fVar.f16014d = (TextView) view.findViewById(f1.top_item_type);
                    fVar.f16013c = (TextView) view.findViewById(f1.top_item_title);
                    fVar.f16015e = (TextView) view.findViewById(f1.top_item_rank);
                    view.setTag(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.f15999e, i2);
                if (nVar instanceof e2) {
                    i(fVar, (e2) nVar, i2);
                    fVar.a = i2;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof p) {
                    y((p) nVar, fVar, i2);
                } else if (nVar instanceof q) {
                    fVar.a = i2;
                    l(fVar, (q) nVar, i2);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(C1027e c1027e) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c1027e) == null) || c1027e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1027e.f16013c, c1.CAM_X0105);
        SkinManager.setViewTextColor(c1027e.f16014d, c1.CAM_X0101);
    }

    public final void i(f fVar, e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, e2Var, i2) == null) || fVar == null || e2Var == null) {
            return;
        }
        fVar.f16014d.setText(TbadkCoreApplication.getInst().getString(i1.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(c.a.d.f.p.n.f(this.f16000f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f16014d);
        e2Var.f3();
        SpannableStringBuilder i1 = e2Var.i1();
        if ((i1 == null || m.isEmptyStringAfterTrim(i1.toString())) && e2Var.p() != null) {
            i1 = new SpannableStringBuilder(e2Var.p());
            TiePlusEventController.tryExposeTiePlusLinkEvent(e2Var.w1());
        }
        fVar.f16013c.setOnTouchListener(new h(i1));
        fVar.f16013c.setText(i1);
        fVar.f16012b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // c.a.t0.d1.w2.d
    public c.a.t0.d1.w2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (c.a.t0.d1.w2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f16013c.setText(kVar.g());
            fVar.f16014d.setText(o);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(c.a.d.f.p.n.f(this.f16000f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f16014d);
            if (kVar.e() != 0) {
                fVar.f16015e.setVisibility(0);
                if (kVar.e() == -1) {
                    fVar.f16015e.setText(this.f16000f.getString(i1.no_rank));
                } else if (kVar.e() > 999) {
                    fVar.f16015e.setText(this.f16000f.getString(i1.rang_orer_thousand));
                } else {
                    TextView textView = fVar.f16015e;
                    textView.setText(this.f16000f.getString(i1.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    fVar.f16013c.setText(kVar.g());
                }
            } else {
                fVar.f16015e.setVisibility(8);
            }
            h(fVar);
            fVar.f16013c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                fVar.f16012b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = c.a.t0.w3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f16002h, this.f16003i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public final void l(f fVar, q qVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, qVar, i2) == null) || fVar == null || qVar == null || qVar.a() == null || this.f16004j == null) {
            return;
        }
        fVar.f16014d.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(c.a.d.f.p.n.f(this.f16000f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f16014d);
        if (this.f16004j.getIs_manager() == 1) {
            if (qVar.a().audit_status.intValue() == 0 && qVar.a().has_forum_rule.intValue() == 0) {
                fVar.f16013c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_none));
            } else if (qVar.a().audit_status.intValue() == 0) {
                fVar.f16013c.setText(qVar.a().title);
            } else if (qVar.a().audit_status.intValue() == 1) {
                fVar.f16013c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_chenking));
            } else if (qVar.a().audit_status.intValue() == 2) {
                fVar.f16013c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f16013c.setText(qVar.a().title);
        }
        fVar.f16012b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nVar) == null) || gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof e2) {
            e2 e2Var = (e2) nVar;
            e2Var.f3();
            SpannableStringBuilder i1 = e2Var.i1();
            if ((i1 == null || m.isEmptyStringAfterTrim(i1.toString())) && e2Var.p() != null) {
                i1 = new SpannableStringBuilder(e2Var.p());
                TiePlusEventController.tryExposeTiePlusLinkEvent(e2Var.w1());
            }
            gVar.f16014d.setText(TbadkCoreApplication.getInst().getString(i1.top));
            gVar.f16013c.setOnTouchListener(new h(i1));
            gVar.f16013c.setText(i1);
            if (StringUtils.isNull(this.m)) {
                gVar.f16016e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f16014d.getLayoutParams();
                layoutParams.setMargins((int) this.f16000f.getResources().getDimension(d1.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f16016e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f16014d.getLayoutParams();
                layoutParams2.setMargins((int) this.f16000f.getResources().getDimension(d1.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f16016e.startLoad(this.m, 10, false);
            }
            gVar.f16014d.setTextColor(this.l);
            gVar.f16012b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f16014d.setText(o);
                gVar.f16014d.setVisibility(0);
                gVar.f16013c.setText(kVar.g());
                gVar.f16016e.setVisibility(8);
            } else {
                gVar.f16014d.setVisibility(8);
                gVar.f16016e.setVisibility(0);
                TextView textView = gVar.f16013c;
                textView.setText(o + "：" + kVar.g());
                gVar.f16016e.startLoad(this.m, 10, false);
            }
            if (kVar.e() != 0) {
                gVar.f16017f.setVisibility(0);
                if (kVar.e() == -1) {
                    gVar.f16017f.setText(this.f16000f.getString(i1.no_rank));
                } else if (kVar.e() > 999) {
                    gVar.f16017f.setText(this.f16000f.getString(i1.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f16017f;
                    textView2.setText(this.f16000f.getString(i1.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f16013c.setText(kVar.g());
                }
            } else {
                gVar.f16017f.setVisibility(8);
            }
            gVar.f16014d.setTextColor(this.l);
            h(gVar);
            gVar.f16013c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f16012b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = c.a.t0.w3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f16002h, this.f16003i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15999e : (List) invokeV.objValue;
    }

    public final String o(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, kVar)) == null) {
            if (!TextUtils.isEmpty(kVar.h()) && kVar.h().trim().length() != 0) {
                return kVar.h();
            }
            if (kVar.a() == 1) {
                return TbadkCoreApplication.getInst().getString(i1.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(i1.top_announcement);
        }
        return (String) invokeL.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.f16000f;
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
        }
    }

    public void r(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f15999e = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f16002h = str;
            this.f16003i = str2;
            this.f16004j = userData;
        }
    }

    public void t(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumData) == null) {
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.m = str;
        }
    }

    public void v(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wVar) == null) {
            this.k = wVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || m.isEmpty(str) || m.isEmpty(str2)) {
            return;
        }
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a((BaseFragmentActivity) this.f16000f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(i1.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(p pVar, f fVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, pVar, fVar, i2)) == null) {
            if (i2 != 0 || pVar == null || pVar.a() == null) {
                return false;
            }
            ForumData a2 = pVar.a();
            boolean z = pVar.d() && !ListUtils.isEmpty(a2.getTipInfos());
            String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
            String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
            String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.f16014d.setText(TbadkCoreApplication.getInst().getString(i1.risk_notice_title));
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(c.a.d.f.p.n.f(this.f16000f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f16014d);
            fVar.f16013c.setText(riskTipNotice);
            fVar.f16013c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
