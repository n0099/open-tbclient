package b.a.r0.x0.c3;

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
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.r0.d4.h;
import b.a.r0.m3.k;
import b.a.r0.m3.l0.a;
import b.a.r0.m3.p;
import b.a.r0.m3.q;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.i1;
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
/* loaded from: classes5.dex */
public class e extends BaseAdapter implements b.a.r0.x0.v2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f27183e;

    /* renamed from: f  reason: collision with root package name */
    public Context f27184f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f27185g;

    /* renamed from: h  reason: collision with root package name */
    public String f27186h;

    /* renamed from: i  reason: collision with root package name */
    public String f27187i;
    public UserData j;
    public w k;
    public int l;
    public String m;
    public HashSet<String> n;
    public boolean o;
    public b.a.r0.x0.v2.b p;
    public final View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27188e;

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
            this.f27188e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1335e c1335e;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f27188e.f27184f == null || ViewHelper.checkUpIsLogin(this.f27188e.f27184f)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof C1335e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof C1335e) && (textView = (c1335e = (C1335e) view.getTag()).f27197c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) c1335e.f27197c.getTag();
                        }
                        if (kVar != null && kVar.k() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i2 = kVar.i();
                            if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.L(this.f27188e.f27184f, i1.book_plugin_not_install_tip);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.f27188e.f27185g, new String[]{i2});
                            a.b b2 = b.a.r0.m3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.d(), this.f27188e.f27186h, this.f27188e.f27187i, null);
                            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.e();
                        } else if (kVar == null || kVar.k() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.f27188e.f27186h).eventStat();
                            if (this.f27188e.f27185g == null || TextUtils.isEmpty(this.f27188e.f27186h)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f27188e.f27185g.getPageActivity()).createNormalConfig(b.a.e.f.m.b.g(this.f27188e.f27186h, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27189e;

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
            this.f27189e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1335e c1335e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.f27189e.k == null || !(view.getTag() instanceof C1335e) || (c1335e = (C1335e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.f27189e.f27183e, c1335e.f27195a);
                if (nVar instanceof d2) {
                    d2 d2Var = (d2) nVar;
                    this.f27189e.k.b(view, d2Var, BdUniqueId.gen(), null, this.f27189e.o ? c1335e.f27195a + 1 : c1335e.f27195a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", d2Var.T()).param("tid", d2Var.t1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1335e.f27195a + 1));
                } else if (nVar instanceof q) {
                    this.f27189e.k.b(view, (q) nVar, BdUniqueId.gen(), null, c1335e.f27195a, 0L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27190e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f27191f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f27192g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27193h;

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
            this.f27193h = eVar;
            this.f27190e = fVar;
            this.f27191f = str;
            this.f27192g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27190e.f27197c.getLayout().getEllipsisCount(this.f27190e.f27197c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f27193h.x(this.f27191f, this.f27192g);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.s.a f27194e;

        public d(e eVar, b.a.q0.s.s.a aVar) {
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
            this.f27194e = aVar;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27194e.dismiss();
            }
        }
    }

    /* renamed from: b.a.r0.x0.c3.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1335e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f27195a;

        /* renamed from: b  reason: collision with root package name */
        public View f27196b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27197c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27198d;

        public C1335e(e eVar) {
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

    /* loaded from: classes5.dex */
    public class f extends C1335e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27199e;

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

    /* loaded from: classes5.dex */
    public class g extends C1335e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f27200e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f27201f;

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
        this.f27186h = "";
        this.f27187i = "";
        this.l = SkinManager.getColor(c1.CAM_X0302);
        this.m = "";
        this.n = new HashSet<>();
        this.p = new b.a.r0.x0.v2.b();
        this.q = new a(this);
        this.r = new b(this);
        this.f27184f = context;
        this.f27185g = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f27183e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f27183e, i2) : invokeI.objValue;
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
                    view = LayoutInflater.from(this.f27184f).inflate(g1.frs_header_top_item_single, (ViewGroup) null, false);
                    gVar.f27196b = view;
                    gVar.f27200e = (TbImageView) view.findViewById(f1.frs_header_top_item_image);
                    gVar.f27197c = (TextView) view.findViewById(f1.frs_header_top_item_title);
                    gVar.f27198d = (TextView) view.findViewById(f1.top_item_type);
                    gVar.f27201f = (TextView) view.findViewById(f1.top_item_rank);
                    view.setTag(gVar);
                }
                m(gVar, (n) ListUtils.getItem(this.f27183e, i2));
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f27184f).inflate(g1.frs_header_top_item_double, (ViewGroup) null, false);
                    fVar.f27196b = view;
                    fVar.f27198d = (TextView) view.findViewById(f1.top_item_type);
                    fVar.f27197c = (TextView) view.findViewById(f1.top_item_title);
                    fVar.f27199e = (TextView) view.findViewById(f1.top_item_rank);
                    view.setTag(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.f27183e, i2);
                if (nVar instanceof d2) {
                    i(fVar, (d2) nVar, i2);
                    fVar.f27195a = i2;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof p) {
                    y((p) nVar, fVar, i2);
                } else if (nVar instanceof q) {
                    fVar.f27195a = i2;
                    l(fVar, (q) nVar, i2);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(C1335e c1335e) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c1335e) == null) || c1335e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1335e.f27197c, c1.CAM_X0105);
        SkinManager.setViewTextColor(c1335e.f27198d, c1.CAM_X0101);
    }

    public final void i(f fVar, d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, d2Var, i2) == null) || fVar == null || d2Var == null) {
            return;
        }
        fVar.f27198d.setText(TbadkCoreApplication.getInst().getString(i1.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27184f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27198d);
        d2Var.d3();
        SpannableStringBuilder h1 = d2Var.h1();
        if ((h1 == null || b.a.e.f.p.k.isEmptyStringAfterTrim(h1.toString())) && d2Var.p() != null) {
            h1 = new SpannableStringBuilder(d2Var.p());
            TiePlusEventController.tryExposeTiePlusLinkEvent(d2Var.u1());
        }
        fVar.f27197c.setOnTouchListener(new h(h1));
        fVar.f27197c.setText(h1);
        fVar.f27196b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // b.a.r0.x0.v2.d
    public b.a.r0.x0.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (b.a.r0.x0.v2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f27197c.setText(kVar.g());
            fVar.f27198d.setText(o);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27184f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27198d);
            if (kVar.e() != 0) {
                fVar.f27199e.setVisibility(0);
                if (kVar.e() == -1) {
                    fVar.f27199e.setText(this.f27184f.getString(i1.no_rank));
                } else if (kVar.e() > 999) {
                    fVar.f27199e.setText(this.f27184f.getString(i1.rang_orer_thousand));
                } else {
                    TextView textView = fVar.f27199e;
                    textView.setText(this.f27184f.getString(i1.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    fVar.f27197c.setText(kVar.g());
                }
            } else {
                fVar.f27199e.setVisibility(8);
            }
            h(fVar);
            fVar.f27197c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                fVar.f27196b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = b.a.r0.m3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f27186h, this.f27187i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public final void l(f fVar, q qVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, qVar, i2) == null) || fVar == null || qVar == null || qVar.a() == null || this.j == null) {
            return;
        }
        fVar.f27198d.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27184f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27198d);
        if (this.j.getIs_manager() == 1) {
            if (qVar.a().audit_status.intValue() == 0 && qVar.a().has_forum_rule.intValue() == 0) {
                fVar.f27197c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_none));
            } else if (qVar.a().audit_status.intValue() == 0) {
                fVar.f27197c.setText(qVar.a().title);
            } else if (qVar.a().audit_status.intValue() == 1) {
                fVar.f27197c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_chenking));
            } else if (qVar.a().audit_status.intValue() == 2) {
                fVar.f27197c.setText(TbadkCoreApplication.getInst().getString(i1.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f27197c.setText(qVar.a().title);
        }
        fVar.f27196b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nVar) == null) || gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof d2) {
            d2 d2Var = (d2) nVar;
            d2Var.d3();
            SpannableStringBuilder h1 = d2Var.h1();
            if ((h1 == null || b.a.e.f.p.k.isEmptyStringAfterTrim(h1.toString())) && d2Var.p() != null) {
                h1 = new SpannableStringBuilder(d2Var.p());
                TiePlusEventController.tryExposeTiePlusLinkEvent(d2Var.u1());
            }
            gVar.f27198d.setText(TbadkCoreApplication.getInst().getString(i1.top));
            gVar.f27197c.setOnTouchListener(new h(h1));
            gVar.f27197c.setText(h1);
            if (StringUtils.isNull(this.m)) {
                gVar.f27200e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f27198d.getLayoutParams();
                layoutParams.setMargins((int) this.f27184f.getResources().getDimension(d1.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f27200e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f27198d.getLayoutParams();
                layoutParams2.setMargins((int) this.f27184f.getResources().getDimension(d1.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f27200e.startLoad(this.m, 10, false);
            }
            gVar.f27198d.setTextColor(this.l);
            gVar.f27196b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f27198d.setText(o);
                gVar.f27198d.setVisibility(0);
                gVar.f27197c.setText(kVar.g());
                gVar.f27200e.setVisibility(8);
            } else {
                gVar.f27198d.setVisibility(8);
                gVar.f27200e.setVisibility(0);
                TextView textView = gVar.f27197c;
                textView.setText(o + "：" + kVar.g());
                gVar.f27200e.startLoad(this.m, 10, false);
            }
            if (kVar.e() != 0) {
                gVar.f27201f.setVisibility(0);
                if (kVar.e() == -1) {
                    gVar.f27201f.setText(this.f27184f.getString(i1.no_rank));
                } else if (kVar.e() > 999) {
                    gVar.f27201f.setText(this.f27184f.getString(i1.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f27201f;
                    textView2.setText(this.f27184f.getString(i1.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f27197c.setText(kVar.g());
                }
            } else {
                gVar.f27201f.setVisibility(8);
            }
            gVar.f27198d.setTextColor(this.l);
            h(gVar);
            gVar.f27197c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f27196b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.d())) {
                return;
            }
            a.b b2 = b.a.r0.m3.l0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.d(), this.f27186h, this.f27187i, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f27183e : (List) invokeV.objValue;
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
            Context context = this.f27184f;
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
            this.f27183e = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f27186h = str;
            this.f27187i = str2;
            this.j = userData;
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
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || b.a.e.f.p.k.isEmpty(str) || b.a.e.f.p.k.isEmpty(str2)) {
            return;
        }
        b.a.q0.s.s.a aVar = new b.a.q0.s.s.a((BaseFragmentActivity) this.f27184f);
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
            fVar.f27198d.setText(TbadkCoreApplication.getInst().getString(i1.risk_notice_title));
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27184f, d1.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27198d);
            fVar.f27197c.setText(riskTipNotice);
            fVar.f27197c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
