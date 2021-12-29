package c.a.t0.s2.u.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.f1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<PostData> A;
    public ArrayList<c.a.d.n.e.n> B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public String L;
    public PostData M;
    public boolean N;
    public View.OnClickListener O;
    public View.OnClickListener P;
    public TbRichTextView.y Q;
    public View.OnClickListener R;
    public c.a.t0.s2.s.c S;
    public View.OnLongClickListener T;
    public SortSwitchButton.f U;
    public final List<c.a.d.n.e.a> V;
    public final List<c.a.d.n.e.a> W;
    public Runnable X;
    public int Y;
    public int Z;
    public PbFragment a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f23539b;
    public d2 b0;

    /* renamed from: c  reason: collision with root package name */
    public r f23540c;
    public List<PostData> c0;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f23541d;
    public final CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f23542e;
    public CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f23543f;
    public final CustomMessageListener f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.s2.u.f.a1.a f23544g;
    public final View.OnClickListener g0;

    /* renamed from: h  reason: collision with root package name */
    public m0 f23545h;
    public CustomMessageListener h0;

    /* renamed from: i  reason: collision with root package name */
    public m0 f23546i;
    public List<c.a.d.n.e.a> i0;

    /* renamed from: j  reason: collision with root package name */
    public l f23547j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.t0.s2.x.a f23548k;
    public c.a.t0.g0.g0.a l;
    public c.a.d.n.e.a m;
    public c.a.d.n.e.a n;
    public c.a.d.n.e.a o;
    public c.a.d.n.e.a p;
    public c.a.d.n.e.a q;
    public j0 r;
    public k0 s;
    public i0 t;
    public PbReplyLoadMoreAdapter u;
    public ArrayList<c.a.t0.s2.u.c.a> v;
    public i w;
    public w x;
    public c.a.t0.s2.u.c.b y;
    public c.a.t0.s2.r.f z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.t0.w3.j0.o)) {
                return;
            }
            c.a.t0.w3.j0.o oVar = (c.a.t0.w3.j0.o) customResponsedMessage.getData();
            if (this.a.b0 == null || this.a.b0.N2 != oVar) {
                return;
            }
            this.a.b0.N2.m(true);
            this.a.f23539b.setData(this.a.B);
            this.a.X();
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof c.a.t0.w3.j0.d)) {
                AbsDelegateAdapterList a = ((c.a.t0.w3.j0.d) customResponsedMessage.getData()).a();
                Iterator<c.a.d.n.e.a<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    c.a.d.n.e.a<?, ?> next = it.next();
                    if (next instanceof n) {
                        ((n) next).a0(this.a.a);
                        if (next instanceof c.a.t0.s2.u.c.a) {
                            this.a.v.add((c.a.t0.s2.u.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.W.clear();
                this.a.W.addAll(arrayList);
                if (this.a.f23539b != null) {
                    this.a.f23539b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f23549e;

            public a(c cVar) {
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
                this.f23549e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f23549e.a.X();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.a = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.z == null || c.a.d.a.j.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
            boolean z = false;
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                c.a.d.f.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f23550e;

        public d(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23550e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f23550e.a == null || this.f23550e.z == null || this.f23550e.z.T() == null) {
                return;
            }
            this.f23550e.a.getPbView().G0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f23551e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f23552f;

        public e(h hVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23552f = hVar;
            this.f23551e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23552f.f23539b.setSelectionFromTop(this.f23552f.f23539b.getHeaderViewsCount() + this.f23551e.size(), 0 - this.f23552f.Z);
                this.f23552f.I = false;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(h hVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, Integer.valueOf(i2)};
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
            this.a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.i0)) {
                this.a.n();
                h hVar = this.a;
                hVar.e0(hVar.z, false);
            }
        }
    }

    public h(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new ArrayList<>();
        this.A = new ArrayList<>();
        this.C = false;
        this.D = true;
        this.E = true;
        this.F = false;
        this.G = false;
        this.J = false;
        this.K = 0;
        this.L = null;
        this.M = null;
        this.N = true;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = new ArrayList();
        this.W = new ArrayList();
        this.Y = -1;
        this.Z = 0;
        this.a0 = -1;
        this.c0 = new ArrayList();
        this.d0 = new a(this, 2921523);
        this.e0 = new b(this, 2004015);
        this.f0 = new c(this, 2001118);
        this.g0 = new d(this);
        this.h0 = new f(this, 2016470);
        this.K = c.a.d.f.p.n.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.f23539b = bdTypeListView;
        J(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.f0);
        this.Z = c.a.d.f.p.n.i(this.a.getContext()) / 3;
    }

    public final int A(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, arrayList)) == null) {
            if (fVar == null || ListUtils.isEmpty(fVar.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(fVar.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    i2 = 0;
                    break;
                }
                c.a.d.n.e.n nVar = arrayList.get(i2);
                if (nVar instanceof PostData) {
                    PostData postData = (PostData) nVar;
                    if (postData.A() == 1 && postData.Q == 0) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (z) {
                return i2 + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdTypeListView bdTypeListView = this.f23539b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f23539b.getData().size(); i2++) {
                c.a.d.n.e.n nVar = this.f23539b.getData().get(i2);
                if (nVar != null && nVar.getType() == c.a.t0.s2.r.q.l) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int C(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, fVar, arrayList, z)) == null) {
            if (fVar == null || fVar.F() == null || fVar.D() == null || fVar.F().size() == 0 || fVar.O() == null || arrayList == null || !fVar.D().J0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (fVar.F().get(0) == null || fVar.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (fVar.y() == null || fVar.y().a() != fVar.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, fVar, arrayList, z)) == null) {
            if (fVar == null || fVar.F() == null || fVar.E() == null || fVar.F().size() == 0 || fVar.O() == null || arrayList == null || !fVar.E().J0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (fVar.F().get(0) == null || fVar.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (fVar.y() == null || fVar.y().a() != fVar.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (ArrayList) invokeV.objValue;
    }

    public final int F(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, fVar, arrayList, z)) == null) {
            if (fVar == null || ListUtils.isEmpty(fVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (fVar == null || !fVar.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (fVar.F().get(0) == null || fVar.F().get(0).A() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Y : invokeV.intValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r rVar = this.f23540c;
            if (rVar == null || rVar.o0() == null) {
                return null;
            }
            if (this.f23540c.o0().mPbBusinessPromotionContainer != null && this.f23540c.o0().mPbBusinessPromotionContainer.isShown()) {
                return this.f23540c.o0().mPbBusinessPromotionContainer;
            }
            return this.f23540c.o0().mForumEnterButtonContainer;
        }
        return (View) invokeV.objValue;
    }

    public final void I(ArrayList<c.a.d.n.e.n> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i2 = c.a.s0.t.c.e.i();
        int j2 = c.a.s0.t.c.e.j() - 1;
        if (bool.booleanValue()) {
            c.a.d.n.e.n nVar = arrayList.get(0);
            if ((nVar instanceof PostData) && ((PostData) nVar).A() == 1) {
                j2++;
            }
        }
        int k2 = c.a.s0.t.c.e.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.getPbModel() != null && this.a.getPbModel().b1() == 3) {
            this.c0.clear();
        }
        P(j2, i2, k2, arrayList);
    }

    public void J(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, pbFragment, bdTypeListView) == null) {
            r rVar = new r(pbFragment, PostData.z0);
            this.f23540c = rVar;
            rVar.D0(pbFragment);
            this.f23541d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, c.a.t0.s2.r.r.f23079j);
            this.f23542e = new PbFirstFloorEnterForumAdapter(pbFragment, c.a.t0.s2.r.h.m);
            this.f23543f = new PbFirstFloorItemAdapter(pbFragment.getContext(), c.a.t0.s2.r.i.f23051g);
            this.f23544g = new c.a.t0.s2.u.f.a1.a(pbFragment, c.a.t0.s2.r.a.f23021g);
            this.f23545h = new m0(pbFragment, c.a.t0.s2.r.q.l);
            this.f23546i = new m0(pbFragment, c.a.t0.s2.r.q.m);
            l lVar = new l(pbFragment, PostData.A0);
            this.f23547j = lVar;
            lVar.Q0(pbFragment);
            this.m = c.a.t0.j3.y.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.n = c.a.t0.j3.y.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.D4);
            this.o = c.a.t0.e1.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.J4);
            this.p = c.a.t0.e1.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.K4);
            this.q = c.a.t0.e1.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.M4);
            this.t = new i0(pbFragment, c.a.t0.s2.r.n.O0);
            this.r = new j0(pbFragment, h0.L0);
            this.s = new k0(pbFragment, f1.R0);
            this.u = new PbReplyLoadMoreAdapter(pbFragment, PostData.G0);
            this.f23548k = new c.a.t0.s2.x.a(pbFragment, c.a.t0.s2.x.b.f23863e);
            this.l = new c.a.t0.g0.g0.a(pbFragment.getPageContext());
            this.w = new i(pbFragment, c.a.s0.s.q.q.j4);
            this.x = new w(pbFragment, pbFragment.getUniqueId());
            c.a.t0.s2.u.c.b bVar = new c.a.t0.s2.u.c.b(pbFragment, pbFragment.getUniqueId(), this.f23539b);
            this.y = bVar;
            this.V.addAll(bVar.a());
            this.V.add(this.f23540c);
            this.V.add(this.f23541d);
            this.V.add(this.f23542e);
            this.V.add(this.f23543f);
            this.V.add(this.f23544g);
            this.V.add(this.f23547j);
            this.V.add(this.f23545h);
            this.V.add(this.f23546i);
            this.V.add(this.m);
            this.V.add(this.n);
            this.V.add(this.o);
            this.V.add(this.p);
            this.V.add(this.q);
            this.V.add(this.t);
            this.V.add(this.r);
            this.V.add(this.s);
            this.V.add(this.f23548k);
            this.V.add(this.u);
            this.V.add(this.l);
            this.V.add(this.w);
            this.V.add(this.x);
            this.V.add(new PbPrivateTitleAdapter(pbFragment));
            this.e0.setPriority(1);
            this.e0.setSelfListener(true);
            pbFragment.registerListener(this.e0);
            pbFragment.registerListener(this.d0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new c.a.t0.w3.j0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.V);
        }
    }

    public final void K(@NonNull c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f23540c.t(fVar);
            this.f23540c.setFromCDN(this.C);
            this.f23540c.n(this.K);
            this.f23540c.c(this.D);
            this.f23540c.e(this.P);
            this.f23540c.m(this.O);
            this.f23540c.p(this.Q);
            this.f23540c.d(this.T);
            this.f23540c.A0(this.R);
            this.f23540c.C0(this.S);
            this.f23543f.d0(this.R);
            this.f23547j.t(fVar);
            this.f23547j.setFromCDN(this.C);
            this.f23547j.q(this.L);
            this.f23547j.c(this.D);
            this.f23547j.e(this.P);
            this.f23547j.m(this.O);
            this.f23547j.p(this.Q);
            this.f23547j.d(this.T);
            this.f23547j.P0(this.S);
            this.f23541d.n0(this.P);
            this.u.d0(this.P);
            this.f23548k.d0(this.g0);
            c.a.d.n.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.t0.j3.t)) {
                ((c.a.t0.j3.t) aVar).k(this.C);
            }
            Iterator<c.a.t0.s2.u.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                c.a.t0.s2.u.c.a next = it.next();
                if (next != null) {
                    next.t(fVar);
                    next.setFromCDN(this.C);
                    next.q(this.L);
                    next.n(this.K);
                    next.c(this.D);
                    next.f(this.E);
                    next.s(this.J);
                    next.e(this.P);
                    next.m(this.O);
                    next.p(this.Q);
                    next.d(this.T);
                }
            }
            this.f23545h.e(this.P);
            this.f23545h.f0(this.U);
            this.f23546i.e(this.P);
            this.f23545h.t(fVar);
            this.f23544g.t(fVar);
            this.f23546i.t(fVar);
            this.r.t(fVar);
            this.s.t(fVar);
            this.w.f0(fVar);
            this.w.e0(this.a.bjhFrom);
            this.x.d0(fVar);
            this.y.f(fVar);
        }
    }

    public final c.a.d.n.e.n L(ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, arrayList, i2)) == null) {
            if (this.z == null) {
                return null;
            }
            c.a.t0.w3.j0.p l0 = this.a.getPbModel().l0();
            if (l0 == null) {
                l0 = this.z.z();
            }
            if (l0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert M0 = l0.M0();
            if (M0 != null) {
                M0.setAdvertAppInfo(l0.getAdvertAppInfo());
            }
            int Y4 = l0.getAdvertAppInfo().Y4();
            if (Y4 != 0) {
                c.a.t0.j3.l0.d.k(l0, Y4);
                if (Y4 != 28 && Y4 != 31) {
                    l0.getAdvertAppInfo().h4 = -1001;
                }
                return null;
            }
            if (this.z.l() != null) {
                l0.K0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                l0.N0 = c.a.d.f.m.b.g(this.z.O().g0(), 0L);
            }
            c.a.t0.s2.r.f fVar = this.z;
            if (fVar != null && fVar.y() != null) {
                l0.O0 = this.z.y().a();
            }
            l(l0);
            if (i2 >= 0) {
                c.a.t0.x1.o.k.a.b(arrayList, l0, i2);
                return l0;
            }
            return null;
        }
        return (c.a.d.n.e.n) invokeLI.objValue;
    }

    public final boolean M(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{fVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(fVar.f()) && fVar.f().size() > 2) {
                int min = Math.min(fVar.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    c.a.s0.s.q.q qVar = fVar.f().get(i6);
                    if (!z2 && i6 == 0) {
                        qVar.Y4(true);
                    }
                    if (qVar.t1() == null) {
                        if (i6 == min - 1) {
                            qVar.a5(true);
                        }
                    } else if (i6 == min - 2) {
                        qVar.a5(true);
                    } else if (i6 == min - 1) {
                        qVar.Z4(true);
                    }
                    arrayList2.add(qVar);
                }
            }
            if (arrayList2.size() > 0) {
                int i7 = (!z || i2 < 0) ? z ? i3 + 2 : i3 >= 0 ? i3 + 1 : i4 >= 0 ? i4 : i5 >= 0 ? i5 : -1 : i2 + 1;
                if (i7 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i7, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final c.a.d.n.e.n N(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        c.a.t0.s2.r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, fVar, arrayList, i2)) == null) {
            if (i2 < 0 || fVar == null || !fVar.f23043k || (aVar = fVar.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i2, aVar);
            return aVar;
        }
        return (c.a.d.n.e.n) invokeLLI.objValue;
    }

    public final c.a.d.n.e.n O(ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i2)) == null) {
            if (c.a.s0.b.d.P() && i2 > 0 && (fVar = this.z) != null && fVar.n0()) {
                String d2 = c.a.t0.e1.e.c.e().d("pb_banner");
                if (this.b0 == null && c.a.t0.e1.a.i().m(d2)) {
                    d2 d2Var = new d2();
                    this.b0 = d2Var;
                    d2Var.N2 = new c.a.t0.w3.j0.o();
                    c.a.t0.s2.r.f fVar2 = this.z;
                    if (fVar2 != null) {
                        this.b0.N2.j(fVar2.m());
                        this.b0.N2.n(this.z.Q());
                    }
                }
                d2 d2Var2 = this.b0;
                if (d2Var2 != null && d2Var2.N2 != null) {
                    ListUtils.add(arrayList, i2, d2Var2);
                }
            }
            return this.b0;
        }
        return (c.a.d.n.e.n) invokeLI.objValue;
    }

    public final void P(int i2, int i3, int i4, ArrayList<c.a.d.n.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i2 < 0 || i3 < 1) {
            return;
        }
        ListIterator<c.a.d.n.e.n> listIterator = arrayList.listIterator();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (i5 == i2 || (i5 > i2 && (i5 - i2) % i3 == 0)) {
                if (i6 >= i4) {
                    break;
                }
                if (i6 < this.c0.size()) {
                    listIterator.add(this.c0.get(i6));
                } else {
                    PostData postData = new PostData();
                    c.a.t0.w3.j0.o oVar = new c.a.t0.w3.j0.o();
                    c.a.t0.s2.r.f fVar = this.z;
                    oVar.j(fVar != null ? fVar.m() : "");
                    c.a.t0.s2.r.f fVar2 = this.z;
                    oVar.n(fVar2 != null ? fVar2.Q() : "");
                    oVar.k(true);
                    postData.w0 = oVar;
                    listIterator.add(postData);
                    this.c0.add(postData);
                }
                i6++;
            }
            listIterator.next();
            i5++;
        }
        if (i5 != i2 || i6 >= i4) {
            return;
        }
        PostData postData2 = new PostData();
        c.a.t0.w3.j0.o oVar2 = new c.a.t0.w3.j0.o();
        c.a.t0.s2.r.f fVar3 = this.z;
        oVar2.j(fVar3 != null ? fVar3.m() : "");
        c.a.t0.s2.r.f fVar4 = this.z;
        oVar2.n(fVar4 != null ? fVar4.Q() : "");
        oVar2.k(true);
        postData2.w0 = oVar2;
        listIterator.add(postData2);
        this.c0.add(postData2);
    }

    public final c.a.d.n.e.n Q(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        c.a.t0.s2.r.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, fVar, arrayList, i2)) == null) {
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName())) {
                return null;
            }
            if (TextUtils.equals(fVar.l().getName(), this.a.getPbModel().r0()) && this.a.getPbModel().x0()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
                hVar = new c.a.t0.s2.r.h(fVar.p().get(0));
            } else {
                hVar = new c.a.t0.s2.r.h(fVar.l());
            }
            hVar.f23050k = this.a.getPbModel().h1();
            ListUtils.add(arrayList, i2 + 1, hVar);
            return hVar;
        }
        return (c.a.d.n.e.n) invokeLLI.objValue;
    }

    public final c.a.d.n.e.n R(c.a.t0.s2.r.f fVar, PostData postData, ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048593, this, fVar, postData, arrayList, i2)) == null) {
            c.a.t0.s2.r.i iVar = null;
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName()) || !TextUtils.equals(fVar.l().getName(), this.a.getPbModel().r0()) || !this.a.getPbModel().x0()) {
                if (postData != null) {
                    if (postData.s0 != null) {
                        iVar = new c.a.t0.s2.r.i(postData.s0);
                    }
                } else {
                    PostData postData2 = this.M;
                    if (postData2 != null && postData2.s0 != null) {
                        iVar = new c.a.t0.s2.r.i(this.M.s0);
                    }
                }
                if (iVar != null) {
                    iVar.f23053f = this.a.getPbModel().h1();
                    ListUtils.add(arrayList, i2 + 1, iVar);
                }
                return iVar;
            }
            return null;
        }
        return (c.a.d.n.e.n) invokeLLLI.objValue;
    }

    public final x S(ArrayList<c.a.d.n.e.n> arrayList, c.a.d.n.e.n nVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048594, this, arrayList, nVar, i2, i3)) == null) {
            x B = this.z.B();
            if (B != null) {
                if (nVar != null) {
                    if (i3 >= 0 || nVar.getType() == AdvertAppInfo.D4) {
                        i3 = nVar.getType() != AdvertAppInfo.D4 ? i3 + 1 : -1;
                    } else {
                        i3 = i2 + 2;
                    }
                }
                if (i3 <= 0 || !(B instanceof x)) {
                    return null;
                }
                ListUtils.add(arrayList, i3, B);
                return B;
            }
            return null;
        }
        return (x) invokeLLII.objValue;
    }

    public final void T(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, fVar, arrayList, i2) == null) {
            c.a.t0.s2.r.q qVar = new c.a.t0.s2.r.q(c.a.t0.s2.r.q.l);
            d2 O = fVar.O();
            if (O != null) {
                O.V0();
            }
            qVar.f23075h = this.a.isHostOnlyMode();
            qVar.f23074g = fVar.f23039g;
            fVar.c();
            qVar.f23076i = fVar.g0();
            qVar.f23078k = fVar.f23038f;
            ListUtils.add(arrayList, i2, qVar);
            if (fVar.L() == 4) {
                ListUtils.add(arrayList, i2 + 1, new c.a.t0.s2.r.p());
            }
        }
    }

    public final c.a.d.n.e.n U(ArrayList<c.a.d.n.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i2)) == null) {
            if (i2 < 0 || (pbModel = this.a.getPbModel()) == null || TextUtils.isEmpty(pbModel.V0())) {
                return null;
            }
            c.a.t0.w3.j0.p pVar = new c.a.t0.w3.j0.p();
            l(pVar);
            ListUtils.add(arrayList, i2 + 1, pVar);
            return pVar;
        }
        return (c.a.d.n.e.n) invokeLI.objValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.Y = B();
            if (this.f23539b.getAdapter2() instanceof c.a.d.n.e.e) {
                this.f23539b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 == 1) {
                r rVar = this.f23540c;
                if (rVar != null) {
                    rVar.w0();
                }
                c.a.d.n.e.a aVar = this.n;
                if (aVar instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar).onPause();
                }
                c.a.d.n.e.a aVar2 = this.o;
                if (aVar2 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar2).onPause();
                }
                c.a.d.n.e.a aVar3 = this.q;
                if (aVar3 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar3).onPause();
                }
                m.a().j(this.a.getPbActivity());
            } else if (i2 == 2) {
                r rVar2 = this.f23540c;
                if (rVar2 != null) {
                    rVar2.y0();
                }
                c.a.d.n.e.a aVar4 = this.n;
                if (aVar4 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar4).onResume();
                }
                c.a.d.n.e.a aVar5 = this.o;
                if (aVar5 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar5).onResume();
                }
                c.a.d.n.e.a aVar6 = this.q;
                if (aVar6 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar6).onResume();
                }
                d0(false);
            } else if (i2 != 3) {
            } else {
                r rVar3 = this.f23540c;
                if (rVar3 != null) {
                    rVar3.x0();
                }
                c.a.d.n.e.a aVar7 = this.n;
                if (aVar7 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar7).onDestroy();
                }
                c.a.d.n.e.a aVar8 = this.o;
                if (aVar8 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar8).onDestroy();
                }
                c.a.d.n.e.a aVar9 = this.q;
                if (aVar9 instanceof c.a.t0.j3.p) {
                    ((c.a.t0.j3.p) aVar9).onDestroy();
                }
                m.a().d();
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.X);
            m0 m0Var = this.f23545h;
            if (m0Var != null) {
                m0Var.onDestroy();
            }
            m0 m0Var2 = this.f23546i;
            if (m0Var2 != null) {
                m0Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f23541d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            c.a.t0.s2.u.f.a1.a aVar = this.f23544g;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public void a0(boolean z) {
        r rVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (rVar = this.f23540c) == null) {
            return;
        }
        rVar.v0(z);
    }

    public final void b0(boolean z, boolean z2, int i2, List<c.a.d.n.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), list}) == null) || z || z2) {
            return;
        }
        if ((!this.H && !this.G) || i2 == -1 || ListUtils.isEmpty(list) || this.I) {
            return;
        }
        this.X = new e(this, list);
        c.a.d.f.m.e.a().post(this.X);
    }

    public void c0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (postData = this.M) == null || postData.L() == null || !this.N) {
            return;
        }
        this.f23540c.s0(this.M.L());
        this.N = false;
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.a.getPbView() == null || this.a.getPbActivity() == null || this.a.getPbActivity().getPbModel() == null) {
            return;
        }
        m.a().g(this.a.getPbActivity().getPbModel().w1(), this.f23545h.c0(), this.a.getPbView().M0(), this.a.getPbActivity().getPageStayDurationItem(), z, this.y.b(), this.a.getListView());
    }

    public void e0(c.a.t0.s2.r.f fVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        boolean z7;
        int i3;
        x xVar;
        List<c.a.d.n.e.n> list;
        int i4;
        boolean z8;
        boolean z9;
        c.a.d.n.e.n nVar;
        int i5;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048606, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.z = fVar;
        if (!c.a.s0.b.d.O()) {
            w0();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.clear();
        c.a.t0.s2.r.f fVar2 = this.z;
        if (fVar2 != null && fVar2.F() != null && this.z.F().size() > 0) {
            this.A.addAll(this.z.F());
        }
        if (fVar.O() != null && fVar.O().J() != null) {
            this.L = fVar.O().J().getUserId();
        }
        if (this.f23540c == null) {
            return;
        }
        K(fVar);
        ArrayList<c.a.d.n.e.n> arrayList = new ArrayList<>(fVar.F());
        if (c.a.s0.h1.b.c.d()) {
            this.f23539b.setData(arrayList.subList(0, 1));
            this.f23540c.B0(false);
            return;
        }
        PostData p = p(arrayList);
        boolean z10 = p != null;
        if (!c.a.t0.f1.a.f() && c.a.s0.b.d.O() && this.z.n0()) {
            I(arrayList, Boolean.valueOf(z10));
        }
        if (p != null) {
            this.M = p;
        }
        if (this.E || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (fVar.r0() && p.N() != null) {
                p.z0(null);
            }
            z10 = true;
            z2 = true;
        }
        if (z10 || fVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j2 = fVar.j();
            if (!this.E && fVar.r0() && j2.N() != null) {
                j2.z0(null);
            }
            postData = j2;
            z10 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.getIsMangaThread()) {
            if (fVar.F().size() > 0 && (postData2 = fVar.F().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.z, arrayList, this.E);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.z.D());
            }
        }
        int D = D(this.z, arrayList, this.E);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.z.E());
        }
        c.a.t0.w3.w.f(arrayList, 1);
        int A = A(fVar, arrayList);
        if (A >= 0) {
            T(fVar, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int u = u(fVar, arrayList);
        List<c.a.d.n.e.n> v = v(fVar);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            c.a.d.n.e.n nVar2 = (c.a.d.n.e.n) ListUtils.getItem(arrayList, u);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).T = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z10 ? F(fVar, arrayList, this.E) : -1;
        if (F < 0 || fVar.S() == null) {
            if (postData != null) {
                postData.S = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, fVar.S());
            z5 = true;
            z6 = true;
        }
        boolean z11 = R(fVar, postData, arrayList, F) != null;
        if (z11) {
            F++;
        }
        if (!z11 && Q(fVar, arrayList, F) != null) {
            F++;
        }
        if (N(fVar, arrayList, F) != null) {
            F++;
        }
        if (z10) {
            c.a.d.n.e.n U = U(arrayList, F);
            boolean z12 = U != null;
            if (z12) {
                z9 = z12;
                nVar = U;
                i5 = -1;
            } else {
                i5 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                nVar = L(arrayList, i5);
                z9 = nVar != null;
            }
            boolean z13 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z13 && this.z.n0()) {
                this.a0 = i5;
                if (O(arrayList, i5) != null) {
                    this.a0 = -1;
                    F++;
                }
            }
            if (c.a.s0.b.d.P() && z13) {
                i3 = i5;
                z7 = z9;
                xVar = null;
            } else {
                x S = S(arrayList, nVar, F, i5);
                if (S != null) {
                    if (!z9) {
                        i3 = i5;
                        xVar = S;
                        i2 = F;
                        z7 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        F++;
                    }
                }
                i3 = i5;
                xVar = S;
                z7 = z9;
            }
            i2 = F;
        } else {
            i2 = F;
            z7 = false;
            i3 = -1;
            xVar = null;
        }
        if (z10) {
            list = v;
            int i6 = i2;
            i4 = u;
            boolean M = M(fVar, arrayList, z7, xVar != null, i3, i6, u, A);
            if (xVar != null) {
                xVar.r = M;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.f23540c.B0(!z5);
        boolean v0 = v0(postData);
        if (this.F && !v0) {
            arrayList.remove(postData);
            this.F = false;
        }
        if (fVar.S() != null) {
            fVar.S().k(!z6);
        }
        if (this.f23539b != null) {
            this.B = arrayList;
            List<c.a.d.n.e.n> R = fVar.R();
            if (!ListUtils.isEmpty(R)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + R.size() + 2);
                arrayList2.addAll(arrayList);
                c.a.t0.s2.r.k kVar = new c.a.t0.s2.r.k();
                PbListView K0 = this.a.getPbView().K0();
                if (K0 != null && K0.n()) {
                    kVar.f23056e = TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.pb_no_replay);
                    kVar.f23057f = true;
                    z8 = false;
                } else {
                    kVar.f23056e = TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.list_has_no_more);
                    z8 = false;
                    kVar.f23057f = false;
                }
                arrayList2.add(kVar);
                c.a.t0.g0.g0.e eVar = new c.a.t0.g0.g0.e();
                eVar.f18266e = TbadkCoreApplication.getInst().getString(c.a.t0.s2.l.recommed_for_you);
                eVar.needTopMargin = z8;
                arrayList2.add(eVar);
                arrayList2.addAll(R);
                this.f23539b.setData(arrayList2);
            } else {
                this.f23539b.setData(this.B);
            }
        }
        b0(v0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f23539b.setData(arrayList);
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.C = z;
            this.f23540c.setFromCDN(z);
            c.a.d.n.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.t0.j3.t)) {
                ((c.a.t0.j3.t) aVar).k(z);
            }
            Iterator<c.a.t0.s2.u.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.F = z;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.D = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.J = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.G = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.H = z;
        }
    }

    public final void l(c.a.t0.w3.j0.p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, pVar) == null) || pVar == null || this.z == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().o4 = new c.a.s0.s.q.e();
        if (this.z.y() != null) {
            pVar.getAdvertAppInfo().o4.f13665b = this.z.y().a();
        }
        pVar.getAdvertAppInfo().o4.a = pVar.L0();
        if (this.z.l() != null && (l = this.z.l()) != null) {
            pVar.getAdvertAppInfo().o4.f13667d = l.getId();
            pVar.getAdvertAppInfo().o4.f13668e = l.getFirst_class();
            pVar.getAdvertAppInfo().o4.f13669f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().o4.f13670g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().o4.f13671h = pVar.getAdvertAppInfo().m4;
        pVar.getAdvertAppInfo().o4.f13672i = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.E = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.h0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.I = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.i0 = new ArrayList();
            ArrayList<BdUniqueId> g2 = c.a.t0.w3.w.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.t0.x1.o.g.a b2 = c.a.t0.x1.r.b.d().b(this.a.getPageContext(), g2.get(i2), 2);
                if (b2 != null) {
                    this.V.add(b2);
                    this.i0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.i0)) {
                return true;
            }
            this.f23539b.addAdapters(this.i0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z) == null) || (lVar = this.f23547j) == null) {
            return;
        }
        lVar.O0(z);
    }

    public final void o(List<c.a.d.n.e.n> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.J())) {
                    c.a.s0.s.q.p0 p0Var = new c.a.s0.s.q.p0();
                    p0Var.k(postData.J());
                    list.set(i2, p0Var);
                }
            }
        }
    }

    public void o0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.O = onClickListener;
        }
    }

    public final PostData p(ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, arrayList)) == null) {
            Iterator<c.a.d.n.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.n.e.n next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.A() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void p0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, yVar) == null) {
            this.Q = yVar;
        }
    }

    public final boolean q(PostData postData, ArrayList<c.a.d.n.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048623, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.M;
            if (postData2 != null && !this.G) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.n0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onLongClickListener) == null) {
            this.T = onLongClickListener;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.y.b() : (View) invokeV.objValue;
    }

    public void r0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public ArrayList<c.a.d.n.e.n> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void s0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.P = onClickListener;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            r rVar = this.f23540c;
            if (rVar == null || rVar.o0() == null) {
                return null;
            }
            return this.f23540c.o0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final int u(c.a.t0.s2.r.f fVar, ArrayList<c.a.d.n.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, fVar, arrayList)) == null) {
            if (this.G || fVar == null || ListUtils.isEmpty(fVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (fVar != null && fVar.r0() && this.E) ? 0 : -1;
            } else if (this.a.getPbModel() == null || !this.a.getPbModel().B0()) {
                if (this.a.getPbView() == null || !this.a.getPbView().C0()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z = false;
                            i2 = -1;
                            break;
                        }
                        c.a.d.n.e.n nVar = arrayList.get(i2);
                        if (nVar instanceof PostData) {
                            PostData postData = (PostData) nVar;
                            if (postData.A() == 1 && postData.Q == 0) {
                                z = true;
                                break;
                            }
                        }
                        i2++;
                    }
                    return !z ? fVar.r0() ? 0 : -1 : i2 + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(c.a.t0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, cVar) == null) {
            this.S = cVar;
        }
    }

    public final List<c.a.d.n.e.n> v(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, fVar)) == null) {
            if (fVar == null || fVar.T() == null || ListUtils.isEmpty(fVar.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = fVar.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i2 = 0; i2 < min; i2++) {
                PostData postData = list.get(i2);
                if (postData != null) {
                    postData.e0 = true;
                    postData.R = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(fVar.T().f23100b) > 2) {
                c.a.d.n.e.n nVar = (c.a.d.n.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar instanceof PostData) {
                    ((PostData) nVar).R = false;
                }
                arrayList.add(new c.a.t0.s2.x.b());
            } else {
                c.a.d.n.e.n nVar2 = (c.a.d.n.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar2 instanceof PostData) {
                    ((PostData) nVar2).R = true;
                }
            }
            c.a.t0.s2.r.q qVar = new c.a.t0.s2.r.q(c.a.t0.s2.r.q.m);
            qVar.f23072e = fVar.T().f23101c;
            arrayList.add(0, qVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final boolean v0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, postData)) == null) ? (this.a.getPbModel() == null || postData == null || postData.G() == null || !postData.G().equals(this.a.getPbModel().n1())) ? false : true : invokeL.booleanValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f23539b.getHeaderViewsCount() : invokeV.intValue;
    }

    public final void w0() {
        c.a.t0.s2.r.f fVar;
        c.a.t0.w3.j0.p pVar;
        c.a.t0.w3.j0.p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (fVar = this.z) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<c.a.t0.w3.j0.p> e2 = this.z.e();
        if (c.a.t0.x1.o.k.a.e(F) || c.a.t0.x1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<c.a.t0.w3.j0.p> it = e2.iterator();
        while (it.hasNext()) {
            c.a.t0.w3.j0.p next = it.next();
            if (next != null && next.K0() != null) {
                sb.append(next.K0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<c.a.t0.w3.j0.p> it2 = e2.iterator();
        while (it2.hasNext()) {
            c.a.t0.w3.j0.p next2 = it2.next();
            if (next2 != null) {
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<c.a.t0.w3.j0.p> it3 = e2.iterator();
        while (it3.hasNext()) {
            c.a.t0.w3.j0.p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int Y4 = next3.getAdvertAppInfo().Y4();
                if (Y4 != 0) {
                    c.a.t0.j3.l0.d.k(next3, Y4);
                    if (Y4 != 28 && Y4 != 31) {
                        next3.getAdvertAppInfo().h4 = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            c.a.t0.w3.j0.p pVar3 = (c.a.t0.w3.j0.p) sparseArray.valueAt(i2);
            if (pVar3 != null && (pVar2 = (c.a.t0.w3.j0.p) hashMap.put(pVar3.J0(), pVar3)) != null) {
                c.a.t0.j3.l0.d.k(pVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (pVar = (c.a.t0.w3.j0.p) entry.getValue()) != null) {
                sparseArray.put(pVar.getPosition(), pVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            c.a.t0.x1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < c.a.t0.x1.o.k.a.k(arrayList); i4++) {
            c.a.t0.w3.j0.p pVar4 = (c.a.t0.w3.j0.p) sparseArray.get(((Integer) c.a.t0.x1.o.k.a.d(arrayList, i4)).intValue());
            if (this.z.l() != null) {
                pVar4.K0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                pVar4.N0 = c.a.d.f.m.b.g(this.z.O().g0(), 0L);
            }
            c.a.t0.s2.r.f fVar2 = this.z;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.O0 = this.z.y().a();
            }
            l(pVar4);
            int position = pVar4.getPosition() + this.z.Z;
            if (position >= c.a.t0.x1.o.k.a.k(F)) {
                pVar4.Q0 = position;
                c.a.t0.j3.l0.d.l(pVar4, 2, position, c.a.t0.x1.o.k.a.k(F));
                return;
            }
            if (!this.E) {
                position--;
                pVar4.Q0 = position;
            }
            if (position < 0) {
                c.a.t0.j3.l0.d.k(pVar4, 23);
            } else {
                c.a.t0.x1.o.k.a.b(F, pVar4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().x4);
            }
        }
    }

    public c.a.d.n.e.n x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) ? this.f23539b.getItem(i2) : (c.a.d.n.e.n) invokeI.objValue;
    }

    public void x0() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (i2 = this.a0) <= 0 || O(this.B, i2) == null) {
            return;
        }
        this.a0 = -1;
        this.f23539b.setData(this.B);
        X();
    }

    public BdUniqueId y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i2)) == null) {
            if (this.f23539b.getItem(i2) != null) {
                return this.f23539b.getItem(i2).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.f23541d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }
}
