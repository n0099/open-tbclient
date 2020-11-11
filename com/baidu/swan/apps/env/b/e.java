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
    private final f cSP;
    private i cSQ = null;
    private i cSR = null;
    private com.baidu.swan.apps.am.a cSS = null;
    private boolean cST = false;
    private boolean cSU = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cSV = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cSW = new HashSet();
    private d.b cSX = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cSP = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void W(@NonNull JSONArray jSONArray) {
        i aty = aty();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + aty);
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
                        boolean z = aty != null && next == aty.ehM;
                        long j = (aty == null || !z) ? 0L : aty.versionCode;
                        String str = (aty == null || !z) ? "0" : aty.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.ehG);
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
        return fVar != null && fVar == this.cSP;
    }

    public d.b atx() {
        return this.cSX;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cSV.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cSW.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cSV.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cSW.remove(bVar);
        return this;
    }

    public String atp() {
        return this.mLibName;
    }

    public i aty() {
        if (this.cSQ == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cSQ = com.baidu.swan.pms.database.a.bbh().yl(this.mLibName);
        }
        return this.cSQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cSR = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i atz() {
        return this.cSR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean atA() {
        return (this.cSR == null || this.cSR == this.cSQ) ? false : true;
    }

    public synchronized void atB() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + atp() + " finished=" + this.cSU + " installing=" + this.cST);
        }
        if (!this.cSU && !this.cST) {
            this.cST = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + atp());
            }
            c.cSD.a(atp(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.atp() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cST = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + atp() + " finished=" + this.cSU + " error=" + aVar);
        }
        if (this.cSU) {
            eVar = this;
        } else {
            this.cSU = true;
            this.cSS = aVar;
            if (this.cSS == null) {
                c.cSD.m(atp(), System.currentTimeMillis());
            }
            c.cSD.nY(atp());
            atF();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cSV.clear();
        this.cSW.clear();
    }

    public boolean atC() {
        return this.cSU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean atD() {
        return atC() && (this.cSS == null || c.cSD.nZ(atp()));
    }

    public boolean atE() {
        return !atC() && this.cST;
    }

    private synchronized void atF() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + atp() + " mCallbacks=" + this.cSV.size());
        }
        this.cSU = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cSV) {
            if (bVar != null) {
                bVar.M(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cSU && bVar != null && 0 != bVar.cSN) {
            this.cSX = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cSW) {
                if (bVar2 != null) {
                    bVar2.M(this);
                }
            }
        }
    }
}
