package com.baidu.apollon.statistics;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class StatService {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f3842a;

    /* loaded from: classes.dex */
    public enum ETag {
        in,
        out,
        push,
        back
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatService f3843a = new StatService();
    }

    public static StatService a() {
        return a.f3843a;
    }

    public static void b(String str, String str2, Collection<String> collection, String str3) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        if (collection != null) {
            a2.addAll(collection);
        }
        a(str, (String) null, a2, str3);
    }

    public StatService() {
        this.f3842a = new ConcurrentHashMap<>();
    }

    public static synchronized void a(String str, ETag eTag, Collection<String> collection) {
        synchronized (StatService.class) {
            if (eTag != null) {
                a(str, eTag.name(), collection, (String) null);
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a().a(str, (String) null, str2, str3, System.currentTimeMillis());
    }

    public static void a(String str, String str2, Collection<String> collection, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a().a(str, str2, collection, str3, System.currentTimeMillis());
    }

    public static void a(String str) {
        a().f3842a.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void a(String str, String str2, String str3, String str4) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        if (str3 != null) {
            a2.add(str3);
        }
        a(str, (String) null, a2, str4);
    }

    public static ArrayList<String> a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0, "");
        Long l = a().f3842a.get(str);
        if (l == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
        a().f3842a.remove(str);
        arrayList.add(Long.toString(valueOf.longValue()));
        arrayList.add(str2);
        return arrayList;
    }
}
