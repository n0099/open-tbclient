package c.a.p0.f1.d2;

import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.o0.k0.b.h;
import c.a.p0.f1.d2.g.e;
import c.a.p0.f1.d2.g.f;
import c.a.p0.f1.d2.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class d implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;

    /* renamed from: b  reason: collision with root package name */
    public List<AlbumElement> f13908b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<n> f13909c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13910d;

    public d() {
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
        this.f13909c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.f13908b = dataRes.album_list;
        int i = 1;
        this.f13910d = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            c.a.p0.f1.d2.g.d dVar = new c.a.p0.f1.d2.g.d();
            dVar.i(dataRes.item_game_code);
            this.f13909c.add(dVar);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                e eVar = new e();
                eVar.g(dataRes.item_game_info.hot_videos);
                this.f13909c.add(eVar);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !m.isEmpty(recentUpdate.log)) {
                f fVar = new f();
                fVar.g(dataRes.item_game_info.recent_update);
                this.f13909c.add(fVar);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            c.a.p0.f1.d2.g.b bVar = new c.a.p0.f1.d2.g.b();
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
            this.f13909c.add(bVar);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.f13909c.add(threadData);
                    c.a.p0.f1.d2.g.b bVar2 = new c.a.p0.f1.d2.g.b();
                    bVar2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.f13909c.add(bVar2);
                }
            }
            c.a.p0.f1.d2.g.b bVar3 = new c.a.p0.f1.d2.g.b();
            bVar3.g(this.a.id.intValue());
            bVar3.setPositionInFrsItemTab(i);
            bVar3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.f13909c.add(bVar3);
        }
        c.a.p0.f1.d2.g.c cVar = new c.a.p0.f1.d2.g.c();
        cVar.i(dataRes.item_info);
        if (cVar.g()) {
            this.f13909c.add(cVar);
        }
        g gVar = new g();
        gVar.g(dataRes.recommend_item);
        this.f13909c.add(gVar);
    }

    @Override // c.a.o0.k0.b.h
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // c.a.o0.k0.b.h
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
