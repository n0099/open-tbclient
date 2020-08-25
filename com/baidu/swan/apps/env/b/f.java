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
/* loaded from: classes8.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private com.baidu.swan.pms.utils.f cjZ;
    private rx.j<i> ckC;
    private rx.j<? super i> cqt;
    private final g cqu;
    private com.baidu.swan.pms.a.c<i> cqv;
    private final d cqx;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cqs = PMSDownloadType.SO_LIB;
    private final Map<String, e> cpV = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cqw = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cqy = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void S(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cpV.isEmpty()) {
                for (e eVar : f.this.cpV.values()) {
                    if (eVar != null && eVar.a(f.this)) {
                        eVar.S(jSONArray);
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
        this.cqu = gVar;
        this.cqx = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.alF().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a mj = com.baidu.swan.apps.env.b.b.mj(next);
                if (mj == null) {
                    dVar.P(next, false);
                } else if (mj.alz()) {
                    dVar.P(next, true);
                } else {
                    String aly = mj.aly();
                    e a2 = c.cpW.a(this, aly);
                    com.baidu.swan.apps.ap.e.b<e> bVar = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void I(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cqx.P(eVar.aly(), eVar.alM());
                            }
                            f.this.s(null);
                        }
                    };
                    a2.j(bVar).k(new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void I(e eVar) {
                            if (eVar != null) {
                                f.this.cqx.a(eVar.aly(), eVar.alG());
                            }
                        }
                    });
                    this.cpV.put(aly, a2);
                    this.cqw.putAll(com.baidu.swan.pms.e.a.wP(aly));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cpV.size());
        }
        if (this.cpV.isEmpty()) {
            r(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g alP() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> alQ() {
        return this.cqy;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g alR() {
        return this.cqu;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c ms(String str) {
        return TextUtils.equals("so", str) ? this : super.ms(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aiw() {
        super.aiw();
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
    public void afB() {
        super.afB();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        r(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.aUK()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cjZ = fVar;
            if (!this.cjZ.isEmpty()) {
                aiJ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> alS() {
        if (this.cqv == null) {
            this.cqv = new b();
        }
        return this.cqv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cpV.size() + " e=" + exc);
        }
        for (e eVar : this.cpV.values()) {
            if (eVar != null && eVar.a(this) && !eVar.alL() && !eVar.alN()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.alK();
            }
        }
        s(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cpV.size() + " e=" + exc);
        }
        for (e eVar : this.cpV.values()) {
            if (!eVar.alL()) {
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
        if (this.cqx != null) {
            this.cqx.q(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e mt(String str) {
        e eVar = this.cpV.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.ait().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cjZ.g(iVar);
                if (f.this.cqt != null) {
                    f.this.cqt.onNext(iVar);
                    f.this.cqt.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cjZ.f(iVar);
                if (f.this.cqt != null) {
                    f.this.cqt.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void aiJ() {
        ArrayList arrayList = new ArrayList();
        if (this.cjZ.aUN()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cqt = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aiP());
        }
    }

    private rx.j<i> aiP() {
        if (this.ckC == null) {
            this.ckC = new a();
        }
        return this.ckC;
    }

    /* loaded from: classes8.dex */
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
        public String Q(i iVar) {
            String a = c.cpW.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.dFj + " path=" + a);
            }
            return a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void O(i iVar) {
            super.O(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.dFj);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void P(i iVar) {
            super.P(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.dFj);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void N(i iVar) {
            super.N(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cqw.get(iVar.dFj);
            e mt = f.this.mt(aVar == null ? null : aVar.cpL);
            if (mt != null) {
                mt.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.dFj + " err=" + aVar);
            }
            f.this.cjZ.f(iVar);
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(13L).bP(aVar.errorNo).sk("so包下载失败").sm(aVar.toString());
            if (f.this.cqt != null) {
                f.this.cqt.onError(new PkgDownloadError(iVar, sm));
            }
            com.baidu.swan.apps.core.pms.c.ait().a(iVar, f.cqs, sm);
            com.baidu.swan.c.d.deleteFile(iVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: i */
        public void M(i iVar) {
            String str;
            super.M(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.cpL;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cqw.get(iVar.dFj);
                str = aVar == null ? str2 : aVar.cpL;
            } else {
                str = str2;
            }
            e mt = f.this.mt(str);
            if (mt != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.dFj + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.aTt().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + mt + " libName=" + str);
                    }
                }
                mt.alK();
            }
            f.this.cjZ.g(iVar);
            if (f.this.cqt != null) {
                f.this.cqt.onNext(iVar);
                f.this.cqt.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.ait().a(iVar, f.cqs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
        com.baidu.swan.pms.e.a aVar = this.cqw.get(iVar.dFj);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.dFj);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.cpL)) {
            iVar.cpL = aVar.cpL;
        }
        e mt = mt(iVar.cpL);
        if (mt == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.cpL);
                return;
            }
            return;
        }
        if (iVar.dFp == null) {
            iVar.dFp = aVar.dFp;
        }
        if (!AbiType.currentAbi().compat(iVar.dFp)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i alH = mt.alH();
        i alI = mt.alI();
        long max = Math.max(alI == null ? 0L : alI.versionCode, alH == null ? 0L : alH.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            mt.a(this, iVar);
        } else {
            if (alI == null || !alI.dFp.compat(iVar.dFp)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.dFp);
                }
                mt.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void alT() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cpV.values()) {
            if (eVar.a(this)) {
                c(eVar.alH());
                i alI = eVar.alI();
                if (eVar.alJ() && alI != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + alI);
                    }
                    com.baidu.swan.pms.node.d.b.a(alI, fVar);
                    if (aVar.dGV == null) {
                        aVar.dGV = new ArrayList();
                    }
                    aVar.dGV.add(alI);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.alK();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.aUK());
        }
        if (fVar.aUK() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            afB();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
