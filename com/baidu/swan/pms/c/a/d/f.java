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
    File bxE;
    e cBO;
    T cBP;
    AtomicBoolean cBQ = new AtomicBoolean(false);
    c<T> cBR;
    private boolean cBS;

    public f(e eVar, T t, c<T> cVar) {
        this.cBO = eVar;
        this.cBP = t;
        this.cBR = cVar;
    }

    public void fb(boolean z) {
        if (this.cBQ.get() != z) {
            this.cBQ.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cBO == null || fVar.cBO.cBN == null || this.cBO == null || this.cBO.cBN == null || !this.cBO.cBN.equals(fVar.cBO.cBN)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> atZ() {
        return this.cBR;
    }

    public T aua() {
        return this.cBP;
    }

    public int aub() {
        return this.cBO.cBN.state;
    }

    public void auc() {
        iH(1);
        this.cBR.I(this.cBP);
    }

    public void aud() {
        this.cBR.H(this.cBP);
    }

    public void aue() {
        iH(2);
        this.cBR.Y(this.cBP);
    }

    public void auf() {
        iH(10);
        this.cBR.G(this.cBP);
    }

    public void aug() {
        iH(3);
        this.cBR.a((c<T>) this.cBP, this.cBO.cBM);
    }

    public boolean iH(int i) {
        if (this.cBO.cBN.state != i) {
            this.cBO.cBN.state = i;
            if (i == 2 || i == 3 || i == 10) {
                fb(true);
                return true;
            }
            fb(false);
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": run:" + this.cBO.cBN.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cBO.cBM == null || this.cBO.cBM.errorNo != 2200) {
                if (this.cBQ.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": stopped:" + this.cBO.cBN.downloadUrl);
                    }
                    aue();
                    return;
                }
                jVar.aul();
                if (this.cBO.cBM != null) {
                    switch (this.cBO.cBM.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": success download:" + this.cBO.cBN.downloadUrl);
                            }
                            auf();
                            return;
                        default:
                            if (this.cBQ.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": stopped:" + this.cBO.cBN.downloadUrl);
                                }
                                aue();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": retry download:" + this.cBO.cBN.downloadUrl);
                            }
                            this.cBR.mRetryCount++;
                            if (this.cBR.mRetryCount < 3) {
                                try {
                                    if (!this.cBQ.get()) {
                                        Thread.sleep(this.cBR.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aug();
                                a(this.cBO.cBM.errorNo, this.cBO.cBN);
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
    public boolean atI() {
        if (TextUtils.isEmpty(this.cBO.cBN.filePath)) {
            this.bxE = com.baidu.swan.pms.f.c.cf(this.cBR.K(this.cBP), this.cBO.cBN.md5);
            if (this.bxE == null) {
                this.cBR.a((c<T>) this.cBP, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cBO.cBN.filePath = this.bxE.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bj(long j) {
        boolean z = false;
        String K = this.cBR.K(this.cBP);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.cBk);
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
        return Objects.hash(this.cBO.cBN);
    }

    public int auh() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cBR.atu()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cBO.cBN.downloadUrl + ",versionName:" + this.cBO.cBN.versionName + ",versionCode:" + this.cBO.cBN.versionCode + "md5:" + this.cBO.cBN.md5 + "bundleId:" + this.cBO.cBN.cBk;
    }

    public void aui() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": onNotifyPending" + this);
        }
        this.cBS = true;
        fb(true);
    }

    public boolean auj() {
        return this.cBS;
    }

    public void fc(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.ats().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cBO.cBN.currentSize = 0L;
        }
        iH(0);
        fb(false);
        this.cBS = false;
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
