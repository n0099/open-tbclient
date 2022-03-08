package com.baidu.searchbox.network.outback.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostStringRequest extends Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.network.outback.request.PostStringRequest$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class PostStringRequestBuilder extends Request.Builder<PostStringRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public static final MediaType MEDIA_TYPE_PLAIN;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public MediaType mediaType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1929671485, "Lcom/baidu/searchbox/network/outback/request/PostStringRequest$PostStringRequestBuilder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1929671485, "Lcom/baidu/searchbox/network/outback/request/PostStringRequest$PostStringRequestBuilder;");
                    return;
                }
            }
            MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostStringRequestBuilder(Map<String, CallFactory> map) {
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

        public PostStringRequestBuilder content(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.content = str;
                return this;
            }
            return (PostStringRequestBuilder) invokeL.objValue;
        }

        public PostStringRequestBuilder mediaType(MediaType mediaType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaType)) == null) {
                this.mediaType = mediaType;
                return this;
            }
            return (PostStringRequestBuilder) invokeL.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostStringRequestBuilder(PostStringRequest postStringRequest) {
            super(postStringRequest);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postStringRequest};
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
        public PostStringRequest build() {
            InterceptResult invokeV;
            RequestBody requestBody;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mediaType == null) {
                    this.mediaType = MEDIA_TYPE_PLAIN;
                }
                if (!Util.isTextEmpty(this.content)) {
                    requestBody = RequestBody.create(this.mediaType, this.content);
                } else {
                    requestBody = this.body;
                    if (requestBody == null) {
                        requestBody = RequestBody.create((MediaType) null, new byte[0]);
                    }
                }
                return new PostStringRequest(post(requestBody), null);
            }
            return (PostStringRequest) invokeV.objValue;
        }

        public PostStringRequestBuilder mediaType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.mediaType = MediaType.parse(str);
                return this;
            }
            return (PostStringRequestBuilder) invokeL.objValue;
        }
    }

    public /* synthetic */ PostStringRequest(PostStringRequestBuilder postStringRequestBuilder, AnonymousClass1 anonymousClass1) {
        this(postStringRequestBuilder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostStringRequest(PostStringRequestBuilder postStringRequestBuilder) {
        super(postStringRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postStringRequestBuilder};
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
