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
/* loaded from: classes10.dex */
public class f<T> implements Runnable {
    File bth;
    e cxD;
    T cxE;
    AtomicBoolean cxF = new AtomicBoolean(false);
    c<T> cxG;
    private boolean cxH;

    public f(e eVar, T t, c<T> cVar) {
        this.cxD = eVar;
        this.cxE = t;
        this.cxG = cVar;
    }

    public void eT(boolean z) {
        if (this.cxF.get() != z) {
            this.cxF.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cxD == null || fVar.cxD.cxC == null || this.cxD == null || this.cxD.cxC == null || !this.cxD.cxC.equals(fVar.cxD.cxC)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> arG() {
        return this.cxG;
    }

    public T arH() {
        return this.cxE;
    }

    public int arI() {
        return this.cxD.cxC.state;
    }

    public void arJ() {
        iq(1);
        this.cxG.G(this.cxE);
    }

    public void arK() {
        this.cxG.F(this.cxE);
    }

    public void arL() {
        iq(2);
        this.cxG.W(this.cxE);
    }

    public void arM() {
        iq(10);
        this.cxG.E(this.cxE);
    }

    public void arN() {
        iq(3);
        this.cxG.a((c<T>) this.cxE, this.cxD.cxB);
    }

    public boolean iq(int i) {
        if (this.cxD.cxC.state != i) {
            this.cxD.cxC.state = i;
            if (i == 2 || i == 3 || i == 10) {
                eT(true);
                return true;
            }
            eT(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": run:" + this.cxD.cxC.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cxD.cxB == null || this.cxD.cxB.errorNo != 2200) {
                if (this.cxF.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": stopped:" + this.cxD.cxC.downloadUrl);
                    }
                    arL();
                    return;
                }
                jVar.arS();
                if (this.cxD.cxB != null) {
                    switch (this.cxD.cxB.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": success download:" + this.cxD.cxC.downloadUrl);
                            }
                            arM();
                            return;
                        default:
                            if (this.cxF.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": stopped:" + this.cxD.cxC.downloadUrl);
                                }
                                arL();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": retry download:" + this.cxD.cxC.downloadUrl);
                            }
                            this.cxG.mRetryCount++;
                            if (this.cxG.mRetryCount < 3) {
                                try {
                                    if (!this.cxF.get()) {
                                        Thread.sleep(this.cxG.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                arN();
                                a(this.cxD.cxB.errorNo, this.cxD.cxC);
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
    public boolean arp() {
        if (TextUtils.isEmpty(this.cxD.cxC.filePath)) {
            this.bth = com.baidu.swan.pms.f.c.bX(this.cxG.I(this.cxE), this.cxD.cxC.md5);
            if (this.bth == null) {
                this.cxG.a((c<T>) this.cxE, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cxD.cxC.filePath = this.bth.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bf(long j) {
        boolean z = false;
        String I = this.cxG.I(this.cxE);
        if (I != null) {
            try {
                StatFs statFs = new StatFs(I);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.cwZ);
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
        return Objects.hash(this.cxD.cxC);
    }

    public int arO() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cxG.arb()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cxD.cxC.downloadUrl + ",versionName:" + this.cxD.cxC.versionName + ",versionCode:" + this.cxD.cxC.versionCode + "md5:" + this.cxD.cxC.md5 + "bundleId:" + this.cxD.cxC.cwZ;
    }

    public void arP() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": onNotifyPending" + this);
        }
        this.cxH = true;
        eT(true);
    }

    public boolean arQ() {
        return this.cxH;
    }

    public void eU(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.aqZ().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cxD.cxC.currentSize = 0L;
        }
        iq(0);
        eT(false);
        this.cxH = false;
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
