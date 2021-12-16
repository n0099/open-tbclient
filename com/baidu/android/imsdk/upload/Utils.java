package com.baidu.android.imsdk.upload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> List<List<T>> splitList(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i2)) == null) {
            if (list == null || list.size() < 1 || i2 < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (size <= i2) {
                arrayList.add(list);
            } else {
                int i3 = size / i2;
                int i4 = size % i2;
                for (int i5 = 0; i5 < i3; i5++) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i6 = 0; i6 < i2; i6++) {
                        arrayList2.add(list.get((i5 * i2) + i6));
                    }
                    arrayList.add(arrayList2);
                }
                if (i4 > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i7 = 0; i7 < i4; i7++) {
                        arrayList3.add(list.get((i3 * i2) + i7));
                    }
                    arrayList.add(arrayList3);
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }
}
