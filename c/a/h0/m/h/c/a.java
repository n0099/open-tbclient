package c.a.h0.m.h.c;

import androidx.core.view.InputDeviceCompat;
import c.a.h0.r.h;
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
    public final File f3617e;

    /* renamed from: f  reason: collision with root package name */
    public final File f3618f;

    /* renamed from: g  reason: collision with root package name */
    public final File f3619g;

    /* renamed from: h  reason: collision with root package name */
    public final File f3620h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3621i;

    /* renamed from: j  reason: collision with root package name */
    public long f3622j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3623k;
    public long l;
    public Writer m;
    public final LinkedHashMap<String, d> n;
    public int o;
    public long p;
    public final ThreadPoolExecutor q;
    public final Callable<Void> r;

    /* renamed from: c.a.h0.m.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0135a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3624e;

        public CallableC0135a(a aVar) {
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
            this.f3624e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.f3624e) {
                    if (this.f3624e.m == null) {
                        return null;
                    }
                    this.f3624e.x();
                    if (this.f3624e.p()) {
                        this.f3624e.u();
                        this.f3624e.o = 0;
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
        public final d a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f3625b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3626c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3627d;

        /* renamed from: c.a.h0.m.h.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0136a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f3628e;

            public /* synthetic */ C0136a(c cVar, OutputStream outputStream, CallableC0135a callableC0135a) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f3628e.f3626c = true;
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
                        this.f3628e.f3626c = true;
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
                        this.f3628e.f3626c = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0136a(c cVar, OutputStream outputStream) {
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
                this.f3628e = cVar;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f3628e.f3626c = true;
                    }
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0135a callableC0135a) {
            this(aVar, dVar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3627d.k(this, false);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f3626c) {
                    this.f3627d.k(this, false);
                    this.f3627d.v(this.a.a);
                    return;
                }
                this.f3627d.k(this, true);
            }
        }

        public OutputStream f(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0136a c0136a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f3627d.f3623k) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f3627d.f3623k);
                }
                synchronized (this.f3627d) {
                    if (this.a.f3631d == this) {
                        if (!this.a.f3630c) {
                            this.f3625b[i2] = true;
                        }
                        File k2 = this.a.k(i2);
                        try {
                            fileOutputStream = new FileOutputStream(k2);
                        } catch (FileNotFoundException unused) {
                            this.f3627d.f3617e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(k2);
                            } catch (FileNotFoundException unused2) {
                                return a.t;
                            }
                        }
                        c0136a = new C0136a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0136a;
            }
            return (OutputStream) invokeI.objValue;
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
            this.f3627d = aVar;
            this.a = dVar;
            this.f3625b = dVar.f3630c ? null : new boolean[aVar.f3623k];
        }
    }

    /* loaded from: classes.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3629b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3630c;

        /* renamed from: d  reason: collision with root package name */
        public c f3631d;

        /* renamed from: e  reason: collision with root package name */
        public long f3632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3633f;

        public /* synthetic */ d(a aVar, String str, CallableC0135a callableC0135a) {
            this(aVar, str);
        }

        public File j(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                File file = this.f3633f.f3617e;
                return new File(file, this.a + "." + i2);
            }
            return (File) invokeI.objValue;
        }

        public File k(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                File file = this.f3633f.f3617e;
                return new File(file, this.a + "." + i2 + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String l() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j2 : this.f3629b) {
                    sb.append(' ');
                    sb.append(j2);
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public final IOException m(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            return (IOException) invokeL.objValue;
        }

        public final void n(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
                if (strArr.length == this.f3633f.f3623k) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            this.f3629b[i2] = Long.parseLong(strArr[i2]);
                        } catch (NumberFormatException unused) {
                            m(strArr);
                            throw null;
                        }
                    }
                    return;
                }
                m(strArr);
                throw null;
            }
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
            this.f3633f = aVar;
            this.a = str;
            this.f3629b = new long[aVar.f3623k];
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f3634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3635f;

        public /* synthetic */ e(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr, CallableC0135a callableC0135a) {
            this(aVar, str, j2, inputStreamArr, jArr);
        }

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f3634e[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f3634e) {
                    c.a.h0.m.h.c.c.a(inputStream);
                }
            }
        }

        public e(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2), inputStreamArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3635f = aVar;
            this.f3634e = inputStreamArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549588112, "Lc/a/h0/m/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(549588112, "Lc/a/h0/m/h/c/a;");
                return;
            }
        }
        s = Pattern.compile("[a-z0-9_-]{1,120}");
        t = new b();
    }

    public a(File file, int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
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
        this.r = new CallableC0135a(this);
        this.f3617e = file;
        this.f3621i = i2;
        this.f3618f = new File(file, "journal");
        this.f3619g = new File(file, "journal.tmp");
        this.f3620h = new File(file, "journal.bkp");
        this.f3623k = i3;
        this.f3622j = j2;
    }

    public static void l(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static a q(File file, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (j2 > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            w(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j2);
                    if (aVar.f3618f.exists()) {
                        try {
                            aVar.s();
                            aVar.r();
                            return aVar;
                        } catch (IOException e2) {
                            h.d("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.delete();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j2);
                    aVar2.u();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    public static void w(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65549, null, file, file2, z) == null) {
            if (z) {
                l(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (this.m == null) {
                    return;
                }
                Iterator it = new ArrayList(this.n.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.f3631d != null) {
                        dVar.f3631d.a();
                    }
                }
                x();
                this.m.close();
                this.m = null;
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close();
            c.a.h0.m.h.c.c.b(this.f3617e);
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                j();
                x();
                this.m.flush();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void k(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, cVar, z) == null) {
            synchronized (this) {
                d dVar = cVar.a;
                if (dVar.f3631d == cVar) {
                    if (z && !dVar.f3630c) {
                        for (int i2 = 0; i2 < this.f3623k; i2++) {
                            if (cVar.f3625b[i2]) {
                                if (!dVar.k(i2).exists()) {
                                    cVar.a();
                                    return;
                                }
                            } else {
                                cVar.a();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f3623k; i3++) {
                        File k2 = dVar.k(i3);
                        if (z) {
                            if (k2.exists()) {
                                File j2 = dVar.j(i3);
                                k2.renameTo(j2);
                                long j3 = dVar.f3629b[i3];
                                long length = j2.length();
                                dVar.f3629b[i3] = length;
                                this.l = (this.l - j3) + length;
                            }
                        } else {
                            l(k2);
                        }
                    }
                    this.o++;
                    dVar.f3631d = null;
                    if (!dVar.f3630c && !z) {
                        this.n.remove(dVar.a);
                        this.m.write("REMOVE " + dVar.a + '\n');
                        this.m.flush();
                        if (this.l <= this.f3622j || p()) {
                            this.q.submit(this.r);
                        }
                        return;
                    }
                    dVar.f3630c = true;
                    this.m.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    if (z) {
                        long j4 = this.p;
                        this.p = 1 + j4;
                        dVar.f3632e = j4;
                    }
                    this.m.flush();
                    if (this.l <= this.f3622j) {
                    }
                    this.q.submit(this.r);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public c m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? n(str, -1L) : (c) invokeL.objValue;
    }

    public final synchronized c n(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j2)) == null) {
            synchronized (this) {
                j();
                y(str);
                d dVar = this.n.get(str);
                if (j2 == -1 || (dVar != null && dVar.f3632e == j2)) {
                    if (dVar != null) {
                        if (dVar.f3631d != null) {
                            return null;
                        }
                    } else {
                        dVar = new d(this, str, null);
                        this.n.put(str, dVar);
                    }
                    c cVar = new c(this, dVar, null);
                    dVar.f3631d = cVar;
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

    public synchronized e o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                j();
                y(str);
                d dVar = this.n.get(str);
                if (dVar == null) {
                    return null;
                }
                if (dVar.f3630c) {
                    InputStream[] inputStreamArr = new InputStream[this.f3623k];
                    for (int i2 = 0; i2 < this.f3623k; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(dVar.j(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.f3623k && inputStreamArr[i3] != null; i3++) {
                                c.a.h0.m.h.c.c.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.o++;
                    this.m.append((CharSequence) ("READ " + str + '\n'));
                    if (p()) {
                        this.q.submit(this.r);
                    }
                    return new e(this, str, dVar.f3632e, inputStreamArr, dVar.f3629b, null);
                }
                return null;
            }
        }
        return (e) invokeL.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.o;
            return i2 >= 2000 && i2 >= this.n.size();
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(this.f3619g);
            Iterator<d> it = this.n.values().iterator();
            while (it.hasNext()) {
                d next = it.next();
                int i2 = 0;
                if (next.f3631d != null) {
                    next.f3631d = null;
                    while (i2 < this.f3623k) {
                        l(next.j(i2));
                        l(next.k(i2));
                        i2++;
                    }
                    it.remove();
                } else {
                    while (i2 < this.f3623k) {
                        this.l += next.f3629b[i2];
                        i2++;
                    }
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048586, this) != null) {
            return;
        }
        c.a.h0.m.h.c.b bVar = new c.a.h0.m.h.c.b(new FileInputStream(this.f3618f), c.a.h0.m.h.c.c.a);
        try {
            String f2 = bVar.f();
            String f3 = bVar.f();
            String f4 = bVar.f();
            String f5 = bVar.f();
            String f6 = bVar.f();
            if (!"libcore.io.DiskLruCache".equals(f2) || !"1".equals(f3) || !Integer.toString(this.f3621i).equals(f4) || !Integer.toString(this.f3623k).equals(f5) || !"".equals(f6)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(f2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f3);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f5);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(f6);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                throw new IOException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                try {
                    t(bVar.f());
                    i2++;
                } catch (EOFException unused) {
                    this.o = i2 - this.n.size();
                    if (bVar.e()) {
                        u();
                    } else {
                        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3618f, true), c.a.h0.m.h.c.c.a));
                    }
                    c.a.h0.m.h.c.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a.h0.m.h.c.c.a(bVar);
            throw th;
        }
    }

    public final void t(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
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
                    dVar.f3630c = true;
                    dVar.f3631d = null;
                    dVar.n(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    dVar.f3631d = new c(this, dVar, null);
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

    public final synchronized void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                Writer writer = this.m;
                if (writer != null) {
                    writer.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3619g), c.a.h0.m.h.c.c.a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f3621i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f3623k));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (d dVar : this.n.values()) {
                    if (dVar.f3631d != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.a);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.a);
                        sb2.append(dVar.l());
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                if (this.f3618f.exists()) {
                    w(this.f3618f, this.f3620h, true);
                }
                w(this.f3619g, this.f3618f, false);
                this.f3620h.delete();
                this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3618f, true), c.a.h0.m.h.c.c.a));
            }
        }
    }

    public synchronized boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            synchronized (this) {
                j();
                y(str);
                d dVar = this.n.get(str);
                if (dVar != null && dVar.f3631d == null) {
                    for (int i2 = 0; i2 < this.f3623k; i2++) {
                        File j2 = dVar.j(i2);
                        if (j2.exists() && !j2.delete()) {
                            throw new IOException("failed to delete " + j2);
                        }
                        this.l -= dVar.f3629b[i2];
                        dVar.f3629b[i2] = 0;
                    }
                    this.o++;
                    this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.n.remove(str);
                    if (p()) {
                        this.q.submit(this.r);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            while (this.l > this.f3622j) {
                v(this.n.entrySet().iterator().next().getKey());
            }
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }
}
