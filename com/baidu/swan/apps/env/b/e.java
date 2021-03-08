package com.baidu.swan.apps.env.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f dbR;
    private i dbS = null;
    private i dbT = null;
    private com.baidu.swan.apps.al.a dbU = null;
    private boolean dbV = false;
    private boolean dbW = false;
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> dbX = new HashSet();
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> dbY = new HashSet();
    private d.b dbZ = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.dbR = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void Y(@NonNull JSONArray jSONArray) {
        i atY = atY();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + atY);
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
                        boolean z = atY != null && next == atY.evJ;
                        long j = (atY == null || !z) ? 0L : atY.versionCode;
                        String str = (atY == null || !z) ? "0" : atY.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b.evD);
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
        return fVar != null && fVar == this.dbR;
    }

    public d.b atX() {
        return this.dbZ;
    }

    public synchronized e j(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dbX.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dbY.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dbX.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dbY.remove(bVar);
        return this;
    }

    public String atP() {
        return this.mLibName;
    }

    public i atY() {
        if (this.dbS == null && !TextUtils.isEmpty(this.mLibName)) {
            this.dbS = com.baidu.swan.pms.database.a.bcx().yb(this.mLibName);
        }
        return this.dbS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.dbT = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i atZ() {
        return this.dbT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aua() {
        return (this.dbT == null || this.dbT == this.dbS) ? false : true;
    }

    public synchronized void aub() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + atP() + " finished=" + this.dbW + " installing=" + this.dbV);
        }
        if (!this.dbW && !this.dbV) {
            this.dbV = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + atP());
            }
            c.dbF.a(atP(), new kotlin.jvm.a.b<com.baidu.swan.apps.al.a, h>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public h invoke(com.baidu.swan.apps.al.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.atP() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.dbV = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.al.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + atP() + " finished=" + this.dbW + " error=" + aVar);
        }
        if (this.dbW) {
            eVar = this;
        } else {
            this.dbW = true;
            this.dbU = aVar;
            if (this.dbU == null) {
                c.dbF.l(atP(), System.currentTimeMillis());
            }
            c.dbF.nG(atP());
            auf();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.dbX.clear();
        this.dbY.clear();
    }

    public boolean auc() {
        return this.dbW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aud() {
        return auc() && (this.dbU == null || c.dbF.nH(atP()));
    }

    public boolean aue() {
        return !auc() && this.dbV;
    }

    private synchronized void auf() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + atP() + " mCallbacks=" + this.dbX.size());
        }
        this.dbW = true;
        for (com.baidu.swan.apps.ao.e.b<e> bVar : this.dbX) {
            if (bVar != null) {
                bVar.N(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.dbW && bVar != null && 0 != bVar.dbP) {
            this.dbZ = bVar;
            for (com.baidu.swan.apps.ao.e.b<e> bVar2 : this.dbY) {
                if (bVar2 != null) {
                    bVar2.N(this);
                }
            }
        }
    }
}
