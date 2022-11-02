package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public class PostMultiPartFormRequest extends HttpParaRequest<PostMultiPartFormRequestBuilder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PostBytes> bytes;
    public List<PostFile> files;

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
    public static class PostMultiPartFormRequestBuilder extends HttpRequestParasBuilder<PostMultiPartFormRequestBuilder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PostBytes> postBytes;
        public List<PostFile> postFiles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostMultiPartFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {abstractHttpManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AbstractHttpManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest) {
            this(postMultiPartFormRequest, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postMultiPartFormRequest};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((PostMultiPartFormRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest, AbstractHttpManager abstractHttpManager) {
            super(postMultiPartFormRequest, abstractHttpManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postMultiPartFormRequest, abstractHttpManager};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpParaRequest) objArr2[0], (AbstractHttpManager) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            if (postMultiPartFormRequest.files != null) {
                this.postFiles = new ArrayList(postMultiPartFormRequest.files);
            }
            if (postMultiPartFormRequest.bytes != null) {
                this.postBytes = new ArrayList(postMultiPartFormRequest.bytes);
            }
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

        public PostMultiPartFormRequestBuilder bytes(List<PostBytes> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, list)) == null) {
                this.postBytes = new ArrayList(list);
                return this;
            }
            return (PostMultiPartFormRequestBuilder) invokeL.objValue;
        }

        public PostMultiPartFormRequestBuilder files(List<PostFile> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, list)) == null) {
                this.postFiles = new ArrayList(list);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostMultiPartFormRequest build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return new PostMultiPartFormRequest(this);
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
                super((HttpRequestParasBuilder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpParaRequest
    public void initExtraHttpRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, postMultiPartFormRequestBuilder) == null) {
            super.initExtraHttpRequest((PostMultiPartFormRequest) postMultiPartFormRequestBuilder);
            if (postMultiPartFormRequestBuilder.postFiles != null) {
                this.files = Util.immutableList(postMultiPartFormRequestBuilder.postFiles);
            }
            if (postMultiPartFormRequestBuilder.postBytes != null) {
                this.bytes = Util.immutableList(postMultiPartFormRequestBuilder.postBytes);
            }
        }
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestBody)) == null) {
            return this.okRequestBuilder.post(requestBody).build();
        }
        return (Request) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        InterceptResult invokeV;
        List<PostFile> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedHashMap<String, String> linkedHashMap = this.params;
            if ((linkedHashMap != null && !linkedHashMap.isEmpty()) || ((list = this.files) != null && list.size() > 0)) {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                builder.setType(MultipartBody.FORM);
                LinkedHashMap<String, String> linkedHashMap2 = this.params;
                if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.params.entrySet()) {
                        builder.addFormDataPart(entry.getKey(), entry.getValue());
                    }
                }
                List<PostFile> list2 = this.files;
                if (list2 != null && list2.size() > 0) {
                    for (PostFile postFile : this.files) {
                        builder.addFormDataPart(postFile.key, postFile.fileName, RequestBody.create(MediaType.parse(postFile.contentType), postFile.file));
                    }
                }
                List<PostBytes> list3 = this.bytes;
                if (list3 != null && list3.size() > 0) {
                    for (PostBytes postBytes : this.bytes) {
                        builder.addFormDataPart(postBytes.key, postBytes.fileName, RequestBody.create(MediaType.parse(postBytes.contentType), postBytes.bytes));
                    }
                }
                return builder.build();
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }
        return (RequestBody) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, abstractHttpManager)) == null) {
            return new PostMultiPartFormRequestBuilder(this, abstractHttpManager);
        }
        return (PostMultiPartFormRequestBuilder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new PostMultiPartFormRequestBuilder(this);
        }
        return (PostMultiPartFormRequestBuilder) invokeV.objValue;
    }
}
