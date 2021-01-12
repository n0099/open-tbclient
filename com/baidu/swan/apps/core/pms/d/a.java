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
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<Integer> cTp = i.R(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> cTq = new ConcurrentHashMap();
    private static int cTr = -2;
    private static final c<String, String> cTs = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: mB */
        public String M(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cTt = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: a */
        public String M(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean mx(@NonNull String str) {
        Long l;
        if (cTr == -2) {
            cTr = com.baidu.swan.apps.t.a.awB().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cTr < 0) {
            return !cTq.containsKey(str);
        }
        return cTr == 0 || (l = cTq.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cTr * 1000));
    }

    public static boolean gV(int i) {
        return cTp.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && gV(aVar.errorNo);
    }

    public static boolean U(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            cTq.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !cTq.containsKey(str);
        }
        return ((Boolean) m(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) m(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(mx(str)))).booleanValue();
    }

    public static boolean my(String str) {
        return U(str, false);
    }

    public static boolean bE(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return my(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(cTs, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cTt, collection);
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

    public static boolean mz(String str) {
        return U(str, true);
    }

    public static boolean bF(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return mz(str);
    }

    public static boolean mA(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = cTq.entrySet().iterator();
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
            Log.i("PreDownloadUtils", "Recorded=" + cTq.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
