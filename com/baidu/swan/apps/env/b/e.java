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
    private final f cMW;
    private i cMX = null;
    private i cMY = null;
    private com.baidu.swan.apps.am.a cMZ = null;
    private boolean cNa = false;
    private boolean cNb = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cNc = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cNd = new HashSet();
    private d.b cNe = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cMW = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void W(@NonNull JSONArray jSONArray) {
        i aqX = aqX();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + aqX);
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
                        boolean z = aqX != null && next == aqX.ebU;
                        long j = (aqX == null || !z) ? 0L : aqX.versionCode;
                        String str = (aqX == null || !z) ? "0" : aqX.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.ebO);
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
        return fVar != null && fVar == this.cMW;
    }

    public d.b aqW() {
        return this.cNe;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cNc.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cNd.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cNc.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cNd.remove(bVar);
        return this;
    }

    public String aqO() {
        return this.mLibName;
    }

    public i aqX() {
        if (this.cMX == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cMX = com.baidu.swan.pms.database.a.aYH().xX(this.mLibName);
        }
        return this.cMX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cMY = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i aqY() {
        return this.cMY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aqZ() {
        return (this.cMY == null || this.cMY == this.cMX) ? false : true;
    }

    public synchronized void ara() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + aqO() + " finished=" + this.cNb + " installing=" + this.cNa);
        }
        if (!this.cNb && !this.cNa) {
            this.cNa = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + aqO());
            }
            c.cMK.a(aqO(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, l>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public l invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.aqO() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cNa = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + aqO() + " finished=" + this.cNb + " error=" + aVar);
        }
        if (this.cNb) {
            eVar = this;
        } else {
            this.cNb = true;
            this.cMZ = aVar;
            if (this.cMZ == null) {
                c.cMK.m(aqO(), System.currentTimeMillis());
            }
            c.cMK.nK(aqO());
            are();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cNc.clear();
        this.cNd.clear();
    }

    public boolean arb() {
        return this.cNb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean arc() {
        return arb() && (this.cMZ == null || c.cMK.nL(aqO()));
    }

    public boolean ard() {
        return !arb() && this.cNa;
    }

    private synchronized void are() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + aqO() + " mCallbacks=" + this.cNc.size());
        }
        this.cNb = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cNc) {
            if (bVar != null) {
                bVar.M(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cNb && bVar != null && 0 != bVar.cMU) {
            this.cNe = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cNd) {
                if (bVar2 != null) {
                    bVar2.M(this);
                }
            }
        }
    }
}
