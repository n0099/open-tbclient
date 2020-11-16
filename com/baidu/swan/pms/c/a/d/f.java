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
/* loaded from: classes6.dex */
public class f<T> implements Runnable {
    e egA;
    T egB;
    File egC;
    AtomicBoolean egD = new AtomicBoolean(false);
    c<T> egE;
    private boolean egF;

    public f(e eVar, T t, c<T> cVar) {
        this.egA = eVar;
        this.egB = t;
        this.egE = cVar;
    }

    public void hX(boolean z) {
        if (this.egD.get() != z) {
            this.egD.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.egA == null || fVar.egA.egz == null || this.egA == null || this.egA.egz == null || !this.egA.egz.equals(fVar.egA.egz)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bbc() {
        return this.egE;
    }

    public T bbd() {
        return this.egB;
    }

    public int bbe() {
        return this.egA.egz.state;
    }

    public void bbf() {
        mR(1);
        this.egE.S(this.egB);
    }

    public void bbg() {
        this.egE.R(this.egB);
    }

    public void bbh() {
        mR(2);
        this.egE.ai(this.egB);
    }

    public void asX() {
        mR(10);
        this.egE.Q(this.egB);
    }

    public void bbi() {
        mR(3);
        this.egE.a((c<T>) this.egB, this.egA.egy);
    }

    public boolean mR(int i) {
        if (this.egA.egz.state != i) {
            this.egA.egz.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hX(true);
                return true;
            }
            hX(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": run:" + this.egA.egz.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.egA.egy == null || this.egA.egy.errorNo != 2200) {
                if (this.egD.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": stopped:" + this.egA.egz.downloadUrl);
                    }
                    bbh();
                    return;
                }
                jVar.bbp();
                if (this.egA.egy != null) {
                    switch (this.egA.egy.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": success download:" + this.egA.egz.downloadUrl);
                            }
                            asX();
                            return;
                        default:
                            if (this.egD.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": stopped:" + this.egA.egz.downloadUrl);
                                }
                                bbh();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": retry download:" + this.egA.egz.downloadUrl);
                            }
                            this.egE.mRetryCount++;
                            if (this.egE.mRetryCount < 3) {
                                try {
                                    if (!this.egD.get()) {
                                        Thread.sleep(this.egE.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bbi();
                                a(this.egA.egy.errorNo, this.egA.egz);
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
    public boolean bbj() {
        if (TextUtils.isEmpty(this.egA.egz.filePath)) {
            this.egC = com.baidu.swan.pms.utils.d.dt(this.egE.U(this.egB), this.egA.egz.md5);
            if (this.egC == null) {
                this.egE.a((c<T>) this.egB, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.egA.egz.filePath = this.egC.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cP(long j) {
        boolean z = false;
        String U = this.egE.U(this.egB);
        if (U != null) {
            try {
                StatFs statFs = new StatFs(U);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.efY);
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
        return Objects.hash(this.egA.egz);
    }

    public int bbk() {
        return new com.baidu.swan.pms.c.a.b.a().B(this.egE.baw()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.egA.egz.downloadUrl + ",versionName:" + this.egA.egz.versionName + ",versionCode:" + this.egA.egz.versionCode + "md5:" + this.egA.egz.md5 + "bundleId:" + this.egA.egz.efY;
    }

    public void bbl() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": onNotifyPending" + this);
        }
        this.egF = true;
        hX(true);
    }

    public boolean bbm() {
        return this.egF;
    }

    public void hY(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bau().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.egA.egz.currentSize = 0L;
        }
        mR(0);
        hX(false);
        this.egF = false;
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
