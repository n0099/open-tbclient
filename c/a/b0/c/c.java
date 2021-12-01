package c.a.b0.c;

import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.d0.h;
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
public class c extends LruCache<String, c.a.b0.c.b<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1400b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c.a.b0.c.b<File>, byte[]> f1401c;

    /* renamed from: d  reason: collision with root package name */
    public long f1402d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f1403e;

    /* renamed from: f  reason: collision with root package name */
    public int f1404f;

    /* renamed from: g  reason: collision with root package name */
    public long f1405g;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1406e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1407f;

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
            this.f1406e = str;
            this.f1407f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f1406e);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f1407f.o(file.listFiles(), currentTimeMillis);
                } catch (Exception unused) {
                    this.f1407f.f1403e = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f1408e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.c.b f1409f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f1410g;

        public b(c cVar, byte[] bArr, c.a.b0.c.b bVar) {
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
            this.f1410g = cVar;
            this.f1408e = bArr;
            this.f1409f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    System.currentTimeMillis();
                    h.h(this.f1408e, (File) this.f1409f.a());
                    this.f1410g.put(((File) this.f1409f.a()).getName(), this.f1409f);
                    c.b(this.f1410g);
                    if (!this.f1410g.a.isEmpty()) {
                        for (e eVar : this.f1410g.a) {
                            eVar.c(((File) this.f1409f.a()).getName(), this.f1409f);
                        }
                    }
                    System.currentTimeMillis();
                    this.f1410g.f();
                } catch (Throwable unused) {
                    if (this.f1410g.a.isEmpty()) {
                        return;
                    }
                    for (e eVar2 : this.f1410g.a) {
                        eVar2.a(((File) this.f1409f.a()).getName(), this.f1409f);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.b0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0024c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.c.b f1411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1412f;

        public RunnableC0024c(c cVar, c.a.b0.c.b bVar) {
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
            this.f1412f = cVar;
            this.f1411e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f1411e != null) {
                        System.currentTimeMillis();
                        ((File) this.f1411e.a()).getName();
                        c.c(this.f1412f);
                        this.f1411e.e();
                        System.currentTimeMillis();
                    }
                    this.f1412f.f();
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
        void a(String str, c.a.b0.c.b<File> bVar);

        void b(String str, c.a.b0.c.b<File> bVar);

        void c(String str, c.a.b0.c.b<File> bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1950440289, "Lc/a/b0/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1950440289, "Lc/a/b0/c/c;");
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
        this.f1403e = false;
        this.f1404f = 0;
        this.f1405g = 2592000000L;
        this.f1400b = str;
        this.f1401c = new HashMap<>();
    }

    public static /* synthetic */ int b(c cVar) {
        int i2 = cVar.f1404f;
        cVar.f1404f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.f1404f;
        cVar.f1404f = i2 - 1;
        return i2;
    }

    public static c l(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i2)) == null) {
            c cVar = new c(i2, str);
            cVar.f1403e = false;
            c.a.b0.a0.b.c(new a(str, cVar), "restore_cache_from_disk", 3);
            return cVar;
        }
        return (c) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        g((c.a.b0.c.b) super.remove(str));
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            c.a.b0.u.a.b(this.a, eVar);
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f1402d < this.f1405g) {
                    return;
                }
                System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f1402d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    c.a.b0.c.b bVar = (c.a.b0.c.b) snapshot.get(str);
                    if (bVar.d(this.f1405g)) {
                        ((File) ((c.a.b0.c.b) super.remove(str)).a()).delete();
                        this.f1404f--;
                    } else if (((File) bVar.a()).lastModified() < this.f1402d) {
                        this.f1402d = ((File) bVar.a()).lastModified();
                    }
                }
                System.currentTimeMillis();
            }
        }
    }

    public final void g(c.a.b0.c.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c.a.b0.a0.b.c(new RunnableC0024c(this, bVar), "delete_disk_file_async", 3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: h */
    public void entryRemoved(boolean z, String str, c.a.b0.c.b<File> bVar, c.a.b0.c.b<File> bVar2) {
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
    public c.a.b0.c.b<File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.b0.c.b<File> bVar = (c.a.b0.c.b) super.get(str);
            if (bVar != null) {
                try {
                    bVar.a().setLastModified(System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
        return (c.a.b0.c.b) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1400b : (String) invokeV.objValue;
    }

    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.f1403e = true;
                if (this.f1401c != null) {
                    for (c.a.b0.c.b<File> bVar : this.f1401c.keySet()) {
                        r(bVar, this.f1401c.get(bVar));
                    }
                    this.f1401c.clear();
                    this.f1401c = null;
                }
            }
        }
    }

    public final void m(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) && file.exists()) {
            super.put(str, new c.a.b0.c.b(file));
            this.f1404f++;
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
                        this.f1402d = file.lastModified();
                    }
                } else {
                    this.f1402d = System.currentTimeMillis();
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
    public int sizeOf(String str, c.a.b0.c.b<File> bVar) {
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

    public void q(byte[] bArr, c.a.b0.c.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, bArr, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f1403e) {
            r(bVar, bArr);
        } else {
            this.f1401c.put(bVar, bArr);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            c.a.b0.c.b<File> i2 = i(str);
            return i2 != null && i2.a().exists();
        }
        return invokeL.booleanValue;
    }

    public final void r(c.a.b0.c.b<File> bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bVar, bArr) == null) {
            c.a.b0.a0.b.c(new b(this, bArr, bVar), "store_cache_to_disk", 3);
        }
    }
}
