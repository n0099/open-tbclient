package com.baidu.swan.pms.c.a.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class f<T> implements Runnable {
    e dFO;
    T dFP;
    File dFQ;
    AtomicBoolean dFR = new AtomicBoolean(false);
    c<T> dFS;
    private boolean dFT;

    public f(e eVar, T t, c<T> cVar) {
        this.dFO = eVar;
        this.dFP = t;
        this.dFS = cVar;
    }

    public void he(boolean z) {
        if (this.dFR.get() != z) {
            this.dFR.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dFO == null || fVar.dFO.dFN == null || this.dFO == null || this.dFO.dFN == null || !this.dFO.dFN.equals(fVar.dFO.dFN)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aTV() {
        return this.dFS;
    }

    public T aTW() {
        return this.dFP;
    }

    public int aTX() {
        return this.dFO.dFN.state;
    }

    public void aTY() {
        lS(1);
        this.dFS.O(this.dFP);
    }

    public void aTZ() {
        this.dFS.N(this.dFP);
    }

    public void aUa() {
        lS(2);
        this.dFS.ae(this.dFP);
    }

    public void alO() {
        lS(10);
        this.dFS.M(this.dFP);
    }

    public void aUb() {
        lS(3);
        this.dFS.a((c<T>) this.dFP, this.dFO.dFM);
    }

    public boolean lS(int i) {
        if (this.dFO.dFN.state != i) {
            this.dFO.dFN.state = i;
            if (i == 2 || i == 3 || i == 10) {
                he(true);
                return true;
            }
            he(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": run:" + this.dFO.dFN.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dFO.dFM == null || this.dFO.dFM.errorNo != 2200) {
                if (this.dFR.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": stopped:" + this.dFO.dFN.downloadUrl);
                    }
                    aUa();
                    return;
                }
                jVar.aUi();
                if (this.dFO.dFM != null) {
                    switch (this.dFO.dFM.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": success download:" + this.dFO.dFN.downloadUrl);
                            }
                            alO();
                            return;
                        default:
                            if (this.dFR.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": stopped:" + this.dFO.dFN.downloadUrl);
                                }
                                aUa();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": retry download:" + this.dFO.dFN.downloadUrl);
                            }
                            this.dFS.mRetryCount++;
                            if (this.dFS.mRetryCount < 3) {
                                try {
                                    if (!this.dFR.get()) {
                                        Thread.sleep(this.dFS.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aUb();
                                a(this.dFO.dFM.errorNo, this.dFO.dFN);
                                return;
                            }
                    }
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aUc() {
        if (TextUtils.isEmpty(this.dFO.dFN.filePath)) {
            this.dFQ = com.baidu.swan.pms.utils.d.di(this.dFS.Q(this.dFP), this.dFO.dFN.md5);
            if (this.dFQ == null) {
                this.dFS.a((c<T>) this.dFP, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dFO.dFN.filePath = this.dFQ.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ci(long j) {
        boolean z = false;
        String Q = this.dFS.Q(this.dFP);
        if (Q != null) {
            try {
                StatFs statFs = new StatFs(Q);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    private void a(int i, com.baidu.swan.pms.model.e eVar) {
        JSONException e;
        int i2;
        if (eVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (i == 2200) {
                i2 = 0;
            } else {
                try {
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, eVar.toString());
                    i2 = i;
                } catch (JSONException e2) {
                    e = e2;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.dFn);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.dFO.dFN);
    }

    public int aUd() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dFS.aTp()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dFO.dFN.downloadUrl + ",versionName:" + this.dFO.dFN.versionName + ",versionCode:" + this.dFO.dFN.versionCode + "md5:" + this.dFO.dFN.md5 + "bundleId:" + this.dFO.dFN.dFn;
    }

    public void aUe() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": onNotifyPending" + this);
        }
        this.dFT = true;
        he(true);
    }

    public boolean aUf() {
        return this.dFT;
    }

    public void hf(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dFO.dFN.currentSize = 0L;
        }
        lS(0);
        he(false);
        this.dFT = false;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        return k((f) obj);
    }
}
