package com.baidu.searchbox.http.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class PostByteRequest extends HttpRequest<PostByteRequestBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType MEDIA_TYPE_STREAM;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] content;
    public MediaType mediaType;

    /* loaded from: classes3.dex */
    public static class PostByteRequestBuilder extends HttpRequestBuilder<PostByteRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] contentBuffer;
        public MediaType mediaType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostByteRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractHttpManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AbstractHttpManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public PostByteRequestBuilder content(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                this.contentBuffer = bArr;
                return this;
            }
            return (PostByteRequestBuilder) invokeL.objValue;
        }

        public PostByteRequestBuilder mediaType(MediaType mediaType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaType)) == null) {
                this.mediaType = mediaType;
                return this;
            }
            return (PostByteRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PostByteRequestBuilder(PostByteRequest postByteRequest) {
            this(postByteRequest, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postByteRequest};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((PostByteRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostByteRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new PostByteRequest(this) : (PostByteRequest) invokeV.objValue;
        }

        public PostByteRequestBuilder mediaType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.mediaType = MediaType.parse(str);
                return this;
            }
            return (PostByteRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostByteRequestBuilder(PostByteRequest postByteRequest, AbstractHttpManager abstractHttpManager) {
            super(postByteRequest, abstractHttpManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postByteRequest, abstractHttpManager};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.contentBuffer = postByteRequest.content;
            this.mediaType = postByteRequest.mediaType;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1232159745, "Lcom/baidu/searchbox/http/request/PostByteRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1232159745, "Lcom/baidu/searchbox/http/request/PostByteRequest;");
                return;
            }
        }
        MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostByteRequest(PostByteRequestBuilder postByteRequestBuilder) {
        super(postByteRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postByteRequestBuilder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((HttpRequestBuilder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestBody)) == null) ? this.okRequestBuilder.post(requestBody).build() : (Request) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] bArr = this.content;
            if (bArr != null && bArr.length > 0) {
                return RequestBody.create(this.mediaType, bArr);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostByteRequestBuilder postByteRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postByteRequestBuilder) == null) {
            this.content = postByteRequestBuilder.contentBuffer;
            MediaType mediaType = postByteRequestBuilder.mediaType;
            this.mediaType = mediaType;
            if (mediaType == null) {
                this.mediaType = MEDIA_TYPE_STREAM;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostByteRequestBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new PostByteRequestBuilder(this) : (PostByteRequestBuilder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostByteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, abstractHttpManager)) == null) ? new PostByteRequestBuilder(this, abstractHttpManager) : (PostByteRequestBuilder) invokeL.objValue;
    }
}
