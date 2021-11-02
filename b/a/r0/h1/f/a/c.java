package b.a.r0.h1.f.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.k;
import b.a.e.l.e.n;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.HotThreadList.DataRes;
import tbclient.HotThreadList.HotThreadListResIdl;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<d2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (d2 d2Var : list) {
                int[] g0 = d2Var.g0();
                if (d2Var.getType() == d2.a3) {
                    d2Var.position = i2;
                    c2 c2Var = new c2();
                    c2Var.w = d2Var;
                    c2Var.position = i2;
                    c2Var.v = true;
                    c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(c2Var);
                    c2 c2Var2 = new c2();
                    c2Var2.w = d2Var;
                    c2Var2.position = i2;
                    if (d2Var.N1()) {
                        c2Var2.j = true;
                    } else if (d2Var.d3() == 1) {
                        c2Var2.f13257h = true;
                        c2Var2.x = g0[0];
                        c2Var2.y = g0[1];
                    } else if (d2Var.d3() >= 2) {
                        c2Var2.f13258i = true;
                    } else {
                        c2Var2.f13255f = true;
                    }
                    c2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(c2Var2);
                    c2 c2Var3 = new c2();
                    c2Var3.k = true;
                    c2Var3.w = d2Var;
                    c2Var3.position = i2;
                    c2Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(c2Var3);
                } else if (d2Var.getType() == d2.x3) {
                    d2Var.position = i2;
                    c2 c2Var4 = new c2();
                    c2Var4.w = d2Var;
                    c2Var4.position = i2;
                    c2Var4.v = true;
                    c2Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(c2Var4);
                    c2 c2Var5 = new c2();
                    c2Var5.w = d2Var;
                    c2Var5.position = i2;
                    c2Var5.m = true;
                    c2Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(c2Var5);
                    c2 c2Var6 = new c2();
                    c2Var6.k = true;
                    c2Var6.w = d2Var;
                    c2Var6.position = i2;
                    c2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(c2Var6);
                } else {
                    d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i2++;
                d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                d2 d2Var = new d2();
                d2Var.g2 = true;
                d2Var.Y2(threadInfo);
                e(d2Var);
                arrayList.add(d2Var);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
                return null;
            }
            return b(hotThreadListResIdl.data.thread_info);
        }
        return (List) invokeL.objValue;
    }

    public static b.a.r0.h1.f.a.e.b d(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.hot_topic_hot_all);
            int i2 = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !k.isEmpty(frsTabInfo.tab_code) && !k.isEmpty(frsTabInfo.tab_name)) {
                        i2++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i2;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new b.a.r0.h1.f.a.e.b(frsTabInfoData);
        }
        return (b.a.r0.h1.f.a.e.b) invokeL.objValue;
    }

    public static void e(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, d2Var) == null) {
            String z0 = d2Var.z0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(d2Var.v0() * 1000);
            if (!TextUtils.isEmpty(z0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                z0 = z0 + "   " + formatTimeForHomeC;
            }
            d2Var.y4(z0);
        }
    }
}
