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
/* loaded from: classes9.dex */
public final class c {
    public static final c dac = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String daa = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> dab = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        p.o(fVar, "updater");
        p.o(str, "libName");
        e ny = ny(str);
        if (ny == null) {
            e eVar = new e(fVar, str);
            dab.put(str, eVar);
            return eVar;
        }
        return ny;
    }

    public final e ny(String str) {
        p.o(str, "libName");
        return dab.get(str);
    }

    public final void nz(String str) {
        p.o(str, "libName");
        dab.remove(str);
    }

    public final void a(d dVar) {
        p.o(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.dag);
        f fVar = new f(new h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes9.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<Exception> {
        public static final b dag = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: q */
        public final void L(Exception exc) {
            c cVar = c.dac;
            if (c.DEBUG) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo end with e: " + exc + " trace=" + Log.getStackTraceString(exc != null ? exc : new Exception()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.baidu.swan.pms.model.i] */
    public final void a(String str, kotlin.jvm.a.b<? super com.baidu.swan.apps.al.a, kotlin.h> bVar) {
        p.o(str, "libName");
        p.o(bVar, BuyTBeanActivityConfig.CALLBACK);
        if (DEBUG) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        com.baidu.swan.apps.env.b.a nx = com.baidu.swan.apps.env.b.b.nx(str);
        if (nx == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tH("not available: so=" + nx));
        } else if (nx.atN()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nx);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bcv().xU(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).arz() || !AbiType.currentAbi().compat(((i) objectRef.element).eui)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tH("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nC = nC(str);
            if (k(str, ((i) objectRef.element).versionCode) && nC != null && nC.compat(((i) objectRef.element).eui)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nx.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes9.dex */
    public static final class a implements b.a {
        final /* synthetic */ String dad;
        final /* synthetic */ Ref.ObjectRef dae;
        final /* synthetic */ kotlin.jvm.a.b daf;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.dad = str;
            this.dae = objectRef;
            this.daf = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fC(boolean z) {
            c cVar = c.dac;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.dad);
            }
            if (z) {
                c.dac.m(this.dad, ((i) this.dae.element).versionCode);
                c cVar2 = c.dac;
                String str = this.dad;
                String str2 = ((i) this.dae.element).versionName;
                p.n(str2, "soPkg.versionName");
                cVar2.bD(str, str2);
                c cVar3 = c.dac;
                String str3 = this.dad;
                AbiType abiType = ((i) this.dae.element).eui;
                p.n(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.daf.invoke(null);
                return;
            }
            this.daf.invoke(new com.baidu.swan.apps.al.a().db(16).dd(2900).tH("install error: pkg=" + ((i) this.dae.element)));
        }
    }

    private final File atS() {
        Context appContext = AppRuntime.getAppContext();
        p.n(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), daa);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.eui : null) == null) {
            return "";
        }
        String str = iVar.libName;
        p.n(str, "so.libName");
        AbiType abiType = iVar.eui;
        p.n(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        p.o(str, "libName");
        p.o(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(atS(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean nA(String str) {
        p.o(str, "libName");
        return k(str, nB(str));
    }

    public final boolean k(String str, long j) {
        AbiType nC;
        p.o(str, "libName");
        com.baidu.swan.apps.env.b.a nx = com.baidu.swan.apps.env.b.b.nx(str);
        if (nx != null) {
            if (nx.atN()) {
                return true;
            }
            long nB = nB(str);
            if (nB <= 0 || j > nB || (nC = nC(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nC);
        }
        return false;
    }

    public final void l(String str, long j) {
        p.o(str, "libName");
        g.bdS().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nB(String str) {
        return com.baidu.swan.apps.storage.c.h.aMh().getLong(nD(str), 0L);
    }

    private final AbiType nC(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aMh().getString(nF(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aMh().putLong(nD(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bD(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aMh().putString(nE(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aMh().putString(nF(str), abiType.id);
    }

    private final String nD(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nE(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nF(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
