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
/* loaded from: classes9.dex */
public final class e implements com.baidu.swan.pms.node.c<JSONArray> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final f dao;
    private i dap = null;
    private i daq = null;
    private com.baidu.swan.apps.al.a dar = null;
    private boolean das = false;
    private boolean dau = false;
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> dav = new HashSet();
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> daw = new HashSet();
    private d.b dax = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.dao = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: A */
    public void W(@NonNull JSONArray jSONArray) {
        i atV = atV();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + atV);
        }
        try {
            Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
            while (it.hasNext()) {
                AbiType next = it.next();
                if (DEBUG) {
                    Log.i("SoUpdating", "decorateParams loop abi=" + next);
                }
                if (next != null) {
                    com.baidu.swan.pms.e.a b2 = com.baidu.swan.pms.e.a.b(this.mLibName, next);
                    if (DEBUG) {
                        Log.i("SoUpdating", "decorateParams loop bundleId=" + b2);
                    }
                    if (b2 != null) {
                        JSONObject jSONObject = new JSONObject();
                        boolean z = atV != null && next == atV.eui;
                        long j = (atV == null || !z) ? 0L : atV.versionCode;
                        String str = (atV == null || !z) ? "0" : atV.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b2.euc);
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
        return fVar != null && fVar == this.dao;
    }

    public d.b atU() {
        return this.dax;
    }

    public synchronized e j(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dav.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.daw.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dav.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.daw.remove(bVar);
        return this;
    }

    public String atM() {
        return this.mLibName;
    }

    public i atV() {
        if (this.dap == null && !TextUtils.isEmpty(this.mLibName)) {
            this.dap = com.baidu.swan.pms.database.a.bcv().xU(this.mLibName);
        }
        return this.dap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.daq = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i atW() {
        return this.daq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean atX() {
        return (this.daq == null || this.daq == this.dap) ? false : true;
    }

    public synchronized void atY() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + atM() + " finished=" + this.dau + " installing=" + this.das);
        }
        if (!this.dau && !this.das) {
            this.das = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + atM());
            }
            c.dac.a(atM(), new kotlin.jvm.a.b<com.baidu.swan.apps.al.a, h>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public h invoke(com.baidu.swan.apps.al.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.atM() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.das = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.al.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + atM() + " finished=" + this.dau + " error=" + aVar);
        }
        if (this.dau) {
            eVar = this;
        } else {
            this.dau = true;
            this.dar = aVar;
            if (this.dar == null) {
                c.dac.l(atM(), System.currentTimeMillis());
            }
            c.dac.nz(atM());
            auc();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.dav.clear();
        this.daw.clear();
    }

    public boolean atZ() {
        return this.dau;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aua() {
        return atZ() && (this.dar == null || c.dac.nA(atM()));
    }

    public boolean aub() {
        return !atZ() && this.das;
    }

    private synchronized void auc() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + atM() + " mCallbacks=" + this.dav.size());
        }
        this.dau = true;
        for (com.baidu.swan.apps.ao.e.b<e> bVar : this.dav) {
            if (bVar != null) {
                bVar.L(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.dau && bVar != null && 0 != bVar.dam) {
            this.dax = bVar;
            for (com.baidu.swan.apps.ao.e.b<e> bVar2 : this.daw) {
                if (bVar2 != null) {
                    bVar2.L(this);
                }
            }
        }
    }
}
