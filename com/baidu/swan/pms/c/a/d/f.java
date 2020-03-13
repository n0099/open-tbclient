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
    File bxt;
    e cBD;
    T cBE;
    AtomicBoolean cBF = new AtomicBoolean(false);
    c<T> cBG;
    private boolean cBH;

    public f(e eVar, T t, c<T> cVar) {
        this.cBD = eVar;
        this.cBE = t;
        this.cBG = cVar;
    }

    public void fa(boolean z) {
        if (this.cBF.get() != z) {
            this.cBF.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cBD == null || fVar.cBD.cBC == null || this.cBD == null || this.cBD.cBC == null || !this.cBD.cBC.equals(fVar.cBD.cBC)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> atW() {
        return this.cBG;
    }

    public T atX() {
        return this.cBE;
    }

    public int atY() {
        return this.cBD.cBC.state;
    }

    public void atZ() {
        iH(1);
        this.cBG.I(this.cBE);
    }

    public void aua() {
        this.cBG.H(this.cBE);
    }

    public void aub() {
        iH(2);
        this.cBG.Y(this.cBE);
    }

    public void auc() {
        iH(10);
        this.cBG.G(this.cBE);
    }

    public void aud() {
        iH(3);
        this.cBG.a((c<T>) this.cBE, this.cBD.cBB);
    }

    public boolean iH(int i) {
        if (this.cBD.cBC.state != i) {
            this.cBD.cBC.state = i;
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
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": run:" + this.cBD.cBC.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cBD.cBB == null || this.cBD.cBB.errorNo != 2200) {
                if (this.cBF.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": stopped:" + this.cBD.cBC.downloadUrl);
                    }
                    aub();
                    return;
                }
                jVar.aui();
                if (this.cBD.cBB != null) {
                    switch (this.cBD.cBB.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": success download:" + this.cBD.cBC.downloadUrl);
                            }
                            auc();
                            return;
                        default:
                            if (this.cBF.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": stopped:" + this.cBD.cBC.downloadUrl);
                                }
                                aub();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": retry download:" + this.cBD.cBC.downloadUrl);
                            }
                            this.cBG.mRetryCount++;
                            if (this.cBG.mRetryCount < 3) {
                                try {
                                    if (!this.cBF.get()) {
                                        Thread.sleep(this.cBG.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aud();
                                a(this.cBD.cBB.errorNo, this.cBD.cBC);
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
        if (TextUtils.isEmpty(this.cBD.cBC.filePath)) {
            this.bxt = com.baidu.swan.pms.f.c.cg(this.cBG.K(this.cBE), this.cBD.cBC.md5);
            if (this.bxt == null) {
                this.cBG.a((c<T>) this.cBE, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cBD.cBC.filePath = this.bxt.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bj(long j) {
        boolean z = false;
        String K = this.cBG.K(this.cBE);
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
                    jSONObject.put("appId", eVar.cAZ);
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
        return Objects.hash(this.cBD.cBC);
    }

    public int aue() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cBG.atr()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cBD.cBC.downloadUrl + ",versionName:" + this.cBD.cBC.versionName + ",versionCode:" + this.cBD.cBC.versionCode + "md5:" + this.cBD.cBC.md5 + "bundleId:" + this.cBD.cBC.cAZ;
    }

    public void auf() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": onNotifyPending" + this);
        }
        this.cBH = true;
        fa(true);
    }

    public boolean aug() {
        return this.cBH;
    }

    public void fb(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atp().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cBD.cBC.currentSize = 0L;
        }
        iH(0);
        fa(false);
        this.cBH = false;
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
