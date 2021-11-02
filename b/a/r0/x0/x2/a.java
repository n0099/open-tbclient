package b.a.r0.x0.x2;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b.a.r0.g.e.b bVar, ForumData forumData, List<b.a.e.l.e.n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{bVar, forumData, list, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        b.a.r0.g.f.b bVar2 = new b.a.r0.g.f.b(bVar, 5);
        bVar2.E(list);
        if (forumData != null) {
            bVar2.v(forumData.getId());
            bVar2.u(forumData.getFirst_class());
            bVar2.C(forumData.getSecond_class());
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            bVar2.z(String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
        }
        bVar2.y(z);
        bVar2.A(i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
    }

    public static void b(b.a.r0.g.e.b bVar, FrsViewData frsViewData, List<b.a.e.l.e.n> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, bVar, frsViewData, list, i2) == null) || frsViewData == null) {
            return;
        }
        a(bVar, frsViewData.getForum(), list, false, i2);
    }

    public static void c(b.a.r0.l3.j0.f fVar, List<b.a.e.l.e.n> list, List<b.a.e.l.e.n> list2) {
        int[] iArr;
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, fVar, list, list2) == null) || fVar == null || ListUtils.getCount(list) <= 0 || ListUtils.getCount(list2) <= 0) {
            return;
        }
        for (int i2 : b.a.r0.l3.j0.f.f20606f) {
            b.a.e.l.e.n nVar = (b.a.e.l.e.n) ListUtils.getItem(list, i2);
            if (nVar != null && (indexOf = list2.indexOf(nVar)) >= 0) {
                fVar.a(i2, indexOf);
            }
        }
    }
}
