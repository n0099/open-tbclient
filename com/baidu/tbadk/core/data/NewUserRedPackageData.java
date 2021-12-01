package com.baidu.tbadk.core.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.ActiveConfig.DataRes;
/* loaded from: classes9.dex */
public class NewUserRedPackageData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String clickUrl;
    public String money;
    public String topPicUrl;

    public NewUserRedPackageData() {
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

    public void parseProto(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
            this.topPicUrl = dataRes.newuser_pop_top;
            this.money = dataRes.newuser_pop_money;
            this.clickUrl = dataRes.newuser_pop_clickurl;
        }
    }
}
