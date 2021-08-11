package com.baidu.pass.ecommerce.view.addressdialog;

import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ElementNode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AddressEntity addressEntity;
    public ElementNode next;
    public ElementNode pre;

    /* loaded from: classes5.dex */
    public static class AddressEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<AddressBean> hotlists;
        public List<AddressBean> list;
        public String selectedId;
        public String selectedName;
        public int selectedPosition;
        public String selectedType;

        public AddressEntity() {
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

        public AddressEntity(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.selectedId = str;
            this.selectedName = str2;
            this.selectedType = str3;
        }

        public AddressEntity(List<AddressBean> list, List<AddressBean> list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, list2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.list = list;
            this.hotlists = list2;
        }
    }

    public ElementNode(AddressEntity addressEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {addressEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.addressEntity = addressEntity;
    }

    public static int getPosition(ElementNode elementNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, elementNode)) == null) {
            ElementNode elementNode2 = elementNode.pre;
            if (elementNode2 != null) {
                return getPosition(elementNode2) + 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static ElementNode moveHeader(ElementNode elementNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, elementNode)) != null) {
            return (ElementNode) invokeL.objValue;
        }
        if (elementNode == null) {
            return null;
        }
        while (true) {
            ElementNode elementNode2 = elementNode.pre;
            if (elementNode2 == null) {
                return elementNode;
            }
            elementNode = elementNode2;
        }
    }
}
