package c.a.p0.f1.v2;

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
import c.a.d.o.e.w;
import c.a.o0.r.t.a;
import c.a.p0.a4.k;
import c.a.p0.a4.m0.a;
import c.a.p0.a4.q;
import c.a.p0.a4.r;
import c.a.p0.q4.i;
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
import com.baidu.tbadk.core.data.ThreadData;
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
public class g extends BaseAdapter implements c.a.p0.f1.o2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14779b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f14780c;

    /* renamed from: d  reason: collision with root package name */
    public String f14781d;

    /* renamed from: e  reason: collision with root package name */
    public String f14782e;

    /* renamed from: f  reason: collision with root package name */
    public UserData f14783f;

    /* renamed from: g  reason: collision with root package name */
    public w f14784g;

    /* renamed from: h  reason: collision with root package name */
    public int f14785h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public c.a.p0.f1.o2.b l;
    public final View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.a.f14779b == null || ViewHelper.checkUpIsLogin(this.a.f14779b)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof e) && (textView = (eVar = (e) view.getTag()).f14790c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) eVar.f14790c.getTag();
                        }
                        if (kVar != null && kVar.j() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i = kVar.i();
                            if ((i.contains("nohead:url") || i.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                c.a.d.f.p.n.M(this.a.f14779b, R.string.obfuscated_res_0x7f0f0317);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.a.f14780c, new String[]{i});
                            a.b b2 = c.a.p0.a4.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.b(), this.a.f14781d, this.a.f14782e, null);
                            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.e();
                        } else if (kVar == null || kVar.j() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.a.f14781d).eventStat();
                            if (this.a.f14780c == null || TextUtils.isEmpty(this.a.f14781d)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.f14780c.getPageActivity()).createNormalConfig(c.a.d.f.m.b.g(this.a.f14781d, 0L), 1)));
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
        public final /* synthetic */ g a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.a.f14784g == null || !(view.getTag() instanceof e) || (eVar = (e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.a.a, eVar.a);
                if (nVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nVar;
                    this.a.f14784g.b(view, threadData, BdUniqueId.gen(), null, this.a.k ? eVar.a + 1 : eVar.a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (nVar instanceof r) {
                    this.a.f14784g.b(view, (r) nVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g f14788d;

        public c(g gVar, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14788d = gVar;
            this.a = fVar;
            this.f14786b = str;
            this.f14787c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f14790c.getLayout().getEllipsisCount(this.a.f14790c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f14788d.x(this.f14786b, this.f14787c);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        public d(g gVar, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public View f14789b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f14790c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f14791d;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f14792e;

        /* renamed from: f  reason: collision with root package name */
        public View f14793f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g gVar) {
            super(gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: c.a.p0.f1.v2.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1117g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f14794e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f14795f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1117g(g gVar) {
            super(gVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((g) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14781d = "";
        this.f14782e = "";
        this.f14785h = SkinManager.getColor(R.color.CAM_X0302);
        this.i = "";
        this.j = new HashSet<>();
        this.l = new c.a.p0.f1.o2.b();
        this.m = new a(this);
        this.n = new b(this);
        this.f14779b = context;
        this.f14780c = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? ListUtils.getItem(this.a, i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        C1117g c1117g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view, viewGroup)) == null) {
            if (getItemViewType(i) == 1) {
                if (view != null && (view.getTag() instanceof C1117g)) {
                    c1117g = (C1117g) view.getTag();
                } else {
                    c1117g = new C1117g(this);
                    view = LayoutInflater.from(this.f14779b).inflate(R.layout.obfuscated_res_0x7f0d0326, (ViewGroup) null, false);
                    c1117g.f14789b = view;
                    c1117g.f14794e = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090b2f);
                    c1117g.f14790c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090b30);
                    c1117g.f14791d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920be);
                    c1117g.f14795f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920bc);
                    view.setTag(c1117g);
                }
                m(c1117g, (n) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f14779b).inflate(R.layout.obfuscated_res_0x7f0d0325, (ViewGroup) null, false);
                    fVar.f14789b = view;
                    fVar.f14793f = view.findViewById(R.id.obfuscated_res_0x7f0920bf);
                    fVar.f14791d = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920be);
                    fVar.f14790c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920bd);
                    fVar.f14792e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920bc);
                    view.setTag(fVar);
                    c.a.p0.f1.l2.e.a.e(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.a, i);
                if (nVar instanceof ThreadData) {
                    i(fVar, (ThreadData) nVar, i);
                    fVar.a = i;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof q) {
                    y((q) nVar, fVar, i);
                } else if (nVar instanceof r) {
                    fVar.a = i;
                    l(fVar, (r) nVar, i);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.f14790c, (int) R.color.CAM_X0105);
    }

    public final void i(f fVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, threadData, i) == null) || fVar == null || threadData == null) {
            return;
        }
        fVar.f14791d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13fd));
        c.a.p0.f1.l2.e.a.f(fVar.f14791d, this.f14785h);
        threadData.parserTitleFrsForTop();
        SpannableStringBuilder span_str = threadData.getSpan_str();
        if ((span_str == null || m.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
            span_str = new SpannableStringBuilder(threadData.getAbstractText());
            TiePlusEventController.h(threadData.getTiePlusLinkOriginData());
        }
        fVar.f14790c.setOnTouchListener(new i(span_str));
        fVar.f14790c.setText(span_str);
        fVar.f14789b.setOnClickListener(this.n);
        h(fVar);
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f14790c.setText(kVar.f());
            fVar.f14791d.setText(o);
            c.a.p0.f1.l2.e.a.f(fVar.f14791d, this.f14785h);
            if (kVar.e() != 0) {
                fVar.f14792e.setVisibility(0);
                if (kVar.e() == -1) {
                    fVar.f14792e.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0c53));
                } else if (kVar.e() > 999) {
                    fVar.f14792e.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0f28));
                } else {
                    TextView textView = fVar.f14792e;
                    textView.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0f27) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.f())) {
                    fVar.f14790c.setText(kVar.f());
                }
            } else {
                fVar.f14792e.setVisibility(8);
            }
            h(fVar);
            fVar.f14790c.setTag(kVar);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.f14789b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(kVar.b())) {
                return;
            }
            a.b b2 = c.a.p0.a4.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.b(), this.f14781d, this.f14782e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public final void l(f fVar, r rVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, rVar, i) == null) || fVar == null || rVar == null || rVar.a() == null || this.f14783f == null) {
            return;
        }
        fVar.f14791d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073b));
        c.a.p0.f1.l2.e.a.f(fVar.f14791d, this.f14785h);
        if (this.f14783f.getIs_manager() == 1) {
            if (rVar.a().audit_status.intValue() == 0 && rVar.a().has_forum_rule.intValue() == 0) {
                fVar.f14790c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073e));
            } else if (rVar.a().audit_status.intValue() == 0) {
                fVar.f14790c.setText(rVar.a().title);
            } else if (rVar.a().audit_status.intValue() == 1) {
                fVar.f14790c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073c));
            } else if (rVar.a().audit_status.intValue() == 2) {
                fVar.f14790c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f073f));
            }
        } else {
            fVar.f14790c.setText(rVar.a().title);
        }
        fVar.f14789b.setOnClickListener(this.n);
        h(fVar);
    }

    public final void m(C1117g c1117g, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, c1117g, nVar) == null) || c1117g == null || nVar == null) {
            return;
        }
        if (nVar instanceof ThreadData) {
            ThreadData threadData = (ThreadData) nVar;
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if ((span_str == null || m.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                span_str = new SpannableStringBuilder(threadData.getAbstractText());
                TiePlusEventController.h(threadData.getTiePlusLinkOriginData());
            }
            c1117g.f14791d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13fd));
            c1117g.f14790c.setOnTouchListener(new i(span_str));
            c1117g.f14790c.setText(span_str);
            if (StringUtils.isNull(this.i)) {
                c1117g.f14794e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1117g.f14791d.getLayoutParams();
                layoutParams.setMargins((int) this.f14779b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                c1117g.f14794e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c1117g.f14791d.getLayoutParams();
                layoutParams2.setMargins((int) this.f14779b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                c1117g.f14794e.J(this.i, 10, false);
            }
            c1117g.f14791d.setTextColor(this.f14785h);
            c1117g.f14789b.setOnClickListener(this.n);
            h(c1117g);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.i)) {
                c1117g.f14791d.setText(o);
                c1117g.f14791d.setVisibility(0);
                c1117g.f14790c.setText(kVar.f());
                c1117g.f14794e.setVisibility(8);
            } else {
                c1117g.f14791d.setVisibility(8);
                c1117g.f14794e.setVisibility(0);
                TextView textView = c1117g.f14790c;
                textView.setText(o + "：" + kVar.f());
                c1117g.f14794e.J(this.i, 10, false);
            }
            if (kVar.e() != 0) {
                c1117g.f14795f.setVisibility(0);
                if (kVar.e() == -1) {
                    c1117g.f14795f.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0c53));
                } else if (kVar.e() > 999) {
                    c1117g.f14795f.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0f28));
                } else {
                    TextView textView2 = c1117g.f14795f;
                    textView2.setText(this.f14779b.getString(R.string.obfuscated_res_0x7f0f0f27) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.f())) {
                    c1117g.f14790c.setText(kVar.f());
                }
            } else {
                c1117g.f14795f.setVisibility(8);
            }
            c1117g.f14791d.setTextColor(this.f14785h);
            h(c1117g);
            c1117g.f14790c.setTag(kVar);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                c1117g.f14789b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(kVar.b())) {
                return;
            }
            a.b b2 = c.a.p0.a4.m0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.b(), this.f14781d, this.f14782e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.e();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final String o(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, kVar)) == null) {
            if (!TextUtils.isEmpty(kVar.g()) && kVar.g().trim().length() != 0) {
                return kVar.g();
            }
            if (kVar.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f139e);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13fe);
        }
        return (String) invokeL.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.f14779b;
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
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f14781d = str;
            this.f14782e = str2;
            this.f14783f = userData;
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
            this.i = str;
        }
    }

    public void v(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wVar) == null) {
            this.f14784g = wVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.f14785h = i;
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || m.isEmpty(str) || m.isEmpty(str2)) {
            return;
        }
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a((BaseFragmentActivity) this.f14779b);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f072a, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(q qVar, f fVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, qVar, fVar, i)) == null) {
            if (i != 0 || qVar == null || qVar.a() == null) {
                return false;
            }
            ForumData a2 = qVar.a();
            boolean z = qVar.b() && !ListUtils.isEmpty(a2.getTipInfos());
            String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
            String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
            String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.f14791d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fc0));
            c.a.p0.f1.l2.e.a.f(fVar.f14791d, this.f14785h);
            fVar.f14790c.setText(riskTipNotice);
            fVar.f14790c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
