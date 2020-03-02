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
    File bxs;
    e cBC;
    T cBD;
    AtomicBoolean cBE = new AtomicBoolean(false);
    c<T> cBF;
    private boolean cBG;

    public f(e eVar, T t, c<T> cVar) {
        this.cBC = eVar;
        this.cBD = t;
        this.cBF = cVar;
    }

    public void fa(boolean z) {
        if (this.cBE.get() != z) {
            this.cBE.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cBC == null || fVar.cBC.cBB == null || this.cBC == null || this.cBC.cBB == null || !this.cBC.cBB.equals(fVar.cBC.cBB)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> atW() {
        return this.cBF;
    }

    public T atX() {
        return this.cBD;
    }

    public int atY() {
        return this.cBC.cBB.state;
    }

    public void atZ() {
        iH(1);
        this.cBF.I(this.cBD);
    }

    public void aua() {
        this.cBF.H(this.cBD);
    }

    public void aub() {
        iH(2);
        this.cBF.Y(this.cBD);
    }

    public void auc() {
        iH(10);
        this.cBF.G(this.cBD);
    }

    public void aud() {
        iH(3);
        this.cBF.a((c<T>) this.cBD, this.cBC.cBA);
    }

    public boolean iH(int i) {
        if (this.cBC.cBB.state != i) {
            this.cBC.cBB.state = i;
            if (i == 2 || i == 3 || i == 10) {
                fa(true);
                return true;
            }
            fa(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": run:" + this.cBC.cBB.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cBC.cBA == null || this.cBC.cBA.errorNo != 2200) {
                if (this.cBE.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": stopped:" + this.cBC.cBB.downloadUrl);
                    }
                    aub();
                    return;
                }
                jVar.aui();
                if (this.cBC.cBA != null) {
                    switch (this.cBC.cBA.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": success download:" + this.cBC.cBB.downloadUrl);
                            }
                            auc();
                            return;
                        default:
                            if (this.cBE.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": stopped:" + this.cBC.cBB.downloadUrl);
                                }
                                aub();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": retry download:" + this.cBC.cBB.downloadUrl);
                            }
                            this.cBF.mRetryCount++;
                            if (this.cBF.mRetryCount < 3) {
                                try {
                                    if (!this.cBE.get()) {
                                        Thread.sleep(this.cBF.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aud();
                                a(this.cBC.cBA.errorNo, this.cBC.cBB);
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
    public boolean atF() {
        if (TextUtils.isEmpty(this.cBC.cBB.filePath)) {
            this.bxs = com.baidu.swan.pms.f.c.cg(this.cBF.K(this.cBD), this.cBC.cBB.md5);
            if (this.bxs == null) {
                this.cBF.a((c<T>) this.cBD, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cBC.cBB.filePath = this.bxs.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bj(long j) {
        boolean z = false;
        String K = this.cBF.K(this.cBD);
        if (K != null) {
            try {
                StatFs statFs = new StatFs(K);
                if (Build.VERSION.SDK_INT >= 18) {
                    z = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong() > j;
                } else {
                    z = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > j;
                }
            } catch (Throwable th) {
                if (com.baidu.swan.pms.d.DEBUG) {
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.cAY);
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
        return Objects.hash(this.cBC.cBB);
    }

    public int aue() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cBF.atr()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cBC.cBB.downloadUrl + ",versionName:" + this.cBC.cBB.versionName + ",versionCode:" + this.cBC.cBB.versionCode + "md5:" + this.cBC.cBB.md5 + "bundleId:" + this.cBC.cBB.cAY;
    }

    public void auf() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": onNotifyPending" + this);
        }
        this.cBG = true;
        fa(true);
    }

    public boolean aug() {
        return this.cBG;
    }

    public void fb(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cBC.cBB.currentSize = 0L;
        }
        iH(0);
        fa(false);
        this.cBG = false;
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
