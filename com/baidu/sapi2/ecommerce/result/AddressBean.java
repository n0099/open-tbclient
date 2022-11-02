package com.baidu.sapi2.ecommerce.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class AddressBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasLeaf;
    public List<AddressBean> hotlists;
    public String id;
    public boolean isHmt;
    public boolean isHotCity;
    public boolean isHotSelected;
    public boolean isNotSelected;
    public boolean isShowPy;
    public String leafType;
    public String name;
    public String namePyInit;
    public String pid;
    public String pname;
    public String ptype;
    public String type;

    public AddressBean() {
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
}
