package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
public class MethodInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String className;
    public final long id;
    public String mFullName;
    public MethodProfileData mProfileData;
    public String mShortName;
    public final String methodName;
    public final String signature;
    public final int srcLineNumber;
    public final String srcPath;

    public MethodInfo(long j, String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, str2, str3, str4, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.id = j;
        this.className = str;
        this.methodName = str2;
        this.signature = str3;
        this.srcPath = str4;
        this.srcLineNumber = i;
    }

    private String getUnqualifiedClassName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String str = this.className;
            int lastIndexOf = str.lastIndexOf(47);
            return lastIndexOf > 0 ? str.substring(lastIndexOf + 1) : str;
        }
        return (String) invokeV.objValue;
    }

    public String getFullName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mFullName == null) {
                this.mFullName = String.format(Locale.US, "%s.%s: %s", this.className, this.methodName, this.signature);
            }
            return this.mFullName;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public MethodProfileData getProfileData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mProfileData : (MethodProfileData) invokeV.objValue;
    }

    public String getShortName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mShortName == null) {
                this.mShortName = String.format(Locale.US, "%s.%s", getUnqualifiedClassName(), this.methodName);
            }
            return this.mShortName;
        }
        return (String) invokeV.objValue;
    }

    public void setProfileData(@NonNull MethodProfileData methodProfileData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, methodProfileData) == null) {
            this.mProfileData = methodProfileData;
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.className + "." + this.methodName + this.signature;
        }
        return (String) invokeV.objValue;
    }
}
