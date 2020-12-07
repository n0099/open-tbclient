package com.baidu.swan.apps.env.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
/* loaded from: classes25.dex */
public final class c {
    public static final c cXM = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cXK = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cXL = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        p.o(fVar, "updater");
        p.o(str, "libName");
        e oA = oA(str);
        if (oA == null) {
            e eVar = new e(fVar, str);
            cXL.put(str, eVar);
            return eVar;
        }
        return oA;
    }

    public final e oA(String str) {
        p.o(str, "libName");
        return cXL.get(str);
    }

    public final void oB(String str) {
        p.o(str, "libName");
        cXL.remove(str);
    }

    public final void a(d dVar) {
        p.o(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cXQ);
        f fVar = new f(new h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes25.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b cXQ = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void M(Exception exc) {
            c cVar = c.cXM;
            if (c.DEBUG) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo end with e: " + exc + " trace=" + Log.getStackTraceString(exc != null ? exc : new Exception()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.baidu.swan.pms.model.i] */
    public final void a(String str, kotlin.jvm.a.b<? super com.baidu.swan.apps.am.a, kotlin.h> bVar) {
        p.o(str, "libName");
        p.o(bVar, BuyTBeanActivityConfig.CALLBACK);
        if (DEBUG) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        com.baidu.swan.apps.env.b.a oz = com.baidu.swan.apps.env.b.b.oz(str);
        if (oz == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().cU(16).cW(2900).uC("not available: so=" + oz));
        } else if (oz.avQ()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + oz);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bdF().yN(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).atE() || !AbiType.currentAbi().compat(((i) objectRef.element).eng)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().cU(16).cW(2900).uC("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType oE = oE(str);
            if (l(str, ((i) objectRef.element).versionCode) && oE != null && oE.compat(((i) objectRef.element).eng)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            oz.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @kotlin.e
    /* loaded from: classes25.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cXN;
        final /* synthetic */ Ref.ObjectRef cXO;
        final /* synthetic */ kotlin.jvm.a.b cXP;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cXN = str;
            this.cXO = objectRef;
            this.cXP = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fv(boolean z) {
            c cVar = c.cXM;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cXN);
            }
            if (z) {
                c.cXM.n(this.cXN, ((i) this.cXO.element).versionCode);
                c cVar2 = c.cXM;
                String str = this.cXN;
                String str2 = ((i) this.cXO.element).versionName;
                p.n(str2, "soPkg.versionName");
                cVar2.bL(str, str2);
                c cVar3 = c.cXM;
                String str3 = this.cXN;
                AbiType abiType = ((i) this.cXO.element).eng;
                p.n(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cXP.invoke(null);
                return;
            }
            this.cXP.invoke(new com.baidu.swan.apps.am.a().cU(16).cW(2900).uC("install error: pkg=" + ((i) this.cXO.element)));
        }
    }

    private final File avV() {
        Context appContext = AppRuntime.getAppContext();
        p.n(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cXK);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.eng : null) == null) {
            return "";
        }
        String str = iVar.cXB;
        p.n(str, "so.libName");
        AbiType abiType = iVar.eng;
        p.n(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        p.o(str, "libName");
        p.o(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(avV(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean oC(String str) {
        p.o(str, "libName");
        return l(str, oD(str));
    }

    public final boolean l(String str, long j) {
        AbiType oE;
        p.o(str, "libName");
        com.baidu.swan.apps.env.b.a oz = com.baidu.swan.apps.env.b.b.oz(str);
        if (oz != null) {
            if (oz.avQ()) {
                return true;
            }
            long oD = oD(str);
            if (oD <= 0 || j > oD || (oE = oE(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(oE);
        }
        return false;
    }

    public final void m(String str, long j) {
        p.o(str, "libName");
        g.bfd().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long oD(String str) {
        return com.baidu.swan.apps.storage.c.h.aNr().getLong(oF(str), 0L);
    }

    private final AbiType oE(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aNr().getString(oH(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aNr().putLong(oF(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bL(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aNr().putString(oG(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aNr().putString(oH(str), abiType.id);
    }

    private final String oF(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String oG(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String oH(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
