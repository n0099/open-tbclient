package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TiebaStaticClassesArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] staticClassesArray;

    public TiebaStaticClassesArray() {
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
        this.staticClassesArray = new String[0];
    }

    public boolean loadStaticClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.staticClassesArray.length <= 0) {
                    return false;
                }
                for (String str : this.staticClassesArray) {
                    try {
                        Class.forName(str);
                    } catch (Throwable th) {
                        BdLog.e(th);
                        Log.e("TiebaStaticClassesArray", "classforName failed. " + th.getMessage());
                    }
                }
                return true;
            } catch (Throwable th2) {
                BdLog.e(th2);
                Log.e("TiebaStaticClassesArray", "init class failed. " + th2.getMessage());
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
