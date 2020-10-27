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
    e ecp;
    T ecq;
    File ecr;
    AtomicBoolean ecs = new AtomicBoolean(false);
    c<T> ect;
    private boolean ecu;

    public f(e eVar, T t, c<T> cVar) {
        this.ecp = eVar;
        this.ecq = t;
        this.ect = cVar;
    }

    public void hL(boolean z) {
        if (this.ecs.get() != z) {
            this.ecs.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.ecp == null || fVar.ecp.eco == null || this.ecp == null || this.ecp.eco == null || !this.ecp.eco.equals(fVar.ecp.eco)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aZj() {
        return this.ect;
    }

    public T aZk() {
        return this.ecq;
    }

    public int aZl() {
        return this.ecp.eco.state;
    }

    public void aZm() {
        mL(1);
        this.ect.S(this.ecq);
    }

    public void aZn() {
        this.ect.R(this.ecq);
    }

    public void aZo() {
        mL(2);
        this.ect.ai(this.ecq);
    }

    public void are() {
        mL(10);
        this.ect.Q(this.ecq);
    }

    public void aZp() {
        mL(3);
        this.ect.a((c<T>) this.ecq, this.ecp.ecn);
    }

    public boolean mL(int i) {
        if (this.ecp.eco.state != i) {
            this.ecp.eco.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hL(true);
                return true;
            }
            hL(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": run:" + this.ecp.eco.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.ecp.ecn == null || this.ecp.ecn.errorNo != 2200) {
                if (this.ecs.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": stopped:" + this.ecp.eco.downloadUrl);
                    }
                    aZo();
                    return;
                }
                jVar.aZw();
                if (this.ecp.ecn != null) {
                    switch (this.ecp.ecn.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": success download:" + this.ecp.eco.downloadUrl);
                            }
                            are();
                            return;
                        default:
                            if (this.ecs.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": stopped:" + this.ecp.eco.downloadUrl);
                                }
                                aZo();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": retry download:" + this.ecp.eco.downloadUrl);
                            }
                            this.ect.mRetryCount++;
                            if (this.ect.mRetryCount < 3) {
                                try {
                                    if (!this.ecs.get()) {
                                        Thread.sleep(this.ect.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aZp();
                                a(this.ecp.ecn.errorNo, this.ecp.eco);
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
    public boolean aZq() {
        if (TextUtils.isEmpty(this.ecp.eco.filePath)) {
            this.ecr = com.baidu.swan.pms.utils.d.du(this.ect.U(this.ecq), this.ecp.eco.md5);
            if (this.ecr == null) {
                this.ect.a((c<T>) this.ecq, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.ecp.eco.filePath = this.ecr.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ct(long j) {
        boolean z = false;
        String U = this.ect.U(this.ecq);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.ebO);
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
        return Objects.hash(this.ecp.eco);
    }

    public int aZr() {
        return new com.baidu.swan.pms.c.a.b.a().B(this.ect.aYD()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.ecp.eco.downloadUrl + ",versionName:" + this.ecp.eco.versionName + ",versionCode:" + this.ecp.eco.versionCode + "md5:" + this.ecp.eco.md5 + "bundleId:" + this.ecp.eco.ebO;
    }

    public void aZs() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": onNotifyPending" + this);
        }
        this.ecu = true;
        hL(true);
    }

    public boolean aZt() {
        return this.ecu;
    }

    public void hM(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aYB().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.ecp.eco.currentSize = 0L;
        }
        mL(0);
        hL(false);
        this.ecu = false;
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
