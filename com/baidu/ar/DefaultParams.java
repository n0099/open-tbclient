package com.baidu.ar;

import android.opengl.EGLContext;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class DefaultParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean aA;
    public boolean aB;
    public boolean aC;
    public boolean aD;
    public boolean aE;
    public EGLContext aF;
    public String aG;
    public JSONObject aH;
    public boolean aI;
    public boolean aJ;
    public boolean aK;
    public String aL;
    public String ay;
    public String az;

    public DefaultParams() {
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
        this.aA = true;
        this.aB = true;
        this.aC = true;
        this.aD = true;
        this.aE = false;
        this.aF = null;
        this.aG = null;
        this.aH = null;
        this.aI = true;
        this.aJ = false;
        this.aK = true;
    }

    public void enableLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.aI = z;
        }
    }

    public String get3dShaderDBPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.aL : (String) invokeV.objValue;
    }

    public String getFaceAlgoModelPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ay : (String) invokeV.objValue;
    }

    public JSONObject getGradingConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.aH : (JSONObject) invokeV.objValue;
    }

    public String getMdlAlgoModelPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.az : (String) invokeV.objValue;
    }

    public String getRenderPipeline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.aG : (String) invokeV.objValue;
    }

    public EGLContext getShareContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.aF : (EGLContext) invokeV.objValue;
    }

    public boolean isLogEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.aI : invokeV.booleanValue;
    }

    public boolean isRecordAutoCrop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.aK : invokeV.booleanValue;
    }

    public boolean isUseBeautyFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.aB : invokeV.booleanValue;
    }

    public boolean isUseFaceFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.aC : invokeV.booleanValue;
    }

    public boolean isUseInputSizeInEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.aA : invokeV.booleanValue;
    }

    public boolean isUseMakeupFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.aD : invokeV.booleanValue;
    }

    public boolean isUseTextureIO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.aE : invokeV.booleanValue;
    }

    public boolean isUserPlayAudio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.aJ : invokeV.booleanValue;
    }

    public void set3dShaderPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.aL = str;
        }
    }

    public void setFaceAlgoModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.ay = str;
        }
    }

    public void setGradingConfig(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            this.aH = jSONObject;
        }
    }

    public void setMdlAlgoModelPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.az = str;
        }
    }

    public void setRecordAutoCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.aK = z;
        }
    }

    public void setRenderPipeline(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.aG = str;
        }
    }

    public void setShareContext(EGLContext eGLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eGLContext) == null) {
            this.aF = eGLContext;
        }
    }

    public void setUseBeautyFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.aB = z;
        }
    }

    public void setUseFaceFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.aC = z;
        }
    }

    public void setUseInputSizeInEngine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.aA = z;
        }
    }

    public void setUseMakeupFilter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.aD = z;
        }
    }

    public void setUseTextureIO(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.aE = z;
        }
    }

    public void setUserPlayAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.aJ = z;
        }
    }
}
