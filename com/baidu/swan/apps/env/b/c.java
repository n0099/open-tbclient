package com.baidu.swan.apps.env.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.e.b;
import com.baidu.swan.pms.model.i;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.swan.pms.utils.g;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
/* loaded from: classes7.dex */
public final class c {
    public static final c cQT = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cQR = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cQS = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.n(fVar, "updater");
        q.n(str, "libName");
        e nR = nR(str);
        if (nR == null) {
            e eVar = new e(fVar, str);
            cQS.put(str, eVar);
            return eVar;
        }
        return nR;
    }

    public final e nR(String str) {
        q.n(str, "libName");
        return cQS.get(str);
    }

    public final void nS(String str) {
        q.n(str, "libName");
        cQS.remove(str);
    }

    public final void a(d dVar) {
        q.n(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cQX);
        f fVar = new f(new com.baidu.swan.pms.c.d.h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes7.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b cQX = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void M(Exception exc) {
            c cVar = c.cQT;
            if (c.DEBUG) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo end with e: " + exc + " trace=" + Log.getStackTraceString(exc != null ? exc : new Exception()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.baidu.swan.pms.model.i] */
    public final void a(String str, kotlin.jvm.a.b<? super com.baidu.swan.apps.am.a, l> bVar) {
        q.n(str, "libName");
        q.n(bVar, BuyTBeanActivityConfig.CALLBACK);
        if (DEBUG) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        com.baidu.swan.apps.env.b.a nQ = com.baidu.swan.apps.env.b.b.nQ(str);
        if (nQ == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).tV("not available: so=" + nQ));
        } else if (nQ.asI()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nQ);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.baA().yg(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).aqw() || !AbiType.currentAbi().compat(((i) objectRef.element).ege)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).tV("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nV = nV(str);
            if (l(str, ((i) objectRef.element).versionCode) && nV != null && nV.compat(((i) objectRef.element).ege)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nQ.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes7.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cQU;
        final /* synthetic */ Ref.ObjectRef cQV;
        final /* synthetic */ kotlin.jvm.a.b cQW;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cQU = str;
            this.cQV = objectRef;
            this.cQW = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fg(boolean z) {
            c cVar = c.cQT;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cQU);
            }
            if (z) {
                c.cQT.n(this.cQU, ((i) this.cQV.element).versionCode);
                c cVar2 = c.cQT;
                String str = this.cQU;
                String str2 = ((i) this.cQV.element).versionName;
                q.m(str2, "soPkg.versionName");
                cVar2.bE(str, str2);
                c cVar3 = c.cQT;
                String str3 = this.cQU;
                AbiType abiType = ((i) this.cQV.element).ege;
                q.m(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cQW.invoke(null);
                return;
            }
            this.cQW.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).tV("install error: pkg=" + ((i) this.cQV.element)));
        }
    }

    private final File asN() {
        Context appContext = AppRuntime.getAppContext();
        q.m(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cQR);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.ege : null) == null) {
            return "";
        }
        String str = iVar.cQI;
        q.m(str, "so.libName");
        AbiType abiType = iVar.ege;
        q.m(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.n(str, "libName");
        q.n(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(asN(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean nT(String str) {
        q.n(str, "libName");
        return l(str, nU(str));
    }

    public final boolean l(String str, long j) {
        AbiType nV;
        q.n(str, "libName");
        com.baidu.swan.apps.env.b.a nQ = com.baidu.swan.apps.env.b.b.nQ(str);
        if (nQ != null) {
            if (nQ.asI()) {
                return true;
            }
            long nU = nU(str);
            if (nU <= 0 || j > nU || (nV = nV(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nV);
        }
        return false;
    }

    public final void m(String str, long j) {
        q.n(str, "libName");
        g.bbY().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nU(String str) {
        return com.baidu.swan.apps.storage.c.h.aKk().getLong(nW(str), 0L);
    }

    private final AbiType nV(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aKk().getString(nY(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aKk().putLong(nW(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bE(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aKk().putString(nX(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aKk().putString(nY(str), abiType.id);
    }

    private final String nW(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nX(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nY(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
