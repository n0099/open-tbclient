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
    private final LinkedHashMap<SwanAppProcessInfo, b> aGV;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0160a {
        private static a aGW = new a();
    }

    public static a IK() {
        return C0160a.aGW;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.aGV = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.aGV.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b cP(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.aGV.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> IL() {
        return new LinkedHashSet<>(this.aGV.values());
    }

    public synchronized b gg(@Nullable String str) {
        b gi;
        gi = gi(str);
        if (gi == null) {
            gi = IM();
        }
        return gi;
    }

    @NonNull
    public synchronized b gh(@Nullable String str) {
        b gg;
        gg = gg(str);
        b(gg.aGX);
        return gg;
    }

    public synchronized b IM() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            gk("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                    a = this.aGV.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.aGX.isSwanAppProcess()) {
                        if (a.IW()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.IV()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.aHb) {
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
                    Iterator<b> it = this.aGV.values().iterator();
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
    public synchronized b IN() {
        b bVar;
        gk("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                b bVar2 = this.aGV.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.aGX.isSwanAppProcess()) {
                    if (bVar2.IW()) {
                        bVar2 = bVar;
                    } else if (bVar2.IV()) {
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
    public synchronized b gi(@Nullable String str) {
        List<b> gj;
        gj = gj(str);
        return gj.isEmpty() ? null : gj.get(gj.size() - 1);
    }

    @NonNull
    public synchronized List<b> gj(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.aGV.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.aGV.remove(swanAppProcessInfo);
        if (remove != null) {
            this.aGV.put(swanAppProcessInfo, remove);
        }
        gk("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> gj = IK().gj(str);
            if (!gj.isEmpty()) {
                for (b bVar2 : gj) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.IW()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.IR().IQ();
                        if (bVar2.aHb) {
                            com.baidu.swan.apps.process.messaging.service.b.IY().a(bVar2.aGX, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo aGX;
        public SwanAppCores aGY;
        private long aGZ;
        private boolean aHa;
        public boolean aHb;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.aGZ = 0L;
            this.aHa = false;
            this.aHb = false;
            this.aGX = swanAppProcessInfo;
        }

        public b IP() {
            IQ();
            this.mMessenger = null;
            this.aHb = false;
            this.aGY = null;
            IR();
            return this;
        }

        public b IQ() {
            this.mAppId = "";
            return this;
        }

        public b IR() {
            this.aHa = false;
            this.aGZ = 0L;
            return this;
        }

        public String IS() {
            return this.mAppId;
        }

        public b gl(String str) {
            return TextUtils.isEmpty(str) ? this : gm(str);
        }

        public b gm(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b IT() {
            this.aGZ = System.currentTimeMillis();
            return this;
        }

        public b IU() {
            this.aHa = true;
            this.aGZ = 0L;
            return this;
        }

        public boolean IV() {
            return this.aHa;
        }

        public boolean IW() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b IX() {
            this.aHa = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.aGX.toString();
            objArr[1] = Integer.valueOf(this.aHb ? 1 : 0);
            objArr[2] = Integer.valueOf(this.aHa ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.aGZ));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void gk(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> IL = IL();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (b bVar : IL) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
