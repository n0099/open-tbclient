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
/* loaded from: classes8.dex */
public final class c {
    public static final c cpW = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cpU = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cpV = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.m(fVar, "updater");
        q.m(str, "libName");
        e mk = mk(str);
        if (mk == null) {
            e eVar = new e(fVar, str);
            cpV.put(str, eVar);
            return eVar;
        }
        return mk;
    }

    public final e mk(String str) {
        q.m(str, "libName");
        return cpV.get(str);
    }

    public final void ml(String str) {
        q.m(str, "libName");
        cpV.remove(str);
    }

    public final void a(d dVar) {
        q.m(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cqa);
        f fVar = new f(new com.baidu.swan.pms.c.d.h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    @h
    /* loaded from: classes8.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b cqa = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void I(Exception exc) {
            c cVar = c.cpW;
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
        com.baidu.swan.apps.env.b.a mj = com.baidu.swan.apps.env.b.b.mj(str);
        if (mj == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sm("not available: so=" + mj));
        } else if (mj.alz()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + mj);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.aTt().wy(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).ajo() || !AbiType.currentAbi().compat(((i) objectRef.element).dFp)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sm("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType mo = mo(str);
            if (j(str, ((i) objectRef.element).versionCode) && mo != null && mo.compat(((i) objectRef.element).dFp)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            mj.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    @h
    /* loaded from: classes8.dex */
    static final class a implements b.a {
        final /* synthetic */ String cpX;
        final /* synthetic */ Ref.ObjectRef cpY;
        final /* synthetic */ kotlin.jvm.a.b cpZ;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cpX = str;
            this.cpY = objectRef;
            this.cpZ = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void em(boolean z) {
            c cVar = c.cpW;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cpX);
            }
            if (z) {
                c.cpW.l(this.cpX, ((i) this.cpY.element).versionCode);
                c cVar2 = c.cpW;
                String str = this.cpX;
                String str2 = ((i) this.cpY.element).versionName;
                q.l((Object) str2, "soPkg.versionName");
                cVar2.bt(str, str2);
                c cVar3 = c.cpW;
                String str3 = this.cpX;
                AbiType abiType = ((i) this.cpY.element).dFp;
                q.l((Object) abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cpZ.invoke(null);
                return;
            }
            this.cpZ.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sm("install error: pkg=" + ((i) this.cpY.element)));
        }
    }

    private final File alE() {
        Context appContext = AppRuntime.getAppContext();
        q.l((Object) appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cpU);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.dFp : null) == null) {
            return "";
        }
        String str = iVar.cpL;
        q.l((Object) str, "so.libName");
        AbiType abiType = iVar.dFp;
        q.l((Object) abiType, "so.abi");
        return a(str, abiType, iVar.versionCode);
    }

    public final String a(String str, AbiType abiType, long j) {
        q.m(str, "libName");
        q.m(abiType, "abi");
        if (TextUtils.isEmpty(str) || j < 1) {
            return "";
        }
        File file = new File(alE(), "" + str + "" + File.separator + "" + j + "" + File.separator + "" + abiType.id);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public final boolean mm(String str) {
        q.m(str, "libName");
        return j(str, mn(str));
    }

    public final boolean j(String str, long j) {
        AbiType mo;
        q.m(str, "libName");
        com.baidu.swan.apps.env.b.a mj = com.baidu.swan.apps.env.b.b.mj(str);
        if (mj != null) {
            if (mj.alz()) {
                return true;
            }
            long mn = mn(str);
            if (mn <= 0 || j > mn || (mo = mo(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(mo);
        }
        return false;
    }

    public final void k(String str, long j) {
        q.m(str, "libName");
        g.aUR().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long mn(String str) {
        return com.baidu.swan.apps.storage.c.h.aDf().getLong(mp(str), 0L);
    }

    private final AbiType mo(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aDf().getString(mr(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aDf().putLong(mp(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bt(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aDf().putString(mq(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aDf().putString(mr(str), abiType.id);
    }

    private final String mp(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String mq(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String mr(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
