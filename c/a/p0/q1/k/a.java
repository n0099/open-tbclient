package c.a.p0.q1.k;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import c.a.o0.r.r.a2;
import c.a.p0.h0.e0.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i, ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65536, null, threadData, i, arrayList) == null) {
            if (threadData.getTabShowMode() == 1) {
                b(threadData, i, arrayList, true);
            } else if (threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().f10991b)) {
                b(threadData, i, arrayList, false);
            } else {
                b(threadData, i, arrayList, true);
            }
        }
    }

    public static void b(ThreadData threadData, int i, ArrayList<n> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{threadData, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) {
            a2 a2Var = new a2();
            a2Var.s = threadData;
            a2Var.position = i;
            if (z) {
                a2Var.a = true;
            } else {
                a2Var.r = true;
            }
            a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            arrayList.add(a2Var);
        }
    }

    public static ArrayList<n> c(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    threadData.isFromFeedTab = true;
                    int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                    if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                        a(threadData, i, arrayList2);
                        a2 a2Var = new a2();
                        a2Var.s = threadData;
                        a2Var.position = i;
                        if (threadData.isBJHNormalThreadType()) {
                            a2Var.f10786f = true;
                        } else if (threadData.picCount() == 1) {
                            a2Var.f10784d = true;
                            a2Var.t = imageWidthAndHeight[0];
                            a2Var.u = imageWidthAndHeight[1];
                        } else if (threadData.picCount() >= 2) {
                            a2Var.f10785e = true;
                        } else {
                            a2Var.f10782b = true;
                        }
                        a2Var.s.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        a2Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var);
                        if (threadData.getItem() != null) {
                            a2 a2Var2 = new a2();
                            a2Var2.n = true;
                            a2Var2.s = threadData;
                            a2Var2.position = i;
                            a2Var2.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var2);
                        }
                        if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                            a2 a2Var3 = new a2();
                            a2Var3.s = threadData;
                            a2Var3.position = i;
                            if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                                a2Var3.p = true;
                            } else if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) > 1) {
                                a2Var3.q = true;
                            }
                            a2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var3);
                        }
                        a2 a2Var4 = new a2();
                        a2Var4.m = true;
                        a2Var4.s = threadData;
                        a2Var4.position = i;
                        a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(a2Var4);
                        a2 a2Var5 = new a2();
                        a2Var5.f10787g = true;
                        a2Var5.s = threadData;
                        a2Var5.position = i;
                        a2Var5.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var5);
                    } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                        a(threadData, i, arrayList2);
                        a2 a2Var6 = new a2();
                        a2Var6.s = threadData;
                        a2Var6.position = i;
                        a2Var6.i = true;
                        threadData.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        a2Var6.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var6);
                        if (threadData.getItem() != null) {
                            a2 a2Var7 = new a2();
                            a2Var7.n = true;
                            a2Var7.s = threadData;
                            a2Var7.position = i;
                            a2Var7.setSupportType(BaseCardInfo.SupportType.CONTENT);
                            arrayList2.add(a2Var7);
                        }
                        a2 a2Var8 = new a2();
                        a2Var8.m = true;
                        a2Var8.s = threadData;
                        a2Var8.position = i;
                        a2Var8.setSupportType(BaseCardInfo.SupportType.EXTEND);
                        arrayList2.add(a2Var8);
                        a2 a2Var9 = new a2();
                        a2Var9.f10787g = true;
                        a2Var9.s = threadData;
                        a2Var9.position = i;
                        a2Var9.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var9);
                    } else if (threadData.getType() == ThreadData.TYPE_ARTICLE && threadData.isBJHArticleThreadType()) {
                        threadData.position = i;
                        threadData.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(threadData);
                    } else if (j.W(threadData)) {
                        j jVar = new j(threadData);
                        jVar.f15321g = threadData.getTid();
                        jVar.feedBackReasonMap = threadData.feedBackReasonMap;
                        jVar.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(jVar);
                    } else {
                        a2 a2Var10 = new a2();
                        a2Var10.s = threadData;
                        a2Var10.position = i;
                        a2Var10.setSupportType(BaseCardInfo.SupportType.FULL);
                        arrayList2.add(a2Var10);
                    }
                } else if (next instanceof BaseCardInfo) {
                    ((BaseCardInfo) next).position = i;
                    arrayList2.add(next);
                } else {
                    arrayList2.add(next);
                }
                i++;
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static List<Integer> d(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                n C = bdTypeRecyclerView.C(i3);
                ThreadData threadData = null;
                if (C instanceof a2) {
                    threadData = ((a2) C).getThreadData();
                } else if (C instanceof ThreadData) {
                    threadData = (ThreadData) C;
                } else if (C instanceof j) {
                    threadData = ((j) C).a;
                }
                if (threadData != null && threadData.getTid().equals(str)) {
                    if (!z) {
                        i = i3;
                    }
                    z = true;
                    i2 = i3;
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void e(boolean z, ArrayList<n> arrayList, c.a.o0.r.r.a aVar) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), arrayList, aVar}) == null) || aVar == null || arrayList == null || (i = aVar.floorPosition) < 0) {
            return;
        }
        if (i != 0 || z) {
            int size = arrayList.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3) instanceof ThreadData) {
                    if (i == i2) {
                        ListUtils.add(arrayList, i3, aVar);
                        return;
                    }
                    i2++;
                }
            }
        }
    }
}
