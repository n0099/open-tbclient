package c.a.u0.e1.q1.d;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.frs.accelerator.TornadoNodeInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Map<Integer, PkgNameAndNodeInfoData> a(List<TornadoNodeInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                for (int i4 = 0; i4 < list.get(i3).getNodeInfoList().size(); i4++) {
                    hashMap.put(Integer.valueOf(i2), new PkgNameAndNodeInfoData(list.get(i3).getPackageName(), list.get(i3).getNodeInfoList().get(i4), list.get(i3).getGameId()));
                    i2++;
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String[] b(List<TornadoNodeInfo> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i2)) == null) {
            if (ListUtils.isEmpty(list) || i2 <= 0) {
                return null;
            }
            String[] strArr = new String[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                for (int i5 = 0; i5 < list.get(i4).getNodeInfoList().size(); i5++) {
                    strArr[i3] = list.get(i4).getNodeInfoList().get(i5).getNodeName();
                    i3++;
                }
            }
            return strArr;
        }
        return (String[]) invokeLI.objValue;
    }
}
