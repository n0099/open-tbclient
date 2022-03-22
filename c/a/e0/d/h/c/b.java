package c.a.e0.d.h.c;

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
    public final InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public final Charset f2769b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2770c;

    /* renamed from: d  reason: collision with root package name */
    public int f2771d;

    /* renamed from: e  reason: collision with root package name */
    public int f2772e;

    /* loaded from: classes.dex */
    public class a extends ByteArrayOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
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
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = ((ByteArrayOutputStream) this).count;
                if (i2 > 0) {
                    i = i2 - 1;
                }
                i = ((ByteArrayOutputStream) this).count;
                try {
                    return new String(((ByteArrayOutputStream) this).buf, 0, i, this.a.f2769b.name());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            InputStream inputStream = this.a;
            byte[] bArr = this.f2770c;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read != -1) {
                this.f2771d = 0;
                this.f2772e = read;
                return;
            }
            throw new EOFException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.a) {
                if (this.f2770c != null) {
                    this.f2770c = null;
                    this.a.close();
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2772e == -1 : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.a) {
                if (this.f2770c != null) {
                    if (this.f2771d >= this.f2772e) {
                        c();
                    }
                    for (int i3 = this.f2771d; i3 != this.f2772e; i3++) {
                        if (this.f2770c[i3] == 10) {
                            if (i3 != this.f2771d) {
                                i2 = i3 - 1;
                                if (this.f2770c[i2] == 13) {
                                    String str = new String(this.f2770c, this.f2771d, i2 - this.f2771d, this.f2769b.name());
                                    this.f2771d = i3 + 1;
                                    return str;
                                }
                            }
                            i2 = i3;
                            String str2 = new String(this.f2770c, this.f2771d, i2 - this.f2771d, this.f2769b.name());
                            this.f2771d = i3 + 1;
                            return str2;
                        }
                    }
                    a aVar = new a(this, (this.f2772e - this.f2771d) + 80);
                    loop1: while (true) {
                        aVar.write(this.f2770c, this.f2771d, this.f2772e - this.f2771d);
                        this.f2772e = -1;
                        c();
                        i = this.f2771d;
                        while (i != this.f2772e) {
                            if (this.f2770c[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                    if (i != this.f2771d) {
                        aVar.write(this.f2770c, this.f2771d, i - this.f2771d);
                    }
                    this.f2771d = i + 1;
                    return aVar.toString();
                }
                throw new IOException("LineReader is closed");
            }
        }
        return (String) invokeV.objValue;
    }

    public b(InputStream inputStream, int i, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i), charset};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i >= 0) {
            if (charset.equals(c.a)) {
                this.a = inputStream;
                this.f2769b = charset;
                this.f2770c = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Unsupported encoding");
        }
        throw new IllegalArgumentException("capacity <= 0");
    }
}
