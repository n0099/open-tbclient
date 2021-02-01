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
/* loaded from: classes3.dex */
public class f<T> implements Runnable {
    File ckA;
    e euD;
    T euE;
    AtomicBoolean euF = new AtomicBoolean(false);
    c<T> euG;
    private boolean euH;

    public f(e eVar, T t, c<T> cVar) {
        this.euD = eVar;
        this.euE = t;
        this.euG = cVar;
    }

    public void iE(boolean z) {
        if (this.euF.get() != z) {
            this.euF.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.euD == null || fVar.euD.euC == null || this.euD == null || this.euD.euC == null || !this.euD.euC.equals(fVar.euD.euC)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bcX() {
        return this.euG;
    }

    public T bcY() {
        return this.euE;
    }

    public int getTaskState() {
        return this.euD.euC.state;
    }

    public void bcZ() {
        lV(1);
        this.euG.S(this.euE);
    }

    public void bda() {
        this.euG.R(this.euE);
    }

    public void bdb() {
        lV(2);
        this.euG.ak(this.euE);
    }

    public void auc() {
        lV(10);
        this.euG.Q(this.euE);
    }

    public void bdc() {
        lV(3);
        this.euG.a((c<T>) this.euE, this.euD.euB);
    }

    public boolean lV(int i) {
        if (this.euD.euC.state != i) {
            this.euD.euC.state = i;
            if (i == 2 || i == 3 || i == 10) {
                iE(true);
                return true;
            }
            iE(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": run:" + this.euD.euC.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.euD.euB == null || this.euD.euB.errorNo != 2200) {
                if (this.euF.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": stopped:" + this.euD.euC.downloadUrl);
                    }
                    bdb();
                    return;
                }
                jVar.bdj();
                if (this.euD.euB != null) {
                    switch (this.euD.euB.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": success download:" + this.euD.euC.downloadUrl);
                            }
                            auc();
                            return;
                        default:
                            if (this.euF.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": stopped:" + this.euD.euC.downloadUrl);
                                }
                                bdb();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": retry download:" + this.euD.euC.downloadUrl);
                            }
                            this.euG.mRetryCount++;
                            if (this.euG.mRetryCount < 3) {
                                try {
                                    if (!this.euF.get()) {
                                        Thread.sleep(this.euG.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bdc();
                                a(this.euD.euB.errorNo, this.euD.euC);
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
    public boolean bdd() {
        if (TextUtils.isEmpty(this.euD.euC.filePath)) {
            this.ckA = com.baidu.swan.pms.utils.d.ds(this.euG.U(this.euE), this.euD.euC.md5);
            if (this.ckA == null) {
                this.euG.a((c<T>) this.euE, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.euD.euC.filePath = this.ckA.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dv(long j) {
        boolean z = false;
        String U = this.euG.U(this.euE);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": path exception or no space left." + th.toString());
                }
            }
        }
        return z;
    }

    private void a(int i, com.baidu.swan.pms.model.e eVar) {
        int i2;
        if (eVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (i == 2200) {
                i2 = 0;
            } else {
                try {
                    jSONObject.put(IIntercepter.TYPE_RESPONSE, eVar.toString());
                    i2 = i;
                } catch (JSONException e) {
                    e = e;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.euc);
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.f.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.euD.euC);
    }

    public int bde() {
        return new com.baidu.swan.pms.c.a.b.a().E(this.euG.bcr()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.euD.euC.downloadUrl + ",versionName:" + this.euD.euC.versionName + ",versionCode:" + this.euD.euC.versionCode + "md5:" + this.euD.euC.md5 + "bundleId:" + this.euD.euC.euc;
    }

    public void bdf() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": onNotifyPending" + this);
        }
        this.euH = true;
        iE(true);
    }

    public boolean bdg() {
        return this.euH;
    }

    public void iF(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcp().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.euD.euC.currentSize = 0L;
        }
        lV(0);
        iE(false);
        this.euH = false;
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
