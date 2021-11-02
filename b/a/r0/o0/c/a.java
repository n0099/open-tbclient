package b.a.r0.o0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.q0.s.q.q1;
import b.a.q0.s.q.r1;
import b.a.q0.s.q.s1;
import b.a.q0.s.q.x;
import b.a.q0.s.s.a;
import b.a.r0.l3.p0.f;
import b.a.r0.o0.h.b;
import b.a.r0.o0.m.e;
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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f21536e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f21537f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.o0.m.e f21538g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.o0.h.b f21539h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f21540i;
    public List<x> j;
    public boolean k;
    public b.a.r0.o0.d.c l;
    public b.a.r0.o0.m.b m;
    public HashSet<Long> n;
    public f.c o;

    /* renamed from: b.a.r0.o0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1055a implements e.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.o0.m.b f21541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21542b;

        public C1055a(a aVar, b.a.r0.o0.m.b bVar) {
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
            this.f21542b = aVar;
            this.f21541a = bVar;
        }

        @Override // b.a.r0.o0.m.e.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21542b.notifyDataSetChanged();
                this.f21541a.s0(this.f21542b.f21538g.s());
                this.f21541a.t0(this.f21542b.f21538g.t());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f21543a;

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
            this.f21543a = aVar;
        }

        @Override // b.a.r0.o0.h.b.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f21543a.f21540i.I(true, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21544e;

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
            this.f21544e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21544e.f21537f == null) {
                return;
            }
            this.f21544e.f21537f.dispatchMvcEvent(new b.a.q0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21545e;

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
            this.f21545e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21545e.f21537f == null) {
                return;
            }
            this.f21545e.f21537f.dispatchMvcEvent(new b.a.q0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21546e;

        /* renamed from: b.a.r0.o0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1056a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f21547e;

            public C1056a(e eVar) {
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
                this.f21547e = eVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    b.a.r0.l3.p0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.f21547e.f21546e.o);
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
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

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
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
            this.f21546e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.f21546e.f21540i.y()) {
                    if (this.f21546e.f21537f != null) {
                        this.f21546e.f21537f.dispatchMvcEvent(new b.a.q0.k0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.f21546e.f21540i.A().b();
                if (b2 != null) {
                    int x = b2.x();
                    if (x == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = k.isEmpty(b2.w()) ? this.f21546e.f21536e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                        blockPopInfoData.ahead_info = this.f21546e.f21536e.getResources().getString(R.string.create_forum_feed);
                        blockPopInfoData.ok_info = this.f21546e.f21536e.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.f21546e.f21536e.getPageActivity(), blockPopInfoData);
                    } else if (x == 2121002) {
                        b.a.q0.t.h.a.b(this.f21546e.f21536e, null, this.f21546e.f21536e.getResources().getString(R.string.create_forum_register_mobile_tip), this.f21546e.f21536e.getResources().getString(R.string.to_binding), this.f21546e.f21536e.getResources().getString(R.string.think_more), new C1056a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.f21546e.f21536e.getResources().getString(R.string.create_forum_err);
                if (b2 != null) {
                    string = k.isEmpty(b2.w()) ? this.f21546e.f21536e.getResources().getString(R.string.create_forum_err) : b2.w();
                }
                b.a.q0.t.h.a.b(this.f21546e.f21536e, null, string, this.f21546e.f21536e.getResources().getString(R.string.know), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes5.dex */
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

        @Override // b.a.r0.l3.p0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // b.a.r0.l3.p0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f21548a;

        /* renamed from: b  reason: collision with root package name */
        public View f21549b;

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

        public /* synthetic */ g(a aVar, C1055a c1055a) {
            this(aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f21550a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f21551b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f21552c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f21553d;

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

        public /* synthetic */ h(a aVar, C1055a c1055a) {
            this(aVar);
        }
    }

    /* loaded from: classes5.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f21554a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f21555b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f21556c;

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

        public /* synthetic */ i(a aVar, C1055a c1055a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, b.a.r0.o0.m.b bVar) {
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
        this.j = new ArrayList();
        this.k = true;
        this.o = new f(this);
        this.f21536e = tbPageContext;
        this.f21537f = viewEventCenter;
        this.n = new HashSet<>();
        this.m = bVar;
        b.a.r0.o0.m.e eVar = new b.a.r0.o0.m.e(this.f21536e, recentlyVisitedForumModel, viewEventCenter);
        this.f21538g = eVar;
        eVar.E(new C1055a(this, bVar));
        this.f21540i = enterForumModel;
        b.a.r0.o0.h.b bVar2 = new b.a.r0.o0.h.b(this.f21536e.getPageActivity(), Integer.valueOf(b.a.q0.s.e0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f21538g);
        this.f21539h = bVar2;
        bVar2.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.r0.o0.m.e eVar = this.f21538g;
            if (eVar == null) {
                return false;
            }
            return eVar.k();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        b.a.r0.o0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f21538g) == null) {
            return;
        }
        eVar.x();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.j.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.j.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.j;
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
            if (i2 >= this.j.size() || i2 < 0) {
                return 6;
            }
            return this.j.get(i2).g();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        b.a.r0.o0.m.c cVar;
        x xVar;
        g gVar;
        h hVar;
        b.a.r0.o0.n.a aVar;
        b.a.r0.o0.n.e eVar;
        b.a.r0.o0.n.f fVar;
        b.a.r0.o0.n.d dVar;
        b.a.r0.o0.n.b bVar;
        b.a.r0.o0.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.f21536e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.f21554a = (TextView) view.findViewById(R.id.title);
                        iVar.f21555b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                        iVar.f21556c = (RelativeLayout) view.findViewById(R.id.container);
                        view.setTag(iVar);
                    }
                    if (this.j.get(i2) instanceof b.a.r0.o0.d.e) {
                        b.a.r0.o0.d.e eVar2 = (b.a.r0.o0.d.e) this.j.get(i2);
                        this.f21539h.v(iVar.f21555b);
                        this.f21539h.r();
                        this.f21539h.q(TbadkCoreApplication.getInst().getSkinType());
                        if (eVar2 != null) {
                            iVar.f21554a.setText(eVar2.f21574h);
                            SkinManager.setViewTextColor(iVar.f21554a, R.color.CAM_X0105);
                            b.a.r0.o0.d.c cVar3 = this.l;
                            if (cVar3 != null && cVar3.f21561a) {
                                SkinManager.setBackgroundResource(iVar.f21556c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f21556c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f21555b;
                            if (textView != null) {
                                if (eVar2.f21575i) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f21555b, R.color.transparent);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.m.c)) {
                        cVar = (b.a.r0.o0.m.c) view.getTag();
                    } else {
                        view = this.f21536e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                        cVar = new b.a.r0.o0.m.c(this.f21536e, view, this.f21537f);
                        view.setTag(cVar);
                    }
                    if ((this.j.get(i2) instanceof x) && (xVar = this.j.get(i2)) != null) {
                        cVar.h(xVar);
                    }
                    cVar.j(this.l);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.f21536e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.f21548a = (TextView) view.findViewById(R.id.footer_text);
                        gVar.f21549b = view.findViewById(R.id.container);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f21549b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.f21548a, R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.f21536e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.f21550a = view.findViewById(R.id.root);
                        hVar.f21551b = (ImageView) view.findViewById(R.id.image);
                        hVar.f21552c = (TextView) view.findViewById(R.id.hint_text);
                        hVar.f21553d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                        b.a.q0.s.g0.n.a aVar2 = new b.a.q0.s.g0.n.a();
                        hVar.f21553d.setTextSize(R.dimen.tbds42);
                        hVar.f21553d.setConfig(aVar2);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f21552c.setText(R.string.enter_forum_login_interest);
                        hVar.f21553d.setText(this.f21536e.getResources().getString(R.string.click_here_to_login_in));
                        hVar.f21553d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f21551b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f21552c.setText(R.string.forum_waiting_for_your_attention);
                        hVar.f21553d.setText(this.f21536e.getResources().getString(R.string.click_here_to_explore_more_forum));
                        SkinManager.setImageResource(hVar.f21551b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f21552c, R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.f21550a, R.color.CAM_X0205);
                    hVar.f21553d.changeSkinType();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f21553d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    View o = this.f21538g.o();
                    this.f21538g.z();
                    return o;
                case 5:
                    m();
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.a)) {
                        aVar = (b.a.r0.o0.n.a) view.getTag();
                    } else {
                        aVar = new b.a.r0.o0.n.a(this.f21536e);
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
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.e)) {
                        eVar = (b.a.r0.o0.n.e) view.getTag();
                    } else {
                        eVar = new b.a.r0.o0.n.e(this.f21536e);
                        view = eVar.d();
                        view.setTag(eVar);
                    }
                    if (this.j.get(i2) instanceof s1) {
                        eVar.c((s1) this.j.get(i2));
                    }
                    if (this.f21540i.A() == null || this.f21540i.A().e() == null || this.f21540i.A().e().b() == null) {
                        return view;
                    }
                    eVar.e(this.f21540i.A().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.f)) {
                        fVar = (b.a.r0.o0.n.f) view.getTag();
                    } else {
                        fVar = new b.a.r0.o0.n.f(this.f21536e);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.j.get(i2) instanceof q1) {
                        q1 q1Var = (q1) this.j.get(i2);
                        fVar.g(q1Var);
                        if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(q1Var.o()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", q1Var.o());
                            statisticItem.param("obj_locate", 1);
                            if (this.f21540i.A() != null && this.f21540i.A().e() != null && this.f21540i.A().e().b() != null) {
                                boolean z = this.f21540i.A().e().b().size() > 0;
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
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.d)) {
                        dVar = (b.a.r0.o0.n.d) view.getTag();
                    } else {
                        dVar = new b.a.r0.o0.n.d(this.f21536e);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.j.get(i2) instanceof r1) {
                        dVar.b((r1) this.j.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.b)) {
                        bVar = (b.a.r0.o0.n.b) view.getTag();
                    } else {
                        bVar = new b.a.r0.o0.n.b(this.f21536e);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.j.get(i2) instanceof b.a.r0.o0.d.a) {
                        bVar.c((b.a.r0.o0.d.a) this.j.get(i2));
                    }
                    if (this.f21540i.A() == null || this.f21540i.A().e() == null || this.f21540i.A().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f21540i.A().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof b.a.r0.o0.n.c)) {
                        cVar2 = (b.a.r0.o0.n.c) view.getTag();
                    } else {
                        cVar2 = new b.a.r0.o0.n.c(this.f21536e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f13476g.length : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            this.n.clear();
        }
    }

    public void i(int i2) {
        b.a.r0.o0.h.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f21539h) == null) {
            return;
        }
        bVar.t(i2);
    }

    public void j(b.a.r0.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar != this.l) {
                this.l = cVar;
                boolean z = cVar.f21561a;
                boolean z2 = cVar.f21562b;
                int i2 = cVar.f21563c;
                notifyDataSetChanged();
            }
            b.a.r0.o0.m.e eVar = this.f21538g;
            if (eVar != null) {
                eVar.C(cVar);
            }
        }
    }

    public void k(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) {
            b.a.r0.o0.h.b bVar = this.f21539h;
            if (bVar != null) {
                bVar.p();
            }
            this.j.clear();
            if (list != null) {
                this.j.addAll(list);
            }
            this.m.V(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        b.a.r0.o0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || (eVar = this.f21538g) == null) {
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
