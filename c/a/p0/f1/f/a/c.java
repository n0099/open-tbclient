package c.a.p0.f1.f.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.k.e.n;
import c.a.o0.b.d;
import c.a.o0.s.q.b2;
import c.a.o0.s.q.c2;
import c.a.p0.f1.f.a.e.e;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<c2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (c2 c2Var : list) {
                int[] g0 = c2Var.g0();
                if (c2Var.getType() == c2.W2) {
                    c2Var.position = i2;
                    b2 b2Var = new b2();
                    b2Var.w = c2Var;
                    b2Var.position = i2;
                    b2Var.v = true;
                    b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(b2Var);
                    b2 b2Var2 = new b2();
                    b2Var2.w = c2Var;
                    b2Var2.position = i2;
                    if (c2Var.K1()) {
                        b2Var2.f13850j = true;
                    } else if (c2Var.X2() == 1) {
                        b2Var2.f13848h = true;
                        b2Var2.x = g0[0];
                        b2Var2.y = g0[1];
                    } else if (c2Var.X2() >= 2) {
                        b2Var2.f13849i = true;
                    } else {
                        b2Var2.f13846f = true;
                    }
                    b2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(b2Var2);
                    b2 b2Var3 = new b2();
                    b2Var3.k = true;
                    b2Var3.w = c2Var;
                    b2Var3.position = i2;
                    b2Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(b2Var3);
                } else if (c2Var.getType() == c2.t3) {
                    c2Var.position = i2;
                    b2 b2Var4 = new b2();
                    b2Var4.w = c2Var;
                    b2Var4.position = i2;
                    b2Var4.v = true;
                    b2Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(b2Var4);
                    b2 b2Var5 = new b2();
                    b2Var5.w = c2Var;
                    b2Var5.position = i2;
                    b2Var5.m = true;
                    b2Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(b2Var5);
                    b2 b2Var6 = new b2();
                    b2Var6.k = true;
                    b2Var6.w = c2Var;
                    b2Var6.position = i2;
                    b2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(b2Var6);
                } else {
                    c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i2++;
                c2Var.setSupportType(BaseCardInfo.SupportType.TOP);
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
                c2 c2Var = new c2();
                c2Var.d2 = true;
                c2Var.S2(threadInfo);
                f(c2Var);
                arrayList.add(c2Var);
            }
            return a(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static List<n> c(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                ThreadInfo threadInfo = list.get(i3);
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.title)) {
                    arrayList.add(new e(threadInfo, i2));
                    i2++;
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> d(HotThreadListResIdl hotThreadListResIdl) {
        InterceptResult invokeL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hotThreadListResIdl)) == null) {
            if (hotThreadListResIdl == null || (dataRes = hotThreadListResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_info)) {
                return null;
            }
            boolean G = d.G();
            List<ThreadInfo> list = hotThreadListResIdl.data.thread_info;
            if (G) {
                return b(list);
            }
            return c(list);
        }
        return (List) invokeL.objValue;
    }

    public static c.a.p0.f1.f.a.e.b e(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
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
            return new c.a.p0.f1.f.a.e.b(frsTabInfoData);
        }
        return (c.a.p0.f1.f.a.e.b) invokeL.objValue;
    }

    public static void f(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, c2Var) == null) {
            String x0 = c2Var.x0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(c2Var.t0() * 1000);
            if (!TextUtils.isEmpty(x0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                x0 = x0 + "   " + formatTimeForHomeC;
            }
            c2Var.o4(x0);
        }
    }
}
