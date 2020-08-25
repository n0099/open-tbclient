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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<Integer> clj = i.N(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> clk = new ConcurrentHashMap();
    private static int cll = -2;
    private static final c<String, String> clm = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.c
        /* renamed from: lE */
        public String J(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cln = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.c
        /* renamed from: a */
        public String J(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean lA(@NonNull String str) {
        Long l;
        if (cll == -2) {
            cll = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cll < 0) {
            return !clk.containsKey(str);
        }
        return cll == 0 || (l = clk.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cll * 1000));
    }

    public static boolean hl(int i) {
        return clj.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && hl(aVar.errorNo);
    }

    public static boolean N(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            clk.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !clk.containsKey(str);
        }
        return ((Boolean) n(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) n(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(lA(str)))).booleanValue();
    }

    public static boolean lB(String str) {
        return N(str, false);
    }

    public static boolean bo(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return lB(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(clm, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cln, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (N(next == null ? "" : cVar.J(next), z)) {
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

    public static boolean lC(String str) {
        return N(str, true);
    }

    public static boolean bp(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return lC(str);
    }

    public static boolean lD(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = clk.entrySet().iterator();
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
            Log.i("PreDownloadUtils", "Recorded=" + clk.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
