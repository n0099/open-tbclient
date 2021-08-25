package c.a.q0.j1.i.a.c;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.j;
import c.a.p0.b1.l;
import c.a.q0.i3.i0.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.view.ForumBroadcastMajorQuestionDialogView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f20825a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.q0.j1.i.a.a f20826b;

    /* renamed from: c  reason: collision with root package name */
    public View f20827c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f20828d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f20829e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f20830f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20831g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f20832h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.q0.j1.i.a.b.b> f20833i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f20834j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public c.a.p0.f0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public BdListView.p t;
    public c.a.p0.n.f<c.a.q0.j1.i.a.b.b> u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* renamed from: c.a.q0.j1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0965a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20835e;

        public C0965a(a aVar) {
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
            this.f20835e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20835e.f20829e != null) {
                    this.f20835e.f20829e.stopScroll();
                }
                this.f20835e.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.p0.n.f<c.a.q0.j1.i.a.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20836e;

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
            this.f20836e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: b */
        public void c(View view, c.a.q0.j1.i.a.b.b bVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.n.f
        /* renamed from: d */
        public void a(View view, c.a.q0.j1.i.a.b.b bVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bVar == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f20836e.n).param("tid", bVar.j() != null ? bVar.j().tid.longValue() : 0L));
            String str = "";
            if (view.getId() == R.id.forum_fail_edit) {
                if (l.a()) {
                    return;
                }
                if (this.f20836e.r) {
                    this.f20836e.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f20836e.f20825a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = this.f20836e.o;
                String str4 = this.f20836e.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() == null || bVar.j().is_deleted.intValue() == 1) {
                new BdTopToast(this.f20836e.f20825a.getPageActivity()).setIcon(false).setContent(this.f20836e.f20825a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).show((ViewGroup) this.f20836e.f20827c.findViewById(R.id.forum_major_history));
            } else {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f20836e.f20825a.getPageActivity());
                pbActivityConfig.createNormalCfg(bVar.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20837e;

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
            this.f20837e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", this.f20837e.n);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f20837e.f20825a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20838e;

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
            this.f20838e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.f20838e.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20839e;

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
            this.f20839e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || l.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f20839e.f20825a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(this.f20839e.n, this.f20839e.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20840e;

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
                    return;
                }
            }
            this.f20840e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (l.a()) {
                    return;
                }
                this.f20840e.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20841e;

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
                    return;
                }
            }
            this.f20841e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20841e.f20829e != null) {
                    this.f20841e.f20829e.stopScroll();
                }
                if (this.f20841e.f20830f == null || this.f20841e.f20826b == null || !j.z()) {
                    return;
                }
                this.f20841e.f20830f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f20841e.f20830f.z(null);
                if (this.f20841e.f20831g) {
                    this.f20841e.f20830f.L();
                    this.f20841e.f20826b.loadMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20842e;

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
                    return;
                }
            }
            this.f20842e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f20842e.f20826b != null) {
                this.f20842e.k();
                this.f20842e.f20826b.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.s.s.a f20843e;

        public i(a aVar, c.a.p0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20843e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.p0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f20843e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public a(TbPageContext<?> tbPageContext, c.a.q0.j1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, view, str, str2, str3, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20833i = new ArrayList();
        this.t = new C0965a(this);
        this.u = new b(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        this.f20825a = tbPageContext;
        this.f20826b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        c.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.dettachView(this.q);
        this.p = null;
    }

    public final void l(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str) == null) {
            this.f20827c = view;
            this.f20828d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
            this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
            this.f20828d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f20834j = (ImageView) this.f20828d.getCenterImgBox();
            LinearLayout linearLayout = (LinearLayout) this.f20828d.getCenterImgBoxLayout();
            this.k = linearLayout;
            linearLayout.setGravity(16);
            int g2 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            int g3 = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            ImageView imageView = this.f20834j;
            int i2 = R.drawable.ic_icon_creation_question16_svg;
            SkinManager.setNavbarIconSrc(imageView, i2, i2);
            this.f20828d.showBottomLine();
            this.m = this.f20828d.setCenterTextTitle(this.f20825a.getResources().getString(R.string.subscribe_bar_title));
            this.f20834j.setPadding(g2, g2, g2, g2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f20834j.getLayoutParams();
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            int i3 = g3 + g2 + g2;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f20834j.setLayoutParams(layoutParams2);
            this.f20834j.setVisibility(0);
            this.f20834j.setOnClickListener(this.v);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
            this.f20829e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f20825a.getPageActivity()));
            this.f20829e.setOverScrollMode(2);
            this.f20829e.setOnSrollToBottomListener(this.t);
            SkinManager.setBackgroundColor(this.f20829e, R.color.CAM_X0204);
            FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f20825a.getPageActivity());
            this.f20832h = froumBroadMajorHistoryAdapter;
            froumBroadMajorHistoryAdapter.setContentOnClickListener(this.u);
            this.f20829e.setAdapter(this.f20832h);
            PbListView pbListView = new PbListView(this.f20825a.getPageActivity());
            this.f20830f = pbListView;
            pbListView.b();
            this.f20830f.o(R.color.CAM_X0204);
            this.f20830f.r(c.a.e.e.p.l.g(this.f20825a.getPageActivity(), R.dimen.tbds182));
            this.f20830f.v();
            this.f20830f.E(R.dimen.tbfontsize33);
            this.f20830f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f20830f.y(R.color.CAM_X0110);
            this.f20830f.q();
            this.f20830f.z(this.y);
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
                s();
                int g4 = c.a.e.a.b.f().g();
                Activity e2 = c.a.e.a.b.f().e(g4 - 2);
                Activity e3 = c.a.e.a.b.f().e(g4 - 3);
                if (e2 == null || e3 == null || !"FlutterPageActivity".equals(e2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                    return;
                }
                e3.finish();
            }
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f20828d.onChangeSkinType(this.f20825a, i2);
            SkinManager.setBackgroundColor(this.f20829e, R.color.CAM_X0204);
            this.f20830f.d(i2);
            this.f20832h.notifyDataSetChanged();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f20833i = null;
            this.s = null;
        }
    }

    public void o(c.a.q0.j1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            c.a.q0.j1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f20831g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.f20833i.clear();
                this.f20833i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.f20833i.addAll(aVar.b());
        }
        this.f20832h.setFoumListData(this.f20833i);
        if (!aVar.c() || (bdRecyclerView = this.f20829e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f20829e.scrollToPosition(0);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f20830f == null || this.f20826b == null) {
            return;
        }
        if (j.z()) {
            this.f20829e.setNextPage(this.f20830f);
            this.f20830f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f20830f.z(null);
            if (this.f20831g) {
                this.f20830f.L();
                this.f20826b.loadMore();
                return;
            }
            this.f20830f.A(this.f20825a.getResources().getString(R.string.list_has_no_more));
            this.f20830f.f();
            return;
        }
        this.f20829e.setNextPage(null);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScreenTopToast screenTopToast = this.s;
            if (screenTopToast == null || !screenTopToast.isShow()) {
                ScreenTopToast btnClickListener = new ScreenTopToast(this.f20825a.getPageActivity()).setTitle(this.f20825a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).setBtnText(this.f20825a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new c(this));
                this.s = btnClickListener;
                btnClickListener.show((ViewGroup) this.f20827c.findViewById(R.id.forum_major_history));
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            c.a.p0.f0.h hVar = this.p;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.p == null) {
                    this.p = new c.a.p0.f0.h(this.f20825a.getPageActivity(), new h(this));
                }
                this.p.l(null);
                this.p.j(this.f20825a.getResources().getDimensionPixelSize(R.dimen.ds272));
                this.p.attachView(this.q, false);
                this.p.o();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f20827c == null) {
            return;
        }
        new BdTopToast(this.f20825a.getPageActivity()).setIcon(true).setContent(this.f20825a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).show((ViewGroup) this.f20827c.findViewById(R.id.forum_major_history));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(this.f20825a.getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f20825a.getPageActivity());
            forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
            aVar.setContentView(forumBroadcastMajorQuestionDialogView);
            aVar.create(this.f20825a).show();
        }
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, forumBroadcastMajorResidueData) == null) && this.l == null) {
            if (forumBroadcastMajorResidueData == null) {
                TextView addTextButton = this.f20828d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f20825a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton;
                SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.x() >= forumBroadcastMajorResidueData.w()) {
                this.r = true;
                TextView addTextButton2 = this.f20828d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f20825a.getString(R.string.dynamic_publish), this.x);
                this.l = addTextButton2;
                SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.l.setAlpha(0.33f);
            } else {
                TextView addTextButton3 = this.f20828d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f20825a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton3;
                SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }
}
