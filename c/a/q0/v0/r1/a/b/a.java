package c.a.q0.v0.r1.a.b;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.p0;
import c.a.q0.v0.r1.a.a.b;
import c.a.q0.v0.r1.a.d.e;
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
/* loaded from: classes4.dex */
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
                    eVar.f27129a = gameForumSubTab.id.intValue();
                    eVar.f27130b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    eVar.f27131c = labelDataList;
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
                c2 c2Var = new c2();
                bVar.g(c2Var);
                c2Var.S2(list.get(i2));
                c2Var.W2();
                if (!TextUtils.isEmpty(c2Var.w0())) {
                    p0 p0Var = new p0();
                    p0Var.k(c2Var.w0());
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
