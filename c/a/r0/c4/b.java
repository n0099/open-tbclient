package c.a.r0.c4;

import c.a.r0.c4.q.d.a;
import c.a.r0.e0.c;
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
public class b implements c.a.r0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.c4.q.d.a f16609a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f16610b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f16611c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f16612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16613e;

    /* renamed from: f  reason: collision with root package name */
    public int f16614f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f16615g;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16616a;

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
            this.f16616a = bVar;
        }

        @Override // c.a.r0.c4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f16616a.f16611c = list;
                this.f16616a.f16614f = i2;
                this.f16616a.h();
            }
        }

        @Override // c.a.r0.c4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16616a.g();
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
        this.f16610b = new ArrayList<>();
        this.f16615g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        c.a.r0.c4.q.d.a aVar = new c.a.r0.c4.q.d.a(gen);
        this.f16609a = aVar;
        aVar.i(this.f16615g);
        this.f16609a.j(gen);
    }

    @Override // c.a.r0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f16612d = aVar;
        }
    }

    @Override // c.a.r0.e0.c
    public void b() {
        c.a.r0.c4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16612d == null || (aVar = this.f16609a) == null) {
            return;
        }
        this.f16613e = false;
        aVar.l(null);
        this.f16609a.k(null);
        this.f16609a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f16613e) {
            return;
        }
        c.a aVar = this.f16612d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f16613e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16610b.clear();
            if (ListUtils.getCount(this.f16611c) > 0) {
                for (SimpleForum simpleForum : this.f16611c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f16610b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f16612d;
            if (aVar != null) {
                aVar.a(this.f16610b, true, 2, this.f16614f);
            }
        }
    }
}
