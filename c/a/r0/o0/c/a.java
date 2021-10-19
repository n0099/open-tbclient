package c.a.r0.o0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.s.q.q1;
import c.a.q0.s.q.r1;
import c.a.q0.s.q.s1;
import c.a.q0.s.q.x;
import c.a.q0.s.s.a;
import c.a.r0.k3.o0.f;
import c.a.r0.o0.h.b;
import c.a.r0.o0.m.e;
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
    public TbPageContext<?> f22658e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f22659f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.o0.m.e f22660g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.o0.h.b f22661h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f22662i;

    /* renamed from: j  reason: collision with root package name */
    public List<x> f22663j;
    public boolean k;
    public c.a.r0.o0.d.c l;
    public c.a.r0.o0.m.b m;
    public HashSet<Long> n;
    public f.c o;

    /* renamed from: c.a.r0.o0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1058a implements e.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.o0.m.b f22664a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f22665b;

        public C1058a(a aVar, c.a.r0.o0.m.b bVar) {
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
            this.f22665b = aVar;
            this.f22664a = bVar;
        }

        @Override // c.a.r0.o0.m.e.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22665b.notifyDataSetChanged();
                this.f22664a.s0(this.f22665b.f22660g.s());
                this.f22664a.t0(this.f22665b.f22660g.t());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f22666a;

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
            this.f22666a = aVar;
        }

        @Override // c.a.r0.o0.h.b.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f22666a.f22662i.I(true, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22667e;

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
            this.f22667e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22667e.f22659f == null) {
                return;
            }
            this.f22667e.f22659f.dispatchMvcEvent(new c.a.q0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22668e;

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
            this.f22668e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f22668e.f22659f == null) {
                return;
            }
            this.f22668e.f22659f.dispatchMvcEvent(new c.a.q0.k0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f22669e;

        /* renamed from: c.a.r0.o0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1059a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f22670e;

            public C1059a(e eVar) {
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
                this.f22670e = eVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    c.a.r0.k3.o0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.f22670e.f22669e.o);
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
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

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
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
            this.f22669e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.f22669e.f22662i.y()) {
                    if (this.f22669e.f22659f != null) {
                        this.f22669e.f22659f.dispatchMvcEvent(new c.a.q0.k0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.f22669e.f22662i.A().b();
                if (b2 != null) {
                    int x = b2.x();
                    if (x == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = k.isEmpty(b2.w()) ? this.f22669e.f22658e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                        blockPopInfoData.ahead_info = this.f22669e.f22658e.getResources().getString(R.string.create_forum_feed);
                        blockPopInfoData.ok_info = this.f22669e.f22658e.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.f22669e.f22658e.getPageActivity(), blockPopInfoData);
                    } else if (x == 2121002) {
                        c.a.q0.t.h.a.b(this.f22669e.f22658e, null, this.f22669e.f22658e.getResources().getString(R.string.create_forum_register_mobile_tip), this.f22669e.f22658e.getResources().getString(R.string.to_binding), this.f22669e.f22658e.getResources().getString(R.string.think_more), new C1059a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.f22669e.f22658e.getResources().getString(R.string.create_forum_err);
                if (b2 != null) {
                    string = k.isEmpty(b2.w()) ? this.f22669e.f22658e.getResources().getString(R.string.create_forum_err) : b2.w();
                }
                c.a.q0.t.h.a.b(this.f22669e.f22658e, null, string, this.f22669e.f22658e.getResources().getString(R.string.know), null, new c(this), null).show();
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

        @Override // c.a.r0.k3.o0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.r0.k3.o0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // c.a.r0.k3.o0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // c.a.r0.k3.o0.f.c
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
        public TextView f22671a;

        /* renamed from: b  reason: collision with root package name */
        public View f22672b;

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

        public /* synthetic */ g(a aVar, C1058a c1058a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f22673a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f22674b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f22675c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f22676d;

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

        public /* synthetic */ h(a aVar, C1058a c1058a) {
            this(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f22677a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f22678b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f22679c;

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

        public /* synthetic */ i(a aVar, C1058a c1058a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, c.a.r0.o0.m.b bVar) {
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
        this.f22663j = new ArrayList();
        this.k = true;
        this.o = new f(this);
        this.f22658e = tbPageContext;
        this.f22659f = viewEventCenter;
        this.n = new HashSet<>();
        this.m = bVar;
        c.a.r0.o0.m.e eVar = new c.a.r0.o0.m.e(this.f22658e, recentlyVisitedForumModel, viewEventCenter);
        this.f22660g = eVar;
        eVar.E(new C1058a(this, bVar));
        this.f22662i = enterForumModel;
        c.a.r0.o0.h.b bVar2 = new c.a.r0.o0.h.b(this.f22658e.getPageActivity(), Integer.valueOf(c.a.q0.s.d0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f22660g);
        this.f22661h = bVar2;
        bVar2.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.r0.o0.m.e eVar = this.f22660g;
            if (eVar == null) {
                return false;
            }
            return eVar.k();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        c.a.r0.o0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.f22660g) == null) {
            return;
        }
        eVar.x();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f22663j.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f22663j.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f22663j.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.f22663j;
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
            if (i2 >= this.f22663j.size() || i2 < 0) {
                return 6;
            }
            return this.f22663j.get(i2).g();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        c.a.r0.o0.m.c cVar;
        x xVar;
        g gVar;
        h hVar;
        c.a.r0.o0.n.a aVar;
        c.a.r0.o0.n.e eVar;
        c.a.r0.o0.n.f fVar;
        c.a.r0.o0.n.d dVar;
        c.a.r0.o0.n.b bVar;
        c.a.r0.o0.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.f22658e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.f22677a = (TextView) view.findViewById(R.id.title);
                        iVar.f22678b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                        iVar.f22679c = (RelativeLayout) view.findViewById(R.id.container);
                        view.setTag(iVar);
                    }
                    if (this.f22663j.get(i2) instanceof c.a.r0.o0.d.e) {
                        c.a.r0.o0.d.e eVar2 = (c.a.r0.o0.d.e) this.f22663j.get(i2);
                        this.f22661h.v(iVar.f22678b);
                        this.f22661h.r();
                        this.f22661h.q(TbadkCoreApplication.getInst().getSkinType());
                        if (eVar2 != null) {
                            iVar.f22677a.setText(eVar2.f22698h);
                            SkinManager.setViewTextColor(iVar.f22677a, R.color.CAM_X0105);
                            c.a.r0.o0.d.c cVar3 = this.l;
                            if (cVar3 != null && cVar3.f22684a) {
                                SkinManager.setBackgroundResource(iVar.f22679c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f22679c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f22678b;
                            if (textView != null) {
                                if (eVar2.f22699i) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f22678b, R.color.transparent);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.m.c)) {
                        cVar = (c.a.r0.o0.m.c) view.getTag();
                    } else {
                        view = this.f22658e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                        cVar = new c.a.r0.o0.m.c(this.f22658e, view, this.f22659f);
                        view.setTag(cVar);
                    }
                    if ((this.f22663j.get(i2) instanceof x) && (xVar = this.f22663j.get(i2)) != null) {
                        cVar.k(xVar);
                    }
                    cVar.m(this.l);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.f22658e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.f22671a = (TextView) view.findViewById(R.id.footer_text);
                        gVar.f22672b = view.findViewById(R.id.container);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f22672b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.f22671a, R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.f22658e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.f22673a = view.findViewById(R.id.root);
                        hVar.f22674b = (ImageView) view.findViewById(R.id.image);
                        hVar.f22675c = (TextView) view.findViewById(R.id.hint_text);
                        hVar.f22676d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                        c.a.q0.s.f0.n.a aVar2 = new c.a.q0.s.f0.n.a();
                        hVar.f22676d.setTextSize(R.dimen.tbds42);
                        hVar.f22676d.setConfig(aVar2);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f22675c.setText(R.string.enter_forum_login_interest);
                        hVar.f22676d.setText(this.f22658e.getResources().getString(R.string.click_here_to_login_in));
                        hVar.f22676d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f22674b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f22675c.setText(R.string.forum_waiting_for_your_attention);
                        hVar.f22676d.setText(this.f22658e.getResources().getString(R.string.click_here_to_explore_more_forum));
                        SkinManager.setImageResource(hVar.f22674b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f22675c, R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.f22673a, R.color.CAM_X0205);
                    hVar.f22676d.changeSkinType();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f22676d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    View o = this.f22660g.o();
                    this.f22660g.z();
                    return o;
                case 5:
                    m();
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.a)) {
                        aVar = (c.a.r0.o0.n.a) view.getTag();
                    } else {
                        aVar = new c.a.r0.o0.n.a(this.f22658e);
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
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.e)) {
                        eVar = (c.a.r0.o0.n.e) view.getTag();
                    } else {
                        eVar = new c.a.r0.o0.n.e(this.f22658e);
                        view = eVar.d();
                        view.setTag(eVar);
                    }
                    if (this.f22663j.get(i2) instanceof s1) {
                        eVar.c((s1) this.f22663j.get(i2));
                    }
                    if (this.f22662i.A() == null || this.f22662i.A().e() == null || this.f22662i.A().e().b() == null) {
                        return view;
                    }
                    eVar.e(this.f22662i.A().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.f)) {
                        fVar = (c.a.r0.o0.n.f) view.getTag();
                    } else {
                        fVar = new c.a.r0.o0.n.f(this.f22658e);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.f22663j.get(i2) instanceof q1) {
                        q1 q1Var = (q1) this.f22663j.get(i2);
                        fVar.g(q1Var);
                        if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(q1Var.o()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", q1Var.o());
                            statisticItem.param("obj_locate", 1);
                            if (this.f22662i.A() != null && this.f22662i.A().e() != null && this.f22662i.A().e().b() != null) {
                                boolean z = this.f22662i.A().e().b().size() > 0;
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
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.d)) {
                        dVar = (c.a.r0.o0.n.d) view.getTag();
                    } else {
                        dVar = new c.a.r0.o0.n.d(this.f22658e);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.f22663j.get(i2) instanceof r1) {
                        dVar.b((r1) this.f22663j.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.b)) {
                        bVar = (c.a.r0.o0.n.b) view.getTag();
                    } else {
                        bVar = new c.a.r0.o0.n.b(this.f22658e);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.f22663j.get(i2) instanceof c.a.r0.o0.d.a) {
                        bVar.c((c.a.r0.o0.d.a) this.f22663j.get(i2));
                    }
                    if (this.f22662i.A() == null || this.f22662i.A().e() == null || this.f22662i.A().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f22662i.A().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof c.a.r0.o0.n.c)) {
                        cVar2 = (c.a.r0.o0.n.c) view.getTag();
                    } else {
                        cVar2 = new c.a.r0.o0.n.c(this.f22658e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f14363g.length : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            this.n.clear();
        }
    }

    public void i(int i2) {
        c.a.r0.o0.h.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f22661h) == null) {
            return;
        }
        bVar.t(i2);
    }

    public void j(c.a.r0.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar != this.l) {
                this.l = cVar;
                boolean z = cVar.f22684a;
                boolean z2 = cVar.f22685b;
                int i2 = cVar.f22686c;
                notifyDataSetChanged();
            }
            c.a.r0.o0.m.e eVar = this.f22660g;
            if (eVar != null) {
                eVar.C(cVar);
            }
        }
    }

    public void k(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) {
            c.a.r0.o0.h.b bVar = this.f22661h;
            if (bVar != null) {
                bVar.p();
            }
            this.f22663j.clear();
            if (list != null) {
                this.f22663j.addAll(list);
            }
            this.m.V(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        c.a.r0.o0.m.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || (eVar = this.f22660g) == null) {
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
