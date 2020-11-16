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
/* loaded from: classes7.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private rx.j<i> cLE;
    private com.baidu.swan.pms.utils.f cLb;
    private rx.j<? super i> cRq;
    private final g cRr;
    private com.baidu.swan.pms.a.c<i> cRs;
    private final d cRu;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cRp = PMSDownloadType.SO_LIB;
    private final Map<String, e> cQS = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cRt = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cRv = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cQS.isEmpty()) {
                for (e eVar : f.this.cQS.values()) {
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
        this.cRr = gVar;
        this.cRu = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.asO().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nQ = com.baidu.swan.apps.env.b.b.nQ(next);
                if (nQ == null) {
                    dVar.V(next, false);
                } else if (nQ.asI()) {
                    dVar.V(next, true);
                } else {
                    String asH = nQ.asH();
                    e a2 = c.cQT.a(this, asH);
                    com.baidu.swan.apps.ap.e.b<e> bVar = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cRu.V(eVar.asH(), eVar.asV());
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
                                f.this.cRu.a(eVar.asH(), eVar.asP());
                            }
                        }
                    });
                    this.cQS.put(asH, a2);
                    this.cRt.putAll(com.baidu.swan.pms.e.a.yx(asH));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cQS.size());
        }
        if (this.cQS.isEmpty()) {
            r(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g asY() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> asZ() {
        return this.cRv;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g ata() {
        return this.cRr;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c nZ(String str) {
        return TextUtils.equals("so", str) ? this : super.nZ(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void apE() {
        super.apE();
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
    public void amI() {
        super.amI();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        r(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bbR()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cLb = fVar;
            if (!this.cLb.isEmpty()) {
                apR();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> atb() {
        if (this.cRs == null) {
            this.cRs = new b();
        }
        return this.cRs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cQS.size() + " e=" + exc);
        }
        for (e eVar : this.cQS.values()) {
            if (eVar != null && eVar.a(this) && !eVar.asU() && !eVar.asW()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.asT();
            }
        }
        s(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cQS.size() + " e=" + exc);
        }
        for (e eVar : this.cQS.values()) {
            if (!eVar.asU()) {
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
        if (this.cRu != null) {
            this.cRu.q(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e oa(String str) {
        e eVar = this.cQS.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.apB().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cLb.g(iVar);
                if (f.this.cRq != null) {
                    f.this.cRq.onNext(iVar);
                    f.this.cRq.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cLb.f(iVar);
                if (f.this.cRq != null) {
                    f.this.cRq.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void apR() {
        ArrayList arrayList = new ArrayList();
        if (this.cLb.bbU()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cRq = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(apX());
        }
    }

    private rx.j<i> apX() {
        if (this.cLE == null) {
            this.cLE = new a();
        }
        return this.cLE;
    }

    /* loaded from: classes7.dex */
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
            String a2 = c.cQT.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.efY + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.efY);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.efY);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cRt.get(iVar.efY);
            e oa = f.this.oa(aVar == null ? null : aVar.cQI);
            if (oa != null) {
                oa.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.efY + " err=" + aVar);
            }
            f.this.cLb.f(iVar);
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(13L).cw(aVar.errorNo).tT("so包下载失败").tV(aVar.toString());
            if (f.this.cRq != null) {
                f.this.cRq.onError(new PkgDownloadError(iVar, tV));
            }
            com.baidu.swan.apps.core.pms.c.apB().a(iVar, f.cRp, tV);
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
            String str2 = iVar.cQI;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cRt.get(iVar.efY);
                str = aVar == null ? str2 : aVar.cQI;
            } else {
                str = str2;
            }
            e oa = f.this.oa(str);
            if (oa != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.efY + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.baA().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + oa + " libName=" + str);
                    }
                }
                oa.asT();
            }
            f.this.cLb.g(iVar);
            if (f.this.cRq != null) {
                f.this.cRq.onNext(iVar);
                f.this.cRq.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.apB().a(iVar, f.cRp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
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
        com.baidu.swan.pms.e.a aVar = this.cRt.get(iVar.efY);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.efY);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.cQI)) {
            iVar.cQI = aVar.cQI;
        }
        e oa = oa(iVar.cQI);
        if (oa == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.cQI);
                return;
            }
            return;
        }
        if (iVar.ege == null) {
            iVar.ege = aVar.ege;
        }
        if (!AbiType.currentAbi().compat(iVar.ege)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i asQ = oa.asQ();
        i asR = oa.asR();
        long max = Math.max(asR == null ? 0L : asR.versionCode, asQ == null ? 0L : asQ.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            oa.a(this, iVar);
        } else {
            if (asR == null || !asR.ege.compat(iVar.ege)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.ege);
                }
                oa.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void atc() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cQS.values()) {
            if (eVar.a(this)) {
                c(eVar.asQ());
                i asR = eVar.asR();
                if (eVar.asS() && asR != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + asR);
                    }
                    com.baidu.swan.pms.node.d.b.a(asR, fVar);
                    if (aVar.ehL == null) {
                        aVar.ehL = new ArrayList();
                    }
                    aVar.ehL.add(asR);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.asT();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bbR());
        }
        if (fVar.bbR() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            amI();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
