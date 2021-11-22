package b.a.p0.a.h0.m.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.a.z2.g1.e;
import b.a.p0.q.j.m.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.facebook.common.internal.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5890a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Integer> f5891b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<String, Long> f5892c;

    /* renamed from: d  reason: collision with root package name */
    public static int f5893d;

    /* renamed from: e  reason: collision with root package name */
    public static final e<String, String> f5894e;

    /* renamed from: f  reason: collision with root package name */
    public static final e<c.a, String> f5895f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.h0.m.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0241a implements e<String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0241a() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.p0.a.z2.g1.e
        public /* bridge */ /* synthetic */ String a(String str) {
            String str2 = str;
            b(str2);
            return str2;
        }

        public String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? str : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e<c.a, String> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.e
        /* renamed from: b */
        public String a(c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? aVar == null ? "" : aVar.b() : (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1973102441, "Lb/a/p0/a/h0/m/s/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1973102441, "Lb/a/p0/a/h0/m/s/a;");
                return;
            }
        }
        f5890a = k.f6863a;
        f5891b = Sets.newHashSet(0, 1010, 1011, 1012, 1020, 1015);
        f5892c = new ConcurrentHashMap();
        f5893d = 1800;
        f5894e = new C0241a();
        f5895f = new b();
    }

    public static <T> T a(String str, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, t)) == null) {
            if (f5890a) {
                String str2 = "Recorded=" + f5892c.size() + " # " + str + " => " + t;
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static boolean b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Long l = f5892c.get(str);
            return l == null || System.currentTimeMillis() - l.longValue() > ((long) (f5893d * 1000));
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? g(str, true) : invokeL.booleanValue;
    }

    public static boolean d(@NonNull String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str2 != null) {
                str = str + str2;
            }
            return c(str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? g(str, false) : invokeL.booleanValue;
    }

    public static boolean f(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            if (str2 != null && str != null) {
                str = str + str2;
            }
            return e(str);
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(@Nullable String str, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            String str2 = "shouldDownloadItem app=" + str + " record=" + z + ZeusCrashHandler.NAME_SEPERATOR;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z) {
                f5892c.put(str, Long.valueOf(System.currentTimeMillis()));
                z2 = true;
            } else {
                z2 = !f5892c.containsKey(str);
            }
            Boolean valueOf = Boolean.valueOf(z2);
            a(str2 + " should", valueOf);
            if (!valueOf.booleanValue()) {
                Boolean valueOf2 = Boolean.valueOf(b(str));
                a(str2 + " AB", valueOf2);
                if (!valueOf2.booleanValue()) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static List<String> h(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) ? j(f5894e, collection) : (List) invokeL.objValue;
    }

    public static List<c.a> i(Collection<c.a> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, collection)) == null) ? j(f5895f, collection) : (List) invokeL.objValue;
    }

    public static <SwanItemT> List<SwanItemT> j(@NonNull e<SwanItemT, String> eVar, Collection<SwanItemT> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, eVar, collection)) == null) ? k(eVar, collection, false) : (List) invokeLL.objValue;
    }

    public static <SwanItemT> List<SwanItemT> k(@NonNull e<SwanItemT, String> eVar, Collection<SwanItemT> collection, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65547, null, eVar, collection, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (collection != null) {
                Iterator<SwanItemT> it = collection.iterator();
                while (it.hasNext()) {
                    SwanItemT next = it.next();
                    if (g(next == null ? "" : eVar.a(next), z)) {
                        arrayList.add(next);
                    }
                }
                a("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
            }
            return arrayList;
        }
        return (List) invokeLLZ.objValue;
    }

    public static boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? f5891b.contains(Integer.valueOf(i2)) : invokeI.booleanValue;
    }

    public static boolean m(b.a.p0.q.i.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bVar)) == null) ? bVar != null && l(bVar.f11762a) : invokeL.booleanValue;
    }

    public static boolean n(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null) {
                return false;
            }
            Iterator<Map.Entry<String, Long>> it = f5892c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Long> next = it.next();
                if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                    it.remove();
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
