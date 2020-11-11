package com.baidu.swan.apps.env.b;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ae;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.core.pms.c;
import com.baidu.swan.apps.core.pms.j;
import com.baidu.swan.apps.env.b.d;
import com.baidu.swan.pms.c.d.g;
import com.baidu.swan.pms.model.i;
import com.baidu.swan.pms.utils.AbiType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.d;
/* loaded from: classes10.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private com.baidu.swan.pms.utils.f cML;
    private rx.j<i> cNo;
    private rx.j<? super i> cTa;
    private final g cTb;
    private com.baidu.swan.pms.a.c<i> cTc;
    private final d cTe;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cSZ = PMSDownloadType.SO_LIB;
    private final Map<String, e> cSC = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cTd = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cTf = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cSC.isEmpty()) {
                for (e eVar : f.this.cSC.values()) {
                    if (eVar != null && eVar.a(f.this)) {
                        eVar.W(jSONArray);
                    }
                }
            }
        }
    };

    public f(g gVar, d dVar) {
        this.TAG = "SwanSoUpdater";
        StringBuilder append = new StringBuilder().append(this.TAG);
        int i = sCount;
        sCount = i + 1;
        this.TAG = append.append(i).toString();
        if (DEBUG) {
            Log.i(this.TAG, "SwanSoUpdater: config=" + dVar + " trace=" + Log.getStackTraceString(new Exception()));
        }
        this.cTb = gVar;
        this.cTe = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.atw().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nW = com.baidu.swan.apps.env.b.b.nW(next);
                if (nW == null) {
                    dVar.V(next, false);
                } else if (nW.atq()) {
                    dVar.V(next, true);
                } else {
                    String atp = nW.atp();
                    e a2 = c.cSD.a(this, atp);
                    com.baidu.swan.apps.ap.e.b<e> bVar = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cTe.V(eVar.atp(), eVar.atD());
                            }
                            f.this.s(null);
                        }
                    };
                    a2.j(bVar).k(new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(e eVar) {
                            if (eVar != null) {
                                f.this.cTe.a(eVar.atp(), eVar.atx());
                            }
                        }
                    });
                    this.cSC.put(atp, a2);
                    this.cTd.putAll(com.baidu.swan.pms.e.a.yC(atp));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cSC.size());
        }
        if (this.cSC.isEmpty()) {
            r(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g atG() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> atH() {
        return this.cTf;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g atI() {
        return this.cTb;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c og(String str) {
        return TextUtils.equals("so", str) ? this : super.og(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqm() {
        super.aqm();
        if (DEBUG) {
            Log.e(this.TAG, "onFetchSuccess:");
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public void b(com.baidu.swan.pms.model.a aVar) {
        super.b(aVar);
        if (DEBUG) {
            Log.e(this.TAG, "onFetchError: " + aVar.toString());
        }
        r(new Exception("failed by fetch error = " + aVar));
    }

    @Override // com.baidu.swan.pms.a.g
    public void anq() {
        super.anq();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        r(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bcy()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cML = fVar;
            if (!this.cML.isEmpty()) {
                aqz();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> atJ() {
        if (this.cTc == null) {
            this.cTc = new b();
        }
        return this.cTc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cSC.size() + " e=" + exc);
        }
        for (e eVar : this.cSC.values()) {
            if (eVar != null && eVar.a(this) && !eVar.atC() && !eVar.atE()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.atB();
            }
        }
        s(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cSC.size() + " e=" + exc);
        }
        for (e eVar : this.cSC.values()) {
            if (!eVar.atC()) {
                if (DEBUG) {
                    Log.i(this.TAG, "finishWithUpdatingCheck: return by wait for=" + eVar);
                    return;
                }
                return;
            }
        }
        n(exc);
    }

    private void n(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
        }
        if (this.cTe != null) {
            this.cTe.q(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e oh(String str) {
        e eVar = this.cSC.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.aqj().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cML.g(iVar);
                if (f.this.cTa != null) {
                    f.this.cTa.onNext(iVar);
                    f.this.cTa.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cML.f(iVar);
                if (f.this.cTa != null) {
                    f.this.cTa.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void aqz() {
        ArrayList arrayList = new ArrayList();
        if (this.cML.bcB()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cTa = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aqF());
        }
    }

    private rx.j<i> aqF() {
        if (this.cNo == null) {
            this.cNo = new a();
        }
        return this.cNo;
    }

    /* loaded from: classes10.dex */
    private class b extends com.baidu.swan.pms.a.b<i> {
        private b() {
        }

        @Override // com.baidu.swan.pms.a.e
        @NonNull
        public Bundle a(@NonNull Bundle bundle, Set<String> set) {
            return f.this.a(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.c
        /* renamed from: e */
        public String U(i iVar) {
            String a2 = c.cSD.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.ehG + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.ehG);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.ehG);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cTd.get(iVar.ehG);
            e oh = f.this.oh(aVar == null ? null : aVar.cSs);
            if (oh != null) {
                oh.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.ehG + " err=" + aVar);
            }
            f.this.cML.f(iVar);
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(13L).cw(aVar.errorNo).tY("so包下载失败").ua(aVar.toString());
            if (f.this.cTa != null) {
                f.this.cTa.onError(new PkgDownloadError(iVar, ua));
            }
            com.baidu.swan.apps.core.pms.c.aqj().a(iVar, f.cSZ, ua);
            com.baidu.swan.c.d.deleteFile(iVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: i */
        public void Q(i iVar) {
            String str;
            super.Q(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.cSs;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cTd.get(iVar.ehG);
                str = aVar == null ? str2 : aVar.cSs;
            } else {
                str = str2;
            }
            e oh = f.this.oh(str);
            if (oh != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.ehG + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.bbh().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + oh + " libName=" + str);
                    }
                }
                oh.atB();
            }
            f.this.cML.g(iVar);
            if (f.this.cTa != null) {
                f.this.cTa.onNext(iVar);
                f.this.cTa.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.aqj().a(iVar, f.cSZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends rx.j<i> {
        private a() {
        }

        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e(f.this.TAG, "PkgDlSubscriber 包下载完成");
            }
            f.this.r(null);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e(f.this.TAG, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
            }
            f.this.r(new Exception("failed by Download error = ", th));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // rx.e
        /* renamed from: d */
        public void onNext(i iVar) {
            if (f.DEBUG) {
                Log.e(f.this.TAG, "PkgDlSubscriber 单个包下载、业务层处理完成：" + iVar.toString());
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void parseData(JSONObject jSONObject) {
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler parseData start data=" + jSONObject);
        }
        if (jSONObject != null) {
            c((i) com.baidu.swan.pms.utils.e.a(jSONObject, new i()));
        }
    }

    private void c(i iVar) {
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler updateBestSo start so=" + iVar);
        }
        if (iVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by null so");
                return;
            }
            return;
        }
        com.baidu.swan.pms.e.a aVar = this.cTd.get(iVar.ehG);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.ehG);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.cSs)) {
            iVar.cSs = aVar.cSs;
        }
        e oh = oh(iVar.cSs);
        if (oh == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.cSs);
                return;
            }
            return;
        }
        if (iVar.ehM == null) {
            iVar.ehM = aVar.ehM;
        }
        if (!AbiType.currentAbi().compat(iVar.ehM)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i aty = oh.aty();
        i atz = oh.atz();
        long max = Math.max(atz == null ? 0L : atz.versionCode, aty == null ? 0L : aty.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            oh.a(this, iVar);
        } else {
            if (atz == null || !atz.ehM.compat(iVar.ehM)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.ehM);
                }
                oh.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void atK() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cSC.values()) {
            if (eVar.a(this)) {
                c(eVar.aty());
                i atz = eVar.atz();
                if (eVar.atA() && atz != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + atz);
                    }
                    com.baidu.swan.pms.node.d.b.a(atz, fVar);
                    if (aVar.ejs == null) {
                        aVar.ejs = new ArrayList();
                    }
                    aVar.ejs.add(atz);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.atB();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bcy());
        }
        if (fVar.bcy() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            anq();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
