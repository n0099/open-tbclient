package com.baidu.searchbox.network.outback.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.FormBody;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostFormRequest extends Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.network.outback.request.PostFormRequest$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class PostFormRequestBuilder extends Request.Builder<PostFormRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FormBody.Builder bodyBuilder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostFormRequestBuilder(Map<String, CallFactory> map) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.bodyBuilder = new FormBody.Builder();
        }

        public PostFormRequestBuilder addParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.bodyBuilder.add(str, str2);
                return this;
            }
            return (PostFormRequestBuilder) invokeLL.objValue;
        }

        public PostFormRequestBuilder addParams(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
                for (String str : map.keySet()) {
                    addParam(str, map.get(str));
                }
                return this;
            }
            return (PostFormRequestBuilder) invokeL.objValue;
        }

        public PostFormRequestBuilder params(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
                this.bodyBuilder = new FormBody.Builder();
                for (String str : map.keySet()) {
                    this.bodyBuilder.add(str, map.get(str));
                }
                return this;
            }
            return (PostFormRequestBuilder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostFormRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                RequestBody requestBody = this.body;
                if (requestBody != null) {
                    int size = ((FormBody) requestBody).size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.bodyBuilder.addEncoded(((FormBody) this.body).name(i2), ((FormBody) this.body).value(i2));
                    }
                }
                return new PostFormRequest(post(this.bodyBuilder.build()), null);
            }
            return (PostFormRequest) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostFormRequestBuilder(PostFormRequest postFormRequest) {
            super(postFormRequest);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postFormRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Request) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bodyBuilder = new FormBody.Builder();
        }
    }

    public /* synthetic */ PostFormRequest(PostFormRequestBuilder postFormRequestBuilder, AnonymousClass1 anonymousClass1) {
        this(postFormRequestBuilder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFormRequest(PostFormRequestBuilder postFormRequestBuilder) {
        super(postFormRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postFormRequestBuilder};
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
