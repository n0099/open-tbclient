package c.a.t0.a0.f.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
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
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<c.a.t0.a0.f.b.b.a> a(List<HotLiveWithCategory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return new LinkedList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (HotLiveWithCategory hotLiveWithCategory : list) {
                if (hotLiveWithCategory != null) {
                    arrayList.add(new c.a.t0.a0.f.b.b.a(hotLiveWithCategory));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<n> b(c.a.t0.a0.f.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            List<ThreadInfo> list = aVar.f14504e;
            ArrayList arrayList = new ArrayList(list.size());
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null) {
                    e eVar = new e();
                    eVar.f14481e = aVar.a;
                    eVar.f14482f = aVar.f14501b;
                    eVar.f14483g = aVar.f14502c;
                    eVar.o(threadInfo);
                    arrayList.add(eVar);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void c(List<c.a.t0.a0.f.b.b.a> list, List<c.a.t0.a0.f.b.b.a> list2, List<Long> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, list2, list3) == null) || ListUtils.isEmpty(list2)) {
            return;
        }
        HashMap hashMap = new HashMap(list2.size());
        for (c.a.t0.a0.f.b.b.a aVar : list2) {
            if (aVar != null) {
                hashMap.put(e(aVar), aVar.f14504e);
            }
        }
        for (c.a.t0.a0.f.b.b.a aVar2 : list) {
            if (aVar2 != null && !ListUtils.isEmpty(aVar2.f14504e)) {
                ArrayList<Integer> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < aVar2.f14504e.size(); i2++) {
                    ThreadInfo threadInfo = aVar2.f14504e.get(i2);
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
                            if (intValue < aVar2.f14504e.size()) {
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
                                    aVar2.f14504e.set(intValue, threadInfo2);
                                } else {
                                    aVar2.f14504e.remove(intValue);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static Pair<List<n>, List<n>> d(String str, List<c.a.t0.a0.f.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (c.a.t0.a0.f.b.b.a aVar : list) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f14504e)) {
                    List<n> b2 = b(aVar);
                    String str2 = aVar.f14501b;
                    if (!ListUtils.isEmpty(b2) && b2.size() >= 2 && !TextUtils.isEmpty(str2)) {
                        c.a.t0.a0.f.b.b.b bVar = new c.a.t0.a0.f.b.b.b();
                        bVar.f14508e = aVar.a;
                        bVar.f14509f = str2;
                        bVar.f14510g = aVar.f14502c;
                        bVar.f14511h = aVar.f14503d;
                        int i2 = aVar.f14505f;
                        bVar.f14512i = aVar.f14506g;
                        linkedList.add(bVar);
                        int size = b2.size();
                        if (size % 2 != 0) {
                            size--;
                        }
                        int i3 = 0;
                        aVar.f14504e = aVar.f14504e.subList(0, size);
                        while (true) {
                            int i4 = i3 + 1;
                            if (i4 < size) {
                                if ("1:1".equals(aVar.f14503d)) {
                                    c.a.t0.a0.f.h.b.b bVar2 = new c.a.t0.a0.f.h.b.b();
                                    e eVar = (e) b2.get(i3);
                                    e eVar2 = (e) b2.get(i4);
                                    bVar2.f14806e = eVar;
                                    bVar2.f14807f = eVar2;
                                    arrayList.add(eVar);
                                    arrayList.add(eVar2);
                                    linkedList.add(bVar2);
                                } else if ("16:9".equals(aVar.f14503d)) {
                                    c.a.t0.a0.f.h.b.a aVar2 = new c.a.t0.a0.f.h.b.a();
                                    e eVar3 = (e) b2.get(i3);
                                    e eVar4 = (e) b2.get(i4);
                                    aVar2.f14803e = eVar3;
                                    aVar2.f14804f = eVar4;
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

    public static String e(c.a.t0.a0.f.b.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.a + "_");
            sb.append(aVar.f14501b + "_");
            sb.append(aVar.f14502c);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(c.a.t0.a0.f.b.b.a aVar, List<c.a.t0.a0.f.b.b.a> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, aVar, list)) == null) {
            if (aVar != null && !ListUtils.isEmpty(list)) {
                for (c.a.t0.a0.f.b.b.a aVar2 : list) {
                    if (aVar.a == aVar2.a && aVar.f14501b.equals(aVar2.f14501b) && aVar.f14502c.equals(aVar2.f14502c)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static List<c.a.t0.a0.f.b.b.a> g(List<c.a.t0.a0.f.b.b.a> list, List<c.a.t0.a0.f.b.b.a> list2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, list, list2, z)) == null) {
            if (list == null || list.isEmpty()) {
                return list2;
            }
            if (list2 == null || list2.isEmpty()) {
                return list;
            }
            LinkedList linkedList = new LinkedList();
            for (c.a.t0.a0.f.b.b.a aVar : list2) {
                if (aVar != null && !ListUtils.isEmpty(aVar.f14504e) && !TextUtils.isEmpty(aVar.f14501b)) {
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
