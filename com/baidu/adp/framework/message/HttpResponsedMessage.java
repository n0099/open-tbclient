package com.baidu.adp.framework.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pf;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class HttpResponsedMessage extends ResponsedMessage<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String contentLength;
    public String contentType;
    public Map<String, List<String>> mHeader;
    public int mStatusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpResponsedMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStatusCode = -1;
        this.mHeader = null;
        this.contentType = "";
        this.contentLength = "";
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i, T t) throws Exception;

    public String getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.contentLength : (String) invokeV.objValue;
    }

    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.contentType : (String) invokeV.objValue;
    }

    public synchronized List<String> getHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                if (this.mHeader == null || !this.mHeader.containsKey(str)) {
                    return null;
                }
                return Collections.unmodifiableList(this.mHeader.get(str));
            }
        }
        return (List) invokeL.objValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStatusCode : invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !isSuccess() : invokeV.booleanValue;
    }

    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.mStatusCode;
            return i == 200 || i / 100 == 3;
        }
        return invokeV.booleanValue;
    }

    public void logStatInBackground(int i, pf pfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, pfVar) == null) {
        }
    }

    public void setContentLength(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.contentLength = str;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.contentType = str;
        }
    }

    public synchronized void setHeader(Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            synchronized (this) {
                this.mHeader = map;
            }
        }
    }

    public void setStatusCode(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            this.mStatusCode = i;
            if (isSuccess()) {
                return;
            }
            setError(-1);
            setErrorString(str);
        }
    }
}
