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
    private static final Set<Integer> cVC = i.R(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> cVD = new ConcurrentHashMap();
    private static int cVE = -2;
    private static final c<String, String> cVF = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: mT */
        public String M(String str) {
            return str;
        }
    };
    private static final c<b.a, String> cVG = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.c
        /* renamed from: a */
        public String M(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean mP(@NonNull String str) {
        Long l;
        if (cVE == -2) {
            cVE = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (cVE < 0) {
            return !cVD.containsKey(str);
        }
        return cVE == 0 || (l = cVD.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (cVE * 1000));
    }

    public static boolean gY(int i) {
        return cVC.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && gY(aVar.errorNo);
    }

    public static boolean T(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            cVD.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !cVD.containsKey(str);
        }
        return ((Boolean) k(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) k(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(mP(str)))).booleanValue();
    }

    public static boolean mQ(String str) {
        return T(str, false);
    }

    public static boolean by(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return mQ(str);
    }

    public static List<String> g(Collection<String> collection) {
        return a(cVF, collection);
    }

    public static List<b.a> h(Collection<b.a> collection) {
        return a(cVG, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (T(next == null ? "" : cVar.M(next), z)) {
                    arrayList.add(next);
                }
            }
            k("shouldDownloadSet", "record=" + z + " targets=" + collection.size() + " should=" + arrayList.size());
        }
        return arrayList;
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection) {
        return a(cVar, collection, false);
    }

    public static boolean mR(String str) {
        return T(str, true);
    }

    public static boolean bz(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return mR(str);
    }

    public static boolean mS(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = cVD.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next != null && next.getKey() != null && next.getKey().startsWith(str)) {
                it.remove();
            }
        }
        return true;
    }

    private static <T> T k(String str, T t) {
        if (DEBUG) {
            Log.i("PreDownloadUtils", "Recorded=" + cVD.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
