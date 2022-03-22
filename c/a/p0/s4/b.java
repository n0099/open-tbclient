package c.a.p0.s4;

import c.a.p0.l0.c;
import c.a.p0.s4.q.d.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class b implements c.a.p0.l0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.s4.q.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f18272b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f18273c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f18274d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18275e;

    /* renamed from: f  reason: collision with root package name */
    public int f18276f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f18277g;

    /* loaded from: classes2.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.s4.q.d.a.b
        public void a(List<SimpleForum> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                this.a.f18273c = list;
                this.a.f18276f = i;
                this.a.h();
            }
        }

        @Override // c.a.p0.s4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18272b = new ArrayList<>();
        this.f18277g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        c.a.p0.s4.q.d.a aVar = new c.a.p0.s4.q.d.a(gen);
        this.a = aVar;
        aVar.i(this.f18277g);
        this.a.j(gen);
    }

    @Override // c.a.p0.l0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f18274d = aVar;
        }
    }

    @Override // c.a.p0.l0.c
    public void b() {
        c.a.p0.s4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f18274d == null || (aVar = this.a) == null) {
            return;
        }
        this.f18275e = false;
        aVar.l(null);
        this.a.k(null);
        this.a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f18275e) {
            return;
        }
        c.a aVar = this.f18274d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f18275e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f18272b.clear();
            if (ListUtils.getCount(this.f18273c) > 0) {
                for (SimpleForum simpleForum : this.f18273c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f18272b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f18274d;
            if (aVar != null) {
                aVar.a(this.f18272b, true, 2, this.f18276f);
            }
        }
    }
}
