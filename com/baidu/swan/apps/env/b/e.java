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
/* loaded from: classes10.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f cEA;
    private i cEB = null;
    private i cEC = null;
    private com.baidu.swan.apps.am.a cED = null;
    private boolean cEE = false;
    private boolean cEF = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cEG = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cEH = new HashSet();
    private d.b cEI = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cEA = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void W(@NonNull JSONArray jSONArray) {
        i apc = apc();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + apc);
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
                        boolean z = apc != null && next == apc.dTy;
                        long j = (apc == null || !z) ? 0L : apc.versionCode;
                        String str = (apc == null || !z) ? "0" : apc.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.dTs);
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
        return fVar != null && fVar == this.cEA;
    }

    public d.b apb() {
        return this.cEI;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cEG.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cEH.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cEG.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cEH.remove(bVar);
        return this;
    }

    public String aoT() {
        return this.mLibName;
    }

    public i apc() {
        if (this.cEB == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cEB = com.baidu.swan.pms.database.a.aWO().xE(this.mLibName);
        }
        return this.cEB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cEC = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i apd() {
        return this.cEC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ape() {
        return (this.cEC == null || this.cEC == this.cEB) ? false : true;
    }

    public synchronized void apf() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + aoT() + " finished=" + this.cEF + " installing=" + this.cEE);
        }
        if (!this.cEF && !this.cEE) {
            this.cEE = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + aoT());
            }
            c.cEo.a(aoT(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.aoT() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cEE = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + aoT() + " finished=" + this.cEF + " error=" + aVar);
        }
        if (this.cEF) {
            eVar = this;
        } else {
            this.cEF = true;
            this.cED = aVar;
            if (this.cED == null) {
                c.cEo.k(aoT(), System.currentTimeMillis());
            }
            c.cEo.nr(aoT());
            apk();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cEG.clear();
        this.cEH.clear();
    }

    public boolean apg() {
        return this.cEF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aph() {
        return apg() && (this.cED == null || c.cEo.ns(aoT()));
    }

    public boolean apj() {
        return !apg() && this.cEE;
    }

    private synchronized void apk() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + aoT() + " mCallbacks=" + this.cEG.size());
        }
        this.cEF = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cEG) {
            if (bVar != null) {
                bVar.M(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cEF && bVar != null && 0 != bVar.cEy) {
            this.cEI = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cEH) {
                if (bVar2 != null) {
                    bVar2.M(this);
                }
            }
        }
    }
}
