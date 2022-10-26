package com.baidu.ala;

import android.content.SharedPreferences;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AlaSharedPrefHelper {
    public static /* synthetic */ Interceptable $ic;
    public static AlaSharedPrefHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences mSP;

    public AlaSharedPrefHelper() {
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

    public static AlaSharedPrefHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (mInstance == null) {
                synchronized (AlaSharedPrefHelper.class) {
                    if (mInstance == null) {
                        mInstance = new AlaSharedPrefHelper();
                    }
                }
            }
            return mInstance;
        }
        return (AlaSharedPrefHelper) invokeV.objValue;
    }

    private synchronized SharedPreferences getSharedPreferences() {
        InterceptResult invokeV;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
            }
            return sharedPreferences;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences();
                this.mSP = sharedPreferences;
                return sharedPreferences.getLong(str, j);
            } catch (ClassCastException e) {
                BdLog.e(e);
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putBoolean(sharedPreferences, str, z);
        }
    }

    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putLong(sharedPreferences, str, j);
        }
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putString(sharedPreferences, str, str2);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.remove(sharedPreferences, str);
        }
    }
}
