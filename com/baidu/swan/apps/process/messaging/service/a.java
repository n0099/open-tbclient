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
    private final LinkedHashMap<SwanAppProcessInfo, b> aHD;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0162a {
        private static a aHE = new a();
    }

    public static a Jx() {
        return C0162a.aHE;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.aHD = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.aHD.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b cS(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.aHD.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> Jy() {
        return new LinkedHashSet<>(this.aHD.values());
    }

    public synchronized b gm(@Nullable String str) {
        b go;
        go = go(str);
        if (go == null) {
            go = Jz();
        }
        return go;
    }

    @NonNull
    public synchronized b gn(@Nullable String str) {
        b gm;
        gm = gm(str);
        b(gm.aHF);
        return gm;
    }

    public synchronized b Jz() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            gq("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                    a = this.aHD.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.aHF.isSwanAppProcess()) {
                        if (a.JJ()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.JI()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.aHJ) {
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
                    Iterator<b> it = this.aHD.values().iterator();
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
    public synchronized b JA() {
        b bVar;
        gq("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= SwanAppProcessInfo.PROCESS_ID_END) {
                b bVar2 = this.aHD.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.aHF.isSwanAppProcess()) {
                    if (bVar2.JJ()) {
                        bVar2 = bVar;
                    } else if (bVar2.JI()) {
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
    public synchronized b go(@Nullable String str) {
        List<b> gp;
        gp = gp(str);
        return gp.isEmpty() ? null : gp.get(gp.size() - 1);
    }

    @NonNull
    public synchronized List<b> gp(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.aHD.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.aHD.remove(swanAppProcessInfo);
        if (remove != null) {
            this.aHD.put(swanAppProcessInfo, remove);
        }
        gq("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> gp = Jx().gp(str);
            if (!gp.isEmpty()) {
                for (b bVar2 : gp) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.JJ()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.JE().JD();
                        if (bVar2.aHJ) {
                            com.baidu.swan.apps.process.messaging.service.b.JL().a(bVar2.aHF, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo aHF;
        public SwanAppCores aHG;
        private long aHH;
        private boolean aHI;
        public boolean aHJ;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.aHH = 0L;
            this.aHI = false;
            this.aHJ = false;
            this.aHF = swanAppProcessInfo;
        }

        public b JC() {
            JD();
            this.mMessenger = null;
            this.aHJ = false;
            this.aHG = null;
            JE();
            return this;
        }

        public b JD() {
            this.mAppId = "";
            return this;
        }

        public b JE() {
            this.aHI = false;
            this.aHH = 0L;
            return this;
        }

        public String JF() {
            return this.mAppId;
        }

        public b gr(String str) {
            return TextUtils.isEmpty(str) ? this : gt(str);
        }

        public b gt(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b JG() {
            this.aHH = System.currentTimeMillis();
            return this;
        }

        public b JH() {
            this.aHI = true;
            this.aHH = 0L;
            return this;
        }

        public boolean JI() {
            return this.aHI;
        }

        public boolean JJ() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b JK() {
            this.aHI = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.aHF.toString();
            objArr[1] = Integer.valueOf(this.aHJ ? 1 : 0);
            objArr[2] = Integer.valueOf(this.aHI ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.aHH));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void gq(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> Jy = Jy();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (b bVar : Jy) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
