package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class StatService {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5264a = "logsender";

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f5265b;

    /* loaded from: classes2.dex */
    public enum ETag {
        in,
        out,
        push,
        back
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static StatService f5266a = new StatService();
    }

    public static StatService a() {
        return a.f5266a;
    }

    public static void b(String str, String str2, Collection<String> collection) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        if (collection != null) {
            a2.addAll(collection);
        }
        a(str, (String) null, a2);
    }

    public StatService() {
        this.f5265b = new ConcurrentHashMap<>();
    }

    public static synchronized void a(String str, ETag eTag, Collection<String> collection) {
        synchronized (StatService.class) {
            if (eTag != null) {
                a(str, eTag.name(), collection);
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, str2, str3, System.currentTimeMillis());
    }

    public static void b(String str, String str2, String str3) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        if (str3 != null) {
            a2.add(str3);
        }
        a(str, (String) null, a2);
    }

    public static void a(String str, String str2, String str3, long j) {
        ArrayList arrayList;
        if (str3 != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str3);
        } else {
            arrayList = null;
        }
        a(str, str2, arrayList, j);
    }

    public static void a(String str, String str2, Collection<String> collection, long j) {
        i.a(RimStatisticsUtil.getAppContext()).a(h.a(str, j, str2, com.baidu.fsg.base.statistics.a.a(), collection));
        if (i.a(RimStatisticsUtil.getAppContext()).a() >= 200) {
            l.a().a("normal_log");
        }
    }

    public static void a(String str, String str2, Collection<String> collection) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, str2, collection, System.currentTimeMillis());
    }

    public static void a(String str) {
        a().f5265b.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static ArrayList<String> a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        Long l = a().f5265b.get(str);
        if (l == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
        a().f5265b.remove(str);
        arrayList.add(Long.toString(valueOf.longValue()));
        arrayList.add(str2);
        return arrayList;
    }
}
