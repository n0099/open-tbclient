package com.baidu.android.imsdk.upload;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> List<List<T>> splitList(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            if (list == null || list.size() < 1 || i < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            if (size <= i) {
                arrayList.add(list);
            } else {
                int i2 = size / i;
                int i3 = size % i;
                for (int i4 = 0; i4 < i2; i4++) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < i; i5++) {
                        arrayList2.add(list.get((i4 * i) + i5));
                    }
                    arrayList.add(arrayList2);
                }
                if (i3 > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i6 = 0; i6 < i3; i6++) {
                        arrayList3.add(list.get((i2 * i) + i6));
                    }
                    arrayList.add(arrayList3);
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }
}
