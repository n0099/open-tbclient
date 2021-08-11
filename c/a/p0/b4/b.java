package c.a.p0.b4;

import c.a.p0.b4.q.d.a;
import c.a.p0.e0.c;
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
/* loaded from: classes3.dex */
public class b implements c.a.p0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.b4.q.d.a f15801a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f15802b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f15803c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f15804d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15805e;

    /* renamed from: f  reason: collision with root package name */
    public int f15806f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f15807g;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f15808a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15808a = bVar;
        }

        @Override // c.a.p0.b4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f15808a.f15803c = list;
                this.f15808a.f15806f = i2;
                this.f15808a.h();
            }
        }

        @Override // c.a.p0.b4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f15808a.g();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15802b = new ArrayList<>();
        this.f15807g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        c.a.p0.b4.q.d.a aVar = new c.a.p0.b4.q.d.a(gen);
        this.f15801a = aVar;
        aVar.i(this.f15807g);
        this.f15801a.j(gen);
    }

    @Override // c.a.p0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f15804d = aVar;
        }
    }

    @Override // c.a.p0.e0.c
    public void b() {
        c.a.p0.b4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f15804d == null || (aVar = this.f15801a) == null) {
            return;
        }
        this.f15805e = false;
        aVar.l(null);
        this.f15801a.k(null);
        this.f15801a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f15805e) {
            return;
        }
        c.a aVar = this.f15804d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f15805e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f15802b.clear();
            if (ListUtils.getCount(this.f15803c) > 0) {
                for (SimpleForum simpleForum : this.f15803c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f15802b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f15804d;
            if (aVar != null) {
                aVar.a(this.f15802b, true, 2, this.f15806f);
            }
        }
    }
}
