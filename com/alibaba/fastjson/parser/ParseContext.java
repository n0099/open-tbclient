package com.alibaba.fastjson.parser;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
/* loaded from: classes.dex */
public class ParseContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object fieldName;
    public final int level;
    public Object object;
    public final ParseContext parent;
    public transient String path;
    public Type type;

    public ParseContext(ParseContext parseContext, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parseContext, obj, obj2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
        this.level = parseContext == null ? 0 : parseContext.level + 1;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.path == null) {
                if (this.parent == null) {
                    this.path = "$";
                } else if (this.fieldName instanceof Integer) {
                    this.path = this.parent.toString() + PreferencesUtil.LEFT_MOUNT + this.fieldName + PreferencesUtil.RIGHT_MOUNT;
                } else {
                    this.path = this.parent.toString() + "." + this.fieldName;
                }
            }
            return this.path;
        }
        return (String) invokeV.objValue;
    }
}
