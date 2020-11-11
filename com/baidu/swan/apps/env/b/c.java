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
    public static final c cSD = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cSB = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cSC = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.n(fVar, "updater");
        q.n(str, "libName");
        e nX = nX(str);
        if (nX == null) {
            e eVar = new e(fVar, str);
            cSC.put(str, eVar);
            return eVar;
        }
        return nX;
    }

    public final e nX(String str) {
        q.n(str, "libName");
        return cSC.get(str);
    }

    public final void nY(String str) {
        q.n(str, "libName");
        cSC.remove(str);
    }

    public final void a(d dVar) {
        q.n(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cSH);
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
        public static final b cSH = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void M(Exception exc) {
            c cVar = c.cSD;
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
        com.baidu.swan.apps.env.b.a nW = com.baidu.swan.apps.env.b.b.nW(str);
        if (nW == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).ua("not available: so=" + nW));
        } else if (nW.atq()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + nW);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.bbh().yl(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).are() || !AbiType.currentAbi().compat(((i) objectRef.element).ehM)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).ua("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType ob = ob(str);
            if (l(str, ((i) objectRef.element).versionCode) && ob != null && ob.compat(((i) objectRef.element).ehM)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            nW.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes10.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cSE;
        final /* synthetic */ Ref.ObjectRef cSF;
        final /* synthetic */ kotlin.jvm.a.b cSG;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cSE = str;
            this.cSF = objectRef;
            this.cSG = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void fd(boolean z) {
            c cVar = c.cSD;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cSE);
            }
            if (z) {
                c.cSD.n(this.cSE, ((i) this.cSF.element).versionCode);
                c cVar2 = c.cSD;
                String str = this.cSE;
                String str2 = ((i) this.cSF.element).versionName;
                q.m(str2, "soPkg.versionName");
                cVar2.bF(str, str2);
                c cVar3 = c.cSD;
                String str3 = this.cSE;
                AbiType abiType = ((i) this.cSF.element).ehM;
                q.m(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cSG.invoke(null);
                return;
            }
            this.cSG.invoke(new com.baidu.swan.apps.am.a().cv(16).cx(2900).ua("install error: pkg=" + ((i) this.cSF.element)));
        }
    }

    private final File atv() {
        Context appContext = AppRuntime.getAppContext();
        q.m(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cSB);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.ehM : null) == null) {
            return "";
        }
        String str = iVar.cSs;
        q.m(str, "so.libName");
        AbiType abiType = iVar.ehM;
        q.m(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.n(str, "libName");
        q.n(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(atv(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean nZ(String str) {
        q.n(str, "libName");
        return l(str, oa(str));
    }

    public final boolean l(String str, long j) {
        AbiType ob;
        q.n(str, "libName");
        com.baidu.swan.apps.env.b.a nW = com.baidu.swan.apps.env.b.b.nW(str);
        if (nW != null) {
            if (nW.atq()) {
                return true;
            }
            long oa = oa(str);
            if (oa <= 0 || j > oa || (ob = ob(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(ob);
        }
        return false;
    }

    public final void m(String str, long j) {
        q.n(str, "libName");
        g.bcF().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long oa(String str) {
        return com.baidu.swan.apps.storage.c.h.aKS().getLong(oc(str), 0L);
    }

    private final AbiType ob(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aKS().getString(oe(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aKS().putLong(oc(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bF(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aKS().putString(od(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aKS().putString(oe(str), abiType.id);
    }

    private final String oc(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String od(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String oe(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
