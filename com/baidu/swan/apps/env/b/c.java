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
    public static final c cXS = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cXQ = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cXR = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        p.o(fVar, "updater");
        p.o(str, "libName");
        e ng = ng(str);
        if (ng == null) {
            e eVar = new e(fVar, str);
            cXR.put(str, eVar);
            return eVar;
        }
        return ng;
    }

    public final e ng(String str) {
        p.o(str, "libName");
        return cXR.get(str);
    }

    public final void nh(String str) {
        p.o(str, "libName");
        cXR.remove(str);
    }

    public final void a(d dVar) {
        p.o(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cXW);
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
        public static final b cXW = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: q */
        public final void L(Exception exc) {
            c cVar = c.cXS;
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
        com.baidu.swan.apps.env.b.a nf = com.baidu.swan.apps.env.b.b.nf(str);
        if (nf == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).to("not available: so=" + nf));
        } else if (nf.atp()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nf);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bci().xB(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).arb() || !AbiType.currentAbi().compat(((i) objectRef.element).esb)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).to("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nk = nk(str);
            if (l(str, ((i) objectRef.element).versionCode) && nk != null && nk.compat(((i) objectRef.element).esb)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nf.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes8.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cXT;
        final /* synthetic */ Ref.ObjectRef cXU;
        final /* synthetic */ kotlin.jvm.a.b cXV;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cXT = str;
            this.cXU = objectRef;
            this.cXV = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fA(boolean z) {
            c cVar = c.cXS;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cXT);
            }
            if (z) {
                c.cXS.n(this.cXT, ((i) this.cXU.element).versionCode);
                c cVar2 = c.cXS;
                String str = this.cXT;
                String str2 = ((i) this.cXU.element).versionName;
                p.n(str2, "soPkg.versionName");
                cVar2.bJ(str, str2);
                c cVar3 = c.cXS;
                String str3 = this.cXT;
                AbiType abiType = ((i) this.cXU.element).esb;
                p.n(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cXV.invoke(null);
                return;
            }
            this.cXV.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).to("install error: pkg=" + ((i) this.cXU.element)));
        }
    }

    private final File atu() {
        Context appContext = AppRuntime.getAppContext();
        p.n(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cXQ);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.esb : null) == null) {
            return "";
        }
        String str = iVar.libName;
        p.n(str, "so.libName");
        AbiType abiType = iVar.esb;
        p.n(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        p.o(str, "libName");
        p.o(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(atu(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean ni(String str) {
        p.o(str, "libName");
        return l(str, nj(str));
    }

    public final boolean l(String str, long j) {
        AbiType nk;
        p.o(str, "libName");
        com.baidu.swan.apps.env.b.a nf = com.baidu.swan.apps.env.b.b.nf(str);
        if (nf != null) {
            if (nf.atp()) {
                return true;
            }
            long nj = nj(str);
            if (nj <= 0 || j > nj || (nk = nk(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nk);
        }
        return false;
    }

    public final void m(String str, long j) {
        p.o(str, "libName");
        g.bdF().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nj(String str) {
        return com.baidu.swan.apps.storage.c.h.aLO().getLong(nl(str), 0L);
    }

    private final AbiType nk(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aLO().getString(nn(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aLO().putLong(nl(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bJ(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aLO().putString(nm(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aLO().putString(nn(str), abiType.id);
    }

    private final String nl(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nm(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nn(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
