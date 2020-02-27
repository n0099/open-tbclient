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
    File bxr;
    e cBB;
    T cBC;
    AtomicBoolean cBD = new AtomicBoolean(false);
    c<T> cBE;
    private boolean cBF;

    public f(e eVar, T t, c<T> cVar) {
        this.cBB = eVar;
        this.cBC = t;
        this.cBE = cVar;
    }

    public void fa(boolean z) {
        if (this.cBD.get() != z) {
            this.cBD.set(z);
        }
    }

    public boolean k(f<T> fVar) {
        return (fVar == null || fVar.cBB == null || fVar.cBB.cBA == null || this.cBB == null || this.cBB.cBA == null || !this.cBB.cBA.equals(fVar.cBB.cBA)) ? false : true;
    }

    public com.baidu.swan.pms.a.c<T> atU() {
        return this.cBE;
    }

    public T atV() {
        return this.cBC;
    }

    public int atW() {
        return this.cBB.cBA.state;
    }

    public void atX() {
        iH(1);
        this.cBE.I(this.cBC);
    }

    public void atY() {
        this.cBE.H(this.cBC);
    }

    public void atZ() {
        iH(2);
        this.cBE.Y(this.cBC);
    }

    public void aua() {
        iH(10);
        this.cBE.G(this.cBC);
    }

    public void aub() {
        iH(3);
        this.cBE.a((c<T>) this.cBC, this.cBB.cBz);
    }

    public boolean iH(int i) {
        if (this.cBB.cBA.state != i) {
            this.cBB.cBA.state = i;
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
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": run:" + this.cBB.cBA.downloadUrl);
        }
        j jVar = new j(this);
        while (true) {
            if (this.cBB.cBz == null || this.cBB.cBz.errorNo != 2200) {
                if (this.cBD.get()) {
                    if (com.baidu.swan.pms.d.DEBUG) {
                        Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": stopped:" + this.cBB.cBA.downloadUrl);
                    }
                    atZ();
                    return;
                }
                jVar.aug();
                if (this.cBB.cBz != null) {
                    switch (this.cBB.cBz.errorNo) {
                        case PushConstants.EXPIRE_NOTIFICATION /* 2200 */:
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": success download:" + this.cBB.cBA.downloadUrl);
                            }
                            aua();
                            return;
                        default:
                            if (this.cBD.get()) {
                                if (com.baidu.swan.pms.d.DEBUG) {
                                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": stopped:" + this.cBB.cBA.downloadUrl);
                                }
                                atZ();
                                return;
                            }
                            if (com.baidu.swan.pms.d.DEBUG) {
                                Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": retry download:" + this.cBB.cBA.downloadUrl);
                            }
                            this.cBE.mRetryCount++;
                            if (this.cBE.mRetryCount < 3) {
                                try {
                                    if (!this.cBD.get()) {
                                        Thread.sleep(this.cBE.mRetryCount * 1000);
                                        break;
                                    } else {
                                        break;
                                    }
                                } catch (InterruptedException e) {
                                    break;
                                }
                            } else {
                                aub();
                                a(this.cBB.cBz.errorNo, this.cBB.cBA);
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
    public boolean atD() {
        if (TextUtils.isEmpty(this.cBB.cBA.filePath)) {
            this.bxr = com.baidu.swan.pms.f.c.cg(this.cBE.K(this.cBC), this.cBB.cBA.md5);
            if (this.bxr == null) {
                this.cBE.a((c<T>) this.cBC, new com.baidu.swan.pms.model.a(2203, "download : path not available"));
                return false;
            }
            this.cBB.cBA.filePath = this.bxr.getAbsolutePath();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bj(long j) {
        boolean z = false;
        String K = this.cBE.K(this.cBC);
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
                    Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": path exception or no space left." + th.toString());
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
                    jSONObject.put("appId", eVar.cAX);
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
        return Objects.hash(this.cBB.cBA);
    }

    public int auc() {
        return new com.baidu.swan.pms.c.a.b.a().u(this.cBE.atp()).intValue();
    }

    public String toString() {
        return "downloadUrl:" + this.cBB.cBA.downloadUrl + ",versionName:" + this.cBB.cBA.versionName + ",versionCode:" + this.cBB.cBA.versionCode + "md5:" + this.cBB.cBA.md5 + "bundleId:" + this.cBB.cBA.cAX;
    }

    public void aud() {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": onNotifyPending" + this);
        }
        this.cBF = true;
        fa(true);
    }

    public boolean aue() {
        return this.cBF;
    }

    public void fb(boolean z) {
        if (com.baidu.swan.pms.d.DEBUG) {
            Log.d("ThunderInfoTask", com.baidu.swan.pms.d.atn().getProcessName() + ": onResetPending" + this);
        }
        if (z) {
            this.cBB.cBA.currentSize = 0L;
        }
        iH(0);
        fa(false);
        this.cBF = false;
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
