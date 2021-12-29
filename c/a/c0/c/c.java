package c.a.c0.c;

import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.c0.d0.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes.dex */
public class c extends LruCache<String, c.a.c0.c.b<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1845b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c.a.c0.c.b<File>, byte[]> f1846c;

    /* renamed from: d  reason: collision with root package name */
    public long f1847d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f1848e;

    /* renamed from: f  reason: collision with root package name */
    public int f1849f;

    /* renamed from: g  reason: collision with root package name */
    public long f1850g;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1851e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1852f;

        public a(String str, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1851e = str;
            this.f1852f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f1851e);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f1852f.o(file.listFiles(), currentTimeMillis);
                } catch (Exception unused) {
                    this.f1852f.f1848e = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f1853e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.c.b f1854f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f1855g;

        public b(c cVar, byte[] bArr, c.a.c0.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bArr, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1855g = cVar;
            this.f1853e = bArr;
            this.f1854f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    System.currentTimeMillis();
                    h.h(this.f1853e, (File) this.f1854f.a());
                    this.f1855g.put(((File) this.f1854f.a()).getName(), this.f1854f);
                    c.b(this.f1855g);
                    if (!this.f1855g.a.isEmpty()) {
                        for (e eVar : this.f1855g.a) {
                            eVar.c(((File) this.f1854f.a()).getName(), this.f1854f);
                        }
                    }
                    System.currentTimeMillis();
                    this.f1855g.f();
                } catch (Throwable unused) {
                    if (this.f1855g.a.isEmpty()) {
                        return;
                    }
                    for (e eVar2 : this.f1855g.a) {
                        eVar2.a(((File) this.f1854f.a()).getName(), this.f1854f);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.c0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0047c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.c.b f1856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1857f;

        public RunnableC0047c(c cVar, c.a.c0.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1857f = cVar;
            this.f1856e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f1856e != null) {
                        System.currentTimeMillis();
                        ((File) this.f1856e.a()).getName();
                        c.c(this.f1857f);
                        this.f1856e.e();
                        System.currentTimeMillis();
                    }
                    this.f1857f.f();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? Long.compare(file.lastModified(), file2.lastModified()) : invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str, c.a.c0.c.b<File> bVar);

        void b(String str, c.a.c0.c.b<File> bVar);

        void c(String str, c.a.c0.c.b<File> bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062936608, "Lc/a/c0/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062936608, "Lc/a/c0/c/c;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f1848e = false;
        this.f1849f = 0;
        this.f1850g = 2592000000L;
        this.f1845b = str;
        this.f1846c = new HashMap<>();
    }

    public static /* synthetic */ int b(c cVar) {
        int i2 = cVar.f1849f;
        cVar.f1849f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f1849f;
        cVar.f1849f = i2 - 1;
        return i2;
    }

    public static c l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            c cVar = new c(i2, str);
            cVar.f1848e = false;
            c.a.c0.a0.b.c(new a(str, cVar), "restore_cache_from_disk", 3);
            return cVar;
        }
        return (c) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        g((c.a.c0.c.b) super.remove(str));
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            c.a.c0.u.a.b(this.a, eVar);
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f1847d < this.f1850g) {
                    return;
                }
                System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f1847d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    c.a.c0.c.b bVar = (c.a.c0.c.b) snapshot.get(str);
                    if (bVar.d(this.f1850g)) {
                        ((File) ((c.a.c0.c.b) super.remove(str)).a()).delete();
                        this.f1849f--;
                    } else if (((File) bVar.a()).lastModified() < this.f1847d) {
                        this.f1847d = ((File) bVar.a()).lastModified();
                    }
                }
                System.currentTimeMillis();
            }
        }
    }

    public final void g(c.a.c0.c.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c.a.c0.a0.b.c(new RunnableC0047c(this, bVar), "delete_disk_file_async", 3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: h */
    public void entryRemoved(boolean z, String str, c.a.c0.c.b<File> bVar, c.a.c0.c.b<File> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, bVar, bVar2}) == null) {
            super.entryRemoved(z, str, bVar, bVar2);
            if (z && bVar != null) {
                g(bVar);
            }
            if (!z || this.a.isEmpty()) {
                return;
            }
            for (e eVar : this.a) {
                eVar.b(str, bVar);
            }
        }
    }

    @Nullable
    public c.a.c0.c.b<File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.c0.c.b<File> bVar = (c.a.c0.c.b) super.get(str);
            if (bVar != null) {
                try {
                    bVar.a().setLastModified(System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
        return (c.a.c0.c.b) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1845b : (String) invokeV.objValue;
    }

    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.f1848e = true;
                if (this.f1846c != null) {
                    for (c.a.c0.c.b<File> bVar : this.f1846c.keySet()) {
                        r(bVar, this.f1846c.get(bVar));
                    }
                    this.f1846c.clear();
                    this.f1846c = null;
                }
            }
        }
    }

    public final void m(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) && file.exists()) {
            super.put(str, new c.a.c0.c.b(file));
            this.f1849f++;
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public final void o(File[] fileArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, fileArr, j2) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    File file = (File) priorityQueue.peek();
                    if (file != null) {
                        this.f1847d = file.lastModified();
                    }
                } else {
                    this.f1847d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file2 = (File) priorityQueue.poll();
                    if (file2 != null) {
                        m(file2.getName(), file2);
                    }
                }
            }
            System.currentTimeMillis();
            k();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: p */
    public int sizeOf(String str, c.a.c0.c.b<File> bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, bVar)) == null) {
            if (bVar == null) {
                return super.sizeOf(null, null);
            }
            return bVar.f();
        }
        return invokeLL.intValue;
    }

    public void q(byte[] bArr, c.a.c0.c.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, bArr, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f1848e) {
            r(bVar, bArr);
        } else {
            this.f1846c.put(bVar, bArr);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            c.a.c0.c.b<File> i2 = i(str);
            return i2 != null && i2.a().exists();
        }
        return invokeL.booleanValue;
    }

    public final void r(c.a.c0.c.b<File> bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bVar, bArr) == null) {
            c.a.c0.a0.b.c(new b(this, bArr, bVar), "store_cache_to_disk", 3);
        }
    }
}
