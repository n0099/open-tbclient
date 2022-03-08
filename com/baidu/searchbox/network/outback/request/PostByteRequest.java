package com.baidu.searchbox.network.outback.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostByteRequest extends Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.network.outback.request.PostByteRequest$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class PostByteRequestBuilder extends Request.Builder<PostByteRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public static final MediaType MEDIA_TYPE_STREAM;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] contentBuffer;
        public MediaType mediaType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1523225365, "Lcom/baidu/searchbox/network/outback/request/PostByteRequest$PostByteRequestBuilder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1523225365, "Lcom/baidu/searchbox/network/outback/request/PostByteRequest$PostByteRequestBuilder;");
                    return;
                }
            }
            MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostByteRequestBuilder(Map<String, CallFactory> map) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaType)) == null) {
                this.mediaType = mediaType;
                return this;
            }
            return (PostByteRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostByteRequestBuilder(PostByteRequest postByteRequest) {
            super(postByteRequest);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postByteRequest};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Request) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostByteRequest build() {
            InterceptResult invokeV;
            RequestBody requestBody;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                byte[] bArr = this.contentBuffer;
                if (bArr != null && bArr.length > 0) {
                    if (this.mediaType == null) {
                        this.mediaType = MEDIA_TYPE_STREAM;
                    }
                    requestBody = RequestBody.create(this.mediaType, this.contentBuffer);
                } else {
                    requestBody = this.body;
                    if (requestBody == null) {
                        requestBody = RequestBody.create((MediaType) null, new byte[0]);
                    }
                }
                return new PostByteRequest(post(requestBody), null);
            }
            return (PostByteRequest) invokeV.objValue;
        }

        public PostByteRequestBuilder mediaType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mediaType = MediaType.parse(str);
                return this;
            }
            return (PostByteRequestBuilder) invokeL.objValue;
        }
    }

    public /* synthetic */ PostByteRequest(PostByteRequestBuilder postByteRequestBuilder, AnonymousClass1 anonymousClass1) {
        this(postByteRequestBuilder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostByteRequest(PostByteRequestBuilder postByteRequestBuilder) {
        super(postByteRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postByteRequestBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Request.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
