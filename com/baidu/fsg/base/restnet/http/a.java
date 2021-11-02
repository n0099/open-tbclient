package com.baidu.fsg.base.restnet.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class a implements b<String, String> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37419a = "Host";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37420b = "Accept";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37421c = "Accept-Charset";

    /* renamed from: d  reason: collision with root package name */
    public static final String f37422d = "Accept-Encoding";

    /* renamed from: e  reason: collision with root package name */
    public static final String f37423e = "Accept-Language";

    /* renamed from: f  reason: collision with root package name */
    public static final String f37424f = "Allow";

    /* renamed from: g  reason: collision with root package name */
    public static final String f37425g = "Cache-Control";

    /* renamed from: h  reason: collision with root package name */
    public static final String f37426h = "Content-Disposition";

    /* renamed from: i  reason: collision with root package name */
    public static final String f37427i = "Content-Encoding";
    public static final String j = "Content-Length";
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1203347552, "Lcom/baidu/fsg/base/restnet/http/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1203347552, "Lcom/baidu/fsg/base/restnet/http/a;");
                return;
            }
        }
        v = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"};
        w = TimeZone.getTimeZone("GMT");
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
            map = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
        }
        this.x = map;
    }

    public static a a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) ? new a(aVar, true) : (a) invokeL.objValue;
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

    private void a(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, this, str, j2) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(v[0], Locale.US);
            simpleDateFormat.setTimeZone(w);
            set(str, simpleDateFormat.format(new Date(j2)));
        }
    }

    private long l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            String first = getFirst(str);
            if (first == null) {
                return -1L;
            }
            for (String str2 : v) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
                simpleDateFormat.setTimeZone(w);
                try {
                    return simpleDateFormat.parse(first).getTime();
                } catch (ParseException unused) {
                }
            }
            throw new IllegalArgumentException("Cannot parse date value \"" + first + "\" for \"" + str + "\" header");
        }
        return invokeL.longValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getFirst("Accept") : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    /* renamed from: a */
    public String getFirst(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            List<String> list = this.x.get(str);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public List<String> put(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, list)) == null) ? this.x.put(str, list) : (List) invokeLL.objValue;
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            set("Content-Length", Long.toString(j2));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    /* renamed from: a */
    public void add(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            List<String> list = this.x.get(str);
            if (list == null) {
                list = new LinkedList<>();
                this.x.put(str, list);
            }
            list.add(str2);
        }
    }

    public void a(URI uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
            set("Location", uri.toASCIIString());
        }
    }

    public void a(List<Charset> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<Charset> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().name().toLowerCase(Locale.ENGLISH));
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            set("Accept-Charset", sb.toString());
        }
    }

    public void a(Set<HttpDefines.HttpMethod> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, set) == null) {
            set("Allow", a(set, ",", "", ""));
        }
    }

    public List<Charset> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String first = getFirst("Accept-Charset");
            if (first != null) {
                String[] split = first.split(",\\s*");
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

    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            a("Date", j2);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            set("Accept", str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    /* renamed from: b */
    public void set(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str2);
            this.x.put(str, linkedList);
        }
    }

    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            set("If-None-Match", sb.toString());
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? getFirst("Accept-Encoding") : (String) invokeV.objValue;
    }

    public void c(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) {
            a("Expires", j2);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            set("Accept-Encoding", str);
        }
    }

    public void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            if (str == null) {
                throw new IllegalArgumentException("'name' must not be null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=\"");
            sb.append(str);
            sb.append('\"');
            if (str2 != null) {
                sb.append("; filename=\"");
                sb.append(str2);
                sb.append('\"');
            }
            set("Content-Disposition", sb.toString());
        }
    }

    @Override // java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x.clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) ? this.x.containsKey(obj) : invokeL.booleanValue;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, obj)) == null) ? this.x.containsValue(obj) : invokeL.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? getFirst("Accept-Language") : (String) invokeV.objValue;
    }

    public void d(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            a("If-Modified-Since", j2);
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            set("Accept-Language", str);
        }
    }

    public Set<HttpDefines.HttpMethod> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String first = getFirst("Allow");
            if (first != null) {
                ArrayList arrayList = new ArrayList(5);
                for (String str : first.split(",\\s*")) {
                    arrayList.add(HttpDefines.HttpMethod.valueOf(str));
                }
                return EnumSet.copyOf((Collection) arrayList);
            }
            return EnumSet.noneOf(HttpDefines.HttpMethod.class);
        }
        return (Set) invokeV.objValue;
    }

    public void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j2) == null) {
            a("Last-Modified", j2);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            set("Cache-Control", str);
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, List<String>>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.x.entrySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, obj)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getFirst("Cache-Control") : (String) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            set("Content-Encoding", str);
        }
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            List<String> list = this.x.get("Content-Type");
            if (list == null || list.size() <= 1) {
                return null;
            }
            return list.get(1);
        }
        return (String) invokeV.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            set("Content-Type", str.toString());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public List<String> get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, obj)) == null) ? this.x.get(obj) : (List) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? getFirst("Content-Encoding") : (String) invokeV.objValue;
    }

    public void h(String str) {
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
            set("ETag", str);
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.x.hashCode() : invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            String first = getFirst("Content-Length");
            if (first != null) {
                try {
                    return Long.parseLong(first);
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            set("If-None-Match", str);
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.x.isEmpty() : invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? getFirst("Content-Type") : (String) invokeV.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            set("Pragma", str);
        }
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? l("Date") : invokeV.longValue;
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            set("User-Agent", str);
        }
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.x.keySet() : (Set) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? getFirst("ETag") : (String) invokeV.objValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? l("Expires") : invokeV.longValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? getFirst("Host") : (String) invokeV.objValue;
    }

    public List<String> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String first = getFirst("If-None-Match");
            if (first != null) {
                for (String str : first.split(",\\s*")) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? l("If-Modified-Since") : invokeV.longValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, map) == null) {
            this.x.putAll(map);
        }
    }

    public long q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? l("Last-Modified") : invokeV.longValue;
    }

    public URI r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            String first = getFirst("Location");
            if (first != null) {
                return URI.create(first);
            }
            return null;
        }
        return (URI) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    public List<String> remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, obj)) == null) ? this.x.remove(obj) : (List) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? getFirst("Pragma") : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.http.b
    public void setAll(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, map) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                set(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.x.size() : invokeV.intValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? getFirst("X-BFB-RT") : (String) invokeV.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.http.b
    public Map<String, String> toSingleValueMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.x.toString() : (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? getFirst("User-Agent") : (String) invokeV.objValue;
    }

    @Override // java.util.Map
    public Collection<List<String>> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.x.values() : (Collection) invokeV.objValue;
    }
}
