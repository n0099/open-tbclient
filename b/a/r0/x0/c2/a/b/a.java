package b.a.r0.x0.c2.a.b;

import android.text.TextUtils;
import b.a.e.l.e.n;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.p0;
import b.a.r0.x0.c2.a.a.b;
import b.a.r0.x0.c2.a.d.e;
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
/* loaded from: classes5.dex */
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
                    eVar.f25655a = gameForumSubTab.id.intValue();
                    eVar.f25656b = gameForumSubTab.sub_tab_name;
                    LabelDataList labelDataList = new LabelDataList();
                    labelDataList.parseProtu(gameForumSubTab.sub_label_list);
                    eVar.f25657c = labelDataList;
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
                d2 d2Var = new d2();
                bVar.g(d2Var);
                d2Var.Y2(list.get(i2));
                d2Var.c3();
                if (!TextUtils.isEmpty(d2Var.y0())) {
                    p0 p0Var = new p0();
                    p0Var.k(d2Var.y0());
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
