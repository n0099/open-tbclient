package com.baidu.apollon.restnet;

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
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes.dex */
public class RestMultipartEntity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3829a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ByteArrayOutputStream f3830b;

    /* renamed from: c  reason: collision with root package name */
    public String f3831c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3832d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3833e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3834f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressListener f3835g;

    /* loaded from: classes.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(234770980, "Lcom/baidu/apollon/restnet/RestMultipartEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(234770980, "Lcom/baidu/apollon/restnet/RestMultipartEntity;");
                return;
            }
        }
        f3829a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
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
        this.f3830b = new ByteArrayOutputStream();
        this.f3832d = false;
        this.f3833e = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i4 = 0; i4 < 30; i4++) {
            char[] cArr = f3829a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f3831c = sb.toString();
        this.f3834f = ("\r\n--" + this.f3831c + Part.CRLF).getBytes();
    }

    private void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!this.f3832d) {
                this.f3832d = true;
                ByteArrayOutputStream byteArrayOutputStream = this.f3830b;
                byteArrayOutputStream.write(("--" + this.f3831c + Part.CRLF).getBytes());
                return;
            }
            this.f3830b.write(this.f3834f);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f3833e) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.f3830b;
            byteArrayOutputStream.write(("\r\n--" + this.f3831c + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f3833e = true;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3831c : (String) invokeV.objValue;
    }

    public void addPart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            a(str, str2, false);
        }
    }

    public OutputStream b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f3830b : (OutputStream) invokeV.objValue;
    }

    public ProgressListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3835g : (ProgressListener) invokeV.objValue;
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (byteArrayOutputStream = this.f3830b) == null) {
            return;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            f();
            return this.f3830b.toByteArray().length;
        }
        return invokeV.longValue;
    }

    public void setProgressListener(ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, progressListener) == null) {
            this.f3835g = progressListener;
        }
    }

    public void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            try {
                e();
                ByteArrayOutputStream byteArrayOutputStream = this.f3830b;
                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
                this.f3830b.write(str2.getBytes());
                if (z) {
                    f();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, inputStream, str3, Boolean.valueOf(z)}) == null) {
            try {
                try {
                    try {
                        e();
                        ByteArrayOutputStream byteArrayOutputStream = this.f3830b;
                        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                        if (str3 != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = this.f3830b;
                            byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                        } else {
                            this.f3830b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                        }
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            this.f3830b.write(bArr, 0, read);
                        }
                        if (z) {
                            f();
                        }
                        this.f3830b.flush();
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                inputStream.close();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ProgressListener f3836a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3837b;

        /* renamed from: c  reason: collision with root package name */
        public long f3838c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), outputStream, progressListener};
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
            this.f3837b = j;
            this.f3838c = 0L;
            this.f3836a = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                long j = this.f3838c + i3;
                this.f3838c = j;
                ProgressListener progressListener = this.f3836a;
                if (progressListener != null) {
                    progressListener.transferred(j, this.f3837b);
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                ((FilterOutputStream) this).out.write(i2);
                long j = this.f3838c + 1;
                this.f3838c = j;
                ProgressListener progressListener = this.f3836a;
                if (progressListener != null) {
                    progressListener.transferred(j, this.f3837b);
                }
            }
        }
    }

    public void a(String str, String str2, InputStream inputStream, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, inputStream, str3) == null) {
            addPart(str, str2, inputStream, str3, false);
        }
    }

    public void a(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream) == null) {
            f();
            a aVar = new a(d(), outputStream, this.f3835g);
            aVar.write(this.f3830b.toByteArray());
            aVar.close();
        }
    }
}
