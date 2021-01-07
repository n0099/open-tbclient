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
    private final f dcT;
    private i dcU = null;
    private i dcV = null;
    private com.baidu.swan.apps.al.a dcW = null;
    private boolean dcX = false;
    private boolean dcY = false;
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> dcZ = new HashSet();
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> dda = new HashSet();
    private d.b ddb = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.dcT = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: B */
    public void W(@NonNull JSONArray jSONArray) {
        i axr = axr();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + axr);
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
                        boolean z = axr != null && next == axr.ewO;
                        long j = (axr == null || !z) ? 0L : axr.versionCode;
                        String str = (axr == null || !z) ? "0" : axr.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b2.ewI);
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
        return fVar != null && fVar == this.dcT;
    }

    public d.b axq() {
        return this.ddb;
    }

    public synchronized e j(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dcZ.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dda.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dcZ.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.dda.remove(bVar);
        return this;
    }

    public String axi() {
        return this.mLibName;
    }

    public i axr() {
        if (this.dcU == null && !TextUtils.isEmpty(this.mLibName)) {
            this.dcU = com.baidu.swan.pms.database.a.bgc().yM(this.mLibName);
        }
        return this.dcU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.dcV = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i axs() {
        return this.dcV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean axt() {
        return (this.dcV == null || this.dcV == this.dcU) ? false : true;
    }

    public synchronized void axu() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + axi() + " finished=" + this.dcY + " installing=" + this.dcX);
        }
        if (!this.dcY && !this.dcX) {
            this.dcX = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + axi());
            }
            c.dcH.a(axi(), new kotlin.jvm.a.b<com.baidu.swan.apps.al.a, h>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public h invoke(com.baidu.swan.apps.al.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.axi() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.dcX = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.al.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + axi() + " finished=" + this.dcY + " error=" + aVar);
        }
        if (this.dcY) {
            eVar = this;
        } else {
            this.dcY = true;
            this.dcW = aVar;
            if (this.dcW == null) {
                c.dcH.m(axi(), System.currentTimeMillis());
            }
            c.dcH.ou(axi());
            axy();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.dcZ.clear();
        this.dda.clear();
    }

    public boolean axv() {
        return this.dcY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean axw() {
        return axv() && (this.dcW == null || c.dcH.ov(axi()));
    }

    public boolean axx() {
        return !axv() && this.dcX;
    }

    private synchronized void axy() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + axi() + " mCallbacks=" + this.dcZ.size());
        }
        this.dcY = true;
        for (com.baidu.swan.apps.ao.e.b<e> bVar : this.dcZ) {
            if (bVar != null) {
                bVar.L(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.dcY && bVar != null && 0 != bVar.dcR) {
            this.ddb = bVar;
            for (com.baidu.swan.apps.ao.e.b<e> bVar2 : this.dda) {
                if (bVar2 != null) {
                    bVar2.L(this);
                }
            }
        }
    }
}
