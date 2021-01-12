package com.baidu.fsg.base.restnet.http;

import com.baidu.fsg.base.restnet.http.HttpDefines;
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
/* loaded from: classes5.dex */
public class a implements b<String, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1909a = "Host";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1910b = "Accept";
    private static final String c = "Accept-Charset";
    private static final String d = "Accept-Encoding";
    private static final String e = "Accept-Language";
    private static final String f = "Allow";
    private static final String g = "Cache-Control";
    private static final String h = "Content-Disposition";
    private static final String i = "Content-Encoding";
    private static final String j = "Content-Length";
    private static final String k = "Content-Type";
    private static final String l = "Date";
    private static final String m = "ETag";
    private static final String n = "Expires";
    private static final String o = "If-Modified-Since";
    private static final String p = "If-None-Match";
    private static final String q = "Last-Modified";
    private static final String r = "Location";
    private static final String s = "Pragma";
    private static final String t = "User-Agent";
    private static final String u = "X-BFB-RT";
    private static final String[] v = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM dd HH:mm:ss yyyy"};
    private static TimeZone w = TimeZone.getTimeZone("GMT");
    private final Map<String, List<String>> x;

    public a(Map<String, List<String>> map, boolean z) {
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

    public a() {
        this(new LinkedCaseInsensitiveMap(8, Locale.ENGLISH), false);
    }

    public static a a(a aVar) {
        return new a(aVar, true);
    }

    public static String a(Collection<?> collection, String str, String str2, String str3) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2).append(it.next()).append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public String a() {
        return c(f1910b);
    }

    public void a(String str) {
        a(f1910b, str);
    }

    public List<Charset> b() {
        ArrayList arrayList = new ArrayList();
        String c2 = c(c);
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

    public void a(List<Charset> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Charset> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().name().toLowerCase(Locale.ENGLISH));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        a(c, sb.toString());
    }

    public String c() {
        return c("Accept-Encoding");
    }

    public void b(String str) {
        a("Accept-Encoding", str);
    }

    public String d() {
        return c(e);
    }

    /* renamed from: c  reason: avoid collision after fix types in other method */
    public void c2(String str) {
        a(e, str);
    }

    public Set<HttpDefines.HttpMethod> e() {
        String c2 = c(f);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList(5);
            String[] split = c2.split(",\\s*");
            for (String str : split) {
                arrayList.add(HttpDefines.HttpMethod.valueOf(str));
            }
            return EnumSet.copyOf((Collection) arrayList);
        }
        return EnumSet.noneOf(HttpDefines.HttpMethod.class);
    }

    public void a(Set<HttpDefines.HttpMethod> set) {
        a(f, a(set, ",", "", ""));
    }

    public String f() {
        return c("Cache-Control");
    }

    public void d(String str) {
        a("Cache-Control", str);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("'name' must not be null");
        }
        StringBuilder sb = new StringBuilder("form-data; name=\"");
        sb.append(str).append('\"');
        if (str2 != null) {
            sb.append("; filename=\"");
            sb.append(str2).append('\"');
        }
        a("Content-Disposition", sb.toString());
    }

    public String g() {
        return c("Content-Encoding");
    }

    public void e(String str) {
        a("Content-Encoding", str);
    }

    public long h() {
        String c2 = c("Content-Length");
        if (c2 != null) {
            try {
                return Long.parseLong(c2);
            } catch (NumberFormatException e2) {
                return -1L;
            }
        }
        return -1L;
    }

    public void a(long j2) {
        a("Content-Length", Long.toString(j2));
    }

    public String i() {
        return c("Content-Type");
    }

    public void f(String str) {
        a("Content-Type", str.toString());
    }

    public String j() {
        List<String> list = this.x.get("Content-Type");
        if (list == null || list.size() <= 1) {
            return null;
        }
        return list.get(1);
    }

    public long k() {
        return l("Date");
    }

    public void b(long j2) {
        a("Date", j2);
    }

    public String l() {
        return c("ETag");
    }

    public void g(String str) {
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

    public long m() {
        return l("Expires");
    }

    public void c(long j2) {
        a("Expires", j2);
    }

    public void d(long j2) {
        a(o, j2);
    }

    public long n() {
        return l(o);
    }

    public void h(String str) {
        a(p, str);
    }

    public List<String> o() {
        ArrayList arrayList = new ArrayList();
        String c2 = c(p);
        if (c2 != null) {
            String[] split = c2.split(",\\s*");
            for (String str : split) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void b(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        a(p, sb.toString());
    }

    public long p() {
        return l("Last-Modified");
    }

    public void e(long j2) {
        a("Last-Modified", j2);
    }

    public URI q() {
        String c2 = c("Location");
        if (c2 != null) {
            return URI.create(c2);
        }
        return null;
    }

    public void a(URI uri) {
        a("Location", uri.toASCIIString());
    }

    public String r() {
        return c(s);
    }

    public void i(String str) {
        a(s, str);
    }

    public String s() {
        return c("User-Agent");
    }

    public void j(String str) {
        a("User-Agent", str);
    }

    private long l(String str) {
        String c2 = c(str);
        if (c2 == null) {
            return -1L;
        }
        for (String str2 : v) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.US);
            simpleDateFormat.setTimeZone(w);
            try {
                return simpleDateFormat.parse(c2).getTime();
            } catch (ParseException e2) {
            }
        }
        throw new IllegalArgumentException("Cannot parse date value \"" + c2 + "\" for \"" + str + "\" header");
    }

    private void a(String str, long j2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(v[0], Locale.US);
        simpleDateFormat.setTimeZone(w);
        a(str, simpleDateFormat.format(new Date(j2)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    /* renamed from: k */
    public String c(String str) {
        List<String> list = this.x.get(str);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    public void b(String str, String str2) {
        List<String> list = this.x.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.x.put(str, list);
        }
        list.add(str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.http.b
    /* renamed from: c */
    public void a(String str, String str2) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str2);
        this.x.put(str, linkedList);
    }

    @Override // com.baidu.fsg.base.restnet.http.b
    public void a(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.baidu.fsg.base.restnet.http.b
    public Map<String, String> t() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.x.size());
        for (Map.Entry<String, List<String>> entry : this.x.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().get(0));
        }
        return linkedHashMap;
    }

    @Override // java.util.Map
    public int size() {
        return this.x.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.x.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.x.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.x.containsValue(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public List<String> get(Object obj) {
        return this.x.get(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: a */
    public List<String> put(String str, List<String> list) {
        return this.x.put(str, list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map
    /* renamed from: b */
    public List<String> remove(Object obj) {
        return this.x.remove(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends List<String>> map) {
        this.x.putAll(map);
    }

    @Override // java.util.Map
    public void clear() {
        this.x.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.x.keySet();
    }

    @Override // java.util.Map
    public Collection<List<String>> values() {
        return this.x.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, List<String>>> entrySet() {
        return this.x.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.x.equals(((a) obj).x);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.x.hashCode();
    }

    public String toString() {
        return this.x.toString();
    }

    public String u() {
        return c(u);
    }

    public String v() {
        return c("Host");
    }
}
