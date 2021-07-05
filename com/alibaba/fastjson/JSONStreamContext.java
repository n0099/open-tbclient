package com.alibaba.fastjson;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class JSONStreamContext {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ArrayValue = 1005;
    public static final int PropertyKey = 1002;
    public static final int PropertyValue = 1003;
    public static final int StartArray = 1004;
    public static final int StartObject = 1001;
    public transient /* synthetic */ FieldHolder $fh;
    public final JSONStreamContext parent;
    public int state;

    public JSONStreamContext(JSONStreamContext jSONStreamContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONStreamContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = jSONStreamContext;
        this.state = i2;
    }
}
