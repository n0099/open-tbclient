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
/* loaded from: classes3.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f csp;
    private i csq = null;
    private i csr = null;
    private com.baidu.swan.apps.am.a css = null;
    private boolean cst = false;
    private boolean csu = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> csv = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> csw = new HashSet();
    private d.b csx = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.csp = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void T(@NonNull JSONArray jSONArray) {
        i amr = amr();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + amr);
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
                        boolean z = amr != null && next == amr.dHx;
                        long j = (amr == null || !z) ? 0L : amr.versionCode;
                        String str = (amr == null || !z) ? "0" : amr.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.dHr);
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
        return fVar != null && fVar == this.csp;
    }

    public d.b amq() {
        return this.csx;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.csv.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.csw.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.csv.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.csw.remove(bVar);
        return this;
    }

    public String ami() {
        return this.mLibName;
    }

    public i amr() {
        if (this.csq == null && !TextUtils.isEmpty(this.mLibName)) {
            this.csq = com.baidu.swan.pms.database.a.aUf().wS(this.mLibName);
        }
        return this.csq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.csr = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i ams() {
        return this.csr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean amt() {
        return (this.csr == null || this.csr == this.csq) ? false : true;
    }

    public synchronized void amu() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + ami() + " finished=" + this.csu + " installing=" + this.cst);
        }
        if (!this.csu && !this.cst) {
            this.cst = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + ami());
            }
            c.csd.a(ami(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.ami() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cst = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + ami() + " finished=" + this.csu + " error=" + aVar);
        }
        if (this.csu) {
            eVar = this;
        } else {
            this.csu = true;
            this.css = aVar;
            if (this.css == null) {
                c.csd.k(ami(), System.currentTimeMillis());
            }
            c.csd.mF(ami());
            amy();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.csv.clear();
        this.csw.clear();
    }

    public boolean amv() {
        return this.csu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean amw() {
        return amv() && (this.css == null || c.csd.mG(ami()));
    }

    public boolean amx() {
        return !amv() && this.cst;
    }

    private synchronized void amy() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + ami() + " mCallbacks=" + this.csv.size());
        }
        this.csu = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.csv) {
            if (bVar != null) {
                bVar.J(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.csu && bVar != null && 0 != bVar.csn) {
            this.csx = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.csw) {
                if (bVar2 != null) {
                    bVar2.J(this);
                }
            }
        }
    }
}
