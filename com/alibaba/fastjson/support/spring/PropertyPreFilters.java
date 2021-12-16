package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PropertyPreFilters {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MySimplePropertyPreFilter> filters;

    /* loaded from: classes9.dex */
    public class MySimplePropertyPreFilter extends SimplePropertyPreFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PropertyPreFilters this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter(PropertyPreFilters propertyPreFilters) {
            super(new String[0]);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {propertyPreFilters};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String[]) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = propertyPreFilters;
        }

        public MySimplePropertyPreFilter addExcludes(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                for (String str : strArr) {
                    getExcludes().add(str);
                }
                return this;
            }
            return (MySimplePropertyPreFilter) invokeL.objValue;
        }

        public MySimplePropertyPreFilter addIncludes(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                for (String str : strArr) {
                    getIncludes().add(str);
                }
                return this;
            }
            return (MySimplePropertyPreFilter) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter(PropertyPreFilters propertyPreFilters, String... strArr) {
            super(strArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {propertyPreFilters, strArr};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String[]) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.this$0 = propertyPreFilters;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MySimplePropertyPreFilter(PropertyPreFilters propertyPreFilters, Class<?> cls, String... strArr) {
            super(cls, strArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {propertyPreFilters, cls, strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Class) objArr2[0], (String[]) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = propertyPreFilters;
        }
    }

    public PropertyPreFilters() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.filters = new ArrayList();
    }

    public MySimplePropertyPreFilter addFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(this);
            this.filters.add(mySimplePropertyPreFilter);
            return mySimplePropertyPreFilter;
        }
        return (MySimplePropertyPreFilter) invokeV.objValue;
    }

    public List<MySimplePropertyPreFilter> getFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.filters : (List) invokeV.objValue;
    }

    public void setFilters(List<MySimplePropertyPreFilter> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.filters = list;
        }
    }

    public MySimplePropertyPreFilter[] toFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (MySimplePropertyPreFilter[]) this.filters.toArray(new MySimplePropertyPreFilter[0]) : (MySimplePropertyPreFilter[]) invokeV.objValue;
    }

    public MySimplePropertyPreFilter addFilter(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(this, strArr);
            this.filters.add(mySimplePropertyPreFilter);
            return mySimplePropertyPreFilter;
        }
        return (MySimplePropertyPreFilter) invokeL.objValue;
    }

    public MySimplePropertyPreFilter addFilter(Class<?> cls, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, strArr)) == null) {
            MySimplePropertyPreFilter mySimplePropertyPreFilter = new MySimplePropertyPreFilter(this, cls, strArr);
            this.filters.add(mySimplePropertyPreFilter);
            return mySimplePropertyPreFilter;
        }
        return (MySimplePropertyPreFilter) invokeLL.objValue;
    }
}
