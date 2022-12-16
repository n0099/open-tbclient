package com.baidu.searchbox.retrieve.upload;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FetchTaskObj {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchTaskObj";
    public transient /* synthetic */ FieldHolder $fh;
    public String mFileID;
    public String mFileMeta;
    public String mJobID;
    public String mOrigin;
    public String mStatus;
    public String mType;
    public String mValue;
    public String mVersion;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(614654382, "Lcom/baidu/searchbox/retrieve/upload/FetchTaskObj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(614654382, "Lcom/baidu/searchbox/retrieve/upload/FetchTaskObj;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public String getFileID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mFileID;
        }
        return (String) invokeV.objValue;
    }

    public String getFileMeta() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mFileMeta;
        }
        return (String) invokeV.objValue;
    }

    public String getJobID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mJobID;
        }
        return (String) invokeV.objValue;
    }

    public String getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mOrigin;
        }
        return (String) invokeV.objValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mStatus;
        }
        return (String) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public String getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mValue;
        }
        return (String) invokeV.objValue;
    }

    public String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mVersion;
        }
        return (String) invokeV.objValue;
    }

    public FetchTaskObj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, str5, str6, str7};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mType = str;
        this.mValue = str2;
        this.mJobID = str3;
        this.mVersion = str4;
        this.mStatus = str5;
        this.mOrigin = str6;
        this.mFileMeta = str7;
    }

    public void setFileID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mFileID = str;
        }
    }

    public void setFileMeta(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mFileMeta = str;
        }
    }

    public void setJobID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mJobID = str;
        }
    }

    public void setOrigin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mOrigin = str;
        }
    }

    public void setStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.mStatus = str;
        }
    }

    public void setType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.mType = str;
        }
    }

    public void setValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mValue = str;
        }
    }

    public void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mVersion = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "FetchTaskObj{mType='" + this.mType + "', mValue='" + this.mValue + "', mJobID='" + this.mJobID + "', mVersion='" + this.mVersion + "', mStatus='" + this.mStatus + "', mOrigin='" + this.mOrigin + "', mFileMeta='" + this.mFileMeta + "'}";
        }
        return (String) invokeV.objValue;
    }
}
