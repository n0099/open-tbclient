package c.a.k0.a.d;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.h0.h;
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
public class d extends LruCache<String, c.a.k0.a.d.c<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3939b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<c.a.k0.a.d.c<File>, byte[]> f3940c;

    /* renamed from: d  reason: collision with root package name */
    public long f3941d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3942e;

    /* renamed from: f  reason: collision with root package name */
    public int f3943f;

    /* renamed from: g  reason: collision with root package name */
    public long f3944g;

    /* loaded from: classes.dex */
    public static class a extends c.a.k0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f3945g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f3946h;

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
            this.f3945g = str;
            this.f3946h = dVar;
        }

        @Override // c.a.k0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.f3945g);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.f3946h.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception unused) {
                    this.f3946h.f3942e = true;
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.k0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f3947g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.k0.a.d.c f3948h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f3949i;

        public b(d dVar, byte[] bArr, c.a.k0.a.d.c cVar) {
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
            this.f3949i = dVar;
            this.f3947g = bArr;
            this.f3948h = cVar;
        }

        @Override // c.a.k0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    h.i(this.f3947g, (File) this.f3948h.a());
                    this.f3949i.put(((File) this.f3948h.a()).getName(), this.f3948h);
                    d.b(this.f3949i);
                    if (!this.f3949i.a.isEmpty()) {
                        for (e eVar : this.f3949i.a) {
                            eVar.c(((File) this.f3948h.a()).getName(), this.f3948h);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = this.f3949i;
                    dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f3948h.a()).getName() + "\nStatus:" + this.f3949i.t());
                    this.f3949i.g();
                    return null;
                } catch (Throwable unused) {
                    if (this.f3949i.a.isEmpty()) {
                        return null;
                    }
                    for (e eVar2 : this.f3949i.a) {
                        eVar2.b(((File) this.f3948h.a()).getName(), this.f3948h);
                    }
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.k0.a.m.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.k0.a.d.c f3950g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f3951h;

        public c(d dVar, c.a.k0.a.d.c cVar) {
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
            this.f3951h = dVar;
            this.f3950g = cVar;
        }

        @Override // c.a.k0.a.m.b
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.f3950g != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.f3950g.a()).getName();
                        d.c(this.f3951h);
                        this.f3950g.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        d dVar = this.f3951h;
                        dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.f3951h.g();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* renamed from: c.a.k0.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0188d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0188d(d dVar) {
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
        void a(String str, c.a.k0.a.d.c<File> cVar);

        void b(String str, c.a.k0.a.d.c<File> cVar);

        void c(String str, c.a.k0.a.d.c<File> cVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-911834540, "Lc/a/k0/a/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-911834540, "Lc/a/k0/a/d/d;");
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
        this.f3942e = false;
        this.f3943f = 0;
        this.f3944g = 2592000000L;
        this.f3939b = str;
        this.f3940c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f3943f;
        dVar.f3943f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f3943f;
        dVar.f3943f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i2)) == null) {
            d dVar = new d(i2, str);
            dVar.f3942e = false;
            c.a.k0.a.m.c.a().c(new a(str, dVar));
            return dVar;
        }
        return (d) invokeLI.objValue;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || super.get(str) == null) {
            return;
        }
        h((c.a.k0.a.d.c) super.remove(str));
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
                if (System.currentTimeMillis() - this.f3941d < this.f3944g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.f3941d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    c.a.k0.a.d.c cVar = (c.a.k0.a.d.c) snapshot.get(str);
                    if (cVar.d(this.f3944g)) {
                        ((File) ((c.a.k0.a.d.c) super.remove(str)).a()).delete();
                        this.f3943f--;
                    } else if (((File) cVar.a()).lastModified() < this.f3941d) {
                        this.f3941d = ((File) cVar.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    public final void h(c.a.k0.a.d.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            c.a.k0.a.m.c.a().c(new c(this, cVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, c.a.k0.a.d.c<File> cVar, c.a.k0.a.d.c<File> cVar2) {
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

    public c.a.k0.a.d.c<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.k0.a.d.c<File> cVar = (c.a.k0.a.d.c) super.get(str);
            if (cVar != null) {
                try {
                    cVar.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable unused) {
                }
            }
            return cVar;
        }
        return (c.a.k0.a.d.c) invokeL.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f3939b : (String) invokeV.objValue;
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
                this.f3942e = true;
                if (this.f3940c != null) {
                    for (c.a.k0.a.d.c<File> cVar : this.f3940c.keySet()) {
                        v(cVar, this.f3940c.get(cVar));
                    }
                    this.f3940c.clear();
                    this.f3940c = null;
                }
            }
        }
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, file) == null) && file.exists()) {
            super.put(str, new c.a.k0.a.d.c(file));
            this.f3943f++;
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
                PriorityQueue priorityQueue = new PriorityQueue(11, new C0188d(this));
                if (priorityQueue.size() > 0) {
                    this.f3941d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.f3941d = System.currentTimeMillis();
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
    public int sizeOf(String str, c.a.k0.a.d.c<File> cVar) {
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
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f3943f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
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

    public void u(byte[] bArr, c.a.k0.a.d.c<File> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, bArr, cVar) == null) || cVar == null) {
            return;
        }
        if (this.f3942e) {
            v(cVar, bArr);
        } else {
            this.f3940c.put(cVar, bArr);
        }
    }

    public final void v(c.a.k0.a.d.c<File> cVar, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, cVar, bArr) == null) {
            c.a.k0.a.m.c.a().c(new b(this, bArr, cVar));
        }
    }
}
