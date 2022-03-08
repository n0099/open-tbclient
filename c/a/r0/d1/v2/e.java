package c.a.r0.d1.v2;

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
import c.a.d.o.e.n;
import c.a.d.o.e.v;
import c.a.q0.r.r.e2;
import c.a.q0.r.t.a;
import c.a.r0.o4.h;
import c.a.r0.y3.k;
import c.a.r0.y3.m0.a;
import c.a.r0.y3.q;
import c.a.r0.y3.r;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends BaseAdapter implements c.a.r0.d1.o2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f16620e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16621f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f16622g;

    /* renamed from: h  reason: collision with root package name */
    public String f16623h;

    /* renamed from: i  reason: collision with root package name */
    public String f16624i;

    /* renamed from: j  reason: collision with root package name */
    public UserData f16625j;
    public v k;
    public int l;
    public String m;
    public HashSet<String> n;
    public boolean o;
    public c.a.r0.d1.o2.b p;
    public final View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16626e;

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
            this.f16626e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1060e c1060e;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f16626e.f16621f == null || ViewHelper.checkUpIsLogin(this.f16626e.f16621f)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof C1060e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof C1060e) && (textView = (c1060e = (C1060e) view.getTag()).f16634c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) c1060e.f16634c.getTag();
                        }
                        if (kVar != null && kVar.k() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i2 = kVar.i();
                            if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                c.a.d.f.p.n.M(this.f16626e.f16621f, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.f16626e.f16622g, new String[]{i2});
                            a.b b2 = c.a.r0.y3.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.d(), this.f16626e.f16623h, this.f16626e.f16624i, null);
                            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.e();
                        } else if (kVar == null || kVar.k() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.f16626e.f16623h).eventStat();
                            if (this.f16626e.f16622g == null || TextUtils.isEmpty(this.f16626e.f16623h)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f16626e.f16622g.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.f16626e.f16623h, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16627e;

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
            this.f16627e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1060e c1060e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.f16627e.k == null || !(view.getTag() instanceof C1060e) || (c1060e = (C1060e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.f16627e.f16620e, c1060e.a);
                if (nVar instanceof e2) {
                    e2 e2Var = (e2) nVar;
                    this.f16627e.k.b(view, e2Var, BdUniqueId.gen(), null, this.f16627e.o ? c1060e.a + 1 : c1060e.a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", e2Var.U()).param("tid", e2Var.w1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1060e.a + 1));
                } else if (nVar instanceof r) {
                    this.f16627e.k.b(view, (r) nVar, BdUniqueId.gen(), null, c1060e.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f16628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16629f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f16630g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f16631h;

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
            this.f16631h = eVar;
            this.f16628e = fVar;
            this.f16629f = str;
            this.f16630g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16628e.f16634c.getLayout().getEllipsisCount(this.f16628e.f16634c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f16631h.x(this.f16629f, this.f16630g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f16632e;

        public d(e eVar, c.a.q0.r.t.a aVar) {
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
            this.f16632e = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16632e.dismiss();
            }
        }
    }

    /* renamed from: c.a.r0.d1.v2.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1060e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f16633b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16634c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16635d;

        public C1060e(e eVar) {
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

    /* loaded from: classes2.dex */
    public class f extends C1060e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16636e;

        /* renamed from: f  reason: collision with root package name */
        public View f16637f;

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

    /* loaded from: classes2.dex */
    public class g extends C1060e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f16638e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f16639f;

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
        this.f16623h = "";
        this.f16624i = "";
        this.l = SkinManager.getColor(R.color.CAM_X0302);
        this.m = "";
        this.n = new HashSet<>();
        this.p = new c.a.r0.d1.o2.b();
        this.q = new a(this);
        this.r = new b(this);
        this.f16621f = context;
        this.f16622g = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f16620e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f16620e, i2) : invokeI.objValue;
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
                    view = LayoutInflater.from(this.f16621f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                    gVar.f16633b = view;
                    gVar.f16638e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                    gVar.f16634c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                    gVar.f16635d = (TextView) view.findViewById(R.id.top_item_type);
                    gVar.f16639f = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(gVar);
                }
                m(gVar, (n) ListUtils.getItem(this.f16620e, i2));
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f16621f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                    fVar.f16633b = view;
                    fVar.f16637f = view.findViewById(R.id.top_item_wrapper);
                    fVar.f16635d = (TextView) view.findViewById(R.id.top_item_type);
                    fVar.f16634c = (TextView) view.findViewById(R.id.top_item_title);
                    fVar.f16636e = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(fVar);
                    c.a.r0.d1.l2.e.a.e(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.f16620e, i2);
                if (nVar instanceof e2) {
                    i(fVar, (e2) nVar, i2);
                    fVar.a = i2;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof q) {
                    y((q) nVar, fVar, i2);
                } else if (nVar instanceof r) {
                    fVar.a = i2;
                    l(fVar, (r) nVar, i2);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(C1060e c1060e) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c1060e) == null) || c1060e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1060e.f16634c, (int) R.color.CAM_X0105);
    }

    public final void i(f fVar, e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, e2Var, i2) == null) || fVar == null || e2Var == null) {
            return;
        }
        fVar.f16635d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        c.a.r0.d1.l2.e.a.f(fVar.f16635d, this.l);
        e2Var.g3();
        SpannableStringBuilder j1 = e2Var.j1();
        if ((j1 == null || m.isEmptyStringAfterTrim(j1.toString())) && e2Var.p() != null) {
            j1 = new SpannableStringBuilder(e2Var.p());
            TiePlusEventController.tryExposeTiePlusLinkEvent(e2Var.x1());
        }
        fVar.f16634c.setOnTouchListener(new h(j1));
        fVar.f16634c.setText(j1);
        fVar.f16633b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // c.a.r0.d1.o2.d
    public c.a.r0.d1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (c.a.r0.d1.o2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f16634c.setText(kVar.g());
            fVar.f16635d.setText(o);
            c.a.r0.d1.l2.e.a.f(fVar.f16635d, this.l);
            if (kVar.e() != 0) {
                fVar.f16636e.setVisibility(0);
                if (kVar.e() == -1) {
                    fVar.f16636e.setText(this.f16621f.getString(R.string.no_rank));
                } else if (kVar.e() > 999) {
                    fVar.f16636e.setText(this.f16621f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView = fVar.f16636e;
                    textView.setText(this.f16621f.getString(R.string.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    fVar.f16634c.setText(kVar.g());
                }
            } else {
                fVar.f16636e.setVisibility(8);
            }
            h(fVar);
            fVar.f16634c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                fVar.f16633b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = c.a.r0.y3.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f16623h, this.f16624i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public final void l(f fVar, r rVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, rVar, i2) == null) || fVar == null || rVar == null || rVar.a() == null || this.f16625j == null) {
            return;
        }
        fVar.f16635d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        c.a.r0.d1.l2.e.a.f(fVar.f16635d, this.l);
        if (this.f16625j.getIs_manager() == 1) {
            if (rVar.a().audit_status.intValue() == 0 && rVar.a().has_forum_rule.intValue() == 0) {
                fVar.f16634c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (rVar.a().audit_status.intValue() == 0) {
                fVar.f16634c.setText(rVar.a().title);
            } else if (rVar.a().audit_status.intValue() == 1) {
                fVar.f16634c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (rVar.a().audit_status.intValue() == 2) {
                fVar.f16634c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f16634c.setText(rVar.a().title);
        }
        fVar.f16633b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nVar) == null) || gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof e2) {
            e2 e2Var = (e2) nVar;
            e2Var.g3();
            SpannableStringBuilder j1 = e2Var.j1();
            if ((j1 == null || m.isEmptyStringAfterTrim(j1.toString())) && e2Var.p() != null) {
                j1 = new SpannableStringBuilder(e2Var.p());
                TiePlusEventController.tryExposeTiePlusLinkEvent(e2Var.x1());
            }
            gVar.f16635d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f16634c.setOnTouchListener(new h(j1));
            gVar.f16634c.setText(j1);
            if (StringUtils.isNull(this.m)) {
                gVar.f16638e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f16635d.getLayoutParams();
                layoutParams.setMargins((int) this.f16621f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f16638e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f16635d.getLayoutParams();
                layoutParams2.setMargins((int) this.f16621f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f16638e.startLoad(this.m, 10, false);
            }
            gVar.f16635d.setTextColor(this.l);
            gVar.f16633b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f16635d.setText(o);
                gVar.f16635d.setVisibility(0);
                gVar.f16634c.setText(kVar.g());
                gVar.f16638e.setVisibility(8);
            } else {
                gVar.f16635d.setVisibility(8);
                gVar.f16638e.setVisibility(0);
                TextView textView = gVar.f16634c;
                textView.setText(o + "：" + kVar.g());
                gVar.f16638e.startLoad(this.m, 10, false);
            }
            if (kVar.e() != 0) {
                gVar.f16639f.setVisibility(0);
                if (kVar.e() == -1) {
                    gVar.f16639f.setText(this.f16621f.getString(R.string.no_rank));
                } else if (kVar.e() > 999) {
                    gVar.f16639f.setText(this.f16621f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f16639f;
                    textView2.setText(this.f16621f.getString(R.string.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f16634c.setText(kVar.g());
                }
            } else {
                gVar.f16639f.setVisibility(8);
            }
            gVar.f16635d.setTextColor(this.l);
            h(gVar);
            gVar.f16634c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f16633b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = c.a.r0.y3.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f16623h, this.f16624i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f16620e : (List) invokeV.objValue;
    }

    public final String o(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, kVar)) == null) {
            if (!TextUtils.isEmpty(kVar.h()) && kVar.h().trim().length() != 0) {
                return kVar.h();
            }
            if (kVar.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return (String) invokeL.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.f16621f;
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
            this.f16620e = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f16623h = str;
            this.f16624i = str2;
            this.f16625j = userData;
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

    public void v(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vVar) == null) {
            this.k = vVar;
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
        c.a.q0.r.t.a aVar = new c.a.q0.r.t.a((BaseFragmentActivity) this.f16621f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(q qVar, f fVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, qVar, fVar, i2)) == null) {
            if (i2 != 0 || qVar == null || qVar.a() == null) {
                return false;
            }
            ForumData a2 = qVar.a();
            boolean z = qVar.d() && !ListUtils.isEmpty(a2.getTipInfos());
            String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
            String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
            String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.f16635d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
            c.a.r0.d1.l2.e.a.f(fVar.f16635d, this.l);
            fVar.f16634c.setText(riskTipNotice);
            fVar.f16634c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
