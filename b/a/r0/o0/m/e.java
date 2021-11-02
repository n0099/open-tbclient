package b.a.r0.o0.m;

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
import b.a.e.l.e.l;
import b.a.r0.o0.g.a;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f21901a;

    /* renamed from: b  reason: collision with root package name */
    public int f21902b;

    /* renamed from: c  reason: collision with root package name */
    public View f21903c;

    /* renamed from: d  reason: collision with root package name */
    public View f21904d;

    /* renamed from: e  reason: collision with root package name */
    public RecentlyVisitedForumModel f21905e;

    /* renamed from: f  reason: collision with root package name */
    public Vibrator f21906f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21907g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f21908h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21909i;
    public RecyclerView j;
    public View k;
    public RecentlyVisitedForumListAdapter l;
    public boolean m;
    public boolean n;
    public ViewEventCenter o;
    public b.a.r0.o0.h.e p;
    public l q;
    public b.a.r0.o0.d.c r;
    public j s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public CustomMessageListener v;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f21910a;

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
            this.f21910a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f21910a.q == null) {
                        this.f21910a.q = new l(new b.a.e.l.e.j());
                    }
                    this.f21910a.q.q(this.f21910a.j, 1);
                } else if (this.f21910a.q != null) {
                    this.f21910a.q.w();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f21911a;

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
            this.f21911a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.f21911a.k();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21912e;

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
            this.f21912e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21912e.B();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21913e;

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
            this.f21913e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21913e.D(false);
            }
        }
    }

    /* renamed from: b.a.r0.o0.m.e$e  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1074e implements RecentlyVisitedForumListAdapter.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f21914a;

        public C1074e(e eVar) {
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
            this.f21914a = eVar;
        }

        @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
        public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, forumViewHolder) == null) || this.f21914a.n || forumViewHolder == null || (view = forumViewHolder.itemView) == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
            FrsActivityConfig callFrom = new FrsActivityConfig(this.f21914a.f21901a.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
            this.f21914a.l(forumViewHolder, callFrom.getIntent(), visitedForumData.z());
            this.f21914a.f21901a.sendMessage(new CustomMessage(2003000, callFrom));
            TiebaStatic.log(new StatisticItem("c13002").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21915e;

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
            this.f21915e = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21915e.D(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f21916e;

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
            this.f21916e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f21916e.f21905e == null || view.getTag() == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
            this.f21916e.f21905e.w(visitedForumData);
            TiebaStatic.log(new StatisticItem("c13005").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f21917a;

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
            this.f21917a = eVar;
        }

        @Override // b.a.r0.o0.g.a.f
        public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, linkedList, z) == null) {
                this.f21917a.y(linkedList);
                if (z || this.f21917a.p == null) {
                    return;
                }
                this.f21917a.p.c(linkedList, this.f21917a.f21901a.getResources().getDimensionPixelSize(R.dimen.tbds678) + this.f21917a.f21901a.getResources().getDimensionPixelSize(R.dimen.tbds10));
            }
        }

        @Override // b.a.r0.o0.g.a.f
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f21917a.v(i2);
            }
        }

        @Override // b.a.r0.o0.g.a.f
        public void onNotify() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f21917a.u();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f21918a;

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
            this.f21918a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f21918a.m(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes5.dex */
    public class k extends RecyclerView.ItemDecoration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f21919a;

        /* renamed from: b  reason: collision with root package name */
        public int f21920b;

        /* renamed from: c  reason: collision with root package name */
        public int f21921c;

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
            this.f21919a = i2;
            this.f21920b = i3;
            this.f21921c = i4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getOrientation() == 1) {
                    if (recyclerView.getChildAdapterPosition(view) == 0) {
                        rect.top = this.f21919a;
                    } else {
                        rect.top = this.f21920b;
                    }
                    if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                        rect.bottom = this.f21921c;
                        return;
                    }
                    return;
                }
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.left = this.f21919a;
                } else {
                    rect.left = this.f21920b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.right = this.f21921c;
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
        this.f21902b = 3;
        this.m = true;
        this.n = false;
        this.t = new a(this, 2156674);
        this.u = new b(this, 2001011);
        this.v = new i(this, 2921347);
        this.f21901a = tbPageContext;
        this.f21905e = recentlyVisitedForumModel;
        this.o = viewEventCenter;
        this.f21906f = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.p = new b.a.r0.o0.h.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.t);
        MessageManager.getInstance().registerListener(this.u);
        p();
        q();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.o0.d.c cVar = this.r;
            if (cVar != null && cVar.f21561a) {
                SkinManager.setViewTextColor(this.f21907g, R.color.CAM_X0101);
                this.f21903c.setBackgroundColor(0);
                SkinManager.setViewTextColorSelector(this.f21909i, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
                this.f21909i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
            } else {
                SkinManager.setViewTextColor(this.f21907g, R.color.CAM_X0105);
                SkinManager.setBackgroundColor(this.f21903c, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f21909i, R.color.CAM_X0302);
                this.f21909i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
            }
            G();
            u();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m = !this.m;
            b.a.q0.s.e0.b.j().t("key_recently_visited_forum_extend_state", this.m);
            if (this.m) {
                TiebaStatic.log(new StatisticItem("c13003"));
            } else {
                TiebaStatic.log(new StatisticItem("c13004"));
            }
            G();
        }
    }

    public void C(b.a.r0.o0.d.c cVar) {
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
            this.f21909i.setVisibility(0);
            this.f21908h.setVisibility(8);
            Vibrator vibrator = this.f21906f;
            if (vibrator != null) {
                vibrator.vibrate(10L);
            }
            ViewEventCenter viewEventCenter = this.o;
            if (viewEventCenter != null) {
                viewEventCenter.dispatchMvcEvent(new b.a.q0.k0.c.b(10, null, null, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
        } else {
            this.f21909i.setVisibility(8);
            this.f21908h.setVisibility(0);
            ViewEventCenter viewEventCenter2 = this.o;
            if (viewEventCenter2 != null) {
                viewEventCenter2.dispatchMvcEvent(new b.a.q0.k0.c.b(11, null, null, null));
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
                this.j.setVisibility(0);
                this.k.setVisibility(8);
                b.a.r0.o0.d.c cVar = this.r;
                if (cVar != null && cVar.f21561a) {
                    i3 = R.color.white_alpha100;
                } else {
                    i3 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21908h, R.drawable.icon_pure_ba_show24_svg, i3, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                b.a.r0.o0.d.c cVar2 = this.r;
                if (cVar2 != null && cVar2.f21561a) {
                    i2 = R.color.white_alpha100;
                } else {
                    i2 = R.color.CAM_X0107;
                }
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21908h, R.drawable.icon_pure_ba_hide24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            b.a.q0.s.e0.b j2 = b.a.q0.s.e0.b.j();
            if (!j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
                this.f21904d.setVisibility(0);
                G();
                jVar = this.s;
                if (jVar == null) {
                    jVar.a();
                    return;
                }
                return;
            }
        }
        this.f21904d.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        jVar = this.s;
        if (jVar == null) {
        }
    }

    public b.a.r0.o0.d.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r : (b.a.r0.o0.d.c) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f21903c : (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m = b.a.q0.s.e0.b.j().g("key_recently_visited_forum_extend_state", true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            View inflate = this.f21901a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
            this.f21903c = inflate;
            this.f21904d = inflate.findViewById(R.id.title_container);
            this.f21907g = (TextView) this.f21903c.findViewById(R.id.title);
            ImageView imageView = (ImageView) this.f21903c.findViewById(R.id.extend_image);
            this.f21908h = imageView;
            imageView.setOnClickListener(new c(this));
            TextView textView = (TextView) this.f21903c.findViewById(R.id.done);
            this.f21909i = textView;
            textView.setOnClickListener(new d(this));
            this.k = this.f21903c.findViewById(R.id.gap);
            this.j = (RecyclerView) this.f21903c.findViewById(R.id.list);
            RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = new RecentlyVisitedForumListAdapter(this.f21901a);
            this.l = recentlyVisitedForumListAdapter;
            this.j.setAdapter(recentlyVisitedForumListAdapter);
            this.j.setClipChildren(false);
            if (TbSingleton.getInstance().isSlideAnimEnable()) {
                l lVar = new l(new b.a.e.l.e.j());
                this.q = lVar;
                lVar.q(this.j, 1);
            }
            this.j.setLayoutManager(new LinearLayoutManager(this.f21901a.getPageActivity(), 0, false));
            this.j.setItemAnimator(new DefaultItemAnimator());
            this.j.addItemDecoration(new k(this, b.a.e.e.p.l.g(this.f21901a.getPageActivity(), R.dimen.tbds44), 0, b.a.e.e.p.l.g(this.f21901a.getPageActivity(), R.dimen.tbds44)));
            this.l.setItemClickListener(new C1074e(this));
            this.l.setItemLongClickListener(new f(this));
            this.l.setDeleteClickListener(new g(this));
            this.f21905e.y(new h(this));
            w(TbadkCoreApplication.getInst().getSkinType());
            this.f21901a.registerListener(this.v);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f21904d.getVisibility() == 0 : invokeV.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || this.f21902b == i2) {
            return;
        }
        this.f21902b = i2;
        A();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.t);
            MessageManager.getInstance().unRegisterListener(this.u);
            b.a.r0.o0.h.e eVar = this.p;
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
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (recentlyVisitedForumModel = this.f21905e) == null) {
            return;
        }
        recentlyVisitedForumModel.refresh();
    }
}
