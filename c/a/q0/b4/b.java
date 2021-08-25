package c.a.q0.b4;

import c.a.q0.b4.q.d.a;
import c.a.q0.e0.c;
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
public class b implements c.a.q0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.q0.b4.q.d.a f16087a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f16088b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f16089c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f16090d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16091e;

    /* renamed from: f  reason: collision with root package name */
    public int f16092f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f16093g;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16094a;

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
            this.f16094a = bVar;
        }

        @Override // c.a.q0.b4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f16094a.f16089c = list;
                this.f16094a.f16092f = i2;
                this.f16094a.h();
            }
        }

        @Override // c.a.q0.b4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16094a.g();
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
        this.f16088b = new ArrayList<>();
        this.f16093g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        c.a.q0.b4.q.d.a aVar = new c.a.q0.b4.q.d.a(gen);
        this.f16087a = aVar;
        aVar.i(this.f16093g);
        this.f16087a.j(gen);
    }

    @Override // c.a.q0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f16090d = aVar;
        }
    }

    @Override // c.a.q0.e0.c
    public void b() {
        c.a.q0.b4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f16090d == null || (aVar = this.f16087a) == null) {
            return;
        }
        this.f16091e = false;
        aVar.l(null);
        this.f16087a.k(null);
        this.f16087a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f16091e) {
            return;
        }
        c.a aVar = this.f16090d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f16091e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16088b.clear();
            if (ListUtils.getCount(this.f16089c) > 0) {
                for (SimpleForum simpleForum : this.f16089c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f16088b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f16090d;
            if (aVar != null) {
                aVar.a(this.f16088b, true, 2, this.f16092f);
            }
        }
    }
}
