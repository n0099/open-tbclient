package c.a.t0.o4;

import c.a.t0.k0.c;
import c.a.t0.o4.a0.d.a;
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
/* loaded from: classes8.dex */
public class l implements c.a.t0.k0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.o4.a0.d.a a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f21737b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f21738c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f21739d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21740e;

    /* renamed from: f  reason: collision with root package name */
    public int f21741f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f21742g;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // c.a.t0.o4.a0.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.a.f21738c = list;
                this.a.f21741f = i2;
                this.a.h();
            }
        }

        @Override // c.a.t0.o4.a0.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    public l() {
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
        this.f21737b = new ArrayList<>();
        this.f21742g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        c.a.t0.o4.a0.d.a aVar = new c.a.t0.o4.a0.d.a(gen);
        this.a = aVar;
        aVar.i(this.f21742g);
        this.a.j(gen);
    }

    @Override // c.a.t0.k0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f21739d = aVar;
        }
    }

    @Override // c.a.t0.k0.c
    public void b() {
        c.a.t0.o4.a0.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21739d == null || (aVar = this.a) == null) {
            return;
        }
        this.f21740e = false;
        aVar.l(null);
        this.a.k(null);
        this.a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f21740e) {
            return;
        }
        c.a aVar = this.f21739d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f21740e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21737b.clear();
            if (ListUtils.getCount(this.f21738c) > 0) {
                for (SimpleForum simpleForum : this.f21738c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f21737b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f21739d;
            if (aVar != null) {
                aVar.a(this.f21737b, true, 2, this.f21741f);
            }
        }
    }
}
