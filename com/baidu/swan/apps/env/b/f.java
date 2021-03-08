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
    private com.baidu.swan.pms.utils.f cVS;
    private rx.j<i> cWv;
    private rx.j<? super i> dcc;
    private final g dcd;
    private com.baidu.swan.pms.a.c<i> dce;
    private final d dcg;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int sCount = 0;
    private static final PMSDownloadType dcb = PMSDownloadType.SO_LIB;
    private final Map<String, e> dbE = new HashMap();
    private final Map<String, com.baidu.swan.pms.e.a> dcf = new HashMap();
    private final com.baidu.swan.pms.node.c<JSONArray> dch = new com.baidu.swan.pms.node.c<JSONArray>() { // from class: com.baidu.swan.apps.env.b.f.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.node.c
        /* renamed from: A */
        public void Y(@NonNull JSONArray jSONArray) {
            if (jSONArray != null && !f.this.dbE.isEmpty()) {
                for (e eVar : f.this.dbE.values()) {
                    if (eVar != null && eVar.a(f.this)) {
                        eVar.Y(jSONArray);
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
        this.dcd = gVar;
        this.dcg = dVar;
        if (dVar != null) {
            Iterator<String> it = dVar.atW().iterator();
            while (it.hasNext()) {
                String next = it.next();
                com.baidu.swan.apps.env.b.a nE = com.baidu.swan.apps.env.b.b.nE(next);
                if (nE == null) {
                    dVar.V(next, false);
                } else if (nE.atQ()) {
                    dVar.V(next, true);
                } else {
                    String atP = nE.atP();
                    e a2 = c.dbF.a(this, atP);
                    com.baidu.swan.apps.ao.e.b<e> bVar = new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void N(e eVar) {
                            if (f.DEBUG) {
                                Log.i(f.this.TAG, "onCallback: SoUpdating=" + eVar);
                            }
                            if (eVar != null) {
                                f.this.dcg.V(eVar.atP(), eVar.aud());
                            }
                            f.this.t(null);
                        }
                    };
                    a2.j(bVar).k(new com.baidu.swan.apps.ao.e.b<e>() { // from class: com.baidu.swan.apps.env.b.f.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: a */
                        public void N(e eVar) {
                            if (eVar != null) {
                                f.this.dcg.a(eVar.atP(), eVar.atX());
                            }
                        }
                    });
                    this.dbE.put(atP, a2);
                    this.dcf.putAll(com.baidu.swan.pms.e.a.ys(atP));
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler() start mUpdatings=" + this.dbE.size());
        }
        if (this.dbE.isEmpty()) {
            s(null);
        }
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.a.g aug() {
        return this;
    }

    @Override // com.baidu.swan.pms.d.a.a
    public com.baidu.swan.pms.node.c<JSONArray> auh() {
        return this.dch;
    }

    @Override // com.baidu.swan.pms.d.a.a
    @Nullable
    public g aui() {
        return this.dcd;
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.node.d.c nN(String str) {
        return TextUtils.equals("so", str) ? this : super.nN(str);
    }

    @Override // com.baidu.swan.pms.a.g
    public void aqK() {
        super.aqK();
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
    public void anJ() {
        super.anJ();
        if (DEBUG) {
            Log.e(this.TAG, "onNoPackage:");
        }
        s(null);
    }

    @Override // com.baidu.swan.pms.a.g
    public void a(com.baidu.swan.pms.utils.f fVar) {
        if (DEBUG) {
            Log.i(this.TAG, "onPrepareDownload: countSet.size=" + (fVar == null ? 0 : fVar.bdN()));
        }
        super.a(fVar);
        if (fVar != null) {
            this.cVS = fVar;
            if (!this.cVS.isEmpty()) {
                aqX();
            }
        }
    }

    @Override // com.baidu.swan.pms.a.g
    public com.baidu.swan.pms.a.c<i> auj() {
        if (this.dce == null) {
            this.dce = new b();
        }
        return this.dce;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "notifyPmsFinish: updatings=" + this.dbE.size() + " e=" + exc);
        }
        for (e eVar : this.dbE.values()) {
            if (eVar != null && eVar.a(this) && !eVar.auc() && !eVar.aue()) {
                if (DEBUG) {
                    Log.i(this.TAG, "notifyPmsFinish: try install updating=" + eVar);
                }
                eVar.aub();
            }
        }
        t(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Exception exc) {
        if (DEBUG) {
            Log.i(this.TAG, "finishWithUpdatingCheck: updatings=" + this.dbE.size() + " e=" + exc);
        }
        for (e eVar : this.dbE.values()) {
            if (!eVar.auc()) {
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
        if (this.dcg != null) {
            this.dcg.r(exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e nO(String str) {
        e eVar = this.dbE.get(str);
        if (eVar == null || !eVar.a(this)) {
            return null;
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final i iVar) {
        com.baidu.swan.apps.core.pms.c.aqH().a(iVar, new c.b() { // from class: com.baidu.swan.apps.env.b.f.4
            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType) {
                f.this.cVS.g(iVar);
                if (f.this.dcc != null) {
                    f.this.dcc.onNext(iVar);
                    f.this.dcc.onCompleted();
                }
            }

            @Override // com.baidu.swan.apps.core.pms.c.b
            public void a(PMSDownloadType pMSDownloadType, com.baidu.swan.apps.al.a aVar) {
                f.this.cVS.f(iVar);
                if (f.this.dcc != null) {
                    f.this.dcc.onError(new PkgDownloadError(iVar, aVar));
                }
            }
        });
    }

    private void aqX() {
        ArrayList arrayList = new ArrayList();
        if (this.cVS.bdQ()) {
            arrayList.add(rx.d.a((d.a) new d.a<i>() { // from class: com.baidu.swan.apps.env.b.f.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(rx.j<? super i> jVar) {
                    f.this.dcc = jVar;
                }
            }));
        }
        if (!arrayList.isEmpty()) {
            rx.d.n(arrayList).b(ard());
        }
    }

    private rx.j<i> ard() {
        if (this.cWv == null) {
            this.cWv = new a();
        }
        return this.cWv;
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
        public String W(i iVar) {
            String a2 = c.dbF.a(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback getDownloadPath: so=" + iVar.evD + " path=" + a2);
            }
            return a2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: f */
        public void U(i iVar) {
            super.U(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadStart: so=" + iVar.evD);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: g */
        public void V(i iVar) {
            super.V(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloading: so=" + iVar.evD);
            }
            f.this.b(iVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: h */
        public void T(i iVar) {
            super.T(iVar);
            com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.dcf.get(iVar.evD);
            e nO = f.this.nO(aVar == null ? null : aVar.dbu);
            if (nO != null) {
                nO.a(new d.b(iVar.currentSize, iVar.size));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        public void a(i iVar, com.baidu.swan.pms.model.a aVar) {
            super.a((b) iVar, aVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadError: so=" + iVar.evD + " err=" + aVar);
            }
            f.this.cVS.f(iVar);
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(13L).dc(aVar.errorNo).tM("so包下载失败").tO(aVar.toString());
            if (f.this.dcc != null) {
                f.this.dcc.onError(new PkgDownloadError(iVar, tO));
            }
            com.baidu.swan.apps.core.pms.c.aqH().a(iVar, f.dcb, tO);
            com.baidu.swan.c.d.deleteFile(iVar.filePath);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.pms.a.b, com.baidu.swan.pms.a.c
        /* renamed from: i */
        public void S(i iVar) {
            String str;
            super.S(iVar);
            if (f.DEBUG) {
                Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: so=" + iVar);
            }
            String str2 = iVar.dbu;
            if (TextUtils.isEmpty(str2)) {
                com.baidu.swan.pms.e.a aVar = (com.baidu.swan.pms.e.a) f.this.dcf.get(iVar.evD);
                str = aVar == null ? str2 : aVar.dbu;
            } else {
                str = str2;
            }
            e nO = f.this.nO(str);
            if (nO != null) {
                boolean e = ae.e(new File(iVar.filePath), iVar.sign);
                if (f.DEBUG) {
                    Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: bundle=" + iVar.evD + " checkSign=" + e);
                }
                if (e) {
                    com.baidu.swan.pms.database.a.bcx().c(iVar);
                    if (f.DEBUG) {
                        Log.i(f.this.TAG, "SoDlCallback onDownloadFinish: updating=" + nO + " libName=" + str);
                    }
                }
                nO.aub();
            }
            f.this.cVS.g(iVar);
            if (f.this.dcc != null) {
                f.this.dcc.onNext(iVar);
                f.this.dcc.onCompleted();
            }
            com.baidu.swan.apps.core.pms.c.aqH().a(iVar, f.dcb);
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
        com.baidu.swan.pms.e.a aVar = this.dcf.get(iVar.evD);
        if (aVar == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by illegal bundleId=" + iVar.evD);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(iVar.dbu)) {
            iVar.dbu = aVar.dbu;
        }
        e nO = nO(iVar.dbu);
        if (nO == null) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by no updating lib=" + iVar.dbu);
                return;
            }
            return;
        }
        if (iVar.evJ == null) {
            iVar.evJ = aVar.evJ;
        }
        if (!AbiType.currentAbi().compat(iVar.evJ)) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by currentAbi");
                return;
            }
            return;
        }
        i atY = nO.atY();
        i atZ = nO.atZ();
        long max = Math.max(atZ == null ? 0L : atZ.versionCode, atY == null ? 0L : atY.versionCode);
        if (iVar.versionCode < max) {
            if (DEBUG) {
                Log.i(this.TAG, String.format("SoNodeHandler updateBestSo end by not bestVer(%d) libVer(%d)", Long.valueOf(max), Long.valueOf(iVar.versionCode)));
            }
        } else if (iVar.versionCode > max) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by update bestVer=" + iVar.versionCode);
            }
            nO.a(this, iVar);
        } else {
            if (atZ == null || !atZ.evJ.compat(iVar.evJ)) {
                if (DEBUG) {
                    Log.i(this.TAG, "SoNodeHandler updateBestSo end by update abi update=" + iVar.evJ);
                }
                nO.a(this, iVar);
            }
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler updateBestSo end by should not exec here");
            }
        }
    }

    @Override // com.baidu.swan.pms.node.d.c
    public void auk() {
        com.baidu.swan.pms.node.d.a aVar = new com.baidu.swan.pms.node.d.a();
        com.baidu.swan.pms.utils.f fVar = new com.baidu.swan.pms.utils.f();
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop start");
        }
        for (e eVar : this.dbE.values()) {
            if (eVar.a(this)) {
                c(eVar.atY());
                i atZ = eVar.atZ();
                if (eVar.aua() && atZ != null) {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler handle for bestSo=" + atZ);
                    }
                    com.baidu.swan.pms.node.d.b.a(atZ, fVar);
                    if (aVar.exp == null) {
                        aVar.exp = new ArrayList();
                    }
                    aVar.exp.add(atZ);
                } else {
                    if (DEBUG) {
                        Log.i(this.TAG, "SoNodeHandler localSo not update, just check for install");
                    }
                    eVar.aub();
                }
            }
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle for loop end");
            Log.i(this.TAG, "SoNodeHandler handle soSet.pkgSize()=" + fVar.bdN());
        }
        if (fVar.bdN() == 0) {
            if (DEBUG) {
                Log.i(this.TAG, "SoNodeHandler handle end by no pkg");
            }
            anJ();
            return;
        }
        if (DEBUG) {
            Log.i(this.TAG, "SoNodeHandler handle end by start dl");
        }
        a(fVar);
        com.baidu.swan.pms.c.a.a.a(aVar, this);
    }
}
