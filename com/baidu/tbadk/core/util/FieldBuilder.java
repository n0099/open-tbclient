package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FieldBuilder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EQ = "=";
    public static final String SE = "|";
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder builder;

    public FieldBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.builder = null;
        this.builder = null;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = this.builder;
            if (sb != null) {
                return sb.toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void append(String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) && !wi.isEmpty(str) && obj != null) {
            try {
                if (this.builder == null) {
                    StringBuilder sb = new StringBuilder();
                    this.builder = sb;
                    sb.append(str);
                    this.builder.append("=");
                    this.builder.append(obj.toString());
                } else {
                    this.builder.append("|");
                    this.builder.append(str);
                    this.builder.append("=");
                    this.builder.append(obj.toString());
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void merge(FieldBuilder fieldBuilder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fieldBuilder) != null) || fieldBuilder == null) {
            return;
        }
        StringBuilder sb = this.builder;
        if (sb == null) {
            StringBuilder sb2 = new StringBuilder();
            this.builder = sb2;
            sb2.append(fieldBuilder.toString());
            return;
        }
        sb.append("|");
        this.builder.append(fieldBuilder.toString());
    }
}
