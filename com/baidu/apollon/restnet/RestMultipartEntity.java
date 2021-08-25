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
/* loaded from: classes5.dex */
public class RestMultipartEntity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f37883a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ByteArrayOutputStream f37884b;

    /* renamed from: c  reason: collision with root package name */
    public String f37885c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37886d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37887e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f37888f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressListener f37889g;

    /* loaded from: classes5.dex */
    public interface ProgressListener {
        void transferred(long j2, long j3);
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
        f37883a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
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
        this.f37884b = new ByteArrayOutputStream();
        this.f37886d = false;
        this.f37887e = false;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i4 = 0; i4 < 30; i4++) {
            char[] cArr = f37883a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f37885c = sb.toString();
        this.f37888f = ("\r\n--" + this.f37885c + Part.CRLF).getBytes();
    }

    private void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!this.f37886d) {
                this.f37886d = true;
                ByteArrayOutputStream byteArrayOutputStream = this.f37884b;
                byteArrayOutputStream.write(("--" + this.f37885c + Part.CRLF).getBytes());
                return;
            }
            this.f37884b.write(this.f37888f);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f37887e) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.f37884b;
            byteArrayOutputStream.write(("\r\n--" + this.f37885c + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f37887e = true;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37885c : (String) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37884b : (OutputStream) invokeV.objValue;
    }

    public ProgressListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37889g : (ProgressListener) invokeV.objValue;
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (byteArrayOutputStream = this.f37884b) == null) {
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
            return this.f37884b.toByteArray().length;
        }
        return invokeV.longValue;
    }

    public void setProgressListener(ProgressListener progressListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, progressListener) == null) {
            this.f37889g = progressListener;
        }
    }

    public void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, str, str2, z) == null) {
            try {
                e();
                ByteArrayOutputStream byteArrayOutputStream = this.f37884b;
                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
                this.f37884b.write(str2.getBytes());
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
                        ByteArrayOutputStream byteArrayOutputStream = this.f37884b;
                        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                        if (str3 != null) {
                            ByteArrayOutputStream byteArrayOutputStream2 = this.f37884b;
                            byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                        } else {
                            this.f37884b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                        }
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            this.f37884b.write(bArr, 0, read);
                        }
                        if (z) {
                            f();
                        }
                        this.f37884b.flush();
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

    /* loaded from: classes5.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ProgressListener f37890a;

        /* renamed from: b  reason: collision with root package name */
        public final long f37891b;

        /* renamed from: c  reason: collision with root package name */
        public long f37892c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j2, OutputStream outputStream, ProgressListener progressListener) {
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
            this.f37891b = j2;
            this.f37892c = 0L;
            this.f37890a = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                long j2 = this.f37892c + i3;
                this.f37892c = j2;
                ProgressListener progressListener = this.f37890a;
                if (progressListener != null) {
                    progressListener.transferred(j2, this.f37891b);
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                ((FilterOutputStream) this).out.write(i2);
                long j2 = this.f37892c + 1;
                this.f37892c = j2;
                ProgressListener progressListener = this.f37890a;
                if (progressListener != null) {
                    progressListener.transferred(j2, this.f37891b);
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
            a aVar = new a(d(), outputStream, this.f37889g);
            aVar.write(this.f37884b.toByteArray());
            aVar.close();
        }
    }
}
