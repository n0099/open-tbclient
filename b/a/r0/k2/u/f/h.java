package b.a.r0.k2.u.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.f1;
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
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<PostData> A;
    public ArrayList<b.a.e.m.e.n> B;
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
    public View.OnClickListener N;
    public View.OnClickListener O;
    public TbRichTextView.z P;
    public View.OnClickListener Q;
    public b.a.r0.k2.s.c R;
    public View.OnLongClickListener S;
    public SortSwitchButton.f T;
    public final List<b.a.e.m.e.a> U;
    public final List<b.a.e.m.e.a> V;
    public Runnable W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f20830a;
    public d2 a0;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f20831b;
    public List<PostData> b0;

    /* renamed from: c  reason: collision with root package name */
    public r f20832c;
    public final CustomMessageListener c0;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20833d;
    public CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f20834e;
    public final CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f20835f;
    public final View.OnClickListener f0;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.k2.u.f.a1.a f20836g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public m0 f20837h;
    public List<b.a.e.m.e.a> h0;

    /* renamed from: i  reason: collision with root package name */
    public m0 f20838i;
    public l j;
    public b.a.r0.k2.x.a k;
    public b.a.r0.b0.g0.a l;
    public b.a.e.m.e.a m;
    public b.a.e.m.e.a n;
    public b.a.e.m.e.a o;
    public b.a.e.m.e.a p;
    public b.a.e.m.e.a q;
    public j0 r;
    public k0 s;
    public i0 t;
    public PbReplyLoadMoreAdapter u;
    public ArrayList<b.a.r0.k2.u.c.a> v;
    public i w;
    public w x;
    public b.a.r0.k2.u.c.b y;
    public b.a.r0.k2.r.f z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f20839a;

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
            this.f20839a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof b.a.r0.m3.j0.o)) {
                return;
            }
            b.a.r0.m3.j0.o oVar = (b.a.r0.m3.j0.o) customResponsedMessage.getData();
            if (this.f20839a.a0 == null || this.f20839a.a0.K2 != oVar) {
                return;
            }
            this.f20839a.a0.K2.m(true);
            this.f20839a.f20831b.setData(this.f20839a.B);
            this.f20839a.X();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f20840a;

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
            this.f20840a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof b.a.r0.m3.j0.d)) {
                AbsDelegateAdapterList a2 = ((b.a.r0.m3.j0.d) customResponsedMessage.getData()).a();
                Iterator<b.a.e.m.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    b.a.e.m.e.a<?, ?> next = it.next();
                    if (next instanceof n) {
                        ((n) next).h0(this.f20840a.f20830a);
                        if (next instanceof b.a.r0.k2.u.c.a) {
                            this.f20840a.v.add((b.a.r0.k2.u.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                this.f20840a.V.clear();
                this.f20840a.V.addAll(arrayList);
                if (this.f20840a.f20831b != null) {
                    this.f20840a.f20831b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f20841a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f20842e;

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
                this.f20842e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f20842e.f20841a.X();
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
            this.f20841a = hVar;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f20841a.z == null || b.a.e.a.j.c(this.f20841a.f20830a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                b.a.e.f.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f20843e;

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
            this.f20843e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20843e.f20830a == null || this.f20843e.z == null || this.f20843e.z.T() == null) {
                return;
            }
            this.f20843e.f20830a.getPbView().G0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f20844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f20845f;

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
            this.f20845f = hVar;
            this.f20844e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20845f.f20831b.setSelectionFromTop(this.f20845f.f20831b.getHeaderViewsCount() + this.f20844e.size(), 0 - this.f20845f.Y);
                this.f20845f.I = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f20846a;

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
            this.f20846a = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f20846a.h0)) {
                this.f20846a.n();
                h hVar = this.f20846a;
                hVar.c0(hVar.z, false);
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
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.X = -1;
        this.Y = 0;
        this.Z = -1;
        this.b0 = new ArrayList();
        this.c0 = new a(this, 2921523);
        this.d0 = new b(this, 2004015);
        this.e0 = new c(this, 2001118);
        this.f0 = new d(this);
        this.g0 = new f(this, 2016470);
        this.K = b.a.e.f.p.l.k(pbFragment.getPageContext().getPageActivity());
        this.f20830a = pbFragment;
        this.f20831b = bdTypeListView;
        J(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.e0);
        this.Y = b.a.e.f.p.l.i(this.f20830a.getContext()) / 3;
    }

    public final int A(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList) {
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
                b.a.e.m.e.n nVar = arrayList.get(i2);
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
            BdTypeListView bdTypeListView = this.f20831b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f20831b.getData().size(); i2++) {
                b.a.e.m.e.n nVar = this.f20831b.getData().get(i2);
                if (nVar != null && nVar.getType() == b.a.r0.k2.r.q.l) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int C(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, fVar, arrayList, z)) == null) {
            if (fVar == null || fVar.F() == null || fVar.D() == null || fVar.F().size() == 0 || fVar.O() == null || arrayList == null || !fVar.D().I0()) {
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

    public int D(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, fVar, arrayList, z)) == null) {
            if (fVar == null || fVar.F() == null || fVar.E() == null || fVar.F().size() == 0 || fVar.O() == null || arrayList == null || !fVar.E().I0()) {
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

    public final int F(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, boolean z) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.X : invokeV.intValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r rVar = this.f20832c;
            if (rVar == null || rVar.v0() == null) {
                return null;
            }
            if (this.f20832c.v0().mPbBusinessPromotionContainer != null && this.f20832c.v0().mPbBusinessPromotionContainer.isShown()) {
                return this.f20832c.v0().mPbBusinessPromotionContainer;
            }
            return this.f20832c.v0().mForumEnterButtonContainer;
        }
        return (View) invokeV.objValue;
    }

    public final void I(ArrayList<b.a.e.m.e.n> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i2 = b.a.q0.t.c.e.i();
        int j = b.a.q0.t.c.e.j() - 1;
        if (bool.booleanValue()) {
            b.a.e.m.e.n nVar = arrayList.get(0);
            if ((nVar instanceof PostData) && ((PostData) nVar).A() == 1) {
                j++;
            }
        }
        int k = b.a.q0.t.c.e.k() + 1;
        PbFragment pbFragment = this.f20830a;
        if (pbFragment != null && pbFragment.getPbModel() != null && this.f20830a.getPbModel().Z0() == 3) {
            this.b0.clear();
        }
        P(j, i2, k, arrayList);
    }

    public void J(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, pbFragment, bdTypeListView) == null) {
            r rVar = new r(pbFragment, PostData.x0);
            this.f20832c = rVar;
            rVar.H0(pbFragment);
            this.f20833d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, b.a.r0.k2.r.r.j);
            this.f20834e = new PbFirstFloorEnterForumAdapter(pbFragment, b.a.r0.k2.r.h.m);
            this.f20835f = new PbFirstFloorItemAdapter(pbFragment.getContext(), b.a.r0.k2.r.i.f20307g);
            this.f20836g = new b.a.r0.k2.u.f.a1.a(pbFragment, b.a.r0.k2.r.a.f20278g);
            this.f20837h = new m0(pbFragment, b.a.r0.k2.r.q.l);
            this.f20838i = new m0(pbFragment, b.a.r0.k2.r.q.m);
            l lVar = new l(pbFragment, PostData.y0);
            this.j = lVar;
            lVar.X0(pbFragment);
            this.m = b.a.r0.a3.y.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.t4);
            this.n = b.a.r0.a3.y.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.v4);
            this.o = b.a.r0.y0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.B4);
            this.p = b.a.r0.y0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.q = b.a.r0.y0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.E4);
            this.t = new i0(pbFragment, b.a.r0.k2.r.n.M0);
            this.r = new j0(pbFragment, h0.J0);
            this.s = new k0(pbFragment, f1.P0);
            this.u = new PbReplyLoadMoreAdapter(pbFragment, PostData.E0);
            this.k = new b.a.r0.k2.x.a(pbFragment, b.a.r0.k2.x.b.f21202e);
            this.l = new b.a.r0.b0.g0.a(pbFragment.getPageContext());
            this.w = new i(pbFragment, b.a.q0.s.q.q.c4);
            this.x = new w(pbFragment, pbFragment.getUniqueId());
            b.a.r0.k2.u.c.b bVar = new b.a.r0.k2.u.c.b(pbFragment, pbFragment.getUniqueId(), this.f20831b);
            this.y = bVar;
            this.U.addAll(bVar.a());
            this.U.add(this.f20832c);
            this.U.add(this.f20833d);
            this.U.add(this.f20834e);
            this.U.add(this.f20835f);
            this.U.add(this.f20836g);
            this.U.add(this.j);
            this.U.add(this.f20837h);
            this.U.add(this.f20838i);
            this.U.add(this.m);
            this.U.add(this.n);
            this.U.add(this.o);
            this.U.add(this.p);
            this.U.add(this.q);
            this.U.add(this.t);
            this.U.add(this.r);
            this.U.add(this.s);
            this.U.add(this.k);
            this.U.add(this.u);
            this.U.add(this.l);
            this.U.add(this.w);
            this.U.add(this.x);
            this.U.add(new PbPrivateTitleAdapter(pbFragment));
            this.d0.setPriority(1);
            this.d0.setSelfListener(true);
            pbFragment.registerListener(this.d0);
            pbFragment.registerListener(this.c0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new b.a.r0.m3.j0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.U);
        }
    }

    public final void K(@NonNull b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.f20832c.t(fVar);
            this.f20832c.setFromCDN(this.C);
            this.f20832c.n(this.K);
            this.f20832c.c(this.D);
            this.f20832c.e(this.O);
            this.f20832c.m(this.N);
            this.f20832c.p(this.P);
            this.f20832c.d(this.S);
            this.f20832c.E0(this.Q);
            this.f20832c.G0(this.R);
            this.f20835f.k0(this.Q);
            this.j.t(fVar);
            this.j.setFromCDN(this.C);
            this.j.q(this.L);
            this.j.c(this.D);
            this.j.e(this.O);
            this.j.m(this.N);
            this.j.p(this.P);
            this.j.d(this.S);
            this.j.W0(this.R);
            this.f20833d.u0(this.O);
            this.u.k0(this.O);
            this.k.k0(this.f0);
            b.a.e.m.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof b.a.r0.a3.t)) {
                ((b.a.r0.a3.t) aVar).k(this.C);
            }
            Iterator<b.a.r0.k2.u.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                b.a.r0.k2.u.c.a next = it.next();
                if (next != null) {
                    next.t(fVar);
                    next.setFromCDN(this.C);
                    next.q(this.L);
                    next.n(this.K);
                    next.c(this.D);
                    next.f(this.E);
                    next.s(this.J);
                    next.e(this.O);
                    next.m(this.N);
                    next.p(this.P);
                    next.d(this.S);
                }
            }
            this.f20837h.e(this.O);
            this.f20837h.m0(this.T);
            this.f20838i.e(this.O);
            this.f20837h.t(fVar);
            this.f20836g.t(fVar);
            this.f20838i.t(fVar);
            this.r.t(fVar);
            this.s.t(fVar);
            this.w.m0(fVar);
            this.w.l0(this.f20830a.bjhFrom);
            this.x.k0(fVar);
            this.y.f(fVar);
        }
    }

    public final b.a.e.m.e.n L(ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, arrayList, i2)) == null) {
            if (this.z == null) {
                return null;
            }
            b.a.r0.m3.j0.p k0 = this.f20830a.getPbModel().k0();
            if (k0 == null) {
                k0 = this.z.z();
            }
            if (k0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert L0 = k0.L0();
            if (L0 != null) {
                L0.setAdvertAppInfo(k0.getAdvertAppInfo());
            }
            int W4 = k0.getAdvertAppInfo().W4();
            if (W4 != 0) {
                b.a.r0.a3.l0.d.k(k0, W4);
                if (W4 != 28 && W4 != 31) {
                    k0.getAdvertAppInfo().a4 = -1001;
                }
                return null;
            }
            if (this.z.l() != null) {
                k0.I0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                k0.L0 = b.a.e.f.m.b.g(this.z.O().f0(), 0L);
            }
            b.a.r0.k2.r.f fVar = this.z;
            if (fVar != null && fVar.y() != null) {
                k0.M0 = this.z.y().a();
            }
            l(k0);
            if (i2 >= 0) {
                b.a.r0.q1.o.k.a.b(arrayList, k0, i2);
                return k0;
            }
            return null;
        }
        return (b.a.e.m.e.n) invokeLI.objValue;
    }

    public final boolean M(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{fVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(fVar.f()) && fVar.f().size() > 2) {
                int min = Math.min(fVar.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    b.a.q0.s.q.q qVar = fVar.f().get(i6);
                    if (!z2 && i6 == 0) {
                        qVar.W4(true);
                    }
                    if (qVar.r1() == null) {
                        if (i6 == min - 1) {
                            qVar.Y4(true);
                        }
                    } else if (i6 == min - 2) {
                        qVar.Y4(true);
                    } else if (i6 == min - 1) {
                        qVar.X4(true);
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

    public final b.a.e.m.e.n N(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        b.a.r0.k2.r.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, fVar, arrayList, i2)) == null) {
            if (i2 < 0 || fVar == null || !fVar.k || (aVar = fVar.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i2, aVar);
            return aVar;
        }
        return (b.a.e.m.e.n) invokeLLI.objValue;
    }

    public final b.a.e.m.e.n O(ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i2)) == null) {
            if (b.a.q0.b.d.K() && i2 > 0 && (fVar = this.z) != null && fVar.n0()) {
                String d2 = b.a.r0.y0.e.c.e().d("pb_banner");
                if (this.a0 == null && b.a.r0.y0.a.i().m(d2)) {
                    d2 d2Var = new d2();
                    this.a0 = d2Var;
                    d2Var.K2 = new b.a.r0.m3.j0.o();
                    b.a.r0.k2.r.f fVar2 = this.z;
                    if (fVar2 != null) {
                        this.a0.K2.j(fVar2.m());
                        this.a0.K2.n(this.z.Q());
                    }
                }
                d2 d2Var2 = this.a0;
                if (d2Var2 != null && d2Var2.K2 != null) {
                    ListUtils.add(arrayList, i2, d2Var2);
                }
            }
            return this.a0;
        }
        return (b.a.e.m.e.n) invokeLI.objValue;
    }

    public final void P(int i2, int i3, int i4, ArrayList<b.a.e.m.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i2 < 0 || i3 < 1) {
            return;
        }
        ListIterator<b.a.e.m.e.n> listIterator = arrayList.listIterator();
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
                if (i6 < this.b0.size()) {
                    listIterator.add(this.b0.get(i6));
                } else {
                    PostData postData = new PostData();
                    b.a.r0.m3.j0.o oVar = new b.a.r0.m3.j0.o();
                    b.a.r0.k2.r.f fVar = this.z;
                    oVar.j(fVar != null ? fVar.m() : "");
                    b.a.r0.k2.r.f fVar2 = this.z;
                    oVar.n(fVar2 != null ? fVar2.Q() : "");
                    oVar.k(true);
                    postData.u0 = oVar;
                    listIterator.add(postData);
                    this.b0.add(postData);
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
        b.a.r0.m3.j0.o oVar2 = new b.a.r0.m3.j0.o();
        b.a.r0.k2.r.f fVar3 = this.z;
        oVar2.j(fVar3 != null ? fVar3.m() : "");
        b.a.r0.k2.r.f fVar4 = this.z;
        oVar2.n(fVar4 != null ? fVar4.Q() : "");
        oVar2.k(true);
        postData2.u0 = oVar2;
        listIterator.add(postData2);
        this.b0.add(postData2);
    }

    public final b.a.e.m.e.n Q(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        b.a.r0.k2.r.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, fVar, arrayList, i2)) == null) {
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName())) {
                return null;
            }
            if (TextUtils.equals(fVar.l().getName(), this.f20830a.getPbModel().q0()) && this.f20830a.getPbModel().v0()) {
                return null;
            }
            if (!this.f20830a.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
                hVar = new b.a.r0.k2.r.h(fVar.p().get(0));
            } else {
                hVar = new b.a.r0.k2.r.h(fVar.l());
            }
            hVar.k = this.f20830a.getPbModel().f1();
            ListUtils.add(arrayList, i2 + 1, hVar);
            return hVar;
        }
        return (b.a.e.m.e.n) invokeLLI.objValue;
    }

    public final b.a.e.m.e.n R(b.a.r0.k2.r.f fVar, PostData postData, ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048593, this, fVar, postData, arrayList, i2)) == null) {
            b.a.r0.k2.r.i iVar = null;
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName()) || !TextUtils.equals(fVar.l().getName(), this.f20830a.getPbModel().q0()) || !this.f20830a.getPbModel().v0()) {
                if (postData != null) {
                    if (postData.r0 != null) {
                        iVar = new b.a.r0.k2.r.i(postData.r0);
                    }
                } else {
                    PostData postData2 = this.M;
                    if (postData2 != null && postData2.r0 != null) {
                        iVar = new b.a.r0.k2.r.i(this.M.r0);
                    }
                }
                if (iVar != null) {
                    iVar.f20309f = this.f20830a.getPbModel().f1();
                    ListUtils.add(arrayList, i2 + 1, iVar);
                }
                return iVar;
            }
            return null;
        }
        return (b.a.e.m.e.n) invokeLLLI.objValue;
    }

    public final x S(ArrayList<b.a.e.m.e.n> arrayList, b.a.e.m.e.n nVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048594, this, arrayList, nVar, i2, i3)) == null) {
            x B = this.z.B();
            if (B != null) {
                if (nVar != null) {
                    if (i3 >= 0 || nVar.getType() == AdvertAppInfo.v4) {
                        i3 = nVar.getType() != AdvertAppInfo.v4 ? i3 + 1 : -1;
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

    public final void T(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, fVar, arrayList, i2) == null) {
            b.a.r0.k2.r.q qVar = new b.a.r0.k2.r.q(b.a.r0.k2.r.q.l);
            d2 O = fVar.O();
            if (O != null) {
                O.U0();
            }
            qVar.f20334h = this.f20830a.isHostOnlyMode();
            qVar.f20333g = fVar.f20299g;
            fVar.c();
            qVar.f20335i = fVar.g0();
            qVar.k = fVar.f20298f;
            ListUtils.add(arrayList, i2, qVar);
            if (fVar.L() == 4) {
                ListUtils.add(arrayList, i2 + 1, new b.a.r0.k2.r.p());
            }
        }
    }

    public final b.a.e.m.e.n U(ArrayList<b.a.e.m.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i2)) == null) {
            if (i2 < 0 || (pbModel = this.f20830a.getPbModel()) == null || TextUtils.isEmpty(pbModel.T0())) {
                return null;
            }
            b.a.r0.m3.j0.p pVar = new b.a.r0.m3.j0.p();
            l(pVar);
            ListUtils.add(arrayList, i2 + 1, pVar);
            return pVar;
        }
        return (b.a.e.m.e.n) invokeLI.objValue;
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
            this.X = B();
            if (this.f20831b.getAdapter2() instanceof b.a.e.m.e.e) {
                this.f20831b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 == 1) {
                r rVar = this.f20832c;
                if (rVar != null) {
                    rVar.A0();
                }
                b.a.e.m.e.a aVar = this.n;
                if (aVar instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar).onPause();
                }
                b.a.e.m.e.a aVar2 = this.o;
                if (aVar2 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar2).onPause();
                }
                b.a.e.m.e.a aVar3 = this.q;
                if (aVar3 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar3).onPause();
                }
                m.a().j(this.f20830a.getPbActivity());
            } else if (i2 == 2) {
                r rVar2 = this.f20832c;
                if (rVar2 != null) {
                    rVar2.C0();
                }
                b.a.e.m.e.a aVar4 = this.n;
                if (aVar4 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar4).onResume();
                }
                b.a.e.m.e.a aVar5 = this.o;
                if (aVar5 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar5).onResume();
                }
                b.a.e.m.e.a aVar6 = this.q;
                if (aVar6 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar6).onResume();
                }
                b0(false);
            } else if (i2 != 3) {
            } else {
                r rVar3 = this.f20832c;
                if (rVar3 != null) {
                    rVar3.B0();
                }
                b.a.e.m.e.a aVar7 = this.n;
                if (aVar7 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar7).onDestroy();
                }
                b.a.e.m.e.a aVar8 = this.o;
                if (aVar8 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar8).onDestroy();
                }
                b.a.e.m.e.a aVar9 = this.q;
                if (aVar9 instanceof b.a.r0.a3.p) {
                    ((b.a.r0.a3.p) aVar9).onDestroy();
                }
                m.a().d();
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            b.a.e.f.m.e.a().removeCallbacks(this.W);
            m0 m0Var = this.f20837h;
            if (m0Var != null) {
                m0Var.onDestroy();
            }
            m0 m0Var2 = this.f20838i;
            if (m0Var2 != null) {
                m0Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f20833d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            b.a.r0.k2.u.f.a1.a aVar = this.f20836g;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public final void a0(boolean z, boolean z2, int i2, List<b.a.e.m.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), list}) == null) || z || z2) {
            return;
        }
        if ((!this.H && !this.G) || i2 == -1 || ListUtils.isEmpty(list) || this.I) {
            return;
        }
        this.W = new e(this, list);
        b.a.e.f.m.e.a().post(this.W);
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || this.f20830a.getPbView() == null || this.f20830a.getPbActivity() == null || this.f20830a.getPbActivity().getPbModel() == null) {
            return;
        }
        m.a().g(this.f20830a.getPbActivity().getPbModel().u1(), this.f20837h.j0(), this.f20830a.getPbView().M0(), this.f20830a.getPbActivity().getPageStayDurationItem(), z, this.y.b(), this.f20830a.getListView());
    }

    public void c0(b.a.r0.k2.r.f fVar, boolean z) {
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
        List<b.a.e.m.e.n> list;
        int i4;
        boolean z8;
        boolean z9;
        b.a.e.m.e.n nVar;
        int i5;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048604, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.z = fVar;
        if (!b.a.q0.b.d.J()) {
            u0();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.clear();
        b.a.r0.k2.r.f fVar2 = this.z;
        if (fVar2 != null && fVar2.F() != null && this.z.F().size() > 0) {
            this.A.addAll(this.z.F());
        }
        if (fVar.O() != null && fVar.O().J() != null) {
            this.L = fVar.O().J().getUserId();
        }
        if (this.f20832c == null) {
            return;
        }
        K(fVar);
        ArrayList<b.a.e.m.e.n> arrayList = new ArrayList<>(fVar.F());
        if (b.a.q0.f1.b.c.d()) {
            this.f20831b.setData(arrayList.subList(0, 1));
            this.f20832c.F0(false);
            return;
        }
        PostData p = p(arrayList);
        boolean z10 = p != null;
        if (!b.a.r0.z0.a.f() && b.a.q0.b.d.J() && this.z.n0()) {
            I(arrayList, Boolean.valueOf(z10));
        }
        if (p != null) {
            this.M = p;
        }
        if (this.E || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (fVar.r0() && p.M() != null) {
                p.y0(null);
            }
            z10 = true;
            z2 = true;
        }
        if (z10 || fVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = fVar.j();
            if (!this.E && fVar.r0() && j.M() != null) {
                j.y0(null);
            }
            postData = j;
            z10 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.f20830a.getIsMangaThread()) {
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
        b.a.r0.m3.w.f(arrayList, 1);
        int A = A(fVar, arrayList);
        if (A >= 0) {
            T(fVar, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int u = u(fVar, arrayList);
        List<b.a.e.m.e.n> v = v(fVar);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            b.a.e.m.e.n nVar2 = (b.a.e.m.e.n) ListUtils.getItem(arrayList, u);
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
            b.a.e.m.e.n U = U(arrayList, F);
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
                this.Z = i5;
                if (O(arrayList, i5) != null) {
                    this.Z = -1;
                    F++;
                }
            }
            if (b.a.q0.b.d.K() && z13) {
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
        this.f20832c.F0(!z5);
        boolean t0 = t0(postData);
        if (this.F && !t0) {
            arrayList.remove(postData);
            this.F = false;
        }
        if (fVar.S() != null) {
            fVar.S().k(!z6);
        }
        if (this.f20831b != null) {
            this.B = arrayList;
            List<b.a.e.m.e.n> R = fVar.R();
            if (!ListUtils.isEmpty(R)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + R.size() + 2);
                arrayList2.addAll(arrayList);
                b.a.r0.k2.r.k kVar = new b.a.r0.k2.r.k();
                PbListView K0 = this.f20830a.getPbView().K0();
                if (K0 != null && K0.n()) {
                    kVar.f20313e = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.pb_no_replay);
                    kVar.f20314f = true;
                    z8 = false;
                } else {
                    kVar.f20313e = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.list_has_no_more);
                    z8 = false;
                    kVar.f20314f = false;
                }
                arrayList2.add(kVar);
                b.a.r0.b0.g0.e eVar = new b.a.r0.b0.g0.e();
                eVar.f16275e = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.recommed_for_you);
                eVar.needTopMargin = z8;
                arrayList2.add(eVar);
                arrayList2.addAll(R);
                this.f20831b.setData(arrayList2);
            } else {
                this.f20831b.setData(this.B);
            }
        }
        a0(t0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f20831b.setData(arrayList);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C = z;
            this.f20832c.setFromCDN(z);
            b.a.e.m.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof b.a.r0.a3.t)) {
                ((b.a.r0.a3.t) aVar).k(z);
            }
            Iterator<b.a.r0.k2.u.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.F = z;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.D = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.J = z;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.G = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.H = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.E = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.I = z;
        }
    }

    public final void l(b.a.r0.m3.j0.p pVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, pVar) == null) || pVar == null || this.z == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().h4 = new b.a.q0.s.q.e();
        if (this.z.y() != null) {
            pVar.getAdvertAppInfo().h4.f14057b = this.z.y().a();
        }
        pVar.getAdvertAppInfo().h4.f14056a = pVar.K0();
        if (this.z.l() != null && (l = this.z.l()) != null) {
            pVar.getAdvertAppInfo().h4.f14059d = l.getId();
            pVar.getAdvertAppInfo().h4.f14060e = l.getFirst_class();
            pVar.getAdvertAppInfo().h4.f14061f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().h4.f14062g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().h4.f14063h = pVar.getAdvertAppInfo().f4;
        pVar.getAdvertAppInfo().h4.f14064i = false;
    }

    public void l0(boolean z) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (lVar = this.j) == null) {
            return;
        }
        lVar.V0(z);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f20830a == null || n()) {
            return;
        }
        this.f20830a.registerListener(this.g0);
    }

    public void m0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onClickListener) == null) {
            this.N = onClickListener;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f20830a == null) {
                return false;
            }
            this.h0 = new ArrayList();
            ArrayList<BdUniqueId> g2 = b.a.r0.m3.w.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                b.a.r0.q1.o.g.a b2 = b.a.r0.q1.r.b.d().b(this.f20830a.getPageContext(), g2.get(i2), 2);
                if (b2 != null) {
                    this.U.add(b2);
                    this.h0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.h0)) {
                return true;
            }
            this.f20831b.addAdapters(this.h0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, zVar) == null) {
            this.P = zVar;
        }
    }

    public final void o(List<b.a.e.m.e.n> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.J())) {
                    b.a.q0.s.q.p0 p0Var = new b.a.q0.s.q.p0();
                    p0Var.k(postData.J());
                    list.set(i2, p0Var);
                }
            }
        }
    }

    public void o0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onLongClickListener) == null) {
            this.S = onLongClickListener;
        }
    }

    public final PostData p(ArrayList<b.a.e.m.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, arrayList)) == null) {
            Iterator<b.a.e.m.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.e.m.e.n next = it.next();
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

    public void p0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, fVar) == null) {
            this.T = fVar;
        }
    }

    public final boolean q(PostData postData, ArrayList<b.a.e.m.e.n> arrayList, boolean z) {
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
                postData3.m0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.O = onClickListener;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.y.b() : (View) invokeV.objValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
            this.Q = onClickListener;
        }
    }

    public ArrayList<b.a.e.m.e.n> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void s0(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, cVar) == null) {
            this.R = cVar;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            r rVar = this.f20832c;
            if (rVar == null || rVar.v0() == null) {
                return null;
            }
            return this.f20832c.v0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean t0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, postData)) == null) ? (this.f20830a.getPbModel() == null || postData == null || postData.G() == null || !postData.G().equals(this.f20830a.getPbModel().l1())) ? false : true : invokeL.booleanValue;
    }

    public final int u(b.a.r0.k2.r.f fVar, ArrayList<b.a.e.m.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, fVar, arrayList)) == null) {
            if (this.G || fVar == null || ListUtils.isEmpty(fVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (fVar != null && fVar.r0() && this.E) ? 0 : -1;
            } else if (this.f20830a.getPbModel() == null || !this.f20830a.getPbModel().z0()) {
                if (this.f20830a.getPbView() == null || !this.f20830a.getPbView().C0()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z = false;
                            i2 = -1;
                            break;
                        }
                        b.a.e.m.e.n nVar = arrayList.get(i2);
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

    public final void u0() {
        b.a.r0.k2.r.f fVar;
        b.a.r0.m3.j0.p pVar;
        b.a.r0.m3.j0.p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (fVar = this.z) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<b.a.r0.m3.j0.p> e2 = this.z.e();
        if (b.a.r0.q1.o.k.a.e(F) || b.a.r0.q1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<b.a.r0.m3.j0.p> it = e2.iterator();
        while (it.hasNext()) {
            b.a.r0.m3.j0.p next = it.next();
            if (next != null && next.J0() != null) {
                sb.append(next.J0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<b.a.r0.m3.j0.p> it2 = e2.iterator();
        while (it2.hasNext()) {
            b.a.r0.m3.j0.p next2 = it2.next();
            if (next2 != null) {
                next2.O0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<b.a.r0.m3.j0.p> it3 = e2.iterator();
        while (it3.hasNext()) {
            b.a.r0.m3.j0.p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int W4 = next3.getAdvertAppInfo().W4();
                if (W4 != 0) {
                    b.a.r0.a3.l0.d.k(next3, W4);
                    if (W4 != 28 && W4 != 31) {
                        next3.getAdvertAppInfo().a4 = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            b.a.r0.m3.j0.p pVar3 = (b.a.r0.m3.j0.p) sparseArray.valueAt(i2);
            if (pVar3 != null && (pVar2 = (b.a.r0.m3.j0.p) hashMap.put(pVar3.I0(), pVar3)) != null) {
                b.a.r0.a3.l0.d.k(pVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (pVar = (b.a.r0.m3.j0.p) entry.getValue()) != null) {
                sparseArray.put(pVar.getPosition(), pVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            b.a.r0.q1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < b.a.r0.q1.o.k.a.k(arrayList); i4++) {
            b.a.r0.m3.j0.p pVar4 = (b.a.r0.m3.j0.p) sparseArray.get(((Integer) b.a.r0.q1.o.k.a.d(arrayList, i4)).intValue());
            if (this.z.l() != null) {
                pVar4.I0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                pVar4.L0 = b.a.e.f.m.b.g(this.z.O().f0(), 0L);
            }
            b.a.r0.k2.r.f fVar2 = this.z;
            if (fVar2 != null && fVar2.y() != null) {
                pVar4.M0 = this.z.y().a();
            }
            l(pVar4);
            int position = pVar4.getPosition() + this.z.Z;
            if (position >= b.a.r0.q1.o.k.a.k(F)) {
                pVar4.O0 = position;
                b.a.r0.a3.l0.d.l(pVar4, 2, position, b.a.r0.q1.o.k.a.k(F));
                return;
            }
            if (!this.E) {
                position--;
                pVar4.O0 = position;
            }
            if (position < 0) {
                b.a.r0.a3.l0.d.k(pVar4, 23);
            } else {
                b.a.r0.q1.o.k.a.b(F, pVar4, position);
                TiebaStatic.eventStat(this.f20830a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().q4);
            }
        }
    }

    public final List<b.a.e.m.e.n> v(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, fVar)) == null) {
            if (fVar == null || fVar.T() == null || ListUtils.isEmpty(fVar.T().f20357a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = fVar.T().f20357a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i2 = 0; i2 < min; i2++) {
                PostData postData = list.get(i2);
                if (postData != null) {
                    postData.j0 = true;
                    postData.R = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(fVar.T().f20358b) > 2) {
                b.a.e.m.e.n nVar = (b.a.e.m.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar instanceof PostData) {
                    ((PostData) nVar).R = false;
                }
                arrayList.add(new b.a.r0.k2.x.b());
            } else {
                b.a.e.m.e.n nVar2 = (b.a.e.m.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar2 instanceof PostData) {
                    ((PostData) nVar2).R = true;
                }
            }
            b.a.r0.k2.r.q qVar = new b.a.r0.k2.r.q(b.a.r0.k2.r.q.m);
            qVar.f20331e = fVar.T().f20359c;
            arrayList.add(0, qVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (i2 = this.Z) <= 0 || O(this.B, i2) == null) {
            return;
        }
        this.Z = -1;
        this.f20831b.setData(this.B);
        X();
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f20831b.getHeaderViewsCount() : invokeV.intValue;
    }

    public b.a.e.m.e.n x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) ? this.f20831b.getItem(i2) : (b.a.e.m.e.n) invokeI.objValue;
    }

    public BdUniqueId y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) {
            if (this.f20831b.getItem(i2) != null) {
                return this.f20831b.getItem(i2).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.f20833d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }
}
