package c.a.q0.b.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class a extends InputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f29069i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f29070e;

    /* renamed from: f  reason: collision with root package name */
    public b f29071f;

    /* renamed from: g  reason: collision with root package name */
    public long f29072g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29073h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1156969628, "Lc/a/q0/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1156969628, "Lc/a/q0/b/d/a;");
                return;
            }
        }
        f29069i = a.class.getName();
    }

    public a(InputStream inputStream, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29072g = 0L;
        this.f29073h = false;
        this.f29070e = inputStream;
        this.f29071f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.f29070e.available();
            } catch (IOException e2) {
                this.f29071f.b(e2, this.f29072g);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f29073h) {
            return;
        }
        this.f29073h = true;
        try {
            try {
                if (this.f29070e.read() == -1) {
                    this.f29071f.onComplete(this.f29072g);
                } else {
                    this.f29071f.a(this.f29072g);
                }
                this.f29070e.close();
            } catch (Exception unused) {
                this.f29070e.close();
            } catch (Throwable th) {
                try {
                    this.f29070e.close();
                } catch (Exception e2) {
                    this.f29071f.b(e2, this.f29072g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f29071f.b(e3, this.f29072g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.f29073h) {
                return -1;
            }
            try {
                int read = this.f29070e.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.f29072g += read;
                } else {
                    this.f29073h = true;
                    this.f29071f.onComplete(this.f29072g);
                }
                return read;
            } catch (IOException e2) {
                this.f29071f.b(e2, this.f29072g);
                throw e2;
            } catch (IllegalStateException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                try {
                    this.f29070e.reset();
                } catch (IOException e2) {
                    this.f29071f.b(e2, this.f29072g);
                    throw e2;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j2)) == null) {
            long skip = this.f29070e.skip(j2);
            this.f29072g += skip;
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (this.f29073h) {
                return -1;
            }
            try {
                int read = this.f29070e.read(bArr, i2, i3);
                if (read >= 0) {
                    this.f29072g += read;
                } else {
                    this.f29073h = true;
                    this.f29071f.onComplete(this.f29072g);
                }
                return read;
            } catch (IOException e2) {
                this.f29071f.b(e2, this.f29072g);
                throw e2;
            } catch (IllegalStateException unused) {
                return -1;
            }
        }
        return invokeLII.intValue;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f29073h) {
                return -1;
            }
            try {
                int read = this.f29070e.read();
                if (read >= 0) {
                    this.f29072g += read;
                } else {
                    this.f29073h = true;
                    this.f29071f.onComplete(this.f29072g);
                }
                return read;
            } catch (IOException e2) {
                this.f29071f.b(e2, this.f29072g);
                throw e2;
            } catch (IllegalStateException unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
