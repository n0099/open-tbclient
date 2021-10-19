package c.a.s0.b.d;

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
    public static final String f29928i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f29929e;

    /* renamed from: f  reason: collision with root package name */
    public b f29930f;

    /* renamed from: g  reason: collision with root package name */
    public long f29931g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29932h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1837027998, "Lc/a/s0/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1837027998, "Lc/a/s0/b/d/a;");
                return;
            }
        }
        f29928i = a.class.getName();
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
        this.f29931g = 0L;
        this.f29932h = false;
        this.f29929e = inputStream;
        this.f29930f = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.f29929e.available();
            } catch (IOException e2) {
                this.f29930f.b(e2, this.f29931g);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f29932h) {
            return;
        }
        this.f29932h = true;
        try {
            try {
                if (this.f29929e.read() == -1) {
                    this.f29930f.onComplete(this.f29931g);
                } else {
                    this.f29930f.a(this.f29931g);
                }
                this.f29929e.close();
            } catch (Exception unused) {
                this.f29929e.close();
            } catch (Throwable th) {
                try {
                    this.f29929e.close();
                } catch (Exception e2) {
                    this.f29930f.b(e2, this.f29931g);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f29930f.b(e3, this.f29931g);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.f29932h) {
                return -1;
            }
            try {
                int read = this.f29929e.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.f29931g += read;
                } else {
                    this.f29932h = true;
                    this.f29930f.onComplete(this.f29931g);
                }
                return read;
            } catch (IOException e2) {
                this.f29930f.b(e2, this.f29931g);
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
                    this.f29929e.reset();
                } catch (IOException e2) {
                    this.f29930f.b(e2, this.f29931g);
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
            long skip = this.f29929e.skip(j2);
            this.f29931g += skip;
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i2, i3)) == null) {
            if (this.f29932h) {
                return -1;
            }
            try {
                int read = this.f29929e.read(bArr, i2, i3);
                if (read >= 0) {
                    this.f29931g += read;
                } else {
                    this.f29932h = true;
                    this.f29930f.onComplete(this.f29931g);
                }
                return read;
            } catch (IOException e2) {
                this.f29930f.b(e2, this.f29931g);
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
            if (this.f29932h) {
                return -1;
            }
            try {
                int read = this.f29929e.read();
                if (read >= 0) {
                    this.f29931g += read;
                } else {
                    this.f29932h = true;
                    this.f29930f.onComplete(this.f29931g);
                }
                return read;
            } catch (IOException e2) {
                this.f29930f.b(e2, this.f29931g);
                throw e2;
            } catch (IllegalStateException unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
