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
/* loaded from: classes25.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private com.baidu.swan.pms.utils.f cRU;
    private rx.j<i> cSx;
    private rx.j<? super i> cYj;
    private final g cYk;
    private com.baidu.swan.pms.a.c<i> cYl;
    private final d cYn;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cYi = PMSDownloadType.SO_LIB;
    private final Map<String, e> cXL = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cYm = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cYo = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: B */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cXL.isEmpty()) {
                for (e eVar : f.this.cXL.values()) {
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
        this.cYk = gVar;
        this.cYn = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.avW().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a oz = com.baidu.swan.apps.env.b.b.oz(next);
                if (oz == null) {
                    dVar.W(next, false);
                } else if (oz.avQ()) {
                    dVar.W(next, true);
                } else {
                    String avP = oz.avP();
                    e a2 = c.cXM.a(this, avP);
                    com.baidu.swan.apps.ap.e.b<e> bVar = new com.baidu.swan.apps.ap.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: a */
                        public void M(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cYn.W(eVar.avP(), eVar.awd());
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
                                f.this.cYn.a(eVar.avP(), eVar.avX());
                            }
                        }
                    });
                    this.cXL.put(avP, a2);
                    this.cYm.putAll(com.baidu.swan.pms.e.a.ze(avP));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cXL.size());
        }
        if (this.cXL.isEmpty()) {
            r(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g awg() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> awh() {
        return this.cYo;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g awi() {
        return this.cYk;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c oI(String str) {
        return TextUtils.equals("so", str) ? this : super.oI(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void asM() {
        super.asM();
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
    public void apQ() {
        super.apQ();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        r(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.beW()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cRU = fVar;
            if (!this.cRU.isEmpty()) {
                asZ();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> awj() {
        if (this.cYl == null) {
            this.cYl = new b();
        }
        return this.cYl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cXL.size() + " e=" + exc);
        }
        for (e eVar : this.cXL.values()) {
            if (eVar != null && eVar.a(this) && !eVar.awc() && !eVar.awe()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.awb();
            }
        }
        s(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cXL.size() + " e=" + exc);
        }
        for (e eVar : this.cXL.values()) {
            if (!eVar.awc()) {
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
        if (this.cYn != null) {
            this.cYn.q(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e oJ(String str) {
        e eVar = this.cXL.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.asJ().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cRU.g(iVar);
                if (f.this.cYj != null) {
                    f.this.cYj.onNext(iVar);
                    f.this.cYj.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.am.a aVar) {
                f.this.cRU.f(iVar);
                if (f.this.cYj != null) {
                    f.this.cYj.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void asZ() {
        ArrayList arrayList = new ArrayList();
        if (this.cRU.beZ()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cYj = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(atf());
        }
    }

    private rx.j<i> atf() {
        if (this.cSx == null) {
            this.cSx = new a();
        }
        return this.cSx;
    }

    /* loaded from: classes25.dex */
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
            String a2 = c.cXM.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.emZ + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.emZ);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.emZ);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cYm.get(iVar.emZ);
            e oJ = f.this.oJ(aVar == null ? null : aVar.cXB);
            if (oJ != null) {
                oJ.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.emZ + " err=" + aVar);
            }
            f.this.cRU.f(iVar);
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(13L).cV(aVar.errorNo).uA("so包下载失败").uC(aVar.toString());
            if (f.this.cYj != null) {
                f.this.cYj.onError(new PkgDownloadError(iVar, uC));
            }
            com.baidu.swan.apps.core.pms.c.asJ().a(iVar, f.cYi, uC);
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
            String str2 = iVar.cXB;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cYm.get(iVar.emZ);
                str = aVar == null ? str2 : aVar.cXB;
            } else {
                str = str2;
            }
            e oJ = f.this.oJ(str);
            if (oJ != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.emZ + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.bdF().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + oJ + " libName=" + str);
                    }
                }
                oJ.awb();
            }
            f.this.cRU.g(iVar);
            if (f.this.cYj != null) {
                f.this.cYj.onNext(iVar);
                f.this.cYj.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.asJ().a(iVar, f.cYi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
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
        com.baidu.swan.pms.e.a aVar = this.cYm.get(iVar.emZ);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.emZ);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.cXB)) {
            iVar.cXB = aVar.cXB;
        }
        e oJ = oJ(iVar.cXB);
        if (oJ == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.cXB);
                return;
            }
            return;
        }
        if (iVar.eng == null) {
            iVar.eng = aVar.eng;
        }
        if (!AbiType.currentAbi().compat(iVar.eng)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i avY = oJ.avY();
        i avZ = oJ.avZ();
        long max = Math.max(avZ == null ? 0L : avZ.versionCode, avY == null ? 0L : avY.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            oJ.a(this, iVar);
        } else {
            if (avZ == null || !avZ.eng.compat(iVar.eng)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.eng);
                }
                oJ.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void awk() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cXL.values()) {
            if (eVar.a(this)) {
                c(eVar.avY());
                i avZ = eVar.avZ();
                if (eVar.awa() && avZ != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + avZ);
                    }
                    com.baidu.swan.pms.node.d.b.a(avZ, fVar);
                    if (aVar.eoN == null) {
                        aVar.eoN = new ArrayList();
                    }
                    aVar.eoN.add(avZ);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.awb();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.beW());
        }
        if (fVar.beW() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            apQ();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
