package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class FormBody extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType CONTENT_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<String> encodedNames;
    public final List<String> encodedValues;

    /* loaded from: classes2.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Charset charset;
        public final List<String> names;
        public final List<String> values;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    this((Charset) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder add(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                if (str != null) {
                    if (str2 != null) {
                        this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                        this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                        return this;
                    }
                    throw new NullPointerException("value == null");
                }
                throw new NullPointerException("name == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder addEncoded(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                if (str != null) {
                    if (str2 != null) {
                        this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                        this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                        return this;
                    }
                    throw new NullPointerException("value == null");
                }
                throw new NullPointerException("name == null");
            }
            return (Builder) invokeLL.objValue;
        }

        public FormBody build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new FormBody(this.names, this.values) : (FormBody) invokeV.objValue;
        }

        public Builder(Charset charset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charset};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334725242, "Lcom/baidu/searchbox/network/outback/core/FormBody;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334725242, "Lcom/baidu/searchbox/network/outback/core/FormBody;");
                return;
            }
        }
        CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    }

    public FormBody(List<String> list, List<String> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(@Nullable OutputStream outputStream, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, outputStream, z)) == null) {
            if (z) {
                outputStream = new ByteArrayOutputStream();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int size = this.encodedNames.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    bufferedOutputStream.write(38);
                }
                Util.writeUtf8(bufferedOutputStream, this.encodedNames.get(i));
                bufferedOutputStream.write(61);
                Util.writeUtf8(bufferedOutputStream, this.encodedValues.get(i));
            }
            bufferedOutputStream.flush();
            if (z) {
                return ((ByteArrayOutputStream) outputStream).size();
            }
            return 0L;
        }
        return invokeLZ.longValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return writeOrCountBytes(null, true);
            } catch (IOException unused) {
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CONTENT_TYPE : (MediaType) invokeV.objValue;
    }

    public String encodedName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.encodedNames.get(i) : (String) invokeI.objValue;
    }

    public String encodedValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.encodedValues.get(i) : (String) invokeI.objValue;
    }

    public String name(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? HttpUrl.percentDecode(encodedName(i), true) : (String) invokeI.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.encodedNames.size() : invokeV.intValue;
    }

    public String value(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? HttpUrl.percentDecode(encodedValue(i), true) : (String) invokeI.objValue;
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, outputStream) == null) {
            writeOrCountBytes(outputStream, false);
        }
    }
}
