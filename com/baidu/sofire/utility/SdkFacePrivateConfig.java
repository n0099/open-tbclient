package com.baidu.sofire.utility;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SdkFacePrivateConfig {
    public static /* synthetic */ Interceptable $ic;
    public static SdkFacePrivateConfig sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences.Editor mEditor;
    public SharedPreferences mPref;

    public SdkFacePrivateConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        SharedPreferences platformPrivateSharedPreferences = SharedPreferenceManager.getInstance(context).getPlatformPrivateSharedPreferences();
        this.mPref = platformPrivateSharedPreferences;
        this.mEditor = platformPrivateSharedPreferences.edit();
    }

    public static synchronized SdkFacePrivateConfig getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (SdkFacePrivateConfig.class) {
                if (context == null) {
                    return sInstance;
                }
                if (sInstance == null) {
                    sInstance = new SdkFacePrivateConfig(context);
                }
                return sInstance;
            }
        }
        return (SdkFacePrivateConfig) invokeL.objValue;
    }

    public boolean getBackFrameFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPref.getBoolean("lt_sbff", false) : invokeV.booleanValue;
    }

    public boolean getBlockWhenNoPlugin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPref.getBoolean("lt_sbwnp", true) : invokeV.booleanValue;
    }

    public boolean getDeviceCheckFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPref.getBoolean("lt_sdcf", true) : invokeV.booleanValue;
    }

    public long getFaceInfoInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPref.getLong("lt_sfii", 1000L) : invokeV.longValue;
    }

    public boolean getFirstFrameFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPref.getBoolean("lt_sfff", false) : invokeV.booleanValue;
    }

    public String getHostArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPref.getString("lt_sha", "") : (String) invokeV.objValue;
    }

    public boolean getPluginProcessFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mPref.getBoolean("lt_sppf", false) : invokeV.booleanValue;
    }

    public boolean getSingleSensorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPref.getBoolean("lt_sssf", true) : invokeV.booleanValue;
    }

    public boolean getUnknownContinueFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPref.getBoolean("lt_sucf", false) : invokeV.booleanValue;
    }

    public void setBackFrameFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mEditor.putBoolean("lt_sbff", z);
            this.mEditor.commit();
        }
    }

    public void setBlockWhenNoPlugin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mEditor.putBoolean("lt_sbwnp", z);
            this.mEditor.commit();
        }
    }

    public void setDeviceCheckFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mEditor.putBoolean("lt_sdcf", z);
            this.mEditor.commit();
        }
    }

    public void setFaceInfoInterval(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.mEditor.putLong("lt_sfii", j);
            this.mEditor.commit();
        }
    }

    public void setFirstFrameFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mEditor.putBoolean("lt_sfff", z);
            this.mEditor.commit();
        }
    }

    public void setHostArray(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mEditor.putString("lt_sha", str);
            this.mEditor.commit();
        }
    }

    public void setPluginProcessFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mEditor.putBoolean("lt_sppf", z);
            this.mEditor.commit();
        }
    }

    public void setSingleSensorFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.mEditor.putBoolean("lt_sssf", z);
            this.mEditor.commit();
        }
    }

    public void setUnknownContinueFlag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mEditor.putBoolean("lt_sucf", z);
            this.mEditor.commit();
        }
    }
}
