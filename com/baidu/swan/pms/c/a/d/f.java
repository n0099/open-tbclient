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
    File cma;
    e ewe;
    T ewf;
    AtomicBoolean ewg = new AtomicBoolean(false);
    c<T> ewh;
    private boolean ewi;

    public f(e eVar, T t, c<T> cVar) {
        this.ewe = eVar;
        this.ewf = t;
        this.ewh = cVar;
    }

    public void iE(boolean z) {
        if (this.ewg.get() != z) {
            this.ewg.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.ewe == null || fVar.ewe.ewd == null || this.ewe == null || this.ewe.ewd == null || !this.ewe.ewd.equals(fVar.ewe.ewd)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bcZ() {
        return this.ewh;
    }

    public T bda() {
        return this.ewf;
    }

    public int getTaskState() {
        return this.ewe.ewd.state;
    }

    public void bdb() {
        lW(1);
        this.ewh.U(this.ewf);
    }

    public void bdc() {
        this.ewh.T(this.ewf);
    }

    public void bdd() {
        lW(2);
        this.ewh.am(this.ewf);
    }

    public void auf() {
        lW(10);
        this.ewh.S(this.ewf);
    }

    public void bde() {
        lW(3);
        this.ewh.a((c<T>) this.ewf, this.ewe.ewc);
    }

    public boolean lW(int i) {
        if (this.ewe.ewd.state != i) {
            this.ewe.ewd.state = i;
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
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": run:" + this.ewe.ewd.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.ewe.ewc == null || this.ewe.ewc.errorNo != 2200) {
                if (this.ewg.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": stopped:" + this.ewe.ewd.downloadUrl);
                    }
                    bdd();
                    return;
                }
                jVar.bdl();
                if (this.ewe.ewc != null) {
                    switch (this.ewe.ewc.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": success download:" + this.ewe.ewd.downloadUrl);
                            }
                            auf();
                            return;
                        default:
                            if (this.ewg.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": stopped:" + this.ewe.ewd.downloadUrl);
                                }
                                bdd();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": retry download:" + this.ewe.ewd.downloadUrl);
                            }
                            this.ewh.mRetryCount++;
                            if (this.ewh.mRetryCount < 3) {
                                try {
                                    if (!this.ewg.get()) {
                                        Thread.sleep(this.ewh.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bde();
                                a(this.ewe.ewc.errorNo, this.ewe.ewd);
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
    public boolean bdf() {
        if (TextUtils.isEmpty(this.ewe.ewd.filePath)) {
            this.cma = com.baidu.swan.pms.utils.d.ds(this.ewh.W(this.ewf), this.ewe.ewd.md5);
            if (this.cma == null) {
                this.ewh.a((c<T>) this.ewf, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.ewe.ewd.filePath = this.cma.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dv(long j) {
        boolean z = false;
        String W = this.ewh.W(this.ewf);
        if (W != null) {
            try {
                StatFs statFs = new StatFs(W);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.evD);
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
        return Objects.hash(this.ewe.ewd);
    }

    public int bdg() {
        return new com.baidu.swan.pms.c.a.b.a().E(this.ewh.bct()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.ewe.ewd.downloadUrl + ",versionName:" + this.ewe.ewd.versionName + ",versionCode:" + this.ewe.ewd.versionCode + "md5:" + this.ewe.ewd.md5 + "bundleId:" + this.ewe.ewd.evD;
    }

    public void bdh() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": onNotifyPending" + this);
        }
        this.ewi = true;
        iE(true);
    }

    public boolean bdi() {
        return this.ewi;
    }

    public void iF(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bcr().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.ewe.ewd.currentSize = 0L;
        }
        lW(0);
        iE(false);
        this.ewi = false;
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
