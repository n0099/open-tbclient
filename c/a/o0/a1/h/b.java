package c.a.o0.a1.h;

import android.util.Log;
import c.a.d.o.e.n;
import c.a.o0.r.r.a2;
import c.a.p0.h0.e0.j;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<? extends n> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (n nVar : list) {
                if (nVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nVar;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a2 a2Var = new a2();
                        a2Var.s = threadData;
                        a2Var.position = i;
                        a2Var.a = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.s = threadData;
                        a2Var2.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            a2Var2.f10786f = true;
                        } else if (threadData.picCount() == 1) {
                            a2Var2.f10784d = true;
                            a2Var2.t = imageWidthAndHeight[0];
                            a2Var2.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            a2Var2.f10785e = true;
                        } else {
                            a2Var2.f10782b = true;
                        }
                        a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList.add(a2Var2);
                        if (threadData.getItem() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.n = true;
                            a2Var3.s = threadData;
                            a2Var3.position = i;
                            a2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(a2Var3);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList())) {
                            a2 a2Var4 = new a2();
                            a2Var4.s = threadData;
                            a2Var4.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) == 1) {
                                a2Var4.p = true;
                            } else {
                                a2Var4.q = true;
                            }
                            a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(a2Var4);
                        }
                        a2 a2Var5 = new a2();
                        a2Var5.m = true;
                        a2Var5.s = threadData;
                        a2Var5.position = i;
                        a2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(a2Var5);
                        a2 a2Var6 = new a2();
                        a2Var6.f10787g = true;
                        a2Var6.s = threadData;
                        a2Var6.position = i;
                        a2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(a2Var6);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a2 a2Var7 = new a2();
                        a2Var7.s = threadData;
                        a2Var7.position = i;
                        a2Var7.a = true;
                        a2Var7.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList.add(a2Var7);
                        a2 a2Var8 = new a2();
                        a2Var8.s = threadData;
                        a2Var8.position = i;
                        a2Var8.i = true;
                        a2Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(a2Var8);
                        if (threadData.getItem() != null) {
                            a2 a2Var9 = new a2();
                            a2Var9.n = true;
                            a2Var9.s = threadData;
                            a2Var9.position = i;
                            a2Var9.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList.add(a2Var9);
                        }
                        a2 a2Var10 = new a2();
                        a2Var10.m = true;
                        a2Var10.s = threadData;
                        a2Var10.position = i;
                        a2Var10.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList.add(a2Var10);
                        a2 a2Var11 = new a2();
                        a2Var11.f10787g = true;
                        a2Var11.s = threadData;
                        a2Var11.position = i;
                        a2Var11.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList.add(a2Var11);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        a2 a2Var12 = new a2();
                        a2Var12.s = threadData;
                        a2Var12.position = i;
                        arrayList.add(a2Var12);
                    } else if (j.W(threadData)) {
                        j jVar = new j(threadData);
                        jVar.f15321g = threadData.getTid();
                        arrayList.add(jVar);
                    } else {
                        a2 a2Var13 = new a2();
                        a2Var13.s = threadData;
                        a2Var13.position = i;
                        arrayList.add(a2Var13);
                    }
                } else if (nVar instanceof BaseCardInfo) {
                    ((BaseCardInfo) nVar).position = i;
                    arrayList.add(nVar);
                } else {
                    arrayList.add(nVar);
                }
                i++;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void b(List<n> list, c.a.o0.r.r.a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, list, aVar) == null) || aVar == null || list == null || (i = aVar.floorPosition) <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    a.b("insertFloorPosition-> floorPosition = " + i);
                    ListUtils.add(list, i3, aVar);
                    return;
                }
                i2++;
            }
        }
    }

    public static List<ThreadData> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(threadInfo);
                threadData.insertItemToTitleOrAbstractText();
                arrayList.add(threadData);
            }
            Log.i("Template", "parserThreadList-> size = " + arrayList.size());
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
