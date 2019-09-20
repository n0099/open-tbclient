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
    private final LinkedHashMap<SwanAppProcessInfo, b> aIb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0171a {
        private static a aIc = new a();
    }

    public static a JB() {
        return C0171a.aIc;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.aIb = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.aIb.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b cT(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.aIb.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> JC() {
        return new LinkedHashSet<>(this.aIb.values());
    }

    public synchronized b go(@Nullable String str) {
        b gq;
        gq = gq(str);
        if (gq == null) {
            gq = JD();
        }
        return gq;
    }

    @NonNull
    public synchronized b gp(@Nullable String str) {
        b go;
        go = go(str);
        b(go.aId);
        return go;
    }

    public synchronized b JD() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            gt("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                    a = this.aIb.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.aId.isSwanAppProcess()) {
                        if (a.JN()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.JM()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.aIh) {
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
                    Iterator<b> it = this.aIb.values().iterator();
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
    public synchronized b JE() {
        b bVar;
        gt("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                b bVar2 = this.aIb.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.aId.isSwanAppProcess()) {
                    if (bVar2.JN()) {
                        bVar2 = bVar;
                    } else if (bVar2.JM()) {
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
    public synchronized b gq(@Nullable String str) {
        List<b> gr;
        gr = gr(str);
        return gr.isEmpty() ? null : gr.get(gr.size() - 1);
    }

    @NonNull
    public synchronized List<b> gr(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.aIb.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.aIb.remove(swanAppProcessInfo);
        if (remove != null) {
            this.aIb.put(swanAppProcessInfo, remove);
        }
        gt("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> gr = JB().gr(str);
            if (!gr.isEmpty()) {
                for (b bVar2 : gr) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.JN()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.JI().JH();
                        if (bVar2.aIh) {
                            com.baidu.swan.apps.process.messaging.service.b.JP().a(bVar2.aId, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo aId;
        public SwanAppCores aIe;
        private long aIf;
        private boolean aIg;
        public boolean aIh;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.aIf = 0L;
            this.aIg = false;
            this.aIh = false;
            this.aId = swanAppProcessInfo;
        }

        public b JG() {
            JH();
            this.mMessenger = null;
            this.aIh = false;
            this.aIe = null;
            JI();
            return this;
        }

        public b JH() {
            this.mAppId = "";
            return this;
        }

        public b JI() {
            this.aIg = false;
            this.aIf = 0L;
            return this;
        }

        public String JJ() {
            return this.mAppId;
        }

        public b gu(String str) {
            return TextUtils.isEmpty(str) ? this : gv(str);
        }

        public b gv(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b JK() {
            this.aIf = System.currentTimeMillis();
            return this;
        }

        public b JL() {
            this.aIg = true;
            this.aIf = 0L;
            return this;
        }

        public boolean JM() {
            return this.aIg;
        }

        public boolean JN() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b JO() {
            this.aIg = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.aId.toString();
            objArr[1] = Integer.valueOf(this.aIh ? 1 : 0);
            objArr[2] = Integer.valueOf(this.aIg ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.aIf));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void gt(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> JC = JC();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (b bVar : JC) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
