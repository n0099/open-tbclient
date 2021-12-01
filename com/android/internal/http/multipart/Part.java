package com.android.internal.http.multipart;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public abstract class Part {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final String BOUNDARY = "----------------314159265358979323846";
    @Deprecated
    public static final byte[] BOUNDARY_BYTES = null;
    public static final String CHARSET = "; charset=";
    public static final byte[] CHARSET_BYTES = null;
    public static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    public static final byte[] CONTENT_DISPOSITION_BYTES = null;
    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    public static final byte[] CONTENT_TRANSFER_ENCODING_BYTES = null;
    public static final String CONTENT_TYPE = "Content-Type: ";
    public static final byte[] CONTENT_TYPE_BYTES = null;
    public static final String CRLF = "\r\n";
    public static final byte[] CRLF_BYTES = null;
    public static final String EXTRA = "--";
    public static final byte[] EXTRA_BYTES = null;
    public static final String QUOTE = "\"";
    public static final byte[] QUOTE_BYTES = null;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(445654902, "Lcom/android/internal/http/multipart/Part;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(445654902, "Lcom/android/internal/http/multipart/Part;");
        }
    }

    public Part() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static String getBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public static long getLengthOfParts(Part[] partArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, partArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.longValue;
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, outputStream, partArr) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    public byte[] getPartBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (byte[]) invokeV.objValue;
    }

    public abstract String getTransferEncoding();

    public boolean isRepeatable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.booleanValue;
    }

    public long length() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeV.longValue;
    }

    public abstract long lengthOfData() throws IOException;

    public void send(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void sendContentTypeHeader(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract void sendData(OutputStream outputStream) throws IOException;

    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void sendEnd(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void sendEndOfHeader(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void sendStart(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public void sendTransferEncodingHeader(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, outputStream) == null) {
            throw new RuntimeException("Stub!");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (String) invokeV.objValue;
    }

    public static long getLengthOfParts(Part[] partArr, byte[] bArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, partArr, bArr)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.longValue;
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, outputStream, partArr, bArr) == null) {
            throw new RuntimeException("Stub!");
        }
    }
}
