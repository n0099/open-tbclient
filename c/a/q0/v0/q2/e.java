package c.a.q0.v0.q2;

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
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import c.a.p0.s.q.c2;
import c.a.p0.s.s.a;
import c.a.q0.a4.h;
import c.a.q0.i3.k;
import c.a.q0.i3.k0.a;
import c.a.q0.i3.o;
import c.a.q0.i3.p;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements c.a.q0.v0.j2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f27071e;

    /* renamed from: f  reason: collision with root package name */
    public Context f27072f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f27073g;

    /* renamed from: h  reason: collision with root package name */
    public String f27074h;

    /* renamed from: i  reason: collision with root package name */
    public String f27075i;

    /* renamed from: j  reason: collision with root package name */
    public UserData f27076j;
    public w k;
    public int l;
    public String m;
    public HashSet<String> n;
    public boolean o;
    public c.a.q0.v0.j2.b p;
    public final View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27077e;

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
            this.f27077e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1268e c1268e;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f27077e.f27072f == null || ViewHelper.checkUpIsLogin(this.f27077e.f27072f)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof C1268e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof C1268e) && (textView = (c1268e = (C1268e) view.getTag()).f27086c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) c1268e.f27086c.getTag();
                        }
                        if (kVar != null && kVar.k() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i2 = kVar.i();
                            if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.L(this.f27077e.f27072f, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.f27077e.f27073g, new String[]{i2});
                            a.b b2 = c.a.q0.i3.k0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.c(), this.f27077e.f27074h, this.f27077e.f27075i, null);
                            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.f();
                        } else if (kVar == null || kVar.k() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.f27077e.f27074h).eventStat();
                            if (this.f27077e.f27073g == null || TextUtils.isEmpty(this.f27077e.f27074h)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f27077e.f27073g.getPageActivity()).createNormalConfig(c.a.e.e.m.b.f(this.f27077e.f27074h, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f27078e;

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
            this.f27078e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1268e c1268e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.f27078e.k == null || !(view.getTag() instanceof C1268e) || (c1268e = (C1268e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.f27078e.f27071e, c1268e.f27084a);
                if (nVar instanceof c2) {
                    c2 c2Var = (c2) nVar;
                    this.f27078e.k.b(view, c2Var, BdUniqueId.gen(), null, this.f27078e.o ? c1268e.f27084a + 1 : c1268e.f27084a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", c2Var.T()).param("tid", c2Var.q1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1268e.f27084a + 1));
                } else if (nVar instanceof p) {
                    this.f27078e.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1268e.f27084a, 0L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27079e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f27080f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f27081g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f27082h;

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
            this.f27082h = eVar;
            this.f27079e = fVar;
            this.f27080f = str;
            this.f27081g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27079e.f27086c.getLayout().getEllipsisCount(this.f27079e.f27086c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f27082h.x(this.f27080f, this.f27081g);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f27083e;

        public d(e eVar, c.a.p0.s.s.a aVar) {
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
            this.f27083e = aVar;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f27083e.dismiss();
            }
        }
    }

    /* renamed from: c.a.q0.v0.q2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1268e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f27084a;

        /* renamed from: b  reason: collision with root package name */
        public View f27085b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f27086c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f27087d;

        public C1268e(e eVar) {
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

    /* loaded from: classes4.dex */
    public class f extends C1268e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f27088e;

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

    /* loaded from: classes4.dex */
    public class g extends C1268e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f27089e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f27090f;

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
        this.f27074h = "";
        this.f27075i = "";
        this.l = SkinManager.getColor(R.color.CAM_X0302);
        this.m = "";
        this.n = new HashSet<>();
        this.p = new c.a.q0.v0.j2.b();
        this.q = new a(this);
        this.r = new b(this);
        this.f27072f = context;
        this.f27073g = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f27071e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f27071e, i2) : invokeI.objValue;
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
                    view = LayoutInflater.from(this.f27072f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                    gVar.f27085b = view;
                    gVar.f27089e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                    gVar.f27086c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                    gVar.f27087d = (TextView) view.findViewById(R.id.top_item_type);
                    gVar.f27090f = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(gVar);
                }
                m(gVar, (n) ListUtils.getItem(this.f27071e, i2));
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f27072f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                    fVar.f27085b = view;
                    fVar.f27087d = (TextView) view.findViewById(R.id.top_item_type);
                    fVar.f27086c = (TextView) view.findViewById(R.id.top_item_title);
                    fVar.f27088e = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.f27071e, i2);
                if (nVar instanceof c2) {
                    i(fVar, (c2) nVar, i2);
                    fVar.f27084a = i2;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof o) {
                    y((o) nVar, fVar, i2);
                } else if (nVar instanceof p) {
                    fVar.f27084a = i2;
                    l(fVar, (p) nVar, i2);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(C1268e c1268e) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c1268e) == null) || c1268e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1268e.f27086c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1268e.f27087d, R.color.CAM_X0101);
    }

    public final void i(f fVar, c2 c2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, c2Var, i2) == null) || fVar == null || c2Var == null) {
            return;
        }
        fVar.f27087d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27072f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27087d);
        c2Var.V2();
        SpannableStringBuilder e1 = c2Var.e1();
        if ((e1 == null || c.a.e.e.p.k.isEmptyStringAfterTrim(e1.toString())) && c2Var.p() != null) {
            e1 = new SpannableStringBuilder(c2Var.p());
            TiePlusEventController.tryExposeTiePlusLinkEvent(c2Var.r1());
        }
        fVar.f27086c.setOnTouchListener(new h(e1));
        fVar.f27086c.setText(e1);
        fVar.f27085b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f27086c.setText(kVar.g());
            fVar.f27087d.setText(o);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27072f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27087d);
            if (kVar.d() != 0) {
                fVar.f27088e.setVisibility(0);
                if (kVar.d() == -1) {
                    fVar.f27088e.setText(this.f27072f.getString(R.string.no_rank));
                } else if (kVar.d() > 999) {
                    fVar.f27088e.setText(this.f27072f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView = fVar.f27088e;
                    textView.setText(this.f27072f.getString(R.string.rang_identify) + kVar.d());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    fVar.f27086c.setText(kVar.g());
                }
            } else {
                fVar.f27088e.setVisibility(8);
            }
            h(fVar);
            fVar.f27086c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                fVar.f27085b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = c.a.q0.i3.k0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f27074h, this.f27075i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public final void l(f fVar, p pVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, pVar, i2) == null) || fVar == null || pVar == null || pVar.b() == null || this.f27076j == null) {
            return;
        }
        fVar.f27087d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27072f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27087d);
        if (this.f27076j.getIs_manager() == 1) {
            if (pVar.b().audit_status.intValue() == 0 && pVar.b().has_forum_rule.intValue() == 0) {
                fVar.f27086c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.b().audit_status.intValue() == 0) {
                fVar.f27086c.setText(pVar.b().title);
            } else if (pVar.b().audit_status.intValue() == 1) {
                fVar.f27086c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.b().audit_status.intValue() == 2) {
                fVar.f27086c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f27086c.setText(pVar.b().title);
        }
        fVar.f27085b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nVar) == null) || gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof c2) {
            c2 c2Var = (c2) nVar;
            c2Var.V2();
            SpannableStringBuilder e1 = c2Var.e1();
            if ((e1 == null || c.a.e.e.p.k.isEmptyStringAfterTrim(e1.toString())) && c2Var.p() != null) {
                e1 = new SpannableStringBuilder(c2Var.p());
                TiePlusEventController.tryExposeTiePlusLinkEvent(c2Var.r1());
            }
            gVar.f27087d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f27086c.setOnTouchListener(new h(e1));
            gVar.f27086c.setText(e1);
            if (StringUtils.isNull(this.m)) {
                gVar.f27089e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f27087d.getLayoutParams();
                layoutParams.setMargins((int) this.f27072f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f27089e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f27087d.getLayoutParams();
                layoutParams2.setMargins((int) this.f27072f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f27089e.startLoad(this.m, 10, false);
            }
            gVar.f27087d.setTextColor(this.l);
            gVar.f27085b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f27087d.setText(o);
                gVar.f27087d.setVisibility(0);
                gVar.f27086c.setText(kVar.g());
                gVar.f27089e.setVisibility(8);
            } else {
                gVar.f27087d.setVisibility(8);
                gVar.f27089e.setVisibility(0);
                TextView textView = gVar.f27086c;
                textView.setText(o + "：" + kVar.g());
                gVar.f27089e.startLoad(this.m, 10, false);
            }
            if (kVar.d() != 0) {
                gVar.f27090f.setVisibility(0);
                if (kVar.d() == -1) {
                    gVar.f27090f.setText(this.f27072f.getString(R.string.no_rank));
                } else if (kVar.d() > 999) {
                    gVar.f27090f.setText(this.f27072f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f27090f;
                    textView2.setText(this.f27072f.getString(R.string.rang_identify) + kVar.d());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f27086c.setText(kVar.g());
                }
            } else {
                gVar.f27090f.setVisibility(8);
            }
            gVar.f27087d.setTextColor(this.l);
            h(gVar);
            gVar.f27086c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f27085b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = c.a.q0.i3.k0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f27074h, this.f27075i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f27071e : (List) invokeV.objValue;
    }

    public final String o(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, kVar)) == null) {
            if (!TextUtils.isEmpty(kVar.h()) && kVar.h().trim().length() != 0) {
                return kVar.h();
            }
            if (kVar.b() == 1) {
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
            Context context = this.f27072f;
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
            this.f27071e = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f27074h = str;
            this.f27075i = str2;
            this.f27076j = userData;
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
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || c.a.e.e.p.k.isEmpty(str) || c.a.e.e.p.k.isEmpty(str2)) {
            return;
        }
        c.a.p0.s.s.a aVar = new c.a.p0.s.s.a((BaseFragmentActivity) this.f27072f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(o oVar, f fVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, oVar, fVar, i2)) == null) {
            if (i2 != 0 || oVar == null || oVar.b() == null) {
                return false;
            }
            ForumData b2 = oVar.b();
            boolean z = oVar.c() && !ListUtils.isEmpty(b2.getTipInfos());
            String riskTipNotice = z ? b2.getTipInfos().get(0).tip_notice : b2.getRiskTipNotice();
            String riskTipPopTitle = z ? b2.getTipInfos().get(0).tip_pop_title : b2.getRiskTipPopTitle();
            String riskTipPop = z ? b2.getTipInfos().get(0).tip_pop : b2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.f27087d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f27072f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f27087d);
            fVar.f27086c.setText(riskTipNotice);
            fVar.f27086c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
