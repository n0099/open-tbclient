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
    private com.baidu.swan.pms.utils.f cGS;
    private rx.j<i> cHv;
    private rx.j<? super i> cNh;
    private final g cNi;
    private com.baidu.swan.pms.a.c<i> cNj;
    private final d cNl;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cNg = PMSDownloadType.SO_LIB;
    private final Map<String, e> cMJ = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cNk = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cNm = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cMJ.isEmpty()) {
                for (e eVar : f.this.cMJ.values()) {
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
        this.cNi = gVar;
        this.cNl = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.aqV().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nI = com.baidu.swan.apps.env.b.b.nI(next);
                if (nI == null) {
                    dVar.V(next, false);
                } else if (nI.aqP()) {
                    dVar.V(next, true);
                } else {
                    String aqO = nI.aqO();
                    e a2 = c.cMK.a(this, aqO);
                    com.baidu.swan.apps.ap.e.b<e> bVar = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cNl.V(eVar.aqO(), eVar.arc());
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
                                f.this.cNl.a(eVar.aqO(), eVar.aqW());
                            }
                        }
                    });
                    this.cMJ.put(aqO, a2);
                    this.cNk.putAll(com.baidu.swan.pms.e.a.yo(aqO));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cMJ.size());
        }
        if (this.cMJ.isEmpty()) {
            r(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g arf() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> arg() {
        return this.cNm;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g arh() {
        return this.cNi;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c nR(String str) {
        return TextUtils.equals("so", str) ? this : super.nR(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void anL() {
        super.anL();
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
    public void akQ() {
        super.akQ();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        r(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.aZY()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cGS = fVar;
            if (!this.cGS.isEmpty()) {
                anY();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> ari() {
        if (this.cNj == null) {
            this.cNj = new b();
        }
        return this.cNj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cMJ.size() + " e=" + exc);
        }
        for (e eVar : this.cMJ.values()) {
            if (eVar != null && eVar.a(this) && !eVar.arb() && !eVar.ard()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.ara();
            }
        }
        s(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cMJ.size() + " e=" + exc);
        }
        for (e eVar : this.cMJ.values()) {
            if (!eVar.arb()) {
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
        if (this.cNl != null) {
            this.cNl.q(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e nS(String str) {
        e eVar = this.cMJ.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.anI().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cGS.g(iVar);
                if (f.this.cNh != null) {
                    f.this.cNh.onNext(iVar);
                    f.this.cNh.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cGS.f(iVar);
                if (f.this.cNh != null) {
                    f.this.cNh.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void anY() {
        ArrayList arrayList = new ArrayList();
        if (this.cGS.bab()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cNh = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aoe());
        }
    }

    private rx.j<i> aoe() {
        if (this.cHv == null) {
            this.cHv = new a();
        }
        return this.cHv;
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
            String a2 = c.cMK.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.ebO + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.ebO);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.ebO);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cNk.get(iVar.ebO);
            e nS = f.this.nS(aVar == null ? null : aVar.cMz);
            if (nS != null) {
                nS.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.ebO + " err=" + aVar);
            }
            f.this.cGS.f(iVar);
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(13L).ca(aVar.errorNo).tK("so包下载失败").tM(aVar.toString());
            if (f.this.cNh != null) {
                f.this.cNh.onError(new PkgDownloadError(iVar, tM));
            }
            com.baidu.swan.apps.core.pms.c.anI().a(iVar, f.cNg, tM);
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
            String str2 = iVar.cMz;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cNk.get(iVar.ebO);
                str = aVar == null ? str2 : aVar.cMz;
            } else {
                str = str2;
            }
            e nS = f.this.nS(str);
            if (nS != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.ebO + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.aYH().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + nS + " libName=" + str);
                    }
                }
                nS.ara();
            }
            f.this.cGS.g(iVar);
            if (f.this.cNh != null) {
                f.this.cNh.onNext(iVar);
                f.this.cNh.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.anI().a(iVar, f.cNg);
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
        com.baidu.swan.pms.e.a aVar = this.cNk.get(iVar.ebO);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.ebO);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.cMz)) {
            iVar.cMz = aVar.cMz;
        }
        e nS = nS(iVar.cMz);
        if (nS == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.cMz);
                return;
            }
            return;
        }
        if (iVar.ebU == null) {
            iVar.ebU = aVar.ebU;
        }
        if (!AbiType.currentAbi().compat(iVar.ebU)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i aqX = nS.aqX();
        i aqY = nS.aqY();
        long max = Math.max(aqY == null ? 0L : aqY.versionCode, aqX == null ? 0L : aqX.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            nS.a(this, iVar);
        } else {
            if (aqY == null || !aqY.ebU.compat(iVar.ebU)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.ebU);
                }
                nS.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void arj() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cMJ.values()) {
            if (eVar.a(this)) {
                c(eVar.aqX());
                i aqY = eVar.aqY();
                if (eVar.aqZ() && aqY != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + aqY);
                    }
                    com.baidu.swan.pms.node.d.b.a(aqY, fVar);
                    if (aVar.edA == null) {
                        aVar.edA = new ArrayList();
                    }
                    aVar.edA.add(aqY);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.ara();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.aZY());
        }
        if (fVar.aZY() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            akQ();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
