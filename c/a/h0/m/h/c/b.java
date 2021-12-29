package c.a.h0.m.h.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class b implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final InputStream f3636e;

    /* renamed from: f  reason: collision with root package name */
    public final Charset f3637f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3638g;

    /* renamed from: h  reason: collision with root package name */
    public int f3639h;

    /* renamed from: i  reason: collision with root package name */
    public int f3640i;

    /* loaded from: classes.dex */
    public class a extends ByteArrayOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3641e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3641e = bVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
            if (((java.io.ByteArrayOutputStream) r5).buf[r0] == 13) goto L7;
         */
        @Override // java.io.ByteArrayOutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i3 = ((ByteArrayOutputStream) this).count;
                if (i3 > 0) {
                    i2 = i3 - 1;
                }
                i2 = ((ByteArrayOutputStream) this).count;
                try {
                    return new String(((ByteArrayOutputStream) this).buf, 0, i2, this.f3641e.f3637f.name());
                } catch (UnsupportedEncodingException e2) {
                    throw new AssertionError(e2);
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, charset};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], ((Integer) objArr2[1]).intValue(), (Charset) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            InputStream inputStream = this.f3636e;
            byte[] bArr = this.f3638g;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                this.f3639h = 0;
                this.f3640i = read;
                return;
            }
            throw new EOFException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f3636e) {
                if (this.f3638g != null) {
                    this.f3638g = null;
                    this.f3636e.close();
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f3640i == -1 : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f3636e) {
                if (this.f3638g != null) {
                    if (this.f3639h >= this.f3640i) {
                        c();
                    }
                    for (int i4 = this.f3639h; i4 != this.f3640i; i4++) {
                        if (this.f3638g[i4] == 10) {
                            if (i4 != this.f3639h) {
                                i3 = i4 - 1;
                                if (this.f3638g[i3] == 13) {
                                    String str = new String(this.f3638g, this.f3639h, i3 - this.f3639h, this.f3637f.name());
                                    this.f3639h = i4 + 1;
                                    return str;
                                }
                            }
                            i3 = i4;
                            String str2 = new String(this.f3638g, this.f3639h, i3 - this.f3639h, this.f3637f.name());
                            this.f3639h = i4 + 1;
                            return str2;
                        }
                    }
                    a aVar = new a(this, (this.f3640i - this.f3639h) + 80);
                    loop1: while (true) {
                        aVar.write(this.f3638g, this.f3639h, this.f3640i - this.f3639h);
                        this.f3640i = -1;
                        c();
                        i2 = this.f3639h;
                        while (i2 != this.f3640i) {
                            if (this.f3638g[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                    if (i2 != this.f3639h) {
                        aVar.write(this.f3638g, this.f3639h, i2 - this.f3639h);
                    }
                    this.f3639h = i2 + 1;
                    return aVar.toString();
                }
                throw new IOException("LineReader is closed");
            }
        }
        return (String) invokeV.objValue;
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), charset};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 >= 0) {
            if (charset.equals(c.a)) {
                this.f3636e = inputStream;
                this.f3637f = charset;
                this.f3638g = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
