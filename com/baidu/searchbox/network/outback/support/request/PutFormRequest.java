package com.baidu.searchbox.network.outback.support.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.FormBody;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class PutFormRequest extends Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.network.outback.support.request.PutFormRequest$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class PutFormRequestBuilder extends Request.Builder<PutFormRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FormBody.Builder bodyBuilder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PutFormRequestBuilder(Map<String, CallFactory> map) {
            super(map);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Map) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.bodyBuilder = new FormBody.Builder();
        }

        public PutFormRequestBuilder addParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.bodyBuilder.add(str, str2);
                return this;
            }
            return (PutFormRequestBuilder) invokeLL.objValue;
        }

        public PutFormRequestBuilder addParams(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
                for (String str : map.keySet()) {
                    addParam(str, map.get(str));
                }
                return this;
            }
            return (PutFormRequestBuilder) invokeL.objValue;
        }

        public PutFormRequestBuilder params(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
                this.bodyBuilder = new FormBody.Builder();
                for (String str : map.keySet()) {
                    this.bodyBuilder.add(str, map.get(str));
                }
                return this;
            }
            return (PutFormRequestBuilder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PutFormRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new PutFormRequest(put(this.bodyBuilder.build()), null) : (PutFormRequest) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PutFormRequestBuilder(PutFormRequest putFormRequest) {
            super(putFormRequest);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {putFormRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Request) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.bodyBuilder = new FormBody.Builder();
        }
    }

    public /* synthetic */ PutFormRequest(PutFormRequestBuilder putFormRequestBuilder, AnonymousClass1 anonymousClass1) {
        this(putFormRequestBuilder);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PutFormRequest(PutFormRequestBuilder putFormRequestBuilder) {
        super(putFormRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {putFormRequestBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Request.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
