package c.a.p0.w0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.n1;
import c.a.o0.r.r.o1;
import c.a.o0.r.r.p1;
import c.a.o0.r.r.x;
import c.a.o0.r.t.a;
import c.a.p0.a4.q0.f;
import c.a.p0.w0.i.b;
import c.a.p0.w0.o.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public ViewEventCenter f19333b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w0.o.h f19334c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.w0.i.b f19335d;

    /* renamed from: e  reason: collision with root package name */
    public EnterForumModel f19336e;

    /* renamed from: f  reason: collision with root package name */
    public List<x> f19337f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19338g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.w0.e.e f19339h;
    public c.a.p0.w0.o.b i;
    public HashSet<Long> j;
    public f.c k;

    /* renamed from: c.a.p0.w0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1462a implements h.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w0.o.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19340b;

        public C1462a(a aVar, c.a.p0.w0.o.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19340b = aVar;
            this.a = bVar;
        }

        @Override // c.a.p0.w0.o.h.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19340b.notifyDataSetChanged();
                this.a.y0(this.f19340b.f19334c.s());
                this.a.z0(this.f19340b.f19334c.t());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // c.a.p0.w0.i.b.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.f19336e.K(true, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f19333b == null) {
                return;
            }
            this.a.f19333b.dispatchMvcEvent(new c.a.o0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f19333b == null) {
                return;
            }
            this.a.f19333b.dispatchMvcEvent(new c.a.o0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.w0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1463a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public C1463a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    c.a.p0.a4.q0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes2.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.a.f19336e.A()) {
                    if (this.a.f19333b != null) {
                        this.a.f19333b.dispatchMvcEvent(new c.a.o0.k0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.f19336e.C().b();
                if (b2 != null) {
                    int z2 = b2.z();
                    if (z2 == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = m.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0458) : b2.y();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f045a);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0984);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (z2 == 2121002) {
                        c.a.o0.s.h.a.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f045c), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13ef), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f138c), new C1463a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0459);
                if (b2 != null) {
                    string = m.isEmpty(b2.y()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0459) : b2.y();
                }
                c.a.o0.s.h.a.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0984), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.p0.a4.q0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f19341b;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(a aVar, C1462a c1462a) {
            this(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f19342b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f19343c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f19344d;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(a aVar, C1462a c1462a) {
            this(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19345b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f19346c;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(a aVar, C1462a c1462a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, c.a.p0.w0.o.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19337f = new ArrayList();
        this.f19338g = true;
        this.k = new f(this);
        this.a = tbPageContext;
        this.f19333b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = bVar;
        c.a.p0.w0.o.h hVar = new c.a.p0.w0.o.h(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.f19334c = hVar;
        hVar.E(new C1462a(this, bVar));
        this.f19336e = enterForumModel;
        c.a.p0.w0.i.b bVar2 = new c.a.p0.w0.i.b(this.a.getPageActivity(), Integer.valueOf(c.a.p0.w0.b.a(1)).intValue(), 0, this.f19334c);
        this.f19335d = bVar2;
        bVar2.v(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.p0.w0.o.h hVar = this.f19334c;
            if (hVar == null) {
                return false;
            }
            return hVar.k();
        }
        return invokeV.booleanValue;
    }

    public List<x> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19337f : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f19337f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f19337f.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f19337f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.f19337f;
            if (list == null || (i2 < list.size() && i2 >= 0)) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= this.f19337f.size() || i2 < 0) {
                return 6;
            }
            return this.f19337f.get(i2).e();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        c.a.p0.w0.o.e eVar;
        x xVar;
        g gVar;
        h hVar;
        c.a.p0.w0.p.a aVar;
        c.a.p0.w0.p.e eVar2;
        c.a.p0.w0.p.f fVar;
        c.a.p0.w0.p.d dVar;
        c.a.p0.w0.p.b bVar;
        c.a.p0.w0.p.c cVar;
        c.a.p0.w0.o.d dVar2;
        c.a.p0.w0.e.i iVar2;
        c.a.p0.w0.o.c cVar2;
        c.a.p0.w0.e.c cVar3;
        c.a.p0.w0.l.c.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d027b, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
                        iVar.f19345b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091d42);
                        iVar.f19346c = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0906c9);
                        view.setTag(iVar);
                    }
                    if (this.f19337f.get(i2) instanceof c.a.p0.w0.e.g) {
                        c.a.p0.w0.e.g gVar2 = (c.a.p0.w0.e.g) this.f19337f.get(i2);
                        this.f19335d.w(iVar.f19345b);
                        this.f19335d.s();
                        this.f19335d.r(TbadkCoreApplication.getInst().getSkinType());
                        if (gVar2 != null) {
                            iVar.a.setText(gVar2.f19363d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            c.a.p0.w0.e.e eVar3 = this.f19339h;
                            if ((eVar3 != null && eVar3.a) || gVar2.f19365f) {
                                SkinManager.setBackgroundResource(iVar.f19346c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f19346c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f19345b;
                            if (textView != null) {
                                if (gVar2.f19364e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f19345b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.f19346c.getLayoutParams();
                            if (gVar2.f19366g != -1) {
                                layoutParams.setMargins(n.f(viewGroup.getContext(), gVar2.f19366g), 0, n.f(viewGroup.getContext(), gVar2.f19366g), 0);
                            }
                            if (gVar2.i != -1) {
                                c.a.o0.r.v.c.d(iVar.a).z(gVar2.i);
                            }
                            if (gVar2.f19367h != -1) {
                                layoutParams.height = n.f(viewGroup.getContext(), gVar2.f19367h);
                            }
                            iVar.f19346c.setLayoutParams(layoutParams);
                            if (gVar2.j != -1) {
                                iVar.f19346c.setPadding(n.f(viewGroup.getContext(), gVar2.j), 0, n.f(viewGroup.getContext(), gVar2.j), 0);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.o.e)) {
                        eVar = (c.a.p0.w0.o.e) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d039c, viewGroup, false);
                        eVar = new c.a.p0.w0.o.e(this.a, view, this.f19333b);
                        view.setTag(eVar);
                    }
                    if ((this.f19337f.get(i2) instanceof x) && (xVar = this.f19337f.get(i2)) != null) {
                        eVar.i(xVar);
                    }
                    eVar.k(this.f19339h);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d027a, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090a0c);
                        gVar.f19341b = view.findViewById(R.id.obfuscated_res_0x7f0906c9);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f19341b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.a, (int) R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0278, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view.findViewById(R.id.obfuscated_res_0x7f091ad7);
                        hVar.f19342b = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090e69);
                        hVar.f19343c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090d55);
                        hVar.f19344d = (TBSpecificationBtn) view.findViewById(R.id.obfuscated_res_0x7f090a0c);
                        c.a.o0.r.l0.n.a aVar3 = new c.a.o0.r.l0.n.a();
                        hVar.f19344d.setTextSize(R.dimen.tbds42);
                        hVar.f19344d.setConfig(aVar3);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f19343c.setText(R.string.obfuscated_res_0x7f0f055d);
                        hVar.f19344d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03d5));
                        hVar.f19344d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f19342b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f19343c.setText(R.string.obfuscated_res_0x7f0f06ab);
                        hVar.f19344d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03d3));
                        SkinManager.setImageResource(hVar.f19342b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f19343c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.a, R.color.CAM_X0205);
                    hVar.f19344d.k();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f19344d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    if (view == null) {
                        View o = this.f19334c.o();
                        this.f19334c.z();
                        return o;
                    }
                    return view;
                case 5:
                    o();
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.a)) {
                        aVar = (c.a.p0.w0.p.a) view.getTag();
                    } else {
                        aVar = new c.a.p0.w0.p.a(this.a);
                        view = aVar.b();
                        view.setTag(aVar);
                    }
                    aVar.a();
                    aVar.c(new e(this));
                    return view;
                case 6:
                default:
                    return view;
                case 7:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.e)) {
                        eVar2 = (c.a.p0.w0.p.e) view.getTag();
                    } else {
                        eVar2 = new c.a.p0.w0.p.e(this.a);
                        view = eVar2.d();
                        view.setTag(eVar2);
                    }
                    if (this.f19337f.get(i2) instanceof p1) {
                        eVar2.c((p1) this.f19337f.get(i2));
                    }
                    if (this.f19336e.C() == null || this.f19336e.C().e() == null || this.f19336e.C().e().b() == null) {
                        return view;
                    }
                    eVar2.e(this.f19336e.C().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.f)) {
                        fVar = (c.a.p0.w0.p.f) view.getTag();
                    } else {
                        fVar = new c.a.p0.w0.p.f(this.a);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.f19337f.get(i2) instanceof n1) {
                        n1 n1Var = (n1) this.f19337f.get(i2);
                        fVar.g(n1Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(n1Var.k()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", n1Var.k());
                            statisticItem.param("obj_locate", 1);
                            if (this.f19336e.C() != null && this.f19336e.C().e() != null && this.f19336e.C().e().b() != null) {
                                boolean z = this.f19336e.C().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                fVar.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(n1Var.k()));
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 9:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.d)) {
                        dVar = (c.a.p0.w0.p.d) view.getTag();
                    } else {
                        dVar = new c.a.p0.w0.p.d(this.a);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.f19337f.get(i2) instanceof o1) {
                        dVar.b((o1) this.f19337f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.b)) {
                        bVar = (c.a.p0.w0.p.b) view.getTag();
                    } else {
                        bVar = new c.a.p0.w0.p.b(this.a);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.f19337f.get(i2) instanceof c.a.p0.w0.e.a) {
                        bVar.c((c.a.p0.w0.e.a) this.f19337f.get(i2));
                    }
                    if (this.f19336e.C() == null || this.f19336e.C().e() == null || this.f19336e.C().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f19336e.C().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.p.c)) {
                        cVar = (c.a.p0.w0.p.c) view.getTag();
                    } else {
                        cVar = new c.a.p0.w0.p.c(this.a);
                        view = cVar.b();
                        view.setTag(cVar);
                    }
                    cVar.a();
                    return view;
                case 12:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.o.d)) {
                        dVar2 = (c.a.p0.w0.o.d) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d04f9, viewGroup, false);
                        dVar2 = new c.a.p0.w0.o.d(this.a, view, this.f19333b, this.f19334c, this.f19336e);
                        view.setTag(dVar2);
                    }
                    if ((this.f19337f.get(i2) instanceof c.a.p0.w0.e.i) && (iVar2 = (c.a.p0.w0.e.i) this.f19337f.get(i2)) != null) {
                        dVar2.i(iVar2);
                    }
                    dVar2.k(this.f19339h);
                    return view;
                case 13:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.o.c)) {
                        cVar2 = (c.a.p0.w0.o.c) view.getTag();
                    } else {
                        view = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01e9, viewGroup, false);
                        cVar2 = new c.a.p0.w0.o.c(this.a, view, this.f19333b, this.f19334c, this.f19336e);
                        view.setTag(cVar2);
                    }
                    if (!(this.f19337f.get(i2) instanceof c.a.p0.w0.e.c) || (cVar3 = (c.a.p0.w0.e.c) this.f19337f.get(i2)) == null || ListUtils.isEmpty(cVar3.k())) {
                        return view;
                    }
                    cVar2.i(cVar3);
                    return view;
                case 14:
                    if (view != null && (view.getTag() instanceof c.a.p0.w0.l.c.a)) {
                        aVar2 = (c.a.p0.w0.l.c.a) view.getTag();
                    } else {
                        aVar2 = new c.a.p0.w0.l.c.a(this.a);
                        view = aVar2.a();
                        view.setTag(aVar2);
                    }
                    if (this.f19337f.get(i2) instanceof c.a.p0.w0.l.b.b) {
                        c.a.p0.w0.l.b.b bVar2 = (c.a.p0.w0.l.b.b) this.f19337f.get(i2);
                        aVar2.a().setData(bVar2);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", bVar2 != null ? bVar2.k() : "").param("obj_source", bVar2 != null ? bVar2.getFrom() : ""));
                        return view;
                    }
                    return view;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f10986c.length : invokeV.intValue;
    }

    public void h(int i2) {
        c.a.p0.w0.o.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (hVar = this.f19334c) == null) {
            return;
        }
        hVar.w(i2);
    }

    public void i() {
        c.a.p0.w0.o.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (hVar = this.f19334c) == null) {
            return;
        }
        hVar.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f19338g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        c.a.p0.w0.i.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (bVar = this.f19335d) == null) {
            return;
        }
        bVar.u(i2);
    }

    public void l(c.a.p0.w0.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            if (eVar != this.f19339h) {
                this.f19339h = eVar;
                boolean z = eVar.a;
                boolean z2 = eVar.f19353b;
                int i2 = eVar.f19354c;
                notifyDataSetChanged();
            }
            c.a.p0.w0.o.h hVar = this.f19334c;
            if (hVar != null) {
                hVar.C(eVar);
            }
        }
    }

    public void m(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            c.a.p0.w0.i.b bVar = this.f19335d;
            if (bVar != null) {
                bVar.q();
            }
            this.f19337f.clear();
            if (list != null) {
                this.f19337f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        c.a.p0.w0.o.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (hVar = this.f19334c) == null) {
            return;
        }
        hVar.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f19338g) {
            TiebaStatic.log("c13378");
            this.f19338g = false;
        }
    }
}
