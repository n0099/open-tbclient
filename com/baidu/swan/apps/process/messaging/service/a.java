package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final LinkedHashMap<SwanAppProcessInfo, b> baX;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0198a {
        private static a baY = new a();
    }

    public static a Ow() {
        return C0198a.baY;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.baX = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.baX.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b dO(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.baX.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> Ox() {
        return new LinkedHashSet<>(this.baX.values());
    }

    public synchronized b gT(@Nullable String str) {
        b gV;
        gV = gV(str);
        if (gV == null) {
            gV = Oy();
        }
        return gV;
    }

    @NonNull
    public synchronized b gU(@Nullable String str) {
        b gT;
        gT = gT(str);
        b(gT.baZ);
        return gT;
    }

    public synchronized b Oy() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            gX("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                    a = this.baX.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.baZ.isSwanAppProcess()) {
                        if (a.OI()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.OH()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.bbd) {
                                bVar3 = a;
                            }
                            if (bVar2 == null) {
                                bVar = bVar3;
                            }
                        }
                        i++;
                        bVar3 = bVar;
                        bVar2 = a;
                    }
                    a = bVar2;
                    bVar = bVar3;
                    i++;
                    bVar3 = bVar;
                    bVar2 = a;
                } else if (bVar3 != null) {
                    if (DEBUG) {
                        Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstConnectedEmptyClient=" + bVar3);
                    }
                    a = bVar3;
                } else if (bVar2 != null) {
                    if (DEBUG) {
                        Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstEmptyClient=" + bVar2);
                    }
                    a = bVar2;
                } else {
                    Iterator<b> it = this.baX.values().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            a = it.next();
                            if (a != null) {
                                if (DEBUG) {
                                    Log.i("SwanAppClientObjManager", "computNextAvailableProcess: lruClient=" + a);
                                }
                            }
                        } else {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: P0");
                            }
                            a = a(SwanAppProcessInfo.P0);
                        }
                    }
                }
            }
        }
        return a;
    }

    @Nullable
    public synchronized b Oz() {
        b bVar;
        gX("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                b bVar2 = this.baX.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.baZ.isSwanAppProcess()) {
                    if (bVar2.OI()) {
                        bVar2 = bVar;
                    } else if (bVar2.OH()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "computNextPreloadProcess: return null by found empty process=" + bVar2);
                        }
                        bVar = null;
                    } else if (bVar == null) {
                    }
                    i++;
                    bVar = bVar2;
                }
                bVar2 = bVar;
                i++;
                bVar = bVar2;
            } else if (DEBUG) {
                Log.i("SwanAppClientObjManager", "computNextPreloadProcess: firstPreloadableClient=" + bVar);
            }
        }
        return bVar;
    }

    @Nullable
    public synchronized b gV(@Nullable String str) {
        List<b> gW;
        gW = gW(str);
        return gW.isEmpty() ? null : gW.get(gW.size() - 1);
    }

    @NonNull
    public synchronized List<b> gW(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.baX.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.baX.remove(swanAppProcessInfo);
        if (remove != null) {
            this.baX.put(swanAppProcessInfo, remove);
        }
        gX("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> gW = Ow().gW(str);
            if (!gW.isEmpty()) {
                for (b bVar2 : gW) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.OI()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.OD().OC();
                        if (bVar2.bbd) {
                            com.baidu.swan.apps.process.messaging.service.b.OK().a(bVar2.baZ, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo baZ;
        public SwanAppCores bba;
        private long bbb;
        private boolean bbc;
        public boolean bbd;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.bbb = 0L;
            this.bbc = false;
            this.bbd = false;
            this.baZ = swanAppProcessInfo;
        }

        public b OB() {
            OC();
            this.mMessenger = null;
            this.bbd = false;
            this.bba = null;
            OD();
            return this;
        }

        public b OC() {
            this.mAppId = "";
            return this;
        }

        public b OD() {
            this.bbc = false;
            this.bbb = 0L;
            return this;
        }

        public String OE() {
            return this.mAppId;
        }

        public b gY(String str) {
            return TextUtils.isEmpty(str) ? this : gZ(str);
        }

        public b gZ(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b OF() {
            this.bbb = System.currentTimeMillis();
            return this;
        }

        public b OG() {
            this.bbc = true;
            this.bbb = 0L;
            return this;
        }

        public boolean OH() {
            return this.bbc;
        }

        public boolean OI() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b OJ() {
            this.bbc = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.baZ.toString();
            objArr[1] = Integer.valueOf(this.bbd ? 1 : 0);
            objArr[2] = Integer.valueOf(this.bbc ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.bbb));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void gX(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> Ox = Ox();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (b bVar : Ox) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
