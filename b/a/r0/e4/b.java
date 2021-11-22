package b.a.r0.e4;

import b.a.r0.e4.q.d.a;
import b.a.r0.f0.c;
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
/* loaded from: classes4.dex */
public class b implements b.a.r0.f0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.r0.e4.q.d.a f17386a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f17387b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f17388c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f17389d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17390e;

    /* renamed from: f  reason: collision with root package name */
    public int f17391f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f17392g;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17393a;

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
            this.f17393a = bVar;
        }

        @Override // b.a.r0.e4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f17393a.f17388c = list;
                this.f17393a.f17391f = i2;
                this.f17393a.h();
            }
        }

        @Override // b.a.r0.e4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f17393a.g();
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
        this.f17387b = new ArrayList<>();
        this.f17392g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        b.a.r0.e4.q.d.a aVar = new b.a.r0.e4.q.d.a(gen);
        this.f17386a = aVar;
        aVar.i(this.f17392g);
        this.f17386a.j(gen);
    }

    @Override // b.a.r0.f0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f17389d = aVar;
        }
    }

    @Override // b.a.r0.f0.c
    public void b() {
        b.a.r0.e4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17389d == null || (aVar = this.f17386a) == null) {
            return;
        }
        this.f17390e = false;
        aVar.l(null);
        this.f17386a.k(null);
        this.f17386a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f17390e) {
            return;
        }
        c.a aVar = this.f17389d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f17390e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17387b.clear();
            if (ListUtils.getCount(this.f17388c) > 0) {
                for (SimpleForum simpleForum : this.f17388c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f17387b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f17389d;
            if (aVar != null) {
                aVar.a(this.f17387b, true, 2, this.f17391f);
            }
        }
    }
}
