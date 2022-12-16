package com.baidu.searchbox.network.outback.support.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.base.AbstractHttpManager;
import com.baidu.searchbox.network.outback.support.request.DeleteRequest;
import com.baidu.searchbox.network.outback.support.request.HeadRequest;
import com.baidu.searchbox.network.outback.support.request.PatchRequest;
import com.baidu.searchbox.network.outback.support.request.PostBodyRequest;
import com.baidu.searchbox.network.outback.support.request.PostFileRequest;
import com.baidu.searchbox.network.outback.support.request.PostMultiPartFormRequest;
import com.baidu.searchbox.network.outback.support.request.PutBodyRequest;
import com.baidu.searchbox.network.outback.support.request.PutFormRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HttpRequestCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AbstractHttpManager httpManager;

    public HttpRequestCompat(AbstractHttpManager abstractHttpManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {abstractHttpManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.httpManager = abstractHttpManager;
    }

    public DeleteRequest.DeleteRequestBuilder deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new DeleteRequest.DeleteRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (DeleteRequest.DeleteRequestBuilder) invokeV.objValue;
    }

    public HeadRequest.HeadRequestBuilder headRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new HeadRequest.HeadRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (HeadRequest.HeadRequestBuilder) invokeV.objValue;
    }

    public PatchRequest.PatchRequestBuilder patchRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new PatchRequest.PatchRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PatchRequest.PatchRequestBuilder) invokeV.objValue;
    }

    public PostFileRequest.PostFileRequestBuilder postFileRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new PostFileRequest.PostFileRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PostFileRequest.PostFileRequestBuilder) invokeV.objValue;
    }

    public PostMultiPartFormRequest.PostMultiPartFormRequestBuilder postMultiPartRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new PostMultiPartFormRequest.PostMultiPartFormRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) invokeV.objValue;
    }

    public PostBodyRequest.PostBodyRequestBuilder postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new PostBodyRequest.PostBodyRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PostBodyRequest.PostBodyRequestBuilder) invokeV.objValue;
    }

    public PutFormRequest.PutFormRequestBuilder putFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new PutFormRequest.PutFormRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PutFormRequest.PutFormRequestBuilder) invokeV.objValue;
    }

    public PutBodyRequest.PutBodyRequestBuilder putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new PutBodyRequest.PutBodyRequestBuilder(this.httpManager.getCallFactoryMap());
        }
        return (PutBodyRequest.PutBodyRequestBuilder) invokeV.objValue;
    }
}
