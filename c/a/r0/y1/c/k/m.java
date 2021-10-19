package c.a.r0.y1.c.k;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes4.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f28734a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.y1.c.j.i f28735b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedHashMap<String, c> f28736c;

    public m(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (dataRes == null) {
            return;
        }
        String str = dataRes.grade_intro_title;
        String str2 = dataRes.grade_intro_link;
        new l(dataRes);
        new n(dataRes.special_list);
        new e(dataRes.cooperate_list);
        new i(dataRes.theme_list);
        new a(dataRes.banner_list);
        new q(dataRes.task_list);
        new p(dataRes.rank, dataRes.user);
        new g(dataRes.daily_list);
        c.a.r0.y1.c.j.i iVar = new c.a.r0.y1.c.j.i();
        this.f28735b = iVar;
        iVar.l(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.f28736c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    c cVar = new c(vipBasicList);
                    if (cVar.f28679g != 3 || cVar.c().size() >= 2) {
                        this.f28736c.put(cVar.f28681i, cVar);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.f28734a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.f28734a.add(str3);
            }
        }
    }
}
