package com.baidu.swan.apps.env.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.swan.pms.c.d.h;
import com.baidu.swan.pms.e.b;
import com.baidu.swan.pms.model.i;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.swan.pms.utils.g;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class c {
    public static final c dbF = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dbD = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> dbE = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        p.p(fVar, "updater");
        p.p(str, "libName");
        e nF = nF(str);
        if (nF == null) {
            e eVar = new e(fVar, str);
            dbE.put(str, eVar);
            return eVar;
        }
        return nF;
    }

    public final e nF(String str) {
        p.p(str, "libName");
        return dbE.get(str);
    }

    public final void nG(String str) {
        p.p(str, "libName");
        dbE.remove(str);
    }

    public final void a(d dVar) {
        p.p(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.dbJ);
        f fVar = new f(new h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes8.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<Exception> {
        public static final b dbJ = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: q */
        public final void N(Exception exc) {
            c cVar = c.dbF;
            if (c.DEBUG) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo end with e: " + exc + " trace=" + Log.getStackTraceString(exc != null ? exc : new Exception()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.baidu.swan.pms.model.i] */
    public final void a(String str, kotlin.jvm.a.b<? super com.baidu.swan.apps.al.a, kotlin.h> bVar) {
        p.p(str, "libName");
        p.p(bVar, BuyTBeanActivityConfig.CALLBACK);
        if (DEBUG) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        com.baidu.swan.apps.env.b.a nE = com.baidu.swan.apps.env.b.b.nE(str);
        if (nE == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tO("not available: so=" + nE));
        } else if (nE.atQ()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nE);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bcx().yb(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).arC() || !AbiType.currentAbi().compat(((i) objectRef.element).evJ)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tO("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nJ = nJ(str);
            if (k(str, ((i) objectRef.element).versionCode) && nJ != null && nJ.compat(((i) objectRef.element).evJ)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nE.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes8.dex */
    public static final class a implements b.a {
        final /* synthetic */ String dbG;
        final /* synthetic */ Ref.ObjectRef dbH;
        final /* synthetic */ kotlin.jvm.a.b dbI;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.dbG = str;
            this.dbH = objectRef;
            this.dbI = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fC(boolean z) {
            c cVar = c.dbF;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.dbG);
            }
            if (z) {
                c.dbF.m(this.dbG, ((i) this.dbH.element).versionCode);
                c cVar2 = c.dbF;
                String str = this.dbG;
                String str2 = ((i) this.dbH.element).versionName;
                p.o(str2, "soPkg.versionName");
                cVar2.bD(str, str2);
                c cVar3 = c.dbF;
                String str3 = this.dbG;
                AbiType abiType = ((i) this.dbH.element).evJ;
                p.o(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.dbI.invoke(null);
                return;
            }
            this.dbI.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tO("install error: pkg=" + ((i) this.dbH.element)));
        }
    }

    private final File atV() {
        Context appContext = AppRuntime.getAppContext();
        p.o(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), dbD);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.evJ : null) == null) {
            return "";
        }
        String str = iVar.dbu;
        p.o(str, "so.libName");
        AbiType abiType = iVar.evJ;
        p.o(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        p.p(str, "libName");
        p.p(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(atV(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean nH(String str) {
        p.p(str, "libName");
        return k(str, nI(str));
    }

    public final boolean k(String str, long j) {
        AbiType nJ;
        p.p(str, "libName");
        com.baidu.swan.apps.env.b.a nE = com.baidu.swan.apps.env.b.b.nE(str);
        if (nE != null) {
            if (nE.atQ()) {
                return true;
            }
            long nI = nI(str);
            if (nI <= 0 || j > nI || (nJ = nJ(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nJ);
        }
        return false;
    }

    public final void l(String str, long j) {
        p.p(str, "libName");
        g.bdU().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nI(String str) {
        return com.baidu.swan.apps.storage.c.h.aMk().getLong(nK(str), 0L);
    }

    private final AbiType nJ(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aMk().getString(nM(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aMk().putLong(nK(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bD(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aMk().putString(nL(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aMk().putString(nM(str), abiType.id);
    }

    private final String nK(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nL(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nM(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
