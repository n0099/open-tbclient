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
    public static final c cEo = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cEm = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cEn = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.n(fVar, "updater");
        q.n(str, "libName");
        e nq = nq(str);
        if (nq == null) {
            e eVar = new e(fVar, str);
            cEn.put(str, eVar);
            return eVar;
        }
        return nq;
    }

    public final e nq(String str) {
        q.n(str, "libName");
        return cEn.get(str);
    }

    public final void nr(String str) {
        q.n(str, "libName");
        cEn.remove(str);
    }

    public final void a(d dVar) {
        q.n(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cEs);
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
        public static final b cEs = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void M(Exception exc) {
            c cVar = c.cEo;
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
        com.baidu.swan.apps.env.b.a np = com.baidu.swan.apps.env.b.b.np(str);
        if (np == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().bX(16).bZ(2900).tt("not available: so=" + np));
        } else if (np.aoU()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + np);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.aWO().xE(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).amJ() || !AbiType.currentAbi().compat(((i) objectRef.element).dTy)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().bX(16).bZ(2900).tt("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType nu = nu(str);
            if (j(str, ((i) objectRef.element).versionCode) && nu != null && nu.compat(((i) objectRef.element).dTy)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            np.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes10.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cEp;
        final /* synthetic */ Ref.ObjectRef cEq;
        final /* synthetic */ kotlin.jvm.a.b cEr;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cEp = str;
            this.cEq = objectRef;
            this.cEr = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void eH(boolean z) {
            c cVar = c.cEo;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cEp);
            }
            if (z) {
                c.cEo.l(this.cEp, ((i) this.cEq.element).versionCode);
                c cVar2 = c.cEo;
                String str = this.cEp;
                String str2 = ((i) this.cEq.element).versionName;
                q.m(str2, "soPkg.versionName");
                cVar2.by(str, str2);
                c cVar3 = c.cEo;
                String str3 = this.cEp;
                AbiType abiType = ((i) this.cEq.element).dTy;
                q.m(abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cEr.invoke(null);
                return;
            }
            this.cEr.invoke(new com.baidu.swan.apps.am.a().bX(16).bZ(2900).tt("install error: pkg=" + ((i) this.cEq.element)));
        }
    }

    private final File aoZ() {
        Context appContext = AppRuntime.getAppContext();
        q.m(appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cEm);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.dTy : null) == null) {
            return "";
        }
        String str = iVar.cEd;
        q.m(str, "so.libName");
        AbiType abiType = iVar.dTy;
        q.m(abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.n(str, "libName");
        q.n(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(aoZ(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean ns(String str) {
        q.n(str, "libName");
        return j(str, nt(str));
    }

    public final boolean j(String str, long j) {
        AbiType nu;
        q.n(str, "libName");
        com.baidu.swan.apps.env.b.a np = com.baidu.swan.apps.env.b.b.np(str);
        if (np != null) {
            if (np.aoU()) {
                return true;
            }
            long nt = nt(str);
            if (nt <= 0 || j > nt || (nu = nu(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(nu);
        }
        return false;
    }

    public final void k(String str, long j) {
        q.n(str, "libName");
        g.aYm().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long nt(String str) {
        return com.baidu.swan.apps.storage.c.h.aGy().getLong(nv(str), 0L);
    }

    private final AbiType nu(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aGy().getString(nx(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aGy().putLong(nv(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void by(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aGy().putString(nw(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aGy().putString(nx(str), abiType.id);
    }

    private final String nv(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String nw(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String nx(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
