package com.baidu.tbadk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tbadk.core.util.TiebaMainSdDatabaseHelper;
import com.baidu.tieba.o9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TiebaDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static TiebaDatabase _instance;
    public transient /* synthetic */ FieldHolder $fh;
    public o9 mainDB;
    public o9 mainSdDB;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1082933900, "Lcom/baidu/tbadk/TiebaDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1082933900, "Lcom/baidu/tbadk/TiebaDatabase;");
                return;
            }
        }
        _instance = new TiebaDatabase();
    }

    public TiebaDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static TiebaDatabase getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return _instance;
        }
        return (TiebaDatabase) invokeV.objValue;
    }

    public o9 getMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o9 o9Var = this.mainDB;
            if (o9Var != null) {
                return o9Var;
            }
            synchronized (_instance) {
                if (this.mainDB != null) {
                    return this.mainDB;
                }
                o9 o9Var2 = new o9(new TiebaMainDatabaseHelper(TbadkCoreApplication.getInst().getContext()));
                this.mainDB = o9Var2;
                return o9Var2;
            }
        }
        return (o9) invokeV.objValue;
    }

    public o9 getSdcardMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            o9 o9Var = this.mainSdDB;
            if (o9Var != null) {
                return o9Var;
            }
            synchronized (_instance) {
                if (this.mainSdDB != null) {
                    return this.mainSdDB;
                }
                o9 o9Var2 = new o9(new TiebaMainSdDatabaseHelper());
                this.mainSdDB = o9Var2;
                return o9Var2;
            }
        }
        return (o9) invokeV.objValue;
    }
}
