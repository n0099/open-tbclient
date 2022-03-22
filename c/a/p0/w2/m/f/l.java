package c.a.p0.w2.m.f;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<PostData> A;
    public ArrayList<c.a.d.o.e.n> B;
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
    public TbRichTextView.y P;
    public View.OnClickListener Q;
    public c.a.p0.w2.j.c R;
    public View.OnLongClickListener S;
    public SortSwitchButton.f T;
    public final List<c.a.d.o.e.a> U;
    public final List<c.a.d.o.e.a> V;
    public Runnable W;
    public int X;
    public int Y;
    public int Z;
    public PbFragment a;
    public ThreadData a0;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f20192b;
    public List<PostData> b0;

    /* renamed from: c  reason: collision with root package name */
    public v f20193c;
    public final CustomMessageListener c0;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20194d;
    public CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f20195e;
    public final CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f20196f;
    public final View.OnClickListener f0;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.w2.m.f.h1.a f20197g;
    public CustomMessageListener g0;

    /* renamed from: h  reason: collision with root package name */
    public t0 f20198h;
    public List<c.a.d.o.e.a> h0;
    public t0 i;
    public p j;
    public c.a.p0.w2.p.a k;
    public c.a.p0.h0.f0.a l;
    public c.a.d.o.e.a m;
    public c.a.d.o.e.a n;
    public c.a.d.o.e.a o;
    public c.a.d.o.e.a p;
    public c.a.d.o.e.a q;
    public q0 r;
    public r0 s;
    public p0 t;
    public PbReplyLoadMoreAdapter u;
    public ArrayList<c.a.p0.w2.m.c.a> v;
    public m w;
    public c0 x;
    public c.a.p0.w2.m.c.b y;
    public c.a.p0.w2.i.f z;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof c.a.p0.a4.k0.n)) {
                return;
            }
            c.a.p0.a4.k0.n nVar = (c.a.p0.a4.k0.n) customResponsedMessage.getData();
            if (this.a.a0 == null || this.a.a0.funAdData != nVar) {
                return;
            }
            this.a.a0.funAdData.m(true);
            this.a.f20192b.setData(this.a.B);
            this.a.Y();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l lVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof c.a.p0.a4.k0.d)) {
                AbsDelegateAdapterList a = ((c.a.p0.a4.k0.d) customResponsedMessage.getData()).a();
                Iterator<c.a.d.o.e.a<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    c.a.d.o.e.a<?, ?> next = it.next();
                    if (next instanceof r) {
                        ((r) next).a0(this.a.a);
                        if (next instanceof c.a.p0.w2.m.c.a) {
                            this.a.v.add((c.a.p0.w2.m.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.V.clear();
                this.a.V.addAll(arrayList);
                if (this.a.f20192b != null) {
                    this.a.f20192b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.Y();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public d(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a == null || this.a.z == null || this.a.z.T() == null) {
                return;
            }
            this.a.a.S4().H0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f20199b;

        public e(l lVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20199b = lVar;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20199b.f20192b.setSelectionFromTop(this.f20199b.f20192b.getHeaderViewsCount() + this.a.size(), 0 - this.f20199b.Y);
                this.f20199b.I = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(l lVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.h0)) {
                this.a.n();
                l lVar = this.a;
                lVar.f0(lVar.z, false);
            }
        }
    }

    public l(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.K = c.a.d.f.p.n.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.f20192b = bdTypeListView;
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.e0);
        this.Y = c.a.d.f.p.n.i(this.a.getContext()) / 3;
    }

    public final int A(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, arrayList)) == null) {
            if (fVar == null || ListUtils.isEmpty(fVar.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(fVar.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    i = 0;
                    break;
                }
                c.a.d.o.e.n nVar = arrayList.get(i);
                if (nVar instanceof PostData) {
                    PostData postData = (PostData) nVar;
                    if (postData.A() == 1 && postData.M == 0) {
                        z = true;
                        break;
                    }
                }
                i++;
            }
            if (z) {
                return i + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdTypeListView bdTypeListView = this.f20192b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i = 0; i < this.f20192b.getData().size(); i++) {
                c.a.d.o.e.n nVar = this.f20192b.getData().get(i);
                if (nVar != null && nVar.getType() == c.a.p0.w2.i.r.f19847h) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int C(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, boolean z) {
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

    public int D(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, boolean z) {
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

    public final int F(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, boolean z) {
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

    public final ArrayList<c.a.d.o.e.n> H(List<c.a.d.o.e.n> list, List<c.a.d.o.e.n> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, list2)) == null) {
            ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            c.a.p0.w2.i.l lVar = new c.a.p0.w2.i.l();
            PbListView L0 = this.a.S4().L0();
            if (L0 != null && L0.n()) {
                lVar.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0daf);
                lVar.f19834b = true;
            } else {
                lVar.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e6);
                lVar.f19834b = false;
            }
            arrayList.add(lVar);
            c.a.p0.h0.f0.e eVar = new c.a.p0.h0.f0.e();
            eVar.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3a);
            eVar.needTopMargin = false;
            arrayList.add(eVar);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            v vVar = this.f20193c;
            if (vVar == null || vVar.o0() == null) {
                return null;
            }
            if (this.f20193c.o0().x != null && this.f20193c.o0().x.isShown()) {
                return this.f20193c.o0().x;
            }
            return this.f20193c.o0().w;
        }
        return (View) invokeV.objValue;
    }

    public final void J(ArrayList<c.a.d.o.e.n> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = c.a.o0.s.c.d.i();
        int j = c.a.o0.s.c.d.j() - 1;
        if (bool.booleanValue()) {
            c.a.d.o.e.n nVar = arrayList.get(0);
            if ((nVar instanceof PostData) && ((PostData) nVar).A() == 1) {
                j++;
            }
        }
        int k = c.a.o0.s.c.d.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.w() != null && this.a.w().c1() == 3) {
            this.b0.clear();
        }
        Q(j, i, k, arrayList);
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbFragment, bdTypeListView) == null) {
            v vVar = new v(pbFragment, PostData.v0);
            this.f20193c = vVar;
            vVar.B0(pbFragment);
            this.f20194d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, c.a.p0.w2.i.s.f19854f);
            this.f20195e = new PbFirstFloorEnterForumAdapter(pbFragment, c.a.p0.w2.i.h.i);
            this.f20196f = new PbFirstFloorItemAdapter(pbFragment.getContext(), c.a.p0.w2.i.i.f19829c);
            this.f20197g = new c.a.p0.w2.m.f.h1.a(pbFragment, c.a.p0.w2.i.a.f19804c);
            this.f20198h = new t0(pbFragment, c.a.p0.w2.i.r.f19847h);
            this.i = new t0(pbFragment, c.a.p0.w2.i.r.i);
            p pVar = new p(pbFragment, PostData.w0);
            this.j = pVar;
            pVar.Q0(pbFragment);
            this.m = c.a.p0.l3.z.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.n = c.a.p0.l3.z.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.o = c.a.p0.g1.c.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.p = c.a.p0.g1.c.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.q = c.a.p0.g1.c.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.t = new p0(pbFragment, c.a.p0.w2.i.o.K0);
            this.r = new q0(pbFragment, o0.H0);
            this.s = new r0(pbFragment, c.a.o0.r.r.d1.N0);
            this.u = new PbReplyLoadMoreAdapter(pbFragment, PostData.C0);
            this.k = new c.a.p0.w2.p.a(pbFragment, c.a.p0.w2.p.b.a);
            this.l = new c.a.p0.h0.f0.a(pbFragment.getPageContext());
            this.w = new m(pbFragment, c.a.o0.r.r.q.f10926e);
            this.x = new c0(pbFragment, pbFragment.getUniqueId());
            c.a.p0.w2.m.c.b bVar = new c.a.p0.w2.m.c.b(pbFragment, pbFragment.getUniqueId(), this.f20192b);
            this.y = bVar;
            this.U.addAll(bVar.a());
            this.U.add(this.f20193c);
            this.U.add(this.f20194d);
            this.U.add(this.f20195e);
            this.U.add(this.f20196f);
            this.U.add(this.f20197g);
            this.U.add(this.j);
            this.U.add(this.f20198h);
            this.U.add(this.i);
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new c.a.p0.a4.k0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.U);
        }
    }

    public final void L(@NonNull c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) {
            this.f20193c.t(fVar);
            this.f20193c.setFromCDN(this.C);
            this.f20193c.n(this.K);
            this.f20193c.c(this.D);
            this.f20193c.e(this.O);
            this.f20193c.m(this.N);
            this.f20193c.p(this.P);
            this.f20193c.d(this.S);
            this.f20193c.y0(this.Q);
            this.f20193c.A0(this.R);
            this.f20196f.d0(this.Q);
            this.j.t(fVar);
            this.j.setFromCDN(this.C);
            this.j.q(this.L);
            this.j.c(this.D);
            this.j.e(this.O);
            this.j.m(this.N);
            this.j.p(this.P);
            this.j.d(this.S);
            this.j.P0(this.R);
            this.f20194d.n0(this.O);
            this.u.d0(this.O);
            this.k.d0(this.f0);
            c.a.d.o.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.p0.l3.u)) {
                ((c.a.p0.l3.u) aVar).k(this.C);
            }
            Iterator<c.a.p0.w2.m.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                c.a.p0.w2.m.c.a next = it.next();
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
            this.f20198h.e(this.O);
            this.f20198h.f0(this.T);
            this.i.e(this.O);
            this.f20198h.t(fVar);
            this.f20197g.t(fVar);
            this.i.t(fVar);
            this.r.t(fVar);
            this.s.t(fVar);
            this.w.f0(fVar);
            this.w.e0(this.a.q1);
            this.x.d0(fVar);
            this.y.f(fVar);
        }
    }

    public final c.a.d.o.e.n M(ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, arrayList, i)) == null) {
            if (this.z == null) {
                return null;
            }
            c.a.p0.a4.k0.o m0 = this.a.w().m0();
            if (m0 == null) {
                m0 = this.z.z();
            }
            if (m0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert M0 = m0.M0();
            if (M0 != null) {
                M0.setAdvertAppInfo(m0.getAdvertAppInfo());
            }
            int q = m0.getAdvertAppInfo().q();
            if (q != 0) {
                c.a.p0.l3.m0.d.k(m0, q);
                if (q != 28 && q != 31) {
                    m0.getAdvertAppInfo().f29816c = -1001;
                }
                return null;
            }
            if (this.z.l() != null) {
                m0.G0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                m0.J0 = c.a.d.f.m.b.g(this.z.O().getId(), 0L);
            }
            c.a.p0.w2.i.f fVar = this.z;
            if (fVar != null && fVar.y() != null) {
                m0.K0 = this.z.y().a();
            }
            l(m0);
            if (i >= 0) {
                c.a.p0.b2.o.k.a.b(arrayList, m0, i);
                return m0;
            }
            return null;
        }
        return (c.a.d.o.e.n) invokeLI.objValue;
    }

    public final boolean N(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{fVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(fVar.f()) && fVar.f().size() > 2) {
                int min = Math.min(fVar.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    c.a.o0.r.r.q qVar = fVar.f().get(i5);
                    if (!z2 && i5 == 0) {
                        qVar.q(true);
                    }
                    if (qVar.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            qVar.s(true);
                        }
                    } else if (i5 == min - 2) {
                        qVar.s(true);
                    } else if (i5 == min - 1) {
                        qVar.r(true);
                    }
                    arrayList2.add(qVar);
                }
            }
            if (arrayList2.size() > 0) {
                int i6 = (!z || i < 0) ? z ? i2 + 2 : i2 >= 0 ? i2 + 1 : i3 >= 0 ? i3 : i4 >= 0 ? i4 : -1 : i + 1;
                if (i6 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i6, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final c.a.d.o.e.n O(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLLI;
        c.a.p0.w2.i.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048590, this, fVar, arrayList, i)) == null) {
            if (i < 0 || fVar == null || !fVar.k || (aVar = fVar.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, aVar);
            return aVar;
        }
        return (c.a.d.o.e.n) invokeLLI.objValue;
    }

    public final c.a.d.o.e.n P(ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLI;
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (fVar = this.z) != null && fVar.n0()) {
                String d2 = c.a.p0.g1.f.c.e().d("pb_banner");
                if (this.a0 == null && c.a.p0.g1.b.j().o(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.a0 = threadData;
                    threadData.funAdData = new c.a.p0.a4.k0.n();
                    c.a.p0.w2.i.f fVar2 = this.z;
                    if (fVar2 != null) {
                        this.a0.funAdData.j(fVar2.m());
                        this.a0.funAdData.n(this.z.Q());
                    }
                }
                ThreadData threadData2 = this.a0;
                if (threadData2 != null && threadData2.funAdData != null) {
                    ListUtils.add(arrayList, i, threadData2);
                }
            }
            return this.a0;
        }
        return (c.a.d.o.e.n) invokeLI.objValue;
    }

    public final void Q(int i, int i2, int i3, ArrayList<c.a.d.o.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<c.a.d.o.e.n> listIterator = arrayList.listIterator();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                if (i5 >= i3) {
                    break;
                }
                if (i5 < this.b0.size()) {
                    listIterator.add(this.b0.get(i5));
                } else {
                    PostData postData = new PostData();
                    c.a.p0.a4.k0.n nVar = new c.a.p0.a4.k0.n();
                    c.a.p0.w2.i.f fVar = this.z;
                    nVar.j(fVar != null ? fVar.m() : "");
                    c.a.p0.w2.i.f fVar2 = this.z;
                    nVar.n(fVar2 != null ? fVar2.Q() : "");
                    nVar.k(true);
                    postData.s0 = nVar;
                    listIterator.add(postData);
                    this.b0.add(postData);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
        if (i4 != i || i5 >= i3) {
            return;
        }
        PostData postData2 = new PostData();
        c.a.p0.a4.k0.n nVar2 = new c.a.p0.a4.k0.n();
        c.a.p0.w2.i.f fVar3 = this.z;
        nVar2.j(fVar3 != null ? fVar3.m() : "");
        c.a.p0.w2.i.f fVar4 = this.z;
        nVar2.n(fVar4 != null ? fVar4.Q() : "");
        nVar2.k(true);
        postData2.s0 = nVar2;
        listIterator.add(postData2);
        this.b0.add(postData2);
    }

    public final c.a.d.o.e.n R(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLLI;
        c.a.p0.w2.i.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, fVar, arrayList, i)) == null) {
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName())) {
                return null;
            }
            if (TextUtils.equals(fVar.l().getName(), this.a.w().s0()) && this.a.w().y0()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(fVar.p())) {
                hVar = new c.a.p0.w2.i.h(fVar.p().get(0));
            } else {
                hVar = new c.a.p0.w2.i.h(fVar.l());
            }
            hVar.f19827g = this.a.w().k1();
            ListUtils.add(arrayList, i + 1, hVar);
            return hVar;
        }
        return (c.a.d.o.e.n) invokeLLI.objValue;
    }

    public final c.a.d.o.e.n S(c.a.p0.w2.i.f fVar, PostData postData, ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048594, this, fVar, postData, arrayList, i)) == null) {
            c.a.p0.w2.i.i iVar = null;
            if (fVar.l() == null || StringUtils.isNull(fVar.l().getName()) || !TextUtils.equals(fVar.l().getName(), this.a.w().s0()) || !this.a.w().y0()) {
                if (postData != null) {
                    if (postData.o0 != null) {
                        iVar = new c.a.p0.w2.i.i(postData.o0);
                    }
                } else {
                    PostData postData2 = this.M;
                    if (postData2 != null && postData2.o0 != null) {
                        iVar = new c.a.p0.w2.i.i(this.M.o0);
                    }
                }
                if (iVar != null) {
                    iVar.f19830b = this.a.w().k1();
                    ListUtils.add(arrayList, i + 1, iVar);
                }
                return iVar;
            }
            return null;
        }
        return (c.a.d.o.e.n) invokeLLLI.objValue;
    }

    public final d0 T(ArrayList<c.a.d.o.e.n> arrayList, c.a.d.o.e.n nVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048595, this, arrayList, nVar, i, i2)) == null) {
            d0 B = this.z.B();
            if (B != null) {
                if (nVar != null) {
                    if (i2 >= 0 || nVar.getType() == AdvertAppInfo.z) {
                        i2 = nVar.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof d0)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (d0) invokeLLII.objValue;
    }

    public final void U(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048596, this, fVar, arrayList, i) == null) {
            c.a.p0.w2.i.r rVar = new c.a.p0.w2.i.r(c.a.p0.w2.i.r.f19847h);
            ThreadData O = fVar.O();
            if (O != null) {
                O.getReply_num();
            }
            rVar.f19850d = this.a.n5();
            rVar.f19849c = fVar.f19820g;
            fVar.c();
            rVar.f19851e = fVar.g0();
            rVar.f19853g = fVar.f19819f;
            ListUtils.add(arrayList, i, rVar);
            if (fVar.L() == 4) {
                ListUtils.add(arrayList, i + 1, new c.a.p0.w2.i.q());
            }
        }
    }

    public final c.a.d.o.e.n V(ArrayList<c.a.d.o.e.n> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (i < 0 || (w = this.a.w()) == null || TextUtils.isEmpty(w.W0())) {
                return null;
            }
            c.a.p0.a4.k0.o oVar = new c.a.p0.a4.k0.o();
            l(oVar);
            ListUtils.add(arrayList, i + 1, oVar);
            return oVar;
        }
        return (c.a.d.o.e.n) invokeLI.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.X = B();
            if (this.f20192b.getAdapter2() instanceof c.a.d.o.e.e) {
                this.f20192b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.S4() == null) {
                return;
            }
            this.a.S4().N1();
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            if (i == 1) {
                v vVar = this.f20193c;
                if (vVar != null) {
                    vVar.u0();
                }
                c.a.d.o.e.a aVar = this.n;
                if (aVar instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar).onPause();
                }
                c.a.d.o.e.a aVar2 = this.o;
                if (aVar2 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar2).onPause();
                }
                c.a.d.o.e.a aVar3 = this.q;
                if (aVar3 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar3).onPause();
                }
                q.a().j(this.a.x());
                c.a.o0.m0.c.a().d();
            } else if (i == 2) {
                v vVar2 = this.f20193c;
                if (vVar2 != null) {
                    vVar2.w0();
                }
                c.a.d.o.e.a aVar4 = this.n;
                if (aVar4 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar4).onResume();
                }
                c.a.d.o.e.a aVar5 = this.o;
                if (aVar5 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar5).onResume();
                }
                c.a.d.o.e.a aVar6 = this.q;
                if (aVar6 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar6).onResume();
                }
                e0(false);
                d0();
            } else if (i != 3) {
            } else {
                v vVar3 = this.f20193c;
                if (vVar3 != null) {
                    vVar3.v0();
                }
                c.a.d.o.e.a aVar7 = this.n;
                if (aVar7 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar7).onDestroy();
                }
                c.a.d.o.e.a aVar8 = this.o;
                if (aVar8 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar8).onDestroy();
                }
                c.a.d.o.e.a aVar9 = this.q;
                if (aVar9 instanceof c.a.p0.l3.p) {
                    ((c.a.p0.l3.p) aVar9).onDestroy();
                }
                q.a().d();
            }
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.W);
            t0 t0Var = this.f20198h;
            if (t0Var != null) {
                t0Var.onDestroy();
            }
            t0 t0Var2 = this.i;
            if (t0Var2 != null) {
                t0Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f20194d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            c.a.p0.w2.m.f.h1.a aVar = this.f20197g;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public void b0(boolean z) {
        v vVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z) == null) || (vVar = this.f20193c) == null) {
            return;
        }
        vVar.t0(z);
    }

    public final void c0(boolean z, boolean z2, int i, List<c.a.d.o.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.H && !this.G) || i == -1 || ListUtils.isEmpty(list) || this.I) {
            return;
        }
        this.W = new e(this, list);
        c.a.d.f.m.e.a().post(this.W);
    }

    public void d0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.z == null || (postData = this.M) == null || postData.L() == null || this.f20193c.o0() == null) {
            return;
        }
        c.a.o0.m0.c.a().c(this.z.Q(), this.z.m(), this.M.L(), this.f20193c.o0().o, this.f20193c.o0().r);
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || this.a.S4() == null || this.a.x() == null || this.a.x().getPbModel() == null) {
            return;
        }
        q.a().g(this.a.x().getPbModel().A1(), this.f20198h.c0(), this.a.S4().N0(), this.a.x().getPageStayDurationItem(), z, this.y.b(), this.a.getListView());
    }

    public void f0(c.a.p0.w2.i.f fVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        d0 d0Var;
        List<c.a.d.o.e.n> list;
        int i3;
        boolean z8;
        c.a.d.o.e.n nVar;
        int i4;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048607, this, fVar, z) == null) || fVar == null) {
            return;
        }
        this.z = fVar;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            x0();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.clear();
        c.a.p0.w2.i.f fVar2 = this.z;
        if (fVar2 != null && fVar2.F() != null && this.z.F().size() > 0) {
            this.A.addAll(this.z.F());
        }
        if (fVar.O() != null && fVar.O().getAuthor() != null) {
            this.L = fVar.O().getAuthor().getUserId();
        }
        if (this.f20193c == null) {
            return;
        }
        L(fVar);
        ArrayList<c.a.d.o.e.n> arrayList = new ArrayList<>(fVar.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!c.a.p0.h1.a.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.z.n0()) {
            J(arrayList, Boolean.valueOf(z9));
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
            z9 = true;
            z2 = true;
        }
        if (z9 || fVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = fVar.j();
            if (!this.E && fVar.r0() && j.N() != null) {
                j.z0(null);
            }
            postData = j;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.G4()) {
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
        c.a.p0.a4.x.f(arrayList, 1);
        int A = A(fVar, arrayList);
        if (A >= 0) {
            U(fVar, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int u = u(fVar, arrayList);
        List<c.a.d.o.e.n> v = v(fVar);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            c.a.d.o.e.n nVar2 = (c.a.d.o.e.n) ListUtils.getItem(arrayList, u);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z9 ? F(fVar, arrayList, this.E) : -1;
        if (F < 0 || fVar.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, fVar.S());
            z5 = true;
            z6 = true;
        }
        boolean z10 = S(fVar, postData, arrayList, F) != null;
        if (z10) {
            F++;
        }
        if (!z10 && R(fVar, arrayList, F) != null) {
            F++;
        }
        if (O(fVar, arrayList, F) != null) {
            F++;
        }
        if (z9) {
            c.a.d.o.e.n V = V(arrayList, F);
            boolean z11 = V != null;
            if (z11) {
                z8 = z11;
                nVar = V;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                nVar = M(arrayList, i4);
                z8 = nVar != null;
            }
            boolean z12 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z12 && this.z.n0()) {
                this.Z = i4;
                if (P(arrayList, i4) != null) {
                    this.Z = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                i2 = i4;
                z7 = z8;
                d0Var = null;
            } else {
                d0 T = T(arrayList, nVar, F, i4);
                if (T != null) {
                    if (!z8) {
                        i2 = i4;
                        d0Var = T;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                d0Var = T;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            d0Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean N = N(fVar, arrayList, z7, d0Var != null, i2, i5, u, A);
            if (d0Var != null) {
                d0Var.n = N;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.f20193c.z0(!z5);
        boolean w0 = w0(postData);
        if (this.F && !w0) {
            arrayList.remove(postData);
            this.F = false;
        }
        if (fVar.S() != null) {
            fVar.S().j(!z6);
        }
        if (this.f20192b != null) {
            this.B = arrayList;
            List<c.a.d.o.e.n> R = fVar.R();
            if (!ListUtils.isEmpty(R)) {
                this.f20192b.setData(H(arrayList, R));
            } else {
                this.f20192b.setData(this.B);
            }
        }
        c0(w0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<c.a.d.o.e.n> R2 = fVar.R();
            if (!ListUtils.isEmpty(R2)) {
                this.f20192b.setData(H(arrayList, R2));
            } else {
                this.f20192b.setData(arrayList);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.C = z;
            this.f20193c.setFromCDN(z);
            c.a.d.o.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof c.a.p0.l3.u)) {
                ((c.a.p0.l3.u) aVar).k(z);
            }
            Iterator<c.a.p0.w2.m.c.a> it = this.v.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.F = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.D = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.J = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.G = z;
        }
    }

    public final void l(c.a.p0.a4.k0.o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, oVar) == null) || oVar == null || this.z == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().j = new c.a.o0.r.r.e();
        if (this.z.y() != null) {
            oVar.getAdvertAppInfo().j.f10837b = this.z.y().a();
        }
        oVar.getAdvertAppInfo().j.a = oVar.L0();
        if (this.z.l() != null && (l = this.z.l()) != null) {
            oVar.getAdvertAppInfo().j.f10839d = l.getId();
            oVar.getAdvertAppInfo().j.f10840e = l.getFirst_class();
            oVar.getAdvertAppInfo().j.f10841f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().j.f10842g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().j.f10843h = oVar.getAdvertAppInfo().f29821h;
        oVar.getAdvertAppInfo().j.i = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.H = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.g0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.E = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.h0 = new ArrayList();
            ArrayList<BdUniqueId> g2 = c.a.p0.a4.x.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i = 0; i < size; i++) {
                c.a.p0.b2.o.g.a b2 = c.a.p0.b2.r.b.d().b(this.a.getPageContext(), g2.get(i), 2);
                if (b2 != null) {
                    this.U.add(b2);
                    this.h0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.h0)) {
                return true;
            }
            this.f20192b.a(this.h0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.I = z;
        }
    }

    public final void o(List<c.a.d.o.e.n> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.J())) {
                    c.a.o0.r.r.o0 o0Var = new c.a.o0.r.r.o0();
                    o0Var.i(postData.J());
                    list.set(i, o0Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        p pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z) == null) || (pVar = this.j) == null) {
            return;
        }
        pVar.O0(z);
    }

    public final PostData p(ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, arrayList)) == null) {
            Iterator<c.a.d.o.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.d.o.e.n next = it.next();
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

    public void p0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            this.N = onClickListener;
        }
    }

    public final boolean q(PostData postData, ArrayList<c.a.d.o.e.n> arrayList, boolean z) {
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

    public void q0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, yVar) == null) {
            this.P = yVar;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.y.b() : (View) invokeV.objValue;
    }

    public void r0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onLongClickListener) == null) {
            this.S = onLongClickListener;
        }
    }

    public ArrayList<c.a.d.o.e.n> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public void s0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, fVar) == null) {
            this.T = fVar;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            v vVar = this.f20193c;
            if (vVar == null || vVar.o0() == null) {
                return null;
            }
            return this.f20193c.o0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            this.O = onClickListener;
        }
    }

    public final int u(c.a.p0.w2.i.f fVar, ArrayList<c.a.d.o.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, fVar, arrayList)) == null) {
            if (this.G || fVar == null || ListUtils.isEmpty(fVar.F()) || arrayList == null || arrayList.size() <= 0) {
                return (fVar != null && fVar.r0() && this.E) ? 0 : -1;
            } else if (this.a.w() == null || !this.a.w().C0()) {
                if (this.a.S4() == null || !this.a.S4().D0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        c.a.d.o.e.n nVar = arrayList.get(i);
                        if (nVar instanceof PostData) {
                            PostData postData = (PostData) nVar;
                            if (postData.A() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? fVar.r0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onClickListener) == null) {
            this.Q = onClickListener;
        }
    }

    public final List<c.a.d.o.e.n> v(c.a.p0.w2.i.f fVar) {
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
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.g0 = true;
                    postData.N = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(fVar.T().f19870b) > 2) {
                c.a.d.o.e.n nVar = (c.a.d.o.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar instanceof PostData) {
                    ((PostData) nVar).N = false;
                }
                arrayList.add(new c.a.p0.w2.p.b());
            } else {
                c.a.d.o.e.n nVar2 = (c.a.d.o.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar2 instanceof PostData) {
                    ((PostData) nVar2).N = true;
                }
            }
            c.a.p0.w2.i.r rVar = new c.a.p0.w2.i.r(c.a.p0.w2.i.r.i);
            rVar.a = fVar.T().f19871c;
            arrayList.add(0, rVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, cVar) == null) {
            this.R = cVar;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.f20192b.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean w0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, postData)) == null) ? (this.a.w() == null || postData == null || postData.G() == null || !postData.G().equals(this.a.w().q1())) ? false : true : invokeL.booleanValue;
    }

    public c.a.d.o.e.n x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i)) == null) ? this.f20192b.G(i) : (c.a.d.o.e.n) invokeI.objValue;
    }

    public final void x0() {
        c.a.p0.w2.i.f fVar;
        c.a.p0.a4.k0.o oVar;
        c.a.p0.a4.k0.o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (fVar = this.z) == null || fVar.a0 || fVar.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = fVar.F();
        ArrayList<c.a.p0.a4.k0.o> e2 = this.z.e();
        if (c.a.p0.b2.o.k.a.e(F) || c.a.p0.b2.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<c.a.p0.a4.k0.o> it = e2.iterator();
        while (it.hasNext()) {
            c.a.p0.a4.k0.o next = it.next();
            if (next != null && next.K0() != null) {
                sb.append(next.K0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<c.a.p0.a4.k0.o> it2 = e2.iterator();
        while (it2.hasNext()) {
            c.a.p0.a4.k0.o next2 = it2.next();
            if (next2 != null) {
                next2.M0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<c.a.p0.a4.k0.o> it3 = e2.iterator();
        while (it3.hasNext()) {
            c.a.p0.a4.k0.o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    c.a.p0.l3.m0.d.k(next3, q);
                    if (q != 28 && q != 31) {
                        next3.getAdvertAppInfo().f29816c = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            c.a.p0.a4.k0.o oVar3 = (c.a.p0.a4.k0.o) sparseArray.valueAt(i);
            if (oVar3 != null && (oVar2 = (c.a.p0.a4.k0.o) hashMap.put(oVar3.J0(), oVar3)) != null) {
                c.a.p0.l3.m0.d.k(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (c.a.p0.a4.k0.o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            c.a.p0.b2.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < c.a.p0.b2.o.k.a.k(arrayList); i3++) {
            c.a.p0.a4.k0.o oVar4 = (c.a.p0.a4.k0.o) sparseArray.get(((Integer) c.a.p0.b2.o.k.a.d(arrayList, i3)).intValue());
            if (this.z.l() != null) {
                oVar4.G0 = this.z.l().getId();
            }
            if (this.z.O() != null) {
                oVar4.J0 = c.a.d.f.m.b.g(this.z.O().getId(), 0L);
            }
            c.a.p0.w2.i.f fVar2 = this.z;
            if (fVar2 != null && fVar2.y() != null) {
                oVar4.K0 = this.z.y().a();
            }
            l(oVar4);
            int position = oVar4.getPosition() + this.z.Z;
            if (position >= c.a.p0.b2.o.k.a.k(F)) {
                oVar4.M0 = position;
                c.a.p0.l3.m0.d.l(oVar4, 2, position, c.a.p0.b2.o.k.a.k(F));
                return;
            }
            if (!this.E) {
                position--;
                oVar4.M0 = position;
            }
            if (position < 0) {
                c.a.p0.l3.m0.d.k(oVar4, 23);
            } else {
                c.a.p0.b2.o.k.a.b(F, oVar4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().s);
            }
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) {
            if (this.f20192b.G(i) != null) {
                return this.f20192b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || (i = this.Z) <= 0 || P(this.B, i) == null) {
            return;
        }
        this.Z = -1;
        this.f20192b.setData(this.B);
        Y();
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.f20194d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }
}
