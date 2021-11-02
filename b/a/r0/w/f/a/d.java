package b.a.r0.w.f.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.LiveSquare.HotLiveWithCategory;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<b.a.r0.w.f.b.b.a> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new b.a.r0.w.f.b.b.a(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(b.a.r0.w.f.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            List<ThreadInfo> list = aVar.f24531e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    e eVar = new e();
                    eVar.f24507e = aVar.f24527a;
                    eVar.f24508f = aVar.f24528b;
                    eVar.f24509g = aVar.f24529c;
                    eVar.o(threadInfo);
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<b.a.r0.w.f.b.b.a> list, List<b.a.r0.w.f.b.b.a> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (b.a.r0.w.f.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f24531e);
            }
        }
        for (b.a.r0.w.f.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f24531e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < aVar2.f24531e.size(); i2++) {
                    ThreadInfo threadInfo = aVar2.f24531e.get(i2);
                    if (threadInfo != null) {
                        if (list3.contains(threadInfo.ala_info.live_id)) {
                            arrayList.add(Integer.valueOf(i2));
                        } else {
                            arrayList2.add(threadInfo.ala_info.live_id);
                        }
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    List list4 = (List) hashMap.get(e(aVar2));
                    if (!ListUtils.isEmpty(list4)) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Integer num : arrayList) {
                            int intValue = num.intValue();
                            if (intValue < aVar2.f24531e.size()) {
                                ThreadInfo threadInfo2 = null;
                                Iterator it = list4.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ThreadInfo threadInfo3 = (ThreadInfo) it.next();
                                    if (threadInfo3 != null && !list3.contains(threadInfo3.ala_info.live_id) && !arrayList2.contains(threadInfo3.ala_info.live_id) && !arrayList3.contains(threadInfo3.ala_info.live_id)) {
                                        threadInfo2 = threadInfo3;
                                        break;
                                    }
                                }
                                if (threadInfo2 != null) {
                                    arrayList3.add(threadInfo2.ala_info.live_id);
                                    aVar2.f24531e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f24531e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<b.a.r0.w.f.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (b.a.r0.w.f.b.b.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f24531e)) {
                    List<n> b2 = b(aVar);
                    String str2 = aVar.f24528b;
                    if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        b.a.r0.w.f.b.b.b bVar = new b.a.r0.w.f.b.b.b();
                        bVar.f24534e = aVar.f24527a;
                        bVar.f24535f = str2;
                        bVar.f24536g = aVar.f24529c;
                        bVar.f24537h = aVar.f24530d;
                        int i2 = aVar.f24532f;
                        bVar.f24538i = aVar.f24533g;
                        linkedList.add(bVar);
                        int size = b2.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i3 = 0;
                        aVar.f24531e = aVar.f24531e.subList(0, size);
                        while (true) {
                            int i4 = i3 + 1;
                            if (i4 < size) {
                                if ("1:1".equals(aVar.f24530d)) {
                                    b.a.r0.w.f.h.b.b bVar2 = new b.a.r0.w.f.h.b.b();
                                    e eVar = (e) b2.get(i3);
                                    e eVar2 = (e) b2.get(i4);
                                    bVar2.f24892e = eVar;
                                    bVar2.f24893f = eVar2;
                                    arrayList.add(eVar);
                                    arrayList.add(eVar2);
                                    linkedList.add(bVar2);
                                } else if ("16:9".equals(aVar.f24530d)) {
                                    b.a.r0.w.f.h.b.a aVar2 = new b.a.r0.w.f.h.b.a();
                                    e eVar3 = (e) b2.get(i3);
                                    e eVar4 = (e) b2.get(i4);
                                    aVar2.f24889e = eVar3;
                                    aVar2.f24890f = eVar4;
                                    arrayList.add(eVar3);
                                    arrayList.add(eVar4);
                                    linkedList.add(aVar2);
                                }
                                i3 += 2;
                            }
                        }
                    } else {
                        arrayList2.add(aVar);
                    }
                } else {
                    arrayList2.add(aVar);
                }
            }
            list.removeAll(arrayList2);
            return new Pair<>(linkedList, arrayList);
        }
        return (Pair) invokeLL.objValue;
    }

    public static String e(b.a.r0.w.f.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.f24527a + "_");
            sb.append(aVar.f24528b + "_");
            sb.append(aVar.f24529c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(b.a.r0.w.f.b.b.a aVar, List<b.a.r0.w.f.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, list)) == null) {
            if (aVar != null && !ListUtils.isEmpty(list)) {
                for (b.a.r0.w.f.b.b.a aVar2 : list) {
                    if (aVar.f24527a == aVar2.f24527a && aVar.f24528b.equals(aVar2.f24528b) && aVar.f24529c.equals(aVar2.f24529c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<b.a.r0.w.f.b.b.a> g(List<b.a.r0.w.f.b.b.a> list, List<b.a.r0.w.f.b.b.a> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, list, list2, z)) == null) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 == null || list2.isEmpty()) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (b.a.r0.w.f.b.b.a aVar : list2) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f24531e) && !TextUtils.isEmpty(aVar.f24528b)) {
                    if (z) {
                        if (!f(aVar, list)) {
                            linkedList.add(aVar);
                        }
                    } else {
                        linkedList.add(aVar);
                    }
                }
            }
            if (z) {
                linkedList.addAll(0, list);
            }
            return linkedList;
        }
        return (List) invokeLLZ.objValue;
    }
}
