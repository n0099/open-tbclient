package c.a.u0.e1.n2;

import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.t0.l0.b.h;
import c.a.t0.s.r.e2;
import c.a.u0.e1.n2.g.e;
import c.a.u0.e1.n2.g.f;
import c.a.u0.e1.n2.g.g;
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
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemInfo f16828e;

    /* renamed from: f  reason: collision with root package name */
    public List<AlbumElement> f16829f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f16830g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f16831h;

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
        this.f16830g = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.f16828e = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.f16829f = dataRes.album_list;
        int i2 = 1;
        this.f16831h = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            c.a.u0.e1.n2.g.d dVar = new c.a.u0.e1.n2.g.d();
            dVar.k(dataRes.item_game_code);
            this.f16830g.add(dVar);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                e eVar = new e();
                eVar.i(dataRes.item_game_info.hot_videos);
                this.f16830g.add(eVar);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !m.isEmpty(recentUpdate.log)) {
                f fVar = new f();
                fVar.i(dataRes.item_game_info.recent_update);
                this.f16830g.add(fVar);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            c.a.u0.e1.n2.g.b bVar = new c.a.u0.e1.n2.g.b();
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
            this.f16830g.add(bVar);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    e2 e2Var = new e2();
                    e2Var.d3(threadInfo);
                    e2Var.h3();
                    e2Var.q4(i2);
                    i2++;
                    e2Var.K1();
                    this.f16830g.add(e2Var);
                    c.a.u0.e1.n2.g.b bVar2 = new c.a.u0.e1.n2.g.b();
                    bVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.f16830g.add(bVar2);
                }
            }
            c.a.u0.e1.n2.g.b bVar3 = new c.a.u0.e1.n2.g.b();
            bVar3.k(this.f16828e.id.intValue());
            bVar3.o(i2);
            bVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.f16830g.add(bVar3);
        }
        c.a.u0.e1.n2.g.c cVar = new c.a.u0.e1.n2.g.c();
        cVar.k(dataRes.item_info);
        if (cVar.i()) {
            this.f16830g.add(cVar);
        }
        g gVar = new g();
        gVar.i(dataRes.recommend_item);
        this.f16830g.add(gVar);
    }

    @Override // c.a.t0.l0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.t0.l0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
