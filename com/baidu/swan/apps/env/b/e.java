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
/* loaded from: classes7.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f cRf;
    private i cRg = null;
    private i cRh = null;
    private com.baidu.swan.apps.am.a cRi = null;
    private boolean cRj = false;
    private boolean cRk = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cRl = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cRm = new HashSet();
    private d.b cRn = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cRf = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void W(@NonNull JSONArray jSONArray) {
        i asQ = asQ();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + asQ);
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
                        boolean z = asQ != null && next == asQ.ege;
                        long j = (asQ == null || !z) ? 0L : asQ.versionCode;
                        String str = (asQ == null || !z) ? "0" : asQ.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.efY);
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
        return fVar != null && fVar == this.cRf;
    }

    public d.b asP() {
        return this.cRn;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cRl.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cRm.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cRl.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cRm.remove(bVar);
        return this;
    }

    public String asH() {
        return this.mLibName;
    }

    public i asQ() {
        if (this.cRg == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cRg = com.baidu.swan.pms.database.a.baA().yg(this.mLibName);
        }
        return this.cRg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cRh = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i asR() {
        return this.cRh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean asS() {
        return (this.cRh == null || this.cRh == this.cRg) ? false : true;
    }

    public synchronized void asT() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + asH() + " finished=" + this.cRk + " installing=" + this.cRj);
        }
        if (!this.cRk && !this.cRj) {
            this.cRj = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + asH());
            }
            c.cQT.a(asH(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.asH() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cRj = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + asH() + " finished=" + this.cRk + " error=" + aVar);
        }
        if (this.cRk) {
            eVar = this;
        } else {
            this.cRk = true;
            this.cRi = aVar;
            if (this.cRi == null) {
                c.cQT.m(asH(), System.currentTimeMillis());
            }
            c.cQT.nS(asH());
            asX();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cRl.clear();
        this.cRm.clear();
    }

    public boolean asU() {
        return this.cRk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean asV() {
        return asU() && (this.cRi == null || c.cQT.nT(asH()));
    }

    public boolean asW() {
        return !asU() && this.cRj;
    }

    private synchronized void asX() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + asH() + " mCallbacks=" + this.cRl.size());
        }
        this.cRk = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cRl) {
            if (bVar != null) {
                bVar.M(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cRk && bVar != null && 0 != bVar.cRd) {
            this.cRn = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cRm) {
                if (bVar2 != null) {
                    bVar2.M(this);
                }
            }
        }
    }
}
