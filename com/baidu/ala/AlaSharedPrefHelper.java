package com.baidu.ala;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    public float getFloat(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f2)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getFloat(str, f2);
        }
        return invokeLF.floatValue;
    }

    public int getInt(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getInt(str, i2);
        }
        return invokeLI.intValue;
    }

    public long getLong(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j2)) == null) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences();
                this.mSP = sharedPreferences;
                return sharedPreferences.getLong(str, j2);
            } catch (ClassCastException e2) {
                BdLog.e(e2);
                return j2;
            }
        }
        return invokeLJ.longValue;
    }

    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public boolean isContains(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            return sharedPreferences.contains(str);
        }
        return invokeL.booleanValue;
    }

    public void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putBoolean(sharedPreferences, str, z);
        }
    }

    public void putFloat(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048583, this, str, f2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putFloat(sharedPreferences, str, f2);
        }
    }

    public void putInt(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putInt(sharedPreferences, str, i2);
        }
    }

    public void putLong(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048585, this, str, j2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putLong(sharedPreferences, str, j2);
        }
    }

    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.putString(sharedPreferences, str, str2);
        }
    }

    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            SharedPreferences sharedPreferences = getSharedPreferences();
            this.mSP = sharedPreferences;
            EditorHelper.remove(sharedPreferences, str);
        }
    }
}
