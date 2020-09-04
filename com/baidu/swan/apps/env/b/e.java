package com.baidu.swan.apps.env.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.apps.env.b.d;
import com.baidu.swan.pms.model.i;
import com.baidu.swan.pms.utils.AbiType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f cqm;
    private i cqn = null;
    private i cqo = null;
    private com.baidu.swan.apps.am.a cqp = null;
    private boolean cqq = false;
    private boolean cqr = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cqs = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cqt = new HashSet();
    private d.b cqu = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cqm = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void S(@NonNull JSONArray jSONArray) {
        i alH = alH();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + alH);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (DEBUG) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    com.baidu.swan.pms.e.a b = com.baidu.swan.pms.e.a.b(this.mLibName, next);
                    if (DEBUG) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + b);
                    }
                    if (b != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = alH != null && next == alH.dFt;
                        long j = (alH == null || !z) ? 0L : alH.versionCode;
                        String str = (alH == null || !z) ? "0" : alH.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.dFn);
                        jSONObject.put("version_code", j);
                        jSONObject.put(SharedPrefConfig.VERSION_NAME, str);
                        if (DEBUG) {
                            Log.i("SoUpdating", "decorate abi=" + next + " jo=" + jSONObject);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public boolean a(f fVar) {
        return fVar != null && fVar == this.cqm;
    }

    public d.b alG() {
        return this.cqu;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cqs.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cqt.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cqs.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cqt.remove(bVar);
        return this;
    }

    public String aly() {
        return this.mLibName;
    }

    public i alH() {
        if (this.cqn == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cqn = com.baidu.swan.pms.database.a.aTt().wz(this.mLibName);
        }
        return this.cqn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cqo = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i alI() {
        return this.cqo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean alJ() {
        return (this.cqo == null || this.cqo == this.cqn) ? false : true;
    }

    public synchronized void alK() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + aly() + " finished=" + this.cqr + " installing=" + this.cqq);
        }
        if (!this.cqr && !this.cqq) {
            this.cqq = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + aly());
            }
            c.cqa.a(aly(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.aly() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cqq = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + aly() + " finished=" + this.cqr + " error=" + aVar);
        }
        if (this.cqr) {
            eVar = this;
        } else {
            this.cqr = true;
            this.cqp = aVar;
            if (this.cqp == null) {
                c.cqa.k(aly(), System.currentTimeMillis());
            }
            c.cqa.mm(aly());
            alO();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cqs.clear();
        this.cqt.clear();
    }

    public boolean alL() {
        return this.cqr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean alM() {
        return alL() && (this.cqp == null || c.cqa.mn(aly()));
    }

    public boolean alN() {
        return !alL() && this.cqq;
    }

    private synchronized void alO() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + aly() + " mCallbacks=" + this.cqs.size());
        }
        this.cqr = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cqs) {
            if (bVar != null) {
                bVar.I(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cqr && bVar != null && 0 != bVar.cqk) {
            this.cqu = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cqt) {
                if (bVar2 != null) {
                    bVar2.I(this);
                }
            }
        }
    }
}
