package com.baidu.adp.framework.cmdRouter;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class TiebaCmdClassesArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] cmdClassesArray;

    public TiebaCmdClassesArray() {
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
        this.cmdClassesArray = new String[0];
    }

    public Set<String> loadCmdClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashSet hashSet = new HashSet();
            try {
                if (this.cmdClassesArray.length <= 0) {
                    return hashSet;
                }
                for (String str : this.cmdClassesArray) {
                    hashSet.add(str);
                }
                return hashSet;
            } catch (Throwable th) {
                BdLog.e(th);
                return hashSet;
            }
        }
        return (Set) invokeV.objValue;
    }
}
