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
/* loaded from: classes8.dex */
public final class f extends j implements com.baidu.swan.pms.d.a.a, com.baidu.swan.pms.node.d.c {
    private String TAG;
    private rx.j<i> cSI;
    private com.baidu.swan.pms.utils.f cSf;
    private rx.j<? super i> cYp;
    private final g cYq;
    private com.baidu.swan.pms.a.c<i> cYr;
    private final d cYt;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType cYo = PMSDownloadType.SO_LIB;
    private final Map<String, e> cXR = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> cYs = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> cYu = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: B */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.cXR.isEmpty()) {
                for (e eVar : f.this.cXR.values()) {
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
        this.cYq = gVar;
        this.cYt = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.atv().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nf = com.baidu.swan.apps.env.b.b.nf(next);
                if (nf == null) {
                    dVar.W(next, false);
                } else if (nf.atp()) {
                    dVar.W(next, true);
                } else {
                    String ato = nf.ato();
                    e a2 = c.cXS.a(this, ato);
                    com.baidu.swan.apps.ao.e.b<e> bVar = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void L(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.cYt.W(eVar.ato(), eVar.atC());
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
                                f.this.cYt.a(eVar.ato(), eVar.atw());
                            }
                        }
                    });
                    this.cXR.put(ato, a2);
                    this.cYs.putAll(com.baidu.swan.pms.e.a.xS(ato));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.cXR.size());
        }
        if (this.cXR.isEmpty()) {
            s(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g atF() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> atG() {
        return this.cYu;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g atH() {
        return this.cYq;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c no(String str) {
        return TextUtils.equals("so", str) ? this : super.no(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqj() {
        super.aqj();
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
    public void ani() {
        super.ani();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        s(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bdy()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cSf = fVar;
            if (!this.cSf.isEmpty()) {
                aqw();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> atI() {
        if (this.cYr == null) {
            this.cYr = new b();
        }
        return this.cYr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.cXR.size() + " e=" + exc);
        }
        for (e eVar : this.cXR.values()) {
            if (eVar != null && eVar.a(this) && !eVar.atB() && !eVar.atD()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.atA();
            }
        }
        t(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.cXR.size() + " e=" + exc);
        }
        for (e eVar : this.cXR.values()) {
            if (!eVar.atB()) {
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
        if (this.cYt != null) {
            this.cYt.r(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e np(String str) {
        e eVar = this.cXR.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.aqg().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cSf.g(iVar);
                if (f.this.cYp != null) {
                    f.this.cYp.onNext(iVar);
                    f.this.cYp.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cSf.f(iVar);
                if (f.this.cYp != null) {
                    f.this.cYp.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void aqw() {
        ArrayList arrayList = new ArrayList();
        if (this.cSf.bdB()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.cYp = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(aqC());
        }
    }

    private rx.j<i> aqC() {
        if (this.cSI == null) {
            this.cSI = new a();
        }
        return this.cSI;
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
        public String U(i iVar) {
            String a2 = c.cXS.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.erV + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.erV);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.erV);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cYs.get(iVar.erV);
            e np = f.this.np(aVar == null ? null : aVar.libName);
            if (np != null) {
                np.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.erV + " err=" + aVar);
            }
            f.this.cSf.f(iVar);
            com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).tm("so包下载失败").to(aVar.toString());
            if (f.this.cYp != null) {
                f.this.cYp.onError(new PkgDownloadError(iVar, aVar2));
            }
            com.baidu.swan.apps.core.pms.c.aqg().a(iVar, f.cYo, aVar2);
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
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.cYs.get(iVar.erV);
                str = aVar == null ? str2 : aVar.libName;
            } else {
                str = str2;
            }
            e np = f.this.np(str);
            if (np != null) {
                boolean f = ae.f(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.erV + " checkSign=" + f);
                }
                if (f) {
                    com.baidu.swan.pms.database.a.bci().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + np + " libName=" + str);
                    }
                }
                np.atA();
            }
            f.this.cSf.g(iVar);
            if (f.this.cYp != null) {
                f.this.cYp.onNext(iVar);
                f.this.cYp.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.aqg().a(iVar, f.cYo);
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
        com.baidu.swan.pms.e.a aVar = this.cYs.get(iVar.erV);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.erV);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.libName)) {
            iVar.libName = aVar.libName;
        }
        e np = np(iVar.libName);
        if (np == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.libName);
                return;
            }
            return;
        }
        if (iVar.esb == null) {
            iVar.esb = aVar.esb;
        }
        if (!AbiType.currentAbi().compat(iVar.esb)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i atx = np.atx();
        i aty = np.aty();
        long max = Math.max(aty == null ? 0L : aty.versionCode, atx == null ? 0L : atx.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            np.a(this, iVar);
        } else {
            if (aty == null || !aty.esb.compat(iVar.esb)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.esb);
                }
                np.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void atJ() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.cXR.values()) {
            if (eVar.a(this)) {
                c(eVar.atx());
                i aty = eVar.aty();
                if (eVar.atz() && aty != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + aty);
                    }
                    com.baidu.swan.pms.node.d.b.a(aty, fVar);
                    if (aVar.etI == null) {
                        aVar.etI = new ArrayList();
                    }
                    aVar.etI.add(aty);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.atA();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bdy());
        }
        if (fVar.bdy() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            ani();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
