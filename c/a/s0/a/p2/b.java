package c.a.s0.a.p2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.e0.d;
import c.a.s0.a.k;
import c.a.s0.a.p2.a;
import c.a.s0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.WebAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8582f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f8583g;

    /* renamed from: h  reason: collision with root package name */
    public static final a.C0533a f8584h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ArrayList<c.a.s0.a.p2.a>> a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.s0.a.p2.e.a f8585b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Boolean f8586c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f8587d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8588e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8589e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8589e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f8589e.f8585b.l();
                this.f8589e.q().a(this.f8589e);
            }
        }
    }

    /* renamed from: c.a.s0.a.p2.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0534b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0534b() {
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

        public void a(@NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(236914252, "Lc/a/s0/a/p2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(236914252, "Lc/a/s0/a/p2/b;");
                return;
            }
        }
        f8582f = k.a;
        f8584h = new a.C0533a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap(32, 0.75f, true);
        c.a.s0.a.c1.a.g0().getSwitch("swan_cookie_enable", false);
        this.f8588e = false;
        this.f8585b = new c.a.s0.a.p2.e.a(this);
    }

    public static synchronized b l() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (b.class) {
                if (f8583g == null) {
                    f8583g = new b();
                }
                bVar = f8583g;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            synchronized (b.class) {
                if (f8583g != null) {
                    f8583g.r(z);
                }
                f8583g = null;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f8586c != null) {
                    d.k("SwanCookieManager", "acceptCookie =" + this.f8586c);
                    return this.f8586c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.f8587d == null) {
                    return false;
                }
                if (this.f8587d.booleanValue() && this.f8588e) {
                    z = true;
                }
                this.f8586c = Boolean.valueOf(z);
                d.k("SwanCookieManager", "mEnableStore =" + this.f8587d + "; mCookieABSwitch=" + this.f8588e);
                return this.f8586c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList<c.a.s0.a.p2.a> arrayList, c.a.s0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, aVar) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.f8577e < 0 || aVar.f8577e > currentTimeMillis) {
                    if (arrayList.size() >= 50) {
                        c.a.s0.a.p2.a aVar2 = new c.a.s0.a.p2.a();
                        aVar2.f8579g = currentTimeMillis;
                        Iterator<c.a.s0.a.p2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            c.a.s0.a.p2.a next = it.next();
                            if (next != null && next.f8579g < aVar2.f8579g && next.f8581i != 2) {
                                aVar2 = next;
                            }
                        }
                        aVar2.f8581i = 2;
                    }
                    aVar.f8579g = currentTimeMillis;
                    aVar.f8580h = currentTimeMillis;
                    aVar.f8581i = 0;
                    arrayList.add(aVar);
                }
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<c.a.s0.a.p2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d2 = c.d(str2);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<c.a.s0.a.p2.a> arrayList2 = this.a.get(d2);
                    if (arrayList2 == null) {
                        arrayList2 = this.f8585b.k(d2);
                        this.a.put(d2, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.s0.a.p2.a aVar = arrayList.get(i2);
                        if (!p(arrayList2, aVar, str)) {
                            d(arrayList2, aVar);
                        }
                    }
                }
            }
        }
    }

    public String f(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (f8582f) {
                String str3 = "getCookie url: " + str + "; defaultCookie=" + str2;
            }
            if (c.a.s0.a.d2.d.J().D() && a() && c.a(str)) {
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f8582f) {
                        String str4 = "Bad address: " + str;
                    }
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void g(c.a.s0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                if (aVar.f8581i == 2) {
                    String d2 = c.d(aVar.a);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<c.a.s0.a.p2.a> arrayList = this.a.get(d2);
                    if (arrayList != null) {
                        arrayList.remove(aVar);
                        if (arrayList.isEmpty()) {
                            this.a.remove(d2);
                        }
                    }
                }
            }
        }
    }

    public void h() {
        SwanAppConfigData P;
        SwanAppConfigData.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f8587d != null || (P = c.a.s0.a.d2.d.J().r().P()) == null || (cVar = P.r) == null) {
            return;
        }
        this.f8587d = Boolean.valueOf(cVar.a);
        d.k("SwanCookieManager", "enableStore =" + this.f8587d);
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webAddress, str)) == null) {
            synchronized (this) {
                String[] e2 = c.e(webAddress);
                if (e2 == null) {
                    return str;
                }
                String d2 = c.d(e2[0]);
                if (d2 == null) {
                    return str;
                }
                ArrayList<c.a.s0.a.p2.a> arrayList = this.a.get(d2);
                if (arrayList == null) {
                    arrayList = this.f8585b.k(d2);
                    this.a.put(d2, arrayList);
                }
                SortedSet<c.a.s0.a.p2.a> m = m(arrayList, webAddress.getScheme(), e2);
                if (m != null && !m.isEmpty()) {
                    String b2 = c.b(m, str);
                    if (f8582f) {
                        String str2 = "getCookie result:" + b2 + ";defaultCookie=" + str;
                    }
                    return b2;
                }
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? f(str, null) : (String) invokeL.objValue;
    }

    public final long k(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
            long j2 = 0;
            if (collection != null && !collection.isEmpty()) {
                for (String str : collection) {
                    if (str != null) {
                        j2 += str.length();
                    }
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public final synchronized SortedSet<c.a.s0.a.p2.a> m(ArrayList<c.a.s0.a.p2.a> arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(f8584h);
                        Iterator<c.a.s0.a.p2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            c.a.s0.a.p2.a next = it.next();
                            if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.f8577e < 0 || next.f8577e > currentTimeMillis)) {
                                if (!next.f8578f || "https".equals(str)) {
                                    if (next.f8581i != 2) {
                                        next.f8579g = currentTimeMillis;
                                        treeSet.add(next);
                                    }
                                }
                            }
                        }
                        return treeSet;
                    }
                }
                return null;
            }
        }
        return (SortedSet) invokeLLL.objValue;
    }

    public synchronized ArrayList<c.a.s0.a.p2.a> n() {
        InterceptResult invokeV;
        ArrayList<c.a.s0.a.p2.a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (ArrayList<c.a.s0.a.p2.a> arrayList2 : this.a.values()) {
                    if (arrayList2 != null) {
                        Iterator<c.a.s0.a.p2.a> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            c.a.s0.a.p2.a next = it.next();
                            if (next != null && next.f8581i != 1) {
                                arrayList.add(next);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f8588e : invokeV.booleanValue;
    }

    public final synchronized boolean p(ArrayList<c.a.s0.a.p2.a> arrayList, c.a.s0.a.p2.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, aVar, str)) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<c.a.s0.a.p2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    c.a.s0.a.p2.a next = it.next();
                    if (aVar.b(next)) {
                        if (aVar.f8577e >= 0 && aVar.f8577e <= currentTimeMillis) {
                            next.f8580h = currentTimeMillis;
                            next.f8581i = 2;
                            return true;
                        }
                        if (!next.f8578f || "https".equals(str)) {
                            next.f8576d = aVar.f8576d;
                            next.f8577e = aVar.f8577e;
                            next.f8578f = aVar.f8578f;
                            next.f8579g = currentTimeMillis;
                            next.f8580h = currentTimeMillis;
                            next.f8581i = 3;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    @Inject(force = false)
    public final synchronized C0534b q() {
        InterceptResult invokeV;
        C0534b c0534b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                c0534b = new C0534b();
            }
            return c0534b;
        }
        return (C0534b) invokeV.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.f8585b.c();
                }
                this.f8585b.e();
                d.k("SwanCookieManager", "onRelease");
            }
        }
    }

    public final ArrayList<c.a.s0.a.p2.a> s(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, strArr, str)) == null) {
            if (strArr == null || TextUtils.isEmpty(str)) {
                return null;
            }
            if (strArr[1].length() > 1) {
                int lastIndexOf = strArr[1].lastIndexOf(47);
                String str2 = strArr[1];
                if (lastIndexOf <= 0) {
                    lastIndexOf++;
                }
                strArr[1] = str2.substring(0, lastIndexOf);
            }
            try {
                return c.g(strArr[0], strArr[1], str);
            } catch (Exception unused) {
                if (f8582f) {
                    String str3 = "parse cookie failed: " + str;
                    return null;
                }
                return null;
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && c.a.s0.a.d2.d.J().D() && a()) {
            q.k(new a(this), "preInitCookieDb");
        }
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webAddress, str) == null) {
            synchronized (this) {
                if (webAddress != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.length() > 4096) {
                            d.o("SwanCookieManager", "setCookie value is too large");
                            return;
                        }
                        String[] e2 = c.e(webAddress);
                        if (e2 == null) {
                            return;
                        }
                        e(webAddress.getScheme(), e2[0], s(e2, str));
                        this.f8585b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && c.a.s0.a.d2.d.J().D() && a() && c.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f8582f) {
                    String str3 = "setCookie with bad address: " + str;
                }
            }
        }
    }

    public void x(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, collection) == null) || TextUtils.isEmpty(str) || collection == null || collection.isEmpty()) {
            return;
        }
        if (k(collection) > 4096) {
            d.o("SwanCookieManager", "setCookie values is too large");
            return;
        }
        if (f8582f) {
            String str2 = "setCookie: url=" + str + "; values=" + collection;
        }
        for (String str3 : collection) {
            w(str, str3);
        }
    }

    public synchronized void y(c.a.s0.a.p2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            synchronized (this) {
                aVar.f8581i = 1;
            }
        }
    }
}
