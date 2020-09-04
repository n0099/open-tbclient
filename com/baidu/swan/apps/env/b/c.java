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
    public static final c cqa = new c();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String cpY = "swan" + File.separator + "libs" + File.separator + "so";
    private static final Map<String, e> cpZ = new LinkedHashMap();

    private c() {
    }

    public final e a(f fVar, String str) {
        q.m(fVar, "updater");
        q.m(str, "libName");
        e ml = ml(str);
        if (ml == null) {
            e eVar = new e(fVar, str);
            cpZ.put(str, eVar);
            return eVar;
        }
        return ml;
    }

    public final e ml(String str) {
        q.m(str, "libName");
        return cpZ.get(str);
    }

    public final void mm(String str) {
        q.m(str, "libName");
        cpZ.remove(str);
    }

    public final void a(d dVar) {
        q.m(dVar, "config");
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg start args: " + dVar);
        }
        dVar.h(b.cqe);
        f fVar = new f(new com.baidu.swan.pms.c.d.h(5), dVar);
        if (DEBUG) {
            Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + fVar);
        }
        com.baidu.swan.pms.c.a(fVar);
    }

    @h
    /* loaded from: classes8.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<Exception> {
        public static final b cqe = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public final void I(Exception exc) {
            c cVar = c.cqa;
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
        com.baidu.swan.apps.env.b.a mk = com.baidu.swan.apps.env.b.b.mk(str);
        if (mk == null) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + str);
            }
            bVar.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sn("not available: so=" + mk));
        } else if (mk.alz()) {
            if (DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + mk);
            }
            bVar.invoke(null);
        } else {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = com.baidu.swan.pms.database.a.aTt().wz(str);
            if (((i) objectRef.element) == null || !((i) objectRef.element).ajo() || !AbiType.currentAbi().compat(((i) objectRef.element).dFt)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sn("invalid: pkg=" + ((i) objectRef.element)));
                return;
            }
            AbiType mp = mp(str);
            if (j(str, ((i) objectRef.element).versionCode) && mp != null && mp.compat(((i) objectRef.element).dFt)) {
                if (DEBUG) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + str + " soPkg=" + ((i) objectRef.element));
                }
                bVar.invoke(null);
                return;
            }
            mk.a(((i) objectRef.element).filePath, new a(str, objectRef, bVar));
        }
    }

    @h
    /* loaded from: classes8.dex */
    static final class a implements b.a {
        final /* synthetic */ String cqb;
        final /* synthetic */ Ref.ObjectRef cqc;
        final /* synthetic */ kotlin.jvm.a.b cqd;

        a(String str, Ref.ObjectRef objectRef, kotlin.jvm.a.b bVar) {
            this.cqb = str;
            this.cqc = objectRef;
            this.cqd = bVar;
        }

        @Override // com.baidu.swan.pms.e.b.a
        public final void en(boolean z) {
            c cVar = c.cqa;
            if (c.DEBUG) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.cqb);
            }
            if (z) {
                c.cqa.l(this.cqb, ((i) this.cqc.element).versionCode);
                c cVar2 = c.cqa;
                String str = this.cqb;
                String str2 = ((i) this.cqc.element).versionName;
                q.l((Object) str2, "soPkg.versionName");
                cVar2.bt(str, str2);
                c cVar3 = c.cqa;
                String str3 = this.cqb;
                AbiType abiType = ((i) this.cqc.element).dFt;
                q.l((Object) abiType, "soPkg.abi");
                cVar3.a(str3, abiType);
                this.cqd.invoke(null);
                return;
            }
            this.cqd.invoke(new com.baidu.swan.apps.am.a().bO(16).bQ(2900).sn("install error: pkg=" + ((i) this.cqc.element)));
        }
    }

    private final File alE() {
        Context appContext = AppRuntime.getAppContext();
        q.l((Object) appContext, "AppRuntime.getAppContext()");
        return new File(appContext.getFilesDir(), cpY);
    }

    public final String a(i iVar) {
        if ((iVar != null ? iVar.dFt : null) == null) {
            return "";
        }
        String str = iVar.cpP;
        q.l((Object) str, "so.libName");
        AbiType abiType = iVar.dFt;
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

    public final boolean mn(String str) {
        q.m(str, "libName");
        return j(str, mo(str));
    }

    public final boolean j(String str, long j) {
        AbiType mp;
        q.m(str, "libName");
        com.baidu.swan.apps.env.b.a mk = com.baidu.swan.apps.env.b.b.mk(str);
        if (mk != null) {
            if (mk.alz()) {
                return true;
            }
            long mo = mo(str);
            if (mo <= 0 || j > mo || (mp = mp(str)) == null) {
                return false;
            }
            return AbiType.currentAbi().compat(mp);
        }
        return false;
    }

    public final void k(String str, long j) {
        q.m(str, "libName");
        g.aUR().edit().putLong("swan_so_latest_update_time_" + str, j).apply();
    }

    private final long mo(String str) {
        return com.baidu.swan.apps.storage.c.h.aDf().getLong(mq(str), 0L);
    }

    private final AbiType mp(String str) {
        return AbiType.findById(com.baidu.swan.apps.storage.c.h.aDf().getString(ms(str), ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, long j) {
        com.baidu.swan.apps.storage.c.h.aDf().putLong(mq(str), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bt(String str, String str2) {
        com.baidu.swan.apps.storage.c.h.aDf().putString(mr(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, AbiType abiType) {
        com.baidu.swan.apps.storage.c.h.aDf().putString(ms(str), abiType.id);
    }

    private final String mq(String str) {
        return "swan_so_installed_version_code_" + str;
    }

    private final String mr(String str) {
        return "swan_so_installed_version_name_" + str;
    }

    private final String ms(String str) {
        return "swan_so_installed_abi_" + str;
    }
}
