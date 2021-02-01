package com.baidu.swan.apps.env.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ao.ae;
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
/* loaded from: classes9.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private rx.j<i> cUV;
    private com.baidu.swan.pms.utils.f cUs;
    private rx.j<? super i> daB;
    private final g daC;
    private com.baidu.swan.pms.a.c<i> daD;
    private final d daF;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType daA = PMSDownloadType.SO_LIB;
    private final Map<String, e> dab = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> daE = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> daG = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.dab.isEmpty()) {
                for (e eVar : f.this.dab.values()) {
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
        this.daC = gVar;
        this.daF = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.atT().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nx = com.baidu.swan.apps.env.b.b.nx(next);
                if (nx == null) {
                    dVar.V(next, false);
                } else if (nx.atN()) {
                    dVar.V(next, true);
                } else {
                    String atM = nx.atM();
                    e a2 = c.dac.a(this, atM);
                    com.baidu.swan.apps.ao.e.b<e> bVar = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void L(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.daF.V(eVar.atM(), eVar.aua());
                            }
                            f.this.t(null);
                        }
                    };
                    a2.j(bVar).k(new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void L(e eVar) {
                            if (eVar != null) {
                                f.this.daF.a(eVar.atM(), eVar.atU());
                            }
                        }
                    });
                    this.dab.put(atM, a2);
                    this.daE.putAll(com.baidu.swan.pms.e.a.yl(atM));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.dab.size());
        }
        if (this.dab.isEmpty()) {
            s(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g aud() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> aue() {
        return this.daG;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g auf() {
        return this.daC;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c nG(String str) {
        return TextUtils.equals("so", str) ? this : super.nG(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqH() {
        super.aqH();
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
        s(new Exception("failed by fetch error = " + aVar));
    }

    @Override // com.baidu.swan.pms.a.g
    public void anG() {
        super.anG();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        s(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bdL()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cUs = fVar;
            if (!this.cUs.isEmpty()) {
                aqU();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> aug() {
        if (this.daD == null) {
            this.daD = new b();
        }
        return this.daD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.dab.size() + " e=" + exc);
        }
        for (e eVar : this.dab.values()) {
            if (eVar != null && eVar.a(this) && !eVar.atZ() && !eVar.aub()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.atY();
            }
        }
        t(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.dab.size() + " e=" + exc);
        }
        for (e eVar : this.dab.values()) {
            if (!eVar.atZ()) {
                if (DEBUG) {
                    Log.i(this.TAG, "finishWithUpdatingCheck: return by wait for=" + eVar);
                    return;
                }
                return;
            }
        }
        o(exc);
    }

    private void o(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyFinalCallback: e=" + Log.getStackTraceString(exc));
        }
        if (this.daF != null) {
            this.daF.r(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e nH(String str) {
        e eVar = this.dab.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.aqE().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cUs.g(iVar);
                if (f.this.daB != null) {
                    f.this.daB.onNext(iVar);
                    f.this.daB.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cUs.f(iVar);
                if (f.this.daB != null) {
                    f.this.daB.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void aqU() {
        ArrayList arrayList = new ArrayList();
        if (this.cUs.bdO()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.daB = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(ara());
        }
    }

    private rx.j<i> ara() {
        if (this.cUV == null) {
            this.cUV = new a();
        }
        return this.cUV;
    }

    /* loaded from: classes9.dex */
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
            String a2 = c.dac.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.euc + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.euc);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.euc);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.daE.get(iVar.euc);
            e nH = f.this.nH(aVar == null ? null : aVar.libName);
            if (nH != null) {
                nH.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.euc + " err=" + aVar);
            }
            f.this.cUs.f(iVar);
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tF("so包下载失败").tH(aVar.toString());
            if (f.this.daB != null) {
                f.this.daB.onError(new PkgDownloadError(iVar, tH));
            }
            com.baidu.swan.apps.core.pms.c.aqE().a(iVar, f.daA, tH);
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
            String str2 = iVar.libName;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.daE.get(iVar.euc);
                str = aVar == null ? str2 : aVar.libName;
            } else {
                str = str2;
            }
            e nH = f.this.nH(str);
            if (nH != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.euc + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.bcv().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + nH + " libName=" + str);
                    }
                }
                nH.atY();
            }
            f.this.cUs.g(iVar);
            if (f.this.daB != null) {
                f.this.daB.onNext(iVar);
                f.this.daB.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.aqE().a(iVar, f.daA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends rx.j<i> {
        private a() {
        }

        @Override // rx.e
        public void onCompleted() {
            if (f.DEBUG) {
                Log.e(f.this.TAG, "PkgDlSubscriber 包下载完成");
            }
            f.this.s(null);
        }

        @Override // rx.e
        public void onError(Throwable th) {
            if (f.DEBUG) {
                Log.e(f.this.TAG, "PkgDlSubscriber 包下载、业务层处理 OnError：" + th.toString());
            }
            f.this.s(new Exception("failed by Download error = ", th));
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
        com.baidu.swan.pms.e.a aVar = this.daE.get(iVar.euc);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.euc);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.libName)) {
            iVar.libName = aVar.libName;
        }
        e nH = nH(iVar.libName);
        if (nH == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.libName);
                return;
            }
            return;
        }
        if (iVar.eui == null) {
            iVar.eui = aVar.eui;
        }
        if (!AbiType.currentAbi().compat(iVar.eui)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i atV = nH.atV();
        i atW = nH.atW();
        long max = Math.max(atW == null ? 0L : atW.versionCode, atV == null ? 0L : atV.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            nH.a(this, iVar);
        } else {
            if (atW == null || !atW.eui.compat(iVar.eui)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.eui);
                }
                nH.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void auh() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.dab.values()) {
            if (eVar.a(this)) {
                c(eVar.atV());
                i atW = eVar.atW();
                if (eVar.atX() && atW != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + atW);
                    }
                    com.baidu.swan.pms.node.d.b.a(atW, fVar);
                    if (aVar.evO == null) {
                        aVar.evO = new ArrayList();
                    }
                    aVar.evO.add(atW);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.atY();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bdL());
        }
        if (fVar.bdL() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            anG();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
