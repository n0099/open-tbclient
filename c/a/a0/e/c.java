package c.a.a0.e;

import android.util.LruCache;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.a0.h0.h;
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
public class c extends LruCache<String, c.a.a0.e.b<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1142b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c.a.a0.e.b<File>, byte[]> f1143c;

    /* renamed from: d  reason: collision with root package name */
    public long f1144d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f1145e;

    /* renamed from: f  reason: collision with root package name */
    public int f1146f;

    /* renamed from: g  reason: collision with root package name */
    public long f1147g;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f1148b;

        public a(String str, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f1148b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f1148b.o(file.listFiles(), currentTimeMillis);
                } catch (Exception unused) {
                    this.f1148b.f1145e = true;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.e.b f1149b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f1150c;

        public b(c cVar, byte[] bArr, c.a.a0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bArr, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1150c = cVar;
            this.a = bArr;
            this.f1149b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    System.currentTimeMillis();
                    h.i(this.a, (File) this.f1149b.a());
                    this.f1150c.put(((File) this.f1149b.a()).getName(), this.f1149b);
                    c.b(this.f1150c);
                    if (!this.f1150c.a.isEmpty()) {
                        for (e eVar : this.f1150c.a) {
                            eVar.c(((File) this.f1149b.a()).getName(), this.f1149b);
                        }
                    }
                    System.currentTimeMillis();
                    this.f1150c.f();
                } catch (Throwable unused) {
                    if (this.f1150c.a.isEmpty()) {
                        return;
                    }
                    for (e eVar2 : this.f1150c.a) {
                        eVar2.a(((File) this.f1149b.a()).getName(), this.f1149b);
                    }
                }
            }
        }
    }

    /* renamed from: c.a.a0.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0020c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.a0.e.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f1151b;

        public RunnableC0020c(c cVar, c.a.a0.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1151b = cVar;
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a != null) {
                        System.currentTimeMillis();
                        ((File) this.a.a()).getName();
                        c.c(this.f1151b);
                        this.a.e();
                        System.currentTimeMillis();
                    }
                    this.f1151b.f();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        void a(String str, c.a.a0.e.b<File> bVar);

        void b(String str, c.a.a0.e.b<File> bVar);

        void c(String str, c.a.a0.e.b<File> bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1457082908, "Lc/a/a0/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1457082908, "Lc/a/a0/e/c;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f1145e = false;
        this.f1146f = 0;
        this.f1147g = 2592000000L;
        this.f1142b = str;
        this.f1143c = new HashMap<>();
    }

    public static /* synthetic */ int b(c cVar) {
        int i = cVar.f1146f;
        cVar.f1146f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(c cVar) {
        int i = cVar.f1146f;
        cVar.f1146f = i - 1;
        return i;
    }

    public static c l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, str, i)) == null) {
            c cVar = new c(i, str);
            cVar.f1145e = false;
            c.a.a0.d0.b.c(new a(str, cVar), "restore_cache_from_disk", 3);
            return cVar;
        }
        return (c) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        g((c.a.a0.e.b) super.remove(str));
    }

    public void e(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            c.a.a0.x.a.b(this.a, eVar);
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f1144d < this.f1147g) {
                    return;
                }
                System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f1144d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    c.a.a0.e.b bVar = (c.a.a0.e.b) snapshot.get(str);
                    if (bVar.d(this.f1147g)) {
                        ((File) ((c.a.a0.e.b) super.remove(str)).a()).delete();
                        this.f1146f--;
                    } else if (((File) bVar.a()).lastModified() < this.f1144d) {
                        this.f1144d = ((File) bVar.a()).lastModified();
                    }
                }
                System.currentTimeMillis();
            }
        }
    }

    public final void g(c.a.a0.e.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c.a.a0.d0.b.c(new RunnableC0020c(this, bVar), "delete_disk_file_async", 3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: h */
    public void entryRemoved(boolean z, String str, c.a.a0.e.b<File> bVar, c.a.a0.e.b<File> bVar2) {
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
    public c.a.a0.e.b<File> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.a0.e.b<File> bVar = (c.a.a0.e.b) super.get(str);
            if (bVar != null) {
                try {
                    bVar.a().setLastModified(System.currentTimeMillis());
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
        return (c.a.a0.e.b) invokeL.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f1142b : (String) invokeV.objValue;
    }

    public final synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                this.f1145e = true;
                if (this.f1143c != null) {
                    for (c.a.a0.e.b<File> bVar : this.f1143c.keySet()) {
                        r(bVar, this.f1143c.get(bVar));
                    }
                    this.f1143c.clear();
                    this.f1143c = null;
                }
            }
        }
    }

    public final void m(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, file) == null) && file.exists()) {
            super.put(str, new c.a.a0.e.b(file));
            this.f1146f++;
        }
    }

    public void n(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public final void o(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    File file = (File) priorityQueue.peek();
                    if (file != null) {
                        this.f1144d = file.lastModified();
                    }
                } else {
                    this.f1144d = System.currentTimeMillis();
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
    public int sizeOf(String str, c.a.a0.e.b<File> bVar) {
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

    public void q(byte[] bArr, c.a.a0.e.b<File> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, bArr, bVar) == null) || bVar == null) {
            return;
        }
        if (this.f1145e) {
            r(bVar, bArr);
        } else {
            this.f1143c.put(bVar, bArr);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            c.a.a0.e.b<File> i = i(str);
            return i != null && i.a().exists();
        }
        return invokeL.booleanValue;
    }

    public final void r(c.a.a0.e.b<File> bVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, bVar, bArr) == null) {
            c.a.a0.d0.b.c(new b(this, bArr, bVar), "store_cache_to_disk", 3);
        }
    }
}
