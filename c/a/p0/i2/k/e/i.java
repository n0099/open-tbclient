package c.a.p0.i2.k.e;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import c.a.o0.s.q.f1;
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
import com.baidu.tieba.R;
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
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<PostData> A;
    public ArrayList<c.a.e.k.e.n> B;
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
    public c.a.p0.i2.i.c R;
    public View.OnLongClickListener S;
    public SortSwitchButton.f T;
    public final List<c.a.e.k.e.a> U;
    public final List<c.a.e.k.e.a> V;
    public Runnable W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f19232a;
    public c2 a0;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f19233b;
    public List<PostData> b0;

    /* renamed from: c  reason: collision with root package name */
    public s f19234c;
    public final CustomMessageListener c0;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f19235d;
    public CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f19236e;
    public final CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f19237f;
    public final View.OnClickListener f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.i2.k.e.z0.a f19238g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public m0 f19239h;
    public List<c.a.e.k.e.a> h0;

    /* renamed from: i  reason: collision with root package name */
    public m0 f19240i;

    /* renamed from: j  reason: collision with root package name */
    public m f19241j;
    public c.a.p0.i2.n.a k;
    public c.a.p0.a0.e0.a l;
    public c.a.e.k.e.a m;
    public c.a.e.k.e.a n;
    public c.a.e.k.e.a o;
    public c.a.e.k.e.a p;
    public c.a.e.k.e.a q;
    public j0 r;
    public k0 s;
    public i0 t;
    public PbReplyLoadMoreAdapter u;
    public ArrayList<c.a.p0.i2.k.c.a> v;
    public j w;
    public x x;
    public c.a.p0.i2.k.c.b y;
    public c.a.p0.i2.h.e z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19242a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f19242a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.p0.i3.h0.o)) {
                return;
            }
            c.a.p0.i3.h0.o oVar = (c.a.p0.i3.h0.o) customResponsedMessage.getData();
            if (this.f19242a.a0 == null || this.f19242a.a0.H2 != oVar) {
                return;
            }
            this.f19242a.a0.H2.m(true);
            this.f19242a.f19233b.setData(this.f19242a.B);
            this.f19242a.X();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19243a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f19243a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof c.a.p0.i3.h0.d)) {
                AbsDelegateAdapterList a2 = ((c.a.p0.i3.h0.d) customResponsedMessage.getData()).a();
                Iterator<c.a.e.k.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    c.a.e.k.e.a<?, ?> next = it.next();
                    if (next instanceof o) {
                        ((o) next).i0(this.f19243a.f19232a);
                        if (next instanceof c.a.p0.i2.k.c.a) {
                            this.f19243a.v.add((c.a.p0.i2.k.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                this.f19243a.V.clear();
                this.f19243a.V.addAll(arrayList);
                if (this.f19243a.f19233b != null) {
                    this.f19243a.f19233b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19244a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19245e;

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
                this.f19245e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19245e.f19244a.X();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f19244a = iVar;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f19244a.z == null || c.a.e.a.j.c(this.f19244a.f19232a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                c.a.e.e.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f19246e;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19246e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19246e.f19232a == null || this.f19246e.z == null || this.f19246e.z.T() == null) {
                return;
            }
            this.f19246e.f19232a.getPbView().H0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f19247e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f19248f;

        public e(i iVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19248f = iVar;
            this.f19247e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19248f.f19233b.setSelectionFromTop(this.f19248f.f19233b.getHeaderViewsCount() + this.f19247e.size(), 0 - this.f19248f.Y);
                this.f19248f.I = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f19249a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
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
            this.f19249a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f19249a.h0)) {
                this.f19249a.n();
                i iVar = this.f19249a;
                iVar.c0(iVar.z, false);
            }
        }
    }

    public i(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.K = c.a.e.e.p.l.k(pbFragment.getPageContext().getPageActivity());
        this.f19232a = pbFragment;
        this.f19233b = bdTypeListView;
        J(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.e0);
        this.Y = c.a.e.e.p.l.i(this.f19232a.getContext()) / 3;
    }

    public final int A(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, arrayList)) == null) {
            if (eVar == null || ListUtils.isEmpty(eVar.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(eVar.F(), 0)) == null) {
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
                c.a.e.k.e.n nVar = arrayList.get(i2);
                if (nVar instanceof PostData) {
                    PostData postData = (PostData) nVar;
                    if (postData.A() == 1 && postData.O == 0) {
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
            BdTypeListView bdTypeListView = this.f19233b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f19233b.getData().size(); i2++) {
                c.a.e.k.e.n nVar = this.f19233b.getData().get(i2);
                if (nVar != null && nVar.getType() == c.a.p0.i2.h.o.l) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int C(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, eVar, arrayList, z)) == null) {
            if (eVar == null || eVar.F() == null || eVar.D() == null || eVar.F().size() == 0 || eVar.O() == null || arrayList == null || !eVar.D().C0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (eVar.F().get(0) == null || eVar.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (eVar.y() == null || eVar.y().a() != eVar.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, eVar, arrayList, z)) == null) {
            if (eVar == null || eVar.F() == null || eVar.E() == null || eVar.F().size() == 0 || eVar.O() == null || arrayList == null || !eVar.E().C0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (eVar.F().get(0) == null || eVar.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (eVar.y() == null || eVar.y().a() != eVar.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (ArrayList) invokeV.objValue;
    }

    public final int F(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, eVar, arrayList, z)) == null) {
            if (eVar == null || ListUtils.isEmpty(eVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (eVar == null || !eVar.p0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (eVar.F().get(0) == null || eVar.F().get(0).A() != 1) ? -1 : 1;
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
            s sVar = this.f19234c;
            if (sVar == null || sVar.w0() == null) {
                return null;
            }
            if (this.f19234c.w0().mPbBusinessPromotionContainer != null && this.f19234c.w0().mPbBusinessPromotionContainer.isShown()) {
                return this.f19234c.w0().mPbBusinessPromotionContainer;
            }
            return this.f19234c.w0().mForumEnterButtonContainer;
        }
        return (View) invokeV.objValue;
    }

    public final void I(ArrayList<c.a.e.k.e.n> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int f2 = c.a.o0.t.c.e.f();
        int g2 = c.a.o0.t.c.e.g() - 1;
        if (bool.booleanValue()) {
            c.a.e.k.e.n nVar = arrayList.get(0);
            if ((nVar instanceof PostData) && ((PostData) nVar).A() == 1) {
                g2++;
            }
        }
        int h2 = c.a.o0.t.c.e.h() + 1;
        PbFragment pbFragment = this.f19232a;
        if (pbFragment != null && pbFragment.getPbModel() != null && this.f19232a.getPbModel().Y0() == 3) {
            this.b0.clear();
        }
        P(g2, f2, h2, arrayList);
    }

    public void J(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, pbFragment, bdTypeListView) == null) {
            s sVar = new s(pbFragment, PostData.u0);
            this.f19234c = sVar;
            sVar.H0(pbFragment);
            this.f19235d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, c.a.p0.i2.h.p.f18774j);
            this.f19236e = new PbFirstFloorEnterForumAdapter(pbFragment, c.a.p0.i2.h.g.m);
            this.f19237f = new PbFirstFloorItemAdapter(pbFragment.getContext(), c.a.p0.i2.h.h.f18745g);
            this.f19238g = new c.a.p0.i2.k.e.z0.a(pbFragment, c.a.p0.i2.h.a.f18714g);
            this.f19239h = new m0(pbFragment, c.a.p0.i2.h.o.l);
            this.f19240i = new m0(pbFragment, c.a.p0.i2.h.o.m);
            m mVar = new m(pbFragment, PostData.v0);
            this.f19241j = mVar;
            mVar.X0(pbFragment);
            this.m = c.a.p0.x2.y.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.n = c.a.p0.x2.y.o().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.q4);
            this.o = c.a.p0.w0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.w4);
            this.p = c.a.p0.w0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x4);
            this.q = c.a.p0.w0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z4);
            this.t = new i0(pbFragment, c.a.p0.i2.h.l.J0);
            this.r = new j0(pbFragment, h0.G0);
            this.s = new k0(pbFragment, f1.M0);
            this.u = new PbReplyLoadMoreAdapter(pbFragment, PostData.B0);
            this.k = new c.a.p0.i2.n.a(pbFragment, c.a.p0.i2.n.b.f19601e);
            this.l = new c.a.p0.a0.e0.a(pbFragment.getPageContext());
            this.w = new j(pbFragment, c.a.o0.s.q.q.X3);
            this.x = new x(pbFragment, pbFragment.getUniqueId());
            c.a.p0.i2.k.c.b bVar = new c.a.p0.i2.k.c.b(pbFragment, pbFragment.getUniqueId(), this.f19233b);
            this.y = bVar;
            this.U.addAll(bVar.a());
            this.U.add(this.f19234c);
            this.U.add(this.f19235d);
            this.U.add(this.f19236e);
            this.U.add(this.f19237f);
            this.U.add(this.f19238g);
            this.U.add(this.f19241j);
            this.U.add(this.f19239h);
            this.U.add(this.f19240i);
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new c.a.p0.i3.h0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.addAdapters(this.U);
        }
    }

    public final void K(@NonNull c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            this.f19234c.t(eVar);
            this.f19234c.setFromCDN(this.C);
            this.f19234c.n(this.K);
            this.f19234c.c(this.D);
            this.f19234c.e(this.O);
            this.f19234c.m(this.N);
            this.f19234c.p(this.P);
            this.f19234c.d(this.S);
            this.f19234c.E0(this.Q);
            this.f19234c.G0(this.R);
            this.f19237f.l0(this.Q);
            this.f19241j.t(eVar);
            this.f19241j.setFromCDN(this.C);
            this.f19241j.q(this.L);
            this.f19241j.c(this.D);
            this.f19241j.e(this.O);
            this.f19241j.m(this.N);
            this.f19241j.p(this.P);
            this.f19241j.d(this.S);
            this.f19241j.W0(this.R);
            this.f19235d.t0(this.O);
            this.u.l0(this.O);
            this.k.l0(this.f0);
            c.a.e.k.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.p0.x2.t)) {
                ((c.a.p0.x2.t) aVar).k(this.C);
            }
            Iterator<c.a.p0.i2.k.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                c.a.p0.i2.k.c.a next = it.next();
                if (next != null) {
                    next.t(eVar);
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
            this.f19239h.e(this.O);
            this.f19239h.n0(this.T);
            this.f19240i.e(this.O);
            this.f19239h.t(eVar);
            this.f19238g.t(eVar);
            this.f19240i.t(eVar);
            this.r.t(eVar);
            this.s.t(eVar);
            this.w.n0(eVar);
            this.w.m0(this.f19232a.bjhFrom);
            this.x.l0(eVar);
            this.y.f(eVar);
        }
    }

    public final c.a.e.k.e.n L(ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, arrayList, i2)) == null) {
            if (this.z == null) {
                return null;
            }
            c.a.p0.i3.h0.p j0 = this.f19232a.getPbModel().j0();
            if (j0 == null) {
                j0 = this.z.z();
            }
            if (j0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert F0 = j0.F0();
            if (F0 != null) {
                F0.setAdvertAppInfo(j0.getAdvertAppInfo());
            }
            int I4 = j0.getAdvertAppInfo().I4();
            if (I4 != 0) {
                c.a.p0.x2.l0.d.j(j0, I4);
                if (I4 != 28 && I4 != 31) {
                    j0.getAdvertAppInfo().V3 = -1001;
                }
                return null;
            }
            if (this.z.m() != null) {
                j0.F0 = this.z.m().getId();
            }
            if (this.z.O() != null) {
                j0.I0 = c.a.e.e.m.b.f(this.z.O().f0(), 0L);
            }
            c.a.p0.i2.h.e eVar = this.z;
            if (eVar != null && eVar.y() != null) {
                j0.J0 = this.z.y().a();
            }
            l(j0);
            if (i2 >= 0) {
                c.a.p0.o1.o.k.a.b(arrayList, j0, i2);
                return j0;
            }
            return null;
        }
        return (c.a.e.k.e.n) invokeLI.objValue;
    }

    public final boolean M(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{eVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(eVar.f()) && eVar.f().size() > 2) {
                int min = Math.min(eVar.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    c.a.o0.s.q.q qVar = eVar.f().get(i6);
                    if (!z2 && i6 == 0) {
                        qVar.I4(true);
                    }
                    if (qVar.o1() == null) {
                        if (i6 == min - 1) {
                            qVar.K4(true);
                        }
                    } else if (i6 == min - 2) {
                        qVar.K4(true);
                    } else if (i6 == min - 1) {
                        qVar.J4(true);
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

    public final c.a.e.k.e.n N(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        c.a.p0.i2.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, eVar, arrayList, i2)) == null) {
            if (i2 < 0 || eVar == null || !eVar.k || (aVar = eVar.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i2, aVar);
            return aVar;
        }
        return (c.a.e.k.e.n) invokeLLI.objValue;
    }

    public final c.a.e.k.e.n O(ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i2)) == null) {
            if (c.a.o0.b.d.R() && i2 > 0) {
                String d2 = c.a.p0.w0.d.c.e().d("pb_banner");
                if (this.a0 == null && c.a.p0.w0.a.i().m(d2)) {
                    c2 c2Var = new c2();
                    this.a0 = c2Var;
                    c2Var.H2 = new c.a.p0.i3.h0.o();
                    c.a.p0.i2.h.e eVar = this.z;
                    if (eVar != null) {
                        this.a0.H2.j(eVar.n());
                        this.a0.H2.n(this.z.Q());
                    }
                }
                c2 c2Var2 = this.a0;
                if (c2Var2 != null && c2Var2.H2 != null) {
                    ListUtils.add(arrayList, i2, c2Var2);
                }
            }
            return this.a0;
        }
        return (c.a.e.k.e.n) invokeLI.objValue;
    }

    public final void P(int i2, int i3, int i4, ArrayList<c.a.e.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i2 < 0 || i3 < 1) {
            return;
        }
        ListIterator<c.a.e.k.e.n> listIterator = arrayList.listIterator();
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
                    c.a.p0.i3.h0.o oVar = new c.a.p0.i3.h0.o();
                    c.a.p0.i2.h.e eVar = this.z;
                    oVar.j(eVar != null ? eVar.n() : "");
                    c.a.p0.i2.h.e eVar2 = this.z;
                    oVar.n(eVar2 != null ? eVar2.Q() : "");
                    oVar.k(true);
                    postData.s0 = oVar;
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
        c.a.p0.i3.h0.o oVar2 = new c.a.p0.i3.h0.o();
        c.a.p0.i2.h.e eVar3 = this.z;
        oVar2.j(eVar3 != null ? eVar3.n() : "");
        c.a.p0.i2.h.e eVar4 = this.z;
        oVar2.n(eVar4 != null ? eVar4.Q() : "");
        oVar2.k(true);
        postData2.s0 = oVar2;
        listIterator.add(postData2);
        this.b0.add(postData2);
    }

    public final c.a.e.k.e.n Q(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        c.a.p0.i2.h.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, eVar, arrayList, i2)) == null) {
            if (eVar.m() == null || StringUtils.isNull(eVar.m().getName())) {
                return null;
            }
            if (TextUtils.equals(eVar.m().getName(), this.f19232a.getPbModel().p0()) && this.f19232a.getPbModel().u0()) {
                return null;
            }
            if (!this.f19232a.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
                gVar = new c.a.p0.i2.h.g(eVar.q().get(0));
            } else {
                gVar = new c.a.p0.i2.h.g(eVar.m());
            }
            gVar.k = this.f19232a.getPbModel().e1();
            ListUtils.add(arrayList, i2 + 1, gVar);
            return gVar;
        }
        return (c.a.e.k.e.n) invokeLLI.objValue;
    }

    public final c.a.e.k.e.n R(c.a.p0.i2.h.e eVar, PostData postData, ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048593, this, eVar, postData, arrayList, i2)) == null) {
            c.a.p0.i2.h.h hVar = null;
            if (eVar.m() == null || StringUtils.isNull(eVar.m().getName()) || !TextUtils.equals(eVar.m().getName(), this.f19232a.getPbModel().p0()) || !this.f19232a.getPbModel().u0()) {
                if (postData != null) {
                    if (postData.p0 != null) {
                        hVar = new c.a.p0.i2.h.h(postData.p0);
                    }
                } else {
                    PostData postData2 = this.M;
                    if (postData2 != null && postData2.p0 != null) {
                        hVar = new c.a.p0.i2.h.h(this.M.p0);
                    }
                }
                if (hVar != null) {
                    hVar.f18747f = this.f19232a.getPbModel().e1();
                    ListUtils.add(arrayList, i2 + 1, hVar);
                }
                return hVar;
            }
            return null;
        }
        return (c.a.e.k.e.n) invokeLLLI.objValue;
    }

    public final y S(ArrayList<c.a.e.k.e.n> arrayList, c.a.e.k.e.n nVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048594, this, arrayList, nVar, i2, i3)) == null) {
            y B = this.z.B();
            if (B != null) {
                if (nVar != null) {
                    if (i3 >= 0 || nVar.getType() == AdvertAppInfo.q4) {
                        i3 = nVar.getType() != AdvertAppInfo.q4 ? i3 + 1 : -1;
                    } else {
                        i3 = i2 + 2;
                    }
                }
                if (i3 <= 0 || !(B instanceof y)) {
                    return null;
                }
                ListUtils.add(arrayList, i3, B);
                return B;
            }
            return null;
        }
        return (y) invokeLLII.objValue;
    }

    public final void T(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048595, this, eVar, arrayList, i2) == null) {
            c.a.p0.i2.h.o oVar = new c.a.p0.i2.h.o(c.a.p0.i2.h.o.l);
            c2 O = eVar.O();
            if (O != null) {
                O.S0();
            }
            oVar.f18771h = this.f19232a.isHostOnlyMode();
            oVar.f18770g = eVar.f18735g;
            eVar.c();
            oVar.f18772i = eVar.f0();
            oVar.k = eVar.f18734f;
            ListUtils.add(arrayList, i2, oVar);
            if (eVar.L() == 4) {
                ListUtils.add(arrayList, i2 + 1, new c.a.p0.i2.h.n());
            }
        }
    }

    public final c.a.e.k.e.n U(ArrayList<c.a.e.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        PbModel pbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, arrayList, i2)) == null) {
            if (i2 < 0 || (pbModel = this.f19232a.getPbModel()) == null || TextUtils.isEmpty(pbModel.S0())) {
                return null;
            }
            c.a.p0.i3.h0.p pVar = new c.a.p0.i3.h0.p();
            l(pVar);
            ListUtils.add(arrayList, i2 + 1, pVar);
            return pVar;
        }
        return (c.a.e.k.e.n) invokeLI.objValue;
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
            if (this.f19233b.getAdapter2() instanceof c.a.e.k.e.e) {
                this.f19233b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 == 1) {
                s sVar = this.f19234c;
                if (sVar != null) {
                    sVar.A0();
                }
                c.a.e.k.e.a aVar = this.n;
                if (aVar instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar).onPause();
                }
                c.a.e.k.e.a aVar2 = this.o;
                if (aVar2 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar2).onPause();
                }
                c.a.e.k.e.a aVar3 = this.q;
                if (aVar3 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar3).onPause();
                }
                n.a().j(this.f19232a.getPbActivity());
            } else if (i2 == 2) {
                s sVar2 = this.f19234c;
                if (sVar2 != null) {
                    sVar2.C0();
                }
                c.a.e.k.e.a aVar4 = this.n;
                if (aVar4 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar4).onResume();
                }
                c.a.e.k.e.a aVar5 = this.o;
                if (aVar5 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar5).onResume();
                }
                c.a.e.k.e.a aVar6 = this.q;
                if (aVar6 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar6).onResume();
                }
                b0(false);
            } else if (i2 != 3) {
            } else {
                s sVar3 = this.f19234c;
                if (sVar3 != null) {
                    sVar3.B0();
                }
                c.a.e.k.e.a aVar7 = this.n;
                if (aVar7 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar7).onDestroy();
                }
                c.a.e.k.e.a aVar8 = this.o;
                if (aVar8 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar8).onDestroy();
                }
                c.a.e.k.e.a aVar9 = this.q;
                if (aVar9 instanceof c.a.p0.x2.p) {
                    ((c.a.p0.x2.p) aVar9).onDestroy();
                }
                n.a().d();
            }
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.W);
            m0 m0Var = this.f19239h;
            if (m0Var != null) {
                m0Var.onDestroy();
            }
            m0 m0Var2 = this.f19240i;
            if (m0Var2 != null) {
                m0Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f19235d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            c.a.p0.i2.k.e.z0.a aVar = this.f19238g;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public final void a0(boolean z, boolean z2, int i2, List<c.a.e.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), list}) == null) || z || z2) {
            return;
        }
        if ((!this.H && !this.G) || i2 == -1 || ListUtils.isEmpty(list) || this.I) {
            return;
        }
        this.W = new e(this, list);
        c.a.e.e.m.e.a().post(this.W);
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || this.f19232a.getPbView() == null || this.f19232a.getPbActivity() == null || this.f19232a.getPbActivity().getPbModel() == null) {
            return;
        }
        n.a().g(this.f19232a.getPbActivity().getPbModel().o1(), this.f19239h.k0(), this.f19232a.getPbView().M0(), this.f19232a.getPbActivity().getPageStayDurationItem(), z, this.y.b(), this.f19232a.getListView());
    }

    public void c0(c.a.p0.i2.h.e eVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        boolean z7;
        y yVar;
        int i3;
        List<c.a.e.k.e.n> list;
        int i4;
        boolean z8;
        boolean z9;
        c.a.e.k.e.n nVar;
        int i5;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048604, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.z = eVar;
        if (!c.a.o0.b.d.M()) {
            u0();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.clear();
        c.a.p0.i2.h.e eVar2 = this.z;
        if (eVar2 != null && eVar2.F() != null && this.z.F().size() > 0) {
            this.A.addAll(this.z.F());
        }
        if (eVar.O() != null && eVar.O().J() != null) {
            this.L = eVar.O().J().getUserId();
        }
        if (this.f19234c == null) {
            return;
        }
        K(eVar);
        ArrayList<c.a.e.k.e.n> arrayList = new ArrayList<>(eVar.F());
        if (c.a.o0.e1.b.e.d()) {
            this.f19233b.setData(arrayList.subList(0, 1));
            this.f19234c.F0(false);
            return;
        }
        PostData p = p(arrayList);
        boolean z10 = p != null;
        if (!c.a.p0.x0.a.f() && c.a.o0.b.d.M()) {
            I(arrayList, Boolean.valueOf(z10));
        }
        if (p != null) {
            this.M = p;
        }
        if (this.E || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (eVar.p0() && p.K() != null) {
                p.t0(null);
            }
            z10 = true;
            z2 = true;
        }
        if (z10 || eVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j2 = eVar.j();
            if (!this.E && eVar.p0() && j2.K() != null) {
                j2.t0(null);
            }
            postData = j2;
            z10 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.f19232a.getIsMangaThread()) {
            if (eVar.F().size() > 0 && (postData2 = eVar.F().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        c.a.p0.i3.v.f(arrayList, 1);
        int A = A(eVar, arrayList);
        if (A >= 0) {
            T(eVar, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int u = u(eVar, arrayList);
        List<c.a.e.k.e.n> v = v(eVar);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            c.a.e.k.e.n nVar2 = (c.a.e.k.e.n) ListUtils.getItem(arrayList, u);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z10 ? F(eVar, arrayList, this.E) : -1;
        if (F < 0 || eVar.S() == null) {
            if (postData != null) {
                postData.Q = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, eVar.S());
            z5 = true;
            z6 = true;
        }
        boolean z11 = R(eVar, postData, arrayList, F) != null;
        if (z11) {
            F++;
        }
        if (!z11 && Q(eVar, arrayList, F) != null) {
            F++;
        }
        if (N(eVar, arrayList, F) != null) {
            F++;
        }
        if (z10) {
            c.a.e.k.e.n U = U(arrayList, F);
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
            if (z13) {
                this.Z = i5;
                if (O(arrayList, i5) != null) {
                    this.Z = -1;
                    F++;
                }
            }
            if (c.a.o0.b.d.R() && z13) {
                i2 = F;
                z7 = z9;
                yVar = null;
            } else {
                y S = S(arrayList, nVar, F, i5);
                if (S != null) {
                    if (!z9) {
                        i3 = i5;
                        yVar = S;
                        i2 = F;
                        z7 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        F++;
                    }
                }
                yVar = S;
                i2 = F;
                z7 = z9;
            }
            i3 = i5;
        } else {
            i2 = F;
            z7 = false;
            yVar = null;
            i3 = -1;
        }
        if (z10) {
            y yVar2 = yVar;
            list = v;
            i4 = u;
            boolean M = M(eVar, arrayList, z7, yVar != null, i3, i2, u, A);
            if (yVar2 != null) {
                yVar2.r = M;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.f19234c.F0(!z5);
        boolean t0 = t0(postData);
        if (this.F && !t0) {
            arrayList.remove(postData);
            this.F = false;
        }
        if (eVar.S() != null) {
            eVar.S().k(!z6);
        }
        if (this.f19233b != null) {
            this.B = arrayList;
            List<c.a.e.k.e.n> R = eVar.R();
            if (!ListUtils.isEmpty(R)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + R.size() + 2);
                arrayList2.addAll(arrayList);
                c.a.p0.i2.h.j jVar = new c.a.p0.i2.h.j();
                PbListView K0 = this.f19232a.getPbView().K0();
                if (K0 != null && K0.m()) {
                    jVar.f18751e = TbadkCoreApplication.getInst().getString(R.string.pb_no_replay);
                    jVar.f18752f = true;
                    z8 = false;
                } else {
                    jVar.f18751e = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                    z8 = false;
                    jVar.f18752f = false;
                }
                arrayList2.add(jVar);
                c.a.p0.a0.e0.e eVar3 = new c.a.p0.a0.e0.e();
                eVar3.f15002e = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
                eVar3.needTopMargin = z8;
                arrayList2.add(eVar3);
                arrayList2.addAll(R);
                this.f19233b.setData(arrayList2);
            } else {
                this.f19233b.setData(this.B);
            }
        }
        a0(t0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f19233b.setData(arrayList);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C = z;
            this.f19234c.setFromCDN(z);
            c.a.e.k.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.p0.x2.t)) {
                ((c.a.p0.x2.t) aVar).k(z);
            }
            Iterator<c.a.p0.i2.k.c.a> it = this.v.iterator();
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

    public final void l(c.a.p0.i3.h0.p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, pVar) == null) || pVar == null || this.z == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().c4 = new c.a.o0.s.q.e();
        if (this.z.y() != null) {
            pVar.getAdvertAppInfo().c4.f13887b = this.z.y().a();
        }
        pVar.getAdvertAppInfo().c4.f13886a = pVar.E0();
        if (this.z.m() != null && (m = this.z.m()) != null) {
            pVar.getAdvertAppInfo().c4.f13889d = m.getId();
            pVar.getAdvertAppInfo().c4.f13890e = m.getFirst_class();
            pVar.getAdvertAppInfo().c4.f13891f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().c4.f13892g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().c4.f13893h = pVar.getAdvertAppInfo().a4;
        pVar.getAdvertAppInfo().c4.f13894i = false;
    }

    public void l0(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || (mVar = this.f19241j) == null) {
            return;
        }
        mVar.V0(z);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f19232a == null || n()) {
            return;
        }
        this.f19232a.registerListener(this.g0);
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
            if (this.f19232a == null) {
                return false;
            }
            this.h0 = new ArrayList();
            ArrayList<BdUniqueId> g2 = c.a.p0.i3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.p0.o1.o.g.a b2 = c.a.p0.o1.r.b.d().b(this.f19232a.getPageContext(), g2.get(i2), 2);
                if (b2 != null) {
                    this.U.add(b2);
                    this.h0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.h0)) {
                return true;
            }
            this.f19233b.addAdapters(this.h0);
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

    public final void o(List<c.a.e.k.e.n> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.H())) {
                    c.a.o0.s.q.p0 p0Var = new c.a.o0.s.q.p0();
                    p0Var.k(postData.H());
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

    public final PostData p(ArrayList<c.a.e.k.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, arrayList)) == null) {
            Iterator<c.a.e.k.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.e.k.e.n next = it.next();
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

    public final boolean q(PostData postData, ArrayList<c.a.e.k.e.n> arrayList, boolean z) {
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
                postData3.i0(1);
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

    public ArrayList<c.a.e.k.e.n> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void s0(c.a.p0.i2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, cVar) == null) {
            this.R = cVar;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            s sVar = this.f19234c;
            if (sVar == null || sVar.w0() == null) {
                return null;
            }
            return this.f19234c.w0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public final boolean t0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, postData)) == null) ? (this.f19232a.getPbModel() == null || postData == null || postData.E() == null || !postData.E().equals(this.f19232a.getPbModel().j1())) ? false : true : invokeL.booleanValue;
    }

    public final int u(c.a.p0.i2.h.e eVar, ArrayList<c.a.e.k.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, eVar, arrayList)) == null) {
            if (this.G || eVar == null || ListUtils.isEmpty(eVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (eVar != null && eVar.p0() && this.E) ? 0 : -1;
            } else if (this.f19232a.getPbModel() == null || !this.f19232a.getPbModel().y0()) {
                if (this.f19232a.getPbView() == null || !this.f19232a.getPbView().D0()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z = false;
                            i2 = -1;
                            break;
                        }
                        c.a.e.k.e.n nVar = arrayList.get(i2);
                        if (nVar instanceof PostData) {
                            PostData postData = (PostData) nVar;
                            if (postData.A() == 1 && postData.O == 0) {
                                z = true;
                                break;
                            }
                        }
                        i2++;
                    }
                    return !z ? eVar.p0() ? 0 : -1 : i2 + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public final void u0() {
        c.a.p0.i2.h.e eVar;
        c.a.p0.i3.h0.p pVar;
        c.a.p0.i3.h0.p pVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (eVar = this.z) == null || eVar.a0 || eVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = eVar.F();
        ArrayList<c.a.p0.i3.h0.p> e2 = this.z.e();
        if (c.a.p0.o1.o.k.a.e(F) || c.a.p0.o1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<c.a.p0.i3.h0.p> it = e2.iterator();
        while (it.hasNext()) {
            c.a.p0.i3.h0.p next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<c.a.p0.i3.h0.p> it2 = e2.iterator();
        while (it2.hasNext()) {
            c.a.p0.i3.h0.p next2 = it2.next();
            if (next2 != null) {
                next2.L0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<c.a.p0.i3.h0.p> it3 = e2.iterator();
        while (it3.hasNext()) {
            c.a.p0.i3.h0.p next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int I4 = next3.getAdvertAppInfo().I4();
                if (I4 != 0) {
                    c.a.p0.x2.l0.d.j(next3, I4);
                    if (I4 != 28 && I4 != 31) {
                        next3.getAdvertAppInfo().V3 = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            c.a.p0.i3.h0.p pVar3 = (c.a.p0.i3.h0.p) sparseArray.valueAt(i2);
            if (pVar3 != null && (pVar2 = (c.a.p0.i3.h0.p) hashMap.put(pVar3.C0(), pVar3)) != null) {
                c.a.p0.x2.l0.d.j(pVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (pVar = (c.a.p0.i3.h0.p) entry.getValue()) != null) {
                sparseArray.put(pVar.getPosition(), pVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            c.a.p0.o1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < c.a.p0.o1.o.k.a.k(arrayList); i4++) {
            c.a.p0.i3.h0.p pVar4 = (c.a.p0.i3.h0.p) sparseArray.get(((Integer) c.a.p0.o1.o.k.a.d(arrayList, i4)).intValue());
            if (this.z.m() != null) {
                pVar4.F0 = this.z.m().getId();
            }
            if (this.z.O() != null) {
                pVar4.I0 = c.a.e.e.m.b.f(this.z.O().f0(), 0L);
            }
            c.a.p0.i2.h.e eVar2 = this.z;
            if (eVar2 != null && eVar2.y() != null) {
                pVar4.J0 = this.z.y().a();
            }
            l(pVar4);
            int position = pVar4.getPosition() + this.z.Z;
            if (position >= c.a.p0.o1.o.k.a.k(F)) {
                pVar4.L0 = position;
                c.a.p0.x2.l0.d.k(pVar4, 2, position, c.a.p0.o1.o.k.a.k(F));
                return;
            }
            if (!this.E) {
                position--;
                pVar4.L0 = position;
            }
            if (position < 0) {
                c.a.p0.x2.l0.d.j(pVar4, 23);
            } else {
                c.a.p0.o1.o.k.a.b(F, pVar4, position);
                TiebaStatic.eventStat(this.f19232a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", pVar4.getAdvertAppInfo().l4);
            }
        }
    }

    public final List<c.a.e.k.e.n> v(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, eVar)) == null) {
            if (eVar == null || eVar.T() == null || ListUtils.isEmpty(eVar.T().f18797a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = eVar.T().f18797a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i2 = 0; i2 < min; i2++) {
                PostData postData = list.get(i2);
                if (postData != null) {
                    postData.c0 = true;
                    postData.P = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(eVar.T().f18798b) > 2) {
                c.a.e.k.e.n nVar = (c.a.e.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar instanceof PostData) {
                    ((PostData) nVar).P = false;
                }
                arrayList.add(new c.a.p0.i2.n.b());
            } else {
                c.a.e.k.e.n nVar2 = (c.a.e.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar2 instanceof PostData) {
                    ((PostData) nVar2).P = true;
                }
            }
            c.a.p0.i2.h.o oVar = new c.a.p0.i2.h.o(c.a.p0.i2.h.o.m);
            oVar.f18768e = eVar.T().f18799c;
            arrayList.add(0, oVar);
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
        this.f19233b.setData(this.B);
        X();
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f19233b.getHeaderViewsCount() : invokeV.intValue;
    }

    public c.a.e.k.e.n x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) ? this.f19233b.getItem(i2) : (c.a.e.k.e.n) invokeI.objValue;
    }

    public BdUniqueId y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i2)) == null) {
            if (this.f19233b.getItem(i2) != null) {
                return this.f19233b.getItem(i2).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.f19235d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }
}
