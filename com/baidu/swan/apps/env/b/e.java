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
    private final f cYe;
    private i cYf = null;
    private i cYg = null;
    private com.baidu.swan.apps.al.a cYh = null;
    private boolean cYi = false;
    private boolean cYj = false;
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> cYk = new HashSet();
    private final Collection<com.baidu.swan.apps.ao.e.b<e>> cYl = new HashSet();
    private d.b cYm = null;
    private final String mLibName;

    public e(@NonNull f fVar, String str) {
        this.cYe = fVar;
        this.mLibName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.pms.node.c
    /* renamed from: B */
    public void W(@NonNull JSONArray jSONArray) {
        i atx = atx();
        if (DEBUG) {
            Log.i("SoUpdating", "decorateParams libName=" + this.mLibName + " localSo=" + atx);
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
                        boolean z = atx != null && next == atx.esb;
                        long j = (atx == null || !z) ? 0L : atx.versionCode;
                        String str = (atx == null || !z) ? "0" : atx.versionName;
                        if (TextUtils.isEmpty(str)) {
                            str = "0";
                        }
                        jSONObject.put("type", "so");
                        jSONObject.put("bundle_id", b2.erV);
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
        return fVar != null && fVar == this.cYe;
    }

    public d.b atw() {
        return this.cYm;
    }

    public synchronized e j(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.cYk.add(bVar);
        return this;
    }

    public synchronized e k(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.cYl.add(bVar);
        return this;
    }

    public synchronized e l(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.cYk.remove(bVar);
        return this;
    }

    public synchronized e m(com.baidu.swan.apps.ao.e.b<e> bVar) {
        this.cYl.remove(bVar);
        return this;
    }

    public String ato() {
        return this.mLibName;
    }

    public i atx() {
        if (this.cYf == null && !TextUtils.isEmpty(this.mLibName)) {
            this.cYf = com.baidu.swan.pms.database.a.bci().xB(this.mLibName);
        }
        return this.cYf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e a(f fVar, i iVar) {
        if (a(fVar)) {
            this.cYg = iVar;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i aty() {
        return this.cYg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean atz() {
        return (this.cYg == null || this.cYg == this.cYf) ? false : true;
    }

    public synchronized void atA() {
        if (DEBUG) {
            Log.i("SoUpdating", "install: " + ato() + " finished=" + this.cYj + " installing=" + this.cYi);
        }
        if (!this.cYj && !this.cYi) {
            this.cYi = true;
            if (DEBUG) {
                Log.i("SoUpdating", "install: " + ato());
            }
            c.cXS.a(ato(), new kotlin.jvm.a.b<com.baidu.swan.apps.al.a, h>() { // from class: com.baidu.swan.apps.env.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.a.b
                /* renamed from: c */
                public h invoke(com.baidu.swan.apps.al.a aVar) {
                    if (e.DEBUG) {
                        Log.i("SoUpdating", "install: " + e.this.ato() + " onCallback");
                    }
                    e.this.b(aVar);
                    e.this.cYi = false;
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized e b(com.baidu.swan.apps.al.a aVar) {
        e eVar;
        if (DEBUG) {
            Log.i("SoUpdating", "finish: " + ato() + " finished=" + this.cYj + " error=" + aVar);
        }
        if (this.cYj) {
            eVar = this;
        } else {
            this.cYj = true;
            this.cYh = aVar;
            if (this.cYh == null) {
                c.cXS.m(ato(), System.currentTimeMillis());
            }
            c.cXS.nh(ato());
            atE();
            clearCallback();
            eVar = this;
        }
        return eVar;
    }

    private synchronized void clearCallback() {
        this.cYk.clear();
        this.cYl.clear();
    }

    public boolean atB() {
        return this.cYj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean atC() {
        return atB() && (this.cYh == null || c.cXS.ni(ato()));
    }

    public boolean atD() {
        return !atB() && this.cYi;
    }

    private synchronized void atE() {
        if (DEBUG) {
            Log.i("SoUpdating", "notifyFinish: " + ato() + " mCallbacks=" + this.cYk.size());
        }
        this.cYj = true;
        for (com.baidu.swan.apps.ao.e.b<e> bVar : this.cYk) {
            if (bVar != null) {
                bVar.L(this);
            }
        }
    }

    public synchronized void a(d.b bVar) {
        if (!this.cYj && bVar != null && 0 != bVar.cYc) {
            this.cYm = bVar;
            for (com.baidu.swan.apps.ao.e.b<e> bVar2 : this.cYl) {
                if (bVar2 != null) {
                    bVar2.L(this);
                }
            }
        }
    }
}
