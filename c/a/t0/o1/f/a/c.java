package c.a.t0.o1.f.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.n.e.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.e2;
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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<e2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (e2 e2Var : list) {
                int[] h0 = e2Var.h0();
                if (e2Var.getType() == e2.i3) {
                    e2Var.position = i2;
                    d2 d2Var = new d2();
                    d2Var.w = e2Var;
                    d2Var.position = i2;
                    d2Var.v = true;
                    d2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(d2Var);
                    d2 d2Var2 = new d2();
                    d2Var2.w = e2Var;
                    d2Var2.position = i2;
                    if (e2Var.Q1()) {
                        d2Var2.f13348j = true;
                    } else if (e2Var.h3() == 1) {
                        d2Var2.f13346h = true;
                        d2Var2.x = h0[0];
                        d2Var2.y = h0[1];
                    } else if (e2Var.h3() >= 2) {
                        d2Var2.f13347i = true;
                    } else {
                        d2Var2.f13344f = true;
                    }
                    d2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(d2Var2);
                    d2 d2Var3 = new d2();
                    d2Var3.k = true;
                    d2Var3.w = e2Var;
                    d2Var3.position = i2;
                    d2Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(d2Var3);
                } else if (e2Var.getType() == e2.G3) {
                    e2Var.position = i2;
                    d2 d2Var4 = new d2();
                    d2Var4.w = e2Var;
                    d2Var4.position = i2;
                    d2Var4.v = true;
                    d2Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(d2Var4);
                    d2 d2Var5 = new d2();
                    d2Var5.w = e2Var;
                    d2Var5.position = i2;
                    d2Var5.m = true;
                    d2Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(d2Var5);
                    d2 d2Var6 = new d2();
                    d2Var6.k = true;
                    d2Var6.w = e2Var;
                    d2Var6.position = i2;
                    d2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(d2Var6);
                } else {
                    e2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i2++;
                e2Var.setSupportType(BaseCardInfo.SupportType.TOP);
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
                e2 e2Var = new e2();
                e2Var.g2 = true;
                e2Var.c3(threadInfo);
                e(e2Var);
                arrayList.add(e2Var);
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

    public static c.a.t0.o1.f.a.e.b d(List<FrsTabInfo> list) {
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
                    if (frsTabInfo != null && !m.isEmpty(frsTabInfo.tab_code) && !m.isEmpty(frsTabInfo.tab_name)) {
                        i2++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i2;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new c.a.t0.o1.f.a.e.b(frsTabInfoData);
        }
        return (c.a.t0.o1.f.a.e.b) invokeL.objValue;
    }

    public static void e(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, e2Var) == null) {
            String A0 = e2Var.A0();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(e2Var.w0() * 1000);
            if (!TextUtils.isEmpty(A0) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                A0 = A0 + "   " + formatTimeForHomeC;
            }
            e2Var.C4(A0);
        }
    }
}
