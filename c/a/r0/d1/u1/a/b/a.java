package c.a.r0.d1.u1.a.b;

import android.text.TextUtils;
import c.a.d.o.e.n;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.p0;
import c.a.r0.d1.u1.a.a.b;
import c.a.r0.d1.u1.a.d.e;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumSubTab;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<e> a(List<GameForumSubTab> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (GameForumSubTab gameForumSubTab : list) {
                e eVar = new e();
                if (gameForumSubTab != null) {
                    eVar.a = gameForumSubTab.id.intValue();
                    eVar.f16521b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    eVar.f16522c = labelDataList;
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                b bVar = new b();
                e2 e2Var = new e2();
                bVar.g(e2Var);
                e2Var.d3(list.get(i2));
                e2Var.h3();
                if (!TextUtils.isEmpty(e2Var.A0())) {
                    p0 p0Var = new p0();
                    p0Var.k(e2Var.A0());
                    linkedList.add(p0Var);
                } else {
                    linkedList.add(bVar);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }
}
