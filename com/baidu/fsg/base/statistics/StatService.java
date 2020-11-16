package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class StatService {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1484a = "logsender";
    private ConcurrentHashMap<String, Long> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public enum ETag {
        in,
        out,
        push,
        back
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static StatService f1485a = new StatService();

        private a() {
        }
    }

    private StatService() {
        this.b = new ConcurrentHashMap<>();
    }

    static StatService a() {
        return a.f1485a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(String str, ETag eTag, Collection<String> collection) {
        synchronized (StatService.class) {
            if (eTag != null) {
                a(str, eTag.name(), collection);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            a(str, str2, str3, System.currentTimeMillis());
        }
    }

    private static void a(String str, String str2, String str3, long j) {
        ArrayList arrayList = null;
        if (str3 != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str3);
        }
        a(str, str2, arrayList, j);
    }

    private static void a(String str, String str2, Collection<String> collection, long j) {
        i.a(RimStatisticsUtil.getAppContext()).a(h.a(str, j, str2, com.baidu.fsg.base.statistics.a.a(), collection));
        if (i.a(RimStatisticsUtil.getAppContext()).a() >= 200) {
            l.a().a(b.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, Collection<String> collection) {
        if (!TextUtils.isEmpty(str)) {
            a(str, str2, collection, System.currentTimeMillis());
        }
    }

    public static void a(String str) {
        a().b.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static void b(String str, String str2, Collection<String> collection) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 != null) {
            if (collection != null) {
                a2.addAll(collection);
            }
            a(str, (String) null, a2);
        }
    }

    public static void b(String str, String str2, String str3) {
        ArrayList<String> a2 = a(str, str2);
        if (a2 != null) {
            if (str3 != null) {
                a2.add(str3);
            }
            a(str, (String) null, a2);
        }
    }

    private static ArrayList<String> a(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        Long l = a().b.get(str);
        if (l == null) {
            return null;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
        a().b.remove(str);
        arrayList.add(Long.toString(valueOf.longValue()));
        arrayList.add(str2);
        return arrayList;
    }
}
