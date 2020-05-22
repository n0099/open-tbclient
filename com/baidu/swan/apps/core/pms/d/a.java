package com.baidu.swan.apps.core.pms.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.e.c;
import com.baidu.swan.pms.c.d.b;
import com.facebook.common.internal.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<Integer> bYx = i.O(0, 1010, 1011, 1012, 1020, 1015);
    private static final Set<String> bYy = new HashSet();
    private static final c<String, String> bYz = new c<String, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.c
        /* renamed from: jz */
        public String I(String str) {
            return str;
        }
    };
    private static final c<b.a, String> bYA = new c<b.a, String>() { // from class: com.baidu.swan.apps.core.pms.d.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.c
        /* renamed from: a */
        public String I(b.a aVar) {
            return aVar == null ? "" : aVar.getBundleId();
        }
    };

    private static boolean aak() {
        return com.baidu.swan.apps.u.a.aeU().getSwitch("swan_predownload_effective", false);
    }

    public static boolean eX(int i) {
        return bYx.contains(Integer.valueOf(i));
    }

    public static boolean c(com.baidu.swan.pms.model.a aVar) {
        return aVar != null && eX(aVar.errorNo);
    }

    public static boolean H(String str, boolean z) {
        boolean booleanValue;
        boolean z2 = false;
        String str2 = "shouldDownloadItem app=" + str + " record=" + z + " : ";
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (bYy) {
            if (((Boolean) n(str2 + " should", Boolean.valueOf(z ? !bYy.add(str) : !bYy.contains(str)))).booleanValue() || !((Boolean) n(str2 + " AB", Boolean.valueOf(aak()))).booleanValue()) {
                z2 = true;
            }
            booleanValue = ((Boolean) n(str2, Boolean.valueOf(z2))).booleanValue();
        }
        return booleanValue;
    }

    public static boolean jx(String str) {
        return H(str, false);
    }

    public static List<String> e(Collection<String> collection) {
        return a(bYz, collection);
    }

    public static List<b.a> f(Collection<b.a> collection) {
        return a(bYA, collection);
    }

    public static <SwanItemT> List<SwanItemT> a(@NonNull c<SwanItemT, String> cVar, Collection<SwanItemT> collection, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            Iterator<SwanItemT> it = collection.iterator();
            while (it.hasNext()) {
                SwanItemT next = it.next();
                if (H(next == null ? "" : cVar.I(next), z)) {
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

    public static boolean jy(String str) {
        return H(str, true);
    }

    private static <T> T n(String str, T t) {
        if (DEBUG) {
            Log.i("PreDownloadUtils", "Recorded=" + bYy.size() + " # " + str + " => " + t);
        }
        return t;
    }
}
