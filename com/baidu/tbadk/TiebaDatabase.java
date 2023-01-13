package com.baidu.tbadk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaMainDatabaseHelper;
import com.baidu.tbadk.core.util.TiebaMainSdDatabaseHelper;
import com.baidu.tieba.aa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class TiebaDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static TiebaDatabase _instance;
    public transient /* synthetic */ FieldHolder $fh;
    public aa mainDB;
    public aa mainSdDB;

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

    public aa getMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            aa aaVar = this.mainDB;
            if (aaVar != null) {
                return aaVar;
            }
            synchronized (_instance) {
                if (this.mainDB != null) {
                    return this.mainDB;
                }
                aa aaVar2 = new aa(new TiebaMainDatabaseHelper(TbadkCoreApplication.getInst().getContext()));
                this.mainDB = aaVar2;
                return aaVar2;
            }
        }
        return (aa) invokeV.objValue;
    }

    public aa getSdcardMainDBDatabaseManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            aa aaVar = this.mainSdDB;
            if (aaVar != null) {
                return aaVar;
            }
            synchronized (_instance) {
                if (this.mainSdDB != null) {
                    return this.mainSdDB;
                }
                aa aaVar2 = new aa(new TiebaMainSdDatabaseHelper());
                this.mainSdDB = aaVar2;
                return aaVar2;
            }
        }
        return (aa) invokeV.objValue;
    }
}
