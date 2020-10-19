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
/* loaded from: classes15.dex */
public class f<T> implements Runnable {
    e dTT;
    T dTU;
    File dTV;
    AtomicBoolean dTW = new AtomicBoolean(false);
    c<T> dTX;
    private boolean dTY;

    public f(e eVar, T t, c<T> cVar) {
        this.dTT = eVar;
        this.dTU = t;
        this.dTX = cVar;
    }

    public void hy(boolean z) {
        if (this.dTW.get() != z) {
            this.dTW.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dTT == null || fVar.dTT.dTS == null || this.dTT == null || this.dTT.dTS == null || !this.dTT.dTS.equals(fVar.dTT.dTS)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aXq() {
        return this.dTX;
    }

    public T aXr() {
        return this.dTU;
    }

    public int aXs() {
        return this.dTT.dTS.state;
    }

    public void aXt() {
        mA(1);
        this.dTX.S(this.dTU);
    }

    public void aXu() {
        this.dTX.R(this.dTU);
    }

    public void aXv() {
        mA(2);
        this.dTX.ai(this.dTU);
    }

    public void apk() {
        mA(10);
        this.dTX.Q(this.dTU);
    }

    public void aXw() {
        mA(3);
        this.dTX.a((c<T>) this.dTU, this.dTT.dTR);
    }

    public boolean mA(int i) {
        if (this.dTT.dTS.state != i) {
            this.dTT.dTS.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hy(true);
                return true;
            }
            hy(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": run:" + this.dTT.dTS.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dTT.dTR == null || this.dTT.dTR.errorNo != 2200) {
                if (this.dTW.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": stopped:" + this.dTT.dTS.downloadUrl);
                    }
                    aXv();
                    return;
                }
                jVar.aXD();
                if (this.dTT.dTR != null) {
                    switch (this.dTT.dTR.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": success download:" + this.dTT.dTS.downloadUrl);
                            }
                            apk();
                            return;
                        default:
                            if (this.dTW.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": stopped:" + this.dTT.dTS.downloadUrl);
                                }
                                aXv();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": retry download:" + this.dTT.dTS.downloadUrl);
                            }
                            this.dTX.mRetryCount++;
                            if (this.dTX.mRetryCount < 3) {
                                try {
                                    if (!this.dTW.get()) {
                                        Thread.sleep(this.dTX.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aXw();
                                a(this.dTT.dTR.errorNo, this.dTT.dTS);
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
    public boolean aXx() {
        if (TextUtils.isEmpty(this.dTT.dTS.filePath)) {
            this.dTV = com.baidu.swan.pms.utils.d.dn(this.dTX.U(this.dTU), this.dTT.dTS.md5);
            if (this.dTV == null) {
                this.dTX.a((c<T>) this.dTU, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dTT.dTS.filePath = this.dTV.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cr(long j) {
        boolean z = false;
        String U = this.dTX.U(this.dTU);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.dTs);
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
        return Objects.hash(this.dTT.dTS);
    }

    public int aXy() {
        return new com.baidu.swan.pms.c.a.b.a().B(this.dTX.aWK()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dTT.dTS.downloadUrl + ",versionName:" + this.dTT.dTS.versionName + ",versionCode:" + this.dTT.dTS.versionCode + "md5:" + this.dTT.dTS.md5 + "bundleId:" + this.dTT.dTS.dTs;
    }

    public void aXz() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": onNotifyPending" + this);
        }
        this.dTY = true;
        hy(true);
    }

    public boolean aXA() {
        return this.dTY;
    }

    public void hz(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aWI().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dTT.dTS.currentSize = 0L;
        }
        mA(0);
        hy(false);
        this.dTY = false;
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
