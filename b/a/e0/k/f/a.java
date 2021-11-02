package b.a.e0.k.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern s;
    public static final OutputStream t;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final File f2596e;

    /* renamed from: f  reason: collision with root package name */
    public final File f2597f;

    /* renamed from: g  reason: collision with root package name */
    public final File f2598g;

    /* renamed from: h  reason: collision with root package name */
    public final File f2599h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2600i;
    public long j;
    public final int k;
    public long l;
    public Writer m;
    public final LinkedHashMap<String, d> n;
    public int o;
    public long p;
    public final ThreadPoolExecutor q;
    public final Callable<Void> r;

    /* renamed from: b.a.e0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0052a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2601e;

        public CallableC0052a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2601e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f2601e) {
                    if (this.f2601e.m == null) {
                        return null;
                    }
                    this.f2601e.w();
                    if (this.f2601e.u()) {
                        this.f2601e.y();
                        this.f2601e.o = 0;
                    }
                    return null;
                }
            }
            return (Void) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends OutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d f2602a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f2603b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2604c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f2605d;

        /* renamed from: b.a.e0.k.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0053a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f2606e;

            public /* synthetic */ C0053a(c cVar, OutputStream outputStream, CallableC0052a callableC0052a) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f2606e.f2604c = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.flush();
                    } catch (IOException unused) {
                        this.f2606e.f2604c = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i2);
                    } catch (IOException unused) {
                        this.f2606e.f2604c = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0053a(c cVar, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, outputStream};
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
                this.f2606e = cVar;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f2606e.f2604c = true;
                    }
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0052a callableC0052a) {
            this(aVar, dVar);
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2605d.h(this, false);
            }
        }

        public OutputStream e(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0053a c0053a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f2605d.k) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f2605d.k);
                }
                synchronized (this.f2605d) {
                    if (this.f2602a.f2610d == this) {
                        if (!this.f2602a.f2609c) {
                            this.f2603b[i2] = true;
                        }
                        File n = this.f2602a.n(i2);
                        try {
                            fileOutputStream = new FileOutputStream(n);
                        } catch (FileNotFoundException unused) {
                            this.f2605d.f2596e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(n);
                            } catch (FileNotFoundException unused2) {
                                return a.t;
                            }
                        }
                        c0053a = new C0053a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0053a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f2604c) {
                    this.f2605d.h(this, false);
                    this.f2605d.t(this.f2602a.f2607a);
                    return;
                }
                this.f2605d.h(this, true);
            }
        }

        public c(a aVar, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2605d = aVar;
            this.f2602a = dVar;
            this.f2603b = dVar.f2609c ? null : new boolean[aVar.k];
        }
    }

    /* loaded from: classes.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f2607a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f2608b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2609c;

        /* renamed from: d  reason: collision with root package name */
        public c f2610d;

        /* renamed from: e  reason: collision with root package name */
        public long f2611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2612f;

        public /* synthetic */ d(a aVar, String str, CallableC0052a callableC0052a) {
            this(aVar, str);
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f2608b) {
                    sb.append(' ');
                    sb.append(j);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final IOException d(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public final void i(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
                if (strArr.length == this.f2612f.k) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            this.f2608b[i2] = Long.parseLong(strArr[i2]);
                        } catch (NumberFormatException unused) {
                            d(strArr);
                            throw null;
                        }
                    }
                    return;
                }
                d(strArr);
                throw null;
            }
        }

        public File k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                File file = this.f2612f.f2596e;
                return new File(file, this.f2607a + "." + i2);
            }
            return (File) invokeI.objValue;
        }

        public File n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                File file = this.f2612f.f2596e;
                return new File(file, this.f2607a + "." + i2 + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public d(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2612f = aVar;
            this.f2607a = str;
            this.f2608b = new long[aVar.k];
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f2613e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2614f;

        public /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0052a callableC0052a) {
            this(aVar, str, j, inputStreamArr, jArr);
        }

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f2613e[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f2613e) {
                    b.a.e0.k.f.c.a(inputStream);
                }
            }
        }

        public e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2614f = aVar;
            this.f2613e = inputStreamArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1922711652, "Lb/a/e0/k/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1922711652, "Lb/a/e0/k/f/a;");
                return;
            }
        }
        s = Pattern.compile("[a-z0-9_-]{1,120}");
        t = new b();
    }

    public a(File file, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = 0L;
        this.n = new LinkedHashMap<>(0, 0.75f, true);
        this.p = 0L;
        this.q = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.r = new CallableC0052a(this);
        this.f2596e = file;
        this.f2600i = i2;
        this.f2597f = new File(file, "journal");
        this.f2598g = new File(file, "journal.tmp");
        this.f2599h = new File(file, "journal.bkp");
        this.k = i3;
        this.j = j;
    }

    public static a d(File file, int i2, int i3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            g(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j);
                    if (aVar.f2597f.exists()) {
                        try {
                            aVar.x();
                            aVar.v();
                            return aVar;
                        } catch (IOException e2) {
                            b.a.e0.n.d.b("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j);
                    aVar2.y();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    public static void g(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, file, file2, z) == null) {
            if (z) {
                k(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    public static void k(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final synchronized c c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, str, j)) == null) {
            synchronized (this) {
                s();
                r(str);
                d dVar = this.n.get(str);
                if (j == -1 || (dVar != null && dVar.f2611e == j)) {
                    if (dVar != null) {
                        if (dVar.f2610d != null) {
                            return null;
                        }
                    } else {
                        dVar = new d(this, str, null);
                        this.n.put(str, dVar);
                    }
                    c cVar = new c(this, dVar, null);
                    dVar.f2610d = cVar;
                    Writer writer = this.m;
                    writer.write("DIRTY " + str + '\n');
                    this.m.flush();
                    return cVar;
                }
                return null;
            }
        }
        return (c) invokeLJ.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.m == null) {
                    return;
                }
                Iterator it = new ArrayList(this.n.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.f2610d != null) {
                        dVar.f2610d.c();
                    }
                }
                w();
                this.m.close();
                this.m = null;
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            close();
            b.a.e0.k.f.c.b(this.f2596e);
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                s();
                w();
                this.m.flush();
            }
        }
    }

    public final synchronized void h(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, cVar, z) == null) {
            synchronized (this) {
                d dVar = cVar.f2602a;
                if (dVar.f2610d == cVar) {
                    if (z && !dVar.f2609c) {
                        for (int i2 = 0; i2 < this.k; i2++) {
                            if (cVar.f2603b[i2]) {
                                if (!dVar.n(i2).exists()) {
                                    cVar.c();
                                    return;
                                }
                            } else {
                                cVar.c();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.k; i3++) {
                        File n = dVar.n(i3);
                        if (z) {
                            if (n.exists()) {
                                File k = dVar.k(i3);
                                n.renameTo(k);
                                long j = dVar.f2608b[i3];
                                long length = k.length();
                                dVar.f2608b[i3] = length;
                                this.l = (this.l - j) + length;
                            }
                        } else {
                            k(n);
                        }
                    }
                    this.o++;
                    dVar.f2610d = null;
                    if (!dVar.f2609c && !z) {
                        this.n.remove(dVar.f2607a);
                        this.m.write("REMOVE " + dVar.f2607a + '\n');
                        this.m.flush();
                        if (this.l <= this.j || u()) {
                            this.q.submit(this.r);
                        }
                        return;
                    }
                    dVar.f2609c = true;
                    this.m.write("CLEAN " + dVar.f2607a + dVar.a() + '\n');
                    if (z) {
                        long j2 = this.p;
                        this.p = 1 + j2;
                        dVar.f2611e = j2;
                    }
                    this.m.flush();
                    if (this.l <= this.j) {
                    }
                    this.q.submit(this.r);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public c n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? c(str, -1L) : (c) invokeL.objValue;
    }

    public synchronized e p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                s();
                r(str);
                d dVar = this.n.get(str);
                if (dVar == null) {
                    return null;
                }
                if (dVar.f2609c) {
                    InputStream[] inputStreamArr = new InputStream[this.k];
                    for (int i2 = 0; i2 < this.k; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(dVar.k(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.k && inputStreamArr[i3] != null; i3++) {
                                b.a.e0.k.f.c.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.o++;
                    this.m.append((CharSequence) ("READ " + str + '\n'));
                    if (u()) {
                        this.q.submit(this.r);
                    }
                    return new e(this, str, dVar.f2611e, inputStreamArr, dVar.f2608b, null);
                }
                return null;
            }
        }
        return (e) invokeL.objValue;
    }

    public final void q(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(32, i2);
                if (indexOf2 == -1) {
                    substring = str.substring(i2);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.n.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i2, indexOf2);
                }
                d dVar = this.n.get(substring);
                if (dVar == null) {
                    dVar = new d(this, substring, null);
                    this.n.put(substring, dVar);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    dVar.f2609c = true;
                    dVar.f2610d = null;
                    dVar.i(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    dVar.f2610d = new c(this, dVar, null);
                    return;
                } else if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                    return;
                } else {
                    throw new IOException("unexpected journal line: " + str);
                }
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            synchronized (this) {
                s();
                r(str);
                d dVar = this.n.get(str);
                if (dVar != null && dVar.f2610d == null) {
                    for (int i2 = 0; i2 < this.k; i2++) {
                        File k = dVar.k(i2);
                        if (k.exists() && !k.delete()) {
                            throw new IOException("failed to delete " + k);
                        }
                        this.l -= dVar.f2608b[i2];
                        dVar.f2608b[i2] = 0;
                    }
                    this.o++;
                    this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.n.remove(str);
                    if (u()) {
                        this.q.submit(this.r);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.o;
            return i2 >= 2000 && i2 >= this.n.size();
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            k(this.f2598g);
            Iterator<d> it = this.n.values().iterator();
            while (it.hasNext()) {
                d next = it.next();
                int i2 = 0;
                if (next.f2610d != null) {
                    next.f2610d = null;
                    while (i2 < this.k) {
                        k(next.k(i2));
                        k(next.n(i2));
                        i2++;
                    }
                    it.remove();
                } else {
                    while (i2 < this.k) {
                        this.l += next.f2608b[i2];
                        i2++;
                    }
                }
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            while (this.l > this.j) {
                t(this.n.entrySet().iterator().next().getKey());
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048590, this) != null) {
            return;
        }
        b.a.e0.k.f.b bVar = new b.a.e0.k.f.b(new FileInputStream(this.f2597f), b.a.e0.k.f.c.f2621a);
        try {
            String c2 = bVar.c();
            String c3 = bVar.c();
            String c4 = bVar.c();
            String c5 = bVar.c();
            String c6 = bVar.c();
            if (!"libcore.io.DiskLruCache".equals(c2) || !"1".equals(c3) || !Integer.toString(this.f2600i).equals(c4) || !Integer.toString(this.k).equals(c5) || !"".equals(c6)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(c2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(c3);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(c5);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(c6);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                throw new IOException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                try {
                    q(bVar.c());
                    i2++;
                } catch (EOFException unused) {
                    this.o = i2 - this.n.size();
                    if (bVar.a()) {
                        y();
                    } else {
                        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2597f, true), b.a.e0.k.f.c.f2621a));
                    }
                    b.a.e0.k.f.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            b.a.e0.k.f.c.a(bVar);
            throw th;
        }
    }

    public final synchronized void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                Writer writer = this.m;
                if (writer != null) {
                    writer.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2598g), b.a.e0.k.f.c.f2621a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f2600i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.k));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (d dVar : this.n.values()) {
                    if (dVar.f2610d != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.f2607a);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.f2607a);
                        sb2.append(dVar.a());
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                if (this.f2597f.exists()) {
                    g(this.f2597f, this.f2599h, true);
                }
                g(this.f2598g, this.f2597f, false);
                this.f2599h.delete();
                this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2597f, true), b.a.e0.k.f.c.f2621a));
            }
        }
    }
}
