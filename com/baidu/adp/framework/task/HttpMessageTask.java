package com.baidu.adp.framework.task;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.nb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class HttpMessageTask extends MessageTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nb mConnectTimeOut;
    public boolean mIsImm;
    public HTTP_METHOD mMethod;
    public boolean mNeedGzip;
    public Class<? extends HttpResponsedMessage> mResponsedClass;
    public String mUrl;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class HTTP_METHOD {
        public static final /* synthetic */ HTTP_METHOD[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HTTP_METHOD GET;
        public static final HTTP_METHOD POST;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-623224756, "Lcom/baidu/adp/framework/task/HttpMessageTask$HTTP_METHOD;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-623224756, "Lcom/baidu/adp/framework/task/HttpMessageTask$HTTP_METHOD;");
                    return;
                }
            }
            GET = new HTTP_METHOD("GET", 0);
            HTTP_METHOD http_method = new HTTP_METHOD("POST", 1);
            POST = http_method;
            $VALUES = new HTTP_METHOD[]{GET, http_method};
        }

        public HTTP_METHOD(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HTTP_METHOD valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HTTP_METHOD) Enum.valueOf(HTTP_METHOD.class, str) : (HTTP_METHOD) invokeL.objValue;
        }

        public static HTTP_METHOD[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HTTP_METHOD[]) $VALUES.clone() : (HTTP_METHOD[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpMessageTask(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
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
        this.mConnectTimeOut = null;
        this.mUrl = null;
        this.mMethod = HTTP_METHOD.POST;
        this.mNeedGzip = true;
        this.mIsImm = false;
        this.mUrl = str;
        addProtobufSuffix();
        this.mPriority = 1;
    }

    private void addProtobufSuffix() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || StringUtils.isNull(this.mUrl)) {
            return;
        }
        Uri parse = Uri.parse(this.mUrl);
        if (StringUtils.isNull(parse.getQueryParameter("cmd")) || !StringUtils.isNull(parse.getQueryParameter("format"))) {
            return;
        }
        this.mUrl = parse.buildUpon().appendQueryParameter("format", "protobuf").toString();
    }

    @Override // com.baidu.adp.framework.task.MessageTask
    public boolean checkCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? FrameHelper.b(this.mCmd) : invokeV.booleanValue;
    }

    public nb getConnectTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mConnectTimeOut : (nb) invokeV.objValue;
    }

    public boolean getIsImm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsImm : invokeV.booleanValue;
    }

    public HTTP_METHOD getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mMethod : (HTTP_METHOD) invokeV.objValue;
    }

    public Class<? extends HttpResponsedMessage> getResponsedClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mResponsedClass : (Class) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public boolean isNeedGzip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNeedGzip : invokeV.booleanValue;
    }

    public void setConnectTimeOut(nb nbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nbVar) == null) {
            this.mConnectTimeOut = nbVar;
        }
    }

    public void setIsImm(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mIsImm = z;
        }
    }

    public void setMethod(HTTP_METHOD http_method) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, http_method) == null) {
            this.mMethod = http_method;
        }
    }

    public void setNeedGzip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.mNeedGzip = z;
        }
    }

    public void setResponsedClass(Class<? extends HttpResponsedMessage> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cls) == null) {
            this.mResponsedClass = cls;
        }
    }

    public String setUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String str2 = this.mUrl;
            this.mUrl = str;
            addProtobufSuffix();
            return str2;
        }
        return (String) invokeL.objValue;
    }
}
