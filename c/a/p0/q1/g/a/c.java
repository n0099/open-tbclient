package c.a.p0.q1.g.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.o.e.n;
import c.a.o0.r.r.a2;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<n> a(List<ThreadData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (ThreadData threadData : list) {
                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                if (threadData.getType() == ThreadData.TYPE_NORMAL) {
                    threadData.position = i;
                    a2 a2Var = new a2();
                    a2Var.s = threadData;
                    a2Var.position = i;
                    a2Var.r = true;
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
                    a2 a2Var3 = new a2();
                    a2Var3.f10787g = true;
                    a2Var3.s = threadData;
                    a2Var3.position = i;
                    a2Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(a2Var3);
                } else if (threadData.getType() == ThreadData.TYPE_VIDEO) {
                    threadData.position = i;
                    a2 a2Var4 = new a2();
                    a2Var4.s = threadData;
                    a2Var4.position = i;
                    a2Var4.r = true;
                    a2Var4.setSupportType(BaseCardInfo.SupportType.TOP);
                    arrayList.add(a2Var4);
                    a2 a2Var5 = new a2();
                    a2Var5.s = threadData;
                    a2Var5.position = i;
                    a2Var5.i = true;
                    a2Var5.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    arrayList.add(a2Var5);
                    a2 a2Var6 = new a2();
                    a2Var6.f10787g = true;
                    a2Var6.s = threadData;
                    a2Var6.position = i;
                    a2Var6.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                    arrayList.add(a2Var6);
                } else {
                    threadData.setSupportType(BaseCardInfo.SupportType.TOP);
                }
                i++;
                threadData.setSupportType(BaseCardInfo.SupportType.TOP);
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
                ThreadData threadData = new ThreadData();
                threadData.isFromHotRankTab = true;
                threadData.parserProtobuf(threadInfo);
                e(threadData);
                arrayList.add(threadData);
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

    public static c.a.p0.q1.g.a.e.b d(List<FrsTabInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            ArrayList arrayList = new ArrayList();
            frsTabInfoData.tabList = arrayList;
            FrsTabItemData frsTabItemData = new FrsTabItemData();
            frsTabItemData.tabCode = "all";
            frsTabItemData.name = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f086c);
            int i = 0;
            frsTabItemData.tabId = 0;
            arrayList.add(frsTabItemData);
            if (!ListUtils.isEmpty(list)) {
                for (FrsTabInfo frsTabInfo : list) {
                    if (frsTabInfo != null && !m.isEmpty(frsTabInfo.tab_code) && !m.isEmpty(frsTabInfo.tab_name)) {
                        i++;
                        FrsTabItemData frsTabItemData2 = new FrsTabItemData(frsTabInfo);
                        frsTabItemData2.tabId = i;
                        arrayList.add(frsTabItemData2);
                    }
                }
            }
            return new c.a.p0.q1.g.a.e.b(frsTabInfoData);
        }
        return (c.a.p0.q1.g.a.e.b) invokeL.objValue;
    }

    public static void e(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + "   " + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }
}
