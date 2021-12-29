package c.a.t0.o1.l.e;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.n.e.n;
import c.a.l.w0.a;
import c.a.s0.g0.g;
import c.a.s0.g0.h;
import c.a.s0.s.i0.f;
import c.a.t0.z2.k;
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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public View f21335b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f21336c;

    /* renamed from: d  reason: collision with root package name */
    public BigdaySwipeRefreshLayout f21337d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.o1.h.i.a f21338e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.o1.h.k.f f21339f;

    /* renamed from: g  reason: collision with root package name */
    public h f21340g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f21341h;

    /* renamed from: i  reason: collision with root package name */
    public g f21342i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.o1.l.b.a f21343j;

    /* renamed from: k  reason: collision with root package name */
    public View f21344k;
    public FrameLayout l;
    public k m;
    public NEGFeedBackView.b n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public BdUniqueId t;
    public f.h u;
    public f.InterfaceC0856f v;
    public CustomMessageListener w;
    public CustomMessageListener x;
    public RecyclerView.RecyclerListener y;
    public RecyclerView.OnScrollListener z;

    /* renamed from: c.a.t0.o1.l.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1284a implements f.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1284a(a aVar) {
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

        @Override // c.a.s0.s.i0.f.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.W();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.InterfaceC0856f {
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

        @Override // c.a.s0.s.i0.f.InterfaceC0856f
        public void a(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                this.a.L(true);
                if (this.a.m == null || this.a.q || !this.a.r) {
                    return;
                }
                this.a.m.n(this.a.o, this.a.p, this.a.s, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.t0.o1.l.e.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1285a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21345e;

            public RunnableC1285a(c cVar) {
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
                this.f21345e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21345e.a.f21343j.c();
                    if (this.f21345e.a.q || !this.f21345e.a.r) {
                        return;
                    }
                    this.f21345e.a.m.n(this.f21345e.a.o, this.f21345e.a.p, this.f21345e.a.s, true);
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.d.f.m.e.a().postDelayed(new RunnableC1285a(this), 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder p;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 24 || (p = this.a.p()) == null || p.getCardView() == null) {
                    return;
                }
                p.getCardView().o(new a.C0186a(3));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) || viewHolder == null || (view = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.m != null) {
                this.a.m.k(view);
            }
            if (view.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view.getTag()).getCardView().stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f21346b;

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
            this.f21346b = aVar;
            this.a = -1;
        }

        public final void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                this.f21346b.o = i2;
                this.f21346b.p = (i2 + i3) - 1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2) == null) {
                if (i2 == 0 && this.f21346b.m != null && this.f21346b.r) {
                    this.f21346b.m.m(this.f21346b.o, this.f21346b.p, this.f21346b.s, 1);
                }
                if (this.a == i2) {
                    return;
                }
                this.a = i2;
                if (i2 == 1) {
                    this.f21346b.N(true);
                } else {
                    this.f21346b.Y();
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
        this.u = new C1284a(this);
        this.v = new b(this);
        this.w = new c(this, 2921420);
        this.x = new d(this, 2921381);
        this.y = new e(this);
        this.z = new f(this);
        this.a = tbPageContext;
        this.t = bdUniqueId;
        this.n = bVar;
        w();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g gVar = this.f21342i;
            if (gVar != null) {
                gVar.m();
            }
            X(null);
            c.a.t0.o1.h.i.a aVar = this.f21338e;
            if (aVar != null) {
                aVar.T();
            }
            c.a.t0.o1.l.b.a aVar2 = this.f21343j;
            if (aVar2 != null) {
                aVar2.d();
            }
            k kVar = this.m;
            if (kVar != null) {
                kVar.h();
            }
            o();
            MessageManager.getInstance().unRegisterListener(this.x);
            MessageManager.getInstance().unRegisterListener(this.w);
        }
    }

    public void B() {
        c.a.t0.o1.l.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f21343j) == null) {
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
        k kVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (kVar = this.m) != null && this.r) {
            kVar.n(this.o, this.p, this.s, true);
        }
    }

    public final boolean F(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, recyclerView)) == null) ? recyclerView == null || !recyclerView.canScrollVertically(-1) : invokeL.booleanValue;
    }

    public void G() {
        c.a.t0.o1.l.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.f21343j) == null) {
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
            List<Integer> s = s(str, this.f21336c);
            int intValue = s.get(0).intValue();
            int intValue2 = s.get(1).intValue();
            if (intValue == -1 || intValue2 == -1) {
                return;
            }
            this.f21336c.removeItemList(intValue, intValue2);
        }
    }

    public void J(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            c.a.t0.o1.l.b.a aVar = this.f21343j;
            if (aVar != null) {
                aVar.f(list);
            }
            E();
        }
    }

    public void K(f.g gVar) {
        c.a.t0.o1.h.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || (aVar = this.f21338e) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pVar) == null) || (bdTypeRecyclerView = this.f21336c) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) || (pbListView = this.f21341h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f21336c.setNextPage(this.f21341h);
        }
        this.f21341h.t(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.f21341h.D(this.a.getResources().getString(R.string.video_tab_click_load));
        this.f21341h.C(onClickListener);
        this.f21341h.f();
    }

    public void Q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (pbListView = this.f21341h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f21336c.setNextPage(this.f21341h);
        }
        this.f21341h.t(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.f21341h.D(this.a.getResources().getString(R.string.loading));
        this.f21341h.C(null);
        this.f21341h.R();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || x()) {
            return;
        }
        if (this.f21342i == null) {
            g gVar = new g(this.a.getPageActivity());
            this.f21342i = gVar;
            gVar.onChangeSkinType();
        }
        this.f21342i.attachView(this.f21335b, false);
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            if (this.f21340g == null) {
                this.f21340g = new h(this.a.getPageActivity(), onClickListener);
            }
            this.f21340g.p();
            this.f21340g.m(null);
            this.f21340g.n(this.a.getResources().getString(R.string.refresh_view_title_text));
            this.f21340g.i(R.drawable.new_pic_emotion_08);
            this.f21340g.l(0);
            this.f21340g.attachView(this.l, false);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.f21340g == null) {
                this.f21340g = new h(this.a.getPageActivity(), null);
            }
            this.f21340g.e();
            this.f21340g.i(R.drawable.new_pic_emotion_03);
            this.f21340g.o(this.a.getString(R.string.no_data_common_txt));
            this.f21340g.attachView(this.l, false);
        }
    }

    public void U() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (pbListView = this.f21341h) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f21336c.setNextPage(this.f21341h);
        }
        this.f21341h.t(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds178));
        this.f21341h.D(this.a.getResources().getString(R.string.video_tab_no_more));
        this.f21341h.C(null);
        this.f21341h.f();
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f21337d.setRefreshing(true);
        }
    }

    public void W() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (kVar = this.m) == null) {
            return;
        }
        kVar.x();
    }

    public void X(f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.f21337d.refreshFinishWithMsgRemind(iVar);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (F(this.f21336c)) {
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
            g gVar = this.f21342i;
            if (gVar != null) {
                gVar.p(TbadkCoreApplication.getInst().getSkinType());
                this.f21342i.onChangeSkinType();
            }
            h hVar = this.f21340g;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
            c.a.t0.o1.h.i.a aVar = this.f21338e;
            if (aVar != null) {
                aVar.C(skinType);
            }
            c.a.t0.o1.l.b.a aVar2 = this.f21343j;
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
            BdTypeRecyclerView bdTypeRecyclerView = this.f21336c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.z);
                this.f21336c.setRecyclerListener(null);
            }
            c.a.t0.o1.h.i.a aVar = this.f21338e;
            if (aVar != null) {
                aVar.b(null);
                this.f21338e.h(null);
            }
        }
    }

    public final ThreadCardViewHolder p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            k kVar = this.m;
            if (kVar == null || kVar.j() == null || !(this.m.j().getTag() instanceof ThreadCardViewHolder)) {
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
            c.a.t0.o1.l.b.a aVar = this.f21343j;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f21335b : (View) invokeV.objValue;
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
                if (item instanceof c.a.t0.g0.f0.b) {
                    c.a.t0.g0.f0.b bVar = (c.a.t0.g0.f0.b) item;
                    if (bVar.getThreadData() != null && bVar.getThreadData().v1().equals(str)) {
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
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (gVar = this.f21342i) == null) {
            return;
        }
        gVar.dettachView(this.f21335b);
    }

    public void u() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (hVar = this.f21340g) == null) {
            return;
        }
        hVar.dettachView(this.l);
        this.f21340g = null;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.f21336c.addOnScrollListener(this.z);
            this.f21336c.setRecyclerListener(this.y);
            this.f21338e.b(this.u);
            this.f21338e.h(this.v);
            this.f21338e.V(this.a.getUniqueId());
            H();
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.video_tab_main_view_layout, (ViewGroup) null);
            this.f21335b = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l = (FrameLayout) this.f21335b.findViewById(R.id.video_tab_framelayout);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f21335b.findViewById(R.id.video_tab_recycle_view);
            this.f21336c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f21336c.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            k kVar = new k(this.a, this.f21336c);
            this.m = kVar;
            kVar.v(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.u(this.t);
            this.f21337d = (BigdaySwipeRefreshLayout) this.f21335b.findViewById(R.id.video_tab_refresh_layout);
            c.a.t0.o1.h.i.a aVar = new c.a.t0.o1.h.i.a(this.a);
            this.f21338e = aVar;
            this.f21337d.setProgressView(aVar);
            int i2 = (int) (this.a.getResources().getDisplayMetrics().density * 86.0f);
            this.f21337d.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f21341h = pbListView;
            pbListView.a();
            this.f21341h.p(R.color.transparent);
            this.f21341h.t(c.a.d.f.p.n.f(this.a.getPageActivity(), R.dimen.tbds178));
            this.f21341h.y();
            this.f21341h.H(R.dimen.tbfontsize36);
            this.f21341h.F(SkinManager.getColor(R.color.CAM_X0109));
            this.f21341h.B(R.color.CAM_X0110);
            this.f21341h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            c.a.t0.o1.l.b.a aVar2 = new c.a.t0.o1.l.b.a(this.a, this.f21336c);
            this.f21343j = aVar2;
            aVar2.g(this.n);
            this.f21343j.h(this.t);
            c.a.t0.o1.h.k.f fVar = new c.a.t0.o1.h.k.f();
            this.f21339f = fVar;
            fVar.a(this.t);
            this.f21343j.i(this.f21339f);
            this.f21344k = this.f21335b.findViewById(R.id.video_tab_divider_shadow);
            m();
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            g gVar = this.f21342i;
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
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (bdTypeRecyclerView = this.f21336c) == null) {
            return;
        }
        bdTypeRecyclerView.setSelection(0);
    }

    public final void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.q = z;
            k kVar = this.m;
            if (kVar == null) {
                return;
            }
            kVar.r(!z);
            ThreadCardViewHolder p = p();
            boolean z2 = false;
            if (p != null && p.getCardView() != null) {
                z2 = p.getCardView().o(new a.C0186a(8, Boolean.valueOf(z)));
            }
            if (z2) {
                return;
            }
            if (z) {
                this.m.x();
            } else if (this.r) {
                this.m.n(this.o, this.p, this.s, true);
            }
        }
    }
}
