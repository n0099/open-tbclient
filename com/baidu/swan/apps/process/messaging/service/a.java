package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import android.os.Messenger;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
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
    private final LinkedHashMap<SwanAppProcessInfo, b> aFb;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.process.messaging.service.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0155a {
        private static a aFc = new a();
    }

    public static a Gu() {
        return C0155a.aFc;
    }

    private a() {
        SwanAppProcessInfo[] indexById;
        this.aFb = new LinkedHashMap<>();
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indexById()) {
            if (swanAppProcessInfo != null && swanAppProcessInfo.isSwanAppProcess()) {
                this.aFb.put(swanAppProcessInfo, new b(swanAppProcessInfo));
            }
        }
    }

    public synchronized b cK(int i) {
        return a(SwanAppProcessInfo.getById(i));
    }

    public synchronized b a(SwanAppProcessInfo swanAppProcessInfo) {
        return this.aFb.get(swanAppProcessInfo);
    }

    public synchronized LinkedHashSet<b> Gv() {
        return new LinkedHashSet<>(this.aFb.values());
    }

    public synchronized b fP(@Nullable String str) {
        b fR;
        fR = fR(str);
        if (fR == null) {
            fR = Gw();
        }
        return fR;
    }

    @NonNull
    public synchronized b fQ(@Nullable String str) {
        b fP;
        fP = fP(str);
        b(fP.aFd);
        return fP;
    }

    public synchronized b Gw() {
        b a;
        b bVar;
        b bVar2 = null;
        synchronized (this) {
            fT("b4 computNextAvailableProcess");
            int i = 0;
            b bVar3 = null;
            while (true) {
                if (i <= 5) {
                    a = this.aFb.get(SwanAppProcessInfo.getById(i));
                    if (a != null && a.aFd.isSwanAppProcess()) {
                        if (a.GG()) {
                            a = bVar2;
                            bVar = bVar3;
                        } else if (a.GF()) {
                            if (DEBUG) {
                                Log.i("SwanAppClientObjManager", "computNextAvailableProcess: firstPreloadedClient=" + a);
                            }
                        } else {
                            if (bVar3 == null && a.aFh) {
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
                    Iterator<b> it = this.aFb.values().iterator();
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
    public synchronized b Gx() {
        b bVar;
        fT("b4 computNextPreloadProcess");
        int i = 0;
        bVar = null;
        while (true) {
            if (i <= 5) {
                b bVar2 = this.aFb.get(SwanAppProcessInfo.getById(i));
                if (bVar2 != null && bVar2.aFd.isSwanAppProcess()) {
                    if (bVar2.GG()) {
                        bVar2 = bVar;
                    } else if (bVar2.GF()) {
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
    public synchronized b fR(@Nullable String str) {
        List<b> fS;
        fS = fS(str);
        return fS.isEmpty() ? null : fS.get(fS.size() - 1);
    }

    @NonNull
    public synchronized List<b> fS(@Nullable String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (b bVar : this.aFb.values()) {
                if (TextUtils.equals(bVar.mAppId, str)) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    public synchronized void b(SwanAppProcessInfo swanAppProcessInfo) {
        b remove = this.aFb.remove(swanAppProcessInfo);
        if (remove != null) {
            this.aFb.put(swanAppProcessInfo, remove);
        }
        fT("lru -> " + swanAppProcessInfo);
    }

    public void a(String str, b bVar) {
        if (!TextUtils.isEmpty(str)) {
            List<b> fS = Gu().fS(str);
            if (!fS.isEmpty()) {
                for (b bVar2 : fS) {
                    if (bVar2 != bVar && bVar2 != null && bVar2.GG()) {
                        if (DEBUG) {
                            Log.i("SwanAppClientObjManager", "deduplicateClients: protectedClient=" + bVar);
                            Log.i("SwanAppClientObjManager", "deduplicateClients: exClient=" + bVar2);
                        }
                        bVar2.GB().GA();
                        if (bVar2.aFh) {
                            com.baidu.swan.apps.process.messaging.service.b.GI().a(bVar2.aFd, 110, new Bundle());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        public final SwanAppProcessInfo aFd;
        public SwanAppCores aFe;
        private long aFf;
        private boolean aFg;
        public boolean aFh;
        private String mAppId;
        public Messenger mMessenger;

        private b(SwanAppProcessInfo swanAppProcessInfo) {
            this.mAppId = "";
            this.mMessenger = null;
            this.aFf = 0L;
            this.aFg = false;
            this.aFh = false;
            this.aFd = swanAppProcessInfo;
        }

        public b Gz() {
            GA();
            this.mMessenger = null;
            this.aFh = false;
            this.aFe = null;
            GB();
            return this;
        }

        public b GA() {
            this.mAppId = "";
            return this;
        }

        public b GB() {
            this.aFg = false;
            this.aFf = 0L;
            return this;
        }

        public String GC() {
            return this.mAppId;
        }

        public b fU(String str) {
            return TextUtils.isEmpty(str) ? this : fV(str);
        }

        public b fV(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "ai_app_id_unknown";
            }
            this.mAppId = str;
            return this;
        }

        public b GD() {
            this.aFf = System.currentTimeMillis();
            return this;
        }

        public b GE() {
            this.aFg = true;
            this.aFf = 0L;
            return this;
        }

        public boolean GF() {
            return this.aFg;
        }

        public boolean GG() {
            return !TextUtils.isEmpty(this.mAppId);
        }

        public b GH() {
            this.aFg = false;
            return this;
        }

        public String toString() {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[5];
            objArr[0] = this.aFd.toString();
            objArr[1] = Integer.valueOf(this.aFh ? 1 : 0);
            objArr[2] = Integer.valueOf(this.aFg ? 1 : 0);
            objArr[3] = SimpleDateFormat.getTimeInstance(2).format(new Date(this.aFf));
            objArr[4] = this.mAppId;
            return String.format(locale, "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", objArr);
        }
    }

    public void fT(String str) {
        if (DEBUG) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            Log.i("SwanAppClientObjManager", "\nlogStatus by " + str + ":\n" + toString());
        }
    }

    public String toString() {
        LinkedHashSet<b> Gv = Gv();
        StringBuilder append = new StringBuilder().append(super.toString()).append(Config.TRACE_TODAY_VISIT_SPLIT).append("\n-> clients: ");
        for (b bVar : Gv) {
            append.append("\n--> ").append(bVar.toString());
        }
        return append.toString();
    }
}
