package c.a.m0.a.d;

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
public class d extends LruCache<String, c.a.m0.a.d.c<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4524b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c.a.m0.a.d.c<File>, byte[]> f4525c;

    /* renamed from: d  reason: collision with root package name */
    public long f4526d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f4527e;

    /* renamed from: f  reason: collision with root package name */
    public int f4528f;

    /* renamed from: g  reason: collision with root package name */
    public long f4529g;

    /* loaded from: classes.dex */
    public static class a extends c.a.m0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4530g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f4531h;

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
            this.f4530g = str;
            this.f4531h = dVar;
        }

        @Override // c.a.m0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f4530g);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f4531h.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception e2) {
                    this.f4531h.f4527e = true;
                    c.a.m0.a.l.b i2 = c.a.m0.a.l.b.i();
                    i2.a("Disk cache initialize failed for " + e2.getMessage());
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.m0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f4532g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.m0.a.d.c f4533h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f4534i;

        public b(d dVar, byte[] bArr, c.a.m0.a.d.c cVar) {
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
            this.f4534i = dVar;
            this.f4532g = bArr;
            this.f4533h = cVar;
        }

        @Override // c.a.m0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    c.a.m0.a.l.d.b(this.f4532g, (File) this.f4533h.a());
                    this.f4534i.put(((File) this.f4533h.a()).getName(), this.f4533h);
                    d.b(this.f4534i);
                    if (!this.f4534i.a.isEmpty()) {
                        for (e eVar : this.f4534i.a) {
                            eVar.c(((File) this.f4533h.a()).getName(), this.f4533h);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = this.f4534i;
                    dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f4533h.a()).getName() + "\nStatus:" + this.f4534i.t());
                    this.f4534i.g();
                    return null;
                } catch (Throwable th) {
                    if (!this.f4534i.a.isEmpty()) {
                        for (e eVar2 : this.f4534i.a) {
                            eVar2.b(((File) this.f4533h.a()).getName(), this.f4533h);
                        }
                    }
                    c.a.m0.a.l.b i2 = c.a.m0.a.l.b.i();
                    i2.a("Failed to save file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.m0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.m0.a.d.c f4535g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f4536h;

        public c(d dVar, c.a.m0.a.d.c cVar) {
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
            this.f4536h = dVar;
            this.f4535g = cVar;
        }

        @Override // c.a.m0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f4535g != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.f4535g.a()).getName();
                        d.c(this.f4536h);
                        this.f4535g.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        d dVar = this.f4536h;
                        dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.f4536h.g();
                    return null;
                } catch (Throwable th) {
                    c.a.m0.a.l.b i2 = c.a.m0.a.l.b.i();
                    i2.a("Failed to delete file. " + th);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* renamed from: c.a.m0.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0211d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0211d(d dVar) {
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
        void a(String str, c.a.m0.a.d.c<File> cVar);

        void b(String str, c.a.m0.a.d.c<File> cVar);

        void c(String str, c.a.m0.a.d.c<File> cVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231776170, "Lc/a/m0/a/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231776170, "Lc/a/m0/a/d/d;");
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
        this.a = new ArrayList();
        this.f4527e = false;
        this.f4528f = 0;
        this.f4529g = 2592000000L;
        this.f4524b = str;
        this.f4525c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f4528f;
        dVar.f4528f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f4528f;
        dVar.f4528f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            d dVar = new d(i2, str);
            dVar.f4527e = false;
            c.a.m0.a.m.c.a().c(new a(str, dVar));
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        h((c.a.m0.a.d.c) super.remove(str));
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.a.add(eVar);
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.f4526d < this.f4529g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f4526d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    c.a.m0.a.d.c cVar = (c.a.m0.a.d.c) snapshot.get(str);
                    if (cVar.d(this.f4529g)) {
                        ((File) ((c.a.m0.a.d.c) super.remove(str)).a()).delete();
                        this.f4528f--;
                    } else if (((File) cVar.a()).lastModified() < this.f4526d) {
                        this.f4526d = ((File) cVar.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    public final void h(c.a.m0.a.d.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            c.a.m0.a.m.c.a().c(new c(this, cVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, c.a.m0.a.d.c<File> cVar, c.a.m0.a.d.c<File> cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, cVar, cVar2}) == null) {
            super.entryRemoved(z, str, cVar, cVar2);
            if (z && cVar != null) {
                h(cVar);
            }
            if (!z || this.a.isEmpty()) {
                return;
            }
            for (e eVar : this.a) {
                eVar.a(str, cVar);
            }
        }
    }

    public c.a.m0.a.d.c<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.m0.a.d.c<File> cVar = (c.a.m0.a.d.c) super.get(str);
            if (cVar != null) {
                try {
                    cVar.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable th) {
                    c.a.m0.a.l.b i2 = c.a.m0.a.l.b.i();
                    i2.a("Failed to update file. " + th);
                }
            }
            return cVar;
        }
        return (c.a.m0.a.d.c) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4524b : (String) invokeV.objValue;
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
                this.f4527e = true;
                if (this.f4525c != null) {
                    for (c.a.m0.a.d.c<File> cVar : this.f4525c.keySet()) {
                        v(cVar, this.f4525c.get(cVar));
                    }
                    this.f4525c.clear();
                    this.f4525c = null;
                }
            }
        }
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, file) == null) && file.exists()) {
            super.put(str, new c.a.m0.a.d.c(file));
            this.f4528f++;
        }
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? j(str) != null && j(str).a().exists() : invokeL.booleanValue;
    }

    public final void r(File[] fileArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, fileArr, j2) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new C0211d(this));
                if (priorityQueue.size() > 0) {
                    this.f4526d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.f4526d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    p(file.getName(), file);
                }
            }
            m("Complete restore cache using " + (System.currentTimeMillis() - j2) + "ms: ");
            n();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, c.a.m0.a.d.c<File> cVar) {
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
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f4528f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
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

    public void u(byte[] bArr, c.a.m0.a.d.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bArr, cVar) == null) || cVar == null) {
            return;
        }
        if (this.f4527e) {
            v(cVar, bArr);
        } else {
            this.f4525c.put(cVar, bArr);
        }
    }

    public final void v(c.a.m0.a.d.c<File> cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, cVar, bArr) == null) {
            c.a.m0.a.m.c.a().c(new b(this, bArr, cVar));
        }
    }
}
