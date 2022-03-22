package c.a.q0.b.d;

import android.util.Log;
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
/* loaded from: classes3.dex */
public class a extends InputStream {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f21021e;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public b f21022b;

    /* renamed from: c  reason: collision with root package name */
    public long f21023c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f21024d;

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
        f21021e = a.class.getName();
    }

    public a(InputStream inputStream, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21023c = 0L;
        this.f21024d = false;
        this.a = inputStream;
        this.f21022b = bVar;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return this.a.available();
            } catch (IOException e2) {
                this.f21022b.b(e2, this.f21023c);
                throw e2;
            }
        }
        return invokeV.intValue;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21024d) {
            return;
        }
        this.f21024d = true;
        try {
            try {
                if (this.a.read() == -1) {
                    this.f21022b.onComplete(this.f21023c);
                } else {
                    this.f21022b.a(this.f21023c);
                }
                this.a.close();
            } catch (Exception unused) {
                this.a.close();
            } catch (Throwable th) {
                try {
                    this.a.close();
                } catch (Exception e2) {
                    this.f21022b.b(e2, this.f21023c);
                }
                throw th;
            }
        } catch (Exception e3) {
            this.f21022b.b(e3, this.f21023c);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            if (this.f21024d) {
                return -1;
            }
            try {
                int read = this.a.read(bArr, 0, bArr.length);
                if (read >= 0) {
                    this.f21023c += read;
                } else {
                    this.f21024d = true;
                    this.f21022b.onComplete(this.f21023c);
                }
                return read;
            } catch (IOException e2) {
                this.f21022b.b(e2, this.f21023c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f21021e, "Exception reading data from InputStream", e3);
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
                    this.a.reset();
                } catch (IOException e2) {
                    this.f21022b.b(e2, this.f21023c);
                    throw e2;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            long skip = this.a.skip(j);
            this.f21023c += skip;
            return skip;
        }
        return invokeJ.longValue;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, bArr, i, i2)) == null) {
            if (this.f21024d) {
                return -1;
            }
            try {
                int read = this.a.read(bArr, i, i2);
                if (read >= 0) {
                    this.f21023c += read;
                } else {
                    this.f21024d = true;
                    this.f21022b.onComplete(this.f21023c);
                }
                return read;
            } catch (IOException e2) {
                this.f21022b.b(e2, this.f21023c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f21021e, "Exception reading data from InputStream", e3);
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
            if (this.f21024d) {
                return -1;
            }
            try {
                int read = this.a.read();
                if (read >= 0) {
                    this.f21023c += read;
                } else {
                    this.f21024d = true;
                    this.f21022b.onComplete(this.f21023c);
                }
                return read;
            } catch (IOException e2) {
                this.f21022b.b(e2, this.f21023c);
                throw e2;
            } catch (IllegalStateException e3) {
                Log.e(f21021e, "Exception reading data from InputStream", e3);
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
