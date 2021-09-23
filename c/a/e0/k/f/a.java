package c.a.e0.k.f;

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
    public final File f3147e;

    /* renamed from: f  reason: collision with root package name */
    public final File f3148f;

    /* renamed from: g  reason: collision with root package name */
    public final File f3149g;

    /* renamed from: h  reason: collision with root package name */
    public final File f3150h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3151i;

    /* renamed from: j  reason: collision with root package name */
    public long f3152j;
    public final int k;
    public long l;
    public Writer m;
    public final LinkedHashMap<String, d> n;
    public int o;
    public long p;
    public final ThreadPoolExecutor q;
    public final Callable<Void> r;

    /* renamed from: c.a.e0.k.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0057a implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3153e;

        public CallableC0057a(a aVar) {
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
            this.f3153e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.f3153e) {
                    if (this.f3153e.m == null) {
                        return null;
                    }
                    this.f3153e.D();
                    if (this.f3153e.B()) {
                        this.f3153e.F();
                        this.f3153e.o = 0;
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
        public final d f3154a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f3155b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3156c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3157d;

        /* renamed from: c.a.e0.k.f.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0058a extends FilterOutputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f3158e;

            public /* synthetic */ C0058a(c cVar, OutputStream outputStream, CallableC0057a callableC0057a) {
                this(cVar, outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        ((FilterOutputStream) this).out.close();
                    } catch (IOException unused) {
                        this.f3158e.f3156c = true;
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
                        this.f3158e.f3156c = true;
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
                        this.f3158e.f3156c = true;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0058a(c cVar, OutputStream outputStream) {
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
                this.f3158e = cVar;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                    try {
                        ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    } catch (IOException unused) {
                        this.f3158e.f3156c = true;
                    }
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, CallableC0057a callableC0057a) {
            this(aVar, dVar);
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3157d.n(this, false);
            }
        }

        public OutputStream e(int i2) {
            InterceptResult invokeI;
            FileOutputStream fileOutputStream;
            C0058a c0058a;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 < 0 || i2 >= this.f3157d.k) {
                    throw new IllegalArgumentException("Expected index " + i2 + " to be greater than 0 and less than the maximum value count of " + this.f3157d.k);
                }
                synchronized (this.f3157d) {
                    if (this.f3154a.f3162d == this) {
                        if (!this.f3154a.f3161c) {
                            this.f3155b[i2] = true;
                        }
                        File n = this.f3154a.n(i2);
                        try {
                            fileOutputStream = new FileOutputStream(n);
                        } catch (FileNotFoundException unused) {
                            this.f3157d.f3147e.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(n);
                            } catch (FileNotFoundException unused2) {
                                return a.t;
                            }
                        }
                        c0058a = new C0058a(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                return c0058a;
            }
            return (OutputStream) invokeI.objValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f3156c) {
                    this.f3157d.n(this, false);
                    this.f3157d.A(this.f3154a.f3159a);
                    return;
                }
                this.f3157d.n(this, true);
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
            this.f3157d = aVar;
            this.f3154a = dVar;
            this.f3155b = dVar.f3161c ? null : new boolean[aVar.k];
        }
    }

    /* loaded from: classes.dex */
    public final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f3159a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f3160b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3161c;

        /* renamed from: d  reason: collision with root package name */
        public c f3162d;

        /* renamed from: e  reason: collision with root package name */
        public long f3163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3164f;

        public /* synthetic */ d(a aVar, String str, CallableC0057a callableC0057a) {
            this(aVar, str);
        }

        public String a() {
            InterceptResult invokeV;
            long[] jArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                StringBuilder sb = new StringBuilder();
                for (long j2 : this.f3160b) {
                    sb.append(' ');
                    sb.append(j2);
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
                if (strArr.length == this.f3164f.k) {
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            this.f3160b[i2] = Long.parseLong(strArr[i2]);
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
                File file = this.f3164f.f3147e;
                return new File(file, this.f3159a + "." + i2);
            }
            return (File) invokeI.objValue;
        }

        public File n(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                File file = this.f3164f.f3147e;
                return new File(file, this.f3159a + "." + i2 + ".tmp");
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
            this.f3164f = aVar;
            this.f3159a = str;
            this.f3160b = new long[aVar.k];
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f3165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3166f;

        public /* synthetic */ e(a aVar, String str, long j2, InputStream[] inputStreamArr, long[] jArr, CallableC0057a callableC0057a) {
            this(aVar, str, j2, inputStreamArr, jArr);
        }

        public InputStream a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f3165e[i2] : (InputStream) invokeI.objValue;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                for (InputStream inputStream : this.f3165e) {
                    c.a.e0.k.f.c.a(inputStream);
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
            this.f3166f = aVar;
            this.f3165e = inputStreamArr;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1629308645, "Lc/a/e0/k/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1629308645, "Lc/a/e0/k/f/a;");
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
        this.r = new CallableC0057a(this);
        this.f3147e = file;
        this.f3151i = i2;
        this.f3148f = new File(file, "journal");
        this.f3149g = new File(file, "journal.tmp");
        this.f3150h = new File(file, "journal.bkp");
        this.k = i3;
        this.f3152j = j2;
    }

    public static a j(File file, int i2, int i3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)})) == null) {
            if (j2 > 0) {
                if (i3 > 0) {
                    File file2 = new File(file, "journal.bkp");
                    if (file2.exists()) {
                        File file3 = new File(file, "journal");
                        if (file3.exists()) {
                            file2.delete();
                        } else {
                            m(file2, file3, false);
                        }
                    }
                    a aVar = new a(file, i2, i3, j2);
                    if (aVar.f3148f.exists()) {
                        try {
                            aVar.E();
                            aVar.C();
                            return aVar;
                        } catch (IOException e2) {
                            c.a.e0.n.d.b("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                            aVar.s();
                        }
                    }
                    file.mkdirs();
                    a aVar2 = new a(file, i2, i3, j2);
                    aVar2.F();
                    return aVar2;
                }
                throw new IllegalArgumentException("valueCount <= 0");
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return (a) invokeCommon.objValue;
    }

    public static void m(File file, File file2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65543, null, file, file2, z) == null) {
            if (z) {
                q(file2);
            }
            if (!file.renameTo(file2)) {
                throw new IOException();
            }
        }
    }

    public static void q(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, file) == null) && file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public synchronized boolean A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                z();
                y(str);
                d dVar = this.n.get(str);
                if (dVar != null && dVar.f3162d == null) {
                    for (int i2 = 0; i2 < this.k; i2++) {
                        File k = dVar.k(i2);
                        if (k.exists() && !k.delete()) {
                            throw new IOException("failed to delete " + k);
                        }
                        this.l -= dVar.f3160b[i2];
                        dVar.f3160b[i2] = 0;
                    }
                    this.o++;
                    this.m.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.n.remove(str);
                    if (B()) {
                        this.q.submit(this.r);
                    }
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.o;
            return i2 >= 2000 && i2 >= this.n.size();
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            q(this.f3149g);
            Iterator<d> it = this.n.values().iterator();
            while (it.hasNext()) {
                d next = it.next();
                int i2 = 0;
                if (next.f3162d != null) {
                    next.f3162d = null;
                    while (i2 < this.k) {
                        q(next.k(i2));
                        q(next.n(i2));
                        i2++;
                    }
                    it.remove();
                } else {
                    while (i2 < this.k) {
                        this.l += next.f3160b[i2];
                        i2++;
                    }
                }
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (this.l > this.f3152j) {
                A(this.n.entrySet().iterator().next().getKey());
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
            return;
        }
        c.a.e0.k.f.b bVar = new c.a.e0.k.f.b(new FileInputStream(this.f3148f), c.a.e0.k.f.c.f3173a);
        try {
            String n = bVar.n();
            String n2 = bVar.n();
            String n3 = bVar.n();
            String n4 = bVar.n();
            String n5 = bVar.n();
            if (!"libcore.io.DiskLruCache".equals(n) || !"1".equals(n2) || !Integer.toString(this.f3151i).equals(n3) || !Integer.toString(this.k).equals(n4) || !"".equals(n5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected journal header: [");
                sb.append(n);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(n2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(n4);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(n5);
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                throw new IOException(sb.toString());
            }
            int i2 = 0;
            while (true) {
                try {
                    x(bVar.n());
                    i2++;
                } catch (EOFException unused) {
                    this.o = i2 - this.n.size();
                    if (bVar.g()) {
                        F();
                    } else {
                        this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3148f, true), c.a.e0.k.f.c.f3173a));
                    }
                    c.a.e0.k.f.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            c.a.e0.k.f.c.a(bVar);
            throw th;
        }
    }

    public final synchronized void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                Writer writer = this.m;
                if (writer != null) {
                    writer.close();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3149g), c.a.e0.k.f.c.f3173a));
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write("1");
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.f3151i));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(Integer.toString(this.k));
                bufferedWriter.write(StringUtils.LF);
                bufferedWriter.write(StringUtils.LF);
                for (d dVar : this.n.values()) {
                    if (dVar.f3162d != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DIRTY ");
                        sb.append(dVar.f3159a);
                        sb.append('\n');
                        bufferedWriter.write(sb.toString());
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("CLEAN ");
                        sb2.append(dVar.f3159a);
                        sb2.append(dVar.a());
                        sb2.append('\n');
                        bufferedWriter.write(sb2.toString());
                    }
                }
                bufferedWriter.close();
                if (this.f3148f.exists()) {
                    m(this.f3148f, this.f3150h, true);
                }
                m(this.f3149g, this.f3148f, false);
                this.f3150h.delete();
                this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3148f, true), c.a.e0.k.f.c.f3173a));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.m == null) {
                    return;
                }
                Iterator it = new ArrayList(this.n.values()).iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.f3162d != null) {
                        dVar.f3162d.c();
                    }
                }
                D();
                this.m.close();
                this.m = null;
            }
        }
    }

    public synchronized void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                z();
                D();
                this.m.flush();
            }
        }
    }

    public final synchronized c i(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j2)) == null) {
            synchronized (this) {
                z();
                y(str);
                d dVar = this.n.get(str);
                if (j2 == -1 || (dVar != null && dVar.f3163e == j2)) {
                    if (dVar != null) {
                        if (dVar.f3162d != null) {
                            return null;
                        }
                    } else {
                        dVar = new d(this, str, null);
                        this.n.put(str, dVar);
                    }
                    c cVar = new c(this, dVar, null);
                    dVar.f3162d = cVar;
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

    public final synchronized void n(c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, cVar, z) == null) {
            synchronized (this) {
                d dVar = cVar.f3154a;
                if (dVar.f3162d == cVar) {
                    if (z && !dVar.f3161c) {
                        for (int i2 = 0; i2 < this.k; i2++) {
                            if (cVar.f3155b[i2]) {
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
                                long j2 = dVar.f3160b[i3];
                                long length = k.length();
                                dVar.f3160b[i3] = length;
                                this.l = (this.l - j2) + length;
                            }
                        } else {
                            q(n);
                        }
                    }
                    this.o++;
                    dVar.f3162d = null;
                    if (!dVar.f3161c && !z) {
                        this.n.remove(dVar.f3159a);
                        this.m.write("REMOVE " + dVar.f3159a + '\n');
                        this.m.flush();
                        if (this.l <= this.f3152j || B()) {
                            this.q.submit(this.r);
                        }
                        return;
                    }
                    dVar.f3161c = true;
                    this.m.write("CLEAN " + dVar.f3159a + dVar.a() + '\n');
                    if (z) {
                        long j3 = this.p;
                        this.p = 1 + j3;
                        dVar.f3163e = j3;
                    }
                    this.m.flush();
                    if (this.l <= this.f3152j) {
                    }
                    this.q.submit(this.r);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            close();
            c.a.e0.k.f.c.b(this.f3147e);
        }
    }

    public c u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? i(str, -1L) : (c) invokeL.objValue;
    }

    public synchronized e w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            synchronized (this) {
                z();
                y(str);
                d dVar = this.n.get(str);
                if (dVar == null) {
                    return null;
                }
                if (dVar.f3161c) {
                    InputStream[] inputStreamArr = new InputStream[this.k];
                    for (int i2 = 0; i2 < this.k; i2++) {
                        try {
                            inputStreamArr[i2] = new FileInputStream(dVar.k(i2));
                        } catch (FileNotFoundException unused) {
                            for (int i3 = 0; i3 < this.k && inputStreamArr[i3] != null; i3++) {
                                c.a.e0.k.f.c.a(inputStreamArr[i3]);
                            }
                            return null;
                        }
                    }
                    this.o++;
                    this.m.append((CharSequence) ("READ " + str + '\n'));
                    if (B()) {
                        this.q.submit(this.r);
                    }
                    return new e(this, str, dVar.f3163e, inputStreamArr, dVar.f3160b, null);
                }
                return null;
            }
        }
        return (e) invokeL.objValue;
    }

    public final void x(String str) {
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
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
                    dVar.f3161c = true;
                    dVar.f3162d = null;
                    dVar.i(split);
                    return;
                } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                    dVar.f3162d = new c(this, dVar, null);
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

    public final void y(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || s.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }
}
