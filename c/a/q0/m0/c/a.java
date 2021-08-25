package c.a.q0.m0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.p0.s.q.p1;
import c.a.p0.s.q.q1;
import c.a.p0.s.q.r1;
import c.a.p0.s.q.x;
import c.a.p0.s.s.a;
import c.a.q0.i3.o0.f;
import c.a.q0.m0.h.b;
import c.a.q0.m0.m.e;
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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f21890e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f21891f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.m0.m.e f21892g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.m0.h.b f21893h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f21894i;

    /* renamed from: j  reason: collision with root package name */
    public List<x> f21895j;
    public boolean k;
    public c.a.q0.m0.d.c l;
    public c.a.q0.m0.m.b m;
    public HashSet<Long> n;
    public f.c o;

    /* renamed from: c.a.q0.m0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1017a implements e.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.m0.m.b f21896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21897b;

        public C1017a(a aVar, c.a.q0.m0.m.b bVar) {
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
            this.f21897b = aVar;
            this.f21896a = bVar;
        }

        @Override // c.a.q0.m0.m.e.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21897b.notifyDataSetChanged();
                this.f21896a.s0(this.f21897b.f21892g.s());
                this.f21896a.t0(this.f21897b.f21892g.t());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21898a;

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
            this.f21898a = aVar;
        }

        @Override // c.a.q0.m0.h.b.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f21898a.f21894i.I(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21899e;

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
            this.f21899e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21899e.f21891f == null) {
                return;
            }
            this.f21899e.f21891f.dispatchMvcEvent(new c.a.p0.i0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21900e;

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
            this.f21900e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21900e.f21891f == null) {
                return;
            }
            this.f21900e.f21891f.dispatchMvcEvent(new c.a.p0.i0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21901e;

        /* renamed from: c.a.q0.m0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1018a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f21902e;

            public C1018a(e eVar) {
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
                this.f21902e = eVar;
            }

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    c.a.q0.i3.o0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.f21902e.f21901e.o);
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
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

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
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

            @Override // c.a.p0.s.s.a.e
            public void onClick(c.a.p0.s.s.a aVar) {
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
            this.f21901e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.f21901e.f21894i.y()) {
                    if (this.f21901e.f21891f != null) {
                        this.f21901e.f21891f.dispatchMvcEvent(new c.a.p0.i0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.f21901e.f21894i.A().b();
                if (b2 != null) {
                    int x = b2.x();
                    if (x == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = k.isEmpty(b2.w()) ? this.f21901e.f21890e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                        blockPopInfoData.ahead_info = this.f21901e.f21890e.getResources().getString(R.string.create_forum_feed);
                        blockPopInfoData.ok_info = this.f21901e.f21890e.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.f21901e.f21890e.getPageActivity(), blockPopInfoData);
                    } else if (x == 2121002) {
                        c.a.p0.t.h.a.b(this.f21901e.f21890e, null, this.f21901e.f21890e.getResources().getString(R.string.create_forum_register_mobile_tip), this.f21901e.f21890e.getResources().getString(R.string.to_binding), this.f21901e.f21890e.getResources().getString(R.string.think_more), new C1018a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.f21901e.f21890e.getResources().getString(R.string.create_forum_err);
                if (b2 != null) {
                    string = k.isEmpty(b2.w()) ? this.f21901e.f21890e.getResources().getString(R.string.create_forum_err) : b2.w();
                }
                c.a.p0.t.h.a.b(this.f21901e.f21890e, null, string, this.f21901e.f21890e.getResources().getString(R.string.know), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // c.a.q0.i3.o0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.q0.i3.o0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.q0.i3.o0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.q0.i3.o0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f21903a;

        /* renamed from: b  reason: collision with root package name */
        public View f21904b;

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

        public /* synthetic */ g(a aVar, C1017a c1017a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f21905a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f21906b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21907c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f21908d;

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

        public /* synthetic */ h(a aVar, C1017a c1017a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f21909a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21910b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f21911c;

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

        public /* synthetic */ i(a aVar, C1017a c1017a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, c.a.q0.m0.m.b bVar) {
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
        this.f21895j = new ArrayList();
        this.k = true;
        this.o = new f(this);
        this.f21890e = tbPageContext;
        this.f21891f = viewEventCenter;
        this.n = new HashSet<>();
        this.m = bVar;
        c.a.q0.m0.m.e eVar = new c.a.q0.m0.m.e(this.f21890e, recentlyVisitedForumModel, viewEventCenter);
        this.f21892g = eVar;
        eVar.E(new C1017a(this, bVar));
        this.f21894i = enterForumModel;
        c.a.q0.m0.h.b bVar2 = new c.a.q0.m0.h.b(this.f21890e.getPageActivity(), Integer.valueOf(c.a.p0.s.d0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f21892g);
        this.f21893h = bVar2;
        bVar2.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.q0.m0.m.e eVar = this.f21892g;
            if (eVar == null) {
                return false;
            }
            return eVar.k();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        c.a.q0.m0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f21892g) == null) {
            return;
        }
        eVar.x();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f21895j.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f21895j.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f21895j.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.f21895j;
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
            if (i2 >= this.f21895j.size() || i2 < 0) {
                return 6;
            }
            return this.f21895j.get(i2).g();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        c.a.q0.m0.m.c cVar;
        x xVar;
        g gVar;
        h hVar;
        c.a.q0.m0.n.a aVar;
        c.a.q0.m0.n.e eVar;
        c.a.q0.m0.n.f fVar;
        c.a.q0.m0.n.d dVar;
        c.a.q0.m0.n.b bVar;
        c.a.q0.m0.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.f21890e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.f21909a = (TextView) view.findViewById(R.id.title);
                        iVar.f21910b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                        iVar.f21911c = (RelativeLayout) view.findViewById(R.id.container);
                        view.setTag(iVar);
                    }
                    if (this.f21895j.get(i2) instanceof c.a.q0.m0.d.e) {
                        c.a.q0.m0.d.e eVar2 = (c.a.q0.m0.d.e) this.f21895j.get(i2);
                        this.f21893h.v(iVar.f21910b);
                        this.f21893h.r();
                        this.f21893h.q(TbadkCoreApplication.getInst().getSkinType());
                        if (eVar2 != null) {
                            iVar.f21909a.setText(eVar2.f21930h);
                            SkinManager.setViewTextColor(iVar.f21909a, R.color.CAM_X0105);
                            c.a.q0.m0.d.c cVar3 = this.l;
                            if (cVar3 != null && cVar3.f21916a) {
                                SkinManager.setBackgroundResource(iVar.f21911c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f21911c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f21910b;
                            if (textView != null) {
                                if (eVar2.f21931i) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f21910b, R.color.transparent);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.m.c)) {
                        cVar = (c.a.q0.m0.m.c) view.getTag();
                    } else {
                        view = this.f21890e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                        cVar = new c.a.q0.m0.m.c(this.f21890e, view, this.f21891f);
                        view.setTag(cVar);
                    }
                    if ((this.f21895j.get(i2) instanceof x) && (xVar = this.f21895j.get(i2)) != null) {
                        cVar.k(xVar);
                    }
                    cVar.m(this.l);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.f21890e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.f21903a = (TextView) view.findViewById(R.id.footer_text);
                        gVar.f21904b = view.findViewById(R.id.container);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f21904b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.f21903a, R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.f21890e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.f21905a = view.findViewById(R.id.root);
                        hVar.f21906b = (ImageView) view.findViewById(R.id.image);
                        hVar.f21907c = (TextView) view.findViewById(R.id.hint_text);
                        hVar.f21908d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                        c.a.p0.s.f0.n.a aVar2 = new c.a.p0.s.f0.n.a();
                        hVar.f21908d.setTextSize(R.dimen.tbds42);
                        hVar.f21908d.setConfig(aVar2);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f21907c.setText(R.string.enter_forum_login_interest);
                        hVar.f21908d.setText(this.f21890e.getResources().getString(R.string.click_here_to_login_in));
                        hVar.f21908d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f21906b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f21907c.setText(R.string.forum_waiting_for_your_attention);
                        hVar.f21908d.setText(this.f21890e.getResources().getString(R.string.click_here_to_explore_more_forum));
                        SkinManager.setImageResource(hVar.f21906b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f21907c, R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.f21905a, R.color.CAM_X0205);
                    hVar.f21908d.changeSkinType();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f21908d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    View o = this.f21892g.o();
                    this.f21892g.z();
                    return o;
                case 5:
                    m();
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.a)) {
                        aVar = (c.a.q0.m0.n.a) view.getTag();
                    } else {
                        aVar = new c.a.q0.m0.n.a(this.f21890e);
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
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.e)) {
                        eVar = (c.a.q0.m0.n.e) view.getTag();
                    } else {
                        eVar = new c.a.q0.m0.n.e(this.f21890e);
                        view = eVar.d();
                        view.setTag(eVar);
                    }
                    if (this.f21895j.get(i2) instanceof r1) {
                        eVar.c((r1) this.f21895j.get(i2));
                    }
                    if (this.f21894i.A() == null || this.f21894i.A().e() == null || this.f21894i.A().e().b() == null) {
                        return view;
                    }
                    eVar.e(this.f21894i.A().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.f)) {
                        fVar = (c.a.q0.m0.n.f) view.getTag();
                    } else {
                        fVar = new c.a.q0.m0.n.f(this.f21890e);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.f21895j.get(i2) instanceof p1) {
                        p1 p1Var = (p1) this.f21895j.get(i2);
                        fVar.g(p1Var);
                        if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(p1Var.o()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", p1Var.o());
                            statisticItem.param("obj_locate", 1);
                            if (this.f21894i.A() != null && this.f21894i.A().e() != null && this.f21894i.A().e().b() != null) {
                                boolean z = this.f21894i.A().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                fVar.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.n.add(Long.valueOf(p1Var.o()));
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 9:
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.d)) {
                        dVar = (c.a.q0.m0.n.d) view.getTag();
                    } else {
                        dVar = new c.a.q0.m0.n.d(this.f21890e);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.f21895j.get(i2) instanceof q1) {
                        dVar.b((q1) this.f21895j.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.b)) {
                        bVar = (c.a.q0.m0.n.b) view.getTag();
                    } else {
                        bVar = new c.a.q0.m0.n.b(this.f21890e);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.f21895j.get(i2) instanceof c.a.q0.m0.d.a) {
                        bVar.c((c.a.q0.m0.d.a) this.f21895j.get(i2));
                    }
                    if (this.f21894i.A() == null || this.f21894i.A().e() == null || this.f21894i.A().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f21894i.A().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof c.a.q0.m0.n.c)) {
                        cVar2 = (c.a.q0.m0.n.c) view.getTag();
                    } else {
                        cVar2 = new c.a.q0.m0.n.c(this.f21890e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f14379g.length : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            this.n.clear();
        }
    }

    public void i(int i2) {
        c.a.q0.m0.h.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f21893h) == null) {
            return;
        }
        bVar.t(i2);
    }

    public void j(c.a.q0.m0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar != this.l) {
                this.l = cVar;
                boolean z = cVar.f21916a;
                boolean z2 = cVar.f21917b;
                int i2 = cVar.f21918c;
                notifyDataSetChanged();
            }
            c.a.q0.m0.m.e eVar = this.f21892g;
            if (eVar != null) {
                eVar.C(cVar);
            }
        }
    }

    public void k(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) {
            c.a.q0.m0.h.b bVar = this.f21893h;
            if (bVar != null) {
                bVar.p();
            }
            this.f21895j.clear();
            if (list != null) {
                this.f21895j.addAll(list);
            }
            this.m.V(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        c.a.q0.m0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || (eVar = this.f21892g) == null) {
            return;
        }
        eVar.F(bdUniqueId);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.k) {
            TiebaStatic.log("c13378");
            this.k = false;
        }
    }
}
