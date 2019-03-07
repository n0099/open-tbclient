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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private final LinkedHashMap<SwanAppProcessInfo, b> aEX;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0126a {
        private static a aEY = new a();
    }

    public static a Gw() {
        return C0126a.aEY;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.aEX = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.aEX.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b cL(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.aEX.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> Gx() {
        return new LinkedHashSet<>(this.aEX.values());
    }

    public synchronized b fO(@Nullable String str) {
        b fQ;
        fQ = fQ(str);
        if (fQ == null) {
            fQ = Gy();
        }
        return fQ;
    }

    @NonNull
    public synchronized b fP(@Nullable String str) {
        b fO;
        fO = fO(str);
        b(fO.aEZ);
        return fO;
    }

    public synchronized b Gy() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            fS("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= 5) {
                    a = this.aEX.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.aEZ.isSwanAppProcess()) {
                        if (a.GI()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.GH()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.aFd) {
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
                    Iterator<b> it = this.aEX.values().iterator();
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
    public synchronized b Gz() {
        b bVar;
        fS("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= 5) {
                b bVar2 = this.aEX.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.aEZ.isSwanAppProcess()) {
                    if (bVar2.GI()) {
                        bVar2 = bVar;
                    } else if (bVar2.GH()) {
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
    public synchronized b fQ(@Nullable String str) {
        List<b> fR;
        fR = fR(str);
        return fR.isEmpty() ? null : fR.get(fR.size() - 1);
    }

    @NonNull
    public synchronized List<b> fR(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.aEX.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.aEX.remove(swanAppProcessInfo);
        if (remove != null) {
            this.aEX.put(swanAppProcessInfo, remove);
        }
        fS("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> fR = Gw().fR(str);
            if (!fR.isEmpty()) {
                for (b bVar2 : fR) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.GI()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.GD().GC();
                        if (bVar2.aFd) {
                            com.baidu.swan.apps.process.messaging.service.b.GK().a(bVar2.aEZ, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo aEZ;
        public SwanAppCores aFa;
        private long aFb;
        private boolean aFc;
        public boolean aFd;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.aFb = 0L;
            this.aFc = false;
            this.aFd = false;
            this.aEZ = swanAppProcessInfo;
        }

        public b GB() {
            GC();
            this.mMessenger = null;
            this.aFd = false;
            this.aFa = null;
            GD();
            return this;
        }

        public b GC() {
            this.mAppId = "";
            return this;
        }

        public b GD() {
            this.aFc = false;
            this.aFb = 0L;
            return this;
        }

        public String GE() {
            return this.mAppId;
        }

        public b fT(String str) {
            return TextUtils.isEmpty(str) ? this : fU(str);
        }

        public b fU(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b GF() {
            this.aFb = System.currentTimeMillis();
            return this;
        }

        public b GG() {
            this.aFc = true;
            this.aFb = 0L;
            return this;
        }

        public boolean GH() {
            return this.aFc;
        }

        public boolean GI() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b GJ() {
            this.aFc = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.aEZ.toString();
            objArr[1] = Integer.valueOf(this.aFd ? 1 : 0);
            objArr[2] = Integer.valueOf(this.aFc ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.aFb));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void fS(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> Gx = Gx();
        StringBuilder append = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (b bVar : Gx) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
