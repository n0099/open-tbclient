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
    e eih;
    T eii;
    File eij;
    AtomicBoolean eik = new AtomicBoolean(false);
    c<T> eil;
    private boolean eim;

    public f(e eVar, T t, c<T> cVar) {
        this.eih = eVar;
        this.eii = t;
        this.eil = cVar;
    }

    public void hU(boolean z) {
        if (this.eik.get() != z) {
            this.eik.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.eih == null || fVar.eih.eig == null || this.eih == null || this.eih.eig == null || !this.eih.eig.equals(fVar.eih.eig)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> bbJ() {
        return this.eil;
    }

    public T bbK() {
        return this.eii;
    }

    public int bbL() {
        return this.eih.eig.state;
    }

    public void bbM() {
        mV(1);
        this.eil.S(this.eii);
    }

    public void bbN() {
        this.eil.R(this.eii);
    }

    public void bbO() {
        mV(2);
        this.eil.ai(this.eii);
    }

    public void atF() {
        mV(10);
        this.eil.Q(this.eii);
    }

    public void bbP() {
        mV(3);
        this.eil.a((c<T>) this.eii, this.eih.eif);
    }

    public boolean mV(int i) {
        if (this.eih.eig.state != i) {
            this.eih.eig.state = i;
            if (i == 2 || i == 3 || i == 10) {
                hU(true);
                return true;
            }
            hU(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": run:" + this.eih.eig.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.eih.eif == null || this.eih.eif.errorNo != 2200) {
                if (this.eik.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": stopped:" + this.eih.eig.downloadUrl);
                    }
                    bbO();
                    return;
                }
                jVar.bbW();
                if (this.eih.eif != null) {
                    switch (this.eih.eif.errorNo) {
                        case 2200:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": success download:" + this.eih.eig.downloadUrl);
                            }
                            atF();
                            return;
                        default:
                            if (this.eik.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": stopped:" + this.eih.eig.downloadUrl);
                                }
                                bbO();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": retry download:" + this.eih.eig.downloadUrl);
                            }
                            this.eil.mRetryCount++;
                            if (this.eil.mRetryCount < 3) {
                                try {
                                    if (!this.eik.get()) {
                                        Thread.sleep(this.eil.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                bbP();
                                a(this.eih.eif.errorNo, this.eih.eig);
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
    public boolean bbQ() {
        if (TextUtils.isEmpty(this.eih.eig.filePath)) {
            this.eij = com.baidu.swan.pms.utils.d.du(this.eil.U(this.eii), this.eih.eig.md5);
            if (this.eij == null) {
                this.eil.a((c<T>) this.eii, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.eih.eig.filePath = this.eij.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cP(long j) {
        boolean z = false;
        String U = this.eil.U(this.eii);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.ehG);
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
        return Objects.hash(this.eih.eig);
    }

    public int bbR() {
        return new com.baidu.swan.pms.c.a.b.a().B(this.eil.bbd()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.eih.eig.downloadUrl + ",versionName:" + this.eih.eig.versionName + ",versionCode:" + this.eih.eig.versionCode + "md5:" + this.eih.eig.md5 + "bundleId:" + this.eih.eig.ehG;
    }

    public void bbS() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": onNotifyPending" + this);
        }
        this.eim = true;
        hU(true);
    }

    public boolean bbT() {
        return this.eim;
    }

    public void hV(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.bbb().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.eih.eig.currentSize = 0L;
        }
        mV(0);
        hU(false);
        this.eim = false;
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
