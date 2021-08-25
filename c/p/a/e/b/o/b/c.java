package c.p.a.e.b.o.b;

import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.e;
import c.p.a.e.b.o.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static final ArrayList<String> f35283j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f35284a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f35285b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f35286c;

    /* renamed from: d  reason: collision with root package name */
    public int f35287d;

    /* renamed from: e  reason: collision with root package name */
    public long f35288e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f35289f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35290g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35291h;

    /* renamed from: i  reason: collision with root package name */
    public i f35292i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1555148929, "Lc/p/a/e/b/o/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1555148929, "Lc/p/a/e/b/o/b/c;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>(6);
        f35283j = arrayList;
        arrayList.add("Content-Length");
        f35283j.add("Content-Range");
        f35283j.add("Transfer-Encoding");
        f35283j.add(Util.ACCEPT_RANGES);
        f35283j.add(Util.ETAG);
        f35283j.add("Content-Disposition");
    }

    public c(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, list, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35286c = null;
        this.f35289f = new Object();
        this.f35284a = str;
        this.f35285b = list;
    }

    @Override // c.p.a.e.b.o.i
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Map<String, String> map = this.f35286c;
            if (map != null) {
                return map.get(str);
            }
            i iVar = this.f35292i;
            if (iVar != null) {
                return iVar.a(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.p.a.e.b.o.i
    public int b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f35287d : invokeV.intValue;
    }

    @Override // c.p.a.e.b.o.i
    public void c() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (iVar = this.f35292i) == null) {
            return;
        }
        iVar.c();
    }

    public void d() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this.f35289f) {
                if (this.f35291h && this.f35286c == null) {
                    this.f35289f.wait();
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void e() throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f35286c == null) {
            try {
                this.f35291h = true;
                this.f35292i = e.x(this.f35284a, this.f35285b);
                synchronized (this.f35289f) {
                    if (this.f35292i != null) {
                        HashMap hashMap = new HashMap();
                        this.f35286c = hashMap;
                        f(this.f35292i, hashMap);
                        this.f35287d = this.f35292i.b();
                        this.f35288e = System.currentTimeMillis();
                        this.f35290g = g(this.f35287d);
                    }
                    this.f35291h = false;
                    this.f35289f.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.f35289f) {
                    if (this.f35292i != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f35286c = hashMap2;
                        f(this.f35292i, hashMap2);
                        this.f35287d = this.f35292i.b();
                        this.f35288e = System.currentTimeMillis();
                        this.f35290g = g(this.f35287d);
                    }
                    this.f35291h = false;
                    this.f35289f.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final void f(i iVar, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, iVar, map) == null) || iVar == null || map == null) {
            return;
        }
        Iterator<String> it = f35283j.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, iVar.a(next));
        }
    }

    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 >= 200 && i2 < 300 : invokeI.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35290g : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? System.currentTimeMillis() - this.f35288e < b.f35280d : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35291h : invokeV.booleanValue;
    }

    public List<com.ss.android.socialbase.downloader.model.c> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35285b : (List) invokeV.objValue;
    }

    public Map<String, String> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f35286c : (Map) invokeV.objValue;
    }
}
