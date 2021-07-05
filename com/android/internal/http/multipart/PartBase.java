package com.android.internal.http.multipart;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class PartBase extends Part {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PartBase(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public String getCharSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    @Override // com.android.internal.http.multipart.Part
    public String getTransferEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public void setCharSet(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setTransferEncoding(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
