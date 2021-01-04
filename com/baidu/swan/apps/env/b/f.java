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
    private com.baidu.swan.pms.utils.f cWR;
    private rx.j<i> cXu;
    private rx.j<? super i> dde;
    private final g ddf;
    private com.baidu.swan.pms.a.c<i> ddg;
    private final d ddi;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType ddd = PMSDownloadType.SO_LIB;
    private final Map<String, e> dcG = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> ddh = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> ddj = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: B */
        public void W(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.dcG.isEmpty()) {
                for (e eVar : f.this.dcG.values()) {
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
        this.ddf = gVar;
        this.ddi = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.axo().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a os = com.baidu.swan.apps.env.b.b.os(next);
                if (os == null) {
                    dVar.W(next, false);
                } else if (os.axi()) {
                    dVar.W(next, true);
                } else {
                    String axh = os.axh();
                    e a2 = c.dcH.a(this, axh);
                    com.baidu.swan.apps.ao.e.b<e> bVar = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void L(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.ddi.W(eVar.axh(), eVar.axv());
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
                                f.this.ddi.a(eVar.axh(), eVar.axp());
                            }
                        }
                    });
                    this.dcG.put(axh, a2);
                    this.ddh.putAll(com.baidu.swan.pms.e.a.zd(axh));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.dcG.size());
        }
        if (this.dcG.isEmpty()) {
            s(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g axy() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> axz() {
        return this.ddj;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g axA() {
        return this.ddf;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c oB(String str) {
        return TextUtils.equals("so", str) ? this : super.oB(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aud() {
        super.aud();
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
    public void arc() {
        super.arc();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        s(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bhr()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cWR = fVar;
            if (!this.cWR.isEmpty()) {
                auq();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> axB() {
        if (this.ddg == null) {
            this.ddg = new b();
        }
        return this.ddg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.dcG.size() + " e=" + exc);
        }
        for (e eVar : this.dcG.values()) {
            if (eVar != null && eVar.a(this) && !eVar.axu() && !eVar.axw()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.axt();
            }
        }
        t(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.dcG.size() + " e=" + exc);
        }
        for (e eVar : this.dcG.values()) {
            if (!eVar.axu()) {
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
        if (this.ddi != null) {
            this.ddi.r(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e oC(String str) {
        e eVar = this.dcG.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.aua().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cWR.g(iVar);
                if (f.this.dde != null) {
                    f.this.dde.onNext(iVar);
                    f.this.dde.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cWR.f(iVar);
                if (f.this.dde != null) {
                    f.this.dde.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void auq() {
        ArrayList arrayList = new ArrayList();
        if (this.cWR.bhu()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.dde = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(auw());
        }
    }

    private rx.j<i> auw() {
        if (this.cXu == null) {
            this.cXu = new a();
        }
        return this.cXu;
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
            String a2 = c.dcH.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.ewI + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void S(i iVar) {
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.ewI);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void T(i iVar) {
            super.T(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.ewI);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void R(i iVar) {
            super.R(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.ddh.get(iVar.ewI);
            e oC = f.this.oC(aVar == null ? null : aVar.libName);
            if (oC != null) {
                oC.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.ewI + " err=" + aVar);
            }
            f.this.cWR.f(iVar);
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(13L).cW(aVar.errorNo).ux("so包下载失败").uz(aVar.toString());
            if (f.this.dde != null) {
                f.this.dde.onError(new PkgDownloadError(iVar, uz));
            }
            com.baidu.swan.apps.core.pms.c.aua().a(iVar, f.ddd, uz);
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
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.ddh.get(iVar.ewI);
                str = aVar == null ? str2 : aVar.libName;
            } else {
                str = str2;
            }
            e oC = f.this.oC(str);
            if (oC != null) {
                boolean f = ae.f(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.ewI + " checkSign=" + f);
                }
                if (f) {
                    com.baidu.swan.pms.database.a.bgb().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + oC + " libName=" + str);
                    }
                }
                oC.axt();
            }
            f.this.cWR.g(iVar);
            if (f.this.dde != null) {
                f.this.dde.onNext(iVar);
                f.this.dde.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.aua().a(iVar, f.ddd);
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
        com.baidu.swan.pms.e.a aVar = this.ddh.get(iVar.ewI);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.ewI);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.libName)) {
            iVar.libName = aVar.libName;
        }
        e oC = oC(iVar.libName);
        if (oC == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.libName);
                return;
            }
            return;
        }
        if (iVar.ewO == null) {
            iVar.ewO = aVar.ewO;
        }
        if (!AbiType.currentAbi().compat(iVar.ewO)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i axq = oC.axq();
        i axr = oC.axr();
        long max = Math.max(axr == null ? 0L : axr.versionCode, axq == null ? 0L : axq.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            oC.a(this, iVar);
        } else {
            if (axr == null || !axr.ewO.compat(iVar.ewO)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.ewO);
                }
                oC.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void axC() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.dcG.values()) {
            if (eVar.a(this)) {
                c(eVar.axq());
                i axr = eVar.axr();
                if (eVar.axs() && axr != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + axr);
                    }
                    com.baidu.swan.pms.node.d.b.a(axr, fVar);
                    if (aVar.eyx == null) {
                        aVar.eyx = new ArrayList();
                    }
                    aVar.eyx.add(axr);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.axt();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bhr());
        }
        if (fVar.bhr() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            arc();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
