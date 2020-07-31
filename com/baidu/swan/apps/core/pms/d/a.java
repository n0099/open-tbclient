package com.baidu.swan.apps.core.pms.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.e.c;
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
    private static final Set<Integer> ceR = i.O(0, 1010, 1011, 1012, 1020, 1015);
    private static final Map<String, Long> ceS = new ConcurrentHashMap();
    private static int ceT = -2;
    private static final c<String, String> ceU = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.c
        /* renamed from: ka */
        public String I(String str) {
            return str;
        }
    };
    private static final c<b.a, String> ceV = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.c
        /* renamed from: a */
        public String I(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean jW(@NonNull String str) {
        Long l;
        if (ceT == -2) {
            ceT = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_predownload_one_sm_interval", -1);
        }
        if (ceT < 0) {
            return !ceS.containsKey(str);
        }
        return ceT == 0 || (l = ceS.get(str)) == null || System.currentTimeMillis() - l.longValue() > ((long) (ceT * 1000));
    }

    public static boolean fp(int i) {
        return ceR.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && fp(aVar.errorNo);
    }

    public static boolean J(@Nullable String str, boolean z) {
        boolean z2;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            ceS.put(str, Long.valueOf(System.currentTimeMillis()));
            z2 = true;
        } else {
            z2 = !ceS.containsKey(str);
        }
        return ((Boolean) n(new StringBuilder().append(str2).append(" should").toString(), Boolean.valueOf(z2))).booleanValue() || ((Boolean) n(new StringBuilder().append(str2).append(" AB").toString(), Boolean.valueOf(jW(str)))).booleanValue();
    }

    public static boolean jX(String str) {
        return J(str, false);
    }

    public static boolean bg(@Nullable String str, @Nullable String str2) {
        if (str2 != null && str != null) {
            str = str + str2;
        }
        return jX(str);
    }

    public static List<String> e(Collection<String> collection) {
        return a(ceU, collection);
    }

    public static List<b.a> f(Collection<b.a> collection) {
        return a(ceV, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (J(next == null ? "" : cVar.I(next), z)) {
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

    public static boolean jY(String str) {
        return J(str, true);
    }

    public static boolean bh(@NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            str = str + str2;
        }
        return jY(str);
    }

    public static boolean jZ(@Nullable String str) {
        if (str == null) {
            return false;
        }
        Iterator<Map.Entry<String, Long>> it = ceS.entrySet().iterator();
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
            Log.i("PreDownloadUtils", "Recorded=" + ceS.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
