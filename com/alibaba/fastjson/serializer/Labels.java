package com.alibaba.fastjson.serializer;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class Labels {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class DefaultLabelFilter implements LabelFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] excludes;
        public String[] includes;

        public DefaultLabelFilter(String[] strArr, String[] strArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr, strArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (strArr != null) {
                String[] strArr3 = new String[strArr.length];
                this.includes = strArr3;
                System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
                Arrays.sort(this.includes);
            }
            if (strArr2 != null) {
                String[] strArr4 = new String[strArr2.length];
                this.excludes = strArr4;
                System.arraycopy(strArr2, 0, strArr4, 0, strArr2.length);
                Arrays.sort(this.excludes);
            }
        }

        @Override // com.alibaba.fastjson.serializer.LabelFilter
        public boolean apply(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                String[] strArr = this.excludes;
                if (strArr != null) {
                    return Arrays.binarySearch(strArr, str) < 0;
                }
                String[] strArr2 = this.includes;
                return strArr2 != null && Arrays.binarySearch(strArr2, str) >= 0;
            }
            return invokeL.booleanValue;
        }
    }

    public Labels() {
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

    public static LabelFilter excludes(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) ? new DefaultLabelFilter(null, strArr) : (LabelFilter) invokeL.objValue;
    }

    public static LabelFilter includes(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) ? new DefaultLabelFilter(strArr, null) : (LabelFilter) invokeL.objValue;
    }
}
