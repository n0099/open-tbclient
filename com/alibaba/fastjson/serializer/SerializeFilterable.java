package com.alibaba.fastjson.serializer;

import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.JSON;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class SerializeFilterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AfterFilter> afterFilters;
    public List<BeforeFilter> beforeFilters;
    public List<ContextValueFilter> contextValueFilters;
    public List<LabelFilter> labelFilters;
    public List<NameFilter> nameFilters;
    public List<PropertyFilter> propertyFilters;
    public List<PropertyPreFilter> propertyPreFilters;
    public List<ValueFilter> valueFilters;
    public boolean writeDirect;

    public SerializeFilterable() {
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
        this.beforeFilters = null;
        this.afterFilters = null;
        this.propertyFilters = null;
        this.valueFilters = null;
        this.nameFilters = null;
        this.propertyPreFilters = null;
        this.labelFilters = null;
        this.contextValueFilters = null;
        this.writeDirect = true;
    }

    public void addFilter(SerializeFilter serializeFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, serializeFilter) == null) || serializeFilter == null) {
            return;
        }
        if (serializeFilter instanceof PropertyPreFilter) {
            getPropertyPreFilters().add((PropertyPreFilter) serializeFilter);
        }
        if (serializeFilter instanceof NameFilter) {
            getNameFilters().add((NameFilter) serializeFilter);
        }
        if (serializeFilter instanceof ValueFilter) {
            getValueFilters().add((ValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof ContextValueFilter) {
            getContextValueFilters().add((ContextValueFilter) serializeFilter);
        }
        if (serializeFilter instanceof PropertyFilter) {
            getPropertyFilters().add((PropertyFilter) serializeFilter);
        }
        if (serializeFilter instanceof BeforeFilter) {
            getBeforeFilters().add((BeforeFilter) serializeFilter);
        }
        if (serializeFilter instanceof AfterFilter) {
            getAfterFilters().add((AfterFilter) serializeFilter);
        }
        if (serializeFilter instanceof LabelFilter) {
            getLabelFilters().add((LabelFilter) serializeFilter);
        }
    }

    public boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONSerializer, obj, str, obj2)) == null) {
            List<PropertyFilter> list = jSONSerializer.propertyFilters;
            if (list != null) {
                for (PropertyFilter propertyFilter : list) {
                    if (!propertyFilter.apply(obj, str, obj2)) {
                        return false;
                    }
                }
            }
            List<PropertyFilter> list2 = this.propertyFilters;
            if (list2 != null) {
                for (PropertyFilter propertyFilter2 : list2) {
                    if (!propertyFilter2.apply(obj, str, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONSerializer, obj, str)) == null) {
            List<PropertyPreFilter> list = jSONSerializer.propertyPreFilters;
            if (list != null) {
                for (PropertyPreFilter propertyPreFilter : list) {
                    if (!propertyPreFilter.apply(jSONSerializer, obj, str)) {
                        return false;
                    }
                }
            }
            List<PropertyPreFilter> list2 = this.propertyPreFilters;
            if (list2 != null) {
                for (PropertyPreFilter propertyPreFilter2 : list2) {
                    if (!propertyPreFilter2.apply(jSONSerializer, obj, str)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public List<AfterFilter> getAfterFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.afterFilters == null) {
                this.afterFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.afterFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<BeforeFilter> getBeforeFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.beforeFilters == null) {
                this.beforeFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.beforeFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<ContextValueFilter> getContextValueFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.contextValueFilters == null) {
                this.contextValueFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.contextValueFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<LabelFilter> getLabelFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.labelFilters == null) {
                this.labelFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.labelFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<NameFilter> getNameFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.nameFilters == null) {
                this.nameFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.nameFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<PropertyFilter> getPropertyFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.propertyFilters == null) {
                this.propertyFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.propertyFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<PropertyPreFilter> getPropertyPreFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.propertyPreFilters == null) {
                this.propertyPreFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.propertyPreFilters;
        }
        return (List) invokeV.objValue;
    }

    public List<ValueFilter> getValueFilters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.valueFilters == null) {
                this.valueFilters = new ArrayList();
                this.writeDirect = false;
            }
            return this.valueFilters;
        }
        return (List) invokeV.objValue;
    }

    public String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, jSONSerializer, obj, str, obj2)) == null) {
            List<NameFilter> list = jSONSerializer.nameFilters;
            if (list != null) {
                for (NameFilter nameFilter : list) {
                    str = nameFilter.process(obj, str, obj2);
                }
            }
            List<NameFilter> list2 = this.nameFilters;
            if (list2 != null) {
                for (NameFilter nameFilter2 : list2) {
                    str = nameFilter2.process(obj, str, obj2);
                }
            }
            return str;
        }
        return (String) invokeLLLL.objValue;
    }

    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, jSONSerializer, beanContext, obj, str, obj2)) == null) ? processValue(jSONSerializer, beanContext, obj, str, obj2, 0) : invokeLLLLL.objValue;
    }

    public boolean writeDirect(JSONSerializer jSONSerializer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, jSONSerializer)) == null) ? jSONSerializer.out.writeDirect && this.writeDirect && jSONSerializer.writeDirect : invokeL.booleanValue;
    }

    public Object processValue(JSONSerializer jSONSerializer, BeanContext beanContext, Object obj, String str, Object obj2, int i2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{jSONSerializer, beanContext, obj, str, obj2, Integer.valueOf(i2)})) == null) {
            if (obj2 != null) {
                if ((SerializerFeature.isEnabled(jSONSerializer.out.features, i2, SerializerFeature.WriteNonStringValueAsString) || !(beanContext == null || (beanContext.getFeatures() & SerializerFeature.WriteNonStringValueAsString.mask) == 0)) && (((z = obj2 instanceof Number)) || (obj2 instanceof Boolean))) {
                    String str2 = null;
                    if (z && beanContext != null) {
                        str2 = beanContext.getFormat();
                    }
                    if (str2 != null) {
                        obj2 = new DecimalFormat(str2).format(obj2);
                    } else {
                        obj2 = obj2.toString();
                    }
                } else if (beanContext != null && beanContext.isJsonDirect()) {
                    obj2 = JSON.parse((String) obj2);
                }
            }
            List<ValueFilter> list = jSONSerializer.valueFilters;
            if (list != null) {
                for (ValueFilter valueFilter : list) {
                    obj2 = valueFilter.process(obj, str, obj2);
                }
            }
            List<ValueFilter> list2 = this.valueFilters;
            if (list2 != null) {
                for (ValueFilter valueFilter2 : list2) {
                    obj2 = valueFilter2.process(obj, str, obj2);
                }
            }
            List<ContextValueFilter> list3 = jSONSerializer.contextValueFilters;
            if (list3 != null) {
                for (ContextValueFilter contextValueFilter : list3) {
                    obj2 = contextValueFilter.process(beanContext, obj, str, obj2);
                }
            }
            List<ContextValueFilter> list4 = this.contextValueFilters;
            if (list4 != null) {
                for (ContextValueFilter contextValueFilter2 : list4) {
                    obj2 = contextValueFilter2.process(beanContext, obj, str, obj2);
                }
            }
            return obj2;
        }
        return invokeCommon.objValue;
    }
}
