package c.a.r0.o0.m;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.l.e.l;
import c.a.r0.o0.g.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f23035a;

    /* renamed from: b  reason: collision with root package name */
    public int f23036b;

    /* renamed from: c  reason: collision with root package name */
    public View f23037c;

    /* renamed from: d  reason: collision with root package name */
    public View f23038d;

    /* renamed from: e  reason: collision with root package name */
    public RecentlyVisitedForumModel f23039e;

    /* renamed from: f  reason: collision with root package name */
    public Vibrator f23040f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f23041g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f23042h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f23043i;

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f23044j;
    public View k;
    public RecentlyVisitedForumListAdapter l;
    public boolean m;
    public boolean n;
    public ViewEventCenter o;
    public c.a.r0.o0.h.e p;
    public l q;
    public c.a.r0.o0.d.c r;
    public j s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23045a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f23045a.q == null) {
                        this.f23045a.q = new l(new c.a.e.l.e.j());
                    }
                    this.f23045a.q.q(this.f23045a.f23044j, 1);
                } else if (this.f23045a.q != null) {
                    this.f23045a.q.w();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23046a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23046a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f23046a.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23047e;

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
                    return;
                }
            }
            this.f23047e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23047e.B();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23048e;

        public d(e eVar) {
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
            this.f23048e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f23048e.D(false);
            }
        }
    }

    /* renamed from: c.a.r0.o0.m.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1077e implements RecentlyVisitedForumListAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23049a;

        public C1077e(e eVar) {
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
            this.f23049a = eVar;
        }

        @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
        public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, forumViewHolder) == null) || this.f23049a.n || forumViewHolder == null || (view = forumViewHolder.itemView) == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
            FrsActivityConfig callFrom = new FrsActivityConfig(this.f23049a.f23035a.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
            this.f23049a.l(forumViewHolder, callFrom.getIntent(), visitedForumData.z());
            this.f23049a.f23035a.sendMessage(new CustomMessage(2003000, callFrom));
            TiebaStatic.log(new StatisticItem("c13002").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23050e;

        public f(e eVar) {
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
            this.f23050e = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f23050e.D(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f23051e;

        public g(e eVar) {
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
            this.f23051e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23051e.f23039e == null || view.getTag() == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
            this.f23051e.f23039e.w(visitedForumData);
            TiebaStatic.log(new StatisticItem("c13005").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes3.dex */
    public class h implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23052a;

        public h(e eVar) {
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
            this.f23052a = eVar;
        }

        @Override // c.a.r0.o0.g.a.f
        public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, linkedList, z) == null) {
                this.f23052a.y(linkedList);
                if (z || this.f23052a.p == null) {
                    return;
                }
                this.f23052a.p.c(linkedList, this.f23052a.f23035a.getResources().getDimensionPixelSize(R.dimen.tbds678) + this.f23052a.f23035a.getResources().getDimensionPixelSize(R.dimen.tbds10));
            }
        }

        @Override // c.a.r0.o0.g.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f23052a.v(i2);
            }
        }

        @Override // c.a.r0.o0.g.a.f
        public void onNotify() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f23052a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f23053a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23053a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f23053a.m(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes3.dex */
    public class k extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f23054a;

        /* renamed from: b  reason: collision with root package name */
        public int f23055b;

        /* renamed from: c  reason: collision with root package name */
        public int f23056c;

        public k(e eVar, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23054a = i2;
            this.f23055b = i3;
            this.f23056c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view) == 0) {
                        rect.top = this.f23054a;
                    } else {
                        rect.top = this.f23055b;
                    }
                    if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.f23056c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.left = this.f23054a;
                } else {
                    rect.left = this.f23055b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.f23056c;
                }
            }
        }
    }

    public e(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, recentlyVisitedForumModel, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23036b = 3;
        this.m = true;
        this.n = false;
        this.t = new a(this, 2156674);
        this.u = new b(this, 2001011);
        this.v = new i(this, 2921347);
        this.f23035a = tbPageContext;
        this.f23039e = recentlyVisitedForumModel;
        this.o = viewEventCenter;
        this.f23040f = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.p = new c.a.r0.o0.h.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.t);
        MessageManager.getInstance().registerListener(this.u);
        p();
        q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.o0.d.c cVar = this.r;
            if (cVar != null && cVar.f22684a) {
                SkinManager.setViewTextColor(this.f23041g, R.color.CAM_X0101);
                this.f23037c.setBackgroundColor(0);
                SkinManager.setViewTextColorSelector(this.f23043i, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
                this.f23043i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
            } else {
                SkinManager.setViewTextColor(this.f23041g, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f23037c, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f23043i, R.color.CAM_X0302);
                this.f23043i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
            }
            G();
            u();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = !this.m;
            c.a.q0.s.d0.b.j().t("key_recently_visited_forum_extend_state", this.m);
            if (this.m) {
                TiebaStatic.log(new StatisticItem("c13003"));
            } else {
                TiebaStatic.log(new StatisticItem("c13004"));
            }
            G();
        }
    }

    public void C(c.a.r0.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.r = cVar;
            A();
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || this.n == z || this.l == null) {
            return;
        }
        this.n = z;
        if (z) {
            this.f23043i.setVisibility(0);
            this.f23042h.setVisibility(8);
            Vibrator vibrator = this.f23040f;
            if (vibrator != null) {
                vibrator.vibrate(10L);
            }
            ViewEventCenter viewEventCenter = this.o;
            if (viewEventCenter != null) {
                viewEventCenter.dispatchMvcEvent(new c.a.q0.k0.c.b(10, null, null, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
        } else {
            this.f23043i.setVisibility(8);
            this.f23042h.setVisibility(0);
            ViewEventCenter viewEventCenter2 = this.o;
            if (viewEventCenter2 != null) {
                viewEventCenter2.dispatchMvcEvent(new c.a.q0.k0.c.b(11, null, null, null));
            }
        }
        this.l.setEditState(this.n);
    }

    public void E(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public void F(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.v.setTag(bdUniqueId);
        }
    }

    public final void G() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m) {
                this.f23044j.setVisibility(0);
                this.k.setVisibility(8);
                c.a.r0.o0.d.c cVar = this.r;
                if (cVar != null && cVar.f22684a) {
                    i3 = R.color.white_alpha100;
                } else {
                    i3 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23042h, R.drawable.icon_pure_ba_show24_svg, i3, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                this.f23044j.setVisibility(8);
                this.k.setVisibility(0);
                c.a.r0.o0.d.c cVar2 = this.r;
                if (cVar2 != null && cVar2.f22684a) {
                    i2 = R.color.white_alpha100;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f23042h, R.drawable.icon_pure_ba_hide24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            j jVar = this.s;
            if (jVar != null) {
                jVar.a();
            }
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.n) {
                D(false);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void l(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder, Intent intent, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumViewHolder, intent, z) == null) || forumViewHolder == null || intent == null) {
            return;
        }
        if (z && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = forumViewHolder.mForumImage;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.mForumName;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.mForumBgImage;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            return;
        }
        intent.putExtra("transition_type", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeZ(1048585, this, z) != null) {
            return;
        }
        if (z) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            if (!j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
                this.f23038d.setVisibility(0);
                G();
                jVar = this.s;
                if (jVar == null) {
                    jVar.a();
                    return;
                }
                return;
            }
        }
        this.f23038d.setVisibility(8);
        this.f23044j.setVisibility(8);
        this.k.setVisibility(8);
        jVar = this.s;
        if (jVar == null) {
        }
    }

    public c.a.r0.o0.d.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r : (c.a.r0.o0.d.c) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f23037c : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m = c.a.q0.s.d0.b.j().g("key_recently_visited_forum_extend_state", true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View inflate = this.f23035a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
            this.f23037c = inflate;
            this.f23038d = inflate.findViewById(R.id.title_container);
            this.f23041g = (TextView) this.f23037c.findViewById(R.id.title);
            ImageView imageView = (ImageView) this.f23037c.findViewById(R.id.extend_image);
            this.f23042h = imageView;
            imageView.setOnClickListener(new c(this));
            TextView textView = (TextView) this.f23037c.findViewById(R.id.done);
            this.f23043i = textView;
            textView.setOnClickListener(new d(this));
            this.k = this.f23037c.findViewById(R.id.gap);
            this.f23044j = (RecyclerView) this.f23037c.findViewById(R.id.list);
            RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = new RecentlyVisitedForumListAdapter(this.f23035a);
            this.l = recentlyVisitedForumListAdapter;
            this.f23044j.setAdapter(recentlyVisitedForumListAdapter);
            this.f23044j.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new c.a.e.l.e.j());
                this.q = lVar;
                lVar.q(this.f23044j, 1);
            }
            this.f23044j.setLayoutManager(new LinearLayoutManager(this.f23035a.getPageActivity(), 0, false));
            this.f23044j.setItemAnimator(new DefaultItemAnimator());
            this.f23044j.addItemDecoration(new k(this, c.a.e.e.p.l.g(this.f23035a.getPageActivity(), R.dimen.tbds44), 0, c.a.e.e.p.l.g(this.f23035a.getPageActivity(), R.dimen.tbds44)));
            this.l.setItemClickListener(new C1077e(this));
            this.l.setItemLongClickListener(new f(this));
            this.l.setDeleteClickListener(new g(this));
            this.f23039e.y(new h(this));
            w(TbadkCoreApplication.getInst().getSkinType());
            this.f23035a.registerListener(this.v);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f23038d.getVisibility() == 0 : invokeV.booleanValue;
    }

    public void u() {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (recentlyVisitedForumListAdapter = this.l) == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyDataSetChanged();
        if (this.l.getItemCount() > 0) {
            m(true);
        } else {
            m(false);
        }
    }

    public void v(int i2) {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (recentlyVisitedForumListAdapter = this.l) == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyItemRemoved(i2);
        if (this.l.getItemCount() == 0) {
            D(false);
            m(false);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f23036b == i2) {
            return;
        }
        this.f23036b = i2;
        A();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
            c.a.r0.o0.h.e eVar = this.p;
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public void y(LinkedList<VisitedForumData> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, linkedList) == null) || this.l == null || linkedList == null) {
            return;
        }
        G();
        this.l.setData(linkedList);
        u();
        w(TbadkCoreApplication.getInst().getSkinType());
    }

    public void z() {
        RecentlyVisitedForumModel recentlyVisitedForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (recentlyVisitedForumModel = this.f23039e) == null) {
            return;
        }
        recentlyVisitedForumModel.refresh();
    }
}
