package com.baidu.apollon.restnet.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
/* loaded from: classes3.dex */
public class a implements c<String, String> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "Host";

    /* renamed from: b  reason: collision with root package name */
    public static final String f31195b = "Accept";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31196c = "Accept-Charset";

    /* renamed from: d  reason: collision with root package name */
    public static final String f31197d = "Accept-Encoding";

    /* renamed from: e  reason: collision with root package name */
    public static final String f31198e = "Accept-Language";

    /* renamed from: f  reason: collision with root package name */
    public static final String f31199f = "Allow";

    /* renamed from: g  reason: collision with root package name */
    public static final String f31200g = "Cache-Control";

    /* renamed from: h  reason: collision with root package name */
    public static final String f31201h = "Content-Disposition";

    /* renamed from: i  reason: collision with root package name */
    public static final String f31202i = "Content-Encoding";

    /* renamed from: j  reason: collision with root package name */
    public static final String f31203j = "Content-Length";
    public static final String k = "Content-Type";
    public static final String l = "Date";
    public static final String m = "ETag";
    public static final String n = "Expires";
    public static final String o = "If-Modified-Since";
    public static final String p = "If-None-Match";
    public static final String q = "Last-Modified";
    public static final String r = "Location";
    public static final String s = "Pragma";
    public static final String t = "User-Agent";
    public static final String u = "X-BFB-RT";
    public static final String[] v;
    public static TimeZone w;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, List<String>> x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1125603139, "Lcom/baidu/apollon/restnet/http/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1125603139, "Lcom/baidu/apollon/restnet/http/a;");
                return;
            }
        }
        v = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"};
        w = TimeZone.getTimeZone("GMT");
    }

    public a(Map<String, List<String>> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (map == null) {
            throw new IllegalArgumentException("'headers' must not be null");
        }
        if (z) {
            LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                linkedCaseInsensitiveMap.put((LinkedCaseInsensitiveMap) entry.getKey(), (String) Collections.unmodifiableList(entry.getValue()));
            }
            this.x = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
            return;
        }
        this.x = map;
    }

    @Override // java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.x.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, obj)) == null) ? this.x.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) ? this.x.containsValue(obj) : invokeL.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? c("Accept-Language") : (String) invokeV.objValue;
    }

    public Set<HttpDefines.HttpMethod> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            String c2 = c("Allow");
            if (c2 != null) {
                ArrayList arrayList = new ArrayList(5);
                for (String str : c2.split(",\\s*")) {
                    arrayList.add(HttpDefines.HttpMethod.valueOf(str));
                }
                return EnumSet.copyOf((Collection) arrayList);
            }
            return EnumSet.noneOf(HttpDefines.HttpMethod.class);
        }
        return (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, List<String>>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.x.entrySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.x.equals(((a) obj).x);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? c("Cache-Control") : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? c("Content-Encoding") : (String) invokeV.objValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            String c2 = c("Content-Length");
            if (c2 != null) {
                try {
                    return Long.parseLong(c2);
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    @Override // java.util.Map
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.x.hashCode() : invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? c("Content-Type") : (String) invokeV.objValue;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.x.isEmpty() : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            List<String> list = this.x.get("Content-Type");
            if (list == null || list.size() <= 1) {
                return null;
            }
            return list.get(1);
        }
        return (String) invokeV.objValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? l("Date") : invokeV.longValue;
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.x.keySet() : (Set) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? c("ETag") : (String) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? l("Expires") : invokeV.longValue;
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? l("If-Modified-Since") : invokeV.longValue;
    }

    public List<String> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String c2 = c("If-None-Match");
            if (c2 != null) {
                for (String str : c2.split(",\\s*")) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? l("Last-Modified") : invokeV.longValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, map) == null) {
            this.x.putAll(map);
        }
    }

    public URI q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            String c2 = c("Location");
            if (c2 != null) {
                return URI.create(c2);
            }
            return null;
        }
        return (URI) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? c("Pragma") : (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? c("User-Agent") : (String) invokeV.objValue;
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.x.size() : invokeV.intValue;
    }

    @Override // com.baidu.apollon.restnet.http.c
    public Map<String, String> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(this.x.size());
            for (Map.Entry<String, List<String>> entry : this.x.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue().get(0));
            }
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.x.toString() : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? c("X-BFB-RT") : (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? c("Host") : (String) invokeV.objValue;
    }

    @Override // java.util.Map
    public Collection<List<String>> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.x.values() : (Collection) invokeV.objValue;
    }

    public static a a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? new a(aVar, true) : (a) invokeL.objValue;
    }

    private long l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            String c2 = c(str);
            if (c2 == null) {
                return -1L;
            }
            for (String str2 : v) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
                simpleDateFormat.setTimeZone(w);
                try {
                    return simpleDateFormat.parse(c2).getTime();
                } catch (ParseException unused) {
                }
            }
            throw new IllegalArgumentException("Cannot parse date value \"" + c2 + "\" for \"" + str + "\" header");
        }
        return invokeL.longValue;
    }

    public List<Charset> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String c2 = c("Accept-Charset");
            if (c2 != null) {
                String[] split = c2.split(",\\s*");
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = split[i2];
                    int indexOf = str.indexOf(59);
                    if (indexOf != -1) {
                        str = str.substring(0, indexOf);
                    }
                    if (!str.equals("*")) {
                        arrayList.add(Charset.forName(str));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? c("Accept-Encoding") : (String) invokeV.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            a("Cache-Control", str);
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            a("Content-Type", str.toString());
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            if (str != null) {
                if (!str.startsWith("\"") && !str.startsWith("W/")) {
                    throw new IllegalArgumentException("Invalid eTag, does not start with W/ or \"");
                }
                if (!str.endsWith("\"")) {
                    throw new IllegalArgumentException("Invalid eTag, does not end with \"");
                }
            }
            a("ETag", str);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            a("Pragma", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.restnet.http.c
    /* renamed from: k */
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            List<String> list = this.x.get(str);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String a(Collection<?> collection, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, collection, str, str2, str3)) == null) {
            if (collection == null || collection.isEmpty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                sb.append(str2);
                sb.append(it.next());
                sb.append(str3);
                if (it.hasNext()) {
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    public void c2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            a("Accept-Language", str);
        }
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j2) == null) {
            a("If-Modified-Since", j2);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            a("If-None-Match", str);
        }
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            a("Expires", j2);
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            a("User-Agent", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.restnet.http.c
    /* renamed from: c */
    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            this.x.put(str, linkedList);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            a("Content-Encoding", str);
        }
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j2) == null) {
            a("Last-Modified", j2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(new LinkedCaseInsensitiveMap(8, Locale.ENGLISH), false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Map) objArr[0], ((Boolean) objArr[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            a("Accept-Encoding", str);
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c("Accept") : (String) invokeV.objValue;
    }

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            a("Date", j2);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            a("Accept", str);
        }
    }

    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            a("If-None-Match", sb.toString());
        }
    }

    public void a(List<Charset> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<Charset> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().name().toLowerCase(Locale.ENGLISH));
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            a("Accept-Charset", sb.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.restnet.http.c
    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            List<String> list = this.x.get(str);
            if (list == null) {
                list = new LinkedList<>();
                this.x.put(str, list);
            }
            list.add(str2);
        }
    }

    public void a(Set<HttpDefines.HttpMethod> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, set) == null) {
            a("Allow", a(set, ",", "", ""));
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
            if (str != null) {
                StringBuilder sb = new StringBuilder("form-data; name=\"");
                sb.append(str);
                sb.append('\"');
                if (str2 != null) {
                    sb.append("; filename=\"");
                    sb.append(str2);
                    sb.append('\"');
                }
                a("Content-Disposition", sb.toString());
                return;
            }
            throw new IllegalArgumentException("'name' must not be null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: b */
    public List<String> remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? this.x.remove(obj) : (List) invokeL.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            a("Content-Length", Long.toString(j2));
        }
    }

    public void a(URI uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uri) == null) {
            a("Location", uri.toASCIIString());
        }
    }

    private void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65541, this, str, j2) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(v[0], Locale.US);
            simpleDateFormat.setTimeZone(w);
            a(str, simpleDateFormat.format(new Date(j2)));
        }
    }

    @Override // com.baidu.apollon.restnet.http.c
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public List<String> get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.x.get(obj) : (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public List<String> put(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list)) == null) ? this.x.put(str, list) : (List) invokeLL.objValue;
    }
}
