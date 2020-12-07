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
import kotlin.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f cXY;
    private i cXZ = null;
    private i cYa = null;
    private com.baidu.swan.apps.am.a cYb = null;
    private boolean cYc = false;
    private boolean cYd = false;
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cYe = new HashSet();
    private final Collection<com.baidu.swan.apps.ap.e.b<e>> cYf = new HashSet();
    private d.b cYg = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cXY = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: B */
    public void W(@NonNull JSONArray jSONArray) {
        i avY = avY();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + avY);
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
                        boolean z = avY != null && next == avY.eng;
                        long j = (avY == null || !z) ? 0L : avY.versionCode;
                        String str = (avY == null || !z) ? "0" : avY.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.emZ);
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
        return fVar != null && fVar == this.cXY;
    }

    public d.b avX() {
        return this.cYg;
    }

    public synchronized e j(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cYe.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cYf.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cYe.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ap.e.b<e> bVar) {
        this.cYf.remove(bVar);
        return this;
    }

    public String avP() {
        return this.mLibName;
    }

    public i avY() {
        if (this.cXZ == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cXZ = com.baidu.swan.pms.database.a.bdF().yN(this.mLibName);
        }
        return this.cXZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cYa = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i avZ() {
        return this.cYa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean awa() {
        return (this.cYa == null || this.cYa == this.cXZ) ? false : true;
    }

    public synchronized void awb() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + avP() + " finished=" + this.cYd + " installing=" + this.cYc);
        }
        if (!this.cYd && !this.cYc) {
            this.cYc = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + avP());
            }
            c.cXM.a(avP(), new kotlin.jvm.a.b<com.baidu.swan.apps.am.a, h>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public h invoke(com.baidu.swan.apps.am.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.avP() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cYc = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.am.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + avP() + " finished=" + this.cYd + " error=" + aVar);
        }
        if (this.cYd) {
            eVar = this;
        } else {
            this.cYd = true;
            this.cYb = aVar;
            if (this.cYb == null) {
                c.cXM.m(avP(), System.currentTimeMillis());
            }
            c.cXM.oB(avP());
            awf();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cYe.clear();
        this.cYf.clear();
    }

    public boolean awc() {
        return this.cYd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean awd() {
        return awc() && (this.cYb == null || c.cXM.oC(avP()));
    }

    public boolean awe() {
        return !awc() && this.cYc;
    }

    private synchronized void awf() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + avP() + " mCallbacks=" + this.cYe.size());
        }
        this.cYd = true;
        for (com.baidu.swan.apps.ap.e.b<e> bVar : this.cYe) {
            if (bVar != null) {
                bVar.M(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cYd && bVar != null && 0 != bVar.cXW) {
            this.cYg = bVar;
            for (com.baidu.swan.apps.ap.e.b<e> bVar2 : this.cYf) {
                if (bVar2 != null) {
                    bVar2.M(this);
                }
            }
        }
    }
}
