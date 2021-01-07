package com.baidu.swan.apps.core.pms.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.e.c;
import com.baidu.swan.pms.c.d.b;
import com.facebook.common.internal.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<Integer> cYb = i.R(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> cYc = new ConcurrentHashMap();
    private static int cYd = -2;
    private static final c<String, String> cYe = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: nM */
        public String M(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cYf = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: a */
        public String M(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean nI(@NonNull String str) {
        Long l;
        if (cYd == -2) {
            cYd = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cYd < 0) {
            return !cYc.containsKey(str);
        }
        return cYd == 0 || (l = cYc.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cYd * 1000));
    }

    public static boolean iB(int i) {
        return cYb.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && iB(aVar.errorNo);
    }

    public static boolean U(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            cYc.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !cYc.containsKey(str);
        }
        return ((Boolean) m(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) m(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(nI(str)))).booleanValue();
    }

    public static boolean nJ(String str) {
        return U(str, false);
    }

    public static boolean bF(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return nJ(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(cYe, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cYf, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (U(next == null ? "" : cVar.M(next), z)) {
                    arrayList.add(next);
                }
            }
            m("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
        }
        return arrayList;
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection) {
        return a(cVar, collection, false);
    }

    public static boolean nK(String str) {
        return U(str, true);
    }

    public static boolean bG(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return nK(str);
    }

    public static boolean nL(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = cYc.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                it.remove();
            }
        }
        return true;
    }

    private static <T> T m(String str, T t) {
        if (DEBUG) {
            Log.i("PreDownloadUtils", "Recorded=" + cYc.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
