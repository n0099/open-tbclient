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
    public static final c dcH = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String dcF = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> dcG = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        p.o(fVar, "updater");
        p.o(str, "libName");
        e ot = ot(str);
        if (ot == null) {
            e eVar = new e(fVar, str);
            dcG.put(str, eVar);
            return eVar;
        }
        return ot;
    }

    public final e ot(String str) {
        p.o(str, "libName");
        return dcG.get(str);
    }

    public final void ou(String str) {
        p.o(str, "libName");
        dcG.remove(str);
    }

    public final void a(d dVar) {
        p.o(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.dcL);
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
        public static final b dcL = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: q */
        public final void L(Exception exc) {
            c cVar = c.dcH;
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
        com.baidu.swan.apps.env.b.a os = com.baidu.swan.apps.env.b.b.os(str);
        if (os == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).uz("not available: so=" + os));
        } else if (os.axj()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + os);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bgc().yM(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).auW() || !AbiType.currentAbi().compat(((i) objectRef.element).ewO)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).uz("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType ox = ox(str);
            if (l(str, ((i) objectRef.element).versionCode) && ox != null && ox.compat(((i) objectRef.element).ewO)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            os.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes9.dex */
    public static final class a implements b.a {
        final /* synthetic */ String dcI;
        final /* synthetic */ Ref.ObjectRef dcJ;
        final /* synthetic */ kotlin.jvm.a.b dcK;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.dcI = str;
            this.dcJ = objectRef;
            this.dcK = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fE(boolean z) {
            c cVar = c.dcH;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.dcI);
            }
            if (z) {
                c.dcH.n(this.dcI, ((i) this.dcJ.element).versionCode);
                c cVar2 = c.dcH;
                String str = this.dcI;
                String str2 = ((i) this.dcJ.element).versionName;
                p.n(str2, "soPkg.versionName");
                cVar2.bK(str, str2);
                c cVar3 = c.dcH;
                String str3 = this.dcI;
                AbiType abiType = ((i) this.dcJ.element).ewO;
                p.n(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.dcK.invoke(null);
                return;
            }
            this.dcK.invoke(new com.baidu.swan.apps.al.a().cV(16).cX(2900).uz("install error: pkg=" + ((i) this.dcJ.element)));
        }
    }

    private final File axo() {
        Context appContext = AppRuntime.getAppContext();
        p.n(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), dcF);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.ewO : null) == null) {
            return "";
        }
        String str = iVar.libName;
        p.n(str, "so.libName");
        AbiType abiType = iVar.ewO;
        p.n(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        p.o(str, "libName");
        p.o(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(axo(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean ov(String str) {
        p.o(str, "libName");
        return l(str, ow(str));
    }

    public final boolean l(String str, long j) {
        AbiType ox;
        p.o(str, "libName");
        com.baidu.swan.apps.env.b.a os = com.baidu.swan.apps.env.b.b.os(str);
        if (os != null) {
            if (os.axj()) {
                return true;
            }
            long ow = ow(str);
            if (ow <= 0 || j > ow || (ox = ox(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(ox);
        }
        return false;
    }

    public final void m(String str, long j) {
        p.o(str, "libName");
        g.bhz().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long ow(String str) {
        return com.baidu.swan.apps.storage.c.h.aPI().getLong(oy(str), 0L);
    }

    private final AbiType ox(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aPI().getString(oA(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aPI().putLong(oy(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bK(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aPI().putString(oz(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aPI().putString(oA(str), abiType.id);
    }

    private final String oy(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String oz(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String oA(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
