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
    private static final Set<Integer> cXc = i.Q(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> cXd = new ConcurrentHashMap();
    private static int cXe = -2;
    private static final c<String, String> cXf = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: na */
        public String O(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cXg = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: a */
        public String O(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean mW(@NonNull String str) {
        Long l;
        if (cXe == -2) {
            cXe = com.baidu.swan.apps.t.a.axc().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cXe < 0) {
            return !cXd.containsKey(str);
        }
        return cXe == 0 || (l = cXd.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cXe * 1000));
    }

    public static boolean gZ(int i) {
        return cXc.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && gZ(aVar.errorNo);
    }

    public static boolean T(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            cXd.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !cXd.containsKey(str);
        }
        return ((Boolean) l(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) l(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(mW(str)))).booleanValue();
    }

    public static boolean mX(String str) {
        return T(str, false);
    }

    public static boolean by(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return mX(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(cXf, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cXg, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (T(next == null ? "" : cVar.O(next), z)) {
                    arrayList.add(next);
                }
            }
            l("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
        }
        return arrayList;
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection) {
        return a(cVar, collection, false);
    }

    public static boolean mY(String str) {
        return T(str, true);
    }

    public static boolean bz(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return mY(str);
    }

    public static boolean mZ(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = cXd.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                it.remove();
            }
        }
        return true;
    }

    private static <T> T l(String str, T t) {
        if (DEBUG) {
            Log.i("PreDownloadUtils", "Recorded=" + cXd.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
