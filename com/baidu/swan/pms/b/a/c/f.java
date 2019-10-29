package com.baidu.swan.pms.b.a.c;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f<T> implements Runnable {
    File aRW;
    e bMC;
    AtomicBoolean bMD = new AtomicBoolean(false);
    c<T> bME;
    T bMx;

    public f(e eVar, T t, c<T> cVar) {
        this.bMC = eVar;
        this.bMx = t;
        this.bME = cVar;
    }

    public void dF(boolean z) {
        if (this.bMD.get() != z) {
            this.bMD.set(z);
        }
    }

    public boolean h(f<T> fVar) {
        if (fVar == null) {
            return false;
        }
        return this.bMx.equals(fVar.bMx);
    }

    public com.baidu.swan.pms.a.a<T> abs() {
        return this.bME;
    }

    public void a(c cVar) {
        this.bME.a(cVar);
    }

    public T abt() {
        return this.bMx;
    }

    public int abu() {
        return this.bMC.bMB.state;
    }

    public void abv() {
        gG(1);
        this.bME.D(this.bMx);
    }

    public void abw() {
        this.bME.P(this.bMx);
    }

    public void abx() {
        gG(2);
        this.bME.R(this.bMx);
    }

    public void aby() {
        gG(10);
        this.bME.C(this.bMx);
    }

    public void abz() {
        gG(3);
        this.bME.a((c<T>) this.bMx, this.bMC.bMA);
    }

    public boolean gG(int i) {
        if (this.bMC.bMB.state != i) {
            this.bMC.bMB.state = i;
            if (i == 2 || i == 3 || i == 10) {
                dF(true);
                return true;
            }
            dF(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.e.DEBUG) {
            Log.d("ThunderInfoTask", "run:" + this.bMC.bMB.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.bMC.bMA == null || this.bMC.bMA.errorNo != 2200) {
                if (this.bMD.get()) {
                    if (com.baidu.swan.pms.e.DEBUG) {
                        Log.d("ThunderInfoTask", "stopped:" + this.bMC.bMB.downloadUrl);
                    }
                    abx();
                    return;
                }
                jVar.abC();
                if (this.bMC.bMA != null) {
                    switch (this.bMC.bMA.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "success download:" + this.bMC.bMB.downloadUrl);
                            }
                            aby();
                            a(this.bMC.bMA.errorNo, this.bMC.bMB);
                            return;
                        default:
                            if (com.baidu.swan.pms.e.DEBUG) {
                                Log.d("ThunderInfoTask", "retry download:" + this.bMC.bMB.downloadUrl);
                            }
                            this.bME.mRetryCount++;
                            if (this.bME.mRetryCount < 3) {
                                try {
                                    if (!this.bMD.get()) {
                                        Thread.sleep(this.bME.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                abz();
                                a(this.bMC.bMA.errorNo, this.bMC.bMB);
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
    public boolean abA() {
        if (TextUtils.isEmpty(this.bMC.bMB.filePath)) {
            this.aRW = com.baidu.swan.pms.e.c.bu(this.bME.getDownloadPath(), this.bMC.bMB.md5);
            if (this.aRW == null) {
                this.bME.a((c<T>) this.bMx, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.bMC.bMB.filePath = this.aRW.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean az(long j) {
        boolean z = false;
        String downloadPath = this.bME.getDownloadPath();
        if (downloadPath != null) {
            try {
                StatFs statFs = new StatFs(downloadPath);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.e.DEBUG) {
                    Log.d("ThunderInfoTask", "path exception or no space left." + th.toString());
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
                    jSONObject.put("response", eVar.toString());
                    i2 = i;
                } catch (JSONException e2) {
                    e = e2;
                    i2 = i;
                    e.printStackTrace();
                    com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.bMa);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.c.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj instanceof f) {
            return this.bMC.bMB.equals(((f) obj).bMC.bMB);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.bMC.bMB);
    }
}
