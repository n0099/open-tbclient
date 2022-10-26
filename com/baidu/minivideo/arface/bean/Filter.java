package com.baidu.minivideo.arface.bean;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class Filter extends BaseBeautyItem {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATA_TYPE_DU_SINGLE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int mDataType;
    public File mFile;
    public float mLevel;
    public String mParam;

    public Filter() {
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

    public int getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDataType;
        }
        return invokeV.intValue;
    }

    public File getFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFile;
        }
        return (File) invokeV.objValue;
    }

    public float getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLevel;
        }
        return invokeV.floatValue;
    }

    public String getParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mParam;
        }
        return (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            File file = this.mFile;
            if (file != null) {
                return file.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getInfo() {
        InterceptResult invokeV;
        Object absoluteFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("param:");
            sb.append(this.mParam);
            sb.append(", type:");
            sb.append(this.mDataType);
            sb.append(", level:");
            sb.append(this.mLevel);
            sb.append(", path:");
            File file = this.mFile;
            if (file == null) {
                absoluteFile = StringUtil.NULL_STRING;
            } else {
                absoluteFile = file.getAbsoluteFile();
            }
            sb.append(absoluteFile);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public void setDataType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.mDataType = i;
        }
    }

    public void setFile(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, file) == null) {
            this.mFile = file;
        }
    }

    public void setLevel(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.mLevel = f;
        }
    }

    public void setParam(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mParam = str;
        }
    }
}
