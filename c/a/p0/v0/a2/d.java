package c.a.p0.v0.a2;

import c.a.e.k.e.n;
import c.a.o0.i0.b.h;
import c.a.o0.s.q.c2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.AlbumElement;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemInfo f25494e;

    /* renamed from: f  reason: collision with root package name */
    public List<AlbumElement> f25495f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f25496g;

    public d() {
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
        this.f25496g = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.f25494e = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.f25495f = dataRes.album_list;
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            c.a.p0.v0.a2.g.a aVar = new c.a.p0.v0.a2.g.a();
            aVar.setSupportType(BaseCardInfo.SupportType.TOP);
            this.f25496g.add(aVar);
            int i2 = 1;
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    c2 c2Var = new c2();
                    c2Var.S2(threadInfo);
                    c2Var.W2();
                    c2Var.b4(i2);
                    i2++;
                    c2Var.E1();
                    this.f25496g.add(c2Var);
                    c.a.p0.v0.a2.g.a aVar2 = new c.a.p0.v0.a2.g.a();
                    aVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.f25496g.add(aVar2);
                }
            }
            c.a.p0.v0.a2.g.a aVar3 = new c.a.p0.v0.a2.g.a();
            aVar3.k(this.f25494e.id.intValue());
            aVar3.o(i2);
            aVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.f25496g.add(aVar3);
        }
        c.a.p0.v0.a2.g.b bVar = new c.a.p0.v0.a2.g.b();
        bVar.k(dataRes.item_info);
        if (bVar.i()) {
            this.f25496g.add(bVar);
        }
        c.a.p0.v0.a2.g.c cVar = new c.a.p0.v0.a2.g.c();
        cVar.i(dataRes.recommend_item);
        this.f25496g.add(cVar);
    }

    @Override // c.a.o0.i0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.o0.i0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
