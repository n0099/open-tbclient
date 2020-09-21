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
/* loaded from: classes3.dex */
public final class c {
    public static final c csd = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String csb = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> csc = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.m(fVar, "updater");
        q.m(str, "libName");
        e mE = mE(str);
        if (mE == null) {
            e eVar = new e(fVar, str);
            csc.put(str, eVar);
            return eVar;
        }
        return mE;
    }

    public final e mE(String str) {
        q.m(str, "libName");
        return csc.get(str);
    }

    public final void mF(String str) {
        q.m(str, "libName");
        csc.remove(str);
    }

    public final void a(d dVar) {
        q.m(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.csh);
        f fVar = new f(new com.baidu.swan.pms.c.d.h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes3.dex */
    public static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b csh = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void J(Exception exc) {
            c cVar = c.csd;
            if (c.DEBUG) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo end with e: " + exc + " trace=" + Log.getStackTraceString(exc != null ? exc : new Exception()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, com.baidu.swan.pms.model.i] */
    public final void a(String str, kotlin.jvm.a.b<? super com.baidu.swan.apps.am.a, l> bVar) {
        q.m(str, "libName");
        q.m(bVar, BuyTBeanActivityConfig.CALLBACK);
        if (DEBUG) {
            Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + str);
        }
        com.baidu.swan.apps.env.b.a mD = com.baidu.swan.apps.env.b.b.mD(str);
        if (mD == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().bP(16).bR(2900).sH("not available: so=" + mD));
        } else if (mD.amj()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + mD);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.aUf().wS(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).ajY() || !AbiType.currentAbi().compat(((i) objectRef.element).dHx)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().bP(16).bR(2900).sH("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType mI = mI(str);
            if (j(str, ((i) objectRef.element).versionCode) && mI != null && mI.compat(((i) objectRef.element).dHx)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            mD.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @h
    /* loaded from: classes3.dex */
    public static final class a implements b.a {
        final /* synthetic */ String cse;
        final /* synthetic */ Ref.ObjectRef csf;
        final /* synthetic */ kotlin.jvm.a.b csg;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cse = str;
            this.csf = objectRef;
            this.csg = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void el(boolean z) {
            c cVar = c.csd;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cse);
            }
            if (z) {
                c.csd.l(this.cse, ((i) this.csf.element).versionCode);
                c cVar2 = c.csd;
                String str = this.cse;
                String str2 = ((i) this.csf.element).versionName;
                q.l((Object) str2, "soPkg.versionName");
                cVar2.bt(str, str2);
                c cVar3 = c.csd;
                String str3 = this.cse;
                AbiType abiType = ((i) this.csf.element).dHx;
                q.l((Object) abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.csg.invoke(null);
                return;
            }
            this.csg.invoke(new com.baidu.swan.apps.am.a().bP(16).bR(2900).sH("install error: pkg=" + ((i) this.csf.element)));
        }
    }

    private final File amo() {
        Context appContext = AppRuntime.getAppContext();
        q.l((Object) appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), csb);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.dHx : null) == null) {
            return "";
        }
        String str = iVar.crS;
        q.l((Object) str, "so.libName");
        AbiType abiType = iVar.dHx;
        q.l((Object) abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.m(str, "libName");
        q.m(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(amo(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean mG(String str) {
        q.m(str, "libName");
        return j(str, mH(str));
    }

    public final boolean j(String str, long j) {
        AbiType mI;
        q.m(str, "libName");
        com.baidu.swan.apps.env.b.a mD = com.baidu.swan.apps.env.b.b.mD(str);
        if (mD != null) {
            if (mD.amj()) {
                return true;
            }
            long mH = mH(str);
            if (mH <= 0 || j > mH || (mI = mI(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(mI);
        }
        return false;
    }

    public final void k(String str, long j) {
        q.m(str, "libName");
        g.aVD().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long mH(String str) {
        return com.baidu.swan.apps.storage.c.h.aDP().getLong(mJ(str), 0L);
    }

    private final AbiType mI(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aDP().getString(mL(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aDP().putLong(mJ(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bt(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aDP().putString(mK(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aDP().putString(mL(str), abiType.id);
    }

    private final String mJ(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String mK(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String mL(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
