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
/* loaded from: classes10.dex */
public final class c {
    public static final c cMK = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cMI = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cMJ = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.n(fVar, "updater");
        q.n(str, "libName");
        e nJ = nJ(str);
        if (nJ == null) {
            e eVar = new e(fVar, str);
            cMJ.put(str, eVar);
            return eVar;
        }
        return nJ;
    }

    public final e nJ(String str) {
        q.n(str, "libName");
        return cMJ.get(str);
    }

    public final void nK(String str) {
        q.n(str, "libName");
        cMJ.remove(str);
    }

    public final void a(d dVar) {
        q.n(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cMO);
        f fVar = new f(new com.baidu.swan.pms.c.d.h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes10.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b cMO = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void M(Exception exc) {
            c cVar = c.cMK;
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
        com.baidu.swan.apps.env.b.a nI = com.baidu.swan.apps.env.b.b.nI(str);
        if (nI == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().bZ(16).cb(2900).tM("not available: so=" + nI));
        } else if (nI.aqP()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nI);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.aYH().xX(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).aoD() || !AbiType.currentAbi().compat(((i) objectRef.element).ebU)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().bZ(16).cb(2900).tM("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nN = nN(str);
            if (l(str, ((i) objectRef.element).versionCode) && nN != null && nN.compat(((i) objectRef.element).ebU)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nI.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes10.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cML;
        final /* synthetic */ Ref.ObjectRef cMM;
        final /* synthetic */ kotlin.jvm.a.b cMN;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cML = str;
            this.cMM = objectRef;
            this.cMN = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void eU(boolean z) {
            c cVar = c.cMK;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cML);
            }
            if (z) {
                c.cMK.n(this.cML, ((i) this.cMM.element).versionCode);
                c cVar2 = c.cMK;
                String str = this.cML;
                String str2 = ((i) this.cMM.element).versionName;
                q.m(str2, "soPkg.versionName");
                cVar2.bF(str, str2);
                c cVar3 = c.cMK;
                String str3 = this.cML;
                AbiType abiType = ((i) this.cMM.element).ebU;
                q.m(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cMN.invoke(null);
                return;
            }
            this.cMN.invoke(new com.baidu.swan.apps.am.a().bZ(16).cb(2900).tM("install error: pkg=" + ((i) this.cMM.element)));
        }
    }

    private final File aqU() {
        Context appContext = AppRuntime.getAppContext();
        q.m(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cMI);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.ebU : null) == null) {
            return "";
        }
        String str = iVar.cMz;
        q.m(str, "so.libName");
        AbiType abiType = iVar.ebU;
        q.m(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.n(str, "libName");
        q.n(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(aqU(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean nL(String str) {
        q.n(str, "libName");
        return l(str, nM(str));
    }

    public final boolean l(String str, long j) {
        AbiType nN;
        q.n(str, "libName");
        com.baidu.swan.apps.env.b.a nI = com.baidu.swan.apps.env.b.b.nI(str);
        if (nI != null) {
            if (nI.aqP()) {
                return true;
            }
            long nM = nM(str);
            if (nM <= 0 || j > nM || (nN = nN(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nN);
        }
        return false;
    }

    public final void m(String str, long j) {
        q.n(str, "libName");
        g.baf().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nM(String str) {
        return com.baidu.swan.apps.storage.c.h.aIs().getLong(nO(str), 0L);
    }

    private final AbiType nN(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aIs().getString(nQ(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aIs().putLong(nO(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bF(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aIs().putString(nP(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aIs().putString(nQ(str), abiType.id);
    }

    private final String nO(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nP(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nQ(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
