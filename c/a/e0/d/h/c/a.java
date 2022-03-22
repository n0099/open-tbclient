package c.a.e0.d.h.c;

import androidx.core.view.InputDeviceCompat;
import c.a.e0.i.h;
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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
/* loaded from: classes.dex */
public final class a implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern o;
    public static final OutputStream p;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    /* renamed from: b  reason: collision with root package name */
    public final File f2753b;

    /* renamed from: c  reason: collision with root package name */
    public final File f2754c;

    /* renamed from: d  reason: collision with root package name */
    public final File f2755d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2756e;

    /* renamed from: f  reason: collision with root package name */
    public long f2757f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2758g;

    /* renamed from: h  reason: collision with root package name */
    public long f2759h;
    public Writer i;
    public final LinkedHashMap<String, d> j;
    public int k;
    public long l;
    public final ThreadPoolExecutor m;
    public final Callable<Void> n;

    /* renamed from: c.a.e0.d.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0123a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public CallableC0123a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this.a) {
                    if (this.a.i == null) {
                        return null;
                    }
                    this.a.x();
                    if (this.a.p()) {
                        this.a.u();
                        this.a.k = 0;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f2760b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2761c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f2762d;

        /* renamed from: c.a.e0.d.h.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0124a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public /* synthetic */ C0124a(c cVar, OutputStream outputStream, CallableC0123a callableC0123a) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.a.f2761c = true;
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
                        this.a.f2761c = true;
                    }
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(i);
                    } catch (IOException unused) {
                        this.a.f2761c = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0124a(c cVar, OutputStream outputStream) {
                super(outputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, outputStream};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((OutputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i, i2);
                    } catch (IOException unused) {
                        this.a.f2761c = true;
                    }
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0123a callableC0123a) {
            this(aVar, dVar);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2762d.k(this, false);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f2761c) {
                    this.f2762d.k(this, false);
                    this.f2762d.v(this.a.a);
                    return;
                }
                this.f2762d.k(this, true);
            }
        }

        public OutputStream f(int i) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0124a c0124a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < 0 || i >= this.f2762d.f2758g) {
                    throw new IllegalArgumentException("Expected index " + i + " to be greater than 0 and less than the maximum value count of " + this.f2762d.f2758g);
                }
                synchronized (this.f2762d) {
                    if (this.a.f2765d == this) {
                        if (!this.a.f2764c) {
                            this.f2760b[i] = true;
                        }
                        File k = this.a.k(i);
                        try {
                            fileOutputStream = new FileOutputStream(k);
                        } catch (FileNotFoundException unused) {
                            this.f2762d.a.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(k);
                            } catch (FileNotFoundException unused2) {
                                return a.p;
                            }
                        }
                        c0124a = new C0124a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0124a;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2762d = aVar;
            this.a = dVar;
            this.f2760b = dVar.f2764c ? null : new boolean[aVar.f2758g];
        }
    }

    /* loaded from: classes.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f2763b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2764c;

        /* renamed from: d  reason: collision with root package name */
        public c f2765d;

        /* renamed from: e  reason: collision with root package name */
        public long f2766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2767f;

        public /* synthetic */ d(a aVar, String str, CallableC0123a callableC0123a) {
            this(aVar, str);
        }

        public File j(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                File file = this.f2767f.a;
                return new File(file, this.a + "." + i);
            }
            return (File) invokeI.objValue;
        }

        public File k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                File file = this.f2767f.a;
                return new File(file, this.a + "." + i + ".tmp");
            }
            return (File) invokeI.objValue;
        }

        public String l() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j : this.f2763b) {
                    sb.append(WebvttCueParser.CHAR_SPACE);
                    sb.append(j);
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
                if (strArr.length == this.f2767f.f2758g) {
                    for (int i = 0; i < strArr.length; i++) {
                        try {
                            this.f2763b[i] = Long.parseLong(strArr[i]);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2767f = aVar;
            this.a = str;
            this.f2763b = new long[aVar.f2758g];
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2768b;

        public /* synthetic */ e(a aVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0123a callableC0123a) {
            this(aVar, str, j, inputStreamArr, jArr);
        }

        public InputStream a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.a[i] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.a) {
                    c.a.e0.d.h.c.c.a(inputStream);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2768b = aVar;
            this.a = inputStreamArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154916234, "Lc/a/e0/d/h/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154916234, "Lc/a/e0/d/h/c/a;");
                return;
            }
        }
        o = Pattern.compile("[a-z0-9_-]{1,120}");
        p = new b();
    }

    public a(File file, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2759h = 0L;
        this.j = new LinkedHashMap<>(0, 0.75f, true);
        this.l = 0L;
        this.m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.n = new CallableC0123a(this);
        this.a = file;
        this.f2756e = i;
        this.f2753b = new File(file, "journal");
        this.f2754c = new File(file, "journal.tmp");
        this.f2755d = new File(file, "journal.bkp");
        this.f2758g = i2;
        this.f2757f = j;
    }

    public static void l(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static a q(File file, int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{file, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j > 0) {
                if (i2 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            w(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i, i2, j);
                    if (aVar.f2753b.exists()) {
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
                    a aVar2 = new a(file, i, i2, j);
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
                if (this.i == null) {
                    return;
                }
                Iterator it = new ArrayList(this.j.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.f2765d != null) {
                        dVar.f2765d.a();
                    }
                }
                x();
                this.i.close();
                this.i = null;
            }
        }
    }

    public void delete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            close();
            c.a.e0.d.h.c.c.b(this.a);
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                j();
                x();
                this.i.flush();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void k(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, cVar, z) == null) {
            synchronized (this) {
                d dVar = cVar.a;
                if (dVar.f2765d == cVar) {
                    if (z && !dVar.f2764c) {
                        for (int i = 0; i < this.f2758g; i++) {
                            if (cVar.f2760b[i]) {
                                if (!dVar.k(i).exists()) {
                                    cVar.a();
                                    return;
                                }
                            } else {
                                cVar.a();
                                throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.f2758g; i2++) {
                        File k = dVar.k(i2);
                        if (z) {
                            if (k.exists()) {
                                File j = dVar.j(i2);
                                k.renameTo(j);
                                long j2 = dVar.f2763b[i2];
                                long length = j.length();
                                dVar.f2763b[i2] = length;
                                this.f2759h = (this.f2759h - j2) + length;
                            }
                        } else {
                            l(k);
                        }
                    }
                    this.k++;
                    dVar.f2765d = null;
                    if (!dVar.f2764c && !z) {
                        this.j.remove(dVar.a);
                        this.i.write("REMOVE " + dVar.a + '\n');
                        this.i.flush();
                        if (this.f2759h <= this.f2757f || p()) {
                            this.m.submit(this.n);
                        }
                        return;
                    }
                    dVar.f2764c = true;
                    this.i.write("CLEAN " + dVar.a + dVar.l() + '\n');
                    if (z) {
                        long j3 = this.l;
                        this.l = 1 + j3;
                        dVar.f2766e = j3;
                    }
                    this.i.flush();
                    if (this.f2759h <= this.f2757f) {
                    }
                    this.m.submit(this.n);
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

    public final synchronized c n(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, str, j)) == null) {
            synchronized (this) {
                j();
                y(str);
                d dVar = this.j.get(str);
                if (j == -1 || (dVar != null && dVar.f2766e == j)) {
                    if (dVar != null) {
                        if (dVar.f2765d != null) {
                            return null;
                        }
                    } else {
                        dVar = new d(this, str, null);
                        this.j.put(str, dVar);
                    }
                    c cVar = new c(this, dVar, null);
                    dVar.f2765d = cVar;
                    Writer writer = this.i;
                    writer.write("DIRTY " + str + '\n');
                    this.i.flush();
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
                d dVar = this.j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (dVar.f2764c) {
                    InputStream[] inputStreamArr = new InputStream[this.f2758g];
                    for (int i = 0; i < this.f2758g; i++) {
                        try {
                            inputStreamArr[i] = new FileInputStream(dVar.j(i));
                        } catch (FileNotFoundException unused) {
                            for (int i2 = 0; i2 < this.f2758g && inputStreamArr[i2] != null; i2++) {
                                c.a.e0.d.h.c.c.a(inputStreamArr[i2]);
                            }
                            return null;
                        }
                    }
                    this.k++;
                    this.i.append((CharSequence) ("READ " + str + '\n'));
                    if (p()) {
                        this.m.submit(this.n);
                    }
                    return new e(this, str, dVar.f2766e, inputStreamArr, dVar.f2763b, null);
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
            int i = this.k;
            return i >= 2000 && i >= this.j.size();
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l(this.f2754c);
            Iterator<d> it = this.j.values().iterator();
            while (it.hasNext()) {
                d next = it.next();
                int i = 0;
                if (next.f2765d != null) {
                    next.f2765d = null;
                    while (i < this.f2758g) {
                        l(next.j(i));
                        l(next.k(i));
                        i++;
                    }
                    it.remove();
                } else {
                    while (i < this.f2758g) {
                        this.f2759h += next.f2763b[i];
                        i++;
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
        c.a.e0.d.h.c.b bVar = new c.a.e0.d.h.c.b(new FileInputStream(this.f2753b), c.a.e0.d.h.c.c.a);
        try {
            String f2 = bVar.f();
            String f3 = bVar.f();
            String f4 = bVar.f();
            String f5 = bVar.f();
            String f6 = bVar.f();
            if (!"libcore.io.DiskLruCache".equals(f2) || !"1".equals(f3) || !Integer.toString(this.f2756e).equals(f4) || !Integer.toString(this.f2758g).equals(f5) || !"".equals(f6)) {
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
            int i = 0;
            while (true) {
                try {
                    t(bVar.f());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (bVar.e()) {
                        u();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2753b, true), c.a.e0.d.h.c.c.a));
                    }
                    c.a.e0.d.h.c.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a.e0.d.h.c.c.a(bVar);
            throw th;
        }
    }

    public final void t(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int i = indexOf + 1;
                int indexOf2 = str.indexOf(32, i);
                if (indexOf2 == -1) {
                    substring = str.substring(i);
                    if (indexOf == 6 && str.startsWith("REMOVE")) {
                        this.j.remove(substring);
                        return;
                    }
                } else {
                    substring = str.substring(i, indexOf2);
                }
                d dVar = this.j.get(substring);
                if (dVar == null) {
                    dVar = new d(this, substring, null);
                    this.j.put(substring, dVar);
                }
                if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                    String[] split = str.substring(indexOf2 + 1).split(" ");
                    dVar.f2764c = true;
                    dVar.f2765d = null;
                    dVar.n(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    dVar.f2765d = new c(this, dVar, null);
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
                Writer writer = this.i;
                if (writer != null) {
                    writer.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2754c), c.a.e0.d.h.c.c.a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f2756e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f2758g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.j.values()) {
                    if (dVar.f2765d != null) {
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
                if (this.f2753b.exists()) {
                    w(this.f2753b, this.f2755d, true);
                }
                w(this.f2754c, this.f2753b, false);
                this.f2755d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2753b, true), c.a.e0.d.h.c.c.a));
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
                d dVar = this.j.get(str);
                if (dVar != null && dVar.f2765d == null) {
                    for (int i = 0; i < this.f2758g; i++) {
                        File j = dVar.j(i);
                        if (j.exists() && !j.delete()) {
                            throw new IOException("failed to delete " + j);
                        }
                        this.f2759h -= dVar.f2763b[i];
                        dVar.f2763b[i] = 0;
                    }
                    this.k++;
                    this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.j.remove(str);
                    if (p()) {
                        this.m.submit(this.n);
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
            while (this.f2759h > this.f2757f) {
                v(this.j.entrySet().iterator().next().getKey());
            }
        }
    }

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }
}
