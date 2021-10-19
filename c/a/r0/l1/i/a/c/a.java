package c.a.r0.l1.i.a.c;

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
import c.a.e.e.p.l;
import c.a.q0.d1.o;
import c.a.r0.k3.i0.n;
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
    public final TbPageContext<?> f21589a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.l1.i.a.a f21590b;

    /* renamed from: c  reason: collision with root package name */
    public View f21591c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f21592d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f21593e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f21594f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21595g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f21596h;

    /* renamed from: i  reason: collision with root package name */
    public List<c.a.r0.l1.i.a.b.b> f21597i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f21598j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public c.a.q0.g0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public BdListView.p t;
    public c.a.q0.n.f<c.a.r0.l1.i.a.b.b> u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* renamed from: c.a.r0.l1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1005a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21599e;

        public C1005a(a aVar) {
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
            this.f21599e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f21599e.f21593e != null) {
                    this.f21599e.f21593e.stopScroll();
                }
                this.f21599e.p();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.q0.n.f<c.a.r0.l1.i.a.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21600e;

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
            this.f21600e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: b */
        public void c(View view, c.a.r0.l1.i.a.b.b bVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.n.f
        /* renamed from: d */
        public void a(View view, c.a.r0.l1.i.a.b.b bVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || bVar == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f21600e.n).param("tid", bVar.j() != null ? bVar.j().tid.longValue() : 0L));
            String str = "";
            if (view.getId() == R.id.forum_fail_edit) {
                if (o.a()) {
                    return;
                }
                if (this.f21600e.r) {
                    this.f21600e.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f21600e.f21589a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = this.f21600e.o;
                String str4 = this.f21600e.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() == null || bVar.j().is_deleted.intValue() == 1) {
                new BdTopToast(this.f21600e.f21589a.getPageActivity()).setIcon(false).setContent(this.f21600e.f21589a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted)).show((ViewGroup) this.f21600e.f21591c.findViewById(R.id.forum_major_history));
            } else {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f21600e.f21589a.getPageActivity());
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
        public final /* synthetic */ a f21601e;

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
            this.f21601e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", this.f21601e.n);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new n(this.f21601e.f21589a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21602e;

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
            this.f21602e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.f21602e.t();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21603e;

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
            this.f21603e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || o.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f21603e.f21589a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(this.f21603e.n, this.f21603e.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21604e;

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
            this.f21604e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (o.a()) {
                    return;
                }
                this.f21604e.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21605e;

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
            this.f21605e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f21605e.f21593e != null) {
                    this.f21605e.f21593e.stopScroll();
                }
                if (this.f21605e.f21594f == null || this.f21605e.f21590b == null || !j.z()) {
                    return;
                }
                this.f21605e.f21594f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f21605e.f21594f.z(null);
                if (this.f21605e.f21595g) {
                    this.f21605e.f21594f.L();
                    this.f21605e.f21590b.loadMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f21606e;

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
            this.f21606e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f21606e.f21590b != null) {
                this.f21606e.k();
                this.f21606e.f21590b.refresh();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f21607e;

        public i(a aVar, c.a.q0.s.s.a aVar2) {
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
            this.f21607e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f21607e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public a(TbPageContext<?> tbPageContext, c.a.r0.l1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
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
        this.f21597i = new ArrayList();
        this.t = new C1005a(this);
        this.u = new b(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        this.f21589a = tbPageContext;
        this.f21590b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        c.a.q0.g0.h hVar;
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
            this.f21591c = view;
            this.f21592d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
            this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
            this.f21592d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f21598j = (ImageView) this.f21592d.getCenterImgBox();
            LinearLayout linearLayout = (LinearLayout) this.f21592d.getCenterImgBoxLayout();
            this.k = linearLayout;
            linearLayout.setGravity(16);
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            ImageView imageView = this.f21598j;
            int i2 = R.drawable.ic_icon_creation_question16_svg;
            SkinManager.setNavbarIconSrc(imageView, i2, i2);
            this.f21592d.showBottomLine();
            this.m = this.f21592d.setCenterTextTitle(this.f21589a.getResources().getString(R.string.subscribe_bar_title));
            this.f21598j.setPadding(g2, g2, g2, g2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f21598j.getLayoutParams();
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            int i3 = g3 + g2 + g2;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f21598j.setLayoutParams(layoutParams2);
            this.f21598j.setVisibility(0);
            this.f21598j.setOnClickListener(this.v);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
            this.f21593e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f21589a.getPageActivity()));
            this.f21593e.setOverScrollMode(2);
            this.f21593e.setOnSrollToBottomListener(this.t);
            SkinManager.setBackgroundColor(this.f21593e, R.color.CAM_X0204);
            FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f21589a.getPageActivity());
            this.f21596h = froumBroadMajorHistoryAdapter;
            froumBroadMajorHistoryAdapter.setContentOnClickListener(this.u);
            this.f21593e.setAdapter(this.f21596h);
            PbListView pbListView = new PbListView(this.f21589a.getPageActivity());
            this.f21594f = pbListView;
            pbListView.b();
            this.f21594f.o(R.color.CAM_X0204);
            this.f21594f.r(l.g(this.f21589a.getPageActivity(), R.dimen.tbds182));
            this.f21594f.v();
            this.f21594f.E(R.dimen.tbfontsize33);
            this.f21594f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f21594f.y(R.color.CAM_X0110);
            this.f21594f.q();
            this.f21594f.z(this.y);
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
                s();
                int h2 = c.a.e.a.b.g().h();
                Activity f2 = c.a.e.a.b.g().f(h2 - 2);
                Activity f3 = c.a.e.a.b.g().f(h2 - 3);
                if (f2 == null || f3 == null || !"FlutterPageActivity".equals(f2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(f3.getClass().getSimpleName())) {
                    return;
                }
                f3.finish();
            }
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f21592d.onChangeSkinType(this.f21589a, i2);
            SkinManager.setBackgroundColor(this.f21593e, R.color.CAM_X0204);
            this.f21594f.d(i2);
            this.f21596h.notifyDataSetChanged();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21597i = null;
            this.s = null;
        }
    }

    public void o(c.a.r0.l1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            c.a.r0.l1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f21595g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.f21597i.clear();
                this.f21597i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.f21597i.addAll(aVar.b());
        }
        this.f21596h.setFoumListData(this.f21597i);
        if (!aVar.c() || (bdRecyclerView = this.f21593e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f21593e.scrollToPosition(0);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f21594f == null || this.f21590b == null) {
            return;
        }
        if (j.z()) {
            this.f21593e.setNextPage(this.f21594f);
            this.f21594f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f21594f.z(null);
            if (this.f21595g) {
                this.f21594f.L();
                this.f21590b.loadMore();
                return;
            }
            this.f21594f.A(this.f21589a.getResources().getString(R.string.list_has_no_more));
            this.f21594f.f();
            return;
        }
        this.f21593e.setNextPage(null);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScreenTopToast screenTopToast = this.s;
            if (screenTopToast == null || !screenTopToast.isShow()) {
                ScreenTopToast btnClickListener = new ScreenTopToast(this.f21589a.getPageActivity()).setTitle(this.f21589a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint)).setBtnText(this.f21589a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn)).setBtnClickListener(new c(this));
                this.s = btnClickListener;
                btnClickListener.show((ViewGroup) this.f21591c.findViewById(R.id.forum_major_history));
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            c.a.q0.g0.h hVar = this.p;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.p == null) {
                    this.p = new c.a.q0.g0.h(this.f21589a.getPageActivity(), new h(this));
                }
                this.p.l(null);
                this.p.j(this.f21589a.getResources().getDimensionPixelSize(R.dimen.ds272));
                this.p.attachView(this.q, false);
                this.p.o();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f21591c == null) {
            return;
        }
        new BdTopToast(this.f21589a.getPageActivity()).setIcon(true).setContent(this.f21589a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip)).show((ViewGroup) this.f21591c.findViewById(R.id.forum_major_history));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f21589a.getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f21589a.getPageActivity());
            forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
            aVar.setContentView(forumBroadcastMajorQuestionDialogView);
            aVar.create(this.f21589a).show();
        }
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, forumBroadcastMajorResidueData) == null) && this.l == null) {
            if (forumBroadcastMajorResidueData == null) {
                TextView addTextButton = this.f21592d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21589a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton;
                SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.x() >= forumBroadcastMajorResidueData.w()) {
                this.r = true;
                TextView addTextButton2 = this.f21592d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21589a.getString(R.string.dynamic_publish), this.x);
                this.l = addTextButton2;
                SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.l.setAlpha(0.33f);
            } else {
                TextView addTextButton3 = this.f21592d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21589a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton3;
                SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }
}
