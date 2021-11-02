package b.a.j0.a.c;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
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
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes.dex */
public class d extends LruCache<String, b.a.j0.a.c.c<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f3018a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3019b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<b.a.j0.a.c.c<File>, byte[]> f3020c;

    /* renamed from: d  reason: collision with root package name */
    public long f3021d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3022e;

    /* renamed from: f  reason: collision with root package name */
    public int f3023f;

    /* renamed from: g  reason: collision with root package name */
    public long f3024g;

    /* loaded from: classes.dex */
    public static class a extends b.a.j0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f3026h;

        public a(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3025g = str;
            this.f3026h = dVar;
        }

        @Override // b.a.j0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f3025g);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f3026h.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception e2) {
                    this.f3026h.f3022e = true;
                    b.a.j0.a.k.b i2 = b.a.j0.a.k.b.i();
                    i2.a("Disk cache initialize failed for " + e2.getMessage());
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.a.j0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f3027g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.j0.a.c.c f3028h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f3029i;

        public b(d dVar, byte[] bArr, b.a.j0.a.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bArr, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3029i = dVar;
            this.f3027g = bArr;
            this.f3028h = cVar;
        }

        @Override // b.a.j0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    b.a.j0.a.k.d.b(this.f3027g, (File) this.f3028h.a());
                    this.f3029i.put(((File) this.f3028h.a()).getName(), this.f3028h);
                    d.b(this.f3029i);
                    if (!this.f3029i.f3018a.isEmpty()) {
                        for (e eVar : this.f3029i.f3018a) {
                            eVar.c(((File) this.f3028h.a()).getName(), this.f3028h);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = this.f3029i;
                    dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f3028h.a()).getName() + "\nStatus:" + this.f3029i.t());
                    this.f3029i.g();
                    return null;
                } catch (Throwable th) {
                    if (!this.f3029i.f3018a.isEmpty()) {
                        for (e eVar2 : this.f3029i.f3018a) {
                            eVar2.b(((File) this.f3028h.a()).getName(), this.f3028h);
                        }
                    }
                    b.a.j0.a.k.b i2 = b.a.j0.a.k.b.i();
                    i2.a("Failed to save file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.j0.a.l.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.j0.a.c.c f3030g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f3031h;

        public c(d dVar, b.a.j0.a.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3031h = dVar;
            this.f3030g = cVar;
        }

        @Override // b.a.j0.a.l.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f3030g != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.f3030g.a()).getName();
                        d.c(this.f3031h);
                        this.f3030g.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        d dVar = this.f3031h;
                        dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.f3031h.g();
                    return null;
                } catch (Throwable th) {
                    b.a.j0.a.k.b i2 = b.a.j0.a.k.b.i();
                    i2.a("Failed to delete file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* renamed from: b.a.j0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0073d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0073d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified())) : invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str, b.a.j0.a.c.c<File> cVar);

        void b(String str, b.a.j0.a.c.c<File> cVar);

        void c(String str, b.a.j0.a.c.c<File> cVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1188993139, "Lb/a/j0/a/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1188993139, "Lb/a/j0/a/c/d;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i2, String str) {
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
        this.f3018a = new ArrayList();
        this.f3022e = false;
        this.f3023f = 0;
        this.f3024g = 2592000000L;
        this.f3019b = str;
        this.f3020c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f3023f;
        dVar.f3023f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f3023f;
        dVar.f3023f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            d dVar = new d(i2, str);
            dVar.f3022e = false;
            b.a.j0.a.l.c.a().c(new a(str, dVar));
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        h((b.a.j0.a.c.c) super.remove(str));
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f3018a.add(eVar);
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f3021d < this.f3024g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f3021d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    b.a.j0.a.c.c cVar = (b.a.j0.a.c.c) snapshot.get(str);
                    if (cVar.d(this.f3024g)) {
                        ((File) ((b.a.j0.a.c.c) super.remove(str)).a()).delete();
                        this.f3023f--;
                    } else if (((File) cVar.a()).lastModified() < this.f3021d) {
                        this.f3021d = ((File) cVar.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    public final void h(b.a.j0.a.c.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            b.a.j0.a.l.c.a().c(new c(this, cVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, b.a.j0.a.c.c<File> cVar, b.a.j0.a.c.c<File> cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, cVar, cVar2}) == null) {
            super.entryRemoved(z, str, cVar, cVar2);
            if (z && cVar != null) {
                h(cVar);
            }
            if (!z || this.f3018a.isEmpty()) {
                return;
            }
            for (e eVar : this.f3018a) {
                eVar.a(str, cVar);
            }
        }
    }

    public b.a.j0.a.c.c<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            b.a.j0.a.c.c<File> cVar = (b.a.j0.a.c.c) super.get(str);
            if (cVar != null) {
                try {
                    cVar.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable th) {
                    b.a.j0.a.k.b i2 = b.a.j0.a.k.b.i();
                    i2.a("Failed to update file. " + th);
                }
            }
            return cVar;
        }
        return (b.a.j0.a.c.c) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3019b : (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? super.maxSize() : invokeV.longValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    public final synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f3022e = true;
                if (this.f3020c != null) {
                    for (b.a.j0.a.c.c<File> cVar : this.f3020c.keySet()) {
                        v(cVar, this.f3020c.get(cVar));
                    }
                    this.f3020c.clear();
                    this.f3020c = null;
                }
            }
        }
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, file) == null) && file.exists()) {
            super.put(str, new b.a.j0.a.c.c(file));
            this.f3023f++;
        }
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) && this.f3018a.contains(eVar)) {
            this.f3018a.remove(eVar);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? j(str) != null && j(str).a().exists() : invokeL.booleanValue;
    }

    public final void r(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new C0073d(this));
                if (priorityQueue.size() > 0) {
                    this.f3021d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.f3021d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    p(file.getName(), file);
                }
            }
            m("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
            n();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, b.a.j0.a.c.c<File> cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, cVar)) == null) {
            if (cVar == null) {
                return super.sizeOf(null, null);
            }
            return cVar.f();
        }
        return invokeLL.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int hitCount = hitCount() + missCount();
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f3023f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
        }
        return (String) invokeV.objValue;
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            synchronized (this) {
                super.trimToSize(i2);
            }
        }
    }

    public void u(byte[] bArr, b.a.j0.a.c.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bArr, cVar) == null) || cVar == null) {
            return;
        }
        if (this.f3022e) {
            v(cVar, bArr);
        } else {
            this.f3020c.put(cVar, bArr);
        }
    }

    public final void v(b.a.j0.a.c.c<File> cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, cVar, bArr) == null) {
            b.a.j0.a.l.c.a().c(new b(this, bArr, cVar));
        }
    }
}
