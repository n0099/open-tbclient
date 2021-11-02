package b.a.r0.x0.l2;

import b.a.e.e.p.k;
import b.a.e.l.e.n;
import b.a.q0.k0.b.h;
import b.a.q0.s.q.d2;
import b.a.r0.x0.l2.g.e;
import b.a.r0.x0.l2.g.f;
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
/* loaded from: classes5.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ItemInfo f25947e;

    /* renamed from: f  reason: collision with root package name */
    public List<AlbumElement> f25948f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f25949g;

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
        this.f25949g = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.f25947e = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.f25948f = dataRes.album_list;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            b.a.r0.x0.l2.g.c cVar = new b.a.r0.x0.l2.g.c();
            cVar.k(dataRes.item_game_code);
            this.f25949g.add(cVar);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                b.a.r0.x0.l2.g.d dVar = new b.a.r0.x0.l2.g.d();
                dVar.i(dataRes.item_game_info.hot_videos);
                this.f25949g.add(dVar);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !k.isEmpty(recentUpdate.log)) {
                e eVar = new e();
                eVar.i(dataRes.item_game_info.recent_update);
                this.f25949g.add(eVar);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            b.a.r0.x0.l2.g.a aVar = new b.a.r0.x0.l2.g.a();
            aVar.setSupportType(BaseCardInfo.SupportType.TOP);
            this.f25949g.add(aVar);
            int i2 = 1;
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    d2 d2Var = new d2();
                    d2Var.Y2(threadInfo);
                    d2Var.c3();
                    d2Var.l4(i2);
                    i2++;
                    d2Var.G1();
                    this.f25949g.add(d2Var);
                    b.a.r0.x0.l2.g.a aVar2 = new b.a.r0.x0.l2.g.a();
                    aVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.f25949g.add(aVar2);
                }
            }
            b.a.r0.x0.l2.g.a aVar3 = new b.a.r0.x0.l2.g.a();
            aVar3.k(this.f25947e.id.intValue());
            aVar3.o(i2);
            aVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.f25949g.add(aVar3);
        }
        b.a.r0.x0.l2.g.b bVar = new b.a.r0.x0.l2.g.b();
        bVar.k(dataRes.item_info);
        if (bVar.i()) {
            this.f25949g.add(bVar);
        }
        f fVar = new f();
        fVar.i(dataRes.recommend_item);
        this.f25949g.add(fVar);
    }

    @Override // b.a.q0.k0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // b.a.q0.k0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
