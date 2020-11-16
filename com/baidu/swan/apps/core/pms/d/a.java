package com.baidu.swan.apps.core.pms.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.e.c;
import com.baidu.swan.pms.c.d.b;
import com.facebook.common.internal.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<Integer> cMl = i.N(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> cMm = new ConcurrentHashMap();
    private static int cMn = -2;
    private static final c<String, String> cMo = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.c
        /* renamed from: nm */
        public String N(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cMp = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.c
        /* renamed from: a */
        public String N(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean ni(@NonNull String str) {
        Long l;
        if (cMn == -2) {
            cMn = com.baidu.swan.apps.t.a.avV().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cMn < 0) {
            return !cMm.containsKey(str);
        }
        return cMn == 0 || (l = cMm.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cMn * 1000));
    }

    public static boolean ii(int i) {
        return cMl.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && ii(aVar.errorNo);
    }

    public static boolean T(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            cMm.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !cMm.containsKey(str);
        }
        return ((Boolean) n(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) n(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(ni(str)))).booleanValue();
    }

    public static boolean nj(String str) {
        return T(str, false);
    }

    public static boolean bz(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return nj(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(cMo, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cMp, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (T(next == null ? "" : cVar.N(next), z)) {
                    arrayList.add(next);
                }
            }
            n("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
        }
        return arrayList;
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection) {
        return a(cVar, collection, false);
    }

    public static boolean nk(String str) {
        return T(str, true);
    }

    public static boolean bA(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return nk(str);
    }

    public static boolean nl(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = cMm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                it.remove();
            }
        }
        return true;
    }

    private static <T> T n(String str, T t) {
        if (DEBUG) {
            Log.i("PreDownloadUtils", "Recorded=" + cMm.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
