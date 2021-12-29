package c.a.t0.u0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.s.q.q1;
import c.a.s0.s.q.r1;
import c.a.s0.s.q.s1;
import c.a.s0.s.q.x;
import c.a.s0.s.s.a;
import c.a.t0.u0.h.b;
import c.a.t0.u0.m.e;
import c.a.t0.w3.p0.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f24617e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f24618f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.u0.m.e f24619g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.u0.h.b f24620h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f24621i;

    /* renamed from: j  reason: collision with root package name */
    public List<x> f24622j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24623k;
    public c.a.t0.u0.d.c l;
    public c.a.t0.u0.m.b m;
    public HashSet<Long> n;
    public f.c o;

    /* renamed from: c.a.t0.u0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1440a implements e.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.t0.u0.m.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f24624b;

        public C1440a(a aVar, c.a.t0.u0.m.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24624b = aVar;
            this.a = bVar;
        }

        @Override // c.a.t0.u0.m.e.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f24624b.notifyDataSetChanged();
                this.a.s0(this.f24624b.f24619g.s());
                this.a.t0(this.f24624b.f24619g.t());
            }
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.u0.h.b.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.f24621i.I(true, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24625e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24625e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24625e.f24618f == null) {
                return;
            }
            this.f24625e.f24618f.dispatchMvcEvent(new c.a.s0.l0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24626e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24626e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f24626e.f24618f == null) {
                return;
            }
            this.f24626e.f24618f.dispatchMvcEvent(new c.a.s0.l0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24627e;

        /* renamed from: c.a.t0.u0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1441a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f24628e;

            public C1441a(e eVar) {
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
                this.f24628e = eVar;
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    c.a.t0.w3.p0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.f24628e.f24627e.o);
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.s0.s.s.a.e
            public void onClick(c.a.s0.s.s.a aVar) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24627e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.f24627e.f24621i.y()) {
                    if (this.f24627e.f24618f != null) {
                        this.f24627e.f24618f.dispatchMvcEvent(new c.a.s0.l0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.f24627e.f24621i.A().b();
                if (b2 != null) {
                    int x = b2.x();
                    if (x == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = m.isEmpty(b2.w()) ? this.f24627e.f24617e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                        blockPopInfoData.ahead_info = this.f24627e.f24617e.getResources().getString(R.string.create_forum_feed);
                        blockPopInfoData.ok_info = this.f24627e.f24617e.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.f24627e.f24617e.getPageActivity(), blockPopInfoData);
                    } else if (x == 2121002) {
                        c.a.s0.t.h.a.b(this.f24627e.f24617e, null, this.f24627e.f24617e.getResources().getString(R.string.create_forum_register_mobile_tip), this.f24627e.f24617e.getResources().getString(R.string.to_binding), this.f24627e.f24617e.getResources().getString(R.string.think_more), new C1441a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.f24627e.f24617e.getResources().getString(R.string.create_forum_err);
                if (b2 != null) {
                    string = m.isEmpty(b2.w()) ? this.f24627e.f24617e.getResources().getString(R.string.create_forum_err) : b2.w();
                }
                c.a.s0.t.h.a.b(this.f24627e.f24617e, null, string, this.f24627e.f24617e.getResources().getString(R.string.know), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.t0.w3.p0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public View f24629b;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(a aVar, C1440a c1440a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f24630b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f24631c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f24632d;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(a aVar, C1440a c1440a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f24633b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f24634c;

        public i(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(a aVar, C1440a c1440a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, c.a.t0.u0.m.b bVar) {
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
        this.f24622j = new ArrayList();
        this.f24623k = true;
        this.o = new f(this);
        this.f24617e = tbPageContext;
        this.f24618f = viewEventCenter;
        this.n = new HashSet<>();
        this.m = bVar;
        c.a.t0.u0.m.e eVar = new c.a.t0.u0.m.e(this.f24617e, recentlyVisitedForumModel, viewEventCenter);
        this.f24619g = eVar;
        eVar.E(new C1440a(this, bVar));
        this.f24621i = enterForumModel;
        c.a.t0.u0.h.b bVar2 = new c.a.t0.u0.h.b(this.f24617e.getPageActivity(), Integer.valueOf(c.a.s0.s.g0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f24619g);
        this.f24620h = bVar2;
        bVar2.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.t0.u0.m.e eVar = this.f24619g;
            if (eVar == null) {
                return false;
            }
            return eVar.k();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        c.a.t0.u0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f24619g) == null) {
            return;
        }
        eVar.x();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f24622j.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f24622j.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f24622j.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.f24622j;
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
            if (i2 >= this.f24622j.size() || i2 < 0) {
                return 6;
            }
            return this.f24622j.get(i2).g();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        c.a.t0.u0.m.c cVar;
        x xVar;
        g gVar;
        h hVar;
        c.a.t0.u0.n.a aVar;
        c.a.t0.u0.n.e eVar;
        c.a.t0.u0.n.f fVar;
        c.a.t0.u0.n.d dVar;
        c.a.t0.u0.n.b bVar;
        c.a.t0.u0.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.f24617e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view.findViewById(R.id.title);
                        iVar.f24633b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                        iVar.f24634c = (RelativeLayout) view.findViewById(R.id.container);
                        view.setTag(iVar);
                    }
                    if (this.f24622j.get(i2) instanceof c.a.t0.u0.d.e) {
                        c.a.t0.u0.d.e eVar2 = (c.a.t0.u0.d.e) this.f24622j.get(i2);
                        this.f24620h.v(iVar.f24633b);
                        this.f24620h.r();
                        this.f24620h.q(TbadkCoreApplication.getInst().getSkinType());
                        if (eVar2 != null) {
                            iVar.a.setText(eVar2.f24650h);
                            SkinManager.setViewTextColor(iVar.a, R.color.CAM_X0105);
                            c.a.t0.u0.d.c cVar3 = this.l;
                            if (cVar3 != null && cVar3.a) {
                                SkinManager.setBackgroundResource(iVar.f24634c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f24634c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f24633b;
                            if (textView != null) {
                                if (eVar2.f24651i) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f24633b, R.color.transparent);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.m.c)) {
                        cVar = (c.a.t0.u0.m.c) view.getTag();
                    } else {
                        view = this.f24617e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                        cVar = new c.a.t0.u0.m.c(this.f24617e, view, this.f24618f);
                        view.setTag(cVar);
                    }
                    if ((this.f24622j.get(i2) instanceof x) && (xVar = this.f24622j.get(i2)) != null) {
                        cVar.h(xVar);
                    }
                    cVar.j(this.l);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.f24617e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view.findViewById(R.id.footer_text);
                        gVar.f24629b = view.findViewById(R.id.container);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f24629b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.a, R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.f24617e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view.findViewById(R.id.root);
                        hVar.f24630b = (ImageView) view.findViewById(R.id.image);
                        hVar.f24631c = (TextView) view.findViewById(R.id.hint_text);
                        hVar.f24632d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                        c.a.s0.s.i0.n.a aVar2 = new c.a.s0.s.i0.n.a();
                        hVar.f24632d.setTextSize(R.dimen.tbds42);
                        hVar.f24632d.setConfig(aVar2);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f24631c.setText(R.string.enter_forum_login_interest);
                        hVar.f24632d.setText(this.f24617e.getResources().getString(R.string.click_here_to_login_in));
                        hVar.f24632d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f24630b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f24631c.setText(R.string.forum_waiting_for_your_attention);
                        hVar.f24632d.setText(this.f24617e.getResources().getString(R.string.click_here_to_explore_more_forum));
                        SkinManager.setImageResource(hVar.f24630b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f24631c, R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.a, R.color.CAM_X0205);
                    hVar.f24632d.changeSkinType();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f24632d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    View o = this.f24619g.o();
                    this.f24619g.z();
                    return o;
                case 5:
                    m();
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.a)) {
                        aVar = (c.a.t0.u0.n.a) view.getTag();
                    } else {
                        aVar = new c.a.t0.u0.n.a(this.f24617e);
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
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.e)) {
                        eVar = (c.a.t0.u0.n.e) view.getTag();
                    } else {
                        eVar = new c.a.t0.u0.n.e(this.f24617e);
                        view = eVar.d();
                        view.setTag(eVar);
                    }
                    if (this.f24622j.get(i2) instanceof s1) {
                        eVar.c((s1) this.f24622j.get(i2));
                    }
                    if (this.f24621i.A() == null || this.f24621i.A().e() == null || this.f24621i.A().e().b() == null) {
                        return view;
                    }
                    eVar.e(this.f24621i.A().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.f)) {
                        fVar = (c.a.t0.u0.n.f) view.getTag();
                    } else {
                        fVar = new c.a.t0.u0.n.f(this.f24617e);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.f24622j.get(i2) instanceof q1) {
                        q1 q1Var = (q1) this.f24622j.get(i2);
                        fVar.g(q1Var);
                        if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(q1Var.o()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", q1Var.o());
                            statisticItem.param("obj_locate", 1);
                            if (this.f24621i.A() != null && this.f24621i.A().e() != null && this.f24621i.A().e().b() != null) {
                                boolean z = this.f24621i.A().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                fVar.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.n.add(Long.valueOf(q1Var.o()));
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 9:
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.d)) {
                        dVar = (c.a.t0.u0.n.d) view.getTag();
                    } else {
                        dVar = new c.a.t0.u0.n.d(this.f24617e);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.f24622j.get(i2) instanceof r1) {
                        dVar.b((r1) this.f24622j.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.b)) {
                        bVar = (c.a.t0.u0.n.b) view.getTag();
                    } else {
                        bVar = new c.a.t0.u0.n.b(this.f24617e);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.f24622j.get(i2) instanceof c.a.t0.u0.d.a) {
                        bVar.c((c.a.t0.u0.d.a) this.f24622j.get(i2));
                    }
                    if (this.f24621i.A() == null || this.f24621i.A().e() == null || this.f24621i.A().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f24621i.A().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof c.a.t0.u0.n.c)) {
                        cVar2 = (c.a.t0.u0.n.c) view.getTag();
                    } else {
                        cVar2 = new c.a.t0.u0.n.c(this.f24617e);
                        view = cVar2.b();
                        view.setTag(cVar2);
                    }
                    cVar2.a();
                    return view;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f13838g.length : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f24623k = true;
            this.n.clear();
        }
    }

    public void i(int i2) {
        c.a.t0.u0.h.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f24620h) == null) {
            return;
        }
        bVar.t(i2);
    }

    public void j(c.a.t0.u0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar != this.l) {
                this.l = cVar;
                boolean z = cVar.a;
                boolean z2 = cVar.f24638b;
                int i2 = cVar.f24639c;
                notifyDataSetChanged();
            }
            c.a.t0.u0.m.e eVar = this.f24619g;
            if (eVar != null) {
                eVar.C(cVar);
            }
        }
    }

    public void k(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) {
            c.a.t0.u0.h.b bVar = this.f24620h;
            if (bVar != null) {
                bVar.p();
            }
            this.f24622j.clear();
            if (list != null) {
                this.f24622j.addAll(list);
            }
            this.m.V(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        c.a.t0.u0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || (eVar = this.f24619g) == null) {
            return;
        }
        eVar.F(bdUniqueId);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f24623k) {
            TiebaStatic.log("c13378");
            this.f24623k = false;
        }
    }
}
