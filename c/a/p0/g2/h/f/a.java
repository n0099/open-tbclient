package c.a.p0.g2.h.f;

import c.a.d.o.e.n;
import c.a.p0.g2.h.e.b;
import c.a.p0.g2.h.e.c;
import c.a.p0.g2.h.e.d;
import c.a.p0.g2.h.e.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Item;
import tbclient.RecommendForumInfo;
import tbclient.SearchSug.DataRes;
import tbclient.SugLiveInfo;
import tbclient.SugRankingInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                b bVar = new b();
                bVar.j(recommendForumInfo);
                arrayList.add(bVar);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                c cVar = new c();
                cVar.j(item);
                arrayList.add(cVar);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                d dVar = new d();
                dVar.p(str);
                dVar.n(sugLiveInfo);
                arrayList.add(dVar);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                e eVar = new e();
                eVar.i(str);
                eVar.g(sugRankingInfo);
                arrayList.add(eVar);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                c.a.p0.g2.h.e.a aVar = new c.a.p0.g2.h.e.a();
                aVar.e(str);
                aVar.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, aVar);
                } else {
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
