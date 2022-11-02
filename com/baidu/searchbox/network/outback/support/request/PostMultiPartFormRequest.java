package com.baidu.searchbox.network.outback.support.request;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.support.request.body.MultipartBody;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class PostMultiPartFormRequest extends Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.network.outback.support.request.PostMultiPartFormRequest$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class PostBytes {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] bytes;
        public String contentType;
        public String fileName;
        public String key;

        public PostBytes(String str, String str2, String str3, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = str;
            this.fileName = str2;
            this.bytes = bArr;
            if (TextUtils.isEmpty(str3)) {
                this.contentType = PostFile.guessMimeType(str2);
            } else {
                this.contentType = str3;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PostBytes(String str, String str2, byte[] bArr) {
            this(str, str2, null, bArr);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (byte[]) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PostFile {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String contentType;
        public File file;
        public String fileName;
        public String key;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PostFile(String str, String str2, File file) {
            this(str, str2, null, file);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], (File) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public PostFile(String str, String str2, String str3, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, file};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.key = str;
            this.fileName = str2;
            this.file = file;
            if (TextUtils.isEmpty(str3)) {
                this.contentType = guessMimeType(str2);
            } else {
                this.contentType = str3;
            }
        }

        public static String guessMimeType(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
                if (TextUtils.isEmpty(contentTypeFor)) {
                    return "application/octet-stream";
                }
                return contentTypeFor;
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class PostMultiPartFormRequestBuilder extends Request.Builder<PostMultiPartFormRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinkedHashMap<String, String> params;
        public List<PostBytes> postBytes;
        public List<PostFile> postFiles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest) {
            super(postMultiPartFormRequest);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postMultiPartFormRequest};
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
            this.params = new LinkedHashMap<>();
            this.postFiles = new ArrayList();
            this.postBytes = new ArrayList();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostMultiPartFormRequestBuilder(Map<String, CallFactory> map) {
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
            this.params = new LinkedHashMap<>();
        }

        private RequestBody buildRequestBody() {
            InterceptResult invokeV;
            List<PostFile> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                LinkedHashMap<String, String> linkedHashMap = this.params;
                if ((linkedHashMap != null && !linkedHashMap.isEmpty()) || ((list = this.postFiles) != null && list.size() > 0)) {
                    MultipartBody.Builder builder = new MultipartBody.Builder();
                    builder.setType(MultipartBody.FORM);
                    LinkedHashMap<String, String> linkedHashMap2 = this.params;
                    if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                        for (Map.Entry<String, String> entry : this.params.entrySet()) {
                            builder.addFormDataPart(entry.getKey(), entry.getValue());
                        }
                    }
                    List<PostFile> list2 = this.postFiles;
                    if (list2 != null && list2.size() > 0) {
                        for (PostFile postFile : this.postFiles) {
                            builder.addFormDataPart(postFile.key, postFile.fileName, RequestBody.create(MediaType.parse(postFile.contentType), postFile.file));
                        }
                    }
                    List<PostBytes> list3 = this.postBytes;
                    if (list3 != null && list3.size() > 0) {
                        for (PostBytes postBytes : this.postBytes) {
                            builder.addFormDataPart(postBytes.key, postBytes.fileName, RequestBody.create(MediaType.parse(postBytes.contentType), postBytes.bytes));
                        }
                    }
                    return builder.build();
                }
                return RequestBody.create((MediaType) null, new byte[0]);
            }
            return (RequestBody) invokeV.objValue;
        }

        public PostMultiPartFormRequestBuilder addBytes(PostBytes postBytes) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, postBytes)) == null) {
                if (this.postBytes == null) {
                    this.postBytes = new ArrayList();
                }
                this.postBytes.add(postBytes);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFile(PostFile postFile) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, postFile)) == null) {
                if (this.postFiles == null) {
                    this.postFiles = new ArrayList();
                }
                this.postFiles.add(postFile);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFiles(List<PostFile> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
                List<PostFile> list2 = this.postFiles;
                if (list2 == null) {
                    this.postFiles = new ArrayList(list);
                } else {
                    list2.addAll(list);
                }
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder addParams(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, map)) == null) {
                this.params.putAll(map);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder bytes(List<PostBytes> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
                this.postBytes = new ArrayList(list);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder files(List<PostFile> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, list)) == null) {
                this.postFiles = new ArrayList(list);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder params(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, map)) == null) {
                this.params = new LinkedHashMap<>(map);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder removeParam(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.params.remove(str);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder removeParams(List<String> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, list)) == null) {
                if (list != null && list.size() > 0) {
                    for (String str : list) {
                        this.params.remove(str);
                    }
                }
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, String str3, byte[] bArr) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, bArr)) == null) {
                return addBytes(new PostBytes(str, str2, str3, bArr));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, File file) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, str2, str3, file)) == null) {
                return addFile(new PostFile(str, str2, str3, file));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, byte[] bArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, bArr)) == null) {
                return addBytes(new PostBytes(str, str2, bArr));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, File file) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, file)) == null) {
                return addFile(new PostFile(str, str2, file));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addBytes(List<PostBytes> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                List<PostBytes> list2 = this.postBytes;
                if (list2 == null) {
                    this.postBytes = new ArrayList(list);
                } else {
                    list2.addAll(list);
                }
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, str3)) == null) {
                return addFile(new PostFile(str, str2, new File(str3)));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4)) == null) {
                return addFile(new PostFile(str, str2, str3, new File(str4)));
            }
            return (PostMultiPartFormRequestBuilder) invokeLLLL.objValue;
        }

        public PostMultiPartFormRequestBuilder addParam(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
                this.params.put(str, str2);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostMultiPartFormRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return new PostMultiPartFormRequest(post(buildRequestBody()), null);
            }
            return (PostMultiPartFormRequest) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostMultiPartFormRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        super(postMultiPartFormRequestBuilder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {postMultiPartFormRequestBuilder};
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

    public /* synthetic */ PostMultiPartFormRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder, AnonymousClass1 anonymousClass1) {
        this(postMultiPartFormRequestBuilder);
    }
}
