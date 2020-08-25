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
    e dFK;
    T dFL;
    File dFM;
    AtomicBoolean dFN = new AtomicBoolean(false);
    c<T> dFO;
    private boolean dFP;

    public f(e eVar, T t, c<T> cVar) {
        this.dFK = eVar;
        this.dFL = t;
        this.dFO = cVar;
    }

    public void hd(boolean z) {
        if (this.dFN.get() != z) {
            this.dFN.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dFK == null || fVar.dFK.dFJ == null || this.dFK == null || this.dFK.dFJ == null || !this.dFK.dFJ.equals(fVar.dFK.dFJ)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aTV() {
        return this.dFO;
    }

    public T aTW() {
        return this.dFL;
    }

    public int aTX() {
        return this.dFK.dFJ.state;
    }

    public void aTY() {
        lS(1);
        this.dFO.O(this.dFL);
    }

    public void aTZ() {
        this.dFO.N(this.dFL);
    }

    public void aUa() {
        lS(2);
        this.dFO.ae(this.dFL);
    }

    public void alO() {
        lS(10);
        this.dFO.M(this.dFL);
    }

    public void aUb() {
        lS(3);
        this.dFO.a((c<T>) this.dFL, this.dFK.dFI);
    }

    public boolean lS(int i) {
        if (this.dFK.dFJ.state != i) {
            this.dFK.dFJ.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hd(true);
                return true;
            }
            hd(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": run:" + this.dFK.dFJ.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dFK.dFI == null || this.dFK.dFI.errorNo != 2200) {
                if (this.dFN.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": stopped:" + this.dFK.dFJ.downloadUrl);
                    }
                    aUa();
                    return;
                }
                jVar.aUi();
                if (this.dFK.dFI != null) {
                    switch (this.dFK.dFI.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": success download:" + this.dFK.dFJ.downloadUrl);
                            }
                            alO();
                            return;
                        default:
                            if (this.dFN.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": stopped:" + this.dFK.dFJ.downloadUrl);
                                }
                                aUa();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": retry download:" + this.dFK.dFJ.downloadUrl);
                            }
                            this.dFO.mRetryCount++;
                            if (this.dFO.mRetryCount < 3) {
                                try {
                                    if (!this.dFN.get()) {
                                        Thread.sleep(this.dFO.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aUb();
                                a(this.dFK.dFI.errorNo, this.dFK.dFJ);
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
        if (TextUtils.isEmpty(this.dFK.dFJ.filePath)) {
            this.dFM = com.baidu.swan.pms.utils.d.di(this.dFO.Q(this.dFL), this.dFK.dFJ.md5);
            if (this.dFM == null) {
                this.dFO.a((c<T>) this.dFL, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dFK.dFJ.filePath = this.dFM.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ci(long j) {
        boolean z = false;
        String Q = this.dFO.Q(this.dFL);
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
                    jSONObject.put("appId", eVar.dFj);
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
        return Objects.hash(this.dFK.dFJ);
    }

    public int aUd() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dFO.aTp()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dFK.dFJ.downloadUrl + ",versionName:" + this.dFK.dFJ.versionName + ",versionCode:" + this.dFK.dFJ.versionCode + "md5:" + this.dFK.dFJ.md5 + "bundleId:" + this.dFK.dFJ.dFj;
    }

    public void aUe() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": onNotifyPending" + this);
        }
        this.dFP = true;
        hd(true);
    }

    public boolean aUf() {
        return this.dFP;
    }

    public void he(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTn().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dFK.dFJ.currentSize = 0L;
        }
        lS(0);
        hd(false);
        this.dFP = false;
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
