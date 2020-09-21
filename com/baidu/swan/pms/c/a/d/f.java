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
/* loaded from: classes24.dex */
public class f<T> implements Runnable {
    e dHS;
    T dHT;
    File dHU;
    AtomicBoolean dHV = new AtomicBoolean(false);
    c<T> dHW;
    private boolean dHX;

    public f(e eVar, T t, c<T> cVar) {
        this.dHS = eVar;
        this.dHT = t;
        this.dHW = cVar;
    }

    public void hc(boolean z) {
        if (this.dHV.get() != z) {
            this.dHV.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dHS == null || fVar.dHS.dHR == null || this.dHS == null || this.dHS.dHR == null || !this.dHS.dHR.equals(fVar.dHS.dHR)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aUH() {
        return this.dHW;
    }

    public T aUI() {
        return this.dHT;
    }

    public int aUJ() {
        return this.dHS.dHR.state;
    }

    public void aUK() {
        md(1);
        this.dHW.P(this.dHT);
    }

    public void aUL() {
        this.dHW.O(this.dHT);
    }

    public void aUM() {
        md(2);
        this.dHW.af(this.dHT);
    }

    public void amy() {
        md(10);
        this.dHW.N(this.dHT);
    }

    public void aUN() {
        md(3);
        this.dHW.a((c<T>) this.dHT, this.dHS.dHQ);
    }

    public boolean md(int i) {
        if (this.dHS.dHR.state != i) {
            this.dHS.dHR.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hc(true);
                return true;
            }
            hc(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": run:" + this.dHS.dHR.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dHS.dHQ == null || this.dHS.dHQ.errorNo != 2200) {
                if (this.dHV.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": stopped:" + this.dHS.dHR.downloadUrl);
                    }
                    aUM();
                    return;
                }
                jVar.aUU();
                if (this.dHS.dHQ != null) {
                    switch (this.dHS.dHQ.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": success download:" + this.dHS.dHR.downloadUrl);
                            }
                            amy();
                            return;
                        default:
                            if (this.dHV.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": stopped:" + this.dHS.dHR.downloadUrl);
                                }
                                aUM();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": retry download:" + this.dHS.dHR.downloadUrl);
                            }
                            this.dHW.mRetryCount++;
                            if (this.dHW.mRetryCount < 3) {
                                try {
                                    if (!this.dHV.get()) {
                                        Thread.sleep(this.dHW.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aUN();
                                a(this.dHS.dHQ.errorNo, this.dHS.dHR);
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
    public boolean aUO() {
        if (TextUtils.isEmpty(this.dHS.dHR.filePath)) {
            this.dHU = com.baidu.swan.pms.utils.d.di(this.dHW.R(this.dHT), this.dHS.dHR.md5);
            if (this.dHU == null) {
                this.dHW.a((c<T>) this.dHT, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dHS.dHR.filePath = this.dHU.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cj(long j) {
        boolean z = false;
        String R = this.dHW.R(this.dHT);
        if (R != null) {
            try {
                StatFs statFs = new StatFs(R);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.dHr);
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
        return Objects.hash(this.dHS.dHR);
    }

    public int aUP() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dHW.aUb()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dHS.dHR.downloadUrl + ",versionName:" + this.dHS.dHR.versionName + ",versionCode:" + this.dHS.dHR.versionCode + "md5:" + this.dHS.dHR.md5 + "bundleId:" + this.dHS.dHR.dHr;
    }

    public void aUQ() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": onNotifyPending" + this);
        }
        this.dHX = true;
        hc(true);
    }

    public boolean aUR() {
        return this.dHX;
    }

    public void hd(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aTZ().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dHS.dHR.currentSize = 0L;
        }
        md(0);
        hc(false);
        this.dHX = false;
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
