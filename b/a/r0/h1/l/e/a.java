package b.a.r0.h1.l.e;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.l.w0.a;
import b.a.q0.g0.g;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.r0.q2.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f19172a;

    /* renamed from: b  reason: collision with root package name */
    public View f19173b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f19174c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f19175d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.r0.h1.h.i.a f19176e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.h1.h.k.f f19177f;

    /* renamed from: g  reason: collision with root package name */
    public h f19178g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19179h;

    /* renamed from: i  reason: collision with root package name */
    public g f19180i;
    public b.a.r0.h1.l.b.a j;
    public View k;
    public FrameLayout l;
    public i m;
    public NEGFeedBackView.b n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public BdUniqueId t;
    public f.h u;
    public f.InterfaceC0712f v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public RecyclerView.RecyclerListener y;
    public RecyclerView.OnScrollListener z;

    /* renamed from: b.a.r0.h1.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0970a implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19181a;

        public C0970a(a aVar) {
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
            this.f19181a = aVar;
        }

        @Override // b.a.q0.s.g0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f19181a.W();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.InterfaceC0712f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19182a;

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
            this.f19182a = aVar;
        }

        @Override // b.a.q0.s.g0.f.InterfaceC0712f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.f19182a.L(true);
                if (this.f19182a.m == null || this.f19182a.q || !this.f19182a.r) {
                    return;
                }
                this.f19182a.m.n(this.f19182a.o, this.f19182a.p, this.f19182a.s, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19183a;

        /* renamed from: b.a.r0.h1.l.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0971a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19184e;

            public RunnableC0971a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19184e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19184e.f19183a.j.c();
                    if (this.f19184e.f19183a.q || !this.f19184e.f19183a.r) {
                        return;
                    }
                    this.f19184e.f19183a.m.n(this.f19184e.f19183a.o, this.f19184e.f19183a.p, this.f19184e.f19183a.s, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f19183a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                b.a.e.f.m.e.a().postDelayed(new RunnableC0971a(this), 500L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19185a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.f19185a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (p = this.f19185a.p()) == null || p.getCardView() == null) {
                    return;
                }
                p.getCardView().n(new a.C0092a(3));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19186a;

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
            this.f19186a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.f19186a.m != null) {
                this.f19186a.m.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f19187a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f19188b;

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
            this.f19188b = aVar;
            this.f19187a = -1;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f19188b.o = i2;
                this.f19188b.p = (i2 + i3) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f19188b.m != null && this.f19188b.r) {
                    this.f19188b.m.m(this.f19188b.o, this.f19188b.p, this.f19188b.s, 1);
                }
                if (this.f19187a == i2) {
                    return;
                }
                this.f19187a = i2;
                if (i2 == 1) {
                    this.f19188b.N(true);
                } else {
                    this.f19188b.Y();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i2, i3) == null) {
                int i5 = 0;
                if (recyclerView instanceof BdRecyclerView) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i5 = bdRecyclerView.getFirstVisiblePosition();
                    i4 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i4 = 0;
                }
                a(i5, (i4 - i5) + 1);
            }
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = true;
        this.s = false;
        this.u = new C0970a(this);
        this.v = new b(this);
        this.w = new c(this, 2921420);
        this.x = new d(this, 2921381);
        this.y = new e(this);
        this.z = new f(this);
        this.f19172a = tbPageContext;
        this.t = bdUniqueId;
        this.n = bVar;
        w();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g gVar = this.f19180i;
            if (gVar != null) {
                gVar.m();
            }
            X(null);
            b.a.r0.h1.h.i.a aVar = this.f19176e;
            if (aVar != null) {
                aVar.S();
            }
            b.a.r0.h1.l.b.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.d();
            }
            i iVar = this.m;
            if (iVar != null) {
                iVar.h();
            }
            o();
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    public void B() {
        b.a.r0.h1.l.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.e();
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            z(true);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            z(false);
        }
    }

    public void E() {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (iVar = this.m) != null && this.r) {
            iVar.n(this.o, this.p, this.s, true);
        }
    }

    public final boolean F(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void G() {
        b.a.r0.h1.l.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.j) == null) {
            return;
        }
        aVar.c();
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.w.setTag(this.t);
            MessageManager.getInstance().registerListener(this.w);
            this.x.setTag(this.t);
            MessageManager.getInstance().registerListener(this.x);
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            List<Integer> s = s(str, this.f19174c);
            int intValue = s.get(0).intValue();
            int intValue2 = s.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.f19174c.removeItemList(intValue, intValue2);
        }
    }

    public void J(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            b.a.r0.h1.l.b.a aVar = this.j;
            if (aVar != null) {
                aVar.f(list);
            }
            E();
        }
    }

    public void K(f.g gVar) {
        b.a.r0.h1.h.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || (aVar = this.f19176e) == null) {
            return;
        }
        aVar.a(gVar);
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.r = z;
        }
    }

    public void M(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) || (bdTypeRecyclerView = this.f19174c) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.q = z;
        }
    }

    public void P(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) || (pbListView = this.f19179h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f19174c.setNextPage(this.f19179h);
        }
        this.f19179h.s(l.g(this.f19172a.getPageActivity(), R.dimen.tbds178));
        this.f19179h.C(this.f19172a.getResources().getString(R.string.video_tab_click_load));
        this.f19179h.B(onClickListener);
        this.f19179h.f();
    }

    public void Q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pbListView = this.f19179h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f19174c.setNextPage(this.f19179h);
        }
        this.f19179h.s(l.g(this.f19172a.getPageActivity(), R.dimen.tbds178));
        this.f19179h.C(this.f19172a.getResources().getString(R.string.loading));
        this.f19179h.B(null);
        this.f19179h.Q();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || x()) {
            return;
        }
        if (this.f19180i == null) {
            g gVar = new g(this.f19172a.getPageActivity());
            this.f19180i = gVar;
            gVar.onChangeSkinType();
        }
        this.f19180i.attachView(this.f19173b, false);
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            if (this.f19178g == null) {
                this.f19178g = new h(this.f19172a.getPageActivity(), onClickListener);
            }
            this.f19178g.o();
            this.f19178g.l(null);
            this.f19178g.m(this.f19172a.getResources().getString(R.string.refresh_view_title_text));
            this.f19178g.i(R.drawable.new_pic_emotion_08);
            this.f19178g.k(0);
            this.f19178g.attachView(this.l, false);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f19178g == null) {
                this.f19178g = new h(this.f19172a.getPageActivity(), null);
            }
            this.f19178g.e();
            this.f19178g.i(R.drawable.new_pic_emotion_03);
            this.f19178g.n(this.f19172a.getString(R.string.no_data_common_txt));
            this.f19178g.attachView(this.l, false);
        }
    }

    public void U() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pbListView = this.f19179h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f19174c.setNextPage(this.f19179h);
        }
        this.f19179h.s(l.g(this.f19172a.getPageActivity(), R.dimen.tbds178));
        this.f19179h.C(this.f19172a.getResources().getString(R.string.video_tab_no_more));
        this.f19179h.B(null);
        this.f19179h.f();
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f19175d.setRefreshing(true);
        }
    }

    public void W() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (iVar = this.m) == null) {
            return;
        }
        iVar.w();
    }

    public void X(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.f19175d.refreshFinishWithMsgRemind(iVar);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (F(this.f19174c)) {
                N(false);
            } else {
                N(true);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            g gVar = this.f19180i;
            if (gVar != null) {
                gVar.p(TbadkCoreApplication.getInst().getSkinType());
                this.f19180i.onChangeSkinType();
            }
            h hVar = this.f19178g;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            b.a.r0.h1.h.i.a aVar = this.f19176e;
            if (aVar != null) {
                aVar.C(skinType);
            }
            b.a.r0.h1.l.b.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            J(new LinkedList());
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f19174c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.z);
                this.f19174c.setRecyclerListener(null);
            }
            b.a.r0.h1.h.i.a aVar = this.f19176e;
            if (aVar != null) {
                aVar.b(null);
                this.f19176e.h(null);
            }
        }
    }

    public final ThreadCardViewHolder p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            i iVar = this.m;
            if (iVar == null || iVar.j() == null || !(this.m.j().getTag() instanceof ThreadCardViewHolder)) {
                return null;
            }
            return (ThreadCardViewHolder) this.m.j().getTag();
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public List<n> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            b.a.r0.h1.l.b.a aVar = this.j;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f19173b : (View) invokeV.objValue;
    }

    public final List<Integer> s(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                n item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof b.a.r0.b0.f0.b) {
                    b.a.r0.b0.f0.b bVar = (b.a.r0.b0.f0.b) item;
                    if (bVar.getThreadData() != null && bVar.getThreadData().t1().equals(str)) {
                        if (!z) {
                            i2 = i4;
                        }
                        z = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void t() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (gVar = this.f19180i) == null) {
            return;
        }
        gVar.dettachView(this.f19173b);
    }

    public void u() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (hVar = this.f19178g) == null) {
            return;
        }
        hVar.dettachView(this.l);
        this.f19178g = null;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f19174c.addOnScrollListener(this.z);
            this.f19174c.setRecyclerListener(this.y);
            this.f19176e.b(this.u);
            this.f19176e.h(this.v);
            this.f19176e.U(this.f19172a.getUniqueId());
            H();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            View inflate = LayoutInflater.from(this.f19172a.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
            this.f19173b = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l = (FrameLayout) this.f19173b.findViewById(R.id.video_tab_framelayout);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f19173b.findViewById(R.id.video_tab_recycle_view);
            this.f19174c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f19172a.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f19174c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            i iVar = new i(this.f19172a, this.f19174c);
            this.m = iVar;
            iVar.u(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.t(this.t);
            this.f19175d = (BigdaySwipeRefreshLayout) this.f19173b.findViewById(R.id.video_tab_refresh_layout);
            b.a.r0.h1.h.i.a aVar = new b.a.r0.h1.h.i.a(this.f19172a);
            this.f19176e = aVar;
            this.f19175d.setProgressView(aVar);
            int i2 = (int) (this.f19172a.getResources().getDisplayMetrics().density * 86.0f);
            this.f19175d.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.f19172a.getPageActivity());
            this.f19179h = pbListView;
            pbListView.a();
            this.f19179h.p(R.color.transparent);
            this.f19179h.s(l.g(this.f19172a.getPageActivity(), R.dimen.tbds178));
            this.f19179h.x();
            this.f19179h.G(R.dimen.tbfontsize36);
            this.f19179h.E(SkinManager.getColor(R.color.CAM_X0109));
            this.f19179h.A(R.color.CAM_X0110);
            this.f19179h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            b.a.r0.h1.l.b.a aVar2 = new b.a.r0.h1.l.b.a(this.f19172a, this.f19174c);
            this.j = aVar2;
            aVar2.g(this.n);
            this.j.h(this.t);
            b.a.r0.h1.h.k.f fVar = new b.a.r0.h1.h.k.f();
            this.f19177f = fVar;
            fVar.a(this.t);
            this.j.i(this.f19177f);
            this.k = this.f19173b.findViewById(R.id.video_tab_divider_shadow);
            m();
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            g gVar = this.f19180i;
            if (gVar == null) {
                return false;
            }
            return gVar.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void y() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (bdTypeRecyclerView = this.f19174c) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.q = z;
            i iVar = this.m;
            if (iVar == null) {
                return;
            }
            iVar.q(!z);
            ThreadCardViewHolder p = p();
            boolean z2 = false;
            if (p != null && p.getCardView() != null) {
                z2 = p.getCardView().n(new a.C0092a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.m.w();
            } else if (this.r) {
                this.m.n(this.o, this.p, this.s, true);
            }
        }
    }
}
