package com.baidu.swan.pms.c.a.d;

import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.common.intercepter.IIntercepter;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f<T> implements Runnable {
    File ckZ;
    e dqP;
    T dqQ;
    AtomicBoolean dqR = new AtomicBoolean(false);
    c<T> dqS;
    private boolean dqT;

    public f(e eVar, T t, c<T> cVar) {
        this.dqP = eVar;
        this.dqQ = t;
        this.dqS = cVar;
    }

    public void go(boolean z) {
        if (this.dqR.get() != z) {
            this.dqR.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.dqP == null || fVar.dqP.dqO == null || this.dqP == null || this.dqP.dqO == null || !this.dqP.dqO.equals(fVar.dqP.dqO)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> aHF() {
        return this.dqS;
    }

    public T aHG() {
        return this.dqQ;
    }

    public int aHH() {
        return this.dqP.dqO.state;
    }

    public void aHI() {
        jr(1);
        this.dqS.N(this.dqQ);
    }

    public void aHJ() {
        this.dqS.M(this.dqQ);
    }

    public void aHK() {
        jr(2);
        this.dqS.ae(this.dqQ);
    }

    public void aHL() {
        jr(10);
        this.dqS.L(this.dqQ);
    }

    public void aHM() {
        jr(3);
        this.dqS.a((c<T>) this.dqQ, this.dqP.dqN);
    }

    public boolean jr(int i) {
        if (this.dqP.dqO.state != i) {
            this.dqP.dqO.state = i;
            if (i == 2 || i == 3 || i == 10) {
                go(true);
                return true;
            }
            go(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": run:" + this.dqP.dqO.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.dqP.dqN == null || this.dqP.dqN.errorNo != 2200) {
                if (this.dqR.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": stopped:" + this.dqP.dqO.downloadUrl);
                    }
                    aHK();
                    return;
                }
                jVar.aHS();
                if (this.dqP.dqN != null) {
                    switch (this.dqP.dqN.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": success download:" + this.dqP.dqO.downloadUrl);
                            }
                            aHL();
                            return;
                        default:
                            if (this.dqR.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": stopped:" + this.dqP.dqO.downloadUrl);
                                }
                                aHK();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": retry download:" + this.dqP.dqO.downloadUrl);
                            }
                            this.dqS.mRetryCount++;
                            if (this.dqS.mRetryCount < 3) {
                                try {
                                    if (!this.dqR.get()) {
                                        Thread.sleep(this.dqS.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aHM();
                                a(this.dqP.dqN.errorNo, this.dqP.dqO);
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
    public boolean aHl() {
        if (TextUtils.isEmpty(this.dqP.dqO.filePath)) {
            this.ckZ = com.baidu.swan.pms.f.c.cP(this.dqS.P(this.dqQ), this.dqP.dqO.md5);
            if (this.ckZ == null) {
                this.dqS.a((c<T>) this.dqQ, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.dqP.dqO.filePath = this.ckZ.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bM(long j) {
        boolean z = false;
        String P = this.dqS.P(this.dqQ);
        if (P != null) {
            try {
                StatFs statFs = new StatFs(P);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": path exception or no space left." + th.toString());
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
                    com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
                }
            }
            try {
                if (eVar instanceof com.baidu.swan.pms.model.f) {
                    jSONObject.put("appId", eVar.dqi);
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
            }
            com.baidu.swan.pms.d.a.a(eVar.category, "pkg_download", null, i2, jSONObject);
        }
    }

    public int hashCode() {
        return Objects.hash(this.dqP.dqO);
    }

    public int aHN() {
        return new com.baidu.swan.pms.c.a.b.a().r(this.dqS.aGX()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.dqP.dqO.downloadUrl + ",versionName:" + this.dqP.dqO.versionName + ",versionCode:" + this.dqP.dqO.versionCode + "md5:" + this.dqP.dqO.md5 + "bundleId:" + this.dqP.dqO.dqi;
    }

    public void aHO() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": onNotifyPending" + this);
        }
        this.dqT = true;
        go(true);
    }

    public boolean aHP() {
        return this.dqT;
    }

    public void gp(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aGV().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.dqP.dqO.currentSize = 0L;
        }
        jr(0);
        go(false);
        this.dqT = false;
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
