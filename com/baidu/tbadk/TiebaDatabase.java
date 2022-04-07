package com.baidu.tbadk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tbadk.core.util.TiebaMainSdDatabaseHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h9;
/* loaded from: classes2.dex */
public class TiebaDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static TiebaDatabase _instance;
    public transient /* synthetic */ FieldHolder $fh;
    public h9 mainDB;
    public h9 mainSdDB;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? _instance : (TiebaDatabase) invokeV.objValue;
    }

    public h9 getMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h9 h9Var = this.mainDB;
            if (h9Var != null) {
                return h9Var;
            }
            synchronized (_instance) {
                if (this.mainDB != null) {
                    return this.mainDB;
                }
                h9 h9Var2 = new h9(new TiebaMainDatabaseHelper(TbadkCoreApplication.getInst().getContext()));
                this.mainDB = h9Var2;
                return h9Var2;
            }
        }
        return (h9) invokeV.objValue;
    }

    public h9 getSdcardMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h9 h9Var = this.mainSdDB;
            if (h9Var != null) {
                return h9Var;
            }
            synchronized (_instance) {
                if (this.mainSdDB != null) {
                    return this.mainSdDB;
                }
                h9 h9Var2 = new h9(new TiebaMainSdDatabaseHelper());
                this.mainSdDB = h9Var2;
                return h9Var2;
            }
        }
        return (h9) invokeV.objValue;
    }
}
