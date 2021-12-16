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
import java.io.File;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes10.dex */
public class PostFileRequest extends HttpRequest<PostFileRequestBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType MEDIA_TYPE_STREAM;
    public transient /* synthetic */ FieldHolder $fh;
    public File file;
    public MediaType mediaType;

    /* loaded from: classes10.dex */
    public static class PostFileRequestBuilder extends HttpRequestBuilder<PostFileRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public File file;
        public MediaType mediaType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostFileRequestBuilder(AbstractHttpManager abstractHttpManager) {
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

        public PostFileRequestBuilder file(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
                this.file = file;
                return this;
            }
            return (PostFileRequestBuilder) invokeL.objValue;
        }

        public PostFileRequestBuilder mediaType(MediaType mediaType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mediaType)) == null) {
                this.mediaType = mediaType;
                return this;
            }
            return (PostFileRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PostFileRequestBuilder(PostFileRequest postFileRequest) {
            this(postFileRequest, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postFileRequest};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((PostFileRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostFileRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new PostFileRequest(this) : (PostFileRequest) invokeV.objValue;
        }

        public PostFileRequestBuilder file(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.file = new File(str);
                return this;
            }
            return (PostFileRequestBuilder) invokeL.objValue;
        }

        public PostFileRequestBuilder mediaType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mediaType = MediaType.parse(str);
                return this;
            }
            return (PostFileRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostFileRequestBuilder(PostFileRequest postFileRequest, AbstractHttpManager abstractHttpManager) {
            super(postFileRequest, abstractHttpManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postFileRequest, abstractHttpManager};
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
            this.file = postFileRequest.file;
            this.mediaType = postFileRequest.mediaType;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2007049333, "Lcom/baidu/searchbox/http/request/PostFileRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2007049333, "Lcom/baidu/searchbox/http/request/PostFileRequest;");
                return;
            }
        }
        MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFileRequest(PostFileRequestBuilder postFileRequestBuilder) {
        super(postFileRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postFileRequestBuilder};
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
            File file = this.file;
            if (file != null) {
                return RequestBody.create(this.mediaType, file);
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostFileRequestBuilder postFileRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, postFileRequestBuilder) == null) {
            this.file = postFileRequestBuilder.file;
            MediaType mediaType = postFileRequestBuilder.mediaType;
            this.mediaType = mediaType;
            if (mediaType == null) {
                this.mediaType = MEDIA_TYPE_STREAM;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFileRequestBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new PostFileRequestBuilder(this) : (PostFileRequestBuilder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFileRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, abstractHttpManager)) == null) ? new PostFileRequestBuilder(this, abstractHttpManager) : (PostFileRequestBuilder) invokeL.objValue;
    }
}
