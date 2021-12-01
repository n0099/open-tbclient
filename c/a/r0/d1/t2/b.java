package c.a.r0.d1.t2;

import c.a.d.m.e.n;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ArrayList<n> arrayList, String str, CardHListViewData cardHListViewData, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65536, null, arrayList, str, cardHListViewData, i2)) == null) {
            if (cardHListViewData != null && !ListUtils.isEmpty(arrayList) && !StringUtils.isNull(str) && i2 >= 0) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    n nVar = arrayList.get(i3);
                    if ((nVar instanceof CardHListViewData) && str.equals(((CardHListViewData) nVar).threadId)) {
                        return false;
                    }
                }
                int i4 = i2 + 1;
                if (i4 > 0) {
                    ListUtils.add(arrayList, i4, cardHListViewData);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLI.booleanValue;
    }

    public static boolean b(FrsRequestData frsRequestData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, frsRequestData)) == null) ? frsRequestData != null && frsRequestData.A() == 1 : invokeL.booleanValue;
    }
}
