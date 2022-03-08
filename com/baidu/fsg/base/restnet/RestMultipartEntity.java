package com.baidu.fsg.base.restnet;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes4.dex */
public class RestMultipartEntity {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] MULTIPART_CHARS;
    public transient /* synthetic */ FieldHolder $fh;
    public ProgressListener listener;
    public String mBoundary;
    public byte[] mBoundaryLineBytes;
    public boolean mIsSetFirst;
    public boolean mIsSetLast;
    public ByteArrayOutputStream mOut;

    /* loaded from: classes4.dex */
    public static class CountingOutputStream extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long length;
        public final ProgressListener listener;
        public long transferred;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountingOutputStream(long j2, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), outputStream, progressListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.length = j2;
            this.transferred = 0L;
            this.listener = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                ((FilterOutputStream) this).out.write(i2);
                long j2 = this.transferred + 1;
                this.transferred = j2;
                ProgressListener progressListener = this.listener;
                if (progressListener != null) {
                    progressListener.transferred(j2, this.length);
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                long j2 = this.transferred + i3;
                this.transferred = j2;
                ProgressListener progressListener = this.listener;
                if (progressListener != null) {
                    progressListener.transferred(j2, this.length);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface ProgressListener {
        void transferred(long j2, long j3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(650257441, "Lcom/baidu/fsg/base/restnet/RestMultipartEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(650257441, "Lcom/baidu/fsg/base/restnet/RestMultipartEntity;");
                return;
            }
        }
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public RestMultipartEntity() {
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
        this.mOut = new ByteArrayOutputStream();
        this.mIsSetFirst = false;
        this.mIsSetLast = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i4 = 0; i4 < 30; i4++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.mBoundary = sb.toString();
        this.mBoundaryLineBytes = ("\r\n--" + this.mBoundary + "\r\n").getBytes();
    }

    private void writeBoundaryLine() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (this.mIsSetFirst) {
                this.mOut.write(this.mBoundaryLineBytes);
                return;
            }
            this.mIsSetFirst = true;
            ByteArrayOutputStream byteArrayOutputStream = this.mOut;
            byteArrayOutputStream.write(("--" + this.mBoundary + "\r\n").getBytes());
        }
    }

    private void writeLastBoundaryIfNeeds() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mIsSetLast) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.mOut;
            StringBuilder sb = new StringBuilder();
            sb.append("\r\n--");
            sb.append(this.mBoundary);
            sb.append("--\r\n");
            byteArrayOutputStream.write(sb.toString().getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.mIsSetLast = true;
    }

    public void addPart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            addPart(str, str2, false);
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, inputStream, str3) == null) {
            addPart(str, str2, inputStream, str3, false);
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, inputStream, str3, Boolean.valueOf(z)}) == null) {
            try {
                try {
                    writeBoundaryLine();
                    ByteArrayOutputStream byteArrayOutputStream = this.mOut;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Content-Disposition: form-data; name=\"");
                    sb.append(str);
                    sb.append("\"; filename=\"");
                    sb.append(str2);
                    sb.append("\"\r\n");
                    byteArrayOutputStream.write(sb.toString().getBytes());
                    if (str3 != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = this.mOut;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Part.CONTENT_TYPE);
                        sb2.append(str3);
                        sb2.append("\r\n\r\n");
                        byteArrayOutputStream2.write(sb2.toString().getBytes());
                    } else {
                        this.mOut.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        this.mOut.write(bArr, 0, read);
                    }
                    if (z) {
                        writeLastBoundaryIfNeeds();
                    }
                    this.mOut.flush();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
    }

    public void addPart(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            try {
                writeBoundaryLine();
                ByteArrayOutputStream byteArrayOutputStream = this.mOut;
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Disposition: form-data; name=\"");
                sb.append(str);
                sb.append("\"\r\n\r\n");
                byteArrayOutputStream.write(sb.toString().getBytes());
                this.mOut.write(str2.getBytes());
                if (z) {
                    writeLastBoundaryIfNeeds();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (byteArrayOutputStream = this.mOut) == null) {
            return;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public String getBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBoundary : (String) invokeV.objValue;
    }

    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            writeLastBoundaryIfNeeds();
            return this.mOut.toByteArray().length;
        }
        return invokeV.longValue;
    }

    public OutputStream getOutputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mOut : (OutputStream) invokeV.objValue;
    }

    public ProgressListener getProgressListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.listener : (ProgressListener) invokeV.objValue;
    }

    public void setProgressListener(ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, progressListener) == null) {
            this.listener = progressListener;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048586, this, outputStream) != null) {
            return;
        }
        writeLastBoundaryIfNeeds();
        CountingOutputStream countingOutputStream = new CountingOutputStream(getContentLength(), outputStream, this.listener);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.mOut.toByteArray());
        byte[] bArr = new byte[8192];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                countingOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
            countingOutputStream.write(bArr, 0, read);
        }
    }
}
