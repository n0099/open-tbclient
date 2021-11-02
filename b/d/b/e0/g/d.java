package b.d.b.e0.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.Sink;
/* loaded from: classes6.dex */
public final class d implements Closeable, Flushable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.d.b.e0.m.a f30216e;

    /* renamed from: f  reason: collision with root package name */
    public final File f30217f;

    /* renamed from: g  reason: collision with root package name */
    public long f30218g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30219h;

    /* renamed from: i  reason: collision with root package name */
    public long f30220i;
    public BufferedSink j;
    public final LinkedHashMap<String, b> k;
    public int l;
    public boolean m;
    public boolean n;
    public final Executor o;
    public final Runnable p;

    /* loaded from: classes6.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract void a() throws IOException;

        public abstract void b() throws IOException;

        public abstract void c();

        public abstract Sink d(int i2);
    }

    /* loaded from: classes6.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f30221a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f30222b;

        /* renamed from: c  reason: collision with root package name */
        public final File[] f30223c;

        /* renamed from: d  reason: collision with root package name */
        public a f30224d;
    }

    /* loaded from: classes6.dex */
    public final class c implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Nullable
        public abstract a a() throws IOException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797120878, "Lb/d/b/e0/g/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-797120878, "Lb/d/b/e0/g/d;");
                return;
            }
        }
        Pattern.compile("[a-z0-9_-]{1,120}");
    }

    public final synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (isClosed()) {
                    throw new IllegalStateException("cache is closed");
                }
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.l;
            return i2 >= 2000 && i2 >= this.k.size();
        }
        return invokeV.booleanValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b[] bVarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.m && !this.n) {
                    for (b bVar : (b[]) this.k.values().toArray(new b[this.k.size()])) {
                        if (bVar.f30224d != null) {
                            bVar.f30224d.a();
                        }
                    }
                    e();
                    this.j.close();
                    this.j = null;
                    this.n = true;
                    return;
                }
                this.n = true;
            }
        }
    }

    public boolean d(b bVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            a aVar = bVar.f30224d;
            if (aVar != null) {
                aVar.c();
            }
            for (int i2 = 0; i2 < this.f30219h; i2++) {
                this.f30216e.delete(bVar.f30223c[i2]);
                long j = this.f30220i;
                long[] jArr = bVar.f30222b;
                this.f30220i = j - jArr[i2];
                jArr[i2] = 0;
            }
            this.l++;
            this.j.writeUtf8("REMOVE").writeByte(32).writeUtf8(bVar.f30221a).writeByte(10);
            this.k.remove(bVar.f30221a);
            if (c()) {
                this.o.execute(this.p);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void delete() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            close();
            this.f30216e.deleteContents(this.f30217f);
        }
    }

    public void e() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            while (this.f30220i > this.f30218g) {
                d(this.k.values().iterator().next());
            }
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.m) {
                    a();
                    e();
                    this.j.flush();
                }
            }
        }
    }

    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                z = this.n;
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
